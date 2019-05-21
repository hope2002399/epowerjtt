package com.centit.powerruntime.service.impl;


import java.util.List;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.VRegNoFileNameDao;
import com.centit.powerruntime.po.VRegNoFileName;
import com.centit.powerruntime.service.VRegNoFileNameManager;

public class VRegNoFileNameManagerImpl extends
        BaseEntityManagerImpl<VRegNoFileName> implements
       VRegNoFileNameManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private VRegNoFileNameDao vRegNoFileNameDao;

    public void setVRegNoFileNameDao(
            VRegNoFileNameDao vRegNoFileNameDao) {
        this.vRegNoFileNameDao = vRegNoFileNameDao;
        setBaseDao(vRegNoFileNameDao);
    }

    @Override
    public List<VRegNoFileName> getinfosByOutItemId(String outItemId) {
        return vRegNoFileNameDao.listObjects();
    }


}
