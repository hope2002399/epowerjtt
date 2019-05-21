package com.centit.indicator.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.po.PmIndexBasic;

public class PmIndexBasicDao extends BaseDaoImpl<PmIndexBasic>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(PmIndexBasicDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("rangeId" , CodeBook.EQUAL_HQL_ID);


			filterField.put("grade" , CodeBook.LIKE_HQL_ID);

			filterField.put("leftRange" , CodeBook.LIKE_HQL_ID);

			filterField.put("rightRange" , CodeBook.LIKE_HQL_ID);

			filterField.put("indexId" , CodeBook.LIKE_HQL_ID);

			filterField.put("dictvalue" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	} 
}
