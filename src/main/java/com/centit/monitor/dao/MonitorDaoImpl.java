package com.centit.monitor.dao;

import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.HQLQueryCallBack;
import com.centit.core.dao.HqlAndParams;
import com.centit.core.dao.SQLUtils;
import com.centit.core.utils.PageDesc;

public class MonitorDaoImpl<T extends Object> extends BaseDaoImpl<T> {
    private static final long serialVersionUID = 1L;

    @Override
    public List<T> listObjects(String shql, Map<String, Object> filterMap,
            PageDesc pageDesc) {
        HqlAndParams hql = builderHqlAndParams(shql, filterMap);
        return listObjects(hql.getHql(), hql.getParams(), pageDesc);
    }

    @Override
    public List<T> listObjects(String shql, Object[] values, PageDesc pageDesc) {
        List<T> l = (List<T>) findObject(shql, values, pageDesc);
        return l;
    }

    @SuppressWarnings("unchecked")
    public List<T> findObject(String shql, Object[] values, PageDesc pageDesc) {

        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();
        List<T> l = null;
        try {
            l = getHibernateTemplate().executeFind(
                    new HQLQueryCallBack(shql, values, startPos, maxSize));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        pageDesc.setTotalRows(new Integer(getHibernateTemplate()
                .find(buildGetCountHQL(shql), values).get(0).toString()));

        return l;
    }

    /**
     * 转换为查询符合条件的数量的hql语句
     * 
     * @param hql
     * @return
     */
    public static String buildGetCountHQL(String hql) {
        List<String> sqlPieces = SQLUtils.splitSqlByFields(hql);
        if (sqlPieces == null || sqlPieces.size() < 3)
            return "";

        String sCountSql = "SELECT count(*) from "
                + SQLUtils.removeOrderBy(sqlPieces.get(2));

        return sCountSql;
    }
}
