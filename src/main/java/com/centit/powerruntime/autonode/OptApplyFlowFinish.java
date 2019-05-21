/**
 * 
 */
package com.centit.powerruntime.autonode;

import java.util.Date;

import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.service.OptBaseInfoManager;
import com.centit.powerruntime.service.OptProcInfoManager;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.NodeEventSupport;
import com.centit.workflow.NodeInstance;

/**
 * TODO Class description should be added
 * 
 * @author ljy
 * @create 2013-11-14
 * @version
 */
public class OptApplyFlowFinish implements NodeEventSupport {

    private OptBaseInfoManager optBaseInfoManager;
    private OptProcInfoManager optProcInfoManager;

    @Override
    public void runAfterCreate(FlowInstance flowInst, NodeInstance nodeInst,
            String optParam, String optUserCode) {
        OptBaseInfo bean = optBaseInfoManager.getOptBaseByFlowId(flowInst
                .getFlowInstId());
        OptProcInfo procInfo = optProcInfoManager
                .getObjectByNodeInstId(nodeInst.getPrevNodeInstId());
        if (procInfo == null) {
            procInfo = new OptProcInfo();
        }
        bean.setBiztype("C");
        bean.setSolvetime(new Date(System.currentTimeMillis()));
        bean.setSolvenote(procInfo.getTransidea());
        bean.setSolvestatus(procInfo.getIdeacode());
        optBaseInfoManager.saveObject(bean);
    }

    @Override
    public void runBeforeSubmit(FlowInstance flowInst, NodeInstance nodeInst,
            String optParam, String optUserCode) {
        

    }

    @Override
    public boolean runAutoOperator(FlowInstance flowInst,
            NodeInstance nodeInst, String optParam, String optUserCode) {
        
        return true;
    }

    public void setOptBaseInfoManager(OptBaseInfoManager optBaseInfoManager) {
        this.optBaseInfoManager = optBaseInfoManager;
    }

    public void setOptProcInfoManager(OptProcInfoManager optProcInfoManager) {
        this.optProcInfoManager = optProcInfoManager;
    }

}
