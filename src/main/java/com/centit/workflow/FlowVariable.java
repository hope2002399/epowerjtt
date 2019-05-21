package com.centit.workflow;

import java.util.Set;

public interface FlowVariable {
    public Long getFlowInstId();

    public String getRunToken();

    public String getVarName();

    public String getVarValue();

    public String getVarType();

    public Set<String> getVarSet();

}
