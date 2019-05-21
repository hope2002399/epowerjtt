package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.MonitorDaoImpl;
import com.centit.supervise.po.SupInfoBasicDlfx;

public class SupInfoBasicDlfxDao extends MonitorDaoImpl<SupInfoBasicDlfx> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SupInfoBasicDlfxDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("superviseCode", " superviseCode = ? ");
            filterField.put("dealStep", " dealStep = ? ");
            filterField.put("orgId", "org_id=?");
            filterField.put("supervisionYear", "supervisionYear=?");
            filterField.put("supervisionMonth", "supervisionMonth=?");
            filterField.put("no", "no=?");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, "superviseCode desc");
        }
        return filterField;
    }

    public List<SupInfoBasicDlfx> getSupInfoBasicDlfxList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        String shql = " select o from SupInfoBasicDlfx o where 1=1 ";
        return listObjects(shql, filterMap, pageDesc);
    }

    public void UpdateSupInfoBasicDlfxJl(SupInfoBasicDlfx info) {
        doExecuteHql(
                "update SupInfoBasicDlfx set endOperatorId=? ,endDate=?,superviseResult=?,isExternal=?,dealStep=? where superviseCode =?  ",
                new Object[] { info.getEndOperatorId(), info.getEndDate(),
                        info.getSuperviseResult(), info.getIsExternal(),
                        info.getDealStep(), info.getSuperviseCode() });
    }

    public void UpdateSupInfoBasicDlfxFk(SupInfoBasicDlfx info) {
        doExecuteHql(
                "update SupInfoBasicDlfx set backOperatorName=? ,receiptDate=?,superviseBack=?,dealStep=? where superviseCode =?  ",
                new Object[] { info.getBackOperatorName(),
                        info.getReceiptDate(), info.getSuperviseBack(),
                        info.getDealStep(), info.getSuperviseCode() });
    }
}
