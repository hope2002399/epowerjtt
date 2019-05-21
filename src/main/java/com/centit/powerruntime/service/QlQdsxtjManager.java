package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.QlQdsxtj;

public interface QlQdsxtjManager extends BaseEntityManager<QlQdsxtj> 
{

    List<QlQdsxtj> listQlQdsxtj(Map<String, Object> paramMap);


}
