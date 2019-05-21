package com.centit.workflow.sample.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.core.utils.PageDesc;
import com.centit.workflow.sample.po.WfFlowInstance;

public class WfFlowInstanceDao extends BaseDaoImpl<WfFlowInstance> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("flowInstId", CodeBook.EQUAL_HQL_ID);
            filterField.put("wfid", CodeBook.LIKE_HQL_ID);
            filterField.put("version", CodeBook.LIKE_HQL_ID);
            filterField.put("createtime",
                    "createtime like to_date(?,'yyyy-mm-dd')");
            filterField.put("lastUpdateTime",
                    "lastUpdateTime like to_date(?,'yyyy-mm-dd')");
            filterField.put("inststate", CodeBook.EQUAL_HQL_ID);
            filterField.put("issubinst", CodeBook.LIKE_HQL_ID);
            filterField.put("flowOptName", CodeBook.LIKE_HQL_ID);
            filterField.put("flowOptTag", CodeBook.LIKE_HQL_ID);
            filterField.put("preinstid", CodeBook.LIKE_HQL_ID);
            filterField.put("prenodeinstid", CodeBook.LIKE_HQL_ID);
            filterField.put("unitcode", CodeBook.LIKE_HQL_ID);
            filterField.put("usercode", CodeBook.LIKE_HQL_ID);
            filterField
                    .put("nodeid",
                            "flowInstId in (select flowInstId from WfNodeInstance where nodeState='N' and nodeId=to_number(?))");
            filterField
                    .put("optcode",
                            "flowInstId in "
                                    + "(select a.flowInstId from WfNodeInstance a,WfNode b where a.nodeId=b.nodeId and a.nodeState='N' and b.optCode=?)");

            filterField.put("nocom", "inststate<> ?");
            filterField.put(CodeBook.ORDER_BY_HQL_ID,
                    "createtime desc,flowInstId desc");

        }
        return filterField;
    }

    public long getNextFlowInstId() {
        String sNo = getNextValueOfSequence("S_FLOWINSTNO");
        return Long.valueOf(sNo);
    }

    /**
     * 更新流程实例状态
     * 
     * @param instid
     *            实例编号
     * @param state
     */
    public void updtFlowInstState(long instid, String state) {
        WfFlowInstance flowInst = this.getObjectById(instid);
        flowInst.setInstState(state);
        this.saveObject(flowInst);
    }

    /**
     * 获取用户参与 流程实例 按照时间倒序排列
     * 
     * @param userCode
     *            用户代码
     * @param pageDesc
     *            分页描述
     * @return
     */
    public List<WfFlowInstance> listUserAttachFlowInstance(String userCode,
            String flowPhase, Map<String, Object> filterMap, PageDesc pageDesc) {
        String shql = "from WfFlowInstance where flowInstId in (select distinct u.cid.flowInstId from VUserAttachFlow u ";
        if (filterMap.get("oper") != null
                && filterMap.get("oper").equals("all")) {
            shql += " )";
        } else {
            shql += " where u.cid.userCode="
                    + HQLUtils.buildHqlStringForSQL(userCode)
                    + " and u.cid.flowPhase in (";

            if (flowPhase != null && flowPhase.equals("fw")) {
                shql += "'fw','yh','qf','zwh','pb','ysp','gz'";
            } else {
                shql += "'sw','pf','ys' ";
            }
            shql += " ) )";
        }

        return this.listObjects(shql, filterMap, pageDesc);
    }

    // 不计时N、计时T(有期限)、暂停P 忽略(无期限) F
    // expireOptSign == 0未处理 1 已通知 ,2..6 已通知2..5次（暂时不启动重复通知）6:不处理 7：已挂起 8 已终止 9
    // 已完成
    public List<WfFlowInstance> listNearExpireFlowInstance(long leaveLimit) {
        return this
                .listObjects(
                        "From WfFlowInstance"
                                + " where timeLimit <= ? and expireOptSign<6 and inststate='N' and isTimer='T'",
                        leaveLimit);
    }

    public void updateTimeConsume(long consumeTime) {
        this.doExecuteHql(
                "update WfFlowInstance set timeLimit =timeLimit- ? "
                        + "where inststate='N' and isTimer='T' and timeLimit is not null  ",
                consumeTime);
    }

    /**
     * 查询最后更改的流程
     * 
     * @param userCode
     * @param state
     * @return
     */
    public List<WfFlowInstance> listLastUpdateFlowInst(String userCode,
            String state) {
        return this
                .listObjects(
                        "From WfFlowInstance"
                                + " where lastUpdateUser = ? and nodeState=? order by lastUpdateTime ",
                        new Object[] { userCode, state });
    }

    /**
     * 查询所有活动的流程
     * 
     * @return
     */
    public List<WfFlowInstance> listAllActiveFlowInst() {
        return this.listObjects("From WfFlowInstance where inststate = 'N'");
    }

    public List<WfFlowInstance> listAllActiveTimerFlowInst() {
        return this
                .listObjects("From WfFlowInstance where inststate = 'N' and isTimer='T'"); // (
                                                                                           // isTimer='T'
                                                                                           // or
                                                                                           // isTimer='F'
                                                                                           // )
                                                                                           // ");
    }

    /**
     * 查询某人操作定时任务的流程
     * 
     * @param userCode
     * @param state
     * @return
     */
    public List<WfFlowInstance> listFlowInstByTimer(String userCode,
            String isTimer) {
        return this
                .listObjects(
                        "From WfFlowInstance"
                                + " where lastUpdateUser = ? and isTimer =? order by lastUpdateTime ",
                        new Object[] { userCode, isTimer });
    }

    /**
     * 更新流程实例时钟状态
     * 
     * @param instid
     *            实例编号
     * @param isTimer
     *            不计时N、计时T(有期限)、暂停P 忽略(无期限) F
     */
    public void updateFlowTimerState(long instid, String isTimer,
            String mangerUserCode) {
        WfFlowInstance flowInst = this.getObjectById(instid);
        flowInst.setIsTimer(isTimer);
        flowInst.setLastUpdateUser(mangerUserCode);
        flowInst.setLastUpdateTime(new Date(System.currentTimeMillis()));
        this.saveObject(flowInst);
    }
}
