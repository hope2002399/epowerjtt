package com.centit.workflow.sample.po;

import com.centit.workflow.StageInstance;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfStageInstance implements java.io.Serializable, StageInstance {
    private static final long serialVersionUID = 1L;
    private WfStageInstanceId cid;

    private String stageCode;
    private Long promiseTime;
    private Long timeLimit;
    private Long expireOptSign;

    // Constructors
    /** default constructor */
    public WfStageInstance() {
    }

    /** minimal constructor */
    public WfStageInstance(WfStageInstanceId id) {
        this.cid = id;
    }

    /** full constructor */
    public WfStageInstance(WfStageInstanceId id, String stageCode,
            Long promiseTime, Long timeLimit, Long expireOptSign) {
        this.cid = id;

        this.stageCode = stageCode;
        this.promiseTime = promiseTime;
        this.timeLimit = timeLimit;
        this.expireOptSign = expireOptSign;
    }

    public WfStageInstanceId getCid() {
        return this.cid;
    }

    public void setCid(WfStageInstanceId id) {
        this.cid = id;
    }

    public Long getFlowInstId() {
        if (this.cid == null)
            this.cid = new WfStageInstanceId();
        return this.cid.getFlowInstId();
    }

    public void setFlowInstId(Long flowInstId) {
        if (this.cid == null)
            this.cid = new WfStageInstanceId();
        this.cid.setFlowInstId(flowInstId);
    }

    public Long getStageId() {
        if (this.cid == null)
            this.cid = new WfStageInstanceId();
        return this.cid.getStageId();
    }

    public void setStageId(Long stageId) {
        if (this.cid == null)
            this.cid = new WfStageInstanceId();
        this.cid.setStageId(stageId);
    }

    // Property accessors
    public String getStageCode() {
        return this.stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public Long getPromiseTime() {
        return this.promiseTime;
    }

    public void setPromiseTime(Long promiseTime) {
        this.promiseTime = promiseTime;
    }

    public Long getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(Long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Long getExpireOptSign() {
        return this.expireOptSign;
    }

    public void setExpireOptSign(Long expireOptSign) {
        this.expireOptSign = expireOptSign;
    }

    public void copy(WfStageInstance other) {
        this.setFlowInstId(other.getFlowInstId());
        this.setStageId(other.getStageId());
        this.stageCode = other.getStageCode();
        this.promiseTime = other.getPromiseTime();
        this.timeLimit = other.getTimeLimit();
        this.expireOptSign = other.getExpireOptSign();
    }

    public void copyNotNullProperty(WfStageInstance other) {
        if (other.getFlowInstId() != null)
            this.setFlowInstId(other.getFlowInstId());
        if (other.getStageId() != null)
            this.setStageId(other.getStageId());

        if (other.getStageCode() != null)
            this.stageCode = other.getStageCode();
        if (other.getPromiseTime() != null)
            this.promiseTime = other.getPromiseTime();
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getExpireOptSign() != null)
            this.expireOptSign = other.getExpireOptSign();
    }

    public void clearProperties() {
        this.stageCode = null;
        this.promiseTime = null;
        this.timeLimit = null;
        this.expireOptSign = null;
    }
}
