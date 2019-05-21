package com.centit.jtt2xyb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.Jtt2XybXk;
import com.centit.jtt2xyb.bo.SqlBean;

public interface Jtt2XybXkService {
	List<Jtt2XybXk> getList(List<SqlBean> sqlBeans,int pageNo,int pageSize);
	List<Jtt2XybXk> getListForScroll(List<SqlBean> sqlBeans);
	List<Jtt2XybXk> getListForScroll(List<SqlBean> sqlBeans,int pageNo,int pageSize);
	int getSumnum(List<SqlBean> sqlBeans);
	
	Jtt2XybXk getInfo(String wsh);
	
	String importExcelXK(List<Map<String, Object>> list, HttpServletResponse response,JiaoTongLog log);
	
	void insert(JiaoTongLog log);
	
	
}
