package com.centit.indicator.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.indicator.po.PmIndexTypeLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	

import com.centit.indicator.service.PmIndexTypeLogManager;
	

public class PmIndexTypeLogAction  extends BaseEntityExtremeAction<PmIndexTypeLog>  {
	private static final Log log = LogFactory.getLog(PmIndexTypeLogAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private PmIndexTypeLogManager pmIndexTypeLogMag;
	public void setPmIndexTypeLogManager(PmIndexTypeLogManager basemgr)
	{
		pmIndexTypeLogMag = basemgr;
		this.setBaseEntityManager(pmIndexTypeLogMag);
	}

	
	
		
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}
