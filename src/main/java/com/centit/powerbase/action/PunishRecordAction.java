package com.centit.powerbase.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.PunishRecord;
import com.centit.powerbase.service.PunishrecordManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.opensymphony.xwork2.ActionContext;

public class PunishRecordAction extends BaseEntityExtremeAction<PunishRecord>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    private PunishrecordManager punishRecordManager;
    private SysUserManager sysUserManager;
    private List<PunishRecord> punishRecordList;
    private SysUnitManager sysUnitManager;
    private String unitsJson;
    private String parentUnit;
    private String message;
    ActionContext context = ActionContext.getContext();
    HttpServletResponse response;

    public ActionContext getContext() {
        return context;
    }

    public void setContext(ActionContext context) {
        this.context = context;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
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

    public List<PunishRecord> getPunishRecordList() {
        return punishRecordList;
    }

    public void setPunishRecordList(List<PunishRecord> punishRecordList) {
        this.punishRecordList = punishRecordList;
    }

    public void setPunishRecordManager(PunishrecordManager punishRecordManager) {
        this.punishRecordManager = punishRecordManager;
        setBaseEntityManager(this.punishRecordManager);
    }

    /**
     * 备案范围管理的查询
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String PunishRecordTemp() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser.getUsercode());
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        String sParentUnit = dept.getUnitcode();
        if (!StringBaseOpt.isNvl(sParentUnit)) {
            if (sysUnitManager.getObjectById(sParentUnit) != null) {
                String s_org_id = sysUnitManager.getObjectById(sParentUnit)
                        .getDepno();
                filterMap.put("topUnitNo", s_org_id);
            } else {
                // 不做处理
            }

        } else {
            // 不做处理
        }
        String orgId = (String) filterMap.get("org_id");
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if (!StringBaseOpt.isNvl(orgId) && "true".equals(s_queryUnderUnit)) {
            filterMap.put("topUnitNo", orgId);
            filterMap.put("org_id", null);
        } else if (!StringBaseOpt.isNvl(orgId)) {
            filterMap.put("org_id", orgId);
        } else {
            // 不做处理
        }
        punishRecordList = punishRecordManager.getPunishRecord(filterMap,
                pageDesc);
        totalRows = pageDesc.getTotalRows();
        unitsJson = sysUnitManager.getAllSubUnitsJSON(sParentUnit);// 获取该部门下面的全部部门信息，并合并为json形式（数组）
        parentUnit = sysUnitManager.getObjectById(sParentUnit).getParentunit();// 获取该部门编码的顶层部门信息
        return SUCCESS;
    }

    /**
     * 修改备案范围管理的信息
     * 
     * @see com.centit.core.action.BaseEntityExtremeAction#edit()
     */
    @SuppressWarnings("unchecked")
    public String edit() {

        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        punishRecordList = punishRecordManager.listObjects(filterMap);
        PunishRecord info = new PunishRecord();
        if (punishRecordList != null) {
            info = punishRecordList.get(0);
        }
        punishRecordManager.copyObjectNotNullProperty(object, info);
        return "edit";
    }

    /**
     * 更新指定备案范围管理的行信息
     * 
     * @return
     */
    public String updatePunishRecord() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        PunishRecord punishRecord = new PunishRecord();
        punishRecordManager.copyObjectNotNullProperty(punishRecord, object);
        punishRecord.setBookOperatorID(fuser.getUsercode());
        punishRecord.setModifyDate(new Date());
        punishRecordManager.saveObject(punishRecord);
        punishRecordManager.initPunishRecords(punishRecord.getOrg_id());
        String url = "powerbase/punishRecord!PunishRecordTemp.do?usercode=0";
        message = "修改成功";
        try {
            this.AlertMessage(url, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.PunishRecordTemp();
    }

    /*
     * 删除备案范围管理的信息
     * 
     * @see com.centit.core.action.BaseEntityExtremeAction#edit()
     */
    public String delete() {
        punishRecordManager.deleteObjectById(object.getOrg_id());
        String url = "powerbase/punishRecord!PunishRecordTemp.do?usercode=0";
        message = "删除成功";
        try {
            this.AlertMessage(url, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.PunishRecordTemp();
    }

    /**
     * 备案范围管理的新增功能方法
     * 
     * @return
     */
    public String addPunishRecord() {

        return "addPunishRecord";
    }

    /**
     * 备案范围管理的数据添加方法
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String savePunishRecord() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put("org_id", object.getOrg_id());
        object.setBookOperatorID(fuser.getUsercode());
        object.setBookDate(new Date());
        object.setModifyDate(new Date());
        punishRecordList = punishRecordManager.listObjects(filterMap);
        String url = "powerbase/punishRecord!PunishRecordTemp.do?usercode=0";
        if (punishRecordList.isEmpty()) {
            punishRecordManager.saveObject(object);
            message = "添加成功！";
            try {
                this.AlertMessage(url, message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            message = "此部门已存在,添加失败！";
            try {
                this.AlertMessage(url, message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // request.setAttribute("message", message);
        return this.PunishRecordTemp();

    }

    /*
     * 操作的提示信息
     */
    public String AlertMessage(String url_temp, String message)
            throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        String url = "<script>window.location.href='" + url_temp + "'</script>";
        out.print("<script>alert('" + message + "')</script>");
        out.print(url);
        out.flush();
        out.close();
        return null;
    }

}
