package com.centit.monitor.po;

import java.util.Date;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-5-30
 * @version
 */
public class VPunish implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String no;
    private Long changNo;
    private String orgId;
    private String internalNo;
    private String itemId;
    private String department;
    private String punishTarget;
    private Long isrisk;
    private Date createDate;
    private Date finishDate;
    private String itemType;
    private String fact;
    private String source;
    private String targetType;
    private String isTrack;
    private String topunitcode;
    private String version;
    private String monitorStyle;
    private String content;
    private String unitcode;
    private String punishDeside;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMonitorStyle() {
        return monitorStyle;
    }

    public void setMonitorStyle(String monitorStyle) {
        this.monitorStyle = monitorStyle;
    }

    public VPunish(String no, Long changNo, String orgId, String internalNo,
            String itemId, String department, String punishTarget, Long isrisk,
            Date createDate, Date finishDate, String itemType,
            String topunitcode, String isTrack, String targetType,
            String source, String fact, String version) {
        super();
        this.no = no;
        this.changNo = changNo;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.punishTarget = punishTarget;
        this.isrisk = isrisk;
        this.createDate = createDate;
        this.finishDate = finishDate;
        this.itemType = itemType;
        this.topunitcode = topunitcode;
        this.isTrack = isTrack;
        this.source = source;
        this.targetType = targetType;
        this.fact = fact;
        this.version = version;
    }

    public VPunish() {

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Long getChangNo() {
        return changNo;
    }

    public void setChangNo(Long changNo) {
        this.changNo = changNo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getIsrisk() {
        return isrisk;
    }

    public void setIsrisk(Long isrisk) {
        this.isrisk = isrisk;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTopunitcode() {
        return topunitcode;
    }

    public void setTopunitcode(String topunitcode) {
        this.topunitcode = topunitcode;
    }

    public String getPunishTarget() {
        return punishTarget;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setPunishTarget(String punishTarget) {
        this.punishTarget = punishTarget;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getIsTrack() {
        return isTrack;
    }

    public void setIsTrack(String isTrack) {
        this.isTrack = isTrack;
    }

    public void copy(VPunish other) {

        this.setNo(other.getNo());

        this.changNo = other.getChangNo();
        this.orgId = other.getOrgId();
        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.punishTarget = other.getPunishTarget();
        this.createDate = other.getCreateDate();
        this.department = other.getDepartment();
        this.isrisk = other.getIsrisk();
        this.topunitcode = other.getTopunitcode();
        this.finishDate = other.getFinishDate();
        this.isTrack = other.getIsTrack();
        this.fact = other.getFact();
        this.source = other.getSource();
        this.targetType = other.getTargetType();
        this.version = other.getVersion();
    }

    public void copyNotNullProperty(VPunish other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getChangNo() != null)
            this.changNo = other.getChangNo();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getPunishTarget() != null)
            this.punishTarget = other.getPunishTarget();
        if (other.getCreateDate() != null)
            this.createDate = other.getCreateDate();
        if (other.getDepartment() != null)
            this.department = other.getDepartment();
        if (other.getIsrisk() != null)
            this.isrisk = other.getIsrisk();
        if (other.getTopunitcode() != null)
            this.topunitcode = other.getTopunitcode();

        if (other.getFinishDate() != null)
            this.finishDate = other.getFinishDate();
        if (other.getIsTrack() != null)
            this.isTrack = other.getIsTrack();
        if (other.getSource() != null)
            this.source = other.getSource();
        if (other.getTargetType() != null)
            this.targetType = other.getTargetType();

        if (other.getFact() != null)
            this.fact = other.getFact();
        if (other.getVersion() != null) {
            this.version = other.getVersion();
        }
    }

    public void clearProperties() {

        this.changNo = null;
        this.orgId = null;
        this.internalNo = null;
        this.itemId = null;
        this.punishTarget = null;
        this.createDate = null;
        this.department = null;
        this.isrisk = null;
        this.topunitcode = null;
        this.finishDate = null;
        this.fact = null;
        this.source = null;
        this.targetType = null;
        this.isTrack = null;
        this.version = null;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getPunishDeside() {
        return punishDeside;
    }

    public void setPunishDeside(String punishDeside) {
        this.punishDeside = punishDeside;
    }

}
