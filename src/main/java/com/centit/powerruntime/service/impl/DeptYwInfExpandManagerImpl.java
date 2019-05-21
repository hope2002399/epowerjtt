package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.DeptYwInfExpand;
import com.centit.powerruntime.dao.DeptYwInfExpandDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.DeptYwInfExpandManager;

public class DeptYwInfExpandManagerImpl extends BaseEntityManagerImpl<DeptYwInfExpand>
	implements DeptYwInfExpandManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(DeptYwInfExpandManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private DeptYwInfExpandDao deptYwInfExpandDao ;
	public void setDeptYwInfExpandDao(DeptYwInfExpandDao baseDao)
	{
		this.deptYwInfExpandDao = baseDao;
		setBaseDao(this.deptYwInfExpandDao);
	}
	
}

