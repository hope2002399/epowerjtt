package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.MonitorDaoImpl;
import com.centit.powerbase.po.Lawmen;

public class LawmenDao extends MonitorDaoImpl<Lawmen> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawmenDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("lawmenId", CodeBook.EQUAL_HQL_ID);
            filterField.put("userId", "user_id=? ");
            filterField.put("updateType", "update_type=? ");
            filterField.put("deptcode", " deptcode=? ");
            filterField.put("userName", " user_name=? ");
            filterField.put("nation", CodeBook.LIKE_HQL_ID);
            filterField.put("birth", CodeBook.LIKE_HQL_ID);
            filterField.put("sex", CodeBook.LIKE_HQL_ID);
            filterField.put("politicalLandscape", CodeBook.LIKE_HQL_ID);
            filterField.put("education", CodeBook.LIKE_HQL_ID);
            filterField.put("tel", CodeBook.LIKE_HQL_ID);
            filterField.put("position", "position=? ");
            filterField.put("organization", CodeBook.LIKE_HQL_ID);
            filterField.put("state", CodeBook.LIKE_HQL_ID);
            filterField.put("usercode", CodeBook.LIKE_HQL_ID);
            filterField.put("changeDate", CodeBook.LIKE_HQL_ID);
            filterField.put("recoder", CodeBook.LIKE_HQL_ID);
            filterField.put("recodDate", CodeBook.LIKE_HQL_ID);
            filterField.put("auditor", CodeBook.LIKE_HQL_ID);
            filterField.put("auditDate", CodeBook.LIKE_HQL_ID);
            filterField.put("datesource", CodeBook.LIKE_HQL_ID);
            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);
            filterField.put("auditDate", CodeBook.LIKE_HQL_ID);
            filterField.put("giveCertOrgan", CodeBook.LIKE_HQL_ID);
            filterField.put("legalRange", CodeBook.LIKE_HQL_ID);
            filterField.put("legalArea", CodeBook.LIKE_HQL_ID);
            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);
            filterField.put("errorDesc", CodeBook.LIKE_HQL_ID);
            filterField.put("topunitcode", " topunitcode = ? ");
            filterField
                    .put("annualDate",
                            "  ( annual_date is null  or annual_date <= to_date(?, 'yyyy') )");
        }
        return filterField;
    }

    /**
     * 获取下一个执行人员编码
     * 
     * @return
     */
    public String genNextChangeId() {
        String no = getNextKeyBySequence("S_lawmenId", 10);
        String no_temp = "0";
        for (int i = 0; i < 7 - no.length(); i++) {
            no_temp += "0";
        }
        no_temp += no;
        return no_temp;
    }

    /**
     * 获取下一个年检编码
     * 
     * @return
     */
    public String genNextAnnualId() {
        String no = getNextKeyBySequence("S_lawmenannualId", 10);
        String no_temp = "0";
        for (int i = 0; i < 7 - no.length(); i++) {
            no_temp += "0";
        }
        no_temp += no;
        return no_temp;
    }

    // 执行人员管理获取list
    public List<Lawmen> lawmenManagementList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " select o from Lawmen o ,Vhiunitinfo v where o.deptcode=v.depno ";
        return listObjects(shql, filterMap, pageDesc);
    }

    // 获取具体执法人员信息
    public Lawmen getLawmenByUseridNo(String userId, String lawmenId) {
        List<Lawmen> procs = this.listObjects("From Lawmen where user_id =  "
                + HQLUtils.buildHqlStringForSQL(userId) + " and lawmen_id="
                + HQLUtils.buildHqlStringForSQL(lawmenId));
        if (procs != null && procs.size() >= 1) {
            return procs.get(0);
        } else {
            return null;
        }
    }

    // 获取具体执法人员信息
    public Lawmen getLawmenByLawmenId(String lawmenId) {
        List<Lawmen> procs = this.listObjects("From Lawmen where lawmenId =  "
                + HQLUtils.buildHqlStringForSQL(lawmenId));
        if (procs != null && procs.size() >= 1) {
            return procs.get(0);
        } else {
            return null;
        }
    }
}
