package com.centit.monitor.action;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Supervisorypersonnel;
import com.centit.monitor.service.SupervisorypersonnelManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class SupervisorypersonnelAction extends
        BaseEntityExtremeAction<Supervisorypersonnel> implements
        ServletResponseAware {
    private static final long serialVersionUID = 1L;
    // manager管理
    private SupervisorypersonnelManager supervisoryPersonnelMag;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    // 变量管理
    HttpServletResponse response;
    private List<FUnitinfo> unitList;
    private List<FUserinfo> userlist;
    private String flag = "1";// 默认申报（1）、审核（2）、查询（3）
    private String isPass = "1";// 默认通过（1），不通过（2）
    private List<Supervisorypersonnel> supervisorypersonneList;
    private String unitsJson;
    private String parentunit;
    private String dep_industry;

    public void setSupervisorypersonnelManager(
            SupervisorypersonnelManager basemgr) {
        supervisoryPersonnelMag = basemgr;
        this.setBaseEntityManager(supervisoryPersonnelMag);
    }

    /**
     *  监察人员申报list
     * @return
     */
    @SuppressWarnings("unchecked")
    public String supervisorypersonnelSBList() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);// 这个是配置查询条件的
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);// 获取所分配的部门
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String flag_temp = "SB";
        String unitCode = (String) filterMap.get("orgcode");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringUtils.isBlank(unitCode)) {
            String unitCodeT = sysUnitManager.getObjectById(unitCode)
                    .getDepno();
            filterMap.put("deptcode", unitCodeT);
        }
        if ("true".equals(s_queryUnderUnit) && !StringUtils.isBlank(unitCode)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("deptcode", null);
        }
        filterMap.put("NP_stateSB", true);
        supervisorypersonneList = supervisoryPersonnelMag
                .supervisorypersonnelSBList(flag_temp, filterMap, pageDesc);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        totalRows = pageDesc.getTotalRows();
        return "SBList";
    }

    /**
     *  监察人员审核list
     * @return
     */
    @SuppressWarnings("unchecked")
    public String supervisorypersonnelSHList() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);// 这个是配置查询条件的
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);// 获取所分配的部门
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String flag_temp = "SB";
        String unitCode = (String) filterMap.get("orgcode");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringUtils.isBlank(unitCode)) {
            String unitCodeT = sysUnitManager.getObjectById(unitCode)
                    .getDepno();
            filterMap.put("deptcode", unitCodeT);
        }
        if ("true".equals(s_queryUnderUnit) && !StringUtils.isBlank(unitCode)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("deptcode", null);
        }
        filterMap.put("NP_stateSH", true);
        supervisorypersonneList = supervisoryPersonnelMag
                .supervisorypersonnelSHList(flag_temp, filterMap, pageDesc);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        totalRows = pageDesc.getTotalRows();
        return "SHList";
    }

    /**
     *  监察人员查询list
     * @return
     */
    @SuppressWarnings("unchecked")
    public String supervisorypersonnelCXList() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);// 这个是配置查询条件的
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("depIndustry", dep_industry);
        filterMap.put("topunitcode", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);// 获取所分配的部门
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String flag_temp = "SB";
        String unitCode = (String) filterMap.get("orgcode");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringUtils.isBlank(unitCode)) {
            String unitCodeT = sysUnitManager.getObjectById(unitCode)
                    .getDepno();
            filterMap.put("deptcode", unitCodeT);
        }
        if ("true".equals(s_queryUnderUnit) && !StringUtils.isBlank(unitCode)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("deptcode", null);
        }
        supervisorypersonneList = supervisoryPersonnelMag
                .supervisorypersonnelCXList(flag_temp, filterMap, pageDesc);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        totalRows = pageDesc.getTotalRows();
        return "CXList";
    }

    /**
     *  添加监察人员
     * @return
     */
    public String editInital() {
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        userlist = sysUserManager.getUserUnderUnit(dept.getUnitcode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return "editInital";
    }

    /**
     *  删除监察人员,注销监察人员
     * @return
     */
    public String scDelete() {
        super.delete();
        if ("1".equals(this.getFlag())) {
            return this.supervisorypersonnelSBList();
        } else {
            return this.supervisorypersonnelSHList();
        }
    }

    /**
     *  监察人员申报，审核
     * @return
     */
    public String updateState() {
        if ("1".equals(this.getFlag())) {// 监察人员申报
            Supervisorypersonnel info = new Supervisorypersonnel();
            FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
            info = supervisoryPersonnelMag.getSpByUseridNo(object.getUserId(),
                    object.getNo());
            if (info != null) {
                info.setState("1");
                info.setRecoder(user.getUsername());
                info.setRecodDate(DatetimeOpt.currentUtilDate());
                info.setChangeDate(DatetimeOpt.currentUtilDate());// 更新时间为默认系统时间
                supervisoryPersonnelMag.supervisorypersonnelSave(info);
            } else {
                //
            }
            return this.supervisorypersonnelSBList();
        } else {// 跳转到审核页面去
            super.edit();
            return "SHForm";
        }
    }

    /**
     *  监察人员审核
     * @return
     */
    public String shSave() {
        Supervisorypersonnel info = new Supervisorypersonnel();
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        info = supervisoryPersonnelMag.getSpByUseridNo(object.getUserId(),
                object.getNo());
        if (info != null) {
            info.setAuditor(user.getUsername());
            info.setAuditDate(DatetimeOpt.currentUtilDate());
            info.setAuditReason(object.getAuditReason());
            if ("1".equals(this.getIsPass())) {
                info.setState("2");// 审核通过
            } else {
                info.setState("3");// 审核未通过
            }
            info.setChangeDate(DatetimeOpt.currentUtilDate());// 更新时间为默认系统时间
            supervisoryPersonnelMag.supervisorypersonnelSave(info);
        } else {
            //
        }
        return this.supervisorypersonnelSHList();

    }

    /**
     *  申报修改监察人员,审核修改监察人员
     * @return
     */
    public String xgEdit() {
        super.edit();
        // System.out.println(sysUnitManager.getUnitCode(object.getDeptcode())+"========");
        object.setDeptcode(sysUnitManager.getUnitCode(object.getDeptcode()));
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        userlist = sysUserManager.getUserUnderUnit(dept.getUnitcode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        if ("1".equals(this.getFlag())) {
            return "SBEdit";
        } else {
            return "SHEdit";
        }
    }

    /**
     * 弹出提示信息
     * 
     * @param msg
     * @param response
     */
    protected void postAlertMessage(String msg, HttpServletResponse response) {
        String alertCoding = "GBK";
        ServletOutputStream sos;
        String str = "<script language=\"JavaScript\""
                + " type=\"text/JavaScript\" charset=\"" + alertCoding + "\">"
                + "javascript:alert('" + msg + "');history.back(-1);"
                + " </script>";
        response.setContentType("text/html; charset=" + alertCoding);
        try {
            sos = response.getOutputStream();
            int strSize = (int) str.length();
            byte[] b = new byte[strSize];
            b = str.getBytes();
            sos.write(b);
            sos.flush();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * 保存新添加的监察人员
     * 
     * @return
     */
    public String supervisorypersonnelSave() {
        Supervisorypersonnel info = new Supervisorypersonnel();
        baseEntityManager.copyObjectNotNullProperty(info, object);// 页面上带过来的信息复制到info里面去
        String unitCode = (String) info.getDeptcode();
        if (!StringBaseOpt.isNvl(unitCode)) {
            String deptcode = sysUnitManager.getObjectById(unitCode).getDepno();
            info.setDeptcode(deptcode);
        }
        String id = supervisoryPersonnelMag.genNextChangeId();
        info.setState("0");// 设置审核状态是未申报（0）
        info.setUpdateDate(DatetimeOpt.currentUtilDate());// 写入前置机时间设置为系统时间
        info.setNo(info.getDeptcode() + id);
        info.setDatesource("1");// 默认设置为1
        supervisoryPersonnelMag.supervisorypersonnelSave(info);// 保存监察人员信息
        return this.supervisorypersonnelSBList();
    }

    /**
     * 
     * @return
     */
    public String updateSave() {
        Supervisorypersonnel info = new Supervisorypersonnel();
        baseEntityManager.copyObjectNotNullProperty(info, object);// 将页面上带过来的信息复制到info里面去
        info.setChangeDate(DatetimeOpt.currentUtilDate());
        String unitCode = (String) info.getDeptcode();
        if (!StringBaseOpt.isNvl(unitCode)) {
            String deptcode = sysUnitManager.getObjectById(unitCode).getDepno();
            info.setDeptcode(deptcode);
        }
        supervisoryPersonnelMag.supervisorypersonnelSave(info);// 保存监察人员信息
        if ("1".equals(this.getFlag())) {
            return this.supervisorypersonnelSBList();
        } else {
            return this.supervisorypersonnelSHList();
        }
    }

    public List<Supervisorypersonnel> getSupervisorypersonneList() {
        return supervisorypersonneList;
    }

    public void setSupervisorypersonneList(
            List<Supervisorypersonnel> supervisorypersonneList) {
        this.supervisorypersonneList = supervisorypersonneList;
    }

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass;
    }

    public List<FUserinfo> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<FUserinfo> userlist) {
        this.userlist = userlist;
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

    public String getDep_industry() {
        return dep_industry;
    }

    public void setDep_industry(String dep_industry) {
        this.dep_industry = dep_industry;
    }

}
