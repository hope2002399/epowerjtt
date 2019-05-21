package com.centit.supervise.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.complaint.po.ComplaintsProcess;
import com.centit.complaint.po.ComplaintsResult;
import com.centit.complaint.service.ComplaintsprocessManager;
import com.centit.complaint.service.ComplaintsresultManager;
import com.centit.powerruntime.action.GeneralOperatorAction;
import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.page.OptJspInfo;
import com.centit.supervise.po.SuperviseBasic;
import com.centit.supervise.po.SuperviseReply;
import com.centit.supervise.po.SuperviseResult;
import com.centit.supervise.service.SuperviseBasicManager;
import com.centit.supervise.service.SuperviseReplyManager;
import com.centit.supervise.service.SuperviseResultManager;
import com.centit.support.utils.UuidOpt;
import com.centit.sys.security.FUserDetail;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.sample.po.WfFlowInstance;

/**
 * 
 * 督办处理通用类
 * 
 * @author ljy
 * @create 2013-6-3
 * @version
 */
public class SuperviseTasksExecuteAction extends
        PowerRuntimeEntityAction<SuperviseReply> implements
        ServletResponseAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    HttpServletResponse response;
    private OptJspInfo jspInfo;
    private String transidea;
    // private SysUserManager sysUserManager;
    // private SysUnitManager SysUnitManager;

    private SuperviseBasicManager superviseBasicManager;
    private SuperviseReplyManager superviseReplyManager;
    private SuperviseResultManager superviseResultManager;
    private ComplaintsprocessManager complaintsprocessManager;

    /************************ 以下为主流程入口 ***************************/

    /**
     * 生成通用Frame框架
     * 
     * @return
     */
    public String generalOptFrame() {
        return this.generalOptFrame("generCommonTrans", "督察督办通用办理");
    }

    /**
     * 定量分析经办人反馈
     * 
     * @return
     */
    public String superviseBack() {
        return this.generalOptFrame("superviseBack", "经办人反馈");
    }

    /**
     * 督办意见审核
     * 
     * @return
     */
    public String isSupervise() {
        return this.generalOptFrame("isSupervise", "督办意见审核");
    }

    /**
     * 发出督办意见
     * 
     * @return
     */
    public String sendSupervise() {
        return this.generalOptFrame("sendSupervise", "发出督办意见");
    }

    /**
     * 重拟督办
     * 
     * @return
     */
    public String reconstructSupervise() {
        return this.generalOptFrame("reconstructSupervise", "重拟督办");
    }

    /**
     * 答复
     * 
     * @return
     */
    public String replySupervise() {
        return this.generalOptFrame("replySupervise", "督办答复");
    }

    /**
     * 单位接收督办
     * 
     * @return
     */
    public String receivesSupervise() {
        return this.generalOptFrame("receivesSupervise", "单位接收督办");
    }

    /**
     * 领导分办
     * 
     * @return
     */
    public String pointsToDoSupervise() {
        return this.generalOptFrame("pointsToDoSupervise", "领导分办");
    }

    /**
     * 审核答复
     * 
     * @return
     */
    public String isReplySupervise() {
        return this.generalOptFrame("isReplySupervise", "审核督办答复");
    }

    /**
     * 督办结论
     * 
     * @return
     */
    public String superviseResult() {
        return this.generalOptFrame("superviseResult", "督办结论");
    }

    /**
     * 督办结论
     * 
     * @return
     */
    public String superviseResult_CJ() {
        return this.generalOptFrame("superviseResultDlfx", "督办结论");
    }

    /**
     * 定量分析督办结论
     * 
     * @return
     */
    public String superviseResultDlfx() {
        return this.generalOptFrame("superviseResultDlfx", "督办结论");
    }

    /**
     * 审核督办结论
     * 
     * @return
     */
    public String isSuperviseResult() {
        return this.generalOptFrame("isSuperviseResult", "审核督办结论");
    }

    /**
     * 流程操作方法整合
     * 
     * @param optMethod
     *            操作方法
     * @param nodeName
     *            节点名称:缺省情况下为流程节点名称,反之，自定义名称
     * @return
     */
    public String generalOptFrame(String optMethod, String nodeName) {
        if (StringUtils.isBlank(optMethod)) {
            optMethod = "generCommonTrans";
        }
        if (StringUtils.isBlank(nodeName)) {
            NodeInstance nit = flowEngine.getNodeInstById(object
                    .getNodeInstId());
            FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());
            nodeName = fif.getNodeName();
        }
        SuperviseBasic superviseBasic = superviseBasicManager
                .getSuperviseBasicByFlowId(super.getFlowInstId());
        if (superviseBasic == null) {
            this.postAlertMessage("操作失败，原因可能是督办办件不存在！", response);
            return null;
        }
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        OptHtmlFrameInfo transFrameInfo = new OptHtmlFrameInfo();
        transFrameInfo.setFrameId("transFrame");

        transFrameInfo.setFrameSrc("/supervise/superviseBasic!" + optMethod
                + ".do?superviseNo=" + superviseBasic.getSuperviseNo()
                + "&djId=" + superviseBasic.getSuperviseNo() + "&flowInstId="
                + super.getFlowInstId() + "&nodeInstId="
                + object.getNodeInstId() + "&moduleCode=" + moduleCode
                + "&documentTemplateIds=" + documentTemplateIds);
        frameList.add(transFrameInfo);
        // 框架主控操作
        super.setModuleParam(generalModuleParamManager
                .getObjectById(moduleCode));

        this.setFrameList(frameList, nodeName);

        return "optframe";
    }

    /************************ 以下为流程节点提交 ***************************/

    /**
     * 提交督办意见审核
     * 
     * @return
     */
    public String submitIsSupervise() {
        // todo 处理业务信息的方法
        SuperviseBasic superviseBasic = superviseBasicManager
                .getObjectById(object.getSuperviseNo());
        if ("T".equals(object.getOperatorResult())) {// 如果审核通过，此处计入督办发起时间
            superviseBasic
                    .setSuperviseDate(new Date(System.currentTimeMillis()));
        }
        superviseBasicManager.saveObject(superviseBasic);
        // 提交
        return this.submitOpt();
    }

    /**
     * 提交定量分析经办人反馈信息
     * 
     * @return
     */
    public String submitSuperviseBack() {
        // todo 处理业务信息的方法
        SuperviseBasic superviseBasic = superviseBasicManager
                .getObjectById(object.getSuperviseNo());
        // if("T".equals(object.getOperatorResult())){//如果审核通过，此处计入督办发起时间
        superviseBasic.setSuperviseDate(new Date(System.currentTimeMillis()));
        // }
        superviseBasicManager.saveObject(superviseBasic);
        // 提交
        return this.submitOpt();
    }

    /**
     * 提交发出督办意见
     * 
     * @return
     */
    public String submitSendSupervise() {
        // todo 处理业务信息的方法

        // 提交
        return this.submitOpt();
    }

    /**
     * 提交重拟督办
     * 
     * @return
     */
    public String submitReconstructSupervise() {
        // todo 处理业务信息的方法
        SuperviseBasic superviseBasic = superviseBasicManager
                .getObjectById(object.getSuperviseNo());
        superviseBasic.setSuperviseOption(object.getOperatorOpinion());
        superviseBasicManager.saveObject(superviseBasic);
        // 提交
        return this.submitOpt();
    }

    /**
     * 提交答复
     * 
     * @return
     */
    public String submitReplySupervise() {
        // todo 处理业务信息的方法
        // 记录督办答复内容：
        SuperviseResult superviseResult = superviseResultManager
                .getSuperviseResultBySuperviseNo(object.getSuperviseNo());
        if (superviseResult == null) {
            superviseResult = new SuperviseResult();
            superviseResult.setNo(superviseResultManager.getNextKeyId());
        }
        superviseResult.setSuperviseNo(object.getSuperviseNo());
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        superviseResult.setBackOperatorId(fuser.getUsercode());
        superviseResult.setBackOperatorName(fuser.getUsername());
        superviseResult.setSuperviseBack(object.getOperatorOpinion());
        superviseResult.setReceiptDate(new Date(System.currentTimeMillis()));// 此处暂时记录时间,以审核答复的时间为最后时间

        superviseResultManager.saveObject(superviseResult);

        // 提交
        return this.submitOpt();
    }

    /**
     * 提交单位接收督办
     * 
     * @return
     */
    public String submitReceivesSupervise() {
        // todo 处理业务信息的方法

        // 提交
        return this.submitOpt();
    }

    /**
     * 提交领导分办
     * 
     * @return
     */
    public String submitPointsToDoSupervise() {
        // todo 处理业务信息的方法

        // 提交
        return this.submitOpt();
    }

    /**
     * 提交审核答复
     * 
     * @return
     */
    public String submitIsReplySupervise() {
        // todo 处理业务信息的方法
        // 记录督办答复内容：
        SuperviseResult superviseResult = superviseResultManager
                .getSuperviseResultBySuperviseNo(object.getSuperviseNo());
        if (superviseResult == null) {
            superviseResult = new SuperviseResult();
            superviseResult.setNo(superviseResultManager.getNextKeyId());
            superviseResult.setSuperviseNo(object.getSuperviseNo());
        }
        superviseResult.setReceiptDate(new Date(System.currentTimeMillis()));// 此处以审核答复的时间为最后时间
        superviseResultManager.saveObject(superviseResult);
        // 提交
        return this.submitOpt();
    }

    private String confirm;
    private Long isExternal;

    /**
     * 提交督办结论
     * 
     * @return
     */
    public String submitSuperviseResult() {
        // todo 处理业务信息的方法
        // 记录督办结论内容：
        SuperviseResult superviseResult = superviseResultManager
                .getSuperviseResultBySuperviseNo(object.getSuperviseNo());
        if (superviseResult == null) {
            superviseResult = new SuperviseResult();
            superviseResult.setNo(superviseResultManager.getNextKeyId());
            superviseResult.setSuperviseNo(object.getSuperviseNo());
        }
        if (!"T".equals(object.getOperatorResult())) {
            confirm = "";
            isExternal = null;
        }
        superviseResult.setConfirm(confirm);
        superviseResult.setIsExternal(isExternal);
        superviseResult.setSuperviseResult(object.getOperatorOpinion());
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        superviseResult.setEndoperatorid(fuser.getUsercode());
        superviseResultManager.saveObject(superviseResult);

        // 提交
        return this.submitOpt();
    }

    /**
     * 提交督办结论
     * 
     * @return
     */
    private ComplaintsresultManager complaintsresultManager;

    public void setComplaintsresultManager(
            ComplaintsresultManager complaintsresultManager) {
        this.complaintsresultManager = complaintsresultManager;
    }

    public String submitSuperviseResultDlfx() {
        // todo 处理业务信息的方法
        // 记录督办结论内容：
        SuperviseResult superviseResult = superviseResultManager
                .getSuperviseResultBySuperviseNo(object.getSuperviseNo());
        if (superviseResult == null) {
            superviseResult = new SuperviseResult();
            superviseResult.setNo(superviseResultManager.getNextKeyId());
            superviseResult.setSuperviseNo(object.getSuperviseNo());
        }
        superviseResult.setConfirm(confirm);
        superviseResult.setIsExternal(isExternal);
        superviseResult.setSuperviseResult(object.getOperatorOpinion());
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        superviseResult.setEndoperatorid(fuser.getUsercode());
        superviseResult.setEndDate(new Date(System.currentTimeMillis()));
        superviseResult.setEndOpinion(object.getOperatorOpinion());
        // superviseResultManager.saveObject(superviseResult);
        // 更新基础信息状态：
        SuperviseBasic superviseBasic = superviseBasicManager
                .getObjectById(object.getSuperviseNo());
        superviseBasic.setBizType("C");// 已办结
        superviseBasicManager.saveObject(superviseBasic);
        superviseResultManager.saveObject(superviseResult);
        if (null != superviseBasic.getComplaintid()) {
            ComplaintsResult complaintsresult = complaintsresultManager
                    .getObjectByComplaintsId(superviseBasic.getComplaintid());
            if (null == complaintsresult) {
                complaintsresult = new ComplaintsResult();
                complaintsresult
                        .setComplaintid(superviseBasic.getComplaintid());
                complaintsresult.setNo(complaintsprocessManager.getNextKey());
            }
            complaintsresult.setType(request.getParameter("confirm"));
            complaintsresult
                    .setResultDate(new Date(System.currentTimeMillis()));
            complaintsresult.setOpinion(object.getOperatorOpinion());
            complaintsresult.setOperatorId(fuser.getUsercode());
            complaintsresult.setOperatorName(fuser.getUsername());
            if ("2".equals(request.getParameter("confirm"))) {// 如果属实的情况
                complaintsresult.setDetail(complaintsresultManager
                        .getDetailByid(superviseBasic.getComplaintid()));
            }
            complaintsresultManager.saveObject(complaintsresult);
            WfFlowInstance flowInst = (WfFlowInstance) flowEngine
                    .getFlowInstById(super.getFlowInstId());
            if ("T".equals(request.getParameter("operatorResult"))
                    && flowInst != null && flowInst.getPreNodeInstId() != 0) {
                // 督办子流程
                this.runBeforeSubmit(flowInst);
            }
        }
        // 提交
        return this.submitOpt();
    }

    /**
     * 提交 审核督办结论
     * 
     * @return
     */
    public String submitIsSuperviseResult() {
        // todo 处理业务信息的方法
        if ("T".equals(object.getOperatorResult())) {
            // 记录督办结论内容：
            SuperviseResult superviseResult = superviseResultManager
                    .getSuperviseResultBySuperviseNo(object.getSuperviseNo());
            if (superviseResult == null) {
                superviseResult = new SuperviseResult();
                superviseResult.setNo(superviseResultManager.getNextKeyId());
                superviseResult.setSuperviseNo(object.getSuperviseNo());
            }
            superviseResult.setEndDate(new Date(System.currentTimeMillis()));
            superviseResult.setEndOpinion(object.getOperatorOpinion());
            superviseResultManager.saveObject(superviseResult);

            // 更新基础信息状态：
            SuperviseBasic superviseBasic = superviseBasicManager
                    .getObjectById(object.getSuperviseNo());
            superviseBasic.setBizType("C");// 已办结
            superviseBasicManager.saveObject(superviseBasic);
        }
        // 判断是否是子流程
        WfFlowInstance flowInst = (WfFlowInstance) flowEngine
                .getFlowInstById(super.getFlowInstId());
        if ("T".equals(request.getParameter("operatorResult"))
                && flowInst != null && flowInst.getPreNodeInstId() != 0) {
            // 督办子流程
            this.runBeforeSubmit(flowInst);
        }
        // 提交
        return this.submitOpt();
    }

    /**
     * 
     * @param flowInst
     *            流程实例
     */
    private void runBeforeSubmit(WfFlowInstance flowInst) {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            // 获取投诉节点实例
            NodeInstance nodeInstance = flowEngine.getNodeInstById(flowInst
                    .getPreNodeInstId());
            FlowNodeInfo fif = flowEngine.getNodeInfoById(nodeInstance
                    .getNodeId());

            ComplaintsProcess complaintsProcess = complaintsprocessManager
                    .getObjectById(flowInst.getPreNodeInstId());
            if (complaintsProcess == null) {
                complaintsProcess = new ComplaintsProcess();
                SuperviseBasic superviseBasic = superviseBasicManager
                        .getObjectById(object.getSuperviseNo());
                complaintsProcess.setComplaintId(superviseBasic
                        .getComplaintid());
                complaintsProcess.setNodeInstId(flowInst.getPreNodeInstId());
                complaintsProcess.setProcessNo(UuidOpt.getUuidAsString());
            }
            complaintsProcess.setProcessName(fif.getNodeName());// 当前此节点在投诉流程中的节点名称
            complaintsProcess.setProcessDate(new Date());
            complaintsProcess.setOperatorId(fuser.getUsercode());
            complaintsProcess.setOperatorName(fuser.getUsername());
            complaintsProcess.setOperatorResult(transidea);
            SuperviseResult superviseResult = superviseResultManager
                    .getSuperviseResultBySuperviseNo(object.getSuperviseNo());
            complaintsProcess.setOperatorOpinion(superviseResult
                    .getSuperviseResult());// 督办结论作为 过程办理信息 传值到投诉流程
            complaintsprocessManager.saveObject(complaintsProcess);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交投诉办理
     * 
     * @return
     */
    public String submitOpt() {
        //
        submitNode();
        // 保存过程日志信息
        saveSuperviseReply();

        // 保存办件人员
        this.saveTeamRolepeople();

        return this.nextStep();
    }

    /**
     * 保存督办过程信息
     * 
     * @return
     */
    public void saveSuperviseReply() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            NodeInstance nit = flowEngine.getNodeInstById(object
                    .getNodeInstId());
            FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());
            SuperviseReply supervisereply = superviseReplyManager
                    .getObjectByNodeInstId(object.getNodeInstId());
            if (supervisereply != null) {
                supervisereply.copyNotNullProperty(object);
                object = supervisereply;
            } else {
                object.setProcessNo(superviseReplyManager.getNextKey());
            }
            object.setProcessName(fif.getNodeName());
            object.setProcessDate(new Date());
            object.setOperatorId(fuser.getUsercode());
            object.setOperatorName(fuser.getUsername());
            // object.setUpdateDate(new Date(System.currentTimeMillis()));
            object.setOperatorResult(transidea);
            superviseReplyManager.saveObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    /**
     * 查看或者编辑业务信息FRAME
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getBizInfoFrame(String superviseNo) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewFrame");
        viewFrameInfo
                .setFrameSrc("/supervise/superviseBasic!viewFrame.do?superviseNo="
                        + superviseNo);
        return viewFrameInfo;
    }

    /**
     * 查看或者编辑业务信息FRAME
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getProcFrame(String superviseNo) {
        OptHtmlFrameInfo procFrameInfo = new OptHtmlFrameInfo();
        procFrameInfo.setFrameId("procFrame");
        procFrameInfo
                .setFrameSrc("/supervise/superviseReply!viewList.do?superviseNo="
                        + superviseNo + "&flowInstId=" + super.getFlowInstId());
        procFrameInfo.setFrameHeight("300px");
        return procFrameInfo;
    }

    private void setFrameList(List<OptHtmlFrameInfo> frameList,
            String moduleDesc) {
        SuperviseBasic superviseBasic = superviseBasicManager
                .getSuperviseBasicByFlowId(super.getFlowInstId());
        frameList.add(getBizInfoFrame(superviseBasic.getSuperviseNo()));// 查看业务信息FRAME
        frameList.add(getProcFrame(superviseBasic.getSuperviseNo())); // 过程信息
        frameList.add(GeneralOperatorAction.getStuffListFrame(superviseBasic
                .getSuperviseNo()));

        jspInfo = new OptJspInfo();
        jspInfo.setTitle("");
        jspInfo.setFrameList(frameList);
    }

    /**
     * 弹出提示信息
     * 
     * @param msg
     * @param response
     */
    protected void postAlertMessage(String msg, HttpServletResponse response) {

        String alertCoding = "UTF-8";

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

    /************************ 以下为getter、setter ***************************/
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

    public OptJspInfo getJspInfo() {
        return jspInfo;
    }

    public void setJspInfo(OptJspInfo jspInfo) {
        this.jspInfo = jspInfo;
    }

    /*
     * public void setSysUserManager(SysUserManager sysUserManager) {
     * this.sysUserManager = sysUserManager; }
     * 
     * public void setSysUnitManager(SysUnitManager sysUnitManager) {
     * SysUnitManager = sysUnitManager; }
     */

    public void setSuperviseBasicManager(
            SuperviseBasicManager superviseBasicManager) {
        this.superviseBasicManager = superviseBasicManager;
    }

    public void setSuperviseReplyManager(
            SuperviseReplyManager superviseReplyManager) {
        this.superviseReplyManager = superviseReplyManager;
    }

    public void setSuperviseResultManager(
            SuperviseResultManager superviseResultManager) {
        this.superviseResultManager = superviseResultManager;
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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public Long getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(Long isExternal) {
        this.isExternal = isExternal;
    }

    public void setComplaintsprocessManager(
            ComplaintsprocessManager complaintsprocessManager) {
        this.complaintsprocessManager = complaintsprocessManager;
    }

}
