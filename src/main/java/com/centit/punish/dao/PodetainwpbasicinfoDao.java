package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Podetainwpbasicinfo;

public class PodetainwpbasicinfoDao extends BaseDaoImpl<Podetainwpbasicinfo> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PodetainwpbasicinfoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("wpid", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishobjectid", CodeBook.LIKE_HQL_ID);

            filterField.put("wptype", CodeBook.LIKE_HQL_ID);

            filterField.put("wpname", CodeBook.LIKE_HQL_ID);

            filterField.put("wpstate", CodeBook.LIKE_HQL_ID);

            filterField.put("receivedate", CodeBook.LIKE_HQL_ID);

            filterField.put("receivelocation", CodeBook.LIKE_HQL_ID);

            filterField.put("receiveperson", CodeBook.LIKE_HQL_ID);

            filterField.put("confirmperson", CodeBook.LIKE_HQL_ID);

            filterField.put("wpcurrentlocation", CodeBook.LIKE_HQL_ID);

            filterField.put("remark", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public String genNextWpId() {
        return getNextKeyBySequence("S_WPID", 10);
    }

}
