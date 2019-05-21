package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Podecisioninfo;

public class PodecisioninfoDao extends BaseDaoImpl<Podecisioninfo> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PodecisioninfoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("jbrCfjd", CodeBook.LIKE_HQL_ID);

            filterField.put("ksrCfjd", CodeBook.LIKE_HQL_ID);

            filterField.put("fzrCfjd", CodeBook.LIKE_HQL_ID);

            filterField.put("jbroptionCfjd", CodeBook.LIKE_HQL_ID);

            filterField.put("ksoptionCfjd", CodeBook.LIKE_HQL_ID);

            filterField.put("fzroptionCfjd", CodeBook.LIKE_HQL_ID);

            filterField.put("jbroptionCfjdtime", CodeBook.LIKE_HQL_ID);

            filterField.put("ksoptionCfjdtime", CodeBook.LIKE_HQL_ID);

            filterField.put("fzroptionCfjdtime", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
