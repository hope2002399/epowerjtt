package com.centit.monitor.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.Pacheckupparam;

public class PacheckupparamDao extends BaseDaoImpl<Pacheckupparam> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PacheckupparamDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("paramNo", CodeBook.EQUAL_HQL_ID);

            filterField.put("paramName", CodeBook.LIKE_HQL_ID);

            filterField.put("defaultValue", CodeBook.LIKE_HQL_ID);

            filterField.put("paramValue", CodeBook.LIKE_HQL_ID);

            filterField.put("paramDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("paramType", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public boolean callAppraisalDept(String orgId, Date yearAndmonth,
            String deleteOld, String onlyCalcSum) throws Exception {
        // StringBuffer sb = new StringBuffer();
        //
        // this.callProcedure("{call performance_appraisal.appraisal_dept(?,?,?,?)}",
        // params);
        return this.callProcedure("performance_appraisal.appraisal_dept",
                orgId, yearAndmonth, deleteOld, onlyCalcSum);

    }

    public boolean callAppraisalDeptAll(Date yearAndmonth, String deleteOld,
            String onlyCalcSum) throws Exception {

        return this.callProcedure("performance_appraisal.appraisal_dept_all",
                yearAndmonth, deleteOld, onlyCalcSum);

    }
    // public boolean callProcedure(String procString,List<Object> params)
    // throws Exception {
    // CallableStatement stmt = null;
    // try {
    // stmt = this.getSession().connection().prepareCall(procString);
    // if (params != null){
    // int idx = 1;
    // for (Object obj : params) {
    // if (obj != null) {
    // stmt.setObject(idx, obj);
    // } else {
    // stmt.setNull(idx, Types.NULL);
    // }
    // idx++;
    // }
    // }
    // stmt.execute();
    // } catch (SQLException e) {
    // e.printStackTrace();
    // throw new Exception("调用存储过程的时候发生错误[sql = " + procString + "]", e);
    // }
    // return false;
    // }

}
