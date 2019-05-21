package com.centit.powerbase.po;

public class PowerQldy implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String powerItemId;
    private String otherItemId;
    private String otherNbId;

    /*----构造函数-----*/
    public PowerQldy() {

    }

    public PowerQldy(String bPowerItemId, String otherItemId, String otherNbId) {
        super();
        this.powerItemId = bPowerItemId;
        this.otherItemId = otherItemId;
        this.otherNbId = otherNbId;
    }

    public String getPowerItemId() {
        return powerItemId;
    }

    public void setPowerItemId(String powerItemId) {
        this.powerItemId = powerItemId;
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

    public void copy(PowerQldy other) {
        this.powerItemId = other.getPowerItemId();
        this.otherItemId = other.getOtherItemId();
        this.otherNbId = other.getOtherNbId();

    }

    public void copyNotNullProperty(PowerQldy other) {
        if (other.getPowerItemId() != null)
            this.powerItemId = other.getPowerItemId();
        if (other.getOtherItemId() != null)
            this.otherItemId = other.getOtherItemId();
        if (other.getOtherNbId() != null)
            this.otherNbId = other.getOtherNbId();

    }

    public void clearProperties() {
        this.powerItemId = null;
        this.otherItemId = null;
        this.otherNbId = null;
    }

    /*
     * 
     * @Override public String toString() { return "ApplyMajor [itemId=" +
     * itemId + ", riskType=" + riskType + ", riskDescrib=" + riskDescrib +
     * ", riskControlWay=" + riskControlWay + ", remark=" + remark +
     * ", lastModifyDate=" + lastModifyDate + ", no=" + no + "]"; }
     */

}
