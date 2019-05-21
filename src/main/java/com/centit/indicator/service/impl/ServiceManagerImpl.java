package com.centit.indicator.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.app.form.FieldInfo;
import com.centit.indicator.dao.DaoUtil;
import com.centit.indicator.dao.PmTempletDao;
import com.centit.indicator.service.ServiceManager;

public class ServiceManagerImpl implements ServiceManager {

	private DaoUtil daoUtil;
	private PmTempletDao pmTempletDao;

	
	
	@SuppressWarnings("rawtypes")
	public Map<String, Object> getObjectById(Map<Object, Object> requestMap,  Class obj) {
		Map<String, Object> fieldMap=getFieldMap(obj);
		Map<String, Object> objMap=daoUtil.getObjectById(requestMap, fieldMap, obj);
		return objMap;
	}

	@SuppressWarnings("rawtypes")
	public int doUpdate(Map<Object, Object> requestMap, Class obj) {
		Map<String, Object> fieldMap=getFieldMap(obj);
		return daoUtil.doUpdate(requestMap, fieldMap);
	}

	@SuppressWarnings("rawtypes")
	public int doInsert(Map<Object, Object> requestMap, Class obj) {
		Map<String, Object> fieldMap=getFieldMap(obj);
		return daoUtil.doInsert(requestMap, fieldMap);
	}
	
	@SuppressWarnings("rawtypes")
	public int updateOrSave(Map<Object, Object> requestMap, Class obj){
		Map<String, Object> o=getObjectById(requestMap, obj);
		if(o==null||o.size()<1){
			return doInsert(requestMap, obj);
		}else{
			return this.doUpdate(requestMap, obj);
		}
	}
	
	@SuppressWarnings("rawtypes")
	private Map<String, Object> getFieldMap(Class obj){
		List<Object[]> fields=daoUtil.getFieldMapInfo(obj);
		Map<String, Object> fieldMap=new HashMap<String, Object>();
		if(fields!=null&&fields.size()>0){
			Object[] o=fields.get(0);
			FieldInfo primayKey = new FieldInfo();
			primayKey.setPojoField(o[2].toString());
			primayKey.setPojoType(o[3].toString());
			primayKey.setTableField(o[4].toString());
			fieldMap.put("primaryKey", primayKey);
			fieldMap.put("tableName", o[1].toString());
			List<FieldInfo> propertys = new ArrayList<FieldInfo>();
			for (int i = 0; i < fields.size(); i++) {
				Object[] f=fields.get(i);
				FieldInfo field = new FieldInfo();
				field.setPojoField(f[5].toString());
				field.setPojoType(f[7].toString());
				field.setTableField(f[6].toString());
				propertys.add(field);
			}
			fieldMap.put("propertys", propertys);
		}else{
			pmTempletDao.buildFactory(obj);
			fieldMap=getFieldMap(obj);
		}
		return fieldMap;
	}

	public DaoUtil getDaoUtil() {
		return daoUtil;
	}

	public void setDaoUtil(DaoUtil daoUtil) {
		this.daoUtil = daoUtil;
	}

	public PmTempletDao getPmTempletDao() {
		return pmTempletDao;
	}

	public void setPmTempletDao(PmTempletDao pmTempletDao) {
		this.pmTempletDao = pmTempletDao;
	}
	
}
