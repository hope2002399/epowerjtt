package com.centit.jtt2xyb.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.Jtt2XybXk;
import com.centit.jtt2xyb.bo.SqlBean;
import com.centit.jtt2xyb.dao.Jtt2XybXkDao;
import com.centit.jtt2xyb.service.Jtt2XybXkService;

public class Jtt2XybXkServiceImpl implements Jtt2XybXkService {
    private Jtt2XybXkDao jtt2XybXkDao;

	public Jtt2XybXkDao getJtt2XybXkDao() {
		return jtt2XybXkDao;
	}

	public void setJtt2XybXkDao(Jtt2XybXkDao jtt2XybXkDao) {
		this.jtt2XybXkDao = jtt2XybXkDao;
	}

	
	public List<Jtt2XybXk> getList(List<SqlBean> sqlBeans, int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		
		return jtt2XybXkDao.getList(sqlBeans, pageNo,pageSize);
	}

	
	public List<Jtt2XybXk> getListForScroll(List<SqlBean> sqlBeans) {
		// TODO Auto-generated method stub
		
		return jtt2XybXkDao.getListForScroll(sqlBeans);
	}
	
	public List<Jtt2XybXk> getListForScroll(List<SqlBean> sqlBeans,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		
		return jtt2XybXkDao.getListForScroll(sqlBeans,pageNo,pageSize);
	}
	
	public Jtt2XybXk getInfo(String wsh) {
		// TODO Auto-generated method stub
		return jtt2XybXkDao.getInfo(wsh);
	}

	
	public int getSumnum(List<SqlBean> sqlBeans) {
		// TODO Auto-generated method stub
		return jtt2XybXkDao.getSumnum(sqlBeans);
	}

	
	public String importExcelXK(List<Map<String, Object>> list, HttpServletResponse response,JiaoTongLog request) {
		return jtt2XybXkDao.insertData(list, response, request);
	}

	
	public void insert(JiaoTongLog log) {
		jtt2XybXkDao.insertImportData(log);
		
	}



    
}
