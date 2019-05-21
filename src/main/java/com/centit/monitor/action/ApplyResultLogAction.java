package com.centit.monitor.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.ApplyResultLog;
import com.centit.monitor.service.ApplyResultLogManager;

public class ApplyResultLogAction extends
        BaseEntityExtremeAction<ApplyResultLog> {
    private static final Log log = LogFactory
            .getLog(ApplyResultLogAction.class);
    private static final long serialVersionUID = 1L;
    private ApplyResultLogManager applyResultLogManager;

    public void setApplyResultLogManager(ApplyResultLogManager basemgr) {
        applyResultLogManager = basemgr;
        this.setBaseEntityManager(applyResultLogManager);
    }

    public String view() {
        try {
            String internalNo = object.getInternalNo();
            String itemId = object.getItemId();
            Long chang_no = object.getChangNo();
            ApplyResultLog applyResultLog = applyResultLogManager
                    .getApplyResultLog(internalNo, itemId, chang_no);
            if (object == null) {

                return LIST;
            }
            request.setAttribute("applyResultLog", applyResultLog);
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
