package com.centit.powerruntime.po;

import java.util.Date;

public class OptDoubleItems implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String itemid;
    private Date applydate;
    private String applyarea;
    private String enterprisename;
    private String options;
    private String itemname;
    private String itemnumber;
    private String applynumber;
    private String linkman;
    private String applyphone;
    private String remark;
    private String county;
    private String district;

    public OptDoubleItems() {

    }

    public OptDoubleItems(String itemid) {
        this.itemid = itemid;
    }

    public OptDoubleItems(String itemid, Date applydate, String applyarea,
            String enterprisename, String options, String itemname,
            String itemnumber, String applynumber, String linkman,
            String applyphone, String remark, String county, String district) {
        this.itemid = itemid;
        this.applydate = applydate;
        this.applyarea = applyarea;
        this.enterprisename = enterprisename;
        this.options = options;
        this.itemname = itemname;
        this.itemnumber = itemnumber;
        this.applynumber = applynumber;
        this.linkman = linkman;
        this.applyphone = applyphone;
        this.remark = remark;
        this.county = county;
        this.district = district;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getApplyarea() {
        return applyarea;
    }

    public void setApplyarea(String applyarea) {
        this.applyarea = applyarea;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemnumber() {
        return itemnumber;
    }

    public void setItemnumber(String itemnumber) {
        this.itemnumber = itemnumber;
    }

    public String getApplynumber() {
        return applynumber;
    }

    public void setApplynumber(String applynumber) {
        this.applynumber = applynumber;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getApplyphone() {
        return applyphone;
    }

    public void setApplyphone(String applyphone) {
        this.applyphone = applyphone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void copy(OptDoubleItems other) {
        this.setItemid(other.getItemid());
        this.applydate = other.getApplydate();
        this.applyarea = other.getApplyarea();
        this.enterprisename = other.getEnterprisename();
        this.options = other.getOptions();
        this.itemname = other.getItemname();
        this.itemnumber = other.getItemnumber();
        this.applynumber = other.getApplynumber();
        this.linkman = other.getLinkman();
        this.applyphone = other.getApplyphone();
        this.remark = other.getRemark();
        this.county = other.getCounty();
        this.district = other.getDistrict();
    }

    public void copyNotNullProperty(OptDoubleItems other) {

        if (other.getItemid() != null)
            this.itemid = other.getItemid();
        if (other.getApplydate() != null)
            this.applydate = other.getApplydate();
        if (other.getApplyarea() != null)
            this.applyarea = other.getApplyarea();
        if (other.getEnterprisename() != null)
            this.enterprisename = other.getEnterprisename();
        if (other.getOptions() != null)
            this.options = other.getOptions();
        if (other.getItemname() != null)
            this.itemname = other.getItemname();
        if (other.getItemnumber() != null)
            this.itemnumber = other.getItemnumber();
        if (other.getApplynumber() != null)
            this.applynumber = other.getApplynumber();
        if (other.getLinkman() != null)
            this.linkman = other.getLinkman();
        if (other.getApplyphone() != null)
            this.applyphone = other.getApplyphone();
        if (other.getRemark() != null)
            this.remark = other.getRemark();
        if (other.getCounty() != null)
            this.county = other.getCounty();
        if (other.getDistrict() != null)
            this.district = other.getDistrict();
    }

    public void clearProperties() {
        this.itemid = null;
        this.applydate = null;
        this.applyarea = null;
        this.enterprisename = null;
        this.options = null;
        this.itemname = null;
        this.itemnumber = null;
        this.applynumber = null;
        this.linkman = null;
        this.applyphone = null;
        this.remark = null;
        this.county = null;
        this.district = null;
    }

}
