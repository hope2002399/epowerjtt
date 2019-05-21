package com.centit.powerbase.action;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VPunish;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.PunishManager;
import com.centit.powerbase.po.Lawsuit;
import com.centit.powerbase.service.LawsuitManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class LawsuitAction extends BaseEntityExtremeAction<Lawsuit> implements
        ServletResponseAware {
    private static final long serialVersionUID = 1L;
    private LawsuitManager lawsuitMag;

    public void setLawsuitManager(LawsuitManager basemgr) {
        lawsuitMag = basemgr;
        this.setBaseEntityManager(lawsuitMag);
    }

    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;

    private String unitsJson;
    private String parentunit;
    private List<FUnitinfo> unitList;
    private List<FUserinfo> userlist;
    private List<Lawsuit> Lawsuitlist;
    private String flag = "1";
    HttpServletResponse response;

    @SuppressWarnings("unchecked")
    public String List() {
        // flag=request.getParameter("flag");
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
        String unitCode = (String) filterMap.get("lawsuitapplyunit");
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
        Lawsuitlist = lawsuitMag.Lawsuitlist(filterMap, pageDesc);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        totalRows = pageDesc.getTotalRows();
        if ("1".equals(flag)) {
            return "Lawsuitlist";
        } else {
            return "Lawsuitlist";
        }

    }

    public String initalEdit() {
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        userlist = sysUserManager.getUserUnderUnit(dept.getUnitcode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();

        String sParentUnit = dept.getUnitcode();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        object.setBookoperator(user.getUsername());
        object.setBookdate(new Date(System.currentTimeMillis()));
        return "dengjiEdit";
    }

    /**
     * 新开窗口查询办件、案件list
     * 
     * @return
     */
    public String selectList() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> remap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(remap);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        String unitCode = (String) filterMap.get("orgcode");
        if (!StringBaseOpt.isNvl(unitCode)) {
            String s_orgId = sysUnitManager.getObjectById(unitCode).getDepno();
            filterMap.put("orgId", s_orgId);
        }
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if ("true".equals(s_queryUnderUnit) && !StringUtils.isBlank(unitCode)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("orgId", null);
        }
        if (!StringUtils.isBlank((String) filterMap.get("internalNo"))) {
            filterMap.put("internalNo", (String) filterMap.get("internalNo"));
        }
        if ("1".equals(flag)) {
            filterMap.put("NP_istrack", true);
            applyList = applyManager.getApplyList(filterMap);
            if (applyList != null) {
                totalRows = applyList.size();
            }
        } else if ("2".equals(flag)) {
            filterMap.put("NP_istrack", true);
            punishList = punishManager.getPunishList(filterMap);
            if (punishList != null) {
                totalRows = punishList.size();
            }
        }
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return "selectList";
    }

    /**
     * 保存诉讼信息
     * 
     * @return
     */
    @SuppressWarnings("unused")
    public String lawsuitSave() {
        try {
            FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                    .getContext().getAuthentication().getPrincipal();
            Lawsuit phobject = new Lawsuit();
            phobject.setBookdate(new Date(System.currentTimeMillis()));
            baseEntityManager.copyObjectNotNullProperty(phobject, object);
            lawsuitMag.saveObject(phobject);
            this.setFlag("1");
            return this.List();

        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 修改诉讼信息
     * 
     * @return
     */
    public String lawsuitUpdate() {
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        String lawsuitno = (String) request.getAttribute("lawsuitno");
        Lawsuit phobject = new Lawsuit();
        phobject = lawsuitMag.getUpdateNo(lawsuitno);
        request.setAttribute("object", phobject);
        this.edit();
        return EDIT;
    }

    /**
     * 明细查看
     * 
     * @return
     */
    public String lawsuitview() {
        String lawsuitno = (String) request.getAttribute("lawsuitno");
        Lawsuit phobject = new Lawsuit();
        phobject = lawsuitMag.getUpdateNo(lawsuitno);
        request.setAttribute("phobject", phobject);
        this.view();
        return "view";
    }

    public String delete() {
        // super.delete();
        lawsuitMag.deleteObject(object);
        this.setFlag("1");
        String url = "powerbase/lawsuit!List.do";
        String message = "删除诉讼信息成功";
        try {
            this.AlertMessage(url, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.List();

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

    private List<VPunish> punishList;
    private List<VApply> applyList;

    public List<VPunish> getPunishList() {
        return punishList;
    }

    public void setPunishList(List<VPunish> punishList) {
        this.punishList = punishList;
    }

    public List<VApply> getApplyList() {
        return applyList;
    }

    public void setApplyList(List<VApply> applyList) {
        this.applyList = applyList;
    }

    private ApplyManager applyManager;

    public ApplyManager getApplyManager() {
        return applyManager;
    }

    public void setApplyManager(ApplyManager applyManager) {
        this.applyManager = applyManager;
    }

    public PunishManager getPunishManager() {
        return punishManager;
    }

    public void setPunishManager(PunishManager punishManager) {
        this.punishManager = punishManager;
    }

    private PunishManager punishManager;

    public LawsuitManager getLawsuitMag() {
        return lawsuitMag;
    }

    public void setLawsuitMag(LawsuitManager lawsuitMag) {
        this.lawsuitMag = lawsuitMag;
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

    public List<Lawsuit> getLawsuitlist() {
        return Lawsuitlist;
    }

    public void setLawsuitlist(List<Lawsuit> lawsuitlist) {
        Lawsuitlist = lawsuitlist;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        
        this.response = response;
    }

}
