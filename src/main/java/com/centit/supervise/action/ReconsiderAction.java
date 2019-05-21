package com.centit.supervise.action;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.complaint.action.EpowerCommonBizAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VApplyForList;
import com.centit.monitor.po.VPunish;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.ApplyResultManager;
import com.centit.monitor.service.PunishManager;
import com.centit.monitor.service.PunishResultManager;
import com.centit.supervise.po.Reconsider;
import com.centit.supervise.po.Reconsiderprocess;
import com.centit.supervise.service.ReconsiderManager;
import com.centit.supervise.service.ReconsiderprocessManager;
import com.centit.support.utils.UuidOpt;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.FunctionManager;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.FlowInstance;

public class ReconsiderAction extends EpowerCommonBizAction<Reconsider> {
    private static final long serialVersionUID = 1L;
    private ReconsiderManager reconsiderMag;
    private ReconsiderprocessManager reconsiderprocessManager;

    private ApplyManager applyManager;
    private PunishManager punishManager;
    @SuppressWarnings("unused")
    private ApplyResultManager applyresultManager;
    @SuppressWarnings("unused")
    private PunishResultManager punishresultManager;
    private FunctionManager functionManager;
    private SysUnitManager sysUnitManager;
    private SysUserManager sysUserManager;
    private List<FUnitinfo> unitList;
    private String flowCode;
    private List<Apply> applylist;
    private List<VApplyForList> vapplyforList;

    public List<VApply> getApplyresultlist() {
        return applyresultlist;
    }

    public void setApplyresultlist(List<VApply> applyresultlist) {
        this.applyresultlist = applyresultlist;
    }

    public List<VPunish> getPunishresultlist() {
        return punishresultlist;
    }

    public void setPunishresultlist(List<VPunish> punishresultlist) {
        this.punishresultlist = punishresultlist;
    }

    private List<Punish> punishlist;
    private List<VApply> applyresultlist;
    private List<VPunish> punishresultlist;
    private String unitsJson;
    private String parentunit;

    /**
     * 行政复议登记
     * 
     * @return
     */
    public String edit() {
        super.view();
        if (StringUtils.isBlank(object.getReconsiderid())) {
            object.setReconsiderid(reconsiderMag.getNextkey());
        }
        // 根据登记编号查看信息
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        setUnitsJson(sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode()));
        setParentunit(sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit());
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        this.initalBizInfo();
        return EDIT;
    }

    @SuppressWarnings("unchecked")
    public String listsup() {
        FUserDetail fuser = (FUserDetail) getLoginUser();
        FUserunit funit = sysUserManager
                .getUserPrimaryUnit(fuser.getUsercode());
        String sParentUnit = funit.getUnitcode();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();
        dt.setTime(System.currentTimeMillis());
        String date = formatter.format(dt);
        String datelimit = AddDate(date, -7);
        if (StringUtils.isBlank(object.getSuptype())) {
            object.setSuptype("apply");
        } else {
            if ((object.getSuptype()).indexOf(",") != -1) {
                object.setSuptype(object.getSuptype().split(",")[0]);
            }
        }
        if ("apply".equals(object.getSuptype())) {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            if (filterMap.get("begFinishTime") == null
                    && filterMap.get("endFinishTime") == null) {
                filterMap.put("begFinishTime", datelimit);
            }
            filterMap.put("topunitcode", sParentUnit);
            filterMap.put("NP_result", "1");
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            vapplyforList = applyManager.listVApplyForList(filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();
        } else if ("punish".equals(object.getSuptype())) {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // filterMap.put("userCode", userCode);
            if (filterMap.get("begFinishTime") == null
                    && filterMap.get("endFinishTime") == null) {
                filterMap.put("begFinishTime", datelimit);
            }
            filterMap.put("topunitcode", sParentUnit);
            filterMap.put("NP_result", "1");
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            punishresultlist = this.punishManager.listVPunish(filterMap,
                    pageDesc);
            totalRows = pageDesc.getTotalRows();
        }
        return "listsup";
    }

    @SuppressWarnings("unchecked")
    public String listFy() {
        FUserDetail fuser = (FUserDetail) getLoginUser();
        FUserunit funit = sysUserManager
                .getUserPrimaryUnit(fuser.getUsercode());
        String sParentUnit = funit.getUnitcode();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();
        dt.setTime(System.currentTimeMillis());
        String date = formatter.format(dt);
        String datelimit = AddDate(date, -7);
        if (StringUtils.isBlank(object.getSuptype())) {
            object.setSuptype("apply");
        } else {
            if ((object.getSuptype()).indexOf(",") != -1) {
                object.setSuptype(object.getSuptype().split(",")[0]);
            }
        }
        if ("apply".equals(object.getSuptype())) {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            if (filterMap.get("begFinishTime") == null
                    && filterMap.get("begFinishTime") == null) {
                filterMap.put("begFinishTime", datelimit);
            }
            filterMap.put("topunitcode", sParentUnit);
            filterMap.put("NP_result", "1");
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            applyresultlist = applyManager.listVApply(filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();
        } else if ("punish".equals(object.getSuptype())) {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // filterMap.put("userCode", userCode);
            if (filterMap.get("begFinishTime") == null
                    && filterMap.get("endFinishTime") == null) {
                filterMap.put("begFinishTime", datelimit);
            }
            filterMap.put("topunitcode", sParentUnit);
            filterMap.put("NP_result", "1");
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            punishresultlist = this.punishManager.listVPunish(filterMap,
                    pageDesc);
            totalRows = pageDesc.getTotalRows();
        }
        return "listsup";
    }

    public static String AddDate(String datebegin, int LaterTime) { // 函数返回:加上一个int值的日期
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            ParsePosition pos = new ParsePosition(0);
            String addDate = null;
            Date dt2 = new Date();
            Date dt1 = formatter.parse(datebegin, pos);
            dt2.setTime(dt1.getTime() + LaterTime * 86400000);
            addDate = formatter.format(dt2);
            return addDate;
        } catch (Exception e) {
            System.out.println("无法计算.AddDate函数出错。" + e.getMessage());
            return null;
        }
    }

    /**
     * 复议提交并保存，创建流程实例
     */
    public String saveAndSubmit() {
        FOptinfo optInfo = functionManager.getObjectById(object.getOptId());
        if (optInfo != null) {
            flowCode = optInfo.getWfcode();
        }
        if (object.getFlowInstId() == null || "".equals(object.getFlowInstId())) {
            FUserDetail fuser = ((FUserDetail) getLoginUser());

            FlowInstance flowInst = flowEngine.createInstance(flowCode,
                    "行政复议登记[" + object.getReconsiderid() + "]",
                    object.getReconsiderid(), fuser.getUsercode(),
                    fuser.getPrimaryUnit());
            long flowInstId = flowInst.getFlowInstId();
            long nodeInstId = flowInst.getFirstNodeInstance().getNodeInstId();

            this.setFlowInstId(flowInstId);
            curNodeInstId = nodeInstId;
            Reconsiderprocess proc = new Reconsiderprocess();
            proc.setProcessno(UuidOpt.getUuidAsString());
            proc.setNodeInstId(nodeInstId);
            proc.setReconsiderId(object.getReconsiderid());
            proc.setProcessCode("xzfydj");
            proc.setProcessName("行政复议登记");
            proc.setProcessDate(new Date());
            proc.setOperatorId(fuser.getUsercode());
            proc.setOperatorName(fuser.getUsername());
            proc.setOperatorOpinion("行政复议登记");
            reconsiderprocessManager.saveObject(proc);

            object.setFlowInstId(flowInstId);
            object.setBiztype("T");
        }
        save();
        return super.nextStep();
    }

    /**
     * 保存行政复议基本信息
     */
    public String save() {
        if (object.getFlowInstId() == null || "".equals(object.getFlowInstId())) {
            object.setBiztype("F");
        }

        if (!StringUtils.isBlank(object.getBjNo())) {
            switch (Integer.parseInt(object.getBjType())) {
            case 1:
                Apply apply = applyManager.getObjectById(object.getBjNo());
                object.setBjNo(apply.getNo());
                object.setOrgId(apply.getOrgId());
                break;
            default:
                Punish punish = punishManager.getObjectById(object.getBjNo());
                object.setBjNo(punish.getNo());
                object.setOrgId(punish.getOrgId());
                break;
            }
        }
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        object.setBookoperator(fuser.getUsercode());
        object.setBookdate(new Date());

        reconsiderMag.saveObject(object);

        return super.list();
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
        // 文书标签字段
        super.initCommonBizJSON(object);
        return "viewBizInfo";
    }

    /**
     * 复议查看
     * 
     * @return
     */
    public String view() {
        this.viewBizInfo();
        return VIEW;
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

    /**
     * 初始化办件信息
     */
    private void initalBizInfo() {

        if (StringUtils.isNotBlank(object.getBjType())) {
            switch (Integer.parseInt(object.getBjType())) {
            case 1:// XK
                   // VApply vapply = applyManager.getApply(object.getBjNo());
                Apply apply = applyManager.getObjectById(object.getBjNo());
                // object.setVapply(vapply);
                object.setApply(apply);
                break;
            case 2:// CF
                   // VPunish vpunish =
                   // punishManager.getPunish(object.getBjNo());
                Punish punish = punishManager.getObjectById(object.getBjNo());
                // object.setVpunish(vpunish);
                object.setPunish(punish);
                break;
            // 其他...
            }
        }
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
        super.initalGenneralOpt("reconsiderTasksExecute", "submitOpt",
                "saveOpt");
        return super.generalOpt();
    }

    /**
     * 受理审查
     * 
     * @return
     */
    public String acceptReconsider() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("reconsiderTasksExecute",
                "submitAcceptReconsider", "saveOpt");
        return super.generalOpt();
    }

    /**
     * 审理
     * 
     * @return
     */
    public String isAcceptReconsider() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("reconsiderTasksExecute",
                "submitIsAcceptReconsider", "saveOpt");
        return super.generalOpt();
    }

    /**
     * 复议决定
     * 
     * @return
     */
    public String reconsiderResult() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("reconsiderTasksExecute",
                "submitReconsiderResult", "saveOpt");
        return super.generalOpt();
    }

    /**
     * 退回补充材料
     * 
     * @return
     */
    public String backReconsider() {
        this.viewBizInfo();
        // 初始化页面form对应的actionName、提交方法以及保存方法名
        super.initalGenneralOpt("reconsiderTasksExecute",
                "submitBackReconsider", "saveOpt");
        return super.generalOpt();
    }

    /******************* 以下为getter、setter ************************/
    public void setApplyManager(ApplyManager applyManager) {
        this.applyManager = applyManager;
    }

    public void setPunishManager(PunishManager punishManager) {
        this.punishManager = punishManager;
    }

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public List<Punish> getPunishlist() {
        return punishlist;
    }

    public void setPunishlist(List<Punish> punishlist) {
        this.punishlist = punishlist;
    }

    public ApplyManager getApplyManager() {
        return applyManager;
    }

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public void setReconsiderManager(ReconsiderManager basemgr) {
        reconsiderMag = basemgr;
        this.setBaseEntityManager(reconsiderMag);
    }

    public void setReconsiderprocessManager(
            ReconsiderprocessManager reconsiderprocessManager) {
        this.reconsiderprocessManager = reconsiderprocessManager;
    }

    public List<Apply> getApplylist() {
        return applylist;
    }

    public void setApplylist(List<Apply> applylist) {
        this.applylist = applylist;
    }

    public void setApplyresultManager(ApplyResultManager applyresultManager) {
        this.applyresultManager = applyresultManager;
    }

    public void setPunishresultManager(PunishResultManager punishresultManager) {
        this.punishresultManager = punishresultManager;
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

    public List<VApplyForList> getVapplyforList() {
        return vapplyforList;
    }

    public void setVapplyforList(List<VApplyForList> vapplyforList) {
        this.vapplyforList = vapplyforList;
    }
}
