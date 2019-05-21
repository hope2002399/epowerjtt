package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.DeptYwInfExpand;

public class DeptYwInfExpandDao extends BaseDaoImpl<DeptYwInfExpand>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(DeptYwInfExpandDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("iddeptYwExpand" , CodeBook.EQUAL_HQL_ID);


			filterField.put("updateType" , CodeBook.LIKE_HQL_ID);

			filterField.put("iddeptYwInf" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifJzHall" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifOnlineSb" , CodeBook.LIKE_HQL_ID);

			filterField.put("onlineBlSd" , CodeBook.LIKE_HQL_ID);

			filterField.put("onlineQcBj" , CodeBook.LIKE_HQL_ID);

			filterField.put("daoXcNum" , CodeBook.LIKE_HQL_ID);

			filterField.put("onlinePay" , CodeBook.LIKE_HQL_ID);

			filterField.put("onlineEms" , CodeBook.LIKE_HQL_ID);

			filterField.put("zxspType" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkwithPHall" , CodeBook.LIKE_HQL_ID);

			filterField.put("useTyPlatform" , CodeBook.LIKE_HQL_ID);

			filterField.put("djType" , CodeBook.LIKE_HQL_ID);

			filterField.put("jrTyBj" , CodeBook.LIKE_HQL_ID);

			filterField.put("needLogin" , CodeBook.LIKE_HQL_ID);

			filterField.put("idTestType" , CodeBook.LIKE_HQL_ID);

			filterField.put("createDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncSign" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncErrorDesc" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateSign" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateErrorDesc" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	} 
}
