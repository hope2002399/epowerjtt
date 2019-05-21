package com.centit.powerruntime.po;

import java.util.Date;
import java.util.List;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class VDeptYwBmdy implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String iddeptYwInf;

	private String  expressContent;
	private String  expressSendType;
	private String  expressFeeObject;
	private String  expressFee;
	private String  uniOrOwn;
	private String  needLogin;
	private String  updateType;
	private String  deptQlId;
	private String  deptYwNum;
	private String  deptYwRegNo;
	private String  ywName;
	private String  ywType;
	private String  useLevelC;
	private String  ifEntrust;
	private String  entrustName;
	private String  entrustFileUrl;
	private String  qlDept;
	private String  decisionDep;
	private String  otherTogetdept;
	private String  otherTogetoffice;
	private String  ywQlObject;
	private String  ywQlObjectRemark;
	private String  anticipateDay;
	private String  anticipateType;
	private String  promiseDay;
	private String  promiseType;
	private String  linkTel;
	private String  queryMethod;
	private String  superviseTel;
	private String  transactUrl;
	private String  transactAddr;
	private String  transactTime;
	private String  ywByLaw;
	private String  condition;
	private String  prohibitLaw;
	private String  limitNum;
	private String  limitNumC;
	private String  chargeFlag;
	private String  xzProcedure;
	private String  resultSendMode;
	private String  serviceDept;
	private String  serviceFileUrl;
	private String  actFileUrl;
	private String  resultFileUrl;
	private String  ywState;
	private Date  ywStartTime;
	private Date  ywEndTime;
	private String  ywEndReason;
	private String  endReasonRemark;
	private String  ywVersion;
	private Date  createDate;
	private String  syncSign;
	private Date  syncDate;
	private String  syncErrorDesc;
	private Date  updateDate;
	private String  updateSign;
	private String  updateErrorDesc;
	private String  ifExpress;
	private List<YwFile> ywFiles;
	private String daoXcNum;
	private String resultFileName;
	private String shrotOrgName;
	
	private String outitemid;
	private String outitemname;
	private String orgcode;
	private String orgname;
	private String qlKind;
	
	
	
	public String getOrgname() {
        return orgname;
    }
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
    public String getQlKind() {
        return qlKind;
    }
    public void setQlKind(String qlKind) {
        this.qlKind = qlKind;
    }
    // Constructors
	/** default constructor */
	public VDeptYwBmdy() {
	}
	/** minimal constructor */
	public VDeptYwBmdy(
		String iddeptYwInf		
		,String  updateType,String  syncSign,String  updateSign) {
	
	
		this.iddeptYwInf = iddeptYwInf;		
	
		this.updateType= updateType; 
		this.syncSign= syncSign; 
		this.updateSign= updateSign; 		
	}

/** full constructor */
	public VDeptYwBmdy(
	 String iddeptYwInf		
	,String  expressContent,String  expressSendType,String  expressFeeObject,String  expressFee,String  uniOrOwn,String  needLogin,String  updateType,String  deptQlId,String  deptYwNum,String  deptYwRegNo,String  ywName,String  ywType,String  useLevelC,String  ifEntrust,String  entrustName,String  entrustFileUrl,String  qlDept,String  decisionDep,String  otherTogetdept,String  otherTogetoffice,String  ywQlObject,String  ywQlObjectRemark,String  anticipateDay,String  anticipateType,String  promiseDay,String  promiseType,String  linkTel,String  queryMethod,String  superviseTel,String  transactUrl,String  transactAddr,String  transactTime,String  ywByLaw,String  condition,String  prohibitLaw,String  limitNum,String  limitNumC,String  chargeFlag,String  xzProcedure,String  resultSendMode,String  serviceDept,String  serviceFileUrl,String  actFileUrl,String  resultFileUrl,String  ywState,Date  ywStartTime,Date  ywEndTime,String  ywEndReason,String  endReasonRemark,String  ywVersion,Date  createDate,String  syncSign,Date  syncDate,String  syncErrorDesc,Date  updateDate,String  updateSign,String  updateErrorDesc,String  ifExpress) {
	
	
		this.iddeptYwInf = iddeptYwInf;		
	
		this.expressContent= expressContent;
		this.expressSendType= expressSendType;
		this.expressFeeObject= expressFeeObject;
		this.expressFee= expressFee;
		this.uniOrOwn= uniOrOwn;
		this.needLogin= needLogin;
		this.updateType= updateType;
		this.deptQlId= deptQlId;
		this.deptYwNum= deptYwNum;
		this.deptYwRegNo= deptYwRegNo;
		this.ywName= ywName;
		this.ywType= ywType;
		this.useLevelC= useLevelC;
		this.ifEntrust= ifEntrust;
		this.entrustName= entrustName;
		this.entrustFileUrl= entrustFileUrl;
		this.qlDept= qlDept;
		this.decisionDep= decisionDep;
		this.otherTogetdept= otherTogetdept;
		this.otherTogetoffice= otherTogetoffice;
		this.ywQlObject= ywQlObject;
		this.ywQlObjectRemark= ywQlObjectRemark;
		this.anticipateDay= anticipateDay;
		this.anticipateType= anticipateType;
		this.promiseDay= promiseDay;
		this.promiseType= promiseType;
		this.linkTel= linkTel;
		this.queryMethod= queryMethod;
		this.superviseTel= superviseTel;
		this.transactUrl= transactUrl;
		this.transactAddr= transactAddr;
		this.transactTime= transactTime;
		this.ywByLaw= ywByLaw;
		this.condition= condition;
		this.prohibitLaw= prohibitLaw;
		this.limitNum= limitNum;
		this.limitNumC= limitNumC;
		this.chargeFlag= chargeFlag;
		this.xzProcedure= xzProcedure;
		this.resultSendMode= resultSendMode;
		this.serviceDept= serviceDept;
		this.serviceFileUrl= serviceFileUrl;
		this.actFileUrl= actFileUrl;
		this.resultFileUrl= resultFileUrl;
		this.ywState= ywState;
		this.ywStartTime= ywStartTime;
		this.ywEndTime= ywEndTime;
		this.ywEndReason= ywEndReason;
		this.endReasonRemark= endReasonRemark;
		this.ywVersion= ywVersion;
		this.createDate= createDate;
		this.syncSign= syncSign;
		this.syncDate= syncDate;
		this.syncErrorDesc= syncErrorDesc;
		this.updateDate= updateDate;
		this.updateSign= updateSign;
		this.updateErrorDesc= updateErrorDesc;
		this.ifExpress= ifExpress;		
	}
	

  

    public String getOutitemid() {
    return outitemid;
}
public void setOutitemid(String outitemid) {
    this.outitemid = outitemid;
}
public String getOutitemname() {
    return outitemname;
}
public void setOutitemname(String outitemname) {
    this.outitemname = outitemname;
}
public String getOrgcode() {
    return orgcode;
}
public void setOrgcode(String orgcode) {
    this.orgcode = orgcode;
}
    public String getShrotOrgName() {
    return shrotOrgName;
}
public void setShrotOrgName(String shrotOrgName) {
    this.shrotOrgName = shrotOrgName;
}
    public String getResultFileName() {
    return resultFileName;
}
public void setResultFileName(String resultFileName) {
    this.resultFileName = resultFileName;
}
    public String getDaoXcNum() {
    return daoXcNum;
}
public void setDaoXcNum(String daoXcNum) {
    this.daoXcNum = daoXcNum;
}
    public List<YwFile> getYwFiles() {
	    return ywFiles;
    }
    public void setYwFiles(List<YwFile> ywFiles) {
        this.ywFiles = ywFiles;
    }
    public String getIddeptYwInf() {
		return this.iddeptYwInf;
	}

	public void setIddeptYwInf(String iddeptYwInf) {
		this.iddeptYwInf = iddeptYwInf;
	}
	// Property accessors
  
	public String getExpressContent() {
		return this.expressContent;
	}
	
	public void setExpressContent(String expressContent) {
		this.expressContent = expressContent;
	}
  
	public String getExpressSendType() {
		return this.expressSendType;
	}
	
	public void setExpressSendType(String expressSendType) {
		this.expressSendType = expressSendType;
	}
  
	public String getExpressFeeObject() {
		return this.expressFeeObject;
	}
	
	public void setExpressFeeObject(String expressFeeObject) {
		this.expressFeeObject = expressFeeObject;
	}
  
	public String getExpressFee() {
		return this.expressFee;
	}
	
	public void setExpressFee(String expressFee) {
		this.expressFee = expressFee;
	}
  
	public String getUniOrOwn() {
		return this.uniOrOwn;
	}
	
	public void setUniOrOwn(String uniOrOwn) {
		this.uniOrOwn = uniOrOwn;
	}
  
	public String getNeedLogin() {
		return this.needLogin;
	}
	
	public void setNeedLogin(String needLogin) {
		this.needLogin = needLogin;
	}
  
	public String getUpdateType() {
		return this.updateType;
	}
	
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
  
	public String getDeptQlId() {
		return this.deptQlId;
	}
	
	public void setDeptQlId(String deptQlId) {
		this.deptQlId = deptQlId;
	}
  
	public String getDeptYwNum() {
		return this.deptYwNum;
	}
	
	public void setDeptYwNum(String deptYwNum) {
		this.deptYwNum = deptYwNum;
	}
  
	public String getDeptYwRegNo() {
		return this.deptYwRegNo;
	}
	
	public void setDeptYwRegNo(String deptYwRegNo) {
		this.deptYwRegNo = deptYwRegNo;
	}
  
	public String getYwName() {
		return this.ywName;
	}
	
	public void setYwName(String ywName) {
		this.ywName = ywName;
	}
  
	public String getYwType() {
		return this.ywType;
	}
	
	public void setYwType(String ywType) {
		this.ywType = ywType;
	}
  
	public String getUseLevelC() {
		return this.useLevelC;
	}
	
	public void setUseLevelC(String useLevelC) {
		this.useLevelC = useLevelC;
	}
  
	public String getIfEntrust() {
		return this.ifEntrust;
	}
	
	public void setIfEntrust(String ifEntrust) {
		this.ifEntrust = ifEntrust;
	}
  
	public String getEntrustName() {
		return this.entrustName;
	}
	
	public void setEntrustName(String entrustName) {
		this.entrustName = entrustName;
	}
  
	public String getEntrustFileUrl() {
		return this.entrustFileUrl;
	}
	
	public void setEntrustFileUrl(String entrustFileUrl) {
		this.entrustFileUrl = entrustFileUrl;
	}
  
	public String getQlDept() {
		return this.qlDept;
	}
	
	public void setQlDept(String qlDept) {
		this.qlDept = qlDept;
	}
  
	public String getDecisionDep() {
		return this.decisionDep;
	}
	
	public void setDecisionDep(String decisionDep) {
		this.decisionDep = decisionDep;
	}
  
	public String getOtherTogetdept() {
		return this.otherTogetdept;
	}
	
	public void setOtherTogetdept(String otherTogetdept) {
		this.otherTogetdept = otherTogetdept;
	}
  
	public String getOtherTogetoffice() {
		return this.otherTogetoffice;
	}
	
	public void setOtherTogetoffice(String otherTogetoffice) {
		this.otherTogetoffice = otherTogetoffice;
	}
  
	public String getYwQlObject() {
		return this.ywQlObject;
	}
	
	public void setYwQlObject(String ywQlObject) {
		this.ywQlObject = ywQlObject;
	}
  
	public String getYwQlObjectRemark() {
		return this.ywQlObjectRemark;
	}
	
	public void setYwQlObjectRemark(String ywQlObjectRemark) {
		this.ywQlObjectRemark = ywQlObjectRemark;
	}
  
	public String getAnticipateDay() {
		return this.anticipateDay;
	}
	
	public void setAnticipateDay(String anticipateDay) {
		this.anticipateDay = anticipateDay;
	}
  
	public String getAnticipateType() {
		return this.anticipateType;
	}
	
	public void setAnticipateType(String anticipateType) {
		this.anticipateType = anticipateType;
	}
  
	public String getPromiseDay() {
		return this.promiseDay;
	}
	
	public void setPromiseDay(String promiseDay) {
		this.promiseDay = promiseDay;
	}
  
	public String getPromiseType() {
		return this.promiseType;
	}
	
	public void setPromiseType(String promiseType) {
		this.promiseType = promiseType;
	}
  
	public String getLinkTel() {
		return this.linkTel;
	}
	
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
  
	public String getQueryMethod() {
		return this.queryMethod;
	}
	
	public void setQueryMethod(String queryMethod) {
		this.queryMethod = queryMethod;
	}
  
	public String getSuperviseTel() {
		return this.superviseTel;
	}
	
	public void setSuperviseTel(String superviseTel) {
		this.superviseTel = superviseTel;
	}
  
	public String getTransactUrl() {
		return this.transactUrl;
	}
	
	public void setTransactUrl(String transactUrl) {
		this.transactUrl = transactUrl;
	}
  
	public String getTransactAddr() {
		return this.transactAddr;
	}
	
	public void setTransactAddr(String transactAddr) {
		this.transactAddr = transactAddr;
	}
  
	public String getTransactTime() {
		return this.transactTime;
	}
	
	public void setTransactTime(String transactTime) {
		this.transactTime = transactTime;
	}
  
	public String getYwByLaw() {
		return this.ywByLaw;
	}
	
	public void setYwByLaw(String ywByLaw) {
		this.ywByLaw = ywByLaw;
	}
  
	public String getCondition() {
		return this.condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
  
	public String getProhibitLaw() {
		return this.prohibitLaw;
	}
	
	public void setProhibitLaw(String prohibitLaw) {
		this.prohibitLaw = prohibitLaw;
	}
  
	public String getLimitNum() {
		return this.limitNum;
	}
	
	public void setLimitNum(String limitNum) {
		this.limitNum = limitNum;
	}
  
	public String getLimitNumC() {
		return this.limitNumC;
	}
	
	public void setLimitNumC(String limitNumC) {
		this.limitNumC = limitNumC;
	}
  
	public String getChargeFlag() {
		return this.chargeFlag;
	}
	
	public void setChargeFlag(String chargeFlag) {
		this.chargeFlag = chargeFlag;
	}
  
	public String getXzProcedure() {
		return this.xzProcedure;
	}
	
	public void setXzProcedure(String xzProcedure) {
		this.xzProcedure = xzProcedure;
	}
  
	public String getResultSendMode() {
		return this.resultSendMode;
	}
	
	public void setResultSendMode(String resultSendMode) {
		this.resultSendMode = resultSendMode;
	}
  
	public String getServiceDept() {
		return this.serviceDept;
	}
	
	public void setServiceDept(String serviceDept) {
		this.serviceDept = serviceDept;
	}
  
	public String getServiceFileUrl() {
		return this.serviceFileUrl;
	}
	
	public void setServiceFileUrl(String serviceFileUrl) {
		this.serviceFileUrl = serviceFileUrl;
	}
  
	public String getActFileUrl() {
		return this.actFileUrl;
	}
	
	public void setActFileUrl(String actFileUrl) {
		this.actFileUrl = actFileUrl;
	}
  
	public String getResultFileUrl() {
		return this.resultFileUrl;
	}
	
	public void setResultFileUrl(String resultFileUrl) {
		this.resultFileUrl = resultFileUrl;
	}
  
	public String getYwState() {
		return this.ywState;
	}
	
	public void setYwState(String ywState) {
		this.ywState = ywState;
	}
  
	public Date getYwStartTime() {
		return this.ywStartTime;
	}
	
	public void setYwStartTime(Date ywStartTime) {
		this.ywStartTime = ywStartTime;
	}
  
	public Date getYwEndTime() {
		return this.ywEndTime;
	}
	
	public void setYwEndTime(Date ywEndTime) {
		this.ywEndTime = ywEndTime;
	}
  
	public String getYwEndReason() {
		return this.ywEndReason;
	}
	
	public void setYwEndReason(String ywEndReason) {
		this.ywEndReason = ywEndReason;
	}
  
	public String getEndReasonRemark() {
		return this.endReasonRemark;
	}
	
	public void setEndReasonRemark(String endReasonRemark) {
		this.endReasonRemark = endReasonRemark;
	}
  
	public String getYwVersion() {
		return this.ywVersion;
	}
	
	public void setYwVersion(String ywVersion) {
		this.ywVersion = ywVersion;
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
  
	public String getIfExpress() {
		return this.ifExpress;
	}
	
	public void setIfExpress(String ifExpress) {
		this.ifExpress = ifExpress;
	}



	public void copy(VDeptYwBmdy other){
  
		this.setIddeptYwInf(other.getIddeptYwInf());
  
		this.expressContent= other.getExpressContent();  
		this.expressSendType= other.getExpressSendType();  
		this.expressFeeObject= other.getExpressFeeObject();  
		this.expressFee= other.getExpressFee();  
		this.uniOrOwn= other.getUniOrOwn();  
		this.needLogin= other.getNeedLogin();  
		this.updateType= other.getUpdateType();  
		this.deptQlId= other.getDeptQlId();  
		this.deptYwNum= other.getDeptYwNum();  
		this.deptYwRegNo= other.getDeptYwRegNo();  
		this.ywName= other.getYwName();  
		this.ywType= other.getYwType();  
		this.useLevelC= other.getUseLevelC();  
		this.ifEntrust= other.getIfEntrust();  
		this.entrustName= other.getEntrustName();  
		this.entrustFileUrl= other.getEntrustFileUrl();  
		this.qlDept= other.getQlDept();  
		this.decisionDep= other.getDecisionDep();  
		this.otherTogetdept= other.getOtherTogetdept();  
		this.otherTogetoffice= other.getOtherTogetoffice();  
		this.ywQlObject= other.getYwQlObject();  
		this.ywQlObjectRemark= other.getYwQlObjectRemark();  
		this.anticipateDay= other.getAnticipateDay();  
		this.anticipateType= other.getAnticipateType();  
		this.promiseDay= other.getPromiseDay();  
		this.promiseType= other.getPromiseType();  
		this.linkTel= other.getLinkTel();  
		this.queryMethod= other.getQueryMethod();  
		this.superviseTel= other.getSuperviseTel();  
		this.transactUrl= other.getTransactUrl();  
		this.transactAddr= other.getTransactAddr();  
		this.transactTime= other.getTransactTime();  
		this.ywByLaw= other.getYwByLaw();  
		this.condition= other.getCondition();  
		this.prohibitLaw= other.getProhibitLaw();  
		this.limitNum= other.getLimitNum();  
		this.limitNumC= other.getLimitNumC();  
		this.chargeFlag= other.getChargeFlag();  
		this.xzProcedure= other.getXzProcedure();  
		this.resultSendMode= other.getResultSendMode();  
		this.serviceDept= other.getServiceDept();  
		this.serviceFileUrl= other.getServiceFileUrl();  
		this.actFileUrl= other.getActFileUrl();  
		this.resultFileUrl= other.getResultFileUrl();  
		this.ywState= other.getYwState();  
		this.ywStartTime= other.getYwStartTime();  
		this.ywEndTime= other.getYwEndTime();  
		this.ywEndReason= other.getYwEndReason();  
		this.endReasonRemark= other.getEndReasonRemark();  
		this.ywVersion= other.getYwVersion();  
		this.createDate= other.getCreateDate();  
		this.syncSign= other.getSyncSign();  
		this.syncDate= other.getSyncDate();  
		this.syncErrorDesc= other.getSyncErrorDesc();  
		this.updateDate= other.getUpdateDate();  
		this.updateSign= other.getUpdateSign();  
		this.updateErrorDesc= other.getUpdateErrorDesc();  
		this.ifExpress= other.getIfExpress();

	}
	
	public void copyNotNullProperty(VDeptYwBmdy other){
  
	if( other.getIddeptYwInf() != null)
		this.setIddeptYwInf(other.getIddeptYwInf());
  
		if( other.getExpressContent() != null)
			this.expressContent= other.getExpressContent();  
		if( other.getExpressSendType() != null)
			this.expressSendType= other.getExpressSendType();  
		if( other.getExpressFeeObject() != null)
			this.expressFeeObject= other.getExpressFeeObject();  
		if( other.getExpressFee() != null)
			this.expressFee= other.getExpressFee();  
		if( other.getUniOrOwn() != null)
			this.uniOrOwn= other.getUniOrOwn();  
		if( other.getNeedLogin() != null)
			this.needLogin= other.getNeedLogin();  
		if( other.getUpdateType() != null)
			this.updateType= other.getUpdateType();  
		if( other.getDeptQlId() != null)
			this.deptQlId= other.getDeptQlId();  
		if( other.getDeptYwNum() != null)
			this.deptYwNum= other.getDeptYwNum();  
		if( other.getDeptYwRegNo() != null)
			this.deptYwRegNo= other.getDeptYwRegNo();  
		if( other.getYwName() != null)
			this.ywName= other.getYwName();  
		if( other.getYwType() != null)
			this.ywType= other.getYwType();  
		if( other.getUseLevelC() != null)
			this.useLevelC= other.getUseLevelC();  
		if( other.getIfEntrust() != null)
			this.ifEntrust= other.getIfEntrust();  
		if( other.getEntrustName() != null)
			this.entrustName= other.getEntrustName();  
		if( other.getEntrustFileUrl() != null)
			this.entrustFileUrl= other.getEntrustFileUrl();  
		if( other.getQlDept() != null)
			this.qlDept= other.getQlDept();  
		if( other.getDecisionDep() != null)
			this.decisionDep= other.getDecisionDep();  
		if( other.getOtherTogetdept() != null)
			this.otherTogetdept= other.getOtherTogetdept();  
		if( other.getOtherTogetoffice() != null)
			this.otherTogetoffice= other.getOtherTogetoffice();  
		if( other.getYwQlObject() != null)
			this.ywQlObject= other.getYwQlObject();  
		if( other.getYwQlObjectRemark() != null)
			this.ywQlObjectRemark= other.getYwQlObjectRemark();  
		if( other.getAnticipateDay() != null)
			this.anticipateDay= other.getAnticipateDay();  
		if( other.getAnticipateType() != null)
			this.anticipateType= other.getAnticipateType();  
		if( other.getPromiseDay() != null)
			this.promiseDay= other.getPromiseDay();  
		if( other.getPromiseType() != null)
			this.promiseType= other.getPromiseType();  
		if( other.getLinkTel() != null)
			this.linkTel= other.getLinkTel();  
		if( other.getQueryMethod() != null)
			this.queryMethod= other.getQueryMethod();  
		if( other.getSuperviseTel() != null)
			this.superviseTel= other.getSuperviseTel();  
		if( other.getTransactUrl() != null)
			this.transactUrl= other.getTransactUrl();  
		if( other.getTransactAddr() != null)
			this.transactAddr= other.getTransactAddr();  
		if( other.getTransactTime() != null)
			this.transactTime= other.getTransactTime();  
		if( other.getYwByLaw() != null)
			this.ywByLaw= other.getYwByLaw();  
		if( other.getCondition() != null)
			this.condition= other.getCondition();  
		if( other.getProhibitLaw() != null)
			this.prohibitLaw= other.getProhibitLaw();  
		if( other.getLimitNum() != null)
			this.limitNum= other.getLimitNum();  
		if( other.getLimitNumC() != null)
			this.limitNumC= other.getLimitNumC();  
		if( other.getChargeFlag() != null)
			this.chargeFlag= other.getChargeFlag();  
		if( other.getXzProcedure() != null)
			this.xzProcedure= other.getXzProcedure();  
		if( other.getResultSendMode() != null)
			this.resultSendMode= other.getResultSendMode();  
		if( other.getServiceDept() != null)
			this.serviceDept= other.getServiceDept();  
		if( other.getServiceFileUrl() != null)
			this.serviceFileUrl= other.getServiceFileUrl();  
		if( other.getActFileUrl() != null)
			this.actFileUrl= other.getActFileUrl();  
		if( other.getResultFileUrl() != null)
			this.resultFileUrl= other.getResultFileUrl();  
		if( other.getYwState() != null)
			this.ywState= other.getYwState();  
		if( other.getYwStartTime() != null)
			this.ywStartTime= other.getYwStartTime();  
		if( other.getYwEndTime() != null)
			this.ywEndTime= other.getYwEndTime();  
		if( other.getYwEndReason() != null)
			this.ywEndReason= other.getYwEndReason();  
		if( other.getEndReasonRemark() != null)
			this.endReasonRemark= other.getEndReasonRemark();  
		if( other.getYwVersion() != null)
			this.ywVersion= other.getYwVersion();  
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
		if( other.getUpdateSign() != null)
			this.updateSign= other.getUpdateSign();  
		if( other.getUpdateErrorDesc() != null)
			this.updateErrorDesc= other.getUpdateErrorDesc();  
		if( other.getIfExpress() != null)
			this.ifExpress= other.getIfExpress();

	}
	
	public void clearProperties(){
  
		this.expressContent= null;  
		this.expressSendType= null;  
		this.expressFeeObject= null;  
		this.expressFee= null;  
		this.uniOrOwn= null;  
		this.needLogin= null;  
		this.updateType= null;  
		this.deptQlId= null;  
		this.deptYwNum= null;  
		this.deptYwRegNo= null;  
		this.ywName= null;  
		this.ywType= null;  
		this.useLevelC= null;  
		this.ifEntrust= null;  
		this.entrustName= null;  
		this.entrustFileUrl= null;  
		this.qlDept= null;  
		this.decisionDep= null;  
		this.otherTogetdept= null;  
		this.otherTogetoffice= null;  
		this.ywQlObject= null;  
		this.ywQlObjectRemark= null;  
		this.anticipateDay= null;  
		this.anticipateType= null;  
		this.promiseDay= null;  
		this.promiseType= null;  
		this.linkTel= null;  
		this.queryMethod= null;  
		this.superviseTel= null;  
		this.transactUrl= null;  
		this.transactAddr= null;  
		this.transactTime= null;  
		this.ywByLaw= null;  
		this.condition= null;  
		this.prohibitLaw= null;  
		this.limitNum= null;  
		this.limitNumC= null;  
		this.chargeFlag= null;  
		this.xzProcedure= null;  
		this.resultSendMode= null;  
		this.serviceDept= null;  
		this.serviceFileUrl= null;  
		this.actFileUrl= null;  
		this.resultFileUrl= null;  
		this.ywState= null;  
		this.ywStartTime= null;  
		this.ywEndTime= null;  
		this.ywEndReason= null;  
		this.endReasonRemark= null;  
		this.ywVersion= null;  
		this.createDate= null;  
		this.syncSign= null;  
		this.syncDate= null;  
		this.syncErrorDesc= null;  
		this.updateDate= null;  
		this.updateSign= null;  
		this.updateErrorDesc= null;  
		this.ifExpress= null;

	}
}
