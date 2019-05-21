package com.centit.jtt2xyb.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.action.BaseAction;
import com.centit.jtt2xyb.service.Jtt2XybCfService;

@SuppressWarnings("serial")
public class ExportExcel extends BaseAction implements ServletResponseAware{

	private Jtt2XybCfService jtt2XybCfService;
    HttpServletResponse response;
    private String decisionBeginTime;
    private String decisionEndTime;
	public void setJtt2XybCfService(Jtt2XybCfService jtt2XybCfService) {
		this.jtt2XybCfService = jtt2XybCfService;
	}
	
	public String getDecisionBeginTime() {
        return decisionBeginTime;
    }

    public void setDecisionBeginTime(String decisionBeginTime) {
        this.decisionBeginTime = decisionBeginTime;
    }

    public String getDecisionEndTime() {
        return decisionEndTime;
    }

    public void setDecisionEndTime(String decisionEndTime) {
        this.decisionEndTime = decisionEndTime;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
	public String execute() throws Exception {
		export(decisionBeginTime,decisionEndTime , request, response);
		return null;
	}

	private void export( String startTime, String endTime, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		getTitle(sheet,getTitleExcel(),excel,titleStyle);
		//创建cell，写入数据  拿到的数据  list<Map>
		insertExcel(sheet,this.jtt2XybCfService.getDataList(startTime, endTime),dataStyle);
		//将以上缓存中的内容写到EXCEL文件中
		downLoadExcle(response, excel);
	}

	private void getFirstRow(HSSFSheet sheet, String startTime, String endTime, HSSFCellStyle timeStyle) {
		CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 4);
		sheet.addMergedRegion(region1); 
		HSSFRow row = sheet.createRow(0);
		Cell cell =  row.createCell(0);
		cell.setCellValue("\"双公示\"数据统计表("+startTime+"至"+endTime+")");
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
		sheet.setColumnWidth(1, 20 * 256);
		sheet.setColumnWidth(2, 20 * 256);
		sheet.setColumnWidth(3, 20 * 256);
		sheet.setColumnWidth(4, 20 * 256);
	}

	private void downLoadExcle(HttpServletResponse response, HSSFWorkbook excel)
			throws UnsupportedEncodingException, IOException {
		String fileName = "上报统计.xls";
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

	private void insertExcel(HSSFSheet sheet, List<Object[]> dataList, HSSFCellStyle style) {
		for (int i = 0; i < dataList.size(); i++) {
			HSSFRow row = sheet.createRow(i + 2);
			for (int j = 0; j < 7; j++) {
				if(j != 5){
				    Cell cell = row.createCell(j==6?5:j);
	                cell.setCellStyle(style);
				    Object data = dataList.get(i)[j];
	                if(null != data && !"".equals(data)){
	                    cell.setCellValue(""+dataList.get(i)[j]);
	                }else{
	                    cell.setCellValue("");
	                }
				}
			}
			
		}
	}
	
	private String getValue(int j ){
		if(0 == j){
			return "XZJG";
		}else if(1 == j){
			return "CQNUM";
		}else if(2 == j){
			return "DRNUM";
		}else if(3 == j){
			return "SUCCESSNUM";
		}else if(4 == j){
			return "ERRORNUM";
		}
		return "";
	}


	private void getTitle(HSSFSheet sheet, String[] title, HSSFWorkbook excel, HSSFCellStyle style) {
		HSSFRow row = sheet.createRow(1);
		for (int i = 0; i < title.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
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
		String [] title = {"行政机关","成功报送数据量（许可） ","错误数据量（许可）","成功报送数据量（处罚）","错误数据量（处罚）","合计"};
		return title;
	}



    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
        
    }
}
