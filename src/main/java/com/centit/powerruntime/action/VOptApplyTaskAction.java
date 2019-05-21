package com.centit.powerruntime.action;

import java.net.URLDecoder;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.VOptApplyTaskList;
import com.centit.powerruntime.service.VOptApplyTaskManager;
import com.centit.sys.security.FUserDetail;

public class VOptApplyTaskAction extends
        BaseEntityExtremeAction<VOptApplyTaskList> {

    private static final long serialVersionUID = 1L;
    private VOptApplyTaskManager vOptApplyTaskManager;

    public void setVOptApplyTaskManager(
            VOptApplyTaskManager vOptApplyTaskManager) {
        this.vOptApplyTaskManager = vOptApplyTaskManager;
        setBaseEntityManager(vOptApplyTaskManager);
    }

    
    /**
     * 办件处理查询列表
     */
    public String list() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            String userCode = fuser.getUsercode();
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            filterMap.put("userCode", userCode);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            objList = vOptApplyTaskManager.listObjects(filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String selectlist() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            String userCode = fuser.getUsercode();
            @SuppressWarnings("unchecked")
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            filterMap.put("userCode", userCode);
            objList = vOptApplyTaskManager.getEmsOptApplyList(filterMap);
            if (request.getParameter("showmore") != null
                    && request.getParameter("showmore") != "") {
                String showmores = URLDecoder.decode(
                        request.getParameter("showmore"), "UTF-8");
                request.setAttribute("showmore", showmores);
                request.setAttribute("bjnumber",
                        request.getParameter("bjnumber"));
                String[] bjnumbers = request.getParameter("bjnumber")
                        .split(",");
                String openid = "";
                if (objList != null && objList.size() > 0) {
                    for (int i = 0; i < objList.size(); i++) {
                        if (bjnumbers != null & bjnumbers.length > 0) {
                            for (int j = 0; j < bjnumbers.length; j++) {
                                if (objList.get(i).getDjId()
                                        .equals(bjnumbers[j])) {
                                    objList.get(i).setIsChecked("1");// 表明被選中的
                                    openid += objList.get(i).getDjId() + ",";
                                    break;
                                }
                            }
                        }
                    }
                }
                request.setAttribute("openid",
                        openid.substring(0, openid.length() - 1));
            }
            return "selectlist";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
