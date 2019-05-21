package com.centit.poweritem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.core.utils.PageDesc;
import com.centit.poweritem.po.VpowerItemServiceChange;
import com.centit.poweritem.po.Vpoweritemservicewithoutlob;

public class VpoweritemservicewithoutlobDao extends
        BaseDaoImpl<Vpoweritemservicewithoutlob> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VpoweritemservicewithoutlobDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("item_id", CodeBook.LIKE_HQL_ID);
            filterField.put("version", CodeBook.EQUAL_HQL_ID);
            filterField
                    .put("begTime", "to_char(beginTime, 'yyyy-mm-dd') <= ? ");
            filterField.put("endTime",
                    " (endTime is null or to_char(endTime, 'yyyy-mm-dd') >?) ");
            filterField.put("NP_not", "version <>0 ");
            filterField.put("orgId", CodeBook.LIKE_HQL_ID);
            filterField.put("itemName", CodeBook.LIKE_HQL_ID);
            filterField.put("itemStaName", CodeBook.LIKE_HQL_ID);
            filterField.put("itemType", CodeBook.LIKE_HQL_ID);
            filterField.put("timeLimit", CodeBook.LIKE_HQL_ID);
            filterField.put("isNetwork", CodeBook.LIKE_HQL_ID);
            filterField.put("isFormula", CodeBook.LIKE_HQL_ID);
            filterField.put("phone", CodeBook.LIKE_HQL_ID);
            filterField.put("address", CodeBook.LIKE_HQL_ID);
            filterField.put("lastmodifytime", CodeBook.LIKE_HQL_ID);
            filterField.put("auditSign", CodeBook.LIKE_HQL_ID);
            filterField.put("monitorPhone", CodeBook.LIKE_HQL_ID);
            filterField.put("acceptLink", CodeBook.LIKE_HQL_ID);
            filterField.put("legalTimeLimit", CodeBook.LIKE_HQL_ID);
            filterField.put("charge", CodeBook.LIKE_HQL_ID);
            filterField.put("formName", CodeBook.LIKE_HQL_ID);
            filterField.put("fileName", CodeBook.LIKE_HQL_ID);
            filterField.put("inFlowImgName", CodeBook.LIKE_HQL_ID);
            filterField.put("ischarge", CodeBook.LIKE_HQL_ID);
            filterField.put("punishClass", CodeBook.LIKE_HQL_ID);
            filterField.put("transactDepname", CodeBook.LIKE_HQL_ID);
            filterField.put("promiseType", CodeBook.LIKE_HQL_ID);
            filterField.put("anticipateType", CodeBook.LIKE_HQL_ID);
            filterField.put("qlDepid", CodeBook.LIKE_HQL_ID);
            filterField.put("qlDepstate", CodeBook.LIKE_HQL_ID);
            filterField.put("entrustName", CodeBook.LIKE_HQL_ID);
            filterField.put("qlState", CodeBook.LIKE_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " item_id , version ");

        }
        return filterField;
    }

    public List<Vpoweritemservicewithoutlob> getObjectBystateAndVersion(
            String qlState, String version) {
        List<Vpoweritemservicewithoutlob> procs = this
                .listObjects("From Vpoweritemservicewithoutlob where ql_state =  "
                        + HQLUtils.buildHqlStringForSQL(qlState)
                        + " and version="
                        + HQLUtils.buildHqlStringForSQL(version));
        return procs;
    }

    @SuppressWarnings("unchecked")
    public List<Vpoweritemservicewithoutlob> listSuppowerWithoutLob(
            String flag, Map<String, Object> filterMap, PageDesc pageDesc) {
        List<Vpoweritemservicewithoutlob> list = new ArrayList<Vpoweritemservicewithoutlob>();
        String itemid = (String) filterMap.get("itemId");
        String itemName = (String) filterMap.get("itemName");
        String itemType = (String) filterMap.get("itemType");
        String orgId = (String) filterMap.get("orgId");
        String sParentUnit = (String) filterMap.get("sParentUnit");
        StringBuffer sql = new StringBuffer();

        if ("sq".equals(flag)) {
            sql.append(" select v_poweritemservicewithoutlob.item_id as itemId, v_poweritemservicewithoutlob.item_Name as itemName,v_poweritemservicewithoutlob.org_id as orgId, v_poweritemservicewithoutlob.ITEM_TYPE as itemType, v_poweritemservicewithoutlob.version as version, v_poweritemservicewithoutlob.ql_state  as qlState ,"
                    + "b_powerchglog.chg_type as chgType ");
            sql.append(" From v_poweritemservicewithoutlob left join b_powerchglog on v_poweritemservicewithoutlob.item_id = b_powerchglog.item_id and v_poweritemservicewithoutlob.version = b_powerchglog.version  and b_powerchglog.reply_time is null left join V_HI_UNITINFO on  v_poweritemservicewithoutlob.org_id = V_HI_UNITINFO.depno "
                    + "where 1=1 and v_poweritemservicewithoutlob.version<> 0 "
                    + " and v_poweritemservicewithoutlob.begin_time <=sysdate and (v_poweritemservicewithoutlob.end_time is null or v_poweritemservicewithoutlob.end_time > sysdate)  ");
            // sql.append(" From v_suppower_without_lob where 1=1 and version<>0 ");
        } else if ("sh".equals(flag)) {
            sql.append(" select item_id as itemId, item_Name as itemName,org_id as orgId, ITEM_TYPE as itemType, version as version, ql_state  as qlState ,"
                    + "chg_type as chgType ");
            sql.append(" From v_poweritemservicechange left join V_HI_UNITINFO on  v_poweritemservicechange.org_id = V_HI_UNITINFO.depno where 1=1 and auditor is null and requester is not null ");
            // sql.append(" From v_suppowerqlbgsq where 1=1 and auditor is null and requester is not null ");
        } else {
            sql.append(" select item_id as itemId, item_Name as itemName,org_id as orgId, ITEM_TYPE as itemType, version as version, ql_state  as qlState ,"
                    + "chg_type as chgType ");
            sql.append(" From v_poweritemservicechange left join V_HI_UNITINFO on  v_poweritemservicechange.org_id = V_HI_UNITINFO.depno where 1=1 and reply_people is null and auditor is not null ");
            // sql.append(" From v_suppowerqlbgsq where 1=1 and reply_people is null and auditor is not null ");
        }
        if (StringUtils.isNotBlank(itemid)) {
            if ("sq".equals(flag)) {
                sql.append(" and v_poweritemservicewithoutlob.item_id like '%"
                        + itemid + "%' ");
            } else {

                sql.append(" and item_id like '%" + itemid + "%' ");
            }
        }
        if (StringUtils.isNotBlank(itemName)) {
            sql.append(" and item_Name like '%" + itemName + "%' ");
        }
        if (StringUtils.isNotBlank(itemType)) {
            sql.append(" and item_Type = '" + itemType + "'");
        }
        if (StringUtils.isNotBlank(orgId)) {
            sql.append(" and org_Id like '%" + orgId + "%' ");
        }
        if (StringUtils.isNotBlank(sParentUnit)) {
            sql.append(" and topunitcode = '" + sParentUnit + "' ");
        }
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        sqlQuery.addScalar("itemId", StringType.INSTANCE);
        sqlQuery.addScalar("itemName", StringType.INSTANCE);
        sqlQuery.addScalar("orgId", StringType.INSTANCE);
        sqlQuery.addScalar("itemType", StringType.INSTANCE);
        sqlQuery.addScalar("version", LongType.INSTANCE);
        sqlQuery.addScalar("qlState", StringType.INSTANCE);
        sqlQuery.addScalar("chgType", StringType.INSTANCE);
        // System.out.println(sql);
        if ("sq".equals(flag)) {
            list = (List<Vpoweritemservicewithoutlob>) sqlQuery
                    .setResultTransformer(
                            Transformers
                                    .aliasToBean(Vpoweritemservicewithoutlob.class))
                    .list();
        } else {
            list = (List<Vpoweritemservicewithoutlob>) sqlQuery
                    .setResultTransformer(
                            Transformers
                                    .aliasToBean(VpowerItemServiceChange.class))
                    .list();
        }
        pageDesc.setTotalRows(new Integer(list.size()));
        return list;
    }
}
