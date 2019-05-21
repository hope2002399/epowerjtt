package com.centit.workflow.sample.action;

import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.sys.security.FUserDetail;
import com.centit.workflow.FlowRoleRelegate;
import com.centit.workflow.sample.po.WfRoleRelegate;

public class SampleFlowRelegateAction extends
        BaseEntityExtremeAction<WfRoleRelegate> {
    private static final long serialVersionUID = 1L;
    private FlowRoleRelegate flowRoleRelegate;
    private String grant;

    @SuppressWarnings("unchecked")
    public String list() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);

        if (filterMap.get("grant") != null) {
            if (filterMap.get("grant").equals("F")) {
                filterMap.remove("grantor");
                filterMap.remove("grantee");
                filterMap.put("grantee",
                        ((FUserDetail) getLoginUser()).getUsercode());
            }
            if (filterMap.get("grant").equals("T")) {
                filterMap.put("grantor",
                        ((FUserDetail) getLoginUser()).getUsercode());
            }
        }

        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        objList = flowRoleRelegate.listRoleRelegate(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return LIST;
    }

    public String save() {
        try {
            WfRoleRelegate wfRole = flowRoleRelegate.getObject(object);
            object.setIsvalid("T");
            if (wfRole != null) {
                wfRole.copyNotNullProperty(object);
                object = wfRole;
            }
            object.setRecorder(((FUserDetail) getLoginUser()).getUsercode());
            flowRoleRelegate.saveRoleRelegate(object);
            savedMessage();
            return "RefreshList";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    public String built() {
        return EDIT;
    }

    public String edit() {
        object = flowRoleRelegate.getObjectById(object.getRelegateno());
        return EDIT;
    }

    public String delete() {
        flowRoleRelegate.deleteRoleRelegate(object.getRelegateno());
        return "RefreshList";
    }

    public FlowRoleRelegate getFlowRoleRelegate() {
        return flowRoleRelegate;
    }

    public void setFlowRoleRelegate(FlowRoleRelegate flowRoleRelegate) {
        this.flowRoleRelegate = flowRoleRelegate;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }

}
