package com.centit.EIdPhoto.service;

import java.util.List;
import java.util.Map;

import com.centit.EIdPhoto.po.TZzMetadataInfo;
import com.centit.EIdPhoto.po.TZzZmdyInfo;
import com.centit.core.utils.PageDesc;

public interface TZzZmdyInfoManager {

    /*
     * 查询所有又ouitemid的数据
     */
    public List<TZzZmdyInfo> findTZzZmdyInfo(Map<String, Object> filterMap,
            PageDesc pageDesc);
    
    /**
     * 根据mouldId查询需要添加的字段
     * @param mouldId
     * @return
     */
    public List<TZzMetadataInfo> findTZzMetadataInfo(String mouldId);
}
