package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.TrackLog;
import com.centit.monitor.po.VTrackLog;

public interface TrackLogManager extends BaseEntityManager<TrackLog> {
    // 保存跟踪设置
    public void trackLogSave(TrackLog info);

    // 获取监察人员下一个编码
    public String genNextChangeId();

    // 查询跟踪表格里面办件list
    public List<VTrackLog> getTrackLogList(Map<String, Object> filterMap);

    public TrackLog getTrackLog(Map<String, Object> filterMap);
}
