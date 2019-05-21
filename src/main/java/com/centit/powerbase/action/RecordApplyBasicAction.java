package com.centit.powerbase.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.RecordApplyBasic;
import com.centit.powerbase.po.Vapplyrecordbasic;
import com.centit.powerbase.service.RecordApplyBasicManager;
import com.centit.powerbase.service.VapplyrecordbasicManager;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class RecordApplyBasicAction extends
        BaseEntityExtremeAction<Vapplyrecordbasic> {
    private static final long serialVersionUID = 1L;
    private RecordApplyBasicManager recordApplyBasicManager;
    private VapplyrecordbasicManager vapplyrecordbasicManager;
    private List<Vapplyrecordbasic> recordlist;
    private Vapplyrecordbasic info;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private String unitsJson;
    private String parentUnit;

    @SuppressWarnings("unchecked")
    public String getList() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();// 获取该部门编码的顶层部门信息
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        recordlist = vapplyrecordbasicManager.listObjects(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "list";
    }

    /*
     * 备案
     */
    @SuppressWarnings("unchecked")
    public String form() {
        // System.out.println(object.getNo()+"  "+object.getOrgId());
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put("no", request.getParameter("no"));
        PageDesc pageDesc = makePageDesc();
        recordlist = vapplyrecordbasicManager.listObjects(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        // super.view();
        if (!recordlist.isEmpty()) {
            info = recordlist.get(0);
        }
        // System.out.println(object.getNo()+"  "+object.getOrgId()+"   "+recordlist.get(0).getOrgId());
        return "form";
    }

    /*
     * 备案意见 保存 到RecordApplyBasic
     */
    public String insertRecordApplyBasic() {
        RecordApplyBasic recordApplyBasic = new RecordApplyBasic();
        FUserDetail user = (FUserDetail) getLoginUser();
        recordApplyBasic.setOperatorId(user.getUsercode());
        recordApplyBasic.setRemark(request.getParameter("remark"));
        // System.out.println(request.getParameter("remark"));
        recordApplyBasic.setNo(object.getNo());
        // System.out.println(object.getNo());
        recordApplyBasic.setBookDate(new Date(System.currentTimeMillis()));
        recordApplyBasic.setDealStep("0");// null时为0
        recordApplyBasic.setRecordCode(recordApplyBasicManager.getRecordCode());
        // System.out.println(recordApplyBasic);
        recordApplyBasicManager.saveRecordApplyBasic(recordApplyBasic);
        return getList();
    }

    public void setRecordApplyBasicManager(RecordApplyBasicManager baseManager) {
        this.recordApplyBasicManager = baseManager;

    }

    public List<Vapplyrecordbasic> getRecordlist() {
        return recordlist;
    }

    public void setRecordlist(List<Vapplyrecordbasic> recordlist) {
        this.recordlist = recordlist;
    }

    public void setVapplyrecordbasicManager(
            VapplyrecordbasicManager vapplyrecordbasicManager) {
        this.vapplyrecordbasicManager = vapplyrecordbasicManager;
        this.setBaseEntityManager(this.vapplyrecordbasicManager);
    }

    public Vapplyrecordbasic getInfo() {
        return info;
    }

    public void setInfo(Vapplyrecordbasic info) {
        this.info = info;
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

}
