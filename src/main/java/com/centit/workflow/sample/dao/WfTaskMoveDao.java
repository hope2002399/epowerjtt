package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfTaskMove;

public class WfTaskMoveDao extends BaseDaoImpl<WfTaskMove> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(WfTaskMoveDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("moveno", CodeBook.EQUAL_HQL_ID);

            filterField.put("olduser", CodeBook.LIKE_HQL_ID);

            filterField.put("newuser", CodeBook.LIKE_HQL_ID);

            filterField.put("desc", CodeBook.LIKE_HQL_ID);

            filterField.put("operuser", CodeBook.LIKE_HQL_ID);

            filterField.put("operdate", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public long getNextMoveTaskNo() {
        String sNo = getNextValueOfSequence("S_TASKMOVENO");
        return Long.valueOf(sNo);
    }

    public void saveTaskMove(WfTaskMove taskMove) {
        taskMove.setMoveno(getNextMoveTaskNo());
        super.saveObject(taskMove);
    }
}
