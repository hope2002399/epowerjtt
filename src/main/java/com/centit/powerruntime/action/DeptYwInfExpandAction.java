package com.centit.powerruntime.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.po.DeptYwInfExpand;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	


		


import com.centit.powerruntime.service.DeptYwInfExpandManager;
	

public class DeptYwInfExpandAction  extends BaseEntityExtremeAction<DeptYwInfExpand>  {
	private static final Log log = LogFactory.getLog(DeptYwInfExpandAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private DeptYwInfExpandManager deptYwInfExpandMag;
	public void setDeptYwInfExpandManager(DeptYwInfExpandManager basemgr)
	{
		deptYwInfExpandMag = basemgr;
		this.setBaseEntityManager(deptYwInfExpandMag);
	}

	
	
		
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}
