package com.centit.powerbase.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Lawmen;
import com.centit.powerbase.po.Lawmenannual;
import com.centit.powerbase.service.LawmenManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class LawmenAction extends BaseEntityExtremeAction<Lawmen> {
    private static final long serialVersionUID = 1L;
    private LawmenManager lawmenMag;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;

    private String unitsJson;
    private String parentunit;
    private List<FUnitinfo> unitList;
    private List<FUserinfo> userlist;
    private List<Lawmen> lawmenManagementList;
    private String flag = "1";// 默认为申报1，审核是2,添加3,汇总查看4
    private String isPass = "1";// 默认为通过，不通过是2
    private String lawmenIds;// 批量存放
    private String annualType;
    private String[] lawmenIdList;

    public String getLawmenIds() {
        return lawmenIds;
    }

    public void setLawmenIds(String lawmenIds) {
        this.lawmenIds = lawmenIds;
    }

    public void setLawmenManager(LawmenManager basemgr) {
        lawmenMag = basemgr;
        this.setBaseEntityManager(lawmenMag);
    }

    // 执法人员管理——>查询
    @SuppressWarnings("unchecked")
    public String lawmenManagementList() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = (FUserDetail) getLoginUser();
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
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
        if ("1".equals(flag)) {
            filterMap.put("state", "0");
        } else if ("2".equals(flag)) {
            filterMap.put("state", "1");
        } else if ("4".equals(flag)) {

        } else if ("5".equals(flag)) {// 年检列表
            filterMap.put(
                    "annualDate",
                    DatetimeOpt.convertDateToString(
                            DatetimeOpt.currentUtilDate()).substring(0, 4));// 为空或者验证年份小于当前年份
        }
        lawmenManagementList = lawmenMag.lawmenManagementList(filterMap,
                pageDesc);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        totalRows = pageDesc.getTotalRows();
        if ("1".equals(flag) || "2".equals(flag)) {
            return "lawmenManagementList";
        } else if ("4".equals(flag)) {
            return "lawmenAllList";
        } else if ("5".equals(flag)) {
            return "lawmenAnnualList";
        } else {
            return null;
        }
    }

    // 执法人员管理——>添加
    public String initalEdit() {
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        userlist = sysUserManager.getUserUnderUnit(dept.getUnitcode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return "initalEdit";
    }

    // 执法人员管理——>修改
    public String lawmenUpdate() {
        super.edit();
        object.setDeptcode(sysUnitManager.getUnitCode(object.getDeptcode()));
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        userlist = sysUserManager.getUserUnderUnit(dept.getUnitcode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return "lawmenUpdate";
    }

    // 执法人员管理——>保存
    public String lawmenSave() {
        Lawmen info = new Lawmen();
        baseEntityManager.copyObjectNotNullProperty(info, object);// 页面上带过来的信息复制到info里面去
        String unitCode = (String) info.getDeptcode();
        if (!StringBaseOpt.isNvl(unitCode)) {
            String deptcode = sysUnitManager.getObjectById(unitCode).getDepno();
            info.setDeptcode(deptcode);
        }
        info.setUpdateType("1");
        if ("3".equals(flag)) {
            String id = lawmenMag.genNextChangeId();
            info.setState("0");// 设置审核状态是未申报（0）
            info.setUpdateDate(DatetimeOpt.currentUtilDate());// 写入前置机时间设置为系统时间
            info.setLawmenId(info.getDeptcode() + id);
            info.setDatesource("1");// 默认设置为1
            lawmenMag.lawmenSave(info);
            this.setFlag("1");
            return this.lawmenManagementList();
        } else if ("1".equals(flag)) {
            lawmenMag.lawmenSave(info);
            this.setFlag("1");
            return this.lawmenManagementList();
        } else if ("2".equals(flag)) {
            lawmenMag.lawmenSave(info);
            this.setFlag("2");
            return this.lawmenManagementList();
        } else if ("5".equals(flag)) {
            lawmenMag.lawmenSave(info);
            this.setFlag("5");
            return this.lawmenManagementList();
        } else {
            this.setFlag("1");
            return this.lawmenManagementList();
        }
    }

    // 执法人员管理——>申报
    public String updateState() {
        if ("1".equals(this.getFlag())) {// 申报
            Lawmen info = new Lawmen();
            FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
            info = lawmenMag.getLawmenByUseridNo(object.getUserId(),
                    object.getLawmenId());
            if (info != null) {
                info.setState("1");
                info.setRecoder(user.getUsername());
                info.setRecodDate(DatetimeOpt.currentUtilDate());
                info.setChangeDate(DatetimeOpt.currentUtilDate());// 更新时间为默认系统时间
                lawmenMag.lawmenSave(info);
            } else {
                //
            }
            return this.lawmenManagementList();
        } else if ("2".equals(flag)) {// 审核
            super.edit();
            return "lawmenUpdateSh";
        } else {
            return this.lawmenManagementList();
        }
    }

    // 执法人员审核——>审核
    public String updateStateSh() {
        Lawmen info = new Lawmen();
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        info = lawmenMag.getLawmenByUseridNo(object.getUserId(),
                object.getLawmenId());
        if (info != null) {
            if ("1".equals(isPass)) {
                info.setState("2");
            } else {
                info.setState("3");
            }
            info.setAuditor(user.getUsername());
            info.setAuditDate(DatetimeOpt.currentUtilDate());
            info.setChangeDate(DatetimeOpt.currentUtilDate());// 更新时间为默认系统时间
            lawmenMag.lawmenSave(info);
        } else {
            //
        }
        this.setFlag("2");
        return this.lawmenManagementList();
    }

    // 单个执法人员年检
    public String annualview() {
        object.setAnnualDate(DatetimeOpt.currentUtilDate());
        object.setValidity(DatetimeOpt.seekEndOfYear(DatetimeOpt.addYears(
                DatetimeOpt.currentUtilDate(), 1)));
        object.setSeparationDate(DatetimeOpt.currentUtilDate());
        return "annualview";
    }

    // 单个年检信息保存至年检表，同时更新执法人员信息表
    public String annualSave() {
        Lawmen info = new Lawmen();
        Lawmenannual infoAnnual = new Lawmenannual();
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        info = lawmenMag.getLawmenByLawmenId(object.getLawmenId());
        if (info != null) {
            if ("1".equals(object.getUpdateType())) {
                info.setAnnualDate(object.getAnnualDate());
                info.setValidity(object.getValidity());
            } else {
                info.setAnnualDate(object.getAnnualDate());
                info.setSeparationDate(object.getSeparationDate());
                info.setSeparationReason(object.getSeparationReason());
            }
            info.setUpdateType(object.getUpdateType());
            // awmenMag.lawmenSave(info);
            String id = lawmenMag.genNextAnnualId();
            infoAnnual.setAnnualDate(object.getAnnualDate());
            infoAnnual.setAnnualId(id);
            if ("1".equals(object.getUpdateType())) {
                infoAnnual.setAnnualResult(object.getUpdateType());// 修改为1，年检 2
                                                                   // 为其他所有
            } else {
                infoAnnual.setAnnualResult("2");// 修改为1，年检 2 为其他所有
            }

            infoAnnual.setRemark(object.getSeparationReason());
            infoAnnual.setUsercode(user.getUsercode());
            infoAnnual.setlawmenId(object.getLawmenId());
            infoAnnual.setValidity(object.getValidity());
            lawmenMag.saveboth(info, infoAnnual);

        } else {
            //
        }
        this.setFlag("5");
        return this.lawmenManagementList();
    }

    // 批量处理，年检信息保存至年检表，同时更新执法人员信息表
    public String annualSaves() {
        Lawmen info = new Lawmen();

        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        if (!lawmenIds.isEmpty()) {
            lawmenIdList = lawmenIds.split(",");
        }
        if (null != lawmenIdList || lawmenIdList.length > 0) {
            for (int i = 0; i < lawmenIdList.length; i++) {
                String lawmenId = lawmenIdList[i];
                Lawmenannual infoAnnual = new Lawmenannual();
                info = lawmenMag.getLawmenByLawmenId(lawmenId);
                if (info != null) {
                    if ("1".equals(object.getUpdateType())) {
                        info.setAnnualDate(object.getAnnualDate());
                        info.setValidity(object.getValidity());
                    } else {
                        info.setAnnualDate(object.getAnnualDate());
                        info.setSeparationDate(object.getSeparationDate());
                        info.setSeparationReason(object.getSeparationReason());
                    }
                    info.setUpdateType(object.getUpdateType());
                    String id = lawmenMag.genNextAnnualId();
                    infoAnnual.setAnnualDate(object.getAnnualDate());
                    infoAnnual.setAnnualId(id);
                    if ("1".equals(object.getUpdateType())) {
                        infoAnnual.setAnnualResult(object.getUpdateType());// 修改为1，年检
                                                                           // 2
                                                                           // 为其他所有
                    } else {
                        infoAnnual.setAnnualResult("2");// 修改为1，年检 2 为其他所有
                    }

                    infoAnnual.setRemark(object.getSeparationReason());
                    infoAnnual.setUsercode(user.getUsercode());
                    infoAnnual.setlawmenId(lawmenId);
                    infoAnnual.setValidity(object.getValidity());
                    lawmenMag.saveboth(info, infoAnnual);

                } else {
                    //
                }
            }
        }
        this.setFlag("5");
        return this.lawmenManagementList();
    }

    public String delete() {
        super.delete();
        return this.lawmenManagementList();
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

    public List<Lawmen> getLawmenManagementList() {
        return lawmenManagementList;
    }

    public void setLawmenManagementList(List<Lawmen> lawmenManagementList) {
        this.lawmenManagementList = lawmenManagementList;
    }

    public void setLawmenMag(LawmenManager lawmenMag) {
        this.lawmenMag = lawmenMag;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public List<FUserinfo> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<FUserinfo> userlist) {
        this.userlist = userlist;
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

    public String getAnnualType() {
        return annualType;
    }

    public void setAnnualType(String annualType) {
        this.annualType = annualType;
    }

}
