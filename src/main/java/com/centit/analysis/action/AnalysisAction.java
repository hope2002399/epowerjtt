package com.centit.analysis.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.analysis.service.AnalysisManager;
import com.centit.core.action.BaseAction;

@SuppressWarnings("serial")
public class AnalysisAction extends BaseAction {

    private AnalysisManager analysisManager;

    public AnalysisManager getAnalysisManager() {
        return analysisManager;
    }

    public void setAnalysisManager(AnalysisManager analysisManager) {
        this.analysisManager = analysisManager;
    }

    private String year;
    private String month;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    private String nowDate;

    public String getNowDate() {
        if (nowDate == null || "".equals(nowDate))
            this.nowDate = getNowYearMonth();
        return nowDate;
    }

    public String mainView() {
        String yearmonth = request.getParameter("s_yearmonth");
        if (yearmonth != null && !"".equals(yearmonth)
                && yearmonth.length() >= 7) {
            year = yearmonth.substring(0, 4);
            month = yearmonth.substring(5, 7);
        } else {
            yearmonth = getNowYearMonth();
            year = yearmonth.substring(0, 4);
            month = yearmonth.substring(5, 7);
        }
        if (yearmonth.length() > 7) {
            yearmonth = yearmonth.substring(0, 7);
        }
        request.setAttribute("s_yearmonth", yearmonth);
        // 权力总数
        String powerSum = analysisManager.getPowerSum(yearmonth);
        // 权力使用总数
        String powerUseSum = analysisManager.getPowerUseSum(yearmonth);
        request.setAttribute("powerSum", powerSum);
        request.setAttribute("powerUseSum", powerUseSum);
        // 当月办件总数
        String applySum_N = analysisManager.getApplySum(yearmonth);
        // 上月办件总数
        String applySum_P = analysisManager.getApplySum(getLastYearMonth(
                yearmonth).substring(0, 7));
        request.setAttribute("applySum_N", Integer.parseInt(applySum_N));
        request.setAttribute("applySum_P", Integer.parseInt(applySum_P));
        // 当月预报警总数
        String outWaySum_N = analysisManager.getOutWaySum(yearmonth);
        // 上月预报警总数
        String outWaySum_P = analysisManager.getOutWaySum(getLastYearMonth(
                yearmonth).substring(0, 7));
        request.setAttribute("outWaySum_N", Integer.parseInt(outWaySum_N));
        request.setAttribute("outWaySum_P", Integer.parseInt(outWaySum_P));
        // 当月发起督办数
        String superviseSum_N = analysisManager.getSuperviseSum(yearmonth);
        // 上月发起督办数
        String superviseSum_P = analysisManager
                .getSuperviseSum(getLastYearMonth(yearmonth).substring(0, 7));
        request.setAttribute("superviseSum_N", Integer.parseInt(superviseSum_N));
        request.setAttribute("superviseSum_P", Integer.parseInt(superviseSum_P));
        attachView();
        return "viewmain";
    }

    // 权力事项运行分析
    public String powerView() {
        String yearmonth = year + "-" + month;
        // 按权利类型统计表
        String cfNum = analysisManager.getPowerPunishBJ(yearmonth);
        List<Map<String, Object>> list = analysisManager
                .getPowerApplyBJ(yearmonth);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("ITEMTYPE", "CF");
        map.put("BJNUM", cfNum);
        list.add(map);
        int sum = 0;
        for (Map<String, Object> m : list) {
            m.put("BJNUM", Integer.parseInt(m.get("BJNUM").toString()));
            sum += Integer.parseInt(m.get("BJNUM").toString());
        }
        request.setAttribute("list", list);
        request.setAttribute("sumnum", sum);
        // 按行业部门统计表
        List<Map<String, Object>> list1 = analysisManager
                .getIndustryTypePowerNum(yearmonth);// 权力总数
        List<Map<String, Object>> list2 = analysisManager
                .getIndustryTypePowerUseNum(yearmonth);// 权力使用数
        List<Map<String, Object>> list3 = analysisManager
                .getIndustryTypeApplyBJ(yearmonth);// 办件数
        List<Map<String, Object>> list4 = analysisManager
                .getIndustryTypeFinishBJ(yearmonth);// 办结数
        int powersum = 0, powerusesum = 0, applysum = 0, finishsum = 0;
        int powercount, powerusecount, applynum, finishnum;
        for (int i = 0; i < list1.size(); i++) {
            powercount = Integer.parseInt(list1.get(i).get("POWERCOUNT")
                    .toString());
            list1.get(i).put("POWERCOUNT", powercount);
            powersum += powercount;
            powerusecount = Integer.parseInt(list2.get(i).get("POWERUSECOUNT")
                    .toString());
            list1.get(i).put("POWERUSECOUNT", powerusecount);
            powerusesum += powerusecount;
            applynum = Integer
                    .parseInt(list3.get(i).get("APPLYNUM").toString());
            list1.get(i).put("APPLYNUM", applynum);
            applysum += applynum;
            finishnum = Integer.parseInt(list4.get(i).get("APPLYNUM")
                    .toString());
            list1.get(i).put("FINISHNUM", finishnum);
            finishsum += finishnum;
        }
        request.setAttribute("list1", list1);
        request.setAttribute("powersum", powersum);
        request.setAttribute("powerusesum", powerusesum);
        request.setAttribute("applysum", applysum);
        request.setAttribute("finishsum", finishsum);
        return "powerview";
    }

    // 预警情况分析
    public String outwayView() {
        String yearmonth = year + "-" + month;
        List<Map<String, Object>> list = analysisManager
                .getIndustryTypeOutWayNum(yearmonth);// 预报警数
        List<Map<String, Object>> list3 = analysisManager
                .getIndustryTypeApplyBJ(yearmonth);// 办件数
        int yjnum, bjnum, applycount;
        int yjsum = 0, bjsum = 0, applysum = 0;
        for (int i = 0; i < list.size(); i++) {
            applycount = Integer.parseInt(list3.get(i).get("APPLYNUM")
                    .toString());
            list.get(i).put("APPLYCOUNT", applycount);
            applysum += applycount;
            yjnum = Integer.parseInt(list.get(i).get("YJNUM").toString());
            list.get(i).put("YJNUM", yjnum);
            yjsum += yjnum;
            bjnum = Integer.parseInt(list.get(i).get("BJNUM").toString());
            list.get(i).put("BJNUM", bjnum);
            bjsum += bjnum;
        }
        request.setAttribute("list", list);
        request.setAttribute("yjsum", yjsum);
        request.setAttribute("bjsum", bjsum);
        request.setAttribute("applysum", applysum);

        return "outwayview";
    }

    // 督查督办情况分析
    public String superviseView() {
        String yearmonth = year + "-" + month;
        List<Map<String, Object>> list = analysisManager
                .getIndustryTypeSuperviseNum(yearmonth);// 督办数
        int dbnum, jsfknum;
        int dbsum = 0, jsfksum = 0;
        for (int i = 0; i < list.size(); i++) {
            dbnum = Integer.parseInt(list.get(i).get("DBNUM").toString());
            list.get(i).put("DBNUM", dbnum);
            dbsum += dbnum;
            jsfknum = Integer.parseInt(list.get(i).get("JSFKNUM").toString());
            list.get(i).put("JSFKNUM", jsfknum);
            jsfksum += jsfknum;
        }
        request.setAttribute("list", list);
        request.setAttribute("jsfksum", jsfksum);
        request.setAttribute("dbsum", dbsum);
        return "superviseview";
    }

    // 数据交换运行情况
    public String datachangeView() {
        String yearmonth = year + "-" + month;
        List<Map<String, Object>> list = analysisManager
                .getIndustryTypeApplyBJ(yearmonth);// 报送办件数
        List<Map<String, Object>> list1 = analysisManager
                .getIndustryTypeBSNum(yearmonth);// 报送条数
        int bsts, applynum;
        int applysum_J = 0, applysum_T = 0;
        for (int i = 0; i < list.size(); i++) {
            applynum = Integer.parseInt(list.get(i).get("APPLYNUM").toString());
            list.get(i).put("APPLYCOUNT_J", applynum);
            applysum_J += applynum;
            bsts = Integer.parseInt(list1.get(i).get("TS").toString());
            list.get(i).put("APPLYCOUNT_T", applynum + bsts);
            applysum_T += (applynum + bsts);
        }
        request.setAttribute("list", list);
        request.setAttribute("applysum_J", applysum_J);
        request.setAttribute("applysum_T", applysum_T);
        request.setAttribute("applytsum_J", 0);
        request.setAttribute("applytsum_T", 0);
        request.setAttribute("applybssum_J", applysum_J);
        request.setAttribute("applybssum_T", applysum_T);
        return "datachangeview";
    }

    // 附件
    @SuppressWarnings("deprecation")
    public String attachView() {
        // 获取月份第一天
        String yearmonthfirst = year + "-" + month + "-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar cDay1 = Calendar.getInstance();
            cDay1.setTime(sdf.parse(yearmonthfirst));
            final int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
            Date lastDate = cDay1.getTime();
            lastDate.setDate(lastDay);
            // 获取月份最后一天
            String yearmonthlast = sdf.format(lastDate);
            request.setAttribute("yearmonthfirst", yearmonthfirst);
            request.setAttribute("yearmonthlast", yearmonthlast);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "attachview";
    }

    // 取当前年月日
    private String getNowYearMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    // 根据给定的月份，取上一个月份
    @SuppressWarnings("deprecation")
    private String getLastYearMonth(String yearmonth) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(yearmonth + "-01");
            date.setMonth(date.getMonth() - 1);
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
