package com.centit.supervise.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.complaint.action.EpowerCommonBizAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.SupDlfxOutway;
import com.centit.supervise.po.SupInfoBasicDlfx;
import com.centit.supervise.service.SupInfoBasicDlfxManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class SupInfoBasicDlfxAction extends
        EpowerCommonBizAction<SupInfoBasicDlfx> {
    private static final long serialVersionUID = 1L;
    // spring-action中配置
    private SupInfoBasicDlfxManager supInfoBasicDlfxManager;
    private SysUnitManager sysUnitManager;
    private SysUserManager sysUserManager;
    // 变量
    private String unitsJson;
    private String parentUnit;
    private List<SupDlfxOutway> infoList;// 预报警信息
    private List<SupInfoBasicDlfx> basicList;// 督办信息
    private List<FUserinfo> userlist;
    private List<FUnitinfo> unitList;
    private SupInfoBasicDlfx supInfo;
    private SupInfoBasicDlfx supProcess;
    private SupInfoBasicDlfx supResult;

    // 查看预报警信息并可以发起督办
    @SuppressWarnings("unchecked")
    public String supDlfxInfo() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        object.setOrgId((String) filterMap.get("orgId"));
        object.setSupervisionMonth((String) filterMap.get("month"));
        object.setSupervisionYear((String) filterMap.get("year"));
        object.setNo((String) filterMap.get("outwayId"));
        filterMap.put("supervisionMonth", (String) filterMap.get("month"));
        filterMap.put("supervisionYear", (String) filterMap.get("year"));
        filterMap.put("no", (String) filterMap.get("outwayId"));
        basicList = supInfoBasicDlfxManager.getSupInfoBasicDlfxList(filterMap,
                pageDesc);
        if (basicList != null && basicList.size() > 0) {
            supInfo = (SupInfoBasicDlfx) basicList.get(0);
        }
        infoList = supInfoBasicDlfxManager.getSupDlfxOutWayManager(filterMap,
                pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "supDlfxInfo";
    }

    // 查看预报警信息并可以发起督办
    @SuppressWarnings("unchecked")
    public String supDlfxFk() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        object.setOrgId((String) filterMap.get("orgId"));
        infoList = supInfoBasicDlfxManager.getSupDlfxOutWayManager(filterMap,
                pageDesc);
        basicList = supInfoBasicDlfxManager.getSupInfoBasicDlfxList(filterMap,
                pageDesc);
        if (basicList != null && basicList.size() > 0) {
            supInfo = (SupInfoBasicDlfx) basicList.get(0);
        }
        totalRows = pageDesc.getTotalRows();
        return "supDlfxFk";
    }

    // 督办结论查看详细信息
    @SuppressWarnings("unchecked")
    public String supDlfxJl() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        object.setOrgId((String) filterMap.get("orgId"));
        infoList = supInfoBasicDlfxManager.getSupDlfxOutWayManager(filterMap,
                pageDesc);
        basicList = supInfoBasicDlfxManager.getSupInfoBasicDlfxList(filterMap,
                pageDesc);
        if (basicList != null && basicList.size() > 0) {
            supInfo = (SupInfoBasicDlfx) basicList.get(0);
        }
        totalRows = pageDesc.getTotalRows();
        return "supDlfxJl";
    }

    // 督办结论查看详细信息
    @SuppressWarnings("unchecked")
    public String supDlfxCx() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        object.setOrgId((String) filterMap.get("orgId"));
        infoList = supInfoBasicDlfxManager.getSupDlfxOutWayManager(filterMap,
                pageDesc);
        basicList = supInfoBasicDlfxManager.getSupInfoBasicDlfxList(filterMap,
                pageDesc);
        if (basicList != null && basicList.size() > 0) {
            supInfo = (SupInfoBasicDlfx) basicList.get(0);
        }
        totalRows = pageDesc.getTotalRows();
        return "supDlfxCx";
    }

    /**
     * 保存督办基本信息
     */
    public String saveSupervise() {
        if (StringUtils.isBlank(object.getSuperviseCode())) {
            object.setSuperviseCode(this.supInfoBasicDlfxManager.getNextkey());
        }
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        object.setOperatorId(fuser.getUsercode());
        object.setSuperDate(new Date());
        object.setDealStep("2");// 督办已经发起，等待经办人反馈
        // 备注说明：此处不计入发起督办时间，需要领导审核同意督办意见后在计入；
        /*
         * if(StringUtils.isNotBlank(object.getMonitorOperatorId())&&StringUtils.
         * isBlank(object.getMonitorOperatorName())){
         * 
         * Map<String,Object> filtermap=new HashMap<String,Object>();
         * filtermap.put("LOGINNAME",object.getMonitorOperatorId());
         * List<FUserinfo> userlist= this.sysUserManager.listObjects(filtermap);
         * object.setMonitorOperatorName(userlist.get(0).getUsername()); }
         */
        this.supInfoBasicDlfxManager.saveObject(object);
        return "backSupDlfxOutway";
    }

    /**
     * 保存督办反馈信息
     */
    @SuppressWarnings("unused")
    public String saveSuperviseFk() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        object.setBackOperatorName((fuser.getUsername()));
        object.setReceiptDate(new Date());
        object.setSuperviseBack(object.getSuperviseBack());
        object.setDealStep("3");// 督办发起
        // object.setIsExternal(object.getIsExternal());
        SupInfoBasicDlfx info = new SupInfoBasicDlfx();
        this.supInfoBasicDlfxManager.UpdateSupInfoBasicDlfxFk(object);
        return "SupDlfxOutwayFk";
    }

    /**
     * 保存督办结论信息
     */
    public String saveSuperviseJl() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        object.setEndOperatorId(fuser.getUsercode());
        object.setEndDate(new Date());
        object.setSuperviseResult(object.getSuperviseResult());
        object.setDealStep("4");// 督办结束
        object.setIsExternal(object.getIsExternal());
        SupInfoBasicDlfx info = new SupInfoBasicDlfx();
        supInfoBasicDlfxManager.copyObjectNotNullProperty(object, info);
        this.supInfoBasicDlfxManager.UpdateSupInfoBasicDlfxJl(object);
        return "SupDlfxOutwayJl";
    }

    // 定量反馈
    @SuppressWarnings("unchecked")
    public String fkList() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());// 获取用户基本信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser.getUsercode());// 获取用户所属机构信息
        Map<Object, Object> paramMap = request.getParameterMap();// 获取页面查询字段信息
        resetPageParam(paramMap);// ecTable 中分分页参数提交时出现的数组的问题
        Map<String, Object> filterMap = convertSearchColumn(paramMap);// 将查询搜索前缀
                                                                      // SEARCH_STRING_PREFIX
                                                                      // (s:)去除
                                                                      // 不含这个前缀的属性将被过滤
        Limit limit = ExtremeTableUtils.getLimit(request);// ServletRequestAware
                                                          // 接口会自动给这个变量赋值
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String sParentUnit = dept.getUnitcode();
        String orgId = (String) filterMap.get("orgId");
        String dealStep = (String) filterMap.get("dealStep");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(orgId) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", sysUnitManager.getUnitCode(orgId));
            filterMap.put("orgId", null);
        } else {
            filterMap.put("topunitcode", sParentUnit);
        }
        if (StringUtils.isBlank(dealStep)) {
            filterMap.put("dealStep", "2");// 等待反馈
        }
        basicList = supInfoBasicDlfxManager.getSupInfoBasicDlfxList(filterMap,
                pageDesc);
        totalRows = pageDesc.getTotalRows();
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();// 获取该部门编码的顶层部门信息
        return "fkList";
    }

    // 定量反馈
    @SuppressWarnings("unchecked")
    public String jlList() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());// 获取用户基本信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser.getUsercode());// 获取用户所属机构信息
        Map<Object, Object> paramMap = request.getParameterMap();// 获取页面查询字段信息
        resetPageParam(paramMap);// ecTable 中分分页参数提交时出现的数组的问题
        Map<String, Object> filterMap = convertSearchColumn(paramMap);// 将查询搜索前缀
                                                                      // SEARCH_STRING_PREFIX
                                                                      // (s:)去除
                                                                      // 不含这个前缀的属性将被过滤
        Limit limit = ExtremeTableUtils.getLimit(request);// ServletRequestAware
                                                          // 接口会自动给这个变量赋值
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String sParentUnit = dept.getUnitcode();
        String orgId = (String) filterMap.get("orgId");
        String dealStep = (String) filterMap.get("dealStep");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(orgId) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", sysUnitManager.getUnitCode(orgId));
            filterMap.put("orgId", null);
        } else {
            filterMap.put("topunitcode", sParentUnit);
        }
        if (StringUtils.isBlank(dealStep)) {
            filterMap.put("dealStep", "3");// 等待反馈
        }
        basicList = supInfoBasicDlfxManager.getSupInfoBasicDlfxList(filterMap,
                pageDesc);
        totalRows = pageDesc.getTotalRows();
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();// 获取该部门编码的顶层部门信息
        return "jlList";
    }

    // 定量反馈
    @SuppressWarnings("unchecked")
    public String cxList() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());// 获取用户基本信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser.getUsercode());// 获取用户所属机构信息
        Map<Object, Object> paramMap = request.getParameterMap();// 获取页面查询字段信息
        resetPageParam(paramMap);// ecTable 中分分页参数提交时出现的数组的问题
        Map<String, Object> filterMap = convertSearchColumn(paramMap);// 将查询搜索前缀
                                                                      // SEARCH_STRING_PREFIX
                                                                      // (s:)去除
                                                                      // 不含这个前缀的属性将被过滤
        Limit limit = ExtremeTableUtils.getLimit(request);// ServletRequestAware
                                                          // 接口会自动给这个变量赋值
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String sParentUnit = dept.getUnitcode();
        String orgId = (String) filterMap.get("orgId");
        // String dealStep=(String)filterMap.get("dealStep");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(orgId) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", sysUnitManager.getUnitCode(orgId));
            filterMap.put("orgId", null);
        } else {
            filterMap.put("topunitcode", sParentUnit);
        }
        /*
         * if(StringUtils.isBlank(dealStep)){ filterMap.put("dealStep",
         * "1");//等待反馈 }
         */
        basicList = supInfoBasicDlfxManager.getSupInfoBasicDlfxList(filterMap,
                pageDesc);
        totalRows = pageDesc.getTotalRows();
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();// 获取该部门编码的顶层部门信息
        return "cxList";
    }

    public List<FUserinfo> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<FUserinfo> userlist) {
        this.userlist = userlist;
    }

    public void setSupInfoBasicDlfxManager(SupInfoBasicDlfxManager basemgr) {
        supInfoBasicDlfxManager = basemgr;
        this.setBaseEntityManager(supInfoBasicDlfxManager);
    }

    public List<SupDlfxOutway> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<SupDlfxOutway> infoList) {
        this.infoList = infoList;
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

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public List<SupInfoBasicDlfx> getBasicList() {
        return basicList;
    }

    public void setBasicList(List<SupInfoBasicDlfx> basicList) {
        this.basicList = basicList;
    }

    public SupInfoBasicDlfx getSupInfo() {
        return supInfo;
    }

    public void setSupInfo(SupInfoBasicDlfx supInfo) {
        this.supInfo = supInfo;
    }

    public SupInfoBasicDlfx getSupProcess() {
        return supProcess;
    }

    public void setSupProcess(SupInfoBasicDlfx supProcess) {
        this.supProcess = supProcess;
    }

    public SupInfoBasicDlfx getSupResult() {
        return supResult;
    }

    public void setSupResult(SupInfoBasicDlfx supResult) {
        this.supResult = supResult;
    }
}
