package com.centit.powerruntime.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.po.DeptQlInf;
import com.centit.powerruntime.po.DeptYwInf;
import com.centit.powerruntime.po.VDeptYwBmdy;
import com.centit.powerruntime.po.YwFile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	


		











import com.centit.powerruntime.service.DeptYwInfManager;
import com.centit.powerruntime.service.VDeptYwBmdyManager;
import com.centit.powerruntime.service.YwFileManager;
	

public class VDeptYwBmdyAction  extends BaseEntityExtremeAction<VDeptYwBmdy>  {
	private static final Log log = LogFactory.getLog(VDeptYwBmdyAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private VDeptYwBmdyManager vDeptYwbmdyMag;
	/*private YwFileManager ywFileManager;
	
	public void setYwFileManager(YwFileManager ywFileManager) {
        this.ywFileManager = ywFileManager;
    }
*/
    public void setVDeptYwBmdyManager(VDeptYwBmdyManager basemgr)
	{
        vDeptYwbmdyMag = basemgr;
		this.setBaseEntityManager(vDeptYwbmdyMag);
	}
	
	
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}
