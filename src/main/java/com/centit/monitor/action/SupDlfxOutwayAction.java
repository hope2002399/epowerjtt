package com.centit.monitor.action;

import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.SupDlfxOutway;
import com.centit.monitor.service.SupDlfxOutwayManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

/**
 * 
 * TODO Class description should be added
 * 
 * @author zjh
 * @create 2013-12-17
 * @version
 */
public class SupDlfxOutwayAction extends BaseEntityExtremeAction<SupDlfxOutway> {
    private static final long serialVersionUID = 1L;
    // 需要在string-action.xml配置的属性
    private SupDlfxOutwayManager supDlfxOutwayManager;
    private SysUnitManager sysUnitManager;
    private SysUserManager sysUserManager;
    // 普通变量
    private List<SupDlfxOutway> jlList;// 督办结论
    private List<SupDlfxOutway> cxList;// 督办查询
    private List<SupDlfxOutway> fkList;// 督办反馈
    private List<SupDlfxOutway> infoList;// 该部门下该月所有的报警信息
    private List<SupDlfxOutway> ybjList;// 预报警查询，督办发起
    private String unitsJson;// 部门（机构）json形式的,在页面上会用到
    private String parentUnit;// 在页面上会用到，该用户拥有的顶层部门编码
    private List<FUnitinfo> unitList;// 这个作用实际上不大了，因为页面不使用list形式下来

    // 定量分析查询
    @SuppressWarnings("unchecked")
    public String list() {
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
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(orgId) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", sysUnitManager.getUnitCode(orgId));
            filterMap.put("orgId", null);
        } else {
            filterMap.put("topunitcode", sParentUnit);
        }
        ybjList = supDlfxOutwayManager.getSupDlfxOutWayManager(filterMap,
                pageDesc);
        totalRows = pageDesc.getTotalRows();
        unitList = sysUnitManager.getAllSubUnits(dept.getUnitcode());// 获取该部门下面的全部部门信息
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();// 获取该部门编码的顶层部门信息
        return LIST;
    }

    // 修改定量分析预报警信息表对应的字段信息
    public String updateSupDlfxInfo() {
        object.setSupervisionType("2");// 督办中
        supDlfxOutwayManager.UpdateSupDlfxOutwayInfo(object);
        return "forList";
    }

    // 修改定量分析预报警信息表对应的字段信息
    public String updateSupDlfxInfoFk() {
        object.setSupervisionType("3");// 督办中
        supDlfxOutwayManager.UpdateSupDlfxOutwayInfo(object);
        return "fkForList";
    }

    // 修改定量分析预报警信息表对应的字段信息
    public String updateSupDlfxInfoJl() {
        object.setSupervisionType("4");// 督办中
        supDlfxOutwayManager.UpdateSupDlfxOutwayInfo(object);
        return "jlForList";
    }

    // spring-action配置的属性set及get方法
    public void setSupDlfxOutwayManager(SupDlfxOutwayManager basemgr) {
        supDlfxOutwayManager = basemgr;
        this.setBaseEntityManager(supDlfxOutwayManager);
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    // 变量对应的set方法及get方法
    public List<SupDlfxOutway> getJlList() {
        return jlList;
    }

    public void setJlList(List<SupDlfxOutway> jlList) {
        this.jlList = jlList;
    }

    public List<SupDlfxOutway> getCxList() {
        return cxList;
    }

    public void setCxList(List<SupDlfxOutway> cxList) {
        this.cxList = cxList;
    }

    public List<SupDlfxOutway> getFkList() {
        return fkList;
    }

    public void setFkList(List<SupDlfxOutway> fkList) {
        this.fkList = fkList;
    }

    public List<SupDlfxOutway> getYbjList() {
        return ybjList;
    }

    public void setYbjList(List<SupDlfxOutway> ybjList) {
        this.ybjList = ybjList;
    }

    public String getParentUnit() {
        return parentUnit;
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    public void setParentUnit(String parentUnit) {
        this.parentUnit = parentUnit;
    }

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public List<SupDlfxOutway> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<SupDlfxOutway> infoList) {
        this.infoList = infoList;
    }

}
