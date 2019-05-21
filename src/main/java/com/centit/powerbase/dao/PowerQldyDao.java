package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerbase.po.PowerQldy;

@SuppressWarnings("serial")
public class PowerQldyDao extends BaseDaoImpl<PowerQldy> {

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("bPowerItemId", CodeBook.LIKE_HQL_ID);
            filterField.put("otherItemId", CodeBook.LIKE_HQL_ID);
            filterField.put("otherNbId", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public PowerQldy getPowerQldyByBPowerItemId(String bPowerItemId) {
        return (PowerQldy) this.findObjectsByHql(
                "from PowerQldy where bPowerItemId='" + bPowerItemId + "'")
                .get(0);
    }

}
