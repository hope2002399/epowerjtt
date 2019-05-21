package com.centit.monitor.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.PunishResult;
import com.centit.monitor.service.PunishDocManager;
import com.centit.monitor.service.PunishResultManager;
import com.centit.sys.util.InFlowInfo;
import com.centit.sys.util.JDomeGetItem;

public class PunishResultAction extends BaseEntityExtremeAction<PunishResult> {
    private static final Log log = LogFactory.getLog(PunishResultAction.class);
    private static final long serialVersionUID = 1L;
    private PunishResultManager punishResultManager;
    private PunishDocManager punishDocManager;

    public void setPunishResultManager(PunishResultManager basemgr) {
        punishResultManager = basemgr;
        this.setBaseEntityManager(punishResultManager);
    }

    public String view() {
        try {
            String internalNo = object.getInternalNo();
            String orgId = object.getOrgId();
            PunishResult result = punishResultManager.getPunishResult(
                    internalNo, orgId);
            request.setAttribute("result", result);
            List<InFlowInfo> listStuff = JDomeGetItem.JDomeGetDocument(result
                    .getAttachment());
            request.setAttribute("listStuff", listStuff);
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

    public void setPunishDocManager(PunishDocManager punishDocManager) {
        this.punishDocManager = punishDocManager;
    }
    
}
