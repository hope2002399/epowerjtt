package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Vpowerrisk;

@SuppressWarnings("serial")
public class VpowerriskDao extends BaseDaoImpl<Vpowerrisk> {

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("itemId", CodeBook.EQUAL_HQL_ID);

            filterField.put("riskType", CodeBook.LIKE_HQL_ID);

            filterField.put("lastModifyDate", CodeBook.EQUAL_HQL_ID);

            filterField.put("itemName", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }

    public List<Vpowerrisk> getListPowerRisk(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return this.listObjects(filterMap, pageDesc);

    }

    public List<Vpowerrisk> view() {
        return this.view();
    }

}
