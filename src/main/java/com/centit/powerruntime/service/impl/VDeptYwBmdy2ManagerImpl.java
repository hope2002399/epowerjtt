package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.VDeptYwBmdy2;
import com.centit.powerruntime.dao.VDeptYwBmdy2Dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.VDeptYwBmdy2Manager;

public class VDeptYwBmdy2ManagerImpl extends BaseEntityManagerImpl<VDeptYwBmdy2>
	implements VDeptYwBmdy2Manager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(VDeptYwBmdy2Manager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private VDeptYwBmdy2Dao vDeptYwBmdy2Dao ;

    public void setVDeptYwBmdy2Dao(VDeptYwBmdy2Dao baseDao)
	{
		this.vDeptYwBmdy2Dao = baseDao;
		setBaseDao(this.vDeptYwBmdy2Dao);
	}
   
	
}

