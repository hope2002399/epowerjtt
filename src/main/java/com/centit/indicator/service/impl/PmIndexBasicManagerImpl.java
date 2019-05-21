package com.centit.indicator.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.indicator.po.PmIndexBasic;
import com.centit.indicator.dao.PmIndexBasicDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.service.PmIndexBasicManager;

public class PmIndexBasicManagerImpl extends BaseEntityManagerImpl<PmIndexBasic>
	implements PmIndexBasicManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(PmIndexBasicManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private PmIndexBasicDao pmIndexBasicDao ;
	public void setPmIndexBasicDao(PmIndexBasicDao baseDao)
	{
		this.pmIndexBasicDao = baseDao;
		setBaseDao(this.pmIndexBasicDao);
	}
	
}

