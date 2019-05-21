package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.DeptQlInf;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.DeptStInf;
import com.centit.powerruntime.dao.DeptQlInfDao;
import com.centit.powerruntime.dao.DeptStInfDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.DeptQlInfManager;

public class DeptQlInfManagerImpl extends BaseEntityManagerImpl<DeptQlInf>
	implements DeptQlInfManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(DeptQlInfManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private DeptQlInfDao deptQlInfDao ;
	
	
    public void setDeptQlInfDao(DeptQlInfDao baseDao)
	{
		this.deptQlInfDao = baseDao;
		setBaseDao(this.deptQlInfDao);
	}
    
	
}

