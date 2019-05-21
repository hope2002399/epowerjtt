package com.centit.powerruntime.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.YwFiles;

public interface YwFilesManager extends BaseEntityManager<YwFiles> 
{
    public List<YwFiles> getinfosByGroupId(String groupid);

    public String getNextKey();
}
