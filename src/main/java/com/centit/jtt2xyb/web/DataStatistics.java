package com.centit.jtt2xyb.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.service.Jtt2XybCfService;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.sample.optmodel.BaseWFEntityAction;

//数据统计
public class DataStatistics extends BaseWFEntityAction<JiaoTongLog> implements ServletResponseAware {
	/**
     * 
     */
    private static final long serialVersionUID = 5496197007230511123L;
    private Jtt2XybCfService jtt2XybCfService;
    private SysUserManager sysUserManager;
    HttpServletResponse response;
    
    
    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setJtt2XybCfService(Jtt2XybCfService jtt2XybCfService) {
		this.jtt2XybCfService = jtt2XybCfService;
	}

	@Override
	public String execute() throws Exception {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
		request.getParameter("decisionBeginTime");
		//开始时间
		String startTime = request.getParameter("decisionBeginTime");
		//结束时间
		String endTime = request.getParameter("decisionEndTime");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		if( "".equals(startTime)|| null == startTime ){
			startTime = getFirstMonthDay(format);
		}
		if("".equals(endTime) || null == endTime ){
			endTime = getCurrentDay(format);
		}
		//查双公示统计数据
		List<Object[]> list = jtt2XybCfService.getDataList(startTime,endTime);
		request.setAttribute("list", list);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime",endTime);
		return "list";
	}
	/**
	 * 手动报送
	 * @return
	 */
	public String sdbs() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        request.getParameter("decisionBeginTime");
        //开始时间
        String startTime = request.getParameter("decisionBeginTime");
        //结束时间
        String endTime = request.getParameter("decisionEndTime");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        if( "".equals(startTime)|| null == startTime ){
            startTime = getFirstMonthDay(format);
        }
        if("".equals(endTime) || null == endTime ){
            endTime = getCurrentDay(format);
        }
        //查双公示统计数据
        List<Object[]> list = jtt2XybCfService.getDataListSdbs(startTime,endTime);
        request.setAttribute("list", list);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime",endTime);
        return "listSdbs";
    }
	public String drwj(){
	    String type = request.getParameter("type");
	    if("1".equals(type)){
	        return "drxkwj";
	    }else{
	        return "drcfwj";
	    }
	    
	}
	
    public String showError(){
        String startTime = request.getParameter("decisionBeginTime");
        String endTime = request.getParameter("decisionEndTime");
        String xzjg = request.getParameter("xzjg");
        String type = request.getParameter("type");
        List<Object[]> list = this.jtt2XybCfService.selectError(startTime, endTime, xzjg,type);
        request.setAttribute("list", list);
        return "errorList";
    }
	
	private String getFirstMonthDay(SimpleDateFormat format){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH,0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		String firstDay = format.format(c.getTime());
		return firstDay;
	}
	
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
