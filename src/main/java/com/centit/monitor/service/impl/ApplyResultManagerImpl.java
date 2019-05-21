package com.centit.monitor.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.ApplyResultDao;
import com.centit.monitor.po.ApplyResult;
import com.centit.monitor.service.ApplyResultManager;

public class ApplyResultManagerImpl extends BaseEntityManagerImpl<ApplyResult>
        implements ApplyResultManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyResultManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private ApplyResultDao applyResultDao;

    public void setApplyResultDao(ApplyResultDao baseDao) {
        this.applyResultDao = baseDao;
        setBaseDao(this.applyResultDao);
    }

    public ApplyResult getApplyResult(String internalNo, String itemId) {
        return applyResultDao.getApplyResult(internalNo, itemId);
    }
}
