package com.centit.jtt2xyb.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simpe {
	public static void main (String []ags) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = "09-十一月-2016";
		 Date date = sdf.parse(s);
		 System.out.println(date);
	}
}
