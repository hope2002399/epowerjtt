package com.centit.indicator.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.indicator.po.PmIndexBasic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	

import com.centit.indicator.service.PmIndexBasicManager;
	

public class PmIndexBasicAction  extends BaseEntityExtremeAction<PmIndexBasic>  {
	private static final Log log = LogFactory.getLog(PmIndexBasicAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private PmIndexBasicManager pmIndexBasicMag;
	public void setPmIndexBasicManager(PmIndexBasicManager basemgr)
	{
		pmIndexBasicMag = basemgr;
		this.setBaseEntityManager(pmIndexBasicMag);
	}

	
	
		
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}
