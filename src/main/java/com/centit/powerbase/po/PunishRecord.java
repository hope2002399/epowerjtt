package com.centit.powerbase.po;

import java.util.Date;

public class PunishRecord implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String org_id;
    private String bookOperatorID;
    private Date bookDate;
    private Date modifyDate;
    private String depKind;
    private Long personNum;
    private Long corpNum;
    private String remark;
    private String lawbasic;
    private Long personNumBusiness;
    private Long corpNumBusiness;

    public PunishRecord() {

    }

    public PunishRecord(String org_id, String bookOperatorID, Date bookDate,
            Date modifyDate, String depKind, Long personNum, Long corpNum,
            Long personNumBusiness, Long corpNumBusiness, String remark,
            String lawbasic) {
        // super();
        this.org_id = org_id;
        this.bookOperatorID = bookOperatorID;
        this.bookDate = bookDate;
        this.modifyDate = modifyDate;
        this.depKind = depKind;
        this.personNum = personNum;
        this.corpNum = corpNum;
        this.remark = remark;
        this.lawbasic = lawbasic;
        this.personNumBusiness = personNumBusiness;
        this.corpNumBusiness = corpNumBusiness;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getBookOperatorID() {
        return bookOperatorID;
    }

    public void setBookOperatorID(String bookOperatorID) {
        this.bookOperatorID = bookOperatorID;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getDepKind() {
        return depKind;
    }

    public void setDepKind(String depKind) {
        this.depKind = depKind;
    }

    public Long getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Long personNum) {
        this.personNum = personNum;
    }

    public Long getCorpNum() {
        return corpNum;
    }

    public void setCorpNum(Long corpNum) {
        this.corpNum = corpNum;
    }

    public Long getPersonNumBusiness() {
        return personNumBusiness;
    }

    public void setPersonNumBusiness(Long personNumBusiness) {

        this.personNumBusiness = personNumBusiness;

    }

    public Long getCorpNumBusiness() {
        return corpNumBusiness;
    }

    public void setCorpNumBusiness(Long corpNumBusiness) {
        this.corpNumBusiness = corpNumBusiness;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLawbasic() {
        return lawbasic;
    }

    public void setLawbasic(String lawbasic) {
        this.lawbasic = lawbasic;
    }

    public void copy(PunishRecord other) {

        this.setOrg_id(other.getOrg_id());
        this.bookOperatorID = other.bookOperatorID;
        this.bookDate = other.getBookDate();
        this.modifyDate = other.getModifyDate();

        this.depKind = other.getDepKind();

        this.personNum = other.getPersonNum();

        this.corpNum = other.getCorpNum();

        this.remark = other.getRemark();

        this.lawbasic = other.getLawbasic();

    }

    public void copyNotNullProperty(PunishRecord other) {

        if (other.getOrg_id() != null)
            this.setOrg_id(other.getOrg_id());

        if (other.getBookOperatorID() != null)
            this.bookOperatorID = other.bookOperatorID;
        if (other.getBookDate() != null)
            this.bookDate = other.getBookDate();
        if (other.getModifyDate() != null)
            this.modifyDate = other.getModifyDate();
        if (other.getDepKind() != null)
            this.depKind = other.getDepKind();
        if (other.personNum != null)
            this.personNum = other.getPersonNum();
        if (other.corpNum != null)
            this.corpNum = other.getCorpNum();
        if (other.lawbasic != null)
            this.lawbasic = other.lawbasic;
        if (other.remark != null)
            this.remark = other.getRemark();

    }

    public void clearProperties() {
        this.org_id = null;
        this.bookOperatorID = null;
        this.bookDate = null;
        this.modifyDate = null;
        this.depKind = null;
        this.personNum = null;
        this.corpNum = null;
        this.remark = null;
        this.lawbasic = null;

    }

}
