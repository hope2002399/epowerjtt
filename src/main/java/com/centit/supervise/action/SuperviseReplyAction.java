package com.centit.supervise.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.supervise.po.SuperviseReply;
import com.centit.supervise.service.SuperviseReplyManager;

public class SuperviseReplyAction extends
        BaseEntityExtremeAction<SuperviseReply> {
    private static final long serialVersionUID = 1L;
    private SuperviseReplyManager superviseReplyMag;

    public void setSuperviseReplyManager(SuperviseReplyManager basemgr) {
        superviseReplyMag = basemgr;
        this.setBaseEntityManager(superviseReplyMag);
    }

    private Long flowInstId;

    public String viewList() {
        objList = superviseReplyMag.getObjListBySuperviseNo(object
                .getSuperviseNo());
        return "viewList";
    }

    public Long getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }
}
