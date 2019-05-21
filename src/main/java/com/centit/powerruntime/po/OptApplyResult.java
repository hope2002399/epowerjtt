package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class OptApplyResult implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String internalNo;

	private Date  applyDate;
	private String  orgId;
	private String  no;
	private String  itemId;
	private String  status;
	private String  note;
	private Date  finishTime;
	private String  receivable;
	private String  paid;
	private String  reliefReasons;
	private String  department;
	private String  transactAffairName;
	private String  content;
	private String  applyWay;
	private String  applicantCode;
	private String  applicantType;
	private String  applicantName;
	private String  applicantPaperType;
	private String  applicantPaperCode;
	private String  applicantPhone;
	private String  applicantMobile;
	private String  applicantAddress;
	private String  applicantZipcode;
	private String  applicantEmail;
	private String  linkman;
	private String  linkmanName;
	private String  linkmanPaperType;
	private String  linkmanPaperCode;
	private String  linkmanPhone;
	private String  linkmanMobile;
	private String  linkmanAddress;
	private String  linkmanZipcode;
	private String  linkmanEmail;
	private String sendway;

	// Constructors
	/** default constructor */
	public OptApplyResult() {
	}
	/** minimal constructor */
	public OptApplyResult(
		String internalNo		
		) {
	
	
		this.internalNo = internalNo;		
			
	}

/** full constructor */
	public OptApplyResult(
	 String internalNo		
	,Date  applyDate,String  orgId,String  no,String  itemId,String  status,String  note,Date  finishTime,String  receivable,String  paid,String  reliefReasons,String  department,String  transactAffairName,String  content,String  applyWay,String  applicantCode,String  applicantType,String  applicantName,String  applicantPaperType,String  applicantPaperCode,String  applicantPhone,String  applicantMobile,String  applicantAddress,String  applicantZipcode,String  applicantEmail,String  linkman,String  linkmanName,String  linkmanPaperType,String  linkmanPaperCode,String  linkmanPhone,String  linkmanMobile,String  linkmanAddress,String  linkmanZipcode,String  linkmanEmail,String sendway) {
	
	
		this.internalNo = internalNo;		
	
		this.applyDate= applyDate;
		this.orgId= orgId;
		this.no= no;
		this.itemId= itemId;
		this.status= status;
		this.note= note;
		this.finishTime= finishTime;
		this.receivable= receivable;
		this.paid= paid;
		this.reliefReasons= reliefReasons;
		this.department= department;
		this.transactAffairName= transactAffairName;
		this.content= content;
		this.applyWay= applyWay;
		this.applicantCode= applicantCode;
		this.applicantType= applicantType;
		this.applicantName= applicantName;
		this.applicantPaperType= applicantPaperType;
		this.applicantPaperCode= applicantPaperCode;
		this.applicantPhone= applicantPhone;
		this.applicantMobile= applicantMobile;
		this.applicantAddress= applicantAddress;
		this.applicantZipcode= applicantZipcode;
		this.applicantEmail= applicantEmail;
		this.linkman= linkman;
		this.linkmanName= linkmanName;
		this.linkmanPaperType= linkmanPaperType;
		this.linkmanPaperCode= linkmanPaperCode;
		this.linkmanPhone= linkmanPhone;
		this.linkmanMobile= linkmanMobile;
		this.linkmanAddress= linkmanAddress;
		this.linkmanZipcode= linkmanZipcode;
		this.linkmanEmail= linkmanEmail;	
		this.sendway=sendway;
	}
	

  
	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	// Property accessors
  
	public Date getApplyDate() {
        if (this.applyDate == null) {
            this.applyDate = new Date(System.currentTimeMillis());
        }
        return this.applyDate;
    }
	
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
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
  
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
  
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
  
	public Date getFinishTime() {
        if (this.finishTime == null) {
            this.finishTime = new Date(System.currentTimeMillis());
        }
        return this.finishTime;
    }
	
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
  
	public String getReceivable() {
		return this.receivable;
	}
	
	public void setReceivable(String receivable) {
		this.receivable = receivable;
	}
  
	public String getPaid() {
		return this.paid;
	}
	
	public void setPaid(String paid) {
		this.paid = paid;
	}
  
	public String getReliefReasons() {
		return this.reliefReasons;
	}
	
	public void setReliefReasons(String reliefReasons) {
		this.reliefReasons = reliefReasons;
	}
  
	public String getDepartment() {
		return this.department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
  
	public String getTransactAffairName() {
		return this.transactAffairName;
	}
	
	public void setTransactAffairName(String transactAffairName) {
		this.transactAffairName = transactAffairName;
	}
  
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
  
	public String getApplyWay() {
		return this.applyWay;
	}
	
	public void setApplyWay(String applyWay) {
		this.applyWay = applyWay;
	}
  
	public String getApplicantCode() {
		return this.applicantCode;
	}
	
	public void setApplicantCode(String applicantCode) {
		this.applicantCode = applicantCode;
	}
  
	public String getApplicantType() {
		return this.applicantType;
	}
	
	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}
  
	public String getApplicantName() {
		return this.applicantName;
	}
	
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
  
	public String getApplicantPaperType() {
		return this.applicantPaperType;
	}
	
	public void setApplicantPaperType(String applicantPaperType) {
		this.applicantPaperType = applicantPaperType;
	}
  
	public String getApplicantPaperCode() {
		return this.applicantPaperCode;
	}
	
	public void setApplicantPaperCode(String applicantPaperCode) {
		this.applicantPaperCode = applicantPaperCode;
	}
  
	public String getApplicantPhone() {
		return this.applicantPhone;
	}
	
	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}
  
	public String getApplicantMobile() {
		return this.applicantMobile;
	}
	
	public void setApplicantMobile(String applicantMobile) {
		this.applicantMobile = applicantMobile;
	}
  
	public String getApplicantAddress() {
		return this.applicantAddress;
	}
	
	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}
  
	public String getApplicantZipcode() {
		return this.applicantZipcode;
	}
	
	public void setApplicantZipcode(String applicantZipcode) {
		this.applicantZipcode = applicantZipcode;
	}
  
	public String getApplicantEmail() {
		return this.applicantEmail;
	}
	
	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}
  
	public String getLinkman() {
		return this.linkman;
	}
	
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
  
	public String getLinkmanName() {
		return this.linkmanName;
	}
	
	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}
  
	public String getLinkmanPaperType() {
		return this.linkmanPaperType;
	}
	
	public void setLinkmanPaperType(String linkmanPaperType) {
		this.linkmanPaperType = linkmanPaperType;
	}
  
	public String getLinkmanPaperCode() {
		return this.linkmanPaperCode;
	}
	
	public void setLinkmanPaperCode(String linkmanPaperCode) {
		this.linkmanPaperCode = linkmanPaperCode;
	}
  
	
  
	public String getLinkmanPhone() {
        return linkmanPhone;
    }
    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }
    public String getLinkmanMobile() {
		return this.linkmanMobile;
	}
	
	public void setLinkmanMobile(String linkmanMobile) {
		this.linkmanMobile = linkmanMobile;
	}
  
	public String getLinkmanAddress() {
		return this.linkmanAddress;
	}
	
	public void setLinkmanAddress(String linkmanAddress) {
		this.linkmanAddress = linkmanAddress;
	}
  
	public String getLinkmanZipcode() {
		return this.linkmanZipcode;
	}
	
	public void setLinkmanZipcode(String linkmanZipcode) {
		this.linkmanZipcode = linkmanZipcode;
	}
  
	public String getLinkmanEmail() {
		return this.linkmanEmail;
	}
	
	public void setLinkmanEmail(String linkmanEmail) {
		this.linkmanEmail = linkmanEmail;
	}
	


	public String getSendway() {
        return sendway;
    }
    public void setSendway(String sendway) {
        this.sendway = sendway;
    }
    public void copy(OptApplyResult other){
  
		this.setInternalNo(other.getInternalNo());
  
		this.applyDate= other.getApplyDate();  
		this.orgId= other.getOrgId();  
		this.no= other.getNo();  
		this.itemId= other.getItemId();  
		this.status= other.getStatus();  
		this.note= other.getNote();  
		this.finishTime= other.getFinishTime();  
		this.receivable= other.getReceivable();  
		this.paid= other.getPaid();  
		this.reliefReasons= other.getReliefReasons();  
		this.department= other.getDepartment();  
		this.transactAffairName= other.getTransactAffairName();  
		this.content= other.getContent();  
		this.applyWay= other.getApplyWay();  
		this.applicantCode= other.getApplicantCode();  
		this.applicantType= other.getApplicantType();  
		this.applicantName= other.getApplicantName();  
		this.applicantPaperType= other.getApplicantPaperType();  
		this.applicantPaperCode= other.getApplicantPaperCode();  
		this.applicantPhone= other.getApplicantPhone();  
		this.applicantMobile= other.getApplicantMobile();  
		this.applicantAddress= other.getApplicantAddress();  
		this.applicantZipcode= other.getApplicantZipcode();   
		this.applicantEmail= other.getApplicantEmail();  
		this.linkman= other.getLinkman();  
		this.linkmanName= other.getLinkmanName();  
		this.linkmanPaperType= other.getLinkmanPaperType();  
		this.linkmanPaperCode= other.getLinkmanPaperCode();  
		this.linkmanPhone= other.getLinkmanPhone();  
		this.linkmanMobile= other.getLinkmanMobile();  
		this.linkmanAddress= other.getLinkmanAddress();  
		this.linkmanZipcode= other.getLinkmanZipcode();  
		this.linkmanEmail= other.getLinkmanEmail();
		this.sendway=other.getSendway();
	}
	
	public void copyNotNullProperty(OptApplyResult other){
  
	if( other.getInternalNo() != null)
	    this.setInternalNo(other.getInternalNo());
  
		if( other.getApplyDate() != null)
			this.applyDate= other.getApplyDate();  
		if( other.getOrgId() != null)
			this.orgId= other.getOrgId();  
		if( other.getNo() != null)
			this.no= other.getNo();  
		if( other.getItemId() != null)
			this.itemId= other.getItemId();  
		if( other.getStatus() != null)
			this.status= other.getStatus();  
		if( other.getNote() != null)
			this.note= other.getNote();  
		if( other.getFinishTime() != null)
			this.finishTime= other.getFinishTime();  
		if( other.getReceivable() != null)
			this.receivable= other.getReceivable();  
		if( other.getPaid() != null)
			this.paid= other.getPaid();  
		if( other.getReliefReasons() != null)
			this.reliefReasons= other.getReliefReasons();  
		if( other.getDepartment() != null)
			this.department= other.getDepartment();  
		if( other.getTransactAffairName() != null)
			this.transactAffairName= other.getTransactAffairName();  
		if( other.getContent() != null)
			this.content= other.getContent();  
		if( other.getApplyWay() != null)
			this.applyWay= other.getApplyWay();  
		if( other.getApplicantCode() != null)
			this.applicantCode= other.getApplicantCode();  
		if( other.getApplicantType() != null)
			this.applicantType= other.getApplicantType();  
		if( other.getApplicantName() != null)
			this.applicantName= other.getApplicantName();  
		if( other.getApplicantPaperType() != null)
			this.applicantPaperType= other.getApplicantPaperType();  
		if( other.getApplicantPaperCode() != null)
			this.applicantPaperCode= other.getApplicantPaperCode();  
		if( other.getApplicantPhone() != null)
			this.applicantPhone= other.getApplicantPhone();  
		if( other.getApplicantMobile() != null)
			this.applicantMobile= other.getApplicantMobile();  
		if( other.getApplicantAddress() != null)
			this.applicantAddress= other.getApplicantAddress();  
		if( other.getApplicantZipcode() != null)
			this.applicantZipcode= other.getApplicantZipcode();  
		if( other.getApplicantEmail() != null)
			this.applicantEmail= other.getApplicantEmail();  
		if( other.getLinkman() != null)
			this.linkman= other.getLinkman();  
		if( other.getLinkmanName() != null)
			this.linkmanName= other.getLinkmanName();  
		if( other.getLinkmanPaperType() != null)
			this.linkmanPaperType= other.getLinkmanPaperType();  
		if( other.getLinkmanPaperCode() != null)
			this.linkmanPaperCode= other.getLinkmanPaperCode();  
		if( other.getLinkmanPhone() != null)
			this.linkmanPhone= other.getLinkmanPhone();  
		if( other.getLinkmanMobile() != null)
			this.linkmanMobile= other.getLinkmanMobile();  
		if( other.getLinkmanAddress() != null)
			this.linkmanAddress= other.getLinkmanAddress();  
		if( other.getLinkmanZipcode() != null)
			this.linkmanZipcode= other.getLinkmanZipcode();  
		if( other.getLinkmanEmail() != null)
			this.linkmanEmail= other.getLinkmanEmail();
		if( other.getSendway() != null)
		    this.sendway=other.getSendway();
	}
	
	public void clearProperties(){
  
		this.applyDate= null;  
		this.orgId= null;  
		this.no= null;  
		this.itemId= null;  
		this.status= null;  
		this.note= null;  
		this.finishTime= null;  
		this.receivable= null;  
		this.paid= null;  
		this.reliefReasons= null;  
		this.department= null;  
		this.transactAffairName= null;  
		this.content= null;  
		this.applyWay= null;  
		this.applicantCode= null;  
		this.applicantType= null;  
		this.applicantName= null;  
		this.applicantPaperType= null;  
		this.applicantPaperCode= null;  
		this.applicantPhone= null;  
		this.applicantMobile= null;  
		this.applicantAddress= null;  
		this.applicantZipcode= null;  
		this.applicantEmail= null;  
		this.linkman= null;  
		this.linkmanName= null;  
		this.linkmanPaperType= null;  
		this.linkmanPaperCode= null;  
		this.linkmanPhone= null;  
		this.linkmanMobile= null;  
		this.linkmanAddress= null;  
		this.linkmanZipcode= null;  
		this.linkmanEmail= null;
		this.sendway=null;
	}
}
