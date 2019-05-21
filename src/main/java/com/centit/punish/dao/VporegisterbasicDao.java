package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Vporegisterbasic;

public class VporegisterbasicDao extends BaseDaoImpl<Vporegisterbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VporegisterbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("poregisterindagate", CodeBook.LIKE_HQL_ID);

            filterField.put("poregisterbasis", CodeBook.LIKE_HQL_ID);

            filterField.put("jbrLa", CodeBook.LIKE_HQL_ID);

            filterField.put("ksLa", CodeBook.LIKE_HQL_ID);

            filterField.put("fzrLa", CodeBook.LIKE_HQL_ID);

            filterField.put("jbroptionLa", CodeBook.LIKE_HQL_ID);

            filterField.put("ksoptionLa", CodeBook.LIKE_HQL_ID);

            filterField.put("fzroptionLa", CodeBook.LIKE_HQL_ID);

            filterField.put("jbroptionLatime", CodeBook.LIKE_HQL_ID);

            filterField.put("ksoptionLatime", CodeBook.LIKE_HQL_ID);

            filterField.put("fzroptionLatime", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjectbrief", CodeBook.LIKE_HQL_ID);

            filterField.put("pooccurstate", CodeBook.LIKE_HQL_ID);

            filterField.put("poorigindate", CodeBook.LIKE_HQL_ID);

            filterField.put("enterprisename", CodeBook.LIKE_HQL_ID);

            filterField.put("enterpriseaddress", CodeBook.LIKE_HQL_ID);

            filterField.put("mastername", CodeBook.LIKE_HQL_ID);

            filterField.put("enphone", CodeBook.LIKE_HQL_ID);

            filterField.put("individualname", CodeBook.LIKE_HQL_ID);

            filterField.put("individualcode", CodeBook.LIKE_HQL_ID);

            filterField.put("sex", CodeBook.LIKE_HQL_ID);

            filterField.put("age", CodeBook.LIKE_HQL_ID);

            filterField.put("individualadress", CodeBook.LIKE_HQL_ID);

            filterField.put("inphone", CodeBook.LIKE_HQL_ID);

            filterField.put("pooriginstate", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
