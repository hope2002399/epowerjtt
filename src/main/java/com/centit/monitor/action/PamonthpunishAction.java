package com.centit.monitor.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;
import org.springframework.security.core.context.SecurityContextHolder;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Pamonthpunish;
import com.centit.monitor.service.PamonthpunishManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.opensymphony.xwork2.ActionContext;

public class PamonthpunishAction extends BaseEntityExtremeAction<Pamonthpunish>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    private PamonthpunishManager pamonthpunishManager;
    private String unitsJson;
    private String parentunit;

    public void setPamonthpunishManager(PamonthpunishManager basemgr) {
        pamonthpunishManager = basemgr;
        this.setBaseEntityManager(pamonthpunishManager);
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    private List<Pamonthpunish> pamonthpunishList;

    public List<Pamonthpunish> getPamonthpunishList() {
        return pamonthpunishList;
    }

    public void setPamonthpunishList(List<Pamonthpunish> pamonthpunishList) {
        this.pamonthpunishList = pamonthpunishList;
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

    // 针对附件异常的提示
    ActionContext context = ActionContext.getContext();
    HttpServletResponse response;

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    List<String> yearList = new ArrayList<String>();

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    /**
     * 增减分列表
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String list() {
        // 年份列表
        for (int i = 0; i < 11; i++) {
            int year = Integer.parseInt(DatetimeOpt.getNowDateTime4String()
                    .substring(0, 4));
            year = year - i;
            yearList.add(String.valueOf(year));
        }
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String unitCode = (String) filterMap.get("orgId");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(unitCode)) {
            String s_orgId = sysUnitManager.getObjectById(unitCode).getDepno();
            filterMap.put("orgId", s_orgId);
        }
        if (!StringBaseOpt.isNvl(unitCode) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("orgId", null);
        }
        Limit limit = ExtremeTableUtils.getLimit(request);

        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 树形部门菜单
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        pamonthpunishList = pamonthpunishManager.getPamonthpunishList(
                filterMap, pageDesc);//
        totalRows = pageDesc.getTotalRows();
        return LIST;
    }

    /**
     * 增减分录入
     * 
     * @return
     */
    public String addscore() {

        this.editInitial();
        FUserDetail user = ((FUserDetail) getLoginUser());
        object.setRecorder(user.getUsername());
        object.setPunishCount(Double.valueOf(1));// 数量初始为1
        request.getParameter("isinuse");
        return "addscore";
    }

    public String editInitial() {
        Pamonthpunish objects = new Pamonthpunish();
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);

        object.setRecordDate(new Date(System.currentTimeMillis()));
        object.setAuditDate(new Date(System.currentTimeMillis()));
        object.setRecorder(user.getLoginname());
        baseEntityManager.copyObjectNotNullProperty(objects, object);

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
     * 保存录入增减分
     * 
     * @return
     */
    public String pamonthpunishSave() {
        String year = object.getCountYear();
        String month = object.getCountMonth();
        String orgId = object.getOrgId();
        String auditResult = pamonthpunishManager.getauditResultbydata(year,
                month, orgId);
        try {
            // 对于审核同意过的测评月份不予在录入(1为审核过0为没有审核过的)
            if (auditResult.equals(0) || StringUtils.isBlank(auditResult)) {

                FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                        .getContext().getAuthentication().getPrincipal();
                Pamonthpunish phobject = new Pamonthpunish();
                phobject.setRecordDate(new Date(System.currentTimeMillis()));
                phobject.setRecorder(fUserDetail.getUsercode());
                phobject.setPunishNo(pamonthpunishManager
                        .generateNextPunishNo());
                String str = object.getPunishType();
                String[] values = str.split("&");// 取type值 分割字符串

                baseEntityManager.copyObjectNotNullProperty(phobject, object);
                if (StringUtils.isBlank(values[1])) {// 增减分项不是按项计算默认为1
                    phobject.setPunishCount(Double.valueOf(1));
                }
                phobject.setPunishType(values[2]);// 取字符串第三个元素就是增减分类别
                pamonthpunishManager.saveObject(phobject);
                return SUCCESS;
            } else {
                // this.postAlertMessage("该部门的测评月份已被审核，不予录入！", response);
                String url = null;
                url = "monitor/pamonthpunish!list.do";
                this.AlertMessage(url);
                return null;
            }
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    // 不予录入增减分提示框
    public String AlertMessage(String url_temp) throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        String url = "<script>window.location.href='" + url_temp + "'</script>";
        out.print("<script>alert('该部门的测评月份增减分项已被审核，不予录入！')</script>");
        out.print(url);
        out.flush();
        out.close();
        return null;
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

    /**
     * 增减分审核
     * 
     * @return
     */
    public String auditsh() {
        String punishNo = (String) request.getAttribute("punishNo");
        this.editInitial();
        FUserDetail user = ((FUserDetail) getLoginUser());
        object.setPunishNo(punishNo);
        object.setAuditor(user.getUsername());
        return "auditsh";
    }

    /**
     * 保存增减分审核
     * 
     * @return
     */
    public String update() {
        try {
            Pamonthpunish phobject = new Pamonthpunish();
            FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
            phobject = pamonthpunishManager.getUpdateNo(object.getPunishNo());
            if (phobject != null) {

                phobject.setAuditor(user.getUsername());
                phobject.setAuditDesc(object.getAuditDesc());
                phobject.setAuditResult(object.getAuditResult());
                phobject.setAuditDate(DatetimeOpt.currentUtilDate());// 更新时间为默认系统时间
                pamonthpunishManager.pamonthpunishSave(phobject);

            }
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }

        return this.list();
    }

    /**
     * 增减分明细查看
     * 
     * @return
     */
    public String phview() {
        String punishNo = (String) request.getAttribute("punishNo");
        Pamonthpunish phobject = new Pamonthpunish();
        phobject = pamonthpunishManager.getUpdateNo(punishNo);
        request.setAttribute("phobject", phobject);
        this.view();
        return "view";
    }

    public String delete() {
        super.delete();

        return "delete";
    }

    public String getParentunit() {
        return parentunit;
    }

    public void setParentunit(String parentunit) {
        this.parentunit = parentunit;
    }

}
