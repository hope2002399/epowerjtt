package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.AmOrg;
import com.centit.powerruntime.po.QlQdtj;

public interface QlQdtjManager extends BaseEntityManager<QlQdtj> 
{

    List<QlQdtj> listQlQdtj(Map<String, Object> paramMap);


}
