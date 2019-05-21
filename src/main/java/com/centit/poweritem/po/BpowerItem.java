package com.centit.poweritem.po;

import java.util.Date;

public class BpowerItem implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String itemId;
    private String itemName;
    private String itemType;
    private String itemStatus;
    private String parentId;
    private String parentName;
    private String isContainSub;
    private String orgId;
    private String spObject;
    private String useLevel;
    private String useUnit;
    private String linkPhone;
    private String monitorPhone;
    private String httpUrl;
    private String dealAddress;
    private String dealTime;
    private String lawAccording;
    private String remark;
    private String isNetwork;
    private Date createTime;
    private Date modifyTime;
    private String itemQldyItemId;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getIsContainSub() {
        return isContainSub;
    }

    public void setIsContainSub(String isContainSub) {
        this.isContainSub = isContainSub;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSpObject() {
        return spObject;
    }

    public void setSpObject(String spObject) {
        this.spObject = spObject;
    }

    public String getUseLevel() {
        return useLevel;
    }

    public void setUseLevel(String useLevel) {
        this.useLevel = useLevel;
    }

    public String getUseUnit() {
        return useUnit;
    }

    public void setUseUnit(String useUnit) {
        this.useUnit = useUnit;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getMonitorPhone() {
        return monitorPhone;
    }

    public void setMonitorPhone(String monitorPhone) {
        this.monitorPhone = monitorPhone;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public String getDealAddress() {
        return dealAddress;
    }

    public void setDealAddress(String dealAddress) {
        this.dealAddress = dealAddress;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getLawAccording() {
        return lawAccording;
    }

    public void setLawAccording(String lawAccording) {
        this.lawAccording = lawAccording;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsNetwork() {
        return isNetwork;
    }

    public void setIsNetwork(String isNetwork) {
        this.isNetwork = isNetwork;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getItemQldyItemId() {
        return itemQldyItemId;
    }

    public void setItemQldyItemId(String itemQldyItemId) {
        this.itemQldyItemId = itemQldyItemId;
    }

    public BpowerItem() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BpowerItem(String itemId, String itemName, String itemType,
            String itemStatus, String parentId, String parentName,
            String isContainSub, String orgId, String spObject,
            String useLevel, String useUnit, String linkPhone,
            String monitorPhone, String httpUrl, String dealAddress,
            String dealTime, String lawAccording, String remark,
            String isNetwork, Date createTime, Date modifyTime) {
        super();
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemStatus = itemStatus;
        this.parentId = parentId;
        this.parentName = parentName;
        this.isContainSub = isContainSub;
        this.orgId = orgId;
        this.spObject = spObject;
        this.useLevel = useLevel;
        this.useUnit = useUnit;
        this.linkPhone = linkPhone;
        this.monitorPhone = monitorPhone;
        this.httpUrl = httpUrl;
        this.dealAddress = dealAddress;
        this.dealTime = dealTime;
        this.lawAccording = lawAccording;
        this.remark = remark;
        this.isNetwork = isNetwork;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public void copy(BpowerItem other) {
        this.itemName = other.getItemName();
        this.itemType = other.getItemType();
        this.itemStatus = other.getItemStatus();
        this.parentId = other.getParentId();
        this.parentName = other.getParentName();
        this.isContainSub = other.getIsContainSub();
        this.orgId = other.getOrgId();
        this.spObject = other.getSpObject();
        this.useLevel = other.getUseLevel();
        this.useUnit = other.getUseUnit();
        this.linkPhone = other.getLinkPhone();
        this.monitorPhone = other.getMonitorPhone();
        this.httpUrl = other.getHttpUrl();
        this.dealAddress = other.getDealAddress();
        this.dealTime = other.getDealTime();
        this.lawAccording = other.getLawAccording();
        this.remark = other.getRemark();
        this.isNetwork = other.getIsNetwork();
        this.createTime = other.getCreateTime();
        this.modifyTime = other.getModifyTime();
        this.itemQldyItemId = other.getItemQldyItemId();

    }

    public void copyNotNullProperty(BpowerItem other) {
        if (other.getItemName() != null)
            this.itemName = other.getItemName();
        if (other.getItemType() != null)
            this.itemType = other.getItemType();
        if (other.getItemStatus() != null)
            this.itemStatus = other.getItemStatus();
        if (other.getParentId() != null)
            this.parentId = other.getParentId();
        if (other.getParentName() != null)
            this.parentName = other.getParentName();
        if (other.getIsContainSub() != null)
            this.isContainSub = other.getIsContainSub();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getSpObject() != null)
            this.spObject = other.getSpObject();
        if (other.getUseLevel() != null)
            this.useLevel = other.getUseLevel();
        if (other.getUseUnit() != null)
            this.useUnit = other.getUseUnit();
        if (other.getLinkPhone() != null)
            this.linkPhone = other.getLinkPhone();
        if (other.getMonitorPhone() != null)
            this.monitorPhone = other.getMonitorPhone();
        if (other.getHttpUrl() != null)
            this.httpUrl = other.getHttpUrl();
        if (other.getDealAddress() != null)
            this.dealAddress = other.getDealAddress();
        if (other.getDealTime() != null)
            this.dealTime = other.getDealTime();
        if (other.getLawAccording() != null)
            this.lawAccording = other.getLawAccording();
        if (other.getRemark() != null)
            this.remark = other.getRemark();
        if (other.getIsNetwork() != null)
            this.isNetwork = other.getIsNetwork();
        if (other.getCreateTime() != null)
            this.createTime = other.getCreateTime();
        if (other.getModifyTime() != null)
            this.modifyTime = other.getModifyTime();
        if (other.getItemQldyItemId() != null)
            this.itemQldyItemId = other.getItemQldyItemId();
    }

    public void clearProperties() {
        this.itemId = null;
        this.itemName = null;
        this.itemType = null;
        this.itemStatus = null;
        this.parentId = null;
        this.parentName = null;
        this.isContainSub = null;
        this.orgId = null;
        this.spObject = null;
        this.useLevel = null;
        this.useUnit = null;
        this.linkPhone = null;
        this.monitorPhone = null;
        this.httpUrl = null;
        this.dealAddress = null;
        this.dealTime = null;
        this.lawAccording = null;
        this.remark = null;
        this.isNetwork = null;
        this.createTime = null;
        this.modifyTime = null;
        this.itemQldyItemId = null;
    }
}
