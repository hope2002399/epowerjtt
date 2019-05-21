package com.centit.supervise.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.powerruntime.action.GeneralOperatorAction;
import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.page.OptJspInfo;
import com.centit.supervise.po.Reconsider;
import com.centit.supervise.po.Reconsiderprocess;
import com.centit.supervise.po.Reconsiderresult;
import com.centit.supervise.service.ReconsiderManager;
import com.centit.supervise.service.ReconsiderprocessManager;
import com.centit.supervise.service.ReconsiderresultManager;
import com.centit.sys.security.FUserDetail;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

/**
 * 
 * 行政复议处理通用类
 * 
 * @author hx
 * @create 2013-6-3
 * @version
 */
public class ReconsiderTasksExecuteAction extends
        PowerRuntimeEntityAction<Reconsiderprocess> implements
        ServletResponseAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    HttpServletResponse response;
    private OptJspInfo jspInfo;
    private String transidea;
    private ReconsiderprocessManager reconsiderprocessManager;
    private ReconsiderManager reconsiderManager;
    private ReconsiderresultManager reconsiderresultManager;

    /************************ 以下为主流程入口 ***************************/

    /**
     * 生成通用Frame框架
     * 
     * @return
     */
    public String generalOptFrame() {
        return this.generalOptFrame("generCommonTrans", "行政复议通用办理");
    }

    /**
     * 受理审查
     * 
     * @return
     */
    public String acceptReconsider() {
        return this.generalOptFrame("acceptReconsider", "受理审查");
    }

    /**
     * 审理
     * 
     * @return
     */
    public String isAcceptReconsider() {
        return this.generalOptFrame("isAcceptReconsider", "审理");
    }

    /**
     * 复议决定
     * 
     * @return
     */
    public String reconsiderResult() {
        return this.generalOptFrame("reconsiderResult", "复议决定");
    }

    /**
     * 退回补充材料
     * 
     * @return
     */
    public String backReconsider() {
        return this.generalOptFrame("backReconsider", "退回补充材料");
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
        Reconsider reconsider = reconsiderManager.getReconsiderByFlowId(super
                .getFlowInstId());
        if (reconsider == null) {
            this.postAlertMessage("操作失败，原因可能是复议办件不存在！", response);
            return null;
        }
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        OptHtmlFrameInfo transFrameInfo = new OptHtmlFrameInfo();
        transFrameInfo.setFrameId("transFrame");

        transFrameInfo.setFrameSrc("/supervise/reconsider!" + optMethod
                + ".do?reconsiderid=" + reconsider.getReconsiderid() + "&djId="
                + reconsider.getReconsiderid() + "&flowInstId="
                + super.getFlowInstId() + "&nodeInstId="
                + object.getNodeInstId() + "&moduleCode=" + moduleCode);
        frameList.add(transFrameInfo);
        // 框架主控操作
        super.setModuleParam(generalModuleParamManager
                .getObjectById(moduleCode));

        this.setFrameList(frameList, nodeName);

        return "optframe";
    }

    /************************ 以下为流程节点提交 ***************************/

    /**
     * 提交受理审查
     * 
     * @return
     */
    public String submitAcceptReconsider() {
        // todo 处理业务信息的方法
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        // 更新基本信息
        Reconsider reconsider = reconsiderManager.getObjectById(object
                .getReconsiderId());

        // 如果是不予受理,则流程结束，保存结果信息
        if ("F".equals(object.getOperatorResult())) {
            this.saveReconsiderresult("0");
            // 标识基本信息为办结
            reconsider.setBiztype("C");
        }
        reconsider.setReconsiderdate(new Date(System.currentTimeMillis()));
        reconsider.setReconsiderdep(fuser.getPrimaryUnit());
        reconsiderManager.saveObject(reconsider);

        // 提交
        return this.submitOpt();
    }

    public void saveReconsiderresult(String finishType) {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        Reconsiderresult reconsiderresult = reconsiderresultManager
                .getObjectById(object.getReconsiderId());
        if (reconsiderresult == null) {
            reconsiderresult = new Reconsiderresult();
            reconsiderresult.setReconsiderId(object.getReconsiderId());
        }
        if (finishType != null && finishType.equals("0")) {
            reconsiderresult.setReconsiderresult("1");
        } else {
            reconsiderresult.setReconsiderresult(object.getOperatorResult());
        }
        reconsiderresult.setReconsiderenddate(new Date(System
                .currentTimeMillis()));
        reconsiderresult.setFinishType(finishType);// 0不予受理1受理
        reconsiderresult.setOperatorId(fuser.getUsercode());
        reconsiderresult.setOperatorName(fuser.getUsername());
        // reconsiderresult.setReconsiderresult(object.getOperatorResult());
        reconsiderresult.setReconsiderremark(object.getOperatorOpinion());
        reconsiderresultManager.saveObject(reconsiderresult);
    }

    /**
     * 提交审理
     * 
     * @return
     */
    public String submitIsAcceptReconsider() {
        // todo 处理业务信息的方法

        // 提交
        return this.submitOpt();
    }

    /**
     * 提交复议决定
     * 
     * @return
     */
    public String submitReconsiderResult() {
        // todo 处理业务信息的方法
        // 保存结果信息
        this.saveReconsiderresult("1");
        // 更新基本信息
        Reconsider reconsider = reconsiderManager.getObjectById(object
                .getReconsiderId());
        reconsider.setBiztype("C");
        reconsiderManager.saveObject(reconsider);
        // 提交
        return this.submitOpt();
    }

    /**
     * 提交退回补充材料
     * 
     * @return
     */
    public String submitBackReconsider() {
        // todo 处理业务信息的方法

        // 提交
        return this.submitOpt();
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
        saveReconsiderprocess();

        // 保存办件人员
        this.saveTeamRolepeople();

        return this.nextStep();
    }

    /**
     * 保存督办过程信息
     * 
     * @return
     */
    public void saveReconsiderprocess() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            NodeInstance nit = flowEngine.getNodeInstById(object
                    .getNodeInstId());
            FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());
            Reconsiderprocess reconsiderprocess = reconsiderprocessManager
                    .getObjectByNodeInstId(object.getNodeInstId());
            if (reconsiderprocess != null) {
                reconsiderprocess.copyNotNullProperty(object);
                object = reconsiderprocess;
            } else {
                object.setProcessno(reconsiderprocessManager.getNextKey());
            }
            object.setProcessName(fif.getNodeName());
            object.setProcessDate(new Date());
            object.setOperatorId(fuser.getUsercode());
            object.setOperatorName(fuser.getUsername());
            object.setOperatorResult(transidea);
            reconsiderprocessManager.saveObject(object);
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
    private OptHtmlFrameInfo getBizInfoFrame(String reconsiderid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewFrame");
        viewFrameInfo
                .setFrameSrc("/supervise/reconsider!viewFrame.do?reconsiderid="
                        + reconsiderid);
        return viewFrameInfo;
    }

    /**
     * 查看或者编辑业务信息FRAME
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getProcFrame(String reconsiderId) {
        OptHtmlFrameInfo procFrameInfo = new OptHtmlFrameInfo();
        procFrameInfo.setFrameId("procFrame");
        procFrameInfo
                .setFrameSrc("/supervise/reconsiderprocess!viewList.do?reconsiderId="
                        + reconsiderId + "&flowInstId=" + super.getFlowInstId());
        procFrameInfo.setFrameHeight("300px");
        return procFrameInfo;
    }

    private void setFrameList(List<OptHtmlFrameInfo> frameList,
            String moduleDesc) {
        Reconsider reconsider = reconsiderManager.getReconsiderByFlowId(super
                .getFlowInstId());
        frameList.add(getBizInfoFrame(reconsider.getReconsiderid()));// 查看业务信息FRAME
        frameList.add(getProcFrame(reconsider.getReconsiderid())); // 过程信息
        frameList.add(GeneralOperatorAction.getStuffListFrame(reconsider
                .getReconsiderid()));

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

    public void setReconsiderprocessManager(
            ReconsiderprocessManager reconsiderprocessManager) {
        this.reconsiderprocessManager = reconsiderprocessManager;
    }

    public void setReconsiderManager(ReconsiderManager reconsiderManager) {
        this.reconsiderManager = reconsiderManager;
    }

    public void setReconsiderresultManager(
            ReconsiderresultManager reconsiderresultManager) {
        this.reconsiderresultManager = reconsiderresultManager;
    }

}
