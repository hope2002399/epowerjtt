package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.Superviselog;

public class SuperviselogDao extends BaseDaoImpl<Superviselog> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("usercode", CodeBook.LIKE_HQL_ID);
            filterField.put("optid", CodeBook.LIKE_HQL_ID);
            filterField.put("bjType", CodeBook.LIKE_HQL_ID);
            filterField.put("bjNo", CodeBook.LIKE_HQL_ID);

            // 时间范围过滤 条件
            filterField.put("begTime", " opttime >= to_date(?, 'yyyy-mm-dd') ");
            filterField.put("endTime", " opttime <= to_date(?, 'yyyy-mm-dd') ");

            // 监察类别过滤
            filterField.put("NP_jclog", " logType = '1' ");
            filterField.put("NP_fzlog", " logType = '2' ");

            // 排序
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " opttime desc");

        }
        return filterField;
    }

    /**
     * 获取监察日志功能optID列表
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<String> getOptList() {
        String sHql = "select distinct m.optid from Superviselog m ";
        return (List<String>) super.findObjectsByHql(sHql);
    }
}
