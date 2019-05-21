package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.LawmenDao;
import com.centit.powerbase.dao.LawmenannualDao;
import com.centit.powerbase.po.Lawmen;
import com.centit.powerbase.po.Lawmenannual;
import com.centit.powerbase.service.LawmenManager;

public class LawmenManagerImpl extends BaseEntityManagerImpl<Lawmen> implements
        LawmenManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawmenManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private LawmenDao lawmenDao;
    private LawmenannualDao lawmenannualDao;

    public LawmenannualDao getLawmenannualDao() {
        return lawmenannualDao;
    }

    public void setLawmenannualDao(LawmenannualDao lawmenannualDao) {
        this.lawmenannualDao = lawmenannualDao;
    }

    public void setLawmenDao(LawmenDao baseDao) {
        this.lawmenDao = baseDao;
        setBaseDao(this.lawmenDao);
    }

    // 执行人员管理list
    public List<Lawmen> lawmenManagementList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return lawmenDao.lawmenManagementList(filterMap, pageDesc);
    }

    // 获取下一个执行人员编号
    public String genNextChangeId() {
        return lawmenDao.genNextChangeId();
    }

    // 获取下一个年检编号
    public String genNextAnnualId() {
        return lawmenDao.genNextAnnualId();
    }

    // 保存执行人员管理——>新添加的执行人员信息
    public void lawmenSave(Lawmen info) {
        lawmenDao.saveObject(info);
    }

    // 获取具体执法人员信息
    public Lawmen getLawmenByUseridNo(String userId, String lawmenId) {
        return lawmenDao.getLawmenByUseridNo(userId, lawmenId);
    }

    // 获取具体执法人员信息
    public Lawmen getLawmenByLawmenId(String lawmenId) {
        return lawmenDao.getLawmenByLawmenId(lawmenId);
    }

    // 执法人员审核同时修改俩个表的信息
    public void saveboth(Lawmen info, Lawmenannual infoAnnual) {
        lawmenDao.saveObject(info);
        lawmenannualDao.saveObject(infoAnnual);

    }
}
