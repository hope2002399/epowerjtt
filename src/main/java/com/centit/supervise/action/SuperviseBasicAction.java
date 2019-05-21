package com.centit.supervise.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.complaint.action.EpowerCommonBizAction;
import com.centit.complaint.po.Complaint;
import com.centit.complaint.service.ComplaintManager;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.Unit.Constant;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.Outway;
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VPunish;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.OutwayManager;
import com.centit.monitor.service.PunishManager;
import com.centit.supervise.po.SuperviseBasic;
import com.centit.supervise.po.SuperviseReply;
import com.centit.supervise.po.SuperviseResult;
import com.centit.supervise.po.VSuperviseBasic;
import com.centit.supervise.service.SuperviseBasicManager;
import com.centit.supervise.service.SuperviseReplyManager;
import com.centit.supervise.service.SuperviseResultManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.FunctionManager;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.centit.sys.service.WorkCalendar;
import com.centit.workflow.FlowInstance;

public class SuperviseBasicAction extends EpowerCommonBizAction<SuperviseBasic> {
    private static final long serialVersionUID = 1L;
    private SuperviseBasicManager superviseBasicMag;
    private FunctionManager functionManager;
    private String optId;
    private String flowCode;
    private ApplyManager applyManager;
    private PunishManager punishManager;
    private ComplaintManager complaintManager;
    private SuperviseReplyManager superviseReplyManager;
    private SuperviseResultManager superviseResultManager;
    private OutwayManager outwayManager;
    private String suptype;
    private List<Apply> applylist;
    private List<Punish> punishlist;
    private SysUnitManager sysUnitManager;
    private SysUserManager sysUserManager;
    private WorkCalendar workCalendar;

    public void setWorkCalendar(WorkCalendar workCalendar) {
        this.workCalendar = workCalendar;
    }

    private String unitsJson;
    private String parentunit;
    private String fromsup;
    private String isworkflowFlag;// 是否是工作流标识
    private String bjtypestring;
    private String intno;
    private String itemid;
    private String iscomplaint;
    private String forwardurl;
    private String s_monitorSource;

    public String getS_monitorSource() {
        return s_monitorSource;
    }

    public void setS_monitorSource(String s_monitorSource) {
        this.s_monitorSource = s_monitorSource;
    }

    public String getForwardurl() {
        return forwardurl;
    }

    public void setForwardurl(String forwardurl) {
        this.forwardurl = forwardurl;
    }

    public String getIscomplaint() {
        return iscomplaint;
    }

    public void setIscomplaint(String iscomplaint) {
        this.iscomplaint = iscomplaint;
    }

    public String getIntno() {
        return intno;
    }

    public void setIntno(String intno) {
        this.intno = intno;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getBjtypestring() {
        return bjtypestring;
    }

    public void setBjtypestring(String bjtypestring) {
        this.bjtypestring = bjtypestring;
    }

    public String getFromsup() {
        return fromsup;
    }

    public void setFromsup(String fromsup) {
        this.fromsup = fromsup;
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

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public String fromComplaint() {
        return superviseinitiate();
    }

    private List<FUnitinfo> unitList;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    /**
     * 定量分析发起督办
     */
    @SuppressWarnings("unchecked")
    public String DlfxInfo() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        String outwayNo = (String) filterMap.get("outwayNo");
        String orgId = (String) filterMap.get("orgId");
        // optId=(String)filterMap.get("optId");
        Outway outway = new Outway();
        if (!StringBaseOpt.isNvl(outwayNo)) {
            outway = outwayManager.getObjectById(outwayNo);

            outway.setOrgId(sysUnitManager.getUnitCode(superviseBasicMag
                    .getDbbmForCjdbByDepno(outway.getOrgId())));

            object.setOutway(outway);
        } else {
            // 暂不做处理
        }
        if (StringUtils.isNotBlank(orgId)) {
            object.setOrgId(orgId);
        } else {
            object.setOrgId(object.getOutway().getOrgId());
        }

        return "DlfxInfo";
    }

    /**
     * 定量分析经办人反馈
     * 
     * @return
     */
    public String superviseBack() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute", "submitSuperviseBack",
                "saveOpt");
        return super.generalOpt();
    }

    /**
     * 定量分析督办结论
     * 
     * @return
     */
    public String superviseResultDlfx() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute",
                "submitSuperviseResultDlfx", "saveOpt");
        super.generalOpt();
        return "superviseResultDlfx";
    }

    /**
     * 定量分析查询list
     * 
     * @return
     */
    public String DlfxList() {
        try {
            FUserDetail user = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(user
                    .getUsercode());
            String sParentUnit = dept.getUnitcode();
            unitList = sysUnitManager.getAllSubUnits(sParentUnit);
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // filterMap.put("userCode", userCode);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            List<VSuperviseBasic> vsuperviselist = superviseBasicMag
                    .listVSuperviseBasic(filterMap, pageDesc);
            request.setAttribute("vsuplist", vsuperviselist);
            totalRows = pageDesc.getTotalRows();
            return "DlfxList";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 其他监察督查督办查询列表
     */
    public String list() {
        try {
            FUserDetail user = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(user
                    .getUsercode());
            String sParentUnit = dept.getUnitcode();
            unitList = sysUnitManager.getAllSubUnits(sParentUnit);
            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // filterMap.put("userCode", userCode);
            if (filterMap.get("queryUnderUnit") != null
                    && !filterMap.get("queryUnderUnit").equals("")
                    && filterMap.get("orgId") != null
                    && !filterMap.get("orgId").equals("")) {
                StringBuilder temp = new StringBuilder();
                List<FUnitinfo> templist = sysUnitManager
                        .getSubUnits(sysUnitManager
                                .getUnitCode((String) filterMap.get("orgId")));
                for (FUnitinfo f : templist) {
                    temp.append(",'").append(f.getDepno()).append("'");
                }
                filterMap.put("subunit", temp.substring(1));
            }

            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            List<VSuperviseBasic> vsuperviselist = superviseBasicMag
                    .listVSuperviseBasic(filterMap, pageDesc);
            request.setAttribute("vsuplist", vsuperviselist);
            totalRows = pageDesc.getTotalRows();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // 督办发起
    private List<FUserinfo> userlist;

    public List<FUserinfo> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<FUserinfo> userlist) {
        this.userlist = userlist;
    }

    public String fromsup() {
        return "fromsup";
    }

    public String superviseinitiate() {
        String optid = object.getOptId();
        if ("1".equals(fromsup)) {
            object.setSuperviseNo("");
            if (request.getParameter("monitorOperatorName") != null) {
                try {
                    String loginName = URLDecoder.decode(
                            request.getParameter("monitorOperatorName"),
                            "UTF-8");
                    object.setMonitorOperatorName(loginName);
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                Map<String, Object> filtermap = new HashMap<String, Object>();
                // filtermap.put("LOGINNAME", object.getMonitorOperatorId());
                filtermap.put("USERCODE", object.getMonitorOperatorId());
                List<FUserinfo> userlist = this.sysUserManager
                        .listObjects(filtermap);
                if (userlist.size() > 0) {
                    List<FUserunit> userunitlist = this.sysUnitManager
                            .getSysUnitsByUserId(userlist.get(0).getUsercode());
                    String primaryorgid = "";
                    for (FUserunit fuu : userunitlist) {
                        if ("T".equals(fuu.getIsprimary())) {
                            primaryorgid = fuu.getUnitcode();
                        }
                    }
                    String depno = sysUnitManager.getObjectById(primaryorgid)
                            .getDepno();
                    String depname = sysUnitManager.getObjectById(primaryorgid)
                            .getUnitname();
                    object.setMonitorOrgId(depno);
                    object.setMonitorOrgName(depname);
                }
            }
        }
        FUserDetail user = ((FUserDetail) getLoginUser());// .getUserinfo（）;
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        userlist = sysUserManager.getUserUnderUnit(dept.getUnitcode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        if (StringUtils.isBlank(object.getBjNo())
                && StringUtils.isBlank(object.getComplaintid())
                && object.getOutwayid() == null) {
            object = new SuperviseBasic();
        }
        viewBizInfo();
        if ("1".equals(fromsup)) {
            if ("1".equals(object.getBjType())) {
                intno = object.getApply().getInternalNo();
                itemid = object.getApply().getItemId();
                forwardurl = "../monitor/apply!view.do?internalNo=" + intno
                        + "&itemId=" + itemid;
                System.out.println("xxxxxxx" + forwardurl);
            } else if ("2".equals(object.getBjType())) {
                intno = object.getPunish().getInternalNo();
                itemid = object.getPunish().getItemId();
                forwardurl = "../monitor/punish!view.do?internalNo=" + intno
                        + "&itemId=" + itemid;
            } else if ("3".equals(object.getBjType())) {
                forwardurl = "../complaint/complaint!view.do?complaintid="
                        + object.getComplaint().getComplaintid();
            } else if ("5".equals(object.getBjType())
                    || "6".equals(object.getBjType())) {
                forwardurl = "../monitor/outway!list.do?s_NP_outWayZC=1";
            } else if ("7".equals(object.getBjType())) {
                forwardurl = "../supervise/superviseBasic!list.do?s_monitorSource=C";
            }
        } else {
            forwardurl = "../supervise/superviseBasic!list.do?";
        }

        object.setOptId(optid);

        if ("7".equals(object.getBjType())) { // YJ
            String outwayId = object.getBjNo();
            Outway o = outwayManager.getObjectById(outwayId);
            if (o != null) {
                String monitorOrgId = o.getOrgId();
                String monitorOrgCode = sysUnitManager
                        .getUnitCode(monitorOrgId);
                String depname = sysUnitManager.getObjectById(monitorOrgCode)
                        .getUnitname();
                object.setMonitorOrgId(monitorOrgCode);
                object.setMonitorOrgName(depname);
                request.setAttribute("s_orgcode", monitorOrgCode);
            }
        } else if ("4".equals(object.getBjType())) { // DB
            String dbId = object.getBjNo();
            SuperviseBasic s = superviseBasicMag.getObjectById(dbId);
            if (s != null) {
                String monitorOrgId = s.getOrgId();
                String monitorOrgCode = sysUnitManager
                        .getUnitCode(monitorOrgId);
                String depname = sysUnitManager.getObjectById(monitorOrgCode)
                        .getUnitname();
                object.setMonitorOrgId(monitorOrgCode);
                object.setMonitorOrgName(depname);
                request.setAttribute("s_orgcode", monitorOrgCode);
            }
        } else {
            String outwayId = object.getOutwayid();
            Outway o = outwayManager.getObjectById(outwayId);
            if (o != null) {
                String monitorOrgId = o.getOrgId();
                String monitorOrgCode = sysUnitManager
                        .getUnitCode(monitorOrgId);
                String depname = sysUnitManager.getObjectById(monitorOrgCode)
                        .getUnitname();
                object.setMonitorOrgId(monitorOrgCode);
                object.setMonitorOrgName(depname);
                request.setAttribute("s_orgcode", monitorOrgCode);
            }
        }
        request.setAttribute("fromsup", fromsup);
        // 层级督办发起做特殊处理
        String outwayId = object.getOutwayid();
        Outway o = outwayManager.getObjectById(outwayId);
        if (o != null) {
            object.setMonitorSource(o.getMonitorSource());
            if ("B".equals(o.getMonitorSource())) {
                String depno = superviseBasicMag.getDbbmForCjdbByDepno(o
                        .getOrgId());
                String monitorOrgCode = sysUnitManager.getUnitCode(depno);
                String depname = sysUnitManager.getObjectById(monitorOrgCode)
                        .getUnitname();
                object.setMonitorOrgId(depno);
                object.setMonitorOrgName(depname);
                request.setAttribute("s_orgcode", monitorOrgCode);
            }
        }
        return EDIT;
    }

    public String edit() {

        // 根据登记编号查看许可信息
        this.getSuperviseInfo();

        return EDIT;
    }

    private void getSuperviseInfo() {
        object = superviseBasicMag.getObjectById(object.getSuperviseNo());
        if (object == null) {
            object = new SuperviseBasic();
        }
        // 根据业务编码，获取流程编码
        FOptinfo optInfo = functionManager.getObjectById(optId);
        if (optInfo != null) {
            flowCode = optInfo.getWfcode();
        }

    }

    /**
     * 保存督办发起信息
     */
    public String save() {

        // bizType: F未提交，T办理中，C办结
        object.setBizType("F");// 设置督办办件状态
        this.saveSupervise();
        return list();
    }

    /**
     * 保存督办基本信息
     */
    private void saveSupervise() {

        if (StringUtils.isBlank(object.getSuperviseNo())) {
            object.setSuperviseNo(this.superviseBasicMag.getNextkey());
        }

        FUserDetail fuser = ((FUserDetail) getLoginUser());
        FUnitinfo dept = sysUnitManager.getObjectById(fuser.getPrimaryUnit());
        object.setCreateUser(fuser.getUsercode());
        object.setCreateDate(new Date());

        object.setOperatorId(fuser.getUsercode());
        object.setOperatorName(dept.getUnitname() + ":" + fuser.getUserdesc());
        // FUserunit dept =
        // sysUserManager.getUserPrimaryUnit(fuser.getUsercode());

        object.setOrgId(dept.getDepno());
        object.setSuperviseDate(new Date());

        Date tempDate = new Date();

        tempDate = workCalendar.getWorkDate(tempDate, "10");

        // DatetimeOpt.
        object.setPromisedate(tempDate);
        // 备注说明：此处不计入发起督办时间，需要领导审核同意督办意见后在计入；
        // 保存
        if (StringUtils.isNotBlank(object.getMonitorOperatorId())
                && StringUtils.isBlank(object.getMonitorOperatorName())) {

            Map<String, Object> filtermap = new HashMap<String, Object>();
            filtermap.put("LOGINNAME", object.getMonitorOperatorId());
            List<FUserinfo> userlist = this.sysUserManager
                    .listObjects(filtermap);
            object.setMonitorOperatorName(userlist.get(0).getUsername());
        }

        this.superviseBasicMag.saveObject(object);
    }

    /**
     * （发起督办的同时）对预警进行摘牌
     */
    private void cancelOutway() {
        String outwayno = object.getOutwayid();
        if (outwayno == null)
            return;
        Outway outway = outwayManager.getObjectById(object.getOutwayid());
        if (outway != null) {
            outway.setOutWayState("0");
            if (outway.getOuttime() == null)
                outway.setOuttime(new Date(System.currentTimeMillis()));
            if (outway.getOutreason() == null)
                outway.setOutreason("督办后自动摘牌！");
            if (outway.getOutperson() == null)
                outway.setOutperson("SYSTEM");

            outwayManager.saveObject(outway);
        }
    }

    @SuppressWarnings("unchecked")
    public String listsup() {
        if (StringUtils.isBlank(suptype)) {
            suptype = "apply";
        }
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String topunitcode = dept.getUnitcode();

        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);

        filterMap.put("bmcj", "*" + topunitcode + ",");

        filterMap.put("topunitcode", topunitcode);
        unitList = sysUnitManager.getAllSubUnits(topunitcode);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        String parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        request.setAttribute("parentUnit", parentUnit);
        String unitCode = (String) filterMap.get("unitcode");

        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");

        if (!StringBaseOpt.isNvl(unitCode) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("bmcj", "*" + unitCode + ",");
        }
        if (!StringBaseOpt.isNvl(unitCode) && !"true".equals(s_queryUnderUnit)) {
            filterMap.put("orgId", sysUnitManager.getObjectById(unitCode)
                    .getDepno());

        }

        if (!StringUtils.isBlank((String) filterMap.get("internalNo"))) {
            filterMap.put("internalNo", (String) filterMap.get("internalNo"));
        }

        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        if ("apply".equals(suptype)) {

            applylist = this.applyManager.listObjects(filterMap, pageDesc);

        } else if ("punish".equals(suptype)) {

            punishlist = this.punishManager.listObjects(filterMap, pageDesc);

        }
        totalRows = pageDesc.getTotalRows();
        return "listsup";
    }

    /**
     * 保存定量分析督办发起信息
     */
    public String DlfxSubmit() {
        String isworkflow = CodeRepositoryUtil.getDataPiece("SYSPARAM",
                "ISWORKFLOW").getDatavalue();// 这个作用是？
        // bizType: F未提交，T办理中，C办结
        object.setBizType("T");// 设置督办办件状态为：已提交
        if ("F".equals(isworkflow)) { // 通过数据字典配置，是否发起工作流程
            saveSupervise();
            return this.backlogOfSupervise();// 根据业务选择
        } else {
            FOptinfo optInfo = functionManager.getObjectById(object.getOptId());
            if (optInfo != null) {
                flowCode = optInfo.getWfcode();// 流程代码
            }
            if (StringUtils.isBlank(object.getSuperviseNo())) {
                object.setSuperviseNo(this.superviseBasicMag.getNextkey());
            }
            // flowInstid流程实例Id
            if (object.getFlowInstId() == null
                    || "".equals(object.getFlowInstId())) {
                FUserDetail fuser = ((FUserDetail) getLoginUser());
                // 创建流程实例 返回流程实例
                FlowInstance flowInst = flowEngine.createInstance(flowCode,
                        "督察督办[" + object.getSuperviseNo() + "]",
                        object.getSuperviseNo(), fuser.getUsercode(),
                        fuser.getPrimaryUnit());
                long flowInstId = flowInst.getFlowInstId();
                long nodeInstId = flowInst.getFirstNodeInstance()
                        .getNodeInstId();
                object.setFlowInstId(0L);
                object.setBizType("T");
                object.setMonitorSource("C");
                this.setFlowInstId(flowInstId);
                curNodeInstId = 0L;
                // 提交时生成督办过程信息
                SuperviseReply supervisereply = superviseReplyManager
                        .getObjectByNodeInstId(nodeInstId);
                if (supervisereply == null) {
                    supervisereply = new SuperviseReply();
                    supervisereply.setNodeInstId(nodeInstId);
                    // supervisereply.setProcessNo(UuidOpt.getUuidAsString());
                    supervisereply.setProcessNo(superviseReplyManager
                            .getNextKey());
                }
                supervisereply.setSuperviseNo(object.getSuperviseNo());
                supervisereply.setProcessName("督办发起");
                supervisereply.setProcessDate(new Date());
                supervisereply.setOperatorId(fuser.getUsercode());
                supervisereply.setOperatorName(fuser.getUserdesc());
                supervisereply.setUpdateDate(new Date(System
                        .currentTimeMillis()));
                supervisereply.setOperatorResult("督办发起");
                supervisereply.setOperatorOpinion(object.getSuperviseOption());
                superviseReplyManager.saveObject(supervisereply);
            }
            saveSupervise();
            cancelOutway();
            s_monitorSource = "C";
            // return super.nextStep();
            return "refreshfankui";
        }
    }

    /** 督办发起提交 **/
    public String saveAndSubmit() {
        String isworkflow = CodeRepositoryUtil.getDataPiece("SYSPARAM",
                "ISWORKFLOW").getDatavalue();
        // bizType: F未提交，T办理中，C办结
        object.setBizType("T");// 设置督办办件状态为：已提交

        // 通过数据字典配置，是否发起工作流程
        if ("F".equals(isworkflow)) {
            saveSupervise();
            cancelOutway();
            return this.backlogOfSupervise();// 根据业务选择
        } else {
            FOptinfo optInfo = functionManager.getObjectById(object.getOptId());
            if (optInfo != null) {
                flowCode = optInfo.getWfcode();
            }
            if (StringUtils.isBlank(object.getSuperviseNo())) {
                object.setSuperviseNo(this.superviseBasicMag.getNextkey());
            }
            if (object.getFlowInstId() == null
                    || "".equals(object.getFlowInstId())) {
                FUserDetail fuser = ((FUserDetail) getLoginUser());

                FlowInstance flowInst = flowEngine.createInstance(flowCode,
                        "督察督办[" + object.getSuperviseNo() + "]",
                        object.getSuperviseNo(), fuser.getUsercode(),
                        fuser.getPrimaryUnit());
                long flowInstId = flowInst.getFlowInstId();
                long nodeInstId = flowInst.getFirstNodeInstance()
                        .getNodeInstId();
                object.setFlowInstId(flowInstId);
                object.setBizType("T");

                this.setFlowInstId(flowInstId);
                curNodeInstId = nodeInstId;
                // 层级督办不走流程，做特殊处理
                if ("B".equals(object.getMonitorSource())) {
                    object.setFlowInstId(null);
                    curNodeInstId = 0L;

                }

                // 提交时生成督办过程信息
                SuperviseReply supervisereply = superviseReplyManager
                        .getObjectByNodeInstId(nodeInstId);
                if (supervisereply == null) {
                    supervisereply = new SuperviseReply();
                    // supervisereply.setNodeInstId(nodeInstId);
                    // supervisereply.setProcessNo(UuidOpt.getUuidAsString());
                    supervisereply.setProcessNo(superviseReplyManager
                            .getNextKey());
                }
                supervisereply.setSuperviseNo(object.getSuperviseNo());
                supervisereply.setProcessName("督办发起");
                supervisereply.setProcessDate(new Date());
                supervisereply.setOperatorId(fuser.getUsercode());
                supervisereply.setOperatorName(fuser.getUserdesc());
                supervisereply.setUpdateDate(new Date(System
                        .currentTimeMillis()));
                supervisereply.setOperatorResult("督办发起");
                supervisereply.setOperatorOpinion(object.getSuperviseOption());
                superviseReplyManager.saveObject(supervisereply);
            }
            saveSupervise();
            cancelOutway();
            // 层级督办不走流程，做特殊处理
            if ("B".equals(object.getMonitorSource())) {
                this.s_monitorSource = "B";
                return "refreshfankui";
            }

            return super.nextStep();
        }
    }

    /** 督查督办选择办件列表 **/

    @SuppressWarnings("unused")
    private String suplist() {
        applylist = this.applyManager.listObjects();
        this.totalRows = applylist.size();
        return "suplist";
    }

    /**
     * 查看
     */
    public String view() {
        viewBizInfo();
        return VIEW;
    }

    /**
     * 查看业务详细信息涉及一下 1、业务信息 2、过程信息 3、结果信息 4、附件材料信息
     * 
     * @return
     */
    public String viewBizInfo() {
        super.view();
        // 信息初始化
        this.initalBizInfo();
        request.setAttribute("fromsup",
                (String) request.getAttribute("fromsup"));

        return "viewBizInfo";
    }

    /**
     * 初始化办件信息
     */
    private void initalBizInfo() {
        if (StringUtils.isNotBlank(object.getBjType())) {
            switch (Integer.parseInt(object.getBjType())) {
            case 1:// XK
                VApply vapply = null;
                Apply apply = null;
                if (StringUtils.isNotBlank(object.getOutwayid())) {
                    Outway outway = outwayManager.getObjectById(object
                            .getOutwayid());
                    String internalNo = outway.getInternalNo();
                    String itemId = outway.getItemId();
                    vapply = applyManager.getApply(internalNo, itemId);
                    apply = applyManager.getApplyInfo(internalNo, itemId);
                } else {
                    vapply = applyManager.getApply(object.getBjNo());
                    apply = applyManager.getObjectById(object.getBjNo());
                }
                object.setVapply(vapply);
                object.setApply(apply);
                break;
            case 2:// CF
                VPunish vpunish = null;
                Punish punish = null;
                if (StringUtils.isNotBlank(object.getOutwayid())) {
                    Outway outway = outwayManager.getObjectById(object
                            .getOutwayid());
                    String internalNo = outway.getInternalNo();
                    String orgId = outway.getOrgId();
                    vpunish = punishManager.getPunish(internalNo, orgId);
                    punish = punishManager.getPunishInfo(internalNo, orgId);
                } else {
                    vpunish = punishManager.getPunish(object.getBjNo());
                    punish = punishManager.getObjectById(object.getBjNo());
                }

                object.setVpunish(vpunish);
                object.setPunish(punish);
                break;
            case 3:// TS
                Complaint complaint = complaintManager.getObjectById(object
                        .getComplaintid());
                if (complaint == null) {
                    complaint = complaintManager
                            .getObjectById(object.getBjNo());
                }
                object.setComplaint(complaint);
                if ("1".equals(complaint.getBjType())) {// XK
                    VApply vapply1 = applyManager.getApply(complaint.getBjNo());
                    Apply apply1 = applyManager.getObjectById(complaint
                            .getBjNo());
                    object.setVapply(vapply1);
                    object.setApply(apply1);
                    object.setVpunish(null);
                    object.setPunish(null);
                } else if ("2".equals(complaint.getBjType())) {// CF
                    VPunish vpunish1 = punishManager.getPunish(complaint
                            .getBjNo());
                    Punish punish1 = punishManager.getObjectById(complaint
                            .getBjNo());
                    object.setVpunish(vpunish1);
                    object.setPunish(punish1);
                    object.setApply(null);
                    object.setVapply(null);
                }
                break;
            case 7://
                Outway outway = outwayManager.getObjectById(object.getBjNo());
                if (outway == null)
                    break;
                if (Constant.BjType_XK.equals(outway.getBjType())) {
                    String internalNo = outway.getInternalNo();
                    String itemId = outway.getItemId();
                    VApply vapply1 = applyManager.getApply(internalNo, itemId);
                    Apply apply1 = applyManager
                            .getApplyInfo(internalNo, itemId);
                    object.setVapply(vapply1);
                    object.setApply(apply1);
                    object.setVpunish(null);
                    object.setPunish(null);
                } else if (Constant.BjType_CF.equals(outway.getBjType())) {
                    String internalNo = outway.getInternalNo();
                    String orgId = outway.getOrgId();
                    VPunish vpunish1 = punishManager.getPunish(internalNo,
                            orgId);
                    Punish punish1 = punishManager.getPunishInfo(internalNo,
                            orgId);
                    object.setVpunish(vpunish1);
                    object.setPunish(punish1);
                    object.setApply(null);
                    object.setVapply(null);
                }
                object.setOutway(outway);
                break;
            // 其他...

            }
        }

        // 督办结果信息
        SuperviseResult superviseResult = superviseResultManager
                .getSuperviseResultBySuperviseNo(object.getSuperviseNo());
        object.setSuperviseResult(superviseResult);
    }

    /**
     * 查看业务信息，用于办理页面
     * 
     * @return
     */
    public String viewFrame() {
        this.viewBizInfo();
        return "viewFrame";
    }

    /***************************** 业务办理 ***************************/
    /**
     * 通用流程
     * 
     * @return
     */
    public String generCommonTrans() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute", "submitOpt", "saveOpt");
        return super.generalOpt();
    }

    /**
     * 督办意见审核
     * 
     * @return
     */
    public String isSupervise() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute", "submitIsSupervise",
                "saveOpt");
        return super.generalOpt();
    }

    /**
     * 发出督办意见
     * 
     * @return
     */
    public String sendSupervise() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute", "submitSendSupervise",
                "saveOpt");
        return super.generalOpt();
    }

    /**
     * 重拟督办
     * 
     * @return
     */
    public String reconstructSupervise() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute",
                "submitReconstructSupervise", "saveOpt");
        return super.generalOpt();
    }

    /**
     * 答复
     * 
     * @return
     */
    public String replySupervise() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute",
                "submitReplySupervise", "saveOpt");
        return super.generalOpt();
    }

    /**
     * 单位接收督办
     * 
     * @return
     */
    public String receivesSupervise() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute",
                "submitReceivesSupervise", "saveOpt");
        return super.generalOpt();
    }

    /**
     * 领导分办
     * 
     * @return
     */
    public String pointsToDoSupervise() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute",
                "submitPointsToDoSupervise", "saveOpt");
        return super.generalOpt();
    }

    /**
     * 审核答复
     * 
     * @return
     */
    public String isReplySupervise() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute",
                "submitIsReplySupervise", "saveOpt");
        return super.generalOpt();
    }

    /**
     * 督办结论
     * 
     * @return
     */
    public String superviseResult() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute",
                "submitSuperviseResult", "saveOpt");
        super.generalOpt();
        return "superviseResult";
    }

    /**
     * 审核督办结论
     * 
     * @return
     */
    public String isSuperviseResult() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("superviseTasksExecute",
                "submitIsSuperviseResult", "saveOpt");
        return super.generalOpt();
    }

    /**************************** 待办结的督办 ***********************/

    public String backlogOfSupervise() {

        return "backlogOfSupervise";
    }

    /************************ 以下为getter、setter ***************************/
    public List<Apply> getApplylist() {
        return applylist;
    }

    public void setApplylist(List<Apply> applylist) {
        this.applylist = applylist;
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    public ApplyManager getApplyManager() {
        return applyManager;
    }

    public void setApplyManager(ApplyManager applyManager) {
        this.applyManager = applyManager;
    }

    public void setSuperviseBasicManager(SuperviseBasicManager basemgr) {
        superviseBasicMag = basemgr;
        this.setBaseEntityManager(superviseBasicMag);
    }

    public List<Punish> getPunishlist() {
        return punishlist;
    }

    public void setPunishlist(List<Punish> punishlist) {
        this.punishlist = punishlist;
    }

    public String getSuptype() {
        return suptype;
    }

    public void setSuptype(String suptype) {
        this.suptype = suptype;
    }

    public PunishManager getPunishManager() {
        return punishManager;
    }

    public void setPunishManager(PunishManager punishManager) {
        this.punishManager = punishManager;
    }

    public void setComplaintManager(ComplaintManager complaintManager) {
        this.complaintManager = complaintManager;
    }

    public void setOutwayManager(OutwayManager outwayManager) {
        this.outwayManager = outwayManager;
    }

    public void setSuperviseReplyManager(
            SuperviseReplyManager superviseReplyManager) {
        this.superviseReplyManager = superviseReplyManager;
    }

    public void setSuperviseResultManager(
            SuperviseResultManager superviseResultManager) {
        this.superviseResultManager = superviseResultManager;
    }

    public String getIsworkflowFlag() {
        return isworkflowFlag;
    }

    public void setIsworkflowFlag(String isworkflowFlag) {
        this.isworkflowFlag = isworkflowFlag;
    }

    public String listMonitorOperator() {

        return "page/supevise/selectMonitorOperator.jsp";
    }

    /**
     * 层级监察督查督办 结论、查询
     * @return
     */
    public String listTJ() {
        try {
            FUserDetail user = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(user
                    .getUsercode());
            String sParentUnit = dept.getUnitcode();
            String caozuo = request.getParameter("caozuo");
            unitList = sysUnitManager.getAllSubUnits(sParentUnit);
            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            String unitCode = (String) filterMap.get("orgcode");
            if (!StringBaseOpt.isNvl(unitCode)) {
                filterMap.put("monitorOrgId", unitCode);
            }
            if (caozuo != null && caozuo.equals("fankui")) {
                filterMap.put("NP_state", "1");
            }
            if (caozuo != null && caozuo.equals("jielun")) {
                filterMap.put("NP_state1", "1");
                filterMap.put("NP_isExternal", "1");
            }
            if (filterMap.get("queryUnderUnit") != null
                    && !filterMap.get("queryUnderUnit").equals("")
                    && filterMap.get("monitorOrgId") != null
                    && !filterMap.get("monitorOrgId").equals("")) {
                StringBuilder temp = new StringBuilder();
                List<FUnitinfo> templist = sysUnitManager.getSubUnits(unitCode);
                for (FUnitinfo f : templist) {
                    temp.append(",'").append(f.getUnitcode()).append("'");
                }
                filterMap.put("subunit", temp.substring(1));
            }
            List<VSuperviseBasic> vsuperviselist = superviseBasicMag
                    .listVSuperviseBasic(filterMap, pageDesc);
            request.setAttribute("vsuplist", vsuperviselist);
            request.setAttribute("caozuo", caozuo);
            totalRows = pageDesc.getTotalRows();
            return "listtj";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String fankui() {
        viewBizInfo();
        return "fankuiedit";
    }

    public String savefankui() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        String operatorOpinion = request.getParameter("operatorOpinion");
        String supno = request.getParameter("superviseNo");

        // 更改基本信息中的办件状态为办理中
        SuperviseBasic sb = superviseBasicMag.getObjectById(supno);
        sb.setBizType("T");
        superviseBasicMag.saveObject(sb);

        SuperviseReply sr = new SuperviseReply();
        sr.setSuperviseNo(supno);
        sr.setOperatorOpinion(operatorOpinion);
        sr.setProcessDate(new Date(System.currentTimeMillis()));
        sr.setProcessName("督办反馈");

        sr.setOperatorId(user.getUsercode());
        sr.setOperatorName(user.getUserdesc());
        sr.setProcessNo(superviseReplyManager.getNextKey());
        superviseReplyManager.saveObject(sr);
        s_monitorSource = sb.getMonitorSource();
        // request.setAttribute("s_monitorSource", "J");
        request.setAttribute("caozuo", "fankui");
        return "refreshfankui";
    }

    public String jielun() {
        viewBizInfo();
        return "jielunedit";
    }

    public String savejielun() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        String operatorOpinion = request.getParameter("operatorOpinion");
        String isExternal = request.getParameter("isExternal");
        String supno = request.getParameter("superviseNo");
        // 更改基本信息中的办件状态为办结
        SuperviseBasic sb = superviseBasicMag.getObjectById(supno);
        sb.setBizType("C");
        superviseBasicMag.saveObject(sb);
        // 保存一条结论的过程信息
        SuperviseReply sr1 = new SuperviseReply();
        sr1.setSuperviseNo(supno);
        sr1.setOperatorOpinion(operatorOpinion);
        sr1.setProcessDate(new Date(System.currentTimeMillis()));
        sr1.setProcessName("督办结论");

        sr1.setOperatorId(user.getUsercode());
        sr1.setOperatorName(user.getUserdesc());
        sr1.setProcessNo(superviseReplyManager.getNextKey());
        superviseReplyManager.saveObject(sr1);

        // 保存结论的结果信息
        SuperviseResult sr = new SuperviseResult();
        sr.setSuperviseNo(supno);
        sr.setBackOperatorId(user.getUsercode());
        sr.setEndoperatorid(user.getUsercode());
        sr.setBackOperatorName(user.getUsername());
        sr.setEndOpinion(operatorOpinion);
        sr.setIsExternal(Long.parseLong(isExternal));
        // sr.setConfirm(confirm);
        sr.setSuperviseResult(operatorOpinion);
        sr.setEndDate(new Date(System.currentTimeMillis()));

        sr.setNo(superviseResultManager.getNextKeyId());
        superviseResultManager.saveObject(sr);
        s_monitorSource = sb.getMonitorSource();
        // request.setAttribute("s_monitorSource", "J");
        request.setAttribute("caozuo", "jielun");
        return "refreshjielun";
    }
}
