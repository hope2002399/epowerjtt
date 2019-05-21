package com.centit.dispatchdoc.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VIncomeDocList implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String djId;

    private String internalNo;
    private String itemId;
    private String acceptNo;
    private String incomeDocNo;
    private String incomeDocTitle;
    private String incomeDeptName;
    private String incomeDocFileName;
    private Date createDate;
    private Date updateDate;
    private String flowCode;
    private Long flowInstId;
    private String transaffairname;
    private String bizstate;
    private String biztype;
    private String orgcode;
    private String orgname;
    private String content;
    private String powerid;
    private String powername;
    private String createuser;
    private Date createdate;
    private String transAffairNo;
    private String transAffairQueryKey;
    private String instState;
    private String nodeName;
    private String nodeState;

    // Constructors
    /** default constructor */
    public VIncomeDocList() {
    }

    /** minimal constructor */
    public VIncomeDocList(String djId, String internalNo, String itemId,
            Date createDate, Date updateDate) {

        this.djId = djId;

        this.internalNo = internalNo;
        this.itemId = itemId;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public VIncomeDocList(String djId, String internalNo, String itemId,
            String acceptNo, String incomeDocNo, String incomeDocTitle,
            String incomeDeptName, String incomeDocFileName, Date createDate,
            Date updateDate, String flowCode, Long flowInstId,
            String transaffairname, String bizstate, String biztype,
            String orgcode, String orgname, String content, String powerid,
            String powername, String createuser, Date createdate,
            String transAffairNo, String transAffairQueryKey, String instState,
            String nodeName, String nodeState) {

        this.djId = djId;

        this.internalNo = internalNo;
        this.itemId = itemId;
        this.acceptNo = acceptNo;
        this.incomeDocNo = incomeDocNo;
        this.incomeDocTitle = incomeDocTitle;
        this.incomeDeptName = incomeDeptName;
        this.incomeDocFileName = incomeDocFileName;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.flowCode = flowCode;
        this.flowInstId = flowInstId;
        this.transaffairname = transaffairname;
        this.bizstate = bizstate;
        this.biztype = biztype;
        this.orgcode = orgcode;
        this.orgname = orgname;
        this.content = content;
        this.powerid = powerid;
        this.powername = powername;
        this.createuser = createuser;
        this.createdate = createdate;
        this.transAffairNo = transAffairNo;
        this.transAffairQueryKey = transAffairQueryKey;
        this.instState = instState;
        this.nodeName = nodeName;
        this.nodeState = nodeState;
    }

    public String getDjId() {
        return this.djId;
    }

    public void setDjId(String djId) {
        this.djId = djId;
    }

    // Property accessors

    public String getInternalNo() {
        return this.internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getAcceptNo() {
        return this.acceptNo;
    }

    public void setAcceptNo(String acceptNo) {
        this.acceptNo = acceptNo;
    }

    public String getIncomeDocNo() {
        return this.incomeDocNo;
    }

    public void setIncomeDocNo(String incomeDocNo) {
        this.incomeDocNo = incomeDocNo;
    }

    public String getIncomeDocTitle() {
        return this.incomeDocTitle;
    }

    public void setIncomeDocTitle(String incomeDocTitle) {
        this.incomeDocTitle = incomeDocTitle;
    }

    public String getIncomeDeptName() {
        return this.incomeDeptName;
    }

    public void setIncomeDeptName(String incomeDeptName) {
        this.incomeDeptName = incomeDeptName;
    }

    public String getIncomeDocFileName() {
        return this.incomeDocFileName;
    }

    public void setIncomeDocFileName(String incomeDocFileName) {
        this.incomeDocFileName = incomeDocFileName;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getFlowCode() {
        return this.flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getTransaffairname() {
        return this.transaffairname;
    }

    public void setTransaffairname(String transaffairname) {
        this.transaffairname = transaffairname;
    }

    public String getBizstate() {
        return this.bizstate;
    }

    public void setBizstate(String bizstate) {
        this.bizstate = bizstate;
    }

    public String getBiztype() {
        return this.biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }

    public String getOrgcode() {
        return this.orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getOrgname() {
        return this.orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPowerid() {
        return this.powerid;
    }

    public void setPowerid(String powerid) {
        this.powerid = powerid;
    }

    public String getPowername() {
        return this.powername;
    }

    public void setPowername(String powername) {
        this.powername = powername;
    }

    public String getCreateuser() {
        return this.createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getTransAffairNo() {
        return this.transAffairNo;
    }

    public void setTransAffairNo(String transAffairNo) {
        this.transAffairNo = transAffairNo;
    }

    public String getTransAffairQueryKey() {
        return this.transAffairQueryKey;
    }

    public void setTransAffairQueryKey(String transAffairQueryKey) {
        this.transAffairQueryKey = transAffairQueryKey;
    }

    public String getInstState() {
        return this.instState;
    }

    public void setInstState(String instState) {
        this.instState = instState;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeState() {
        return this.nodeState;
    }

    public void setNodeState(String nodeState) {
        this.nodeState = nodeState;
    }

    public void copy(VIncomeDocList other) {

        this.setDjId(other.getDjId());

        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.acceptNo = other.getAcceptNo();
        this.incomeDocNo = other.getIncomeDocNo();
        this.incomeDocTitle = other.getIncomeDocTitle();
        this.incomeDeptName = other.getIncomeDeptName();
        this.incomeDocFileName = other.getIncomeDocFileName();
        this.createDate = other.getCreateDate();
        this.updateDate = other.getUpdateDate();
        this.flowCode = other.getFlowCode();
        this.flowInstId = other.getFlowInstId();
        this.transaffairname = other.getTransaffairname();
        this.bizstate = other.getBizstate();
        this.biztype = other.getBiztype();
        this.orgcode = other.getOrgcode();
        this.orgname = other.getOrgname();
        this.content = other.getContent();
        this.powerid = other.getPowerid();
        this.powername = other.getPowername();
        this.createuser = other.getCreateuser();
        this.createdate = other.getCreatedate();
        this.transAffairNo = other.getTransAffairNo();
        this.transAffairQueryKey = other.getTransAffairQueryKey();
        this.instState = other.getInstState();
        this.nodeName = other.getNodeName();
        this.nodeState = other.getNodeState();

    }

    public void copyNotNullProperty(VIncomeDocList other) {

        if (other.getDjId() != null)
            this.setDjId(other.getDjId());

        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getAcceptNo() != null)
            this.acceptNo = other.getAcceptNo();
        if (other.getIncomeDocNo() != null)
            this.incomeDocNo = other.getIncomeDocNo();
        if (other.getIncomeDocTitle() != null)
            this.incomeDocTitle = other.getIncomeDocTitle();
        if (other.getIncomeDeptName() != null)
            this.incomeDeptName = other.getIncomeDeptName();
        if (other.getIncomeDocFileName() != null)
            this.incomeDocFileName = other.getIncomeDocFileName();
        if (other.getCreateDate() != null)
            this.createDate = other.getCreateDate();
        if (other.getUpdateDate() != null)
            this.updateDate = other.getUpdateDate();
        if (other.getFlowCode() != null)
            this.flowCode = other.getFlowCode();
        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getTransaffairname() != null)
            this.transaffairname = other.getTransaffairname();
        if (other.getBizstate() != null)
            this.bizstate = other.getBizstate();
        if (other.getBiztype() != null)
            this.biztype = other.getBiztype();
        if (other.getOrgcode() != null)
            this.orgcode = other.getOrgcode();
        if (other.getOrgname() != null)
            this.orgname = other.getOrgname();
        if (other.getContent() != null)
            this.content = other.getContent();
        if (other.getPowerid() != null)
            this.powerid = other.getPowerid();
        if (other.getPowername() != null)
            this.powername = other.getPowername();
        if (other.getCreateuser() != null)
            this.createuser = other.getCreateuser();
        if (other.getCreatedate() != null)
            this.createdate = other.getCreatedate();
        if (other.getTransAffairNo() != null)
            this.transAffairNo = other.getTransAffairNo();
        if (other.getTransAffairQueryKey() != null)
            this.transAffairQueryKey = other.getTransAffairQueryKey();
        if (other.getInstState() != null)
            this.instState = other.getInstState();
        if (other.getNodeName() != null)
            this.nodeName = other.getNodeName();
        if (other.getNodeState() != null)
            this.nodeState = other.getNodeState();

    }

    public void clearProperties() {

        this.internalNo = null;
        this.itemId = null;
        this.acceptNo = null;
        this.incomeDocNo = null;
        this.incomeDocTitle = null;
        this.incomeDeptName = null;
        this.incomeDocFileName = null;
        this.createDate = null;
        this.updateDate = null;
        this.flowCode = null;
        this.flowInstId = null;
        this.transaffairname = null;
        this.bizstate = null;
        this.biztype = null;
        this.orgcode = null;
        this.orgname = null;
        this.content = null;
        this.powerid = null;
        this.powername = null;
        this.createuser = null;
        this.createdate = null;
        this.transAffairNo = null;
        this.transAffairQueryKey = null;
        this.instState = null;
        this.nodeName = null;
        this.nodeState = null;

    }
}
