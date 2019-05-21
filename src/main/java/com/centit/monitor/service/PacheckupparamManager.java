package com.centit.monitor.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Pacheckupparam;

public interface PacheckupparamManager extends
        BaseEntityManager<Pacheckupparam> {

    public List<Pacheckupparam> getPacheckupparamList(
            Map<String, Object> filterMap, PageDesc pageDesc);

    public boolean insertPerformance(Date yearAndmonth, String deleteOld,
            String onlyCalcSum);

    public boolean insertPerformancedep(String orgId, Date yearAndmonth,
            String deleteOld, String onlyCalcSum);

}
