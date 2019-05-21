package com.centit.complaint.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.complaint.po.Complaint;
import com.centit.complaint.po.ComplaintsProcess;
import com.centit.complaint.po.ComplaintsResult;
import com.centit.complaint.service.ComplaintManager;
import com.centit.complaint.service.ComplaintsprocessManager;
import com.centit.complaint.service.ComplaintsresultManager;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.Punish;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.PunishManager;
import com.centit.powerruntime.action.GeneralOperatorAction;
import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.page.OptJspInfo;
import com.centit.supervise.po.SuperviseBasic;
import com.centit.supervise.po.SuperviseReply;
import com.centit.supervise.service.SuperviseBasicManager;
import com.centit.supervise.service.SuperviseReplyManager;
import com.centit.support.utils.UuidOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.FunctionManager;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.sample.po.WfFlowInstance;

/**
 * 
 * 投诉处理通用类
 * 
 * @author ljy
 * @create 2013-6-3
 * @version
 */
public class ComplaintTasksExecuteAction extends
        PowerRuntimeEntityAction<ComplaintsProcess> implements
        ServletResponseAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    HttpServletResponse response;
    private String transidea;
    private OptJspInfo jspInfo;
    private ComplaintManager complaintManager;
    private ComplaintsprocessManager complaintsprocessManager;
    private ComplaintsresultManager complaintsresultManager;
    private SysUserManager sysUserManager;
    private SysUnitManager SysUnitManager;
    private FunctionManager functionManager;
    private SuperviseBasicManager superviseBasicManager;
    private SuperviseReplyManager superviseReplyManager;
    private ApplyManager applyManager;
    private PunishManager punishManager;

    public void setApplyManager(ApplyManager applyManager) {
        this.applyManager = applyManager;
    }

    public void setPunishManager(PunishManager punishManager) {
        this.punishManager = punishManager;
    }

    /**
     * 投诉受理
     * 
     * @return
     */
    public String acceptComplaint() {
        Complaint complaint = complaintManager.getComplaintByFlowId(super
                .getFlowInstId());
        if (complaint == null) {
            this.postAlertMessage("操作失败，原因可能是投诉办件不存在！", response);
            return null;
        }
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/complaint/complaint!acceptComplaint.do?complaintid="
                        + complaint.getComplaintid()
                        + "&djId="
                        + complaint.getComplaintid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId() + "&moduleCode=" + moduleCode);
        frameList.add(viewFrameInfo);
        this.setFrameList(frameList, "投诉受理");

        return "optframe";
    }

    /**
     * 审批投诉受理
     * 
     * @return
     */
    public String isAcceptComplaint() {
        Complaint complaint = complaintManager.getComplaintByFlowId(super
                .getFlowInstId());
        if (complaint == null) {
            this.postAlertMessage("操作失败，原因可能是投诉办件不存在！", response);
            return null;
        }
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/complaint/complaint!isAcceptComplaint.do?complaintid="
                        + complaint.getComplaintid()
                        + "&djId="
                        + complaint.getComplaintid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId() + "&moduleCode=" + moduleCode);
        frameList.add(viewFrameInfo);
        this.setFrameList(frameList, "审批投诉受理");

        return "optframe";
    }

    /**
     * 调查结论
     * 
     * @return
     */
    public String complaintResult() {
        Complaint complaint = complaintManager.getComplaintByFlowId(super
                .getFlowInstId());
        if (complaint == null) {
            this.postAlertMessage("操作失败，原因可能是投诉办件不存在！", response);
            return null;
        }
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/complaint/complaint!complaintResult.do?complaintid="
                        + complaint.getComplaintid()
                        + "&djId="
                        + complaint.getComplaintid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId() + "&moduleCode=" + moduleCode);
        frameList.add(viewFrameInfo);
        this.setFrameList(frameList, "调查结论");

        return "optframe";
    }

    public String complaintBack() {
        Complaint complaint = complaintManager.getComplaintByFlowId(super
                .getFlowInstId());
        if (complaint == null) {
            this.postAlertMessage("操作失败，原因可能是投诉办件不存在！", response);
            return null;
        }
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/complaint/complaint!complaintBack.do?complaintid="
                        + complaint.getComplaintid()
                        + "&djId="
                        + complaint.getComplaintid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId() + "&moduleCode=" + moduleCode);
        frameList.add(viewFrameInfo);
        this.setFrameList(frameList, "反馈投诉人");

        return "optframe";
    }

    /**
     * 生成通用Frame框架
     * 
     * @return
     */
    public String generalOptFrame() {
        // 根据工作流程实例号获得投诉基本信息
        Complaint complaint = complaintManager.getComplaintByFlowId(super
                .getFlowInstId());

        if (complaint == null) {
            this.postAlertMessage("操作失败，原因可能是投诉办件不存在！", response);
            return null;
        }

        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        OptHtmlFrameInfo transFrameInfo = new OptHtmlFrameInfo();
        transFrameInfo.setFrameId("transFrame");
        transFrameInfo
                .setFrameSrc("/complaint/complaint!generCommonTrans.do?complaintid="
                        + complaint.getComplaintid()
                        + "&djId="
                        + complaint.getComplaintid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId() + "&moduleCode=" + moduleCode);

        // 框架主控操作
        // super.setModuleParam(generalModuleParamManager.getObjectById(moduleCode));
        frameList.add(transFrameInfo);
        this.setFrameList(frameList, "投诉办理");
        return "optframe";
    }

    /**
     * 生成通用办理界面
     * 
     * @return
     */
    public String generCommonTrans() {

        try {
            moduleParam = generalModuleParamManager.getObjectById(moduleCode);//
            // TODO 判断是 新建 还是更新
            if (object == null)
                object = new ComplaintsProcess();

            /**
             * 获得办件角色人名单,根据参数是否需要 办件人员
             */
            super.initTeamUsersConfig();

        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "通用配置功能出错，请检查各配置项是否准确。");
            return ERROR;
        }
        return "optTrans";
    }

    /**
     * 查看或者编辑业务信息FRAME
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getBizInfoFrame(String djid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewFrame");
        viewFrameInfo
                .setFrameSrc("/complaint/complaint!viewBizInfo.do?complaintid="
                        + djid);
        return viewFrameInfo;
    }

    /**
     * 查看过程信息
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getProcFrame(String complaintId) {
        OptHtmlFrameInfo procFrameInfo = new OptHtmlFrameInfo();
        procFrameInfo.setFrameId("procFrame");
        procFrameInfo
                .setFrameSrc("/complaint/complaintsprocess!viewList.do?complaintId="
                        + complaintId + "&flowInstId=" + super.getFlowInstId());
        procFrameInfo.setFrameHeight("300px");
        return procFrameInfo;
    }

    /**
     * 公用部分
     * 
     * @param frameList
     * @param moduleDesc
     * @return
     */
    private void setFrameList(List<OptHtmlFrameInfo> frameList,
            String moduleDesc) {
        Complaint complaint = complaintManager.getComplaintByFlowId(super
                .getFlowInstId());
        frameList.add(getBizInfoFrame(complaint.getComplaintid()));// 查看投诉信息FRAME
        frameList.add(getProcFrame(complaint.getComplaintid())); // 过程信息
        frameList.add(GeneralOperatorAction.getStuffListFrame(complaint
                .getComplaintid()));

        jspInfo = new OptJspInfo();
        jspInfo.setTitle(moduleDesc);
        jspInfo.setFrameList(frameList);
    }

    /**
     * 保存投诉过程信息
     * 
     * @return
     */
    public void saveComplaintProcess() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            NodeInstance nit = flowEngine.getNodeInstById(object
                    .getNodeInstId());
            FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());
            ComplaintsProcess complaintsProcess = complaintsprocessManager
                    .getObjectById(object.getNodeInstId());
            if (complaintsProcess != null) {
                complaintsProcess.copyNotNullProperty(object);
                object = complaintsProcess;
            } else {
                object.setProcessNo(UuidOpt.getUuidAsString());
            }
            // object.setComplaintId(object.getComplaintId());
            // complaintsProcess.setProcessCode("tsdj");
            object.setProcessName(fif.getNodeName());
            object.setProcessDate(new Date());
            object.setOperatorId(fuser.getUsercode());
            object.setOperatorName(fuser.getUsername());
            object.setOperatorResult(transidea);
            complaintsprocessManager.saveObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String submitAcceptComplaint() {
        // 1、更新基本信息表——投诉反馈时间
        Complaint complaint = complaintManager.getObjectById(object
                .getComplaintId());
        complaint.setPromise_Date(promisedate);
        complaintManager.saveObject(complaint);
        return this.submitOpt();
    }

    /**
     * 提交投诉受理同时发起督办子流程
     * 
     * @return
     */
    public String submitIsAcceptComplaint() {

        // 1、处理
        if ("F".equals(object.getOperatorResult())) {
            Map<String, Object> filtermap = new HashMap<String, Object>();
            filtermap.put("complaintid", object.getComplaintId());
            List<ComplaintsResult> l = this.complaintsresultManager
                    .listObjects(filtermap);
            ComplaintsResult cr = new ComplaintsResult();
            FUserDetail fuser = (FUserDetail) getLoginUser();
            FUserunit funit = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            FUnitinfo unitinfo = SysUnitManager.getObjectById(funit
                    .getUnitcode());
            String depno = unitinfo.getDepno();
            if (l.size() > 0) {
                cr = l.get(0);
                cr.setType("0");// 不予受理
            } else {
                String nextno = this.complaintsresultManager
                        .getNextComplaintNo(depno);
                cr.setComplaintid(object.getComplaintId());
                cr.setType("0");
                cr.setNo(nextno);
                cr.setResultDate(new Date(System.currentTimeMillis()));
                // cr.setUpdateDate(new Date(System.currentTimeMillis()));
                cr.setOpinion(object.getOperatorOpinion());
                cr.setOperatorId(fuser.getUsercode());
                cr.setOperatorName(fuser.getUsername());
            }
            this.complaintsresultManager.saveObject(cr);
        }
        // 2、提交
        Set<Long> noid = super.submitNode();

        // 保存过程日志信息
        saveComplaintProcess();
        // 保存办件人员
        this.saveTeamRolepeople();
        String operatorResult = "";
        if (object.getOperatorResult() == null) {
            operatorResult = request.getParameter("operatorResult");
        } else {
            operatorResult = object.getOperatorResult();
        }
        if ("D".equals(operatorResult)) {
            // 督办子流程
            if (noid != null && noid.size() > 0) {
                Long prenodeinstid = noid.iterator().next();
                //
                this.createDBflowInst(prenodeinstid);
            }
        }
        return super.nextStep();
    }

    private String optId;
    private String isOrg;
    private String superviseDetail;
    private Date promisedate;

    /**
     * 投诉流程：发起督办子流程
     * 
     * @param prenodeinstid
     */
    private void createDBflowInst(Long prenodeinstid) {
        // 1、
        FUserDetail fuser = (FUserDetail) getLoginUser();
        FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser.getUsercode());
        NodeInstance nodeInst = flowEngine.getNodeInstById(prenodeinstid);// 投诉流程
        // 2、新增发起督办
        /*********************** 保存督办业务信息BEGIN *****************************************/
        SuperviseBasic superviseBasic = new SuperviseBasic();
        superviseBasic.setSuperviseNo(superviseBasicManager.getNextkey());
        superviseBasic.setBjType("3");// 督办类型为投诉
        superviseBasic.setComplaintid(object.getComplaintId());
        Complaint complaint = complaintManager.getObjectById(object
                .getComplaintId());
        switch (Integer.parseInt(complaint.getBjType())) {
        case 1:
            Apply apply = applyManager.getApplyInfo(complaint.getBjNo());
            superviseBasic.setMonitorOrgName(apply.getDepartment());
            superviseBasic.setMonitorOrgId(apply.getOrgId());
            break;
        default:
            Punish punish = punishManager.getPunishInfo(complaint.getBjNo());
            superviseBasic.setMonitorOrgName(punish.getDepartment());
            superviseBasic.setMonitorOrgId(punish.getOrgId());
            break;
        }
        superviseBasic.setBjNo(complaint.getBjNo());
        superviseBasic.setFlowInstId(nodeInst.getSubFlowInstId());// 根据父流程(投诉流程)获取子流程(督办子流程)实例
        superviseBasic.setBizType("T");
        superviseBasic.setCreateUser(fuser.getUsercode());
        superviseBasic.setCreateDate(new Date(System.currentTimeMillis()));
        superviseBasic.setOperatorId(fuser.getUsercode());
        superviseBasic.setOperatorName(fuser.getUsername());
        superviseBasic.setOrgId(SysUnitManager
                .getObjectById(dept.getUnitcode()).getDepno());
        superviseBasic.setSuperviseDate(new Date());
        if (promisedate != null) {
            superviseBasic.setPromisedate(promisedate);
        } else {
            superviseBasic.setPromisedate(new Date(System.currentTimeMillis()
                    + (long) 5 * 24 * 60 * 60 * 1000));
        }
        superviseBasic.setSuperviseDetail(superviseDetail);
        superviseBasic.setIsOrg(isOrg);// 此项为必须
        superviseBasic.setSuperviseOption(object.getOperatorOpinion());// 此项为必须
        superviseBasic.setOptId(optId);// 此项为必须
        // 备注说明：此处不计入发起督办时间，需要领导审核同意督办意见后在计入；
        // 保存
        superviseBasicManager.saveObject(superviseBasic);
        /*********************** 保存督办业务信息END *****************************************/

        // 根据子流程获取流程实例
        WfFlowInstance dbflowINST = (WfFlowInstance) flowEngine
                .getFlowInstById(nodeInst.getSubFlowInstId());
        // 3、提交时生成督办过程信息
        SuperviseReply supervisereply = superviseReplyManager
                .getObjectById(String.valueOf(dbflowINST.getFirstNodeInstance()
                        .getNodeInstId()));
        if (supervisereply == null) {
            supervisereply = new SuperviseReply();
            supervisereply.setNodeInstId(dbflowINST.getFirstNodeInstance()
                    .getNodeInstId());
        }
        supervisereply.setProcessNo(UuidOpt.getUuidAsString());
        supervisereply.setSuperviseNo(superviseBasic.getSuperviseNo());
        supervisereply.setProcessName("督办发起");
        supervisereply.setProcessDate(new Date());
        supervisereply.setOperatorId(fuser.getUsercode());
        supervisereply.setOperatorName(fuser.getUsername());
        supervisereply.setUpdateDate(new Date(System.currentTimeMillis()));
        supervisereply.setOperatorResult("督办发起");
        supervisereply.setOperatorOpinion(object.getOperatorOpinion());// 督办建议...
        superviseReplyManager.saveObject(supervisereply);

    }

    /**
     * 提交调查结论
     * 
     * @return
     */
    public String submitComplaintResult() {
        // 1、处理
        // 获得结果信息
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("complaintid", object.getComplaintId());
        List<ComplaintsResult> l = this.complaintsresultManager
                .listObjects(filtermap);
        ComplaintsResult complaintsresult = new ComplaintsResult();
        FUserDetail fuser = (FUserDetail) getLoginUser();
        FUserunit funit = sysUserManager
                .getUserPrimaryUnit(fuser.getUsercode());
        FUnitinfo unitinfo = SysUnitManager.getObjectById(funit.getUnitcode());
        String depno = unitinfo.getDepno();
        if (l.size() > 0) {
            complaintsresult = l.get(0);
        } else {
            String nextno = this.complaintsresultManager
                    .getNextComplaintNo(depno);
            complaintsresult.setComplaintid(object.getComplaintId());
            complaintsresult.setNo(nextno);
        }
        complaintsresult.setType(object.getOperatorResult());
        complaintsresult.setResultDate(new Date(System.currentTimeMillis()));
        // complaintsresult.setUpdateDate(new Date(System.currentTimeMillis()));
        complaintsresult.setOpinion(object.getOperatorOpinion());
        complaintsresult.setOperatorId(fuser.getUsercode());
        complaintsresult.setOperatorName(fuser.getUsername());
        if ("2".equals(object.getOperatorResult())) {// 如果属实的情况
            Complaint complaint = complaintManager.getObjectById(object
                    .getComplaintId());
            complaintsresult.setDetail(complaint.getComplaintsType());
        }
        this.complaintsresultManager.saveObject(complaintsresult);
        // 2、
        Complaint complaint = complaintManager.getObjectById(object
                .getComplaintId());
        complaint.setComplaintsType(object.getOperatorResult());
        complaintManager.saveObject(complaint);
        // 3、提交
        return this.submitOpt();
    }

    /**
     * 提交反馈投诉人
     * 
     * @return
     */
    public String submitComplaintBack() {
        // 1、处理
        // 获得结果信息
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("complaintid", object.getComplaintId());
        List<ComplaintsResult> l = this.complaintsresultManager
                .listObjects(filtermap);
        ComplaintsResult complaintsresult = new ComplaintsResult();
        FUserDetail fuser = (FUserDetail) getLoginUser();
        FUserunit funit = sysUserManager
                .getUserPrimaryUnit(fuser.getUsercode());
        FUnitinfo unitinfo = SysUnitManager.getObjectById(funit.getUnitcode());
        String depno = unitinfo.getDepno();
        if (l.size() > 0) {
            complaintsresult = l.get(0);
        } else {
            String nextno = this.complaintsresultManager
                    .getNextComplaintNo(depno);
            complaintsresult.setComplaintid(object.getComplaintId());
            complaintsresult.setNo(nextno);
        }
        // 更新4个反馈字段
        complaintsresult.setCobackResult(object.getOperatorResult());
        complaintsresult.setCobackDate(new Date(System.currentTimeMillis()));
        complaintsresult.setCobackRemark(object.getOperatorOpinion());
        complaintsresult.setCobackoperatorId(fuser.getUsercode());

        this.complaintsresultManager.saveObject(complaintsresult);
        // 更新投诉基本信息表
        Complaint co = this.complaintManager.getObjectById(object
                .getComplaintId());
        co.setBiztype("C");// 办结状态位 C
        complaintManager.saveObject(co);

        // 2、提交
        return this.submitOpt();
    }

    /**
     * 提交投诉受理
     * 
     * @return
     */
    public String submitOpt() {
        // 保存关注人员
        // saveAtt();
        submitNode();
        // 保存过程日志信息
        saveComplaintProcess();
        // 保存办件人员
        this.saveTeamRolepeople();

        return this.nextStep();
    }

    private String teamRoles;

    /**
     * 保存办件人员
     */
    public void saveTeamRolepeople() {
        try {
            // flowEngine.deleteFlowWorkTeam(super.getFlowInstId(),"ajjbr");
            NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId);
            if (!StringUtils.isBlank(teamRoles)) {
                String[] teamRole = teamRoles.split(",");
                if (teamRole.length > 0) {
                    for (String a : teamRole) {
                        flowEngine.assignFlowWorkTeam(nit.getFlowInstId(),
                                "jbr", a);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setComplaintManager(ComplaintManager complaintManager) {
        this.complaintManager = complaintManager;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        
        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * 弹出提示信息
     * 
     * @param msg
     * @param response
     */
    protected void postAlertMessage(String msg, HttpServletResponse response) {

        String alertCoding = "GBK";

        ServletOutputStream sos;
        String str = "<script language=\"JavaScript\""
                + " type=\"text/JavaScript\" charset=\"" + alertCoding + "\">"
                + "javascript:alert('" + msg + "');history.back(-1);"
                + " </script>";

        response.setContentType("text/html; charset=" + alertCoding);
        try {
            sos = response.getOutputStream();
            int strSize = (int) str.length();
            byte[] b = new byte[strSize];
            b = str.getBytes();
            sos.write(b);
            sos.flush();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public OptJspInfo getJspInfo() {
        return jspInfo;
    }

    public void setJspInfo(OptJspInfo jspInfo) {
        this.jspInfo = jspInfo;
    }

    public void setComplaintsprocessManager(
            ComplaintsprocessManager complaintsprocessManager) {
        this.complaintsprocessManager = complaintsprocessManager;
    }

    public String getTeamRoles() {
        return teamRoles;
    }

    public void setTeamRoles(String teamRoles) {
        this.teamRoles = teamRoles;
    }

    public String getTransidea() {
        return transidea;
    }

    public void setTransidea(String transidea) {
        this.transidea = transidea;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public ComplaintsresultManager getComplaintsresultManager() {
        return complaintsresultManager;
    }

    public void setComplaintsresultManager(
            ComplaintsresultManager complaintsresultManager) {
        this.complaintsresultManager = complaintsresultManager;
    }

    public void setSuperviseBasicManager(
            SuperviseBasicManager superviseBasicManager) {
        this.superviseBasicManager = superviseBasicManager;
    }

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    public void setSuperviseReplyManager(
            SuperviseReplyManager superviseReplyManager) {
        this.superviseReplyManager = superviseReplyManager;
    }

    public String getIsOrg() {
        return isOrg;
    }

    public void setIsOrg(String isOrg) {
        this.isOrg = isOrg;
    }

    public String getSuperviseDetail() {
        return superviseDetail;
    }

    public void setSuperviseDetail(String superviseDetail) {
        this.superviseDetail = superviseDetail;
    }

    public FunctionManager getFunctionManager() {
        return functionManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        SysUnitManager = sysUnitManager;
    }

    public Date getPromisedate() {
        return promisedate;
    }

    public void setPromisedate(Date promisedate) {
        this.promisedate = promisedate;
    }

}
