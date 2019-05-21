package com.centit.workflow.sample.po;

import java.util.Date;

import com.centit.workflow.ManageActionLog;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfManageAction implements java.io.Serializable, ManageActionLog {
    private static final long serialVersionUID = 1L;

    private Long actionid;

    private Long wfinstid;
    private String actiontype;
    private Date actiontime;
    private String usercode;
    private String roletype;
    private String rolecode;
    private String admindesc;

    // Constructors
    /** default constructor */
    public WfManageAction() {
    }

    /** minimal constructor */
    public WfManageAction(Long actionid, String actiontype, Date actiontime) {

        this.actionid = actionid;

        this.actiontype = actiontype;
        this.actiontime = actiontime;
    }

    /** full constructor */
    public WfManageAction(Long actionid, Long wfinstid, String actiontype,
            Date actiontime, String usercode, String roletype, String rolecode,
            String admindesc) {

        this.actionid = actionid;

        this.wfinstid = wfinstid;
        this.actiontype = actiontype;
        this.actiontime = actiontime;
        this.usercode = usercode;
        this.roletype = roletype;
        this.rolecode = rolecode;
        this.admindesc = admindesc;
    }

    public Long getActionId() {
        return this.actionid;
    }

    public void setActionId(Long actionid) {
        this.actionid = actionid;
    }

    // Property accessors

    public Long getFlowInstId() {
        return this.wfinstid;
    }

    public void setFlowInstId(Long wfinstid) {
        this.wfinstid = wfinstid;
    }

    public String getActionType() {
        return this.actiontype;
    }

    public void setActionType(String actiontype) {
        this.actiontype = actiontype;
    }

    public Date getActionTime() {
        return this.actiontime;
    }

    public void setActionTime(Date actiontime) {
        this.actiontime = actiontime;
    }

    public String getUserCode() {
        return this.usercode;
    }

    public void setUserCode(String usercode) {
        this.usercode = usercode;
    }

    public String getRoleType() {
        return this.roletype;
    }

    public void setRoleType(String roletype) {
        this.roletype = roletype;
    }

    public String getRoleCode() {
        return this.rolecode;
    }

    public void setRoleCode(String rolecode) {
        this.rolecode = rolecode;
    }

    public String getAdminDesc() {
        return this.admindesc;
    }

    public void setAdminDesc(String admindesc) {
        this.admindesc = admindesc;
    }

    public void copy(WfManageAction other) {

        this.setActionId(other.getActionId());

        this.wfinstid = other.getFlowInstId();
        this.actiontype = other.getActionType();
        this.actiontime = other.getActionTime();
        this.usercode = other.getUserCode();
        this.roletype = other.getRoleType();
        this.rolecode = other.getRoleCode();
        this.admindesc = other.getAdminDesc();

    }

    public void copyNotNullProperty(WfManageAction other) {

        if (other.getActionId() != null)
            this.setActionId(other.getActionId());

        if (other.getFlowInstId() != null)
            this.wfinstid = other.getFlowInstId();
        if (other.getActionType() != null)
            this.actiontype = other.getActionType();
        if (other.getActionTime() != null)
            this.actiontime = other.getActionTime();
        if (other.getUserCode() != null)
            this.usercode = other.getUserCode();
        if (other.getRoleType() != null)
            this.roletype = other.getRoleType();
        if (other.getRoleCode() != null)
            this.rolecode = other.getRoleCode();
        if (other.getAdminDesc() != null)
            this.admindesc = other.getAdminDesc();

    }
}
