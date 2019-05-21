package com.centit.powerruntime.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.OptStuffInfo;

public interface OptStuffInfoManager extends BaseEntityManager<OptStuffInfo> {

    public OptStuffInfo getStuffInfoByArchiveType(String djId,
            String archiveType);
    
    public OptStuffInfo getStuffInfoByDjIdName(String djId,
            String fileName);

}
