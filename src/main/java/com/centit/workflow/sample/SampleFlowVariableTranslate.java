package com.centit.workflow.sample;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.centit.sys.service.SysVariableTranslate;
import com.centit.workflow.sample.po.WfFlowInstance;
import com.centit.workflow.sample.po.WfFlowVariable;
import com.centit.workflow.sample.po.WfNodeInstance;

public class SampleFlowVariableTranslate implements SysVariableTranslate {

    private SysVariableTranslate flowVarTrans;
    private List<WfFlowVariable> flowVariables;
    private Map<String, Set<String>> flowOrganizes;
    private WfNodeInstance nodeInst;
    private WfFlowInstance flowInst;

    public SampleFlowVariableTranslate(SysVariableTranslate varTrans,
            List<WfFlowVariable> flowVars, WfNodeInstance nodeInstance,
            WfFlowInstance flowInstance) {
        flowVarTrans = varTrans;
        flowVariables = flowVars;
        nodeInst = nodeInstance;
        flowInst = flowInstance;
    }

    public void setNodeInst(WfNodeInstance nodeInst) {
        this.nodeInst = nodeInst;
    }

    public void setFlowVarTrans(SysVariableTranslate flowVarTrans) {
        this.flowVarTrans = flowVarTrans;
    }

    public void setFlowVariables(List<WfFlowVariable> flowVariables) {
        this.flowVariables = flowVariables;
    }

    public void setFlowOrganizes(Map<String, Set<String>> flowOrganizes) {
        this.flowOrganizes = flowOrganizes;
    }

    private WfFlowVariable findFlowVariable(String varName) {
        if (flowVariables == null || flowVariables.size() == 0)
            return null;
        String thisToken = nodeInst.getRunToken();
        WfFlowVariable sValue = null;
        int nTL = 0;
        for (WfFlowVariable variable : flowVariables) {
            String currToken = variable.getRunToken();
            int cTL = currToken.length();
            if (varName.equals(variable.getVarName())
                    && ("A".equals(variable.getRunToken()) || thisToken == null
                            || currToken.equals(thisToken) || thisToken
                                .startsWith(currToken + '.')) && nTL < cTL) {
                nTL = cTL;
                sValue = variable;
            }
        }

        return sValue;

    }

    @Override
    public String getLabelValue(String varName) {
        String sRes = null;
        /**
         * 编写的流程变量接口
         */
        if (flowVarTrans != null) {
            sRes = flowVarTrans.getVarValue(varName);
            if (sRes != null)
                return sRes;
        }
        /**
         * 程序设置的流程变量
         */
        WfFlowVariable v = findFlowVariable(varName);
        if (v != null)
            return v.getVarValue();
        /**
         * 系统内置变量 flowunit 流程机构 flowuser 流程创建用户 nodeunit 节点机构
         */
        if ("flowuser".equalsIgnoreCase(varName))
            return flowInst.getUserCode();
        else if ("flowunit".equalsIgnoreCase(varName))
            return flowInst.getUnitCode();
        else if ("nodeunit".equalsIgnoreCase(varName))
            return nodeInst.getUnitCode();

        return null;
    }

    @Override
    public String getVarValue(String varName) {
        return getLabelValue(varName);
    }

    public Set<String> getUsersVariable(String varName) {
        if (flowVarTrans != null) {
            Set<String> sUsers = flowVarTrans.getUsersVariable(varName);
            if (sUsers != null && sUsers.size() > 0)
                return sUsers;
        }
        WfFlowVariable v = findFlowVariable(varName);
        if (v != null)
            return v.getVarSet();
        return null;
    }

    /**
     * 返回机构表达式中的自定义变量对应的用户组
     * 
     * @param varName
     *            自定义变量
     * @return
     */
    public Set<String> getUnitsVariable(String varName) {
        if (flowVarTrans != null) {
            Set<String> sUnits = flowVarTrans.getUnitsVariable(varName);
            if (sUnits != null && sUnits.size() > 0)
                return sUnits;
        }
        WfFlowVariable v = findFlowVariable(varName);
        if (v != null)
            return v.getVarSet();

        return flowOrganizes.get(varName);
    }

}
