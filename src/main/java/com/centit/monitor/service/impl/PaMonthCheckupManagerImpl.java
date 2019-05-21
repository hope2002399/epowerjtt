package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.PaMonthCheckupDao;
import com.centit.monitor.po.PaMonthCheckup;
import com.centit.monitor.service.PaMonthCheckupManager;

public class PaMonthCheckupManagerImpl extends
        BaseEntityManagerImpl<PaMonthCheckup> implements PaMonthCheckupManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PaMonthCheckupManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private PaMonthCheckupDao paMonthCheckupDao;

    public void setPaMonthCheckupDao(PaMonthCheckupDao baseDao) {
        this.paMonthCheckupDao = baseDao;
        setBaseDao(this.paMonthCheckupDao);
    }

    @Override
    public List<PaMonthCheckup> getCheckList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return paMonthCheckupDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public List<PaMonthCheckup> getCheckList(String countYear,
            String countMonth, String orgId) {
        
        return paMonthCheckupDao.getCheckList(countYear, countMonth, orgId);
    }

}
