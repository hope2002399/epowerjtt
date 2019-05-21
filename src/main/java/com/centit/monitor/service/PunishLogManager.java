package com.centit.monitor.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.PunishLog;

public interface PunishLogManager extends BaseEntityManager<PunishLog> {
    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String orgId);

    public PunishLog getPunishLog(String internalNo, String orgId, Long chang_no);
}
