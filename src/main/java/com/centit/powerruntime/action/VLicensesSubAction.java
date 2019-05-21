package com.centit.powerruntime.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.po.LicensesSub;
import com.centit.powerruntime.po.QlQdzxsxtj;
import com.centit.powerruntime.po.QlQdzxtj;
import com.centit.powerruntime.po.VLicensesSub;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.powerruntime.service.VLicensesSubManager;
import com.ibm.icu.text.SimpleDateFormat;

public class VLicensesSubAction  extends BaseEntityExtremeAction<VLicensesSub> implements ServletResponseAware {
	private static final Log log = LogFactory.getLog(VLicensesSubAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private VLicensesSubManager vLicensesSubMag;

    HttpServletResponse response;
    
    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
    public void setVLicensesSubManager(VLicensesSubManager basemgr)
	{
        vLicensesSubMag = basemgr;
		this.setBaseEntityManager(vLicensesSubMag);
	}
	/**
	 * 电子证照（批文）列表查询
	 * @return
	 */
    public String getVLicensesSub(){
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Date myDate = new Date(); 
        if(StringUtils.isBlank((String)filterMap.get("decisionBeginTime"))){
            filterMap.put("decisionBeginTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-01");
        }
        if(StringUtils.isBlank((String)filterMap.get("decisionEndTime"))){
            filterMap.put("decisionEndTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
        }
        List<LicensesSub> licensesSubs = vLicensesSubMag.getsl(filterMap);
        request.setAttribute("licensesSubs", licensesSubs);
        if(StringUtils.isBlank((String)filterMap.get("decisionBeginTime"))){
            request.setAttribute("startTime",(myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-01");
        }else{
            request.setAttribute("startTime",((String)filterMap.get("decisionBeginTime")));
        }
        if(StringUtils.isBlank((String)filterMap.get("decisionEndTime"))){
            request.setAttribute("endTime", (myDate.getYear()+1900)+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate());
        }else{
            request.setAttribute("endTime", ((String)filterMap.get("decisionEndTime")));
        }
        return "licensesSub";
    }
    /**
     * 电子证照（批文）导出
     * @return
     * @throws IOException 
     * @throws UnsupportedEncodingException 
     */
    public String export() throws Exception{
        String startTime = request.getParameter("decisionBeginTime");
        String endTime = request.getParameter("decisionEndTime");
        export2(startTime,endTime , request,response);
        return null;
    }

    
	private void export2(String startTime, String endTime,
            HttpServletRequest request, HttpServletResponse response2) {
	  //创建一个excel对象  
        HSSFWorkbook excel = new HSSFWorkbook();
        //firstTime style
        HSSFCellStyle timeStyle =   getFirstTimeCellStyle(excel);
        //单元格样式  
        HSSFCellStyle titleStyle =   getTitleCellStyle(excel);
        //内容样式
        HSSFCellStyle dataStyle =   getDataCellStyle(excel);
        //添加sheet  
        HSSFSheet sheet =   excel.createSheet();
        //设置标题列宽,
        setWidth(sheet);
        //时间段标题
        getFirstRow(sheet,startTime,endTime,timeStyle);
        //创建标题
        getTitle(sheet,excel,titleStyle);
        //创建cell，写入数据  拿到的数据  list<Map>
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("beginTime", startTime);
        filterMap.put("endTime", endTime);
        insertExcel(sheet,this.vLicensesSubMag.getVLicensesSubExport(filterMap),dataStyle);
        //将以上缓存中的内容写到EXCEL文件中
        try {
            downLoadExcle(response, excel);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
	 private void getFirstRow(HSSFSheet sheet, String startTime, String endTime, HSSFCellStyle timeStyle) {
         CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 2);
         sheet.addMergedRegion(region1); 
         HSSFRow row = sheet.createRow(0);
         Cell cell =  row.createCell(0);
         cell.setCellValue("电子证照（批文报送）情况统计");
         cell.setCellStyle(timeStyle);
     }
	 private HSSFCellStyle getFirstTimeCellStyle(HSSFWorkbook excel) {
         HSSFFont font = excel.createFont();
         HSSFCellStyle cellStyle = excel.createCellStyle();
         font.setFontName("黑体");    
         font.setFontHeightInPoints((short) 16);//设置字体大小    
         font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
         cellStyle.setFont(font);
         cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//创建一个居中样式
         return cellStyle;
     }

     private void setWidth(HSSFSheet sheet) {
         sheet.setColumnWidth(0, 40 * 256);
         sheet.setColumnWidth(1, 60 * 256);
         sheet.setColumnWidth(2, 20 * 256);
         sheet.setColumnWidth(3, 20 * 256);
         sheet.setColumnWidth(4, 20 * 256);
     }

     private void downLoadExcle(HttpServletResponse response, HSSFWorkbook excel)
             throws UnsupportedEncodingException, IOException {
         String fileName = "电子证照（批文报送）情况.xls";
         response.setHeader("Content-Disposition","attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
         response.setContentType("application/octet-stream; charset=UTF-8");
         ServletOutputStream out = response.getOutputStream();
         try {  
             excel.write(out); 
             out.flush();  
         }  
         catch (Exception e)  
         {  
             e.printStackTrace();  
         }finally {
             out.close();
         }
     }
     //List<Map<String, Object>> dataList
     private void insertExcel(HSSFSheet sheet, List<VLicensesSub> vLicensesSub, HSSFCellStyle style) {
         List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
         for (VLicensesSub vls : vLicensesSub) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("orgname", vls.getOrgname());
            map.put("orgcode", vls.getOrgcode());
            map.put("zzname", vls.getZzName());
            map.put("sl", vls.getSl());
            dataList.add(map);
      }
         
         for (int i = 0; i < dataList.size(); i++) {
             HSSFRow row = sheet.createRow(i + 2);
             for (int j = 0; j < 3; j++) {
                 Cell cell = row.createCell(j);
                 cell.setCellStyle(style);
                 Object data = dataList.get(i).get(getValue(j));
                 if(null != data && !"".equals(data)){
                     cell.setCellValue(""+dataList.get(i).get(getValue(j)));
                 }else{
                     cell.setCellValue("");
                 }
             }
         }
     }
     
     private String getValue(int j ){
         if(0 == j){
             return "orgname";
         }else if(1 == j){
             return "zzname";
         }else if(2 == j){
             return "sl";
         }
         return "";
     }

     private void getTitle(HSSFSheet sheet, HSSFWorkbook excel, HSSFCellStyle style) {
         HSSFRow row1 = sheet.createRow(1);
         for(int i =0;i<10;i++){
             HSSFCell cell1 = row1.createCell(i);
         }
         String [] title1 = {"业务局","模板名称","数量"};
         for(int i = 0;i<title1.length;i++){
             if(i==0){
                 HSSFCell cell = row1.createCell(0);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
             }else if(i==1){
                 HSSFCell cell = row1.createCell(1);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
             }else if(i==2){
                 HSSFCell cell = row1.createCell(2);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
             }
         }
     }

     private HSSFCellStyle getTitleCellStyle(HSSFWorkbook excel) {
         HSSFFont font = excel.createFont();
         HSSFCellStyle cellStyle = excel.createCellStyle();
         font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
         cellStyle.setFont(font);
         cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//创建一个居中样式
         return cellStyle;
     }
     private HSSFCellStyle getDataCellStyle(HSSFWorkbook excel) {
         HSSFCellStyle cellStyle = excel.createCellStyle();
         cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//创建一个居中样式
         return cellStyle;
     }
     private String [] getTitleExcel(){
         String [] title = {"业务局","模板名称","数量"};
         return title;
     }  
    public String delete() {
	    super.delete();      
	    
	    return "delete";
	}

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
        
    }
}
