package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.QlQdzxsxtj;
import com.centit.powerruntime.po.QlQdzxtj;

public interface QlQdzxsxtjManager extends BaseEntityManager<QlQdzxsxtj> 
{

    List<QlQdzxsxtj> listQlQdzxsxtj(Map<String, Object> paramMap);


}
