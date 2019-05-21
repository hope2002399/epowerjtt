package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.MonitorDaoImpl;
import com.centit.powerbase.po.PunishRecord;

@SuppressWarnings("serial")
public class PunishRecordDao extends MonitorDaoImpl<PunishRecord> {
    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("depKind", CodeBook.EQUAL_HQL_ID);
            filterField.put("org_id", CodeBook.EQUAL_HQL_ID);
            filterField.put("topUnitNo", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }

    public List<PunishRecord> getPunishRecord(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " select o from PunishRecord o ,Vhiunitinfo v where o.org_id=v.depno ";
        return listObjects(shql, filterMap, pageDesc);
    }

    public void updatePunishRecord(Map<String, Object> filterMap) {
        PunishRecord punishRecord = new PunishRecord();

        this.renewObject(punishRecord);

    }

    public void insertPunishRecord(PunishRecord punishRecord) {
        this.saveObject(punishRecord);

    }
}
