package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Outwaycalc;

public class OutwaycalcDao extends BaseDaoImpl<Outwaycalc> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OutwaycalcDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("calcNo", CodeBook.EQUAL_HQL_ID);
            filterField.put("calcTime", CodeBook.LIKE_HQL_ID);
            filterField.put("callType", CodeBook.LIKE_HQL_ID);
            filterField.put("caller", CodeBook.LIKE_HQL_ID);
            filterField.put("scopeBegin", CodeBook.LIKE_HQL_ID);
            filterField.put("scopeEnd", CodeBook.LIKE_HQL_ID);
            filterField.put("alertPieces", CodeBook.LIKE_HQL_ID);
            filterField.put("alarmPieces", CodeBook.LIKE_HQL_ID);
            filterField.put("begincalcTime",
                    "calcTime>=to_date(?,'yyyy-mm-dd')");
            filterField.put("endcalcTime", "calcTime<=to_date(?,'yyyy-mm-dd')");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " calc_no desc ");
        }
        return filterField;
    }

    public List<Outwaycalc> getOutwaycalcList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        List<Outwaycalc> l = super.listObjects(filterMap, pageDesc);
        return l;
    }
}
