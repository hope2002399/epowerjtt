package com.centit.indicator.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class PmTempletIndicator implements java.io.Serializable {
	private static final long serialVersionUID =  1L;
	private PmTempletIndicatorId cid;


	private String  ifMust;
	private String  ifInternal;
	private String  internalTable;
	private String ifAlong;
	private String  ifPrimary;
	private String  ifHidden;
	private Long  indicatorLevel;
	private Long  indicatorIndex;
	private String  ifWriteBack;
	private String  writeBackTable;
	private String  writeBackIndicator;
	private Date  createTime;
	private String  createBy;
	private String ifCp;
	private String evlType;
	private String evlMethod;
	private String version;
	private String fatherId;
	private String businessNotes;

	// Constructors
	/** default constructor */
	public PmTempletIndicator() {
	}
	/** minimal constructor */
	public PmTempletIndicator(PmTempletIndicatorId id 
				
		) {
		this.cid = id; 
			
			
	}

/** full constructor */
	public PmTempletIndicator(PmTempletIndicatorId id,String fatherId
			
	,String  ifMust,String  ifInternal,String  internalTable,String ifAlong,String  ifPrimary,String  ifHidden,Long  indicatorLevel,Long  indicatorIndex,String  ifWriteBack,String  writeBackTable,String  writeBackIndicator,Date  createTime,String  createBy,
	String ifCp,String evlType,String evlMethod,String version) {
		this.cid = id; 
			
	
		this.ifAlong=ifAlong;
		this.ifMust= ifMust;
		this.ifInternal= ifInternal;
		this.internalTable= internalTable;
		this.ifPrimary= ifPrimary;
		this.ifHidden= ifHidden;
		this.indicatorLevel= indicatorLevel;
		this.indicatorIndex= indicatorIndex;
		this.ifWriteBack= ifWriteBack;
		this.writeBackTable= writeBackTable;
		this.writeBackIndicator= writeBackIndicator;
		this.createTime= createTime;
		this.createBy= createBy;
		this.ifCp=ifCp;
		this.evlType=evlType;
		this.evlMethod=evlMethod;
		this.version=version;
		this.fatherId=fatherId;
	}

	public PmTempletIndicatorId getCid() {
		return this.cid;
	}
	
	public void setCid(PmTempletIndicatorId id) {
		this.cid = id;
	}
  
	public String getTempletId() {
		if(this.cid==null)
			this.cid = new PmTempletIndicatorId();
		return this.cid.getTempletId();
	}
	
	public void setTempletId(String templetId) {
		if(this.cid==null)
			this.cid = new PmTempletIndicatorId();
		this.cid.setTempletId(templetId);
	}
  
	public String getIndicatorId() {
		if(this.cid==null)
			this.cid = new PmTempletIndicatorId();
		return this.cid.getIndicatorId();
	}
	
	public void setIndicatorId(String indicatorId) {
		if(this.cid==null)
			this.cid = new PmTempletIndicatorId();
		this.cid.setIndicatorId(indicatorId);
	}
	
	

	// Property accessors
  
	public String getIfMust() {
		return this.ifMust;
	}
	
	public void setIfMust(String ifMust) {
		this.ifMust = ifMust;
	}
  
	public String getIfInternal() {
		return this.ifInternal;
	}
	
	public void setIfInternal(String ifInternal) {
		this.ifInternal = ifInternal;
	}
  
	public String getInternalTable() {
		return this.internalTable;
	}
	
	public void setInternalTable(String internalTable) {
		this.internalTable = internalTable;
	}
  
	public String getIfPrimary() {
		return this.ifPrimary;
	}
	
	public void setIfPrimary(String ifPrimary) {
		this.ifPrimary = ifPrimary;
	}
  
	public String getIfAlong() {
		return ifAlong;
	}
	public void setIfAlong(String ifAlong) {
		this.ifAlong = ifAlong;
	}
	public String getIfHidden() {
		return this.ifHidden;
	}
	
	public void setIfHidden(String ifHidden) {
		this.ifHidden = ifHidden;
	}
  
	public Long getIndicatorLevel() {
		return this.indicatorLevel;
	}
	
	public void setIndicatorLevel(Long indicatorLevel) {
		this.indicatorLevel = indicatorLevel;
	}
  
	public Long getIndicatorIndex() {
		return this.indicatorIndex;
	}
	
	public void setIndicatorIndex(Long indicatorIndex) {
		this.indicatorIndex = indicatorIndex;
	}
  
	public String getIfWriteBack() {
		return this.ifWriteBack;
	}
	
	public void setIfWriteBack(String ifWriteBack) {
		this.ifWriteBack = ifWriteBack;
	}
  
	public String getWriteBackTable() {
		return this.writeBackTable;
	}
	
	public void setWriteBackTable(String writeBackTable) {
		this.writeBackTable = writeBackTable;
	}
  
	public String getWriteBackIndicator() {
		return this.writeBackIndicator;
	}
	
	public void setWriteBackIndicator(String writeBackIndicator) {
		this.writeBackIndicator = writeBackIndicator;
	}
  
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
  
	public String getCreateBy() {
		return this.createBy;
	}
	
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void copy(PmTempletIndicator other){
  
		this.setTempletId(other.getTempletId());  
		this.setIndicatorId(other.getIndicatorId());
  
		this.ifAlong=other.getIfAlong();
		this.ifMust= other.getIfMust();  
		this.ifInternal= other.getIfInternal();  
		this.internalTable= other.getInternalTable();  
		this.ifPrimary= other.getIfPrimary();  
		this.ifHidden= other.getIfHidden();  
		this.indicatorLevel= other.getIndicatorLevel();  
		this.indicatorIndex= other.getIndicatorIndex();  
		this.ifWriteBack= other.getIfWriteBack();  
		this.writeBackTable= other.getWriteBackTable();  
		this.writeBackIndicator= other.getWriteBackIndicator();  
		this.createTime= other.getCreateTime();  
		this.createBy= other.getCreateBy();
		this.ifCp=other.getIfCp();
		this.evlType=other.getEvlType();
		this.evlMethod=other.getEvlMethod();
		this.version=other.getVersion();
		this.fatherId=other.getFatherId();
	}
	
	public void copyNotNullProperty(PmTempletIndicator other){
  
	if( other.getTempletId() != null)
		this.setTempletId(other.getTempletId());  
	if( other.getIndicatorId() != null)
		this.setIndicatorId(other.getIndicatorId());
  
		if( other.getIfMust() != null)
			this.ifMust= other.getIfMust();  
		if( other.getIfInternal() != null)
			this.ifInternal= other.getIfInternal();  
		if( other.getInternalTable() != null)
			this.internalTable= other.getInternalTable();  
		if(other.getIfAlong()!=null)
			this.ifAlong=other.getIfAlong();
		if( other.getIfPrimary() != null)
			this.ifPrimary= other.getIfPrimary();  
		if( other.getIfHidden() != null)
			this.ifHidden= other.getIfHidden();  
		if( other.getIndicatorLevel() != null)
			this.indicatorLevel= other.getIndicatorLevel();  
		if( other.getIndicatorIndex() != null)
			this.indicatorIndex= other.getIndicatorIndex();  
		if( other.getIfWriteBack() != null)
			this.ifWriteBack= other.getIfWriteBack();  
		if( other.getWriteBackTable() != null)
			this.writeBackTable= other.getWriteBackTable();  
		if( other.getWriteBackIndicator() != null)
			this.writeBackIndicator= other.getWriteBackIndicator();  
		if( other.getCreateTime() != null)
			this.createTime= other.getCreateTime();  
		if( other.getCreateBy() != null)
			this.createBy= other.getCreateBy();
		if( other.getIfCp() !=null)
			this.ifCp=other.getIfCp();
		if( other.getEvlType()!=null)
			this.evlType=other.getEvlType();
		if( other.getEvlMethod()!=null)
			this.evlMethod=other.getEvlMethod();
		if( other.getVersion()!=null)
			this.version=other.getVersion();
		if(other.getFatherId()!=null)
			this.fatherId=fatherId;
	}
	
	public void clearProperties(){
  
		this.ifMust= null;  
		this.ifInternal= null;  
		this.internalTable= null;  
		this.ifAlong=null;
		this.ifPrimary= null;  
		this.ifHidden= null;  
		this.indicatorLevel= null;  
		this.indicatorIndex= null;  
		this.ifWriteBack= null;  
		this.writeBackTable= null;  
		this.writeBackIndicator= null;  
		this.createTime= null;  
		this.createBy= null;
		this.ifCp=null;
		this.evlType=null;
		this.evlMethod=null;
		this.version=null;
		this.fatherId=null;

	}
	public String getIfCp() {
		return ifCp;
	}
	public void setIfCp(String ifCp) {
		this.ifCp = ifCp;
	}
	public String getEvlType() {
		return evlType;
	}
	public void setEvlType(String evlType) {
		this.evlType = evlType;
	}
	public String getEvlMethod() {
		return evlMethod;
	}
	public void setEvlMethod(String evlMethod) {
		this.evlMethod = evlMethod;
	}
    public String getBusinessNotes() {
        return businessNotes;
    }
    public void setBusinessNotes(String businessNotes) {
        this.businessNotes = businessNotes;
    }
	
	
}
