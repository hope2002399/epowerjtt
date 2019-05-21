package com.centit.monitor.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.ApplyResultLogDao;
import com.centit.monitor.po.ApplyResultLog;
import com.centit.monitor.service.ApplyResultLogManager;

public class ApplyResultLogManagerImpl extends
        BaseEntityManagerImpl<ApplyResultLog> implements ApplyResultLogManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(ApplyResultLogManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private ApplyResultLogDao applyResultLogDao;

    public void setApplyResultLogDao(ApplyResultLogDao baseDao) {
        this.applyResultLogDao = baseDao;
        setBaseDao(this.applyResultLogDao);
    }

    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String itemId) {
        return applyResultLogDao.getVersionList(internalNo, itemId);
    }

    public ApplyResultLog getApplyResultLog(String internalNo, String itemId,
            Long chang_no) {
        return applyResultLogDao
                .getApplyResultLog(internalNo, itemId, chang_no);
    }
}
