package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HqlAndParams;
import com.centit.core.dao.SQLQueryCallBack;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.VPowerQldy;

@SuppressWarnings("serial")
public class VPowerQldyDao extends BaseDaoImpl<VPowerQldy> {

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("itemId", CodeBook.LIKE_HQL_ID);
            filterField.put("itemName", CodeBook.LIKE_HQL_ID);
            filterField.put("itemType", CodeBook.LIKE_HQL_ID);
            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);
            filterField.put("otherItemId", CodeBook.LIKE_HQL_ID);
            filterField.put("otherNbId", CodeBook.LIKE_HQL_ID);
            filterField.put("item_id", CodeBook.LIKE_HQL_ID);
            filterField.put("item_name", CodeBook.LIKE_HQL_ID);
            filterField.put("item_type", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public List<VPowerQldy> getListPowerRisk(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = "from v_power_qldy where 1=1 ";
        HqlAndParams hql = builderHqlAndParams(shql, filterMap);
        String queryUnderUnit = "";
        if (filterMap.get("org_id") != null
                && !"".equals(filterMap.get("org_id"))) {
            queryUnderUnit += " and org_Id in ( select depno from f_unitinfo connect by prior unitcode = parentunit start with depno='"
                    + filterMap.get("org_id") + "' ) ";
        }
        String hql1 = "select *  " + hql.getHql() + queryUnderUnit;
        String hql2 = "select count(*)  " + hql.getHql() + queryUnderUnit;
        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();
        List<VPowerQldy> l = null;
        try {
            l = getHibernateTemplate().executeFind(
                    new SQLQueryCallBack(hql1, hql.getParams(), startPos,
                            maxSize, VPowerQldy.class));
            pageDesc.setTotalRows(new Integer(getHibernateTemplate()
                    .executeFind(new SQLQueryCallBack(hql2, hql.getParams()))
                    .get(0).toString()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return l;
    }

}
