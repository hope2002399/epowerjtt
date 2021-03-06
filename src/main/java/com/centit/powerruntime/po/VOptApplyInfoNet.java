package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VOptApplyInfoNet implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String netId;
    private String djId;
    private Date applyDate;
    private String proposerName;
    private String applyItemType;
    private String applyReason;
    private String applyWay;
    private String proposerType;
    private String proposerPaperType;
    private String proposerPaperCode;
    private String proposerPhone;
    private String proposerMobile;
    private String proposerAddr;
    private String proposerZipcode;
    private String proposerEmail;
    private String proposerUnitcode;
    private String agentName;
    private String agentPaperType;
    private String agentPaperCode;
    private String agentPhone;
    private String agentMobile;
    private String agentAddr;
    private String agentZipcode;
    private String agentEmail;
    private String agentUnitcode;
    private String applyMemo;
    private Date acceptDate;
    private Date auditingDate;
    private String headUsercode;
    private String headAuditingIdea;
    private Date checkIdeaDate;
    private String checkUsercode;
    private String checkIdea;
    private String checkDetail;
    private String checkAddr;
    private Date checkDate;
    private String checkMemo;
    private Date bookDate;
    private String transAffairNo;// 办件编号
    private String transaffairname;
    private String orgcode;
    private String orgname;
    private String powerid;
    private String powername;
    private String biztype;// F未提交，W等待受理，T办理中，C办结
    private String bizstate;
    private String itemType;

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getBizstate() {
        return bizstate;
    }

    public void setBizstate(String bizstate) {
        this.bizstate = bizstate;
    }

    public VOptApplyInfoNet(String netId, String djId, Date applyDate,
            String proposerName, String applyItemType, String applyReason,
            String applyWay, String proposerType, String proposerPaperType,
            String proposerPaperCode, String proposerPhone,
            String proposerMobile, String proposerAddr, String proposerZipcode,
            String proposerEmail, String proposerUnitcode, String agentName,
            String agentPaperType, String agentPaperCode, String agentPhone,
            String agentMobile, String agentAddr, String agentZipcode,
            String agentEmail, String agentUnitcode, String applyMemo,
            Date acceptDate, Date auditingDate, String headUsercode,
            String headAuditingIdea, Date checkIdeaDate, String checkUsercode,
            String checkIdea, String checkDetail, String checkAddr,
            Date checkDate, String checkMemo, Date bookDate) {
        super();
        this.netId = netId;
        this.djId = djId;
        this.applyDate = applyDate;
        this.proposerName = proposerName;
        this.applyItemType = applyItemType;
        this.applyReason = applyReason;
        this.applyWay = applyWay;
        this.proposerType = proposerType;
        this.proposerPaperType = proposerPaperType;
        this.proposerPaperCode = proposerPaperCode;
        this.proposerPhone = proposerPhone;
        this.proposerMobile = proposerMobile;
        this.proposerAddr = proposerAddr;
        this.proposerZipcode = proposerZipcode;
        this.proposerEmail = proposerEmail;
        this.proposerUnitcode = proposerUnitcode;
        this.agentName = agentName;
        this.agentPaperType = agentPaperType;
        this.agentPaperCode = agentPaperCode;
        this.agentPhone = agentPhone;
        this.agentMobile = agentMobile;
        this.agentAddr = agentAddr;
        this.agentZipcode = agentZipcode;
        this.agentEmail = agentEmail;
        this.agentUnitcode = agentUnitcode;
        this.applyMemo = applyMemo;
        this.acceptDate = acceptDate;
        this.auditingDate = auditingDate;
        this.headUsercode = headUsercode;
        this.headAuditingIdea = headAuditingIdea;
        this.checkIdeaDate = checkIdeaDate;
        this.checkUsercode = checkUsercode;
        this.checkIdea = checkIdea;
        this.checkDetail = checkDetail;
        this.checkAddr = checkAddr;
        this.checkDate = checkDate;
        this.checkMemo = checkMemo;
        this.bookDate = bookDate;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    // Constructors
    /** default constructor */
    public VOptApplyInfoNet() {
    }

    /** minimal constructor */
    public VOptApplyInfoNet(String netId) {

        this.netId = netId;

    }

    /** full constructor */
    public VOptApplyInfoNet(String netId, String djId, Date applyDate,
            String proposerName, String applyItemType, String applyReason,
            String applyWay, String proposerType, String proposerPaperType,
            String proposerPaperCode, String proposerPhone,
            String proposerMobile, String proposerAddr, String proposerZipcode,
            String proposerEmail, String proposerUnitcode, String agentName,
            String agentPaperType, String agentPaperCode, String agentPhone,
            String agentMobile, String agentAddr, String agentZipcode,
            String agentEmail, String agentUnitcode, String applyMemo,
            Date acceptDate, Date auditingDate, String headUsercode,
            String headAuditingIdea, Date checkIdeaDate, String checkUsercode,
            String checkIdea, String checkDetail, String checkAddr,
            Date checkDate, String checkMemo) {
        this.netId = netId;
        this.djId = djId;

        this.applyDate = applyDate;
        this.proposerName = proposerName;
        this.applyItemType = applyItemType;
        this.applyReason = applyReason;
        this.applyWay = applyWay;
        this.proposerType = proposerType;
        this.proposerPaperType = proposerPaperType;
        this.proposerPaperCode = proposerPaperCode;
        this.proposerPhone = proposerPhone;
        this.proposerMobile = proposerMobile;
        this.proposerAddr = proposerAddr;
        this.proposerZipcode = proposerZipcode;
        this.proposerEmail = proposerEmail;
        this.proposerUnitcode = proposerUnitcode;
        this.agentName = agentName;
        this.agentPaperType = agentPaperType;
        this.agentPaperCode = agentPaperCode;
        this.agentPhone = agentPhone;
        this.agentMobile = agentMobile;
        this.agentAddr = agentAddr;
        this.agentZipcode = agentZipcode;
        this.agentEmail = agentEmail;
        this.agentUnitcode = agentUnitcode;
        this.applyMemo = applyMemo;
        this.acceptDate = acceptDate;
        this.auditingDate = auditingDate;
        this.headUsercode = headUsercode;
        this.headAuditingIdea = headAuditingIdea;
        this.checkIdeaDate = checkIdeaDate;
        this.checkUsercode = checkUsercode;
        this.checkIdea = checkIdea;
        this.checkDetail = checkDetail;
        this.checkAddr = checkAddr;
        this.checkDate = checkDate;
        this.checkMemo = checkMemo;
    }

    public String getDjId() {
        return this.djId;
    }

    public void setDjId(String djId) {
        this.djId = djId;
    }

    // Property accessors

    public Date getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getProposerName() {
        return this.proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getApplyItemType() {
        return this.applyItemType;
    }

    public void setApplyItemType(String applyItemType) {
        this.applyItemType = applyItemType;
    }

    public String getApplyReason() {
        return this.applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getApplyWay() {
        return this.applyWay;
    }

    public void setApplyWay(String applyWay) {
        this.applyWay = applyWay;
    }

    public String getProposerType() {
        return this.proposerType;
    }

    public void setProposerType(String proposerType) {
        this.proposerType = proposerType;
    }

    public String getProposerPaperType() {
        return this.proposerPaperType;
    }

    public void setProposerPaperType(String proposerPaperType) {
        this.proposerPaperType = proposerPaperType;
    }

    public String getProposerPaperCode() {
        return this.proposerPaperCode;
    }

    public void setProposerPaperCode(String proposerPaperCode) {
        this.proposerPaperCode = proposerPaperCode;
    }

    public String getProposerPhone() {
        return this.proposerPhone;
    }

    public void setProposerPhone(String proposerPhone) {
        this.proposerPhone = proposerPhone;
    }

    public String getProposerMobile() {
        return this.proposerMobile;
    }

    public void setProposerMobile(String proposerMobile) {
        this.proposerMobile = proposerMobile;
    }

    public String getProposerAddr() {
        return this.proposerAddr;
    }

    public void setProposerAddr(String proposerAddr) {
        this.proposerAddr = proposerAddr;
    }

    public String getProposerZipcode() {
        return this.proposerZipcode;
    }

    public void setProposerZipcode(String proposerZipcode) {
        this.proposerZipcode = proposerZipcode;
    }

    public String getProposerEmail() {
        return this.proposerEmail;
    }

    public void setProposerEmail(String proposerEmail) {
        this.proposerEmail = proposerEmail;
    }

    public String getProposerUnitcode() {
        return this.proposerUnitcode;
    }

    public void setProposerUnitcode(String proposerUnitcode) {
        this.proposerUnitcode = proposerUnitcode;
    }

    public String getAgentName() {
        return this.agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentPaperType() {
        return this.agentPaperType;
    }

    public void setAgentPaperType(String agentPaperType) {
        this.agentPaperType = agentPaperType;
    }

    public String getAgentPaperCode() {
        return this.agentPaperCode;
    }

    public void setAgentPaperCode(String agentPaperCode) {
        this.agentPaperCode = agentPaperCode;
    }

    public String getAgentPhone() {
        return this.agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getAgentMobile() {
        return this.agentMobile;
    }

    public void setAgentMobile(String agentMobile) {
        this.agentMobile = agentMobile;
    }

    public String getAgentAddr() {
        return this.agentAddr;
    }

    public void setAgentAddr(String agentAddr) {
        this.agentAddr = agentAddr;
    }

    public String getAgentZipcode() {
        return this.agentZipcode;
    }

    public void setAgentZipcode(String agentZipcode) {
        this.agentZipcode = agentZipcode;
    }

    public String getAgentEmail() {
        return this.agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getAgentUnitcode() {
        return this.agentUnitcode;
    }

    public void setAgentUnitcode(String agentUnitcode) {
        this.agentUnitcode = agentUnitcode;
    }

    public String getApplyMemo() {
        return this.applyMemo;
    }

    public void setApplyMemo(String applyMemo) {
        this.applyMemo = applyMemo;
    }

    public Date getAcceptDate() {
        return this.acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getAuditingDate() {
        return this.auditingDate;
    }

    public void setAuditingDate(Date auditingDate) {
        this.auditingDate = auditingDate;
    }

    public String getHeadUsercode() {
        return this.headUsercode;
    }

    public void setHeadUsercode(String headUsercode) {
        this.headUsercode = headUsercode;
    }

    public String getHeadAuditingIdea() {
        return this.headAuditingIdea;
    }

    public void setHeadAuditingIdea(String headAuditingIdea) {
        this.headAuditingIdea = headAuditingIdea;
    }

    public Date getCheckIdeaDate() {
        return this.checkIdeaDate;
    }

    public void setCheckIdeaDate(Date checkIdeaDate) {
        this.checkIdeaDate = checkIdeaDate;
    }

    public String getCheckUsercode() {
        return this.checkUsercode;
    }

    public void setCheckUsercode(String checkUsercode) {
        this.checkUsercode = checkUsercode;
    }

    public String getCheckIdea() {
        return this.checkIdea;
    }

    public void setCheckIdea(String checkIdea) {
        this.checkIdea = checkIdea;
    }

    public String getCheckDetail() {
        return this.checkDetail;
    }

    public void setCheckDetail(String checkDetail) {
        this.checkDetail = checkDetail;
    }

    public String getCheckAddr() {
        return this.checkAddr;
    }

    public void setCheckAddr(String checkAddr) {
        this.checkAddr = checkAddr;
    }

    public Date getCheckDate() {
        return this.checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckMemo() {
        return this.checkMemo;
    }

    public void setCheckMemo(String checkMemo) {
        this.checkMemo = checkMemo;
    }

    public void copy(VOptApplyInfoNet other) {
        this.setNetId(other.getNetId());
        this.setDjId(other.getDjId());

        this.applyDate = other.getApplyDate();
        this.proposerName = other.getProposerName();
        this.applyItemType = other.getApplyItemType();
        this.applyReason = other.getApplyReason();
        this.applyWay = other.getApplyWay();
        this.proposerType = other.getProposerType();
        this.proposerPaperType = other.getProposerPaperType();
        this.proposerPaperCode = other.getProposerPaperCode();
        this.proposerPhone = other.getProposerPhone();
        this.proposerMobile = other.getProposerMobile();
        this.proposerAddr = other.getProposerAddr();
        this.proposerZipcode = other.getProposerZipcode();
        this.proposerEmail = other.getProposerEmail();
        this.proposerUnitcode = other.getProposerUnitcode();
        this.agentName = other.getAgentName();
        this.agentPaperType = other.getAgentPaperType();
        this.agentPaperCode = other.getAgentPaperCode();
        this.agentPhone = other.getAgentPhone();
        this.agentMobile = other.getAgentMobile();
        this.agentAddr = other.getAgentAddr();
        this.agentZipcode = other.getAgentZipcode();
        this.agentEmail = other.getAgentEmail();
        this.agentUnitcode = other.getAgentUnitcode();
        this.applyMemo = other.getApplyMemo();
        this.acceptDate = other.getAcceptDate();
        this.auditingDate = other.getAuditingDate();
        this.headUsercode = other.getHeadUsercode();
        this.headAuditingIdea = other.getHeadAuditingIdea();
        this.checkIdeaDate = other.getCheckIdeaDate();
        this.checkUsercode = other.getCheckUsercode();
        this.checkIdea = other.getCheckIdea();
        this.checkDetail = other.getCheckDetail();
        this.checkAddr = other.getCheckAddr();
        this.checkDate = other.getCheckDate();
        this.checkMemo = other.getCheckMemo();

    }

    public void copyNotNullProperty(VOptApplyInfoNet other) {
        if (other.getNetId() != null)
            this.setNetId(other.getNetId());
        if (other.getDjId() != null)
            this.setDjId(other.getDjId());

        if (other.getApplyDate() != null)
            this.applyDate = other.getApplyDate();
        if (other.getProposerName() != null)
            this.proposerName = other.getProposerName();
        if (other.getApplyItemType() != null)
            this.applyItemType = other.getApplyItemType();
        if (other.getApplyReason() != null)
            this.applyReason = other.getApplyReason();
        if (other.getApplyWay() != null)
            this.applyWay = other.getApplyWay();
        if (other.getProposerType() != null)
            this.proposerType = other.getProposerType();
        if (other.getProposerPaperType() != null)
            this.proposerPaperType = other.getProposerPaperType();
        if (other.getProposerPaperCode() != null)
            this.proposerPaperCode = other.getProposerPaperCode();
        if (other.getProposerPhone() != null)
            this.proposerPhone = other.getProposerPhone();
        if (other.getProposerMobile() != null)
            this.proposerMobile = other.getProposerMobile();
        if (other.getProposerAddr() != null)
            this.proposerAddr = other.getProposerAddr();
        if (other.getProposerZipcode() != null)
            this.proposerZipcode = other.getProposerZipcode();
        if (other.getProposerEmail() != null)
            this.proposerEmail = other.getProposerEmail();
        if (other.getProposerUnitcode() != null)
            this.proposerUnitcode = other.getProposerUnitcode();
        if (other.getAgentName() != null)
            this.agentName = other.getAgentName();
        if (other.getAgentPaperType() != null)
            this.agentPaperType = other.getAgentPaperType();
        if (other.getAgentPaperCode() != null)
            this.agentPaperCode = other.getAgentPaperCode();
        if (other.getAgentPhone() != null)
            this.agentPhone = other.getAgentPhone();
        if (other.getAgentMobile() != null)
            this.agentMobile = other.getAgentMobile();
        if (other.getAgentAddr() != null)
            this.agentAddr = other.getAgentAddr();
        if (other.getAgentZipcode() != null)
            this.agentZipcode = other.getAgentZipcode();
        if (other.getAgentEmail() != null)
            this.agentEmail = other.getAgentEmail();
        if (other.getAgentUnitcode() != null)
            this.agentUnitcode = other.getAgentUnitcode();
        if (other.getApplyMemo() != null)
            this.applyMemo = other.getApplyMemo();
        if (other.getAcceptDate() != null)
            this.acceptDate = other.getAcceptDate();
        if (other.getAuditingDate() != null)
            this.auditingDate = other.getAuditingDate();
        if (other.getHeadUsercode() != null)
            this.headUsercode = other.getHeadUsercode();
        if (other.getHeadAuditingIdea() != null)
            this.headAuditingIdea = other.getHeadAuditingIdea();
        if (other.getCheckIdeaDate() != null)
            this.checkIdeaDate = other.getCheckIdeaDate();
        if (other.getCheckUsercode() != null)
            this.checkUsercode = other.getCheckUsercode();
        if (other.getCheckIdea() != null)
            this.checkIdea = other.getCheckIdea();
        if (other.getCheckDetail() != null)
            this.checkDetail = other.getCheckDetail();
        if (other.getCheckAddr() != null)
            this.checkAddr = other.getCheckAddr();
        if (other.getCheckDate() != null)
            this.checkDate = other.getCheckDate();
        if (other.getCheckMemo() != null)
            this.checkMemo = other.getCheckMemo();
    }

    public void clearProperties() {
        this.djId = null;
        this.applyDate = null;
        this.proposerName = null;
        this.applyItemType = null;
        this.applyReason = null;
        this.applyWay = null;
        this.proposerType = null;
        this.proposerPaperType = null;
        this.proposerPaperCode = null;
        this.proposerPhone = null;
        this.proposerMobile = null;
        this.proposerAddr = null;
        this.proposerZipcode = null;
        this.proposerEmail = null;
        this.proposerUnitcode = null;
        this.agentName = null;
        this.agentPaperType = null;
        this.agentPaperCode = null;
        this.agentPhone = null;
        this.agentMobile = null;
        this.agentAddr = null;
        this.agentZipcode = null;
        this.agentEmail = null;
        this.agentUnitcode = null;
        this.applyMemo = null;
        this.acceptDate = null;
        this.auditingDate = null;
        this.headUsercode = null;
        this.headAuditingIdea = null;
        this.checkIdeaDate = null;
        this.checkUsercode = null;
        this.checkIdea = null;
        this.checkDetail = null;
        this.checkAddr = null;
        this.checkDate = null;
        this.checkMemo = null;
    }

    public String getTransAffairNo() {
        return transAffairNo;
    }

    public void setTransAffairNo(String transAffairNo) {
        this.transAffairNo = transAffairNo;
    }

    public String getTransaffairname() {
        return transaffairname;
    }

    public void setTransaffairname(String transaffairname) {
        this.transaffairname = transaffairname;
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

    public String getPowerid() {
        return powerid;
    }

    public void setPowerid(String powerid) {
        this.powerid = powerid;
    }

    public String getPowername() {
        return powername;
    }

    public void setPowername(String powername) {
        this.powername = powername;
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }
}
