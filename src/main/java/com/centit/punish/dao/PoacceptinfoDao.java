package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Poacceptinfo;

public class PoacceptinfoDao extends BaseDaoImpl<Poacceptinfo> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoacceptinfoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("jbrSl", CodeBook.LIKE_HQL_ID);

            filterField.put("ksrSl", CodeBook.LIKE_HQL_ID);

            filterField.put("fzrSl", CodeBook.LIKE_HQL_ID);

            filterField.put("jbroptionSl", CodeBook.LIKE_HQL_ID);

            filterField.put("ksoptionSl", CodeBook.LIKE_HQL_ID);

            filterField.put("fzroptionSl", CodeBook.LIKE_HQL_ID);

            filterField.put("jbroptionSltime", CodeBook.LIKE_HQL_ID);

            filterField.put("ksoptionSltime", CodeBook.LIKE_HQL_ID);

            filterField.put("fzroptionSltime", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
