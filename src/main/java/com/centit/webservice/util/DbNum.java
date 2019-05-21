package com.centit.webservice.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.centit.powerruntime.service.OptApplyNetManager;
import com.centit.powerruntime.service.VOptApplyTaskManager;
import com.centit.punish.service.VUserTaskListCFManager;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUserManager;

public class DbNum {
    private SysUserManager sysUserManager;
    private VOptApplyTaskManager vOptApplyTaskManager;
    private VUserTaskListCFManager userTaskListCFManager;
    private OptApplyNetManager optApplyNetManager;
    private static WebApplicationContext ctx = ContextLoaderListener
            .getCurrentWebApplicationContext();

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public VOptApplyTaskManager getvOptApplyTaskManager() {
        return vOptApplyTaskManager;
    }

    public void setvOptApplyTaskManager(
            VOptApplyTaskManager vOptApplyTaskManager) {
        this.vOptApplyTaskManager = vOptApplyTaskManager;
    }

    public VUserTaskListCFManager getUserTaskListCFManager() {
        return userTaskListCFManager;
    }

    public void setUserTaskListCFManager(
            VUserTaskListCFManager userTaskListCFManager) {
        this.userTaskListCFManager = userTaskListCFManager;
    }

    public void setOptApplyNetManager(OptApplyNetManager optApplyNetManager) {
        this.optApplyNetManager = optApplyNetManager;
    }

    public String sendDBS(String loginname) {
        if (null == sysUserManager)
            sysUserManager = ctx
                    .getBean("sysUserManager", SysUserManager.class);
        FUserDetail sysuser = sysUserManager.loadUserByUsername(loginname);
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("userCode", sysuser.getUsercode());
        if (null == vOptApplyTaskManager)
            vOptApplyTaskManager = ctx.getBean("vOptApplyTaskManager",
                    VOptApplyTaskManager.class);
        int xknum = 0;
        try {
            xknum = vOptApplyTaskManager.listObjects(filterMap).size();
        } catch (Exception d) {

        }
        if (null == userTaskListCFManager)
            userTaskListCFManager = ctx.getBean("userTaskListCFManager",
                    VUserTaskListCFManager.class);
        int cfnum = 0;
        try {
            cfnum = userTaskListCFManager.listObjects(filterMap).size();
        } catch (Exception e) {

        }
        int netdbnum = 0;
        if (null == optApplyNetManager)
            optApplyNetManager = ctx.getBean("optApplyNetManager",
                    OptApplyNetManager.class);
        try {
            filterMap.put("orgcode1", sysuser.getPrimaryUnit());
            filterMap.put("orgcode", null);
            netdbnum = optApplyNetManager.listOptApplyInfoNetUnprocessed(
                    filterMap).size();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "{\"dbnum\":\"" + String.valueOf(xknum + cfnum + netdbnum)
                + "\"}";
    }
}
