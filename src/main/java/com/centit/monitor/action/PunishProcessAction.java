package com.centit.monitor.action;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.PunishDoc;
import com.centit.monitor.po.PunishProcess;
import com.centit.monitor.service.PunishDocManager;
import com.centit.monitor.service.PunishProcessManager;

public class PunishProcessAction extends BaseEntityExtremeAction<PunishProcess> {
    private static final Log log = LogFactory.getLog(PunishProcessAction.class);
    private static final long serialVersionUID = 1L;
    private PunishProcessManager punishProcessManager;
    private PunishDocManager punishDocManager;

    public void setPunishDocManager(PunishDocManager punishDocManager) {
        this.punishDocManager = punishDocManager;
    }

    public void setPunishProcessManager(PunishProcessManager basemgr) {
        punishProcessManager = basemgr;
        this.setBaseEntityManager(punishProcessManager);
    }

    public String view() {
        try {
            PunishProcess punishProcess = punishProcessManager
                    .getObject(object);
            HashMap<String, Object> docMap = new HashMap<String, Object>();
            docMap.put("docType", "2");
            docMap.put("internalNo", punishProcess.getInternalNo());
            docMap.put("orgId", punishProcess.getOrgId());
            docMap.put("processNo", punishProcess.getNoOrd());
            List<PunishDoc> docList = punishDocManager.listObjects(docMap);
            punishProcess.setDocList(docList);
            if (object == null) {
                return LIST;
            }
            List<PunishDoc> listStuffOFAttach = punishDocManager
                    .getProcessPunishDoc("attachment",
                            punishProcess.getInternalNo(),
                            punishProcess.getOrgId(),
                            String.valueOf(punishProcess.getNoOrd()), false);
            List<PunishDoc> listStuffOFEVID = punishDocManager
                    .getProcessPunishDoc("evidence",
                            punishProcess.getInternalNo(),
                            punishProcess.getOrgId(),
                            String.valueOf(punishProcess.getNoOrd()), false);
            request.setAttribute("attachments", listStuffOFAttach);
            request.setAttribute("evidences", listStuffOFEVID);
            request.setAttribute("punishProcess", punishProcess);
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
