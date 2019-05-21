package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.QlQdywtj;
import com.centit.powerruntime.po.QlQdzxtj;

public interface QlQdywtjManager extends BaseEntityManager<QlQdywtj> 
{

    List<QlQdywtj> listQlQdywtj(Map<String, Object> paramMap);


}
