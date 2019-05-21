package com.centit.workflow.sample.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfTeam implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private WfTeamId cid;

    private String authDesc;
    private Date authTime;

    // Constructors
    /** default constructor */
    public WfTeam() {
    }

    /** minimal constructor */
    public WfTeam(WfTeamId id

    , Date authtime) {
        this.cid = id;

        this.authTime = authtime;
    }

    /** full constructor */
    public WfTeam(WfTeamId id

    , String authdesc, Date authtime) {
        this.cid = id;
        this.authDesc = authdesc;
        this.authTime = authtime;
    }

    public WfTeam(Long wfinstid, String usercode, String rolecode, Date authtime) {
        this.cid = new WfTeamId(wfinstid, usercode, rolecode);
        this.authTime = authtime;
    }

    public WfTeamId getCid() {
        return this.cid;
    }

    public void setCid(WfTeamId id) {
        this.cid = id;
    }

    public Long getFlowInstId() {
        if (this.cid == null)
            this.cid = new WfTeamId();
        return this.cid.getFlowInstId();
    }

    public void setFlowInstId(Long wfinstid) {
        if (this.cid == null)
            this.cid = new WfTeamId();
        this.cid.setFlowInstId(wfinstid);
    }

    public String getUserCode() {
        if (this.cid == null)
            this.cid = new WfTeamId();
        return this.cid.getUserCode();
    }

    public void setUserCode(String usercode) {
        if (this.cid == null)
            this.cid = new WfTeamId();
        this.cid.setUserCode(usercode);
    }

    public String getRoleCode() {
        if (this.cid == null)
            this.cid = new WfTeamId();
        return this.cid.getRoleCode();
    }

    public void setRoleCode(String rolecode) {
        if (this.cid == null)
            this.cid = new WfTeamId();
        this.cid.setRoleCode(rolecode);
    }

    // Property accessors

    public String getAuthDesc() {
        return this.authDesc;
    }

    public void setAuthDesc(String authdesc) {
        this.authDesc = authdesc;
    }

    public Date getAuthTime() {
        return this.authTime;
    }

    public void setAuthTime(Date authtime) {
        this.authTime = authtime;
    }

    public void copy(WfTeam other) {

        this.setFlowInstId(other.getFlowInstId());
        this.setUserCode(other.getUserCode());
        this.setRoleCode(other.getRoleCode());

        this.authDesc = other.getAuthDesc();
        this.authTime = other.getAuthTime();

    }

    public void copyNotNullProperty(WfTeam other) {

        if (other.getFlowInstId() != null)
            this.setFlowInstId(other.getFlowInstId());
        if (other.getUserCode() != null)
            this.setUserCode(other.getUserCode());
        if (other.getRoleCode() != null)
            this.setRoleCode(other.getRoleCode());

        if (other.getAuthDesc() != null)
            this.authDesc = other.getAuthDesc();
        if (other.getAuthTime() != null)
            this.authTime = other.getAuthTime();

    }
}
