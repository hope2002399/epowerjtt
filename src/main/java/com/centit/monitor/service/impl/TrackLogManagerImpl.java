package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.TrackLogDao;
import com.centit.monitor.dao.VTrackLogDao;
import com.centit.monitor.po.TrackLog;
import com.centit.monitor.po.VTrackLog;
import com.centit.monitor.service.TrackLogManager;

public class TrackLogManagerImpl extends BaseEntityManagerImpl<TrackLog>
        implements TrackLogManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(TrackLogManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private TrackLogDao trackLogDao;
    private VTrackLogDao vTrackLogDao;

    public VTrackLogDao getvTrackLogDao() {
        return vTrackLogDao;
    }

    public void setvTrackLogDao(VTrackLogDao vTrackLogDao) {
        this.vTrackLogDao = vTrackLogDao;
    }

    public void setTrackLogDao(TrackLogDao baseDao) {
        this.trackLogDao = baseDao;
        setBaseDao(this.trackLogDao);
    }

    public void trackLogSave(TrackLog info) {
        this.saveObject(info);
    }

    // 获取监察人员下一个编码
    public String genNextChangeId() {
        return trackLogDao.genNextChangeId();
    }

    // 查询跟踪表格里面办件list
    public List<VTrackLog> getTrackLogList(Map<String, Object> filterMap) {
        return vTrackLogDao.getTrackLogList(filterMap);
    }

    public TrackLog getTrackLog(Map<String, Object> filterMap) {
        return trackLogDao.getTrackLog(filterMap);
    }
}
