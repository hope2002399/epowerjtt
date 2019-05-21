package com.centit.sys.po;

import java.util.Date;

public class ApplyUser {
    private String userPassword;

    private String userName;

    private String depName;

    private String userID;

    private String enterpriseID;

    private String depAaddress;

    private String post;

    private String artificialPerson;

    private String isInUse;

    private Date existDate;

    private String telephone;

    private String isCancel;

    private String linkman;

    private String checkOperatorId;

    private String checkOperatorName;

    private Date checkDate;
    private String remark;

    private String papercode;

    private String email;

    private String unitcode;

    private String filename;

    public String getPapercode() {
        return papercode;
    }

    public void setPapercode(String papercode) {
        this.papercode = papercode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDepAaddress() {
        return depAaddress;
    }

    public void setDepAaddress(String depAaddress) {
        this.depAaddress = depAaddress;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getArtificialPerson() {
        return artificialPerson;
    }

    public void setArtificialPerson(String artificialPerson) {
        this.artificialPerson = artificialPerson;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    public void setIsInUse(String isInUse) {
        this.isInUse = isInUse;
    }

    public String getIsInUse() {
        return isInUse;
    }

    public String getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(String enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public Date getExistDate() {
        return existDate;
    }

    public void setExistDate(Date existDate) {
        this.existDate = existDate;
    }

    public String getCheckOperatorId() {
        return checkOperatorId;
    }

    public void setCheckOperatorId(String checkOperatorId) {
        this.checkOperatorId = checkOperatorId;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCheckOperatorName() {
        return checkOperatorName;
    }

    public void setCheckOperatorName(String checkOperatorName) {
        this.checkOperatorName = checkOperatorName;
    }

    public void copy(ApplyUser other) {
        this.artificialPerson = other.getArtificialPerson();
        this.checkDate = other.getCheckDate();
        this.checkOperatorId = other.getCheckOperatorId();
        this.depAaddress = other.getDepAaddress();
        this.depName = other.getDepName();
        this.enterpriseID = other.getEnterpriseID();
        this.existDate = other.getExistDate();
        this.isCancel = other.getIsCancel();
        this.isInUse = other.getIsInUse();
        this.linkman = other.getLinkman();
        this.post = other.getPost();
        this.remark = other.getRemark();
        this.telephone = other.getTelephone();
        this.userID = other.getUserID();
        this.userName = other.getUserName();
        this.userPassword = other.getUserPassword();

        this.papercode = other.getPapercode();
        this.unitcode = other.getUnitcode();
        this.email = other.getEmail();
        this.filename = other.getFilename();

    }

    public void copyNotNullProperty(ApplyUser other) {
        if (other.getArtificialPerson() != null)
            this.artificialPerson = other.getArtificialPerson();
        if (other.getCheckDate() != null)
            this.checkDate = other.getCheckDate();
        if (other.getCheckOperatorId() != null)
            this.checkOperatorId = other.getCheckOperatorId();
        if (other.getDepAaddress() != null)
            this.depAaddress = other.getDepAaddress();
        if (other.getDepName() != null)
            this.depName = other.getDepName();
        if (other.getEnterpriseID() != null)
            this.enterpriseID = other.getEnterpriseID();
        if (other.getExistDate() != null)
            this.existDate = other.getExistDate();
        if (other.getIsCancel() != null)
            this.isCancel = other.getIsCancel();
        if (other.getIsInUse() != null)
            this.isInUse = other.getIsInUse();
        if (other.getLinkman() != null)
            this.linkman = other.getLinkman();
        if (other.getPost() != null)
            this.post = other.getPost();
        if (other.getRemark() != null)
            this.remark = other.getRemark();
        if (other.getTelephone() != null)
            this.telephone = other.getTelephone();
        if (other.getUserID() != null)
            this.userID = other.getUserID();
        if (other.getUserName() != null)
            this.userName = other.getUserName();
        if (other.getUserPassword() != null)
            this.userPassword = other.getUserPassword();
        if (other.getCheckOperatorName() != null)
            this.checkOperatorName = other.getCheckOperatorName();
        if (other.getPapercode() != null)
            this.papercode = other.getPapercode();
        if (other.getUnitcode() != null)
            this.unitcode = other.getUnitcode();
        if (other.getEmail() != null)
            this.email = other.getEmail();
        if (other.getFilename() != null)
            this.filename = other.getFilename();

    }

    public void clearProperties() {
        this.artificialPerson = null;
        this.checkDate = null;
        this.checkOperatorId = null;
        this.depAaddress = null;
        this.depName = null;
        this.enterpriseID = null;
        this.existDate = null;
        this.isCancel = null;
        this.isInUse = null;
        this.linkman = null;
        this.post = null;
        this.remark = null;
        this.telephone = null;
        this.userID = null;
        this.userName = null;
        this.userPassword = null;
        this.papercode = null;
        this.unitcode = null;
        this.email = null;
        this.filename = null;

    }

}
