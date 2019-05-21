package com.centit.powerbase.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.LawVehicle;
import com.centit.powerbase.service.LawVehicleManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class LawVehicleAction extends BaseEntityExtremeAction<LawVehicle>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    private LawVehicleManager lawVehicleMag;
    HttpServletResponse response;

    public void setLawVehicleManager(LawVehicleManager basemgr) {
        lawVehicleMag = basemgr;
        this.setBaseEntityManager(lawVehicleMag);
    }

    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;

    private String unitsJson;
    private String parentunit;
    private List<LawVehicle> lawVehiclelist;

    public List<LawVehicle> getLawVehiclelist() {
        return lawVehiclelist;
    }

    public void setLawVehiclelist(List<LawVehicle> lawVehiclelist) {
        this.lawVehiclelist = lawVehiclelist;
    }

    private List<FUnitinfo> unitList;
    private List<FUserinfo> userlist;

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

    public String getParentunit() {
        return parentunit;
    }

    public void setParentunit(String parentunit) {
        this.parentunit = parentunit;
    }

    @SuppressWarnings("unchecked")
    public String list() {

        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        lawVehiclelist = lawVehicleMag.lawVehicleList(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return LIST;
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
        object.setRecorder(user.getUsername());
        object.setRecordDate(new Date(System.currentTimeMillis()));
        String vehicleId = (String) request.getAttribute("vehicleId");
        object.setVehicleId(vehicleId);
        return EDIT;
    }

    protected void postAlertMessage(String msg, HttpServletResponse response) {// 提示信息
        String alertCoding = "UTF-8";
        ServletOutputStream sos;
        /*
         * try { msg=new String (msg.getBytes(Charset.forName(alertCoding)),
         * "GB2312"); } catch (UnsupportedEncodingException e1) { // TODO
         * Auto-generated catch block e1.printStackTrace(); }
         */

        String str = "<script language=\"JavaScript\""
                + " type=\"text/JavaScript\" charset=\"" + alertCoding + "\">"
                + "javascript:alert('" + msg + "');history.back(-1);"
                + " </script>";
        // response.setCharacterEncoding(alertCoding);
        // response.setContentType("text/html; charset=" + alertCoding);
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
     * 验证用户输入的车牌号是否唯一
     * 
     * @return
     */
    public String checkplateNumber() {
        String plateNumber = object.getPlateNumber();
        response.setCharacterEncoding("utf-8");
        if (StringBaseOpt.isNvl(plateNumber)) {
            this.postAlertMessage("请输入车牌号", response);
        }
        if (lawVehicleMag.checkplateNumber(plateNumber)) {
            this.postAlertMessage("该车牌号已存在", response);
        } else
            this.postAlertMessage("该车牌号可用", response);
        return null;
    }

    public String lawsave() {
        try {

            // FUserDetail fUserDetail = (FUserDetail)
            // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            LawVehicle phobject = new LawVehicle();
            // phobject.setRecorder( fUserDetail.getUsercode());
            baseEntityManager.copyObjectNotNullProperty(phobject, object);
            if (object.getVehicleId().equals("")) {// vehicleId为空时新增操作
                if (StringBaseOpt.isNvl(object.getPlateNumber())) {
                    this.postAlertMessage("请输入车牌号", response);
                }
                if (lawVehicleMag.checkplateNumber(object.getPlateNumber())) {
                    this.postAlertMessage("该车牌号已存在", response);
                    return null;
                }
                phobject.setVehicleId(lawVehicleMag.generateNextVehicleId());
                phobject.setRecordDate(new Date(System.currentTimeMillis()));// 录入时间=更新时间？
            }
            lawVehicleMag.saveObject(phobject);

            return this.list();
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }

    }

    public String lawupdate() {
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        String vehicleId = (String) request.getAttribute("vehicleId");
        LawVehicle phobject = new LawVehicle();
        phobject = lawVehicleMag.getUpdateNo(vehicleId);
        request.setAttribute("object", phobject);
        this.edit();
        return EDIT;
    }

    /**
     * 查看
     * 
     * @return
     */
    public String lawview() {
        String vehicleId = (String) request.getAttribute("vehicleId");
        LawVehicle phobject = new LawVehicle();
        phobject = lawVehicleMag.getUpdateNo(vehicleId);
        request.setAttribute("phobject", phobject);
        this.view();
        return "view";
    }

    public String delete() {
        // super.delete();
        lawVehicleMag.deleteObject(object);
        String url = "powerbase/lawVehicle!list.do";
        String message = "删除车辆信息成功";
        try {
            this.AlertMessage(url, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.list();
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

    @Override
    public void setServletResponse(HttpServletResponse arg0) {
        
        this.response = arg0;
    }
}
