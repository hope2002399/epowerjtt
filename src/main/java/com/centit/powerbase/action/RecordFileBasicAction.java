package com.centit.powerbase.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.RecordFileBasic;
import com.centit.powerbase.po.RecordFileStuff;
import com.centit.powerbase.po.VRecordFileBasic;
import com.centit.powerbase.service.RecordFileBasicManager;
import com.centit.powerbase.service.RecordFileDepManager;
import com.centit.powerbase.service.RecordFileStuffManager;
import com.centit.powerbase.service.VRecordFileBasicManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class RecordFileBasicAction extends
        BaseEntityExtremeAction<RecordFileBasic> implements
        ServletResponseAware {
    private static final long serialVersionUID = 1L;
    HttpServletResponse response;
    private RecordFileBasicManager recordFileBasicManager;
    private RecordFileDepManager recordFileDepManager;
    private List<RecordFileBasic> recordList = new ArrayList<RecordFileBasic>();
    private List<VRecordFileBasic> vrecordList = new ArrayList<VRecordFileBasic>();
    private List<FUnitinfo> allunitList;
    private String constituteId;
    private String sfile_FileName;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private RecordFileStuffManager recordFileStuffManager;
    private VRecordFileBasicManager vRecordFileBasicManager;

    private List<RecordFileStuff> listfileStuff;
    private InputStream stuffStream;
    private String filename;
    private String attachNo;
    private RecordFileStuff filestuff;
    private File sfile_;
    private String upshow;// 判断是否是上传文件 1表示上传文件

    private String unitsJson;
    private String parentUnit;

    protected void getDep(FUserDetail user) {
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();// 获取该部门编码的顶层部门信息

    }

    @SuppressWarnings("unchecked")
    public String list() {// 查询显示

        FUserDetail user = ((FUserDetail) getLoginUser());
        getDep(user);
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        String orderField = request.getParameter("orderField");
        String orderDirection = request.getParameter("orderDirection");
        if (!StringUtils.isBlank(orderField)
                && !StringUtils.isBlank(orderDirection)) {
            filterMap.put(CodeBook.SELF_ORDER_BY, orderField + " "
                    + orderDirection);
        } else {
            filterMap.put(CodeBook.SELF_ORDER_BY, "bookDate desc");
        }
        filterMap.put("operatorID", user.getUsercode());
        filterMap.put("dealStep", "1");

        PageDesc pageDesc = makePageDesc();
        vrecordList = vRecordFileBasicManager.listObjects(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        try {
            backurl = this.getBackUrl(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "list";
    }

    public String view() {// 查看详细信息
        super.view();

        setUpshow(null);// 不显示上传文件区域

        String depName = recordFileBasicManager.getDepNamesByDepIds(object
                .getConstituteDepName());
        object.setConstituteId(depName);// 将数据库中获得的unitcode转为unitname

        listfileStuff = recordFileStuffManager
                .getRecordFileStuffByRecord(object.getRecordCode());
        // 获得已上传的文件

        return "view";
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

    public String chooseDep() {// 添加备案时，选取制定部门
        allunitList = sysUnitManager.getValidObjects();
        return "chooseDep";
    }

    public String stuffDown() throws IOException {// 附件查看或者下载
        String attachNo = (String) request.getAttribute("attachNo");
        RecordFileStuff bean = recordFileStuffManager.getStuffByNo(attachNo);
        String fileName = "文件查看";
        byte[] bt = null;
        fileName = bean.getFileName();
        bt = bean.getContext();

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

    public String editInitial() {// 新添
        FUserDetail user = ((FUserDetail) getLoginUser());
        getDep(user);

        try {
            backurl = this.URLDecoding(backurl);// 因为backurl已经在list方法中被编码过了，所以在此处需要解码。。。。
            object = getEntityClass().newInstance();
            object.clearProperties();
            return "edit";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    public String edit() {// 编辑
        FUserDetail user = ((FUserDetail) getLoginUser());
        getDep(user);

        super.edit();

        String depName = recordFileBasicManager.getDepNamesByDepIds(object
                .getConstituteDepName());
        object.setConstituteId(depName);

        return "edit";

    }

    /****** 未使用到 *****/
    /*
     * public String delete() { super.delete();
     * 
     * return "delete"; }
     */

    public String save() {// 保存
        boolean flag = false;
        if (!StringUtils.isBlank(object.getRecordCode())) {// 修改
            flag = true;
        }
        if (StringUtils.isBlank(object.getRecordCode())) {// 新增
            object.setRecordCode(recordFileBasicManager.getRecordCode());
            object.setBookDate(new Date(System.currentTimeMillis()));
            object.setDealStep("1");
            FUserDetail user = ((FUserDetail) getLoginUser());
            object.setOperatorID(user.getUsercode());
            object.setFinishStatus("0");
        }

        recordFileBasicManager.saveObject(object);

        if (flag) {
            recordFileDepManager.delDepByRecordCode(object.getRecordCode());
            // 若是修改备案文件信息，则将recordFileDep中已存储recordCode等于当前的code删除，更新后重新添加
        }
        recordFileDepManager.saveDeps(object.getRecordCode(),
                object.getConstituteDepName());
        // 将constitutedepid和recordCode存入数据库
        request.setAttribute("recordCode", object.getRecordCode());
        request.setAttribute("upshow", "1");
        return this.upstuff();
    }

    public String upstuff() {// 查看详细信息

        super.view();
        String depName = recordFileBasicManager.getDepNamesByDepIds(object
                .getConstituteDepName());
        object.setConstituteId(depName);// 将数据库中获得的unitcode转为unitname
        listfileStuff = recordFileStuffManager
                .getRecordFileStuffByRecord(object.getRecordCode());

        if (filestuff != null) {
            filestuff.clearProperties();
        }
        return "view";

    }

    public String complete() {
        return this.list();
    }

    public String savestuff() {// 保存附件
        if (sfile_ == null) {
            this.postAlertMessage("请选择文件！", response);
            return null;
        }

        FUserDetail user = ((FUserDetail) getLoginUser());
        filestuff.setOperatorID(user.getUsercode());
        filestuff.setUploadDate(new Date(System.currentTimeMillis()));
        filestuff.setAttachNo(recordFileStuffManager.getAttachNo());
        filestuff.setRecordCode(object.getRecordCode());
        filestuff.setProcessNo("1");

        try {
            FileInputStream fis = new FileInputStream(sfile_);
            if (fis != null) {
                byte[] bbuf = null;
                int len = fis.available();
                bbuf = new byte[len];
                fis.read(bbuf);
                filestuff.setContext(bbuf);
                filestuff.setFileName(sfile_FileName);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        recordFileStuffManager.saveObject(filestuff);
        request.setAttribute("recordCode", object.getRecordCode());
        request.setAttribute("upshow", "1");
        return this.upstuff();
    }

    /****************************** 为第三方页面准备返回到本页面的URL **************************************/
    private String backurl;

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

    /****************************** 为第三方页面准备返回到本页面的URL **************************************/

    public String getSfile_FileName() {
        return sfile_FileName;
    }

    public void setSfile_FileName(String sfile_FileName) {
        this.sfile_FileName = sfile_FileName;
    }

    public List<FUnitinfo> getAllunitList() {
        return allunitList;
    }

    public void setAllunitList(List<FUnitinfo> allunitList) {
        this.allunitList = allunitList;
    }

    public String getAttachNo() {
        return attachNo;
    }

    public RecordFileStuff getFilestuff() {
        return filestuff;
    }

    public void setFilestuff(RecordFileStuff filestuff) {
        this.filestuff = filestuff;
    }

    public void setAttachNo(String attachNo) {
        this.attachNo = attachNo;
    }

    public String getFilename() {
        return filename;
    }

    public File getSfile_() {
        return sfile_;
    }

    public void setSfile_(File sfile_) {
        this.sfile_ = sfile_;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    public List<RecordFileStuff> getListfileStuff() {
        return listfileStuff;
    }

    public void setListfileStuff(List<RecordFileStuff> listfileStuff) {
        this.listfileStuff = listfileStuff;
    }

    public void setRecordFileStuffManager(
            RecordFileStuffManager recordFileStuffManager) {
        this.recordFileStuffManager = recordFileStuffManager;
    }

    public void setvRecordFileBasicManager(
            VRecordFileBasicManager vRecordFileBasicManager) {
        this.vRecordFileBasicManager = vRecordFileBasicManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public List<RecordFileBasic> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<RecordFileBasic> recordList) {
        this.recordList = recordList;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        
        this.response = response;
    }

    public String getConstituteId() {
        return constituteId;
    }

    public void setConstituteId(String constituteId) {
        this.constituteId = constituteId;
    }

    public void setRecordFileBasicManager(RecordFileBasicManager basemgr) {
        recordFileBasicManager = basemgr;
        this.setBaseEntityManager(recordFileBasicManager);
    }

    public void setRecordFileDepManager(
            RecordFileDepManager recordFileDepManager) {
        this.recordFileDepManager = recordFileDepManager;
    }

    public String getUpshow() {
        return upshow;
    }

    public void setUpshow(String upshow) {
        this.upshow = upshow;
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

    public List<VRecordFileBasic> getVrecordList() {
        return vrecordList;
    }

    public void setVrecordList(List<VRecordFileBasic> vrecordList) {
        this.vrecordList = vrecordList;
    }
}
