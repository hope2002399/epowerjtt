package com.centit.jtt2xyb.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.action.BaseAction;
import com.centit.jtt2xyb.service.WssbtjService;
import com.centit.workflow.sample.optmodel.BaseWFEntityAction;

public class ExportLegarerror extends BaseAction implements ServletResponseAware{
    
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
		getFirstRow(sheet,null,null,timeStyle);
		//创建标题
		getTitle(sheet,excel,titleStyle);
		//创建cell，写入数据  拿到的数据  list<Map>
		String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
		insertExcel(sheet,this.wssbtjService.getLegalErrorList(startTime, endTime),dataStyle);
		//将以上缓存中的内容写到EXCEL文件中
		downLoadExcle(response, excel);
	}

	private void getFirstRow(HSSFSheet sheet, String startTime, String endTime, HSSFCellStyle timeStyle) {
		CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 9);
		sheet.addMergedRegion(region1); 
		HSSFRow row = sheet.createRow(0);
		Cell cell =  row.createCell(0);
		cell.setCellValue("申请人为法人，并且证号类型和证件号码不匹配的数据");
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
		/*sheet.setColumnWidth(1, 20 * 256);
		sheet.setColumnWidth(2, 30 * 256);
		sheet.setColumnWidth(3, 20 * 256);*/
	}

	private void downLoadExcle(HttpServletResponse response, HSSFWorkbook excel)
			throws UnsupportedEncodingException, IOException {
		String fileName = "证件号码无效的数据.xls";
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

	private void insertExcel(HSSFSheet sheet, List<Map<String, Object>> dataList, HSSFCellStyle style) {
	    for (int i = 0; i < dataList.size(); i++) {
            int hj = 0;
            int [] a = {1,2,3,4,5,6,7,8};
            for (int j = 0; j < a.length; j++) {
                hj = hj + Integer.parseInt(dataList.get(i).get(getValue(a[j])).toString());
            }
            dataList.get(i).put("hj", hj);
        }
	    int n = 0;
		for (int i = 0; i < dataList.size(); i++) {
		    if(StringUtils.isNotBlank((String)dataList.get(i).get("parentNo")) || "合计".equals(dataList.get(i).get("areaName").toString())
		|| "江苏省交通运输厅".equals(dataList.get(i).get("areaName").toString())){
		        HSSFRow row = sheet.createRow(n + 2);
		        n++;
	            for (int j = 0; j < 10; j++) {
	                Cell cell = null;
	                if(j != 10){
	                    cell = row.createCell(j);
	                }else{
	                    cell = row.createCell(9);
	                }
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
	}
	
	private String getValue(int j ){
	    if(0 == j){
            return "areaName";
        }else if(1 == j){
            return "gl";
        }else if(2 == j){
            return "yg";
        }else if(3 == j){
            return "gk";
        }else if(4 == j){
            return "hs";
        }else if(5 == j){
            return "hd";
        }else if(6 == j){
            return "zj";
        }else if(7 == j){
            return "zb";
        }else if(8 == j){
            return "gg";
        }else if(9 == j){
            return "hj";
        }
		return "";
	}

	private void getTitle(HSSFSheet sheet, HSSFWorkbook excel, HSSFCellStyle style) {
		HSSFRow row1 = sheet.createRow(1);
		HSSFRow row2 = sheet.createRow(2);
		for(int i =0;i<10;i++){
			HSSFCell cell1 = row1.createCell(i);
			HSSFCell cell2 = row2.createCell(i);
        }
        String [] title1 = {"部门","公路 ","运管","港口","海事 ","航道","质监","建设","高管","合计"};
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
            }
		}
	}
	/*private void getTitle2(HSSFSheet sheet, String[] title, HSSFWorkbook excel, HSSFCellStyle style) {
		HSSFRow row = sheet.createRow(1);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(title[0]);
		cell.setCellStyle(style);
		int num=0;
	       for(int i=0;i<9;i++){           //循环9次，每一次都要跨单元格显示
	        //计算从那个单元格跨到那一格
	        int celln=0;
	        int celle=0;
	        if(i==0){
	         celln=0;
	         celle=1;
	        }else{
	         celln=(i*2);
	         celle=(i*2+1);
	        }
	        //单元格合并
	        //四个参数分别是：起始行，起始列，结束行，结束列
	        sheet.addMergedRegion(new   Region(0,(short)(celln+1),0,(short)(celle+1))); 
	        HSSFCell   cell   =   row.createCell((short) (celln+1) );   
	        cell.setCellValue("merging"+i); //跨单元格显示的数据
	        cell.setCellStyle(style);   //样式
	        //不跨单元格显示的数据，如：分两行，上一行分别两格为一格，下一行就为两格，“数量”，“金额”
	        HSSFCell   cell1   =   row2.createCell((short) celle );
	        HSSFCell   cell2   =   row2.createCell((short) (celle+1));
	        cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
	        cell1.setCellValue("数量"); 
	        cell1.setCellStyle(style);
	        cell2.setEncoding(HSSFCell.ENCODING_UTF_16);
	        cell2.setCellValue("金额"); 
	        cell2.setCellStyle(style);
	        num++;
	      }
	}*/

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
	

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
        
    }
}
