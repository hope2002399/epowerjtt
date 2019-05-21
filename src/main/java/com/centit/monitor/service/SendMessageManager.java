package com.centit.monitor.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.SmsLog;

/**
 * 
 * 预报警规则定义的接口
 * 
 * @author jf
 * @create 2014-2-11
 * @version
 */
public interface SendMessageManager extends
        BaseEntityManager<SmsLog> {

    /**
     * 新增发送短信日志
     * 
     * @param calcNo
     *            批次号
     * @param wpExeRule
     */
    public void insertSendSMSLog(SmsLog smsLog);


}
