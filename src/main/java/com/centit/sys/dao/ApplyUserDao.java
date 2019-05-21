package com.centit.sys.dao;

import java.util.HashMap;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.sys.po.ApplyUser;

public class ApplyUserDao extends BaseDaoImpl<ApplyUser> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("USERNAME", CodeBook.LIKE_HQL_ID);
            filterField.put("ISINUSE", CodeBook.EQUAL_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, "userID asc");
        }
        return filterField;
    }

}
