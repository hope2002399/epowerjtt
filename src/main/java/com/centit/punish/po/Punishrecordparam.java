package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Punishrecordparam implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String orgId;

    private String bookoperatorid;
    private Date bookdate;
    private Date modifydate;
    private String depkind;
    private Long personnum;
    private Long corpnum;
    private String punishClass;
    private Long personnumBusiness;
    private Long corpnumBusiness;
    private String lawbasic;
    private String remark;

    // Constructors
    /** default constructor */
    public Punishrecordparam() {
    }

    /** minimal constructor */
    public Punishrecordparam(String orgId) {

        this.orgId = orgId;

    }

    /** full constructor */
    public Punishrecordparam(String orgId, String bookoperatorid,
            Date bookdate, Date modifydate, String depkind, Long personnum,
            Long corpnum, String punishClass, Long personnumBusiness,
            Long corpnumBusiness, String lawbasic, String remark) {

        this.orgId = orgId;

        this.bookoperatorid = bookoperatorid;
        this.bookdate = bookdate;
        this.modifydate = modifydate;
        this.depkind = depkind;
        this.personnum = personnum;
        this.corpnum = corpnum;
        this.punishClass = punishClass;
        this.personnumBusiness = personnumBusiness;
        this.corpnumBusiness = corpnumBusiness;
        this.lawbasic = lawbasic;
        this.remark = remark;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    // Property accessors

    public String getBookoperatorid() {
        return this.bookoperatorid;
    }

    public void setBookoperatorid(String bookoperatorid) {
        this.bookoperatorid = bookoperatorid;
    }

    public Date getBookdate() {
        return this.bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

    public Date getModifydate() {
        return this.modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getDepkind() {
        return this.depkind;
    }

    public void setDepkind(String depkind) {
        this.depkind = depkind;
    }

    public Long getPersonnum() {
        return this.personnum;
    }

    public void setPersonnum(Long personnum) {
        this.personnum = personnum;
    }

    public Long getCorpnum() {
        return this.corpnum;
    }

    public void setCorpnum(Long corpnum) {
        this.corpnum = corpnum;
    }

    public String getPunishClass() {
        return this.punishClass;
    }

    public void setPunishClass(String punishClass) {
        this.punishClass = punishClass;
    }

    public Long getPersonnumBusiness() {
        return this.personnumBusiness;
    }

    public void setPersonnumBusiness(Long personnumBusiness) {
        this.personnumBusiness = personnumBusiness;
    }

    public Long getCorpnumBusiness() {
        return this.corpnumBusiness;
    }

    public void setCorpnumBusiness(Long corpnumBusiness) {
        this.corpnumBusiness = corpnumBusiness;
    }

    public String getLawbasic() {
        return this.lawbasic;
    }

    public void setLawbasic(String lawbasic) {
        this.lawbasic = lawbasic;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void copy(Punishrecordparam other) {

        this.setOrgId(other.getOrgId());

        this.bookoperatorid = other.getBookoperatorid();
        this.bookdate = other.getBookdate();
        this.modifydate = other.getModifydate();
        this.depkind = other.getDepkind();
        this.personnum = other.getPersonnum();
        this.corpnum = other.getCorpnum();
        this.punishClass = other.getPunishClass();
        this.personnumBusiness = other.getPersonnumBusiness();
        this.corpnumBusiness = other.getCorpnumBusiness();
        this.lawbasic = other.getLawbasic();
        this.remark = other.getRemark();

    }

    public void copyNotNullProperty(Punishrecordparam other) {

        if (other.getOrgId() != null)
            this.setOrgId(other.getOrgId());

        if (other.getBookoperatorid() != null)
            this.bookoperatorid = other.getBookoperatorid();
        if (other.getBookdate() != null)
            this.bookdate = other.getBookdate();
        if (other.getModifydate() != null)
            this.modifydate = other.getModifydate();
        if (other.getDepkind() != null)
            this.depkind = other.getDepkind();
        if (other.getPersonnum() != null)
            this.personnum = other.getPersonnum();
        if (other.getCorpnum() != null)
            this.corpnum = other.getCorpnum();
        if (other.getPunishClass() != null)
            this.punishClass = other.getPunishClass();
        if (other.getPersonnumBusiness() != null)
            this.personnumBusiness = other.getPersonnumBusiness();
        if (other.getCorpnumBusiness() != null)
            this.corpnumBusiness = other.getCorpnumBusiness();
        if (other.getLawbasic() != null)
            this.lawbasic = other.getLawbasic();
        if (other.getRemark() != null)
            this.remark = other.getRemark();

    }

    public void clearProperties() {

        this.bookoperatorid = null;
        this.bookdate = null;
        this.modifydate = null;
        this.depkind = null;
        this.personnum = null;
        this.corpnum = null;
        this.punishClass = null;
        this.personnumBusiness = null;
        this.corpnumBusiness = null;
        this.lawbasic = null;
        this.remark = null;

    }
}
