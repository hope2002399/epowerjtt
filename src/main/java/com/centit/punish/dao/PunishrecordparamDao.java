package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.MonitorDaoImpl;
import com.centit.punish.po.Punishrecordparam;

public class PunishrecordparamDao extends MonitorDaoImpl<Punishrecordparam> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishrecordparamDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("orgId", " org_Id=? ");
            filterField.put("bookoperatorid", CodeBook.LIKE_HQL_ID);
            filterField.put("bookdate", CodeBook.LIKE_HQL_ID);
            filterField.put("modifydate", CodeBook.LIKE_HQL_ID);
            filterField.put("depkind", " depkind=? ");
            filterField.put("personnum", CodeBook.LIKE_HQL_ID);
            filterField.put("corpnum", CodeBook.LIKE_HQL_ID);
            filterField.put("punishClass", CodeBook.LIKE_HQL_ID);
            filterField.put("personnumBusiness", CodeBook.LIKE_HQL_ID);
            filterField.put("corpnumBusiness", CodeBook.LIKE_HQL_ID);
            filterField.put("lawbasic", CodeBook.LIKE_HQL_ID);
            filterField.put("remark", CodeBook.LIKE_HQL_ID);
            filterField.put("topunitcode", " topunitcode = ? ");
        }
        return filterField;
    }

    public List<Punishrecordparam> getpunishrecordparamList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        String shql = "  select  o from Punishrecordparam o  ,Vhiunitinfo v where o.orgId=v.depno ";
        return listObjects(shql, filterMap, pageDesc);
    }
}
