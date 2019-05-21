package com.centit.supervise.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.supervise.dao.ReconsiderDao;
import com.centit.supervise.po.Reconsider;
import com.centit.supervise.service.ReconsiderManager;

public class ReconsiderManagerImpl extends BaseEntityManagerImpl<Reconsider>
        implements ReconsiderManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ReconsiderManager.class);

    private ReconsiderDao reconsiderDao;

    public void setReconsiderDao(ReconsiderDao baseDao) {
        this.reconsiderDao = baseDao;
        setBaseDao(this.reconsiderDao);
    }

    @Override
    public String getNextkey() {
        return "FY" + reconsiderDao.getNextKeyBySequence("S_RECONSIDERID", 6);
    }

    @Override
    public Reconsider getReconsiderByFlowId(Long flowInstId) {
        return reconsiderDao.getReconsiderByFlowId(flowInstId);
    }

}
