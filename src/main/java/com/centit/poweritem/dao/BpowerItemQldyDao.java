package com.centit.poweritem.dao;

import java.util.HashMap;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.poweritem.po.BpowerItemQldy;

public class BpowerItemQldyDao extends BaseDaoImpl<BpowerItemQldy> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Map<String, String> getFilterField() {
        
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("serviceId", CodeBook.EQUAL_HQL_ID);
            filterField.put("NserviceId", " serviceId !=? ");
            filterField.put("serviceName", CodeBook.LIKE_HQL_ID);
            filterField.put("itemMainId", CodeBook.EQUAL_HQL_ID);
            filterField.put("itemMainName", CodeBook.LIKE_HQL_ID);
            filterField.put("itemSubId", CodeBook.EQUAL_HQL_ID);
            filterField.put("itemSubName", CodeBook.LIKE_HQL_ID);
            filterField.put("itemQldyItemId", CodeBook.EQUAL_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " serviceId asc");
        }
        return filterField;
    }

}
