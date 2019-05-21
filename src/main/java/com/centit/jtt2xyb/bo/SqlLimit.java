package com.centit.jtt2xyb.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;


/**
 * 此类根据字段名生成相应的表达式,方法不可被重载/重写
 * 
 * @author 季金辉
 * 
 * 
 */
public final class SqlLimit {

	/** 根据SqlBean对象 拼接字符串表达式 */
	public static String buildLimit(SqlBean sqlBean) {
		String columnName = sqlBean.getColumnName();
		Object[] columnValues = sqlBean.getColumnValues();
		SqlSymbol sqlSymbol = sqlBean.getLinkSymbol();

		String limit;

		switch (sqlSymbol) {
		case EQUAL: {
			limit = eq(columnName, columnValues[0]);
			break;
		}
		case NOT_EQUAL: {
			limit = ne(columnName, columnValues[0]);
			break;
		}
		case LESS_EQUAL: {
			limit = le(columnName, columnValues[0]);
			break;
		}
		case LESS_THAN: {
			limit = lt(columnName, columnValues[0]);
			break;
		}
		case GREATER_EQUAL: {
			limit = ge(columnName, columnValues[0]);
			break;
		}
		case GREATER_THAN: {
			limit = gt(columnName, columnValues[0]);
			break;
		}
		case ALL_LIKE: {
			limit = like(columnName, columnValues[0]);
			break;
		}
		case START_WITH: {
			limit = start(columnName, columnValues[0]);
			break;
		}
		case END_WITH: {
			limit = end(columnName, columnValues[0]);
			break;
		}
		case IN: {
			limit = in(columnName, columnValues);
			break;
		}
		case NOT_IN: {
			limit = notIn(columnName, columnValues);
			break;
		}
		case BETWEEN: {
			if (columnValues.length < 2)
				throw new RuntimeException("传入的value数量太少");

			if (columnValues.length > 2)
				throw new RuntimeException("传入的value数量太多");

			limit = between(columnName, columnValues[0], columnValues[1]);
		}
		case NOT_BETWEEN: {
			if (columnValues.length < 2)
				throw new RuntimeException("传入的value数量太少");

			if (columnValues.length > 2)
				throw new RuntimeException("传入的value数量太多");

			limit = notbetween(columnName, columnValues[0], columnValues[1]);
		}
		case NULL: {
			limit = isNull(columnName);
		}
		case NOT_NULL: {
			limit = isNotNull(columnName);
		}
		default: {
			limit = "";
			throw new RuntimeException("没有匹配");
		}
		}
		return limit;
	}

	/**
	 * ========================?占位符====================================
	 */
	/** 根据SqlBean对象 拼接字符串表达式 */
	public static String buildPreparedLimit(SqlBean sqlBean) {
		String columnName = sqlBean.getColumnName();
		Object[] columnValues = sqlBean.getColumnValues();
		SqlSymbol sqlSymbol = sqlBean.getLinkSymbol();

		String limit;

		switch (sqlSymbol) {
		case EQUAL: {
			limit = eq(columnName);
			break;
		}
		case NOT_EQUAL: {
			limit = ne(columnName);
			break;
		}
		case LESS_EQUAL: {
			limit = le(columnName);
			break;
		}
		case LESS_THAN: {
			limit = lt(columnName);
			break;
		}
		case GREATER_EQUAL: {
			limit = ge(columnName);
			break;
		}
		case GREATER_THAN: {
			limit = gt(columnName);
			break;
		}
		case ALL_LIKE: {
			limit = like(columnName);
			break;
		}
		case START_WITH: {
			limit = start(columnName);
			break;
		}
		case END_WITH: {
			limit = end(columnName);
			break;
		}
		case IN: {
			limit = in(columnName, columnValues.length);
			break;
		}
		case NOT_IN: {
			limit = notIn(columnName, columnValues.length);
			break;
		}
		case BETWEEN: {
			if (columnValues.length < 2)
				throw new RuntimeException("传入的value数量太少");

			if (columnValues.length > 2)
				throw new RuntimeException("传入的value数量太多");

			limit = between(columnName);
		}
		case NOT_BETWEEN: {
			if (columnValues.length < 2)
				throw new RuntimeException("传入的value数量太少");

			if (columnValues.length > 2)
				throw new RuntimeException("传入的value数量太多");

			limit = notbetween(columnName);
		}
		case NULL: {
			limit = isNull(columnName);
		}
		case NOT_NULL: {
			limit = isNotNull(columnName);
		}
		default: {
			limit = "";
			throw new RuntimeException("没有匹配");
		}
		}
		return limit;
	}

	/** 相等 */
	public static final String eq(String column) {
		String limit = " and " + column + " =? ";
		return limit;
	}

	/** 不等于 */
	public static final String ne(String column) {
		String limit = " and " + column + " !=? ";
		return limit;
	}

	/** 小于 */
	public static final String lt(String column) {
		return " and " + column + " <? ";
	}

	/** 小于等于 */
	public static final String le(String column) {
		String limit = " and " + column + " <=? ";
		return limit;
	}

	/** 大于 */
	public static final String gt(String column) {
		String limit = " and " + column + " >? ";
		return limit;
	}

	/** 大于等于 */
	public static final String ge(String column) {
		String limit = " and " + column + " >=? ";
		return limit;
	}

	/** like匹配 */
	public static final String like(String column) {
		String limit = " and " + column + " like '%?%' ";
		return limit;
	}

	/** start匹配 */
	public static final String start(String column) {
		String limit = " and " + column + " like '%?' ";
		return limit;
	}

	/** end匹配 */
	public static final String end(String column) {
		String limit = " and " + column + " like '?%' ";
		return limit;
	}

	/** in范围 */
	public static final String in(String column, int num) {
		String limit = "";
		for (int i = 0; i < num; i++) {
			limit = limit + "?,";
		}
		if (StringUtils.isNotBlank(limit)) {
			limit = limit.substring(0, limit.length() - 1);
		}
		limit = " and " + column + " in (" + limit + ") ";
		return limit;
	}

	/** not in范围 */
	public static final String notIn(String column, int num) {
		String limit = "";
		for (int i = 0; i < num; i++) {
			limit = limit + "?,";
		}
		if (StringUtils.isNotBlank(limit))
			limit = limit.substring(0, limit.length() - 1);
		limit = " and " + column + " not in (" + limit + ") ";
		return limit;
	}

	/** between范围 */
	public static final String between(String column) {
		String limit = " and " + column + " between (? and ?) ";
		return limit;
	}

	/** not between范围 */
	public static final String notbetween(String column) {
		String limit = " and " + column + " not between (? and ?) ";
		return limit;
	}

	/** null 情况 */
	public static final String isNull(String column) {
		String limit = " and " + column + " is null ";
		return limit;
	}

	/** not null 情况 */
	public static final String isNotNull(String column) {
		String limit = " and " + column + " is not null ";
		return limit;
	}

	public static final Object[] getSqlBeanValues(SqlBean sqlBean) {
		return sqlBean.getColumnValues();
	}

	public static final Object[] getSqlBeanValues(List<SqlBean> sqlBeans) {
		List<Object> sqlBeanValues = new ArrayList<Object>();
		for (SqlBean sqlBean : sqlBeans) {
			Object[] values = sqlBean.getColumnValues();
			for (int i = 0; i < values.length; i++) {
				sqlBeanValues.add(values[i]);
			}
		}
		return sqlBeanValues.toArray(new Object[0]);
	}

	/**
	 * =========================================对于拼接sql的情况======================
	 * =======================
	 * 
	 * */

	/** 相等 */
	public static final String eq(String column, Object value) {

		String limit = " and ";

		if (value == null) {
			limit = " and " + column + " is null";
		} else {
			if (value instanceof Number) {
				limit = limit + column + " = " + String.valueOf(value) + " ";
			} else if (value instanceof String) {
				String s = value.toString();
				s = s.replaceAll("'", "''");
				limit = limit + column + " = '" + s + "' ";
			} else if (value instanceof Date) {
				limit = limit + column + " = '"
						+ DateUtils.getDate((Date) value, null) + "' ";
			}
		}
		return limit;
	}

	/** 不等于 */
	public static final String ne(String column, Object value) {

		String limit = " and ";

		if (value == null) {
			limit = " and " + column + " is not null";
		} else {
			if (value instanceof Number) {
				limit = limit + column + " != " + String.valueOf(value) + " ";
			} else if (value instanceof String) {
				String s = value.toString();
				s = s.replaceAll("'", "''");
				limit = limit + column + " != '" + s + "' ";
			} else if (value instanceof Date) {
				limit = limit + column + " != '"
						+ DateUtils.getDate((Date) value, null) + "' ";
			}
		}

		return limit;
	}

	/** 小于 */
	public static final String lt(String column, Object value) {

		try {
			if (StringUtils.isBlank(String.valueOf(value)))
				return "";
		} catch (Exception ex) {
			/** StringUtils 进行判断的时候可能会出现异常，比如说空指针等 */
			ReflectionUtils.handleReflectionException(ex);
			return "";
		}

		String limit = " and ";

		if (value instanceof Number) {
			limit = limit + column + " < " + String.valueOf(value) + " ";
		} else if (value instanceof String) {
			String s = value.toString();
			s = s.replaceAll("'", "''");
			limit = limit + column + " < '" + s + "' ";
		} else if (value instanceof Date) {
			limit = limit + column + " < '"
					+ DateUtils.getDate((Date) value, null) + "' ";
		}
		return limit;
	}

	/** 小于等于 */
	public static final String le(String column, Object value) {

		try {
			if (StringUtils.isBlank(String.valueOf(value)))
				return "";
		} catch (Exception ex) {
			/** StringUtils 进行判断的时候可能会出现异常，比如说空指针等 */
			ReflectionUtils.handleReflectionException(ex);
			return "";
		}

		String limit = " and ";

		if (value instanceof Number) {
			limit = limit + column + " <= " + String.valueOf(value) + " ";
		} else if (value instanceof String) {
			String s = value.toString();
			s = s.replaceAll("'", "''");
			limit = limit + column + " <= '" + s + "' ";
		} else if (value instanceof Date) {
			limit = limit + column + " <= '"
					+ DateUtils.getDate((Date) value, null) + "' ";
		}
		return limit;
	}

	/** 大于 */
	public static final String gt(String column, Object value) {

		try {
			if (StringUtils.isBlank(String.valueOf(value)))
				return "";
		} catch (Exception ex) {
			/** StringUtils 进行判断的时候可能会出现异常，比如说空指针等 */
			ReflectionUtils.handleReflectionException(ex);
			return "";
		}

		String limit = " and ";

		if (value instanceof Number) {
			limit = limit + column + " > " + String.valueOf(value) + " ";
		} else if (value instanceof String) {
			String s = value.toString();
			s = s.replaceAll("'", "''");
			limit = limit + column + " > '" + s + "' ";
		} else if (value instanceof Date) {
			limit = limit + column + " > '"
					+ DateUtils.getDate((Date) value, null) + "' ";
		}
		return limit;
	}

	/** 大于等于 */
	public static final String ge(String column, Object value) {

		try {
			if (StringUtils.isBlank(String.valueOf(value)))
				return "";
		} catch (Exception ex) {
			/** StringUtils 进行判断的时候可能会出现异常，比如说空指针等 */
			ReflectionUtils.handleReflectionException(ex);
			return "";
		}

		String limit = " and ";

		if (value instanceof Number) {
			limit = limit + column + " >= " + String.valueOf(value) + " ";
		} else if (value instanceof String) {
			String s = value.toString();
			s = s.replaceAll("'", "''");
			limit = limit + column + " >= '" + s + "' ";
		} else if (value instanceof Date) {
			limit = limit + column + " >= '"
					+ DateUtils.getDate((Date) value, null) + "' ";
		}
		return limit;
	}

	/** like 所有的都匹配 */
	public static final String like(String column, Object value) {

		try {
			if (StringUtils.isBlank(String.valueOf(value)))
				return "";
		} catch (Exception ex) {
			/** StringUtils 进行判断的时候可能会出现异常，比如说空指针等 */
			ReflectionUtils.handleReflectionException(ex);
			return "";
		}

		String limit = " and ";

		if (value instanceof Number) {
			String s = value.toString();
			s = s.replaceAll("'", "''");
			limit = limit + column + " like %" + String.valueOf(s) + "% ";
		} else if (value instanceof String) {
			String s = value.toString();
			s = s.replaceAll("'", "''");
			limit = limit + column + " like '%" + s + "%' ";
		} else if (value instanceof Date) {
			String s = value.toString();
			s = s.replaceAll("'", "''");
			limit = limit + column + " like '%"
					+ DateUtils.getDate((Date) value, null) + "%' ";
		}
		return limit;
	}

	/** start 所有的都匹配 */
	public static final String start(String column, Object value) {

		try {
			if (StringUtils.isBlank(String.valueOf(value)))
				return "";
		} catch (Exception ex) {
			/** StringUtils 进行判断的时候可能会出现异常，比如说空指针等 */
			ReflectionUtils.handleReflectionException(ex);
			return "";
		}

		String limit = " and ";

		if (value instanceof Number) {
			limit = limit + column + " like %" + String.valueOf(value) + " ";
		} else if (value instanceof String) {
			String s = value.toString();
			s = s.replaceAll("'", "''");
			limit = limit + column + " like '%" + s + "' ";
		} else if (value instanceof Date) {
			limit = limit + column + " like '%"
					+ DateUtils.getDate((Date) value, null) + "' ";
		}
		return limit;
	}

	/** end 所有的都匹配 */
	public static final String end(String column, Object value) {

		try {
			if (StringUtils.isBlank(String.valueOf(value)))
				return "";
		} catch (Exception ex) {
			/** StringUtils 进行判断的时候可能会出现异常，比如说空指针等 */
			ReflectionUtils.handleReflectionException(ex);
			return "";
		}

		String limit = " and ";

		if (value instanceof Number) {
			limit = limit + column + " like " + String.valueOf(value) + "% ";
		} else if (value instanceof String) {
			String s = value.toString();
			s = s.replaceAll("'", "''");
			limit = limit + column + " like '%" + s + "' ";
		} else if (value instanceof Date) {
			limit = limit + column + " like '%"
					+ DateUtils.getDate((Date) value, null) + "' ";
		}
		return limit;
	}

	/** in范围 */
	public static final String in(String column, Object... objects) {

		if (objects.length == 0)
			return "";

		String limit = " and " + column + " in (";

		for (Object object : objects) {
			if (object instanceof Number) {
				limit = limit + "" + String.valueOf(object) + ",";
			} else if (object instanceof String) {
				String s = object.toString();
				s = s.replaceAll("'", "''");
				limit = limit + "'" + s + "',";
			} else if (object instanceof Date) {
				limit = limit + "'" + DateUtils.getDate((Date) object, null)
						+ "',";
			}
		}
		limit = limit.substring(0, limit.length() - 1) + ") ";
		return limit;
	}

	/** not in范围 */
	public static final String notIn(String column, Object... objects) {

		if (objects.length == 0)
			return "";

		String limit = " and " + column + " not in (";

		for (Object object : objects) {
			if (object instanceof Number) {
				limit = limit + "" + String.valueOf(object) + ",";
			} else if (object instanceof String) {
				String s = object.toString();
				s = s.replaceAll("'", "''");
				limit = limit + "'" + s + "',";
			} else if (object instanceof Date) {
				limit = limit + "'" + DateUtils.getDate((Date) object, null)
						+ "',";
			}
		}
		limit = limit.substring(0, limit.length() - 1) + ") ";
		return limit;
	}

	/** between 范围 */
	public static final String between(String column, Object svalue,
			Object lvalue) {

		try {
			if (StringUtils.isBlank(String.valueOf(svalue))
					|| StringUtils.isBlank(String.valueOf(svalue)))
				return "";
		} catch (Exception ex) {
			// StringUtils 进行判断的时候可能会出现异常，比如说空指针等
			ReflectionUtils.handleReflectionException(ex);
			return "";
		}

		String limit = " and ";

		String str1 = "";
		String str2 = "";
		if (svalue instanceof Number) {
			str1 = String.valueOf(svalue);
		} else if (svalue instanceof String) {
			String s = svalue.toString();
			s = s.replaceAll("'", "''");
			str1 = "'" + s + "'";
		} else if (svalue instanceof Date) {
			str1 = "'" + DateUtils.getDate((Date) svalue, null) + "' ";
		}

		if (lvalue instanceof Number) {
			str2 = String.valueOf(lvalue);
		} else if (lvalue instanceof String) {
			String s = lvalue.toString();
			s = s.replaceAll("'", "''");
			str2 = "'" + s + "'";
		} else if (lvalue instanceof Date) {
			str2 = "'" + DateUtils.getDate((Date) lvalue, null) + "' ";
		}
		limit = limit + column + " between (" + str1 + " and " + str2 + ") ";
		return limit;
	}

	/** not between 范围 */
	public static final String notbetween(String column, Object svalue,
			Object lvalue) {

		try {
			if (StringUtils.isBlank(String.valueOf(svalue))
					|| StringUtils.isBlank(String.valueOf(svalue)))
				return "";
		} catch (Exception ex) {
			/** StringUtils 进行判断的时候可能会出现异常，比如说空指针等 */
			ReflectionUtils.handleReflectionException(ex);
			return "";
		}

		String limit = " and ";

		String str1 = "";
		String str2 = "";
		if (svalue instanceof Number) {
			str1 = String.valueOf(svalue);
		} else if (svalue instanceof String) {
			String s = svalue.toString();
			s = s.replaceAll("'", "''");
			str1 = "'" + s + "'";
		} else if (svalue instanceof Date) {
			str1 = "'" + DateUtils.getDate((Date) svalue, null) + "' ";
		}

		if (lvalue instanceof Number) {
			str2 = String.valueOf(lvalue);
		} else if (lvalue instanceof String) {
			String s = lvalue.toString();
			s = s.replaceAll("'", "''");
			str2 = "'" + s + "'";
		} else if (lvalue instanceof Date) {
			str2 = "'" + DateUtils.getDate((Date) lvalue, null) + "' ";
		}
		limit = limit + column + " not between (" + str1 + " and " + str2
				+ ") ";
		return limit;
	}

	/**
	 * ============= 以下函数基本都是针对NamedParameterJdbcTemplate
	 * */

	public static final String eq(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " = :" + column + " ";
		}
		return " and " + column + " = :" + paramName + " ";
	}

	public static final String gt(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " > :" + column + " ";
		}
		return " and " + column + " > :" + paramName + " ";
	}

	public static final String ge(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " >= :" + column + " ";
		}
		return " and " + column + " >= :" + paramName + " ";
	}

	public static final String lt(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " < :" + column + " ";
		}
		return " and " + column + " < :" + paramName + " ";
	}

	public static final String le(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " <= :" + column + " ";
		}
		return " and " + column + " <= :" + paramName + " ";
	}

	public static final String ne(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " != :" + column + " ";
		}
		return " and " + column + " != :" + paramName + " ";
	}

	public static final String like(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " like '%:" + column + "%' ";
		}
		return " and " + column + " like '%:" + paramName + "%' ";
	}

	public static final String start(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " like '%:" + column + "' ";
		}
		return " and " + column + " like '%:" + paramName + "' ";
	}

	public static final String end(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " like ':" + column + "%' ";
		}
		return " and " + column + " like ':" + paramName + "%' ";
	}

	public static final String in(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " in (:" + column + ") ";
		}
		return " and " + column + " in (:" + paramName + ") ";
	}

	public static final String notIn(String column, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return " and " + column + " not in (:" + column + ") ";
		}
		return " and " + column + " not in (:" + paramName + ") ";
	}

	public static final String between(String column, String paramName1,
			String paramName2) {
		if (StringUtils.isBlank(paramName1) && StringUtils.isBlank(paramName2)) {
			return " and " + column + " between :" + column + " and :" + column
					+ " ";
		}
		return " and " + column + " between :" + paramName1 + " and :"
				+ paramName2 + " ";
	}

	public static final String notbetween(String column, String paramName1,
			String paramName2) {
		if (StringUtils.isBlank(paramName1) && StringUtils.isBlank(paramName2)) {
			return " and " + column + " not between :" + column + " and :"
					+ column + " ";
		}
		return " and " + column + " not between :" + paramName1 + " and :"
				+ paramName2 + " ";
	}

	public static final String isNull(String column, String paramName) {
		return " and " + column + " is null ";
	}

	public static final String isNotNull(String column, String paramName) {
		return " and " + column + " is not null ";
	}

	/** 判断数据是否为空 */
	private static boolean isEmptyValue(String paramName,
			Map<String, Object> paramsMap) {
		if (paramsMap != null && !paramsMap.isEmpty()) {
			Object paramValue = paramsMap.get(paramName);
			return !StringUtils.isEmpty((String) paramValue)
					&& !StringUtils.isBlank((String) paramValue);
		}
		return false;
	}
}
