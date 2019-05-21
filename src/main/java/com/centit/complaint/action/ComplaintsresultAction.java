package com.centit.complaint.action;

import com.centit.complaint.po.ComplaintsResult;
import com.centit.complaint.service.ComplaintsresultManager;
import com.centit.core.action.BaseEntityExtremeAction;

public class ComplaintsresultAction extends
        BaseEntityExtremeAction<ComplaintsResult> {

    private static final long serialVersionUID = 1L;
    private ComplaintsresultManager complaintsresultManager;

    public void setComplaintsresultManager(ComplaintsresultManager basemgr) {
        complaintsresultManager = basemgr;
        this.setBaseEntityManager(complaintsresultManager);
    }

    public String view() {
        try {

            ComplaintsResult result = complaintsresultManager
                    .getObjectByComplaintsId(object.getComplaintid());

            if (object == null) {

                return LIST;
            }
            // if (o != null)
            // applyManager.copyObject(object, o);
            request.setAttribute("result", result);

            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    public String delete() {
        super.delete();

        return "delete";
    }
}
