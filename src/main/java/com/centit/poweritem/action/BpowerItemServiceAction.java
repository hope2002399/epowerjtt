package com.centit.poweritem.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.extremecomponents.table.limit.Limit;
import org.springframework.security.core.context.SecurityContextHolder;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.action.SupPowerAction;
import com.centit.powerbase.po.SuppowerStandard;
import com.centit.powerbase.po.Suppowerchglog;
import com.centit.powerbase.service.SuppowerchglogManager;
import com.centit.poweritem.po.BpowerItem;
import com.centit.poweritem.po.BpowerItemService;
import com.centit.poweritem.po.VpowerItemServiceChange;
import com.centit.poweritem.service.BpowerItemManager;
import com.centit.poweritem.service.BpowerItemServiceManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.opensymphony.xwork2.ActionContext;

public class BpowerItemServiceAction extends
        BaseEntityExtremeAction<BpowerItemService> implements
        ServletResponseAware {
    private static final long serialVersionUID = 1L;
    ActionContext context = ActionContext.getContext();
    HttpServletResponse response;
    private BpowerItemManager bpowerItemManager;
    private BpowerItemServiceManager bpowerItemServiceManager;
    private SuppowerchglogManager suppowerchglogManager;

    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private List<FUnitinfo> unitList;
    private String unitsJson;
    private String parentunit;
    private Suppowerchglog suppowerchglog;
    @SuppressWarnings("rawtypes")
    private List bpowerItemlist;
    @SuppressWarnings("rawtypes")
    private List bpowerItemServicelist;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public SuppowerchglogManager getSuppowerchglogManager() {
        return suppowerchglogManager;
    }

    public void setSuppowerchglogManager(
            SuppowerchglogManager suppowerchglogManager) {
        this.suppowerchglogManager = suppowerchglogManager;
    }

    public ActionContext getContext() {
        return context;
    }

    public void setContext(ActionContext context) {
        this.context = context;
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

    @SuppressWarnings("rawtypes")
    public List getBpowerItemlist() {
        return bpowerItemlist;
    }

    @SuppressWarnings("rawtypes")
    public void setBpowerItemlist(List bpowerItemlist) {
        this.bpowerItemlist = bpowerItemlist;
    }

    public BpowerItemManager getBpowerItemManager() {
        return bpowerItemManager;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
    }

    public Suppowerchglog getSuppowerchglog() {
        return suppowerchglog;
    }

    public void setSuppowerchglog(Suppowerchglog suppowerchglog) {
        this.suppowerchglog = suppowerchglog;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {

        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setBpowerItemManager(BpowerItemManager bpowerItemManager) {
        this.bpowerItemManager = bpowerItemManager;
    }

    public BpowerItemServiceManager getBpowerItemServiceManager() {
        return bpowerItemServiceManager;
    }

    public void setBpowerItemServiceManager(
            BpowerItemServiceManager bpowerItemServiceManager) {
        this.bpowerItemServiceManager = bpowerItemServiceManager;
    }

    @SuppressWarnings("rawtypes")
    public List getBpowerItemServicelist() {
        return bpowerItemServicelist;
    }

    @SuppressWarnings("rawtypes")
    public void setBpowerItemServicelist(List bpowerItemServicelist) {
        this.bpowerItemServicelist = bpowerItemServicelist;
    }

    /**
     * 权力变更申请修改权力事项信息
     * 
     * @return
     */
    @SuppressWarnings("rawtypes")
    List versionList = new ArrayList();
    Long version_bg;

    public Long getVersion_bg() {
        return version_bg;
    }

    public void setVersion_bg(Long version_bg) {
        this.version_bg = version_bg;
    }

    @SuppressWarnings("rawtypes")
    public List getVersionList() {
        return versionList;
    }

    @SuppressWarnings("rawtypes")
    public void setVersionList(List versionList) {
        this.versionList = versionList;
    }

    @SuppressWarnings({ "unchecked", "static-access" })
    @Override
    public String edit() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        if (StringUtils.isBlank(object.getCid().getItemId())) {
            bpowerItemServiceManager.clearObjectProperties(object);
        } else {

            String itemid = (String) request.getAttribute("itemId");
            Long version = (Long) request.getAttribute("version");
            if (version_bg != null) {
                object.setVersion(version_bg);
                setVersion_bg(version_bg);
            }
            object = bpowerItemServiceManager.getObject(object);
            bpowerItemServicelist = bpowerItemServiceManager
                    .getlistSuppowerOld(itemid, version);
            for (int i = 0; i < bpowerItemServicelist.size(); i++) {
                BpowerItemService temp = new BpowerItemService();
                temp = (BpowerItemService) bpowerItemServicelist.get(i);
                versionList.add(temp.getVersion());
            }
            if (version != null) {
                object.setVersion(version);
                if (version_bg == null) {
                    setVersion_bg(version);
                }
            }
            List<SuppowerStandard> list2 = this.genxmlStandardList(object
                    .getRisk());
            request.setAttribute("list2", list2);
            List<SuppowerStandard> list1 = this.genProcessWorkDescList(object
                    .getProcessWorkDesc());
            request.setAttribute("list1", list1);
            List<SuppowerStandard> list3 = this.genAcceptConditionList(object
                    .getAcceptCondition());
            request.setAttribute("list3", list3);
            String flag = "1";// 表示添加
            if (list2.size() > 0) {
                flag = "2";
            }
            request.setAttribute("flag_hx", flag);
        }
        return "SuppowerQlbgSqNXg";
    }

    @SuppressWarnings("unused")
    public String checkItemId() {
        try {

            boolean b = bpowerItemServiceManager.isPowerExist(object
                    .getItemId());
            result = new JSONObject();
            if (b) {
                result.put("message", "USED");
            } else {
                result.put("message", "UNUSE");
            }
            String type = request.getParameter("type");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "checkitemid";
    }

    private JSONObject result;

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    public String editInitial() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        try {
            object = getEntityClass().newInstance();
            object.clearProperties();
            return "nEdit";

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 权力变更申请list
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String listSupPowerSQ() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("sParentUnit", sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String flag = "sq";
        bpowerItemServicelist = bpowerItemServiceManager
                .listSuppowerWithoutLob(flag, filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "listSupPowerSQ";
    }

    public String SuppowerQlbgSqXz() {
        this.editInitial();
        String itemId = request.getParameter("itemId");
        BpowerItem bi = bpowerItemManager.getObjectById(itemId);
        request.setAttribute("bi", bi);
        return "SuppowerQlbgSqNXz";

    }

    /**
     * 权力变更审核list
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String listSupPowerSH() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("sParentUnit", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String flag = "sh";
        bpowerItemServicelist = bpowerItemServiceManager
                .listSuppowerWithoutLob(flag, filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "listSupPowerSH";
    }

    /**
     * 查看附件信息
     * 
     * @return
     * @throws UnsupportedEncodingException
     */
    private String fileType;

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

    public String downloadStuff() throws IOException {
        BpowerItemService bean = bpowerItemServiceManager.getObjectById(object
                .getCid());
        String fileName = "文件查看";
        byte[] bt = null;
        if ("processDesc_".equals(fileType)) {
            fileName = bean.getFileName();
            bt = bean.getProcessDesc();
        } else if ("inFlowImg_".equals(fileType)) {
            fileName = bean.getInFlowImgName();
            bt = bean.getInFlowImg();
        } else if ("applyForm_".equals(fileType)) {
            fileName = bean.getFormName();
            bt = bean.getApplyForm();
        } else if ("applyFormDemo_".equals(fileType)) {
            fileName = bean.getApplyFormDemoName();
            bt = bean.getApplyFormDemo();
        } else if ("srvDirectoryStuff_".equals(fileType)) {
            fileName = "服务指南.doc";
            bt = bean.getSrvDirectoryStuff();
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

    public String deleteStuff() {
        BpowerItemService bean = bpowerItemServiceManager.getObjectById(object
                .getCid());
        if ("processDesc_".equals(fileType)) {
            bean.setFileName("");
            bean.setProcessDesc(null);
        } else if ("inFlowImg_".equals(fileType)) {
            bean.setInFlowImgName("");
            bean.setInFlowImg(null);
        } else if ("applyForm_".equals(fileType)) {
            bean.setFormName("");
            bean.setApplyForm(null);
        } else if ("applyFormDemo_".equals(fileType)) {
            bean.setApplyFormDemoName("");
            bean.setApplyFormDemo(null);
        } else if ("srvDirectoryStuff_".equals(fileType)) {
            bean.setSrvDirectoryStuff(null);
        }

        bpowerItemServiceManager.saveObject(bean);
        return this.edit();
    }

    // 保存权力信息
    private File processDesc_;
    private File applyForm_;
    private File srvDirectoryStuff_;
    private File applyFormDemo_;
    private String applyFormDemo_FileName;
    private File inFlowImg_;
    private String processDesc_FileName;
    private String applyForm_FileName;
    private String inFlowImg_FileName;
    private String sItemType;

    public File getProcessDesc_() {
        return processDesc_;
    }

    public void setProcessDesc_(File processDesc_) {
        this.processDesc_ = processDesc_;
    }

    public File getApplyForm_() {
        return applyForm_;
    }

    public void setApplyForm_(File applyForm_) {
        this.applyForm_ = applyForm_;
    }

    public File getSrvDirectoryStuff_() {
        return srvDirectoryStuff_;
    }

    public void setSrvDirectoryStuff_(File srvDirectoryStuff_) {
        this.srvDirectoryStuff_ = srvDirectoryStuff_;
    }

    public File getApplyFormDemo_() {
        return applyFormDemo_;
    }

    public void setApplyFormDemo_(File applyFormDemo_) {
        this.applyFormDemo_ = applyFormDemo_;
    }

    public String getApplyFormDemo_FileName() {
        return applyFormDemo_FileName;
    }

    public void setApplyFormDemo_FileName(String applyFormDemo_FileName) {
        this.applyFormDemo_FileName = applyFormDemo_FileName;
    }

    public File getInFlowImg_() {
        return inFlowImg_;
    }

    public void setInFlowImg_(File inFlowImg_) {
        this.inFlowImg_ = inFlowImg_;
    }

    public String getProcessDesc_FileName() {
        return processDesc_FileName;
    }

    public void setProcessDesc_FileName(String processDesc_FileName) {
        this.processDesc_FileName = processDesc_FileName;
    }

    public String getApplyForm_FileName() {
        return applyForm_FileName;
    }

    public void setApplyForm_FileName(String applyForm_FileName) {
        this.applyForm_FileName = applyForm_FileName;
    }

    public String getInFlowImg_FileName() {
        return inFlowImg_FileName;
    }

    public void setInFlowImg_FileName(String inFlowImg_FileName) {
        this.inFlowImg_FileName = inFlowImg_FileName;
    }

    public String getsItemType() {
        return sItemType;
    }

    public void setsItemType(String sItemType) {
        this.sItemType = sItemType;
    }

    /**
     * 权力变更申请，保存修改之后的权力信息
     * 
     * @return
     */
    @SuppressWarnings("unused")
    public String suppowerchglogSave() {
        boolean isNew = true;
        String oldValue = null;
        if (processDesc_ != null) {
            try {
                FileInputStream fis = new FileInputStream(processDesc_);
                if (fis != null) {
                    byte[] bbuf = null;
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                    object.setProcessDesc(bbuf);
                    object.setFileName(processDesc_FileName);
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 内部流程图
        if (inFlowImg_ != null) {
            try {
                FileInputStream fis = new FileInputStream(inFlowImg_);
                if (fis != null) {
                    byte[] bbuf = null;
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                    object.setInFlowImg(bbuf);
                    object.setInFlowImgName(inFlowImg_FileName);
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 申请表格
        if (applyForm_ != null) {
            try {
                FileInputStream fis = new FileInputStream(applyForm_);
                if (fis != null) {
                    byte[] bbuf = null;
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                    object.setApplyForm(bbuf);
                    object.setFormName(applyForm_FileName);
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 内部流程图
        if (srvDirectoryStuff_ != null) {
            try {
                FileInputStream fis = new FileInputStream(srvDirectoryStuff_);
                if (fis != null) {
                    byte[] bbuf = null;
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                    object.setSrvDirectoryStuff(bbuf);
                    // object.setInFlowImgName(inFlowImg_FileName);
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 申请表格
        if (applyFormDemo_ != null) {
            try {
                FileInputStream fis = new FileInputStream(applyFormDemo_);
                if (fis != null) {
                    byte[] bbuf = null;
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                    object.setApplyFormDemo(bbuf);
                    object.setApplyFormDemoName(applyFormDemo_FileName);
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String risk = null;
        try {
            risk = this.getStandXml(request);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        object.setRisk(risk);
        String processWorkDesc = this.getProcessWorkDescHtml(request);
        object.setProcessWorkDesc(processWorkDesc);

        String acceptCondition = this.getAcceptConditionHtml(request);
        object.setAcceptCondition(acceptCondition);
        try {
            BpowerItemService suppower = bpowerItemServiceManager
                    .getObjectById(object.getItemId(), getVersion_bg());
            Long version = object.getVersion();// 获取原始版本号信息
            String url = null;
            if (suppower != null) {// 编辑
                isNew = false;
                // 这里将选择的版本内容复制到要修改的0版本内容里面
                suppower.setVersion(Long.valueOf("0"));
                suppower.setQlState("N");// 修改权力事项里面，状态为N
                suppower.setLastmodifytime(new Date(System.currentTimeMillis()));// 修改时间
                // suppowerManager.saveSuppower(suppower);// 修改0版本
                BpowerItemService bean = new BpowerItemService();
                bean.setDis_detail(suppower.getDis_detail());
                bean.setDis_standard(suppower.getDis_standard());
                object.setVersion(Long.valueOf("0"));
                object.setQlState("N");// 修改在权力事项里面，状态为N
                object.setLastmodifytime(new Date(System.currentTimeMillis()));// 修改时间
                if (StringBaseOpt.isNvl(object.getDis_detail())
                        || StringBaseOpt.isNvl(object.getDis_standard())) {
                    // Suppower bean =
                    // suppowerManager.getObjectById(object.getCid());
                    if (StringBaseOpt.isNvl(object.getDis_detail())) {
                        object.setDis_detail(bean.getDis_detail());
                    }
                    if (StringBaseOpt.isNvl(object.getDis_standard())) {
                        object.setDis_standard(bean.getDis_standard());
                    }
                }
                object.setPowerOptInfos(null);
                BpowerItemService s = new BpowerItemService();
                s.copy(object);
                bpowerItemServiceManager.saveSuppower(s);// 修改0版本
                // 增加权力变更信息
                FUserDetail fUserDetail = (FUserDetail) getLoginUser();
                Suppowerchglog logBean = new Suppowerchglog();
                logBean.setRequester(fUserDetail.getUsercode());// 申请者
                logBean.setChgType("xg");// 新版未使用
                logBean.setVersion(version);// version具体版本
                logBean.setItemId(object.getItemId());// 这是通过页面上传过来的值
                logBean.setRequestTime(DatetimeOpt.currentUtilDate());// 申请时间是系统时间
                logBean.setChgReason(suppowerchglog.getChgReason());
                logBean.setChgContent(suppowerchglog.getChgContent());
                // 获取权力变更信息表里面最大变更编号
                logBean.setChangeId(suppowerchglogManager.genNextChangeId());
                suppowerchglogManager.saveSuppowerchglog(logBean);
                url = "poweritem/bpowerItemService!listSupPowerSQ.do?itemId="
                        + object.getItemId() + "&itemName="
                        + object.getItemName() + "&orgId=" + object.getOrgId()
                        + "&itemType=" + object.getItemType();
                this.AlertMessage(url);
                return null;
            } else {
                object.setLastmodifytime(new Date(System.currentTimeMillis()));
                object.setVersion(Long.valueOf("0"));// 设置默认的版本为0
                bpowerItemServiceManager.saveSuppower(object);// 新增权力事项的时候走的流程
                // 获取用户信息类
                FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                        .getContext().getAuthentication().getPrincipal();
                Suppowerchglog logBean = new Suppowerchglog();
                logBean.setRequester(fUserDetail.getUsercode());// 申请者
                logBean.setChgType("tj");// 新版未使用
                logBean.setVersion(Long.valueOf("0"));// 默认只修改0版本
                logBean.setItemId(object.getItemId());// 这是通过页面上传过来的值
                logBean.setRequestTime(DatetimeOpt.currentUtilDate());// 申请时间是系统时间
                logBean.setChgReason(suppowerchglog.getChgReason());
                logBean.setChgContent(suppowerchglog.getChgContent());
                logBean.setChangeId(suppowerchglogManager.genNextChangeId());
                suppowerchglogManager.saveSuppowerchglog(logBean);
                url = "poweritem/bpowerItemService!listSupPowerSQ.do?itemId="
                        + object.getItemId() + "&itemName="
                        + object.getItemName() + "&orgId=" + object.getOrgId()
                        + "&itemType=" + object.getItemType();
                this.AlertMessage(url);
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private String getAcceptConditionHtml(HttpServletRequest request) {
        String xml = "";
        String[] stand_id = request.getParameterValues("stand_id");
        String[] stand_code = request.getParameterValues("stand_code");

        List standardList = new ArrayList();
        if (stand_id != null && stand_id.length > 0) {
            for (int i = 0; i < stand_id.length; i++) {
                if (!StringBaseOpt.isNvl(stand_id[i])
                        || !StringBaseOpt.isNvl(stand_code[i])) {
                    SuppowerStandard standinfo = new SuppowerStandard();
                    standinfo.setStand_id(stand_id[i]);
                    standinfo.setStand_code(stand_code[i]);
                    standardList.add(standinfo);
                }
            }
        }
        if (standardList.size() > 0) {
            xml += "<table width=\"95%\" id=\"table_b1\" cellspacing=\"0\" cellpadding=\"0\">";

            for (int i = 0; i < standardList.size();) {
                SuppowerStandard standinfo = (SuppowerStandard) standardList
                        .get(i);

                xml += "<tr>";
                xml += "<td>";
                xml += standinfo.getStand_id();
                xml += "</td>";
                xml += "<td>";
                xml += standinfo.getStand_code();
                xml += "</td>";

                xml += "</tr>";
                i += 1;

            }
            xml += "</table>";

        } // 有样式(缩进)的写出
        return xml;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private String getProcessWorkDescHtml(HttpServletRequest request) {
        String xml = "";
        String[] seq_base_lowmul = request
                .getParameterValues("seq_base_lowmul");
        String[] seq_base_topmul = request
                .getParameterValues("seq_base_topmul");
        String[] lastmodyfidate = request.getParameterValues("lastmodyfidate");
        String[] seq_base_unit = request.getParameterValues("seq_base_unit");
        List standardList = new ArrayList();
        if (seq_base_lowmul != null && seq_base_lowmul.length > 0) {
            for (int i = 0; i < seq_base_lowmul.length; i++) {
                if (!StringBaseOpt.isNvl(seq_base_lowmul[i])
                        || !StringBaseOpt.isNvl(seq_base_topmul[i])
                        || !StringBaseOpt.isNvl(seq_base_unit[i])) {
                    SuppowerStandard standinfo = new SuppowerStandard();
                    standinfo.setSeq_base_lowmul(seq_base_lowmul[i]);
                    standinfo.setSeq_base_topmul(seq_base_topmul[i]);
                    standinfo.setLastmodyfidate(lastmodyfidate[i]);
                    standinfo.setSeq_base_unit(seq_base_unit[i]);
                    standardList.add(standinfo);
                }
            }
        }
        if (standardList.size() > 0) {
            xml += "<table width=\"95%\" id=\"table_b1\" cellspacing=\"0\" cellpadding=\"0\">";
            xml += "<tr class=\"b_darkblue\">";
            xml += "<td width=\"15%\">步骤</td>";
            xml += "<td width=\"30%\">申请人和部门要做的事情</td>";
            xml += "<td width=\"15%\">回应时间</td>";
            xml += "</tr>";
            for (int i = 0; i < standardList.size();) {
                SuppowerStandard standinfo = (SuppowerStandard) standardList
                        .get(i);
                if (!StringBaseOpt.isNvl(standinfo.getLastmodyfidate())
                        && !StringBaseOpt.isNvl(standinfo.getSeq_base_topmul())) {
                    xml += "<tr>";
                    xml += "<td rowspan=\"2\">";
                    xml += standinfo.getSeq_base_lowmul();
                    xml += "</td>";
                    xml += "<td>";
                    xml += standinfo.getSeq_base_topmul();
                    xml += "</td>";
                    xml += "<td>";
                    xml += "&nbsp;";
                    xml += "</td>";
                    xml += "</tr>";
                    xml += "<tr>";
                    xml += "<td>";
                    xml += standinfo.getLastmodyfidate();
                    xml += "</td>";
                    xml += "<td>";
                    xml += standinfo.getSeq_base_unit();
                    xml += "</td>";
                    xml += "</tr>";
                    i += 1;
                } else {
                    xml += "<tr>";
                    xml += "<td>";
                    xml += standinfo.getSeq_base_lowmul();
                    xml += "</td>";
                    xml += "<td>";
                    xml += standinfo.getLastmodyfidate();
                    xml += "</td>";
                    xml += "<td>";
                    xml += standinfo.getSeq_base_unit();
                    xml += "</td>";
                    xml += "</tr>";
                    i += 1;
                }
            }
            xml += "</table>";

        } // 有样式(缩进)的写出
        return xml;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private String getStandXml(HttpServletRequest request) throws IOException {
        String xml = "";
        String[] seq_id = request.getParameterValues("seq_id");
        String[] seq_type = request.getParameterValues("seq_type");
        String[] seq_base_name = request.getParameterValues("seq_base_name");
        String[] seq_remark = request.getParameterValues("seq_remark");
        List standardList = new ArrayList();
        if (seq_id != null && seq_id.length > 0) {
            for (int i = 0; i < seq_id.length; i++) {
                if (!StringBaseOpt.isNvl(seq_type[i])
                        || !StringBaseOpt.isNvl(seq_base_name[i])
                        || !StringBaseOpt.isNvl(seq_remark[i])) {
                    SuppowerStandard standinfo = new SuppowerStandard();
                    standinfo.setSeq_id(seq_id[i]);
                    standinfo.setSeq_type(seq_type[i]);
                    standinfo.setSeq_base_name(seq_base_name[i]);
                    standinfo.setSeq_remark(seq_remark[i]);
                    standardList.add(standinfo);
                }
            }
        }
        if (standardList.size() > 0) {
            DocumentFactory df = DocumentFactory.getInstance();

            Document Doc = df.createDocument("UTF-8");
            // 创建根节点
            Element root = Doc.addElement("STANDARD");
            // 创建根节点 STANDARD;

            // 添加到CONTENT节点中
            SuppowerStandard supinfo = new SuppowerStandard();
            for (int j = 0; j < standardList.size(); j++) {
                supinfo = (SuppowerStandard) standardList.get(j);
                Element elementsStandSeq = root.addElement("STAND_SEQ");
                Element seqId = elementsStandSeq.addElement("SEQ_ID");
                seqId.setText("" + supinfo.getSeq_id() + "");
                Element seqType = elementsStandSeq.addElement("SEQ_TYPE");
                seqType.setText("" + supinfo.getSeq_type() + "");
                Element seqBaseName = elementsStandSeq
                        .addElement("SEQ_BASE_NAME");
                seqBaseName.setText("" + supinfo.getSeq_base_name() + "");
                Element seqRemark = elementsStandSeq.addElement("SEQ_REMARK");
                seqRemark.setText("" + supinfo.getSeq_remark() + "");

            }
            OutputFormat opf = OutputFormat.createPrettyPrint();
            opf.setEncoding("UTF-8");
            opf.setTrimText(true);

            // 生成XML文件
            XMLWriter xmlOut = null;
            try {
                xmlOut = new XMLWriter(new FileOutputStream("city-dom4j.xml"),
                        opf);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            xmlOut.write(Doc);
            xmlOut.flush();
            xmlOut.close();

            // 获取XML字符串形式
            StringWriter writerStr = new StringWriter();
            XMLWriter xmlw = new XMLWriter(writerStr, opf);
            xmlw.write(Doc);
            xml = writerStr.getBuffer().toString();

        } // 有样式(缩进)的写出
        return xml;
    }

    public String AlertMessage(String url_temp) throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        String url = "<script>window.location.href='" + url_temp + "'</script>";
        out.print("<script>alert('保存成功！')</script>");
        out.print(url);
        out.flush();
        out.close();
        return null;
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

    @SuppressWarnings({ "unused", "unchecked", "rawtypes" })
    static public List<SuppowerStandard> genxmlStandardList(String risk) {
        boolean flag = false;
        List<SuppowerStandard> insertList = new ArrayList();
        Document doc = null;
        if (StringBaseOpt.isNvl(risk))
            return insertList;
        try {
            doc = DocumentHelper.parseText(risk); // 为Docunment对象doc加载CLOB数据
            Element root = doc.getRootElement(); // 获得XML根节点
            Iterator iter = root.elementIterator("STAND_SEQ");// 获取根节点的子节点STAND_SEQ放入迭代器中
            while (iter.hasNext()) { // 遍历STAND_SEQ
                Element recordEle = (Element) iter.next(); // 在迭代器中获取当前STAND_SEQ
                String ret[] = new String[11];// 装数据
                Map map = new HashMap();
                SuppowerStandard info = new SuppowerStandard();

                info.setSeq_id(StringBaseOpt.isNvl(recordEle
                        .elementTextTrim("SEQ_ID")) ? "" : recordEle
                        .elementTextTrim("SEQ_ID"));
                info.setSeq_type(StringBaseOpt.isNvl(recordEle
                        .elementTextTrim("SEQ_TYPE")) ? "" : recordEle
                        .elementTextTrim("SEQ_TYPE"));
                info.setSeq_base_name(StringBaseOpt.isNvl(recordEle
                        .elementTextTrim("SEQ_BASE_NAME")) ? "" : recordEle
                        .elementTextTrim("SEQ_BASE_NAME"));
                info.setSeq_remark(StringBaseOpt.isNvl(recordEle
                        .elementTextTrim("SEQ_REMARK")) ? "" : recordEle
                        .elementTextTrim("SEQ_REMARK"));
                insertList.add(info);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return insertList;
    }

    @SuppressWarnings({ "unused", "unchecked", "rawtypes" })
    static public List<SuppowerStandard> genProcessWorkDescList(
            String processWorkDesc) {
        boolean flag = false;
        List<SuppowerStandard> insertList = new ArrayList();

        if (StringBaseOpt.isNvl(processWorkDesc))
            return insertList;

        String temp = processWorkDesc.substring(
                processWorkDesc.indexOf("<tr>", 2), processWorkDesc.length());
        String[] trs = temp.split("</tr>");
        for (int i = 0; i < trs.length - 1;) {
            SuppowerStandard info = new SuppowerStandard();
            String test = trs[i];
            if (test.indexOf("rowspan=\"2\"") > 0) {
                info.setSeq_base_lowmul(test.substring(
                        test.indexOf("rowspan=\"2\"") + 12,
                        test.indexOf("</td>")));
                test = test.substring(test.indexOf("</td>") + 5, test.length());
                info.setSeq_base_topmul(test.substring(
                        test.indexOf("<td>") + 4, test.indexOf("</td>")));
                test = test.substring(test.indexOf("</td>") + 5, test.length());
                info.setSeq_base_unit(test.substring(test.indexOf("<td>") + 4,
                        test.indexOf("</td>")));
                test = trs[i + 1];
                info.setLastmodyfidate(test.substring(test.indexOf("<td>") + 4,
                        test.indexOf("</td>")));
                test = test.substring(test.indexOf("</td>") + 5, test.length());
                info.setSeq_base_unit(test.substring(test.indexOf("<td>") + 4,
                        test.indexOf("</td>")));
                i += 2;
            } else {
                info.setSeq_base_lowmul(test.substring(
                        test.indexOf("<td>") + 4, test.indexOf("</td>")));
                test = test.substring(test.indexOf("</td>") + 5, test.length());
                info.setLastmodyfidate(test.substring(test.indexOf("<td>") + 4,
                        test.indexOf("</td>")));
                test = test.substring(test.indexOf("</td>") + 5, test.length());
                info.setSeq_base_unit(test.substring(test.indexOf("<td>") + 4,
                        test.indexOf("</td>")));
                i += 1;
            }
            insertList.add(info);
        }

        return insertList;
    }
    @SuppressWarnings({ "unused", "unchecked", "rawtypes" })
    static public List<SuppowerStandard> genAcceptConditionList(
            String processWorkDesc) {
        boolean flag = false;
        List<SuppowerStandard> insertList = new ArrayList();

        if (StringBaseOpt.isNvl(processWorkDesc))
            return insertList;

        String temp = processWorkDesc.substring(
                processWorkDesc.indexOf("<tr>", 2), processWorkDesc.length());
        String[] trs = temp.split("</tr>");
        for (int i = 0; i < trs.length - 1;) {
            SuppowerStandard info = new SuppowerStandard();
            String test = trs[i];

            info.setStand_id(test.substring(test.indexOf("<td>") + 4,
                    test.indexOf("</td>")));
            test = test.substring(test.indexOf("</td>") + 5, test.length());
            info.setStand_code(test.substring(test.indexOf("<td>") + 4,
                    test.indexOf("</td>")));

            i += 1;

            insertList.add(info);
        }

        return insertList;
    }

    @SuppressWarnings("rawtypes")
    public String viewzycl() {
        BpowerItemService bean = bpowerItemServiceManager.getObjectById(object
                .getCid());
        String xml = null;
        if (bean != null) {
            xml = bean.getDis_detail();
        }
        List list = bpowerItemServiceManager.getzycvie("punishType");// 自由裁量处罚种类
        List seqtypelist = bpowerItemServiceManager.getzycvie("seq_type");// 裁量基准
        List seqBaseUnitList = bpowerItemServiceManager
                .getseqlowlimitunit("seqBaseUnit");// 裁量基准
        List list1 = bpowerItemServiceManager.xmlDISCRETIONList(xml, "", "");
        List list2 = bpowerItemServiceManager.xmlStandardList(xml, "", "");
        request.setAttribute("list1", list1);
        request.setAttribute("list2", list2);
        request.setAttribute("list", list);
        request.setAttribute("seqtypelist", seqtypelist);
        request.setAttribute("seqBaseUnitList", seqBaseUnitList);
        return "viewzycl";
    }

    @SuppressWarnings("rawtypes")
    public String viewcfcx() {
        BpowerItemService bean = bpowerItemServiceManager.getObjectById(object
                .getCid());

        String xml = null;
        if (bean != null) {
            xml = bean.getDis_standard();
        }
        List list = bpowerItemServiceManager.getzycvie("punishType");// 自由裁量处罚种类
        List seqtypelist = bpowerItemServiceManager.getzycvie("seq_type");// 裁量基准
        List seqBaseUnitList = bpowerItemServiceManager
                .getseqlowlimitunit("seqBaseUnit");// 裁量基准
        List list2 = bpowerItemServiceManager.genxmlStandardList(xml, "", "");
        request.setAttribute("list2", list2);
        request.setAttribute("list", list);
        request.setAttribute("seqtypelist", seqtypelist);
        request.setAttribute("seqBaseUnitList", seqBaseUnitList);

        return "viewcfcx";
    }

    @SuppressWarnings("rawtypes")
    public String editzycl() {
        String xml = object.getDis_detail();
        BpowerItemService bean = bpowerItemServiceManager.getObjectById(object
                .getCid());
        if (bean != null) {
            if (StringBaseOpt.isNvl(xml)) {
                xml = bean.getDis_detail();
            }
        }
        List seqBaseUnitList = bpowerItemServiceManager
                .getseqlowlimitunit("seqBaseUnit");// 裁量基准
        List list1 = bpowerItemServiceManager.xmlDISCRETIONList(xml, "", "");
        List list2 = bpowerItemServiceManager.xmlStandardList(xml, "", "");
        if (list1.size() > 0) {
            request.setAttribute("flagcyz", "1");
        } else {
            request.setAttribute("flagcyz", "2");
        }
        if (list2.size() > 0) {
            request.setAttribute("flagcyzdis", "1");
        } else {
            request.setAttribute("flagcyzdis", "2");
        }
        request.setAttribute("list1", list1);
        request.setAttribute("list2", list2);
        request.setAttribute("seqBaseUnitList", seqBaseUnitList);

        return "editzycl";
    }

    @SuppressWarnings("rawtypes")
    public String editcfcx() {
        String xml = object.getDis_standard();
        BpowerItemService bean = bpowerItemServiceManager.getObjectById(object
                .getCid());
        if (bean != null) {
            if (StringBaseOpt.isNvl(xml)) {
                xml = bean.getDis_standard();
            }
        }
        List list = bpowerItemServiceManager.getzycvie("punishType");// 自由裁量处罚种类
        List seqtypelist = bpowerItemServiceManager.getzycvie("seq_type");// 裁量基准
        List seqBaseUnitList = bpowerItemServiceManager
                .getseqlowlimitunit("seqBaseUnit");// 裁量基准
        List list2 = bpowerItemServiceManager.genxmlStandardList(xml, "", "");
        if (list2.size() > 0) {
            request.setAttribute("flagcyzdis", "1");
        } else {
            request.setAttribute("flagcyzdis", "2");
        }
        request.setAttribute("list2", list2);
        request.setAttribute("list", list);
        request.setAttribute("seqtypelist", seqtypelist);
        request.setAttribute("seqBaseUnitList", seqBaseUnitList);

        return "editcfcx";
    }

    private VpowerItemServiceChange suppowerqlbgsq;

    public VpowerItemServiceChange getSuppowerqlbgsq() {
        return suppowerqlbgsq;
    }

    public void setSuppowerqlbgsq(VpowerItemServiceChange suppowerqlbgsq) {
        this.suppowerqlbgsq = suppowerqlbgsq;
    }

    /*
     * 权力变更审核获取具体权力事项信息
     */
    public String suppowerQlbgShEdit() {

        suppowerqlbgsq = bpowerItemServiceManager
                .getVpowerItemServiceChangeInfo(object.getItemId(),
                        object.getVersion());
        suppowerqlbgsq.setBegTime(DatetimeOpt.currentUtilDate());
        suppowerqlbgsq.setChgResult("1");// 默认值设置为1
        return "suppowerQlbgShEdit";
    }

    private Date parseString2Date(String timeString, String pattern) {
        System.out.println(timeString);
        System.out.println(pattern);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date(System.currentTimeMillis());
        if (timeString != null && "".equals(timeString)) {
            if (timeString.length() > pattern.length()) {
                timeString = timeString.substring(0, pattern.length());
            }
        }
        try {
            date = sdf.parse(timeString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    private void request2Suppowerchglog() {
        suppowerchglog = new Suppowerchglog();
        suppowerqlbgsq = bpowerItemServiceManager
                .getVpowerItemServiceChangeInfo(object.getItemId(),
                        object.getVersion());
        suppowerchglog.setChangeId(request.getParameter("changeId"));
        suppowerchglog.setVersion(Long.parseLong(request
                .getParameter("version")));
        suppowerchglog.setItemId(request.getParameter("itemId"));
        suppowerchglog.setChgType(request.getParameter("chgType"));
        suppowerchglog.setRequestTime(suppowerqlbgsq.getRequestTime());
        suppowerchglog.setChgReason(request.getParameter("chgReason"));
        suppowerchglog.setChgResult(request.getParameter("chgResult"));
        suppowerchglog.setChgContent(request.getParameter("chgContent"));
        suppowerchglog.setRequester(request.getParameter("requester"));
        suppowerchglog.setAuditContent(request.getParameter("auditContent"));
    }

    // 审核同意的后续操作
    public String SuppowerReplySaveTY() {
        BpowerItemService suppower = new BpowerItemService();
        System.out.println("审核同意");
        Long version = object.getVersion();
        try {
            Long versionTemp = Long.valueOf("0");
            suppower = bpowerItemServiceManager.getObjectById(
                    object.getItemId(), versionTemp);// 获取版本号为0的该权力事项
            BpowerItemService suppower_temp = new BpowerItemService();
            BpowerItemService suppower_old = new BpowerItemService();
            suppower_temp.copyNotNullProperty(suppower);// 获取版本号为0的该权力事项
            if (0 != version) {// 非新增的修改
                suppower_old = bpowerItemServiceManager.getObjectById(
                        object.getItemId(), version);// 获取版本号为0的该权力事项
                // suppower.setEndTime(DatetimeOpt.currentUtilDate());//
                // 设置结束时间为系统时间
                if ("N".equals(suppower.getQlState())) {
                    suppower_temp.setVersion(version + 1);// 新版本号
                    suppower_temp.setBeginTime(parseString2Date(
                            (String) request.getParameter("begTime"),
                            "yyyy-MM-dd HH:mm:ss"));// 设置启用时间为系统时间
                    suppower_temp.setQlState("A");// 新版本为在用A
                    suppower_old.setEndTime(DatetimeOpt.currentUtilDate());// 设置结束时间为系统时间
                    suppower_old.setQlState("U");// 已经经过一次升级,以前的版本

                } else if ("A".equals(suppower.getQlState())) {// 启用该权力事项
                    suppower_temp.setVersion(version + 1);// 新版本号
                    suppower_temp.setQlState("A");// 新版本为在用A
                    suppower_old.setBeginTime(parseString2Date(
                            (String) request.getParameter("begTime"),
                            "yyyy-MM-dd HH:mm:ss"));// 设置启用时间为选择的生效时间
                    suppower_temp.setBeginTime(parseString2Date(
                            (String) request.getParameter("begTime"),
                            "yyyy-MM-dd HH:mm:ss"));// 设置启用时间为系统时间
                    suppower_old.setEndTime(DatetimeOpt.currentUtilDate());// 设置结束时间为系统时间
                } else {// 废止或者挂起
                    suppower_old.setQlState(suppower_temp.getQlState());
                    suppower_old.setEndTime(parseString2Date(
                            (String) request.getParameter("begTime"),
                            "yyyy-MM-dd HH:mm:ss"));// 设置结束时间为系统时间
                    suppower_temp.setVersion(version + 1);// 新版本号
                    suppower_temp.setEndTime(parseString2Date(
                            (String) request.getParameter("begTime"),
                            "yyyy-MM-dd HH:mm:ss"));// 设置结束时间为系统时间
                }
                suppower_temp.setPowerOptInfos(null);
                suppower_old.setPowerOptInfos(null);
                BpowerItemService s = new BpowerItemService();
                s.copy(suppower_temp);
                BpowerItemService s1 = new BpowerItemService();
                s1.copy(suppower_old);

                bpowerItemServiceManager.saveSuppower(suppower_old, s);
                // suppowerManager.saveSuppower(suppower_old, suppower_temp);
            } else {
                suppower.setVersion(version);// 原来的版本号
                suppower.setBeginTime(parseString2Date(
                        (String) request.getParameter("begTime"),
                        "yyyy-MM-dd HH:mm:ss"));// 设置启用时间为审核填写的生效时间
                suppower_temp.setVersion(version + 1);// 新版本号
                if ("T".equals(suppower.getQlState())
                        || "X".equals(suppower.getQlState())) {
                    suppower.setEndTime(DatetimeOpt.currentUtilDate());
                }
                suppower_temp.setBeginTime(parseString2Date(
                        (String) request.getParameter("begTime"),
                        "yyyy-MM-dd HH:mm:ss"));// 设置启用时间为系统时间
                suppower_temp.setPowerOptInfos(null);
                suppower.setPowerOptInfos(null);
                BpowerItemService s = new BpowerItemService();
                s.copy(suppower_temp);
                BpowerItemService s1 = new BpowerItemService();
                s1.copy(suppower);
                bpowerItemServiceManager.saveSuppower(suppower, s);
            }
            FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                    .getContext().getAuthentication().getPrincipal();
            // request2Suppowerchglog();
            suppowerchglog.setReplyPeople(fUserDetail.getUsercode());// 回复者就是审核者本人
            suppowerchglog.setReplyTime(DatetimeOpt.currentUtilDate());// 回复时间
            suppowerchglog.setReplyContent("审核即结束流程");
            suppowerchglogManager.saveObject(suppowerchglog);
            return "successReply";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }

    }

    // 审核不同意的后续操作
    public String SuppowerReplySaveBTY() {
        BpowerItemService suppower = new BpowerItemService();
        Long version = object.getVersion();
        System.out.println("审核不同意");
        try {
            if (0 != version) {// 非新增的
                suppower = bpowerItemServiceManager.getObjectById(
                        object.getItemId(), version);// 获取该权力事项
                suppower.setVersion(Long.valueOf("0"));// 新版本号
                bpowerItemServiceManager.saveObject(suppower);
            } else {
                // 新增的如果同意就不做修改
            }
            FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                    .getContext().getAuthentication().getPrincipal();
            // request2Suppowerchglog();
            suppowerchglog.setReplyPeople(fUserDetail.getUsercode());// 回复者就是审核者本人
            suppowerchglog.setReplyTime(DatetimeOpt.currentUtilDate());// 回复时间
            suppowerchglog.setReplyContent("审核即结束流程");
            suppowerchglogManager.saveObject(suppowerchglog);
            return "successReply";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }

    }

    /**
     * 保存审核之后的信息
     * 
     * @return
     */
    public String SuppowerSHSave() {
        request2Suppowerchglog();
        if ("1".equals(suppowerchglog.getChgResult())) {// 申请同意修改
            try {
                FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                        .getContext().getAuthentication().getPrincipal();
                suppowerchglog.setChgResult(suppowerchglog.getChgResult());// 申请结果
                suppowerchglog.setAuditor(fUserDetail.getUsercode());// 审核者
                suppowerchglog.setAuditTime(DatetimeOpt.currentUtilDate());// 审核时间
                suppowerchglogManager.saveObject(suppowerchglog);

                SuppowerReplySaveTY();

                return listSupPowerSH();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                saveError(e.getMessage());
                return ERROR;
            }
        } else {
            if (0 != suppowerchglog.getVersion()) {
                BpowerItemService suppower = bpowerItemServiceManager
                        .getObjectById(object.getItemId(), object.getVersion());
                ;
                suppower.setVersion(Long.valueOf("0"));
                bpowerItemServiceManager.saveObject(suppower);// 修改版本重新返回到0版本上去
                FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                        .getContext().getAuthentication().getPrincipal();
                suppowerchglog.setChgResult(suppowerchglog.getChgResult());// 申请结果
                suppowerchglog.setAuditor(fUserDetail.getUsercode());// 审核者、
                suppowerchglog.setAuditTime(DatetimeOpt.currentUtilDate());// 审核时间
                suppowerchglogManager.saveObject(suppowerchglog);

            } else {
                FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                        .getContext().getAuthentication().getPrincipal();
                suppowerchglog.setAuditor(fUserDetail.getUsercode());// 审核者、
                suppowerchglog.setAuditTime(DatetimeOpt.currentUtilDate());// 审核时间
                suppowerchglogManager.saveObject(suppowerchglog);

            }

            SuppowerReplySaveBTY();

            return listSupPowerSH();
        }
    }

    @SuppressWarnings("unchecked")
    public String listVersion() {
        String itemid = (String) request.getAttribute("itemId");
        Long version = (Long) request.getAttribute("version");
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put("itemId", itemid);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        versionList = suppowerchglogManager.getlistVersionByItemid(filterMap,
                pageDesc);// 当权力项有多个版本时，列表显示版本号最大的一条
        bpowerItemServicelist = bpowerItemServiceManager.getlistSuppowerOld(
                itemid, version);
        totalRows = pageDesc.getTotalRows();
        object = bpowerItemServiceManager.getObjectById(itemid, version);

        List<SuppowerStandard> list2 = SupPowerAction.genxmlStandardList(object
                .getRisk());
        request.setAttribute("list2", list2);
        List<SuppowerStandard> list1 = SupPowerAction
                .genProcessWorkDescList(object.getProcessWorkDesc());
        request.setAttribute("list1", list1);
        List<SuppowerStandard> list3 = SupPowerAction
                .genAcceptConditionList(object.getAcceptCondition());
        request.setAttribute("list3", list3);
        request.setAttribute("sup", object);
        request.setAttribute("suppowerList", bpowerItemServicelist);
        return "listNVersion";

    }

    @SuppressWarnings("unused")
    public String SuppowerQlbgSqXg() {
        Long version = object.getVersion();
        if (version_bg != null) {
            object.setVersion(version_bg);
            setVersion_bg(version_bg);
        }
        this.edit();
        bpowerItemServicelist = bpowerItemServiceManager.getlistSuppowerOld(
                object.getItemId(), object.getVersion());
        return "SuppowerQlbgSqNXg";

    }

    /**
     * 权力变更使用的(挂起和废止)
     * 
     * @return
     */
    public String updateQlbgState() {
        try {
            // 下面这个是获取用户信息类
            FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                    .getContext().getAuthentication().getPrincipal();
            BpowerItemService suppower = bpowerItemServiceManager
                    .getObjectById(object.getItemId(), Long.valueOf("0"));// 获取0版本的
            Suppowerchglog logBean = new Suppowerchglog();
            logBean.setRequester(fUserDetail.getUsercode());// 申请者

            logBean.setVersion(object.getVersion());// 默认只修改0版本
            logBean.setItemId(object.getItemId());// 这是通过页面上传过来的值
            logBean.setRequestTime(DatetimeOpt.currentUtilDate());// 申请时间是系统时间
            if ("T".equals(object.getQlState())) {
                logBean.setChgType("gq");// 这是通过页面上传过来的值
                logBean.setChgReason("申请挂起权力");
                logBean.setChgContent("申请挂起权力");
            }
            if ("X".equals(object.getQlState())) {
                logBean.setChgType("fz");// 这是通过页面上传过来的值
                logBean.setChgReason("申请废止权力");
                logBean.setChgContent("申请废止权力");
            }
            if (suppower == null) {
                suppower = new BpowerItemService();
                suppower.copy(bpowerItemServiceManager.getObjectById(
                        object.getItemId(), object.getVersion()));
                suppower.setVersion(Long.valueOf("0"));
            }
            // 变更版本号不用修改
            suppower.setQlState(object.getQlState());
            bpowerItemServiceManager.saveObject(suppower);
            logBean.setChangeId(suppowerchglogManager.genNextChangeId());
            suppowerchglogManager.saveSuppowerchglog(logBean);
            return this.listSupPowerSQ();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            this.saveError(e.getMessage());
            return this.listSupPowerSQ();
        }
    }

    /**
     * 权力变更(启用)
     * 
     * @return
     */
    public String upDateQlbgQyState() {
        try {
            // 下面这个是获取用户信息类
            FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                    .getContext().getAuthentication().getPrincipal();
            BpowerItemService suppower = bpowerItemServiceManager
                    .getObjectById(object.getItemId(), Long.valueOf("0"));// 获取0版本的
            Suppowerchglog logBean = new Suppowerchglog();
            logBean.setRequester(fUserDetail.getUsercode());// 申请者
            logBean.setVersion(object.getVersion());// 默认只修改0版本
            logBean.setItemId(object.getItemId());// 这是通过页面上传过来的值
            logBean.setRequestTime(DatetimeOpt.currentUtilDate());// 申请时间是系统时间
            logBean.setChgType("qy");// 这是通过页面上传过来的值
            logBean.setChgReason("申请启用权力");
            logBean.setChgContent("申请启用权力");
            // 变更版本号不用修改
            suppower.setQlState(object.getQlState());
            bpowerItemServiceManager.saveObject(suppower);
            logBean.setChangeId(suppowerchglogManager.genNextChangeId());
            suppowerchglogManager.saveSuppowerchglog(logBean);
            return this.listSupPowerSQ();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            this.saveError(e.getMessage());
            return this.listSupPowerSQ();
        }
    }

}
