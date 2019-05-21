package com.centit.punish.service.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerbase.dao.PcfreeumpiredegreeDao;
import com.centit.powerbase.dao.PcfreeumpiretypeDao;
import com.centit.powerbase.dao.PcpunishStandardDao;
import com.centit.powerbase.po.Pcfreeumpiredegree;
import com.centit.powerbase.po.Pcfreeumpiretype;
import com.centit.powerbase.po.PcpunishStandard;
import com.centit.punish.dao.PodiscussbasicDao;
import com.centit.punish.dao.PopunishbasicDao;
import com.centit.punish.dao.PoradixbasicDao;
import com.centit.punish.dao.PotranslawbasicDao;
import com.centit.punish.dao.PunishobjectbasicDao;
import com.centit.punish.dao.VPotranslawbasicDao;
import com.centit.punish.po.Podiscussbasic;
import com.centit.punish.po.Popunishbasic;
import com.centit.punish.po.PopunishbasicId;
import com.centit.punish.po.Poradixbasic;
import com.centit.punish.po.Potranslawbasic;
import com.centit.punish.po.PotranslawbasicId;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PotranslawbasicManager;

public class PotranslawbasicManagerImpl extends
        BaseEntityManagerImpl<Potranslawbasic> implements
        PotranslawbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PotranslawbasicManager.class);

    private PotranslawbasicDao potranslawbasicDao;
    private VPotranslawbasicDao vPotranslawbasicDao;
    private PunishobjectbasicDao punishobjectbasicDao;
    private PopunishbasicDao popunishbasicDao;
    private PcfreeumpiretypeDao pcfreeumpiretypeDao;
    private PoradixbasicDao poradixbasicDao;
    private PcfreeumpiredegreeDao pcfreeumpiredegreeDao;
    private PcpunishStandardDao pcpunishStandardDao;
    private PodiscussbasicDao podiscussbasicDao;
    private Pcfreeumpiretype pcfreeumpiretype;
    private Podiscussbasic podiscussbase;

    @Override
    public String getAllpunishClassID(String punishobjectid) {
        return vPotranslawbasicDao.getAllpunishClassID(punishobjectid);
    }

    public void updatePunishObjectIsSurpass(String punishObjectID) {
        String isSurpass = potranslawbasicDao
                .factPunishisSurpass(punishObjectID);
        Punishobjectbasic saveobject = punishobjectbasicDao
                .getObjectById(punishObjectID);
        saveobject.setIssurpass(Long.parseLong(isSurpass));
        punishobjectbasicDao.saveObject(saveobject);
        // punishobjectbasicDao.updateIsisSurpass(punishObjectID, isSurpass);
    }

    public void updatePOTransLawBasic(String punishObjectID, String item_id,
            String degreeNo) {
        // 第一步:判断是否已经设置了处罚
        if (popunishbasicDao.isHavingPunishBasic(punishObjectID, item_id)) {
            // 设置了的话，删除所有
            popunishbasicDao.deleteAllPunishBasic(punishObjectID, item_id);
        }
        // 第二步：更新案件违法事实信息
        potranslawbasicDao.updatePOTransLawBasic(punishObjectID, item_id,
                degreeNo);
        // 第三步：设置处罚
        Map<String, Object> filtermap = new HashMap<String, Object>();
        // filtermap.put("item_id", item_id);
        filtermap.put("degreeno", degreeNo);
        List<Pcfreeumpiretype> typeList = this.pcfreeumpiretypeDao
                .listObjects(filtermap);
        if (typeList != null && typeList.size() > 0) {
            for (int i = 0; i < typeList.size(); i++) {
                Pcfreeumpiretype pcFreeUmpireType = (Pcfreeumpiretype) typeList
                        .get(i);
                String punishValue = "";
                String PunishTypeID = pcFreeUmpireType.getCid()
                        .getPunishtypeid();
                String Toplimit = pcFreeUmpireType.getToplimit();
                String Lowlimit = pcFreeUmpireType.getLowlimit();
                if (null == Toplimit) {
                    Toplimit = "-";
                }
                if (null == Lowlimit) {
                    Lowlimit = "-";
                }
                String freeUmpireIsRate = "";
                // 判断所在的自由裁量是否是按比例计算

                /**
                 * 以下是对数据的处理，当有数据的时候，根据情况取值，没有值的时候，用“－”代替；注意有小数的情况
                 */
                Long punishtype = pcFreeUmpireType.getPunishtype();
                if (null != punishtype) {
                    if (1 == punishtype) {// 上下限
                        if (!"-".equals(Toplimit) && !"-".equals(Lowlimit)) {
                            if ("∞".equals(Toplimit) || "0".equals(Toplimit)) {
                                punishValue = Lowlimit;
                            } else {
                                if (Lowlimit.indexOf(".") > -1
                                        || Toplimit.indexOf(".") > -1) {
                                    DecimalFormat df = new DecimalFormat("#.00");
                                    double min = Double.parseDouble(Lowlimit);
                                    double max = Double.parseDouble(Toplimit);
                                    punishValue = df.format((min + max) / 2);
                                } else {
                                    int max = Integer.parseInt(Toplimit);
                                    int min = Integer.parseInt(Lowlimit);
                                    punishValue = String
                                            .valueOf((max + min + 1) / 2);
                                }
                            }
                        } else {
                            punishValue = "-";
                        }
                    } else {// 基数

                        if ("1".equals(freeUmpireIsRate)) {
                            Poradixbasic saveobj = poradixbasicDao
                                    .getRadixBasicInfo(punishObjectID,
                                            PunishTypeID, item_id);
                            if (saveobj == null) {
                                saveobj = new Poradixbasic();
                                String radixid = poradixbasicDao
                                        .generateNextPoRadixId();
                                saveobj.setRadixid(Long.parseLong(radixid));
                                saveobj.setPunishobjectid(punishObjectID);
                                saveobj.setItem_id(item_id);
                                saveobj.setPunishtypeid(PunishTypeID);
                            }

                            saveobj.setMultiple(Double.parseDouble(punishValue));
                            saveobj.setDegreeno(Long.parseLong(degreeNo));
                            saveobj.setRadix(Long.parseLong("0"));
                            poradixbasicDao.saveObject(saveobj);
                            punishValue = "#";
                        }
                        /*
                         * else if (!"1".equals(freeUmpireIsRate)) { if
                         * (poradixbasicDao.ifHavePoRadix(punishObjectID,
                         * item_id, PunishTypeID)) { Poradixbasic saveobj = new
                         * Poradixbasic(); String radixid =
                         * poradixbasicDao.generateNextPoRadixId();
                         * saveobj.setRadixid(Long.parseLong(radixid));
                         * saveobj.setPunishobjectid(punishObjectID);
                         * saveobj.setItem_id(item_id);
                         * saveobj.setPunishtypeid(PunishTypeID);
                         * saveobj.setMultiple(Double.parseDouble("0"));
                         * saveobj.setDegreeno(Long.parseLong("0"));
                         * saveobj.setRadix(Long.parseLong("-1"));
                         * poradixbasicDao.save(saveobj); } }
                         */
                    }
                }
                // 保存处罚
                Popunishbasic basic = new Popunishbasic();
                basic.setItem_id(item_id);
                basic.setPunishobjectid(punishObjectID);
                basic.setPunishtypeid(PunishTypeID);
                basic.setPunishvalue(punishValue);
                popunishbasicDao.saveObject(basic);
            }
        }
    }

    public String isSurpassFreeUmpire(String item_id, Long version,
            String degreeNo, String[] freeUmpire) {
        String isSurpass = "";
        boolean flag = false;
        /*
         * List<Pcfreeumpiretype> standardlist = this.pcfreeumpiretypeDao
         * .getPCFreeUmpireTypeListBySqlCon(item_id, degreeNo, "1");
         */
        List<Pcfreeumpiretype> standardlist = pcfreeumpiretypeDao
                .getPcfreeumpiretypeByItemIdandversion(item_id, version,
                        degreeNo);

        if (standardlist.size() != freeUmpire.length) {
            flag = true;
        } else {
            for (String o : freeUmpire) {
                String type = "";
                String value = "";
                if (o.contains("@")) {
                    type = o.split("@")[0];
                    value = o.split("@")[1];
                }
                if (o.contains("&")) {
                    type = o.split("&")[0];
                    value = o.split("&")[1];
                }
                if (value.indexOf("*") > -1) {
                    java.text.DecimalFormat df = new java.text.DecimalFormat(
                            "#.00");
                    value = df.format(Double.parseDouble(value.substring(0,
                            value.indexOf("*"))));
                }
                if (this.inThisStandard(type, value, standardlist)) {
                    flag = false;
                } else {
                    flag = true;
                    break;
                }
            }
        }

        if (!flag) {
            isSurpass = "0";
        } else {
            isSurpass = "1";
        }
        return isSurpass;
    }

    public boolean inThisStandard(String type, String value,
            List<Pcfreeumpiretype> standardList) {
        boolean flag = false;
        for (Pcfreeumpiretype bean : standardList) {
            if (!type.equals(bean.getPunishtypeid())) {// 处罚项目类型不相同
                flag = false;
            } else {// 处罚项目类型相同
                // 1、上下限
                if (1 == bean.getPunishtype()) {
                    if (!"-".equals(bean.getToplimit())
                            && !"-".equals(bean.getLowlimit())
                            && !"-".equals(value)
                            && !"0".equals(bean.getToplimit())) {// 有数值的情况
                        if (value.indexOf(".") > -1) {
                            double values = Double.parseDouble(value);
                            double min = Double.parseDouble(bean.getLowlimit());
                            if ("∞".equals(bean.getToplimit())) {
                                if (values < min) {
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            } else {
                                double max = Double.parseDouble(bean
                                        .getToplimit());
                                if (values < min || max < values) {
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            }
                        } else {
                            int min = Integer.parseInt(bean.getLowlimit());
                            int values = Integer.parseInt(value);
                            if ("∞".equals(bean.getToplimit())) {
                                if (values < min) {
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            } else {
                                int max = Integer.parseInt(bean.getToplimit());
                                if (values < min || max < values) {
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            }
                        }
                    } else {
                        flag = true;
                    }
                    break;

                } else {// 基数情况
                        // 页面已做判断，所以这边肯定没有超出
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void insertpunishBasicInfo(String punishobjectid, String item_id,
            String[] freeUmpire, String degreeno, String issurpass,
            String disobeyitem, String stepworkid, String podiscusstype) {
        if (!(!StringUtils.isBlank(degreeno) && !"-2".equals(degreeno))) {
            degreeno = "0";
        }
        if (this.popunishbasicDao.isHavingPunishBasic(punishobjectid, item_id)) {
            this.popunishbasicDao.deleteAllPunishBasic(punishobjectid, item_id);
        }
        for (String o : freeUmpire) {
            String punishtypeid = "";
            String punishvalue = "";
            if (o.contains("@")) {
                punishtypeid = o.split("@")[0];
                punishvalue = o.split("@")[1];
            } else if (o.contains("&")) {
                punishtypeid = o.split("&")[0];
                punishvalue = o.split("&")[1];
            } else {
                punishtypeid = o.trim();
                punishvalue = "";
            }
            if (punishvalue.indexOf("*") > -1) {
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
                Double radix = Double.parseDouble(punishvalue
                        .substring(punishvalue.indexOf("*") + 1));
                Double multiple = Double.parseDouble(punishvalue.substring(0,
                        punishvalue.indexOf("*")));
                Poradixbasic poRadix = new Poradixbasic();
                poRadix.setMultiple(multiple);
                poRadix.setRadix(radix.longValue());
                poRadix.setItem_id(item_id);
                poRadix.setPunishobjectid(punishobjectid);
                poRadix.setPunishtypeid(punishtypeid);
                poRadix.setDegreeno(Long.parseLong(degreeno));
                this.poradixbasicDao.updateRadixBasic(poRadix);
                punishvalue = df.format(multiple * radix);
            }
            Popunishbasic saveobj = new Popunishbasic();
            saveobj.setCid(new PopunishbasicId(punishobjectid, punishtypeid,
                    item_id));
            saveobj.setPunishvalue(punishvalue);
            this.popunishbasicDao.save(saveobj);

        }
        if (!"00000000".equals(item_id)) {
            Potranslawbasic updateobj = this.potranslawbasicDao
                    .getObjectById(new PotranslawbasicId(item_id,
                            punishobjectid));
            updateobj.setIssurpass(Long.parseLong(issurpass));
            this.potranslawbasicDao.save(updateobj);
        }
    }

    // 删除punishclass的步骤
    public void deletePunishClass(String punishobjectid, String item_id) {
        // 第一步:删除popunishbasic
        if (this.popunishbasicDao.isHavingPunishBasic(punishobjectid, item_id)) {
            this.popunishbasicDao.deleteAllPunishBasic(punishobjectid, item_id);
        }
        // 第二步:删除POTRANSLAWBASIC
        Potranslawbasic deleteobject = new Potranslawbasic();
        PotranslawbasicId cid = new PotranslawbasicId();
        cid.setPunishobjectid(punishobjectid);
        cid.setItem_id(item_id);
        deleteobject.setCid(cid);
        this.deleteObjectById(cid);
        // 第三步:删除PORADIXBASIC
        if (this.poradixbasicDao.ifHavePoRadix(punishobjectid, item_id, "")) {
            this.poradixbasicDao.delRadixBasic(punishobjectid, item_id, "");
        }

    }

    // 现场处罚 初始化
    public void initPunishInfo(String punishObjectID, String item_id) {
        Potranslawbasic saveobject = new Potranslawbasic();
        saveobject.setPunishobjectid(punishObjectID);
        saveobject.setItem_id(item_id);
        this.potranslawbasicDao.saveObject(saveobject);
        this.initRadioBasic(punishObjectID, item_id);
    }

    /**
     * @param punishObjectID
     * @param item_id
     */
    private void initRadioBasic(String punishObjectID, String item_id) {
        
        // 检索自由裁量标准－违法事实程度表中是否存在记录，存在则获取对应的degreeNo
        List<Pcfreeumpiredegree> pcfreeumpiredegreeList = pcfreeumpiredegreeDao
                .getObjectByItemsIdAndMaxVesion(item_id);

        if (pcfreeumpiredegreeList != null && pcfreeumpiredegreeList.size() > 0) {
            Pcfreeumpiredegree pcfreeumpiredegree = pcfreeumpiredegreeList
                    .get(0);

            List<Pcfreeumpiretype> pcfreeumpiretypes = pcfreeumpiretypeDao
                    .listFreeumpiretype(pcfreeumpiredegree.getDegreeno(), "1");

            for (Pcfreeumpiretype pcd : pcfreeumpiretypes) {
                Poradixbasic poradixbasic = new Poradixbasic();
                poradixbasic.setRadixid(poradixbasicDao
                        .getNextLongSequence("S_RADIXID"));
                poradixbasic.setPunishobjectid(punishObjectID);
                poradixbasic.setItem_id(item_id);
                poradixbasic.setPunishtypeid(pcd.getPunishtypeid());
                poradixbasic.setDegreeno(pcd.getDegreeno());
                poradixbasicDao.save(poradixbasic);
            }

        } else {// 如果不存在，则从裁量标准中获取
            List<PcpunishStandard> PcpunishStandardList = pcpunishStandardDao
                    .listPcpunishStandardByItemIdAndMaxVesion(item_id);
            if (PcpunishStandardList != null && PcpunishStandardList.size() > 0) {
                for (PcpunishStandard pcd : PcpunishStandardList) {
                    Poradixbasic poradixbasic = new Poradixbasic();
                    poradixbasic.setRadixid(poradixbasicDao
                            .getNextLongSequence("S_RADIXID"));
                    poradixbasic.setPunishobjectid(punishObjectID);
                    poradixbasic.setItem_id(item_id);
                    poradixbasic.setPunishtypeid(pcd.getPunishtypeid());
                    poradixbasic.setDegreeno((long) 0);
                    poradixbasicDao.save(poradixbasic);
                }

            }

        }
    }

    // 现场处罚计算处罚金额
    public String getPunishAmout(String punishobjectid, String item_id) {
        String limited = "0";
        PopunishbasicId cid = new PopunishbasicId();
        cid.setPunishobjectid(punishobjectid);
        cid.setItem_id(item_id);
        String amercecode = this.poradixbasicDao.getDataCodeFromFdic(
                "punishType", "amerce");
        cid.setPunishtypeid(amercecode);
        // Popunishbasic basic = this.popunishbasicDao.getObjectById(cid);
        Popunishbasic basic = this.popunishbasicDao.getPunishBasic(
                punishobjectid, item_id);
        if (null != basic) {
            if ("-".equals(basic.getPunishvalue())) {
                basic.setPunishvalue("");
            }
            String punishvalue = basic.getPunishvalue();
            if ("#".equals(punishvalue)) {
                Poradixbasic radixBasic = this.poradixbasicDao.getRadixBasic(
                        punishobjectid, amercecode, item_id);
                String radixName = radixBasic.getRadixName();
                String radixUnit = radixBasic.getRadixUnit();
                String multiple = String.valueOf(radixBasic.getMultiple());
                limited = punishvalue.replaceAll("#", multiple + "倍"
                        + radixName + "(单位:" + radixUnit + ")");
            } else {
                limited = punishvalue;
            }
        }
        return limited;
    }

    public String getOtherPunish(String punishobjectid, String punishclassid) {
        String limited = "";
        String amercecode = this.poradixbasicDao.getDataCodeFromFdic(
                "punishType", "amerce");
        List<Popunishbasic> list = this.popunishbasicDao.getPopunishbasicList(
                punishobjectid, punishclassid);
        for (int i = 0; i < list.size(); i++) {
            Popunishbasic basic = (Popunishbasic) list.get(i);
            if ("-".equals(basic.getPunishvalue())) {
                basic.setPunishvalue("");
            }
            if (basic.getPunishtypeid().equals(amercecode)) {
                continue;
            } else {
                String tmp = this.poradixbasicDao.getDatavalueFromFdic(
                        "punishType", basic.getPunishtypeid());
                String punishvalue = basic.getPunishvalue();
                if (!"".equals(punishvalue)) {
                    tmp = tmp + ":";
                    if (this.poradixbasicDao.getDataCodeFromFdic("punishType",
                            "shutout").equals(basic.getPunishtypeid())
                            || this.poradixbasicDao.getDataCodeFromFdic(
                                    "punishType", "detention").equals(
                                    basic.getPunishtypeid())) {
                        punishvalue = punishvalue + "天";
                    }
                    tmp = tmp + punishvalue;
                }
                if (StringUtils.isBlank(limited)) {
                    limited = tmp;
                } else {
                    limited = limited + ";" + tmp;
                }
            }
        }
        return limited;
    }

    public void updatePunishBasic(String punishObjectID, String item_id,
            String[] freeUmpire, String degreeNo) {
        if (StringUtils.isBlank(degreeNo)) {
            degreeNo = "0";
        }
        if (this.popunishbasicDao.isHavingPunishBasic(punishObjectID, item_id)) {
            this.popunishbasicDao.deleteAllPunishBasic(punishObjectID, item_id);
        }
        for (int i = 0; i < freeUmpire.length; i++) {
            String punishTypeID = "";
            String punishValue = "";
            if (freeUmpire[i].contains("@")) {
                punishTypeID = freeUmpire[i].split("@")[0];
                punishValue = freeUmpire[i].split("@")[1];
            } else if (freeUmpire[i].contains("&")) {
                punishTypeID = freeUmpire[i].split("&")[0];
                punishValue = freeUmpire[i].split("&")[1];
            }
            if (punishValue.indexOf("*") > -1) {
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
                Double radix = Double.parseDouble(punishValue
                        .substring(punishValue.indexOf("*") + 1));
                Double multiple = Double.parseDouble(punishValue.substring(0,
                        punishValue.indexOf("*")));
                Poradixbasic poRadix = new Poradixbasic();
                poRadix.setDegreeno(Long.parseLong(degreeNo));
                poRadix.setMultiple(Double.parseDouble(df.format(multiple)));
                poRadix.setRadix(radix.longValue());
                poRadix.setItem_id(item_id);
                poRadix.setPunishobjectid(punishObjectID);
                poRadix.setPunishtypeid(punishTypeID);
                this.poradixbasicDao.updateRadixBasic(poRadix);
                punishValue = df.format(multiple * radix);
            }
            Popunishbasic basic = new Popunishbasic();
            basic.setItem_id(item_id);
            basic.setPunishobjectid(punishObjectID);
            basic.setPunishtypeid(punishTypeID);
            basic.setPunishvalue(punishValue);
            this.popunishbasicDao.save(basic);
        }
    }

    public void updatePunishBasic2(String punishObjectID, String item_id,
            String[] freeUmpire, String degreeNo) {
        if (StringUtils.isBlank(degreeNo)) {
            degreeNo = "0";
        }
        Long deg = Long.parseLong(degreeNo);
        String pcfreeumpiretypeId = null;
        String podiscussresult = null;
        pcfreeumpiretype = pcfreeumpiretypeDao.getPunishTypeid(deg);
        if (pcfreeumpiretype != null) {
            pcfreeumpiretypeId = pcfreeumpiretype.getPunishtypeid();
        }
        podiscussbase = podiscussbasicDao.getPodiscussresult(punishObjectID);
        if (podiscussbase != null) {
            podiscussresult = podiscussbase.getPodiscussresult();
            if (podiscussresult.indexOf(":") > -1) {
                podiscussresult = podiscussresult.substring(podiscussresult
                        .indexOf(":") + 1);
            }
        }
        if (this.popunishbasicDao.isHavingPunishBasic(punishObjectID, item_id)) {
            this.popunishbasicDao.deleteAllPunishBasic(punishObjectID, item_id);
        }
        for (int i = 0; i < freeUmpire.length; i++) {
            String punishTypeID = "";
            String punishValue = "";
            if (freeUmpire[i].contains("@")) {
                punishTypeID = freeUmpire[i].split("@")[0];
                punishValue = freeUmpire[i].split("@")[1];
            } else if (freeUmpire[i].contains("&")) {
                punishTypeID = freeUmpire[i].split("&")[0];
                punishValue = freeUmpire[i].split("&")[1];
            }
            if (punishValue.indexOf("*") > -1) {
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
                Double radix = Double.parseDouble(punishValue
                        .substring(punishValue.indexOf("*") + 1));
                Double multiple = Double.parseDouble(punishValue.substring(0,
                        punishValue.indexOf("*")));
                Poradixbasic poRadix = new Poradixbasic();
                poRadix.setDegreeno(Long.parseLong(degreeNo));
                poRadix.setMultiple(Double.parseDouble(df.format(multiple)));
                poRadix.setRadix(radix.longValue());
                poRadix.setItem_id(item_id);
                poRadix.setPunishobjectid(punishObjectID);
                poRadix.setPunishtypeid(punishTypeID);
                this.poradixbasicDao.updateRadixBasic(poRadix);
                punishValue = df.format(multiple * radix);
            }
            Popunishbasic basic = new Popunishbasic();
            basic.setItem_id(item_id);
            basic.setPunishobjectid(punishObjectID);
            if (punishTypeID == null || "".equals(punishTypeID)) {
                basic.setPunishtypeid(pcfreeumpiretypeId);
            } else {
                basic.setPunishtypeid(punishTypeID);
            }
            if (punishValue == null || "".equals(punishValue)) {
                basic.setPunishvalue(podiscussresult);
            } else {
                basic.setPunishvalue(punishValue);
            }

            this.popunishbasicDao.save(basic);
        }
    }

    @Override
    public Potranslawbasic getItem_idBypunishobjectid(String punishobjectid) {
        return potranslawbasicDao.getItem_idBypunishobjectid(punishobjectid);
    }

    public void setPoradixbasicDao(PoradixbasicDao poradixbasicDao) {
        this.poradixbasicDao = poradixbasicDao;
    }

    public void setPunishobjectbasicDao(
            PunishobjectbasicDao punishobjectbasicDao) {
        this.punishobjectbasicDao = punishobjectbasicDao;
    }

    public void setPcfreeumpiretypeDao(PcfreeumpiretypeDao pcfreeumpiretypeDao) {
        this.pcfreeumpiretypeDao = pcfreeumpiretypeDao;
    }

    public void setPopunishbasicDao(PopunishbasicDao popunishbasicDao) {
        this.popunishbasicDao = popunishbasicDao;
    }

    public PotranslawbasicDao getPotranslawbasicDao() {
        return potranslawbasicDao;
    }

    public void setPotranslawbasicDao(PotranslawbasicDao baseDao) {
        this.potranslawbasicDao = baseDao;
        setBaseDao(this.potranslawbasicDao);
    }

    public void setvPotranslawbasicDao(VPotranslawbasicDao vPotranslawbasicDao) {
        this.vPotranslawbasicDao = vPotranslawbasicDao;
    }

    public List<Potranslawbasic> getPotranslawbasicsbyId(String punishobjectid) {
        return potranslawbasicDao.getPotranslawbasicsbyId(punishobjectid);
    }

    public void setPcpunishStandardDao(PcpunishStandardDao pcpunishStandardDao) {
        this.pcpunishStandardDao = pcpunishStandardDao;
    }

    public void setPcfreeumpiredegreeDao(
            PcfreeumpiredegreeDao pcfreeumpiredegreeDao) {
        this.pcfreeumpiredegreeDao = pcfreeumpiredegreeDao;
    }

    public Pcfreeumpiretype getPcfreeumpiretype() {
        return pcfreeumpiretype;
    }

    public void setPcfreeumpiretype(Pcfreeumpiretype pcfreeumpiretype) {
        this.pcfreeumpiretype = pcfreeumpiretype;
    }

    public Podiscussbasic getPodiscussbase() {
        return podiscussbase;
    }

    public void setPodiscussbase(Podiscussbasic podiscussbase) {
        this.podiscussbase = podiscussbase;
    }

    public PodiscussbasicDao getPodiscussbasicDao() {
        return podiscussbasicDao;
    }

    public void setPodiscussbasicDao(PodiscussbasicDao podiscussbasicDao) {
        this.podiscussbasicDao = podiscussbasicDao;
    }
}
