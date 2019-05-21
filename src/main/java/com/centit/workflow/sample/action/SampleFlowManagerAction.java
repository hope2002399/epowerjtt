package com.centit.workflow.sample.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.JSONOpt;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.workflow.ActionLog;
import com.centit.workflow.ActionTask;
import com.centit.workflow.FlowDefine;
import com.centit.workflow.FlowDescribe;
import com.centit.workflow.FlowEngine;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.FlowManager;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.ManageActionLog;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.UserTask;
import com.centit.workflow.sample.po.WfFlowDefine;
import com.opensymphony.xwork2.ModelDriven;

/**
 * FlowDescribe
 * 
 * 流程管理ACTION类
 * 
 * @author ljy
 * @version $Rev$ <br>
 *          $Id$
 */
public class SampleFlowManagerAction extends BaseAction implements
        ModelDriven<FlowInstance> {
    public static final Log log = LogFactory
            .getLog(SampleFlowManagerAction.class);
    private static final long serialVersionUID = 1L;

    private FlowManager flowMgr;
    private FlowDefine flowDef;
    private FlowEngine flowEngine;
    private List<FUserunit> unitList;
    private List<NodeInstance> nodeList;
    private List<ActionTask> taskList;
    private List<ActionLog> logList;
    private List<ManageActionLog> flowLogList;
    private List<UserTask> userTaskList;
    private List<FlowInstance> objList;
    protected Integer totalRows;
    protected Integer nd_totalRows;
    protected Integer wf_totalRows;
    private long nodeInstId;
    private long nodeId;
    private long flowInstId;
    private String nodeOptUrl;
    private String timeLimit;
    private Map<String, Set<String>> teamMap;
    private String roleCode;
    private JSONObject nodeOptInfo;
    private FlowInstance object;
    private List<FlowNodeInfo> flowNodeList;
    private String unitCode;

    public FlowInstance getModel() {
        return object;
    }

    /**
     * 流程实例检索查询
     * 
     * @return
     */
    public String list() {
        try {
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            objList = flowMgr.listFlowInstance(getFilterMap(), pageDesc);
            totalRows = pageDesc.getTotalRows();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 查询用户主单位下的流程
     * 
     * @return
     */
    public String listMyUnitFlow() {
        try {
            Map<String, Object> fieldMap = getFilterMap();
            fieldMap.put("unitcode",
                    ((FUserDetail) getLoginUser()).getPrimaryUnit());
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            objList = flowMgr.listFlowInstance(fieldMap, pageDesc);
            totalRows = pageDesc.getTotalRows();
            return "UnitFlow";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 根据单位流程获取节点信息
     * 
     * @return
     */
    public String listNodesByUnitFlow() {
        listFlowInstNodes();
        return "UnitNode";
    }

    /**
     * 当前用户参与的流程
     * 
     * @return
     */
    public String listUserAttach() {
        return listUserFlow();
        /*
         * Limit limit=ExtremeTableUtils.getLimit(request); PageDesc pageDesc =
         * ExtremeTableUtils.makePageDesc(limit); objList =
         * flowMgr.listUserAttachFlowInstance
         * (((FUserDetail)getLoginUser()).getUsercode(),getFilterMap(),
         * pageDesc); totalRows = pageDesc.getTotalRows(); return "UserAttach";
         */
    }

    /**
     * 查看用户相关流程
     * 
     * @return
     */
    public String listUserFlow() {
        Map<String, Object> filterMap = getFilterMap();
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);

        // if(filterMap.get("attachuser") != null){
        // objList =
        // flowMgr.listUserAttachFlowInstance(filterMap.get("attachuser"),getFilterMap(),
        // pageDesc);
        // }

        // 如果带参数oper,则为过滤当前用户流程，包括在办的或者完成的
        if (filterMap.get("oper") != null) {

            // 办结事项
            if (filterMap.get("oper").equals("comp")) {
                filterMap.put("inststate", "C");

            }
            if (!filterMap.get("oper").equals("all")) {
                // 默认当前在办
                filterMap.put("attachuser",
                        ((FUserDetail) getLoginUser()).getUsercode());
            }

        } else {
            if (filterMap.get("attachuser") == null
                    || filterMap.get("attachuser").toString().length() == 0) {
                filterMap.put("attachuser",
                        ((FUserDetail) getLoginUser()).getUsercode());
            }
        }

        // 默认提供参与用户动态查询条件，userFlowInstList.jsp --- s_attachuser属性调用
        objList = flowMgr.listUserAttachFlowInstance(
                ((FUserDetail) getLoginUser()).getUsercode(),
                (String) filterMap.get("flowPhase"), filterMap, pageDesc);
        request.setAttribute("s_attachuser", filterMap.get("attachuser"));
        request.setAttribute("s_inststate", filterMap.get("inststate"));
        totalRows = pageDesc.getTotalRows();

        return "UserFlow";
    }

    private Map<String, Object> getFilterMap() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        return filterMap;
    }

    /**
     * 当前用户创建的流程
     * 
     * @return
     */
    public String listUserCreate() {
        return listUserFlow();
        /*
         * Map<String,String> filterMap = getFilterMap();
         * filterMap.put("usercode"
         * ,((FUserDetail)getLoginUser()).getUsercode()); Limit
         * limit=ExtremeTableUtils.getLimit(request); PageDesc pageDesc =
         * ExtremeTableUtils.makePageDesc(limit); objList =
         * flowMgr.listUserCreateFlowInstance(filterMap,pageDesc); totalRows =
         * pageDesc.getTotalRows(); return "UserCreate";
         */
    }

    /**
     * 查找所有没有操作用户的节点
     * 
     * @return
     */
    public String listNoOptNodes() {
        nodeList = flowMgr.listNodesWithoutOpt();
        totalRows = nodeList.size();
        return "NOptNodes";
    }

    /**
     * 查询并管理某流程实例下的所有节点信息
     * 
     * @return String
     */
    public String listFlowInstNodes() {
        object = flowMgr.getFlowInstance(flowInstId);
        nodeList = flowMgr.listFlowInstNodes(flowInstId);
        flowLogList = flowMgr.listManageActionLog(flowInstId);

        FlowInstance flowInst = flowEngine.getFlowInstById(flowInstId);

        FlowDescribe flowDefine = flowDef.getFlowDefObject(flowInst
                .getFlowCode());
        Set<FlowNodeInfo> nodeSet = flowDefine.getFlowNodes();
        flowNodeList = new ArrayList<FlowNodeInfo>(nodeSet);
        nd_totalRows = nodeList.size();
        wf_totalRows = flowLogList.size();
        return "ListNodes";
    }

    public String createFlowNode() {
        long newNodeInst = flowMgr.createNodeInst(nodeId, flowInstId, unitCode,
                ((FUserDetail) getLoginUser()).getUsercode());
        this.setNodeInstId(newNodeInst);

        List<UserTask> userTask = flowMgr.listNodeTasks(newNodeInst);

        if (userTask == null || userTask.size() == 0) {
            FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nodeId);
            if (nodeInfo.getRoleType() != null
                    && nodeInfo.getRoleType().equals("bj")) {
                this.setRoleCode(nodeInfo.getRoleCode());
                return "AssignWorkTeam";
            }

            if (nodeInfo.getRoleType() != null
                    && nodeInfo.getRoleType().equals("en")) {
                return "listNodeInstTasks";
            }
        }
        return "RefreshNodes";
    }

    /**
     * 查看节点信息，没有任何操作权限
     * 
     * @return
     */
    public String viewFlowInstNodes() {
        listFlowInstNodes();
        return "ViewNodes";
    }

    /**
     * 修改孤儿节点实例机构
     * 
     * @return
     */
    public String modifyNodeInst() {
        flowMgr.saveNodeInstUnit(nodeInstId, unitCode,
                ((FUserDetail) getLoginUser()).getUsercode());
        return listNoOptNodes();
    }

    /**
     * 修改流程实例机构
     * 
     * @return
     */
    public String modifyFlowInst() {
        flowMgr.saveFlowInstUnit(flowInstId, unitCode,
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshFlowInst";
    }

    /**
     * 查询某节点实例下的任务信息
     * 
     * @return String
     */
    public String listNodeInstTasks() {
        taskList = flowMgr.listNodeActionTasks(nodeInstId);
        totalRows = taskList.size();
        return "ListTasks";
    }

    public String preAssignWorkTeam() {
        return "AssignWorkTeam";
    }

    public String assignWorkTeam() {
        String[] userCodes = request.getParameterValues("userCode");
        if (userCodes != null && userCodes.length > 0) {
            flowEngine.assignFlowWorkTeam(flowInstId, roleCode,
                    new HashSet<String>(Arrays.asList(userCodes)));
        }
        return "ListWorkTeam";
    }

    public String deleteWorkTeam() {
        flowEngine.deleteFlowWorkTeam(flowInstId, roleCode);
        return "ListWorkTeam";
    }

    public String deleteWorkTeamUser() {
        flowEngine.deleteFlowWorkTeam(flowInstId, roleCode,
                request.getParameter("userCode"));
        return "ListWorkTeam";
    }

    public String viewWorkTeam() {
        teamMap = flowEngine.viewFlowWorkTeam(flowInstId);
        return "teamList";
    }

    /**
     * 查询某节点实例下的日志信息
     * 
     * @return String
     */
    public String listNodeInstLogs() {
        logList = flowMgr.listNodeActionLogs(nodeInstId);
        totalRows = logList.size();
        return "ListLogs";
    }

    /*
     * 终止止一个流程实例
     */
    public String stopInstance() {
        flowMgr.stopInstance(flowInstId,
                ((FUserDetail) getLoginUser()).getUsercode(),
                request.getParameter("stopDesc"));
        return "RefreshNodes";
    }

    /*
     * 暂挂一个流程实例
     */
    public String suspendInstance() {
        flowMgr.suspendInstance(flowInstId,
                ((FUserDetail) getLoginUser()).getUsercode(),
                request.getParameter("stopDesc"));
        return "RefreshNodes";
    }

    /*
     * 唤醒一个暂挂流程实例
     */
    public String awakeInstance() {
        String mangerUserCode = ((FUserDetail) getLoginUser()).getUsercode();
        if (timeLimit != null && !"".equals(timeLimit.trim())) {
            flowMgr.activizeExpireInstance(flowInstId, timeLimit,
                    mangerUserCode, request.getParameter("authDesc"));
        } else {
            flowMgr.activizeInstance(flowInstId, mangerUserCode,
                    request.getParameter("authDesc"));
        }
        return "RefreshNodes";
    }

    /**
     * 回滚一个流程节点到上一节点
     */
    public String rollbackOpt() {
        flowMgr.rollbackOpt(nodeInstId,
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshNodes";
    }

    /**
     * 强制一个流程节点前进到下一个节点
     */
    public String forceCommit() {
        flowMgr.forceCommit(nodeInstId,
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshNodes";
    }

    /**
     * 针对一个正在运行的节点实例强制游离
     */
    public String forceDissociate() {
        flowMgr.forceDissociateRuning(nodeInstId,
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshNodes";
    }

    /**
     * 针对一个正在运行且被强制游离的节点实例，结束游离状态
     */
    public String stopDissociate() {
        flowMgr.stopDissociateNodeInst(nodeInstId,
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshNodes";
    }

    /**
     * 针对一个完成的节点实例，创建游离节点
     */
    public String createDissociate() {
        flowMgr.createDissociateNodeInst(nodeInstId,
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshNodes";
    }

    /**
     * 唤醒一个暂挂节点实例
     */
    public String awakeNodeInst() {
        String mangerUserCode = ((FUserDetail) getLoginUser()).getUsercode();
        if (timeLimit != null) {
            flowMgr.activizeExpireNodeInstance(nodeInstId, timeLimit,
                    mangerUserCode);
        } else {
            flowMgr.activizeNodeInstance(nodeInstId, mangerUserCode);
        }
        return "RefreshNodes";
    }

    /**
     * 从这个节点重新运行该流程，包括已经结束的流程
     * 
     * @return
     */
    public String resetToCurrent() {
        flowMgr.resetFlowToThisNode(nodeInstId,
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshNodes";
    }

    /**
     * 暂挂一个节点实例
     */
    public String suspendNodeInst() {
        flowMgr.suspendNodeInstance(nodeInstId,
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshNodes";
    }

    public List<FUserunit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUserunit> unitList) {
        this.unitList = unitList;

    }

    public void setFlowManager(FlowManager flowMgr) {
        this.flowMgr = flowMgr;
        // this.setBaseEntityManager(flowMgr);
    }

    public FlowManager getFlowManager() {
        return flowMgr;
    }

    public void setFlowDefine(FlowDefine flowdef) {
        this.flowDef = flowdef;
    }

    public FlowDefine getFlowDefine() {
        return flowDef;
    }

    public List<NodeInstance> getNodeList() {
        return nodeList;
    }

    public List<ActionTask> getTaskList() {
        return taskList;
    }

    public List<ActionLog> getLogList() {
        return logList;
    }

    private String viewXml;
    private String xml;

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public void setViewXml(String viewXml) {
        this.viewXml = viewXml;
    }

    public String getViewXml() {
        return viewXml;
    }

    public String viewxml() {
        try {
            String instid = request.getParameter("flowInstId");
            if (instid != null) {
                flowInstId = Long.parseLong(instid);
            }
            FlowInstance dbobject = flowMgr.getFlowInstance(flowInstId);
            if (dbobject != null) {
                WfFlowDefine wfFlow = flowDef.getFlowDefObject(
                        dbobject.getFlowCode(), dbobject.getVersion());
                xml = wfFlow.getFlowXmlDesc();
                viewXml = flowMgr.viewFlowInstance(dbobject.getFlowInstId());
                return "viewxml";
            } else {
                return "flowerror";
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    /**
     * 返回节点的操作记录，或者日志
     * 
     * @return
     */
    public String viewFlowNodeInfo() {
        try {

            FlowInstance dbobject = flowMgr.getFlowInstance(flowInstId);
            FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nodeId);
            nodeOptInfo = new JSONObject();
            if (dbobject == null || nodeInfo == null)
                return "nodeinfo";
            nodeOptInfo.element("nodename", nodeInfo.getNodeName());
            int nodeInstInd = 0;
            for (NodeInstance nodeInst : dbobject.getNodeInstances()) {
                if (nodeInst.getNodeId().equals(nodeId)) {

                    JSONOpt.setAttribute(nodeOptInfo, "instance[" + nodeInstInd
                            + "].createtime", DatetimeOpt
                            .convertDatetimeToString(nodeInst.getCreateTime()));
                    JSONOpt.setAttribute(nodeOptInfo, "instance[" + nodeInstInd
                            + "].unitcode", nodeInst.getUnitCode());
                    JSONOpt.setAttribute(
                            nodeOptInfo,
                            "instance[" + nodeInstInd + "].unitname",
                            CodeRepositoryUtil.getValue("unitcode",
                                    nodeInst.getUnitCode()));

                    if ("N".equals(nodeInst.getNodeState())
                            || "R".equals(nodeInst.getNodeState())) {
                        List<UserTask> tasks = flowMgr.listNodeTasks(nodeInst
                                .getNodeInstId());
                        JSONOpt.setAttribute(nodeOptInfo, "instance["
                                + nodeInstInd + "].state", "办理中");
                        int taskInd = 0;
                        for (UserTask task : tasks) {

                            JSONOpt.setAttribute(nodeOptInfo, "instance["
                                    + nodeInstInd + "].task[" + taskInd
                                    + "].usercode", task.getUserCode());
                            JSONOpt.setAttribute(nodeOptInfo, "instance["
                                    + nodeInstInd + "].task[" + taskInd
                                    + "].username", CodeRepositoryUtil
                                    .getValue("usercode", task.getUserCode()));
                            taskInd++;
                        }
                    } else {
                        JSONOpt.setAttribute(nodeOptInfo, "instance["
                                + nodeInstInd + "].state",
                                CodeRepositoryUtil.getValue("WFInstType",
                                        nodeInst.getNodeState()));

                        List<ActionLog> actions = flowMgr
                                .listNodeActionLogs(nodeInst.getNodeInstId());
                        int actionInd = 0;
                        for (ActionLog action : actions) {
                            JSONOpt.setAttribute(nodeOptInfo, "instance["
                                    + nodeInstInd + "].action[" + actionInd
                                    + "].usercode", action.getUserCode());
                            JSONOpt.setAttribute(nodeOptInfo, "instance["
                                    + nodeInstInd + "].action[" + actionInd
                                    + "].username", CodeRepositoryUtil
                                    .getValue("usercode", action.getUserCode()));
                            JSONOpt.setAttribute(nodeOptInfo, "instance["
                                    + nodeInstInd + "].action[" + actionInd
                                    + "].actiontime", DatetimeOpt
                                    .convertDatetimeToString(action
                                            .getActionTime()));
                            JSONOpt.setAttribute(nodeOptInfo, "instance["
                                    + nodeInstInd + "].action[" + actionInd
                                    + "].actiontype", CodeRepositoryUtil
                                    .getValue("WfActionType",
                                            action.getActionType()));
                            actionInd++;
                        }
                    }
                    nodeInstInd++;
                }
            }
            nodeOptInfo.element("count", nodeInstInd);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "nodeinfo";
    }

    public List<UserTask> getUserTaskList() {
        return userTaskList;
    }

    public void setUserTaskList(List<UserTask> userTaskList) {
        this.userTaskList = userTaskList;
    }

    public List<ManageActionLog> getFlowLogList() {
        return flowLogList;
    }

    public List<FlowInstance> getObjList() {
        return objList;
    }

    public void setObjList(List<FlowInstance> objList) {
        this.objList = objList;
    }

    public long getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public Integer getNd_totalRows() {
        return nd_totalRows;
    }

    public void setNd_totalRows(Integer nd_totalRows) {
        this.nd_totalRows = nd_totalRows;
    }

    public Integer getWf_totalRows() {
        return wf_totalRows;
    }

    public void setWf_totalRows(Integer wf_totalRows) {
        this.wf_totalRows = wf_totalRows;
    }

    public String getNodeOptUrl() {
        return nodeOptUrl;
    }

    public void setNodeOptUrl(String nodeOptUrl) {
        this.nodeOptUrl = nodeOptUrl;
    }

    public long getNodeInstId() {
        return nodeInstId;
    }

    public void setNodeInstId(long nodeInstId) {
        this.nodeInstId = nodeInstId;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public FlowInstance getObject() {
        return object;
    }

    public void setObject(FlowInstance object) {
        this.object = object;
    }

    public FlowEngine getFlowEngine() {
        return flowEngine;
    }

    public void setFlowEngine(FlowEngine flowEngine) {
        this.flowEngine = flowEngine;
    }

    public Map<String, Set<String>> getTeamMap() {
        return teamMap;
    }

    public void setTeamMap(Map<String, Set<String>> teamMap) {
        this.teamMap = teamMap;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public JSONObject getNodeOptInfo() {
        return nodeOptInfo;
    }

    public void setNodeOptInfo(JSONObject nodeOptInfo) {
        this.nodeOptInfo = nodeOptInfo;
    }

    public List<FlowNodeInfo> getFlowNodeList() {
        return flowNodeList;
    }

    public void setFlowNodeList(List<FlowNodeInfo> flowNodeList) {
        this.flowNodeList = flowNodeList;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

}
