package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.RecordBasic;

@SuppressWarnings("serial")
public class RecordBasicDao extends BaseDaoImpl<RecordBasic> {
    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("recordCode", CodeBook.EQUAL_HQL_ID);
            filterField.put("no", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }

    public List<RecordBasic> recordBasicList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return listObjects(filterMap, pageDesc);
    }

    public String getRecordCode() {
        return getNextKeyBySequence("S_RECORDBASIC_RECORDCODE", 0);
    }
}
