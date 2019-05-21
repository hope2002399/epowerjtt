package com.centit.monitor.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.SupervisorypersonnelDao;
import com.centit.monitor.po.Supervisorypersonnel;
import com.centit.monitor.service.SupervisorypersonnelManager;

public class SupervisorypersonnelManagerImpl extends
        BaseEntityManagerImpl<Supervisorypersonnel> implements
        SupervisorypersonnelManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(SupervisorypersonnelManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private SupervisorypersonnelDao SupervisorypersonnelDao;

    public void setSupervisorypersonnelDao(SupervisorypersonnelDao baseDao) {
        this.SupervisorypersonnelDao = baseDao;
        setBaseDao(this.SupervisorypersonnelDao);
    }

    // 监察人员申报list
    public List<Supervisorypersonnel> supervisorypersonnelSBList(String flag,
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return SupervisorypersonnelDao.GetSupervisorypersonnelList(flag,
                filterMap, pageDesc);
    }

    // 监察人员审核list
    public List<Supervisorypersonnel> supervisorypersonnelSHList(String flag,
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return SupervisorypersonnelDao.GetSupervisorypersonnelList(flag,
                filterMap, pageDesc);
    }

    // 监察人员查询list
    public List<Supervisorypersonnel> supervisorypersonnelCXList(String flag,
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return SupervisorypersonnelDao.GetSupervisorypersonnelList(flag,
                filterMap, pageDesc);
    }

    // 保存新增加的监察人员
    public void supervisorypersonnelSave(Supervisorypersonnel info) {
        SupervisorypersonnelDao.saveObject(info);
    }

    // 获取监察人员下一个编码
    public String genNextChangeId() {
        return SupervisorypersonnelDao.genNextChangeId();
    }

    // 通过用户编码和流水号获取检查人员信息
    public Supervisorypersonnel getSpByUseridNo(String userId, String no) {
        return SupervisorypersonnelDao.getSpByUseridNo(userId, no);
    }

    // 通过用户编码和流水号获取检查人员信息
    public Supervisorypersonnel getSpByUserNameBirth(String userName, Date birth) {
        return SupervisorypersonnelDao.getSpByUserNameBirth(userName, birth);
    }
}
