package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.PowerRisk;

@SuppressWarnings("serial")
public class PowerRiskDao extends BaseDaoImpl<PowerRisk> {

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("itemId", CodeBook.EQUAL_HQL_ID);

            filterField.put("riskType", CodeBook.LIKE_HQL_ID);

            filterField.put("lastModifyDate", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }

    public List<PowerRisk> getListPowerRisk(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return this.listObjects(filterMap, pageDesc);

    }

}
