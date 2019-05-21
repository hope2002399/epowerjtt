package com.centit.workflow.sample.po;

import java.util.Date;

import com.centit.workflow.ActionTask;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfActionTask implements java.io.Serializable, ActionTask {
    private static final long serialVersionUID = 1L;

    private Long taskid;

    private Long nodeinstid;
    private Date assigntime;
    private Date expiretime;
    private String usercode;
    private String roletype;
    private String rolecode;
    private String taskstate;
    private String isvalid;
    private String authdesc;

    // Constructors
    /** default constructor */
    public WfActionTask() {
    }

    /** minimal constructor */
    public WfActionTask(Long taskid, Date assigntime, Date expiretime) {

        this.taskid = taskid;

        this.assigntime = assigntime;
        this.expiretime = expiretime;
    }

    /** full constructor */
    public WfActionTask(Long taskid, Long nodeinstid, Date assigntime,
            Date expiretime, String usercode, String roletype, String rolecode,
            String taskstate, String isvalid, String authdesc) {

        this.taskid = taskid;

        this.nodeinstid = nodeinstid;
        this.assigntime = assigntime;
        this.expiretime = expiretime;
        this.usercode = usercode;
        this.roletype = roletype;
        this.rolecode = rolecode;
        this.taskstate = taskstate;
        this.isvalid = isvalid;
        this.authdesc = authdesc;
    }

    public Long getTaskId() {
        return this.taskid;
    }

    public void setTaskId(Long taskid) {
        this.taskid = taskid;
    }

    // Property accessors

    public Long getNodeInstId() {
        return this.nodeinstid;
    }

    public void setNodeInstId(Long nodeinstid) {
        this.nodeinstid = nodeinstid;
    }

    public Date getAssignTime() {
        return this.assigntime;
    }

    public void setAssignTime(Date assigntime) {
        this.assigntime = assigntime;
    }

    public Date getExpireTime() {
        return this.expiretime;
    }

    public void setExpireTime(Date expiretime) {
        this.expiretime = expiretime;
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

    /**
     * @return A:已分配 C：已完成（提交）
     */
    public String getTaskState() {
        return this.taskstate;
    }

    /**
     * 
     * @param taskstate
     *            A:已分配 C：已完成（提交）
     */
    public void setTaskState(String taskstate) {
        this.taskstate = taskstate;
    }

    public boolean isValid() {
        return "T".equals(isvalid);
    }

    /**
     * T 正常 F 失效
     * 
     * @return
     */
    public String getIsvalid() {
        return this.isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }

    public String getAuthDesc() {
        return this.authdesc;
    }

    public void setAuthDesc(String authdesc) {
        this.authdesc = authdesc;
    }

    public void copy(WfActionTask other) {

        this.setTaskId(other.getTaskId());

        this.nodeinstid = other.getNodeInstId();
        this.assigntime = other.getAssignTime();
        this.expiretime = other.getExpireTime();
        this.usercode = other.getUserCode();
        this.roletype = other.getRoleType();
        this.rolecode = other.getRoleCode();
        this.taskstate = other.getTaskState();
        this.isvalid = other.getIsvalid();
        this.authdesc = other.getAuthDesc();

    }

    public void copyNotNullProperty(WfActionTask other) {

        if (other.getTaskId() != null)
            this.setTaskId(other.getTaskId());

        if (other.getNodeInstId() != null)
            this.nodeinstid = other.getNodeInstId();
        if (other.getAssignTime() != null)
            this.assigntime = other.getAssignTime();
        if (other.getExpireTime() != null)
            this.expiretime = other.getExpireTime();
        if (other.getUserCode() != null)
            this.usercode = other.getUserCode();
        if (other.getRoleType() != null)
            this.roletype = other.getRoleType();
        if (other.getRoleCode() != null)
            this.rolecode = other.getRoleCode();
        if (other.getTaskState() != null)
            this.taskstate = other.getTaskState();
        if (other.getIsvalid() != null)
            this.isvalid = other.getIsvalid();
        if (other.getAuthDesc() != null)
            this.authdesc = other.getAuthDesc();

    }
}
