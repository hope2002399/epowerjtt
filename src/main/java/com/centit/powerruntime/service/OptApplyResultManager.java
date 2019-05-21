package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.OptApplyResult;

public interface OptApplyResultManager extends BaseEntityManager<OptApplyResult> 
{

    List<OptApplyResult> listOptApplyResult(Map<String, Object> filterMap,PageDesc pageDesc);

}
