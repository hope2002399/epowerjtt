package com.centit.workflow.sample.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.workflow.sample.po.WfActionLog;

/**
 * 
 * 流程日志操作类
 * 
 * @author ljy, codefan
 * @version $Rev$ <br>
 *          $Id$
 */
public class WfActionLogDao extends BaseDaoImpl<WfActionLog> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("actionid", CodeBook.EQUAL_HQL_ID);

            filterField.put("nodeinstid", CodeBook.LIKE_HQL_ID);

            filterField.put("actiontype", CodeBook.LIKE_HQL_ID);

            filterField.put("actiontime", CodeBook.LIKE_HQL_ID);

            filterField.put("usercode", CodeBook.LIKE_HQL_ID);

            filterField.put("roletype", CodeBook.LIKE_HQL_ID);

            filterField.put("rolecode", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public List<WfActionLog> listUserActionLogs(String userCode,
            PageDesc pageDesc, Date lastTime) {
        if (lastTime == null)
            return listObjects(
                    "From WfActionLog where usercode=? order by actiontime desc",
                    new Object[] { userCode }, pageDesc);
        else
            return listObjects(
                    "From WfActionLog where usercode=? and actiontime >= ? order by  actiontime desc",
                    new Object[] { userCode, lastTime }, pageDesc);

    }

    /**
     * 查询受委托的工作记录
     * 
     * @param userCode
     * @param pageDesc
     * @return
     */
    public List<WfActionLog> listGrantedActionLog(String userCode,
            PageDesc pageDesc) {
        return listObjects(
                "from WfActionLog where usercode=? and  grantor <> null",
                userCode, pageDesc);
    }

    /**
     * 查询委托别人做的工作记录
     * 
     * @param userCode
     * @param pageDesc
     * @return
     */
    public List<WfActionLog> listGrantorActionLog(String userCode,
            PageDesc pageDesc) {
        return listObjects("from WfActionLog where grantor = ?", userCode,
                pageDesc);
    }

    /**
     * 生成流程日志操作编号
     * 
     * @return long
     */
    public long getNextActionId() {
        String sNo = getNextValueOfSequence("S_ACTIONLOGNO");
        return Long.valueOf(sNo);
    }
}
