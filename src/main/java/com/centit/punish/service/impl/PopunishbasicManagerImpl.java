package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PopunishbasicDao;
import com.centit.punish.po.Popunishbasic;
import com.centit.punish.service.PopunishbasicManager;

public class PopunishbasicManagerImpl extends
        BaseEntityManagerImpl<Popunishbasic> implements PopunishbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PopunishbasicManager.class);

    private PopunishbasicDao popunishbasicDao;

    public void setPopunishbasicDao(PopunishbasicDao baseDao) {
        this.popunishbasicDao = baseDao;
        setBaseDao(this.popunishbasicDao);
    }

    @Override
    public Popunishbasic getObjectByPunishobjectid(String punishobjectid) {
        return popunishbasicDao.getObjectByPunishobjectid(punishobjectid);
    }

}
