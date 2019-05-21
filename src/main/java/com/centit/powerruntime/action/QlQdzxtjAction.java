package com.centit.powerruntime.action;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.po.QlQdsxtj;
import com.centit.powerruntime.po.QlQdtj;
import com.centit.powerruntime.po.QlQdzxsxtj;
import com.centit.powerruntime.po.QlQdzxtj;

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

import com.centit.powerruntime.service.QlQdzxsxtjManager;
import com.centit.powerruntime.service.QlQdzxtjManager;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;


public class QlQdzxtjAction  extends BaseEntityExtremeAction<QlQdzxtj> implements ServletResponseAware {
	private static final Log log = LogFactory.getLog(QlQdzxtjAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private QlQdzxtjManager qlQdzxtjManager;
	private QlQdzxsxtjManager qlQdzxsxtjManager;
    private String unitsJson;
    private String parentunit;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    HttpServletResponse response;
    
    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
	public String getParentunit() {
        return parentunit;
    }

    public void setParentunit(String parentunit) {
        this.parentunit = parentunit;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    public void setQlQdzxsxtjManager(QlQdzxsxtjManager qlQdzxsxtjManager) {
        this.qlQdzxsxtjManager = qlQdzxsxtjManager;
    }

    public void setQlQdzxtjManager(QlQdzxtjManager basemgr)
	{
	    qlQdzxtjManager = basemgr;
		this.setBaseEntityManager(qlQdzxtjManager);
	}

	 /**
     * 权力清单统计
     * @return
     */
     public String qlqdzx() {
         String jtcode = request.getParameter("jtcode");
         FUserDetail fuser = ((FUserDetail) getLoginUser());
         String userCode = fuser.getUsercode();
         @SuppressWarnings("unchecked")
         Map<Object, Object> paramMap = request.getParameterMap();
         resetPageParam(paramMap);
         Map<String, Object> filterMap = convertSearchColumn(paramMap);
         if(!StringUtils.isBlank(jtcode)&&jtcode.length() > 4){
             filterMap.put("jtcode", jtcode.substring(0, jtcode.length()-4));
             List<QlQdzxsxtj> qlQdtjs = qlQdzxsxtjManager.listQlQdzxsxtj(filterMap);
             request.setAttribute("qlQdtjs", qlQdtjs);
             request.setAttribute("flag", request.getParameter("flag"));
         }else{
             List<QlQdzxtj> qlQdzxtjs = qlQdzxtjManager.listQlQdzxtj(filterMap);
             request.getSession().setAttribute("flag", null);
             request.setAttribute("qlQdtjs", qlQdzxtjs);
         }
        /* request.setAttribute("endTime", filterMap.get("endTime")==null?"":filterMap.get("endTime"));
         request.setAttribute("beginTime", filterMap.get("beginTime")==null?"":filterMap.get("beginTime"));*/
         request.setAttribute("method", "qlQdzxtj!qlqdzx");
         return "qlmlzx";
     }
	
     
     public String export() throws Exception {
         String startTime = request.getParameter("beginTime");
         String endTime = request.getParameter("endTime");
         String jtcode = request.getParameter("jtcode");
         export2(startTime,endTime ,jtcode, request,response);
         return null;
     }

     private void export2( String startTime, String endTime,String jtcode, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
         Map<String, Object> filterMap = new HashMap<String, Object>();
         filterMap.put("beginTime", startTime);
         filterMap.put("endTime", endTime);
         if(!StringUtils.isBlank(jtcode)&&jtcode.length() > 4){
             List<QlQdzxtj> qdzxtjs = new ArrayList<QlQdzxtj>();
             List<QlQdzxsxtj> qlQdzxsxtjs = qlQdzxsxtjManager.listQlQdzxsxtj(filterMap);
             for (QlQdzxsxtj qlQdzxsxtj : qlQdzxsxtjs) {
                 QlQdzxtj qlQdzxtj = new QlQdzxtj();
                 qlQdzxtj.copyNotNullProperty(qlQdzxsxtj);
                 qdzxtjs.add(qlQdzxtj);
            }
             insertExcel(sheet,qdzxtjs,dataStyle);
         }else{
             insertExcel(sheet,this.qlQdzxtjManager.listQlQdzxtj(filterMap),dataStyle);
         }
         //将以上缓存中的内容写到EXCEL文件中
         downLoadExcle(response, excel);
     }

     private void getFirstRow(HSSFSheet sheet, String startTime, String endTime, HSSFCellStyle timeStyle) {
         CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 4);
         sheet.addMergedRegion(region1); 
         HSSFRow row = sheet.createRow(0);
         Cell cell =  row.createCell(0);
         cell.setCellValue("\"行政权力清单统计表");
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
         String fileName = "行政权力清单统计.xls";
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
     private void insertExcel(HSSFSheet sheet, List<QlQdzxtj> qlqdzxList, HSSFCellStyle style) {
         List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
         for (QlQdzxtj qlQdzxtj : qlqdzxList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("orgname", qlQdzxtj.getOrgname());
            map.put("xzxk", qlQdzxtj.getXzxk());
            map.put("xzcf", qlQdzxtj.getXzcf());
            map.put("xzqz", qlQdzxtj.getXzqz());
            map.put("xzzs", qlQdzxtj.getXzzs());
            map.put("xzjf", qlQdzxtj.getXzjf());
            map.put("xzjl", qlQdzxtj.getXzjl());
            map.put("xzqr", qlQdzxtj.getXzqr());
            map.put("xzcj", qlQdzxtj.getXzcj());
            map.put("xzzy", qlQdzxtj.getXzzy());
            map.put("qt", qlQdzxtj.getQt());
            dataList.add(map);
         }
         
         for (int i = 0; i < dataList.size(); i++) {
             HSSFRow row = sheet.createRow(i + 2);
             for (int j = 0; j < 11; j++) {
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
             return "xzxk";
         }else if(2 == j){
             return "xzcf";
         }else if(3 == j){
             return "xzqz";
         }else if(4 == j){
             return "xzzs";
         }else if(5 == j){
             return "xzjf";
         }else if(6 == j){
             return "xzjl";
         }else if(7 == j){
             return "xzqr";
         }else if(8 == j){
             return "xzcj";
         }else if(9 == j){
             return "xzzy";
         }else if(10 == j){
             return "qt";
         }
         
         return "";
     }

     private void getTitle(HSSFSheet sheet, String[] title, HSSFWorkbook excel, HSSFCellStyle style) {
         HSSFRow row1 = sheet.createRow(1);
         for(int i =0;i<10;i++){
             HSSFCell cell1 = row1.createCell(i);
         }
         String [] title1 = {"部门","行政许可","行政处罚","行政强制","行政征收","行政给付","行政奖励","行政确认","行政裁决","行政征用","其他"};
         for(int i = 0;i<title1.length;i++){
             int fr=0,lr=0,fc=0,lc=0;
             if(i==0){
                 fr=1;lr=1;fc=0;lc=0;
                 HSSFCell cell = row1.createCell(0);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==1){
                 fr=1;lr=1;fc=1;lc=1;
                 HSSFCell cell = row1.createCell(1);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==2){
                 fr=1;lr=1;fc=2;lc=2;
                 HSSFCell cell = row1.createCell(2);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==3){
                 fr=1;lr=1;fc=3;lc=3;
                 HSSFCell cell = row1.createCell(3);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==4){
                 fr=1;lr=1;fc=4;lc=4;
                 HSSFCell cell = row1.createCell(4);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==5){
                 fr=1;lr=1;fc=5;lc=5;
                 HSSFCell cell = row1.createCell(5);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==6){
                 fr=1;lr=1;fc=6;lc=6;
                 HSSFCell cell = row1.createCell(6);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==7){
                 fr=1;lr=1;fc=7;lc=7;
                 HSSFCell cell = row1.createCell(7);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==8){
                 fr=1;lr=1;fc=8;lc=8;
                 HSSFCell cell = row1.createCell(8);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==9){
                 fr=1;lr=1;fc=9;lc=9;
                 HSSFCell cell = row1.createCell(9);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
             }else if(i==10){
                 fr=1;lr=1;fc=10;lc=10;
                 HSSFCell cell = row1.createCell(10);
                 cell.setCellValue(title1[i]);
                 cell.setCellStyle(style);
                 sheet.addMergedRegion(new CellRangeAddress(fr,lr,fc,lc));
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
         /*String [] title = {"部门","申报数量 ","5天内反馈","5天后反馈","未超过3天","超过3天","超过5天","受理","补正","不予受理"};*/
         String [] title = {"5天内反馈","5天后反馈","未超过3天","超过3天","超过5天","受理","补正","不予受理"};
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
