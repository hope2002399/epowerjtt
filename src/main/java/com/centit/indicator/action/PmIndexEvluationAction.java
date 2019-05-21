package com.centit.indicator.action;

import java.util.List;
import java.util.Map;

import com.centit.indicator.po.PmIndexEvluation;
import com.centit.indicator.po.VEvluation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

	

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;

		

import com.centit.indicator.service.PmIndexEvluationManager;
import com.centit.indicator.service.VEvluationManager;
	

public class PmIndexEvluationAction  extends BaseEntityExtremeAction<PmIndexEvluation>  {
	private static final Log log = LogFactory.getLog(PmIndexEvluationAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private PmIndexEvluationManager pmIndexEvluationMag;
	private VEvluationManager vEvluationManager;
	private List<VEvluation> vEvluationList;
	public void setPmIndexEvluationManager(PmIndexEvluationManager basemgr)
	{
		pmIndexEvluationMag = basemgr;
		this.setBaseEntityManager(pmIndexEvluationMag);
	}

	public String list(){
		Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        vEvluationList=vEvluationManager.listObjects(filterMap, pageDesc);
        totalRows=pageDesc.getTotalRows();
		return LIST;
	}
	
		
	public String view(){
		VEvluation vEvluation=vEvluationManager.getObjectById(object.getEvlId());
		request.setAttribute("vEvluation", vEvluation);
		return VIEW;
	}
	
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}




	public void setVEvluationManager(VEvluationManager vEvluationManager) {
		this.vEvluationManager = vEvluationManager;
	}

	public List<VEvluation> getVEvluationList() {
		return vEvluationList;
	}

	public void setVEvluationList(List<VEvluation> vEvluationList) {
		this.vEvluationList = vEvluationList;
	}
}
