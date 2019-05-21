package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Vapplyrecordbasic;

public interface VapplyrecordbasicManager extends
        BaseEntityManager<Vapplyrecordbasic> {

    public List<Vapplyrecordbasic> getList(Map<String, Object> filterMap,
            PageDesc pageDesc);

}
