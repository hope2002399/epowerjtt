package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.OptExpressMessage;

public class OptExpressMessageDao extends BaseDaoImpl<OptExpressMessage> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptExpressMessageDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("expressid", CodeBook.EQUAL_HQL_ID);
            filterField.put("emsordno", CodeBook.LIKE_HQL_ID);
            filterField.put("govtbname", CodeBook.LIKE_HQL_ID);
            filterField.put("posttype", CodeBook.LIKE_HQL_ID);
            filterField.put("nettype", CodeBook.LIKE_HQL_ID);
            filterField.put("busstype", CodeBook.LIKE_HQL_ID);
            filterField.put("sendid", CodeBook.LIKE_HQL_ID);
            filterField.put("sendname", CodeBook.LIKE_HQL_ID);
            filterField.put("sendprov", CodeBook.LIKE_HQL_ID);
            filterField.put("sendcity", CodeBook.LIKE_HQL_ID);
            filterField.put("sendCountry", CodeBook.LIKE_HQL_ID);
            filterField.put("sendstrect", CodeBook.LIKE_HQL_ID);
            filterField.put("sendphone", CodeBook.LIKE_HQL_ID);
            filterField.put("sendcall", CodeBook.LIKE_HQL_ID);
            filterField.put("rcvname", CodeBook.LIKE_HQL_ID);
            filterField.put("rcvprov", CodeBook.LIKE_HQL_ID);
            filterField.put("rcvcity", CodeBook.LIKE_HQL_ID);
            filterField.put("rcvcountry", CodeBook.LIKE_HQL_ID);
            filterField.put("rcvstrect", CodeBook.LIKE_HQL_ID);
            filterField.put("rcvphone", CodeBook.LIKE_HQL_ID);
            filterField.put("rcvcall", CodeBook.LIKE_HQL_ID);
            filterField.put("rcvpostcode", CodeBook.LIKE_HQL_ID);
            filterField.put("item", CodeBook.LIKE_HQL_ID);
            filterField.put("chkcode", CodeBook.LIKE_HQL_ID);
            filterField.put("issend", CodeBook.LIKE_HQL_ID);
            filterField.put("expresstime", CodeBook.LIKE_HQL_ID);
            filterField.put("djid", CodeBook.EQUAL_HQL_ID);
            filterField.put("startexpresstime",
                    "expresstime >= to_date(?,'yyyy-mm-dd')");
            filterField.put("endexpresstime",
                    "expresstime <= to_date(?,'yyyy-mm-dd')");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, "expresstime desc");
        }
        return filterField;
    }

    public String getExpressMessageId() {
        String id = super.getNextKeyByHqlStrOfMax("expressid",
                "OptExpressMessage", 16);
        return id;
    }
}
