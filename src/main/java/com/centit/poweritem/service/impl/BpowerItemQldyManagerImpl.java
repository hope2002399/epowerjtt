package com.centit.poweritem.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.poweritem.dao.BpowerItemQldyDao;
import com.centit.poweritem.po.BpowerItemQldy;
import com.centit.poweritem.service.BpowerItemManager;
import com.centit.poweritem.service.BpowerItemQldyManager;

public class BpowerItemQldyManagerImpl extends
        BaseEntityManagerImpl<BpowerItemQldy> implements BpowerItemQldyManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(BpowerItemManager.class);

    private BpowerItemQldyDao bpowerItemQldyDao;

    public BpowerItemQldyDao getBpowerItemQldyDao() {
        return bpowerItemQldyDao;
    }

    public void setBpowerItemQldyDao(BpowerItemQldyDao bpowerItemQldyDao) {
        this.bpowerItemQldyDao = bpowerItemQldyDao;
        setBaseDao(this.bpowerItemQldyDao);
    }

}
