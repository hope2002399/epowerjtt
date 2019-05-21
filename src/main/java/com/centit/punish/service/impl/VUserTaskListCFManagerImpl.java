package com.centit.punish.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.VUserTaskListCFDao;
import com.centit.punish.po.VUserTaskListCF;
import com.centit.punish.service.VUserTaskListCFManager;

public class VUserTaskListCFManagerImpl extends
        BaseEntityManagerImpl<VUserTaskListCF> implements
        VUserTaskListCFManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private VUserTaskListCFDao userTaskListCFDao;

    public void setUserTaskListCFDao(VUserTaskListCFDao userTaskListCFDao) {
        this.userTaskListCFDao = userTaskListCFDao;
        setBaseDao(userTaskListCFDao);
    }

    public VUserTaskListCFDao getUserTaskListCFDao() {
        return userTaskListCFDao;
    }

}
