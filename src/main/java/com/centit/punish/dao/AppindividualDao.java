package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Appindividual;

public class AppindividualDao extends BaseDaoImpl<Appindividual> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(AppindividualDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("individualid", CodeBook.EQUAL_HQL_ID);

            filterField.put("individualname", CodeBook.LIKE_HQL_ID);

            filterField.put("individualcode", CodeBook.LIKE_HQL_ID);

            filterField.put("sex", CodeBook.LIKE_HQL_ID);

            filterField.put("age", CodeBook.LIKE_HQL_ID);

            filterField.put("individualadress", CodeBook.LIKE_HQL_ID);

            filterField.put("workunit", CodeBook.LIKE_HQL_ID);

            filterField.put("postcode", CodeBook.LIKE_HQL_ID);

            filterField.put("phone", CodeBook.LIKE_HQL_ID);

            filterField.put("email", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "lastusedate desc");

        }
        return filterField;
    }
}
