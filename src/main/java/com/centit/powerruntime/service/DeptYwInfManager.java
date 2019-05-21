package com.centit.powerruntime.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.DeptYwInf;

public interface DeptYwInfManager extends BaseEntityManager<DeptYwInf> 
{

    DeptYwInf getDeptYwInfById(String iddeptYwInf);

}
