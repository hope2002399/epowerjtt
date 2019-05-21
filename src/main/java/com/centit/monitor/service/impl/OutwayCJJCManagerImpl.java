package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.OutwayCJJCDao;
import com.centit.monitor.po.OutwayCJJC;
import com.centit.monitor.service.OutwayCJJCManager;

public class OutwayCJJCManagerImpl extends BaseEntityManagerImpl<OutwayCJJC>
        implements OutwayCJJCManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private OutwayCJJCDao outwayCJJCDao;

    public void setOutwayCJJCDao(OutwayCJJCDao baseDao) {
        this.outwayCJJCDao = baseDao;
        setBaseDao(this.outwayCJJCDao);
    }

    public void updateMore(OutwayCJJC outway, String[] warnNoList) {
        this.outwayCJJCDao.updateMore(outway, warnNoList);
    }

    public List<OutwayCJJC> getOutWayCJJCList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return this.outwayCJJCDao.getOutWayList(filterMap, pageDesc);
    }

    public List<OutwayCJJC> getOutWayCJJCListT(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return this.outwayCJJCDao.getOutWayListT(filterMap, pageDesc);
    }

    public List<OutwayCJJC> getOutWayCJJCList(Map<String, Object> filterMap) {
        return this.outwayCJJCDao.getOutWayList(filterMap);
    }

    public String getMaxStateFromOutWayCJJC(String processno, String internalno) {
        return this.outwayCJJCDao.getMaxStateFromOutWay(processno, internalno);
    }

    public OutwayCJJC getOutwayCJJCById(String id) {
        return this.outwayCJJCDao.getOutwayCJJCById(id);
    }
}
