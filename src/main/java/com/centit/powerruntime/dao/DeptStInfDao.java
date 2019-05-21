package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerruntime.po.DeptQlInf;
import com.centit.powerruntime.po.DeptStInf;

public class DeptStInfDao extends BaseDaoImpl<DeptStInf>{
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(DeptStInfDao.class);
    public Map<String, String> getFilterField() {
        if( filterField == null){
            filterField = new HashMap<String, String>();
            
            filterField.put("iddeptQlInf" , CodeBook.EQUAL_HQL_ID);
            filterField.put("updateType" , CodeBook.LIKE_HQL_ID);
            filterField.put("deptQlParentId" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlRegNo" , CodeBook.LIKE_HQL_ID);
            filterField.put("deptQlRegNo" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlName" , CodeBook.LIKE_HQL_ID);
            filterField.put("qlKind" , CodeBook.EQUAL_HQL_ID);
            filterField.put("deptId2" , "dept_id like ?");
            filterField.put("deptId" , CodeBook.LIKE_HQL_ID);
            filterField.put("deptAreano" , CodeBook.LIKE_HQL_ID);
            filterField.put("topiddeptQlInf" , CodeBook.LIKE_HQL_ID); 
            filterField.put("hiLevel" , CodeBook.LIKE_HQL_ID);
            filterField.put("orgshortname" , CodeBook.LIKE_HQL_ID);
            filterField.put("zxs" , CodeBook.LIKE_HQL_ID);
            filterField.put("orgname1" , CodeBook.LIKE_HQL_ID);
            filterField.put("orgname2" , CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }
}
