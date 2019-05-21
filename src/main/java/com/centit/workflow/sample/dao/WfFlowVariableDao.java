package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfFlowVariable;

public class WfFlowVariableDao extends BaseDaoImpl<WfFlowVariable> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(WfFlowVariableDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("flowInstId", CodeBook.EQUAL_HQL_ID);

            filterField.put("runToken", CodeBook.EQUAL_HQL_ID);

            filterField.put("varName", CodeBook.EQUAL_HQL_ID);

            filterField.put("varValue", CodeBook.LIKE_HQL_ID);

            filterField.put("varType", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public List<WfFlowVariable> listFlowVariables(long flowInstId) {
        return this
                .listObjects(
                        "From WfFlowVariable where cid.flowInstId=? order by cid.runToken",
                        flowInstId);
    }

    public List<WfFlowVariable> viewFlowVariablesByVarname(long flowInstId,
            String varname) {
        return this
                .listObjects(
                        "From WfFlowVariable where cid.flowInstId=? and cid.varName=? order by cid.runToken",
                        new Object[] { flowInstId, varname });
    }
}
