package com.centit.sys.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.sys.po.FOptinfo;

public interface FirstPageManager extends BaseEntityManager<FOptinfo> {
    public String getXknum(String yyyymm);

    public String getCfnum(String yyyymm);

    public String getYjnum(String yyyymm);

    public String getDbnum(String yyyymm);

    @SuppressWarnings("rawtypes")
    public List<Map<String, String>> getAreaNum(Map map);

    @SuppressWarnings("rawtypes")
    public List<Integer> getAreaXkNum(Map map);

    @SuppressWarnings("rawtypes")
    public List<Integer> getAreaCfNum(Map map);

    @SuppressWarnings("rawtypes")
    public List<Integer> getMonthNumByYear(Map map);
    
    @SuppressWarnings("rawtypes")
    public List<Double> getAreaXkBjl(Map map);

    @SuppressWarnings("rawtypes")
    public List<Double> getAreaCfBjl(Map map);
}
