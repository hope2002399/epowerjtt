package com.centit.monitor.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.ApplyResultLog;

public interface ApplyResultLogManager extends
        BaseEntityManager<ApplyResultLog> {
    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String itemId);

    public ApplyResultLog getApplyResultLog(String internalNo, String itemId,
            Long chang_no);
}
