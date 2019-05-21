package com.centit.jtt2xyb.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.WssbxzxkBo;
import com.centit.jtt2xyb.service.WssbtjService;
import com.centit.workflow.sample.optmodel.BaseWFEntityAction;

/**
 * 行政许可导出
 * TODO Class description should be added
 * 
 * @author admin
 * @create 2019年3月6日
 * @version
 */
public class jttWssbxzxk extends BaseWFEntityAction<JiaoTongLog> implements ServletResponseAware{
    
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
     * 导出行政许可列表查询
     */
    @Override
    public String execute() throws Exception {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        if(!StringUtils.isBlank((String)filterMap.get("xkjdrqBeginTime"))){
            request.setAttribute("startDate",(String)filterMap.get("xkjdrqBeginTime"));
        }else{
            request.setAttribute("startDate","");
        }
        if(!StringUtils.isBlank((String)filterMap.get("xkjdrqEndTime"))){
            request.setAttribute("endDate", (String)filterMap.get("xkjdrqEndTime"));
        }else{
            request.setAttribute("endDate", "");
        }
        Limit limit = ExtremeTableUtils.getLimit(request,15);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        List<WssbxzxkBo> list = wssbtjService.getXzxkList(filterMap,pageDesc);
        request.setAttribute("totalRows", pageDesc.getTotalRows());
        request.setAttribute("map", list);
        return "list";
        
    }
    

    @Override
    public void setServletResponse(HttpServletResponse arg0) {
        // TODO Auto-generated method stub
        
    }

}
