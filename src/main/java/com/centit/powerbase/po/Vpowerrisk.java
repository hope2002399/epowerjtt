package com.centit.powerbase.po;

import java.util.Date;

public class Vpowerrisk {
    private String itemId;
    private String riskType;
    private String riskDescrib;
    private String riskControlWay;
    private String remark;
    private Date lastModifyDate;
    private String itemName;
    private String orgId;
    private String itemType;
    private String version;

    public Vpowerrisk() {

    }

    public Vpowerrisk(String itemId, String riskType, String riskDescrib,
            String riskControlWay, String remark, Date lastModifyDate,
            String itemName, String orgId, String itemType, String version) {
        super();
        this.itemId = itemId;
        this.riskType = riskType;
        this.riskDescrib = riskDescrib;
        this.riskControlWay = riskControlWay;
        this.remark = remark;
        this.lastModifyDate = lastModifyDate;
        this.itemName = itemName;
        this.orgId = orgId;
        this.itemType = itemType;
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getRiskDescrib() {
        return riskDescrib;
    }

    public void setRiskDescrib(String riskDescrib) {
        this.riskDescrib = riskDescrib;
    }

    public String getRiskControlWay() {
        return riskControlWay;
    }

    public void setRiskControlWay(String riskControlWay) {
        this.riskControlWay = riskControlWay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void copy(Vpowerrisk other) {
        this.itemId = other.getItemId();
        this.lastModifyDate = other.getLastModifyDate();
        this.remark = other.getRemark();
        this.riskControlWay = other.getRiskControlWay();
        this.riskDescrib = other.getRiskDescrib();
        this.riskType = other.getRiskType();
        this.itemName = other.getItemName();
        this.itemType = other.getItemType();
        this.orgId = other.getOrgId();
        this.version = other.version;

    }

    public void copyNotNullProperty(Vpowerrisk other) {
        if (other.itemId != null)
            this.itemId = other.getItemId();
        if (other.lastModifyDate != null)
            this.lastModifyDate = other.getLastModifyDate();
        if (other.remark != null)
            this.remark = other.getRemark();
        if (other.riskControlWay != null)
            this.riskControlWay = other.getRiskControlWay();
        if (other.riskDescrib != null)
            this.riskDescrib = other.getRiskDescrib();
        if (other.riskType != null)
            this.riskType = other.getRiskType();
        if (other.itemName != null)
            this.itemName = other.getItemName();
        if (other.itemType != null)
            this.riskType = other.getItemType();
        if (other.orgId != null)
            this.orgId = other.getOrgId();
        if (other.version != null)
            this.version = other.version;
    }

    public void clearProperties() {
        this.itemId = null;
        this.lastModifyDate = null;
        this.remark = null;
        this.riskControlWay = null;
        this.riskDescrib = null;
        this.riskType = null;
        this.itemName = null;
        this.itemType = null;
        this.orgId = null;
        this.version = null;
    }

}
