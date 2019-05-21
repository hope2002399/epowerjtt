/**
 * 
 */
package com.centit.app.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.extremecomponents.table.limit.Limit;

import com.centit.app.po.Innermsg;
import com.centit.app.service.InnermsgManager;
import com.centit.core.action.BaseAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.VOptApplyTaskList;
import com.centit.powerruntime.po.VProcAttention;
import com.centit.powerruntime.service.OptProcAttentionManager;
import com.centit.powerruntime.service.VOptApplyTaskManager;
import com.centit.punish.po.VUserTaskListCF;
import com.centit.punish.service.VUserTaskListCFManager;
import com.centit.sys.po.MyHome;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.UserSettingManager;
import com.opensymphony.xwork2.ActionContext;

public class DashboardAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    private InnermsgManager innermsgManager;
    private UserSettingManager userSettingMgr;
    private List<Innermsg> msgList;
    private List<MyHome> myHomeList;
    private String sysType;
    private VOptApplyTaskManager vOptApplyTaskManager;
    private OptProcAttentionManager optProcAttentionManager;
    private List<VOptApplyTaskList> xkdbList;
    private List<VProcAttention> attList;
    private VUserTaskListCFManager userTaskListCFManager;
    private List<VUserTaskListCF> cfdbList;

    public String show() throws Exception {
        FUserDetail uinfo = (FUserDetail) getLoginUser();
        myHomeList = userSettingMgr.queryMyHomeByUsercode(uinfo.getUsercode());
        JSONArray data = new JSONArray();
        data.addAll(myHomeList);
        request.setAttribute("data", data);

        List<Innermsg> myMsgList = innermsgManager.listMyMsgs(uinfo
                .getUsercode());
        if (myMsgList != null) {
            msgList = (myMsgList.size() > 5 ? myMsgList.subList(0, 4)
                    : myMsgList);
        }
        Map<String, Object> session = ActionContext.getContext().getSession();
        sysType = (String) session.get("sysType");
        if ("XZXK".equals(sysType)) {// 许可审批系统
            this.qxXZXK_dashboard();
        } else if ("XZCF".equals(sysType)) {// 行政处罚
            this.qxXZCF_dashboard();
        } else if ("Qlyx".equals(sysType) || "FZJD".equals(sysType)) {
            // 权力库、 法制监督系统
            this.qxQlyxAndFZJD_dashboard();
        } else if ("DZJC".equals(sysType)) {// 电子监察系统
            this.qxDZJC_dashboard();
        }
        return "dashboard";
    }

    private void qxDZJC_dashboard() {
    }

    private void qxQlyxAndFZJD_dashboard() {
    }

    /**
     * 行政处罚
     */
    @SuppressWarnings("unchecked")
    private void qxXZCF_dashboard() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);

        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        filterMap.put("userCode", fuser.getUsercode());
        cfdbList = (List<VUserTaskListCF>) getSubList(userTaskListCFManager
                .listObjects(filterMap, pageDesc));
    }

    /**
     * 许可审批系统
     */
    @SuppressWarnings("unchecked")
    public void qxXZXK_dashboard() {
        
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        String userCode = fuser.getUsercode();
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put("userCode", userCode);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        // 许可待办
        xkdbList = (List<VOptApplyTaskList>) getSubList(vOptApplyTaskManager
                .listObjects(filterMap, pageDesc));
        // 关注办件
        attList = (List<VProcAttention>) getSubList(optProcAttentionManager
                .listProcAttention(filterMap, pageDesc));

    }

    /**
     * 截取LIST前N条数据
     * 
     * @param objList
     *            列表对象
     * @param dataLen
     *            数据条数
     * @return
     */
    private List<?> getSubList(List<?> objList) {
        int dataLen = 6;
        objList = (objList != null && objList.size() > dataLen ? objList
                .subList(0, dataLen - 1) : objList);
        return objList;
    }

    public InnermsgManager getInnermsgManager() {
        return innermsgManager;
    }

    public void setInnermsgManager(InnermsgManager innermsgManager) {
        this.innermsgManager = innermsgManager;
    }

    public List<Innermsg> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Innermsg> msgList) {
        this.msgList = msgList;
    }

    public UserSettingManager getUserSettingMgr() {
        return userSettingMgr;
    }

    public void setUserSettingMgr(UserSettingManager userSettingMgr) {
        this.userSettingMgr = userSettingMgr;
    }

    public List<MyHome> getMyHomeList() {
        return myHomeList;
    }

    public void setMyHomeList(List<MyHome> myHomeList) {
        this.myHomeList = myHomeList;
    }

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    public List<VOptApplyTaskList> getXkdbList() {
        return xkdbList;
    }

    public void setXkdbList(List<VOptApplyTaskList> xkdbList) {
        this.xkdbList = xkdbList;
    }

    public List<VProcAttention> getAttList() {
        return attList;
    }

    public void setAttList(List<VProcAttention> attList) {
        this.attList = attList;
    }

    public void setOptProcAttentionManager(
            OptProcAttentionManager optProcAttentionManager) {
        this.optProcAttentionManager = optProcAttentionManager;
    }

    public List<VUserTaskListCF> getCfdbList() {
        return cfdbList;
    }

    public void setCfdbList(List<VUserTaskListCF> cfdbList) {
        this.cfdbList = cfdbList;
    }

    public void setUserTaskListCFManager(
            VUserTaskListCFManager userTaskListCFManager) {
        this.userTaskListCFManager = userTaskListCFManager;
    }

    public void setvOptApplyTaskManager(
            VOptApplyTaskManager vOptApplyTaskManager) {
        this.vOptApplyTaskManager = vOptApplyTaskManager;
    }

}
