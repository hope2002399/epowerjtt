package com.centit.powerbase.po;

import java.util.Date;

public class PowerRisk implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String itemId;
    private String riskType;
    private String riskDescrib;
    private String riskControlWay;
    private String remark;
    private Date lastModifyDate;

    /*----构造函数-----*/
    public PowerRisk() {

    }

    /*--full constructor--*/
    public PowerRisk(String itemId, String riskType, String riskDescrib,
            String riskControlWay, String remark, Date lastModifyDate) {
        // super();
        this.itemId = itemId;// 权力编码
        this.riskType = riskType;
        this.riskDescrib = riskDescrib;
        this.riskControlWay = riskControlWay;
        this.remark = remark;
        this.lastModifyDate = lastModifyDate;
    }

    /*---复制对象--*/
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

    public void copy(PowerRisk other) {
        this.itemId = other.getItemId();
        this.lastModifyDate = other.getLastModifyDate();
        this.remark = other.getRemark();
        this.riskControlWay = other.getRiskControlWay();
        this.riskDescrib = other.getRiskDescrib();
        this.riskType = other.getRiskType();

    }

    public void copyNotNullProperty(PowerRisk other) {
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
    }

    public void clearProperties() {
        this.itemId = null;
        this.lastModifyDate = null;
        this.remark = null;
        this.riskControlWay = null;
        this.riskDescrib = null;
        this.riskType = null;
    }

    /*
     * 
     * @Override public String toString() { return "ApplyMajor [itemId=" +
     * itemId + ", riskType=" + riskType + ", riskDescrib=" + riskDescrib +
     * ", riskControlWay=" + riskControlWay + ", remark=" + remark +
     * ", lastModifyDate=" + lastModifyDate + ", no=" + no + "]"; }
     */

}
