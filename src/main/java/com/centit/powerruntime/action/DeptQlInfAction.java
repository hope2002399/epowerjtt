package com.centit.powerruntime.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.DeptQlInf;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.DeptStInf;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

import com.centit.powerruntime.service.DeptQlInfManager;
import com.centit.powerruntime.service.DeptStInfManager;
import com.centit.sys.security.FUserDetail;
	

public class DeptQlInfAction  extends BaseEntityExtremeAction<DeptQlInf>  {
	private static final Log log = LogFactory.getLog(DeptQlInfAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private DeptQlInfManager deptQlInfMag;
	
    public void setDeptQlInfManager(DeptQlInfManager basemgr)
	{
		deptQlInfMag = basemgr;
		this.setBaseEntityManager(deptQlInfMag);
	}
	
		
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}
