package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Pomovebackbasic;

public class PomovebackbasicDao extends BaseDaoImpl<Pomovebackbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PomovebackbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("sortno", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishobjectid", CodeBook.LIKE_HQL_ID);

            filterField.put("stepworkid", CodeBook.LIKE_HQL_ID);

            filterField.put("beginapprovecode", CodeBook.LIKE_HQL_ID);

            filterField.put("endapprovecode", CodeBook.LIKE_HQL_ID);

            filterField.put("movebackdate", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorid", CodeBook.LIKE_HQL_ID);

            filterField.put("movebackcontent", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
