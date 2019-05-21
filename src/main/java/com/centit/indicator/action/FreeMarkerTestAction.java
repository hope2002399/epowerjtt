package com.centit.indicator.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import freemarker.template.TemplateException;


public class FreeMarkerTestAction {
	public String  test() throws IOException, TemplateException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath("/");
		
		String dataJson = request.getParameter("dataJson");
		if (dataJson == null)
			dataJson = ReadFile(path + "WEB-INF/classes/testData.json");
		return "compose";
	}
	
	public String preview() {
		
		return "preview";
	}
	
	public String ReadFile(String path){
	    File file = new File(path);
	    BufferedReader reader = null;
	    String laststr = "";
	    try {
	    	//System.out.println("以行为单位读取文件内容，一次读一整行：");
	    	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			reader = new BufferedReader(isr);
			String tempString = null;
			//int line = 1;
			//一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				laststr = laststr + tempString;
				//显示行号
				//System.out.println("line " + line + ": " + tempString);
				//line++;
			}
			reader.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally {
	    	if (reader != null) {
	    		try {
	    			reader.close();
	    		} catch (IOException e1) {
	    		}
	    	}
	    }
	    return laststr;
	}
}
