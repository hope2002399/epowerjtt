package com.centit.jtt2xyb.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;






import com.centit.core.utils.PageDesc;
import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.SqlBean;
import com.centit.jtt2xyb.bo.WssbtjBo;
import com.centit.jtt2xyb.bo.WssbxzcfBo;
import com.centit.jtt2xyb.bo.WssbxzxkBo;
import com.centit.jtt2xyb.dao.WssbtjDao;
import com.centit.jtt2xyb.service.WssbtjService;

public class WssbtjServiceImpl implements WssbtjService {
    private WssbtjDao wssbtjDao;
	
	public void setWssbtjDao(WssbtjDao wssbtjDao) {
		this.wssbtjDao = wssbtjDao;
	}


	public List<WssbtjBo> getList(List<SqlBean> sqlBeans, int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return wssbtjDao.getList(sqlBeans, pageNo,pageSize);
	}

	
	public WssbtjBo getInfo(String wsh) {
		// TODO Auto-generated method stub
		return wssbtjDao.getInfo(wsh);
	}

	
	public int getSumnum(List<SqlBean> sqlBeans) {
		// TODO Auto-generated method stub
		return wssbtjDao.getSumnum(sqlBeans);
	}

	
	public List<WssbtjBo> getListForScroll(List<SqlBean> sqlBeans) {
		// TODO Auto-generated method stub
		return wssbtjDao.getListForScroll(sqlBeans);
	}

	
	public String importExcelCF(List<Map<String, Object>> list,HttpServletResponse response,JiaoTongLog log) {
		 return wssbtjDao.insertData(list,response,log);
	}

	
	public List<Map<String, Object>> getDataList(String startTime ,String endTime) {
		return wssbtjDao.selectDataStatistics(startTime,endTime);
	}
	

    public List<Map<String, Object>> getErrorList(String startTime ,String endTime) {
        return wssbtjDao.getErrorList(startTime,endTime);
    }
    

    public List<Map<String, Object>> getLegalErrorList(String startTime ,String endTime) {
        return wssbtjDao.getLegalErrorList(startTime,endTime);
    }

    public List<Map<String, Object>> getOvertimeErrorList(String startTime ,String endTime) {
        return wssbtjDao.getOvertimeErrorList(startTime,endTime);
    }

    public List<Map<String, Object>> getNonErrorList(String startTime ,String endTime) {
        return wssbtjDao.getNonErrorList(startTime,endTime);
    }

	public List<Map<String, Object>> selectError(String startTime,String endTime,String xzjg){
		return wssbtjDao.selectError(startTime,endTime,xzjg);
	}


    @Override
    public List<Map<String, Object>> getDataListsx(String startTime,
            String endTime) {
        return wssbtjDao.selectDataStatisticssx(startTime,endTime);
    }
    
    @Override
    public List<Object[]> selectDataStatisticssxAll(String startTime,
            String endTime){
        return wssbtjDao.selectDataStatisticssxAll(startTime,endTime);
    }
    

    @Override
    public List<Map<String, Object>> getDataListNotMeet(String startTime,
            String endTime) {
        return wssbtjDao.getNotMeetDetailList(startTime,endTime);
    }
    
    @Override
    public List<Map<String, Object>> getYwInfHadCountStat(String startTime,
            String endTime) {
        return wssbtjDao.getYwInfHadCountStat(startTime,endTime);
    }

    @Override
    public List<Map<String, Object>> getDataDetailListsx(String condition) {
        return wssbtjDao.selectDataDetail(condition);
    }


    @Override
    public List<Map<String, Object>> getDataAllDetailListsx(String[] djids) {
        return wssbtjDao.selectDataAllDetail(djids);
    }


    @Override
    public List<Map<String, Object>> getDataListDzzz(Map<String, Object> filterMap) {
        // TODO Auto-generated method stub
        return wssbtjDao.getDataListDzzz(filterMap);
    }
    @Override
    public List<Map<String, Object>> getDataListDzzzAll(Map<String, Object> filterMap) {
        // TODO Auto-generated method stub
        return wssbtjDao.getDataListDzzzAll(filterMap);
    }
    @Override
    public List<Map<String, Object>> gettrafficData(Map<String, Object> filterMap) {
        // TODO Auto-generated method stub
        return wssbtjDao.gettrafficData(filterMap);
    }
    


    @Override
    public List<Map<String, Object>> getDataListZzxx(Map<String, Object> filterMap) {
        // TODO Auto-generated method stub
        return wssbtjDao.getDataListZzxx(filterMap);
    }

    @Override
    public List<Object[]> getDataListZzxxAll(String startTime,
            String endTime) {
        // TODO Auto-generated method stub
        return wssbtjDao.getDataListZzxxAll(startTime,endTime);
    }
    @Override
    public List<Map<String, Object>> getDataListZzxxPro(Map<String, Object> filterMap) {
        // TODO Auto-generated method stub
        return wssbtjDao.getDataListZzxxPro(filterMap);
    }

    /**
     * 行政许可列表
     */
    @Override
    public List<WssbxzxkBo> getXzxkList(Map<String, Object> filterMap, PageDesc pageDesc) {
        return wssbtjDao.getXzxkList(filterMap,pageDesc);
    }


    @Override
    public List<WssbxzxkBo> getXzxkAllList(Map<String, Object> filterMap) {
        return wssbtjDao.getXzxkAllList(filterMap);
    }


    /**
     * 行政处罚列表
     */
    @Override
    public List<WssbxzcfBo> getXzcfList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return wssbtjDao.getXzcfList(filterMap,pageDesc);
    }


    @Override
    public List<WssbxzcfBo> getXzcfAllList(Map<String, Object> filterMap) {
        return wssbtjDao.getXzcfAllList(filterMap);
    }

}
