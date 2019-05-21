package com.centit.complaint.action;

import com.centit.complaint.po.ComplaintsProcess;
import com.centit.complaint.service.ComplaintsprocessManager;
import com.centit.core.action.BaseEntityExtremeAction;

public class ComplaintsprocessAction extends
        BaseEntityExtremeAction<ComplaintsProcess> {

    private static final long serialVersionUID = 1L;
    private ComplaintsprocessManager complaintsprocessMag;

    public void setComplaintsprocessManager(ComplaintsprocessManager basemgr) {
        complaintsprocessMag = basemgr;
        this.setBaseEntityManager(complaintsprocessMag);
    }

    public String delete() {
        super.delete();

        return "delete";
    }

    private Long flowInstId;

    public String viewList() {
        objList = complaintsprocessMag.getObjListByComplaintId(object
                .getComplaintId());
        return "viewList";
    }

    public Long getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

}
