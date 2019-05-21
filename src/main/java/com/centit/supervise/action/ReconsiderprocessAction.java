package com.centit.supervise.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.supervise.po.Reconsiderprocess;
import com.centit.supervise.service.ReconsiderprocessManager;

public class ReconsiderprocessAction extends
        BaseEntityExtremeAction<Reconsiderprocess> {
    private static final long serialVersionUID = 1L;
    private ReconsiderprocessManager reconsiderprocessMag;

    public void setReconsiderprocessManager(ReconsiderprocessManager basemgr) {
        reconsiderprocessMag = basemgr;
        this.setBaseEntityManager(reconsiderprocessMag);
    }

    private Long flowInstId;

    public String viewList() {
        objList = reconsiderprocessMag.getObjListByReconsiderId(object
                .getReconsiderId());
        return "viewList";
    }

    public Long getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

}
