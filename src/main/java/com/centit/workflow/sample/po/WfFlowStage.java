package com.centit.workflow.sample.po;

import com.centit.workflow.FlowStage;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfFlowStage implements java.io.Serializable, FlowStage {
    private static final long serialVersionUID = 1L;

    private Long stageId;

    private Long version;
    private String flowCode;
    private String stageCode;
    private String stageName;
    private String isAccountTime;
    private String limitType;
    private String timeLimit;
    private String expireOpt;

    // Constructors
    /** default constructor */
    public WfFlowStage() {
    }

    /** minimal constructor */
    public WfFlowStage(Long stageId, String stageCode) {

        this.stageId = stageId;

        this.stageCode = stageCode;
    }

    /** full constructor */
    public WfFlowStage(Long stageId, Long version, String flowCode,
            String stageCode, String stageName, String isAccountTime,
            String limitType, String timeLimit, String expireOpt) {

        this.stageId = stageId;

        this.version = version;
        this.flowCode = flowCode;
        this.stageCode = stageCode;
        this.stageName = stageName;
        this.isAccountTime = isAccountTime;
        this.limitType = limitType;
        this.timeLimit = timeLimit;
        this.expireOpt = expireOpt;
    }

    public Long getStageId() {
        return this.stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    // Property accessors

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFlowCode() {
        return this.flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public String getStageCode() {
        return this.stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStageName() {
        return this.stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getIsAccountTime() {
        return this.isAccountTime;
    }

    public void setIsAccountTime(String isAccountTime) {
        this.isAccountTime = isAccountTime;
    }

    public String getLimitType() {
        return this.limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getExpireOpt() {
        return this.expireOpt;
    }

    public void setExpireOpt(String expireOpt) {
        this.expireOpt = expireOpt;
    }

    public void copy(WfFlowStage other) {

        this.setStageId(other.getStageId());

        this.version = other.getVersion();
        this.flowCode = other.getFlowCode();
        this.stageCode = other.getStageCode();
        this.stageName = other.getStageName();
        this.isAccountTime = other.getIsAccountTime();
        this.limitType = other.getLimitType();
        this.timeLimit = other.getTimeLimit();
        this.expireOpt = other.getExpireOpt();

    }

    public void copyNotNullProperty(WfFlowStage other) {

        if (other.getStageId() != null)
            this.setStageId(other.getStageId());

        if (other.getVersion() != null)
            this.version = other.getVersion();
        if (other.getFlowCode() != null)
            this.flowCode = other.getFlowCode();
        if (other.getStageCode() != null)
            this.stageCode = other.getStageCode();
        if (other.getStageName() != null)
            this.stageName = other.getStageName();
        if (other.getIsAccountTime() != null)
            this.isAccountTime = other.getIsAccountTime();
        if (other.getLimitType() != null)
            this.limitType = other.getLimitType();
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getExpireOpt() != null)
            this.expireOpt = other.getExpireOpt();

    }

    public void clearProperties() {

        this.version = null;
        this.flowCode = null;
        this.stageCode = null;
        this.stageName = null;
        this.isAccountTime = null;
        this.limitType = null;
        this.timeLimit = null;
        this.expireOpt = null;

    }
}
