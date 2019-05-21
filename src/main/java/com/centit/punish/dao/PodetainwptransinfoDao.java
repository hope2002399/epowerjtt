package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Podetainwptransinfo;

public class PodetainwptransinfoDao extends BaseDaoImpl<Podetainwptransinfo> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PodetainwptransinfoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("wpid", CodeBook.EQUAL_HQL_ID);

            filterField.put("transperson", CodeBook.LIKE_HQL_ID);

            filterField.put("receiveperson", CodeBook.LIKE_HQL_ID);

            filterField.put("receivedate", CodeBook.LIKE_HQL_ID);

            filterField.put("translocation", CodeBook.LIKE_HQL_ID);

            filterField.put("remark", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
