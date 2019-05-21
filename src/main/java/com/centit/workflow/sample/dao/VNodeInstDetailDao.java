package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.VNodeInstDetail;

public class VNodeInstDetailDao extends BaseDaoImpl<VNodeInstDetail> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VNodeInstDetailDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("nodeInstId", CodeBook.EQUAL_HQL_ID);

            filterField.put("flowInstId", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeId", CodeBook.LIKE_HQL_ID);

            filterField.put("createTime", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeState", CodeBook.LIKE_HQL_ID);

            filterField.put("unitCode", CodeBook.LIKE_HQL_ID);

            filterField.put("lastUpdateUser", CodeBook.EQUAL_HQL_ID);

            filterField.put("lastUpdateTime", CodeBook.LIKE_HQL_ID);

            filterField.put("flowOptName", CodeBook.LIKE_HQL_ID);

            filterField.put("flowOptTag", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeName", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public VNodeInstDetail getDetailbyNodeinstid(long nodeinstid) {

        String hql = "FROM VNodeInstDetail t WHERE nodeInstId = ? ";
        @SuppressWarnings("unchecked")
        List<VNodeInstDetail> o = getHibernateTemplate().find(hql, nodeinstid);
        if (o != null && o.size() > 0) {
            return o.get(0);
        }
        return null;
    }
}
