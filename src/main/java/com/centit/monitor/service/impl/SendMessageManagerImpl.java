package com.centit.monitor.service.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.SmsLogDao;
import com.centit.monitor.po.SmsLog;
import com.centit.monitor.service.OutwayWarnpointManager;
import com.centit.monitor.service.SendMessageManager;

/**
 * 
 * 预报警规则定义的接口实现类
 * 
 * @author jf
 * @create 2014-2-11
 * @version
 */
public class SendMessageManagerImpl extends
    BaseEntityManagerImpl<SmsLog> implements
        SendMessageManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(OutwayWarnpointManager.class);

    private SmsLogDao smsLogDao;

    public void setsmsLogDao(SmsLogDao baseDao) {
        this.smsLogDao = baseDao;
        setBaseDao(this.smsLogDao);
    }


    @Override
    public void insertSendSMSLog(SmsLog smsLog) {
        smsLogDao.insertSmsLog(smsLog);
    }


}
