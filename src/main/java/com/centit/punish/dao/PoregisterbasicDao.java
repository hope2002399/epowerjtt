package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Poregisterbasic;

public class PoregisterbasicDao extends BaseDaoImpl<Poregisterbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoregisterbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("poregisterindagate", CodeBook.LIKE_HQL_ID);

            filterField.put("poregisterbasis", CodeBook.LIKE_HQL_ID);

            filterField.put("ispass", CodeBook.LIKE_HQL_ID);

            filterField.put("ifregister", CodeBook.LIKE_HQL_ID);

            filterField.put("poregisterstep", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
