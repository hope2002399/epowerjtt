package com.centit.indicator.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.po.PmIndexType;

public class PmIndexTypeDao extends BaseDaoImpl<PmIndexType>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(PmIndexTypeDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("indexId" , CodeBook.EQUAL_HQL_ID);


			filterField.put("indexname" , CodeBook.LIKE_HQL_ID);

			filterField.put("evlType" , CodeBook.LIKE_HQL_ID);

			filterField.put("templetId" , CodeBook.LIKE_HQL_ID);

			filterField.put("indicatorId" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	} 
}
