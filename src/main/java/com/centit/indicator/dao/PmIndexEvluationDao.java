package com.centit.indicator.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.po.PmIndexEvluation;

public class PmIndexEvluationDao extends BaseDaoImpl<PmIndexEvluation>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(PmIndexEvluationDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("evlId" , CodeBook.EQUAL_HQL_ID);


			filterField.put("templetId" , CodeBook.LIKE_HQL_ID);

			filterField.put("objectId" , CodeBook.LIKE_HQL_ID);

			filterField.put("objectType" , CodeBook.LIKE_HQL_ID);

			filterField.put("evlScore" , CodeBook.LIKE_HQL_ID);

			filterField.put("taskId" , CodeBook.LIKE_HQL_ID);

			filterField.put("evlTime" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	} 
}
