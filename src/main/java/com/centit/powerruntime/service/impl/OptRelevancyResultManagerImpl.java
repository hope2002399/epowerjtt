package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.OptRelevancyResult;
import com.centit.powerruntime.dao.OptRelevancyResultDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.OptRelevancyResultManager;

public class OptRelevancyResultManagerImpl extends BaseEntityManagerImpl<OptRelevancyResult>
	implements OptRelevancyResultManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(OptRelevancyResultManager.class);
	

	private OptRelevancyResultDao optRelevancyResultDao ;
	public void setOptRelevancyResultDao(OptRelevancyResultDao baseDao)
	{
		this.optRelevancyResultDao = baseDao;
		setBaseDao(this.optRelevancyResultDao);
	}
    @Override
    public void saveResult(OptRelevancyResult relevancyResult) {
        optRelevancyResultDao.saveResult(relevancyResult);
        
    }
    @Override
    public void updateResult(OptRelevancyResult relevancyResult) {
        optRelevancyResultDao.updateResult(relevancyResult);
        
    }
	
}

