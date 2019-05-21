package com.centit.indicator.service;

import java.util.Map;

public interface ServiceManager {
	public Map<String, Object> getObjectById(Map<Object, Object> requestMap,Class obj);
	
	public int doUpdate(Map<Object, Object> requestMap,Class obj);
	
	public int doInsert(Map<Object, Object> requestMap,Class obj);
	
	public int updateOrSave(Map<Object, Object> requestMap, Class obj);
}
