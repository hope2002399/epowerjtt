package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.OutwayCJJC;

public interface OutwayCJJCManager extends BaseEntityManager<OutwayCJJC> {
    public void updateMore(OutwayCJJC outwayCJJC, String[] warnNoList);

    public List<OutwayCJJC> getOutWayCJJCList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public List<OutwayCJJC> getOutWayCJJCListT(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public List<OutwayCJJC> getOutWayCJJCList(Map<String, Object> filterMap);

    public String getMaxStateFromOutWayCJJC(String processno, String internalno);

    public OutwayCJJC getOutwayCJJCById(String id);
}
