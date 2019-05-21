package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.PaPerformanceResult;

public interface PaPerformanceResultManager extends
        BaseEntityManager<PaPerformanceResult> {

    public List<PaPerformanceResult> getPaPerformancneList(
            Map<String, Object> filterMap, PageDesc pageDesc);

    public PaPerformanceResult getUpdateNo(Long checkNo);

    public void pamonthpunishSave(PaPerformanceResult probject);

}
