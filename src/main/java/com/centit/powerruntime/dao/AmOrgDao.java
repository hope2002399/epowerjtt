package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.AmOrg;

public class AmOrgDao extends BaseDaoImpl<AmOrg>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(AmOrgDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("idorg" , CodeBook.EQUAL_HQL_ID);


			filterField.put("idparentorg" , CodeBook.LIKE_HQL_ID);

			filterField.put("orgname" , CodeBook.LIKE_HQL_ID);

			filterField.put("orgshortname" , CodeBook.LIKE_HQL_ID);

			filterField.put("idareaCode" , CodeBook.LIKE_HQL_ID);

			filterField.put("ord" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateType" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncSign" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncErrorDesc" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateSign" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateErrorDesc" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifCg" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	} 
}
