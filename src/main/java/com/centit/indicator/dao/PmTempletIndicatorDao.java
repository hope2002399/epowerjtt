package com.centit.indicator.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.po.PmTempletIndicator;

public class PmTempletIndicatorDao extends BaseDaoImpl<PmTempletIndicator>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(PmTempletIndicatorDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("templetId" , "cid.templetId=?");

			filterField.put("indicatorId" , CodeBook.EQUAL_HQL_ID);


			filterField.put("ifMust" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifInternal" , CodeBook.LIKE_HQL_ID);

			filterField.put("internalTable" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifPrimary" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifHidden" , CodeBook.LIKE_HQL_ID);

			filterField.put("indicatorLevel" , CodeBook.LIKE_HQL_ID);

			filterField.put("indicatorIndex" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifWriteBack" , CodeBook.LIKE_HQL_ID);

			filterField.put("writeBackTable" , CodeBook.LIKE_HQL_ID);

			filterField.put("writeBackIndicator" , CodeBook.LIKE_HQL_ID);

			filterField.put("createTime" , CodeBook.LIKE_HQL_ID);

			filterField.put("createBy" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	} 
}
