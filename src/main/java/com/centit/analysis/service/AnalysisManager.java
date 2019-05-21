package com.centit.analysis.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.sys.po.FOptinfo;

public interface AnalysisManager extends BaseEntityManager<FOptinfo> {
    // 取权力总数量
    public String getPowerSum(String yearmonth);

    // 取权力使用总数量
    public String getPowerUseSum(String yearmonth);

    // 取办件总数量
    public String getApplySum(String yearmonth);

    // 取预报警总数量
    public String getOutWaySum(String yearmonth);

    // 取督办总数量
    public String getSuperviseSum(String yearmonth);

    // 根据事项类型分类汇总办件量
    public List<Map<String, Object>> getPowerApplyBJ(String yearmonth);

    public String getPowerPunishBJ(String yearmonth);

    // 根据行业类别分类汇总办件量
    public List<Map<String, Object>> getIndustryTypeApplyBJ(String yearmonth);

    // 根据行业类别分类汇总办结量
    public List<Map<String, Object>> getIndustryTypeFinishBJ(String yearmonth);

    // 根据行业类别分类汇总在用权力数
    public List<Map<String, Object>> getIndustryTypePowerNum(String yearmonth);

    // 根据行业类别分类汇总当月使用权力数
    public List<Map<String, Object>> getIndustryTypePowerUseNum(String yearmonth);

    // 根据行业类别分类汇总当月预报警数
    public List<Map<String, Object>> getIndustryTypeOutWayNum(String yearmonth);

    // 根据行业类别分类汇总当月督办数
    public List<Map<String, Object>> getIndustryTypeSuperviseNum(
            String yearmonth);

    // 根据行业类别分类汇总当月报送条数（包含m_applyprocess、m_applyresult、m_punishprocess、m_punishresult）
    public List<Map<String, Object>> getIndustryTypeBSNum(String yearmonth);

}
