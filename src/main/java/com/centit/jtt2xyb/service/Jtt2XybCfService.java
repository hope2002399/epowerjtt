package com.centit.jtt2xyb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.Jtt2XybCf;
import com.centit.jtt2xyb.bo.SqlBean;

public interface Jtt2XybCfService {
	List<Jtt2XybCf> getList(List<SqlBean> sqlBeans,int pageNo,int pageSize);
	List<Jtt2XybCf> getListForScroll(List<SqlBean> sqlBeans);
	int getSumnum(List<SqlBean> sqlBeans);
	
	Jtt2XybCf getInfo(String wsh);
	
	String importExcelCF(List<Map<String, Object>> list, HttpServletResponse response,JiaoTongLog log);
	
	List<Object[]> getDataList(String startTime ,String endTime);
	
	List<Object[]> selectError(String startTime ,String endTime,String xzjg, String type);
    List<Object[]> getDataListSdbs(String startTime, String endTime);
	
}
