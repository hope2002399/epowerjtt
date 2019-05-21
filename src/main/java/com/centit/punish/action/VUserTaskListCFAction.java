package com.centit.punish.action;

import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.VUserTaskListCF;
import com.centit.punish.service.VUserTaskListCFManager;
import com.centit.sys.security.FUserDetail;

public class VUserTaskListCFAction extends
        BaseEntityExtremeAction<VUserTaskListCF> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // private VUserTaskListCFManager userTaskListCFManager;
    public void setUserTaskListCFManager(
            VUserTaskListCFManager userTaskListCFManager) {
        // this.userTaskListCFManager = userTaskListCFManager;
        this.setBaseEntityManager(userTaskListCFManager);
    }

    public String list() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            filterMap.put("userCode", fuser.getUsercode());
            objList = baseEntityManager.listObjects(filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
