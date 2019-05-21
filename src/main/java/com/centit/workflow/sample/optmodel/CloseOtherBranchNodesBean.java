package com.centit.workflow.sample.optmodel;

import com.centit.workflow.FlowEngine;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.NodeEventSupport;
import com.centit.workflow.NodeInstance;

public class CloseOtherBranchNodesBean implements NodeEventSupport {

    private FlowEngine flowEng;

    @Override
    public boolean runAutoOperator(FlowInstance flowInst,
            NodeInstance nodeInst, String optParam, String optUserCode) {
        flowEng.disableOtherBranchNodes(nodeInst.getNodeInstId(), optUserCode);
        return true;
    }

    public void setFlowEngine(FlowEngine flowEng) {
        this.flowEng = flowEng;
    }

    @Override
    public void runAfterCreate(FlowInstance flowInst, NodeInstance nodeInst,
            String optParam, String optUserCode) {
        

    }

    @Override
    public void runBeforeSubmit(FlowInstance flowInst, NodeInstance nodeInst,
            String optParam, String optUserCode) {
        

    }

}
