package com.centit.monitor.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

import com.centit.complaint.service.ComplaintManager;
import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.PunishDoc;
import com.centit.monitor.po.PunishProcess;
import com.centit.monitor.po.PunishResult;
import com.centit.monitor.po.VPunishForList;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.OutwayManager;
import com.centit.monitor.service.PunishDocManager;
import com.centit.monitor.service.PunishLogManager;
import com.centit.monitor.service.PunishManager;
import com.centit.monitor.service.PunishProcessManager;
import com.centit.monitor.service.PunishResultLogManager;
import com.centit.monitor.service.PunishResultManager;
import com.centit.powerbase.po.Suppower;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.powerbase.util.IMonitorOptLog;
import com.centit.powerbase.util.MonitorOptLogFactoryImpl;
import com.centit.supervise.service.SuperviseBasicManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class PunishAction extends BaseEntityExtremeAction<Punish> {
    private static final Log log = LogFactory.getLog(PunishAction.class);
    private static final IMonitorOptLog monitorOptLog = MonitorOptLogFactoryImpl
            .getMonitorOptLog("QLJK");
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private SuppowerManager suppowerManager;
    private PunishProcessManager punishProcessManager;
    private PunishDocManager punishDocManager;
    private PunishResultManager punishResultManager;
    private PunishLogManager punishLogManager;
    private PunishResultLogManager punishResultLogManager;
    private OutwayManager outwayManager;
    private ComplaintManager complaintManager;
    private SuperviseBasicManager superviseBasicManager;
    private Suppower suppower;

    public void setSuperviseBasicManager(
            SuperviseBasicManager superviseBasicManager) {
        this.superviseBasicManager = superviseBasicManager;
    }

    public void setOutwayManager(OutwayManager outwayManager) {
        this.outwayManager = outwayManager;
    }

    public void setComplaintManager(ComplaintManager complaintManager) {
        this.complaintManager = complaintManager;
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

    public void setPunishLogManager(PunishLogManager punishLogManager) {
        this.punishLogManager = punishLogManager;
    }

    public void setPunishResultLogManager(
            PunishResultLogManager punishResultLogManager) {
        this.punishResultLogManager = punishResultLogManager;
    }

    public void setPunishProcessManager(
            PunishProcessManager punishProcessManager) {
        this.punishProcessManager = punishProcessManager;
    }

    public void setPunishDocManager(PunishDocManager punishDocManager) {
        this.punishDocManager = punishDocManager;
    }

    public void setPunishResultManager(PunishResultManager punishResultManager) {
        this.punishResultManager = punishResultManager;
    }

    private static final long serialVersionUID = 1L;
    private List<FUnitinfo> unitList;
    private List<Suppower> itemList;
    private List<VPunishForList> punishList;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public List<Suppower> getItemList() {
        return itemList;
    }

    public void setItemList(List<Suppower> itemList) {
        this.itemList = itemList;
    }

    public List<VPunishForList> getPunishList() {
        return punishList;
    }

    public void setPunishList(List<VPunishForList> punishList) {
        this.punishList = punishList;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }

    private PunishManager punishManager;

    public void setPunishManager(PunishManager basemgr) {
        punishManager = basemgr;
        this.setBaseEntityManager(punishManager);
    }

    public String delete() {
        super.delete();

        return "delete";
    }

    
    /**
     * 案件过程监控
     */
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
        String sOrgId = (String) filterMap.get("orgId");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        String endTime = (String) filterMap.get("endTime");
        String NP_result = (String) filterMap.get("NP_result");
        @SuppressWarnings("unused")
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
        String begTime1 = (String) filterMap.get("begTime");
        if ((begTime1 == null || begTime1.equals(""))
                && (NP_result == null || NP_result.equals("") || NP_result
                        .equals("null"))) {
            Date date = new Date();// 当前日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化对象
            Calendar calendar = Calendar.getInstance();// 日历对象
            calendar.setTime(date);// 设置当前日期
            calendar.add(Calendar.MONTH, -1);// 月份减一
            begTime1 = sdf.format(calendar.getTime());
            filterMap.put("begTime", begTime1);
            request.setAttribute("s_begTime", begTime1);
        }
        if (endTime != null && endTime.length() == 10) {
            endTime = endTime + " 23:59:59";
            filterMap.put("endTime", endTime);
        }
        if (!StringBaseOpt.isNvl(sOrgId)
                && (s_queryUnderUnit == null || s_queryUnderUnit.equals(""))) {
            filterMap.put("unitcode", sysUnitManager.getUnitCode(sOrgId));
            filterMap.put("orgId", null);
        } else if (!StringBaseOpt.isNvl(sOrgId)
                && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", sysUnitManager.getUnitCode(sOrgId));
            filterMap.put("orgId", null);
        }
        if (null != filterMap.get("begFinishTime")) {
            String begFinishTime = (String) filterMap.get("begFinishTime");
            if (begFinishTime.length() == 10) {
                begFinishTime = begFinishTime + " 00:00:00";
                filterMap.put("begFinishTime", begFinishTime);
            }
        }
        if (null != filterMap.get("begTime")) {
            String begTime = (String) filterMap.get("begTime");
            if (begTime.length() == 10) {
                begTime = begTime + " 00:00:00";
                filterMap.put("begTime", begTime);
            }
        }
        if (null != filterMap.get("endFinishTime")) {
            String endFinishTime = (String) filterMap.get("endFinishTime");
            if (endFinishTime.length() == 10) {
                endFinishTime = endFinishTime + " 23:59:59";
                filterMap.put("endFinishTime", endFinishTime);
            }
        }
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        punishList = punishManager.listVPunishForList(filterMap, pageDesc);// 当权力项有多个版本时，列表显示版本号最大的一条
        totalRows = pageDesc.getTotalRows();
        monitorOptLog.log(((FUserinfo) this.getLoginUser()).getUsercode(), "",
                "案件列表查看", "", "9");
        request.setAttribute("opt", request.getParameter("opt"));
        return LIST;
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
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        itemList = suppowerManager.getlistSuppower("CF");
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        punishList = punishManager
                .listResultObjectsForList(filterMap, pageDesc);// 当权力项有多个版本时，列表显示版本号最大的一条
        totalRows = pageDesc.getTotalRows();
        return "result";
    }

    @SuppressWarnings("rawtypes")
    public String view() {
        try {
            if (object == null) {
                return LIST;
            }
            FUserDetail user = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(user
                    .getUsercode());
            String sParentUnit = dept.getUnitcode();
            String internalNo = object.getInternalNo();
            String orgId = object.getOrgId();
            Punish punish = new Punish();
            if (StringUtils.isNotBlank(object.getNo())) {// 兼容使用主键查询方式
                punish = punishManager.getObjectById(object.getNo());
                internalNo = punish.getInternalNo();
                orgId = punish.getOrgId();
            } else {
                punish = punishManager.getPunishInfo(internalNo, orgId);
            }
            request.setAttribute("punish", punish);
            List<PunishProcess> processList = punishProcessManager.listObjects(
                    internalNo, orgId);
            request.setAttribute("processList", processList);
            List<PunishDoc> docList = punishDocManager.listObjects(internalNo,
                    orgId);
            request.setAttribute("docList", docList);
            PunishResult result = punishResultManager.getPunishResult(
                    internalNo, orgId);
            request.setAttribute("result", result);
            List punishVersionList = punishLogManager.getVersionList(
                    internalNo, orgId);
            request.setAttribute("punishVersionList", punishVersionList);
            List punishResultVersionList = punishResultLogManager
                    .getVersionList(internalNo, orgId);
            request.setAttribute("punishResultVersionList",
                    punishResultVersionList);
            HashMap<String, Object> outwayMap = new HashMap<String, Object>();
            outwayMap.put("bjType", "1");
            outwayMap.put("internalNo", internalNo);
            outwayMap.put("topunitcode", sParentUnit);
            List outwayList = outwayManager.getOutWayList(outwayMap);
            request.setAttribute("outwayList", outwayList);
            HashMap<String, Object> complaintMap = new HashMap<String, Object>();
            complaintMap.put("bjType", "2");
            complaintMap.put("internalNo", internalNo);
            List complaintList = complaintManager.listObjects(complaintMap);
            request.setAttribute("complaintList", complaintList);
            HashMap<String, Object> superviseMap = new HashMap<String, Object>();
            superviseMap.put("bjType", "2");
            superviseMap.put("bjNo", punish.getNo());
            List superviseList = superviseBasicManager
                    .listObjects(superviseMap);
            request.setAttribute("superviseList", superviseList);
            monitorOptLog.log(((FUserinfo) this.getLoginUser()).getUsercode(),
                    "案件内部编号：" + punish.getInternalNo(),
                    "案件详细信息查看:部门内部编码：" + punish.getInternalNo() + ",当事人："
                            + punish.getPunishTarget(), "", "9");
            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    public String punishView() {
        try {
            String internalNo = object.getInternalNo();
            String orgId = object.getOrgId();
            Punish punish = punishManager.getPunishInfo(internalNo, orgId);
            List applyList = punishManager.getApplyReg(internalNo);
            if(applyList.size() == 1){
                Object[] applys = (Object[]) applyList.get(0);
                punish.setParentName(applys[5]!=null?applys[5].toString():"");
                punish.setItemParName(applys[4].toString());
            }
            HashMap<String, Object> docMap = new HashMap<String, Object>();
            docMap.put("docType", "1");
            docMap.put("internalNo", punish.getInternalNo());
            docMap.put("orgId", punish.getOrgId());
            List<PunishDoc> docList = punishDocManager.listObjects(docMap);
            punish.setDocList(docList);
            if (object == null) {
                return LIST;
            }
            request.setAttribute("punish", punish);
            return "punishView";
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
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
        Punish punish = punishManager.getPunishInfo(internal_no, org_id);
        request.setAttribute("punish", punish);
        Date punishDate = punish.getCreateDate();
        setSuppower(suppowerManager.getSuppowerLastVersion(item_id, punishDate));
        request.setAttribute("sup", suppower);
        request.setAttribute("systemType", "punish");
        return "flowChart";
    }

    public String flowChart_L() {
        String item_id = (String) request.getParameter("item_id");
        String internal_no = (String) request.getParameter("internal_no");
        String org_id = (String) request.getParameter("org_id");
        Punish punish = punishManager.getPunishInfo(internal_no, org_id);
        request.setAttribute("punish", punish);
        Suppower power = suppowerManager.getSuppowerLastVersion(item_id,
                punish.getCreateDate());
        String inFlowInfo = "";
        if (power != null) {
            inFlowInfo = power.getInFlowInfo();
        }
        List<PunishProcess> processList = punishProcessManager
                .listPunishProcessEx(internal_no, org_id, inFlowInfo);
        request.setAttribute("processList", processList);
        PunishResult result = punishResultManager.getPunishResult(internal_no,
                org_id);
        request.setAttribute("result", result);
        return "flowChart_L";
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
    public String compare() {
        String itemId = object.getItemId();
        String[] itemIds = itemId.split(",");
        List punishList = new ArrayList();
        Object[][] temp = new Object[25][itemIds.length + 1];
        for (int i = 0; i < itemIds.length; i++) {
            String internalNo = itemIds[i].split(";")[0];
            String orgId = itemIds[i].split(";")[1];
            Punish punish = punishManager.getPunishInfo(internalNo, orgId);
            if (i == 0)
                temp[0][i] = "部门内部办件编号";
            temp[0][i + 1] = punish.getInternalNo();

            if (i == 0)
                temp[1][i] = "权力编码";
            temp[1][i + 1] = punish.getItemId();

            if (i == 0)
                temp[2][i] = "权力名称";
            temp[2][i + 1] = CodeRepositoryUtil.getValue("suppowerId",
                    punish.getItemId());

            if (i == 0)
                temp[3][i] = "处罚名称";
            temp[3][i + 1] = CodeRepositoryUtil.getValue("ITEM_TYPE",
                    punish.getContent());

            if (i == 0)
                temp[4][i] = "案件来源";
            temp[4][i + 1] = CodeRepositoryUtil.getValue("SOURCE",
                    punish.getSource());

            if (i == 0)
                temp[5][i] = "确认事实";
            temp[5][i + 1] = punish.getFact();

            if (i == 0)
                temp[6][i] = "主办部门";
            temp[6][i + 1] = CodeRepositoryUtil.getValue("depno",
                    punish.getOrgId());

            if (i == 0)
                temp[7][i] = "业务处室";
            temp[7][i + 1] = punish.getDepartment();

            if (i == 0)
                temp[8][i] = "案发时间";
            temp[8][i + 1] = punish.getAjOccurDate().toLocaleString();

            if (i == 0)
                temp[9][i] = "案发地点";
            temp[9][i + 1] = punish.getAjAddr();

            if (i == 0)
                temp[10][i] = "录入自建系统时间";
            temp[10][i + 1] = punish.getCreateDate().toLocaleString();

            if (i == 0)
                temp[11][i] = "处罚当事人";
            temp[11][i + 1] = punish.getPunishTarget();

            if (i == 0)
                temp[12][i] = "当事人类型";
            temp[12][i + 1] = CodeRepositoryUtil.getValue("PROPOSER_TYPE",
                    punish.getTargetType());

            if (i == 0)
                temp[13][i] = "组织机构代码";
            temp[13][i + 1] = punish.getTargetCode();

            if (i == 0)
                temp[14][i] = "当事人证件名称";
            temp[14][i + 1] = CodeRepositoryUtil.getValue("PaperType",
                    punish.getTargetPaperType());

            if (i == 0)
                temp[15][i] = "当事人证件号码";
            temp[15][i + 1] = punish.getTargetPaperNumber();

            if (i == 0)
                temp[16][i] = "当事人联系电话";
            temp[16][i + 1] = punish.getTargetPhone();

            if (i == 0)
                temp[17][i] = "当事人联系手机";
            temp[17][i + 1] = punish.getTargetMobile();

            if (i == 0)
                temp[18][i] = "当事人邮编";
            temp[18][i + 1] = punish.getTargetZipCode();

            if (i == 0)
                temp[19][i] = "当事人地址";
            temp[19][i + 1] = punish.getTargetAddress();

            if (i == 0)
                temp[20][i] = "当事人电子邮件";
            temp[20][i + 1] = punish.getTargetEmail();

            if (i == 0)
                temp[21][i] = "办理附件";
            temp[21][i + 1] = new StringBuffer();
            List<PunishDoc> docs = punish.getDocList();
            for (int j = 0; j < docs.size(); j++) {
                String docUrl = "<a href='punishDoc!downloadStuff.do?djId=${"
                        + docs.get(j).getNo() + "}'>${"
                        + docs.get(j).getDocName() + "}</a>";
                ((StringBuffer) temp[21][i + 1]).append(docUrl).append(" ");
            }
            if (i == 0)
                temp[22][i] = "案件过程信息";
            List<PunishProcess> processList = punishProcessManager.listObjects(
                    punish.getInternalNo(), punish.getOrgId());
            temp[22][i + 1] = processList;

            if (i == 0)
                temp[23][i] = "案件上传附件";
            List<PunishDoc> docList = punishDocManager.listObjects(
                    punish.getInternalNo(), punish.getOrgId());
            temp[23][i + 1] = docList;

            if (i == 0)
                temp[24][i] = "案件结果信息";
            PunishResult result = punishResultManager.getPunishResult(
                    punish.getInternalNo(), punish.getOrgId());
            temp[24][i + 1] = result;
        }
        for (int j = 0; j <= 24; j++) {
            punishList.add(temp[j]);
        }
        request.setAttribute("punishList", punishList);
        return "compare";
    }
    
}
