package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.OptPickupMessage;
import com.centit.powerruntime.dao.OptPickupMessageDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.OptPickupMessageManager;

public class OptPickupMessageManagerImpl extends
        BaseEntityManagerImpl<OptPickupMessage> implements
        OptPickupMessageManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(OptPickupMessageManager.class);

    private OptPickupMessageDao optPickupMessageDao;

    public void setOptPickupMessageDao(OptPickupMessageDao baseDao) {
        this.optPickupMessageDao = baseDao;
        setBaseDao(this.optPickupMessageDao);
    }

    @Override
    public String getPickupMessageId() {
        return optPickupMessageDao.getPickupMessageId();
    }

}
