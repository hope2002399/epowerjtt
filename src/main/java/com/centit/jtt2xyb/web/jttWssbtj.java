package com.centit.jtt2xyb.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;







import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.service.WssbtjService;
import com.centit.workflow.sample.optmodel.BaseWFEntityAction;

//数据统计
public class jttWssbtj  extends BaseWFEntityAction<JiaoTongLog> implements ServletResponseAware {
    
    private static final long serialVersionUID = 1L;
    private WssbtjService wssbtjService;
    HttpServletResponse response;
    
	public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setWssbtjService(WssbtjService wssbtjService) {
		this.wssbtjService = wssbtjService;
	}

    /**
     * 外网申报统计
     */
	@Override
	public String execute() throws Exception {
		String startTime = request.getParameter("decisionBeginTime");
		String endTime = request.getParameter("decisionEndTime");
		String type = request.getParameter("type");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		if( "".equals(startTime)|| null == startTime ){
			startTime = getFirstMonthDay(format);
		}
		if("".equals(endTime) || null == endTime ){
			endTime = getCurrentDay(format);
		}
		List<Map<String,Object>> list =	wssbtjService.getDataList(startTime,endTime);
		request.setAttribute("map", list);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		return "list";
		
	}
	

	
	private String getFirstMonthDay(SimpleDateFormat format){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH,0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		String firstDay = format.format(c.getTime());
		return firstDay;
	}
	
	@SuppressWarnings("unused")
	private String getCurrentDay(SimpleDateFormat format){
		Calendar ca = Calendar.getInstance();    
        //ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
        String last = format.format(ca.getTime());
		return last;
	}

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
        
    }
	
}
