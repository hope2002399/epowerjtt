package com.centit.monitor.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.PunishResultLog;
import com.centit.monitor.service.PunishResultLogManager;

public class PunishResultLogAction extends
        BaseEntityExtremeAction<PunishResultLog> {
    private static final Log log = LogFactory
            .getLog(PunishResultLogAction.class);

    // private static final ISysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog("optid");

    private static final long serialVersionUID = 1L;
    private PunishResultLogManager punishResultLogManager;

    public void setPunishResultLogManager(PunishResultLogManager basemgr) {
        punishResultLogManager = basemgr;
        this.setBaseEntityManager(punishResultLogManager);
    }

    public String view() {
        try {
            String internalNo = object.getInternalNo();
            String orgId = object.getOrgId();
            Long chang_no = object.getChangNo();
            PunishResultLog punishResultLog = punishResultLogManager
                    .getPunishResultLog(internalNo, orgId, chang_no);
            if (object == null) {

                return LIST;
            }
            // if (o != null)
            // applyManager.copyObject(object, o);
            request.setAttribute("punishResultLog", punishResultLog);

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
