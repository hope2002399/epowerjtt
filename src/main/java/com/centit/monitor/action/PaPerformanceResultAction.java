package com.centit.monitor.action;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.PaMonthCheckup;
import com.centit.monitor.po.PaPerformanceResult;
import com.centit.monitor.po.Pamonthpunish;
import com.centit.monitor.service.PaMonthCheckupManager;
import com.centit.monitor.service.PaPerformanceResultManager;
import com.centit.monitor.service.PacheckupparamManager;
import com.centit.monitor.service.PamonthpunishManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.ibm.icu.text.SimpleDateFormat;

public class PaPerformanceResultAction extends
        BaseEntityExtremeAction<PaPerformanceResult> {
    private static final long serialVersionUID = 1L;
    private PaPerformanceResultManager paPerformanceResultManager;
    // 页面要用到的一些变量

    private String unitsJson;

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

    private String parentunit;
    private List<PaPerformanceResult> paPerformancneList;

    public List<PaPerformanceResult> getPaPerformancneList() {
        return paPerformancneList;
    }

    public void setPaPerformancneList(
            List<PaPerformanceResult> paPerformancneList) {
        this.paPerformancneList = paPerformancneList;
    }

    public void setPaPerformanceResultManager(PaPerformanceResultManager basemgr) {
        paPerformanceResultManager = basemgr;
        this.setBaseEntityManager(paPerformanceResultManager);
    }

    private SysUserManager sysUserManager;

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    private SysUnitManager sysUnitManager;

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    private List<FUnitinfo> unitList;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    private PaMonthCheckupManager paMonthCheckupMag;

    public void setPaMonthCheckupMag(PaMonthCheckupManager paMonthCheckupMag) {
        this.paMonthCheckupMag = paMonthCheckupMag;
    }

    private PacheckupparamManager pacheckupparamMag;

    public void setPacheckupparamMag(PacheckupparamManager pacheckupparamMag) {
        this.pacheckupparamMag = pacheckupparamMag;
    }

    private List<PaMonthCheckup> checklist;

    public List<PaMonthCheckup> getChecklist() {
        return checklist;
    }

    public void setChecklist(List<PaMonthCheckup> checklist) {
        this.checklist = checklist;
    }

    public List<Pamonthpunish> rglrlist;

    public List<Pamonthpunish> getRglrlist() {
        return rglrlist;
    }

    public void setRglrlist(List<Pamonthpunish> rglrlist) {
        this.rglrlist = rglrlist;
    }

    private PamonthpunishManager pamonthpunishManager;

    public void setPamonthpunishManager(
            PamonthpunishManager pamonthpunishManager) {
        this.pamonthpunishManager = pamonthpunishManager;
    }

    private Pamonthpunish pamonthpunish;

    private boolean bl;

    public boolean isBl() {
        return bl;
    }

    public void setBl(boolean bl) {
        this.bl = bl;
    }

    public Pamonthpunish getPamonthpunish() {
        return pamonthpunish;
    }

    public void setPamonthpunish(Pamonthpunish pamonthpunish) {
        this.pamonthpunish = pamonthpunish;
    }

    /**
     * 绩效得分查询
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String list() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String unitCode = (String) filterMap.get("orgId");
        filterMap.put("orgId", unitCode);
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(unitCode) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("orgId", null);
        }
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 树形部门菜单
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        paPerformancneList = paPerformanceResultManager.getPaPerformancneList(
                filterMap, pageDesc);//
        totalRows = pageDesc.getTotalRows();
        return LIST;
    }

    /**
     * 审核
     * 
     * @return
     */
    public String auditsh() {
        Long checkNo = (Long) request.getAttribute("checkNo");
        this.editInitial();
        FUserDetail user = ((FUserDetail) getLoginUser());
        object.setCheckNo(checkNo);
        object.setAuditor(user.getUsername());
        return "auditsh";
    }

    public String editInitial() {
        PaPerformanceResult probject = new PaPerformanceResult();
        FUserDetail user = ((FUserDetail) getLoginUser());
        object.setAuditor(user.getLoginname());
        object.setAuditDate(new Date(System.currentTimeMillis()));
        baseEntityManager.copyObjectNotNullProperty(probject, object);
        try {

            object = getEntityClass().newInstance();
            object.clearProperties();
            return EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 保存审核
     * 
     * @return
     */
    public String prupdate() {
        try {
            PaPerformanceResult probject = new PaPerformanceResult();
            FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
            probject = paPerformanceResultManager.getUpdateNo(object
                    .getCheckNo());
            if (probject != null) {
                probject.setAuditor(user.getUsername());
                probject.setAuditDesc(object.getAuditDesc());
                probject.setAuditResult(object.getAuditResult());
                probject.setAuditDate(DatetimeOpt.currentUtilDate());// 更新时间为默认系统时间
                paPerformanceResultManager.pamonthpunishSave(probject);

            }
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }

        return this.list();
    }

    /**
     * 查看明细
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String view() {
        String countYear = (String) request.getAttribute("countYear");
        String countMonth = (String) request.getAttribute("countMonth");
        String orgId = (String) request.getAttribute("orgId");
        // String checkType = (String) request.getAttribute("checkType");
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put("orgId", orgId);
        filterMap.put("countYear", countYear);
        filterMap.put("countMonth", countMonth);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        checklist = paMonthCheckupMag.getCheckList(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        // 根据部门年月获取该部门的人工录入绩效明细
        rglrlist = pamonthpunishManager.getPamonthpunishList(filterMap,
                pageDesc);
        request.setAttribute("rglrlist", rglrlist);
        return "clist";
    }

    public String delete() {
        super.delete();
        return "delete";
    }

    /**
     * 针对某一个部门计算绩效得分
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String jsperformance() {

        Map<Object, Object> paramMap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        String onlyCalcSum = (String) filterMap.get("onlyCalcSun");// 仅计算总分的参数
        String deleteOld = (String) filterMap.get("deleteOld");// 重算时的参数
        String year = object.getCountYear();
        String month = object.getCountMonth();
        String orgId = object.getOrgId();
        String yearandmonth = year + "-" + month + "-" + 30;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        try {
            date = sdf.parse(yearandmonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date yearAndmonth = new java.sql.Date(date.getTime());

        // 仅计算总分的参数
        if (onlyCalcSum != null) {
            onlyCalcSum = "1";
        } else {
            onlyCalcSum = "0";
        }
        // 重算时的参数
        if (deleteOld != null) {
            deleteOld = "1";
        } else {
            deleteOld = "0";
        }
        bl = pacheckupparamMag.insertPerformancedep(orgId, yearAndmonth,
                deleteOld, onlyCalcSum);
        return this.view();
    }
}
