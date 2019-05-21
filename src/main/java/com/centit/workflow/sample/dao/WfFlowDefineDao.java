package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.core.dao.HqlAndParams;
import com.centit.workflow.sample.po.WfFlowDefine;
import com.centit.workflow.sample.po.WfFlowDefineId;

public class WfFlowDefineDao extends BaseDaoImpl<WfFlowDefine> {
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("flowCode", "cid.flowCode=?");

            filterField.put("version", "cid.version=?");

            filterField.put("wfName", CodeBook.LIKE_HQL_ID);

            filterField.put("flowName", CodeBook.LIKE_HQL_ID);

            filterField.put("flowState", CodeBook.LIKE_HQL_ID);

            filterField.put("flwoDesc", CodeBook.LIKE_HQL_ID);
            filterField.put("optId", CodeBook.EQUAL_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "WFCODE");

        }
        return filterField;
    }

    public long getLastVersion(String flowCode) {
        String hql;
        // "SELECT max(cast(version as long)) FROM WfFlowDefine WHERE WFCODE = "
        hql = "SELECT max(cast(cid.version as long)) FROM WfFlowDefine WHERE cid.flowCode = "
                + HQLUtils.buildHqlStringForSQL(flowCode);
        return getSingleIntByHql(hql);
    }

    public long getNextNodeId() {
        String sNo = getNextValueOfSequence("S_FLOWDEFNO");
        return Long.valueOf(sNo);
    }

    public long getNextTransId() {
        String sNo = getNextValueOfSequence("S_FLOWDEFNO");
        return Long.valueOf(sNo);
    }

    public long getNextStageId() {
        String sNo = getNextValueOfSequence("S_FLOWDEFNO");
        return Long.valueOf(sNo);
    }

    @SuppressWarnings("unchecked")
    public List<WfFlowDefine> getAllLastVertionFlows(
            Map<String, Object> filterMap) {

        String sql = "SELECT * FROM F_V_LASTVERTIONFLOW WHERE 1=1 ";
        HqlAndParams sqlAndParams = builderHqlAndParams(sql, filterMap);
        return (List<WfFlowDefine>) this.findObjectsBySql(
                sqlAndParams.getHql(), sqlAndParams.getParams(),
                WfFlowDefine.class);
    }

    public List<WfFlowDefine> getAllVersionFlowsByCode(String wfCode) {
        String hql = "from WfFlowDefine where wfcode = "
                + HQLUtils.buildHqlStringForSQL(wfCode)
                + " order by version desc";
        return this.listObjects(hql);
    }

    public WfFlowDefine getLastVersionFlowByCode(String flowCode) {
        long lVer = getLastVersion(flowCode);
        return this.getObjectById(new WfFlowDefineId(lVer, flowCode));
    }

    public WfFlowDefine getFlowDefineByID(String flowCode, Long version) {
        return this.getObjectById(new WfFlowDefineId(version, flowCode));
    }

    @SuppressWarnings("unchecked")
    public List<WfFlowDefine> getFlowsByState(String wfstate) {
        String sql = "SELECT * FROM F_V_LASTVERTIONFLOW WHERE WFSTATE ="
                + HQLUtils.buildHqlStringForSQL(wfstate) + "ORDER BY VERSION";

        return (List<WfFlowDefine>) this.findObjectsBySql(sql,
                WfFlowDefine.class);
    }

    public String getNextPrimarykey() {
        return getNextKeyBySequence("S_FLOWDEFINE", 6);
    }

    /*
     * public void saveObject(WfFlowDefine objDef){ Set<WfFlowStage> stages =
     * objDef.getWfFlowStages(); for(WfFlowStage stage : stages){ if(stage!=null
     * && (stage.getStageId()==null || stage.getStageId().equals(0))){
     * stage.setStageId( getNextStageId()); } } super.saveObject(objDef); }
     */
}
