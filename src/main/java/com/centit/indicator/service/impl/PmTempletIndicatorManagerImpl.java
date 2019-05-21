package com.centit.indicator.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.indicator.po.PmTempletIndicator;
import com.centit.indicator.dao.PmTempletIndicatorDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.service.PmTempletIndicatorManager;

public class PmTempletIndicatorManagerImpl extends BaseEntityManagerImpl<PmTempletIndicator>
	implements PmTempletIndicatorManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(PmTempletIndicatorManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private PmTempletIndicatorDao pmTempletIndicatorDao ;
	public void setPmTempletIndicatorDao(PmTempletIndicatorDao baseDao)
	{
		this.pmTempletIndicatorDao = baseDao;
		setBaseDao(this.pmTempletIndicatorDao);
	}
	
}

