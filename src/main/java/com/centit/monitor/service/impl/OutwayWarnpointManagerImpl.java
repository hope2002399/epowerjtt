package com.centit.monitor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.Unit.Constant;
import com.centit.monitor.dao.OutwayWarnpointDao;
import com.centit.monitor.po.OutwayWarnpoint;
import com.centit.monitor.service.OutwayWarnpointManager;
import com.centit.support.utils.StringBaseOpt;

/**
 * 
 * 预报警规则定义的接口实现类
 * 
 * @author jf
 * @create 2014-2-11
 * @version
 */
public class OutwayWarnpointManagerImpl extends
        BaseEntityManagerImpl<OutwayWarnpoint> implements
        OutwayWarnpointManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(OutwayWarnpointManager.class);

    private OutwayWarnpointDao outwayWarnpointDao;

    public void setOutwayWarnpointDao(OutwayWarnpointDao baseDao) {
        this.outwayWarnpointDao = baseDao;
        setBaseDao(this.outwayWarnpointDao);
    }

    @Override
    public void createProcedure(OutwayWarnpoint object) {
        if (object.getWpOracleSql() != null) {
            StringBuffer pSql = new StringBuffer();
            pSql.append("create or replace procedure ");
            pSql.append(object.getWpOracle())
                    .append("(calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)");
            pSql.append(" is");
            pSql.append(object.getWpOracleSql());
            String sql = pSql.toString();
            sql = sql.replaceAll("\r\n", " ");
            outwayWarnpointDao.createProcedure(sql, object.getWpOracle());
        }

    }

    public void runAutoProcedure(Long calcNo, String wpExeRule) {
        Map<String, Object> filterDesc = new HashMap<String, Object>();
        filterDesc.put("wpExeType", Constant.ExeType_Auto);
        filterDesc.put("wpExeRule", wpExeRule);
        filterDesc.put("wpStatus", Constant.YesOrNo_True);
        List<OutwayWarnpoint> datas = outwayWarnpointDao
                .listObjects(filterDesc);
        for (OutwayWarnpoint wp : datas) {
            runProcedure(calcNo, wp);
        }
    }

    @Override
    public void runProcedure(Long calcNo, OutwayWarnpoint wp) {
        if (!StringBaseOpt.isNvl(wp.getWpOracle())) { // 判断是否有存储过程
            Object[] paramObjs = new Object[6];
            // 参数顺序固化
            paramObjs[0] = calcNo; // calcNo
            paramObjs[1] = wp.getWpLevelNo(); // V_MONITOR_STYLE
            paramObjs[2] = wp.getWpTypeNo(); // V_MONITOR_TYPE
            paramObjs[3] = wp.getWpNo(); // V_Warning_Code
            paramObjs[4] = wp.getWpName(); // V_MONITOR_LOGO
            paramObjs[5] = wp.getWpSource(); // V_MONITOR_SOURCE
            boolean result = this.outwayWarnpointDao.callProcedure(
                    wp.getWpOracle(), paramObjs);
            if (!result) {
                log.debug("批次" + calcNo + "执行" + wp.getWpOracle() + "存储过程调用失败");
            }
        }
    }

}
