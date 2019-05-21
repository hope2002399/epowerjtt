package com.centit.powerruntime.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.po.OptApplyResult;
import com.centit.powerruntime.po.OptPickupMessage;
import com.centit.powerruntime.po.OptRelevancyResult;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

	

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;

		

import com.centit.powerruntime.service.OptApplyResultManager;
import com.centit.powerruntime.service.OptRelevancyResultManager;
import com.centit.sys.security.FUserDetail;
	

public class OptRelevancyResultAction  extends PowerRuntimeEntityAction<OptRelevancyResult>  implements
ServletResponseAware{
	private static final Log log = LogFactory.getLog(OptRelevancyResultAction.class);
	
	
	private static final long serialVersionUID = 1L;
	private OptRelevancyResultManager optRelevancyResultMag;
	private List<OptApplyResult> srPermitApplyList;
	private OptApplyResultManager optApplyResultManager;
	
	public void setOptRelevancyResultManager(OptRelevancyResultManager basemgr)
	{
		optRelevancyResultMag = basemgr;
		this.setBaseEntityManager(optRelevancyResultMag);
	}
	
	public List<OptApplyResult> getSrPermitApplyList() {
        return srPermitApplyList;
    }

    public void setSrPermitApplyList(List<OptApplyResult> srPermitApplyList) {
        this.srPermitApplyList = srPermitApplyList;
    }

    public void setOptApplyResultManager(OptApplyResultManager optApplyResultManager) {
        this.optApplyResultManager = optApplyResultManager;
    }
    
/*    public String edit() {
	    FUserDetail fuser = ((FUserDetail) getLoginUser());
	    String internalNo=object.getInternalNo();
	    object = optRelevancyResultMag.getObjectById(internalNo);
	    if(object!=null){
	        
	    }else{
	        object=new OptRelevancyResult();
	        object.setInternalNo(internalNo);
	        object.setUpdatedate(new Date(System.currentTimeMillis()));
	        object.setUsername(fuser.getUsername());
	    }
        return "edit";
    }*/
    
    public String edit() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        String internalNo=object.getInternalNo();
        try {
            if (object == null) {
                object = getEntityClass().newInstance();
            } else {
                OptRelevancyResult o = optRelevancyResultMag.getObject(object);
                if (o != null) {
                    optRelevancyResultMag.copyObject(object, o);
                } else {
                    optRelevancyResultMag.clearObjectProperties(object);
                    object=new OptRelevancyResult();
                    object.setInternalNo(internalNo);
                    object.setUpdatedate(new Date(System.currentTimeMillis()));
                    object.setUsername(fuser.getUsername());
                }
            }
            return EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
	
	public String save() {
	    OptRelevancyResult o = optRelevancyResultMag.getObject(object);
        if (o != null) {
            optRelevancyResultMag.copyObjectNotNullProperty(o, object);
            object = o;
            optRelevancyResultMag.updateResult(object);
        }else{
            object.setUpdatedate(new Date(System.currentTimeMillis()));
            optRelevancyResultMag.saveResult(object);
        }
        
	    return this.list();
	}
	
	
	
	public String list() {
        try {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            if (StringUtils.isBlank(String.valueOf(filterMap.get("orgcode")))) {
                filterMap.remove("orgcode");
            }
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            request.setAttribute("startTime","");
            request.setAttribute("endTime", "");
            request.setAttribute("startDate","");
            request.setAttribute("endDate", "");
            srPermitApplyList = optApplyResultManager.listOptApplyResult(filterMap,pageDesc);
            totalRows = pageDesc.getTotalRows();
            return "list";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    @Override
    public void setServletResponse(HttpServletResponse arg0) {
        // TODO Auto-generated method stub
        
    }
	
}
