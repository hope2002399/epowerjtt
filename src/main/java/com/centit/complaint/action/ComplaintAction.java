package com.centit.complaint.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.complaint.po.Complaint;
import com.centit.complaint.po.ComplaintsProcess;
import com.centit.complaint.po.ComplaintsResult;
import com.centit.complaint.po.VComplaint;
import com.centit.complaint.service.ComplaintManager;
import com.centit.complaint.service.ComplaintsprocessManager;
import com.centit.complaint.service.ComplaintsresultManager;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VPunish;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.PunishManager;
import com.centit.supervise.po.SuperviseBasic;
import com.centit.support.utils.StringBaseOpt;
import com.centit.support.utils.UuidOpt;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.FunctionManager;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.FlowInstance;

public class ComplaintAction extends EpowerCommonBizAction<Complaint> {

    private static final long serialVersionUID = 1L;
    private ComplaintManager complaintMag;
    private FunctionManager functionManager;
    private ApplyManager applyManager;
    private PunishManager punishManager;
    private String flowCode;
    private ComplaintsProcess complaintsProcess;
    private ComplaintsresultManager complaintsresultManager;

    public void setComplaintsresultManager(
            ComplaintsresultManager complaintsresultManager) {
        this.complaintsresultManager = complaintsresultManager;
    }

    private ComplaintsprocessManager complaintsprocessManager;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private List<FUnitinfo> unitList;
    private String isworkflowFlag;// 是否是工作流标识
    private List<VComplaint> fgList;
    private String unitsJson;
    private String parentUnit;

    public List<VComplaint> getFgList() {
        return fgList;
    }

    public void setFgList(List<VComplaint> fgList) {
        this.fgList = fgList;
    }

    /************************* 以下为投诉登记 ***************************/
    public String edit() {

        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();

        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();// 获取该部门编码的顶层部门信息
        if (StringBaseOpt.isNvl(object.getComplaintid())) {
            object.setComplaintid(complaintMag.getNextkey());
            // 根据登记编号查看信息
        }
        viewBizInfo();
        return EDIT;
    }
    /**
     * 投诉查看
     * @return
     */
    public String listFg() {
        // ActionContext.getContext().put("optIds", complaintMag.getOptList());
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        fgList = complaintMag.listVComplaint(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();

        return "fgList";
    }

    /**
     * 投诉提交并保存，创建流程实例
     */
    public String saveAndSubmit() {
        FOptinfo optInfo = functionManager.getObjectById(object.getOptId());
        if (optInfo != null) {
            flowCode = optInfo.getWfcode();
        }
        if (object.getFlowInstId() == null || "".equals(object.getFlowInstId())) {
            FUserDetail fuser = ((FUserDetail) getLoginUser());

            FlowInstance flowInst = flowEngine.createInstance(flowCode, "投诉登记["
                    + object.getComplaintid() + "]", object.getComplaintid(),
                    fuser.getUsercode(), fuser.getPrimaryUnit());
            long flowInstId = flowInst.getFlowInstId();
            long nodeInstId = flowInst.getFirstNodeInstance().getNodeInstId();

            this.setFlowInstId(flowInstId);
            curNodeInstId = nodeInstId;
            complaintsProcess = new ComplaintsProcess();
            complaintsProcess.setProcessNo(UuidOpt.getUuidAsString());
            complaintsProcess.setNodeInstId(nodeInstId);
            complaintsProcess.setComplaintId(object.getComplaintid());
            complaintsProcess.setProcessCode("tsdj");
            complaintsProcess.setProcessName("投诉登记");
            complaintsProcess.setProcessDate(new Date());
            complaintsProcess.setOperatorId(fuser.getUsercode());
            complaintsProcess.setOperatorName(fuser.getUsername());
            complaintsprocessManager.saveObject(complaintsProcess);

            object.setFlowInstId(flowInstId);
            object.setBiztype("T");
        }
        save();
        return super.nextStep();
    }

    /**
     * 仅保存投诉基本信息
     */
    public String save() {
        if (object.getFlowInstId() == null || "".equals(object.getFlowInstId())) {
            object.setBiztype("F");
        }

        if (StringUtils.isBlank(object.getBjNo())) {
            switch (Integer.parseInt(object.getBjType())) {
            case 1:
                Apply apply = applyManager.getApplyNew(object.getInternalNo(),
                        object.getGraentOrgId());
                object.setBjNo(apply.getNo());
                break;
            default:
                Punish punish = punishManager.getPunishInfo(
                        object.getInternalNo(), object.getGraentOrgId());
                object.setBjNo(punish.getNo());
                break;
            }
        }
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        object.setCreateUser(fuser.getUsercode());
        object.setCreateDate(new Date());
        object.setComplaintsSource("1");
        complaintMag.saveObject(object);

        return super.view();
    }

    /***************************** 以下为投诉办理 ******************************/

    /**
     * 投诉受理
     * 
     * @return
     */
    public String acceptComplaint() {
        object = complaintMag.getObject(object);
        this.initalBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("complaintTasksExecute",
                "submitAcceptComplaint", "saveOpt");
        super.generalOpt();
        return "acceptComplaint";
    }

    /**
     * 审批投诉受理
     * 
     * @return
     */
    public String isAcceptComplaint() {
        object = complaintMag.getObject(object);
        this.initalBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("complaintTasksExecute",
                "submitIsAcceptComplaint", "saveOpt");
        return super.generalOpt();
    }

    private SuperviseBasic superviseBasic;//

    /**
     * 子流程，发起督办，准备督办办件基本信息
     * 
     * @return
     */
    public String fromComplaint() {
        this.initalSupBizInfo();
        return "fromComplaint";
    }

    private void initalSupBizInfo() {
        Complaint complaint = complaintMag.getObjectById(object
                .getComplaintid());
        if (superviseBasic == null) {
            superviseBasic = new SuperviseBasic();
        }
        superviseBasic.setBjType(object.getBjType());
        superviseBasic.setComplaint(complaint);
        //
        if (complaint != null) {
            object = complaint;
        }
        initalBizInfo();
        superviseBasic.setApply(object.getApply());
        superviseBasic.setPunish(object.getPunish());
    }

    /**
     * 调查结论
     * 
     * @return
     */
    public String complaintResult() {
        object = complaintMag.getObject(object);
        this.initalBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("complaintTasksExecute",
                "submitComplaintResult", "saveOpt");
        return super.generalOpt();
    }

    public String complaintBack() {
        object = complaintMag.getObject(object);
        this.initalBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("complaintTasksExecute", "submitComplaintBack",
                "saveOpt");
        return super.generalOpt();
    }

    /**
     * 投诉办理
     * 
     * @return
     */
    public String generCommonTrans() {
        return this.acceptComplaint();
    }

    /**
     * 初始化办件信息
     */
    private void initalBizInfo() {
        // 办件类型 bjType 1：许可 2：处罚
        if ("1".equals(object.getBjType())) {
            Apply apply = null;
            if (StringUtils.isNotBlank(object.getBjNo())) {
                apply = applyManager.getObjectById(object.getBjNo());
            } else {
                apply = applyManager.getApplyInfo(object.getInternalNo(),
                        object.getItemId());
            }
            if (apply == null) {
                apply = new Apply();
            }
            object.setApply(apply);
            object.setGraentOrgId(apply.getOrgId());
        } else if ("2".equals(object.getBjType())) {
            Punish punish = null;
            if (StringUtils.isNotBlank(object.getBjNo())) {
                punish = punishManager.getObjectById(object.getBjNo());
            } else {
                punish = punishManager.getPunishInfo(object.getInternalNo(),
                        object.getGraentOrgId());
            }
            if (punish == null) {
                punish = new Punish();
            }
            object.setPunish(punish);
            object.setGraentOrgId(punish.getOrgId());

        }

    }

    // ======================获取投诉办件和案件===================\\
    private String flag;// ="1";//默认显示为办件类型

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String selectList() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> remap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(remap);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        String unitCode = (String) filterMap.get("unitcode");

        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(unitCode) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("unitcode", null);
        }

        /*
         * if(!StringBaseOpt.isNvl(unitCode)){ String s_orgId =
         * sysUnitManager.getObjectById(unitCode).getDepno();
         * filterMap.put("orgId", s_orgId); } String s_queryUnderUnit =
         * (String)filterMap.get("queryUnderUnit");
         * if("true".equals(s_queryUnderUnit)&&!StringUtils.isBlank(unitCode)){
         * filterMap.put("topunitcode", unitCode); filterMap.put("orgId", null);
         * }
         */
        if (!StringUtils.isBlank((String) filterMap.get("internalNo"))) {
            filterMap.put("internalNo", (String) filterMap.get("internalNo"));
        }
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        if (flag == null) {
            flag = "1";
        }
        if ("1".equals(flag)) {
            // filterMap.put("NP_istrack", true);
            applyList = applyManager.listVApply(filterMap, pageDesc);
            if (applyList != null) {
                totalRows = pageDesc.getTotalRows();
            }
        } else if ("2".equals(flag)) {
            // filterMap.put("NP_istrack", true);
            punishList = punishManager.listVPunish(filterMap, pageDesc);
            if (punishList != null) {
                totalRows = pageDesc.getTotalRows();
            }
        }
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return "selectList";
    }

    /******************************** 以下投诉基本信息相关 ****************************************/

    /**
     * 显示业务信息，用于基础数据信息 1、办件信息：许可办件或者处罚办件 2、投诉信息
     * 
     * @return
     */
    public String viewBizInfo() {
        super.view();
        // 办件案件信息初始化
        this.initalBizInfo();
        return "viewBizInfo";
    }

    @Override
    public String view() {
        isworkflowFlag = CodeRepositoryUtil.getDataPiece("SYSPARAM",
                "ISWORKFLOW").getDatavalue();
        ComplaintsResult result = complaintsresultManager
                .getObjectByComplaintsId(object.getComplaintid());
        request.setAttribute("result", result);
        this.viewBizInfo();
        return VIEW;
    }

    @Override
    public String delete() {
        super.delete();
        return super.list();
    }

    /********************************** 以下为getter、setter ********************/

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    public void setComplaintManager(ComplaintManager basemgr) {
        complaintMag = basemgr;
        this.setBaseEntityManager(complaintMag);
    }

    public void setApplyManager(ApplyManager applyManager) {
        this.applyManager = applyManager;
    }

    public void setPunishManager(PunishManager punishManager) {
        this.punishManager = punishManager;
    }

    public ComplaintsProcess getComplaintsProcess() {
        return complaintsProcess;
    }

    public void setComplaintsProcess(ComplaintsProcess complaintsProcess) {
        this.complaintsProcess = complaintsProcess;
    }

    public void setComplaintsprocessManager(
            ComplaintsprocessManager complaintsprocessManager) {
        this.complaintsprocessManager = complaintsprocessManager;
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

    public SuperviseBasic getSuperviseBasic() {
        return superviseBasic;
    }

    public void setSuperviseBasic(SuperviseBasic superviseBasic) {
        this.superviseBasic = superviseBasic;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public String getIsworkflowFlag() {
        return isworkflowFlag;
    }

    public void setIsworkflowFlag(String isworkflowFlag) {
        this.isworkflowFlag = isworkflowFlag;
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
}
