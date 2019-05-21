package com.centit.supervise.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.supervise.dao.ReconsiderresultDao;
import com.centit.supervise.po.Reconsiderresult;
import com.centit.supervise.service.ReconsiderresultManager;

public class ReconsiderresultManagerImpl extends
        BaseEntityManagerImpl<Reconsiderresult> implements
        ReconsiderresultManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(ReconsiderresultManager.class);

    private ReconsiderresultDao reconsiderresultDao;

    public void setReconsiderresultDao(ReconsiderresultDao baseDao) {
        this.reconsiderresultDao = baseDao;
        setBaseDao(this.reconsiderresultDao);
    }

}
