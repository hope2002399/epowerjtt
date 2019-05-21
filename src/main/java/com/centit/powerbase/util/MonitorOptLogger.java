package com.centit.powerbase.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.util.StringUtils;

import com.centit.core.utils.PageDesc;
import com.centit.core.web.StartupListener;
import com.centit.monitor.po.Superviselog;
import com.centit.monitor.service.SuperviselogManager;

public class MonitorOptLogger implements IMonitorOptLog, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1213704398618624206L;

    public static final Log log = LogFactoryImpl.getLog(MonitorOptLogger.class);

    private String optId;

    public MonitorOptLogger(String optId) {
        this.optId = optId;
    }

    private static void save(Superviselog superviselog) {
        SuperviselogManager superviselogManager = getOptLogMag();

        superviselogManager.saveObject(superviselog);

        if (log.isInfoEnabled()) {
            log.info(superviselog);
        }

    }

    private static SuperviselogManager getOptLogMag() {
        SuperviselogManager superviselogManager = StartupListener
                .getCurrentWebApplicationContext().getBean(
                        "superviselogManager", SuperviselogManager.class);
        return superviselogManager;
    }

    @Override
    public void log(String usercode, String optId, String tagId,
            String optMethod, String optContent, String oldValue, String bjType) {
        save(new Superviselog(usercode, optId, tagId, optMethod, optContent,
                oldValue, bjType, "1"));
    }

    @Override
    public void log(String usercode, String tagId, String optContent,
            String oldValue, String bjType) {
        this.log(usercode, this.optId, tagId, Thread.currentThread()
                .getStackTrace()[2].getMethodName(), optContent, oldValue,
                bjType);

    }

    @Override
    public void log(String usercode, String tagId, String optContent,
            String bjType) {
        this.log(usercode, this.optId, tagId, Thread.currentThread()
                .getStackTrace()[2].getMethodName(), optContent, null, bjType);

    }

    @Override
    public void log(Superviselog superviselog) {
        if (!StringUtils.hasText(superviselog.getOptid())) {
            superviselog.setOptid(this.optId);
        }
        if (!StringUtils.hasText(superviselog.getOptmethod())) {
            superviselog.setOptmethod(Thread.currentThread().getStackTrace()[2]
                    .getMethodName());
        }

        save(superviselog);
    }

    @Override
    public List<Superviselog> listMonitorOptLog(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return getOptLogMag().listObjects(filterMap, pageDesc);
    }

    @Override
    public List<Superviselog> listMonitorOptLog(Map<String, Object> filterMap) {
        return getOptLogMag().listObjects(filterMap);
    }

    // 法制监督操作日志
    @Override
    public void logFZ(String usercode, String optId, String tagId,
            String optMethod, String optContent, String oldValue, String bjType) {
        save(new Superviselog(usercode, optId, tagId, optMethod, optContent,
                oldValue, bjType, "2"));
    }

    @Override
    public void logFZ(String usercode, String tagId, String optContent,
            String oldValue, String bjType) {
        this.logFZ(usercode, this.optId, tagId, Thread.currentThread()
                .getStackTrace()[2].getMethodName(), optContent, oldValue,
                bjType);

    }

    @Override
    public void logFZ(String usercode, String tagId, String optContent,
            String bjType) {
        this.logFZ(usercode, this.optId, tagId, Thread.currentThread()
                .getStackTrace()[2].getMethodName(), optContent, null, bjType);

    }

}
