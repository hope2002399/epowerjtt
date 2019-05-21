package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class AmOrg implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String idorg;

	private String  idparentorg;
	private String  orgname;
	private String  orgshortname;
	private String  idareaCode;
	private Long  ord;
	private String  updateType;
	private String  syncSign;
	private Date  syncDate;
	private String  syncErrorDesc;
	private String  updateSign;
	private Date  updateDate;
	private String  updateErrorDesc;
	private String  ifCg;

	// Constructors
	/** default constructor */
	public AmOrg() {
	}
	/** minimal constructor */
	public AmOrg(
		String idorg		
		,String  updateType,String  updateSign) {
	
	
		this.idorg = idorg;		
	
		this.updateType= updateType; 
		this.updateSign= updateSign; 		
	}

/** full constructor */
	public AmOrg(
	 String idorg		
	,String  idparentorg,String  orgname,String  orgshortname,String  idareaCode,Long  ord,String  updateType,String  syncSign,Date  syncDate,String  syncErrorDesc,String  updateSign,Date  updateDate,String  updateErrorDesc,String  ifCg) {
	
	
		this.idorg = idorg;		
	
		this.idparentorg= idparentorg;
		this.orgname= orgname;
		this.orgshortname= orgshortname;
		this.idareaCode= idareaCode;
		this.ord= ord;
		this.updateType= updateType;
		this.syncSign= syncSign;
		this.syncDate= syncDate;
		this.syncErrorDesc= syncErrorDesc;
		this.updateSign= updateSign;
		this.updateDate= updateDate;
		this.updateErrorDesc= updateErrorDesc;
		this.ifCg= ifCg;		
	}
	

  
	public String getIdorg() {
		return this.idorg;
	}

	public void setIdorg(String idorg) {
		this.idorg = idorg;
	}
	// Property accessors
  
	public String getIdparentorg() {
		return this.idparentorg;
	}
	
	public void setIdparentorg(String idparentorg) {
		this.idparentorg = idparentorg;
	}
  
	public String getOrgname() {
		return this.orgname;
	}
	
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
  
	public String getOrgshortname() {
		return this.orgshortname;
	}
	
	public void setOrgshortname(String orgshortname) {
		this.orgshortname = orgshortname;
	}
  
	public String getIdareaCode() {
		return this.idareaCode;
	}
	
	public void setIdareaCode(String idareaCode) {
		this.idareaCode = idareaCode;
	}
  
	public Long getOrd() {
		return this.ord;
	}
	
	public void setOrd(Long ord) {
		this.ord = ord;
	}
  
	public String getUpdateType() {
		return this.updateType;
	}
	
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
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
  
	public String getUpdateSign() {
		return this.updateSign;
	}
	
	public void setUpdateSign(String updateSign) {
		this.updateSign = updateSign;
	}
  
	public Date getUpdateDate() {
		return this.updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
  
	public String getUpdateErrorDesc() {
		return this.updateErrorDesc;
	}
	
	public void setUpdateErrorDesc(String updateErrorDesc) {
		this.updateErrorDesc = updateErrorDesc;
	}
  
	public String getIfCg() {
		return this.ifCg;
	}
	
	public void setIfCg(String ifCg) {
		this.ifCg = ifCg;
	}



	public void copy(AmOrg other){
  
		this.setIdorg(other.getIdorg());
  
		this.idparentorg= other.getIdparentorg();  
		this.orgname= other.getOrgname();  
		this.orgshortname= other.getOrgshortname();  
		this.idareaCode= other.getIdareaCode();  
		this.ord= other.getOrd();  
		this.updateType= other.getUpdateType();  
		this.syncSign= other.getSyncSign();  
		this.syncDate= other.getSyncDate();  
		this.syncErrorDesc= other.getSyncErrorDesc();  
		this.updateSign= other.getUpdateSign();  
		this.updateDate= other.getUpdateDate();  
		this.updateErrorDesc= other.getUpdateErrorDesc();  
		this.ifCg= other.getIfCg();

	}
	
	public void copyNotNullProperty(AmOrg other){
  
	if( other.getIdorg() != null)
		this.setIdorg(other.getIdorg());
  
		if( other.getIdparentorg() != null)
			this.idparentorg= other.getIdparentorg();  
		if( other.getOrgname() != null)
			this.orgname= other.getOrgname();  
		if( other.getOrgshortname() != null)
			this.orgshortname= other.getOrgshortname();  
		if( other.getIdareaCode() != null)
			this.idareaCode= other.getIdareaCode();  
		if( other.getOrd() != null)
			this.ord= other.getOrd();  
		if( other.getUpdateType() != null)
			this.updateType= other.getUpdateType();  
		if( other.getSyncSign() != null)
			this.syncSign= other.getSyncSign();  
		if( other.getSyncDate() != null)
			this.syncDate= other.getSyncDate();  
		if( other.getSyncErrorDesc() != null)
			this.syncErrorDesc= other.getSyncErrorDesc();  
		if( other.getUpdateSign() != null)
			this.updateSign= other.getUpdateSign();  
		if( other.getUpdateDate() != null)
			this.updateDate= other.getUpdateDate();  
		if( other.getUpdateErrorDesc() != null)
			this.updateErrorDesc= other.getUpdateErrorDesc();  
		if( other.getIfCg() != null)
			this.ifCg= other.getIfCg();

	}
	
	public void clearProperties(){
  
		this.idparentorg= null;  
		this.orgname= null;  
		this.orgshortname= null;  
		this.idareaCode= null;  
		this.ord= null;  
		this.updateType= null;  
		this.syncSign= null;  
		this.syncDate= null;  
		this.syncErrorDesc= null;  
		this.updateSign= null;  
		this.updateDate= null;  
		this.updateErrorDesc= null;  
		this.ifCg= null;

	}
}
