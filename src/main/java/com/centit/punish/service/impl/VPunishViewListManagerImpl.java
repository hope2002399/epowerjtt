package com.centit.punish.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.punish.dao.VPunishViewListDao;
import com.centit.punish.po.VPunishViewList;
import com.centit.punish.service.VPunishViewListManager;

public class VPunishViewListManagerImpl extends
        BaseEntityManagerImpl<VPunishViewList> implements
        VPunishViewListManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VPunishViewListManager.class);

    private VPunishViewListDao VPunishViewListDao;

    public void setVPunishViewListDao(VPunishViewListDao baseDao) {
        this.VPunishViewListDao = baseDao;
        setBaseDao(this.VPunishViewListDao);
    }

    @Override
    public List<VPunishViewList> listPunishObjectBasics(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        
        return VPunishViewListDao.listPunishObjectBasics(filterMap, pageDesc);
    }

}
