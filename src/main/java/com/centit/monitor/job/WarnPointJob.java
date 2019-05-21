package com.centit.monitor.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.centit.monitor.Unit.Constant;
import com.centit.monitor.po.Outwaycalc;
import com.centit.monitor.service.OutwayWarnpointManager;
import com.centit.monitor.service.OutwaycalcManager;

/**
 * 
 * 预报警规则定时任务
 * 
 * @author jf
 * @create 2014-2-20
 * @version
 */
public class WarnPointJob extends QuartzJobBean {

    private String wpExeRule;

    private OutwayWarnpointManager outwayWarnpointManager;

    private OutwaycalcManager outwaycalcManager;

    public void setWpExeRule(String wpExeRule) {
        this.wpExeRule = wpExeRule;
    }

    public void setOutwayWarnpointManager(
            OutwayWarnpointManager outwayWarnpointManager) {
        this.outwayWarnpointManager = outwayWarnpointManager;
    }

    public void setOutwaycalcManager(OutwaycalcManager outwaycalcManager) {
        this.outwaycalcManager = outwaycalcManager;
    }

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        Outwaycalc calc = outwaycalcManager.start(null, Constant.ExeType_Auto);
        outwayWarnpointManager.runAutoProcedure(calc.getCalcNo(), wpExeRule);
        outwaycalcManager.end(calc);
    }

}
