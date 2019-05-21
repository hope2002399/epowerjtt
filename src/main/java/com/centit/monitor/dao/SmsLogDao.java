package com.centit.monitor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.SmsLog;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public class SmsLogDao extends BaseDaoImpl<SmsLog> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SmsLogDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("id", CodeBook.EQUAL_HQL_ID);
            filterField.put("smsPhones", CodeBook.LIKE_HQL_ID);
            filterField.put("smsNames", CodeBook.LIKE_HQL_ID);
            filterField.put("smsUsercodes", CodeBook.LIKE_HQL_ID);
            filterField.put("smsContent", CodeBook.LIKE_HQL_ID);
            filterField.put("smsSendstatus", CodeBook.EQUAL_HQL_ID);
            filterField.put("smsType", CodeBook.EQUAL_HQL_ID);
            filterField.put("smsSendReturnStatus", CodeBook.LIKE_HQL_ID);
            filterField.put("begTime", "smsSendtime >= to_date(?,'yyyy-mm-dd')");
            filterField
                    .put("endTime", "smsSendtime <= to_date(?,'yyyy-mm-dd')+1");
        }
        return filterField;
    }
    
    /**
     * 新增发送短信日志表
     * @param smsLog
     */
    public void insertSmsLog(SmsLog smsLog){
        String inssql="insert into sms_log (ID, SMS_PHONES, SMS_NAMES, NET_ID, SMS_USERCODES, SMS_CONTENT, SMS_SENDSTATUS, SMS_TYPE, SMS_SENDTIME, SMS_SENDRETURNSTATUS)"
                + "values ('" + smsLog.getId() + "','" + smsLog.getSmsPhones() + "','" + smsLog.getSmsNames() + "','" + smsLog.getNetId() + "','"
                + smsLog.getSmsUsercodes() + "','" + smsLog.getSmsContent() + "','"
                + smsLog.getSmsSendstatus() + "','" + smsLog.getSmsType() + "',sysdate,'" + smsLog.getSmsSendReturnStatus() + "')";
        super.doExecuteSql(inssql);
    }
}
