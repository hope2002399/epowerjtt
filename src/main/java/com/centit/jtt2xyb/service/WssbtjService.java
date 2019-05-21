package com.centit.jtt2xyb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.centit.core.utils.PageDesc;
import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.SqlBean;
import com.centit.jtt2xyb.bo.WssbtjBo;
import com.centit.jtt2xyb.bo.WssbxzcfBo;
import com.centit.jtt2xyb.bo.WssbxzxkBo;

public interface WssbtjService {
	List<WssbtjBo> getList(List<SqlBean> sqlBeans,int pageNo,int pageSize);
	List<WssbtjBo> getListForScroll(List<SqlBean> sqlBeans);
	int getSumnum(List<SqlBean> sqlBeans);
	
	WssbtjBo getInfo(String wsh);
	
	String importExcelCF(List<Map<String, Object>> list, HttpServletResponse response,JiaoTongLog log);
	
	List<Map<String, Object>> getDataList(String startTime ,String endTime);
	public List<Map<String, Object>> getDataListNotMeet(String startTime,String endTime);
	
	List<Map<String, Object>> selectError(String startTime,String endTime,String xzjg);
    List<Map<String, Object>> getDataListsx(String startTime, String endTime);
    public List<Map<String, Object>> getDataDetailListsx(String condition);
    public List<Map<String, Object>> getDataAllDetailListsx(String[] djids);
    List<Map<String, Object>> getDataListDzzz(Map<String, Object> filterMap);
    List<Map<String, Object>> getDataListDzzzAll(Map<String, Object> filterMap);
    List<Map<String, Object>> getDataListZzxx(Map<String, Object> filterMap);
    List<Map<String, Object>> gettrafficData(Map<String, Object> filterMap);
    public List<Map<String, Object>> getDataListZzxxPro(Map<String, Object> filterMap);
    public List<Map<String, Object>> getErrorList(String startTime ,String endTime);
    public List<Map<String, Object>> getLegalErrorList(String startTime ,String endTime);
    public List<Map<String, Object>> getOvertimeErrorList(String startTime ,String endTime);
    public List<Map<String, Object>> getNonErrorList(String startTime ,String endTime);
    public List<Map<String, Object>> getYwInfHadCountStat(String startTime,String endTime);
    public List<Object[]> selectDataStatisticssxAll(String startTime,String endTime);
    public List<Object[]> getDataListZzxxAll(String startTime,String endTime);
    public List<WssbxzxkBo> getXzxkList(Map<String, Object> filterMap, PageDesc pageDesc);
    public List<WssbxzxkBo> getXzxkAllList(Map<String, Object> filterMap);
    public List<WssbxzcfBo> getXzcfList(Map<String, Object> filterMap,PageDesc pageDesc);
    public List<WssbxzcfBo> getXzcfAllList(Map<String, Object> filterMap);
	
}
