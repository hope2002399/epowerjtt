package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;

import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.DeptYwInf;
import com.centit.powerruntime.po.VDeptYwBmdy;

public class VDeptYwBmdyDao extends BaseDaoImpl<VDeptYwBmdy>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(VDeptYwBmdyDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("iddeptYwInf" , CodeBook.EQUAL_HQL_ID);


			filterField.put("expressContent" , CodeBook.LIKE_HQL_ID);

			filterField.put("expressSendType" , CodeBook.LIKE_HQL_ID);

			filterField.put("expressFeeObject" , CodeBook.LIKE_HQL_ID);

			filterField.put("expressFee" , CodeBook.LIKE_HQL_ID);

			filterField.put("uniOrOwn" , CodeBook.LIKE_HQL_ID);

			filterField.put("needLogin" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateType" , CodeBook.LIKE_HQL_ID);

			filterField.put("deptQlId" , CodeBook.EQUAL_HQL_ID);

			filterField.put("deptYwNum" , CodeBook.LIKE_HQL_ID);

			filterField.put("deptYwRegNo" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywName" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywType" , CodeBook.LIKE_HQL_ID);

			filterField.put("useLevelC" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifEntrust" , CodeBook.LIKE_HQL_ID);

			filterField.put("entrustName" , CodeBook.LIKE_HQL_ID);

			filterField.put("entrustFileUrl" , CodeBook.LIKE_HQL_ID);

			filterField.put("qlDept" , CodeBook.LIKE_HQL_ID);

			filterField.put("decisionDep" , CodeBook.LIKE_HQL_ID);

			filterField.put("otherTogetdept" , CodeBook.LIKE_HQL_ID);

			filterField.put("otherTogetoffice" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywQlObject" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywQlObjectRemark" , CodeBook.LIKE_HQL_ID);

			filterField.put("anticipateDay" , CodeBook.LIKE_HQL_ID);

			filterField.put("anticipateType" , CodeBook.LIKE_HQL_ID);

			filterField.put("promiseDay" , CodeBook.LIKE_HQL_ID);

			filterField.put("promiseType" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkTel" , CodeBook.LIKE_HQL_ID);

			filterField.put("queryMethod" , CodeBook.LIKE_HQL_ID);

			filterField.put("superviseTel" , CodeBook.LIKE_HQL_ID);

			filterField.put("transactUrl" , CodeBook.LIKE_HQL_ID);

			filterField.put("transactAddr" , CodeBook.LIKE_HQL_ID);

			filterField.put("transactTime" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywByLaw" , CodeBook.LIKE_HQL_ID);

			filterField.put("condition" , CodeBook.LIKE_HQL_ID);

			filterField.put("prohibitLaw" , CodeBook.LIKE_HQL_ID);

			filterField.put("limitNum" , CodeBook.LIKE_HQL_ID);

			filterField.put("limitNumC" , CodeBook.LIKE_HQL_ID);

			filterField.put("chargeFlag" , CodeBook.LIKE_HQL_ID);

			filterField.put("xzProcedure" , CodeBook.LIKE_HQL_ID);

			filterField.put("resultSendMode" , CodeBook.LIKE_HQL_ID);

			filterField.put("serviceDept" , CodeBook.LIKE_HQL_ID);

			filterField.put("serviceFileUrl" , CodeBook.LIKE_HQL_ID);

			filterField.put("actFileUrl" , CodeBook.LIKE_HQL_ID);

			filterField.put("resultFileUrl" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywState" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywStartTime" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywEndTime" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywEndReason" , CodeBook.LIKE_HQL_ID);

			filterField.put("endReasonRemark" , CodeBook.LIKE_HQL_ID);

			filterField.put("ywVersion" , CodeBook.LIKE_HQL_ID);

			filterField.put("createDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncSign" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncErrorDesc" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateSign" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateErrorDesc" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifExpress" , CodeBook.LIKE_HQL_ID);
			
			filterField.put("outitemid" , CodeBook.LIKE_HQL_ID);

			filterField.put("outitemname" , CodeBook.LIKE_HQL_ID);

			filterField.put("orgcode" , CodeBook.LIKE_HQL_ID);

			filterField.put("orgname" , CodeBook.LIKE_HQL_ID);
			
			filterField.put("qlKind" , CodeBook.EQUAL_HQL_ID);
		}
		return filterField;
	} 
}
