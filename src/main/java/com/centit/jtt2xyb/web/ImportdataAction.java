package com.centit.jtt2xyb.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.action.BaseAction;
import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.service.Jtt2XybCfService;
import com.centit.jtt2xyb.service.Jtt2XybXkService;
import com.centit.sys.security.FUserDetail;


public class ImportdataAction extends BaseAction implements ServletResponseAware{
    /**
     * 
     */
    private static final long serialVersionUID = 5313560179073360805L;
    //处罚字段
    public final static int CFFIELD = 24;
    //许可字段
    public final static int XKFIELD = 20;
    private Jtt2XybXkService jtt2XybXkService;
    private Jtt2XybCfService jtt2XybCfService;
    private File myfiles;
    private String myfilesFileName;
    private String myfilesContentType;
    private String fileType_takeIn;
    HttpServletResponse response;
    
    
    public String getFileType_takeIn() {
        return fileType_takeIn;
    }

    public void setFileType_takeIn(String fileType_takeIn) {
        this.fileType_takeIn = fileType_takeIn;
    }

    public String getMyfilesFileName() {
        return myfilesFileName;
    }

    public void setMyfilesFileName(String myfilesFileName) {
        this.myfilesFileName = myfilesFileName;
    }

    public String getMyfilesContentType() {
        return myfilesContentType;
    }

    public void setMyfilesContentType(String myfilesContentType) {
        this.myfilesContentType = myfilesContentType;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }


    public File getMyfiles() {
        return myfiles;
    }

    public void setMyfiles(File myfiles) {
        this.myfiles = myfiles;
    }

    public void setJtt2XybXkService(Jtt2XybXkService jtt2XybXkService) {
        this.jtt2XybXkService = jtt2XybXkService;
    }

    public void setJtt2XybCfService(Jtt2XybCfService jtt2XybCfService) {
        this.jtt2XybCfService = jtt2XybCfService;
    }

    public String execute() throws Exception {
        InputStream is = new FileInputStream(myfiles);
        String message = "";
        //获取文件类型
        String fileTpye = fileType_takeIn;
        //获取文件名
        String filename =   myfilesFileName;
        //获取文件大小
        int  fileSize = is.available();
        JiaoTongLog log = null;
        try {
            log = getLog(request,response, fileTpye, filename);
        } catch (Throwable e1) {
            e1.printStackTrace();
        }
        if(null == log){ //此状态 为session过期，需要重新登录
            return null;
        }else if(0 == fileSize){
            String msg = "error_msg_4# "+filename+" 文件是空的！";
            response.getWriter().write(msg);
            this.jtt2XybXkService.insert(getLog(log, 2, "此文件大小为0"));    //插入日志表
            return null;
        }
        String fileExt = filename.substring(filename.lastIndexOf(".") + 1); // 根据文件类型对文件操作
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        // xls
        if (fileExt.equals("xls")) {
            if ("XK".equals(fileTpye)) {
                 try {
                     message = dealwithXlsFileXK(
                            new HSSFWorkbook(new POIFSFileSystem(is))
                                    .getSheetAt(0), list, response,log);
                } catch (Exception e) {
                    getErrorMsg8(response, log, e);     //插入日志表
                }
            } else if ("CF".equals(fileTpye)) {
                 try {
                     message = dealwithXlsFileCF(
                            new HSSFWorkbook(new POIFSFileSystem(is))
                                    .getSheetAt(0), list,response,log);
                } catch (Exception e) {
                    getErrorMsg8(response, log, e); 
                }
            }
        } else {
        //xlsx
            if ("XK".equals(fileTpye)) {
                 try {
                     message = dealwithXlsxFileXk(
                             new XSSFWorkbook(is).getSheetAt(0), list, response, log);
                } catch (Exception e) {
                    System.out.println(e);
                    getErrorMsg8(response, log, e); 
                }
            } else {
                 try {
                     message = dealwithXlsxFileCf(
                            new XSSFWorkbook(is).getSheetAt(0), list, response,log);
                } catch (Exception e) {
                    getErrorMsg8(response, log, e); 
                }
            }
        }
        if(!"".equals(message)){
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.getOutputStream().write(message.getBytes("UTF-8"));
            response.getOutputStream().flush();
        }
        return null;
    }
    


    
    private String dealwithXlsxFileXk(XSSFSheet xssfSheet, List<Map<String, Object>> list, HttpServletResponse response,JiaoTongLog log) throws Exception {
            boolean trueOrFasle = false;
            int row = xssfSheet.getLastRowNum();
            if(0 == row){
                String msg = "";
                msg = "error_msg_5#  "+log.getFileName()+"包含0条数据！";
                response.getWriter().write(msg);
                this.jtt2XybXkService.insert(getLog(log, 2, log.getFileName()+"包含0条数据！"));
                return "";
            }
            XSSFRow xRow = xssfSheet.getRow(0);
            short s = xRow.getLastCellNum();
            boolean flag = checkFied(s, getFileType(log.getType()),response);// 判断字段列数 是否一致
            log.setDataNum(row);
            if(false == flag){
                String msg = "";
                msg = "error_msg_1";
                response.getWriter().write(msg);
                this.jtt2XybXkService.insert(getLog(log,2, "上传的文件不是指定的模板文件"));
                return "";
            }
            HSSFRow hsrow = null;
            Map<String,String> testExcelMap=new HashMap<String,String>();
            for (int rownum = 0; rownum < row; rownum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rownum);
                Map<String, Object> map = new HashMap<String, Object>();
                if (0 == rownum ) {
                    continue;
                } else if( "".equals(xssfRow.getCell(1).getStringCellValue()) ){
                    String str = "文书号";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if(  "".equals(xssfRow.getCell(2).getStringCellValue())){
                    String str = "项目名称";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if(   "".equals(xssfRow.getCell(4).getStringCellValue())){
                    String str = "审批类别";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if(   "".equals(xssfRow.getCell(5).getStringCellValue())){
                    String str = "审批内容";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if(   "".equals(xssfRow.getCell(6).getStringCellValue())){
                    String str = "行政相对人名称";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if("".equals(xssfRow.getCell(13).toString())||xssfRow.getCell(13).toString() == null){
                    String str = "决定日期";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if("".equals(xssfRow.getCell(14).toString())||xssfRow.getCell(14).toString() == null){
                    String str = "截止日期";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if("".equals(xssfRow.getCell(15).getStringCellValue()) ){   
                    String str = "许可机关";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                    //0.0
                }else if("".equals(xssfRow.getCell(16).toString())||xssfRow.getCell(16).toString() == null){   
                    String str = "当前状态";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                    //0.0
                }else if("".equals(xssfRow.getCell(17).toString())||xssfRow.getCell(17).toString() == null){   
                    String str = "地方编码";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                    //0.0
                }else if("".equals(xssfRow.getCell(18).toString())||xssfRow.getCell(18).toString() == null){   //判断空
                    String str = "数据更新时间戳";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else {
                    trueOrFasle = findCF(response, log, xssfRow.getCell(1).getStringCellValue(), testExcelMap);
                    if(trueOrFasle){
                        break;
                    }
                    mapMethodXk(hsrow, xssfRow, map);
                    list.add(map);
                }
            }
            if (trueOrFasle) {
                return "";
            }
            return this.jtt2XybXkService.importExcelXK(list,response,log);
    }

    private JiaoTongLog getLog(JiaoTongLog log,int isSuccess,String msg) {
        log.setId(""+System.currentTimeMillis());
        log.setDrjg(isSuccess);
        log.setErrormsg(msg);
        return log;
    }

    private String dealwithXlsxFileCf(XSSFSheet xssfSheet, List<Map<String, Object>> list, HttpServletResponse response,JiaoTongLog log) throws Exception {
        boolean trueOrfasle = false;
            int row = xssfSheet.getLastRowNum();
            if(0 == row){
                String msg = "";
                msg = "error_msg_5#  "+log.getFileName()+"包含0条数据！";
                response.getWriter().write(msg);
                this.jtt2XybXkService.insert(getLog(log, 2, log.getFileName()+"包含0条数据！"));
                return "";
            }
            XSSFRow xRow = xssfSheet.getRow(0);
            Map<String,String> testExcelMap=new HashMap<String,String>();
            short s = xRow.getLastCellNum();
            boolean flag = checkFied(s, getFileType(log.getType()),response);// 判断字段列数 是否一致
            log.setDataNum(row);
            if(false == flag){
                String msg = "";
                msg = "error_msg_1";
                response.getWriter().write(msg);
                this.jtt2XybXkService.insert(getLog(log, 2, "上传的文件不是指定的模板文件"));
                return "";
            }
            HSSFRow hsrow = null;
            for (int rownum = 0; rownum < row; rownum++) {
                Map<String, Object> map = new HashMap<String, Object>();
                XSSFRow xssfRow = xssfSheet.getRow(rownum);
                if (rownum == 0 ) {
                    continue;
                    //以下为必填字段检查
                }  else if( "".equals(xssfRow.getCell(0).getStringCellValue()) ){
                    String str = "文书号";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(xssfRow.getCell(1).getStringCellValue()) ){
                    String str = "处罚名称";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(xssfRow.getCell(3).getStringCellValue()) ){
                    String str = "处罚类别1";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(xssfRow.getCell(2).getStringCellValue()) ){
                    String str = "处罚事由";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(xssfRow.getCell(4).getStringCellValue()) ){
                    String str = "处罚依据";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(xssfRow.getCell(5).getStringCellValue()) ){
                    String str = "行政相对人名称";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if(null == xssfRow.getCell(12) ){
                    String str = "处罚结果";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if(null == judge(xssfRow.getCell(13)) ){
                    String str = "处罚决定日期";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(xssfRow.getCell(15).getStringCellValue()) ){
                    String str = "处罚机关";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if(null == xssfRow.getCell(16) ){
                    String str = "当前状态";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if(null == xssfRow.getCell(17) ){
                    String str = "地方编码";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if(null == judge(xssfRow.getCell(18))) {
                    String str = "数据更新时间戳";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else {
                    findCF(response, log, xssfRow.getCell(0).getStringCellValue(), testExcelMap);
                    mapMethodCf(hsrow, xssfRow, map);
                    list.add(map);
                }
            }
            if (trueOrfasle) {
                return "";
            }
            return this.jtt2XybCfService.importExcelCF(list,response,log);
            
    }

    private void insertLogAndWriteMsg(HttpServletResponse response,
            JiaoTongLog log, int rownum,String str) throws IOException {
        String msg;
        msg = "error_msg_3#请检查 "+log.getFileName()+" 中,第   "+rownum+"  排的"+str+"是否未填！";
        response.getWriter().write(msg);
        this.jtt2XybXkService.insert(getLog(log, 2, "请检查 "+log.getFileName()+" 中,第   "+(rownum+1)+"  排的"+str+"是否未填！"));
    }

    private String dealwithXlsFileXK(HSSFSheet sheetAt, List<Map<String, Object>> list,
                            HttpServletResponse response,JiaoTongLog log) throws Exception {
        boolean trueOrfasle = false;
            int rowNum = sheetAt.getLastRowNum();
            if(0 == rowNum){
                String msg = "";
                msg = "error_msg_5#  "+log.getFileName()+"包含0条数据！";
                response.getWriter().write(msg);
                this.jtt2XybXkService.insert(getLog(log, 2, log.getFileName()+"包含0条数据！"));
                return "";
            }
            HSSFRow row = sheetAt.getRow(0);
            short s = row.getLastCellNum(); // 获取excel 一共有多少字段
            boolean flag = checkFied(s, getFileType(log.getType()),response);// 判断字段列数 是否一致
            log.setDataNum(rowNum);
            if(false == flag){
                String msg = "";
                msg = "error_msg_1";
                response.getWriter().write(msg);
                this.jtt2XybXkService.insert(getLog(log, 2, "上传的文件不是指定的模板文件"));
                return "";
            }
            XSSFRow xssfRow = null;
            Map<String,String> testExcelMap=new HashMap<String,String>();
            for (int rownum = 0; rownum < rowNum; rownum++) {
                Map<String, Object> map = new HashMap<String, Object>();
                HSSFRow hsrow = sheetAt.getRow(rownum);
                if (rownum == 0 ) {
                    continue;
                }   else if( "".equals(hsrow.getCell(0).getStringCellValue()) ){
                    String str = "文书号";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                    //判断日期是否为空
                }else if(   "".equals(hsrow.getCell(1).getStringCellValue())){
                    String str = "项目名称";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if(   "".equals(hsrow.getCell(3).getStringCellValue())){
                    String str = "审批类别";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if(   "".equals(hsrow.getCell(4).getStringCellValue())){
                    String str = "审批内容";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if(   "".equals(hsrow.getCell(5).getStringCellValue())){
                    String str = "行政相对人名称";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if(null == judge(hsrow.getCell(12))){
                    hsrow.getCell(12).getCellType();
                    String str = "决定日期";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else if("".equals(hsrow.getCell(14).getStringCellValue()) ){   
                    String str = "许可机关";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                    //0.0
                }else if( null == judge(hsrow.getCell(17))){   
                    String str = "数据更新时间戳";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";  
                }else {
                    trueOrfasle= findCF(response, log, hsrow.getCell(0).getStringCellValue(), testExcelMap);
                    if(trueOrfasle){
                        break;
                    }
                    mapMethodXk(hsrow, xssfRow, map);
                    list.add(map);
                }
            }
            if (trueOrfasle) {
                return "";
            }
            return this.jtt2XybXkService.importExcelXK(list,response,log);
        } 
    
    private String judge(XSSFCell cellf){
        int celltype = cellf.getCellType();
         String result = new String();  
        switch (celltype) {
        case HSSFCell.CELL_TYPE_NUMERIC:
              if (HSSFDateUtil.isCellDateFormatted(cellf)) {
               SimpleDateFormat sdf = null;  
               if (cellf.getCellStyle().getDataFormat() == HSSFDataFormat  
                       .getBuiltinFormat("h:mm")) {  
                   sdf = new SimpleDateFormat("HH:mm");  
               } else {// 日期  
                   sdf = new SimpleDateFormat("yyyy-MM-dd");  
               }  
               Date date = cellf.getDateCellValue();  
               result = sdf.format(date);  

         } else if (cellf.getCellStyle().getDataFormat() == 58) {  
             // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
             double value = cellf.getNumericCellValue();  
             Date date = org.apache.poi.ss.usermodel.DateUtil  
                     .getJavaDate(value);  
             result = sdf.format(date);  
         } else {  
             double value = cellf.getNumericCellValue();  
             CellStyle style = cellf.getCellStyle();  
             DecimalFormat format = new DecimalFormat();  
             String temp = style.getDataFormatString();  
             // 单元格设置成常规  
             if (temp.equals("General")) {  
                 format.applyPattern("#");  
             }  
             result = format.format(value);  
         }  
         break;  
     case HSSFCell.CELL_TYPE_STRING:// String类型  
         result = cellf.getRichStringCellValue().toString();  
         break;  
     case HSSFCell.CELL_TYPE_BLANK:  
         result = "";  
     default:  
         result = "";  
         break;  
     }  
     return result;  
        
    }
    private String judge(HSSFCell cell){
        int celltype = cell.getCellType();
         String result = new String();  
        switch (celltype) {
        case HSSFCell.CELL_TYPE_NUMERIC:
              if (HSSFDateUtil.isCellDateFormatted(cell)) {
               SimpleDateFormat sdf = null;  
               if (cell.getCellStyle().getDataFormat() == HSSFDataFormat  
                       .getBuiltinFormat("h:mm")) {  
                   sdf = new SimpleDateFormat("HH:mm");  
               } else {// 日期  
                   sdf = new SimpleDateFormat("yyyy-MM-dd");  
               }  
               Date date = cell.getDateCellValue();  
               result = sdf.format(date);  

         } else if (cell.getCellStyle().getDataFormat() == 58) {  
             // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
             double value = cell.getNumericCellValue();  
             Date date = org.apache.poi.ss.usermodel.DateUtil  
                     .getJavaDate(value);  
             result = sdf.format(date);  
         } else {  
             double value = cell.getNumericCellValue();  
             CellStyle style = cell.getCellStyle();  
             DecimalFormat format = new DecimalFormat();  
             String temp = style.getDataFormatString();  
             // 单元格设置成常规  
             if (temp.equals("General")) {  
                 format.applyPattern("#");  
             }  
             result = format.format(value);  
         }  
         break;  
     case HSSFCell.CELL_TYPE_STRING:// String类型  
         result = cell.getRichStringCellValue().toString();  
         break;  
     case HSSFCell.CELL_TYPE_BLANK:  
         result = "";  
     default:  
         result = "";  
         break;  
     }  
     return result;  
        
    }
    
    private boolean findCF(HttpServletResponse response, JiaoTongLog log,
            String ss, Map<String, String> testExcelMap) throws IOException {
        if(!testExcelMap.containsKey(ss)){
            testExcelMap.put(ss, "");
            return false;
        }else{
            String msg;
             msg = "error_msg_6#  "+ss+"  该文书号在文件中存在一个或多个，请自行处理重复数据！";
             response.getWriter().write(msg);
            this.jtt2XybXkService.insert(getLog(log, 2, msg));
            return true;
        }
    }

    private String  dealwithXlsFileCF(HSSFSheet sheetAt, List<Map<String, Object>> list, HttpServletResponse response,JiaoTongLog log) throws Exception {
            boolean trueOrfasle = false;
            int rowNum = sheetAt.getLastRowNum();
            if(0 == rowNum){
                String msg = "";
                msg = "error_msg_5#  "+log.getFileName()+"包含0条数据！";
                response.getWriter().write(msg);
                this.jtt2XybXkService.insert(getLog(log, 2, log.getFileName()+"包含0条数据！"));
                return "";
            }
            HSSFRow row = sheetAt.getRow(0);
            short s = row.getLastCellNum(); // 获取excel 一共有多少字段
            boolean flag = checkFied(s, getFileType(log.getType()),response);// 判断字段列数 是否一致
            log.setDataNum(rowNum);
            if(false == flag){
                String msg = "";
                msg = "error_msg_1";
                response.getWriter().write(msg);
                this.jtt2XybXkService.insert(getLog(log, 2, "上传的文件不是指定的模板文件"));
                return "";
            }
            XSSFRow xssfRow = null;
            Map<String,String> testExcelMap=new HashMap<String,String>();
            for (int rownum = 0; rownum < rowNum; rownum++) {
                Map<String, Object> map = new HashMap<String, Object>();
                HSSFRow hsrow = sheetAt.getRow(rownum);
                if (rownum == 0  ) {
                    continue;
                }else if("".equals(hsrow.getCell(0).getStringCellValue()) ){
                    String str = "文书号";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(hsrow.getCell(1).getStringCellValue()) ){
                    String str = "处罚名称";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(hsrow.getCell(3).getStringCellValue()) ){
                    String str = "处罚类别1";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(hsrow.getCell(2).getStringCellValue()) ){
                    String str = "处罚事由";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(hsrow.getCell(4).getStringCellValue()) ){
                    String str = "处罚依据";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(hsrow.getCell(5).getStringCellValue()) ){
                    String str = "行政相对人名称";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if(null == hsrow.getCell(12) ){
                    String str = "处罚结果";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if(null == judge(hsrow.getCell(13))){
                    String str = "处罚决定日期";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(hsrow.getCell(15).getStringCellValue()) ){
                    String str = "处罚机关";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(hsrow.getCell(16).getStringCellValue()) ){
                    String str = "当前状态";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if("".equals(hsrow.getCell(17).getStringCellValue()) ){
                    String str = "地方编码";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else if(null == judge(hsrow.getCell(18))){
                    String str = "数据更新时间戳";
                    insertLogAndWriteMsg(response, log, rownum,str);
                    return "";
                }else {
                    findCF(response, log, hsrow.getCell(0).getStringCellValue(), testExcelMap);
                    mapMethodCf(hsrow, xssfRow, map);// 保存数据
                    
                    list.add(map);// 添加到map
                }
            }
            if (trueOrfasle) {
                return "";
            }
            return this.jtt2XybCfService.importExcelCF(list,response,log);
    }

    
    
    private void mapMethodCf(HSSFRow hsrow, XSSFRow xsrow, Map<String, Object> map) {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
          Cell cell = null;
        if (null == xsrow) {
            map.put("CF_WSH", "" + hsrow.getCell(0));
            if (null != hsrow.getCell(1)) {
                map.put("CF_CFMC", "" + hsrow.getCell(1));
            } else {
                map.put("CF_CFMC", "");
            }
            if (null != hsrow.getCell(2)) {
                map.put("CF_SY", "" + hsrow.getCell(2));
            } else {
                map.put("CF_SY", "");
            }
            if (null != hsrow.getCell(3)) {
                map.put("CF_CFLB1", "" + hsrow.getCell(3));
            } else {
                map.put("CF_CFLB1", "");
            }
            if (null != hsrow.getCell(4)) {
                map.put("CF_YJ", "" + hsrow.getCell(4));
            } else {
                map.put("CF_YJ", "");
            }
            if (null != hsrow.getCell(5)) {
                map.put("CF_XDR", "" + hsrow.getCell(5));
            } else {
                map.put("CF_XDR", "");
            }
            if (null != hsrow.getCell(6)) {
                map.put("CF_XDR_SHXYM", "" + hsrow.getCell(6));
            } else {
                map.put("CF_XDR_SHXYM", "");
            }
            if (null != hsrow.getCell(7)) {
                map.put("CF_XDR_ZDM", "" + hsrow.getCell(7));
            } else {
                map.put("CF_XDR_ZDM", "");
            }
            if (null != hsrow.getCell(8)) {
                map.put("CF_XDR_GSDJ", "" + hsrow.getCell(8));
            } else {
                map.put("CF_XDR_GSDJ", "");
            }
            if (null != hsrow.getCell(9)) {
                map.put("CF_XDR_SWDJ", "" + hsrow.getCell(9));
            } else {
                map.put("CF_XDR_SWDJ", "");
            }
            if (null != hsrow.getCell(10)) {
                map.put("CF_XDR_SFZ", "" + hsrow.getCell(10));
            } else {
                map.put("CF_XDR_SFZ", "");
            }
            if (null != hsrow.getCell(11)) {
                map.put("CF_FR", "" + hsrow.getCell(11));
            } else {
                map.put("CF_FR", "");
            }
            if (null != hsrow.getCell(12)) {
                map.put("CF_JG", "" + hsrow.getCell(12));
            } else {
                map.put("CF_JG", "");
            }
            if (null != hsrow.getCell(13)) {
                 cell = hsrow.getCell(13);
                map.put("CF_JDRQ", sdf.format(getDate(sdf, cell)));
            } else {
                map.put("CF_JDRQ", "");
            }
            if (null != hsrow.getCell(14)) {
                 cell = hsrow.getCell(14);
                map.put("CF_JZQ", "" + hsrow.getCell(14));
            } else {
                map.put("CF_JZQ", "");
            }
            if (null != hsrow.getCell(15)) {
                map.put("CF_XZJG", "" + hsrow.getCell(15).toString().trim());
            } else {
                map.put("CF_XZJG", "");
            }
            if (null != hsrow.getCell(16)) {
                
                map.put("CF_ZT", "" + hsrow.getCell(16).toString().trim());
            } else {
                map.put("CF_ZT", "");
            }
            if (null != hsrow.getCell(17)) {
                map.put("DFBM", "" + hsrow.getCell(17).toString().trim());
            } else {
                map.put("DFBM", "");
            }
            if (null != hsrow.getCell(18)) {
                 cell = hsrow.getCell(18);
                map.put("SJC", sdf.format(getDate(sdf, cell)));
            } else {
                map.put("SJC", "");
            }
            if (null != hsrow.getCell(19)) {
                map.put("BZ", "" + hsrow.getCell(19));
            } else {
                map.put("BZ", "");
            }
            if (null != hsrow.getCell(20)) {
                map.put("CF_BM", "" + hsrow.getCell(20));
            } else {
                map.put("CF_BM", "");
            }
            if (null != hsrow.getCell(21) && hsrow.getCell(21).getCellType()== Cell.CELL_TYPE_NUMERIC) {
                long longVal = Math.round(hsrow.getCell(21).getNumericCellValue());
                map.put("CF_SYFW", "" + longVal);
            } else {
                map.put("CF_SYFW", "");
            }
            if (null != hsrow.getCell(22)) {
                map.put("CF_SXYZCD", "" + hsrow.getCell(22));
            } else {
                map.put("CF_SXYZCD", "");
            }
            if (null != hsrow.getCell(23)) {
                 cell = hsrow.getCell(23);
                map.put("CF_GSJZQ", sdf.format(getDate(sdf, cell)));
            } else {
                map.put("CF_GSJZQ", "");
            }
        } else if (null == hsrow) {
            map.put("CF_WSH", "" + xsrow.getCell(0));
            if (null != xsrow.getCell(1)) {
                map.put("CF_CFMC", "" + xsrow.getCell(1));
            } else {
                map.put("CF_CFMC", "");
            }
            if (null != xsrow.getCell(2)) {
                map.put("CF_SY", "" + xsrow.getCell(2));
            } else {
                map.put("CF_SY", "");
            }
            if (null != xsrow.getCell(3)) {
                map.put("CF_CFLB1", "" + xsrow.getCell(3));
            } else {
                map.put("CF_CFLB1", "");
            }
            if (null != xsrow.getCell(4)) {
                map.put("CF_YJ", "" + xsrow.getCell(4));
            } else {
                map.put("CF_YJ", "");
            }
            if (null != xsrow.getCell(5)) {
                map.put("CF_XDR", "" + xsrow.getCell(5));
            } else {
                map.put("CF_XDR", "");
            }
            if (null != xsrow.getCell(6)) {
                map.put("CF_XDR_SHXYM", "" + xsrow.getCell(6));
            } else {
                map.put("CF_XDR_SHXYM", "");
            }
            if (null != xsrow.getCell(7)) {
                map.put("CF_XDR_ZDM", "" + xsrow.getCell(7));
            } else {
                map.put("CF_XDR_ZDM", "");
            }
            if (null != xsrow.getCell(8)) {
                map.put("CF_XDR_GSDJ", "" + xsrow.getCell(8));
            } else {
                map.put("CF_XDR_GSDJ", "");
            }
            if (null != xsrow.getCell(9)) {
                map.put("CF_XDR_SWDJ", "" + xsrow.getCell(9));
            } else {
                map.put("CF_XDR_SWDJ", "");
            }
            if (null != xsrow.getCell(10)) {
                map.put("CF_XDR_SFZ", "" + xsrow.getCell(10));
            } else {
                map.put("CF_XDR_SFZ", "");
            }
            if (null != xsrow.getCell(11)) {
                map.put("CF_FR", "" + xsrow.getCell(11));
            } else {
                map.put("CF_FR", "");
            }
            if (null != xsrow.getCell(12)) {
                map.put("CF_JG", "" + xsrow.getCell(12));
            } else {
                map.put("CF_JG", "");
            }
            if (null != xsrow.getCell(13)) {
                 cell = xsrow.getCell(13);
                map.put("CF_JDRQ", sdf.format(getDate(sdf, cell)));
            } else {
                map.put("CF_JDRQ", "");
            }
            if (null != xsrow.getCell(14)) {
                cell = xsrow.getCell(14);
                map.put("CF_JZQ", sdf.format(getDate(sdf, cell)));
            } else {
                map.put("CF_JZQ", "");
            }
            if (null != xsrow.getCell(15)) {
                map.put("CF_XZJG", "" + xsrow.getCell(15).toString().trim());
            } else {
                map.put("CF_XZJG", "");
            }
            if (null != xsrow.getCell(16)&& xsrow.getCell(16).getCellType()== Cell.CELL_TYPE_NUMERIC) {
                long longVal = Math.round(xsrow.getCell(16).getNumericCellValue());
                map.put("CF_ZT", "" + longVal);
            } else {
                map.put("CF_ZT", "");
            }
            if (null != xsrow.getCell(17)&& xsrow.getCell(17).getCellType()== Cell.CELL_TYPE_NUMERIC) {
                long longVal = Math.round(xsrow.getCell(17).getNumericCellValue());
                map.put("DFBM", "" + longVal);
            } else {
                map.put("DFBM", "");
            }
            if (null != xsrow.getCell(18)) {
                 cell = xsrow.getCell(18);
                map.put("SJC", sdf.format(getDate(sdf, cell)));
            } else {
                map.put("SJC", "");
            }
            if (null != xsrow.getCell(19)) {
                map.put("BZ", "" + xsrow.getCell(19));
            } else {
                map.put("BZ", "");
            }
            if (null != xsrow.getCell(20)) {
                map.put("CF_BM", "" + xsrow.getCell(20));
            } else {
                map.put("CF_BM", "");
            }
            if (null != xsrow.getCell(21) && xsrow.getCell(21).getCellType()== Cell.CELL_TYPE_NUMERIC) {
                long longVal = Math.round(xsrow.getCell(21).getNumericCellValue());
                map.put("CF_SYFW", "" + longVal);
            } else {
                map.put("CF_SYFW", "");
            }
            if (null != xsrow.getCell(22)) {
                map.put("CF_SXYZCD", "" + xsrow.getCell(22));
            } else {
                map.put("CF_SXYZCD", "");
            }
            if (null != xsrow.getCell(23)) {
                 cell = xsrow.getCell(23);
                map.put("CF_GSJZQ", sdf.format(getDate(sdf, cell)));
            } else {
                map.put("CF_GSJZQ", "");
            }
        }
        map.put("DATASOURCE", "2");

    }

    private void mapMethodXk(HSSFRow hsrow, XSSFRow xssfRow, Map<String, Object> map) {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
          Cell cell = null;
        if (null == xssfRow) {
            // 主键不判断
            map.put("XK_WSH", "" + hsrow.getCell(0));
            map.put("XK_XMMC", "" + hsrow.getCell(1));
            if (null != hsrow.getCell(3)) {
                map.put("XK_SPLB", "" + hsrow.getCell(3));
            } else {
                map.put("XK_SPLB", "");
            }
            if (null != hsrow.getCell(4)) {
                map.put("XK_NR", "" + hsrow.getCell(4));
            } else {
                map.put("XK_NR", "");
            }
            if (null != hsrow.getCell(5)) {
                map.put("XK_XDR", "" + hsrow.getCell(5));
            } else {
                map.put("XK_XDR", "");
            }
            if (null != hsrow.getCell(6)) {
                map.put("XK_XDR_SHXYM", "" + hsrow.getCell(6));
            } else {
                map.put("XK_XDR_SHXYM", "");
            }
            if (null != hsrow.getCell(7)) {
                map.put("XK_XDR_ZDM", "" + hsrow.getCell(7));
            } else {
                map.put("XK_XDR_ZDM", "");
            }
            if (null != hsrow.getCell(8)) {
                map.put("XK_XDR_GSDJ", "" + hsrow.getCell(8));
            } else {
                map.put("XK_XDR_GSDJ", "");
            }
            if (null != hsrow.getCell(9)) {
                map.put("XK_XDR_SWDJ", "" + hsrow.getCell(9));
            } else {
                map.put("XK_XDR_SWDJ", "");
            }
            if (null != hsrow.getCell(10)) {
                map.put("XK_XDR_SFZ", "" + hsrow.getCell(10));
            } else {
                map.put("XK_XDR_SFZ", "");
            }
            if (null != hsrow.getCell(11)) {
                map.put("XK_FR", "" + hsrow.getCell(11));
            } else {
                map.put("XK_FR", "");
            }
            if (null != hsrow.getCell(12)) {
                 cell = hsrow.getCell(12);
                map.put("XK_JDRQ", sdf.format(getDate(sdf,cell)));
            } else {
                map.put("XK_JDRQ", "");
            }
            if (null != hsrow.getCell(13)&&  hsrow.getCell(13).getCellType() != HSSFCell.CELL_TYPE_BLANK ) {
                 cell = hsrow.getCell(13);
                map.put("XK_JZQ", sdf.format(getDate(sdf,cell)));
            } else {
                map.put("XK_JZQ", "");
            }
            if (null != hsrow.getCell(14)) {
                map.put("XK_XZJG", "" + hsrow.getCell(14).toString().trim());
            } else {
                map.put("XK_XZJG", "");
            }
            if (null != hsrow.getCell(15)&& hsrow.getCell(15).getCellType()== Cell.CELL_TYPE_NUMERIC) {
                long longVal = Math.round(hsrow.getCell(15).getNumericCellValue());  
                map.put("XK_ZT", "" +longVal);
            } else {
                map.put("XK_ZT", "");
            }
            if (null != hsrow.getCell(16)&& hsrow.getCell(16).getCellType()== Cell.CELL_TYPE_NUMERIC) {
                long longVal = Math.round(hsrow.getCell(16).getNumericCellValue());
                map.put("DFBM", "" + longVal);
            } else {
                map.put("DFBM", "");
            }
            if (null != hsrow.getCell(17)) {
                 cell = hsrow.getCell(17);
                map.put("SJC", sdf.format(getDate(sdf,cell)));
            } else {
                map.put("SJC", "");
            }
            if (null != hsrow.getCell(18)) {
                map.put("BZ", "" + hsrow.getCell(18));
            } else {
                map.put("BZ", "");
            }
            if (null != hsrow.getCell(2)) {
                map.put("XK_BM", "" + hsrow.getCell(2));
            } else {
                map.put("XK_BM", "");
            }
            if (null != hsrow.getCell(19) && hsrow.getCell(19).getCellType()== Cell.CELL_TYPE_NUMERIC) {
                long longVal = Math.round(hsrow.getCell(19).getNumericCellValue());
                map.put("XK_SYFW", "" + longVal);
            } else {
                map.put("XK_SYFW", "");
            }
        } else if (null == hsrow) {
            // 主键不判断
            map.put("XK_WSH", "" + xssfRow.getCell(1));
            map.put("XK_XMMC", "" + xssfRow.getCell(2));
            if (null != xssfRow.getCell(4)) {
                map.put("XK_SPLB", "" + xssfRow.getCell(4));
            } else {
                map.put("XK_SPLB", "");
            }
            if (null != xssfRow.getCell(5)) {
                map.put("XK_NR", "" + xssfRow.getCell(5));
            } else {
                map.put("XK_NR", "");
            }
            if (null != xssfRow.getCell(6)) {
                map.put("XK_XDR", "" + xssfRow.getCell(6));
            } else {
                map.put("XK_XDR", "");
            }
            if (null != xssfRow.getCell(7)) {
                map.put("XK_XDR_SHXYM", "" + xssfRow.getCell(7));
            } else {
                map.put("XK_XDR_SHXYM", "");
            }
            if (null != xssfRow.getCell(8)) {
                map.put("XK_XDR_ZDM", "" + xssfRow.getCell(8));
            } else {
                map.put("XK_XDR_ZDM", "");
            }
            if (null != xssfRow.getCell(9)) {
                map.put("XK_XDR_GSDJ", "" + xssfRow.getCell(9));
            } else {
                map.put("XK_XDR_GSDJ", "");
            }
            if (null != xssfRow.getCell(10)) {
                map.put("XK_XDR_SWDJ", "" + xssfRow.getCell(10));
            } else {
                map.put("XK_XDR_SWDJ", "");
            }
            if (null != xssfRow.getCell(11)) {
                map.put("XK_XDR_SFZ", "" + xssfRow.getCell(11));
            } else {
                map.put("XK_XDR_SFZ", "");
            }
            if (null != xssfRow.getCell(12)) {
                map.put("XK_FR", "" + xssfRow.getCell(12));
            } else {
                map.put("XK_FR", "");
            }
            if (! "".equals(xssfRow.getCell(13).toString())&&xssfRow.getCell(13).toString() != null) {
                 cell = xssfRow.getCell(13);
                map.put("XK_JDRQ", sdf.format(getDate(sdf,cell)));
            } else {
                map.put("XK_JDRQ", "");
            }
            if (! "".equals(xssfRow.getCell(14).toString())&&xssfRow.getCell(14).toString() != null) {
                 cell = xssfRow.getCell(14);
                map.put("XK_JZQ", sdf.format(getDate(sdf,cell)));
            } else {
                map.put("XK_JZQ", "");
            }
            if (null != xssfRow.getCell(15)) {
                map.put("XK_XZJG", "" + xssfRow.getCell(15).toString().trim());
            } else {
                map.put("XK_XZJG", "");
            }
            if (null != xssfRow.getCell(16) && xssfRow.getCell(16).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                long longVal = Math.round(xssfRow.getCell(16).getNumericCellValue());  
                map.put("XK_ZT", "" + longVal);
            } else {
                map.put("XK_ZT", "");
            }
            if (null != xssfRow.getCell(17) &&xssfRow.getCell(17).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                  long longVal = Math.round(xssfRow.getCell(17).getNumericCellValue());
                map.put("DFBM", "" +longVal);
            } else {
                map.put("DFBM", "");
            }
            if (! "".equals(xssfRow.getCell(18).toString())&&xssfRow.getCell(18).toString() != null) {
                    cell = xssfRow.getCell(18);
                    map.put("SJC", sdf.format(getDate(sdf,cell)));
            } else {
                map.put("SJC", "");
            }
            if (null != xssfRow.getCell(19)) {
                map.put("BZ", "" + xssfRow.getCell(19));
            } else {
                map.put("BZ", "");
            }
            if (null != xssfRow.getCell(3)) {
                map.put("XK_BM", "" + xssfRow.getCell(3));
            } else {
                map.put("XK_BM", "");
            }
            if (null != xssfRow.getCell(20) && xssfRow.getCell(20).getCellType()== Cell.CELL_TYPE_NUMERIC) {
                long longVal = Math.round(xssfRow.getCell(20).getNumericCellValue());
                map.put("XK_SYFW", "" + longVal);
            } else {
                map.put("XK_SYFW", "");
            }
        }
        map.put("DATASOURCE", "2");
    }

    private Date getDate(SimpleDateFormat sdf, Cell cell)  {
                // 如果单元格为空，返回null
                    // 判断单元格类型
                    switch (cell.getCellType()) { 
                    // 数字类型
                    case HSSFCell.CELL_TYPE_NUMERIC:  
                        // 处理日期格式、时间格式
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {  
                        if (cell.getCellStyle().getDataFormat() == HSSFDataFormat  
                                .getBuiltinFormat("h:mm")) {  
                            sdf = new SimpleDateFormat("HH:mm");  
                        } else {// 日期  
                            sdf = new SimpleDateFormat("yyyy-MM-dd");  
                        }  
                        Date date = cell.getDateCellValue();  
                       return date;  
                    } else if (cell.getCellStyle().getDataFormat() == 58) {  
                        // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
                        double value = cell.getNumericCellValue();  
                        Date date = org.apache.poi.ss.usermodel.DateUtil  
                                .getJavaDate(value);  
                        return date;  
                    }
                        break;  
                    case HSSFCell.CELL_TYPE_STRING:// String类型  
                        try {
                            String s = cell.getStringCellValue().replace(".", "-");
                            return sdf.parse(s);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                  
            }
             return null;
    }
    
    private void getErrorMsg8(HttpServletResponse response, JiaoTongLog log,
            Exception e) throws Exception {
        String errorMsg = "error_msg_8# "+e.getCause();
        response.getWriter().write(errorMsg);
        this.jtt2XybXkService.insert(getLog(log, 2, errorMsg));
    }

    private JiaoTongLog getLog(HttpServletRequest request,HttpServletResponse res, String fileTpye,
            String filename) throws Throwable {
        JiaoTongLog log = new JiaoTongLog();
        FUserDetail user = ((FUserDetail) getLoginUser());
        try {
            String userId = user.getUsercode();
            log.setUserid(userId);
        } catch (NullPointerException e) {
                res.getWriter().write("error_msg_7# 操作超时，请重新登录!");
                return null;
        }
        log.setIp(getIp(request));
        log.setFileName(filename);
        log.setType(getType(fileTpye));
        return log;
    }


    private String getIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for"); 
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) { 
          ipAddress = request.getHeader("Proxy-Client-IP"); 
        } 
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) { 
          ipAddress = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) { 
          ipAddress = request.getHeader("HTTP_CLIENT_IP"); 
        } 
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) { 
          ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR"); 
        } 
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) { 
          ipAddress = request.getRemoteAddr(); 
        } 
        return ipAddress; 
    }

    private String getType(String fileTpye) {
        if("XK".equals(fileTpye)){
            fileTpye = "许可";
        }else{
            fileTpye = "处罚";
        }
        return fileTpye;
    }
    
    private String getFileType(String type){
        if("许可".equals(type)){
            type = "XK";
        }else if("处罚".equals(type)){
            type = "CF";
        }
        return type;
    }

    
    // 检查字段是否一致
    private boolean checkFied(short s, String fileTpye, HttpServletResponse response) {
        if ("XK".equals(fileTpye)) { // 许可一共20个字段
            s = (short)((int)s-1);//s第一个是序号，不是字段，所以减去1；
            if (s == XKFIELD) {
                return true;
            }
        } else if ("CF".equals(fileTpye)) {
            if (s ==  CFFIELD) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

}
