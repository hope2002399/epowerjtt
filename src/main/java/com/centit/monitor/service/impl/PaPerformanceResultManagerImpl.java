package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.PaPerformanceResultDao;
import com.centit.monitor.po.PaPerformanceResult;
import com.centit.monitor.service.PaPerformanceResultManager;

public class PaPerformanceResultManagerImpl extends
        BaseEntityManagerImpl<PaPerformanceResult> implements
        PaPerformanceResultManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PaPerformanceResultManager.class);
    private PaPerformanceResultDao paPerformanceResultDao;

    public void setPaPerformanceResultDao(PaPerformanceResultDao baseDao) {
        this.paPerformanceResultDao = baseDao;
        setBaseDao(this.paPerformanceResultDao);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List getPaPerformancneList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return paPerformanceResultDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public PaPerformanceResult getUpdateNo(Long checkNo) {
        return paPerformanceResultDao.getObjectById(checkNo);
    }

    @Override
    public void pamonthpunishSave(PaPerformanceResult probject) {
        paPerformanceResultDao.saveObject(probject);
    }

}
