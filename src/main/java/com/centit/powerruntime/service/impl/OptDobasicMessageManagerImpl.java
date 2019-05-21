package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.OptDobasicMessage;
import com.centit.powerruntime.dao.OptDobasicMessageDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.OptDobasicMessageManager;

public class OptDobasicMessageManagerImpl extends
        BaseEntityManagerImpl<OptDobasicMessage> implements
        OptDobasicMessageManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(OptDobasicMessageManager.class);

    private OptDobasicMessageDao optDobasicMessageDao;

    public void setOptDobasicMessageDao(OptDobasicMessageDao baseDao) {
        this.optDobasicMessageDao = baseDao;
        setBaseDao(this.optDobasicMessageDao);
    }

    @Override
    public String getDobasicMessageId() {
        // TODO Auto-generated method stub
        return optDobasicMessageDao.getDobasicMessageId();
    }

}
