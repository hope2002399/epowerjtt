package com.centit.punish.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerbase.service.SuppowerManager;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.po.VOrgSupPower;
import com.centit.punish.po.Podiscussbasic;
import com.centit.punish.po.PodiscussbasicId;
import com.centit.punish.po.Pofinishbasic;
import com.centit.punish.po.Poindagaterepbasic;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PodiscussbasicManager;
import com.centit.punish.service.PofinishbasicManager;
import com.centit.punish.service.PoindagaterepbasicManager;
import com.centit.punish.service.PopunishbasicManager;
import com.centit.punish.service.PotranslawbasicManager;
import com.centit.punish.service.PunishobjectbasicManager;
import com.centit.sys.security.FUserDetail;

public class PodiscussbasicAction extends PunishCommonBizAction<Podiscussbasic> {
    private static final Log log = LogFactory
            .getLog(PodiscussbasicAction.class);
    private static final long serialVersionUID = 1L;
    private PodiscussbasicManager podiscussbasicMag;
    private Punishobjectbasic punishobjectbasic;
    @SuppressWarnings("unused")
    private PopunishbasicManager popunishbasicManager;
    private PunishobjectbasicManager punishobjectbasicManager;
    private PotranslawbasicManager potranslawbasicManager;
    private PoindagaterepbasicManager poindagaterepbasicManager;
    private PofinishbasicManager pofinishbasicManager;
    private SuppowerManager suppowerManager;
    private String retresult;
    private String isNeed;// 是否需要二次讨论

    public String editDiscuss() {
        punishobjectbasic = punishobjectbasicManager.getObjectById(object
                .getPunishobjectid());
        return EDIT;
    }

    /**
     * 查看详细信息
     */
    public String view() {
        try {
            Podiscussbasic o = baseEntityManager.getObject(object);
            if (object == null) {

                return LIST;
            }
            if (o != null)
                baseEntityManager.copyObject(object, o);
            if (curNodeInstId != null) {
                if (optProcInfo == null) {
                    optProcInfo = new OptProcInfo();
                }
                optProcInfo.setDjId(object.getPunishobjectid());
                optProcInfo.setNodeInstId(curNodeInstId);
                optStuffs = super.optProcInfoManager
                        .getStuffInfoList(optProcInfo);
            }
            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    /********************************** 案件讨论节点 ******************************/
    private String item_id;
    private String degreeNo;
    private Integer punishClassNum = null;

    private File podiscussrecored_;
    private String podiscussrecored_FileName;
    private String isSurpass;
    private String selFreeUmpire;
    private long podiscussType = 1;

    /**
     * 案件讨论: 案件第一次讨论
     * 
     * @return
     */
    public String PODiscuss() {
        String punishobjectid = object.getPunishobjectid();
        long podiscusstype = podiscussType;// 默认为案件一次讨论
        // 第一次讨论：flowPhase=ajtl;第二次讨论：flowPhase=ectl
        /**
         * 案件一次讨论
         */
        object.setPodiscusstype(podiscusstype);
        // 初始化页面信息
        object = podiscussbasicMag.getObject(object);
        if (object == null) {
            object = new Podiscussbasic();
            object.setPunishobjectid(punishobjectid);
            object.setPodiscussbegintime(new Date(System.currentTimeMillis()));
            object.setPodiscussendtime(new Date(System.currentTimeMillis()));
        }

        Punishobjectbasic pobasic = this.punishobjectbasicManager
                .getObjectById(punishobjectid);
        int punishclassnum = pobasic.getPunishclassnum().intValue();// 处罚项目种类数量
        if (punishclassnum == 1) {
            punishClassNum = 1;
            // 获取权力编码
            item_id = this.podiscussbasicMag.getPunishClassID(punishobjectid);
            degreeNo = this.podiscussbasicMag.getDegreeNoByCon(punishobjectid,
                    item_id);
        } else if (punishclassnum > 1) {
            punishClassNum = punishclassnum;
            degreeNo = "";
            item_id = "00000000";
        }
        object.setPodiscusstype(podiscusstype);
        if (podiscusstype == 1) {
            object.setPodiscussresult(this.poindagaterepbasicManager
                    .getObjectById(object.getPunishobjectid())
                    .getPoindagaterepresult());
        } else if (podiscusstype == 2) {
            Podiscussbasic bean = this.podiscussbasicMag
                    .getObjectById(new PodiscussbasicId(object
                            .getPunishobjectid(), Long.parseLong("1")));
            if (bean == null) {
                bean = new Podiscussbasic();
            }
            object.setPodiscussresult(bean.getPodiscussresult());
        }
        // 初始化风险点
        super.initalOptProcInfo();
        // 初始化处罚决定
        // cftype初始化

        Poindagaterepbasic bean = poindagaterepbasicManager
                .getObjectById(punishobjectid);
        if (StringUtils.isNotBlank(bean.getPoindagaterepstate())) {
            if ("0".equals(bean.getPoindagaterepstate())) {
                optProcInfo.setCfType("1");
            } else {
                optProcInfo.setCfType("99999");
            }
        } else {
            optProcInfo.setCfType("1");
        }
        return "PODiscuss";
    }

    /**
     * 案件讨论: * 案件第二次讨论
     * 
     * @return
     */
    public String PO2Discuss() {
        podiscussType = 2;
        return this.PODiscuss();
    }

    /**
     * 案件讨论步骤 - 处罚意见选择页面 -自由裁量标准 用户根据业务需要确定处罚意见后，保持对应的处罚意见
     * 
     * @return
     */
    public String savepunishInfo() {
        String FreeUmpire[] = selFreeUmpire.split(",");
        punishobjectbasic = this.punishobjectbasicManager
                .getPunishobjectid(object.getPunishobjectid());

        if (punishobjectbasic != null) {
            punishClassNum = punishobjectbasic.getPunishclassnum().intValue();
        } else {
            punishClassNum = 1;
        }
        // punishClassNum =
        // this.punishobjectbasicManager.getObjectById(object.getPunishobjectid()).getPunishclassnum().intValue();
        if (punishClassNum != null && punishClassNum == 1
                && !StringUtils.isBlank(degreeNo)) {
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            VOrgSupPower vOrgSupPower = suppowerManager.getSupPowerInfo(
                    item_id, loginInfo.getPrimaryUnit());
            isSurpass = this.potranslawbasicManager.isSurpassFreeUmpire(
                    item_id, vOrgSupPower.getVersion(), degreeNo, FreeUmpire);
            String punishobjectid = object.getPunishobjectid();
            String podiscusstype = null;
            if (object.getPodiscusstype() != null) {
                podiscusstype = String.valueOf(object.getPodiscusstype());
            } else {
                podiscusstype = "0";
                object.setPodiscusstype((long) 0);
            }
            this.podiscussbasicMag.savepunishBasicInfo(punishobjectid,
                    podiscusstype, item_id, FreeUmpire, isSurpass,
                    String.valueOf(punishClassNum), degreeNo, object);
            retresult = this.podiscussbasicMag.getObjectById(
                    new PodiscussbasicId(punishobjectid, Long
                            .parseLong(podiscusstype))).getPodiscussresult();
        }
        if (punishClassNum != null && punishClassNum == 1) {
            return "punishinfo2";
        } else {
            return "allpunishinfo2";
        }
    }

    /**
     * 保存案件讨论信息 案件第一次讨论：提交后进入发放处罚预先告知书环节 案件第二次讨论：提交后进入行政审批环节
     * 
     * @return
     */
    public String saveDiscussSubmitOpt() {

        try {
            if (!"0".equals(isNeed)) {// 需要二次讨论
                Podiscussbasic bean = podiscussbasicMag.getObject(object);
                if (bean != null) {
                    bean.copyNotNullProperty(object);
                    object = bean;
                }
                if (podiscussrecored_ != null) {
                    try {
                        FileInputStream fis = new FileInputStream(
                                podiscussrecored_);
                        if (fis != null) {
                            byte[] bbuf = null;
                            int len = fis.available();
                            bbuf = new byte[len];
                            fis.read(bbuf);
                            object.setPodiscussrecored(bbuf);
                            object.setPodiscussaffixname(podiscussrecored_FileName);
                        }
                        fis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                object.setEnregisterdate(new Date(System.currentTimeMillis()));
                FUserDetail fUserDetail = (FUserDetail) getLoginUser();
                object.setEnregisterid(fUserDetail.getUsercode());
                podiscussbasicMag.saveDiscussbase(object);
                // 更新结案信息表中认定违法事实、违反条款、处罚结论信息
                Pofinishbasic pofinishbasic = pofinishbasicManager
                        .getObjectById(object.getPunishobjectid());
                if (pofinishbasic == null) {
                    pofinishbasic = new Pofinishbasic();
                    pofinishbasic.setPunishobjectid(object.getPunishobjectid());
                }
                /*
                 * //此处做特殊处理，如果没有做出认定违法事实、违反条款、处罚结论信息，则这三项采用最终调查报告中的数据
                 * Poindagaterepbasic poindagaterepbasic=
                 * poindagaterepbasicManager
                 * .getObjectById(object.getPunishobjectid());
                 */
                pofinishbasic.setConfirmtruth(object.getConfirmtruth());
                pofinishbasic.setDisobeyitem(object.getDisobeyitem());
                pofinishbasic.setPodiscussresult(object.getPodiscussresult());

                pofinishbasicManager.saveObject(pofinishbasic);

                if (1 == object.getPodiscusstype()) {// 一次讨论
                    super.initalOptNewlyIdea((long) 1, "一次讨论", (long) 9,
                            "/punish/podiscussbasic!view.do?podiscusstype=1&punishobjectid="
                                    + object.getPunishobjectid()
                                    + "&nodeInstId=" + curNodeInstId);
                    // 更新案件实际讨论次数，进行1次讨论时，需将值置成1
                    Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                            .getObjectById(object.getPunishobjectid());
                    punishobjectbasic.setPodiscussnum((long) 1);
                    this.punishobjectbasicManager.saveObject(punishobjectbasic);
                } else {// 二次讨论
                    super.initalOptNewlyIdea((long) 1, "二次讨论", (long) 11,
                            "/punish/podiscussbasic!view.do?podiscusstype=2&punishobjectid="
                                    + object.getPunishobjectid()
                                    + "&nodeInstId=" + curNodeInstId);
                    // 更新案件实际讨论次数，进行二次讨论时，需将值置成2
                    Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                            .getObjectById(object.getPunishobjectid());
                    punishobjectbasic.setPodiscussnum((long) 2);
                    this.punishobjectbasicManager.saveObject(punishobjectbasic);
                }

            } else {// 不需要二次讨论
                podiscussbasicMag.deleteObject(object);// 如果存在二次讨论的信息，则删除之
                // 更新案件实际讨论次数，不进行二次讨论时，需将值置成1
                Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                        .getObjectById(object.getPunishobjectid());
                punishobjectbasic.setPodiscussnum((long) 1);
                this.punishobjectbasicManager.saveObject(punishobjectbasic);
            }

            return this.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            e.printStackTrace();
            request.setAttribute("error", "保存案件讨论信息出错，详见系统日志。");
            return ERROR;
        }
    }

    private List<OptStuffInfo> optStuffs;
    private InputStream inputStream;
    private InputStream stuffStream;
    private String filename;

    /**
     * 处罚讨论附件下载
     * 
     * @return
     */
    public String downloaddiscussstuff() {
        PodiscussbasicId cid = new PodiscussbasicId();
        cid.setPunishobjectid(object.getPunishobjectid());
        cid.setPodiscusstype(object.getPodiscusstype());
        object = this.podiscussbasicMag.getObjectById(cid);
        String fn = object.getPodiscussaffixname();
        try {
            if (object.getPodiscussrecored() != null) {
                inputStream = new ByteArrayInputStream(
                        object.getPodiscussrecored());
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }
        try {
            this.setFilename(new String(fn.getBytes("GBK"), "ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "download";

    }

    /********************* getter、setter ***************************/

    public void setPodiscussbasicManager(PodiscussbasicManager basemgr) {
        podiscussbasicMag = basemgr;
        this.setBaseEntityManager(podiscussbasicMag);
    }

    public PunishobjectbasicManager getPunishobjectbasicManager() {
        return punishobjectbasicManager;
    }

    public void setPunishobjectbasicManager(
            PunishobjectbasicManager punishobjectbasicManager) {
        this.punishobjectbasicManager = punishobjectbasicManager;
    }

    public Punishobjectbasic getPunishobjectbasic() {
        return punishobjectbasic;
    }

    public void setPunishobjectbasic(Punishobjectbasic punishobjectbasic) {
        this.punishobjectbasic = punishobjectbasic;
    }

    public void setPopunishbasicManager(
            PopunishbasicManager popunishbasicManager) {
        this.popunishbasicManager = popunishbasicManager;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public void setPunishClassNum(Integer punishClassNum) {
        this.punishClassNum = punishClassNum;
    }

    public String getDegreeNo() {
        return degreeNo;
    }

    public void setDegreeNo(String degreeNo) {
        this.degreeNo = degreeNo;
    }

    public int getPunishClassNum() {
        return punishClassNum;
    }

    public void setPunishClassNum(int punishClassNum) {
        this.punishClassNum = punishClassNum;
    }

    public void setPotranslawbasicManager(
            PotranslawbasicManager potranslawbasicManager) {
        this.potranslawbasicManager = potranslawbasicManager;
    }

    public File getPodiscussrecored_() {
        return podiscussrecored_;
    }

    public void setPodiscussrecored_(File podiscussrecored_) {
        this.podiscussrecored_ = podiscussrecored_;
    }

    public String getPodiscussrecored_FileName() {
        return podiscussrecored_FileName;
    }

    public void setPodiscussrecored_FileName(String podiscussrecored_FileName) {
        this.podiscussrecored_FileName = podiscussrecored_FileName;
    }

    public void setPofinishbasicManager(
            PofinishbasicManager pofinishbasicManager) {
        this.pofinishbasicManager = pofinishbasicManager;
    }

    public PoindagaterepbasicManager getPoindagaterepbasicManager() {
        return poindagaterepbasicManager;
    }

    public void setPoindagaterepbasicManager(
            PoindagaterepbasicManager poindagaterepbasicManager) {
        this.poindagaterepbasicManager = poindagaterepbasicManager;
    }

    public String getRetresult() {
        return retresult;
    }

    public void setRetresult(String retresult) {
        this.retresult = retresult;
    }

    public String getIsNeed() {
        return isNeed;
    }

    public void setIsNeed(String isNeed) {
        this.isNeed = isNeed;
    }

    public List<OptStuffInfo> getOptStuffs() {
        return optStuffs;
    }

    public void setOptStuffs(List<OptStuffInfo> optStuffs) {
        this.optStuffs = optStuffs;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getSelFreeUmpire() {
        return selFreeUmpire;
    }

    public void setSelFreeUmpire(String selFreeUmpire) {
        this.selFreeUmpire = selFreeUmpire;
    }

    public String getIsSurpass() {
        return isSurpass;
    }

    public void setIsSurpass(String isSurpass) {
        this.isSurpass = isSurpass;
    }

    public long getPodiscussType() {
        return podiscussType;
    }

    public void setPodiscussType(long podiscussType) {
        this.podiscussType = podiscussType;
    }

    public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }
}
