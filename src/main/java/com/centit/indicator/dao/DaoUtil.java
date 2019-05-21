package com.centit.indicator.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.centit.app.util.SqlUtil;
import com.centit.core.dao.BaseDaoImpl;

@SuppressWarnings({ "serial", "rawtypes" })
public class DaoUtil extends BaseDaoImpl {

	@SuppressWarnings("unchecked")
	public Map<String, Object> getObjectById(Map<Object, Object> requestMap, Map<String, Object> fieldMap, Object obj) {
		Map<String, Object> paramMap = SqlUtil.getSelectObjectSql(requestMap, fieldMap);
		String sql = paramMap.get("sql").toString();
		if (sql == null || "".equals(sql))
			return null;
		List<Object[]> pojoList = (List<Object[]>) findObjectsBySql(sql);
		List<String> fields = (List<String>) paramMap.get("fields");
		paramMap=new HashMap<String, Object>();
		if (pojoList != null && pojoList.size() > 0) {
			Object[] pojo = pojoList.get(0);
			// Field[] objFields=obj.getClass().getFields();
			for (int i = 0; i < fields.size(); i++) {
				Object value=pojo[i] ;
				if(value instanceof java.sql.Clob){
					Clob clob=(Clob)value;
					Reader inStream=null ;
					try {
						inStream = clob.getCharacterStream();
						char[] c = new char[(int) clob.length()];
						inStream.read(c);
						value = new String(c);
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
						try {
							inStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				paramMap.put(fields.get(i), value);
			}
		}
		return paramMap;
	}

	public int doUpdate(Map<Object, Object> requestMap, Map<String, Object> fieldMap) {
		Map updateParam = SqlUtil.getUpdateSql(requestMap, fieldMap);
		String sql = updateParam.get("sql").toString();
		Object[] value = (Object[]) updateParam.get("value");
		try {
			this.doExecuteSql(sql, value);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int doInsert(Map<Object, Object> requestMap, Map<String, Object> fieldMap) {
		Map insertParam = SqlUtil.getInsetSql(requestMap, fieldMap);
		String sql = insertParam.get("sql").toString();
		Object[] value = (Object[]) insertParam.get("value");
		try {
			this.doExecuteSql(sql, value);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getFieldMapInfo(Class obj) {
		String sql = "SELECT * FROM PM_INDICATOR_FIELD_INFO WHERE CLASS_NAME='" + obj.getSimpleName() + "'";
		return (List<Object[]>) findObjectsBySql(sql);
	}
}
