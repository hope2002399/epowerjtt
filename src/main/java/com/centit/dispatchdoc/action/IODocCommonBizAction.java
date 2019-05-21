/**
 * 
 */
package com.centit.dispatchdoc.action;

import java.util.List;

import com.centit.powerruntime.action.GeneralOperatorAction;
import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.page.OptJspInfo;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

/**
 * 收发文公用业务操作父类
 * 
 * @author ljy
 * @create 2013-9-23
 * @version
 */
public class IODocCommonBizAction<T> extends PowerRuntimeEntityAction<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private OptJspInfo jspInfo;
    protected SysUnitManager sysUnitManager;
    protected SysUserManager sysUserManager;
    protected String isSubFlow;// T:子流程

    /**
     * 基础业务信息查询
     * 
     * @return
     */
    protected OptBaseInfo getOptBaseInfo() {
        OptBaseInfo optBase = optBaseInfoManager.getOptBaseByFlowId(super
                .getFlowInstId());
        if (optBase == null) {
            optBase = new OptBaseInfo();
        }
        return optBase;
    }

    /**
     * FRAME设置公用部分
     * 
     * @param frameList
     * @param moduleDesc
     * @return
     */
    protected void setFrameList(List<OptHtmlFrameInfo> frameList,
            String moduleDesc) {
        OptBaseInfo optBaseInfo = optBaseInfoManager.getOptBaseByFlowId(super
                .getFlowInstId());
        frameList.add(getProcFrame(optBaseInfo.getDjId())); // 过程信息
        frameList.add(GeneralOperatorAction.getStuffListFrame(optBaseInfo
                .getDjId()));
        jspInfo = new OptJspInfo();
        jspInfo.setTitle(moduleDesc);
        jspInfo.setFrameList(frameList);
    }

    /**
     * 查看过程信息
     * 
     * @param djid
     * @return
     */
    protected OptHtmlFrameInfo getCommonTransFrame(String djId) {
        OptHtmlFrameInfo transFrameInfo = new OptHtmlFrameInfo();
        transFrameInfo.setFrameId("transFrame");
        transFrameInfo
                .setFrameSrc("/dispatchdoc/ioDocTasksExcute!doOpt.do?djId="
                        + djId + "&flowInstId=" + super.getFlowInstId()
                        + "&nodeInstId=" + super.getNodeInstId()
                        + "&moduleCode=" + moduleCode);
        return transFrameInfo;
    }

    /**
     * 查看过程信息
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getProcFrame(String djId) {
        OptHtmlFrameInfo procFrameInfo = new OptHtmlFrameInfo();
        procFrameInfo.setFrameId("procFrame");
        procFrameInfo
                .setFrameSrc("/powerruntime/generalOperator!listIdeaLogs.do?djId="
                        + djId);
        procFrameInfo.setFrameHeight("300px");
        return procFrameInfo;
    }

    public OptJspInfo getJspInfo() {
        return jspInfo;
    }

    public void setJspInfo(OptJspInfo jspInfo) {
        this.jspInfo = jspInfo;
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public String getIsSubFlow() {
        return isSubFlow;
    }

    public void setIsSubFlow(String isSubFlow) {
        this.isSubFlow = isSubFlow;
    }
}
