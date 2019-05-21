package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfNode;

public class WfNodeDao extends BaseDaoImpl<WfNode> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("nodeId", CodeBook.EQUAL_HQL_ID);

            filterField.put("flowCode", CodeBook.LIKE_HQL_ID);

            filterField.put("version", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeType", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeName", CodeBook.LIKE_HQL_ID);

            filterField.put("optType", CodeBook.LIKE_HQL_ID);

            filterField.put("optCode", CodeBook.LIKE_HQL_ID);

            filterField.put("subFlowCode", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("roleType", CodeBook.LIKE_HQL_ID);

            filterField.put("roleCode", CodeBook.LIKE_HQL_ID);

        }
        // this.getNextValueOfSequence(sequenceName)
        return filterField;
    }

}
