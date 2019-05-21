package com.centit.monitor.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Supervisorypersonnel;

public class SupervisorypersonnelDao extends
        MonitorDaoImpl<Supervisorypersonnel> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(SupervisorypersonnelDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("userId", CodeBook.LIKE_HQL_ID);

            filterField.put("updateType", " update_type=? ");

            filterField.put("userName", CodeBook.LIKE_HQL_ID);

            filterField.put("deptcode", " deptcode=? ");

            filterField.put("birth", CodeBook.LIKE_HQL_ID);

            filterField.put("sex", CodeBook.LIKE_HQL_ID);

            filterField.put("politicalLandscape", CodeBook.LIKE_HQL_ID);

            filterField.put("education", CodeBook.LIKE_HQL_ID);

            filterField.put("tel", CodeBook.LIKE_HQL_ID);

            filterField.put("position", CodeBook.LIKE_HQL_ID);

            filterField.put("organization", CodeBook.LIKE_HQL_ID);

            filterField.put("changeDate", CodeBook.LIKE_HQL_ID);

            filterField.put("recoder", CodeBook.LIKE_HQL_ID);

            filterField.put("recodDate", CodeBook.LIKE_HQL_ID);

            filterField.put("auditor", CodeBook.LIKE_HQL_ID);

            filterField.put("auditDate", CodeBook.LIKE_HQL_ID);

            filterField.put("datesource", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("readDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("errorDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("NP_stateSB", " state='0' ");
            filterField.put("NP_stateSH", " (state='1' or state ='2') ");
            filterField.put("state", CodeBook.EQUAL_HQL_ID);
            filterField.put("auditReason", CodeBook.LIKE_HQL_ID);
            filterField.put("topunitcode", " topunitcode = ? ");
            filterField.put("depIndustry", " dep_Industry =? ");
            filterField.put("sysId", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    /**
     * 获取监察人员下一个编码
     * 
     * @return
     */
    public String genNextChangeId() {
        String no = getNextKeyBySequence("S_NO", 10);
        String no_temp = "0";
        for (int i = 0; i < 7 - no.length(); i++) {
            no_temp += "0";
        }
        no_temp += no;
        return no_temp;
    }

    /**
     * 根据不同选择获取检查人员list
     * 
     * @param flag
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<Supervisorypersonnel> GetSupervisorypersonnelList(String flag,
            Map<String, Object> filterMap, PageDesc pageDesc) {
        String shql = "select o from Supervisorypersonnel o ,Vhiunitinfo v where o.deptcode=v.depno ";
        return listObjects(shql, filterMap, pageDesc);
    }

    public Supervisorypersonnel getSpByUseridNo(String userId, String no) {
        List<Supervisorypersonnel> procs = this
                .listObjects("From Supervisorypersonnel where user_id =  "
                        + HQLUtils.buildHqlStringForSQL(userId) + " and no="
                        + HQLUtils.buildHqlStringForSQL(no));
        if (procs != null && procs.size() >= 1) {
            return procs.get(0);
        } else {
            return null;
        }
    }

    public Supervisorypersonnel getSpByUserNameBirth(String userName, Date birth) {
        List<Supervisorypersonnel> procs = this
                .listObjects("From Supervisorypersonnel where user_Name =  "
                        + HQLUtils.buildHqlStringForSQL(userName)
                        + " and birth=" + (birth));
        if (procs != null && procs.size() >= 1) {
            return procs.get(0);
        } else {
            return null;
        }
    }
}
