package com.centit.monitor.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Outway;
import com.centit.monitor.po.Outwaycalc;
import com.centit.monitor.service.OutwayManager;
import com.centit.monitor.service.OutwaycalcManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class OutwaycalcAction extends BaseEntityExtremeAction<Outwaycalc> {
    private static final long serialVersionUID = 1L;
    private OutwaycalcManager outwaycalcMag;
    private OutwayManager outwayMag;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private List<Outwaycalc> outwaycalcList;
    private List<Outway> outwayList;
    private String unitsJson;
    private String parentunit;
    private List<FUnitinfo> unitList;

    /**
     * 预报警计算日志查看
     */
    @SuppressWarnings("unchecked")
    public String list() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        outwaycalcList = outwaycalcMag.getOutWayCalcList(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return LIST;
    }

    @SuppressWarnings("unchecked")
    public String outwaylist() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        String orderField = request.getParameter("orderField");
        String orderDirection = request.getParameter("orderDirection");
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        if (!StringUtils.isBlank(orderField)
                && !StringUtils.isBlank(orderDirection)) {
            filterMap.put(CodeBook.SELF_ORDER_BY, orderField + " "
                    + orderDirection);
        }
        filterMap.put("topunitcode", sParentUnit);
        String unitCode = (String) filterMap.get("orgId");
        if (!StringBaseOpt.isNvl(unitCode)) {
            String s_orgId = sysUnitManager.getObjectById(unitCode).getDepno();
            filterMap.put("orgId", s_orgId);
            filterMap.put("topunitcode", s_orgId);
        }
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(unitCode) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("orgId", null);
        }
        outwayList = outwayMag.getOutWayListT(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "outwaylist";
    }

    public List<Outwaycalc> getOutwaycalcList() {
        return outwaycalcList;
    }

    public void setOutwaycalcList(List<Outwaycalc> outwaycalcList) {
        this.outwaycalcList = outwaycalcList;
    }

    public void setOutwaycalcManager(OutwaycalcManager basemgr) {
        outwaycalcMag = basemgr;
        this.setBaseEntityManager(outwaycalcMag);
    }

    public void setOutwaycalcMag(OutwaycalcManager outwaycalcMag) {
        this.outwaycalcMag = outwaycalcMag;
    }

    public List<Outway> getOutwayList() {
        return outwayList;
    }

    public void setOutwayList(List<Outway> outwayList) {
        this.outwayList = outwayList;
    }

    public void setOutwayMag(OutwayManager outwayMag) {
        this.outwayMag = outwayMag;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
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

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }
}
