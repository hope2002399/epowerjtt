package com.centit.complaint.action;

import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.complaint.po.VUserTaskListComplaint;
import com.centit.complaint.service.VUserTaskListComplaintManager;
import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class VUserTaskListComplaintAction extends
        BaseEntityExtremeAction<VUserTaskListComplaint> {
    private static final long serialVersionUID = 1L;
    private VUserTaskListComplaintManager vusertasklistcomplaintMag;
    private SysUnitManager sysUnitManager;
    private SysUserManager sysUserManager;

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public void setVusertasklistcomplaintMag(
            VUserTaskListComplaintManager vusertasklistcomplaintMag) {
        this.vusertasklistcomplaintMag = vusertasklistcomplaintMag;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    private List<FUnitinfo> unitList;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    private String unitsJson;
    private String parentunit;

    /**
     * 投诉办理列表查询
     */
    public String list() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            String userCode = fuser.getUsercode();
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            filterMap.put("userCode", userCode);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            objList = vusertasklistcomplaintMag
                    .listObjects(filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();

            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            String sParentUnit = dept.getUnitcode();
            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            unitList = sysUnitManager.getAllSubUnits(sParentUnit);
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
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

}
