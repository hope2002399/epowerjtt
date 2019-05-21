package com.centit.workflow.sample.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfNodeInstance;

public class WfNodeInstanceDao extends BaseDaoImpl<WfNodeInstance> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("nodeinstid", CodeBook.EQUAL_HQL_ID);
            filterField.put("wfinstid", CodeBook.LIKE_HQL_ID);
            filterField.put("nodeid", CodeBook.LIKE_HQL_ID);
            filterField.put("createtime",
                    "createtime like to_date(?,'yyyy-mm-dd')");
            filterField.put("lastUpdateTime",
                    "lastUpdateTime like to_date(?,'yyyy-mm-dd')");
            filterField.put("lastUpdateUser", CodeBook.EQUAL_HQL_ID);
            filterField.put("starttime", CodeBook.LIKE_HQL_ID);
            filterField.put("nodestate", CodeBook.LIKE_HQL_ID);
            filterField.put("subwfinstid", CodeBook.LIKE_HQL_ID);
            filterField.put("unitcode", CodeBook.LIKE_HQL_ID);
            filterField.put("transid", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "nodeInstId desc");

        }
        return filterField;
    }

    public long getNextNodeInstId() {
        String sNo = getNextValueOfSequence("S_NODEINSTNO");
        return Long.valueOf(sNo);
    }

    /**
     * 根据节点实例编号，更新当前节点运行状态，
     * 
     * @param nodeinstid
     *            节点实例编号
     * @param state
     *            状态代码
     */

    public void updtNodeInstState(long nodeinstid, String state) {
        WfNodeInstance nodeInst = this.getObjectById(nodeinstid);
        nodeInst.setNodeState(state);
        this.saveObject(nodeInst);
    }

    public List<WfNodeInstance> listNodeInstByState(long flowInstId,
            String nodeState) {
        return listObjects("From WfNodeInstance where nodestate= '" + nodeState
                + "' and wfinstid= " + flowInstId);
    }

    public List<WfNodeInstance> listNodesWithoutOpt() {
        return listObjects("From WfNodeInstance where (nodestate='N' or nodestate='R') and  "
                + " nodeInstId not in (select id.nodeInstId from VUserTaskList) and "
                + " flowInstId in (select flowInstId from WfFlowInstance where instState='N' )order by id.nodeInstId desc");
    }

    // expireOptSign == 0未处理 1 已通知 ,2..6 已通知2..5次（暂时不启动重复通知） 6:不处理 7：已挂起 8 已终止 9
    // 已完成
    public List<WfNodeInstance> listNearExpireNodeInstance(long leaveTime) {
        return this
                .listObjects(
                        "From WfNodeInstance"
                                + " where timeLimit <= ? and expireOptSign < 6 and nodeState='N' and (isTimer='T' or isTimer='R')",
                        leaveTime);
    }

    public void updateTimeConsume(long consumeTime) {
        this.doExecuteHql(
                "update WfNodeInstance set timeLimit =timeLimit- ? "
                        + "where nodeState='N' and  isTimer='T' and timeLimit is not null  ",
                consumeTime);
    }

    /**
     * 查询最后更改的节点
     * 
     * @param userCode
     * @param state
     * @return
     */
    public List<WfNodeInstance> listLastUpdateNodeInst(String userCode,
            String state) {
        return this
                .listObjects(
                        "From WfNodeInstance"
                                + " where lastUpdateUser = ? and nodeState = ? order by lastUpdateTime ",
                        new Object[] { userCode, state });
    }

    /**
     * 查询某人操作定时任务的节点
     * 
     * @param userCode
     * @param state
     * @return
     */
    public List<WfNodeInstance> listNodeInstByTimer(String userCode,
            String isTimer) {
        return this
                .listObjects(
                        "From WfNodeInstance"
                                + " where lastUpdateUser = ? and isTimer = ? order by lastUpdateTime ",
                        new Object[] { userCode, isTimer });
    }

    /**
     * 更新节点实例时钟状态
     * 
     * @param instid
     *            实例编号
     * @param isTimer
     *            不计时N、计时T(有期限)、暂停P 忽略(无期限) F
     */
    public void updateNodeTimerState(long instid, String isTimer,
            String mangerUserCode) {
        WfNodeInstance nodeInst = this.getObjectById(instid);
        nodeInst.setIsTimer(isTimer);
        nodeInst.setLastUpdateUser(mangerUserCode);
        nodeInst.setLastUpdateTime(new Date(System.currentTimeMillis()));
        this.saveObject(nodeInst);
    }
}
