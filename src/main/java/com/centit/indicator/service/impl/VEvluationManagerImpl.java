package com.centit.indicator.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.indicator.po.VEvluation;
import com.centit.indicator.dao.VEvluationDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.service.VEvluationManager;

public class VEvluationManagerImpl extends BaseEntityManagerImpl<VEvluation>
	implements VEvluationManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(VEvluationManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private VEvluationDao VEvluationDao ;
	public void setVEvluationDao(VEvluationDao baseDao)
	{
		this.VEvluationDao = baseDao;
		setBaseDao(this.VEvluationDao);
	}
	
}

