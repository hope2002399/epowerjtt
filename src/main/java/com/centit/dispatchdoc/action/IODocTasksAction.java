package com.centit.dispatchdoc.action;

import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.po.DispatchDocTask;
import com.centit.dispatchdoc.po.IncomeDocTask;
import com.centit.dispatchdoc.service.DispatchDocManager;
import com.centit.dispatchdoc.service.IODocTasksManager;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.service.OptBaseInfoManager;
import com.centit.sys.security.FUserDetail;
import com.centit.workflow.FlowDefine;
import com.centit.workflow.FlowDescribe;

public class IODocTasksAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private IODocTasksManager ioDocTasksManager;

    private DispatchDocManager dispatchDocManager;

    private FlowDefine flowDefine;

    private List<IncomeDocTask> incomeDocList;

    private List<DispatchDocTask> dispatchDocList;

    private OptBaseInfoManager optBaseInfoManager;

    private Long flowInstId;

    private int totalRows;

    private List<FlowDescribe> flowList;

    public String refreshTasks() {
        OptBaseInfo optBase = optBaseInfoManager.getOptBaseByFlowId(flowInstId);

        String djId = "";
        if (optBase != null) {
            djId = optBase.getDjId();
        }

        return djId.indexOf("FW") != -1 ? listDispatchDocTasks()
                : listIncomeDocTasks();
    }

    /**
     * 收文待办查询
     * 
     * @return
     */
    public String listIncomeDocTasks() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            String userCode = fuser.getUsercode();
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            filterMap.put("userCode", userCode);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            incomeDocList = ioDocTasksManager.listIncomeDocTask(filterMap,
                    pageDesc);
            totalRows = pageDesc.getTotalRows();
            return "IncomeDocTask";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    /**
     * 发文待办查询
     * 
     * @return
     */
    public String listDispatchDocTasks() {
        // TODO 发文
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            String userCode = fuser.getUsercode();
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            filterMap.put("userCode", userCode);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            dispatchDocList = ioDocTasksManager.listDispatchDocTask(filterMap,
                    pageDesc);
            totalRows = pageDesc.getTotalRows();
            return "DispatchDocTask";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 选择流程
     * 
     * @return
     */
    public String ioSelectFlow() {
        try {
            flowList = flowDefine.getFlowsByOptId("IO_DOC");

            savedMessage();
            return "ioSelectFlow";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            saveError(e.getMessage());
            return ERROR;
        }
    }

    public void setIoDocTasksManager(IODocTasksManager ioDocTasksManager) {
        this.ioDocTasksManager = ioDocTasksManager;
    }

    public List<IncomeDocTask> getIncomeDocList() {
        return incomeDocList;
    }

    public void setIncomeDocList(List<IncomeDocTask> incomeDocList) {
        this.incomeDocList = incomeDocList;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<DispatchDocTask> getDispatchDocList() {
        return dispatchDocList;
    }

    public void setDispatchDocList(List<DispatchDocTask> dispatchDocList) {
        this.dispatchDocList = dispatchDocList;
    }

    public DispatchDocManager getDispatchDocManager() {
        return dispatchDocManager;
    }

    public void setDispatchDocManager(DispatchDocManager dispatchDocManager) {
        this.dispatchDocManager = dispatchDocManager;
    }

    public void setOptBaseInfoManager(OptBaseInfoManager optBaseInfoManager) {
        this.optBaseInfoManager = optBaseInfoManager;
    }

    public Long getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public List<FlowDescribe> getFlowList() {
        return flowList;
    }

    public void setFlowList(List<FlowDescribe> flowList) {
        this.flowList = flowList;
    }

    public void setFlowDefine(FlowDefine flowDefine) {
        this.flowDefine = flowDefine;
    }

}
