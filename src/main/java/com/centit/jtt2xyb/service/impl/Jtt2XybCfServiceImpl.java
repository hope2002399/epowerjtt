package com.centit.jtt2xyb.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.Jtt2XybCf;
import com.centit.jtt2xyb.bo.SqlBean;
import com.centit.jtt2xyb.dao.Jtt2XybCfDao;
import com.centit.jtt2xyb.service.Jtt2XybCfService;

public class Jtt2XybCfServiceImpl implements Jtt2XybCfService {
    private Jtt2XybCfDao jtt2XybCfDao;

	public Jtt2XybCfDao getJtt2XybCfDao() {
		return jtt2XybCfDao;
	}

	public void setJtt2XybCfDao(Jtt2XybCfDao jtt2XybCfDao) {
		this.jtt2XybCfDao = jtt2XybCfDao;
	}

	
	public List<Jtt2XybCf> getList(List<SqlBean> sqlBeans, int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return jtt2XybCfDao.getList(sqlBeans, pageNo,pageSize);
	}

	
	public Jtt2XybCf getInfo(String wsh) {
		// TODO Auto-generated method stub
		return jtt2XybCfDao.getInfo(wsh);
	}

	
	public int getSumnum(List<SqlBean> sqlBeans) {
		// TODO Auto-generated method stub
		return jtt2XybCfDao.getSumnum(sqlBeans);
	}

	
	public List<Jtt2XybCf> getListForScroll(List<SqlBean> sqlBeans) {
		// TODO Auto-generated method stub
		return jtt2XybCfDao.getListForScroll(sqlBeans);
	}

	
	public String importExcelCF(List<Map<String, Object>> list,HttpServletResponse response,JiaoTongLog log) {
		 return jtt2XybCfDao.insertData(list,response,log);
	}

	
	public List<Object[]> getDataList(String startTime ,String endTime) {
		return jtt2XybCfDao.selectDataStatistics(startTime,endTime);
	}

	public List<Object[]> selectError(String startTime ,String endTime,String xzjg,String type){
	    return jtt2XybCfDao.selectError(startTime,endTime,xzjg,type);
	}

    @Override
    public List<Object[]> getDataListSdbs(String startTime, String endTime) {
        // TODO Auto-generated method stub
        return jtt2XybCfDao.selectDataStatisticsSdbs(startTime,endTime);
    }

}
