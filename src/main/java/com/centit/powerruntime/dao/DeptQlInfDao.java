package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerruntime.po.DeptQlInf;

public class DeptQlInfDao extends BaseDaoImpl<DeptQlInf>{
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(DeptQlInfDao.class);
    public Map<String, String> getFilterField() {
        if( filterField == null){
            filterField = new HashMap<String, String>();
            
            filterField.put("iddeptQlInf" , CodeBook.EQUAL_HQL_ID);

            filterField.put("updateType" , CodeBook.LIKE_HQL_ID);
            filterField.put("deptQlParentId" , CodeBook.EQUAL_HQL_ID);
            filterField.put("qlKind" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlRegNo" , CodeBook.LIKE_HQL_ID);
            filterField.put("deptQlRegNo" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlName" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlShortName" , CodeBook.LIKE_HQL_ID);
            filterField.put("deptId" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlDepstate" , CodeBook.LIKE_HQL_ID);
            filterField.put("entrustName" , CodeBook.LIKE_HQL_ID);
            filterField.put("deptAreano" , CodeBook.LIKE_HQL_ID);
            filterField.put("deptOrganization" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlByLaw" , CodeBook.LIKE_HQL_ID);
            filterField.put("useLevel" , CodeBook.LIKE_HQL_ID);
            filterField.put("useLevelC" , CodeBook.LIKE_HQL_ID);
            filterField.put("remaer" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlState" , CodeBook.LIKE_HQL_ID);
            filterField.put("startTime" , CodeBook.LIKE_HQL_ID);
            filterField.put("endTime" , CodeBook.LIKE_HQL_ID);
            filterField.put("endReason" , CodeBook.LIKE_HQL_ID);
            filterField.put("endReasonRemark" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlVersion" , CodeBook.LIKE_HQL_ID);
            filterField.put("createDate" , CodeBook.LIKE_HQL_ID);
            filterField.put("syncSign" , CodeBook.LIKE_HQL_ID);
            filterField.put("syncDate" , CodeBook.LIKE_HQL_ID);
            filterField.put("syncErrorDesc" , CodeBook.LIKE_HQL_ID);
            filterField.put("updateDate" , CodeBook.LIKE_HQL_ID);
            filterField.put("idnewQlInf" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlSubCount" , CodeBook.LIKE_HQL_ID);
            filterField.put("updateSign" , CodeBook.LIKE_HQL_ID);
            filterField.put("updateErrorDesc" , CodeBook.LIKE_HQL_ID);
            filterField.put("ifAuditTransfer" , CodeBook.LIKE_HQL_ID);
            filterField.put("auditTransferType" , CodeBook.LIKE_HQL_ID);
            filterField.put("ifNPPublic" , CodeBook.LIKE_HQL_ID);
            filterField.put("ifEnterGovHall" , CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
