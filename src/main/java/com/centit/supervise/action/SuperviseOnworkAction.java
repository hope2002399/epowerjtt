package com.centit.supervise.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.supervise.po.SuperviseBasic;
import com.centit.supervise.po.SuperviseOnwork;
import com.centit.supervise.po.SuperviseResult;
import com.centit.supervise.service.SuperviseBasicManager;
import com.centit.supervise.service.SuperviseOnworkManager;
import com.centit.supervise.service.SuperviseResultManager;
import com.centit.support.utils.UuidOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class SuperviseOnworkAction extends
        BaseEntityExtremeAction<SuperviseOnwork> {
    private static final Log log = LogFactory
            .getLog(SuperviseOnworkAction.class);
    private static final long serialVersionUID = 1L;
    private SuperviseOnworkManager superviseOnworkMag;
    private SuperviseResultManager superviseResultManager;
    private SuperviseBasicManager superviseBasicManager;
    private SysUnitManager sysUnitManager;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    private SysUserManager sysUserManager;
    private List<FUnitinfo> unitList;
    private String unitsJson;
    private String parentunit;

    public String saveResult() {
        try {
            // 1、保存督办结论信息
            SuperviseResult superviseResult = superviseResultManager
                    .getSuperviseResultBySuperviseNo(object.getSuperviseNo());
            if (superviseResult == null) {
                superviseResult = new SuperviseResult();
                superviseResult.setNo(UuidOpt.getUuidAsString());
                superviseResult.setSuperviseNo(object.getSuperviseNo());
            }
            FUserDetail user = ((FUserDetail) getLoginUser());
            superviseResult.setEndoperatorid(user.getUsercode());
            superviseResult.setEndDate(new Date(System.currentTimeMillis()));
            superviseResult.setSuperviseResult(object.getSuperviseResult());
            superviseResult.setEndOpinion(object.getEndOpinion());
            if (StringUtils.isNotBlank(object.getIsExternal())) {
                superviseResult.setIsExternal(Long.parseLong(object
                        .getIsExternal()));
            }
            superviseResultManager.saveObject(superviseResult);

            // 2、更新督办基本信息
            SuperviseBasic superviseBasic = superviseBasicManager
                    .getObjectById(object.getSuperviseNo());
            superviseBasic.setBizType("C");
            superviseBasicManager.saveObject(superviseBasic);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            log.error(e, e.getCause());
            request.setAttribute("error", "保存督办结论信息出错，详见系统日志。");
        }
        return super.list();
    }

    /*************************** 以下为getter、setter *******************************/
    public void setSuperviseResultManager(
            SuperviseResultManager superviseResultManager) {
        this.superviseResultManager = superviseResultManager;
    }

    public void setSuperviseBasicManager(
            SuperviseBasicManager superviseBasicManager) {
        this.superviseBasicManager = superviseBasicManager;
    }

    public void setSuperviseOnworkManager(SuperviseOnworkManager basemgr) {
        superviseOnworkMag = basemgr;
        this.setBaseEntityManager(superviseOnworkMag);
    }

    /**
     * 部门监察督查督办 ：带办结的督办
     */
    public String list() {
        try {
            FUserDetail user = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(user
                    .getUsercode());
            String sParentUnit = dept.getUnitcode();
            unitList = sysUnitManager.getAllSubUnits(sParentUnit);
            setUnitsJson(sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode()));
            setParentunit(sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit());
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            List<SuperviseOnwork> objList = new ArrayList<SuperviseOnwork>();
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
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
                filterMap.put("orgId", "");
                String hql = "From SuperviseOnwork  where  orgId in("
                        + temp.substring(1) + ") ";
                objList = superviseOnworkMag.listObjects(hql, filterMap,
                        pageDesc);

            } else {
                // filterMap.put("userCode", userCode);

                objList = superviseOnworkMag.listObjects(filterMap, pageDesc);
                // .listVSuperviseBasic(filterMap, pageDesc);
            }
            request.setAttribute("objList", objList);
            totalRows = pageDesc.getTotalRows();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
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
}
