package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.RecordFileStuff;

public class RecordFileStuffDao extends BaseDaoImpl<RecordFileStuff> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SuppowerchglogDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("attachNo", CodeBook.EQUAL_HQL_ID);

            filterField.put("recordCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("operatorID", CodeBook.EQUAL_HQL_ID);

            filterField.put("beginDate",
                    "to_char(uploadDate, 'yyyy-mm-dd') >= ? ");
            filterField.put("endDate",
                    "to_char(uploadDate, 'yyyy-mm-dd') <= ? ");

            filterField.put("attachmnetName", CodeBook.LIKE_HQL_ID);

            filterField.put("fileName", CodeBook.LIKE_HQL_ID);

            filterField.put("fileType", CodeBook.LIKE_HQL_ID);

            filterField.put("memo", CodeBook.LIKE_HQL_ID);

            filterField.put("processNo", CodeBook.LIKE_HQL_ID);

            filterField.put("context", CodeBook.LIKE_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " uploadDate desc");
        }
        return filterField;
    }

    public List<RecordFileStuff> getRecordFileStuffByRecord(String recordCode) {
        if (recordCode != null) {
            List<RecordFileStuff> procs = this
                    .listObjects("From RecordFileStuff where recordCode =  "
                            + HQLUtils.buildHqlStringForSQL(recordCode));
            if (procs != null)
                return procs;
        }
        return null;

    }

    public RecordFileStuff getStuffByNo(String attachNo) {
        if (attachNo != null) {
            List<RecordFileStuff> procs = this
                    .listObjects("From RecordFileStuff where attachNo =  "
                            + HQLUtils.buildHqlStringForSQL(attachNo));
            if (procs != null && procs.size() >= 1)
                return procs.get(0);
        }
        return null;

    }

    public String getAttachNo() {
        return getNextKeyBySequence("S_ATTACHNO", 5);
    }

    public List<RecordFileStuff> getFileStuff(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return listObjects(filterMap, pageDesc);

    }
}
