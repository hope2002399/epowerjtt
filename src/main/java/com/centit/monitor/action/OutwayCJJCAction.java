package com.centit.monitor.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.OutwayCJJC;
import com.centit.monitor.service.OutwayCJJCManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class OutwayCJJCAction extends BaseEntityExtremeAction<OutwayCJJC> {
    private static final Log log = LogFactory.getLog(OutwayCJJCAction.class);
    private static final long serialVersionUID = 1L;
    private OutwayCJJCManager outwayCJJCMag;
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

    public void setOutwayMag(OutwayCJJCManager outwayCJJCMag) {
        this.outwayCJJCMag = outwayCJJCMag;
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

    @Override
    public String list() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        @SuppressWarnings("unchecked")
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
        String unitCode = (String) filterMap.get("orgId");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(unitCode) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topunitcode", sysUnitManager.getUnitCode(unitCode));
            filterMap.put("orgId", null);
        }
        PageDesc pageDesc = makePageDesc();
        objList = outwayCJJCMag.getOutWayCJJCList(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        this.pageDesc = pageDesc;
        return LIST;
    }

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    @Override
    public String save() {
        if (this.warnNos.isEmpty()) {
            OutwayCJJC dbObject = outwayCJJCMag.getObject(object);
            return this.saveSingle(dbObject);
        } else
            return this.saveMore();
    }

    // 单个预报警摘牌保存
    public String saveSingle(OutwayCJJC dbObject) {
        try {
            if (dbObject != null) {
                baseEntityManager.copyObjectNotNullProperty(dbObject, object);
                object = dbObject;
            }
            FUserDetail user = ((FUserDetail) getLoginUser());
            object.setOutperson(user.getUsercode());
            object.setOuttime(new Date());
            outwayCJJCMag.saveObject(object);
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
            OutwayCJJC dbObject = new OutwayCJJC();
            String[] warnNoList = null;
            FUserDetail user = ((FUserDetail) getLoginUser());
            if (!this.warnNos.isEmpty()) {
                warnNoList = warnNos.split(",");
                dbObject.setOutperson(user.getUsercode());
                dbObject.setOuttime(new Date());
                dbObject.setOutreason(object.getOutreason());
            }
            if (null != warnNoList) {
                this.outwayCJJCMag.updateMore(dbObject, warnNoList);
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
            OutwayCJJC dbObject = new OutwayCJJC();
            String[] warnNoList = null;
            FUserDetail user = ((FUserDetail) getLoginUser());
            if (!this.warnNos.isEmpty()) {
                warnNoList = warnNos.split(",");
                dbObject.setOutperson(user.getUsercode());
                dbObject.setOuttime(new Date());
                dbObject.setOutreason(object.getOutreason());
            }
            if (null != warnNoList) {
                this.outwayCJJCMag.updateMore(dbObject, warnNoList);
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

    public void setOutwayCJJCManager(OutwayCJJCManager basemgr) {
        outwayCJJCMag = basemgr;
        this.setBaseEntityManager(outwayCJJCMag);
    }

    public String editPLZP() {
        object.setOutreason("");
        return EDIT;
    }

    @Override
    public String edit() {
        this.setS_bjType(this.s_bjType);
        return super.edit();
    }
}
