package com.centit.monitor.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.ApplyResult;

public interface ApplyResultManager extends BaseEntityManager<ApplyResult> {
    public ApplyResult getApplyResult(String internalNo, String itemId);
}
