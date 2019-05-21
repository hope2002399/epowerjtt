package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfStageInstance;

public class WfStageInstanceDao extends BaseDaoImpl<WfStageInstance> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(WfStageInstanceDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("flowInstId", CodeBook.EQUAL_HQL_ID);

            filterField.put("stageId", CodeBook.EQUAL_HQL_ID);

            filterField.put("promiseTime", CodeBook.LIKE_HQL_ID);

            filterField.put("timeLimit", CodeBook.LIKE_HQL_ID);

            filterField.put("expireOptSign", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
