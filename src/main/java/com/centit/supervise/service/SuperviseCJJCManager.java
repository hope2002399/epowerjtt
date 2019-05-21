package com.centit.supervise.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.supervise.po.SuperviseCJJC;

public interface SuperviseCJJCManager extends BaseEntityManager<SuperviseCJJC> {
    public SuperviseCJJC getSuperviseCJJCByCode(String supervisecode);

    public String getNextkey();

    public List<SuperviseCJJC> listSuperviseCJJC(Map<String, Object> filtermap,
            PageDesc pagedesc);
}
