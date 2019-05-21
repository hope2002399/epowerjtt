package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;

import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.DeptYwInf;
import com.centit.powerruntime.po.VDeptYwBmdy;
import com.centit.powerruntime.po.VDeptYwBmdy2;

public class VDeptYwBmdy2Dao extends BaseDaoImpl<VDeptYwBmdy2>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(VDeptYwBmdy2Dao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("iddeptYwInf" , CodeBook.EQUAL_HQL_ID);



			filterField.put("deptQlId" , CodeBook.EQUAL_HQL_ID);

			filterField.put("deptYwNum" , CodeBook.LIKE_HQL_ID);

			filterField.put("deptYwRegNo" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywName" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywType" , CodeBook.LIKE_HQL_ID);

			filterField.put("useLevelC" , CodeBook.LIKE_HQL_ID);
			
			filterField.put("useLevel" , CodeBook.LIKE_HQL_ID);
			
			filterField.put("qlDept" , CodeBook.LIKE_HQL_ID);

			filterField.put("outitemname" , CodeBook.LIKE_HQL_ID);

			filterField.put("orgcode" , CodeBook.LIKE_HQL_ID);

			filterField.put("orgname" , CodeBook.LIKE_HQL_ID);
			
			filterField.put("qlKind" , CodeBook.EQUAL_HQL_ID);
			
			filterField.put("deptId2" , " QL_DEPT like ? ");
			
		}
		return filterField;
	} 
}
