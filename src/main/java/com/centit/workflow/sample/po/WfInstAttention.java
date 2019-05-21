package com.centit.workflow.sample.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfInstAttention implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private WfInstAttentionId cid;

    private Date attSetTime;
    private String attSetUser;
    private String attSetMemo;

    // Constructors
    /** default constructor */
    public WfInstAttention() {
    }

    /** minimal constructor */
    public WfInstAttention(WfInstAttentionId id

    ) {
        this.cid = id;

    }

    /** full constructor */
    public WfInstAttention(WfInstAttentionId id

    , Date attSetTime, String attSetUser, String attSetMemo) {
        this.cid = id;

        this.attSetTime = attSetTime;
        this.attSetUser = attSetUser;
        this.attSetMemo = attSetMemo;
    }

    public WfInstAttention(String userCode, Long flowInstId, Date attSetTime,
            String attSetUser) {
        this.cid = new WfInstAttentionId(userCode, flowInstId);
        this.attSetTime = attSetTime;
        this.attSetUser = attSetUser;
    }

    public WfInstAttentionId getCid() {
        return this.cid;
    }

    public void setCid(WfInstAttentionId id) {
        this.cid = id;
    }

    public String getUserCode() {
        if (this.cid == null)
            this.cid = new WfInstAttentionId();
        return this.cid.getUserCode();
    }

    public void setUserCode(String userCode) {
        if (this.cid == null)
            this.cid = new WfInstAttentionId();
        this.cid.setUserCode(userCode);
    }

    public Long getFlowInstId() {
        if (this.cid == null)
            this.cid = new WfInstAttentionId();
        return this.cid.getFlowInstId();
    }

    public void setFlowInstId(Long flowInstId) {
        if (this.cid == null)
            this.cid = new WfInstAttentionId();
        this.cid.setFlowInstId(flowInstId);
    }

    // Property accessors

    public Date getAttSetTime() {
        return this.attSetTime;
    }

    public void setAttSetTime(Date attSetTime) {
        this.attSetTime = attSetTime;
    }

    public String getAttSetUser() {
        return this.attSetUser;
    }

    public void setAttSetUser(String attSetUser) {
        this.attSetUser = attSetUser;
    }

    public String getAttSetMemo() {
        return this.attSetMemo;
    }

    public void setAttSetMemo(String attSetMemo) {
        this.attSetMemo = attSetMemo;
    }

    public void copy(WfInstAttention other) {

        this.setUserCode(other.getUserCode());
        this.setFlowInstId(other.getFlowInstId());

        this.attSetTime = other.getAttSetTime();
        this.attSetUser = other.getAttSetUser();
        this.attSetMemo = other.getAttSetMemo();

    }

    public void copyNotNullProperty(WfInstAttention other) {

        if (other.getUserCode() != null)
            this.setUserCode(other.getUserCode());
        if (other.getFlowInstId() != null)
            this.setFlowInstId(other.getFlowInstId());

        if (other.getAttSetTime() != null)
            this.attSetTime = other.getAttSetTime();
        if (other.getAttSetUser() != null)
            this.attSetUser = other.getAttSetUser();
        if (other.getAttSetMemo() != null)
            this.attSetMemo = other.getAttSetMemo();

    }

    public void clearProperties() {

        this.attSetTime = null;
        this.attSetUser = null;
        this.attSetMemo = null;

    }
}
