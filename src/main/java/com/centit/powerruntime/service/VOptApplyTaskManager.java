package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.VOptApplyTaskList;

public interface VOptApplyTaskManager extends
        BaseEntityManager<VOptApplyTaskList> {

    public VOptApplyTaskList getObjectBydjId(String djId);

    public List<VOptApplyTaskList> getEmsOptApplyList(
            Map<String, Object> filterMap);
}
