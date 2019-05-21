package com.centit.monitor.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Supervisorypersonnel;

public interface SupervisorypersonnelManager extends
        BaseEntityManager<Supervisorypersonnel> {
    // 监察人员申报list
    public List<Supervisorypersonnel> supervisorypersonnelSBList(String flag,
            Map<String, Object> filterMap, PageDesc pageDesc);

    // 监察人员审核list
    public List<Supervisorypersonnel> supervisorypersonnelSHList(String flag,
            Map<String, Object> filterMap, PageDesc pageDesc);

    // 监察人员查询list
    public List<Supervisorypersonnel> supervisorypersonnelCXList(String flag,
            Map<String, Object> filterMap, PageDesc pageDesc);

    // 保存新增加的监察人员
    public void supervisorypersonnelSave(Supervisorypersonnel info);

    // 获取监察人员下一个编码
    public String genNextChangeId();

    // 通过用户编码和流水号获取检查人员信息
    public Supervisorypersonnel getSpByUseridNo(String userId, String no);

    public Supervisorypersonnel getSpByUserNameBirth(String userName, Date birth);
}
