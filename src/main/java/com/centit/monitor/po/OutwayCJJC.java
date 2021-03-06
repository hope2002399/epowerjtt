package com.centit.monitor.po;

// Generated 2013-12-17 16:44:14 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * SupDbycOutway generated by hbm2java
 */
public class OutwayCJJC implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private long outwayid;
    private String warnpointno;
    private String oldOutwayId;
    private String outwaytype;
    private Date intime;
    private Date outtime;
    private String outperson;
    private String outreason;
    private String outwayinfo;
    private Date updateDate;
    private Date readDate;
    private String syncSign;
    private String errorDesc;
    private Boolean ischeck;
    private Boolean issync;
    // private Boolean isYj;
    private String orgId;
    private String internalNo;
    private String oldOutwayType;
    private String itemId;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getOldOutwayType() {
        return oldOutwayType;
    }

    public void setOldOutwayType(String oldOutwayType) {
        this.oldOutwayType = oldOutwayType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public OutwayCJJC() {
    }

    public OutwayCJJC(long outwayid, String warnpointno, String oldOutwayId,
            String outwaytype, Date intime, Date updateDate) {
        this.outwayid = outwayid;
        this.warnpointno = warnpointno;
        this.oldOutwayId = oldOutwayId;
        this.outwaytype = outwaytype;
        this.intime = intime;
        this.updateDate = updateDate;
    }

    public OutwayCJJC(long outwayid, String warnpointno, String oldOutwayId,
            String outwaytype, Date intime, Date outtime, String outperson,
            String outreason, String outwayinfo, Date updateDate,
            Date readDate, String syncSign, String errorDesc, Boolean ischeck,
            Boolean issync, String orgId) {
        this.outwayid = outwayid;
        this.warnpointno = warnpointno;
        this.oldOutwayId = oldOutwayId;
        this.outwaytype = outwaytype;
        this.intime = intime;
        this.outtime = outtime;
        this.outperson = outperson;
        this.outreason = outreason;
        this.outwayinfo = outwayinfo;
        this.updateDate = updateDate;
        this.readDate = readDate;
        this.syncSign = syncSign;
        this.errorDesc = errorDesc;
        this.ischeck = ischeck;
        this.issync = issync;
        this.orgId = orgId;
        // this.isYj = isYj;
    }

    public long getOutwayid() {
        return this.outwayid;
    }

    public void setOutwayid(long outwayid) {
        this.outwayid = outwayid;
    }

    public String getWarnpointno() {
        return this.warnpointno;
    }

    public void setWarnpointno(String warnpointno) {
        this.warnpointno = warnpointno;
    }

    public String getOldOutwayId() {
        return this.oldOutwayId;
    }

    public void setOldOutwayId(String oldOutwayId) {
        this.oldOutwayId = oldOutwayId;
    }

    public String getOutwaytype() {
        return this.outwaytype;
    }

    public void setOutwaytype(String outwaytype) {
        this.outwaytype = outwaytype;
    }

    public Date getIntime() {
        return this.intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return this.outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public String getOutperson() {
        return this.outperson;
    }

    public void setOutperson(String outperson) {
        this.outperson = outperson;
    }

    public String getOutreason() {
        return this.outreason;
    }

    public void setOutreason(String outreason) {
        this.outreason = outreason;
    }

    public String getOutwayinfo() {
        return this.outwayinfo;
    }

    public void setOutwayinfo(String outwayinfo) {
        this.outwayinfo = outwayinfo;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getReadDate() {
        return this.readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public String getSyncSign() {
        return this.syncSign;
    }

    public void setSyncSign(String syncSign) {
        this.syncSign = syncSign;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public Boolean getIscheck() {
        return this.ischeck;
    }

    public void setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }

    public Boolean getIssync() {
        return this.issync;
    }

    public void setIssync(Boolean issync) {
        this.issync = issync;
    }

    /*
     * public Boolean getIsYj() { return this.isYj; }
     * 
     * public void setIsYj(Boolean isYj) { this.isYj = isYj; }
     */

    public void copy(OutwayCJJC other) {
        this.setOutwayid(other.getOutwayid());
        this.setWarnpointno(other.getWarnpointno());
        this.setOldOutwayId(other.getOldOutwayId());
        this.setOutwaytype(other.getOutwaytype());
        this.setIntime(other.getIntime());
        this.setOuttime(other.getOuttime());
        this.setOutperson(other.getOutperson());
        this.setOutreason(other.getOutreason());
        this.setOutwayinfo(other.getOutwayinfo());
        this.setUpdateDate(other.getUpdateDate());
        this.setReadDate(other.getReadDate());
        this.setSyncSign(other.getSyncSign());
        this.setErrorDesc(other.getErrorDesc());
        this.setIscheck(other.getIscheck());
        this.setIssync(other.getIssync());
        this.setOrgId(other.getOrgId());
        this.setInternalNo(other.getInternalNo());
        // this.setIsYj(other.getIsYj());
        this.setOldOutwayType(other.getOldOutwayType());
    }

}
