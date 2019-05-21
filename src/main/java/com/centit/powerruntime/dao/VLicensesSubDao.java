package com.centit.powerruntime.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.core.dao.HqlAndParams;
import com.centit.core.dao.SQLQueryCallBack;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.OptApplyInfo;
import com.centit.powerruntime.po.VLicensesSub;
import com.centit.powerruntime.po.VOptApplyInfo;

public class VLicensesSubDao extends BaseDaoImpl<VLicensesSub> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VLicensesSubDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            
            filterField.put("cid", CodeBook.EQUAL_HQL_ID);
            
            filterField.put("orgcode", CodeBook.EQUAL_HQL_ID);
            
            filterField.put("orgname", CodeBook.EQUAL_HQL_ID);
            
            filterField.put("zzName", CodeBook.LIKE_HQL_ID);
            
            filterField.put("sl", CodeBook.EQUAL_HQL_ID);
            
        }
        return filterField;
    }

    public List<String[]> filterMap() {
        List<String []> list = new ArrayList();
        String innerSQL = "";
        String sql = " select orgname,zz_name,sl from v_licenses_sub ";
               SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
               list = sqlQuery.list();
        return list;
    }

}
