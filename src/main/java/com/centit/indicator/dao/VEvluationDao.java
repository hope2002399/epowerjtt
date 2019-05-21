package com.centit.indicator.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.po.VEvluation;

public class VEvluationDao extends BaseDaoImpl<VEvluation>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(VEvluationDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("evlId" , CodeBook.EQUAL_HQL_ID);


			filterField.put("templetId" , CodeBook.LIKE_HQL_ID);

			filterField.put("objectId" , CodeBook.LIKE_HQL_ID);

			filterField.put("objectType" , CodeBook.LIKE_HQL_ID);

			filterField.put("evlScore" , CodeBook.LIKE_HQL_ID);

			filterField.put("taskId" , CodeBook.LIKE_HQL_ID);

			filterField.put("evlTimebeg" ," to_char(evlTime,'yyyy-mm-dd')>=? ");
			filterField.put("evlTimeend" , " to_char(evlTime,'yyyy-mm-dd') <=? ");
			filterField.put("evlTime" , CodeBook.LIKE_HQL_ID);

			filterField.put("annual" , CodeBook.LIKE_HQL_ID);

			filterField.put("templetName" , CodeBook.LIKE_HQL_ID);

			filterField.put("objectName" , CodeBook.LIKE_HQL_ID);

			filterField.put("expression" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	} 
}
