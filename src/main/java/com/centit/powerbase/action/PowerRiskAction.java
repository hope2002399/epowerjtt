package com.centit.powerbase.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.PowerRisk;
import com.centit.powerbase.po.Vpowerrisk;
import com.centit.powerbase.service.PowerRiskManager;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.powerbase.service.VpowerriskManager;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.opensymphony.xwork2.ActionContext;

public class PowerRiskAction extends BaseEntityExtremeAction<PowerRisk>
        implements ServletResponseAware {
    private static final Log log = LogFactory.getLog(PowerRiskAction.class);
    private static final long serialVersionUID = 1L;
    private VpowerriskManager vpowerriskManager;
    private PowerRiskManager powerRiskManager;
    private List<Vpowerrisk> list;// 都要写范式
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private List<FUnitinfo> unitList;
    private String message;
    private List<Vpowerrisk> vpowerrisks;
    private SuppowerManager suppowerManager;
    ActionContext context = ActionContext.getContext();
    HttpServletResponse response;

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

    private String unitsJson;
    private String parentUnit;

    /*
     * 重大许可备案查询list
     */
    @SuppressWarnings("unchecked")
    public String xkList() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        FUserDetail user = (FUserDetail) getLoginUser();
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());

        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();// 获取该部门编码的顶层部门信息

        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);

        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        PageDesc pageDesc = makePageDesc();
        list = vpowerriskManager.getListPowerRisk(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "xkList";
    }

    /*
     * 重大许可备案-->修改
     */
    public String powerRiskUpdate() {
        this.edit();
        return "edit";
    }

    /*
     * 重大许可备案-->删除
     */
    public String delete() {
        // super.delete();//有提示信息。
        powerRiskManager.deleteObject(object);
        String url = "powerbase/powerRisk!xkList.do";
        message = "删除许可权力事项成功";
        try {
            this.AlertMessage(url, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xkList();
    }

    /*
     * 操作的提示信息
     */
    public String AlertMessage(String url_temp, String message)
            throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        String url = "<script>window.location.href='" + url_temp + "'</script>";
        out.print("<script>alert('" + message + "')</script>");
        out.print(url);
        out.flush();
        out.close();
        return null;
    }

    /*
     * 重大许可备案-->修改、新增保存
     */
    public String powerRiskSave() {
        // Vpowerrisk vpowerrisk = new Vpowerrisk();
        // powerRiskManager.copyObjectNotNullProperty(vpowerrisk, object);
        object.setLastModifyDate(new Date(System.currentTimeMillis()));
        powerRiskManager.saveObject(object);
        return xkList();
    }

    /*
     * 重大许可备案-->新增
     */
    public String powerRiskAdd() {
        return "add";
    }

    /*
     * 验证权力编码
     */
    @SuppressWarnings("unchecked")
    public void checkExist() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String id = request.getParameter("itemId");
        filterMap.put("itemId", id);
        boolean flag = suppowerManager.isPowerExist(id);
        if (flag) {
            List<PowerRisk> result = powerRiskManager.getListPowerRisk(
                    filterMap, pageDesc);
            if (result.isEmpty()) {
                message = "有效权力编码";
            } else {
                message = "该权力编码已被占用";
            }
        } else {
            message = "该权力在权力库中不存在!";
        }
        try {
            this.postAlertMessage(message, response);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }

    }

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

    public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }

    public List<Vpowerrisk> getList() {
        return list;
    }

    public void setList(List<Vpowerrisk> list) {
        this.list = list;
    }

    public void setVpowerriskManager(VpowerriskManager baseManger) {
        vpowerriskManager = baseManger;
    }

    public void setPowerRiskManager(PowerRiskManager baseManger) {
        powerRiskManager = baseManger;
        this.setBaseEntityManager(powerRiskManager);
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

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public List<Vpowerrisk> getVpowerrisk() {
        return vpowerrisks;
    }

    public void setVpowerrisk(List<Vpowerrisk> vpowerrisks) {
        this.vpowerrisks = vpowerrisks;
    }

    public String getParentUnit() {
        return parentUnit;
    }

    public void setParentUnit(String parentUnit) {
        this.parentUnit = parentUnit;
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }
}
