package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.PaMonthCheckup;

public interface PaMonthCheckupManager extends
        BaseEntityManager<PaMonthCheckup> {

    public List<PaMonthCheckup> getCheckList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public List<PaMonthCheckup> getCheckList(String countYear,
            String countMonth, String orgId);

}
