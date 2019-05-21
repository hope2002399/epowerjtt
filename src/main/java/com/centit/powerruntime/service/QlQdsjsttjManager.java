package com.centit.powerruntime.service;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.QlQdsjsttj;

public interface QlQdsjsttjManager extends BaseEntityManager<QlQdsjsttj> 
{

    List<QlQdsjsttj> listQlQdsjsttj(Map<String, Object> paramMap);


}
