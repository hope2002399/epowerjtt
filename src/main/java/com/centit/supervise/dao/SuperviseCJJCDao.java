package com.centit.supervise.dao;

// Generated 2013-12-20 16:41:04 by Hibernate Tools 3.4.0.CR1

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.SuperviseCJJC;

public class SuperviseCJJCDao extends BaseDaoImpl<SuperviseCJJC> {

    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SuperviseCJJCDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("supervisecode", " supervisecode = ? ");
            filterField.put("supervisestep", " dealstep = ? ");

            // filterField.put("bizType", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "supervisecode desc");

            // filterField.put("begsupervisedate",
            // "superviseDate >= to_date(?,'yyyy-mm-dd')");
            // filterField.put("endsupervisedate",
            // "superviseDate <= to_date(?,'yyyy-mm-dd')");

        }
        return filterField;
    }

    public SuperviseCJJC getSuperviseCJJCByCode(String supervisecode) {
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("supervisecode", supervisecode);
        List<SuperviseCJJC> optComplaintList = this.listObjects(
                "from SuperviseCJJC where 1 = 1 ", filtermap);
        if (optComplaintList == null || optComplaintList.size() == 0) {
            return null;
        }
        return optComplaintList.get(0);
    }
}
