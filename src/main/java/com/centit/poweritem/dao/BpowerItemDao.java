package com.centit.poweritem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.poweritem.po.BpowerItem;

public class BpowerItemDao extends BaseDaoImpl<BpowerItem> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Map<String, String> getFilterField() {
        
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("itemId", CodeBook.EQUAL_HQL_ID);
            filterField.put("NitemId", " itemId !=? ");
            filterField.put("itemName", CodeBook.LIKE_HQL_ID);
            filterField.put("itemType", CodeBook.EQUAL_HQL_ID);
            filterField.put("itemStatus", CodeBook.EQUAL_HQL_ID);
            filterField.put("parentId", CodeBook.EQUAL_HQL_ID);
            filterField.put("parentName", CodeBook.LIKE_HQL_ID);
            filterField.put("isContainSub", CodeBook.EQUAL_HQL_ID);
            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);
            filterField.put("spObject", CodeBook.LIKE_HQL_ID);
            filterField.put("isNetwork", CodeBook.EQUAL_HQL_ID);
            filterField.put("itemQldyItemId", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BpowerItem> listObjects(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        List<BpowerItem> list = new ArrayList<BpowerItem>();
        String itemid = (String) filterMap.get("itemId");
        String itemName = (String) filterMap.get("itemName");
        String itemType = (String) filterMap.get("itemType");
        String itemStatus = (String) filterMap.get("itemStatus");
        String orgId = (String) filterMap.get("orgId");
        String itemQldyItemId = (String) filterMap.get("itemQldyItemId");
        String sParentUnit = (String) filterMap.get("sParentUnit");

        StringBuffer sqlcondition = new StringBuffer();
        if (StringUtils.isNotBlank(itemid)) {
            sqlcondition.append(" and item_id like '%" + itemid + "%' ");
        }
        if (StringUtils.isNotBlank(itemName)) {
            sqlcondition.append(" and item_Name like '%" + itemName + "%' ");
        }
        if (StringUtils.isNotBlank(itemType)) {
            sqlcondition.append(" and item_Type = '" + itemType + "'");
        }
        if (StringUtils.isNotBlank(itemStatus)) {
            sqlcondition.append(" and item_status = '" + itemStatus + "'");
        }
        if (StringUtils.isNotBlank(orgId)) {
            sqlcondition.append(" and orgId like '%" + orgId + "%' ");
        }
        if (StringUtils.isNotBlank(sParentUnit)) {
            sqlcondition.append(" and topunitcode = '" + sParentUnit + "' ");
        }
        if (StringUtils.isNotBlank(itemQldyItemId)) {
            sqlcondition.append(" and item_qldy_powerid = '" + itemQldyItemId
                    + "' ");
        }
        // 取总的条数
        StringBuffer sqlcount = new StringBuffer();
        sqlcount.append("select count(*) from b_power_item t left join v_hi_unitinfo u on t.orgid=u.depno where 1=1  and t.iscontainsub is not null and t.item_id like '%000' ");
        sqlcount.append(sqlcondition.toString());
        log.info(sqlcount.toString());
        pageDesc.setTotalRows(Integer.valueOf(getSession()
                .createSQLQuery(sqlcount.toString()).list().get(0).toString()));

        // 取数据
        String orderBy = " order by item_id ";
        StringBuffer sql = new StringBuffer();
        sql.append("select t.item_id itemId,t.parent_id parentId,t.item_name itemName,t.item_type itemType,"
                + "t.use_unit useUnit,t.use_level useLevel,t.item_status itemStatus,t.iscontainsub isContainSub,"
                + "t.orgid orgId,t.sp_object spObject,t.isnetwork isNetwork,item_qldy_powerid itemQldyItemId "
                + "from b_power_item t where 1=1 ");
        /*
         * if (StringUtils.isNotBlank(itemStatus)) {
         * sql.append(" and item_status = '" + itemStatus+"'"); }
         */

        // 分页语句
        StringBuffer sqlpage = new StringBuffer();
        sqlpage.append("(").append(" SELECT b.item_id ")
                .append(" FROM (SELECT A.*, ROWNUM RN ")
                .append("  FROM (select t.item_id ")
                .append("  from b_power_item t ")
                .append("  left join v_hi_unitinfo u ")
                .append("   on t.orgid = u.depno ").append("   where 1 = 1 ")
                .append("    and t.iscontainsub is not null ")
                .append("   and t.item_id like '%000' ")
                .append(sqlcondition.toString())
                .append(" order by item_id ) A ").append("  WHERE ROWNUM <= ")
                .append(pageDesc.getRowStart() + pageDesc.getPageSize())
                .append(") b ").append(" WHERE RN >")
                .append(pageDesc.getRowStart()).append(")");

        sql.append(" and t.item_id in ").append(sqlpage)
                .append(" or t.parent_id in  ").append(sqlpage).append(orderBy);

        log.info(sql.toString());

        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        sqlQuery.addScalar("itemId", StringType.INSTANCE);
        sqlQuery.addScalar("parentId", StringType.INSTANCE);
        sqlQuery.addScalar("itemName", StringType.INSTANCE);
        sqlQuery.addScalar("orgId", StringType.INSTANCE);
        sqlQuery.addScalar("itemType", StringType.INSTANCE);
        sqlQuery.addScalar("useUnit", StringType.INSTANCE);
        sqlQuery.addScalar("useLevel", StringType.INSTANCE);
        sqlQuery.addScalar("itemStatus", StringType.INSTANCE);
        sqlQuery.addScalar("isContainSub", StringType.INSTANCE);
        sqlQuery.addScalar("spObject", StringType.INSTANCE);
        sqlQuery.addScalar("isNetwork", StringType.INSTANCE);
        sqlQuery.addScalar("itemQldyItemId", StringType.INSTANCE);
        list = (List<BpowerItem>) sqlQuery.setResultTransformer(
                Transformers.aliasToBean(BpowerItem.class)).list();

        return list;
    }

}
