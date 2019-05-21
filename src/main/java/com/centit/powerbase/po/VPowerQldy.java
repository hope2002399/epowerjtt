package com.centit.powerbase.po;

public class VPowerQldy implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String itemId;
    private String itemName;
    private String itemType;
    private String orgId;

    private String otherItemId;
    private String otherNbId;

    /*----构造函数-----*/
    public VPowerQldy() {

    }

    public VPowerQldy(String itemId, String itemName, String itemType,
            String orgId, String otherItemId, String otherNbId) {
        super();
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.orgId = orgId;
        this.otherItemId = otherItemId;
        this.otherNbId = otherNbId;
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public VPowerQldy(String itemId, String otherItemId, String otherNbId) {
        super();
        this.itemId = itemId;
        this.otherItemId = otherItemId;
        this.otherNbId = otherNbId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setiItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getOtherItemId() {
        return otherItemId;
    }

    public void setOtherItemId(String otherItemId) {
        this.otherItemId = otherItemId;
    }

    public String getOtherNbId() {
        return otherNbId;
    }

    public void setOtherNbId(String otherNbId) {
        this.otherNbId = otherNbId;
    }

    public void copy(VPowerQldy other) {
        this.itemId = other.getItemId();
        this.otherItemId = other.getOtherItemId();
        this.otherNbId = other.getOtherNbId();
        this.itemName = other.getItemName();
        this.itemType = other.getItemType();
        this.orgId = other.getOrgId();

    }

    public void copyNotNullProperty(VPowerQldy other) {
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getOtherItemId() != null)
            this.otherItemId = other.getOtherItemId();
        if (other.getOtherNbId() != null)
            this.otherNbId = other.getOtherNbId();
        if (other.getItemName() != null)
            this.itemName = other.getItemName();
        if (other.getItemType() != null)
            this.itemType = other.getItemType();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();

    }

    public void clearProperties() {
        this.itemId = null;
        this.otherItemId = null;
        this.otherNbId = null;
        this.orgId = null;
        this.itemName = null;
        this.itemType = null;
    }

    /*
     * 
     * @Override public String toString() { return "ApplyMajor [itemId=" +
     * itemId + ", riskType=" + riskType + ", riskDescrib=" + riskDescrib +
     * ", riskControlWay=" + riskControlWay + ", remark=" + remark +
     * ", lastModifyDate=" + lastModifyDate + ", no=" + no + "]"; }
     */

}
