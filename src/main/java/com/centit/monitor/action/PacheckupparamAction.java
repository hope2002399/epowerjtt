package com.centit.monitor.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Pacheckupparam;
import com.centit.monitor.service.PacheckupparamManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.ibm.icu.text.SimpleDateFormat;
import com.opensymphony.xwork2.ActionContext;

public class PacheckupparamAction extends
        BaseEntityExtremeAction<Pacheckupparam> implements ServletResponseAware {
    private static final Log log = LogFactory
            .getLog(PacheckupparamAction.class);

    // private static final ISysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog("optid");

    private static final long serialVersionUID = 1L;
    private PacheckupparamManager pacheckupparamMag;
    private SysUserManager sysUserManager;

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    private SysUnitManager sysUnitManager;

    public void setPacheckupparamManager(PacheckupparamManager basemgr) {
        pacheckupparamMag = basemgr;
        this.setBaseEntityManager(pacheckupparamMag);
    }

    private List<FUnitinfo> unitList;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    // 针对附件异常的提示
    ActionContext context = ActionContext.getContext();
    HttpServletResponse response;

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    // 页面用到的变量
    private List<Pacheckupparam> pacheckupparamList;

    public List<Pacheckupparam> getPacheckupparamList() {
        return pacheckupparamList;
    }

    public void setPacheckupparamList(List<Pacheckupparam> pacheckupparamList) {
        this.pacheckupparamList = pacheckupparamList;
    }

    List<String> yearList = new ArrayList<String>();
    private boolean bl;

    public boolean isBl() {
        return bl;
    }

    public void setBl(boolean bl) {
        this.bl = bl;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    /**
     * 参数列表
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String list() {
        // 年份列表
        for (int i = 0; i < 11; i++) {
            int year = Integer.parseInt(DatetimeOpt.getNowDateTime4String()
                    .substring(0, 4));
            year = year - i;
            yearList.add(String.valueOf(year));
        }
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        pacheckupparamList = pacheckupparamMag.getPacheckupparamList(filterMap,
                pageDesc);//
        totalRows = pageDesc.getTotalRows();
        return LIST;
    }

    /**
     * 新增参数
     * 
     * @return
     */
    public String checkupxz() {
        this.editInitial();
        return "checkupxz";
    }

    public String editInitial() {
        // FUserDetail user = ((FUserDetail)getLoginUser());
        // FUserunit dept =
        // sysUserManager.getUserPrimaryUnit(user.getUsercode());
        // String sParentUnit = dept.getUnitcode();
        // unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        try {
            object = getEntityClass().newInstance();
            object.clearProperties();
            return EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 修改参数
     * 
     * @return
     */
    public String Edit() {
        super.edit();
        return "checkupxz";
    }

    public String AlertMessage(String url_temp) throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        String url = "<script>window.location.href='" + url_temp + "'</script>";
        out.print("<script>alert('保存成功！')</script>");
        out.print(url);
        out.flush();
        out.close();
        return null;
    }

    /**
     * 保存新增参数
     * 
     * @return
     */
    public String pacheckupparamSave() {

        try {
            Pacheckupparam pmobject = pacheckupparamMag.getObject(object);
            if (pmobject != null) {
                pmobject.copyNotNullProperty(object);
                object = pmobject;
            }
            try {

                pacheckupparamMag.saveObject(object);
                savedMessage();
            } catch (Exception e) {
                log.error(e.getMessage(), e);

                return EDIT;
            }

            return SUCCESS;
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }

    }

    /**
     * 删除参数
     * 
     * @return
     */

    public String delete() {
        super.delete();

        return "delete";
    }

    // 保存修改之后的参数
    public String paramSave() {
        object.setParamType(null);// 当这个为空的时候系统就不会对其进行修改操作

        // String paramType=object.getParamType().replace(",", " ").trim();
        // object.setParamType(paramType);
        super.save();
        return this.list();
    }

    /**
     * 计算绩效得分
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String jsperformance() {

        Map<Object, Object> paramMap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        String year = (String) filterMap.get("countYear");
        String month = (String) filterMap.get("countMonth");
        String onlyCalcSum = (String) filterMap.get("onlyCalcSun");// 仅计算总分的参数
        String deleteOld = (String) filterMap.get("deleteOld");// 重算时的参数
        // String orgid = (String)filterMap.get("orgId");
        String yearandmonth = year + "-" + month + "-" + 30;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        try {
            date = sdf.parse(yearandmonth);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        java.sql.Date yearAndmonth = new java.sql.Date(date.getTime());

        // 仅计算总分的参数
        if (onlyCalcSum != null) {
            onlyCalcSum = "1";
        } else {
            onlyCalcSum = "0";
        }
        ;
        // 重算时的参数
        if (deleteOld != null) {
            deleteOld = "1";
        } else {
            deleteOld = "0";
        }
        ;
        bl = pacheckupparamMag.insertPerformance(yearAndmonth, deleteOld,
                onlyCalcSum);
        return this.list();
    }
}
