package com.centit.jtt2xyb.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.service.WssbtjService;
import com.centit.workflow.sample.optmodel.BaseWFEntityAction;

//数据统计
public class jttWssbtjsx  extends BaseWFEntityAction<JiaoTongLog> implements ServletResponseAware {
    
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
		List<Map<String,Object>> list =	wssbtjService.getDataListsx(startTime,endTime);
		request.setAttribute("map", list);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		return "list";
		
	}
	
	public String showDetail(){
	    String type = request.getParameter("type");
	    String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String orgCode = request.getParameter("orgCode");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        if( "".equals(startTime)|| null == startTime ){
            startTime = getFirstMonthDay(format);
        }
        if("".equals(endTime) || null == endTime ){
            endTime = getCurrentDay(format);
        }
        String condition = " and  app.apply_date >=  to_date('" + startTime + "', 'yyyy-mm-dd')  and app.apply_date <= "
           +"  to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') ";
        if("all".equals(orgCode)){
            condition += " and bas.orgCode like 'JS000000%' ";
        }else if("cityall".equals(orgCode)){
            condition += " and bas.orgCode not like 'JS000000%' ";
        }else if(orgCode.length() == 10){
            condition += " and bas.orgCode = '" + orgCode + "' ";
        }else if(orgCode.length() == 8){
            condition += " and amo.idarea_code like '" + orgCode.substring(0,4) + "%' ";
        }else if(orgCode.length() == 6){
            condition += " and amo.idarea_code = '" + orgCode + "' ";
        }
	    switch(type){
	        case "sbsl":
	            condition += " and app.sync_sign <> '6' ";
	            break;
            case "cfzn":
                condition += " and ceil(TO_NUMBER(oar.update_date - app.apply_date)) <= 5 and oar.isaccept is not null and app.sync_sign <> '6' ";
                break;
            case "cfzw":
                condition += " and ceil(TO_NUMBER(oar.update_date - app.apply_date)) > 5  and oar.isaccept is not null and app.sync_sign <> '6' ";
                break;
                
            case "tzn":
                condition += " and ceil(TO_NUMBER(sysdate - app.apply_date)) <= 3 and app.sync_sign <> '6' "
                        + " and app.dj_id not in "
                        + " (select dj_id  from opt_apply_info@to_jttweb "
                        + " right join opt_apply_return@to_jttweb "
                        + " on dj_id = djid where dj_id is not null)";
                break;
            case "tfzj":
                condition += " and ceil(TO_NUMBER(sysdate - app.apply_date)) between 4 and 5 and app.sync_sign <> '6' "
                        + " and app.dj_id not in "
                        + " (select dj_id  from opt_apply_info@to_jttweb "
                        + " right join opt_apply_return@to_jttweb "
                        + " on dj_id = djid where dj_id is not null)";
                break;
            case "wcfzn":
                condition += " and ceil(TO_NUMBER(sysdate - app.apply_date)) > 5 and app.sync_sign <> '6' "
                        + " and app.dj_id not in "
                        + " (select dj_id  from opt_apply_info@to_jttweb "
                        + " right join opt_apply_return@to_jttweb "
                        + " on dj_id = djid where dj_id is not null)";
                break;
                
            case "sl":
                condition += " and ISACCEPT = 1 and app.sync_sign <> '6' ";
                break;
            case "bsl":
                condition += " and ISACCEPT = 0 and app.sync_sign <> '6' ";
                break;
            case "bz":
                condition += " and ISACCEPT = 4 and app.sync_sign <> '6' ";
                break;
	    }
	    List<Map<String,Object>> list = wssbtjService.getDataDetailListsx(condition);
        request.setAttribute("map", list);
	    return "detail";
	}
	
	/**
	 * 业务办理事项统计
	 * @return
	 */
	public String showywInfHadCount(){
	    
        String startTime = request.getParameter("decisionBeginTime");
        String endTime = request.getParameter("decisionEndTime");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        if( "".equals(startTime)|| null == startTime ){
            startTime = getFirstMonthDay(format);
        }
        if("".equals(endTime) || null == endTime ){
            endTime = getCurrentDay(format);
        }
        List<Map<String,Object>> list = wssbtjService.getYwInfHadCountStat(startTime, endTime);
        request.setAttribute("map", list);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "ywInfHadCount";
	}
	
	/**
	 * 
	 * “不见面”事项
	 * @return
	 */
	public String showNotMeetDetialList(){
        List<Map<String,Object>> list = wssbtjService.getDataListNotMeet(null, null);
        request.setAttribute("map", list);
	    return "showNotMeet";
	}
	
    public String showAllDetail(){
        String djid = request.getParameter("djid");
        String[] djids = djid.split(",");
        List<Map<String,Object>> list = wssbtjService.getDataAllDetailListsx(djids);
        request.setAttribute("map", list);
        return "detailAll";
    }
    
    /**
     * 查找当事人为个人且当事人证件号码无效的数据
     * @return
     * @throws Exception
     */
    public String showerrorList() throws Exception {
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        if( "".equals(startTime)|| null == startTime ){
            startTime = getFirstMonthDay(format);
        }
        if("".equals(endTime) || null == endTime ){
            endTime = getCurrentDay(format);
        }
        List<Map<String,Object>> list = wssbtjService.getErrorList(startTime,endTime);
        request.setAttribute("map", list);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "errorlist";
    }
    
    /**
     * 查找当事人为法人，当事人证件号码或联系人证件号码无效的数据
     * @return
     * @throws Exception
     */
    public String showlegalerrorList() throws Exception {
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        if( "".equals(startTime)|| null == startTime ){
            startTime = getFirstMonthDay(format);
        }
        if("".equals(endTime) || null == endTime ){
            endTime = getCurrentDay(format);
        }
        List<Map<String,Object>> list = wssbtjService.getLegalErrorList(startTime,endTime);
        request.setAttribute("map", list);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "legalerrorlist";
    }
    
    
    
    /**
     * 上报时间不在24小时之内
     * @return
     * @throws Exception
     */
    public String showOvertimeErrorList() throws Exception {
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        if( "".equals(startTime)|| null == startTime ){
            startTime = getFirstMonthDay(format);
        }
        if("".equals(endTime) || null == endTime ){
            endTime = getCurrentDay(format);
        }
        List<Map<String,Object>> list = wssbtjService.getOvertimeErrorList(startTime,endTime);
        request.setAttribute("map", list);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "overTimeErrorlist";
    }
    
    public String showNonErrorList() throws Exception {
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        if( "".equals(startTime)|| null == startTime ){
            startTime = getFirstMonthDay(format);
        }
        if("".equals(endTime) || null == endTime ){
            endTime = getCurrentDay(format);
        }
        List<Map<String,Object>> list = wssbtjService.getNonErrorList(startTime,endTime);
        request.setAttribute("map", list);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "nonErrorlist";
    }
    /**
     * 办件信息根部门统计
     * @return
     */
    public String dzzzByDep(){
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Date myDate = new Date(); 
        if(StringUtils.isBlank((String)filterMap.get("startTime"))){
            filterMap.put("startTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-01");
            request.setAttribute("startTime",(myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-01");
        }else{
            request.setAttribute("startTime",(String)filterMap.get("startTime"));
        }
        if(StringUtils.isBlank((String)filterMap.get("endTime"))){
            filterMap.put("endTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
            request.setAttribute("endTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
        }else{
            request.setAttribute("endTime",(String)filterMap.get("endTime"));
        }
        List<Map<String,Object>> list = wssbtjService.getDataListDzzz(filterMap);
        request.setAttribute("map", list);
        return "dzzzByDep";
    }
    /**
     * word导出
     */
    public void docWriter(){
        try {
            String url = request.getSession().getServletContext().getRealPath("writmodel")+"\\一张网数据统计情况.docx";
            OPCPackage pack = POIXMLDocument.openPackage(url);
            XWPFDocument document = new XWPFDocument(pack);
            String startTime = request.getParameter("decisionBeginTime");
            String endTime = request.getParameter("decisionEndTime");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
            if( "".equals(startTime)|| null == startTime ){
                startTime = getFirstMonthDay(format);
            }
            if("".equals(endTime) || null == endTime ){
                endTime = getCurrentDay(format);
            }
            Map<String, Object> filterMap = new HashMap<>();
            filterMap.put("startTime", startTime);
            filterMap.put("endTime", endTime);
            //办件报送情况
            int itemscount = 0;
            int itemspro = 0;
            int itemscity = 0;
            int itemsarea = 0;
            int itemsgl = 0;
            int itemsyg = 0;
            int itemsgk = 0;
            int itemshs = 0;
            int itemshd = 0;
            int itemszj = 0;
            int itemszb = 0;
            int itemsgg = 0;
            //外网申报报送情况
            int jttwebcount = 0;
            int jttwebpro = 0;
            int jttwebcity = 0;
            int jttwebarea = 0;
            int jttwebgl = 0;
            int jttwebyg = 0;
            int jttwebgk = 0;
            int jttwebhs = 0;
            int jttwebhd = 0;
            int jttwebzj = 0;
            int jttwebzb = 0;
            int jttwebgg = 0;
            //电子证照报送情况
            int elicencecount = 0;
            int elicencepro = 0;
            int elicencecity = 0;
            int elicencearea = 0;
            int elicencegl = 0;
            int elicenceyg = 0;
            int elicencegk = 0;
            int elicencehs = 0;
            int elicencehd = 0;
            int elicencezj = 0;
            int elicencezb = 0;
            int elicencegg = 0;
            //超过24小时报送
            int moreoneday = 0;
            int moreonedaygl = 0;
            int moreonedayyg = 0;
            int moreonedaygk = 0;
            int moreonedayhs = 0;
            int moreonedayhd = 0;
            int moreonedayzj = 0;
            int moreonedayzb = 0;
            int moreonedaygg = 0;
            //自然人证件号码无效
            int ordinary = 0;
            int ordinarygl = 0;
            int ordinaryyg = 0;
            int ordinarygk = 0;
            int ordinaryhs = 0;
            int ordinaryhd = 0;
            int ordinaryzj = 0;
            int ordinaryzb = 0;
            int ordinarygg = 0;
            //法人证件号码无效
            int legal = 0;
            int legalgl = 0;
            int legalyg = 0;
            int legalgk = 0;
            int legalhs = 0;
            int legalhd = 0;
            int legalzj = 0;
            int legalzb = 0;
            int legalgg = 0;
            //办件信息报送情况
            List<Map<String,Object>> dataListDzzzAll = wssbtjService.getDataListDzzzAll(filterMap);
            //外网申报统计
            List<Object[]> dataStatisticssxAll = wssbtjService.selectDataStatisticssxAll(startTime, endTime);
            //电子证照
            List<Object[]> dataListZzxxAll = wssbtjService.getDataListZzxxAll(startTime, endTime);
            //上报时间不在24小时之内
            List<Map<String,Object>> OvertimeErrorList = wssbtjService.getOvertimeErrorList(startTime,endTime);
            //查找当事人为个人且当事人证件号码无效的数据
            List<Map<String,Object>> errorList = wssbtjService.getErrorList(startTime,endTime);
            //查找当事人为法人，当事人证件号码或联系人证件号码无效的数据
            List<Map<String,Object>> legalErrorList = wssbtjService.getLegalErrorList(startTime,endTime);
            
            Iterator<XWPFTable> tables = document.getTablesIterator();
            int number = 0;
            while(tables.hasNext()){
                XWPFTable table = tables.next();
                if(table.getRows().size() < 10){
                    continue;
                }
                number ++;
                int count = table.getNumberOfRows();
                switch(number){
                    case 1:
                        for(int i = 1;i < count;i++){
                            XWPFTableRow row = table.getRow(i);
                            List<XWPFTableCell> cells = row.getTableCells();
                            for(Map<String,Object> map : dataListDzzzAll){
                                if(map.get("orgname").toString().indexOf(cells.get(1).getText()) != -1){
                                    int countAll = 0;
                                    if(!map.get("orgname").equals("合计")){
                                        cells.get(2).setText(map.get("GL") + "");
                                        cells.get(3).setText(map.get("YG") + "");
                                        cells.get(4).setText(map.get("GK") + "");
                                        cells.get(5).setText(map.get("HS") + "");
                                        cells.get(6).setText(map.get("HD") + "");
                                        cells.get(7).setText(map.get("ZJ") + "");
                                        cells.get(8).setText(map.get("JS") + "");
                                        cells.get(9).setText(map.get("GG") + "");
                                        itemsgl += Integer.parseInt(map.get("GL").toString());
                                        itemsyg += Integer.parseInt(map.get("YG").toString());
                                        itemsgk += Integer.parseInt(map.get("GK").toString());
                                        itemshs += Integer.parseInt(map.get("HS").toString());
                                        itemshd += Integer.parseInt(map.get("HD").toString());
                                        itemszj += Integer.parseInt(map.get("ZJ").toString());
                                        itemszb += Integer.parseInt(map.get("JS").toString());
                                        itemsgg += Integer.parseInt(map.get("GG").toString());
                                        countAll = Integer.parseInt(map.get("GL").toString())+Integer.parseInt(map.get("YG").toString())
                                        +Integer.parseInt(map.get("GK").toString())+Integer.parseInt(map.get("HS").toString())
                                        +Integer.parseInt(map.get("HD").toString())+Integer.parseInt(map.get("ZJ").toString())
                                        +Integer.parseInt(map.get("JS").toString())+Integer.parseInt(map.get("GG").toString());
                                        cells.get(10).setText(String.valueOf(countAll));
                                    }
                                    if(map.get("orgname").equals("合计")){
                                        cells.get(2).setText(itemsgl + "");
                                        cells.get(3).setText(itemsyg + "");
                                        cells.get(4).setText(itemsgk + "");
                                        cells.get(5).setText(itemshs + "");
                                        cells.get(6).setText(itemshd + "");
                                        cells.get(7).setText(itemszj + "");
                                        cells.get(8).setText(itemszb + "");
                                        cells.get(9).setText(itemsgg + "");
                                        itemscount = itemsgl + itemsyg + itemsgk + itemshs + itemshd + itemszj + itemszb + itemsgg;
                                        cells.get(10).setText(String.valueOf(countAll));
                                    }else if(map.get("orgname").equals("江苏省交通运输厅")){
                                        itemspro = countAll;
                                    }else if(map.get("childNo").toString().substring(4,6).equals("00")
                                            &&!map.get("childNo").toString().substring(2,6).equals("0000")){
                                        itemscity = itemscity + countAll;
                                    }
                                    break;
                                }
                            }
                        }
                        itemsarea = itemscount - itemspro - itemscity;
                        break;
                    case 2:
                        int gl = 0;
                        int yg = 0;
                        int gk = 0;
                        int hs = 0;
                        int hd = 0;
                        int zj = 0;
                        int zb = 0;
                        int gg = 0;
                        int allcount = 0;
                        for(int i = 1;i < count;i++){
                            XWPFTableRow row = table.getRow(i);
                            List<XWPFTableCell> cells = row.getTableCells();
                            for(Object[] map : dataStatisticssxAll){
                                if(map[1].toString().indexOf(cells.get(1).getText()) != -1){
                                    cells.get(2).setText(map[2].toString());
                                    cells.get(3).setText(map[3].toString());
                                    cells.get(4).setText(map[4].toString());
                                    cells.get(5).setText(map[5].toString());
                                    cells.get(6).setText(map[6].toString());
                                    cells.get(7).setText(map[7].toString());
                                    cells.get(8).setText(map[8].toString());
                                    cells.get(9).setText(map[9].toString());
                                    int countAll = Integer.parseInt(map[10].toString());
                                    cells.get(10).setText(countAll+"");
                                    gl += Integer.parseInt(map[2].toString());
                                    yg += Integer.parseInt(map[3].toString());
                                    gk += Integer.parseInt(map[4].toString());
                                    hs += Integer.parseInt(map[5].toString());
                                    hd += Integer.parseInt(map[6].toString());
                                    zj += Integer.parseInt(map[7].toString());
                                    zb += Integer.parseInt(map[8].toString());
                                    gg += Integer.parseInt(map[9].toString());
                                    allcount += countAll;
                                    if(map[1].equals("江苏省交通运输厅")){
                                        jttwebpro = countAll;
                                    }else if(map[0].toString().substring(4,6).equals("00")
                                            &&!map[0].toString().substring(2,6).equals("0000")){
                                        jttwebcity = jttwebcity + countAll;
                                    }
                                    break;
                                }else if(cells.get(1).getText().equals("合计")){
                                    cells.get(2).setText(gl + "");
                                    cells.get(3).setText(yg + "");
                                    cells.get(4).setText(gk + "");
                                    cells.get(5).setText(hs + "");
                                    cells.get(6).setText(hd + "");
                                    cells.get(7).setText(zj + "");
                                    cells.get(8).setText(zb + "");
                                    cells.get(9).setText(gg + "");
                                    cells.get(10).setText(allcount + "");
                                    jttwebgl = gl;
                                    jttwebyg = yg;
                                    jttwebgk = gk;
                                    jttwebhs = hs;
                                    jttwebhd = hd;
                                    jttwebzj = zj;
                                    jttwebzb = zb;
                                    jttwebgg = gg;
                                    jttwebcount = allcount;
                                    break;
                                }
                            }
                        }
                        jttwebarea = jttwebcount - jttwebpro - jttwebcity;
                        break;
                    case 3:
                        int egl = 0;
                        int eyg = 0;
                        int egk = 0;
                        int ehs = 0;
                        int ehd = 0;
                        int ezj = 0;
                        int ezb = 0;
                        int egg = 0;
                        int eallcount = 0;
                        for(int i = 1;i < count;i++){
                            XWPFTableRow row = table.getRow(i);
                            List<XWPFTableCell> cells = row.getTableCells();
                            for(Object[] map : dataListZzxxAll){
                                if(map[1].toString().indexOf(cells.get(1).getText()) != -1){
                                    cells.get(2).setText(map[2].toString());
                                    cells.get(3).setText(map[3].toString());
                                    cells.get(4).setText(map[4].toString());
                                    cells.get(5).setText(map[5].toString());
                                    cells.get(6).setText(map[6].toString());
                                    cells.get(7).setText(map[7].toString());
                                    cells.get(8).setText(map[8].toString());
                                    cells.get(9).setText(map[9].toString());
                                    int countAll = Integer.parseInt(map[2].toString())+Integer.parseInt(map[3].toString())
                                    +Integer.parseInt(map[4].toString())+Integer.parseInt(map[5].toString())
                                    +Integer.parseInt(map[6].toString())+Integer.parseInt(map[7].toString())
                                    +Integer.parseInt(map[8].toString())+Integer.parseInt(map[9].toString());
                                    cells.get(10).setText(countAll+"");
                                    egl += Integer.parseInt(map[2].toString());
                                    eyg += Integer.parseInt(map[3].toString());
                                    egk += Integer.parseInt(map[4].toString());
                                    ehs += Integer.parseInt(map[5].toString());
                                    ehd += Integer.parseInt(map[6].toString());
                                    ezj += Integer.parseInt(map[7].toString());
                                    ezb += Integer.parseInt(map[8].toString());
                                    egg += Integer.parseInt(map[9].toString());
                                    eallcount += countAll;
                                    if(map[1].equals("江苏省交通运输厅")){
                                        elicencepro = countAll;
                                    }else if(map[0].toString().substring(4,6).equals("00")
                                            &&!map[0].toString().substring(2,6).equals("0000")){
                                        elicencecity = elicencecity + countAll;
                                    }
                                    break;
                                }else if(cells.get(1).getText().equals("合计")){
                                    cells.get(2).setText(egl + "");
                                    cells.get(3).setText(eyg + "");
                                    cells.get(4).setText(egk + "");
                                    cells.get(5).setText(ehs + "");
                                    cells.get(6).setText(ehd + "");
                                    cells.get(7).setText(ezj + "");
                                    cells.get(8).setText(ezb + "");
                                    cells.get(9).setText(egg + "");
                                    cells.get(10).setText(eallcount + "");
                                    elicencegl = egl;
                                    elicenceyg = eyg;
                                    elicencegk = egk;
                                    elicencehs = ehs;
                                    elicencehd = ehd;
                                    elicencezj = ezj;
                                    elicencezb = ezb;
                                    elicencegg = egg;
                                    elicencecount = eallcount;
                                    break;
                                }
                            }
                        }
                        elicencearea = elicencecount - elicencepro - elicencecity;
                        break;
                    case 4:
                        for(int i = 1;i < count;i++){
                            XWPFTableRow row = table.getRow(i);
                            List<XWPFTableCell> cells = row.getTableCells();
                            for(Map<String,Object> map : OvertimeErrorList){
                                if(map.get("areaName").toString().indexOf(cells.get(1).getText()) != -1){
                                    if(!map.get("areaName").equals("合计")){
                                        cells.get(2).setText(map.get("gl") + "");
                                        cells.get(3).setText(map.get("yg") + "");
                                        cells.get(4).setText(map.get("gk") + "");
                                        cells.get(5).setText(map.get("hs") + "");
                                        cells.get(6).setText(map.get("hd") + "");
                                        cells.get(7).setText(map.get("zj") + "");
                                        cells.get(8).setText(map.get("zb") + "");
                                        cells.get(9).setText(map.get("gg") + "");
                                        moreonedaygl += Integer.parseInt(map.get("gl").toString());
                                        moreonedayyg += Integer.parseInt(map.get("yg").toString());
                                        moreonedaygk += Integer.parseInt(map.get("gk").toString());
                                        moreonedayhs += Integer.parseInt(map.get("hs").toString());
                                        moreonedayhd += Integer.parseInt(map.get("hd").toString());
                                        moreonedayzj += Integer.parseInt(map.get("zj").toString());
                                        moreonedayzb += Integer.parseInt(map.get("zb").toString());
                                        moreonedaygg += Integer.parseInt(map.get("gg").toString());
                                        int countAll = Integer.parseInt(map.get("gl").toString())+Integer.parseInt(map.get("yg").toString())
                                        +Integer.parseInt(map.get("gk").toString())+Integer.parseInt(map.get("hs").toString())
                                        +Integer.parseInt(map.get("hd").toString())+Integer.parseInt(map.get("zj").toString())
                                        +Integer.parseInt(map.get("zb").toString())+Integer.parseInt(map.get("gg").toString());
                                        cells.get(10).setText(String.valueOf(countAll));
                                    }
                                    if(map.get("areaName").equals("合计")){
                                        moreoneday = moreonedaygl + moreonedayyg + moreonedaygk + moreonedayhs
                                                   + moreonedayhd + moreonedayzj + moreonedayzb + moreonedaygg;
                                        cells.get(2).setText(moreonedaygl + "");
                                        cells.get(3).setText(moreonedayyg + "");
                                        cells.get(4).setText(moreonedaygk + "");
                                        cells.get(5).setText(moreonedayhs + "");
                                        cells.get(6).setText(moreonedayhd + "");
                                        cells.get(7).setText(moreonedayzj + "");
                                        cells.get(8).setText(moreonedayzb + "");
                                        cells.get(9).setText(moreonedaygg + "");
                                        cells.get(10).setText(moreoneday + "");
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case 5:
                        for(int i = 1;i < count;i++){
                            XWPFTableRow row = table.getRow(i);
                            List<XWPFTableCell> cells = row.getTableCells();
                            for(Map<String,Object> map : errorList){
                                if(map.get("areaName").toString().indexOf(cells.get(1).getText()) != -1){
                                    if(!map.get("areaName").equals("合计")){
                                        cells.get(2).setText(map.get("gl") + "");
                                        cells.get(3).setText(map.get("yg") + "");
                                        cells.get(4).setText(map.get("gk") + "");
                                        cells.get(5).setText(map.get("hs") + "");
                                        cells.get(6).setText(map.get("hd") + "");
                                        cells.get(7).setText(map.get("zj") + "");
                                        cells.get(8).setText(map.get("zb") + "");
                                        cells.get(9).setText(map.get("gg") + "");
                                        ordinarygl += Integer.parseInt(map.get("gl").toString());
                                        ordinaryyg += Integer.parseInt(map.get("yg").toString());
                                        ordinarygk += Integer.parseInt(map.get("gk").toString());
                                        ordinaryhs += Integer.parseInt(map.get("hs").toString());
                                        ordinaryhd += Integer.parseInt(map.get("hd").toString());
                                        ordinaryzj += Integer.parseInt(map.get("zj").toString());
                                        ordinaryzb += Integer.parseInt(map.get("zb").toString());
                                        ordinarygg += Integer.parseInt(map.get("gg").toString());
                                        int countAll = Integer.parseInt(map.get("gl").toString())+Integer.parseInt(map.get("yg").toString())
                                        +Integer.parseInt(map.get("gk").toString())+Integer.parseInt(map.get("hs").toString())
                                        +Integer.parseInt(map.get("hd").toString())+Integer.parseInt(map.get("zj").toString())
                                        +Integer.parseInt(map.get("zb").toString())+Integer.parseInt(map.get("gg").toString());
                                        cells.get(10).setText(String.valueOf(countAll));
                                    }
                                    if(map.get("areaName").equals("合计")){
                                        ordinary = ordinarygl + ordinaryyg + ordinarygk + ordinaryhs
                                                 + ordinaryhd + ordinaryzj + ordinaryzb + ordinarygg;
                                        cells.get(2).setText(ordinarygl + "");
                                        cells.get(3).setText(ordinaryyg + "");
                                        cells.get(4).setText(ordinarygk + "");
                                        cells.get(5).setText(ordinaryhs + "");
                                        cells.get(6).setText(ordinaryhd + "");
                                        cells.get(7).setText(ordinaryzj + "");
                                        cells.get(8).setText(ordinaryzb + "");
                                        cells.get(9).setText(ordinarygg + "");
                                        cells.get(10).setText(ordinary + "");
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case 6:
                        for(int i = 1;i < count;i++){
                            XWPFTableRow row = table.getRow(i);
                            List<XWPFTableCell> cells = row.getTableCells();
                            for(Map<String,Object> map : legalErrorList){
                                if(map.get("areaName").toString().indexOf(cells.get(1).getText()) != -1){
                                    if(!map.get("areaName").equals("合计")){
                                        cells.get(2).setText(map.get("gl") + "");
                                        cells.get(3).setText(map.get("yg") + "");
                                        cells.get(4).setText(map.get("gk") + "");
                                        cells.get(5).setText(map.get("hs") + "");
                                        cells.get(6).setText(map.get("hd") + "");
                                        cells.get(7).setText(map.get("zj") + "");
                                        cells.get(8).setText(map.get("zb") + "");
                                        cells.get(9).setText(map.get("gg") + "");
                                        legalgl += Integer.parseInt(map.get("gl").toString());
                                        legalyg += Integer.parseInt(map.get("yg").toString());
                                        legalgk += Integer.parseInt(map.get("gk").toString());
                                        legalhs += Integer.parseInt(map.get("hs").toString());
                                        legalhd += Integer.parseInt(map.get("hd").toString());
                                        legalzj += Integer.parseInt(map.get("zj").toString());
                                        legalzb += Integer.parseInt(map.get("zb").toString());
                                        legalgg += Integer.parseInt(map.get("gg").toString());
                                        int countAll = Integer.parseInt(map.get("gl").toString())+Integer.parseInt(map.get("yg").toString())
                                        +Integer.parseInt(map.get("gk").toString())+Integer.parseInt(map.get("hs").toString())
                                        +Integer.parseInt(map.get("hd").toString())+Integer.parseInt(map.get("zj").toString())
                                        +Integer.parseInt(map.get("zb").toString())+Integer.parseInt(map.get("gg").toString());
                                        cells.get(10).setText(String.valueOf(countAll));
                                    }
                                    if(map.get("areaName").equals("合计")){
                                        legal = legalgl + legalyg + legalgk + legalhs
                                              + legalhd + legalzj + legalzb + legalgg;
                                        cells.get(2).setText(legalgl + "");
                                        cells.get(3).setText(legalyg + "");
                                        cells.get(4).setText(legalgk + "");
                                        cells.get(5).setText(legalhs + "");
                                        cells.get(6).setText(legalhd + "");
                                        cells.get(7).setText(legalzj + "");
                                        cells.get(8).setText(legalzb + "");
                                        cells.get(9).setText(legalgg + "");
                                        cells.get(10).setText(String.valueOf(legal));
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                }
                
            }
            Map<String, String> map = new HashMap<>();
            String[] starttimes = startTime.split("-");
            String[] endtimes = endTime.split("-");
            Calendar calendar = Calendar.getInstance();
            map.put("datetime", starttimes[0] + "年" + starttimes[1] + "月" + starttimes[2] + "日～" 
                    + endtimes[0] + "年" + endtimes[1] + "月" + endtimes[2] + "日");//统计时间
            map.put("sysdate", calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DATE) + "日");//出报表时间
            map.put("yearDate", calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月");
            
            //办件报送
            map.put("itemscount", itemscount + "");//办件报送总数
            map.put("itemspro", itemspro + "");//办件报送省级
            map.put("emscity", itemscity + "");//办件报送市级
            map.put("itemsarea", itemsarea + "");//办件报送县级
            map.put("itemsgl", itemsgl + "");//办件报送公路
            map.put("itemsyg", itemsyg + "");//办件报送运管
            map.put("itemsgk", itemsgk + "");//办件报送港口
            map.put("itemshs", itemshs + "");//办件报送海事
            map.put("itemshd", itemshd + "");//办件报送航道
            map.put("itemszj", itemszj + "");//办件报送质监
            map.put("itemszb", itemszb + "");//办件报送建设
            map.put("itemsgg", itemsgg + "");//办件报送高管
            //电子证
            map.put("elicencecount", elicencecount + "");
            map.put("elicencepro", elicencepro + "");
            map.put("elicencecity", elicencecity + "");
            map.put("elicencearea", elicencearea + "");
            map.put("elicencegl", elicencegl + "");
            map.put("elicenceyg", elicenceyg + "");
            map.put("elicencegk", elicencegk + "");
            map.put("elicencehs", elicencehs + "");
            map.put("elicencehd", elicencehd + "");
            map.put("elicencezj", elicencezj + "");
            map.put("elicencezb", elicencezb + "");
            map.put("elicencegg", elicencegg + "");
            //外网申报
            map.put("jttwebcount", jttwebcount + "");
            map.put("jttwebpro", jttwebpro + "");
            map.put("jttwebcity", jttwebcity + "");
            map.put("jttwebarea", jttwebarea + "");
            map.put("jttwebgl", jttwebgl + "");
            map.put("jttwebyg", jttwebyg + "");
            map.put("jttwebgk", jttwebgk + "");
            map.put("jttwebhs", jttwebhs + "");
            map.put("jttwebhd", jttwebhd + "");
            map.put("jttwebzj", jttwebzj + "");
            map.put("jttwebzb", jttwebzb + "");
            map.put("jttwebgg", jttwebgg + "");
            //存在问题
            map.put("errorcount", (moreoneday + ordinary + legal) + "");
            float proportion = new BigDecimal(((double)(moreoneday + ordinary + legal)*100)/itemscount).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
            float moreonedaypro = new BigDecimal((double)moreoneday*100/itemscount).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
            float ordinarypro = new BigDecimal((double)ordinary*100/itemscount).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
            float pro = new BigDecimal((double)legal*100/itemscount).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
            map.put("proportion", proportion + "%");
            //超过24小时报送
            map.put("moreoneday", moreoneday + "");
            map.put("moreonedaypro",moreonedaypro + "%");
            map.put("moreonedaygl", moreonedaygl + "");
            map.put("moreonedayyg", moreonedayyg + "");
            map.put("moreonedaygk", moreonedaygk + "");
            map.put("moreonedayhs", moreonedayhs + "");
            map.put("moreonedayhd", moreonedayhd + "");
            map.put("moreonedayzj", moreonedayzj + "");
            map.put("moreonedayzb", moreonedayzb + "");
            map.put("moreonedaygg", moreonedaygg + "");
            //自然人证件号码无效
            map.put("ordinary", ordinary + "");
            map.put("ordinarypro", ordinarypro + "%");
            map.put("ordinarygl", ordinarygl + "");
            map.put("ordinaryyg", ordinaryyg + "");
            map.put("ordinarygk", ordinarygk + "");
            map.put("ordinaryhs", ordinaryhs + "");
            map.put("ordinaryhd", ordinaryhd + "");
            map.put("ordinaryzj", ordinaryzj + "");
            map.put("ordinaryzb", ordinaryzb + "");
            map.put("ordinarygg", ordinarygg + "");
            //法人证件号码无效
            map.put("legal", legal + "");
            map.put("pro", pro + "%");
            map.put("gl", legalgl + "");
            map.put("yg", legalyg + "");
            map.put("gk", legalgk + "");
            map.put("hs", legalhs + "");
            map.put("hd", legalhd + "");
            map.put("zj", legalzj + "");
            map.put("zb", legalzb + "");
            map.put("gg", legalgg + "");
            
            Iterator<XWPFParagraph> itparag = document.getParagraphsIterator();
            while(itparag.hasNext()){
                XWPFParagraph paragraph = itparag.next();
                Set<String> set = map.keySet();  
                Iterator<String> iterator = set.iterator();  
                while (iterator.hasNext()) {  
                    String key = iterator.next();  
                    List<XWPFRun> run=paragraph.getRuns();  
                    for(int i=0;i<run.size();i++)  
                    {  
                        if(run.get(i).getText(run.get(i).getTextPosition())!=null &&  
                                run.get(i).getText(run.get(i).getTextPosition()).equals(key)){
                            /** 
                             * 参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始 
                             * 就可以把原来的文字全部替换掉了 
                             */  
                            run.get(i).setText(map.get(key),0);  
                            break;
                        }  
                    }  
                }
            }
            
            String userAgent = request.getHeader("User-Agent");  
                
           
       
            String fileName = "一张网数据统计情况（"+starttimes[0] + "年" + starttimes[1] + "月" + starttimes[2] + "日～" 
                    + endtimes[0] + "年" + endtimes[1] + "月" + endtimes[2] + "日"+"）.docx";
            //response.setHeader("Content-Disposition","attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
           
            
            // 针对IE或者以IE为内核的浏览器：  
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {  
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");  
            } else {  
                // 非IE浏览器的处理：  
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");  
            } 
            response.setHeader("Content-Disposition","attachment;filename="+ fileName);
            //response.setHeader("Content-Disposition","attachment;filename="+ new String( fileName.getBytes("UTF-8"), "ISO-8859-1" ));
            //response.setContentType("application/octet-stream; charset=UTF-8");
            
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("UTF-8");
            
            ServletOutputStream out = response.getOutputStream();
            try {  
                document.write(out);
                out.flush();  
            }  
            catch (Exception e)  
            {  
                e.printStackTrace();  
            }finally {
                out.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * 办件信息报送情况菜单
     * 办件信息根部门省市县统计
     * @return
     */
    public String dzzzByDepAll(){
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Date myDate = new Date(); 
        if(StringUtils.isBlank((String)filterMap.get("startTime"))){
            filterMap.put("startTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-1");
            request.setAttribute("startTime",(myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-1");
        }else{
            request.setAttribute("startTime",(String)filterMap.get("startTime"));
        }
        if(StringUtils.isBlank((String)filterMap.get("endTime"))){
            filterMap.put("endTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
            request.setAttribute("endTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
        }else{
            request.setAttribute("endTime",(String)filterMap.get("endTime"));
        }
        List<Map<String,Object>> list = wssbtjService.getDataListDzzzAll(filterMap);
        request.setAttribute("map", list);
        return "dzzzByDepAll";
    }
    /**
     * 电子证照根县级部门统计
     * @return
     */
    public String zzxxByDep(){
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Date myDate = new Date(); 
        if(StringUtils.isBlank((String)filterMap.get("startTime"))){
            filterMap.put("startTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-01");
            request.setAttribute("startTime",(myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-01");
        }else{
            request.setAttribute("startTime",(String)filterMap.get("startTime"));
        }
        if(StringUtils.isBlank((String)filterMap.get("endTime"))){
            filterMap.put("endTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
            request.setAttribute("endTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
        }else{
            request.setAttribute("endTime",(String)filterMap.get("endTime"));
        }
        List<Map<String,Object>> list = wssbtjService.getDataListZzxx(filterMap);
        request.setAttribute("map", list);
        return "zzxxByDep";
    }
    
    /**
     * 交通部数据报告送情况
     * @return
     */
    public String traffic(){
        String time = request.getParameter("decisionBeginTime");
        Map<String, Object> filterMap = new HashMap<>();
        if(StringUtils.isNotBlank(time)){
            filterMap.put("time", time);
            request.setAttribute("time",time);
        }else{
            Date myDate = new Date(); 
            filterMap.put("time", (myDate.getYear()+1900));
            request.setAttribute("time",(myDate.getYear()+1900) + "");
        }
        List<Map<String,Object>> list = wssbtjService.gettrafficData(filterMap);
        request.setAttribute("map", list);
        return "traffic";
    }
    /**
     * 电子证照省市部门统计
     * @return
     */
    public String zzxxByDepPro(){
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Date myDate = new Date(); 
        if(StringUtils.isBlank((String)filterMap.get("startTime"))){
            filterMap.put("startTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-01");
            request.setAttribute("startTime",(myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-01");
        }else{
            request.setAttribute("startTime",(String)filterMap.get("startTime"));
        }
        if(StringUtils.isBlank((String)filterMap.get("endTime"))){
            filterMap.put("endTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
            request.setAttribute("endTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
        }else{
            request.setAttribute("endTime",(String)filterMap.get("endTime"));
        }
        List<Map<String,Object>> list = wssbtjService.getDataListZzxxPro(filterMap);
        request.setAttribute("map", list);
        return "zzxxByDepPro";
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
