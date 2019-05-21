package com.centit.jtt2xyb.bo;

/**
 * @author 季金辉
 *
 * sql表达式条件对象
 */

public class SqlBean {

	/** 字段名 */
	private String columnName;
	
	/** 字段值 */
	private Object[] columnValues;
	
	/** 判断符号 */
	private SqlSymbol linkSymbol;
	
	public SqlBean(String colName, SqlSymbol linkSymbol, Object... values) {
		this.columnName = colName;
		this.columnValues = values;
		this.linkSymbol = linkSymbol;
	}
	
	public SqlBean() {
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnValues(Object[] columnValues) {
		this.columnValues = columnValues;
	}

	public Object[] getColumnValues() {
		return columnValues;
	}

	public void setLinkSymbol(SqlSymbol linkSymbol) {
		this.linkSymbol = linkSymbol;
	}

	public SqlSymbol getLinkSymbol() {
		return linkSymbol;
	}
}
