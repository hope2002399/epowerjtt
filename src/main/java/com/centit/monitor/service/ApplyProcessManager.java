package com.centit.monitor.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.ApplyProcess;

public interface ApplyProcessManager extends BaseEntityManager<ApplyProcess> {
    public List<ApplyProcess> listObjects(String internalNo, String itemId);

    public List<ApplyProcess> listApplyProcessEx(String internalNo,
            String itemId, String xmlInFlowInfo);
}
