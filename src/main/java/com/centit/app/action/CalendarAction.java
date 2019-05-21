package com.centit.app.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import com.centit.app.po.OaWorkDay;
import com.centit.app.service.OaWorkDayManager;
import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.WorkTimeSpan;
import com.centit.sys.service.WorkCalendar;

public class CalendarAction extends BaseEntityExtremeAction<OaWorkDay> {

    private static final long serialVersionUID = 1L;
    private OaWorkDayManager oaWorkDayManager;
    private WorkCalendar workCalendar;
    private JSONObject result;

    public WorkCalendar getWorkCalendar() {
        return workCalendar;
    }

    public void setWorkCalendar(WorkCalendar workCalendar) {
        this.workCalendar = workCalendar;
    }

    public void setOaWorkDayManager(OaWorkDayManager oaWorkDayManager) {
        this.oaWorkDayManager = oaWorkDayManager;
        super.setBaseEntityManager(oaWorkDayManager);
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    public String view() {

        return "calendar";
    }

    public String getUnusualDays() {
        return "unusual";
    }

    public String savedate() {
        try {
            OaWorkDay dbobject = oaWorkDayManager.getObjectById(object
                    .getWorkday());
            if (dbobject != null) {
                if (object.getDaytype().equals("C")) { // 当把这个日期设置为正常时
                                                       // 把这个日期从数据库里面删除
                    oaWorkDayManager.deleteObject(dbobject);
                } else {
                    oaWorkDayManager
                            .copyObjectNotNullProperty(dbobject, object);
                    object = dbobject;
                }
            }
            if (!object.getDaytype().equals("C")) {
                oaWorkDayManager.saveObject(object);
            }
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("DayType", object.getDaytype());
            result = JSONObject.fromObject(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "save";
    }

    private Date beginDate;
    private Date endDate;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDayArray() {
        try {
            List<OaWorkDay> list = oaWorkDayManager.getListByDay(beginDate,
                    endDate);
            if (list != null) {
                // Map<String,String> map1=new HashMap<String, String>();
                // Map<String,String> map2=new HashMap<String, String>();
                HashMap<String, String> map = new HashMap<String, String>();
                SimpleDateFormat df = new SimpleDateFormat("MMdd");
                for (OaWorkDay day : list) {
                    if (day.getDaytype().equals("A")) {
                        map.put(df.format(day.getWorkday()), "A");
                    } else {
                        map.put(df.format(day.getWorkday()), "B");
                    }
                }
                result = JSONObject.fromObject(map);
                System.out.print(result);
            } else {
                result = null;
            }
            return "jsonArray";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date s = sdf.parse("2012-07-14 09:00:25");
        Date s1 = sdf.parse("2012-07-15 15:20:35");
        WorkTimeSpan workTimeSpan = workCalendar.getWorkTime(s, s1);
        System.out.println(workTimeSpan.getTimeSpanDesc());
        return null;
    }

}
