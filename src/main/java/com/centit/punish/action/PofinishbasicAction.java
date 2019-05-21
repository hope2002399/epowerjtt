package com.centit.punish.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.punish.po.Podiscussbasic;
import com.centit.punish.po.PodiscussbasicId;
import com.centit.punish.po.Pofinishbasic;
import com.centit.punish.po.Poindagaterepbasic;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PodiscussbasicManager;
import com.centit.punish.service.PofinishbasicManager;
import com.centit.punish.service.PoindagaterepbasicManager;
import com.centit.punish.service.PunishobjectbasicManager;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.SysUserFilterEngine;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

public class PofinishbasicAction extends PunishCommonBizAction<Pofinishbasic> {
    private static final Log log = LogFactory.getLog(PofinishbasicAction.class);
    private static final long serialVersionUID = 1L;
    private PofinishbasicManager pofinishbasicMag;
    private PunishobjectbasicManager punishobjectbasicManager;
    private PoindagaterepbasicManager poindagaterepbasicManager;
    private PodiscussbasicManager podiscussbasicManager;

    public void setPofinishbasicManager(PofinishbasicManager basemgr) {
        pofinishbasicMag = basemgr;
        this.setBaseEntityManager(pofinishbasicMag);
    }

    public void setPunishobjectbasicManager(
            PunishobjectbasicManager punishobjectbasicManager) {
        this.punishobjectbasicManager = punishobjectbasicManager;
    }

    public void setPoindagaterepbasicManager(
            PoindagaterepbasicManager poindagaterepbasicManager) {
        this.poindagaterepbasicManager = poindagaterepbasicManager;
    }

    public void setPodiscussbasicManager(
            PodiscussbasicManager podiscussbasicManager) {
        this.podiscussbasicManager = podiscussbasicManager;
    }

    OptProcInfo opi = new OptProcInfo();
    private String roleCode = "";

    private File punishaffixdoc_;
    private String punishaffixdoc_FileName;

    /**
     * 案件执行情况登记
     * 
     * @return
     */
    public String doBookfinish() {
        String punishobjectid = object.getPunishobjectid();

        object = pofinishbasicMag.getObjectById(punishobjectid);
        if (object == null) {
            object = new Pofinishbasic();
            object.setPunishobjectid(punishobjectid);

        }
        this.initailFinish(punishobjectid);
        String amout = pofinishbasicMag.getPunishReultByExtraCode(
                punishobjectid, "3");// 罚款
        String seizure = pofinishbasicMag.getPunishReultByExtraCode(
                punishobjectid, "4");// 没收违法所得、没收非法财物
        String shouont = pofinishbasicMag.getPunishReultByExtraCode(
                punishobjectid, "6");// 责令停产停业
        String detention = pofinishbasicMag.getPunishReultByExtraCode(
                punishobjectid, "7");// 行政拘留

        object.setPunishamout(Double.parseDouble(amout));
        object.setPunishseizure(Long.parseLong(seizure));
        object.setPunishshoutont(Long.parseLong(shouont));
        object.setPunishdetention(Long.parseLong(detention));

        object.setPunishamoutpeople(0);
        object.setPunishseizurevalue(0.00);
        object.setPunishdetentionpeople(0);

        // 初始化风险点
        this.initalOptProcInfo();
        // 审批人员角色信息
        // this.initaluserJson();
        super.initalNextOperators();
        opi.setTranscontent("申请结案");

        return "doBookfinish";
    }

    // 违法条款、最终处罚意见、认定违法事实首先从讨论表里取值，前者没有再从案件调查终结报告信息表中取
    private void initailFinish(String punishobjectid) {
        Poindagaterepbasic bean = poindagaterepbasicManager
                .getObjectById(punishobjectid);
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getObjectById(object.getPunishobjectid());
        Podiscussbasic podiscussbasic = new Podiscussbasic();
        PodiscussbasicId podiscussbasicId = new PodiscussbasicId();
        podiscussbasicId.setPunishobjectid(object.getPunishobjectid());
        if (1 == punishobjectbasic.getPunishclassnum()) {
            podiscussbasicId.setPodiscusstype((long) 1);
            podiscussbasic = podiscussbasicManager
                    .getObjectById(podiscussbasicId);
        } else {
            podiscussbasicId.setPodiscusstype((long) 2);
            podiscussbasic = podiscussbasicManager
                    .getObjectById(podiscussbasicId);
        }

        if (StringUtils.isBlank(object.getDisobeyitem())) {
            if (podiscussbasic == null
                    || StringUtils.isBlank(podiscussbasic.getDisobeyitem())) {
                object.setDisobeyitem(bean.getDisobeyitem());
            } else {
                object.setDisobeyitem(podiscussbasic.getDisobeyitem());
            }
        }
        if (StringUtils.isBlank(object.getConfirmtruth())) {
            if (podiscussbasic == null
                    || StringUtils.isBlank(podiscussbasic.getConfirmtruth())) {
                object.setConfirmtruth(bean.getConfirmtruth());
            } else {
                object.setConfirmtruth(podiscussbasic.getConfirmtruth());
            }
        }
        if (StringUtils.isBlank(object.getPodiscussresult())) {
            if (podiscussbasic == null
                    || StringUtils.isBlank(podiscussbasic.getPodiscussresult())) {
                object.setPodiscussresult(bean.getPoindagaterepresult());
            } else {
                object.setPodiscussresult(podiscussbasic.getPodiscussresult());
            }
        }

    }

    /**
     * 提交处罚执行情况并申请审批
     * 
     * @return
     */
    public String saveFinishSubmitOpt() {
        try {
            // 保存更新结案审批信息
            this.save();
            // 详细信息查看使用
            initalOptNewlyIdea(
                    (long) 0,
                    "",
                    (long) 16,
                    "/punish/pofinishbasic!view.do?punishobjectid="
                            + object.getPunishobjectid());
            // 提交流程
            return super.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交处罚执行情况信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 结案审批：领导审批等
     * 
     * @return
     */
    public String isPOFinish() {

        String punishobjectid = object.getPunishobjectid();

        object = pofinishbasicMag.getObjectById(punishobjectid);
        if (object == null) {
            object = new Pofinishbasic();
            object.setPunishobjectid(punishobjectid);
        }

        this.initailFinish(punishobjectid);

        super.initalDocJson("处罚结案报告", object.getPunishobjectid());
        if (StringUtils.isNotBlank(super.getModuleCode())
                && !"null".equals(super.getModuleCode())) {
            // 初始化页面form对应的actionName、提交方法以及保存方法名
            super.initalGenneralOpt("pofinishbasic", "saveIsFinishsubmitOpt",
                    "saveOpt");
            return super.generalOpt();
        }

        // 初始化风险点
        this.initalOptProcInfo();
        return "isPOFinish";
    }

    /**
     * 提交结案审批：领导审批等
     * 
     * @return
     */
    public String saveIsFinishsubmitOpt() {
        try {
            // 局长结案审批时，更新结案审批表
            String ideacode = optProcInfo.getIdeacode();
            Pofinishbasic pofinishbasic = pofinishbasicMag.getObjectById(object
                    .getPunishobjectid());
            FUserDetail loginInfo = (FUserDetail) getLoginUser();

            if (pofinishbasic != null) {
                pofinishbasic.copyNotNullProperty(object);
                object = pofinishbasic;
                this.initailFinish(object.getPunishobjectid());
            }

            if (!"cfja_kssp".equalsIgnoreCase(super.getFlowPhase())) {// 局长审批
                if ("T".equals(ideacode)) {
                    object.setIsfinish((long) 1);
                }
                object.setFzrja(CodeRepositoryUtil.getValue("usercode",
                        loginInfo.getUsercode()));
                object.setFzroptionja(optProcInfo.getTranscontent());
                object.setFzroptionjatime(new Date(System.currentTimeMillis()));
                // 显示详细信息
                initalOptNewlyIdea((long) 1, "执行情况与结案", (long) 18,
                        "/punish/pofinishbasic!view.do?punishobjectid="
                                + object.getPunishobjectid() + "&nodeInstId="
                                + curNodeInstId);
            } else {// 科长审批
                object.setKsja(CodeRepositoryUtil.getValue("usercode",
                        loginInfo.getUsercode()));
                object.setKsoptionja(optProcInfo.getTranscontent());
                object.setKsoptionjatime(new Date(System.currentTimeMillis()));
                // 不显示详细信息
                initalOptNewlyIdea((long) 0, "", (long) 17,
                        "/punish/pofinishbasic!view.do?punishobjectid="
                                + object.getPunishobjectid());
            }
            pofinishbasicMag.saveObject(object);
            // 提交流程
            return super.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交结案审批信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 结案
     * 
     * @return
     */
    public String poFinish() {
        String punishobjectid = object.getPunishobjectid();

        object = pofinishbasicMag.getObjectById(punishobjectid);
        if (object == null) {
            object = new Pofinishbasic();
            object.setPunishobjectid(punishobjectid);
        }
        this.initailFinish(punishobjectid);
        return "poFinish";
    }

    /**
     * 提交结束结案
     * 
     * @return
     */
    public String saveEndsubmitOpt() {
        try {
            // 更新处罚基本表
            String punishobjectid = object.getPunishobjectid();
            Punishobjectbasic base = punishobjectbasicManager
                    .getObjectById(punishobjectid);
            base.setPofinishdate(new Date(System.currentTimeMillis()));// 结案时间

            base.setSolvestatus("2");// 同意结案
            base.setSolvetime(new Date(System.currentTimeMillis()));// 办结时间

            OptIdeaInfo optIdeaInfo = super.getOptProcInfoManager()
                    .listIdeaLogsByDjId(punishobjectid).get(0);
            base.setSolvenote(optIdeaInfo.getTranscontent());

            punishobjectbasicManager.saveObject(base);
            // 提交流程
            return super.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交结案信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 保存|更新结案审批信息
     */
    public String save() {
        try {
            String punishobjectid = object.getPunishobjectid();
            Pofinishbasic bean = pofinishbasicMag.getObjectById(punishobjectid);

            if (bean != null) {
                bean.copyNotNullProperty(object);
                object = bean;
                this.initailFinish(punishobjectid);
            }
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            object.setJbrja(CodeRepositoryUtil.getValue("usercode",
                    loginInfo.getUsercode()));
            object.setJbroptionja(optProcInfo.getTranscontent());
            object.setJbroptionjatime(new Date(System.currentTimeMillis()));

            if (punishaffixdoc_ != null) {
                try {
                    FileInputStream fis = new FileInputStream(punishaffixdoc_);
                    if (fis != null) {
                        byte[] bbuf = null;
                        int len = fis.available();
                        bbuf = new byte[len];
                        fis.read(bbuf);
                        object.setPunishaffixdoc(bbuf);
                        object.setPunishaffixname(punishaffixdoc_FileName);
                    }
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            pofinishbasicMag.saveObject(object);
            return "";
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存结案审批信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 审批人员角色信息
     * 
     * @return
     */
    public String initaluserJson() {
        // 获取人员权限编号
        NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId);
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());
        if (fif != null) {
            roleCode = fif.getRoleCode();
        }
        /**
         * 获得办件角色人名单
         */
        Set<String> Rolecodes = flowEngine.viewFlowWorkTeam(
                nit.getFlowInstId(), roleCode);

        String RoleuserCodes = "";
        // String RoleuserNames = "";

        if (Rolecodes != null && Rolecodes.size() > 0) {
            for (String a : Rolecodes) {
                RoleuserCodes += a + ",";
                // RoleuserNames += CodeRepositoryUtil.getValue("usercode", a)
                // + ",";
            }
            teamRoleCode = RoleuserCodes.substring(0,
                    RoleuserCodes.length() - 1);
            // bjUserNames = RoleuserNames.substring(0, RoleuserNames.length() -
            // 1);
        }

        /**
         * 根据参数是否需要 办件人员
         */
        FUserDetail fUserDetail = (FUserDetail) getLoginUser();
        String roleCode = roleCodefromFlow;
        if (StringUtils.isBlank(roleCode) || "null".equals(roleCode)) {
            roleCode = "D(all)";
        }
        Set<String> users = SysUserFilterEngine.calcOperators(roleCode,
                fUserDetail.getPrimaryUnit(), null, null, null,
                fUserDetail.getUsercode(), null);
        JSONArray userjson = new JSONArray();
        if (users != null) {
            for (String user : users) {
                String username = CodeRepositoryUtil.getValue("usercode", user);
                JSONObject usermap = new JSONObject();
                usermap.put("name", username);
                usermap.put("nodeID", user);
                usermap.put("belongId", "-1");
                usermap.put("levle", 2);
                userjson.add(usermap);
            }
        }
        request.setAttribute("userjson", userjson);

        return "";
    }

    public File getPunishaffixdoc_() {
        return punishaffixdoc_;
    }

    public void setPunishaffixdoc_(File punishaffixdoc_) {
        this.punishaffixdoc_ = punishaffixdoc_;
    }

    public String getPunishaffixdoc_FileName() {
        return punishaffixdoc_FileName;
    }

    public void setPunishaffixdoc_FileName(String punishaffixdoc_FileName) {
        this.punishaffixdoc_FileName = punishaffixdoc_FileName;
    }

    public OptProcInfo getOpi() {
        return opi;
    }

    public void setOpi(OptProcInfo opi) {
        this.opi = opi;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    private List<OptStuffInfo> optStuffs;

    public List<OptStuffInfo> getOptStuffs() {
        return optStuffs;
    }

    public void setOptStuffs(List<OptStuffInfo> optStuffs) {
        this.optStuffs = optStuffs;
    }

    public String viewFinishBasic() {
        super.view();
        return VIEW;
    }

    public String view() {
        try {
            object = baseEntityManager.getObject(object);
            if (object == null) {
                return LIST;
            }
            optProcInfo = new OptProcInfo();
            optProcInfo.setDjId(object.getPunishobjectid());
            optProcInfo.setNodeInstId(curNodeInstId);
            optStuffs = super.optProcInfoManager.getStuffInfoList(optProcInfo);
            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private InputStream stuffStream;

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 处罚票据下载
     * 
     * @return
     */
    public String downloadstuff() {
        object = this.pofinishbasicMag
                .getObjectById(object.getPunishobjectid());
        String fn = object.getPunishaffixname();
        if (object.getPunishaffixdoc() == null) {
            super.postAlertMessage("附件为空", response);
            return null;
        }
        try {
            if (object.getPunishaffixdoc() != null) {
                inputStream = new ByteArrayInputStream(
                        object.getPunishaffixdoc());
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
}
