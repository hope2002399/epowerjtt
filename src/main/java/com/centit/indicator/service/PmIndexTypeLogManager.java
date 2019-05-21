package com.centit.indicator.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.indicator.po.PmIndexTypeLog;

public interface PmIndexTypeLogManager extends BaseEntityManager<PmIndexTypeLog> 
{
	public PmIndexTypeLog getLogByTempId(String templatId,String indicatorId);
}
