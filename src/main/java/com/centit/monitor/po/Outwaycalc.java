package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Outwaycalc implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long calcNo;

    private Date calcTime;
    private String callType;
    private String caller;
    private Date scopeBegin;
    private Date scopeEnd;
    private Long alertPieces;
    private Long alarmPieces;

    // Constructors
    /** default constructor */
    public Outwaycalc() {
    }

    /** minimal constructor */
    public Outwaycalc(Long calcNo, Date calcTime, String callType) {

        this.calcNo = calcNo;

        this.calcTime = calcTime;
        this.callType = callType;
    }

    /** full constructor */
    public Outwaycalc(Long calcNo, Date calcTime, String callType,
            String caller, Date scopeBegin, Date scopeEnd, Long alertPieces,
            Long alarmPieces) {

        this.calcNo = calcNo;

        this.calcTime = calcTime;
        this.callType = callType;
        this.caller = caller;
        this.scopeBegin = scopeBegin;
        this.scopeEnd = scopeEnd;
        this.alertPieces = alertPieces;
        this.alarmPieces = alarmPieces;
    }

    public Long getCalcNo() {
        return this.calcNo;
    }

    public void setCalcNo(Long calcNo) {
        this.calcNo = calcNo;
    }

    // Property accessors

    public Date getCalcTime() {
        return this.calcTime;
    }

    public void setCalcTime(Date calcTime) {
        this.calcTime = calcTime;
    }

    public String getCallType() {
        return this.callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCaller() {
        return this.caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public Date getScopeBegin() {
        return this.scopeBegin;
    }

    public void setScopeBegin(Date scopeBegin) {
        this.scopeBegin = scopeBegin;
    }

    public Date getScopeEnd() {
        return this.scopeEnd;
    }

    public void setScopeEnd(Date scopeEnd) {
        this.scopeEnd = scopeEnd;
    }

    public Long getAlertPieces() {
        return this.alertPieces;
    }

    public void setAlertPieces(Long alertPieces) {
        this.alertPieces = alertPieces;
    }

    public Long getAlarmPieces() {
        return this.alarmPieces;
    }

    public void setAlarmPieces(Long alarmPieces) {
        this.alarmPieces = alarmPieces;
    }

    public void copy(Outwaycalc other) {

        this.setCalcNo(other.getCalcNo());

        this.calcTime = other.getCalcTime();
        this.callType = other.getCallType();
        this.caller = other.getCaller();
        this.scopeBegin = other.getScopeBegin();
        this.scopeEnd = other.getScopeEnd();
        this.alertPieces = other.getAlertPieces();
        this.alarmPieces = other.getAlarmPieces();

    }

    public void copyNotNullProperty(Outwaycalc other) {

        if (other.getCalcNo() != null)
            this.setCalcNo(other.getCalcNo());

        if (other.getCalcTime() != null)
            this.calcTime = other.getCalcTime();
        if (other.getCallType() != null)
            this.callType = other.getCallType();
        if (other.getCaller() != null)
            this.caller = other.getCaller();
        if (other.getScopeBegin() != null)
            this.scopeBegin = other.getScopeBegin();
        if (other.getScopeEnd() != null)
            this.scopeEnd = other.getScopeEnd();
        if (other.getAlertPieces() != null)
            this.alertPieces = other.getAlertPieces();
        if (other.getAlarmPieces() != null)
            this.alarmPieces = other.getAlarmPieces();

    }

    public void clearProperties() {

        this.calcTime = null;
        this.callType = null;
        this.caller = null;
        this.scopeBegin = null;
        this.scopeEnd = null;
        this.alertPieces = null;
        this.alarmPieces = null;

    }
}
