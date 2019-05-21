package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.DeptStInf;

public interface DeptStInfManager extends BaseEntityManager<DeptStInf> 
{

    List<DeptStInf> getDepQlInflist(Map<String, Object> filterMap,
            PageDesc pageDesc);

}
