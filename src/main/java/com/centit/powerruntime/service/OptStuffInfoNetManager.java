package com.centit.powerruntime.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.OptStuffInfoNet;

public interface OptStuffInfoNetManager extends
        BaseEntityManager<OptStuffInfoNet> {

    /**
     * 根据业务编号和排序号获取材料信息
     * 
     * @param djId
     * @param sortId
     * @return
     */
    public OptStuffInfoNet getObjectById_SortId(String netId, String sortId);

    public OptStuffInfoNet getStuffInfoByArchiveType(String netId,
            String archiveType);

    /**
     * 正文材料文件查询
     * 
     * @param djId
     * @return
     */
    public List<OptStuffInfoNet> getZwfjStuffInfo(String netId);

    public void deleteOSIN(String netId, String sortId);

}
