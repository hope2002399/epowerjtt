package com.centit.supervise.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.centit.complaint.action.EpowerCommonBizAction;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.OutwayCJJC;
import com.centit.monitor.service.OutwayCJJCManager;
import com.centit.supervise.po.SuperviseCJJC;
import com.centit.supervise.service.SuperviseCJJCManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class SuperviseCJJCAction extends EpowerCommonBizAction<SuperviseCJJC> {
    private static final long serialVersionUID = 1L;
    private OutwayCJJCManager outwayCJJCManager;
    private SuperviseCJJCManager superviseCJJCManager;

    private List<FUnitinfo> unitList;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    // 部门tree
    private String unitsJson;
    private String parentunit;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
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

    public OutwayCJJCManager getOutwayCJJCManager() {
        return outwayCJJCManager;
    }

    public void setOutwayCJJCManager(OutwayCJJCManager outwayCJJCManager) {
        this.outwayCJJCManager = outwayCJJCManager;
    }

    public SuperviseCJJCManager getSuperviseCJJCMag() {
        return superviseCJJCManager;
    }

    public void setSuperviseCJJCManager(
            SuperviseCJJCManager superviseCJJCManager) {
        this.superviseCJJCManager = superviseCJJCManager;
    }

    @SuppressWarnings("unchecked")
    public String list() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        PageDesc pageDesc = makePageDesc();
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        if (!StringBaseOpt.isNvl(request.getParameter("step"))) {
            filterMap.put("supervisestep", request.getParameter("step"));
        }
        objList = superviseCJJCManager.listSuperviseCJJC(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();

        this.pageDesc = pageDesc;
        return LIST;
    }

    public String edit() {
        String outwayid = request.getParameter("outwayid");
        String supervisecode = request.getParameter("supervisecode");
        request.setAttribute("outwaycjjc",
                outwayCJJCManager.getOutwayCJJCById(outwayid));
        request.setAttribute("sup",
                superviseCJJCManager.getSuperviseCJJCByCode(supervisecode));
        return "edit";
    }

    public String view() {
        String outwayid = request.getParameter("outwayid");
        String supervisecode = request.getParameter("supervisecode");
        request.setAttribute("outwaycjjc",
                outwayCJJCManager.getOutwayCJJCById(outwayid));
        request.setAttribute("sup",
                superviseCJJCManager.getSuperviseCJJCByCode(supervisecode));
        return "view";
    }

    public String save() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        String step = request.getParameter("step");
        String supervisecode = request.getParameter("supervisecode");
        SuperviseCJJC sup = superviseCJJCManager
                .getSuperviseCJJCByCode(supervisecode);
        if (step.equals("2")) {
            String outwayId = request.getParameter("outwayid");
            OutwayCJJC outway = outwayCJJCManager.getOutwayCJJCById(outwayId);
            object.setSupervisecode(superviseCJJCManager.getNextkey());
            object.setNo(outwayId);
            object.setSuperviseoption(request.getParameter("superviseOption"));
            object.setPromise(new Date());
            object.setSuperdate(new Date());
            object.setOrgId(outway.getOrgId());
            object.setDealstep(step);
            object.setSupervisetype(outway.getOutwaytype());
            object.setOperatorid(user.getUsercode());
            object.setOperatorname(user.getUsername());
            superviseCJJCManager.saveObject(object);
        } else if (step.equals("3")) {
            sup.setSuperviseback(request.getParameter("superviseback"));
            sup.setDealstep(step);
            sup.setReceiptdate(new Date());
            sup.setBackoperatorname(user.getUsername());
            superviseCJJCManager.saveObject(sup);
        } else if (step.equals("4")) {
            sup.setSuperviseresult(request.getParameter("superviseresult"));
            sup.setDealstep(step);
            sup.setEnddate(new Date());
            sup.setEndoperatorid(user.getUsercode());
            sup.setEndoperatorname(user.getUsername());
            sup.setIsexternal(request.getParameter("isexternal").equals("1"));
            superviseCJJCManager.saveObject(sup);
        }

        return "outwaylist";
    }
}
