package com.centit.monitor.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.PunishLog;
import com.centit.monitor.service.PunishLogManager;

public class PunishLogAction extends BaseEntityExtremeAction<PunishLog> {
    private static final Log log = LogFactory.getLog(PunishLogAction.class);

    // private static final ISysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog("optid");

    private static final long serialVersionUID = 1L;
    private PunishLogManager punishLogManager;

    public void setPunishLogManager(PunishLogManager basemgr) {
        punishLogManager = basemgr;
        this.setBaseEntityManager(punishLogManager);
    }

    public String view() {
        try {
            String internalNo = object.getInternalNo();
            String orgId = object.getOrgId();
            Long chang_no = object.getChangNo();
            PunishLog punishLog = punishLogManager.getPunishLog(internalNo,
                    orgId, chang_no);
            if (object == null) {

                return LIST;
            }
            // if (o != null)
            // applyManager.copyObject(object, o);
            request.setAttribute("punishLog", punishLog);

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
