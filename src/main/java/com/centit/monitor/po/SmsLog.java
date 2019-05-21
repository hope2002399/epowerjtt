package com.centit.monitor.po;


import java.util.Date;




public class SmsLog implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    
    
    private String id;//主键
    
    private String netId; //关联DJ_id
    
    private String smsPhones;//发送手机号
    
    private String smsNames;//接收人名称
    
    private String smsUsercodes;//接收人code
    
    private String smsContent;//发送内容
    
    private String smsSendstatus;//发送状态
    
    private String smsType;//发送类型
    
    private Date smsSendtime;//发送时间
    
    private String smsSendReturnStatus; //发送返回状态码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSmsPhones() {
        return smsPhones;
    }

    public void setSmsPhones(String smsPhones) {
        this.smsPhones = smsPhones;
    }

    public String getSmsNames() {
        return smsNames;
    }

    public void setSmsNames(String smsNames) {
        this.smsNames = smsNames;
    }

    public String getSmsUsercodes() {
        return smsUsercodes;
    }

    public void setSmsUsercodes(String smsUsercodes) {
        this.smsUsercodes = smsUsercodes;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getSmsSendstatus() {
        return smsSendstatus;
    }

    public void setSmsSendstatus(String smsSendstatus) {
        this.smsSendstatus = smsSendstatus;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public Date getSmsSendtime() {
        return smsSendtime;
    }

    public void setSmsSendtime(Date smsSendtime) {
        this.smsSendtime = smsSendtime;
    }

    public String getSmsSendReturnStatus() {
        return smsSendReturnStatus;
    }

    public void setSmsSendReturnStatus(String smsSendReturnStatus) {
        this.smsSendReturnStatus = smsSendReturnStatus;
    }

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    
}
