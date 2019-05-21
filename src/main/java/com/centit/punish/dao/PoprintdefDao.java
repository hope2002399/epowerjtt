package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Poprintdef;

public class PoprintdefDao extends BaseDaoImpl<Poprintdef> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoprintdefDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("depid", CodeBook.EQUAL_HQL_ID);

            filterField.put("printtype", CodeBook.EQUAL_HQL_ID);

            filterField.put("ioprintcode", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
