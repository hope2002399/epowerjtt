package com.centit.monitor.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.PunishResultLog;

public interface PunishResultLogManager extends
        BaseEntityManager<PunishResultLog> {
    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String orgId);

    public PunishResultLog getPunishResultLog(String internalNo, String orgId,
            Long chang_no);
}
