package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Poenterprise;

public class PoenterpriseDao extends BaseDaoImpl<Poenterprise> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoenterpriseDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("enterpriseid", CodeBook.EQUAL_HQL_ID);

            filterField.put("enterprisename", CodeBook.LIKE_HQL_ID);

            filterField.put("enterprisecode", CodeBook.LIKE_HQL_ID);

            filterField.put("enterpriseaddress", CodeBook.LIKE_HQL_ID);

            filterField.put("unittype", CodeBook.LIKE_HQL_ID);

            filterField.put("corpdomain", CodeBook.LIKE_HQL_ID);

            filterField.put("regtype", CodeBook.LIKE_HQL_ID);

            filterField.put("mastername", CodeBook.LIKE_HQL_ID);

            filterField.put("postcode", CodeBook.LIKE_HQL_ID);

            filterField.put("phone", CodeBook.LIKE_HQL_ID);

            filterField.put("linker", CodeBook.LIKE_HQL_ID);

            filterField.put("fax", CodeBook.LIKE_HQL_ID);

            filterField.put("email", CodeBook.LIKE_HQL_ID);

            filterField.put("isvip", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public String genNextEnterpriseId() {
        return getNextKeyBySequence("S_ENTERPRISEID", 10);
    }

    public Poenterprise getPoenterprise(String punishobjectid) {
        String hql = "from Poenterprise where cid.punishobjectid = ?";
        @SuppressWarnings("unchecked")
        List<Poenterprise> list = (List<Poenterprise>) this.findObjectsByHql(
                hql, punishobjectid);
        return list.get(0);
    }
}
