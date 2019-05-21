package com.centit.monitor.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.ApplyLog;

public interface ApplyLogManager extends BaseEntityManager<ApplyLog> {
    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String itemId);

    public ApplyLog getApplyLog(String internalNo, String itemId, Long chang_no);
}
