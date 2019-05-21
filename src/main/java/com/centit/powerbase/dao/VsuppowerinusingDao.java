package com.centit.powerbase.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerbase.po.Vsuppowerinusing;

public class VsuppowerinusingDao extends BaseDaoImpl<Vsuppowerinusing> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VsuppowerinusingDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("item_id", CodeBook.LIKE_HQL_ID);

            filterField.put("version", CodeBook.EQUAL_HQL_ID);

            filterField.put("beginTime", CodeBook.LIKE_HQL_ID);

            filterField.put("endTime", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);

            filterField.put("itemName", CodeBook.LIKE_HQL_ID);

            filterField.put("itemStaName", CodeBook.LIKE_HQL_ID);

            filterField.put("itemType", CodeBook.EQUAL_HQL_ID);

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

        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public Vsuppowerinusing findB_PowerByItemId(String itemId) {
        List<Vsuppowerinusing> l = new ArrayList<Vsuppowerinusing>();
        String hql = "from Vsuppowerinusing where cid.itemId = ?";
        l = (List<Vsuppowerinusing>) this.findObjectsByHql(hql, itemId);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return new Vsuppowerinusing();
        }
    }
}
