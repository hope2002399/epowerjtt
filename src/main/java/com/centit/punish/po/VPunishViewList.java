package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VPunishViewList implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String wfoptname;
    private String unitCode;
    private String nodeName;
    private Date createtime;
    private String punishobjectno;
    private String punishobjecttype;
    private String managedepid;
    private Date poregisterdate;
    private Long pooccurstate;
    private String punishobjectstate;
    private Date pooccurdate;
    private Date poregistedate;
    private String pooriginstate;
    private Long flowInstId;
    private String optId;
    private String biztype;

    // Constructors
    /** default constructor */
    public VPunishViewList() {
    }

    /** minimal constructor */
    public VPunishViewList(String punishobjectid) {

        this.punishobjectid = punishobjectid;

    }

    /** full constructor */
    public VPunishViewList(String punishobjectid, String wfoptname,
            String unitCode, String nodeName, Date createtime,
            String punishobjectno, String punishobjecttype, String managedepid,
            Date poregisterdate, Long pooccurstate, String punishobjectstate,
            Date pooccurdate, Date poregistedate, String pooriginstate,
            Long flowInstId, String optId) {

        this.punishobjectid = punishobjectid;

        this.wfoptname = wfoptname;
        this.unitCode = unitCode;
        this.nodeName = nodeName;
        this.createtime = createtime;
        this.punishobjectno = punishobjectno;
        this.punishobjecttype = punishobjecttype;
        this.managedepid = managedepid;
        this.poregisterdate = poregisterdate;
        this.pooccurstate = pooccurstate;
        this.punishobjectstate = punishobjectstate;
        this.pooccurdate = pooccurdate;
        this.poregistedate = poregistedate;
        this.pooriginstate = pooriginstate;
        this.flowInstId = flowInstId;
        this.optId = optId;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public String getWfoptname() {
        return this.wfoptname;
    }

    public void setWfoptname(String wfoptname) {
        this.wfoptname = wfoptname;
    }

    public String getUnitCode() {
        return this.unitCode;
    }

    public VPunishViewList(String punishobjectid, String wfoptname,
            String unitCode, String nodeName, Date createtime,
            String punishobjectno, String punishobjecttype, String managedepid,
            Date poregisterdate, Long pooccurstate, String punishobjectstate,
            Date pooccurdate, Date poregistedate, String pooriginstate,
            Long flowInstId, String optId, String biztype) {
        super();
        this.punishobjectid = punishobjectid;
        this.wfoptname = wfoptname;
        this.unitCode = unitCode;
        this.nodeName = nodeName;
        this.createtime = createtime;
        this.punishobjectno = punishobjectno;
        this.punishobjecttype = punishobjecttype;
        this.managedepid = managedepid;
        this.poregisterdate = poregisterdate;
        this.pooccurstate = pooccurstate;
        this.punishobjectstate = punishobjectstate;
        this.pooccurdate = pooccurdate;
        this.poregistedate = poregistedate;
        this.pooriginstate = pooriginstate;
        this.flowInstId = flowInstId;
        this.optId = optId;
        this.biztype = biztype;
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPunishobjectno() {
        return this.punishobjectno;
    }

    public void setPunishobjectno(String punishobjectno) {
        this.punishobjectno = punishobjectno;
    }

    public String getPunishobjecttype() {
        return this.punishobjecttype;
    }

    public void setPunishobjecttype(String punishobjecttype) {
        this.punishobjecttype = punishobjecttype;
    }

    public String getManagedepid() {
        return this.managedepid;
    }

    public void setManagedepid(String managedepid) {
        this.managedepid = managedepid;
    }

    public Date getPoregisterdate() {
        return this.poregisterdate;
    }

    public void setPoregisterdate(Date poregisterdate) {
        this.poregisterdate = poregisterdate;
    }

    public Long getPooccurstate() {
        return this.pooccurstate;
    }

    public void setPooccurstate(Long pooccurstate) {
        this.pooccurstate = pooccurstate;
    }

    public String getPunishobjectstate() {
        return this.punishobjectstate;
    }

    public void setPunishobjectstate(String punishobjectstate) {
        this.punishobjectstate = punishobjectstate;
    }

    public Date getPooccurdate() {
        return this.pooccurdate;
    }

    public void setPooccurdate(Date pooccurdate) {
        this.pooccurdate = pooccurdate;
    }

    public Date getPoregistedate() {
        return this.poregistedate;
    }

    public void setPoregistedate(Date poregistedate) {
        this.poregistedate = poregistedate;
    }

    public String getPooriginstate() {
        return this.pooriginstate;
    }

    public void setPooriginstate(String pooriginstate) {
        this.pooriginstate = pooriginstate;
    }

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getOptId() {
        return this.optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public void copy(VPunishViewList other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.wfoptname = other.getWfoptname();
        this.unitCode = other.getUnitCode();
        this.nodeName = other.getNodeName();
        this.createtime = other.getCreatetime();
        this.punishobjectno = other.getPunishobjectno();
        this.punishobjecttype = other.getPunishobjecttype();
        this.managedepid = other.getManagedepid();
        this.poregisterdate = other.getPoregisterdate();
        this.pooccurstate = other.getPooccurstate();
        this.punishobjectstate = other.getPunishobjectstate();
        this.pooccurdate = other.getPooccurdate();
        this.poregistedate = other.getPoregistedate();
        this.pooriginstate = other.getPooriginstate();
        this.flowInstId = other.getFlowInstId();
        this.optId = other.getOptId();
        this.biztype = other.getBiztype();

    }

    public void copyNotNullProperty(VPunishViewList other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getWfoptname() != null)
            this.wfoptname = other.getWfoptname();
        if (other.getUnitCode() != null)
            this.unitCode = other.getUnitCode();
        if (other.getNodeName() != null)
            this.nodeName = other.getNodeName();
        if (other.getCreatetime() != null)
            this.createtime = other.getCreatetime();
        if (other.getPunishobjectno() != null)
            this.punishobjectno = other.getPunishobjectno();
        if (other.getPunishobjecttype() != null)
            this.punishobjecttype = other.getPunishobjecttype();
        if (other.getManagedepid() != null)
            this.managedepid = other.getManagedepid();
        if (other.getPoregisterdate() != null)
            this.poregisterdate = other.getPoregisterdate();
        if (other.getPooccurstate() != null)
            this.pooccurstate = other.getPooccurstate();
        if (other.getPunishobjectstate() != null)
            this.punishobjectstate = other.getPunishobjectstate();
        if (other.getPooccurdate() != null)
            this.pooccurdate = other.getPooccurdate();
        if (other.getPoregistedate() != null)
            this.poregistedate = other.getPoregistedate();
        if (other.getPooriginstate() != null)
            this.pooriginstate = other.getPooriginstate();
        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getOptId() != null)
            this.optId = other.getOptId();
        if (other.getBiztype() != null)
            this.biztype = other.getBiztype();
    }

    public void clearProperties() {

        this.wfoptname = null;
        this.unitCode = null;
        this.nodeName = null;
        this.createtime = null;
        this.punishobjectno = null;
        this.punishobjecttype = null;
        this.managedepid = null;
        this.poregisterdate = null;
        this.pooccurstate = null;
        this.punishobjectstate = null;
        this.pooccurdate = null;
        this.poregistedate = null;
        this.pooriginstate = null;
        this.flowInstId = null;
        this.optId = null;
        this.biztype = null;
    }
}
