package com.centit.jtt2xyb.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.action.BaseAction;
import com.centit.jtt2xyb.bo.WssbxzcfBo;
import com.centit.jtt2xyb.service.WssbtjService;

public class ExportBxzcf extends BaseAction implements ServletResponseAware{
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
        export( request,response);
        return null;
    }
    
    private void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        //getFirstRow(sheet,null,null,timeStyle);
        //创建标题
        getTitle(sheet,excel,titleStyle);
        //创建cell，写入数据  拿到的数据  list<Map>
        String startDate = request.getParameter("cfjdrqBeginTime");
        String endDate = request.getParameter("cfjdrqEndTime");
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("startDate", startDate);
        filterMap.put("endDate", endDate);
        filterMap.put("cfsclx", request.getParameter("cfsclx"));
        filterMap.put("cfxdrlx", request.getParameter("cfxdrlx"));
        insertExcel(sheet,this.wssbtjService.getXzcfAllList(filterMap),dataStyle);
        //将以上缓存中的内容写到EXCEL文件中
        downLoadExcle(response, excel,filterMap);
    }
    
    private void getTitle(HSSFSheet sheet, HSSFWorkbook excel, HSSFCellStyle style) {
        HSSFRow row1 = sheet.createRow(0);
        String [] title1 = {"行政相对人名称","行政相对人代码_1（统一社会信用代码）","行政相对人代码_2（工商注册号）","行政相对人代码_3（组织机构代码）","行政相对人代码_4（税务登记号） ","行政相对人代码_5（事业单位证书号）",
                "行政相对人代码_6（社会组织登记证号）","法定代表人","法定代表人身份证号","证件类型","证件号码","行政处罚决定书文号","违法行为类型","违法事实","处罚依据","处罚类别","处罚内容","处罚金额（万元）",
                "没收违法所得、没收非法财务的金额（万元）","暂扣或吊销证照名称及编号","处罚决定日期","处罚有效期","公示截止期","处罚机关","处罚机关统一社会信用代码","数据来源单位","数据来源单位统一社会信用代码","备注","数据导出时间"};
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
            }else if(i==3){
                HSSFCell cell = row1.createCell(3);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==4){
                HSSFCell cell = row1.createCell(4);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==5){
                HSSFCell cell = row1.createCell(5);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==6){
                HSSFCell cell = row1.createCell(6);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==7){
                HSSFCell cell = row1.createCell(7);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==8){
                HSSFCell cell = row1.createCell(8);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==9){
                HSSFCell cell = row1.createCell(9);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==10){
                HSSFCell cell = row1.createCell(10);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==11){
                HSSFCell cell = row1.createCell(11);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==12){
                HSSFCell cell = row1.createCell(12);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==13){
                HSSFCell cell = row1.createCell(13);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==14){
                HSSFCell cell = row1.createCell(14);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==15){
                HSSFCell cell = row1.createCell(15);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==16){
                HSSFCell cell = row1.createCell(16);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==17){
                HSSFCell cell = row1.createCell(17);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==18){
                HSSFCell cell = row1.createCell(18);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==19){
                HSSFCell cell = row1.createCell(19);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==20){
                HSSFCell cell = row1.createCell(20);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==21){
                HSSFCell cell = row1.createCell(21);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==22){
                HSSFCell cell = row1.createCell(22);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==23){
                HSSFCell cell = row1.createCell(23);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==24){
                HSSFCell cell = row1.createCell(24);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==25){
                HSSFCell cell = row1.createCell(25);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==26){
                HSSFCell cell = row1.createCell(26);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }else if(i==27){
                HSSFCell cell = row1.createCell(27);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }
            else if(i==28){
                HSSFCell cell = row1.createCell(28);
                cell.setCellValue(title1[i]);
                cell.setCellStyle(style);
            }
        }
    }
    
    private void insertExcel(HSSFSheet sheet, List<WssbxzcfBo> dataList, HSSFCellStyle style) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd" );
        int n = 0;
        for(Object obj : dataList) {
            HSSFRow row = sheet.createRow(n + 1);
            n++;
            for (int j = 0; j < 29; j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(style);
                Object[] objs = (Object[]) obj;
                if(null != objs[j] && !"".equals(objs[j])){
                    if(j==20||j==21||j==22){
                        cell.setCellValue(sdf.format(objs[j]));
                    }else{
                        cell.setCellValue(""+objs[j]);
                    }
                }else{
                    cell.setCellValue("");
                }
            }
        
        }
    }
    
    private void downLoadExcle(HttpServletResponse response, HSSFWorkbook excel,Map<String, Object> filterMap)
            throws UnsupportedEncodingException, IOException {
        String fileName = "ZHXYXT0000_";
        if (!StringUtils.isBlank((String)filterMap.get("cfsclx"))) {
            if("1".equals(filterMap.get("cfsclx"))){
                if (!StringUtils.isBlank((String)filterMap.get("cfxdrlx"))) {
                    if("1".equals(filterMap.get("cfxdrlx"))){
                        fileName+="XYGJJH1-0301";
                    }else if("2".equals(filterMap.get("cfxdrlx"))){
                        fileName+="XYGJJH2-0301";
                    }
                } 
            }else if("2".equals(filterMap.get("cfsclx"))){
                if (!StringUtils.isBlank((String)filterMap.get("cfxdrlx"))) {
                    if("1".equals(filterMap.get("cfxdrlx"))){
                        fileName+="XYSJJH1-0301";
                    }else if("2".equals(filterMap.get("cfxdrlx"))){
                        fileName+="XYSJJH2-0301";
                    }
                }
            }else if("3".equals(filterMap.get("cfsclx"))){
                if (!StringUtils.isBlank((String)filterMap.get("cfxdrlx"))) {
                    if("1".equals(filterMap.get("cfxdrlx"))){
                        fileName+="XYDYJH1-0301";
                    }else if("2".equals(filterMap.get("cfxdrlx"))){
                        fileName+="XYDYJH2-0301";
                    }
                }
            }else if("4".equals(filterMap.get("cfsclx"))){
                if (!StringUtils.isBlank((String)filterMap.get("cfxdrlx"))) {
                    if("1".equals(filterMap.get("cfxdrlx"))){
                        fileName+="XYSYJH1-0301";
                    }else if("2".equals(filterMap.get("cfxdrlx"))){
                        fileName+="XYSYJH2-0301";
                    }
                }
            }
            
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        fileName+="_"+sdf.format(d)+".xls";
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
    
    private void setWidth(HSSFSheet sheet) {
        sheet.setColumnWidth(0, 30 * 256);
        sheet.setColumnWidth(1, 30 * 256);
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
        
    }
}
