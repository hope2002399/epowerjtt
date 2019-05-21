package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.VDeptYwBmdy;
import com.centit.powerruntime.dao.VDeptYwBmdyDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.VDeptYwBmdyManager;

public class VDeptYwBmdyManagerImpl extends BaseEntityManagerImpl<VDeptYwBmdy>
	implements VDeptYwBmdyManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(VDeptYwBmdyManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private VDeptYwBmdyDao vDeptYwBmdyDao ;

    public void setVDeptYwBmdyDao(VDeptYwBmdyDao baseDao)
	{
		this.vDeptYwBmdyDao = baseDao;
		setBaseDao(this.vDeptYwBmdyDao);
	}
   
	
}

