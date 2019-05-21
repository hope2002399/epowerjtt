package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.workflow.sample.po.VUserTaskList;

public class VUserTasksDao extends BaseDaoImpl<VUserTaskList> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("nodeInstId", CodeBook.EQUAL_HQL_ID);

            filterField.put("flowInstId", CodeBook.LIKE_HQL_ID);

            filterField.put("wfOptName", CodeBook.LIKE_HQL_ID);

            filterField.put("wfOptTag", CodeBook.LIKE_HQL_ID);

            filterField.put("userCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("roleType", CodeBook.LIKE_HQL_ID);

            filterField.put("roleCode", CodeBook.LIKE_HQL_ID);

            filterField.put("authDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeName", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeType", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeOptType", CodeBook.LIKE_HQL_ID);

            filterField.put("optName", CodeBook.LIKE_HQL_ID);

            filterField.put("methodName", CodeBook.LIKE_HQL_ID);

            filterField.put("optUrl", CodeBook.LIKE_HQL_ID);

            filterField.put("optMethod", CodeBook.LIKE_HQL_ID);

            filterField.put("optDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("optCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("inststate", CodeBook.LIKE_HQL_ID);

            filterField.put("flowPhase", CodeBook.LIKE_HQL_ID);

            filterField.put("noGrantor",
                    "1 = to_number(?) and grantor is null ");

            filterField.put("grantor",
                    "1 = to_number(?) and grantor is not null ");

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "nodeCreateTime desc");

        }
        return filterField;
    }

    public List<VUserTaskList> listDashboardTasks(Map<String, Object> filterMap) {
        return this.listObjects(filterMap);
    }

    public List<VUserTaskList> listTasksByUser(String userCode) {
        return this.listObjects("from VUserTaskList where userCode = ? ",
                userCode);
    }

    @SuppressWarnings("unchecked")
    public List<VUserTaskList> listTasksByRoleCode(String roleCode) {
        String baseSQL = "select *  FROM V_USER_TASK_LIST t2 WHERE t2.ROLECODE ='"
                + roleCode
                + "'and (t2.nodeinstid,t2.usercode) in (select nodeinstid,max(usercode) from v_inner_user_task_list where ROLECODE ='"
                + roleCode + "' group by nodeinstid) order by t2.swhtime desc";
        return (List<VUserTaskList>) super.findObjectsBySql(baseSQL,
                VUserTaskList.class);
    }

    /**
     * 获取当前任务中的节点信息
     * 
     * @param nodeInstId
     * @return
     */
    public VUserTaskList getNodeInfoByInstID(Long nodeInstId) {

        return this.listObjects("from VUserTaskList where cid.nodeInstId = ? ",
                nodeInstId).get(0);
    }

    @SuppressWarnings("unchecked")
    public List<VUserTaskList> listZWHTasks(String userCode, String flowPhase,
            Map<String, String> filterMap) {
        String sql = "select t.* from V_USER_TASK_LIST t join QLYX_LCDJ t1 on(t.WFINSTID=t1.flowid)"
                + " join qlyx_nw_result t2 on (t1.djid = t2.dj_id)"
                + " join zwhqx t3 on(t.usercode=t3.usercode and t2.wjlx=t3.datacode)"
                + " where t.usercode = "
                + HQLUtils.buildHqlStringForSQL(userCode)
                + " and t.flowphase = "
                + HQLUtils.buildHqlStringForSQL(flowPhase);

        if (!StringUtils.isBlank(filterMap.get("wfOptTag"))) {
            sql += " and t.wfOptTag like '%" + filterMap.get("wfOptTag") + "%'";
        }

        if (!StringUtils.isBlank(filterMap.get("wfOptName"))) {
            sql += " and t.wfOptName like '%" + filterMap.get("wfOptName")
                    + "%'";
        }

        if (!StringUtils.isBlank(filterMap.get("sbdw"))) {
            sql += " and t.sbdw like '%" + filterMap.get("sbdw") + "%'";
        }

        if (!StringUtils.isBlank(filterMap.get("ywcs"))) {
            sql += " and t.ywcs = '" + filterMap.get("ywcs") + "'";
        }
        sql += " order by createtime desc";

        return (List<VUserTaskList>) super.findObjectsBySql(sql,
                VUserTaskList.class);
    }

    /**
     * 盖章任务
     * 
     * @param userCode
     * @param flowPhase
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<VUserTaskList> listGZTasks(String userCode, String flowPhase,
            Map<String, String> filterMap) {
        String sql = "select t.* from V_USER_TASK_LIST t join QLYX_LCDJ t1 on(t.WFINSTID=t1.flowid)"
                + " join qlyx_nw_result t2 on (t1.djid = t2.dj_id)"
                + " join gzqx t3 on(t.usercode=t3.usercode and t2.wjlx=t3.datacode)"
                + " where t.usercode = "
                + HQLUtils.buildHqlStringForSQL(userCode)
                + " and t.flowphase = "
                + HQLUtils.buildHqlStringForSQL(flowPhase);

        if (!StringUtils.isBlank(filterMap.get("wfOptTag"))) {
            sql += " and t.wfOptTag like '%" + filterMap.get("wfOptTag") + "%'";
        }

        if (!StringUtils.isBlank(filterMap.get("wfOptName"))) {
            sql += " and t.wfOptName like '%" + filterMap.get("wfOptName")
                    + "%'";
        }

        if (!StringUtils.isBlank(filterMap.get("sbdw"))) {
            sql += " and t.sbdw like '%" + filterMap.get("sbdw") + "%'";
        }

        if (!StringUtils.isBlank(filterMap.get("ywcs"))) {
            sql += " and t.ywcs = '" + filterMap.get("ywcs") + "'";
        }

        sql += " order by createtime desc ";
        return (List<VUserTaskList>) super.findObjectsBySql(sql,
                VUserTaskList.class);
    }

    /**
     * 盖章任务
     * 
     * @param userCode
     * @param flowPhase
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<VUserTaskList> listTasksWithFilter(String userCode,
            String flowPhase, Map<String, String> filterMap) {
        String sql = "select t.* from V_USER_TASK_LIST t join QLYX_LCDJ t1 on(t.WFINSTID=t1.flowid)"
                + " join qlyx_nw_result t2 on (t1.djid = t2.dj_id)"
                + " join USER_TASK_FILTER t3 on(t.usercode=t3.usercode and t2.wjlx=t3.datacode and t3.flowphase = "
                + HQLUtils.buildHqlStringForSQL(flowPhase)
                + ")"
                + " where t.usercode = "
                + HQLUtils.buildHqlStringForSQL(userCode)
                + " and t.flowphase = "
                + HQLUtils.buildHqlStringForSQL(flowPhase);

        if (!StringUtils.isBlank(filterMap.get("wfOptTag"))) {
            sql += " and t.wfOptTag like '%" + filterMap.get("wfOptTag") + "%'";
        }

        if (!StringUtils.isBlank(filterMap.get("wfOptName"))) {
            sql += " and t.wfOptName like '%" + filterMap.get("wfOptName")
                    + "%'";
        }

        if (!StringUtils.isBlank(filterMap.get("sbdw"))) {
            sql += " and t.sbdw like '%" + filterMap.get("sbdw") + "%'";
        }

        if (!StringUtils.isBlank(filterMap.get("ywcs"))) {
            sql += " and t.ywcs = '" + filterMap.get("ywcs") + "'";
        }

        sql += " order by createtime desc ";
        return (List<VUserTaskList>) super.findObjectsBySql(sql,
                VUserTaskList.class);
    }
}
