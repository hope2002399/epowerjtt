package com.centit.supervise.action;

import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.supervise.po.VUserTaskListReconsider;
import com.centit.supervise.service.VUserTaskListReconsiderManager;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class VUserTaskListReconsiderAction extends
        BaseEntityExtremeAction<VUserTaskListReconsider> {
    private static final long serialVersionUID = 1L;
    private VUserTaskListReconsiderManager VUserTaskListReconsiderMag;

    private SysUnitManager sysUnitManager;
    private SysUserManager sysUserManager;

    public void setVUserTaskListReconsiderManager(
            VUserTaskListReconsiderManager basemgr) {
        VUserTaskListReconsiderMag = basemgr;
        this.setBaseEntityManager(VUserTaskListReconsiderMag);
    }

    private String unitsJson;
    private String parentunit;

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
            objList = VUserTaskListReconsiderMag.listObjects(filterMap,
                    pageDesc);
            totalRows = pageDesc.getTotalRows();

            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            String sParentUnit = dept.getUnitcode();
            unitList = sysUnitManager.getAllSubUnits(sParentUnit);
            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
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
