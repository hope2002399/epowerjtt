package com.centit.powerruntime.service;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.QlQdsjstsxtj;
import com.centit.powerruntime.po.QlQdsjsttj;

public interface QlQdsjstsxtjManager extends BaseEntityManager<QlQdsjstsxtj> 
{

    List<QlQdsjstsxtj> listQlQdsjstsxtj(Map<String, Object> paramMap);


}
