package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerbase.po.RecordFileDep;

public class RecordFileDepDao extends BaseDaoImpl<RecordFileDep> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(RecordFileDep.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("no", CodeBook.EQUAL_HQL_ID);
            filterField.put("recordCode", CodeBook.EQUAL_HQL_ID);
            filterField.put("constituteDepID", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }

    public String getNo() {
        return getNextKeyBySequence("S_RECORDFILEDEPNO", 10);
    }

    public void deleteByRecordCode(String recordCode) {
        doExecuteHql("delete from RecordFileDep  where recordCode =? ",
                recordCode);
    }
}
