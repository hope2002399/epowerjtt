package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerbase.po.LawexecutorInspect;

/**
 * 
 * 执法人员年检DAO
 * 
 * @author JF
 * @create 2013-10-25
 * @version
 */
public class LawexecutorInspectDao extends BaseDaoImpl<LawexecutorInspect> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(LawexecutorInspectDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("inspectId", CodeBook.EQUAL_HQL_ID);

            filterField.put("staffno", CodeBook.LIKE_HQL_ID);

            filterField.put("inspectType", CodeBook.LIKE_HQL_ID);

            filterField.put("inspectDate", CodeBook.LIKE_HQL_ID);

            filterField.put("inspectValidate", CodeBook.LIKE_HQL_ID);

            filterField.put("inspectRemark", CodeBook.LIKE_HQL_ID);

            filterField.put("recorder", CodeBook.LIKE_HQL_ID);

            filterField.put("recordDate", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

}
