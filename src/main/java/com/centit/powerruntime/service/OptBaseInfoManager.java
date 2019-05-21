package com.centit.powerruntime.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.OptBaseInfo;

public interface OptBaseInfoManager extends BaseEntityManager<OptBaseInfo> {
    public OptBaseInfo getOptBaseByFlowId(Long flowinstid);

    public String getOptBaseJson(String djId);

    public void updateBizType(String djId, String rolecode);

    public int getNumOfsameModel(String codeModel, String year);

    public String isSimpleTransAffairNo(String djId, String transAffairNo);
}
