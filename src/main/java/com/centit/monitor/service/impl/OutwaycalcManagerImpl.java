package com.centit.monitor.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.OutwayDao;
import com.centit.monitor.dao.OutwaycalcDao;
import com.centit.monitor.po.Outwaycalc;
import com.centit.monitor.service.OutwaycalcManager;

public class OutwaycalcManagerImpl extends BaseEntityManagerImpl<Outwaycalc>
        implements OutwaycalcManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OutwaycalcManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private OutwaycalcDao outwaycalcDao;
    private OutwayDao outwayDao;

    public void setOutwaycalcDao(OutwaycalcDao baseDao) {
        this.outwaycalcDao = baseDao;
        setBaseDao(this.outwaycalcDao);
    }

    public void setOutwayDao(OutwayDao outwayDao) {
        this.outwayDao = outwayDao;
    }

    public List<Outwaycalc> getOutWayCalcList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return outwaycalcDao.getOutwaycalcList(filterMap, pageDesc);
    }

    @Override
    public Outwaycalc start(String caller, String callType) {
        Outwaycalc calc = new Outwaycalc();
        Date curDate = new Date();
        calc.setCalcNo(outwaycalcDao.getNextLongSequence("S_Out_Way_No"));
        calc.setCalcTime(curDate);
        calc.setCaller(caller);
        calc.setCallType(callType);
        calc.setScopeBegin(curDate);
        outwaycalcDao.save(calc);
        return calc;
    }

    @Override
    public void end(Outwaycalc calc) {
        Date curDate = new Date();
        calc.setScopeEnd(curDate);
        calc.setAlertPieces(outwayDao.getAlertCount(calc.getCalcNo()));
        calc.setAlarmPieces(outwayDao.getAlarmCount(calc.getCalcNo()));
        outwaycalcDao.save(calc);
    }

}
