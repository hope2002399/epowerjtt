package com.centit.workflow.sample.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfOrganize implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private WfOrganizeId cid;

    private String authDesc;
    private Date authTime;

    // Constructors
    /** default constructor */
    public WfOrganize() {
    }

    /** minimal constructor */
    public WfOrganize(WfOrganizeId id

    , Date authTime) {
        this.cid = id;

        this.authTime = authTime;
    }

    /** full constructor */
    public WfOrganize(WfOrganizeId id

    , String authDesc, Date authTime) {
        this.cid = id;

        this.authDesc = authDesc;
        this.authTime = authTime;
    }

    public WfOrganize(Long wfinstid, String unitCode, String rolecode,
            Date authtime) {
        this.cid = new WfOrganizeId(wfinstid, unitCode, rolecode);
        this.authTime = authtime;
    }

    public WfOrganizeId getCid() {
        return this.cid;
    }

    public void setCid(WfOrganizeId id) {
        this.cid = id;
    }

    public Long getFlowInstId() {
        if (this.cid == null)
            this.cid = new WfOrganizeId();
        return this.cid.getFlowInstId();
    }

    public void setFlowInstId(Long flowInstId) {
        if (this.cid == null)
            this.cid = new WfOrganizeId();
        this.cid.setFlowInstId(flowInstId);
    }

    public String getUnitCode() {
        if (this.cid == null)
            this.cid = new WfOrganizeId();
        return this.cid.getUnitCode();
    }

    public void setUnitCode(String unitCode) {
        if (this.cid == null)
            this.cid = new WfOrganizeId();
        this.cid.setUnitCode(unitCode);
    }

    public String getRoleCode() {
        if (this.cid == null)
            this.cid = new WfOrganizeId();
        return this.cid.getRoleCode();
    }

    public void setRoleCode(String roleCode) {
        if (this.cid == null)
            this.cid = new WfOrganizeId();
        this.cid.setRoleCode(roleCode);
    }

    // Property accessors

    public String getAuthDesc() {
        return this.authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc;
    }

    public Date getAuthTime() {
        return this.authTime;
    }

    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    public void copy(WfOrganize other) {

        this.setFlowInstId(other.getFlowInstId());
        this.setUnitCode(other.getUnitCode());
        this.setRoleCode(other.getRoleCode());

        this.authDesc = other.getAuthDesc();
        this.authTime = other.getAuthTime();

    }

    public void copyNotNullProperty(WfOrganize other) {

        if (other.getFlowInstId() != null)
            this.setFlowInstId(other.getFlowInstId());
        if (other.getUnitCode() != null)
            this.setUnitCode(other.getUnitCode());
        if (other.getRoleCode() != null)
            this.setRoleCode(other.getRoleCode());

        if (other.getAuthDesc() != null)
            this.authDesc = other.getAuthDesc();
        if (other.getAuthTime() != null)
            this.authTime = other.getAuthTime();

    }

    public void clearProperties() {

        this.authDesc = null;
        this.authTime = null;

    }
}
