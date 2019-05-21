package com.centit.powerbase.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.LawExecutor;
import com.centit.powerbase.po.LawexecutorInspect;
import com.centit.powerbase.service.LawExecutorManager;
import com.centit.powerbase.service.LawexecutorInspectManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

/**
 * 执法人员管理模块Action
 * 
 * @author jf
 * @create 2013-10-23
 * @version
 */
public class LawExecutorAction extends BaseEntityExtremeAction<LawExecutor>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    private LawExecutorManager lawExecutorMag;
    HttpServletResponse response;
    private InputStream stuffStream;// 附件流
    private File file;// 证件照附件
    private SysUnitManager sysUnitManager;// 部门Service
    private String unitsJson;// 部门JSON
    private String staffnos;// 批量处理是主键串
    private LawexecutorInspectManager lawexecutorInspectManager;// 年检Service
    private List<LawexecutorInspect> inspectList;// 某执法人员的年检记录列表
    private String parentUnit;// 父部门ID
    private SysUserManager sysUserManager;
    private String backurl;

    public void setLawExecutorManager(LawExecutorManager basemgr) {
        lawExecutorMag = basemgr;
        this.setBaseEntityManager(lawExecutorMag);
    }

    @Override
    public String edit() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        if (dept != null) {

            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());

            FUnitinfo unit = sysUnitManager.getObjectById(dept.getUnitcode());

            parentUnit = unit.getParentunit();

        } else {
            unitsJson = "{}";
        }
        return super.edit();
    }

    @Override
    public String view() {
        
        return super.view();
    }

    @Override
    public String built() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        if (dept != null) {

            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());

            FUnitinfo unit = sysUnitManager.getObjectById(dept.getUnitcode());

            parentUnit = unit.getParentunit();

        } else {
            unitsJson = "{}";
        }
        return super.built();
    }

    @Override
    public String list() {
        // 执法人员汇总列表
        String result = super.list();
        try {
            backurl = this.getBackUrl(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 审核查找操作
     * 
     * @return
     */
    public String check() {
        String result = super.edit();
        if (result.equals(EDIT)) {
            return "check";
        } else {
            return result;
        }
    }

    /**
     * 年检查找操作
     * 
     * @return
     */
    public String inspect() {
        String result = super.edit();
        if (result.equals(EDIT)) {
            // 查询该人员的年检记录信息
            Map<String, Object> filterMap = new HashMap<String, Object>();
            filterMap.put("staffno", request.getParameter("staffno"));
            inspectList = lawexecutorInspectManager.listObjects(filterMap);

            return "inspect";
        } else {
            return result;
        }
    }

    /**
     * 执法人员年检列表
     * 
     * @return
     */
    public String listInspect() {
        try {
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            String orderField = request.getParameter("orderField");
            String orderDirection = request.getParameter("orderDirection");

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // 默认查询审核通过信息
            filterMap.put("auditIdeaCode", "2");

            if (!StringUtils.isBlank(orderField)
                    && !StringUtils.isBlank(orderDirection)) {
                filterMap.put(CodeBook.SELF_ORDER_BY, orderField + " "
                        + orderDirection);
            }
            PageDesc pageDesc = makePageDesc();
            objList = baseEntityManager.listObjects(filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();

            this.pageDesc = pageDesc;

            try {
                backurl = this.getBackUrl(null);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "listInspect";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 执法人员审核列表
     * 
     * @return
     */
    public String listCheck() {
        try {
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            String orderField = request.getParameter("orderField");
            String orderDirection = request.getParameter("orderDirection");

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // 默认查询待审核信息
            filterMap.put("auditIdeaCode", "1");

            if (!StringUtils.isBlank(orderField)
                    && !StringUtils.isBlank(orderDirection)) {
                filterMap.put(CodeBook.SELF_ORDER_BY, orderField + " "
                        + orderDirection);
            }
            PageDesc pageDesc = makePageDesc();

            FUserDetail user = (FUserDetail) getLoginUser();

            objList = lawExecutorMag.pageCheckList(user.getPrimaryUnit(),
                    filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();

            this.pageDesc = pageDesc;

            try {
                backurl = this.getBackUrl(null);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "listCheck";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    protected void postAlertMessage(String msg, HttpServletResponse response) {// 提示信息
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

    public String CheckPassCode() {
        String passCode = object.getPasscode();
        if (StringBaseOpt.isNvl(passCode)) {
            this.postAlertMessage("请输入编号", response);
        }
        if (lawExecutorMag.IsPasscodeExist(passCode)) {
            this.postAlertMessage("该证书编号已存在", response);
        } else
            this.postAlertMessage("该证书编号可用", response);
        return null;
    }

    /**
     * 执法人员登记列表
     * 
     * @return
     */
    public String listRegister() {
        try {
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            String orderField = request.getParameter("orderField");
            String orderDirection = request.getParameter("orderDirection");

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // 默认查询登记人是自己的信息
            FUserDetail user = (FUserDetail) getLoginUser();
            filterMap.put("operator", user.getUsercode());
            // filterMap.put("s_");

            if (!StringUtils.isBlank(orderField)
                    && !StringUtils.isBlank(orderDirection)) {
                filterMap.put(CodeBook.SELF_ORDER_BY, orderField + " "
                        + orderDirection);
            }
            PageDesc pageDesc = makePageDesc();
            objList = baseEntityManager.listObjects(filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();

            this.pageDesc = pageDesc;

            try {
                backurl = this.getBackUrl(null);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "listRegister";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 批量审核
     * 
     * @return
     */
    public String batchCheck() {
        try {
            String auditIdeaCode = request.getParameter("auditIdeaCode");
            if (!staffnos.isEmpty()) {
                String[] statffno = staffnos.split(",");
                FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
                for (int i = 0; i < statffno.length; i++) {
                    LawExecutor le = lawExecutorMag.getObjectById(statffno[i]);
                    if (le != null) {
                        le.setAuditDate(DatetimeOpt.currentUtilDate());
                        le.setAuditUserCode(user.getUsercode());
                        le.setAuditIdeaCode(auditIdeaCode);
                        lawExecutorMag.saveObject(le);
                    }
                }
                savedMessage();
            }
            return "checkSuccess";
        } catch (Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 审核保存操作
     * 
     * @return
     */
    public String checkSave() {
        try {
            LawExecutor le = lawExecutorMag.getObject(object);
            if (le != null) {
                // 审核动作时,原纪录处于待审核状态
                lawExecutorMag.copyObjectNotNullProperty(le, object);
                object = le;
                object.setAuditDate(DatetimeOpt.currentUtilDate());// 设置审核时间
                FUserDetail user = (FUserDetail) getLoginUser();
                object.setAuditUserCode(user.getUsercode()); // 设置审核人
            } else {
                return ERROR;
            }
            lawExecutorMag.saveObject(object);
            savedMessage();
            return "checkSuccess";
        } catch (Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
    }

    @Override
    public String save() {
        try {
            LawExecutor le = lawExecutorMag.getObject(object);
            if (le != null) {// 修改
                lawExecutorMag.copyObjectNotNullProperty(le, object);
                object = le;
                object.setRepairdate(DatetimeOpt.currentUtilDate());// 设置修改时间
            } else {
                // 新增登记或者新增直接提交审核
                FUserDetail user = (FUserDetail) getLoginUser();// 获取当前用户的信息
                object.setOperator(user.getUsercode());
                object.setInputtime(DatetimeOpt.currentUtilDate());
                // 生成主键
                object.setStaffno(lawExecutorMag.createStaffno(object
                        .getDeptid()));
            }
            byte[] b = null;
            if (file != null) {
                FileInputStream fis = new FileInputStream(file);
                int len = fis.available();
                b = new byte[len];
                fis.read(b);
                object.setCardphoto(b);
                fis.close();
            }
            lawExecutorMag.saveObject(object);
            savedMessage();
            return SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 下载照片
     * 
     * @return
     */
    public String downloadPhoto() {
        LawExecutor le = lawExecutorMag.getObject(object);
        byte[] bt = null;
        if (le != null)
            bt = le.getCardphoto();
        try {
            if (bt != null)
                setStuffStream(new ByteArrayInputStream(bt));
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
        }
        return "download";
    }

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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

    public String getStaffnos() {
        return staffnos;
    }

    public void setStaffnos(String staffnos) {
        this.staffnos = staffnos;
    }

    public LawexecutorInspectManager getLawexecutorInspectManager() {
        return lawexecutorInspectManager;
    }

    public void setLawexecutorInspectManager(
            LawexecutorInspectManager lawexecutorInspectManager) {
        this.lawexecutorInspectManager = lawexecutorInspectManager;
    }

    public List<LawexecutorInspect> getInspectList() {
        return inspectList;
    }

    public void setInspectList(List<LawexecutorInspect> inspectList) {
        this.inspectList = inspectList;
    }

    public String getParentUnit() {
        return parentUnit;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setServletResponse(HttpServletResponse response) {
        
        this.response = response;
    }

    /**
     * 为第三方页面准备返回到本页面的URL
     * 
     * @param params
     *            要带的参数键，键值从request中获取；如果为null，则取所有request键
     * @return
     * @throws UnsupportedEncodingException
     */
    protected String getBackUrl(String[] params)
            throws UnsupportedEncodingException {
        return getBackUrl(params, null);
    }

    protected String getBackUrl(String[] params, String[] rejectParams)
            throws UnsupportedEncodingException {
        StringBuffer path = this.request.getRequestURL();
        String queryString = this.getQueryStringFromFormBean(params,
                rejectParams);
        if (!"".equals(queryString)) {
            path.append("?");
            path.append(queryString);
        }
        return URLEncoding(path.toString());
    }

    public String getQueryStringFromFormBean(String[] params,
            String[] rejectParams) throws UnsupportedEncodingException {
        Object[] objects = null;
        int length = 0;
        if (params == null) {
            objects = this.request.getParameterMap().keySet().toArray();
            length = objects.length;
        } else {
            length = params.length;
        }

        String queryString = "";
        for (int i = 0; i < length; i++) {
            String param = null;
            if (params == null) {
                param = (String) objects[i];
            } else {
                param = params[i];
            }
            if (rejectParams != null
                    && StringBaseOpt.contains(rejectParams, param)) {
                continue;
            }
            String value = this.request.getParameter(param);
            if (value != null && !value.equals("")) {
                if (!"".equals(queryString) && !queryString.endsWith("&")) {
                    queryString += "&";
                }
                queryString += param + "=" + URLEncoding(value);
            }
        }
        return queryString;
    }

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl;
    }

    public String URLEncoding(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (Exception e) {
        }
        return value;
    }

    public String URLDecoding(String value) {
        try {
            return URLDecoder.decode(value, "UTF-8");
        } catch (Exception e) {
        }
        return value;
    }

    protected String changeString(String value) {
        if (value == null) {
            return null;
        }
        try {
            value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;

    }
}
