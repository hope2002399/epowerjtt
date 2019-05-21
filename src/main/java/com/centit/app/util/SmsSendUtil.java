package com.centit.app.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 短信发送方法
 * TODO Class description should be added
 * 
 * @author jf
 * @create 2014-5-12
 * @version
 */
public class SmsSendUtil {
    
    /**
     * 发送短信
     * @param mobile 目标手机号
     * @param smsValue 发送内容
     * @return
     */
    public boolean sendSMS(String mobile, String smsValue) {
        String smsUrl = null;
        String srcTermID = null;
        String linkId = null;
        return true;
        //return this.sendSMS(mobile, smsValue, smsUrl, srcTermID, linkId);
    }
    
    /**
     * 发送短信
     * 
     * @param bean
     * @return
     */
    private boolean sendSMS(String mobile, String smsValue, String smsUrl,
            String srcTermID, String linkId) {
        boolean rebool = false;
        try {
            if (mobile != null && mobile.trim().length() > 0
                    && smsValue != null && smsValue.trim().length() > 0) {
                smsValue = URLEncoder.encode(smsValue, "GBK");
                if (smsValue.trim().length() > 0 && mobile.trim().length() > 0) {
                    smsUrl = smsUrl + "?srcTermID=" + srcTermID + "&LinkID="
                            + linkId + "&destTermID=" + mobile + "&msg="
                            + smsValue;
                    URL url = new URL(smsUrl);
                    URLConnection URLconnection = url.openConnection();
                    HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
                    int responseCode = httpConnection.getResponseCode();
                    System.out.println("短信返回码=" + responseCode);
                    if (responseCode == 0) {
                        rebool = true;
                    }
                }
            }
        } catch (Exception ex) {
            return rebool;
        }
        return rebool;
    }

    public static void main(String[] args) {
        String smsHttpAddress = "http://sms.jsfgw.com/.........";
        String LinkID = "123456";
        String srcTermID = "106388081233";
        String isOpenSend = "1";
        String smsUrl = smsHttpAddress;
        SmsSendUtil sms = new SmsSendUtil();
        boolean bool = sms.sendSMS("18761699837", "短信测试....", smsUrl,
                srcTermID, LinkID);
        System.out.println(bool);

    }

}
