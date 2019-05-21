package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.workflow.sample.po.VUserTaskList;
import com.centit.workflow.sample.po.WfActionTask;

/**
 * 
 * 流程任务数据操作类
 * 
 * @author ljy
 * @version $Rev$ <br>
 *          $Id$
 */
public class WfActionTaskDao extends BaseDaoImpl<WfActionTask> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("taskid", CodeBook.EQUAL_HQL_ID);
            filterField.put("nodeinstid", CodeBook.EQUAL_HQL_ID);
            filterField.put("assigntime", CodeBook.EQUAL_HQL_ID);
            filterField.put("expiretime", CodeBook.EQUAL_HQL_ID);
            filterField.put("usercode", CodeBook.EQUAL_HQL_ID);
            filterField.put("roletype", CodeBook.EQUAL_HQL_ID);
            filterField.put("rolecode", CodeBook.EQUAL_HQL_ID);
            filterField.put("taskstate", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }

    /**
     * 生成主键编号
     * 
     * @return
     */
    public long getNextTaskId() {
        String sNo = getNextValueOfSequence("S_ACTIONTASKNO");
        return Long.valueOf(sNo);
    }

    /**
     * 根据用户编码获取用户任务列表
     * 
     * @param userCode
     *            userCode
     * @return List<WfActionTask>
     */
    @SuppressWarnings("unchecked")
    public List<VUserTaskList> getTasksByUser(String userCode) {
        String baseSQL = "from VUserTaskList where id.userCode = ? order by createtime";
        return (List<VUserTaskList>) findObjectsByHql(baseSQL, userCode);
    }

    @SuppressWarnings("unchecked")
    public List<VUserTaskList> getTasksByNodeInstId(long nodeinstid) {
        String baseSQL = "from VUserTaskList where cid.nodeInstId = ? ";
        return (List<VUserTaskList>) findObjectsByHql(baseSQL, nodeinstid);
    }

    @SuppressWarnings("unchecked")
    public List<VUserTaskList> getTasksByFlowid(long flowinstid) {
        String baseSQL = "from VUserTaskList where flowInstId = ? order by createtime";
        return (List<VUserTaskList>) findObjectsByHql(baseSQL, flowinstid);
    }

    @SuppressWarnings("unchecked")
    public VUserTaskList getUserTaskByNodeInstId(long nodeinstid,
            String userCode) {
        String baseSQL = "from VUserTaskList where id.nodeInstId = ? and id.userCode=? ";
        List<VUserTaskList> utl = (List<VUserTaskList>) findObjectsByHql(
                baseSQL, new Object[] { nodeinstid, userCode });
        if (utl == null || utl.size() == 0)
            return null;
        else
            return utl.get(0);

    }

    public List<WfActionTask> getActionTaskByNodeidAndUser(long nodeInstId,
            String userCode) {
        return this
                .listObjects(
                        "From WfActionTask where nodeinstid=? and usercode=? and ISVALID='T'",
                        new Object[] { nodeInstId, userCode });
    }

    @SuppressWarnings("unchecked")
    public List<WfActionTask> listActionTaskByNode(String userCode) {
        // String baseHQL =
        // "from WfActionTask t join WfNodeInstance i on i.nodeinstid = t.nodeinstid where i.nodestate <> 'C' and t.usercode = ?";
        // return this.listObjects(baseHQL,userCode);
        String baseSQL = "SELECT * FROM WF_ACTION_TASK T JOIN WF_NODE_INSTANCE I ON I.NODEINSTID = T.NODEINSTID WHERE I.NODESTATE <> 'C' AND T.USERCODE ="
                + HQLUtils.buildHqlStringForSQL(userCode);
        return (List<WfActionTask>) this.findObjectsBySql(baseSQL,
                WfActionTask.class);
    }

    @SuppressWarnings("unchecked")
    public String getTaskGrantor(long nodeInstId, String userCode) {
        String baseSQL = "from VUserTaskList where id.nodeInstId = ? and id.userCode=? ";
        List<VUserTaskList> utl = (List<VUserTaskList>) findObjectsByHql(
                baseSQL, new Object[] { nodeInstId, userCode });
        if (utl == null || utl.size() == 0)
            return null;
        /**
         * 优先已自己的身份执行
         */
        String grantor = userCode;
        for (VUserTaskList task : utl) {
            if (task.getGrantor() == null || "".equals(task.getGrantor()))
                return userCode;
            else
                grantor = task.getGrantor();
        }
        return grantor;
    }

    @SuppressWarnings("unchecked")
    public boolean hasOptPower(long nodeInstId, String userCode,
            String grantorCode) {

        String baseSQL = "from VUserTaskList where id.nodeInstId = ? and id.userCode=? ";
        List<VUserTaskList> utl = (List<VUserTaskList>) findObjectsByHql(
                baseSQL, new Object[] { nodeInstId, userCode });
        if (utl == null || utl.size() == 0)
            return false;
        /**
         * 优先已自己的身份执行
         */
        if (grantorCode != null && !grantorCode.equals(userCode)) {
            for (VUserTaskList task : utl) {
                if (grantorCode.equals(task.getGrantor()))
                    return true;
            }
            return false;
        }
        return true;
    }

}
