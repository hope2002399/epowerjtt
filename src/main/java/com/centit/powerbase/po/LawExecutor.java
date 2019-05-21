package com.centit.powerbase.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class LawExecutor implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String staffno;

    private String passcode;
    private String staffname;
    private String sex;
    private String nation;
    private String idcard;
    private String politics;
    private String education;
    private String deptid;
    private String position;
    private String telephone;
    private String plait;
    private Date getpasstime;
    private String issueddept;
    private String executionarea;
    private String executionclass;
    private String executionjob;
    private Date changepasstime;
    private Date passlife;
    private String memo;
    private Date inputtime;
    private String operator;
    private String status;
    private Date repairdate;
    private byte[] cardphoto;
    private Long cardkind;
    private String staffstatus;
    private String ifRecordno;
    private String ifDeptcode;
    private String deptname;
    private String hasexport;
    private String dsource;
    private String reReason;
    private Date exportDate;
    private String exptoweb;
    private Date exptowebtime;

    private String auditIdeaCode;
    private String auditIdeaContent;
    private String auditUserCode;
    private Date auditDate;

    // Constructors
    /** default constructor */
    public LawExecutor() {
    }

    /** minimal constructor */
    public LawExecutor(String staffno) {

        this.staffno = staffno;

    }

    /** full constructor */
    public LawExecutor(String staffno, String passcode, String staffname,
            String sex, String nation, String idcard, String politics,
            String education, String deptid, String position, String telephone,
            String plait, Date getpasstime, String issueddept,
            String executionarea, String executionclass, String executionjob,
            Date changepasstime, Date passlife, String memo, Date inputtime,
            String operator, String status, Date repairdate, byte[] cardphoto,
            Long cardkind, String staffstatus, String ifRecordno,
            String ifDeptcode, String deptname, String hasexport,
            String dsource, String reReason, Date exportDate, String exptoweb,
            Date exptowebtime) {

        this.staffno = staffno;

        this.passcode = passcode;
        this.staffname = staffname;
        this.sex = sex;
        this.nation = nation;
        this.idcard = idcard;
        this.politics = politics;
        this.education = education;
        this.deptid = deptid;
        this.position = position;
        this.telephone = telephone;
        this.plait = plait;
        this.getpasstime = getpasstime;
        this.issueddept = issueddept;
        this.executionarea = executionarea;
        this.executionclass = executionclass;
        this.executionjob = executionjob;
        this.changepasstime = changepasstime;
        this.passlife = passlife;
        this.memo = memo;
        this.inputtime = inputtime;
        this.operator = operator;
        this.status = status;
        this.repairdate = repairdate;
        this.cardphoto = cardphoto;
        this.cardkind = cardkind;
        this.staffstatus = staffstatus;
        this.ifRecordno = ifRecordno;
        this.ifDeptcode = ifDeptcode;
        this.deptname = deptname;
        this.hasexport = hasexport;
        this.dsource = dsource;
        this.reReason = reReason;
        this.exportDate = exportDate;
        this.exptoweb = exptoweb;
        this.exptowebtime = exptowebtime;
    }

    public String getStaffno() {
        return this.staffno;
    }

    public void setStaffno(String staffno) {
        this.staffno = staffno;
    }

    // Property accessors

    public String getPasscode() {
        return this.passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getStaffname() {
        return this.staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPolitics() {
        return this.politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDeptid() {
        return this.deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPlait() {
        return this.plait;
    }

    public void setPlait(String plait) {
        this.plait = plait;
    }

    public Date getGetpasstime() {
        return this.getpasstime;
    }

    public void setGetpasstime(Date getpasstime) {
        this.getpasstime = getpasstime;
    }

    public String getIssueddept() {
        return this.issueddept;
    }

    public void setIssueddept(String issueddept) {
        this.issueddept = issueddept;
    }

    public String getExecutionarea() {
        return this.executionarea;
    }

    public void setExecutionarea(String executionarea) {
        this.executionarea = executionarea;
    }

    public String getExecutionclass() {
        return this.executionclass;
    }

    public void setExecutionclass(String executionclass) {
        this.executionclass = executionclass;
    }

    public String getExecutionjob() {
        return this.executionjob;
    }

    public void setExecutionjob(String executionjob) {
        this.executionjob = executionjob;
    }

    public Date getChangepasstime() {
        return this.changepasstime;
    }

    public void setChangepasstime(Date changepasstime) {
        this.changepasstime = changepasstime;
    }

    public Date getPasslife() {
        return this.passlife;
    }

    public void setPasslife(Date passlife) {
        this.passlife = passlife;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getInputtime() {
        return this.inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRepairdate() {
        return this.repairdate;
    }

    public void setRepairdate(Date repairdate) {
        this.repairdate = repairdate;
    }

    public byte[] getCardphoto() {
        return this.cardphoto;
    }

    public void setCardphoto(byte[] cardphoto) {
        this.cardphoto = cardphoto;
    }

    public Long getCardkind() {
        return this.cardkind;
    }

    public void setCardkind(Long cardkind) {
        this.cardkind = cardkind;
    }

    public String getStaffstatus() {
        return this.staffstatus;
    }

    public void setStaffstatus(String staffstatus) {
        this.staffstatus = staffstatus;
    }

    public String getIfRecordno() {
        return this.ifRecordno;
    }

    public void setIfRecordno(String ifRecordno) {
        this.ifRecordno = ifRecordno;
    }

    public String getIfDeptcode() {
        return this.ifDeptcode;
    }

    public void setIfDeptcode(String ifDeptcode) {
        this.ifDeptcode = ifDeptcode;
    }

    public String getDeptname() {
        return this.deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getHasexport() {
        return this.hasexport;
    }

    public void setHasexport(String hasexport) {
        this.hasexport = hasexport;
    }

    public String getDsource() {
        return this.dsource;
    }

    public void setDsource(String dsource) {
        this.dsource = dsource;
    }

    public String getReReason() {
        return this.reReason;
    }

    public void setReReason(String reReason) {
        this.reReason = reReason;
    }

    public Date getExportDate() {
        return this.exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    public String getExptoweb() {
        return this.exptoweb;
    }

    public void setExptoweb(String exptoweb) {
        this.exptoweb = exptoweb;
    }

    public Date getExptowebtime() {
        return this.exptowebtime;
    }

    public void setExptowebtime(Date exptowebtime) {
        this.exptowebtime = exptowebtime;
    }

    public void copy(LawExecutor other) {

        this.setStaffno(other.getStaffno());

        this.passcode = other.getPasscode();
        this.staffname = other.getStaffname();
        this.sex = other.getSex();
        this.nation = other.getNation();
        this.idcard = other.getIdcard();
        this.politics = other.getPolitics();
        this.education = other.getEducation();
        this.deptid = other.getDeptid();
        this.position = other.getPosition();
        this.telephone = other.getTelephone();
        this.plait = other.getPlait();
        this.getpasstime = other.getGetpasstime();
        this.issueddept = other.getIssueddept();
        this.executionarea = other.getExecutionarea();
        this.executionclass = other.getExecutionclass();
        this.executionjob = other.getExecutionjob();
        this.changepasstime = other.getChangepasstime();
        this.passlife = other.getPasslife();
        this.memo = other.getMemo();
        this.inputtime = other.getInputtime();
        this.operator = other.getOperator();
        this.status = other.getStatus();
        this.repairdate = other.getRepairdate();
        this.cardphoto = other.getCardphoto();
        this.cardkind = other.getCardkind();
        this.staffstatus = other.getStaffstatus();
        this.ifRecordno = other.getIfRecordno();
        this.ifDeptcode = other.getIfDeptcode();
        this.deptname = other.getDeptname();
        this.hasexport = other.getHasexport();
        this.dsource = other.getDsource();
        this.reReason = other.getReReason();
        this.exportDate = other.getExportDate();
        this.exptoweb = other.getExptoweb();
        this.exptowebtime = other.getExptowebtime();
        this.auditIdeaCode = other.getAuditIdeaCode();
        this.auditIdeaContent = other.getAuditIdeaContent();
        this.auditUserCode = other.getAuditUserCode();
        this.auditDate = other.getAuditDate();

    }

    public void copyNotNullProperty(LawExecutor other) {

        if (other.getStaffno() != null)
            this.setStaffno(other.getStaffno());

        if (other.getPasscode() != null)
            this.passcode = other.getPasscode();
        if (other.getStaffname() != null)
            this.staffname = other.getStaffname();
        if (other.getSex() != null)
            this.sex = other.getSex();
        if (other.getNation() != null)
            this.nation = other.getNation();
        if (other.getIdcard() != null)
            this.idcard = other.getIdcard();
        if (other.getPolitics() != null)
            this.politics = other.getPolitics();
        if (other.getEducation() != null)
            this.education = other.getEducation();
        if (other.getDeptid() != null)
            this.deptid = other.getDeptid();
        if (other.getPosition() != null)
            this.position = other.getPosition();
        if (other.getTelephone() != null)
            this.telephone = other.getTelephone();
        if (other.getPlait() != null)
            this.plait = other.getPlait();
        if (other.getGetpasstime() != null)
            this.getpasstime = other.getGetpasstime();
        if (other.getIssueddept() != null)
            this.issueddept = other.getIssueddept();
        if (other.getExecutionarea() != null)
            this.executionarea = other.getExecutionarea();
        if (other.getExecutionclass() != null)
            this.executionclass = other.getExecutionclass();
        if (other.getExecutionjob() != null)
            this.executionjob = other.getExecutionjob();
        if (other.getChangepasstime() != null)
            this.changepasstime = other.getChangepasstime();
        if (other.getPasslife() != null)
            this.passlife = other.getPasslife();
        if (other.getMemo() != null)
            this.memo = other.getMemo();
        if (other.getInputtime() != null)
            this.inputtime = other.getInputtime();
        if (other.getOperator() != null)
            this.operator = other.getOperator();
        if (other.getStatus() != null)
            this.status = other.getStatus();
        if (other.getRepairdate() != null)
            this.repairdate = other.getRepairdate();
        if (other.getCardphoto() != null)
            this.cardphoto = other.getCardphoto();
        if (other.getCardkind() != null)
            this.cardkind = other.getCardkind();
        if (other.getStaffstatus() != null)
            this.staffstatus = other.getStaffstatus();
        if (other.getIfRecordno() != null)
            this.ifRecordno = other.getIfRecordno();
        if (other.getIfDeptcode() != null)
            this.ifDeptcode = other.getIfDeptcode();
        if (other.getDeptname() != null)
            this.deptname = other.getDeptname();
        if (other.getHasexport() != null)
            this.hasexport = other.getHasexport();
        if (other.getDsource() != null)
            this.dsource = other.getDsource();
        if (other.getReReason() != null)
            this.reReason = other.getReReason();
        if (other.getExportDate() != null)
            this.exportDate = other.getExportDate();
        if (other.getExptoweb() != null)
            this.exptoweb = other.getExptoweb();
        if (other.getExptowebtime() != null)
            this.exptowebtime = other.getExptowebtime();

        if (other.getAuditIdeaCode() != null)
            this.auditIdeaCode = other.getAuditIdeaCode();
        if (other.getAuditIdeaContent() != null)
            this.auditIdeaContent = other.getAuditIdeaContent();
        if (other.getAuditUserCode() != null)
            this.auditUserCode = other.getAuditUserCode();
        if (other.getAuditDate() != null)
            this.auditDate = other.getAuditDate();

    }

    public void clearProperties() {

        this.passcode = null;
        this.staffname = null;
        this.sex = null;
        this.nation = null;
        this.idcard = null;
        this.politics = null;
        this.education = null;
        this.deptid = null;
        this.position = null;
        this.telephone = null;
        this.plait = null;
        this.getpasstime = null;
        this.issueddept = null;
        this.executionarea = null;
        this.executionclass = null;
        this.executionjob = null;
        this.changepasstime = null;
        this.passlife = null;
        this.memo = null;
        this.inputtime = null;
        this.operator = null;
        this.status = null;
        this.repairdate = null;
        this.cardphoto = null;
        this.cardkind = null;
        this.staffstatus = null;
        this.ifRecordno = null;
        this.ifDeptcode = null;
        this.deptname = null;
        this.hasexport = null;
        this.dsource = null;
        this.reReason = null;
        this.exportDate = null;
        this.exptoweb = null;
        this.exptowebtime = null;
        this.auditIdeaCode = null;
        this.auditIdeaContent = null;
        this.auditUserCode = null;
        this.auditDate = null;

    }

    public String getAuditIdeaCode() {
        return auditIdeaCode;
    }

    public void setAuditIdeaCode(String auditIdeaCode) {
        this.auditIdeaCode = auditIdeaCode;
    }

    public String getAuditIdeaContent() {
        return auditIdeaContent;
    }

    public void setAuditIdeaContent(String auditIdeaContent) {
        this.auditIdeaContent = auditIdeaContent;
    }

    public String getAuditUserCode() {
        return auditUserCode;
    }

    public void setAuditUserCode(String auditUserCode) {
        this.auditUserCode = auditUserCode;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }
}
