package com.centit.workflow;

public interface StageInstance {
    public Long getFlowInstId();

    public Long getStageId();

    // Property accessors
    public String getStageCode();

    public Long getPromiseTime();

    public Long getTimeLimit();

    public Long getExpireOptSign();

}
