package com.centit.monitor.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.ApplyLogDao;
import com.centit.monitor.po.ApplyLog;
import com.centit.monitor.service.ApplyLogManager;

public class ApplyLogManagerImpl extends BaseEntityManagerImpl<ApplyLog>
        implements ApplyLogManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyLogManager.class);
    private ApplyLogDao applyLogDao;

    public void setApplyLogDao(ApplyLogDao baseDao) {
        this.applyLogDao = baseDao;
        setBaseDao(this.applyLogDao);
    }

    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String itemId) {
        return applyLogDao.getVersionList(internalNo, itemId);
    }

    public ApplyLog getApplyLog(String internalNo, String itemId, Long chang_no) {
        return applyLogDao.getApplyLog(internalNo, itemId, chang_no);
    }
}
