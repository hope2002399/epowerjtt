package com.centit.punish.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerbase.po.Vsuppowerinusing;
import com.centit.powerbase.service.VsuppowerinusingManager;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.po.OptWritdef;
import com.centit.powerruntime.service.OptWritdefManager;
import com.centit.punish.po.Pcdef;
import com.centit.punish.po.Poindagaterepbasic;
import com.centit.punish.po.Poregisterbasic;
import com.centit.punish.po.Potranslawbasic;
import com.centit.punish.po.PotranslawbasicId;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PcdefManager;
import com.centit.punish.service.PoindagaterepbasicManager;
import com.centit.punish.service.PoradixbasicManager;
import com.centit.punish.service.PoregisterbasicManager;
import com.centit.punish.service.PotranslawbasicManager;
import com.centit.punish.service.PunishobjectbasicManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.SysUserFilterEngine;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

//案件立案信息
public class PoregisterbasicAction extends
        PunishCommonBizAction<Poregisterbasic> {
    private static final Log log = LogFactory
            .getLog(PoregisterbasicAction.class);
    private static final long serialVersionUID = 1L;
    private Potranslawbasic potranslawbasic;

    private PoregisterbasicManager poregisterbasicMag;
    private PotranslawbasicManager potranslawbasicManager;
    private PunishobjectbasicManager punishobjectbasicManager;
    private PoradixbasicManager poradixbasicManager;
    private PcdefManager pcdefManager;
    private OptWritdefManager optWritdefManager;
    private VsuppowerinusingManager vsuppowerinusingManager;

    private String roleCode = "";

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
        String RoleuserNames = "";

        if (Rolecodes != null && Rolecodes.size() > 0) {
            for (String a : Rolecodes) {
                RoleuserCodes += a + ",";
                RoleuserNames += CodeRepositoryUtil.getValue("usercode", a)
                        + ",";
            }
            teamRoleCode = RoleuserCodes.substring(0,
                    RoleuserCodes.length() - 1);
            bjUserNames = RoleuserNames
                    .substring(0, RoleuserNames.length() - 1);
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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    private String anyou;// 案由
    private String belonganyou;
    private String punishclassname;

    public String getPunishclassname() {
        return punishclassname;
    }

    public void setPunishclassname(String punishclassname) {
        this.punishclassname = punishclassname;
    }

    public String getAnyou() {
        return anyou;
    }

    public void setAnyou(String anyou) {
        this.anyou = anyou;
    }

    public void setPcdefManager(PcdefManager pcdefManager) {
        this.pcdefManager = pcdefManager;
    }

    /**
     * 立案调查
     * 
     * @return
     */
    public String pORegister() {
        object = poregisterbasicMag.getObjectById(object.getPunishobjectid());
        List<Potranslawbasic> list = potranslawbasicManager
                .getPotranslawbasicsbyId(object.getPunishobjectid());
        if (list != null && list.size() > 0) {
            potranslawbasic = list.get(0);
            // 和权力库关联，取最新在用的权力
            Vsuppowerinusing vsuppowerinusing = vsuppowerinusingManager
                    .findB_PowerByItemId(potranslawbasic.getItem_id());

            punishclassname = vsuppowerinusing.getItemName();

            Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                    .getObjectById(object.getPunishobjectid());

            object.setPunishObjectBrief(punishobjectbasic
                    .getPunishobjectbrief());
        }
        /*
         * object =
         * poregisterbasicMag.getObjectById(object.getPunishobjectid());
         * List<Potranslawbasic> list = potranslawbasicManager
         * .getPotranslawbasicsbyId(object.getPunishobjectid());
         * 
         * if (list != null && list.size() > 0) { potranslawbasic = list.get(0);
         * Pcdef pcdef = pcdefManager.getObjectById(potranslawbasic
         * .getPunishclassid()); punishclassname = pcdef.getPunishclassname();
         * Punishobjectbasic
         * punishobjectbasic=punishobjectbasicManager.getObjectById
         * (object.getPunishobjectid());
         * belonganyou=punishobjectbasic.getPunishobjectbrief();
         * object.setPunishObjectBrief
         * (punishobjectbasic.getPunishobjectbrief()); }
         */

        initalOptProcInfo();
        this.initaluserJson();
        return "pORegister";
    }

    /**
     * 保存立案调查
     */
    public String save() {
        try {
            // 1更新案件立案信息
            Poregisterbasic dbobject = poregisterbasicMag.getObjectById(object
                    .getPunishobjectid());

            if (dbobject != null) {
                dbobject.copy(object);
                object = dbobject;
            }
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            object.setJbrOption_la(optProcInfo.getTranscontent());
            object.setJbr_la(CodeRepositoryUtil.getValue("usercode",
                    loginInfo.getUsercode()));
            object.setJbrOption_latime(new Date(System.currentTimeMillis()));

            poregisterbasicMag.saveObject(object);
            // 2新增或更新 案件违法事实信息
            this.saveOrUpdatePotranslawbasic();
            // 3、更新案件基本信息表 -案由字段
            this.updatePunishobjectbasic();
            // 4、根据权力编号初始化案件基数信息
            this.initalRadixBasic();
            // 5、
            // 保存案号：根据权力类型从格式文书案号管理处取出对应的文书格式。
            Punishobjectbasic pbobject = punishobjectbasicManager
                    .getObjectById(object.getPunishobjectid());
            if (StringUtils.isBlank(pbobject.getCaseno())) {
                OptWritdef owf = optWritdefManager.getObjectByTempType("6");// 6:处罚类
                String caseNo = "";
                if (owf != null) {
                    caseNo = this.getWritCodeByWritcodemodel(owf.getWritcode());
                }
                pbobject.setCaseno(caseNo);
                punishobjectbasicManager.saveObject(pbobject);
            }
            super.saveOpt();
            return "refreshTasks";
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存立案前调查信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 根据处罚类别编号初始化案件基数信息
     */
    private void initalRadixBasic() {
        if (StringUtils.isNotBlank(potranslawbasic.getItem_id())) {
            // 删除
            boolean flag = poradixbasicManager
                    .deleteObjectBypunishObjectID(object.getPunishobjectid());
            if (flag) {
                poradixbasicManager.initRadixBasic(object.getPunishobjectid(),
                        potranslawbasic.getItem_id());
            }
        }
    }

    /**
     * 新增或更新 案件违法事实信息
     */
    private void saveOrUpdatePotranslawbasic() {
        if (StringUtils.isNotBlank(potranslawbasic.getItem_id())) {
            PotranslawbasicId cid = new PotranslawbasicId();
            cid.setPunishobjectid(object.getPunishobjectid());
            if (potranslawbasic != null) {
                cid.setItem_id(potranslawbasic.getItem_id());
            }
            Potranslawbasic dbpotranslawbasic = potranslawbasicManager
                    .getObjectById(cid);
            if (dbpotranslawbasic != null) {
                dbpotranslawbasic.copyNotNullProperty(potranslawbasic);
                potranslawbasic = dbpotranslawbasic;
            } else {
                potranslawbasic.setPunishobjectid(object.getPunishobjectid());

            }
            potranslawbasic.setTranslawdate(new Date());
            potranslawbasicManager.saveObject(potranslawbasic);
        }
    }

    /**
     * 更新案件基本信息表 -案由字段
     */
    private void updatePunishobjectbasic() {
        if (StringUtils.isNotBlank(object.getPunishObjectBrief())) {
            Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                    .getObjectById(object.getPunishobjectid());
            punishobjectbasic.setPunishobjectbrief(object
                    .getPunishObjectBrief());
            punishobjectbasic.setPunishclassnum((long) 1);
            punishobjectbasicManager.saveObject(punishobjectbasic);
        }
    }

    /**
     * 提交立案前调查信息
     * 
     * @return
     */
    public String submit() {
        try {
            this.save();
            super.initalOptNewlyIdea((long) 0, "", (long) 3,
                    "/punish/poregisterbasic!initialAndApproval.do?punishobjectid="
                            + object.getPunishobjectid());
            return super.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交立案前调查信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 立案调查审批信息
     * 
     * @return
     */
    public String isKSPORegister() {
        object = poregisterbasicMag.getObjectById(object.getPunishobjectid());

        if (StringUtils.isNotBlank(super.getModuleCode())
                && !"null".equals(super.getModuleCode())) {
            // 初始化页面form对应的actionName、提交方法以及保存方法名
            super.initalGenneralOpt("poregisterbasic", "submitIsKSPORegister",
                    "saveIs");
            return super.generalOpt();
        }

        initalOptProcInfo();
        return "ispORegister";
    }

    /**
     * 立案调查审批信息
     * 
     * @return
     */
    public String ispORegister() {

        super.initalDocJson("立案审批表", object.getPunishobjectid());

        object = poregisterbasicMag.getObjectById(object.getPunishobjectid());

        if (StringUtils.isNotBlank(super.getModuleCode())
                && !"null".equals(super.getModuleCode())) {
            // 初始化页面form对应的actionName、提交方法以及保存方法名
            super.initalGenneralOpt("poregisterbasic", "submitIs", "saveIs");
            return super.generalOpt();
        }

        initalOptProcInfo();
        return "ispORegister";
    }

    /**
     * 保存立案调查审批信息
     * 
     * @return
     */
    public String saveIs() {
        try {
            Poregisterbasic dbobject = poregisterbasicMag.getObjectById(object
                    .getPunishobjectid());
            if (dbobject != null) {
                dbobject.copyNotNullProperty(object);
                if (!"B".equals(optProcInfo.getIdeacode())) {// 不是退回的
                    dbobject.setIspass(optProcInfo.getIdeacode());
                    if ("T".equals(optProcInfo.getIdeacode())) {
                        dbobject.setIfregister((long) 1);
                    } else {
                        dbobject.setIfregister((long) 0);
                    }
                }
                object = dbobject;
            }

            // 记录审批意见、办理人、时间
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            if ("cfla_jzsp".trim().equalsIgnoreCase(super.getFlowPhase())) {
                object.setFzrOption_la(optProcInfo.getTranscontent());
                object.setFzrOption_la(CodeRepositoryUtil.getValue("usercode",
                        loginInfo.getUsercode()));
                object.setFzrOption_latime(new Date(System.currentTimeMillis()));
            } else {
                object.setKsOption_la(optProcInfo.getTranscontent());
                object.setKs_la(CodeRepositoryUtil.getValue("usercode",
                        loginInfo.getUsercode()));
                object.setKsOption_latime(new Date(System.currentTimeMillis()));
            }

            poregisterbasicMag.saveObject(object);
            super.saveOpt();
            return "refreshTasks";
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存立案调查审批信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 提交立案调查科室审批信息
     * 
     * @return
     */
    public String submitIsKSPORegister() {
        try {
            this.saveIs();
            super.initalOptNewlyIdea((long) 0, "", (long) 4,
                    "/punish/poregisterbasic!initialAndApproval.do?punishobjectid="
                            + object.getPunishobjectid());
            return super.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交立案调查审批信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 提交立案调查审批信息
     * 
     * @return
     */
    public String submitIs() {
        try {
            this.saveIs();

            List<Potranslawbasic> list = potranslawbasicManager
                    .getPotranslawbasicsbyId(object.getPunishobjectid());
            if (list != null && list.size() > 0) {
                potranslawbasic = list.get(0);
                // 1、确定 案件编号、立案时间
                Punishobjectbasic dbobject = punishobjectbasicManager
                        .getObjectById(object.getPunishobjectid());
                if ("T".equals(object.getIspass())) {// 如果同意立案
                    dbobject.setPoregisterdate(new Date(System
                            .currentTimeMillis()));
                    // dbobject.setPunishobjectbrief(pcdef.getPunishclassname());
                    if (dbobject.getPunishobjectno() == null) {//
                        dbobject.setPunishobjectno(punishobjectbasicManager
                                .getNextAjbh());
                    }

                    // 保存案号：根据权力类型从格式文书案号管理处取出对应的文书格式。
                    if (StringUtils.isBlank(dbobject.getCaseno())) {
                        OptWritdef owf = optWritdefManager
                                .getObjectByTempType("6");// 6:处罚类
                        String caseNo = "";
                        if (owf != null) {
                            caseNo = this.getWritCodeByWritcodemodel(owf
                                    .getWritcode());
                        }
                        dbobject.setCaseno(caseNo);
                    }

                } else {
                    dbobject.setPunishobjectno("");
                }
                punishobjectbasicManager.saveObject(dbobject);
                super.initalOptNewlyIdea((long) 1, "案件初核与立案审批", (long) 5,
                        "/punish/poregisterbasic!initialAndApproval.do?punishobjectid="
                                + object.getPunishobjectid() + "&nodeInstId="
                                + curNodeInstId);

                // 2、生成调查终结报告基础数据
                Poindagaterepbasic dbpoindagateRepBasic = poindagaterepbasicManager
                        .getObjectById(dbobject.getPunishobjectid());
                if (dbpoindagateRepBasic == null) {
                    dbpoindagateRepBasic = new Poindagaterepbasic();
                    dbpoindagateRepBasic.setPunishobjectid(dbobject
                            .getPunishobjectid());
                    poindagaterepbasicManager.saveObject(dbpoindagateRepBasic);
                }
            }
            return super.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交立案调查审批信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 根据文书模版格式组装返回文书案号
     * 
     * @param writcodemodel
     * @return
     */
    private String getWritCodeByWritcodemodel(String writcodemodel) {
        String writCode = "";
        if (StringUtils.isNotBlank(writcodemodel)) {
            StringBuffer sb = new StringBuffer();

            writCode = writcodemodel;

            String codemodelLike = "";// 用于查询
            if (writCode.indexOf("$year$") != -1) {
                int first = writCode.indexOf("$year$");
                sb.append(writCode.substring(0, first));
                sb.append(DatetimeOpt.convertDateToString(
                        new Date(System.currentTimeMillis()), "").substring(0,
                        4));
                sb.append(writCode.substring(first + 6, writCode.length()));
                writCode = sb.toString();
                sb.delete(0, sb.length());
            }
            if (writCode.indexOf("$Y2$") != -1) {
                int first = writCode.indexOf("$Y2$");
                sb.append(writCode.substring(0, first));
                sb.append(DatetimeOpt
                        .convertDateToString(
                                new Date(System.currentTimeMillis()), "")
                        .substring(0, 4).substring(2));
                sb.append(writCode.substring(first + 4, writCode.length()));
                writCode = sb.toString();
                sb.delete(0, sb.length());
            }

            if (writCode.indexOf("$N") != -1) {
                int firstBegin = writCode.indexOf("$N");
                int firstEnd = firstBegin + 2;
                int secondBegin = writCode.indexOf("$", firstEnd);
                int nunber = Integer.parseInt(writCode.substring(firstEnd,
                        secondBegin));
                sb.append(writCode.substring(0, firstBegin));
                String zero = "";
                String model = "";
                for (int i = 0; i < nunber; i++) {
                    if (StringUtils.isBlank(model)) {
                        model = "_";
                    } else {
                        model = model + "_";
                    }
                    if (StringUtils.isBlank(zero)) {
                        zero = "0";
                    } else {
                        zero = zero + "0";
                    }
                }
                codemodelLike = sb.toString();
                // String codeModel = sb.toString()+ model+
                // writCode.substring(secondBegin + 1, writCode.length());
                int index = punishobjectbasicManager.getNumOfsameModel(
                        codemodelLike,
                        DatetimeOpt.convertDateToString(
                                new Date(System.currentTimeMillis()), "")
                                .substring(0, 4)) + 1;
                sb.append(this.endReplace(zero, String.valueOf(index))).append(
                        writCode.substring(secondBegin + 1, writCode.length()));
                writCode = sb.toString();
            }

        }
        return writCode;

    }

    private String endReplace(String str, String replace) {
        return replace == null || str == null ? str : str.substring(0,
                str.length() - replace.length())
                + replace;
    }

    /**
     * 初核与立案审批信息
     * 
     * @return
     */
    private List<OptStuffInfo> optStuffs;

    public List<OptStuffInfo> getOptStuffs() {
        return optStuffs;
    }

    public void setOptStuffs(List<OptStuffInfo> optStuffs) {
        this.optStuffs = optStuffs;
    }

    Vsuppowerinusing vsuppowerinusing;

    public String initialAndApproval() {
        String punishobjectid = object.getPunishobjectid();
        // String flowPhase=super.getFlowPhase();
        // Long nodeInstId=super.getNodeInstId();
        // 处罚项目类别信息
        potranslawbasic = potranslawbasicManager
                .getItem_idBypunishobjectid(punishobjectid);

        vsuppowerinusing = vsuppowerinusingManager
                .findB_PowerByItemId(potranslawbasic.getItem_id());
        // 立案基本信息
        object = poregisterbasicMag.getObjectById(object.getPunishobjectid());
        if (curNodeInstId != null) {
            if (optProcInfo == null) {
                optProcInfo = new OptProcInfo();
            }
            optProcInfo.setDjId(object.getPunishobjectid());
            optProcInfo.setNodeInstId(curNodeInstId);
            optStuffs = super.optProcInfoManager.getStuffInfoList(optProcInfo);
        }
        return "initialAndApproval";
    }

    // AJAX
    public String getpunishpbasis() throws IOException {
        String punishclassid = request.getParameter("punishclassid");
        Pcdef pcdef = this.pcdefManager.getObjectById(punishclassid);
        String punishbasis = pcdef.getPunishbasis();
        response.getWriter().write(punishbasis);
        return null;
    }

    public void setPunishobjectbasicManager(
            PunishobjectbasicManager punishobjectbasicManager) {
        this.punishobjectbasicManager = punishobjectbasicManager;
    }

    private PoindagaterepbasicManager poindagaterepbasicManager;

    public void setPoindagaterepbasicManager(
            PoindagaterepbasicManager poindagaterepbasicManager) {
        this.poindagaterepbasicManager = poindagaterepbasicManager;
    }

    public void setPoradixbasicManager(PoradixbasicManager poradixbasicManager) {
        this.poradixbasicManager = poradixbasicManager;
    }

    public void setPotranslawbasicManager(
            PotranslawbasicManager potranslawbasicManager) {
        this.potranslawbasicManager = potranslawbasicManager;
    }

    public void setPoregisterbasicManager(PoregisterbasicManager basemgr) {
        poregisterbasicMag = basemgr;
        this.setBaseEntityManager(poregisterbasicMag);
    }

    public Potranslawbasic getPotranslawbasic() {
        return potranslawbasic;
    }

    public String getBelonganyou() {
        return belonganyou;
    }

    public void setBelonganyou(String belonganyou) {
        this.belonganyou = belonganyou;
    }

    public void setOptWritdefManager(OptWritdefManager optWritdefManager) {
        this.optWritdefManager = optWritdefManager;
    }

    public void setPotranslawbasic(Potranslawbasic potranslawbasic) {
        this.potranslawbasic = potranslawbasic;
    }

    public void setVsuppowerinusingManager(
            VsuppowerinusingManager vsuppowerinusingManager) {
        this.vsuppowerinusingManager = vsuppowerinusingManager;
    }

    public Vsuppowerinusing getVsuppowerinusing() {
        return vsuppowerinusing;
    }

    public void setVsuppowerinusing(Vsuppowerinusing vsuppowerinusing) {
        this.vsuppowerinusing = vsuppowerinusing;
    }

}
