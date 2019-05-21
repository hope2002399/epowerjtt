package com.centit.powerruntime.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.AmOrg;

public interface AmOrgManager extends BaseEntityManager<AmOrg> 
{

    String getByOrgcode(String area, String orgcode);

}
