package com.centit.punish.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerbase.dao.PcfreeumpiredegreeDao;
import com.centit.powerbase.dao.PcfreeumpiretypeDao;
import com.centit.powerbase.po.Pcfreeumpiredegree;
import com.centit.powerbase.po.PcfreeumpiredegreeId;
import com.centit.powerbase.po.Pcfreeumpiretype;
import com.centit.punish.dao.PcdefDao;
import com.centit.punish.dao.PoindagaterepbasicDao;
import com.centit.punish.dao.PopunishbasicDao;
import com.centit.punish.dao.PoradixbasicDao;
import com.centit.punish.dao.PotranslawbasicDao;
import com.centit.punish.po.Pcdef;
import com.centit.punish.po.Poindagaterepbasic;
import com.centit.punish.po.Popunishbasic;
import com.centit.punish.po.Poradixbasic;
import com.centit.punish.po.Potranslawbasic;
import com.centit.punish.po.PotranslawbasicId;
import com.centit.punish.service.PoindagaterepbasicManager;
import com.centit.sys.dao.DataDictionaryDao;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.po.FDatadictionaryId;
import com.centit.sys.service.CodeRepositoryUtil;

public class PoindagaterepbasicManagerImpl extends
        BaseEntityManagerImpl<Poindagaterepbasic> implements
        PoindagaterepbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PoindagaterepbasicManager.class);

    private PoindagaterepbasicDao poindagaterepbasicDao;
    private PcfreeumpiretypeDao pcfreeumpiretypeDao;
    private PopunishbasicDao popunishbasicDao;
    private PoradixbasicDao poradixbasicDao;
    private PotranslawbasicDao potranslawbasicDao;
    private PcfreeumpiredegreeDao pcfreeumpiredegreeDao;
    private DataDictionaryDao datadictionaryDao;
    private Pcfreeumpiredegree pcfreeumpiredegree;
    private PcdefDao pcdefDao;

    public PcdefDao getPcdefDao() {
        return pcdefDao;
    }

    public void setPcdefDao(PcdefDao pcdefDao) {
        this.pcdefDao = pcdefDao;
    }

    public void setPoradixbasicDao(PoradixbasicDao poradixbasicDao) {
        this.poradixbasicDao = poradixbasicDao;
    }

    public void setPotranslawbasicDao(PotranslawbasicDao potranslawbasicDao) {
        this.potranslawbasicDao = potranslawbasicDao;
    }

    public void setPcfreeumpiredegreeDao(
            PcfreeumpiredegreeDao pcfreeumpiredegreeDao) {
        this.pcfreeumpiredegreeDao = pcfreeumpiredegreeDao;
    }

    public void setDatadictionaryDao(DataDictionaryDao datadictionaryDao) {
        this.datadictionaryDao = datadictionaryDao;
    }

    public void setPoindagaterepbasicDao(PoindagaterepbasicDao baseDao) {
        this.poindagaterepbasicDao = baseDao;
        setBaseDao(this.poindagaterepbasicDao);
    }

    public PcfreeumpiretypeDao getPcfreeumpiretypedao() {
        return pcfreeumpiretypeDao;
    }

    public void setPcfreeumpiretypeDao(PcfreeumpiretypeDao baseDao) {
        this.pcfreeumpiretypeDao = baseDao;
        setBaseDao(this.poindagaterepbasicDao);
    }

    public PopunishbasicDao getPopunishbasicDao() {
        return popunishbasicDao;
    }

    public void setPopunishbasicDao(PopunishbasicDao baseDao) {
        this.popunishbasicDao = baseDao;
        setBaseDao(this.poindagaterepbasicDao);
    }

    public List<Pcdef> getPcdefChooseList(String punishobjectid,
            String s_punishclasscode, String s_punishclassname,
            String primaryunit) {
        return this.poindagaterepbasicDao.getPcdefChooseList(punishobjectid,
                s_punishclasscode, s_punishclassname, primaryunit);
    }

    /**
     * 处罚项目时，做出的最终处罚意见
     */
    public String getIndagateRepResult(String punishobjectid, String item_id) {

        String result = "";
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("punishobjectid", punishobjectid);
        filtermap.put("item_id", item_id);
        List<Popunishbasic> pobasiclist = this.popunishbasicDao
                .listObjects(filtermap);
        // String
        // amercedatacode=this.poradixbasicDao.getDataCodeFromFdic("punishType","3");
        for (Popunishbasic o : pobasiclist) {
            String punishtypeid = o.getPunishtypeid();
            String punishvalue = o.getPunishvalue();
            FDatadictionaryId diccid = new FDatadictionaryId("punishType",
                    punishtypeid);
            FDatadictionary dicobj = this.datadictionaryDao
                    .getObjectById(diccid);
            String tmp = dicobj.getDatavalue();
            /**
             * 1 警告 2 通报批评 3 罚款 处罚类别 4 没收违法所得、没收非法财物 5 暂扣或者吊销许可证、暂扣或者吊销执照 6
             * 责令停产停业 7 行政拘留 8 劳动教养 9 法律、行政法规规定的其他行政处罚
             */
            if (!"-".equals(punishvalue) && !"0".equals(punishvalue)) {
                tmp = tmp + ":";
                if ("3".equals(dicobj.getExtracode())
                        || "2".equals(dicobj.getExtracode())) {// 3对应字典项
                    if ("#".equals(punishvalue)) {//
                        tmp = tmp + punishvalue + "&";
                    } else if (this.poradixbasicDao.ifHavePoRadix(
                            punishobjectid, item_id, punishtypeid)) {
                        // Poradixbasic basic
                        // =this.poradixbasicDao.getRadixBasic(punishobjectid,
                        // amercedatacode, punishclassid);
                        Poradixbasic basic = poradixbasicDao.getRadixBasicInfo(
                                punishobjectid, punishtypeid, item_id);

                        if (null != basic.getRadix()) {
                            if (-1 == basic.getRadix()) {
                                tmp = tmp + punishvalue + "元";
                            } else {
                                tmp = tmp + punishvalue + "元#&";
                            }
                        } else {
                            tmp = tmp + punishvalue + "元";
                        }

                    } else {
                        tmp = tmp + punishvalue + "元";
                    }
                } else if ("6".equals(dicobj.getExtracode())
                        || "7".equals(dicobj.getExtracode())) {
                    tmp = tmp + punishvalue + "天";
                }
            }
            if (StringUtils.isBlank(result)) {
                result = tmp;
            } else {
                result = result + "；" + tmp;
            }
        }
        if (result.indexOf("#&") > -1) {
            // Poradixbasic radixBasic
            // =this.poradixbasicDao.getRadixBasic(punishobjectid,
            // amercedatacode, item_id);
            Poradixbasic radixBasic = this.poradixbasicDao
                    .getRadixBasicByPunishobjectid(punishobjectid);
            String radixName = "";// radixBasic.getRadixName();
            String radix = null;
            if (null != radixBasic.getRadix()) {
                radix = radixBasic.getRadix().toString();
            }
            String radixUnit = ""; // radixBasic.getRadixUnit();
            String multiple = null;
            if (null != radixBasic.getMultiple()) {
                multiple = radixBasic.getMultiple().toString();
            }
            if (!StringUtils.isBlank(radix) && !"-1".equals(radix)
                    && !"0".equals(radix)) {
                result = result.replaceAll("#&", "[" + radix + radixUnit + "*"
                        + multiple + "倍]");
            } else {
                result = result.replaceAll("#&", multiple + "倍" + radixName
                        + "(单位:" + radixUnit + ")");
            }
        }
        return result;
    }

    // 获取最终处罚结果
    public String getPunishOpinion(String punishobjectid, String item_id) {
        String retStr = "";
        PotranslawbasicId cid = new PotranslawbasicId(item_id, punishobjectid);
        Potranslawbasic obj = this.potranslawbasicDao.getObjectById(cid);
        String isHavedegree = this.pcfreeumpiredegreeDao
                .getdegreeNoSelByID(item_id) ? "1" : "0";
        if ("1".equals(isHavedegree)) {
            if (this.popunishbasicDao.isHavingPunishBasic(punishobjectid,
                    item_id)) {
                retStr = this.getIndagateRepResult(punishobjectid, item_id);
            } else {
                retStr = "";
            }
        } else {
            if (obj == null) {
                obj = new Potranslawbasic();
            }
            if (null == obj.getDegreeno()) {
                retStr = "";
            } else {
                retStr = this.getIndagateRepResult(punishobjectid, item_id);
            }
        }
        return retStr;
    }

    public List<Pcfreeumpiretype> getFreeUmpireList(String punishobjectid,
            String item_id, Long version, Long degreeno) {
        // String degreeNo=degreeno+"";
        // List<Pcfreeumpiretype> freeUmpireList=this.getFreeUmpireList(item_id,
        // degreeNo);
        /**
         * 这段暂时屏蔽
         */
        /*
         * List<Pcfreeumpiretype>
         * freeUmpireList=pcfreeumpiretypeDao.listFreeumpiretype(degreeno);
         * 
         * if (!StringUtils.isBlank(punishobjectid)&&
         * this.poradixbasicDao.ifHavePoRadix(punishobjectid,item_id, "")) { for
         * (int i = 0; i < freeUmpireList.size(); i++) { Pcfreeumpiretype info =
         * (Pcfreeumpiretype) freeUmpireList.get(i);
         * 
         * if ("1".equals(info.getIsrate())) {/// String limited =
         * info.getPunishcontent(); String
         * dicPunishtypeid=this.poradixbasicDao.getDataCodeFromFdic
         * ("punishType", "amerce");//从字典项中取amerce处罚类型的punishtypeid;
         * Poradixbasic basic
         * =this.poradixbasicDao.getRadixBasic(punishobjectid, dicPunishtypeid,
         * punishclassid); String radix = ""; String radixName =
         * basic.getRadixName(); String radixUnit = basic.getRadixUnit(); if
         * (StringUtils.isBlank(radixName)&& StringUtils.isBlank(radixUnit)) {
         * String tmp =this.poradixbasicDao.getRadixprama(punishclassid,
         * dicPunishtypeid, info.getDegreeno().toString()); radixName =
         * tmp.split(",")[0]; radixUnit = tmp.split(",")[1]; } // if (null ==
         * basic) { // radix = ""; //这里的radix初值为""，不需要单独处理了 // } else if(basic
         * != null){ radix = basic.getRadix().toString(); } if
         * (!StringUtils.isBlank(radix) && !"0".equals(radix) &&
         * !"-1".equals(radix)) { limited = limited.replaceAll("#", radixName +
         * "(" + radix + radixUnit + ")"); } else { limited =
         * limited.replaceAll("#", radixName + "(单位:" + radixUnit + ")"); }
         * //info.setPunishcontent(limited);//////////////////// } } }
         */

        return null;// freeUmpireList;
    }

    /**
     * 准备舍弃的方法
     * 
     * @param item_id
     * @param version
     * @param degreeNo
     * @return
     */
    public List<Pcfreeumpiretype> getFreeUmpireList(String item_id,
            Long version, String degreeNo) {
        String tmp = "";
        // List<Pcfreeumpiretype> FreeUmpireList
        // =this.pcfreeumpiretypeDao.getPCFreeUmpireTypeListByItem_id(item_id);

        List<Pcfreeumpiretype> FreeUmpireList = pcfreeumpiretypeDao
                .listFreeumpiretype(Long.parseLong(degreeNo), "");

        if (FreeUmpireList != null && FreeUmpireList.size() > 0) {
            for (int i = 0; i < FreeUmpireList.size(); i++) {
                Pcfreeumpiretype info = (Pcfreeumpiretype) FreeUmpireList
                        .get(i);
                if (info.getDegreeno().toString().equals(tmp)) {
                    FreeUmpireList.remove(i);
                    i = i - 1;
                    continue;
                } else {
                    tmp = info.getDegreeno().toString();
                }
                if (info.getDegreeno().toString().equals(degreeNo)) {
                    info.setIsinuse(Long.parseLong("1"));
                } else {
                    info.setIsinuse(Long.parseLong("0"));
                }
                /*
                 * if(this.pcfreeumpiretypeDao.ifHavePCFreeUmpireTypeRate("",
                 * info.getDegreeno().toString())) { //
                 * info.setIsrate(Long.parseLong("1"));/////////// }
                 */
                String limite = this.getFreeUmpireInfo(item_id, info
                        .getDegreeno().toString());
                info.setRemark(limite);// ///////

            }
        }
        return FreeUmpireList;
    }

    public String getFreeUmpireInfo(String item_id, String degreeNo) {
        String limited = "";
        // List<Pcfreeumpiretype> typeList =
        // this.pcfreeumpiretypeDao.getPCFreeUmpireTypeListBySqlCon(item_id,
        // degreeNo,"1");
        List<Pcfreeumpiretype> typeList = pcfreeumpiretypeDao
                .listFreeumpiretype(Long.parseLong(degreeNo), "1");

        for (int i = 0; i < typeList.size(); i++) {
            Pcfreeumpiretype pcFreeUmpireType = (Pcfreeumpiretype) typeList
                    .get(i);
            String PunishTypeID = pcFreeUmpireType.getPunishtypeid();
            String PunishMax = pcFreeUmpireType.getToplimit();
            String PunishMin = pcFreeUmpireType.getLowlimit();
            String isRate = null;
            /*
             * if(null!=pcFreeUmpireType.getIsrate()){///////////// isRate
             * =pcFreeUmpireType.getIsrate().toString(); }
             */
            // String tmp
            // =this.poradixbasicDao.getDatavalueFromFdic("punishType",
            // PunishTypeID);
            String tmp = CodeRepositoryUtil
                    .getValue("punishType", PunishTypeID);
            if (null != PunishMax && null != PunishMin
                    && !"-".equals(PunishMax) && !"-".equals(PunishMin)
                    && !"0".equals(PunishMax)) {
                tmp = tmp + ":";
                if (Double.parseDouble(PunishMax) == Double
                        .parseDouble(PunishMin)) {
                    if ("3".equals(PunishTypeID)) {
                        if ("1".equals(isRate)) {
                            tmp = tmp + PunishMin + "倍#";
                        } else {
                            tmp = tmp + PunishMin + "元";
                        }
                    } else if ("6".equals(PunishTypeID)
                            || "7".equals(PunishTypeID)) {
                        tmp = tmp + PunishMin + "天";
                    }
                } else {
                    if ("3".equals(PunishTypeID)) {
                        if ("1".equals(isRate)) {
                            tmp = tmp + PunishMin + "倍-" + PunishMax + "倍#";
                        } else {
                            tmp = tmp + PunishMin + "元-" + PunishMax + "元";
                        }

                    } else if ("6".equals(PunishTypeID)
                            || "7".equals(PunishTypeID)) {
                        tmp = tmp + PunishMin + "天-" + PunishMax + "天";
                    }
                }
            }
            if (!StringUtils.isBlank(limited)) {
                limited = limited + "；" + tmp;
            } else {
                limited = tmp;
            }
        }
        return limited;
    }

    public List<Potranslawbasic> getPunishListByID(String punishobjectid) {
        List<Potranslawbasic> retlist = this.potranslawbasicDao
                .getPotranslawbasicsbyId(punishobjectid);
        for (Potranslawbasic o : retlist) {
            String punishclassid = o.getItem_id();
            String ishavedegree = this.pcfreeumpiredegreeDao
                    .getdegreeNoSelByID(o.getItem_id()) ? "1" : "0";
            o.setIshavedegree(ishavedegree);
            String result = "";
            if ("1".equals(ishavedegree)) {
                if (this.popunishbasicDao.isHavingPunishBasic(punishobjectid,
                        punishclassid)) {
                    result = this.getIndagateRepResult(punishobjectid,
                            punishclassid);
                } else {
                    result = "";
                }
            } else {
                if (null != o.getDegreeno()) {
                    result = "";
                } else {
                    result = this.getIndagateRepResult(punishobjectid,
                            punishclassid);
                }
            }
            o.setResult(result);
        }
        return retlist;
    }

    public String getDisobeyItem(String punishobjectid, String otherdisobeyitem) {
        StringBuffer retStr = new StringBuffer();
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("punishobjectid", punishobjectid);
        List<Potranslawbasic> list = this.potranslawbasicDao
                .listObjects(filtermap);
        if (list.size() != 0) {
            for (Potranslawbasic o : list) {
                String punishclassid = o.getItem_id();
                Pcdef o2 = this.pcdefDao.getObjectById(punishclassid);

                String punishbasis = o2.getPunishbasis();
                retStr.append(punishbasis);
                retStr.append(";");
            }
        }
        retStr.append(otherdisobeyitem);
        return retStr.toString();
    }

    /**
     * 获取自由裁量参考标准
     * 
     * @param item_id
     * @param version
     * @param degreeno
     * @return
     */
    @Override
    public List<Pcfreeumpiretype> getFreeUmpireBZList(String item_id,
            Long version, String degreeno) {
        String tmp = "";
        List<Pcfreeumpiretype> FreeUmpireList = pcfreeumpiretypeDao
                .getPcfreeumpiretypeByItemIdandversion(item_id, version, "");

        if (FreeUmpireList != null && FreeUmpireList.size() > 0) {
            for (int i = 0; i < FreeUmpireList.size(); i++) {
                Pcfreeumpiretype info = (Pcfreeumpiretype) FreeUmpireList
                        .get(i);
                if (info.getDegreeno().toString().equals(tmp)) {
                    FreeUmpireList.remove(i);
                    i = i - 1;
                    continue;
                } else {
                    tmp = info.getDegreeno().toString();
                }
                if (info.getDegreeno().toString().equals(degreeno)) {
                    info.setIsinuse(Long.parseLong("1"));
                } else {
                    info.setIsinuse(Long.parseLong("0"));
                }

                String limite = this.getFreeUmpireInfo(item_id, info
                        .getDegreeno().toString());
                info.setRemark(limite);// ///////
                // 违法事实程度描述
                PcfreeumpiredegreeId pcfreeumpiredegreeId = new PcfreeumpiredegreeId();
                pcfreeumpiredegreeId.setDegreeno(info.getDegreeno());
                pcfreeumpiredegree = pcfreeumpiredegreeDao.getDgreeNo(
                        info.getDegreeno(), item_id, version);
                String punishfactgrade = pcfreeumpiredegree
                        .getPunishfactgrade();
                info.setPunishfactgrade(punishfactgrade);
            }
        }
        return FreeUmpireList;
    }

    public Pcfreeumpiredegree getPcfreeumpiredegree() {
        return pcfreeumpiredegree;
    }

    public void setPcfreeumpiredegree(Pcfreeumpiredegree pcfreeumpiredegree) {
        this.pcfreeumpiredegree = pcfreeumpiredegree;
    }
}
