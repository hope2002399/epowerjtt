package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VPunishForList implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String no;

    private String content;
    private String orgId;
    private String internalNo;
    private String itemId;
    private String department;
    private String punishTarget;
    private String istrack;
    private String targetType;
    private Date createDate;
    private Long isrisk;
    private String itemType;
    private String topunitcode;
    private String unitcode;
    private String monitorStyle;
    private Date finishDate;

    // Constructors
    /** default constructor */
    public VPunishForList() {
    }

    /** minimal constructor */
    public VPunishForList(String no, String orgId, String internalNo,
            String itemId, String department, String punishTarget,
            String targetType, Date createDate) {

        this.no = no;

        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.punishTarget = punishTarget;
        this.targetType = targetType;
        this.createDate = createDate;
    }

    /** full constructor */
    public VPunishForList(String no, String content, String orgId,
            String internalNo, String itemId, String department,
            String punishTarget, String istrack, String targetType,
            Date createDate, Long isrisk, String itemType, String topunitcode,
            String unitcode, String monitorStyle, Date finishDate) {

        this.no = no;

        this.content = content;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.punishTarget = punishTarget;
        this.istrack = istrack;
        this.targetType = targetType;
        this.createDate = createDate;
        this.isrisk = isrisk;
        this.itemType = itemType;
        this.topunitcode = topunitcode;
        this.unitcode = unitcode;
        this.monitorStyle = monitorStyle;
        this.finishDate = finishDate;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // Property accessors

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPunishTarget() {
        return this.punishTarget;
    }

    public void setPunishTarget(String punishTarget) {
        this.punishTarget = punishTarget;
    }

    public String getIstrack() {
        return this.istrack;
    }

    public void setIstrack(String istrack) {
        this.istrack = istrack;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getIsrisk() {
        return this.isrisk;
    }

    public void setIsrisk(Long isrisk) {
        this.isrisk = isrisk;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTopunitcode() {
        return this.topunitcode;
    }

    public void setTopunitcode(String topunitcode) {
        this.topunitcode = topunitcode;
    }

    public String getUnitcode() {
        return this.unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getMonitorStyle() {
        return this.monitorStyle;
    }

    public void setMonitorStyle(String monitorStyle) {
        this.monitorStyle = monitorStyle;
    }

    public Date getFinishDate() {
        return this.finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public VPunishForList copy(VPunishForList other) {

        this.setNo(other.getNo());

        this.content = other.getContent();
        this.orgId = other.getOrgId();
        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.department = other.getDepartment();
        this.punishTarget = other.getPunishTarget();
        this.istrack = other.getIstrack();
        this.targetType = other.getTargetType();
        this.createDate = other.getCreateDate();
        this.isrisk = other.getIsrisk();
        this.itemType = other.getItemType();
        this.topunitcode = other.getTopunitcode();
        this.unitcode = other.getUnitcode();
        this.monitorStyle = other.getMonitorStyle();
        this.finishDate = other.getFinishDate();

        return this;
    }

    public VPunishForList copyNotNullProperty(VPunishForList other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getContent() != null)
            this.content = other.getContent();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getDepartment() != null)
            this.department = other.getDepartment();
        if (other.getPunishTarget() != null)
            this.punishTarget = other.getPunishTarget();
        if (other.getIstrack() != null)
            this.istrack = other.getIstrack();
        if (other.getTargetType() != null)
            this.targetType = other.getTargetType();
        if (other.getCreateDate() != null)
            this.createDate = other.getCreateDate();
        if (other.getIsrisk() != null)
            this.isrisk = other.getIsrisk();
        if (other.getItemType() != null)
            this.itemType = other.getItemType();
        if (other.getTopunitcode() != null)
            this.topunitcode = other.getTopunitcode();
        if (other.getUnitcode() != null)
            this.unitcode = other.getUnitcode();
        if (other.getMonitorStyle() != null)
            this.monitorStyle = other.getMonitorStyle();
        if (other.getFinishDate() != null)
            this.finishDate = other.getFinishDate();

        return this;
    }

    public VPunishForList clearProperties() {

        this.content = null;
        this.orgId = null;
        this.internalNo = null;
        this.itemId = null;
        this.department = null;
        this.punishTarget = null;
        this.istrack = null;
        this.targetType = null;
        this.createDate = null;
        this.isrisk = null;
        this.itemType = null;
        this.topunitcode = null;
        this.unitcode = null;
        this.monitorStyle = null;
        this.finishDate = null;

        return this;
    }
}
