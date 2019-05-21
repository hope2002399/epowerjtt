package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.QlQdzxtj;

public interface QlQdzxtjManager extends BaseEntityManager<QlQdzxtj> 
{

    List<QlQdzxtj> listQlQdzxtj(Map<String, Object> paramMap);


}
