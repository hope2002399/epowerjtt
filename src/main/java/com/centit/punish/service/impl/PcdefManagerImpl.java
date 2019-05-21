package com.centit.punish.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.punish.dao.PcdefDao;
import com.centit.punish.dao.PctypeDao;
import com.centit.punish.dao.PoradixbasicDao;
import com.centit.punish.po.Pcdef;
import com.centit.punish.po.Pctype;
import com.centit.punish.po.Poradixbasic;
import com.centit.punish.service.PcdefManager;

public class PcdefManagerImpl extends BaseEntityManagerImpl<Pcdef> implements
        PcdefManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PcdefManager.class);

    private PcdefDao pcdefDao;
    private PctypeDao pctypeDao;
    private PoradixbasicDao poradixbasicDao;

    public void setPoradixbasicDao(PoradixbasicDao poradixbasicDao) {
        this.poradixbasicDao = poradixbasicDao;
    }

    public void setPctypeDao(PctypeDao pctypeDao) {
        this.pctypeDao = pctypeDao;
    }

    public void setPcdefDao(PcdefDao baseDao) {
        this.pcdefDao = baseDao;
        setBaseDao(this.pcdefDao);
    }

    public String generateNextPunishClassID() {
        return pcdefDao.genNextPunishClassID();
    }

    @Override
    public Pcdef getObjectByItemId(String punishclasscode) {
        return pcdefDao.getObjectByItemId(punishclasscode);
    }

    @Override
    public List<Pcdef> listPcdef(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return pcdefDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public String getPunishclassname(String punishClassIDs) {
        String punishclassname = "";
        if (StringUtils.isBlank(punishClassIDs)) {
            return "";
        }
        if (punishClassIDs.indexOf(",") > -1) {
            String[] punishClassID = punishClassIDs.split(",");
            for (String punishClassid : punishClassID) {
                Pcdef pcdef = pcdefDao.getObjectById(punishClassid);
                if (StringUtils.isBlank(punishclassname)) {
                    punishclassname = pcdef.getPunishclassname();
                } else {
                    punishclassname = punishclassname + "；"
                            + pcdef.getPunishclassname();
                }
            }
        } else {
            Pcdef pcdef = pcdefDao.getObjectById(punishClassIDs);
            punishclassname = pcdef.getPunishclassname();
        }

        return punishclassname;
    }

    public String getpunishItemType(String punishObjectID, String item_id,
            Long version) {// 对于某个处罚方式的综合显示.
        String punlishType = "";
        List<Pctype> typeList = this.pctypeDao.listPcTypeInUse(item_id);

        for (int i = 0; i < typeList.size(); i++) {
            Pctype pcType = (Pctype) typeList.get(i);
            String PunishTypeID = pcType.getPunishtypeid();
            String PunishMax = pcType.getPunishmax();
            String PunishMin = pcType.getPunishmin();
            // String PunishContent = pcType.getPunishContent();
            String PunishContent = pcType.getPunishcontent();
            String isRate = pcType.getIsrate().toString();
            String Limited = pcType.getChargemax();
            String radixName = pcType.getRadixname();
            String radixUnit = pcType.getRadixunit();
            String tmp = this.poradixbasicDao.getDatavalueFromFdic(
                    "punishType", PunishTypeID);
            String dicPunishtypeid1 = this.poradixbasicDao.getDataCodeFromFdic(
                    "punishType", "amerce");// 从字典项中取amerce处罚类型的punishtypeid;
            String dicPunishtypeid2 = this.poradixbasicDao.getDataCodeFromFdic(
                    "punishType", "detention");// 从字典项中取amerce处罚类型的punishtypeid;
            if (!"-".equals(PunishMax) && !"-".equals(PunishMin)
                    && !"0".equals(PunishMax)) {
                tmp = tmp + ":";
                if ("∞".equals(PunishMax)) {

                    if (dicPunishtypeid1.equals(PunishTypeID)) {
                        tmp = tmp + PunishMin + "元以上";
                    } else if (dicPunishtypeid2.equals(PunishTypeID)) {
                        tmp = tmp + PunishMin + "天以上";
                    }
                } else {
                    if (null != PunishMax
                            && null != PunishMin
                            && Double.parseDouble(PunishMax) == Double
                                    .parseDouble(PunishMin)) {
                        if (dicPunishtypeid1.equals(PunishTypeID)) {
                            if ("1".equals(isRate)) {
                                tmp = tmp + PunishMin + "倍";
                                Poradixbasic radix = this.poradixbasicDao
                                        .getRadixBasic(punishObjectID,
                                                PunishTypeID, item_id);
                                String value = null;
                                if (null != radix.getRadix()) {
                                    value = radix.getRadix().toString();
                                }
                                tmp = tmp + radixName;
                                String show = "";
                                if (!StringUtils.isBlank(value)
                                        || !StringUtils.isBlank(Limited)) {
                                    show = "(";
                                    if (!StringUtils.isBlank(value)) {
                                        show = show + value + radixUnit;
                                    }
                                    if (!"(".equals(show)
                                            && !StringUtils.isBlank(Limited)) {
                                        show = show + ",";
                                    }
                                    if (!StringUtils.isBlank(Limited)) {
                                        show = show + "最大不超过" + Limited + "元";
                                    }
                                    show = show + ")";
                                }
                                if (!StringUtils.isBlank(show)) {
                                    tmp = tmp + show;
                                }
                            } else {
                                tmp = tmp + PunishMin + "元";
                            }
                        } else if (dicPunishtypeid2.equals(PunishTypeID)) {
                            tmp = tmp + PunishMax + "天";
                        }
                    } else {
                        if (dicPunishtypeid1.equals(PunishTypeID)) {
                            if ("1".equals(isRate)) {
                                tmp = tmp + PunishMin + "倍-" + PunishMax + "倍";
                                Poradixbasic radix = this.poradixbasicDao
                                        .getRadixBasic(punishObjectID,
                                                PunishTypeID, item_id);
                                String value = null;
                                if (null != radix.getRadix()) {
                                    value = radix.getRadix().toString();
                                }
                                tmp = tmp + radixName;
                                String show = "";
                                if (!StringUtils.isBlank(value)
                                        || !StringUtils.isBlank(Limited)) {
                                    show = "(";
                                    if (!StringUtils.isBlank(value)) {
                                        show = show + value + radixUnit;
                                    }
                                    if (!"(".equals(show)
                                            && !StringUtils.isBlank(Limited)) {
                                        show = show + ",";
                                    }
                                    if (!StringUtils.isBlank(Limited)) {
                                        show = show + "最大不超过" + Limited + "元";
                                    }
                                    show = show + ")";
                                }
                                if (!StringUtils.isBlank(show)) {
                                    tmp = tmp + show;
                                }
                            } else {
                                tmp = tmp + PunishMin + "元-" + PunishMax + "元";
                            }
                        } else if (dicPunishtypeid2.equals(PunishTypeID)) {
                            tmp = tmp + PunishMin + "天-" + PunishMax + "天";
                        }
                    }
                }
            } else if (!StringUtils.isBlank(PunishContent)) {
                tmp = tmp + PunishContent;
            }
            if (StringUtils.isBlank(punlishType)) {
                punlishType = tmp;
            } else {
                punlishType = punlishType + "；" + tmp;
            }
        }
        return punlishType;
    }

    public List<Pcdef> listPcdefUsingOrg(String unitcode, String anyou) {
        return this.pcdefDao.listPcdefUsingOrg(unitcode, anyou);
    }

    @Override
    public String getpunishItemType(String punishObjectID, String punishClassID) {
        
        return null;
    }

}
