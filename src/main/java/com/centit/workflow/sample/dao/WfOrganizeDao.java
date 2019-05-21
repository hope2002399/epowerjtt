package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfOrganize;

public class WfOrganizeDao extends BaseDaoImpl<WfOrganize> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(WfOrganizeDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("flowinstid", "id.flowInstId=?");
            filterField.put("unitCode", "id.userCode=?");
            filterField.put("rolecode", "id.roleCode=?");
            filterField.put("authdesc", CodeBook.LIKE_HQL_ID);
            filterField.put("authtime", CodeBook.EQUAL_HQL_ID);

            filterField
                    .put(CodeBook.ORDER_BY_HQL_ID, "id.wfinstid,id.rolecode");

        }
        return filterField;
    }

    public void deleteFlowOrganize(long flowInstId, String roleCode) {
        this.doExecuteHql(
                "delete WfOrganize where id.flowInstId=? and id.roleCode=?",
                new Object[] { flowInstId, roleCode });
    }

    public List<WfOrganize> listFlowOrganize(long flowInstId) {
        // Map<String,String> filterDesc = new HashMap<String,String>();
        // filterDesc.put("flowinstid",new Long(flowInstId).toString());
        return this.listObjects(
                "From WfOrganize where cid.flowInstId=? order by cid.roleCode",
                flowInstId);
    }

    public List<WfOrganize> listFlowOrganizeByRole(long flowInstId,
            String roleCode) {
        // Map<String,String> filterDesc = new HashMap<String,String>();
        // filterDesc.put("flowinstid",new Long(flowInstId).toString());
        return this.listObjects(
                "From WfOrganize where id.flowInstId=? and id.roleCode=?",
                new Object[] { flowInstId, roleCode });
    }
}
