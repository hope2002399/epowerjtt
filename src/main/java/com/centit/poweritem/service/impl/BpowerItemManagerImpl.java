package com.centit.poweritem.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.poweritem.dao.BpowerItemDao;
import com.centit.poweritem.po.BpowerItem;
import com.centit.poweritem.service.BpowerItemManager;

public class BpowerItemManagerImpl extends BaseEntityManagerImpl<BpowerItem>
        implements BpowerItemManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(BpowerItemManager.class);

    private BpowerItemDao bpowerItemDao;

    public BpowerItemDao getBpowerItemDao() {
        return bpowerItemDao;
    }

    public void setBpowerItemDao(BpowerItemDao bpowerItemDao) {
        this.bpowerItemDao = bpowerItemDao;
        setBaseDao(this.bpowerItemDao);
    }

    @Override
    public List<BpowerItem> listObjects(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        return bpowerItemDao.listObjects(filterMap, pageDesc);
    }

}
