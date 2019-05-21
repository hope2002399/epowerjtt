package com.centit.EIdPhoto.service;

import java.util.List;
import java.util.Map;

import com.centit.EIdPhoto.po.TZzZmInfo;
import com.centit.core.utils.PageDesc;

public interface TZzZmInfoManager {

    /**
     * 新增数据
     * @param tZzZmInfo
     */
    public void insertZmInfo(TZzZmInfo tZzZmInfo);
    
    /**
     * 查询数据
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<TZzZmInfo> findTZzZmdyInfo(Map<String, Object> filterMap,
            PageDesc pageDesc);
}
