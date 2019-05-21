package com.centit.powerruntime.action;

import java.util.List;
import java.util.Map;

import com.centit.monitor.po.ApplyProcess;
import com.centit.monitor.service.ApplyProcessManager;
import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.po.OptApplyResult;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

	

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;

		

import com.centit.powerruntime.service.OptApplyResultManager;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
	

public class OptApplyResultAction  extends PowerRuntimeEntityAction<OptApplyResult>  {
	private static final Log log = LogFactory.getLog(OptApplyResultAction.class);
	
	
	private static final long serialVersionUID = 1L;
	private OptApplyResultManager optApplyResultMag;
	private SysUserManager sysUserManager;
	private SysUnitManager sysUnitManager;
	private String unitsJson;
    private String parentunit;
    private List<OptApplyResult> srPermitApplyList;
    private ApplyProcessManager applyProcessManager;
	public void setOptApplyResultManager(OptApplyResultManager basemgr)
	{
		optApplyResultMag = basemgr;
		this.setBaseEntityManager(optApplyResultMag);
	}
	public String getUnitsJson() {
        return unitsJson;
    }


    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }


    public String getParentunit() {
        return parentunit;
    }


    public void setParentunit(String parentunit) {
        this.parentunit = parentunit;
    }


    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }


    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }
    
    public List<OptApplyResult> getSrPermitApplyList() {
        return srPermitApplyList;
    }
    public void setSrPermitApplyList(List<OptApplyResult> srPermitApplyList) {
        this.srPermitApplyList = srPermitApplyList;
    }
    
    
    public void setApplyProcessManager(ApplyProcessManager applyProcessManager) {
        this.applyProcessManager = applyProcessManager;
    }
    @SuppressWarnings("unchecked")
    public String list() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            if (StringUtils.isBlank(String.valueOf(filterMap.get("orgcode")))) {
                filterMap.remove("orgcode");
            }
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            if(!StringUtils.isBlank((String)filterMap.get("finishBeginTime"))){
                request.setAttribute("startTime",(String)filterMap.get("finishBeginTime"));
            }else{
                request.setAttribute("startTime","");
            }
            if(!StringUtils.isBlank((String)filterMap.get("finishEndTime"))){
                request.setAttribute("endTime", (String)filterMap.get("finishEndTime"));
            }else{
                request.setAttribute("endTime", "");
            }
            if(!StringUtils.isBlank((String)filterMap.get("applyBeginTime"))){
                request.setAttribute("startDate",(String)filterMap.get("applyBeginTime"));
            }else{
                request.setAttribute("startDate","");
            }
            if(!StringUtils.isBlank((String)filterMap.get("applyEndTime"))){
                request.setAttribute("endDate", (String)filterMap.get("applyEndTime"));
            }else{
                request.setAttribute("endDate", "");
            }
            srPermitApplyList = optApplyResultMag.listOptApplyResult(filterMap,pageDesc);
            totalRows = pageDesc.getTotalRows();

           /* unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();*/
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    
    public String view() {
        // 查看办件业务数据信息
        object = optApplyResultMag.getObjectById(object.getInternalNo());
        // 查看过程日志
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put("internalNo", object.getInternalNo());
        List<ApplyProcess> processList=applyProcessManager.listObjects(filterMap);
        request.setAttribute("processList", processList);
        return "view";
    }
    
    
}
