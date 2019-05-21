package com.centit.powerbase.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class LawexecutorInspect implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long inspectId;

    private String staffno;
    private String inspectType;
    private Date inspectDate;
    private Date inspectValidate;
    private String inspectRemark;
    private String recorder;
    private Date recordDate;

    // Constructors
    /** default constructor */
    public LawexecutorInspect() {
    }

    /** minimal constructor */
    public LawexecutorInspect(Long inspectId, String staffno,
            String inspectType, Date inspectDate, String inspectRemark,
            String recorder, Date recordDate) {

        this.inspectId = inspectId;

        this.staffno = staffno;
        this.inspectType = inspectType;
        this.inspectDate = inspectDate;
        this.inspectRemark = inspectRemark;
        this.recorder = recorder;
        this.recordDate = recordDate;
    }

    /** full constructor */
    public LawexecutorInspect(Long inspectId, String staffno,
            String inspectType, Date inspectDate, Date inspectValidate,
            String inspectRemark, String recorder, Date recordDate) {

        this.inspectId = inspectId;

        this.staffno = staffno;
        this.inspectType = inspectType;
        this.inspectDate = inspectDate;
        this.inspectValidate = inspectValidate;
        this.inspectRemark = inspectRemark;
        this.recorder = recorder;
        this.recordDate = recordDate;
    }

    public Long getInspectId() {
        return this.inspectId;
    }

    public void setInspectId(Long inspectId) {
        this.inspectId = inspectId;
    }

    // Property accessors

    public String getStaffno() {
        return this.staffno;
    }

    public void setStaffno(String staffno) {
        this.staffno = staffno;
    }

    public String getInspectType() {
        return this.inspectType;
    }

    public void setInspectType(String inspectType) {
        this.inspectType = inspectType;
    }

    public Date getInspectDate() {
        return this.inspectDate;
    }

    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }

    public Date getInspectValidate() {
        return this.inspectValidate;
    }

    public void setInspectValidate(Date inspectValidate) {
        this.inspectValidate = inspectValidate;
    }

    public String getInspectRemark() {
        return this.inspectRemark;
    }

    public void setInspectRemark(String inspectRemark) {
        this.inspectRemark = inspectRemark;
    }

    public String getRecorder() {
        return this.recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public Date getRecordDate() {
        return this.recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public void copy(LawexecutorInspect other) {

        this.setInspectId(other.getInspectId());

        this.staffno = other.getStaffno();
        this.inspectType = other.getInspectType();
        this.inspectDate = other.getInspectDate();
        this.inspectValidate = other.getInspectValidate();
        this.inspectRemark = other.getInspectRemark();
        this.recorder = other.getRecorder();
        this.recordDate = other.getRecordDate();

    }

    public void copyNotNullProperty(LawexecutorInspect other) {

        if (other.getInspectId() != null)
            this.setInspectId(other.getInspectId());

        if (other.getStaffno() != null)
            this.staffno = other.getStaffno();
        if (other.getInspectType() != null)
            this.inspectType = other.getInspectType();
        if (other.getInspectDate() != null)
            this.inspectDate = other.getInspectDate();
        if (other.getInspectValidate() != null)
            this.inspectValidate = other.getInspectValidate();
        if (other.getInspectRemark() != null)
            this.inspectRemark = other.getInspectRemark();
        if (other.getRecorder() != null)
            this.recorder = other.getRecorder();
        if (other.getRecordDate() != null)
            this.recordDate = other.getRecordDate();

    }

    public void clearProperties() {

        this.staffno = null;
        this.inspectType = null;
        this.inspectDate = null;
        this.inspectValidate = null;
        this.inspectRemark = null;
        this.recorder = null;
        this.recordDate = null;

    }
}
