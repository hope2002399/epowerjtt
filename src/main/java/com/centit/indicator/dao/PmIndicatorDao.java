package com.centit.indicator.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.po.PmIndicator;

public class PmIndicatorDao extends BaseDaoImpl<PmIndicator>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(PmIndicatorDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("indicatorId" , CodeBook.EQUAL_HQL_ID);


			filterField.put("indicatorName" , CodeBook.LIKE_HQL_ID);

			filterField.put("indicatorNickName" , CodeBook.LIKE_HQL_ID);

			filterField.put("hasLower" , CodeBook.LIKE_HQL_ID);

			filterField.put("fatherId" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifDictionary" , CodeBook.LIKE_HQL_ID);

			filterField.put("dictionaryId" , CodeBook.LIKE_HQL_ID);

			filterField.put("dictionaryKey" , CodeBook.LIKE_HQL_ID);

			filterField.put("inputType" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifCascade" , CodeBook.LIKE_HQL_ID);

			filterField.put("cascadeId" , CodeBook.LIKE_HQL_ID);

			filterField.put("valueType" , CodeBook.LIKE_HQL_ID);

			filterField.put("createTime" , CodeBook.LIKE_HQL_ID);

			filterField.put("createBy" , CodeBook.LIKE_HQL_ID);
			
			filterField.put(CodeBook.ORDER_BY_HQL_ID, " indicatorName ASC");

		}
		return filterField;
	} 
}
