package com.centit.monitor.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.Superviselog;

public interface SuperviselogManager extends BaseEntityManager<Superviselog> {
    /**
     * 获取监察日志功能optID列表
     * 
     * @return
     */
    public List<String> getOptList();

}
