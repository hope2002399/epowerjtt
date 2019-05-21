package com.centit.analysis.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.analysis.dao.AnalysisDao;
import com.centit.analysis.service.AnalysisManager;
import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.sys.po.FOptinfo;

public class AnalysisManagerImpl extends BaseEntityManagerImpl<FOptinfo>
        implements AnalysisManager {
    private static final long serialVersionUID = 1L;
    private AnalysisDao analysisDao;

    public AnalysisDao getAnalysisDao() {
        return analysisDao;
    }

    public void setAnalysisDao(AnalysisDao analysisDao) {
        this.analysisDao = analysisDao;
    }

    @Override
    public List<Map<String, Object>> getPowerApplyBJ(String yearmonth) {
        
        return analysisDao.getPowerApplyBJ(yearmonth);
    }

    @Override
    public String getPowerPunishBJ(String yearmonth) {
        
        return analysisDao.getPowerPunishBJ(yearmonth);
    }

    @Override
    public List<Map<String, Object>> getIndustryTypeApplyBJ(String yearmonth) {
        
        return analysisDao.getIndustryTypeApplyBJ(yearmonth);
    }

    @Override
    public List<Map<String, Object>> getIndustryTypeFinishBJ(String yearmonth) {
        
        return analysisDao.getIndustryTypeFinishBJ(yearmonth);
    }

    @Override
    public List<Map<String, Object>> getIndustryTypePowerNum(String yearmonth) {
        
        return analysisDao.getIndustryTypePowerNum(yearmonth);
    }

    @Override
    public List<Map<String, Object>> getIndustryTypePowerUseNum(String yearmonth) {
        
        return analysisDao.getIndustryTypePowerUseNum(yearmonth);
    }

    @Override
    public String getPowerSum(String yearmonth) {
        
        return analysisDao.getPowerSum(yearmonth);
    }

    @Override
    public String getPowerUseSum(String yearmonth) {
        
        return analysisDao.getPowerUseSum(yearmonth);
    }

    @Override
    public String getApplySum(String yearmonth) {
        
        return analysisDao.getApplySum(yearmonth);
    }

    @Override
    public String getOutWaySum(String yearmonth) {
        
        return analysisDao.getOutWaySum(yearmonth);
    }

    @Override
    public String getSuperviseSum(String yearmonth) {
        
        return analysisDao.getSuperviseSum(yearmonth);
    }

    @Override
    public List<Map<String, Object>> getIndustryTypeOutWayNum(String yearmonth) {
        
        return analysisDao.getIndustryTypeOutWayNum(yearmonth);
    }

    @Override
    public List<Map<String, Object>> getIndustryTypeSuperviseNum(
            String yearmonth) {
        
        return analysisDao.getIndustryTypeSuperviseNum(yearmonth);
    }

    @Override
    public List<Map<String, Object>> getIndustryTypeBSNum(String yearmonth) {
        return analysisDao.getIndustryTypeBSNum(yearmonth);
    }

}
