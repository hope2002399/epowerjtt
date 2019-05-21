package com.centit.powerbase.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Lawmenannual implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String annualId;

    private String lawmenId;
    private String usercode;
    private Date annualDate;
    private String annualResult;
    private Date validity;
    private String remark;

    // Constructors
    /** default constructor */
    public Lawmenannual() {
    }

    /** minimal constructor */
    public Lawmenannual(String annualId, String lawmenId, String usercode,
            Date annualDate, String annualResult, String remark) {

        this.annualId = annualId;

        this.lawmenId = lawmenId;
        this.usercode = usercode;
        this.annualDate = annualDate;
        this.annualResult = annualResult;
        this.remark = remark;
    }

    /** full constructor */
    public Lawmenannual(String annualId, String lawmenId, String usercode,
            Date annualDate, String annualResult, Date validity, String remark) {

        this.annualId = annualId;

        this.lawmenId = lawmenId;
        this.usercode = usercode;
        this.annualDate = annualDate;
        this.annualResult = annualResult;
        this.validity = validity;
        this.remark = remark;
    }

    public String getAnnualId() {
        return this.annualId;
    }

    public void setAnnualId(String annualId) {
        this.annualId = annualId;
    }

    // Property accessors

    public String getlawmenId() {
        return this.lawmenId;
    }

    public void setlawmenId(String lawmenId) {
        this.lawmenId = lawmenId;
    }

    public String getUsercode() {
        return this.usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public Date getAnnualDate() {
        return this.annualDate;
    }

    public void setAnnualDate(Date annualDate) {
        this.annualDate = annualDate;
    }

    public String getAnnualResult() {
        return this.annualResult;
    }

    public void setAnnualResult(String annualResult) {
        this.annualResult = annualResult;
    }

    public Date getValidity() {
        return this.validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void copy(Lawmenannual other) {

        this.setAnnualId(other.getAnnualId());

        this.lawmenId = other.getlawmenId();
        this.usercode = other.getUsercode();
        this.annualDate = other.getAnnualDate();
        this.annualResult = other.getAnnualResult();
        this.validity = other.getValidity();
        this.remark = other.getRemark();

    }

    public void copyNotNullProperty(Lawmenannual other) {

        if (other.getAnnualId() != null)
            this.setAnnualId(other.getAnnualId());

        if (other.getlawmenId() != null)
            this.lawmenId = other.getlawmenId();
        if (other.getUsercode() != null)
            this.usercode = other.getUsercode();
        if (other.getAnnualDate() != null)
            this.annualDate = other.getAnnualDate();
        if (other.getAnnualResult() != null)
            this.annualResult = other.getAnnualResult();
        if (other.getValidity() != null)
            this.validity = other.getValidity();
        if (other.getRemark() != null)
            this.remark = other.getRemark();

    }

    public void clearProperties() {

        this.lawmenId = null;
        this.usercode = null;
        this.annualDate = null;
        this.annualResult = null;
        this.validity = null;
        this.remark = null;

    }
}
