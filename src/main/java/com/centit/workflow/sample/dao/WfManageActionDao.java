package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfManageAction;

public class WfManageActionDao extends BaseDaoImpl<WfManageAction> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("actionid", CodeBook.EQUAL_HQL_ID);

            filterField.put("wfinstid", CodeBook.LIKE_HQL_ID);

            filterField.put("actiontype", CodeBook.LIKE_HQL_ID);

            filterField.put("actiontime", CodeBook.LIKE_HQL_ID);

            filterField.put("usercode", CodeBook.LIKE_HQL_ID);

            filterField.put("roletype", CodeBook.LIKE_HQL_ID);

            filterField.put("rolecode", CodeBook.LIKE_HQL_ID);

            filterField.put("admindesc", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    /**
     * 生成主键编号
     * 
     * @return
     */
    public long getNextManageId() {
        String sNo = getNextValueOfSequence("S_MANAGERACTIONNO");
        return Long.valueOf(sNo);
    }

    /**
     * 查询流程管理日志信息
     * 
     * @param wfinstid
     * @return
     */
    public List<WfManageAction> getFlowManageLogs(long wfinstid) {
        String hql = "from WfManageAction where wfinstid = " + wfinstid
                + " order by actiontime desc";
        return this.listObjects(hql);
    }
}
