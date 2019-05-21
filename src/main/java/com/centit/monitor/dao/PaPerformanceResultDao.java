package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.PaPerformanceResult;

public class PaPerformanceResultDao extends BaseDaoImpl<PaPerformanceResult> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PaPerformanceResultDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("checkNo", CodeBook.EQUAL_HQL_ID);

            filterField.put("checkType", CodeBook.LIKE_HQL_ID);

            filterField.put("userCode", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);

            filterField.put("countYear", CodeBook.LIKE_HQL_ID);

            filterField.put("countMonth", CodeBook.EQUAL_HQL_ID);

            filterField.put("createDate", CodeBook.LIKE_HQL_ID);

            filterField.put("allNum", CodeBook.LIKE_HQL_ID);

            filterField.put("zsScore", CodeBook.LIKE_HQL_ID);

            filterField.put("auditDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("auditor", CodeBook.LIKE_HQL_ID);

            filterField.put("auditDate", CodeBook.LIKE_HQL_ID);

            filterField.put("auditResult", CodeBook.LIKE_HQL_ID);
            filterField.put("recordNum", CodeBook.LIKE_HQL_ID);
            filterField.put("calculateNum", CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }

}
