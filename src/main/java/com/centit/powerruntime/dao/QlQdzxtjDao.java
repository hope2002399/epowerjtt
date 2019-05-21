package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;

import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.QlQdzxtj;

public class QlQdzxtjDao extends BaseDaoImpl<QlQdzxtj>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(QlQdzxtjDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();
			filterField.put("orgname" , CodeBook.EQUAL_HQL_ID);
			filterField.put("xzxk" , CodeBook.EQUAL_HQL_ID);
			filterField.put("xzcf" , CodeBook.EQUAL_HQL_ID);
			filterField.put("xzqz" , CodeBook.EQUAL_HQL_ID);
			filterField.put("xzzs" , CodeBook.EQUAL_HQL_ID);
			filterField.put("xzjf" , CodeBook.EQUAL_HQL_ID);
			filterField.put("xzjl" , CodeBook.EQUAL_HQL_ID);
            filterField.put("xzqr" , CodeBook.EQUAL_HQL_ID);
            filterField.put("xzcj" , CodeBook.EQUAL_HQL_ID);
            filterField.put("xzzy" , CodeBook.EQUAL_HQL_ID);
            filterField.put("qt" , CodeBook.EQUAL_HQL_ID);
            filterField.put("pjtcode" , CodeBook.EQUAL_HQL_ID);
		}
		return filterField;
	} 
}
