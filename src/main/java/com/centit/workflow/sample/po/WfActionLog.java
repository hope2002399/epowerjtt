package com.centit.workflow.sample.po;

import java.util.Date;

import com.centit.workflow.ActionLog;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfActionLog implements java.io.Serializable, ActionLog {
    private static final long serialVersionUID = 1L;

    private Long actionid;

    private Long nodeinstid;
    private String actiontype;
    private Date actiontime;
    private String usercode;
    private String roletype;
    private String rolecode;
    private String grantor;

    // Constructors
    /** default constructor */
    public WfActionLog() {
    }

    /** minimal constructor */
    public WfActionLog(Long actionid, String actiontype, Date actiontime) {

        this.actionid = actionid;

        this.actiontype = actiontype;
        this.actiontime = actiontime;
    }

    /** full constructor */
    public WfActionLog(Long actionid, Long nodeinstid, String actiontype,
            Date actiontime, String usercode, String roletype, String rolecode,
            String grantor) {

        this.actionid = actionid;

        this.nodeinstid = nodeinstid;
        this.actiontype = actiontype;
        this.actiontime = actiontime;
        this.usercode = usercode;
        this.roletype = roletype;
        this.rolecode = rolecode;
        this.grantor = grantor;
    }

    public Long getActionId() {
        return this.actionid;
    }

    public void setActionId(Long actionid) {
        this.actionid = actionid;
    }

    // Property accessors

    public Long getNodeInstId() {
        return this.nodeinstid;
    }

    public void setNodeInstId(Long nodeinstid) {
        this.nodeinstid = nodeinstid;
    }

    /**
     * 创建流程同时创建首节点 W 创建节点 C 更改数据 U 提交节点 S 挂起节点 A 唤醒节点 R 终止节点 E
     */
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

    public void copy(WfActionLog other) {

        this.setActionId(other.getActionId());

        this.nodeinstid = other.getNodeInstId();
        this.actiontype = other.getActionType();
        this.actiontime = other.getActionTime();
        this.usercode = other.getUserCode();
        this.roletype = other.getRoleType();
        this.rolecode = other.getRoleCode();
        this.grantor = other.getGrantor();

    }

    public void copyNotNullProperty(WfActionLog other) {

        if (other.getActionId() != null)
            this.setActionId(other.getActionId());

        if (other.getNodeInstId() != null)
            this.nodeinstid = other.getNodeInstId();
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
        if (other.getGrantor() != null)
            this.grantor = other.getGrantor();

    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }
}
