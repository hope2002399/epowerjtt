package com.centit.dispatchdoc.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VDispatchDocList implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String djId;

    private Date createDate;
    private Long flowInstId;
    private String transaffairname;
    private String biztype;
    private String createuser;

    private String headunitcode;
    private String orgcode;
    private String orgname;

    // Constructors
    /** default constructor */
    public VDispatchDocList() {
    }

    /** constructor */
    public VDispatchDocList(String djId, Date createDate, Long flowInstId,
            String transaffairname, String biztype, String createuser,
            String headunitcode, String orgcode, String orgname) {

        this.djId = djId;
        this.createDate = createDate;
        this.flowInstId = flowInstId;
        this.transaffairname = transaffairname;
        this.biztype = biztype;
        this.createuser = createuser;
        this.headunitcode = headunitcode;
        this.orgcode = orgcode;
        this.orgname = orgname;
    }

    public String getDjId() {
        return djId;
    }

    public void setDjId(String djId) {
        this.djId = djId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getTransaffairname() {
        return transaffairname;
    }

    public void setTransaffairname(String transaffairname) {
        this.transaffairname = transaffairname;
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public String getHeadunitcode() {
        return headunitcode;
    }

    public void setHeadunitcode(String headunitcode) {
        this.headunitcode = headunitcode;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public void copy(VDispatchDocList other) {

        this.setDjId(other.getDjId());
        this.setCreateDate(other.getCreateDate());
        this.setFlowInstId(other.getFlowInstId());
        this.setTransaffairname(other.getTransaffairname());
        this.setBiztype(other.getBiztype());
        this.setCreateuser(other.getCreateuser());
        this.setHeadunitcode(other.getHeadunitcode());
        this.setOrgcode(other.getOrgcode());
        this.setOrgname(other.getOrgname());
    }

    public void copyNotNullProperty(VDispatchDocList other) {

        if (other.getDjId() != null)
            this.setDjId(other.getDjId());

        if (other.getCreateDate() != null)
            this.setCreateDate(other.getCreateDate());
        if (other.getFlowInstId() != null)
            this.setFlowInstId(other.getFlowInstId());
        if (other.getTransaffairname() != null)
            this.setTransaffairname(other.getTransaffairname());
        if (other.getBiztype() != null)
            this.setBiztype(other.getBiztype());
        if (other.getCreateuser() != null)
            this.setCreateuser(other.getCreateuser());

        if (other.getHeadunitcode() != null)
            this.setHeadunitcode(other.getHeadunitcode());
        if (other.getOrgcode() != null)
            this.setOrgcode(other.getOrgcode());
        if (other.getOrgname() != null)
            this.setOrgname(other.getOrgname());
    }

    public void clearProperties() {

        this.djId = null;
        this.createDate = null;
        this.flowInstId = null;
        this.transaffairname = null;
        this.biztype = null;
        this.createuser = null;
        this.headunitcode = null;
        this.orgcode = null;
        this.orgname = null;
    }
}
