package com.centit.powerbase.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerbase.po.Vsuppowerinusing;
import com.centit.powerbase.service.VsuppowerinusingManager;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class VsuppowerinusingAction extends
        BaseEntityExtremeAction<Vsuppowerinusing> {
    private static final long serialVersionUID = 1L;
    private VsuppowerinusingManager vsuppowerinusingMag;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;

    public void setVsuppowerinusingManager(VsuppowerinusingManager basemgr) {
        vsuppowerinusingMag = basemgr;
        this.setBaseEntityManager(vsuppowerinusingMag);
    }

    private String unitsJson;
    private String parentunit;

    public String list() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return super.list();
    }

    public String delete() {
        super.delete();

        return "delete";
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

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }
}
