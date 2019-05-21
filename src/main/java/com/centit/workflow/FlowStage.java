package com.centit.workflow;

public interface FlowStage {
    public Long getStageId();

    public Long getVersion();

    public String getFlowCode();

    public String getStageCode();

    public String getStageName();

    public String getIsAccountTime();

    public String getLimitType();

    public String getTimeLimit();

    public String getExpireOpt();

}
