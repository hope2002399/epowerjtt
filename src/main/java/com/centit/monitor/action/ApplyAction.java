package com.centit.monitor.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.extremecomponents.table.limit.Limit;

import com.centit.complaint.service.ComplaintManager;
import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.po.DispatchDoc;
import com.centit.dispatchdoc.po.IncomeDoc;
import com.centit.dispatchdoc.service.DispatchDocManager;
import com.centit.dispatchdoc.service.IncomeDocManager;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.ApplyDoc;
import com.centit.monitor.po.ApplyProcess;
import com.centit.monitor.po.ApplyResult;
import com.centit.monitor.po.FormInfo;
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VApplyForList;
import com.centit.monitor.service.ApplyDocManager;
import com.centit.monitor.service.ApplyLogManager;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.ApplyProcessManager;
import com.centit.monitor.service.ApplyResultLogManager;
import com.centit.monitor.service.ApplyResultManager;
import com.centit.monitor.service.OutwayManager;
import com.centit.powerbase.po.Suppower;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.powerbase.util.IMonitorOptLog;
import com.centit.powerbase.util.MonitorOptLogFactoryImpl;
import com.centit.powerruntime.po.DeptYwInf;
import com.centit.powerruntime.service.DeptYwInfManager;
import com.centit.supervise.service.SuperviseBasicManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.centit.sys.util.InFlowInfo;
import com.centit.sys.util.JDomeGetItem;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-5-28
 * @version
 */
public class ApplyAction extends BaseEntityExtremeAction<Apply> {
    private static final Log log = LogFactory.getLog(ApplyAction.class);
    private static final IMonitorOptLog monitorOptLog = MonitorOptLogFactoryImpl
            .getMonitorOptLog("QLJK");
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private SuppowerManager suppowerManager;
    private ApplyProcessManager applyProcessManager;
    private ApplyDocManager applyDocManager;
    private ApplyResultManager applyResultManager;
    private ApplyLogManager applyLogManager;
    private ApplyResultLogManager applyResultLogManager;
    private OutwayManager outwayManager;
    private ComplaintManager complaintManager;
    private SuperviseBasicManager superviseBasicManager;
    private IncomeDocManager incomeDocManager;
    private DispatchDocManager dispatchDocManager;
    private DeptYwInfManager deptYwInfManager;
    private Suppower suppower;

    
    public void setDeptYwInfManager(DeptYwInfManager deptYwInfManager) {
        this.deptYwInfManager = deptYwInfManager;
    }

    public void setIncomeDocManager(IncomeDocManager incomeDocManager) {
        this.incomeDocManager = incomeDocManager;
    }

    public void setDispatchDocManager(DispatchDocManager dispatchDocManager) {
        this.dispatchDocManager = dispatchDocManager;
    }

    public void setSuperviseBasicManager(
            SuperviseBasicManager superviseBasicManager) {
        this.superviseBasicManager = superviseBasicManager;
    }

    public void setComplaintManager(ComplaintManager complaintManager) {
        this.complaintManager = complaintManager;
    }

    public void setOutwayManager(OutwayManager outwayManager) {
        this.outwayManager = outwayManager;
    }

    private String unitsJson;
    private String parentunit;

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

    public void setApplyResultLogManager(
            ApplyResultLogManager applyResultLogManager) {
        this.applyResultLogManager = applyResultLogManager;
    }

    public void setApplyLogManager(ApplyLogManager applyLogManager) {
        this.applyLogManager = applyLogManager;
    }

    public void setApplyResultManager(ApplyResultManager applyResultManager) {
        this.applyResultManager = applyResultManager;
    }

    public void setApplyDocManager(ApplyDocManager applyDocManager) {
        this.applyDocManager = applyDocManager;
    }

    public void setApplyProcessManager(ApplyProcessManager applyProcessManager) {
        this.applyProcessManager = applyProcessManager;
    }

    public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }

    private List<FUnitinfo> unitList;
    private List<Suppower> itemList;
    private List<VApply> applyList;

    public List<VApply> getApplyList() {
        return applyList;
    }

    public void setApplyList(List<VApply> applyList) {
        this.applyList = applyList;
    }

    private String item_type;

    // private static final ISysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog("optid");

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public List<Suppower> getItemList() {
        return itemList;
    }

    public void setItemList(List<Suppower> itemList) {
        this.itemList = itemList;
    }

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

    private static final long serialVersionUID = 1L;
    private ApplyManager applyManager;

    public void setApplyManager(ApplyManager basemgr) {
        applyManager = basemgr;
        this.setBaseEntityManager(applyManager);
    }

    @SuppressWarnings("unchecked")
    public String list() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        filterMap.put("item_type", item_type);
        String unitCode = (String) filterMap.get("orgId");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(unitCode) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("orgId", null);
        }
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        itemList = suppowerManager.getlistSuppower(item_type);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        applyList = applyManager.listVApply(filterMap, pageDesc);// 当权力项有多个版本时，列表显示版本号最大的一条
        totalRows = pageDesc.getTotalRows();
        monitorOptLog.log(((FUserinfo) this.getLoginUser()).getUsercode(), "",
                "办件列表查看", "", "9");
        return LIST;
    }

    private String url;

    
    /**
     * 办件过程监控/办件结果监控
     * @return
     */
    @SuppressWarnings("unchecked")
    public String fgList() {
        Map<Object, Object> paramMap = request.getParameterMap();

        resetPageParam(paramMap);
        // log.error("规则化前参数表：" + paramMap.toString());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isvalid", "T");

        Map<String, Object> filterMap = convertSearchColumn(paramMap);

        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        String sOrgId = (String) filterMap.get("orgId");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(sOrgId)
                && (s_queryUnderUnit == null || s_queryUnderUnit.equals(""))) {
            filterMap.put("unitcode", sysUnitManager.getUnitCode(sOrgId));
            filterMap.put("orgId", null);
        } else if (!StringBaseOpt.isNvl(sOrgId)
                && "true".equals(s_queryUnderUnit)) {
            System.out.println(sysUnitManager.getUnitCode(sOrgId));
            filterMap.put("topunitcode", sysUnitManager.getUnitCode(sOrgId));
            filterMap.put("orgId", null);
        }

        filterMap.put("item_type", item_type);
        String unitCode = (String) filterMap.get("orgId");
        String maxstatus = (String) filterMap.get("maxstatus");
        String begTime = (String) filterMap.get("begTime");
        String endTime = (String) filterMap.get("endTime");

        String NP_result = (String) filterMap.get("NP_result");
        String NP_process = (String) filterMap.get("NP_process");

        String begFinishTime1 = (String) filterMap.get("begFinishTime");
        if ((begFinishTime1 == null || begFinishTime1.equals(""))
                && (NP_result != null && !NP_result.equals("") && !NP_result
                        .equals("null"))) {
            Date date = new Date();// 当前日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化对象
            Calendar calendar = Calendar.getInstance();// 日历对象
            calendar.setTime(date);// 设置当前日期
            calendar.add(Calendar.MONTH, -1);// 月份减一
            begFinishTime1 = sdf.format(calendar.getTime());
            filterMap.put("begFinishTime", begFinishTime1);
            request.setAttribute("s_begFinishTime", begFinishTime1);
        }
        /*if ((begTime == null || begTime.equals(""))
                && (NP_result == null || NP_result.equals("") || NP_result
                        .equals("null"))) {
            Date date = new Date();// 当前日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化对象
            Calendar calendar = Calendar.getInstance();// 日历对象
            calendar.setTime(date);// 设置当前日期
            calendar.add(Calendar.MONTH, -1);// 月份减一
            begTime = sdf.format(calendar.getTime());
            filterMap.put("begTime", begTime);
            request.setAttribute("s_begTime", begTime);
        }*/
        if (begTime != null && begTime.length() == 10) {
            begTime = begTime + " 00:00:00";
            filterMap.put("begTime", begTime);
        }
        if (endTime != null && endTime.length() == 10) {
            endTime = endTime + " 23:59:59";
            filterMap.put("endTime", endTime);
        }

        String type = (String) filterMap.get("type");
        if (!StringBaseOpt.isNvl(item_type) && item_type.equals("CF")) {
            url = "/monitor/punish!list.do?type=" + type + "&s_NP_result="
                    + NP_result + "&s_NP_process=" + NP_process + "&s_orgId="
                    + unitCode + "&s_begTime=" + begTime + "&s_endTime="
                    + endTime + "&title=" + request.getParameter("title");
            return "punish";
        }
        if ("null".equals(maxstatus)) {
            filterMap.put("maxstatus", null);
        }
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        if (null != filterMap.get("begFinishTime")) {
            String begFinishTime = (String) filterMap.get("begFinishTime");
            if (begFinishTime.length() == 10) {
                begFinishTime = begFinishTime + " 00:00:00";
                filterMap.put("begFinishTime", begFinishTime);
            }
        }
        if (null != filterMap.get("endFinishTime")) {
            String endFinishTime = (String) filterMap.get("endFinishTime");
            if (endFinishTime.length() == 10) {
                endFinishTime = endFinishTime + " 23:59:59";
                filterMap.put("endFinishTime", endFinishTime);
            }
        }
        List<VApplyForList> applys = applyManager.listVApplyForList(filterMap,
                pageDesc);// 当权力项有多个版本时，列表显示版本号最大的一条
        totalRows = pageDesc.getTotalRows();
        monitorOptLog.log(((FUserinfo) this.getLoginUser()).getUsercode(), "",
                "办件列表查看", "", "9");

        request.setAttribute("opt", request.getParameter("opt"));
        request.setAttribute("applys", applys);
        return "fgList";
    }

    @SuppressWarnings("unchecked")
    public String listResult() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        filterMap.put("item_type", item_type);
        // filterMap.put("type", "null");
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        itemList = suppowerManager.getlistSuppower(item_type);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        // 当权力项有多个版本时，列表显示版本号最大的一条
        totalRows = pageDesc.getTotalRows();
        return "result";
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public String view() {
        try {
            if (object == null) {
                return LIST;
            }
            String internalNo = object.getInternalNo();
            String itemId = object.getItemId();
            Apply apply = new Apply();
            if (StringUtils.isNotBlank(object.getNo())) {// 兼容使用主键查询方式 add By HX
                apply = applyManager.getObjectById(object.getNo());
                internalNo = apply.getInternalNo();
                itemId = apply.getItemId();
            } else {
                apply = applyManager.getApplyInfo(internalNo, itemId);
            }

            // if (o != null)
            // applyManager.copyObject(object, o);
            FUserDetail user = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(user
                    .getUsercode());
            String sParentUnit = dept.getUnitcode();
            request.setAttribute("apply", apply);
            List<ApplyProcess> processList = applyProcessManager.listObjects(
                    internalNo, itemId);
            request.setAttribute("processList", processList);
            List<ApplyDoc> docList = applyDocManager.getProcessApplyDoc(
                    internalNo, itemId, null, false);
            request.setAttribute("docList", docList);
            ApplyResult result = applyResultManager.getApplyResult(internalNo,
                    itemId);
            request.setAttribute("result", result);
            List applyVersionList = applyLogManager.getVersionList(internalNo,
                    itemId);
            request.setAttribute("applyVersionList", applyVersionList);
            List applyResultVersionList = applyResultLogManager.getVersionList(
                    internalNo, itemId);
            request.setAttribute("applyResultVersionList",
                    applyResultVersionList);
            Map<String, Object> outwayMap = new HashMap();
            outwayMap.put("bjType", "1");
            outwayMap.put("internalNo", internalNo);
            outwayMap.put("topunitcode", sParentUnit);
            List outwayList = outwayManager.getOutWayList(outwayMap);
            request.setAttribute("outwayList", outwayList);

            Map<String, Object> complaintMap = new HashMap();
            complaintMap.put("bjType", "1");
            complaintMap.put("internalNo", internalNo);
            complaintMap.put("itemId", itemId);
            // complaintMap.put("topunitcode", sParentUnit);
            List complaintList = complaintManager.listObjects(complaintMap);
            request.setAttribute("complaintList", complaintList);
            Map<String, Object> superviseMap = new HashMap();
            superviseMap.put("bjType", "1");
            superviseMap.put("bjNo", apply.getNo());
            List superviseList = superviseBasicManager
                    .listObjects(superviseMap);
            request.setAttribute("superviseList", superviseList);
            IncomeDoc incomeDoc = incomeDocManager.getIncomeDoc(internalNo,
                    itemId);
            DispatchDoc dispatchDoc = dispatchDocManager.getDispatchDoc(
                    internalNo, itemId);
            request.setAttribute("incomeDoc", incomeDoc);
            request.setAttribute("dispatchDoc", dispatchDoc);
            monitorOptLog.log(((FUserinfo) this.getLoginUser()).getUsercode(),
                    "办件内部编号：" + apply.getInternalNo(),
                    "办件详细信息查看:部门内部编码：" + apply.getInternalNo() + ",申请者："
                            + apply.getApplicantName(), "", "9");
            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public String applyView() {
        try {
            String internalNo = object.getInternalNo();
            String itemId = object.getItemId();
            Apply apply = applyManager.getApplyInfo(internalNo, itemId);
            List applyList = applyManager.getApplyReg(internalNo);
            if(applyList.size() == 1){
                Object[] applys = (Object[]) applyList.get(0);
                apply.setParentName(applys[5]!=null?applys[5].toString():"");
                apply.setItemParName(applys[4].toString());
            }
            if (null != apply) {
                String itemtype = apply.getItemId();
                if(itemtype.indexOf("-") != -1){
                    int first = itemtype.indexOf("-");
                    int last = itemtype.lastIndexOf("-");
                    apply.setItemType(itemtype.substring(first + 1, last)); 
                }
            }
            Map<String, Object> docMap = new HashMap();
            docMap.put("docType", "1");
            docMap.put("internalNo", apply.getInternalNo());
            docMap.put("itemId", apply.getItemId());
            List docList = applyDocManager.listObjects(docMap);
            apply.setDocList(docList);
            if (object == null) {
                return LIST;
            }
            // if (o != null)
            // applyManager.copyObject(object, o);
            List<InFlowInfo> listStuff = JDomeGetItem.JDomeGetDocument(apply
                    .getStuff());
            request.setAttribute("listStuff", listStuff);
            if(apply.getItemId().length() > 33){
                Map<String, Object> filterMap = new HashMap<String, Object>();
                filterMap.put("deptYwRegNo", apply.getItemId());
                List<DeptYwInf> deptYwInfs = deptYwInfManager.listObjects(filterMap);
                if(deptYwInfs.size() > 0){
                    String itemName = deptYwInfs.get(0).getYwName();
                    request.setAttribute("itemName", itemName);
                }
                request.setAttribute("itemType", apply.getItemId().subSequence(22, 24));
            }
            request.setAttribute("apply", apply);
            return "applyView";
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    @SuppressWarnings("rawtypes")
    public String formView() {
        try {
            String internalNo = object.getInternalNo();
            String itemId = object.getItemId();
            Apply apply = applyManager.getApplyInfo(internalNo, itemId);
            String form = apply.getForm();

            if (object == null) {

                return LIST;
            }
            List formList = new ArrayList();
            if (!StringBaseOpt.isNvl(form)) {
                formList = this.getFormList(form);
            }
            // if (o != null)
            // applyManager.copyObject(object, o);
            request.setAttribute("formList", formList);

            return "formView";
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List getFormList(String form) {
        List insertList = new ArrayList();
        Document doc = null;
        if (form == null || form.equals(""))
            return insertList;
        try {
            doc = DocumentHelper.parseText(form); // 为Docunment对象doc加载CLOB数据
            // doc.setXMLEncoding("GBK");
            Element root = doc.getRootElement(); // 获得XML根节点
            Iterator iter = root.elementIterator("DATA");// 获取根节点的子节点STAND_SEQ放入迭代器中
            while (iter.hasNext()) { // 遍历STAND_SEQ

                Element infoEle = (Element) iter.next(); // 在迭代器中获取当前STAND_SEQ

                FormInfo info = new FormInfo();

                info.setKey(infoEle.elementTextTrim("KEY"));

                info.setName(infoEle.elementTextTrim("NAME"));
                info.setValue(infoEle.elementTextTrim("VALUE"));

                insertList.add(info);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return insertList;
    }

    public String delete() {
        super.delete();

        return "delete";
    }

    public Suppower getSuppower() {
        return suppower;
    }

    public void setSuppower(Suppower suppower) {
        this.suppower = suppower;
    }

    public String flowchart() {
        String item_id = (String) request.getParameter("item_id");
        String internal_no = (String) request.getParameter("internal_no");
        String org_id = (String) request.getParameter("org_id");

        request.setAttribute("item_id", item_id);
        request.setAttribute("internal_no", internal_no);
        request.setAttribute("org_id", org_id);

        Apply apply = applyManager.getApplyInfo(internal_no, item_id);
        request.setAttribute("apply", apply);
        Date applyDate = apply.getApplyDate();
        setSuppower(suppowerManager.getSuppowerLastVersion(item_id, applyDate));

        request.setAttribute("sup", suppower);
        request.setAttribute("systemType", "apply");

        return "flowChart";
    }

    public String flowChart_L() {
        String item_id = (String) request.getParameter("item_id");
        String internal_no = (String) request.getParameter("internal_no");
        @SuppressWarnings("unused")
        String org_id = (String) request.getParameter("org_id");
        Apply apply = applyManager.getApplyInfo(internal_no, item_id);
        request.setAttribute("apply", apply);
        Suppower power = suppowerManager.getSuppowerLastVersion(item_id,
                apply.getApplyDate());
        String inFlowInfo = "";
        if (power != null) {
            inFlowInfo = power.getInFlowInfo();
        }
        List<ApplyProcess> processList = applyProcessManager
                .listApplyProcessEx(internal_no, item_id, inFlowInfo);
        request.setAttribute("processList", processList);

        ApplyResult result = applyResultManager.getApplyResult(internal_no,
                item_id);
        request.setAttribute("result", result);

        return "flowChart_L";
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public String compare() {
        String itemId = object.getItemId();
        String[] itemIds = itemId.split(",");
        @SuppressWarnings("rawtypes")
        List applyList = new ArrayList();
        Object[][] temp = new Object[36][itemIds.length + 1];
        for (int i = 0; i < itemIds.length; i++) {
            String internalNo = itemIds[i].split(";")[0];
            String item_id = itemIds[i].split(";")[1];
            Apply apply = applyManager.getApplyInfo(internalNo, item_id);
            if (i == 0)
                temp[0][i] = "部门内部办件编号";
            temp[0][i + 1] = apply.getInternalNo();

            if (i == 0)
                temp[1][i] = "权力编码";
            temp[1][i + 1] = apply.getItemId();

            if (i == 0)
                temp[2][i] = "权力名称";
            temp[2][i + 1] = CodeRepositoryUtil.getValue("suppowerId",
                    apply.getItemId());

            if (i == 0)
                temp[3][i] = "权力类型";
            temp[3][i + 1] = CodeRepositoryUtil.getValue("ITEM_TYPE",
                    apply.getItemType());

            if (i == 0)
                temp[4][i] = "办件名称";
            temp[4][i + 1] = apply.getTransactAffairName();

            if (i == 0)
                temp[5][i] = "办件摘要";
            temp[5][i + 1] = apply.getContent();

            if (i == 0)
                temp[6][i] = "业务处室";
            temp[6][i + 1] = apply.getDepartment();

            if (i == 0)
                temp[7][i] = "办件申请时间";
            temp[7][i + 1] = apply.getApplyDate().toLocaleString();

            if (i == 0)
                temp[8][i] = "申请者（自然人/法人）";
            temp[8][i + 1] = CodeRepositoryUtil.getValue("PROPOSER_TYPE",
                    apply.getApplicantType());

            if (i == 0)
                temp[9][i] = "办件申请方式";
            temp[9][i + 1] = CodeRepositoryUtil.getValue("bjsqfs",
                    apply.getApplyWay());

            if (i == 0)
                temp[10][i] = "组织机构代码";
            temp[10][i + 1] = apply.getApplicantCode();

            if (i == 0)
                temp[11][i] = "申请者名称";
            temp[11][i + 1] = apply.getApplicantName();

            if (i == 0)
                temp[12][i] = "申请者地址";
            temp[12][i + 1] = apply.getApplicantAddress();

            if (i == 0)
                temp[13][i] = "申请者证件类型";
            temp[13][i + 1] = CodeRepositoryUtil.getValue("PaperType",
                    apply.getApplicantPaperType());

            if (i == 0)
                temp[14][i] = "申请者证件号码";
            temp[14][i + 1] = apply.getApplicantPaperCode();

            if (i == 0)
                temp[15][i] = "申请者邮编";
            temp[15][i + 1] = apply.getApplicantZipcode();

            if (i == 0)
                temp[16][i] = "申请者电话";
            temp[16][i + 1] = apply.getApplicantPhone();

            if (i == 0)
                temp[17][i] = "申请者手机";
            temp[17][i + 1] = apply.getApplicantMobile();

            if (i == 0)
                temp[18][i] = "申请者电子邮件";
            temp[18][i + 1] = apply.getApplicantEmail();

            if (i == 0)
                temp[19][i] = "联系人/代理人（自然人）";
            temp[19][i + 1] = apply.getLinkman();

            if (i == 0)
                temp[20][i] = "联系人/代理人姓名";
            temp[20][i + 1] = apply.getLinkmanName();

            if (i == 0)
                temp[21][i] = "联系人/代理人证件类型";
            temp[21][i + 1] = CodeRepositoryUtil.getValue("PaperType",
                    apply.getLinkmanPaperType());

            if (i == 0)
                temp[22][i] = "联系人/代理人证件号码";
            temp[22][i + 1] = apply.getLinkmanPaperCode();

            if (i == 0)
                temp[23][i] = "联系人/代理人电话";
            temp[23][i + 1] = apply.getLinkmanPhone();

            if (i == 0)
                temp[24][i] = "联系人/代理人手机";
            temp[24][i + 1] = apply.getLinkmanMobile();

            if (i == 0)
                temp[25][i] = "联系人/代理人地址";
            temp[25][i + 1] = apply.getLinkmanAddress();

            if (i == 0)
                temp[26][i] = "联系人/代理人邮编";
            temp[26][i + 1] = apply.getLinkmanZipcode();

            if (i == 0)
                temp[27][i] = "联系人/代理人电子邮件";
            temp[27][i + 1] = apply.getLinkmanEmail();

            if (i == 0)
                temp[28][i] = "承诺时限";
            temp[28][i + 1] = apply.getPromise()
                    + CodeRepositoryUtil.getValue("Promise_Type",
                            apply.getPromiseType());

            if (i == 0)
                temp[29][i] = "办件申请提交材料";
            temp[29][i + 1] = new StringBuffer();
            List<ApplyDoc> docs = apply.getDocList();
            for (int j = 0; j < docs.size(); j++) {
                String docUrl = "<a href='applyDoc!downloadStuff.do?djId=${"
                        + docs.get(j).getNo() + "}'>${"
                        + docs.get(j).getDocName() + "}</a>";
                ((StringBuffer) temp[29][i + 1]).append(docUrl).append(" ");
            }
            // <a
            // href='applyDoc!downloadStuff.do?djId=${doc.djId}'>${doc.docName}</a>

            if (i == 0)
                temp[30][i] = "是否风险点";
            temp[30][i + 1] = apply.getIsrisk() != null
                    && apply.getIsrisk().equals("1") ? "是" : "否";

            if (i == 0)
                temp[31][i] = "风险点类别";
            temp[31][i + 1] = apply.getRisktype();

            if (i == 0)
                temp[32][i] = "风险点描述";
            temp[32][i + 1] = apply.getRiskdescription();

            if (i == 0)
                temp[33][i] = "风险内控的手段与结果";
            temp[33][i + 1] = apply.getRiskresult();

            if (i == 0)
                temp[34][i] = "办件过程信息";
            List<ApplyProcess> processList = applyProcessManager.listObjects(
                    apply.getInternalNo(), apply.getItemId());
            temp[34][i + 1] = processList;

            if (i == 0)
                temp[35][i] = "办件上传附件";
            List<ApplyDoc> docList = applyDocManager.listObjects(
                    apply.getInternalNo(), apply.getItemId());
            temp[35][i + 1] = docList;
        }

        for (int j = 0; j <= 35; j++) {
            applyList.add(temp[j]);
        }

        request.setAttribute("applyList", applyList);
        return "compare";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
