package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Outwaycalc;

public interface OutwaycalcManager extends BaseEntityManager<Outwaycalc> {
    // 获取outwaycalclist
    public List<Outwaycalc> getOutWayCalcList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    /**
     * 启动一批预报警规则运算，记录日志
     * 
     * @param caller
     * @return
     */
    public Outwaycalc start(String caller, String callType);

    /**
     * 结束一批预报警规则运算，记录日志
     */
    public void end(Outwaycalc calc);

}
