package com.centit.supervise.action;

import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.supervise.po.VUserTaskListSupervise;
import com.centit.supervise.service.VUserTaskListSuperviseManager;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class VUserTaskListSuperviseAction extends
        BaseEntityExtremeAction<VUserTaskListSupervise> {
    private static final long serialVersionUID = 1L;
    private VUserTaskListSuperviseManager VUserTaskListSuperviseMag;

    private SysUnitManager sysUnitManager;
    private SysUserManager sysUserManager;

    private String unitsJson;
    private String parentunit;

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

    public void setVUserTaskListSuperviseManager(
            VUserTaskListSuperviseManager basemgr) {
        VUserTaskListSuperviseMag = basemgr;
        this.setBaseEntityManager(VUserTaskListSuperviseMag);
    }

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
            // List<FUnitinfo> templist1=sysUnitManager.getSubUnits("1");

            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            // String sParentUnit = dept.getUnitcode();
            // unitList = sysUnitManager.getAllSubUnits(sParentUnit);

            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();

            if (filterMap.get("queryUnderUnit") != null
                    && !filterMap.get("queryUnderUnit").equals("")
                    && filterMap.get("unitCode") != null
                    && !filterMap.get("unitCode").equals("")) {

                StringBuilder temp = new StringBuilder();
                List<FUnitinfo> templist = sysUnitManager
                        .getSubUnits((String) filterMap.get("unitCode"));
                for (FUnitinfo f : templist) {
                    temp.append(",'").append(f.getUnitcode()).append("'");
                }
                // filterMap.put("subunit",temp.substring(1) );
                String hql = "From VUserTaskListSupervise  where  unitCode in("
                        + temp.substring(1) + ") ";
                filterMap.put("unitCode", "");
                objList = VUserTaskListSuperviseMag.listObjects(hql, filterMap,
                        pageDesc);
            } else {

                objList = VUserTaskListSuperviseMag.listObjects(filterMap,
                        pageDesc);
            }
            totalRows = pageDesc.getTotalRows();

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

}
