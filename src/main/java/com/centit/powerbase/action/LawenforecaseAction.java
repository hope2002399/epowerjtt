package com.centit.powerbase.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Lawenforecase;
import com.centit.powerbase.service.LawenforecaseManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.opensymphony.xwork2.ActionContext;

public class LawenforecaseAction extends BaseEntityExtremeAction<Lawenforecase>
        implements ServletResponseAware {
    private static final Log log = LogFactory.getLog(LawenforecaseAction.class);
    private static final long serialVersionUID = 1L;
    private LawenforecaseManager lawenforecaseMag;

    public void setLawenforecaseManager(LawenforecaseManager basemgr) {
        lawenforecaseMag = basemgr;
        this.setBaseEntityManager(lawenforecaseMag);
    }

    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;

    private String unitsJson;
    private String parentunit;
    private List<FUnitinfo> unitList;
    private List<FUserinfo> userlist;
    private List<Lawenforecase> Lawsuitlist;
    private String flag = "1";
    private File casedoc_;

    public File getCasedoc_() {
        return casedoc_;
    }

    public void setCasedoc_(File casedoc_) {
        this.casedoc_ = casedoc_;
    }

    private String casedoc_FileName;

    public String getCasedoc_FileName() {
        return casedoc_FileName;
    }

    public void setCasedoc_FileName(String casedoc_FileName) {
        this.casedoc_FileName = casedoc_FileName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

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
        Lawsuitlist = lawenforecaseMag.LawenforecaseList(filterMap, pageDesc);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        totalRows = pageDesc.getTotalRows();
        if ("1".equals(flag)) {
            return "LawenforecaseList";
        } else {
            return "LawenforecaseList";

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
     * 检测案件编号是否唯一
     */
    public String checkCaseNoExist() {
        String caseno = object.getCaseno();
        if (StringBaseOpt.isNvl(caseno)) {
            this.postAlertMessage("请输入编号", response);
        }
        if (lawenforecaseMag.CheckCasenoExist(caseno)) {
            this.postAlertMessage("该案件编号已存在", response);
        } else
            this.postAlertMessage("该案件编号可用", response);
        return null;
    }

    /**
     * 保存执法案例信息
     * 
     * @return
     */
    public String lawenforecaseSave() {
        try {

            Lawenforecase phobject = new Lawenforecase();
            baseEntityManager.copyObjectNotNullProperty(phobject, object);// 页面上带过来的信息复制到phobject里面去
            phobject.setBookdate(new Date(System.currentTimeMillis()));
            // phobject.setBookoperator( fUserDetail.getUsercode());
            // 案例正文
            if (casedoc_ != null) {
                try {
                    FileInputStream fis = new FileInputStream(casedoc_);
                    if (fis != null) {
                        byte[] bbuf = null;
                        int len = fis.available();
                        bbuf = new byte[len];
                        fis.read(bbuf);
                        phobject.setCasedoc(bbuf);
                        String str = casedoc_FileName;
                        // String [] value=str.split(".");
                        String value = str.substring(0, str.lastIndexOf("."));
                        phobject.setDocName(value);
                        phobject.setFileName(casedoc_FileName);
                    }
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // lawenforecaseMag.getObject(object);
            // baseEntityManager.copyObjectNotNullProperty(phobject, object);

            lawenforecaseMag.lawenforecaseSave(phobject);
            this.setFlag("1");
            return this.List();

        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 修改信息
     * 
     * @return
     */

    public String lawUpdate() {
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        String caseno = (String) request.getAttribute("caseno");
        try {
            caseno = java.net.URLDecoder.decode(caseno, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // caseno=this.changeString(caseno);
        object.setCaseno(caseno);
        this.edit();
        return EDIT;
    }

    /**
     * 材料下载使用
     */
    private InputStream stuffStream;

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    private String fileType;// 附件类型

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    // 针对附件异常的提示
    ActionContext context = ActionContext.getContext();
    HttpServletResponse response;

    /**
     * 查看附件信息
     * 
     * @return
     * @throws UnsupportedEncodingException
     */
    public String downloadStuff() throws IOException {
        String caseno = this.changeString(object.getCaseno());
        Lawenforecase bean = lawenforecaseMag.getObjectById(caseno);
        String fileName = "文件查看";
        byte[] bt = null;
        if ("casedoc".equals(fileType)) {
            fileName = bean.getFileName();
            bt = bean.getCasedoc();
        }
        try {
            if (bt != null) {
                setStuffStream(new ByteArrayInputStream(bt));
            } else {
                // saveError("没有电子档！");
                this.postAlertMessage("操作失败，没有电子档！", response);
                return null;
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }
        this.setFilename(new String(fileName.getBytes("GBK"), "ISO8859-1"));
        return "download";
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
     * 删除附件
     * 
     * @return
     */
    public String deleteStuff() {
        String caseno = this.changeString(object.getCaseno());
        Lawenforecase bean = lawenforecaseMag.getObjectById(caseno);
        if ("casedoc".equals(fileType)) {
            bean.setFileName("");
            bean.setDocName("");
            bean.setCasedoc(null);
            lawenforecaseMag.saveObject(bean);
        }
        return this.edit();
    }

    /**
     * 查看
     * 
     * @return
     */
    public String lawsuitview() {
        String caseno = (String) request.getAttribute("caseno");
        try {
            caseno = java.net.URLDecoder.decode(caseno, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // caseno=this.changeString(caseno);
        System.out.println(caseno);
        object.setCaseno(caseno);
        Lawenforecase phobject = new Lawenforecase();
        phobject = lawenforecaseMag.getUpdateNo(caseno);
        request.setAttribute("phobject", phobject);
        this.view();
        System.out.println(phobject.getCaseno() + object.getCaseno());
        return "view";
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

    public List<Lawenforecase> getLawsuitlist() {
        return Lawsuitlist;
    }

    public void setLawsuitlist(List<Lawenforecase> lawsuitlist) {
        Lawsuitlist = lawsuitlist;
    }

    public String lawdelete() {
        String caseno = object.getCaseno();
        try {
            caseno = java.net.URLDecoder.decode(caseno, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // caseno=this.changeString(caseno);
        object.setCaseno(caseno);
        // super.delete();
        lawenforecaseMag.deleteObject(object);
        this.setFlag("1");
        String url = "powerbase/lawenforecase!List.do";
        String message = "删除" + object.getCaseno() + "执法案列成功！";
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

    @Override
    public void setServletResponse(HttpServletResponse arg0) {
        
        this.response = arg0;
    }

    protected String changeString(String value) {
        try {
            value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;

    }

}
