package com.centit.supervise.po;

import java.util.Date;

import com.centit.monitor.po.Apply;
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VPunish;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Reconsider implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String reconsiderid;

    private Date reconsiderdate;
    private String reconsiderapply;
    private String applyphone;
    private Date applydate;
    private String applyreason;
    private String applyremark;
    private String reconsiderdep;
    private String bookoperator;
    private Date bookdate;
    private Long flowInstId;
    private String bjType;
    private String bjNo;
    private String itemId;
    private String internalNo;
    private String orgId;
    private String optId;
    private String biztype;

    private VApply vapply;
    private VPunish vpunish;
    private Apply apply;
    private Punish punish;

    private String suptype;
    private Reconsiderresult reconsiderresult;

    // Constructors
    /** default constructor */
    public Reconsider() {
    }

    /** minimal constructor */
    public Reconsider(String reconsiderid, String orgId) {

        this.reconsiderid = reconsiderid;

        this.orgId = orgId;
    }

    /** full constructor */
    public Reconsider(String reconsiderid, Date reconsiderdate,
            String reconsiderapply, String applyphone, Date applydate,
            String applyreason, String applyremark, String reconsiderdep,
            String bookoperator, Date bookdate, Long flowinstid, String bjType,
            String bjNo, String itemId, String internalNo, String orgId,
            String optid, String biztype) {

        this.reconsiderid = reconsiderid;

        this.reconsiderdate = reconsiderdate;
        this.reconsiderapply = reconsiderapply;
        this.applyphone = applyphone;
        this.applydate = applydate;
        this.applyreason = applyreason;
        this.applyremark = applyremark;
        this.reconsiderdep = reconsiderdep;
        this.bookoperator = bookoperator;
        this.bookdate = bookdate;
        this.flowInstId = flowinstid;
        this.bjType = bjType;
        this.bjNo = bjNo;
        this.itemId = itemId;
        this.internalNo = internalNo;
        this.orgId = orgId;
        this.optId = optid;
        this.biztype = biztype;
    }

    public String getReconsiderid() {
        return this.reconsiderid;
    }

    public void setReconsiderid(String reconsiderid) {
        this.reconsiderid = reconsiderid;
    }

    // Property accessors

    public String getSuptype() {
        return suptype;
    }

    public void setSuptype(String suptype) {
        this.suptype = suptype;
    }

    public Date getReconsiderdate() {
        return this.reconsiderdate;
    }

    public void setReconsiderdate(Date reconsiderdate) {
        this.reconsiderdate = reconsiderdate;
    }

    public String getReconsiderapply() {
        return this.reconsiderapply;
    }

    public void setReconsiderapply(String reconsiderapply) {
        this.reconsiderapply = reconsiderapply;
    }

    public String getApplyphone() {
        return this.applyphone;
    }

    public void setApplyphone(String applyphone) {
        this.applyphone = applyphone;
    }

    public Date getApplydate() {
        return this.applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getApplyreason() {
        return this.applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getApplyremark() {
        return this.applyremark;
    }

    public void setApplyremark(String applyremark) {
        this.applyremark = applyremark;
    }

    public String getReconsiderdep() {
        return this.reconsiderdep;
    }

    public void setReconsiderdep(String reconsiderdep) {
        this.reconsiderdep = reconsiderdep;
    }

    public String getBookoperator() {
        return this.bookoperator;
    }

    public void setBookoperator(String bookoperator) {
        this.bookoperator = bookoperator;
    }

    public Date getBookdate() {
        return this.bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

    public String getBjType() {
        return this.bjType;
    }

    public void setBjType(String bjType) {
        this.bjType = bjType;
    }

    public String getBjNo() {
        return this.bjNo;
    }

    public void setBjNo(String bjNo) {
        this.bjNo = bjNo;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getInternalNo() {
        return this.internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public Long getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public String getBiztype() {
        return this.biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }

    public void copy(Reconsider other) {

        this.setReconsiderid(other.getReconsiderid());

        this.reconsiderdate = other.getReconsiderdate();
        this.reconsiderapply = other.getReconsiderapply();
        this.applyphone = other.getApplyphone();
        this.applydate = other.getApplydate();
        this.applyreason = other.getApplyreason();
        this.applyremark = other.getApplyremark();
        this.reconsiderdep = other.getReconsiderdep();
        this.bookoperator = other.getBookoperator();
        this.bookdate = other.getBookdate();
        this.flowInstId = other.getFlowInstId();
        this.bjType = other.getBjType();
        this.bjNo = other.getBjNo();
        this.itemId = other.getItemId();
        this.internalNo = other.getInternalNo();
        this.orgId = other.getOrgId();
        this.optId = other.getOptId();
        this.biztype = other.getBiztype();

    }

    public void copyNotNullProperty(Reconsider other) {

        if (other.getReconsiderid() != null)
            this.setReconsiderid(other.getReconsiderid());

        if (other.getReconsiderdate() != null)
            this.reconsiderdate = other.getReconsiderdate();
        if (other.getReconsiderapply() != null)
            this.reconsiderapply = other.getReconsiderapply();
        if (other.getApplyphone() != null)
            this.applyphone = other.getApplyphone();
        if (other.getApplydate() != null)
            this.applydate = other.getApplydate();
        if (other.getApplyreason() != null)
            this.applyreason = other.getApplyreason();
        if (other.getApplyremark() != null)
            this.applyremark = other.getApplyremark();
        if (other.getReconsiderdep() != null)
            this.reconsiderdep = other.getReconsiderdep();
        if (other.getBookoperator() != null)
            this.bookoperator = other.getBookoperator();
        if (other.getBookdate() != null)
            this.bookdate = other.getBookdate();
        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getBjType() != null)
            this.bjType = other.getBjType();
        if (other.getBjNo() != null)
            this.bjNo = other.getBjNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getOptId() != null)
            this.optId = other.getOptId();
        if (other.getBiztype() != null)
            this.biztype = other.getBiztype();

    }

    public void clearProperties() {

        this.reconsiderdate = null;
        this.reconsiderapply = null;
        this.applyphone = null;
        this.applydate = null;
        this.applyreason = null;
        this.applyremark = null;
        this.reconsiderdep = null;
        this.bookoperator = null;
        this.bookdate = null;
        this.flowInstId = null;
        this.bjType = null;
        this.bjNo = null;
        this.itemId = null;
        this.internalNo = null;
        this.orgId = null;
        this.optId = null;
        this.biztype = null;

    }

    public VApply getVapply() {
        return vapply;
    }

    public void setVapply(VApply vapply) {
        this.vapply = vapply;
    }

    public VPunish getVpunish() {
        return vpunish;
    }

    public void setVpunish(VPunish vpunish) {
        this.vpunish = vpunish;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    public Punish getPunish() {
        return punish;
    }

    public void setPunish(Punish punish) {
        this.punish = punish;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Reconsiderresult getReconsiderresult() {
        return reconsiderresult;
    }

    public void setReconsiderresult(Reconsiderresult reconsiderresult) {
        this.reconsiderresult = reconsiderresult;
    }
}
