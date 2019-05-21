package com.centit.powerruntime.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.Suppowerstuffinfo;

public interface SuppowerstuffinfoManager extends
        BaseEntityManager<Suppowerstuffinfo> {

    public List<Suppowerstuffinfo> getinfosByGroupId(String groupid);

    public String getNextKey();
}
