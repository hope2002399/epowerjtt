package com.centit.powerbase.action;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.PunishResult;
import com.centit.monitor.service.PunishResultManager;
import com.centit.powerbase.po.PunishBasic;
import com.centit.powerbase.po.PunishRecord;
import com.centit.powerbase.po.RecordBasic;
import com.centit.powerbase.po.Suppower;
import com.centit.powerbase.service.PunishBasicManager;
import com.centit.powerbase.service.PunishrecordManager;
import com.centit.powerbase.service.RecordBasicManager;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.opensymphony.xwork2.ActionContext;

public class PunishRecordBasicAction extends
        BaseEntityExtremeAction<RecordBasic> implements ServletResponseAware {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory
            .getLog(PunishRecordBasicAction.class);
    private static final long serialVersionUID = 1L;
    private PunishBasicManager punishBasicManager;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private SuppowerManager suppowerManager;
    private List<PunishBasic> punishList;
    private List<RecordBasic> recordInfo;
    private List<Suppower> supPwoerList;
    private InputStream recordBasicStream;
    private PunishrecordManager punishRecordManager;
    private PunishResultManager punishResultManager;

    public PunishResultManager getPunishResultManager() {
        return punishResultManager;
    }

    public void setPunishResultManager(PunishResultManager punishResultManager) {
        this.punishResultManager = punishResultManager;
    }

    public InputStream getRecordBasicStream() {
        return recordBasicStream;
    }

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setRecordBasicStream(InputStream recordBasicStream) {
        this.recordBasicStream = recordBasicStream;
    }

    public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }

    private RecordBasicManager recordBasicManager;
    ActionContext actionContext = ActionContext.getContext();

    public ActionContext getActionContext() {
        return actionContext;
    }

    public List<Suppower> getSupPwoerList() {
        return supPwoerList;
    }

    public void setSupPwoerList(List<Suppower> supPwoerList) {
        this.supPwoerList = supPwoerList;
    }

    public void setActionContext(ActionContext actionContext) {
        this.actionContext = actionContext;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;

    }

    HttpServletResponse response;

    public void setRecordBasicManager(RecordBasicManager recordBasicManager) {
        this.recordBasicManager = recordBasicManager;
    }

    public void setPunishRecordManager(PunishrecordManager punishRecordManager) {
        this.punishRecordManager = punishRecordManager;
    }

    public List<RecordBasic> getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(List<RecordBasic> recordInfo) {
        this.recordInfo = recordInfo;
    }

    public void setPunishBasicManager(PunishBasicManager punishBasicManager) {
        this.punishBasicManager = punishBasicManager;

    }

    public List<PunishBasic> getPunishList() {
        return punishList;
    }

    public void setPunishList(List<PunishBasic> punishList) {
        this.punishList = punishList;
    }

    private String unitsJson;

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

    private String parentUnit;

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public String PunishTemp() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser.getUsercode());
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String sParentUnit = dept.getUnitcode();

        if (!StringBaseOpt.isNvl(sParentUnit)) {
            if (sysUnitManager.getObjectById(sParentUnit) != null) {
                String s_org_id = sysUnitManager.getObjectById(sParentUnit)
                        .getDepno();
                filterMap.put("parentDepno", s_org_id);
                filterMap.put("orgId", s_org_id);
            } else { // 不做处理

            }

        } else { // 不做处理
        }
        String orgId = (String) filterMap.get("org_id");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(orgId) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("parentDepno", orgId);
            filterMap.put("org_id", null);
        } else if (!StringBaseOpt.isNvl(orgId)) {
            filterMap.put("org_id", orgId);
        } else {
            // 不做处理
        }
        if (null == filterMap.get("beginCreateDate")
                && null == filterMap.get("endCreateDate")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dt = new Date(System.currentTimeMillis());
            String sDateTime = sdf.format(dt);
            filterMap.put("beginCreateDate", sDateTime.substring(0, 8)
                    + "01 00:00:00");
            request.setAttribute("beginCreateDate", sDateTime.substring(0, 8)
                    + "01");
            filterMap.put("endCreateDate", sDateTime.substring(0, 10)
                    + " 23:59:59");
            request.setAttribute("endCreateDate", sDateTime.substring(0, 10));
        } else {
            if (null != filterMap.get("beginCreateDate")) {
                String beginCreateDate = (String) filterMap
                        .get("beginCreateDate");
                request.setAttribute("beginCreateDate", beginCreateDate);
                if (beginCreateDate.length() == 10) {
                    beginCreateDate = beginCreateDate + " 00:00:00";
                    filterMap.put("beginCreateDate", beginCreateDate);
                }
            }
            if (null != filterMap.get("endCreateDate")) {
                String endCreateDate = (String) filterMap.get("endCreateDate");
                request.setAttribute("endCreateDate", endCreateDate);
                if (endCreateDate.length() == 10) {
                    endCreateDate = endCreateDate + " 23:59:59";
                    filterMap.put("endCreateDate", endCreateDate);
                }

            }
        }
        punishList = punishBasicManager.listObjects(filterMap, pageDesc);
        supPwoerList = suppowerManager.getlistSuppower("CF");
        totalRows = pageDesc.getTotalRows();
        unitsJson = sysUnitManager.getAllSubUnitsJSON(sParentUnit);// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(sParentUnit).getParentunit();// 获取该部门编码的顶层部门信息
        return SUCCESS;
    }

    @SuppressWarnings("unused")
    public String RadioDetail() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        String isShow = "hidden";
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        punishList = punishBasicManager.PunishBasicTemp(filterMap, pageDesc);// 对应v_Punish_Reordbasic视图
        recordInfo = recordBasicManager.recordBasicList(filterMap, pageDesc);
        filterMap.put("org_id", punishList.get(0).getOrg_id());
        List<PunishRecord> punishRecord = punishRecordManager.getPunishRecord(
                filterMap, pageDesc);
        /* String target_type = punishList.get(0).getTarget_type(); */
        /*
         * if (!punishRecord.isEmpty()){ Long personNum =
         * punishRecord.get(0).getPersonNum(); Long corpNum =
         * punishRecord.get(0).getCorpNum(); if (target_type.equals("0")) { if
         * (!punishRecord.isEmpty() &&
         * !StringBaseOpt.isNvl(String.valueOf(personNum)))
         * punishList.get(0).setPersonNum(personNum); else {
         * 
         * } } else if (target_type.equals("1") || "2".equals(target_type)) { if
         * (!punishRecord.isEmpty() &&
         * !StringBaseOpt.isNvl(String.valueOf(corpNum))) {
         * punishList.get(0).setPersonNum(corpNum); } else {
         * 
         * } } }
         */
        if (!recordInfo.isEmpty()) {
            String filename = recordInfo.get(0).getFileName();
            if (filename != " " && filename != null) {
                isShow = "visible";
            }

        }

        request.setAttribute("isShow", isShow);
        totalRows = pageDesc.getTotalRows();
        return "radio";
    }

    @SuppressWarnings("unused")
    public String RadioSave() {
        String message;
        String fileName = object.getFileName();
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        recordInfo = recordBasicManager.recordBasicList(filterMap, pageDesc);
        RecordBasic recordBasic = new RecordBasic();
        if (!recordInfo.isEmpty()) {
            recordBasic = recordInfo.get(0);
            fileName = recordBasic.getFileName();
        }
        if (object.getOperatorId() == null
                && recordBasic.getOperatorId() == null) {
            filterMap.put("recordCode", recordBasicManager.getRecordCode());
            object.setNo((String) filterMap.get("no"));
            object.setOperatorId(fuser.getUsername());
            object.setBookDate(new Date());
        }
        if (StringBaseOpt.isNvl(object.getFileName())
                && StringBaseOpt.isNvl(recordBasic.getFileName())) {

            String url = "powerbase/punishRecordBasic!PunishTemp.do?usercode=0";
            try {
                this.AlertMessage(url, "请选择文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                // 判断附件名是否存在
                if (!StringBaseOpt.isNvl(object.getFileName())) {
                    @SuppressWarnings("resource")
                    FileInputStream fis = new FileInputStream(
                            object.getFileName());
                    if (fis != null) {
                        byte[] bbuf = null;
                        int len;
                        len = fis.available();
                        bbuf = new byte[len];
                        fis.read(bbuf);
                        object.setApplyFile(bbuf);
                    } else {
                        // 不修改附件的情况

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!StringBaseOpt.isNvl((String) filterMap.get("recordCode"))) {
                object.setRecordCode((String) filterMap.get("recordCode"));
            }
            recordBasicManager.copyObjectNotNullProperty(recordBasic, object);
            if (StringBaseOpt.isNvl(object.getFileName())) {
                recordBasic.setFileName(fileName);
            }
            recordBasicManager.saveObject(recordBasic);
            // 修改备案状态
            PunishResult punishResult = new PunishResult();
            filterMap.put("no", null);
            if (!punishResultManager.listObjects(filterMap, pageDesc).isEmpty()) {
                punishResult = punishResultManager.getPunishResult(
                        (String) filterMap.get("internal_no"),
                        (String) filterMap.get("org_id"));
                punishResult.setIsRecord("1");
                punishResultManager.saveObject(punishResult);
            }
            String url = "powerbase/punishRecordBasic!PunishTemp.do?usercode=0";
            message = "修改成功";
            object.clearProperties();
            try {
                this.AlertMessage(url, message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return this.PunishTemp();
    }

    public String recordBasicDown() {// 附件查看或者下载
        setRecordInfo(null);
        String no = (String) request.getAttribute("no");
        String fileName = "文件查看";

        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        filterMap.put("no", no);
        byte[] bt = null;
        recordInfo = recordBasicManager.recordBasicList(filterMap, pageDesc);
        bt = recordInfo.get(0).getApplyFile();
        fileName = recordInfo.get(0).getFileName();
        if (bt != null) {
            setRecordBasicStream(new ByteArrayInputStream(bt));
        }
        try {
            this.setFilename(new String(fileName.getBytes("GBK"), "ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "download";

    }

    public String recordBasicDelete() {// 附件删除
        String message = null;
        String url = "powerbase/punishRecordBasic!PunishTemp.do?usercode=0";
        setRecordInfo(null);
        String no = (String) request.getAttribute("no");
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        filterMap.put("no", no);
        if (no != null) {
            recordInfo = recordBasicManager
                    .recordBasicList(filterMap, pageDesc);
            recordBasicManager.deleteObjectById(no);
            RecordBasic recordBasic = new RecordBasic();
            recordBasic = recordInfo.get(0);
            recordBasic.setApplyFile(null);
            recordBasic.setFileName(null);
            // recordBasicManager.copyObjectNotNullProperty(recordBasic,
            // object);
            recordBasicManager.saveObject(recordBasic);
            message = "删除成功";
        }
        try {
            this.AlertMessage(url, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.PunishTemp();

    }

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

    public String Compare() {
        String org_id = (String) request.getParameter("org_id");
        String targerType = (String) request.getParameter("targerType");
        String callback = request.getParameter("callback");
        PunishRecord punishRecord = punishBasicManager
                .getPunishRecordByOrgid(org_id);
        HttpServletResponse response = (HttpServletResponse) ActionContext
                .getContext().get(ServletActionContext.HTTP_RESPONSE);
        String str_utf = callback;
        if ("0".equals(targerType)) {
            String personnum = "";
            String personbusness = "";
            if (null != punishRecord.getPersonNum()) {
                personnum = String.valueOf(punishRecord.getPersonNum());
            } else {
                personnum = "null";
            }
            if (null != punishRecord.getPersonNumBusiness()) {
                personbusness = String.valueOf(punishRecord
                        .getPersonNumBusiness());
            } else {
                personbusness = "null";
            }
            str_utf = str_utf + "({num:'" + personnum + "',business:'"
                    + personbusness + "'})";
        } else {
            String corpnum = "";
            String corpBusiness = "";
            if (null != punishRecord.getCorpNum()) {
                corpnum = String.valueOf(punishRecord.getCorpNum());
            } else
                corpnum = "null";
            if (null != punishRecord.getCorpNumBusiness()) {
                corpBusiness = String
                        .valueOf(punishRecord.getCorpNumBusiness());
            } else
                corpBusiness = "null";
            str_utf = str_utf + "({num:'" + corpnum + "',business:"
                    + corpBusiness + "'})";
        }
        try {
            response.getWriter().print(str_utf);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
