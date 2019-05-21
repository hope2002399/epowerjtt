package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Poreceiptinfo;

public class PoreceiptinfoDao extends BaseDaoImpl<Poreceiptinfo> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoreceiptinfoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("poreceiptstate", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("operatorname", CodeBook.LIKE_HQL_ID);

            filterField.put("signinedname", CodeBook.LIKE_HQL_ID);

            filterField.put("signineddate", CodeBook.LIKE_HQL_ID);

            filterField.put("poreceiptname", CodeBook.LIKE_HQL_ID);

            filterField.put("poreceiptdoc", CodeBook.LIKE_HQL_ID);

            filterField.put("receiptmodel", CodeBook.LIKE_HQL_ID);

            filterField.put("enregisterid", CodeBook.LIKE_HQL_ID);

            filterField.put("enregisterdate", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
