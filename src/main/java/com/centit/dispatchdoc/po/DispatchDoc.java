package com.centit.dispatchdoc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.centit.powerruntime.po.OptBaseInfo;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class DispatchDoc implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String djId;

    private String internalNo;
    private String itemId;
    private String dispatchDocNo;
    private String dispatchDocTitle;
    private String dispatchFileType;
    private String dispatchDocType;
    private String dispatchCanOpen;
    private String dispatchOpenType;
    private String notOpenReason;
    private String isUnionDispatch;
    private String unionOthers;
    private String isCountersign;
    private String dispatchDocSummary;
    private Date draftDate;
    private String optUnitName;
    private String draftUserName;
    private String secretsDegree;
    private Long dispatchCopies;
    private String mainNotifyUnit;
    private String otherUnits;
    private Date retentionPeriod;
    private String checkUserName;
    private String dispatchDocFileName;
    private byte[] dispatchDocFile;
    private Date createDate;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;
    private String dispatchDocRed;
    private Date printDate;
    private String criticalLevel;
    private String flowCode;
    private OptBaseInfo optBaseInfo;
    private Set<DocRelative> docRelatives = null;// new
                                                 // ArrayList<DocRelative>();
    protected String ideacode;

    public String getIdeacode() {
        return ideacode;
    }

    public void setIdeacode(String ideacode) {
        this.ideacode = ideacode;
    }

    // Constructors
    /** default constructor */
    public DispatchDoc() {
    }

    /** minimal constructor */
    public DispatchDoc(String djId, String internalNo, String itemId,
            Date createDate, Date updateDate) {

        this.djId = djId;

        this.internalNo = internalNo;
        this.itemId = itemId;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public DispatchDoc(String djId, String internalNo, String itemId,
            String dispatchDocNo, String dispatchDocTitle,
            String dispatchFileType, String dispatchDocType,
            String dispatchCanOpen, String dispatchOpenType,
            String notOpenReason, String isUnionDispatch, String unionOthers,
            String isCountersign, String dispatchDocSummary, Date draftDate,
            String optUnitName, String draftUserName, String secretsDegree,
            Long dispatchCopies, String mainNotifyUnit, String otherUnits,
            Date retentionPeriod, String checkUserName,
            String dispatchDocFileName, byte[] dispatchDocFile,
            Date createDate, Date updateDate, Date syncDate, String syncSign,
            String syncErrorDesc, String dispatchDocRed, Date printDate,
            String criticalLevel) {

        this.djId = djId;

        this.internalNo = internalNo;
        this.itemId = itemId;
        this.dispatchDocNo = dispatchDocNo;
        this.dispatchDocTitle = dispatchDocTitle;
        this.dispatchFileType = dispatchFileType;
        this.dispatchDocType = dispatchDocType;
        this.dispatchCanOpen = dispatchCanOpen;
        this.dispatchOpenType = dispatchOpenType;
        this.notOpenReason = notOpenReason;
        this.isUnionDispatch = isUnionDispatch;
        this.unionOthers = unionOthers;
        this.isCountersign = isCountersign;
        this.dispatchDocSummary = dispatchDocSummary;
        this.draftDate = draftDate;
        this.optUnitName = optUnitName;
        this.draftUserName = draftUserName;
        this.secretsDegree = secretsDegree;
        this.dispatchCopies = dispatchCopies;
        this.mainNotifyUnit = mainNotifyUnit;
        this.otherUnits = otherUnits;
        this.retentionPeriod = retentionPeriod;
        this.checkUserName = checkUserName;
        this.dispatchDocFileName = dispatchDocFileName;
        this.dispatchDocFile = dispatchDocFile;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
        this.dispatchDocRed = dispatchDocRed;
        this.printDate = printDate;
        this.criticalLevel = criticalLevel;
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

    public String getDispatchDocNo() {
        return this.dispatchDocNo;
    }

    public void setDispatchDocNo(String dispatchDocNo) {
        this.dispatchDocNo = dispatchDocNo;
    }

    public String getDispatchDocTitle() {
        return this.dispatchDocTitle;
    }

    public void setDispatchDocTitle(String dispatchDocTitle) {
        this.dispatchDocTitle = dispatchDocTitle;
    }

    public String getDispatchFileType() {
        return this.dispatchFileType;
    }

    public void setDispatchFileType(String dispatchFileType) {
        this.dispatchFileType = dispatchFileType;
    }

    public String getDispatchDocType() {
        return this.dispatchDocType;
    }

    public void setDispatchDocType(String dispatchDocType) {
        this.dispatchDocType = dispatchDocType;
    }

    public String getDispatchCanOpen() {
        return this.dispatchCanOpen;
    }

    public void setDispatchCanOpen(String dispatchCanOpen) {
        this.dispatchCanOpen = dispatchCanOpen;
    }

    public String getDispatchOpenType() {
        return this.dispatchOpenType;
    }

    public void setDispatchOpenType(String dispatchOpenType) {
        this.dispatchOpenType = dispatchOpenType;
    }

    public String getNotOpenReason() {
        return this.notOpenReason;
    }

    public void setNotOpenReason(String notOpenReason) {
        this.notOpenReason = notOpenReason;
    }

    public String getIsUnionDispatch() {
        return this.isUnionDispatch;
    }

    public void setIsUnionDispatch(String isUnionDispatch) {
        this.isUnionDispatch = isUnionDispatch;
    }

    public String getUnionOthers() {
        return this.unionOthers;
    }

    public void setUnionOthers(String unionOthers) {
        this.unionOthers = unionOthers;
    }

    public String getIsCountersign() {
        return this.isCountersign;
    }

    public void setIsCountersign(String isCountersign) {
        this.isCountersign = isCountersign;
    }

    public String getDispatchDocSummary() {
        return this.dispatchDocSummary;
    }

    public void setDispatchDocSummary(String dispatchDocSummary) {
        this.dispatchDocSummary = dispatchDocSummary;
    }

    public Date getDraftDate() {
        return this.draftDate;
    }

    public void setDraftDate(Date draftDate) {
        this.draftDate = draftDate;
    }

    public String getOptUnitName() {
        return this.optUnitName;
    }

    public void setOptUnitName(String optUnitName) {
        this.optUnitName = optUnitName;
    }

    public String getDraftUserName() {
        return this.draftUserName;
    }

    public void setDraftUserName(String draftUserName) {
        this.draftUserName = draftUserName;
    }

    public String getSecretsDegree() {
        return this.secretsDegree;
    }

    public void setSecretsDegree(String secretsDegree) {
        this.secretsDegree = secretsDegree;
    }

    public Long getDispatchCopies() {
        return this.dispatchCopies;
    }

    public void setDispatchCopies(Long dispatchCopies) {
        this.dispatchCopies = dispatchCopies;
    }

    public String getMainNotifyUnit() {
        return this.mainNotifyUnit;
    }

    public void setMainNotifyUnit(String mainNotifyUnit) {
        this.mainNotifyUnit = mainNotifyUnit;
    }

    public String getOtherUnits() {
        return this.otherUnits;
    }

    public void setOtherUnits(String otherUnits) {
        this.otherUnits = otherUnits;
    }

    public Date getRetentionPeriod() {
        return this.retentionPeriod;
    }

    public void setRetentionPeriod(Date retentionPeriod) {
        this.retentionPeriod = retentionPeriod;
    }

    public String getCheckUserName() {
        return this.checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    public String getDispatchDocFileName() {
        return this.dispatchDocFileName;
    }

    public void setDispatchDocFileName(String dispatchDocFileName) {
        this.dispatchDocFileName = dispatchDocFileName;
    }

    public byte[] getDispatchDocFile() {
        return this.dispatchDocFile;
    }

    public void setDispatchDocFile(byte[] dispatchDocFile) {
        this.dispatchDocFile = dispatchDocFile;
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

    public String getDispatchDocRed() {
        return this.dispatchDocRed;
    }

    public void setDispatchDocRed(String dispatchDocRed) {
        this.dispatchDocRed = dispatchDocRed;
    }

    public Date getPrintDate() {
        return this.printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public String getCriticalLevel() {
        return this.criticalLevel;
    }

    public void setCriticalLevel(String criticalLevel) {
        this.criticalLevel = criticalLevel;
    }

    public Set<DocRelative> getDocRelatives() {
        if (this.docRelatives == null)
            this.docRelatives = new HashSet<DocRelative>();
        return this.docRelatives;
    }

    public void setDocRelatives(Set<DocRelative> docRelatives) {
        this.docRelatives = docRelatives;
    }

    public void addDocRelative(DocRelative docRelative) {
        if (this.docRelatives == null)
            this.docRelatives = new HashSet<DocRelative>();
        this.docRelatives.add(docRelative);
    }

    public void removeDocRelative(DocRelative docRelative) {
        if (this.docRelatives == null)
            return;
        this.docRelatives.remove(docRelative);
    }

    public DocRelative newDocRelative() {
        DocRelative res = new DocRelative();

        res.setDispatchNo(this.getDjId());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replaceDocRelatives(List<DocRelative> docRelatives) {
        List<DocRelative> newObjs = new ArrayList<DocRelative>();
        for (DocRelative p : docRelatives) {
            if (p == null)
                continue;
            DocRelative newdt = newDocRelative();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<DocRelative> oldObjs = new HashSet<DocRelative>();
        oldObjs.addAll(getDocRelatives());

        for (Iterator<DocRelative> it = oldObjs.iterator(); it.hasNext();) {
            DocRelative odt = it.next();
            found = false;
            for (DocRelative newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeDocRelative(odt);
        }
        oldObjs.clear();
        // insert or update
        for (DocRelative newdt : newObjs) {
            found = false;
            for (Iterator<DocRelative> it = getDocRelatives().iterator(); it
                    .hasNext();) {
                DocRelative odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addDocRelative(newdt);
        }
    }

    public void copy(DispatchDoc other) {

        this.setDjId(other.getDjId());

        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.dispatchDocNo = other.getDispatchDocNo();
        this.dispatchDocTitle = other.getDispatchDocTitle();
        this.dispatchFileType = other.getDispatchFileType();
        this.dispatchDocType = other.getDispatchDocType();
        this.dispatchCanOpen = other.getDispatchCanOpen();
        this.dispatchOpenType = other.getDispatchOpenType();
        this.notOpenReason = other.getNotOpenReason();
        this.isUnionDispatch = other.getIsUnionDispatch();
        this.unionOthers = other.getUnionOthers();
        this.isCountersign = other.getIsCountersign();
        this.dispatchDocSummary = other.getDispatchDocSummary();
        this.draftDate = other.getDraftDate();
        this.optUnitName = other.getOptUnitName();
        this.draftUserName = other.getDraftUserName();
        this.secretsDegree = other.getSecretsDegree();
        this.dispatchCopies = other.getDispatchCopies();
        this.mainNotifyUnit = other.getMainNotifyUnit();
        this.otherUnits = other.getOtherUnits();
        this.retentionPeriod = other.getRetentionPeriod();
        this.checkUserName = other.getCheckUserName();
        this.dispatchDocFileName = other.getDispatchDocFileName();
        this.dispatchDocFile = other.getDispatchDocFile();
        this.createDate = other.getCreateDate();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();
        this.dispatchDocRed = other.getDispatchDocRed();
        this.printDate = other.getPrintDate();
        this.criticalLevel = other.getCriticalLevel();
        this.flowCode = other.getFlowCode();
        this.docRelatives = other.getDocRelatives();
    }

    public void copyNotNullProperty(DispatchDoc other) {

        if (other.getDjId() != null)
            this.setDjId(other.getDjId());

        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getDispatchDocNo() != null)
            this.dispatchDocNo = other.getDispatchDocNo();
        if (other.getDispatchDocTitle() != null)
            this.dispatchDocTitle = other.getDispatchDocTitle();
        if (other.getDispatchFileType() != null)
            this.dispatchFileType = other.getDispatchFileType();
        if (other.getDispatchDocType() != null)
            this.dispatchDocType = other.getDispatchDocType();
        if (other.getDispatchCanOpen() != null)
            this.dispatchCanOpen = other.getDispatchCanOpen();
        if (other.getDispatchOpenType() != null)
            this.dispatchOpenType = other.getDispatchOpenType();
        if (other.getNotOpenReason() != null)
            this.notOpenReason = other.getNotOpenReason();
        if (other.getIsUnionDispatch() != null)
            this.isUnionDispatch = other.getIsUnionDispatch();
        if (other.getUnionOthers() != null)
            this.unionOthers = other.getUnionOthers();
        if (other.getIsCountersign() != null)
            this.isCountersign = other.getIsCountersign();
        if (other.getDispatchDocSummary() != null)
            this.dispatchDocSummary = other.getDispatchDocSummary();
        if (other.getDraftDate() != null)
            this.draftDate = other.getDraftDate();
        if (other.getOptUnitName() != null)
            this.optUnitName = other.getOptUnitName();
        if (other.getDraftUserName() != null)
            this.draftUserName = other.getDraftUserName();
        if (other.getSecretsDegree() != null)
            this.secretsDegree = other.getSecretsDegree();
        if (other.getDispatchCopies() != null)
            this.dispatchCopies = other.getDispatchCopies();
        if (other.getMainNotifyUnit() != null)
            this.mainNotifyUnit = other.getMainNotifyUnit();
        if (other.getOtherUnits() != null)
            this.otherUnits = other.getOtherUnits();
        if (other.getRetentionPeriod() != null)
            this.retentionPeriod = other.getRetentionPeriod();
        if (other.getCheckUserName() != null)
            this.checkUserName = other.getCheckUserName();
        if (other.getDispatchDocFileName() != null)
            this.dispatchDocFileName = other.getDispatchDocFileName();
        if (other.getDispatchDocFile() != null)
            this.dispatchDocFile = other.getDispatchDocFile();
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
        if (other.getDispatchDocRed() != null)
            this.dispatchDocRed = other.getDispatchDocRed();
        if (other.getPrintDate() != null)
            this.printDate = other.getPrintDate();
        if (other.getCriticalLevel() != null)
            this.criticalLevel = other.getCriticalLevel();
        if (other.getFlowCode() != null)
            this.flowCode = other.getFlowCode();

        this.docRelatives = other.getDocRelatives();
    }

    public void clearProperties() {

        this.internalNo = null;
        this.itemId = null;
        this.dispatchDocNo = null;
        this.dispatchDocTitle = null;
        this.dispatchFileType = null;
        this.dispatchDocType = null;
        this.dispatchCanOpen = null;
        this.dispatchOpenType = null;
        this.notOpenReason = null;
        this.isUnionDispatch = null;
        this.unionOthers = null;
        this.isCountersign = null;
        this.dispatchDocSummary = null;
        this.draftDate = null;
        this.optUnitName = null;
        this.draftUserName = null;
        this.secretsDegree = null;
        this.dispatchCopies = null;
        this.mainNotifyUnit = null;
        this.otherUnits = null;
        this.retentionPeriod = null;
        this.checkUserName = null;
        this.dispatchDocFileName = null;
        this.dispatchDocFile = null;
        this.createDate = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;
        this.dispatchDocRed = null;
        this.printDate = null;
        this.criticalLevel = null;
        this.flowCode = null;
        this.docRelatives = new HashSet<DocRelative>();
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public OptBaseInfo getOptBaseInfo() {
        return optBaseInfo;
    }

    public void setOptBaseInfo(OptBaseInfo optBaseInfo) {
        this.optBaseInfo = optBaseInfo;
    }
}
