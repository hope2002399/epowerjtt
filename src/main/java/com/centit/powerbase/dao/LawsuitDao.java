package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerbase.po.Lawsuit;

public class LawsuitDao extends BaseDaoImpl<Lawsuit> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawsuitDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("lawsuitno", CodeBook.EQUAL_HQL_ID);

            filterField.put("lawsuitdate", CodeBook.LIKE_HQL_ID);

            filterField.put("lawsuitapplyunit", CodeBook.LIKE_HQL_ID);

            filterField.put("lawsuitdep", CodeBook.LIKE_HQL_ID);

            filterField.put("lawsuitenddate", CodeBook.LIKE_HQL_ID);

            filterField.put("lawsuitresult", CodeBook.LIKE_HQL_ID);

            filterField.put("lawsuitremark", CodeBook.LIKE_HQL_ID);

            filterField.put("bookoperator", CodeBook.LIKE_HQL_ID);

            filterField.put("bookdate", CodeBook.LIKE_HQL_ID);
            filterField.put("beginlawsuitdate",
                    "lawsuitdate>=to_date(?,'yyyy-mm-dd')");
            filterField.put("endlawsuitdate",
                    "lawsuitdate<=to_date(?,'yyyy-mm-dd')");

        }
        return filterField;
    }
}
