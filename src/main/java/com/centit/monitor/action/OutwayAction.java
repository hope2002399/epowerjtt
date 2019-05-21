package com.centit.monitor.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.Unit.Constant;
import com.centit.monitor.po.Outway;
import com.centit.monitor.po.OutwayWarnpoint;
import com.centit.monitor.service.OutwayManager;
import com.centit.monitor.service.OutwayWarnpointManager;
import com.centit.supervise.po.SuperviseBasic;
import com.centit.supervise.service.SuperviseBasicManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class OutwayAction extends BaseEntityExtremeAction<Outway> {
    private static final Log log = LogFactory.getLog(OutwayAction.class);
    private static final long serialVersionUID = 1L;
    private OutwayManager outwayMag;
    private SuperviseBasicManager superviseBasicMag;
    private List<FUnitinfo> unitList;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private String warnNos;
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

    public String getWarnNos() {
        return warnNos;
    }

    public void setWarnNos(String warnNos) {
        this.warnNos = warnNos;
    }

    // 查询条件记忆功能应用，后续考虑jquery客户端保存方式
    private String s_orgId;
    private String s_bjType;
    private String s_internalNo;
    private String s_monitorStyle;
    private String s_monitorType;
    private String s_begTime;
    private String s_endTime;
    private String s_queryUnderUnit;

    public String getS_queryUnderUnit() {
        return s_queryUnderUnit;
    }

    public void setS_queryUnderUnit(String s_queryUnderUnit) {
        this.s_queryUnderUnit = s_queryUnderUnit;
    }

    private String s_NP_outWayZC;

    public String getS_NP_outWayZC() {
        return s_NP_outWayZC;
    }

    public void setS_NP_outWayZC(String s_NP_outWayZC) {
        this.s_NP_outWayZC = s_NP_outWayZC;
    }

    public String getS_NP_outWayQX() {
        return s_NP_outWayQX;
    }

    public void setS_NP_outWayQX(String s_NP_outWayQX) {
        this.s_NP_outWayQX = s_NP_outWayQX;
    }

    public void setOutwayMag(OutwayManager outwayMag) {
        this.outwayMag = outwayMag;
    }

    private String s_NP_outWayQX;

    public String getS_internalNo() {
        return s_internalNo;
    }

    public void setS_internalNo(String s_internalNo) {
        this.s_internalNo = s_internalNo;
    }

    public String getS_monitorStyle() {
        return s_monitorStyle;
    }

    public void setS_monitorStyle(String s_monitorStyle) {
        this.s_monitorStyle = s_monitorStyle;
    }

    public String getS_monitorType() {
        return s_monitorType;
    }

    public void setS_monitorType(String s_monitorType) {
        this.s_monitorType = s_monitorType;
    }

    public String getS_begTime() {
        return s_begTime;
    }

    public void setS_begTime(String s_begTime) {
        this.s_begTime = s_begTime;
    }

    public String getS_endTime() {
        return s_endTime;
    }

    public void setS_endTime(String s_endTime) {
        this.s_endTime = s_endTime;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
    }

    public String getS_orgId() {
        return s_orgId;
    }

    public void setS_orgId(String s_orgId) {
        this.s_orgId = s_orgId;
    }

    public String getS_bjType() {
        return s_bjType;
    }

    public void setS_bjType(String s_bjType) {
        this.s_bjType = s_bjType;
    }

    /**
     * 定量分析预报警list
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String DlfxList() {
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
        String monitorSource = (String) filterMap.get("monitorSource");
        if (!StringBaseOpt.isNvl(monitorSource)) {
            object.setMonitorSource(monitorSource);
        } else {
            filterMap.put("monitorSource", "C");
        }
        objList = outwayMag.getOutWayList(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        unitList = sysUnitManager.getAllSubUnits(dept.getUnitcode());// 获取该部门下面的全部部门信息
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();// 获取该部门编码的顶层部门信息
        return "DlfxList";
    }

    /**
     * 定量分析保存摘牌信息
     * 
     * @return
     */
    public String DlfxSave() {
        if (this.warnNos.isEmpty()) {
            Outway dbObject = outwayMag.getObject(object);
            return this.saveSingleDlfx(dbObject);
        } else {
            return this.saveMoreDlfx();
        }
    }

    /**
     * 定量分析进入摘牌页面
     * 
     * @return
     */
    public String DlfxEdit() {
        object = outwayMag.getObjectById(object.getOutwayno());
        super.edit();
        return "DlfxEdit";
    }

    /**
     * //单个定量分析预报警摘牌保存
     * 
     * @param dbObject
     * @return
     */
    public String saveSingleDlfx(Outway dbObject) {
        try {
            if (dbObject != null) {
                baseEntityManager.copyObjectNotNullProperty(dbObject, object);
                object = dbObject;
            }
            FUserDetail user = ((FUserDetail) getLoginUser());
            object.setOutperson(user.getUsercode());
            object.setOuttime(new Date());
            // 取消预报警标志
            object.setOutWayState("0");
            outwayMag.saveObject(object);
            savedMessage();
            return this.DlfxList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    /**
     * //批量定量分析预报警摘牌保存
     * 
     * @return
     */
    public String saveMoreDlfx() {
        try {
            Outway dbObject = new Outway();
            String[] warnNoList = null;
            FUserDetail user = ((FUserDetail) getLoginUser());
            if (!this.warnNos.isEmpty()) {
                warnNoList = warnNos.split(",");
                dbObject.setOutperson(user.getUsercode());
                dbObject.setOuttime(new Date());
                // 取消预报警标志
                dbObject.setOutWayState("0");
                dbObject.setOutreason(object.getOutreason());
            }
            if (null != warnNoList) {
                this.outwayMag.updateMore(dbObject, warnNoList);
            }
            return this.DlfxList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    private OutwayWarnpointManager outwayWarnpointManager;

    public void setOutwayWarnpointManager(
            OutwayWarnpointManager outwayWarnpointManager) {
        this.outwayWarnpointManager = outwayWarnpointManager;
    }

    private String unitList2JSON(List<OutwayWarnpoint> owlist) {

        if (owlist == null) {
            return "";
        }

        JSONArray jsonArr = new JSONArray();
        for (OutwayWarnpoint ow : owlist) {

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("wpTypeNo", ow.getWpTypeNo());// 类型编号
            jsonObj.put("wpNo", ow.getWpNo());// 异常编码
            jsonObj.put("wpName", ow.getWpName());// 异常名称
            jsonArr.add(jsonObj);
        }
        return jsonArr.toString();
    }
    /**
     * 已消除预报警
     */
    @SuppressWarnings("unchecked")
    public String list() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        String orderField = request.getParameter("orderField");
        String orderDirection = request.getParameter("orderDirection");
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        if (!StringUtils.isBlank(orderField)
                && !StringUtils.isBlank(orderDirection)) {
            filterMap.put(CodeBook.SELF_ORDER_BY, orderField + " "
                    + orderDirection);
        }
        filterMap.put("topunitcode", sParentUnit);
        String unitCode = (String) filterMap.get("orgId");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(unitCode) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", sysUnitManager.getUnitCode(unitCode));
            filterMap.put("orgId", null);
        }
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        objList = outwayMag.getOutWayList(filterMap, pageDesc);
        Outway outway;
        for (int i = 0; i < objList.size(); i++) {
            // 预警对象类型为督办或预警时，查出该预警对应的预警对应的办件类别 bjType2
            outway = objList.get(i);
            if (outway.getBjType().equals(Constant.BjType_YJ)) {
                Outway sourceOutway = outwayMag.getObjectById(objList.get(i)
                        .getBjNo());
                objList.get(i).setBjType2(sourceOutway.getBjType());
            }
            if (outway.getBjType().equals(Constant.BjType_DB)) {
                SuperviseBasic sup = superviseBasicMag.getObjectById(objList
                        .get(i).getBjNo());
                Outway sourceOutway = outwayMag
                        .getObjectById(sup.getOutwayid());
                if (sourceOutway != null)
                    objList.get(i).setBjType2(sourceOutway.getBjType());
            }
        }
        totalRows = pageDesc.getTotalRows();
        this.pageDesc = pageDesc;
        List<OutwayWarnpoint> owlist = outwayWarnpointManager.listObjects();
        request.setAttribute("owlist", unitList2JSON(owlist));
        return LIST;
    }

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    @Override
    public String save() {
        if (this.warnNos.isEmpty()) {
            Outway dbObject = outwayMag.getObject(object);
            return this.saveSingle(dbObject);
        } else
            return this.saveMore();
    }

    // 单个预报警摘牌保存
    public String saveSingle(Outway dbObject) {
        try {
            if (dbObject != null) {
                baseEntityManager.copyObjectNotNullProperty(dbObject, object);
                object = dbObject;
            }
            FUserDetail user = ((FUserDetail) getLoginUser());
            object.setOutperson(user.getUsercode());
            object.setOuttime(new Date());
            // 取消预报警标志
            object.setOutWayState("0");
            outwayMag.saveObject(object);
            savedMessage();
            return this.list();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    // 批量预报警摘牌保存
    public String saveMore() {
        try {
            Outway dbObject = new Outway();
            String[] warnNoList = null;
            FUserDetail user = ((FUserDetail) getLoginUser());
            if (!this.warnNos.isEmpty()) {
                warnNoList = warnNos.split(",");
                dbObject.setOutperson(user.getUsercode());
                dbObject.setOuttime(new Date());
                // 取消预报警标志
                dbObject.setOutWayState("0");
                dbObject.setOutreason(object.getOutreason());
            }
            if (null != warnNoList) {
                this.outwayMag.updateMore(dbObject, warnNoList);
            }
            return this.list();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    // 批量预报警摘牌保存
    public void savePL() {
        try {
            Outway dbObject = new Outway();
            String[] warnNoList = null;
            FUserDetail user = ((FUserDetail) getLoginUser());
            if (!this.warnNos.isEmpty()) {
                warnNoList = warnNos.split(",");
                dbObject.setOutperson(user.getUsercode());
                dbObject.setOuttime(new Date());
                // 取消预报警标志
                dbObject.setOutWayState("0");
                dbObject.setOutreason(object.getOutreason());
            }
            if (null != warnNoList) {
                this.outwayMag.updateMore(dbObject, warnNoList);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }
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

    public void setSuperviseBasicMag(SuperviseBasicManager superviseBasicMag) {
        this.superviseBasicMag = superviseBasicMag;
    }

    public void setOutwayManager(OutwayManager basemgr) {
        outwayMag = basemgr;
        this.setBaseEntityManager(outwayMag);
    }

    public String editPLZP() {
        object.setOutreason("");
        return EDIT;
    }

    @Override
    public String edit() {
        this.setS_bjType(this.s_bjType);
        object = outwayMag.getObjectById(object.getOutwayno());
        return super.edit();
    }

    @Override
    public String view() {
        super.view();
        if (Constant.BjType_YJ.equals(object.getBjType())) {
            Outway outway = outwayMag.getObjectById(object.getBjNo());
            object.setBjType2(outway.getBjType());
        }
        return VIEW;
    }

}
