package com.centit.dispatchdoc.service;

import java.util.List;
import java.util.Map;

import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.po.DispatchDocTask;
import com.centit.dispatchdoc.po.IncomeDocTask;

public interface IODocTasksManager {
    /**
     * 收文待办事项查询
     * 
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<IncomeDocTask> listIncomeDocTask(Map<String, Object> filterMap,
            PageDesc pageDesc);

    /**
     * 发文待办事项
     * 
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<DispatchDocTask> listDispatchDocTask(
            Map<String, Object> filterMap, PageDesc pageDesc);
}
