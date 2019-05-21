package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class DeptQlInf implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String iddeptQlInf;

	private String  updateType;
	private String  deptQlParentId;
	private String  qlKind;
	private String  qlRegNo;
	private String  deptQlRegNo;
	private String  qlName;
	private String  qlShortName;
	private String  deptId;
	private String  qlDepstate;
	private String  entrustName;
	private String  deptAreano;
	private String  deptOrganization;
	private String  qlByLaw;
	private String  useLevel;
	private String  useLevelC;
	private String  remaer;
	private String  qlState;
	private Date  startTime;
	private Date  endTime;
	private String  endReason;
	private String  endReasonRemark;
	private Long  qlVersion;
	private Date  createDate;
	private String  syncSign;
	private Date  syncDate;
	private String  syncErrorDesc;
	private Date  updateDate;
	private String  idnewQlInf;
	private Long  qlSubCount;
	private String  updateSign;
	private String  updateErrorDesc;
	private String  ifAuditTransfer;
	private String  auditTransferType;
	private String  ifNPPublic;
	private String  ifEnterGovHall;
	private String orgShortName;
	// Constructors
	/** default constructor */
	public DeptQlInf() {
	}
	/** minimal constructor */
	public DeptQlInf(
		String iddeptQlInf		
		,String  updateType,String  qlName,String  deptId,Date  createDate,String  syncSign,String  updateSign) {
	
	
		this.iddeptQlInf = iddeptQlInf;		
	
		this.updateType= updateType; 
		this.qlName= qlName; 
		this.deptId= deptId; 
		this.createDate= createDate; 
		this.syncSign= syncSign; 
		this.updateSign= updateSign; 		
	}

/** full constructor */
	public DeptQlInf(
	 String iddeptQlInf		
	,String  updateType,String  deptQlParentId,String  qlKind,String  qlRegNo,String  deptQlRegNo,String  qlName,String  qlShortName,String  deptId,String  qlDepstate,String  entrustName,String  deptAreano,String  deptOrganization,String  qlByLaw,String  useLevel,String  useLevelC,String  remaer,String  qlState,Date  startTime,Date  endTime,String  endReason,String  endReasonRemark,Long  qlVersion,Date  createDate,String  syncSign,Date  syncDate,String  syncErrorDesc,Date  updateDate,String  idnewQlInf,Long  qlSubCount,String  updateSign,String  updateErrorDesc,String  ifAuditTransfer,String  auditTransferType,String  ifNPPublic,String  ifEnterGovHall) {
	
	
		this.iddeptQlInf = iddeptQlInf;		
	
		this.updateType= updateType;
		this.deptQlParentId= deptQlParentId;
		this.qlKind= qlKind;
		this.qlRegNo= qlRegNo;
		this.deptQlRegNo= deptQlRegNo;
		this.qlName= qlName;
		this.qlShortName= qlShortName;
		this.deptId= deptId;
		this.qlDepstate= qlDepstate;
		this.entrustName= entrustName;
		this.deptAreano= deptAreano;
		this.deptOrganization= deptOrganization;
		this.qlByLaw= qlByLaw;
		this.useLevel= useLevel;
		this.useLevelC= useLevelC;
		this.remaer= remaer;
		this.qlState= qlState;
		this.startTime= startTime;
		this.endTime= endTime;
		this.endReason= endReason;
		this.endReasonRemark= endReasonRemark;
		this.qlVersion= qlVersion;
		this.createDate= createDate;
		this.syncSign= syncSign;
		this.syncDate= syncDate;
		this.syncErrorDesc= syncErrorDesc;
		this.updateDate= updateDate;
		this.idnewQlInf= idnewQlInf;
		this.qlSubCount= qlSubCount;
		this.updateSign= updateSign;
		this.updateErrorDesc= updateErrorDesc;
		this.ifAuditTransfer= ifAuditTransfer;
		this.auditTransferType= auditTransferType;
		this.ifNPPublic= ifNPPublic;
		this.ifEnterGovHall= ifEnterGovHall;		
	}
	

  
	public String getOrgShortName() {
    return orgShortName;
}
public void setOrgShortName(String orgShortName) {
    this.orgShortName = orgShortName;
}
    public String getIddeptQlInf() {
		return this.iddeptQlInf;
	}

	public void setIddeptQlInf(String iddeptQlInf) {
		this.iddeptQlInf = iddeptQlInf;
	}
	// Property accessors
  
	public String getUpdateType() {
		return this.updateType;
	}
	
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
  
	public String getDeptQlParentId() {
		return this.deptQlParentId;
	}
	
	public void setDeptQlParentId(String deptQlParentId) {
		this.deptQlParentId = deptQlParentId;
	}
  
	public String getQlKind() {
		return this.qlKind;
	}
	
	public void setQlKind(String qlKind) {
		this.qlKind = qlKind;
	}
  
	public String getQlRegNo() {
		return this.qlRegNo;
	}
	
	public void setQlRegNo(String qlRegNo) {
		this.qlRegNo = qlRegNo;
	}
  
	public String getDeptQlRegNo() {
		return this.deptQlRegNo;
	}
	
	public void setDeptQlRegNo(String deptQlRegNo) {
		this.deptQlRegNo = deptQlRegNo;
	}
  
	public String getQlName() {
		return this.qlName;
	}
	
	public void setQlName(String qlName) {
		this.qlName = qlName;
	}
  
	public String getQlShortName() {
		return this.qlShortName;
	}
	
	public void setQlShortName(String qlShortName) {
		this.qlShortName = qlShortName;
	}
  
	public String getDeptId() {
		return this.deptId;
	}
	
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
  
	public String getQlDepstate() {
		return this.qlDepstate;
	}
	
	public void setQlDepstate(String qlDepstate) {
		this.qlDepstate = qlDepstate;
	}
  
	public String getEntrustName() {
		return this.entrustName;
	}
	
	public void setEntrustName(String entrustName) {
		this.entrustName = entrustName;
	}
  
	public String getDeptAreano() {
		return this.deptAreano;
	}
	
	public void setDeptAreano(String deptAreano) {
		this.deptAreano = deptAreano;
	}
  
	public String getDeptOrganization() {
		return this.deptOrganization;
	}
	
	public void setDeptOrganization(String deptOrganization) {
		this.deptOrganization = deptOrganization;
	}
  
	public String getQlByLaw() {
		return this.qlByLaw;
	}
	
	public void setQlByLaw(String qlByLaw) {
		this.qlByLaw = qlByLaw;
	}
  
	public String getUseLevel() {
		return this.useLevel;
	}
	
	public void setUseLevel(String useLevel) {
		this.useLevel = useLevel;
	}
  
	public String getUseLevelC() {
		return this.useLevelC;
	}
	
	public void setUseLevelC(String useLevelC) {
		this.useLevelC = useLevelC;
	}
  
	public String getRemaer() {
		return this.remaer;
	}
	
	public void setRemaer(String remaer) {
		this.remaer = remaer;
	}
  
	public String getQlState() {
		return this.qlState;
	}
	
	public void setQlState(String qlState) {
		this.qlState = qlState;
	}
  
	public Date getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
  
	public Date getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
  
	public String getEndReason() {
		return this.endReason;
	}
	
	public void setEndReason(String endReason) {
		this.endReason = endReason;
	}
  
	public String getEndReasonRemark() {
		return this.endReasonRemark;
	}
	
	public void setEndReasonRemark(String endReasonRemark) {
		this.endReasonRemark = endReasonRemark;
	}
  
	public Long getQlVersion() {
		return this.qlVersion;
	}
	
	public void setQlVersion(Long qlVersion) {
		this.qlVersion = qlVersion;
	}
  
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
  
	public String getSyncSign() {
		return this.syncSign;
	}
	
	public void setSyncSign(String syncSign) {
		this.syncSign = syncSign;
	}
  
	public Date getSyncDate() {
		return this.syncDate;
	}
	
	public void setSyncDate(Date syncDate) {
		this.syncDate = syncDate;
	}
  
	public String getSyncErrorDesc() {
		return this.syncErrorDesc;
	}
	
	public void setSyncErrorDesc(String syncErrorDesc) {
		this.syncErrorDesc = syncErrorDesc;
	}
  
	public Date getUpdateDate() {
		return this.updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
  
	public String getIdnewQlInf() {
		return this.idnewQlInf;
	}
	
	public void setIdnewQlInf(String idnewQlInf) {
		this.idnewQlInf = idnewQlInf;
	}
  
	public Long getQlSubCount() {
		return this.qlSubCount;
	}
	
	public void setQlSubCount(Long qlSubCount) {
		this.qlSubCount = qlSubCount;
	}
  
	public String getUpdateSign() {
		return this.updateSign;
	}
	
	public void setUpdateSign(String updateSign) {
		this.updateSign = updateSign;
	}
  
	public String getUpdateErrorDesc() {
		return this.updateErrorDesc;
	}
	
	public void setUpdateErrorDesc(String updateErrorDesc) {
		this.updateErrorDesc = updateErrorDesc;
	}
  
	public String getIfAuditTransfer() {
		return this.ifAuditTransfer;
	}
	
	public void setIfAuditTransfer(String ifAuditTransfer) {
		this.ifAuditTransfer = ifAuditTransfer;
	}
  
	public String getAuditTransferType() {
		return this.auditTransferType;
	}
	
	public void setAuditTransferType(String auditTransferType) {
		this.auditTransferType = auditTransferType;
	}
  
	public String getIfNPPublic() {
		return this.ifNPPublic;
	}
	
	public void setIfNPPublic(String ifNPPublic) {
		this.ifNPPublic = ifNPPublic;
	}
  
	public String getIfEnterGovHall() {
		return this.ifEnterGovHall;
	}
	
	public void setIfEnterGovHall(String ifEnterGovHall) {
		this.ifEnterGovHall = ifEnterGovHall;
	}



	public void copy(DeptQlInf other){
  
		this.setIddeptQlInf(other.getIddeptQlInf());
  
		this.updateType= other.getUpdateType();  
		this.deptQlParentId= other.getDeptQlParentId();  
		this.qlKind= other.getQlKind();  
		this.qlRegNo= other.getQlRegNo();  
		this.deptQlRegNo= other.getDeptQlRegNo();  
		this.qlName= other.getQlName();  
		this.qlShortName= other.getQlShortName();  
		this.deptId= other.getDeptId();  
		this.qlDepstate= other.getQlDepstate();  
		this.entrustName= other.getEntrustName();  
		this.deptAreano= other.getDeptAreano();  
		this.deptOrganization= other.getDeptOrganization();  
		this.qlByLaw= other.getQlByLaw();  
		this.useLevel= other.getUseLevel();  
		this.useLevelC= other.getUseLevelC();  
		this.remaer= other.getRemaer();  
		this.qlState= other.getQlState();  
		this.startTime= other.getStartTime();  
		this.endTime= other.getEndTime();  
		this.endReason= other.getEndReason();  
		this.endReasonRemark= other.getEndReasonRemark();  
		this.qlVersion= other.getQlVersion();  
		this.createDate= other.getCreateDate();  
		this.syncSign= other.getSyncSign();  
		this.syncDate= other.getSyncDate();  
		this.syncErrorDesc= other.getSyncErrorDesc();  
		this.updateDate= other.getUpdateDate();  
		this.idnewQlInf= other.getIdnewQlInf();  
		this.qlSubCount= other.getQlSubCount();  
		this.updateSign= other.getUpdateSign();  
		this.updateErrorDesc= other.getUpdateErrorDesc();  
		this.ifAuditTransfer= other.getIfAuditTransfer();  
		this.auditTransferType= other.getAuditTransferType();  
		this.ifNPPublic= other.getIfNPPublic();  
		this.ifEnterGovHall= other.getIfEnterGovHall();

	}
	
	public void copyNotNullProperty(DeptQlInf other){
  
	if( other.getIddeptQlInf() != null)
		this.setIddeptQlInf(other.getIddeptQlInf());
  
		if( other.getUpdateType() != null)
			this.updateType= other.getUpdateType();  
		if( other.getDeptQlParentId() != null)
			this.deptQlParentId= other.getDeptQlParentId();  
		if( other.getQlKind() != null)
			this.qlKind= other.getQlKind();  
		if( other.getQlRegNo() != null)
			this.qlRegNo= other.getQlRegNo();  
		if( other.getDeptQlRegNo() != null)
			this.deptQlRegNo= other.getDeptQlRegNo();  
		if( other.getQlName() != null)
			this.qlName= other.getQlName();  
		if( other.getQlShortName() != null)
			this.qlShortName= other.getQlShortName();  
		if( other.getDeptId() != null)
			this.deptId= other.getDeptId();  
		if( other.getQlDepstate() != null)
			this.qlDepstate= other.getQlDepstate();  
		if( other.getEntrustName() != null)
			this.entrustName= other.getEntrustName();  
		if( other.getDeptAreano() != null)
			this.deptAreano= other.getDeptAreano();  
		if( other.getDeptOrganization() != null)
			this.deptOrganization= other.getDeptOrganization();  
		if( other.getQlByLaw() != null)
			this.qlByLaw= other.getQlByLaw();  
		if( other.getUseLevel() != null)
			this.useLevel= other.getUseLevel();  
		if( other.getUseLevelC() != null)
			this.useLevelC= other.getUseLevelC();  
		if( other.getRemaer() != null)
			this.remaer= other.getRemaer();  
		if( other.getQlState() != null)
			this.qlState= other.getQlState();  
		if( other.getStartTime() != null)
			this.startTime= other.getStartTime();  
		if( other.getEndTime() != null)
			this.endTime= other.getEndTime();  
		if( other.getEndReason() != null)
			this.endReason= other.getEndReason();  
		if( other.getEndReasonRemark() != null)
			this.endReasonRemark= other.getEndReasonRemark();  
		if( other.getQlVersion() != null)
			this.qlVersion= other.getQlVersion();  
		if( other.getCreateDate() != null)
			this.createDate= other.getCreateDate();  
		if( other.getSyncSign() != null)
			this.syncSign= other.getSyncSign();  
		if( other.getSyncDate() != null)
			this.syncDate= other.getSyncDate();  
		if( other.getSyncErrorDesc() != null)
			this.syncErrorDesc= other.getSyncErrorDesc();  
		if( other.getUpdateDate() != null)
			this.updateDate= other.getUpdateDate();  
		if( other.getIdnewQlInf() != null)
			this.idnewQlInf= other.getIdnewQlInf();  
		if( other.getQlSubCount() != null)
			this.qlSubCount= other.getQlSubCount();  
		if( other.getUpdateSign() != null)
			this.updateSign= other.getUpdateSign();  
		if( other.getUpdateErrorDesc() != null)
			this.updateErrorDesc= other.getUpdateErrorDesc();  
		if( other.getIfAuditTransfer() != null)
			this.ifAuditTransfer= other.getIfAuditTransfer();  
		if( other.getAuditTransferType() != null)
			this.auditTransferType= other.getAuditTransferType();  
		if( other.getIfNPPublic() != null)
			this.ifNPPublic= other.getIfNPPublic();  
		if( other.getIfEnterGovHall() != null)
			this.ifEnterGovHall= other.getIfEnterGovHall();

	}
	
	public void clearProperties(){
  
		this.updateType= null;  
		this.deptQlParentId= null;  
		this.qlKind= null;  
		this.qlRegNo= null;  
		this.deptQlRegNo= null;  
		this.qlName= null;  
		this.qlShortName= null;  
		this.deptId= null;  
		this.qlDepstate= null;  
		this.entrustName= null;  
		this.deptAreano= null;  
		this.deptOrganization= null;  
		this.qlByLaw= null;  
		this.useLevel= null;  
		this.useLevelC= null;  
		this.remaer= null;  
		this.qlState= null;  
		this.startTime= null;  
		this.endTime= null;  
		this.endReason= null;  
		this.endReasonRemark= null;  
		this.qlVersion= null;  
		this.createDate= null;  
		this.syncSign= null;  
		this.syncDate= null;  
		this.syncErrorDesc= null;  
		this.updateDate= null;  
		this.idnewQlInf= null;  
		this.qlSubCount= null;  
		this.updateSign= null;  
		this.updateErrorDesc= null;  
		this.ifAuditTransfer= null;  
		this.auditTransferType= null;  
		this.ifNPPublic= null;  
		this.ifEnterGovHall= null;

	}
}
