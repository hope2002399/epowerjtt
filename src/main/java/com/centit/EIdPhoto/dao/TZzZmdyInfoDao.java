package com.centit.EIdPhoto.dao;

import java.util.List;
import java.util.Map;


import com.centit.EIdPhoto.po.TZzZmdyInfo;
import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.HqlAndParams;
import com.centit.core.dao.SQLQueryCallBack;
import com.centit.core.utils.PageDesc;

public class TZzZmdyInfoDao extends BaseDaoImpl<TZzZmdyInfo> {

    /**
     * 
     */
    private static final long serialVersionUID = -7633072450788744539L;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TZzZmdyInfo> listObjects(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        String shql = "from T_ZZ_ZMDY_INFO where outItemId is not null";
        String queryUnderUnit = "";
        if(filterMap.get("zzName") != null && !"".equals(filterMap.get("zzName").toString().trim())){
            shql = shql + " and zz_name like '%" + filterMap.get("zzName") + "%'";
        }
        if(filterMap.get("outItemName") != null && !"".equals(filterMap.get("outItemName").toString().trim())){
            shql = shql + " and outItemName like '%" + filterMap.get("outItemName") + "%'";
        }
        if(filterMap.get("outItemId") != null && !"".equals(filterMap.get("outItemId").toString().trim())){
            shql = shql + " and outItemId = substr('" + filterMap.get("outItemId") + "',23,12)";
        }
        HqlAndParams hql = builderHqlAndParams(shql, filterMap);

        String hql1 = "select *  " + hql.getHql() + queryUnderUnit;
        String hql2 = "select count(*)  " + hql.getHql() + queryUnderUnit;
        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();
        List<TZzZmdyInfo> list = null;
        try {

            list = getHibernateTemplate().executeFind(
                    new SQLQueryCallBack(hql1, hql.getParams(), startPos,
                            maxSize, TZzZmdyInfo.class));
            pageDesc.setTotalRows(new Integer(getHibernateTemplate()
                    .executeFind(new SQLQueryCallBack(hql2, hql.getParams()))
                    .get(0).toString()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return list;
    }  
    
}
