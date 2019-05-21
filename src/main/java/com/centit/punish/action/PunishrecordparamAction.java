package com.centit.punish.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.Punishrecordparam;
import com.centit.punish.service.PunishrecordparamManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class PunishrecordparamAction extends
        BaseEntityExtremeAction<Punishrecordparam> {
    private static final long serialVersionUID = 1L;
    private PunishrecordparamManager punishrecordparamMag;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;

    private String unitsJson;
    private String parentunit;
    private String s_depkind;
    private List<FUnitinfo> unitList;
    private List<FUserinfo> userlist;
    private List<Punishrecordparam> punishrecordparamList;

    public void setPunishrecordparamManager(PunishrecordparamManager basemgr) {
        punishrecordparamMag = basemgr;
        this.setBaseEntityManager(punishrecordparamMag);
    }

    /**
     * 处罚备案参数管理 查询
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String punishrecordparamList() {
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
            filterMap.put("orgId", unitCodeT);
        }
        if ("true".equals(s_queryUnderUnit) && !StringUtils.isBlank(unitCode)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("orgId", null);
        }
        punishrecordparamList = punishrecordparamMag.punishrecordparamList(
                filterMap, pageDesc);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        totalRows = punishrecordparamList.size();
        return "paramlist";
    }

    /**
     * 处罚备案参数管理 添加
     * 
     * @return
     */
    public String initalEdit() {
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        userlist = sysUserManager.getUserUnderUnit(dept.getUnitcode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return "initalEdit";
    }

    /**
     * 处罚备案参数管理 修改
     * 
     * @return
     */
    public String update() {
        super.edit();
        object.setOrgId(sysUnitManager.getUnitCode(object.getOrgId()));
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        userlist = sysUserManager.getUserUnderUnit(dept.getUnitcode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return "update";
    }

    /**
     * 处罚备案参数管理 保存
     * 
     * @return
     */
    public String punishrecordparamSave() {
        Punishrecordparam info = new Punishrecordparam();
        baseEntityManager.copyObjectNotNullProperty(info, object);// 页面上带过来的信息复制到info里面去
        String unitCode = (String) info.getOrgId();
        if (!StringBaseOpt.isNvl(unitCode)) {
            String deptcode = sysUnitManager.getObjectById(unitCode).getDepno();
            info.setOrgId(deptcode);
        }
        if (info.getBookdate() == null) {
            info.setBookdate(DatetimeOpt.currentUtilDate());// 登记时间设置为系统时间
        }
        info.setModifydate(DatetimeOpt.currentUtilDate());// 更新时间设置为系统时间
        FUserDetail user = (FUserDetail) getLoginUser();
        info.setBookoperatorid(user.getUsercode());
        punishrecordparamMag.punishrecordparamSave(info);
        return this.punishrecordparamList();
    }

    /**
     * 处罚备案参数管理 删除
     * 
     * @return
     */
    public String delete() {
        super.delete();
        return this.punishrecordparamList();
    }

    public List<Punishrecordparam> getPunishrecordparamList() {
        return punishrecordparamList;
    }

    public void setPunishrecordparamList(
            List<Punishrecordparam> punishrecordparamList) {
        this.punishrecordparamList = punishrecordparamList;
    }

    public PunishrecordparamManager getPunishrecordparamMag() {
        return punishrecordparamMag;
    }

    public void setPunishrecordparamMag(
            PunishrecordparamManager punishrecordparamMag) {
        this.punishrecordparamMag = punishrecordparamMag;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
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

    public List<FUserinfo> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<FUserinfo> userlist) {
        this.userlist = userlist;
    }

    public String getS_depkind() {
        return s_depkind;
    }

    public void setS_depkind(String s_depkind) {
        this.s_depkind = s_depkind;
    }

}
