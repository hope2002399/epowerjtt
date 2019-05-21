package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Vapplyrecordbasic;

public class VapplyrecordbasicDao extends BaseDaoImpl<Vapplyrecordbasic> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null)
            filterField = new HashMap<String, String>();
        filterField.put("internalNo", CodeBook.EQUAL_HQL_ID);
        filterField.put("begTime", "to_char(applyDate, 'yyyy-mm-dd') >= ? ");
        filterField.put("endTime", "to_char(applyDate, 'yyyy-mm-dd') <= ? ");
        filterField.put("no", CodeBook.EQUAL_HQL_ID);
        filterField.put("orgId", CodeBook.LIKE_HQL_ID);
        filterField.put("applicant", CodeBook.LIKE_HQL_ID);
        filterField.put("itemName", CodeBook.LIKE_HQL_ID);
        return filterField;
    }

    public List<Vapplyrecordbasic> getList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return this.listObjects(filterMap, pageDesc);
    }

}
