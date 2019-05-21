package com.centit.jtt2xyb.web;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
	public static String getDateString(Date date){
		 if(date!=null){
			 return sdf.format(date);
		 }
		 return "";
	}
}
