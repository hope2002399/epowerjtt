package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.RecordApplyBasic;

public class RecordApplyBasicDao extends BaseDaoImpl<RecordApplyBasic> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null)
            filterField = new HashMap<String, String>();
        filterField.put("recordCode", CodeBook.EQUAL_HQL_ID);
        filterField.put("no", CodeBook.EQUAL_HQL_ID);

        return filterField;
    }

    public List<RecordApplyBasic> getListRecord(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        List<RecordApplyBasic> list = null;
        list = this.listObjects(filterMap, pageDesc);
        return list;
    }

    public String getRecordCode() {
        return getNextKeyBySequence("S_RECORDAPPLYBASIC_RECORDCODE", 10);
    }

}
