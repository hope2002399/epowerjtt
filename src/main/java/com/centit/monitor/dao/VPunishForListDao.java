package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.VPunishForList;

public class VPunishForListDao extends BaseDaoImpl<VPunishForList> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VPunishForListDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("content", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("department", CodeBook.LIKE_HQL_ID);

            filterField.put("punishTarget", CodeBook.LIKE_HQL_ID);

            filterField.put("istrack", CodeBook.LIKE_HQL_ID);

            filterField.put("targetType", CodeBook.LIKE_HQL_ID);

            filterField.put("createDate", CodeBook.LIKE_HQL_ID);

            filterField.put("isrisk", CodeBook.LIKE_HQL_ID);

            filterField.put("itemType", CodeBook.LIKE_HQL_ID);

            filterField.put("topunitcode", CodeBook.EQUAL_HQL_ID);

            filterField.put("unitcode", CodeBook.EQUAL_HQL_ID);

            filterField.put("monitorStyle", CodeBook.LIKE_HQL_ID);

            filterField.put("finishDate", CodeBook.LIKE_HQL_ID);
            filterField.put("begFinishTime",
                    "finishDate >= to_date(?,'yyyy-mm-dd HH24:mi:ss')");
            filterField.put("endFinishTime",
                    "finishDate <= to_date(?,'yyyy-mm-dd HH24:mi:ss')");
            filterField.put("NP_result", "finishDate is not null");
            filterField.put("NP_process", "finishDate is null");
            filterField.put("begTime",
                    "createDate >= to_date(?,'yyyy-mm-dd HH24:mi:ss')");
            filterField.put("endTime",
                    "createDate <= to_date(?,'yyyy-mm-dd HH24:mi:ss')");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " createDate desc");
        }
        return filterField;
    }

    public List<VPunishForList> listVPunishForList(
            Map<String, Object> filterMap, PageDesc pageDesc) {

        String shql = " from VPunishForList where 1=1 ";

        return this.listObjects(shql, filterMap, pageDesc);
    }

    public List<VPunishForList> listResultObjectsForList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        String shql = " From VPunishForList   "
                + " where finishDate is not null ";
        List<VPunishForList> l = super.listObjects(shql, filterMap, pageDesc);
        return l;
    }
}
