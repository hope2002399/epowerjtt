package com.centit.jtt2xyb.bo;

public enum SqlSymbol {
	/** 等于 */
	EQUAL,
	
	/** 不等于 */
	NOT_EQUAL,
	
	/** 小于等于 */
	LESS_EQUAL,
	
	/** 小于 */
	LESS_THAN,
	
	/** 大于等于 */
	GREATER_EQUAL,
	
	/** 大于 */
	GREATER_THAN,
	
	/** 模糊查询，前后匹配多个 */
	ALL_LIKE,
	
	/** 模糊查询，以指定字符串开始 */
	START_WITH,
	
	/** 模糊查询，以指定字符串结束 */
	END_WITH,
	
	/** 模糊查询，在指定值中间 */
	IN,
	
	/** 模糊查询，不在指定值中间 */
	NOT_IN,
	
	/** 模糊查询，在大小范围内 */
	BETWEEN,
	
	/** 模糊查询，不在大小范围内 */
	NOT_BETWEEN,
	
	/** 为空 */
	NULL,
	
	/** 不为空 */
	NOT_NULL;
}
