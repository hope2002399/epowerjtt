package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.OptSendMessage;
import com.centit.powerruntime.dao.OptSendMessageDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.OptSendMessageManager;

public class OptSendMessageManagerImpl extends
        BaseEntityManagerImpl<OptSendMessage> implements OptSendMessageManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(OptSendMessageManager.class);
    private OptSendMessageDao optSendMessageDao;

    public void setOptSendMessageDao(OptSendMessageDao baseDao) {
        this.optSendMessageDao = baseDao;
        setBaseDao(this.optSendMessageDao);
    }

    @Override
    public String getSendMessageId() {
        // TODO Auto-generated method stub
        return optSendMessageDao.getSendMessageId();
    }

}
