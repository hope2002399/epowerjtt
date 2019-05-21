package com.centit.monitor.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.Outwayparam;
import com.ibm.icu.text.SimpleDateFormat;

public class OutwayparamDao extends BaseDaoImpl<Outwayparam> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OutwayparamDao.class);

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

    public boolean callCheck_warning(String usreName, String countYear,
            String countMonth) {
        StringBuffer sb = new StringBuffer();
        sb.append("{call alert_warning.check_warning(?,'M',?)}");
        List<Object> parm = new ArrayList<Object>();
        String yerandmonth = countYear + "-" + countMonth + "-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = new java.util.Date();
        try {
            utilDate = sdf.parse(yerandmonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        parm.add(sqlDate);
        parm.add(usreName);
        // parm.add(flag);
        return this.callProcedure(sb.toString(), parm);
    }

    // 调用存储过程
    @SuppressWarnings("deprecation")
    public boolean callProcedure(String procString, List<Object> params) {
        CallableStatement stmt = null;
        try {
            stmt = this.getSession().connection().prepareCall(procString);
            if (params != null) {
                int idx = 1;
                for (Object obj : params) {
                    if (obj != null) {
                        stmt.setObject(idx, obj);
                    } else {
                        stmt.setNull(idx, Types.NULL);
                    }
                    idx++;
                }
            }
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
