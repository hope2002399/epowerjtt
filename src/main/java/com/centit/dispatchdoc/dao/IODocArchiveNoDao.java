package com.centit.dispatchdoc.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerruntime.po.OptZwh;

public class IODocArchiveNoDao extends BaseDaoImpl<OptZwh> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(IODocArchiveNoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("djId", CodeBook.EQUAL_HQL_ID);

            filterField.put("fwh", CodeBook.LIKE_HQL_ID);

            filterField.put("lsh", CodeBook.LIKE_HQL_ID);

            filterField.put("lshYear", CodeBook.LIKE_HQL_ID);

            filterField.put("wjlx", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
