package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.VapplyrecordbasicDao;
import com.centit.powerbase.po.Vapplyrecordbasic;
import com.centit.powerbase.service.VapplyrecordbasicManager;

public class VapplyrecordbasicManagerImpl extends
        BaseEntityManagerImpl<Vapplyrecordbasic> implements
        VapplyrecordbasicManager {
    private static final long serialVersionUID = 1L;
    private VapplyrecordbasicDao vapplyrecordbasicDao;

    public void setVapplyrecordbasicDao(
            VapplyrecordbasicDao vapplyrecordbasicDao) {
        this.vapplyrecordbasicDao = vapplyrecordbasicDao;
        this.setBaseDao(vapplyrecordbasicDao);
    }

    @Override
    public List<Vapplyrecordbasic> getList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vapplyrecordbasicDao.getList(filterMap, pageDesc);
    }
}
