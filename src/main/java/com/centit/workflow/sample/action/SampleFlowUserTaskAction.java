/**
 * 
 */
package com.centit.workflow.sample.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.security.FUserDetail;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.FlowManager;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.UserTask;
import com.centit.workflow.sample.po.VUserTaskList;
import com.centit.workflow.sample.po.WfActionTask;
import com.centit.workflow.sample.po.WfTaskMove;

/**
 * 
 * 用户任务列表管理
 * 
 * @author ljy
 * @create 2012-3-27
 * @version
 */
public class SampleFlowUserTaskAction extends
        BaseEntityExtremeAction<WfActionTask> {
    private static final long serialVersionUID = 1L;

    private FlowManager flowManager;
    private String nextOptUrl;
    private long flowInstId;
    private String nodeOptUrl;

    private String optParam;
    private List<VUserTaskList> vUserTasksList;
    private List<UserTask> userTaskList;
    private List<NodeInstance> userCompNodesList;
    private WfTaskMove taskMoveObj;
    private List<WfTaskMove> moveTaskList;

    /**
     * 给一个节点指定任务、用这个代替系统自动分配任务
     */
    public String assign() {
        flowManager.assignTask(object.getNodeInstId(), object.getUserCode(),
                ((FUserDetail) getLoginUser()).getUsercode(),
                object.getExpireTime(), object.getAuthDesc());
        return "RefreshTasks";
    }

    /**
     * 查看任务信息
     * 
     * @return
     */
    public String preAssignTask() {
        return "TaskEdit";
    }

    /**
     * 收回一个分配的任务
     * 
     * @return
     */
    public String disableTask() {
        flowManager.disableTask(object.getTaskId(),
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshTasks";
    }

    /**
     * 删除任务
     * 
     * @return
     */
    public String deleteTask() {
        flowManager.deleteTask(object.getTaskId(),
                ((FUserDetail) getLoginUser()).getUsercode());
        return "RefreshTasks";
    }

    /**
     * 任务列表查询，查询条件可自助添加
     */
    public String listNodeOpers() {
        userTaskList = flowManager.listNodeTasks(object.getNodeInstId());
        totalRows = userTaskList.size();
        return "NodeOpers";
    }

    /**
     * 任务列表查询，查询条件可自助添加
     */
    @SuppressWarnings("unchecked")
    public String list() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        String userCode = fuser.getUsercode();

        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put("userCode", userCode);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        vUserTasksList = flowManager.listUserTasks(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "UserTask";
    }

    /**
     * 用户已办事项
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String listUserCompTask() {
        String userCode = ((FUserDetail) getLoginUser()).getUsercode();
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put("lastUpdateUser", userCode);
        filterMap.put("nodestate", "C");
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        userCompNodesList = flowManager.listUserCompleteTasks(filterMap,
                pageDesc, userCode);
        totalRows = userCompNodesList.size();
        return "CompNodes";
    }

    /**
     * 用户挂起的待办事项
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String listUserSuspendTask() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put("lastUpdateUser",
                ((FUserDetail) getLoginUser()).getUsercode());
        filterMap.put("nodeState", "S");
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        userCompNodesList = flowManager.listUserSuspendNodeInst(filterMap,
                pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "SuspendNodes";
    }

    /**
     * 唤醒或者处理挂起的待办
     * 
     * @return
     */
    public String activeAndToNextStep() {
        flowManager.activizeNodeInstance(object.getNodeInstId(),
                ((FUserDetail) getLoginUser()).getUsercode());
        if (nodeOptUrl != null && nodeOptUrl.trim().length() > 0) {
            try {
                nextOptUrl = URLDecoder.decode(nodeOptUrl, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (optParam != null && !"".equals(optParam)) {
                nextOptUrl = nextOptUrl + "&optParam=" + optParam;
            }
            return "gotoNext";
        } else {
            return listUserSuspendTask();
        }
    }

    /**
     * 节点任务办理，提交后判断下一步是否有操作权限，如果有权限，直接进入下一办理界面
     * 
     * @return
     */
    public String nextStep() {
        FlowInstance inst = flowManager.getFlowInstance(flowInstId);
        long nextNodeInstId = 0l;
        for (NodeInstance nodeInst : inst.getActiveNodeInstances()) {
            String url = flowManager.getNodeOptUrl(nodeInst.getNodeInstId(),
                    ((FUserDetail) getLoginUser()).getUsercode());
            if (url != null && nextNodeInstId < nodeInst.getNodeInstId()
                    && !"".equals(url.trim())) {
                nextNodeInstId = nodeInst.getNodeInstId();
                nextOptUrl = "/" + url;
            }
        }
        if (nextNodeInstId > 0l)
            return "gotoNext";
        else
            return list();
    }

    public String todoWork() {
        FUserDetail u = (FUserDetail) this.getLoginUser();
        if (StringBaseOpt.isNvl(flowManager.getTaskGrantor(
                object.getNodeInstId(), u.getUsercode())))
            return "haveDone";
        return "todoWork";
    }

    /**
     * 收回用户待办任务
     * 
     * @return
     */
    public String reclaimUserTask() {
        if (flowManager.nodeCanBeReclaim(object.getNodeInstId())) {
            flowManager.resetFlowToThisNode(object.getNodeInstId(),
                    ((FUserDetail) getLoginUser()).getUsercode());
        }

        return listUserCompTask();
    }

    public String saveTaskMove() {
        taskMoveObj.setOperdate(new Date(System.currentTimeMillis()));
        taskMoveObj.setOperuser(((FUserDetail) getLoginUser()).getUsercode());
        flowManager.saveMoveTask(taskMoveObj);
        return listTaskMove();
    }

    public String listTaskMove() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        moveTaskList = flowManager.listMoveTask(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "listTaskMove";
    }

    public String getNextOptUrl() {
        return nextOptUrl;
    }

    public void setNextOptUrl(String nextOptUrl) {
        this.nextOptUrl = nextOptUrl;
    }

    public FlowManager getFlowManager() {
        return flowManager;
    }

    public void setFlowManager(FlowManager flowManager) {
        this.flowManager = flowManager;
    }

    public long getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public List<UserTask> getUserTaskList() {
        return userTaskList;
    }

    public void setUserTaskList(List<UserTask> userTaskList) {
        this.userTaskList = userTaskList;
    }

    public List<NodeInstance> getUserCompNodesList() {
        return userCompNodesList;
    }

    public void setUserCompNodesList(List<NodeInstance> userCompNodesList) {
        this.userCompNodesList = userCompNodesList;
    }

    public String getNodeOptUrl() {
        return nodeOptUrl;
    }

    public void setNodeOptUrl(String nodeOptUrl) {
        this.nodeOptUrl = nodeOptUrl;
    }

    public String getOptParam() {
        return optParam;
    }

    public void setOptParam(String optParam) {
        this.optParam = optParam;
    }

    public WfTaskMove getTaskMoveObj() {
        return taskMoveObj;
    }

    public void setTaskMoveObj(WfTaskMove taskMoveObj) {
        this.taskMoveObj = taskMoveObj;
    }

    public List<WfTaskMove> getMoveTaskList() {
        return moveTaskList;
    }

    public void setMoveTaskList(List<WfTaskMove> moveTaskList) {
        this.moveTaskList = moveTaskList;
    }

    public List<VUserTaskList> getVUserTasksList() {
        return vUserTasksList;
    }

    public void setVUserTasksList(List<VUserTaskList> vUserTasksList) {
        this.vUserTasksList = vUserTasksList;
    }

}
