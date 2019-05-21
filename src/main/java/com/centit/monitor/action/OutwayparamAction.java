package com.centit.monitor.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;
import org.springframework.security.core.context.SecurityContextHolder;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Outwayparam;
import com.centit.monitor.service.OutwayparamManager;
import com.centit.sys.security.FUserDetail;

public class OutwayparamAction extends BaseEntityExtremeAction<Outwayparam> {
    private static final long serialVersionUID = 1L;
    private OutwayparamManager outwayparamMag;
    private List<Outwayparam> outwayparamList;
    private List<String> getMonthList() {
        
        List<String> months = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            if (i > 9) {
                months.add(String.valueOf(i));
            } else {
                months.add("0" + String.valueOf(i));
            }
        }
        return months;
    }

    private List<String> getYearList() {
        
        List<String> years = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String thisYear = sdf.format(new Date(System.currentTimeMillis()))
                .substring(0, 4);
        for (int i = 2010; i <= Integer.parseInt(thisYear); i++) {
            years.add(String.valueOf(i));
        }
        return years;
    }

    /**
     *  参数列表
     */
    @SuppressWarnings("unchecked")
    public String list() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        outwayparamList = outwayparamMag
                .getOutWayParamList(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        request.setAttribute("yearList", getYearList());
        request.setAttribute("monthlist", getMonthList());
        return LIST;
    }

    // 保存修改之后的参数
    public String outwayparamSave() {
        object.setParamType(null);// 当这个为空的时候系统就不会对其进行修改操作
        super.save();
        return this.list();
    }

    // 调用存储过程
    @SuppressWarnings("unchecked")
    public String callProcedure() {
        // 进行调用存储过程
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        String countYear = (String) filterMap.get("countYear");
        String countMonth = (String) filterMap.get("countMonth");
        FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String proceduceName = fUserDetail.getUsercode();
        @SuppressWarnings("unused")
        boolean flag = outwayparamMag.callCheck_warning(proceduceName,
                countYear, countMonth);
        // 调用结束
        return this.list();
    }

    public void setOutwayparamManager(OutwayparamManager basemgr) {
        outwayparamMag = basemgr;
        this.setBaseEntityManager(outwayparamMag);
    }

    public List<Outwayparam> getOutwayparamList() {
        return outwayparamList;
    }

    public void setOutwayparamList(List<Outwayparam> outwayparamList) {
        this.outwayparamList = outwayparamList;
    }
}
