package com.centit.app.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ibm.icu.text.SimpleDateFormat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    
    public static List<String[]> readXLS(String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

        List<String[]> xlsList = new ArrayList<String[]>();
        
        String[] rowAry;
                
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }

            // 循环行Row
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                
                rowAry = new String[hssfRow.getLastCellNum()];
                
                // 循环列Cell
                for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
                    
                    HSSFCell hssfCell = hssfRow.getCell(cellNum);
                    if (hssfCell == null) {
                        continue;
                    }
                    rowAry[cellNum] = getValue(hssfCell);                    
                   
                }
                
                xlsList.add(rowAry);
                
            }
        }
        return xlsList;
    }
    
    public static List<String[]> readXLSX(String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        XSSFWorkbook  hssfWorkbook = new XSSFWorkbook (is);

        List<String[]> xlsList = new ArrayList<String[]>();
        
        String[] rowAry;
                
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }

            // 循环行Row
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                
                rowAry = new String[hssfRow.getLastCellNum()];
                
                // 循环列Cell
                for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
                    
                    XSSFCell hssfCell = hssfRow.getCell(cellNum);
                    if (hssfCell == null) {
                        continue;
                    }
                    rowAry[cellNum] = getValueXlsx(hssfCell);                    
                   
                }
                
                xlsList.add(rowAry);
                
            }
        }
        return xlsList;
    }

    @SuppressWarnings("static-access")
    public static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    
    @SuppressWarnings("static-access")
    public static String getValueXlsx(XSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    
    @SuppressWarnings("rawtypes")
	public static Map<String,List> getXlsObject(String[] reflectNames,List<String[]> reflectValues,Class objClass) throws Exception, Exception{
    	List<String> errorInfo = new ArrayList<String>();//报错信息
    	List<Object> objList=new ArrayList<Object>();
    	if(reflectValues!=null&&reflectValues.size()>0&&reflectNames!=null&&reflectNames.length>0){
        	for (int i = 0; i < reflectValues.size(); i++) {
    			Object obj=objClass.newInstance();
    			String[] values=reflectValues.get(i);
//    			if(values==null||values[0].length()<32)continue;
//    			if(values.length<2)break;//获取此行值数小于5算作不正规数据，直接被视为获取数据结束
    			if(values==null)continue;
    			boolean flag=false;
    			String flagStr="";
    			for (int j = 0; j < 10; j++) {
					if(values[j]==null){
						continue;
					}
					flag=true;
					flagStr+=values[j];
				}
    			if(!flag||flagStr.equals("")){
    				break;
    			}
    			if(values.length<10)break;//获取此行值数小于5算作不正规数据，直接被视为获取数据结束
    			for (int j = 0; j < values.length; j++) {
    				String errorStr="";
					if(j>=reflectNames.length)break;
					if(values[j]==null||"".equals(values[j].trim()))continue;
					try {
						String name=reflectNames[j];
						String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
						Field field = obj.getClass().getDeclaredField(name);
						Object o=null;
						if(field.getType().equals(String.class)){
							o=values[j].toString().trim();
						}else if(field.getType().equals(Double.class)){
							o=Double.valueOf(values[j].trim());
						}else if(field.getType().equals(Long.class)){
							String s=values[j].trim();
							if(s.indexOf(".")>0){
								s=s.substring(0,s.lastIndexOf("."));
							}
							o=Long.valueOf(s);
						}else if(field.getType().equals(Integer.class)){
							o=Integer.parseInt(values[j].trim());
						}else if(field.getType().equals(Date.class)){
							try {
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
								o=sdf.parse(values[j].trim());
							} catch (Exception e) {
								try {
									SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
									o=sdf.parse(values[j].trim());
								} catch (Exception e1) {
									errorStr+="第"+(i+6)+"行，第"+(j+1)+"列日期格式错误(yyyy-MM-dd 或 yyyy-MM)，请检验并按要求填入数据！\r\n ";
									System.out.println(errorStr);
									errorInfo.add(errorStr);
									continue;
								}
							}
						}
						Method m=obj.getClass().getDeclaredMethod(methodName, field.getType());
						m.invoke(obj,o);
					} catch (Exception e) {
						errorStr="第"+(i+6)+"行，第"+(j+1)+"列数据格式错误(请勿输入数据单位及特殊符号)，请检验并按要求填入数据！\r\n";
						errorInfo.add(errorStr);
						System.out.println(errorStr+"Get Reflect ZiDuan Error!");
						continue;
					} 
				}
    			objList.add(obj);
    		}
    	}
    	Map<String, List> resultMap=new HashMap<String, List>();
    	resultMap.put("objList", objList);
    	resultMap.put("errorList", errorInfo);
		return resultMap;
    }

}
