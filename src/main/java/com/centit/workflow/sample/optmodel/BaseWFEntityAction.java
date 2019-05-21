package com.centit.workflow.sample.optmodel;

import java.util.Map;
import java.util.Set;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.support.utils.HtmlFormUtils;
import com.centit.support.utils.StringRegularOpt;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysVariableTranslate;
import com.centit.workflow.FlowEngine;
import com.centit.workflow.WorkflowException;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseWFEntityAction<T extends Object> extends
        BaseEntityExtremeAction<T> implements ModelDriven<T> {
    private static final long serialVersionUID = 1L;
    protected SysVariableTranslate businessVariable = null;
    protected FlowEngine flowEngine;

    protected Long curNodeInstId;
    protected Long curFlowInstId;
    protected String flowPhase;
    private String isGrantor;
    private String grantor;

    public void setFlowEngine(FlowEngine flowEngine) {
        this.flowEngine = flowEngine;
        // this.request.getSession().getServletContext();
    }

    /**
     * 需要设定自定义 变量解释器是需要调用这个函数
     * 
     * @param businessVariable
     */
    public void setBusinessVariable(SysVariableTranslate businessVariable) {
        this.businessVariable = businessVariable;
    }

    /**
     * 从request的参数中获取节点编号（包括流程编号）
     * 
     * @return false 没有找到对应的参数
     */
    @SuppressWarnings("unchecked")
    protected boolean extractFlowOptParam() {
        boolean bHasExtract = false;
        try {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Object oParam = paramMap.get("nodeInstId");
            if (oParam != null) {
                String sNodeInstId = HtmlFormUtils.getParameterString(oParam);
                if (sNodeInstId != null
                        && StringRegularOpt.isNumber(sNodeInstId)) {
                    curNodeInstId = Long.valueOf(sNodeInstId);
                }
            }
            oParam = paramMap.get("flowInstId");
            if (oParam != null) {
                String sFlowInstId = HtmlFormUtils.getParameterString(oParam);
                if (sFlowInstId != null
                        && StringRegularOpt.isNumber(sFlowInstId)) {
                    curFlowInstId = Long.valueOf(sFlowInstId);
                }
            }
            /*
             * oParam = paramMap.get("optParam"); if (oParam != null) {
             * curOptParam = StringBaseOpt.getParameterString(oParam); }
             */
            bHasExtract = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bHasExtract;
    }

    public Long getNodeInstId() {
        return curNodeInstId;
    }

    public void setNodeInstId(Long curNodeInstId) {
        this.curNodeInstId = curNodeInstId;
    }

    public Long getFlowInstId() {
        return curFlowInstId;
    }

    public void setFlowInstId(Long curFlowInstId) {
        this.curFlowInstId = curFlowInstId;
    }

    protected Set<Long> submitNode() throws WorkflowException {
        return submitNode(true);
    }

    public SysVariableTranslate getBusinessVariable() {
        if (businessVariable == null) {
            BaseVariable<T> bo = new BaseVariable<T>();
            bo.setModuleObject(object);
            bo.setServletRequest(request);
            businessVariable = bo;
        }
        return businessVariable;
    }

    protected Set<Long> submitNode(boolean closeBranch)
            throws WorkflowException {
        extractFlowOptParam();
        FUserDetail curUser = ((FUserDetail) getLoginUser());

        SysVariableTranslate fvt = getBusinessVariable();

        return flowEngine.submitOpt(curNodeInstId, curUser.getUsercode(),
                curUser.getPrimaryUnit(), closeBranch, fvt, this.request
                        .getSession().getServletContext());
    }

    protected Set<Long> submitNode(String grantorCode, boolean closeBranch)
            throws WorkflowException {
        extractFlowOptParam();
        FUserDetail curUser = ((FUserDetail) getLoginUser());

        SysVariableTranslate fvt = getBusinessVariable();

        return flowEngine.submitOpt(curNodeInstId, curUser.getUsercode(),
                grantorCode, curUser.getPrimaryUnit(), closeBranch, fvt,
                this.request.getSession().getServletContext());
    }

    protected Set<Long> submitNode(String grantorCode) throws WorkflowException {
        return submitNode(grantorCode, true);
    }

    public String getFlowPhase() {
        return flowPhase;
    }

    public void setFlowPhase(String flowPhase) {
        this.flowPhase = flowPhase;
    }

    public String getIsGrantor() {
        return isGrantor;
    }

    public void setIsGrantor(String isGrantor) {
        this.isGrantor = isGrantor;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }
}
