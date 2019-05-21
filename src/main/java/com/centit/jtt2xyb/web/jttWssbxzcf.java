package com.centit.jtt2xyb.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.WssbxzcfBo;
import com.centit.jtt2xyb.service.WssbtjService;
import com.centit.workflow.sample.optmodel.BaseWFEntityAction;

/**
 * 行政处罚
 * TODO Class description should be added
 * 
 * @author admin
 * @create 2019年3月6日
 * @version
 */
public class jttWssbxzcf extends BaseWFEntityAction<JiaoTongLog> implements ServletResponseAware{
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
     * 行政处罚导出列表查询
     */
    @Override
    public String execute() throws Exception {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        if(!StringUtils.isBlank((String)filterMap.get("cfjdrqBeginTime"))){
            request.setAttribute("startDate",(String)filterMap.get("cfjdrqBeginTime"));
        }else{
            request.setAttribute("startDate","");
        }
        if(!StringUtils.isBlank((String)filterMap.get("cfjdrqEndTime"))){
            request.setAttribute("endDate", (String)filterMap.get("cfjdrqEndTime"));
        }else{
            request.setAttribute("endDate", "");
        }
        //Limit limit = ExtremeTableUtils.getLimit(request);
        Limit limit = ExtremeTableUtils.getLimit(request,15);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        List<WssbxzcfBo> list = wssbtjService.getXzcfList(filterMap,pageDesc);
        request.setAttribute("map", list);
        request.setAttribute("totalRows", pageDesc.getTotalRows());
        return "list";
        
    }
    

    @Override
    public void setServletResponse(HttpServletResponse arg0) {
        // TODO Auto-generated method stub
        
    }
}
