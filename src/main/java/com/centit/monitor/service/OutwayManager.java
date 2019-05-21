package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Outway;

public interface OutwayManager extends BaseEntityManager<Outway> {
    public void updateMore(Outway outway, String[] warnNoList);

    public List<Outway> getOutWayList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public List<Outway> getOutWayListT(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public List<Outway> getOutWayList(Map<String, Object> filterMap);

    public String getMaxStateFromOutWay(String processno, String internalno);

    @SuppressWarnings("rawtypes")
    public List getcjjclist(String begintime, String endtime);
}
