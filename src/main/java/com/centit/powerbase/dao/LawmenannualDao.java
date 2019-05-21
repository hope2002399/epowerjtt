package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.CodeBook;
import com.centit.powerbase.po.Lawmenannual;

public class LawmenannualDao extends
        com.centit.monitor.dao.MonitorDaoImpl<Lawmenannual> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawmenannualDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("annualId", CodeBook.EQUAL_HQL_ID);

            filterField.put("lawmenId", CodeBook.LIKE_HQL_ID);

            filterField.put("usercode", CodeBook.LIKE_HQL_ID);

            filterField.put("annualDate", CodeBook.LIKE_HQL_ID);

            filterField.put("annualResult", CodeBook.LIKE_HQL_ID);

            filterField.put("validity", CodeBook.LIKE_HQL_ID);

            filterField.put("remark", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
