package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.workflow.sample.po.WfTeam;

public class WfTeamDao extends BaseDaoImpl<WfTeam> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(WfTeamDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("flowinstid", "id.flowInstId=?");
            filterField.put("usercode", "id.userCode=?");
            filterField.put("rolecode", "id.roleCode=?");
            filterField.put("authdesc", CodeBook.LIKE_HQL_ID);
            filterField.put("authtime", CodeBook.EQUAL_HQL_ID);

            filterField
                    .put(CodeBook.ORDER_BY_HQL_ID, "id.wfinstid,id.rolecode");

        }
        return filterField;
    }

    public void deleteFlowWorkTeam(long flowInstId, String roleCode) {
        this.doExecuteHql(
                "delete WfTeam where id.flowInstId=? and id.roleCode=?",
                new Object[] { flowInstId, roleCode });
    }

    /**
     * 查询用户的所有办件
     * 
     * @param userCode
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<WfTeam> listTeamsByFlow(String userCode) {
        // String baseHQL =
        // "from WfTeam t join WfFlowInstance f on f.wfinstid = t.cid.wfinstid where f.inststate <> 'C' and t.usercode = ?";
        // return this.listObjects(baseHQL,userCode);
        String baseSQL = "SELECT T.* FROM WF_TEAM T JOIN WF_FLOW_INSTANCE F ON F.WFINSTID = T.WFINSTID WHERE F.INSTSTATE <> 'C' AND T.USERCODE ="
                + HQLUtils.buildHqlStringForSQL(userCode);
        return (List<WfTeam>) this.findObjectsBySql(baseSQL, WfTeam.class);
    }

    public List<WfTeam> listFlowWorkTeam(long flowInstId) {
        // Map<String,String> filterDesc = new HashMap<String,String>();
        // filterDesc.put("flowinstid",new Long(flowInstId).toString());
        return this.listObjects(
                "From WfTeam where cid.flowInstId=? order by cid.roleCode",
                flowInstId);
    }

    public List<WfTeam> listFlowWorkTeamByRole(long flowInstId, String roleCode) {
        // Map<String,String> filterDesc = new HashMap<String,String>();
        // filterDesc.put("flowinstid",new Long(flowInstId).toString());
        return this.listObjects(
                "From WfTeam where id.flowInstId=? and id.roleCode=?",
                new Object[] { flowInstId, roleCode });
    }
}
