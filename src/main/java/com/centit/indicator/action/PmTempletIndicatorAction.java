package com.centit.indicator.action;

import com.centit.indicator.po.PmTempletIndicator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.indicator.service.PmTempletIndicatorManager;
public class PmTempletIndicatorAction  extends BaseEntityExtremeAction<PmTempletIndicator>  {
	private static final Log log = LogFactory.getLog(PmTempletIndicatorAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private PmTempletIndicatorManager pmTempletIndicatorMag;
	public void setPmTempletIndicatorManager(PmTempletIndicatorManager basemgr)
	{
		pmTempletIndicatorMag = basemgr;
		this.setBaseEntityManager(pmTempletIndicatorMag);
	}

	
	
		
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}
