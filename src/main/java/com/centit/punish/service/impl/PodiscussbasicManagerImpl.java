package com.centit.punish.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PodiscussbasicDao;
import com.centit.punish.dao.PopunishbasicDao;
import com.centit.punish.dao.PoradixbasicDao;
import com.centit.punish.dao.PotranslawbasicDao;
import com.centit.punish.dao.PunishobjectbasicDao;
import com.centit.punish.dao.VPODiscussDao;
import com.centit.punish.po.Podiscussbasic;
import com.centit.punish.po.Popunishbasic;
import com.centit.punish.po.PopunishbasicId;
import com.centit.punish.po.Poradixbasic;
import com.centit.punish.po.Potranslawbasic;
import com.centit.punish.po.PotranslawbasicId;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.po.VPODiscuss;
import com.centit.punish.service.PodiscussbasicManager;
import com.centit.support.utils.StringRegularOpt;

public class PodiscussbasicManagerImpl extends
        BaseEntityManagerImpl<Podiscussbasic> implements PodiscussbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PodiscussbasicManager.class);

    private PodiscussbasicDao podiscussbasicDao;
    private VPODiscussDao vPODiscussDao;
    private PopunishbasicDao popunishbasicDao;
    private PoradixbasicDao poradixbasicDao;
    private PunishobjectbasicDao punishobjectbasicDao;
    private PotranslawbasicDao potranslawbasicDao;

    public void setPodiscussbasicDao(PodiscussbasicDao baseDao) {
        this.podiscussbasicDao = baseDao;
        setBaseDao(this.podiscussbasicDao);
    }

    public void setvPODiscussDao(VPODiscussDao vPODiscussDao) {
        this.vPODiscussDao = vPODiscussDao;
    }

    public void setPopunishbasicDao(PopunishbasicDao popunishbasicDao) {
        this.popunishbasicDao = popunishbasicDao;
    }

    public void setPoradixbasicDao(PoradixbasicDao poradixbasicDao) {
        this.poradixbasicDao = poradixbasicDao;
    }

    public void setPunishobjectbasicDao(
            PunishobjectbasicDao punishobjectbasicDao) {
        this.punishobjectbasicDao = punishobjectbasicDao;
    }

    public void setPotranslawbasicDao(PotranslawbasicDao potranslawbasicDao) {
        this.potranslawbasicDao = potranslawbasicDao;
    }

    @Override
    public VPODiscuss getVPODiscussByCid(String punishobjectid,
            Long podiscusstype) {
        VPODiscuss vpod = new VPODiscuss();
        vpod.setPunishobjectid(punishobjectid);
        vpod.setPodiscusstype(podiscusstype);
        return vPODiscussDao.getObject(vpod);
    }

    public String getPunishClassID(String punishobjectid) {
        return this.podiscussbasicDao.getPunishClassID(punishobjectid);
    }

    public String getDegreeNoByCon(String punishObjectID, String item_id) {
        return this.podiscussbasicDao.getDegreeNoByCon(punishObjectID, item_id);
    }

    public void savepunishBasicInfo(String punishobjectid,
            String podiscusstype, String item_id, String[] freeumpire,
            String issurpass, String punisnclassnum, String degreeno,
            Podiscussbasic discuss) {
        if (StringUtils.isBlank(degreeno)) {
            degreeno = "0";
        }
        String decision = "";
        if (this.popunishbasicDao.isHavingPunishBasic(punishobjectid, item_id)) {
            if ("1".equals(punisnclassnum)) {
                this.popunishbasicDao.deleteAllPunishBasic(punishobjectid, "");
            } else {
                this.popunishbasicDao.deleteAllPunishBasic(punishobjectid,
                        item_id);
            }
        }
        for (int i = 0; i < freeumpire.length; i++) {
            String tmp = "";
            String RadixTmp = "";
            String punishtypeid = freeumpire[i].split("&")[0];
            String punishValue = freeumpire[i].split("&")[1];
            if (punishValue.indexOf("*") > -1 && "1".equals(punisnclassnum)
                    && punisnclassnum != null) {
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
                Double radix = Double.parseDouble(punishValue
                        .substring(punishValue.indexOf("*") + 1));
                Double multiple = Double.parseDouble(punishValue.substring(0,
                        punishValue.indexOf("*")));
                Poradixbasic poRadix = new Poradixbasic();
                poRadix.setMultiple(multiple);
                poRadix.setRadix(radix.longValue());
                poRadix.setItem_id(item_id);
                poRadix.setPunishobjectid(punishobjectid);
                poRadix.setPunishtypeid(punishtypeid);
                poRadix.setDegreeno(Long.parseLong(degreeno));
                this.poradixbasicDao.updateRadixBasic(poRadix);
                punishValue = df.format(multiple * radix);
                /*
                 * String tableName = ""; String sqlCondition = " and item_id='"
                 * + item_id + "' and punishTypeID='" + punishtypeid + "'"; if
                 * (!"0".equals(degreeno)) { sqlCondition = sqlCondition +
                 * " and degreeNo=" + degreeno; tableName = "PCFreeUmpireType";
                 * } else { tableName = "PCTYPE"; }
                 */
                // String RadixParam
                // =this.poradixbasicDao.getRadixprama(sqlCondition, tableName);
                RadixTmp = "["
                        + // RadixParam.split(",")[0] + ":"+
                        String.valueOf(radix) + "*" + String.valueOf(multiple)
                        + "倍]";
            }
            Popunishbasic basic = new Popunishbasic();
            basic.setCid(new PopunishbasicId(punishobjectid, punishtypeid,
                    item_id));
            basic.setPunishvalue(punishValue);

            tmp = this.poradixbasicDao.getDatavalueFromFdic("punishType",
                    punishtypeid);
            String unit = "";
            if (this.poradixbasicDao.getDataCodeFromFdic("punishType", "3")
                    .equals(punishtypeid)) {
                unit = "元";
            } else if (this.poradixbasicDao.getDataCodeFromFdic("punishType",
                    "6").equals(punishtypeid)
                    || this.poradixbasicDao.getDataCodeFromFdic("punishType",
                            "7").equals(punishtypeid)) {
                unit = "天";
            }
            if (!"-".equals(punishValue)) {
                tmp = tmp + ":";
                if (!StringUtils.isBlank(RadixTmp)) {
                    tmp = tmp + punishValue + unit + RadixTmp;
                } else {
                    tmp = tmp + punishValue + unit;
                }
            }
            this.popunishbasicDao.saveObject(basic);

            if ("1".equals(punisnclassnum) && punisnclassnum != null) {
                Popunishbasic basic2 = new Popunishbasic();
                basic2.setItem_id("00000000");
                basic2.setPunishobjectid(punishobjectid);
                basic2.setPunishtypeid(punishtypeid);
                basic2.setPunishvalue(punishValue);
                this.popunishbasicDao.save(basic2);
            }
            if (StringUtils.isBlank(decision)) {
                decision = tmp;
            } else {
                decision = decision + "；" + tmp;
            }
        }
        if ("1".equals(punisnclassnum) && punisnclassnum != null) {
            // this.punishobjectbasicDao.updateIsisSurpass(punishobjectid,
            // issurpass);
            Punishobjectbasic saveobject = punishobjectbasicDao
                    .getObjectById(punishobjectid);
            if (saveobject != null) {
                if (StringRegularOpt.isNumber(issurpass)) {
                    saveobject.setIssurpass(Long.valueOf(issurpass));
                }
                punishobjectbasicDao.saveObject(saveobject);
            }
            Potranslawbasic o = this.potranslawbasicDao
                    .getObjectById(new PotranslawbasicId(item_id,
                            punishobjectid));
            if (StringRegularOpt.isNumber(issurpass)) {
                o.setIssurpass(Long.parseLong(issurpass));
            }
            this.potranslawbasicDao.saveObject(o);
        }
        if (!StringUtils.isBlank(decision)) {
            discuss.setPodiscussresult(decision);
            Podiscussbasic o = new Podiscussbasic();
            o.copy(discuss);
            this.saveObject(o);
        }

    }

    @Override
    public void saveDiscussbase(Podiscussbasic podiscussbasic) {
        
        this.podiscussbasicDao.saveObject(podiscussbasic);
    }

}
