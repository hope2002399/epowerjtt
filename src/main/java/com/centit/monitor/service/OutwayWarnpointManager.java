package com.centit.monitor.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.OutwayWarnpoint;

/**
 * 
 * 预报警规则定义的接口
 * 
 * @author jf
 * @create 2014-2-11
 * @version
 */
public interface OutwayWarnpointManager extends
        BaseEntityManager<OutwayWarnpoint> {

    /**
     * 创建存错过程
     * 
     * @param pSql
     *            存储过程SQL
     */
    public void createProcedure(OutwayWarnpoint object);

    /**
     * 根据运行规则查询需要自动执行的预警
     * 
     * @param calcNo
     *            批次号
     * @param wpExeRule
     */
    public void runAutoProcedure(Long calcNo, String wpExeRule);

    /**
     * 指定存储过程运行
     * 
     * @param wpOracle
     */
    public void runProcedure(Long calcNo, OutwayWarnpoint wp);

}
