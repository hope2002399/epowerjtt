package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Poexcucebasic;

public class PoexcucebasicDao extends BaseDaoImpl<Poexcucebasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoexcucebasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("poexcucedate", CodeBook.LIKE_HQL_ID);

            filterField.put("poexcuceadress", CodeBook.LIKE_HQL_ID);

            filterField.put("undertakername", CodeBook.LIKE_HQL_ID);

            filterField.put("undertakecertno", CodeBook.LIKE_HQL_ID);

            filterField.put("registercertno", CodeBook.LIKE_HQL_ID);

            filterField.put("registerid", CodeBook.LIKE_HQL_ID);

            filterField.put("deputyname", CodeBook.LIKE_HQL_ID);

            filterField.put("excucedate", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
