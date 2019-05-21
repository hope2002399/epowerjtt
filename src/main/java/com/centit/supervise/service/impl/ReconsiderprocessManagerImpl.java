package com.centit.supervise.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.supervise.dao.ReconsiderprocessDao;
import com.centit.supervise.po.Reconsiderprocess;
import com.centit.supervise.service.ReconsiderprocessManager;

public class ReconsiderprocessManagerImpl extends
        BaseEntityManagerImpl<Reconsiderprocess> implements
        ReconsiderprocessManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(ReconsiderprocessManager.class);

    private ReconsiderprocessDao reconsiderprocessDao;

    public void setReconsiderprocessDao(ReconsiderprocessDao baseDao) {
        this.reconsiderprocessDao = baseDao;
        setBaseDao(this.reconsiderprocessDao);
    }

    @Override
    public Reconsiderprocess getObjectByNodeInstId(Long nodeInstId) {
        return reconsiderprocessDao.getObjectByNodeInstId(nodeInstId);
    }

    @Override
    public String getNextKey() {
        return reconsiderprocessDao.getNextKeyBySequence(
                "S_RECONSIDERPROCESSID", 32);
    }

    @Override
    public List<Reconsiderprocess> getObjListByReconsiderId(String reconsiderId) {
        return reconsiderprocessDao.getObjListByReconsiderId(reconsiderId);
    }

}
