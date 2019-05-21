package com.centit.powerruntime.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.po.AmOrg;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	


		


import com.centit.powerruntime.service.AmOrgManager;
	

public class AmOrgAction  extends BaseEntityExtremeAction<AmOrg>  {
	private static final Log log = LogFactory.getLog(AmOrgAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private AmOrgManager amOrgMag;
	public void setAmOrgManager(AmOrgManager basemgr)
	{
		amOrgMag = basemgr;
		this.setBaseEntityManager(amOrgMag);
	}

	
	
		
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}
