package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.QlQdywsxtj;
import com.centit.powerruntime.po.QlQdywtj;
import com.centit.powerruntime.po.QlQdzxtj;

public interface QlQdywsxtjManager extends BaseEntityManager<QlQdywsxtj> 
{

    List<QlQdywsxtj> listQlQdywsxtj(Map<String, Object> paramMap);


}
