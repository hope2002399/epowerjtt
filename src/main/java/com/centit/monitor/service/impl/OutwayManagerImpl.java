package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.OutwayDao;
import com.centit.monitor.po.Outway;
import com.centit.monitor.service.OutwayManager;

public class OutwayManagerImpl extends BaseEntityManagerImpl<Outway> implements
        OutwayManager {
    private static final long serialVersionUID = 1L;
    private OutwayDao outwayDao;

    public void setOutwayDao(OutwayDao baseDao) {
        this.outwayDao = baseDao;
        setBaseDao(this.outwayDao);
    }

    public void updateMore(Outway outway, String[] warnNoList) {
        this.outwayDao.updateMore(outway, warnNoList);
    }

    public List<Outway> getOutWayList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return this.outwayDao.getOutWayList(filterMap, pageDesc);
    }

    public List<Outway> getOutWayListT(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return this.outwayDao.getOutWayListT(filterMap, pageDesc);
    }

    public List<Outway> getOutWayList(Map<String, Object> filterMap) {
        return this.outwayDao.getOutWayList(filterMap);
    }

    public String getMaxStateFromOutWay(String processno, String internalno) {
        return this.outwayDao.getMaxStateFromOutWay(processno, internalno);
    }

    @SuppressWarnings("rawtypes")
    public List getcjjclist(String begintime, String endtime) {

        return outwayDao.getcjjclist(begintime, endtime);
    }
}
