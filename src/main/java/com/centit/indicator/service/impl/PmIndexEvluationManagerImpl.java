package com.centit.indicator.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.indicator.po.PmIndexEvluation;
import com.centit.indicator.dao.PmIndexEvluationDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.service.PmIndexEvluationManager;

public class PmIndexEvluationManagerImpl extends BaseEntityManagerImpl<PmIndexEvluation>
	implements PmIndexEvluationManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(PmIndexEvluationManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private PmIndexEvluationDao pmIndexEvluationDao ;
	public void setPmIndexEvluationDao(PmIndexEvluationDao baseDao)
	{
		this.pmIndexEvluationDao = baseDao;
		setBaseDao(this.pmIndexEvluationDao);
	}
	
}

