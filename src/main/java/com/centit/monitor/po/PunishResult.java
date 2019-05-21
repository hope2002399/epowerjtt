package com.centit.monitor.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class PunishResult implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String no;
    private Long changNo;
    private String orgId;
    private String internalNo;
    private String itemId;
    private String program;
    private String punishSort;
    private String accordance;
    private String standard;
    private String punishDeside;
    private String punishClass;
    private String punishResult;
    private Double punishResultFine;
    private Long punishResultFinePeople;
    private Double punishResultExpropriation;
    private Double punishResultExpropriationV;
    private Long punishResultBusiness;
    private Long punishResultPeople;
    private Long punishResultDetain;
    private String attachment;
    private Date finishDate;
    private String resultStandard;
    private Date createDate;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;
    private String isRecord;

    public String getIsRecord() {
        return isRecord;
    }

    public void setIsRecord(String isRecord) {
        this.isRecord = isRecord;
    }

    @SuppressWarnings("rawtypes")
    private List docList = new ArrayList();

    @SuppressWarnings("rawtypes")
    public List getDocList() {
        return docList;
    }

    @SuppressWarnings("rawtypes")
    public void setDocList(List docList) {
        this.docList = docList;
    }

    // Constructors
    /** default constructor */
    public PunishResult() {
    }

    /** minimal constructor */
    public PunishResult(String no, Long changNo, String orgId,
            String internalNo, String itemId, String program,
            String accordance, String standard, String punishDeside,
            String punishClass, String punishResult, String attachment,
            Date finishDate, Date createDate, Date updateDate, String isRecord) {

        this.no = no;

        this.changNo = changNo;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.program = program;
        this.accordance = accordance;
        this.standard = standard;
        this.punishDeside = punishDeside;
        this.punishClass = punishClass;
        this.punishResult = punishResult;
        this.attachment = attachment;
        this.finishDate = finishDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isRecord = isRecord;
    }

    /** full constructor */
    public PunishResult(String no, Long changNo, String orgId,
            String internalNo, String itemId, String program,
            String punishSort, String accordance, String standard,
            String punishDeside, String punishClass, String punishResult,
            Double punishResultFine, Long punishResultFinePeople,
            Double punishResultExpropriation,
            Double punishResultExpropriationV, Long punishResultBusiness,
            Long punishResultPeople, Long punishResultDetain,
            String attachment, Date finishDate, String resultStandard,
            Date createDate, Date updateDate, Date syncDate, String syncSign,
            String syncErrorDesc, String isRecord) {

        this.no = no;

        this.changNo = changNo;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.program = program;
        this.punishSort = punishSort;
        this.accordance = accordance;
        this.standard = standard;
        this.punishDeside = punishDeside;
        this.punishClass = punishClass;
        this.punishResult = punishResult;
        this.punishResultFine = punishResultFine;
        this.punishResultFinePeople = punishResultFinePeople;
        this.punishResultExpropriation = punishResultExpropriation;
        this.punishResultExpropriationV = punishResultExpropriationV;
        this.punishResultBusiness = punishResultBusiness;
        this.punishResultPeople = punishResultPeople;
        this.punishResultDetain = punishResultDetain;
        this.attachment = attachment;
        this.finishDate = finishDate;
        this.resultStandard = resultStandard;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
        this.isRecord = isRecord;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // Property accessors

    public Long getChangNo() {
        return this.changNo;
    }

    public void setChangNo(Long changNo) {
        this.changNo = changNo;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

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

    public String getProgram() {
        return this.program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getPunishSort() {
        return this.punishSort;
    }

    public void setPunishSort(String punishSort) {
        this.punishSort = punishSort;
    }

    public String getAccordance() {
        return this.accordance;
    }

    public void setAccordance(String accordance) {
        this.accordance = accordance;
    }

    public String getStandard() {
        return this.standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getPunishDeside() {
        return this.punishDeside;
    }

    public void setPunishDeside(String punishDeside) {
        this.punishDeside = punishDeside;
    }

    public String getPunishClass() {
        return this.punishClass;
    }

    public void setPunishClass(String punishClass) {
        this.punishClass = punishClass;
    }

    public String getPunishResult() {
        return this.punishResult;
    }

    public void setPunishResult(String punishResult) {
        this.punishResult = punishResult;
    }

    public Double getPunishResultFine() {
        return this.punishResultFine;
    }

    public void setPunishResultFine(Double punishResultFine) {
        this.punishResultFine = punishResultFine;
    }

    public Long getPunishResultFinePeople() {
        return this.punishResultFinePeople;
    }

    public void setPunishResultFinePeople(Long punishResultFinePeople) {
        this.punishResultFinePeople = punishResultFinePeople;
    }

    public Double getPunishResultExpropriation() {
        return this.punishResultExpropriation;
    }

    public void setPunishResultExpropriation(Double punishResultExpropriation) {
        this.punishResultExpropriation = punishResultExpropriation;
    }

    public Double getPunishResultExpropriationV() {
        return this.punishResultExpropriationV;
    }

    public void setPunishResultExpropriationV(Double punishResultExpropriationV) {
        this.punishResultExpropriationV = punishResultExpropriationV;
    }

    public Long getPunishResultBusiness() {
        return this.punishResultBusiness;
    }

    public void setPunishResultBusiness(Long punishResultBusiness) {
        this.punishResultBusiness = punishResultBusiness;
    }

    public Long getPunishResultPeople() {
        return this.punishResultPeople;
    }

    public void setPunishResultPeople(Long punishResultPeople) {
        this.punishResultPeople = punishResultPeople;
    }

    public Long getPunishResultDetain() {
        return this.punishResultDetain;
    }

    public void setPunishResultDetain(Long punishResultDetain) {
        this.punishResultDetain = punishResultDetain;
    }

    public String getAttachment() {
        return this.attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Date getFinishDate() {
        return this.finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getResultStandard() {
        return this.resultStandard;
    }

    public void setResultStandard(String resultStandard) {
        this.resultStandard = resultStandard;
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

    public Date getSyncDate() {
        return this.syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    public String getSyncSign() {
        return this.syncSign;
    }

    public void setSyncSign(String syncSign) {
        this.syncSign = syncSign;
    }

    public String getSyncErrorDesc() {
        return this.syncErrorDesc;
    }

    public void setSyncErrorDesc(String syncErrorDesc) {
        this.syncErrorDesc = syncErrorDesc;
    }

    public void copy(PunishResult other) {

        this.setNo(other.getNo());

        this.changNo = other.getChangNo();
        this.orgId = other.getOrgId();
        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.program = other.getProgram();
        this.punishSort = other.getPunishSort();
        this.accordance = other.getAccordance();
        this.standard = other.getStandard();
        this.punishDeside = other.getPunishDeside();
        this.punishClass = other.getPunishClass();
        this.punishResult = other.getPunishResult();
        this.punishResultFine = other.getPunishResultFine();
        this.punishResultFinePeople = other.getPunishResultFinePeople();
        this.punishResultExpropriation = other.getPunishResultExpropriation();
        this.punishResultExpropriationV = other.getPunishResultExpropriationV();
        this.punishResultBusiness = other.getPunishResultBusiness();
        this.punishResultPeople = other.getPunishResultPeople();
        this.punishResultDetain = other.getPunishResultDetain();
        this.attachment = other.getAttachment();
        this.finishDate = other.getFinishDate();
        this.resultStandard = other.getResultStandard();
        this.createDate = other.getCreateDate();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();
        this.isRecord = other.getIsRecord();

    }

    public void copyNotNullProperty(PunishResult other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getChangNo() != null)
            this.changNo = other.getChangNo();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getProgram() != null)
            this.program = other.getProgram();
        if (other.getPunishSort() != null)
            this.punishSort = other.getPunishSort();
        if (other.getAccordance() != null)
            this.accordance = other.getAccordance();
        if (other.getStandard() != null)
            this.standard = other.getStandard();
        if (other.getPunishDeside() != null)
            this.punishDeside = other.getPunishDeside();
        if (other.getPunishClass() != null)
            this.punishClass = other.getPunishClass();
        if (other.getPunishResult() != null)
            this.punishResult = other.getPunishResult();
        if (other.getPunishResultFine() != null)
            this.punishResultFine = other.getPunishResultFine();
        if (other.getPunishResultFinePeople() != null)
            this.punishResultFinePeople = other.getPunishResultFinePeople();
        if (other.getPunishResultExpropriation() != null)
            this.punishResultExpropriation = other
                    .getPunishResultExpropriation();
        if (other.getPunishResultExpropriationV() != null)
            this.punishResultExpropriationV = other
                    .getPunishResultExpropriationV();
        if (other.getPunishResultBusiness() != null)
            this.punishResultBusiness = other.getPunishResultBusiness();
        if (other.getPunishResultPeople() != null)
            this.punishResultPeople = other.getPunishResultPeople();
        if (other.getPunishResultDetain() != null)
            this.punishResultDetain = other.getPunishResultDetain();
        if (other.getAttachment() != null)
            this.attachment = other.getAttachment();
        if (other.getFinishDate() != null)
            this.finishDate = other.getFinishDate();
        if (other.getResultStandard() != null)
            this.resultStandard = other.getResultStandard();
        if (other.getCreateDate() != null)
            this.createDate = other.getCreateDate();
        if (other.getUpdateDate() != null)
            this.updateDate = other.getUpdateDate();
        if (other.getSyncDate() != null)
            this.syncDate = other.getSyncDate();
        if (other.getSyncSign() != null)
            this.syncSign = other.getSyncSign();
        if (other.getSyncErrorDesc() != null)
            this.syncErrorDesc = other.getSyncErrorDesc();
        if (other.getIsRecord() != null)
            this.isRecord = other.getIsRecord();

    }

    public void clearProperties() {

        this.changNo = null;
        this.orgId = null;
        this.internalNo = null;
        this.itemId = null;
        this.program = null;
        this.punishSort = null;
        this.accordance = null;
        this.standard = null;
        this.punishDeside = null;
        this.punishClass = null;
        this.punishResult = null;
        this.punishResultFine = null;
        this.punishResultFinePeople = null;
        this.punishResultExpropriation = null;
        this.punishResultExpropriationV = null;
        this.punishResultBusiness = null;
        this.punishResultPeople = null;
        this.punishResultDetain = null;
        this.attachment = null;
        this.finishDate = null;
        this.resultStandard = null;
        this.createDate = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;
        this.isRecord = null;

    }
}
