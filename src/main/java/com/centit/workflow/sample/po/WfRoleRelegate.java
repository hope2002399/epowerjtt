package com.centit.workflow.sample.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfRoleRelegate implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long relegateno;
    private String grantor;
    private String grantee;
    private String isvalid;
    private Date relegatetime;
    private Date expiretime;
    private String unitcode;
    private String roletype;
    private String rolecode;
    private String grantdesc;
    private String recorder;
    private Date recorddate;

    // Constructors
    /** default constructor */
    public WfRoleRelegate() {
    }

    /** minimal constructor */
    public WfRoleRelegate(Long relegateno, String grantor, String grantee,
            String isvalid, Date relegatetime) {

        this.relegateno = relegateno;

        this.grantor = grantor;
        this.grantee = grantee;
        this.isvalid = isvalid;
        this.relegatetime = relegatetime;
    }

    /** full constructor */
    public WfRoleRelegate(Long relegateno, String grantor, String grantee,
            String isvalid, Date relegatetime, Date expiretime,
            String unitcode, String roletype, String rolecode,
            String grantdesc, String recorder, Date recorddate) {

        this.relegateno = relegateno;

        this.grantor = grantor;
        this.grantee = grantee;
        this.isvalid = isvalid;
        this.relegatetime = relegatetime;
        this.expiretime = expiretime;
        this.unitcode = unitcode;
        this.roletype = roletype;
        this.rolecode = rolecode;
        this.grantdesc = grantdesc;
        this.recorder = recorder;
        this.recorddate = recorddate;
    }

    public Long getRelegateno() {
        return this.relegateno;
    }

    public void setRelegateno(Long relegateno) {
        this.relegateno = relegateno;
    }

    // Property accessors

    public String getGrantor() {
        return this.grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public String getGrantee() {
        return this.grantee;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }

    public String getIsvalid() {
        return this.isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }

    public Date getRelegatetime() {
        return this.relegatetime;
    }

    public void setRelegatetime(Date relegatetime) {
        this.relegatetime = relegatetime;
    }

    public Date getExpiretime() {
        return this.expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    public String getUnitcode() {
        return this.unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getRoletype() {
        return this.roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype;
    }

    public String getRolecode() {
        return this.rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    public String getGrantdesc() {
        return this.grantdesc;
    }

    public void setGrantdesc(String grantdesc) {
        this.grantdesc = grantdesc;
    }

    public String getRecorder() {
        return this.recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public Date getRecorddate() {
        return this.recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public void copy(WfRoleRelegate other) {

        this.setRelegateno(other.getRelegateno());

        this.grantor = other.getGrantor();
        this.grantee = other.getGrantee();
        this.isvalid = other.getIsvalid();
        this.relegatetime = other.getRelegatetime();
        this.expiretime = other.getExpiretime();
        this.unitcode = other.getUnitcode();
        this.roletype = other.getRoletype();
        this.rolecode = other.getRolecode();
        this.grantdesc = other.getGrantdesc();
        this.recorder = other.getRecorder();
        this.recorddate = other.getRecorddate();

    }

    public void copyNotNullProperty(WfRoleRelegate other) {

        if (other.getRelegateno() != null)
            this.setRelegateno(other.getRelegateno());

        if (other.getGrantor() != null)
            this.grantor = other.getGrantor();
        if (other.getGrantee() != null)
            this.grantee = other.getGrantee();
        if (other.getIsvalid() != null)
            this.isvalid = other.getIsvalid();
        if (other.getRelegatetime() != null)
            this.relegatetime = other.getRelegatetime();
        if (other.getExpiretime() != null)
            this.expiretime = other.getExpiretime();
        if (other.getUnitcode() != null)
            this.unitcode = other.getUnitcode();
        if (other.getRoletype() != null)
            this.roletype = other.getRoletype();
        if (other.getRolecode() != null)
            this.rolecode = other.getRolecode();
        if (other.getGrantdesc() != null)
            this.grantdesc = other.getGrantdesc();
        if (other.getRecorder() != null)
            this.recorder = other.getRecorder();
        if (other.getRecorddate() != null)
            this.recorddate = other.getRecorddate();

    }

    public void clearProperties() {

        this.grantor = null;
        this.grantee = null;
        this.isvalid = null;
        this.relegatetime = null;
        this.expiretime = null;
        this.unitcode = null;
        this.roletype = null;
        this.rolecode = null;
        this.grantdesc = null;
        this.recorder = null;
        this.recorddate = null;

    }
}
