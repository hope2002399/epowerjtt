package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Lawsuit;

public interface LawsuitManager extends BaseEntityManager<Lawsuit> {

    public List<Lawsuit> Lawsuitlist(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public Lawsuit getUpdateNo(String lawsuitno);

}
