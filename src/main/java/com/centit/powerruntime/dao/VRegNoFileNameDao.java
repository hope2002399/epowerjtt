package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerruntime.po.VRegNoFileName;
import com.centit.powerruntime.po.YwFiles;

public class VRegNoFileNameDao extends BaseDaoImpl<VRegNoFileName> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VRegNoFileNameDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("sortId", CodeBook.EQUAL_HQL_ID);

            filterField.put("groupId", CodeBook.EQUAL_HQL_ID);

            filterField.put("stuffType", CodeBook.LIKE_HQL_ID);

            filterField.put("stuffName", CodeBook.LIKE_HQL_ID);

            filterField.put("isNeed", CodeBook.LIKE_HQL_ID);

            filterField.put("isElectron", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public List<YwFiles> getinfosByGroupId(String groupid) {

        String hql = "From YwFile where groupId = ? and updateType != '3'";
        return getHibernateTemplate().find(hql, groupid);
    }

}
