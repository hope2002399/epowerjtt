package com.centit.powerruntime.po;

import java.util.Date;

import com.centit.powerbase.po.PowerOrgInfoId;

/**
 * 
 * TODO Class description should be added
 * 
 * @author hx
 * @create 2012-12-7
 * @version
 */
public class VPowerOrgInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PowerOrgInfoId cid;

    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    private String wfcode;
    private String setoperator;
    private Date setime;
    private String item_type;
    private String wfName;
    private String unitName;

    public String getWfName() {
        return wfName;
    }

    public void setWfName(String wfName) {
        this.wfName = wfName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    // Constructors
    /** default constructor */
    public VPowerOrgInfo() {
    }

    /** minimal constructor */
    public VPowerOrgInfo(PowerOrgInfoId id

    ) {
        this.cid = id;

    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    /** full constructor */
    public VPowerOrgInfo(PowerOrgInfoId id

    , String wfcode, String setoperator, Date setime) {
        this.cid = id;

        this.wfcode = wfcode;
        this.setoperator = setoperator;
        this.setime = setime;
    }

    public PowerOrgInfoId getCid() {
        return this.cid;
    }

    public void setCid(PowerOrgInfoId id) {
        this.cid = id;
    }

    public String getItemId() {
        if (this.cid == null)
            this.cid = new PowerOrgInfoId();
        return this.cid.getItemId();
    }

    public void setItemId(String itemId) {
        if (this.cid == null)
            this.cid = new PowerOrgInfoId();
        this.cid.setItemId(itemId);
    }

    public String getUnitcode() {
        if (this.cid == null)
            this.cid = new PowerOrgInfoId();
        return this.cid.getUnitcode();
    }

    public void setUnitcode(String unitcode) {
        if (this.cid == null)
            this.cid = new PowerOrgInfoId();
        this.cid.setUnitcode(unitcode);
    }

    // Property accessors

    public String getWfcode() {
        return this.wfcode;
    }

    public void setWfcode(String wfcode) {
        this.wfcode = wfcode;
    }

    public String getSetoperator() {
        return this.setoperator;
    }

    public void setSetoperator(String setoperator) {
        this.setoperator = setoperator;
    }

    public Date getSetime() {
        return this.setime;
    }

    public void setSetime(Date setime) {
        this.setime = setime;
    }

    public void copy(VPowerOrgInfo other) {

        this.setItemId(other.getItemId());
        this.setUnitcode(other.getUnitcode());

        this.wfcode = other.getWfcode();
        this.setoperator = other.getSetoperator();
        this.setime = other.getSetime();

    }

    public VPowerOrgInfo(PowerOrgInfoId cid, String itemName, String wfcode,
            String setoperator, Date setime, String item_type, String wfName,
            String unitName) {
        super();
        this.cid = cid;
        this.itemName = itemName;
        this.wfcode = wfcode;
        this.setoperator = setoperator;
        this.setime = setime;
        this.item_type = item_type;
        this.wfName = wfName;
        this.unitName = unitName;
    }

    public void copyNotNullProperty(VPowerOrgInfo other) {

        if (other.getItemId() != null)
            this.setItemId(other.getItemId());
        if (other.getUnitcode() != null)
            this.setUnitcode(other.getUnitcode());

        if (other.getWfcode() != null)
            this.wfcode = other.getWfcode();
        if (other.getSetoperator() != null)
            this.setoperator = other.getSetoperator();
        if (other.getSetime() != null)
            this.setime = other.getSetime();

    }

    public void clearProperties() {

        this.wfcode = null;
        this.setoperator = null;
        this.setime = null;

    }
}
