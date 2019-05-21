package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HqlAndParams;
import com.centit.core.dao.SQLQueryCallBack;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.VPunishViewList;

public class VPunishViewListDao extends BaseDaoImpl<VPunishViewList> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VPunishViewListDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.LIKE_HQL_ID);

            filterField.put("wfoptname", CodeBook.LIKE_HQL_ID);

            filterField.put("unitCode", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeName", CodeBook.LIKE_HQL_ID);

            filterField.put("createtime", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjectno", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjecttype", CodeBook.LIKE_HQL_ID);

            filterField.put("managedepid", CodeBook.EQUAL_HQL_ID);

            filterField.put("poregisterdate", CodeBook.LIKE_HQL_ID);

            filterField.put("pooccurstate", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjectstate", CodeBook.LIKE_HQL_ID);

            filterField.put("pooccurdate", CodeBook.LIKE_HQL_ID);

            filterField.put("poregistedate", CodeBook.LIKE_HQL_ID);

            filterField.put("pooriginstate", CodeBook.LIKE_HQL_ID);

            filterField.put("flowInstId", CodeBook.LIKE_HQL_ID);

            filterField.put("optId", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public List<VPunishViewList> listPunishObjectBasics(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        String shql = "from v_punish_view_list where 1=1 ";
        HqlAndParams hql = builderHqlAndParams(shql, filterMap);
        String queryUnderUnit = "";
        if ("true".equals(filterMap.get("queryUnderUnit"))) {
            queryUnderUnit = " or ( managedepid<>"
                    + filterMap.get("managedepid")
                    + " and managedepid in ( select unitcode from f_unitinfo connect by prior unitcode = parentunit start with unitcode= "
                    + filterMap.get("managedepid") + " ) )";
        }
        String hql1 = "select *  " + hql.getHql() + queryUnderUnit;
        String hql2 = "select count(*)  " + hql.getHql() + queryUnderUnit;
        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();

        List<VPunishViewList> l = null;
        try {

            l = getHibernateTemplate().executeFind(
                    new SQLQueryCallBack(hql1, hql.getParams(), startPos,
                            maxSize, VPunishViewList.class));
            pageDesc.setTotalRows(new Integer(getHibernateTemplate()
                    .executeFind(new SQLQueryCallBack(hql2, hql.getParams()))
                    .get(0).toString()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return l;
    }
}
