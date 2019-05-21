package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.LawExecutor;

public class LawExecutorDao extends BaseDaoImpl<LawExecutor> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawExecutorDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("staffno", CodeBook.EQUAL_HQL_ID);
            filterField.put("passcode", CodeBook.LIKE_HQL_ID);
            filterField.put("staffname", CodeBook.LIKE_HQL_ID);
            filterField.put("sex", CodeBook.LIKE_HQL_ID);
            filterField.put("nation", CodeBook.LIKE_HQL_ID);
            filterField.put("idcard", CodeBook.LIKE_HQL_ID);
            filterField.put("politics", CodeBook.LIKE_HQL_ID);
            filterField.put("education", CodeBook.LIKE_HQL_ID);
            filterField.put("deptid", CodeBook.LIKE_HQL_ID);
            filterField.put("position", CodeBook.LIKE_HQL_ID);
            filterField.put("telephone", CodeBook.LIKE_HQL_ID);
            filterField.put("plait", CodeBook.LIKE_HQL_ID);
            filterField.put("getpasstime", CodeBook.LIKE_HQL_ID);
            filterField.put("issueddept", CodeBook.LIKE_HQL_ID);
            filterField.put("executionarea", CodeBook.LIKE_HQL_ID);
            filterField.put("executionclass", CodeBook.LIKE_HQL_ID);
            filterField.put("executionjob", CodeBook.LIKE_HQL_ID);
            filterField.put("changepasstime", CodeBook.LIKE_HQL_ID);
            filterField.put("passlife", CodeBook.LIKE_HQL_ID);
            filterField.put("memo", CodeBook.LIKE_HQL_ID);
            filterField.put("inputtime", CodeBook.LIKE_HQL_ID);
            filterField.put("operator", CodeBook.LIKE_HQL_ID);
            filterField.put("status", CodeBook.LIKE_HQL_ID);
            filterField.put("repairdate", CodeBook.LIKE_HQL_ID);
            filterField.put("cardphoto", CodeBook.LIKE_HQL_ID);
            filterField.put("cardkind", CodeBook.LIKE_HQL_ID);
            filterField.put("staffstatus", CodeBook.LIKE_HQL_ID);
            filterField.put("ifRecordno", CodeBook.LIKE_HQL_ID);
            filterField.put("ifDeptcode", CodeBook.LIKE_HQL_ID);
            filterField.put("deptname", CodeBook.LIKE_HQL_ID);
            filterField.put("hasexport", CodeBook.LIKE_HQL_ID);
            filterField.put("dsource", CodeBook.LIKE_HQL_ID);
            filterField.put("reReason", CodeBook.LIKE_HQL_ID);
            filterField.put("exportDate", CodeBook.LIKE_HQL_ID);
            filterField.put("exptoweb", CodeBook.LIKE_HQL_ID);
            filterField.put("exptowebtime", CodeBook.LIKE_HQL_ID);
            filterField.put("auditIdeaCode", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }

    public String createStaffno(String deptid) {
        String shql = "LawExecutor where staffno like '" + deptid + "%'";
        String fieldName = "staffno";
        String nextKey = this.getNextKeyByHqlStrOfMax(fieldName, shql);
        if (nextKey.equals("1")) {
            int len = 20 - deptid.length() - 1;
            for (int i = 0; i < len; i++) {
                nextKey = "0" + nextKey;
            }
            nextKey = deptid + nextKey;
        }
        return nextKey;
    }

    /**
     * 根据当前登录人机构分页查询执法人员审核列表
     * 
     * @param unitcode
     * @param filterMap
     * @param pageDesc
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<LawExecutor> pageCheckList(String unitcode,
            Map<String, Object> filterMap, PageDesc pageDesc) {
        String sql = "select depno from f_unitinfo start with unitcode = '"
                + unitcode + "' connect by prior unitcode = parentunit";
        List<Object[]> list = super.findObjectsBySql(sql);
        int size = list.size();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("'" + list.get(i) + "'");
        }
        String params = sb.toString();
        String shql = " From LawExecutor where deptid in (" + params + ")";
        return super.listObjects(shql, filterMap, pageDesc);
    }

    public boolean IsPasscodeExist(String passcode) {
        if (passcode != null) {
            List<LawExecutor> procs = this
                    .listObjects("From LawExecutor where passcode =  "
                            + HQLUtils.buildHqlStringForSQL(passcode));
            if (procs != null && procs.size() >= 1)
                return true;
        }
        return false;

    }
}
