package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.SupDlfxOutway;

/**
 * 
 * TODO Class description should be added
 * 
 * @author zjh
 * @create 2013-12-17
 * @version
 */
public class SupDlfxOutwayDao extends MonitorDaoImpl<SupDlfxOutway> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SupDlfxOutwayDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("outwayId", CodeBook.EQUAL_HQL_ID);

            filterField.put("warnPointNo", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", "org_id=?");

            filterField.put("outwayType", CodeBook.EQUAL_HQL_ID);

            filterField.put("inTime", CodeBook.EQUAL_HQL_ID);

            filterField.put("outTime", CodeBook.EQUAL_HQL_ID);

            filterField.put("outPerson", CodeBook.LIKE_HQL_ID);

            filterField.put("outReason", CodeBook.LIKE_HQL_ID);

            filterField.put("analysisType", CodeBook.EQUAL_HQL_ID);

            filterField.put("supervisionType", CodeBook.EQUAL_HQL_ID);

            filterField.put("hbValue", CodeBook.LIKE_HQL_ID);

            filterField.put("sync_sign", CodeBook.LIKE_HQL_ID);

            filterField.put("error_desc", CodeBook.LIKE_HQL_ID);

            filterField.put("isCheck", CodeBook.LIKE_HQL_ID);

            filterField.put("isSync", CodeBook.LIKE_HQL_ID);

            filterField.put("month", "month=?");

            filterField.put("year", "year=?");

            filterField.put("itemId", CodeBook.EQUAL_HQL_ID);

            filterField.put("sjValue", CodeBook.EQUAL_HQL_ID);

            filterField.put("bzValue", CodeBook.LIKE_HQL_ID);

            filterField.put("tbValue", CodeBook.LIKE_HQL_ID);

            filterField.put("topunitcode", " topunitcode = ? ");
            // 时间选择
            filterField.put("begTime", "inTime>=to_date(?,'yyyy-MM-dd')");

            filterField.put("endTime", "inTime<=to_date(?,'yyyy-MM-dd')");
            // 某个月的预警信息
            // filterField.put("month", "to_char(inTime,'yyyy-MM')=?");
            // 排序
            filterField.put(CodeBook.ORDER_BY_HQL_ID, "o.inTime desc");

        }
        return filterField;
    }

    public List<SupDlfxOutway> getSupDlfxOutWayManager(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        // 下面的SupDlfxOutway不是是对应的java类，只是保存数据使用的
        String shql = " select o from SupDlfxOutway o ,Vhiunitinfo v where o.orgId=v.depno ";
        return listObjects(shql, filterMap, pageDesc);
    }

    public List<SupDlfxOutway> getSupDlfxOutWayInfoManager(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        // 下面的SupDlfxOutway不是是对应的java类，只是保存数据使用的
        String shql = " select o from SupDlfxOutway o where 1=1 ";
        return listObjects(shql, filterMap, pageDesc);
    }

    public void UpdateSupDlfxOutwayInfo(SupDlfxOutway info) {
        doExecuteHql(
                "update SupDlfxOutway set supervisionType=? where orgId =? and month=? and year=? and outwayId=?",
                new Object[] { info.getSupervisionType(), info.getOrgId(),
                        info.getMonth(), info.getYear(), info.getOutwayId() });
    }
}
