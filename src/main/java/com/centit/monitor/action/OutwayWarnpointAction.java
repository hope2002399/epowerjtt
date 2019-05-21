package com.centit.monitor.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.Unit.Constant;
import com.centit.monitor.po.OutwayWarnpoint;
import com.centit.monitor.po.Outwaycalc;
import com.centit.monitor.service.OutwayWarnpointManager;
import com.centit.monitor.service.OutwaycalcManager;

/**
 * 
 * 定义预报警规则Action
 * 
 * @author jf
 * @create 2014-2-11
 * @version
 */
public class OutwayWarnpointAction extends
        BaseEntityExtremeAction<OutwayWarnpoint> {
    private static final long serialVersionUID = 1L;
    private OutwayWarnpointManager outwayWarnpointManager;
    private OutwaycalcManager outwaycalcManager;

    public void setOutwayWarnpointManager(OutwayWarnpointManager basemgr) {
        outwayWarnpointManager = basemgr;
        this.setBaseEntityManager(outwayWarnpointManager);
    }

    public void setOutwaycalcManager(OutwaycalcManager outwaycalcManager) {
        this.outwaycalcManager = outwaycalcManager;
    }

    /**
     * 保存预报警规则
     */
    @Override
    public String save() {
        String result = super.save();
        if (object.getWpOracleSql() != null) {
            outwayWarnpointManager.createProcedure(object);
        }

        return result;
    }

    /**
     * 手动运行规则
     * 
     * @return
     */
    public String run() {
        OutwayWarnpoint o = baseEntityManager.getObject(object);
        if (object == null) {
            return LIST;
        }
        if (o != null) {
            Outwaycalc calc = outwaycalcManager.start(this.getLoginUserName(),
                    Constant.ExeType_Manual);
            outwayWarnpointManager.runProcedure(calc.getCalcNo(), o);
            outwaycalcManager.end(calc);
        }
        return SUCCESS;
    }

}
