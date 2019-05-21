package com.centit.supervise.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.SupDlfxOutwayDao;
import com.centit.monitor.po.SupDlfxOutway;
import com.centit.supervise.dao.SupInfoBasicDlfxDao;
import com.centit.supervise.po.SupInfoBasicDlfx;
import com.centit.supervise.service.SupInfoBasicDlfxManager;

public class SupInfoBasicDlfxManagerImpl extends
        BaseEntityManagerImpl<SupInfoBasicDlfx> implements
        SupInfoBasicDlfxManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(SupInfoBasicDlfxManager.class);

    private SupInfoBasicDlfxDao supInfoBasicDlfxDao;
    private SupDlfxOutwayDao supDlfxOutwayDao;

    public SupDlfxOutwayDao getSupDlfxOutwayDao() {
        return supDlfxOutwayDao;
    }

    public void setSupDlfxOutwayDao(SupDlfxOutwayDao supDlfxOutwayDao) {
        this.supDlfxOutwayDao = supDlfxOutwayDao;
    }

    public void setSupInfoBasicDlfxDao(SupInfoBasicDlfxDao baseDao) {
        this.supInfoBasicDlfxDao = baseDao;
        setBaseDao(this.supInfoBasicDlfxDao);
    }

    // 获取预报警信息
    public List<SupDlfxOutway> getSupDlfxOutWayManager(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return supDlfxOutwayDao
                .getSupDlfxOutWayInfoManager(filterMap, pageDesc);
    }

    public String getNextkey() {
        return "DL"
                + supInfoBasicDlfxDao.getNextKeyBySequence(
                        "S_SUPERVISEBASICDLFX", 8);
    }

    // 获取督办信息
    public List<SupInfoBasicDlfx> getSupInfoBasicDlfxList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return supInfoBasicDlfxDao.getSupInfoBasicDlfxList(filterMap, pageDesc);
    }

    public void UpdateSupInfoBasicDlfxJl(SupInfoBasicDlfx info) {
        supInfoBasicDlfxDao.UpdateSupInfoBasicDlfxJl(info);
    }

    public void UpdateSupInfoBasicDlfxFk(SupInfoBasicDlfx info) {
        supInfoBasicDlfxDao.UpdateSupInfoBasicDlfxFk(info);
    }
}
