package com.centit.monitor.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.OutwayWarnpoint;

/**
 * 
 * 预报警规则DAO
 * 
 * @author jf
 * @create 2014-2-11
 * @version
 */
public class OutwayWarnpointDao extends BaseDaoImpl<OutwayWarnpoint> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OutwayWarnpointDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("wpNo", CodeBook.EQUAL_HQL_ID);
            filterField.put("wpType", CodeBook.LIKE_HQL_ID);
            filterField.put("wpLevel", CodeBook.LIKE_HQL_ID);
            filterField.put("wpLevelNo", CodeBook.EQUAL_HQL_ID);
            filterField.put("wpDesc", CodeBook.LIKE_HQL_ID);
            filterField.put("wpTypeNo", CodeBook.EQUAL_HQL_ID);
            filterField.put("wpStatus", CodeBook.EQUAL_HQL_ID);
            filterField.put("wpSource", CodeBook.EQUAL_HQL_ID);
            filterField.put("wpOracle", CodeBook.LIKE_HQL_ID);
            filterField.put("wpOracleSql", CodeBook.LIKE_HQL_ID);
            filterField.put("wpRunning", CodeBook.EQUAL_HQL_ID);
            filterField.put("wpExeType", CodeBook.EQUAL_HQL_ID);
            filterField.put("wpExeRule", CodeBook.LIKE_HQL_ID);
            filterField.put("wpName", CodeBook.LIKE_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, "wpNo");

        }
        return filterField;
    }

    /**
     * 创建存储过程
     * 
     * @param sql
     */
    @SuppressWarnings("deprecation")
    public void createProcedure(String sql, String procedure) {
        Transaction tran = null;
        try {
            Connection con = this.getSession().connection();
            tran = this.getSession().beginTransaction();
            Statement st = con.createStatement();

            // 创建存储过程
            st.execute(sql);
            // 编译存储过程
            st.execute("alter procedure " + procedure + " compile");
            tran.commit();
        } catch (Exception e) {
            try {
                tran.rollback();
            } catch (HibernateException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                this.getSession().close();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }

    }
}
