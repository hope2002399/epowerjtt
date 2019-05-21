package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Poundertakebasic;

public class PoundertakebasicDao extends BaseDaoImpl<Poundertakebasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoundertakebasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("usercode", CodeBook.EQUAL_HQL_ID);

            filterField.put("depid", CodeBook.LIKE_HQL_ID);

            filterField.put("sectionid", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
