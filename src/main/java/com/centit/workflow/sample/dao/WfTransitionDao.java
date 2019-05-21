package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfTransition;

public class WfTransitionDao extends BaseDaoImpl<WfTransition> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("transid", CodeBook.EQUAL_HQL_ID);

            filterField.put("wfid", CodeBook.LIKE_HQL_ID);

            filterField.put("version", CodeBook.LIKE_HQL_ID);

            filterField.put("transclass", CodeBook.LIKE_HQL_ID);

            filterField.put("transname", CodeBook.LIKE_HQL_ID);

            filterField.put("transdesc", CodeBook.LIKE_HQL_ID);

            filterField.put("startnodeid", CodeBook.LIKE_HQL_ID);

            filterField.put("endnodeid", CodeBook.LIKE_HQL_ID);

            filterField.put("transcondition", CodeBook.LIKE_HQL_ID);

            filterField.put("routerpos", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public List<WfTransition> getNodeTrans(long nodeID) {
        String baseHQL = "from WfTransition where startnodeid = " + nodeID;
        return this.listObjects(baseHQL);
    }
}
