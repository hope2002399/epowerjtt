package com.centit.powerruntime.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.OptBaseInfoNet;

public interface OptBaseInfoNetManager extends
        BaseEntityManager<OptBaseInfoNet> {
    public OptBaseInfoNet getOptBaseNetByFlowId(Long flowinstid);

    // public String getOptBaseNetJsonBydjId(String djId);
    public String getOptBaseNetJsonBynetId(String netId);

    public int getNumOfsameModel(String codeModel, String year);
}
