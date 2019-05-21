package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.VPODiscuss;

public class VPODiscussDao extends BaseDaoImpl<VPODiscuss> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VPODiscussDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("podiscusstype", CodeBook.EQUAL_HQL_ID);

            filterField.put("podiscussbegintime", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussendtime", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussemcee", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussnoter", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussattendname", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussattendeename", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussaffixname", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussrecored", CodeBook.LIKE_HQL_ID);

            filterField.put("disobeyitem", CodeBook.LIKE_HQL_ID);

            filterField.put("confirmtruth", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussadress", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussresult", CodeBook.LIKE_HQL_ID);

            filterField.put("enregisterdate", CodeBook.LIKE_HQL_ID);

            filterField.put("isSurpass", CodeBook.LIKE_HQL_ID);

            filterField.put("punish_heavy", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
