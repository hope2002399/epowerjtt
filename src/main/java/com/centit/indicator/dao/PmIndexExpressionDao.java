package com.centit.indicator.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.po.PmIndexExpression;

public class PmIndexExpressionDao extends BaseDaoImpl<PmIndexExpression>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(PmIndexExpressionDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("templetId" , CodeBook.EQUAL_HQL_ID);


			filterField.put("expression" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	} 
}
