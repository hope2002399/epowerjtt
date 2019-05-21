package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Outway implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String outwayno;

    private String bjType;
    private String bjNo;
    private String processNo;
    private Long calcNo;
    private String orgId;
    private String internalNo;
    private String itemId;
    private String monitorStyle;
    private String monitorType;
    private String monitorLogo;
    private Date intime;
    private Date outtime;
    private String outperson;
    private String outreason;
    private Date updateDate;
    private Date readDate;
    private String syncSign;
    private String errorDesc;
    // 2013-6-17 add 作为预报警摘牌标志 1: 正常 0：取消
    private String OutWayState;
    // 2014-2-11 add
    private String monitorDesc;
    private String monitorSource;
    private String warningCode;

    // 层级监察产生异常的预警对应的bjType
    private String bjType2;

    public String getBjType2() {
        return bjType2;
    }

    public void setBjType2(String bjType2) {
        this.bjType2 = bjType2;
    }

    public String getMonitorDesc() {
        return monitorDesc;
    }

    public void setMonitorDesc(String monitorDesc) {
        this.monitorDesc = monitorDesc;
    }

    public String getMonitorSource() {
        return monitorSource;
    }

    public void setMonitorSource(String monitorSource) {
        this.monitorSource = monitorSource;
    }

    public String getWarningCode() {
        return warningCode;
    }

    public void setWarningCode(String warningCode) {
        this.warningCode = warningCode;
    }

    public String getOutWayState() {
        return OutWayState;
    }

    public void setOutWayState(String outWayState) {
        OutWayState = outWayState;
    }

    // Constructors
    /** default constructor */
    public Outway() {
    }

    /** minimal constructor */
    public Outway(String outwayno, String bjType, String orgId,
            String internalNo, String itemId, String monitorStyle, Date intime,
            Date updateDate, String OutWayState, String bjType2) {

        this.outwayno = outwayno;

        this.bjType = bjType;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.monitorStyle = monitorStyle;
        this.intime = intime;
        this.updateDate = updateDate;
        this.OutWayState = OutWayState;

    }

    /** full constructor */
    public Outway(String outwayno, String bjType, String bjNo,
            String processNo, Long calcNo, String orgId, String internalNo,
            String itemId, String monitorStyle, String monitorType,
            String monitorLogo, Date intime, Date outtime, String outperson,
            String outreason, Date updateDate, Date readDate, String syncSign,
            String errorDesc, String OutWayState, String monitorDesc,
            String monitorSource, String warningCode, String bjType2) {

        this.outwayno = outwayno;

        this.bjType = bjType;
        this.bjNo = bjNo;
        this.processNo = processNo;
        this.calcNo = calcNo;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.monitorStyle = monitorStyle;
        this.monitorType = monitorType;
        this.monitorLogo = monitorLogo;
        this.intime = intime;
        this.outtime = outtime;
        this.outperson = outperson;
        this.outreason = outreason;
        this.updateDate = updateDate;
        this.readDate = readDate;
        this.syncSign = syncSign;
        this.errorDesc = errorDesc;

        this.OutWayState = OutWayState;

        this.monitorDesc = monitorDesc;
        this.monitorSource = monitorSource;
        this.warningCode = warningCode;

    }

    public String getOutwayno() {
        return this.outwayno;
    }

    public void setOutwayno(String outwayno) {
        this.outwayno = outwayno;
    }

    // Property accessors

    public String getBjType() {
        return this.bjType;
    }

    public void setBjType(String bjType) {
        this.bjType = bjType;
    }

    public String getBjNo() {
        return this.bjNo;
    }

    public void setBjNo(String bjNo) {
        this.bjNo = bjNo;
    }

    public String getProcessNo() {
        return this.processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo;
    }

    public Long getCalcNo() {
        return this.calcNo;
    }

    public void setCalcNo(Long calcNo) {
        this.calcNo = calcNo;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getInternalNo() {
        return this.internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMonitorStyle() {
        return this.monitorStyle;
    }

    public void setMonitorStyle(String monitorStyle) {
        this.monitorStyle = monitorStyle;
    }

    public String getMonitorType() {
        return this.monitorType;
    }

    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }

    public String getMonitorLogo() {
        return this.monitorLogo;
    }

    public void setMonitorLogo(String monitorLogo) {
        this.monitorLogo = monitorLogo;
    }

    public Date getIntime() {
        return this.intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return this.outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public String getOutperson() {
        return this.outperson;
    }

    public void setOutperson(String outperson) {
        this.outperson = outperson;
    }

    public String getOutreason() {
        return this.outreason;
    }

    public void setOutreason(String outreason) {
        this.outreason = outreason;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getReadDate() {
        return this.readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public String getSyncSign() {
        return this.syncSign;
    }

    public void setSyncSign(String syncSign) {
        this.syncSign = syncSign;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public void copy(Outway other) {

        this.setOutwayno(other.getOutwayno());

        this.bjType = other.getBjType();
        this.bjNo = other.getBjNo();
        this.processNo = other.getProcessNo();
        this.calcNo = other.getCalcNo();
        this.orgId = other.getOrgId();
        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.monitorStyle = other.getMonitorStyle();
        this.monitorType = other.getMonitorType();
        this.monitorLogo = other.getMonitorLogo();
        this.intime = other.getIntime();
        this.outtime = other.getOuttime();
        this.outperson = other.getOutperson();
        this.outreason = other.getOutreason();
        this.updateDate = other.getUpdateDate();
        this.readDate = other.getReadDate();
        this.syncSign = other.getSyncSign();
        this.errorDesc = other.getErrorDesc();
        this.OutWayState = other.getOutWayState();
    }

    public void copyNotNullProperty(Outway other) {

        if (other.getOutwayno() != null)
            this.setOutwayno(other.getOutwayno());

        if (other.getBjType() != null)
            this.bjType = other.getBjType();
        if (other.getBjNo() != null)
            this.bjNo = other.getBjNo();
        if (other.getProcessNo() != null)
            this.processNo = other.getProcessNo();
        if (other.getCalcNo() != null)
            this.calcNo = other.getCalcNo();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getMonitorStyle() != null)
            this.monitorStyle = other.getMonitorStyle();
        if (other.getMonitorType() != null)
            this.monitorType = other.getMonitorType();
        if (other.getMonitorLogo() != null)
            this.monitorLogo = other.getMonitorLogo();
        if (other.getIntime() != null)
            this.intime = other.getIntime();
        if (other.getOuttime() != null)
            this.outtime = other.getOuttime();
        if (other.getOutperson() != null)
            this.outperson = other.getOutperson();
        if (other.getOutreason() != null)
            this.outreason = other.getOutreason();
        if (other.getUpdateDate() != null)
            this.updateDate = other.getUpdateDate();
        if (other.getReadDate() != null)
            this.readDate = other.getReadDate();
        if (other.getSyncSign() != null)
            this.syncSign = other.getSyncSign();
        if (other.getErrorDesc() != null)
            this.errorDesc = other.getErrorDesc();

        if (other.getOutWayState() != null)
            this.OutWayState = other.getOutWayState();

    }

    public void clearProperties() {

        this.bjType = null;
        this.bjNo = null;
        this.processNo = null;
        this.calcNo = null;
        this.orgId = null;
        this.internalNo = null;
        this.itemId = null;
        this.monitorStyle = null;
        this.monitorType = null;
        this.monitorLogo = null;
        this.intime = null;
        this.outtime = null;
        this.outperson = null;
        this.outreason = null;
        this.updateDate = null;
        this.readDate = null;
        this.syncSign = null;
        this.errorDesc = null;
        this.OutWayState = null;
    }
}
