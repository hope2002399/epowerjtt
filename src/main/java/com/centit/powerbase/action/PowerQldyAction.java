package com.centit.powerbase.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.PowerQldy;
import com.centit.powerbase.po.VPowerQldy;
import com.centit.powerbase.service.PowerQldyManager;
import com.centit.powerbase.service.VPowerQldyManager;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.opensymphony.xwork2.ActionContext;

public class PowerQldyAction extends BaseEntityExtremeAction<VPowerQldy>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    private VPowerQldyManager vPowerQldyManager;
    private PowerQldyManager powerQldyManager;
    private List<VPowerQldy> list;// 都要写范式
    private String unitsJson;
    private String parentUnit;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    ActionContext context = ActionContext.getContext();
    HttpServletResponse response;

    public VPowerQldyManager getvPowerQldyManager() {
        return vPowerQldyManager;
    }

    public void setvPowerQldyManager(VPowerQldyManager vPowerQldyManager) {
        this.vPowerQldyManager = vPowerQldyManager;
    }

    public PowerQldyManager getPowerQldyManager() {
        return powerQldyManager;
    }

    public void setPowerQldyManager(PowerQldyManager powerQldyManager) {
        this.powerQldyManager = powerQldyManager;
    }

    public List<VPowerQldy> getList() {
        return list;
    }

    public void setList(List<VPowerQldy> list) {
        this.list = list;
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    public String getParentUnit() {
        return parentUnit;
    }

    public void setParentUnit(String parentUnit) {
        this.parentUnit = parentUnit;
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

    public HttpServletResponse getResponse() {
        return response;
    }

    public ActionContext getContext() {
        return context;
    }

    public void setContext(ActionContext context) {
        this.context = context;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;

    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    @SuppressWarnings("unchecked")
    public String list() {

        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        FUserDetail user = (FUserDetail) getLoginUser();
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());

        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();

        PageDesc pageDesc = makePageDesc();
        list = vPowerQldyManager.getListVPowerQldy(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return LIST;
    }

    public String addOrModify() {
        String itemId = request.getParameter("itemId");
        VPowerQldy vpq = vPowerQldyManager.getObjectById(itemId);
        request.setAttribute("obj", vpq);

        return EDIT;
    }

    public String savePowerQldy() {
        String itemId = request.getParameter("itemId");
        String otherItemId = request.getParameter("otherItemId");
        PowerQldy po = new PowerQldy();
        po.setOtherItemId(otherItemId);
        po.setPowerItemId(itemId);
        powerQldyManager.saveObject(po);
        return list();
    }

}
