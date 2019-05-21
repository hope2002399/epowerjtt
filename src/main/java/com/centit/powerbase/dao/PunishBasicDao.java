package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.PunishBasic;

@SuppressWarnings("serial")
public class PunishBasicDao extends BaseDaoImpl<PunishBasic> {
    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("no", CodeBook.EQUAL_HQL_ID);
            filterField.put("recodeStyle", CodeBook.EQUAL_HQL_ID);
            filterField.put("internal_no", CodeBook.EQUAL_HQL_ID);
            filterField.put("org_id", CodeBook.EQUAL_HQL_ID);
            filterField.put("punish_target", CodeBook.LIKE_HQL_ID);
            filterField.put("isRecord", CodeBook.EQUAL_HQL_ID);
            filterField.put("parentDepno", CodeBook.EQUAL_HQL_ID);
            filterField.put("item_id", CodeBook.EQUAL_HQL_ID);
            filterField.put("beginCreateDate",
                    "createDate >= to_date(?,'yyyy-mm-dd HH24:mi:ss')");
            filterField.put("endCreateDate",
                    "createDate <= to_date(?,'yyyy-mm-dd HH24:mi:ss')");
        }
        return filterField;
    }

    public List<PunishBasic> getPunishBasic(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return this.listObjects(filterMap, pageDesc);
    }
}
