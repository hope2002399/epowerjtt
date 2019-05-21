package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.OptApplyResult;
import com.centit.powerruntime.dao.OptApplyResultDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.OptApplyResultManager;

public class OptApplyResultManagerImpl extends BaseEntityManagerImpl<OptApplyResult>
	implements OptApplyResultManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(OptApplyResultManager.class);
	

	private OptApplyResultDao optApplyResultDao ;
	public void setOptApplyResultDao(OptApplyResultDao baseDao)
	{
		this.optApplyResultDao = baseDao;
		setBaseDao(this.optApplyResultDao);
	}
    @Override
    public List<OptApplyResult> listOptApplyResult(Map<String, Object> filterMap, PageDesc pageDesc) {
        return optApplyResultDao.listOptApplyResult(filterMap,pageDesc);
    }
	
}

