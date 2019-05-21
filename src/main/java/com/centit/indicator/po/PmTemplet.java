package com.centit.indicator.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class PmTemplet implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String templetId;

	private String  templetCode;
	private String  templetName;
	private String  templetType;
	private String version;
	private String  year;
	private String  jspName;
	private String  jspHtml;
	private String  releaseFlag;
	private Date  createTime;
	private String  createBy;

	// Constructors
	/** default constructor */
	public PmTemplet() {
	}
	/** minimal constructor */
	public PmTemplet(
		String templetId		
		) {
	
	
		this.templetId = templetId;		
			
	}

/** full constructor */
	public PmTemplet(
	 String templetId		
	,String  templetCode,String  templetName,String version,String  templetType,String  year,String  jspName,String  jspHtml,String  releaseFlag,Date  createTime,String  createBy) {
	
	
		this.templetId = templetId;		
	
		this.version=version;
		this.templetCode= templetCode;
		this.templetName= templetName;
		this.templetType= templetType;
		this.year= year;
		this.jspName= jspName;
		this.jspHtml= jspHtml;
		this.releaseFlag= releaseFlag;
		this.createTime= createTime;
		this.createBy= createBy;		
	}
	

  
	public String getTempletId() {
		return this.templetId;
	}

	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}
	// Property accessors
  
	public String getTempletCode() {
		return this.templetCode;
	}
	
	public void setTempletCode(String templetCode) {
		this.templetCode = templetCode;
	}
  
	public String getTempletName() {
		return this.templetName;
	}
	
	public void setTempletName(String templetName) {
		this.templetName = templetName;
	}
  
	public String getTempletType() {
		return this.templetType;
	}
	
	public void setTempletType(String templetType) {
		this.templetType = templetType;
	}
  
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getYear() {
		return this.year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
  
	public String getJspName() {
		return this.jspName;
	}
	
	public void setJspName(String jspName) {
		this.jspName = jspName;
	}
  
	public String getJspHtml() {
		return this.jspHtml;
	}
	
	public void setJspHtml(String jspHtml) {
		this.jspHtml = jspHtml;
	}
  
	public String getReleaseFlag() {
		return this.releaseFlag;
	}
	
	public void setReleaseFlag(String releaseFlag) {
		this.releaseFlag = releaseFlag;
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



	public void copy(PmTemplet other){
  
		this.setTempletId(other.getTempletId());
  
		this.templetCode= other.getTempletCode();  
		this.templetName= other.getTempletName();  
		this.templetType= other.getTempletType();  
		this.version=other.getVersion();
		this.year= other.getYear();  
		this.jspName= other.getJspName();  
		this.jspHtml= other.getJspHtml();  
		this.releaseFlag= other.getReleaseFlag();  
		this.createTime= other.getCreateTime();  
		this.createBy= other.getCreateBy();

	}
	
	public void copyNotNullProperty(PmTemplet other){
  
	if( other.getTempletId() != null)
		this.setTempletId(other.getTempletId());
  
		if( other.getTempletCode() != null)
			this.templetCode= other.getTempletCode();  
		if( other.getTempletName() != null)
			this.templetName= other.getTempletName();  
		if( other.getTempletType() != null)
			this.templetType= other.getTempletType();  
		if(other.getVersion()!=null)
			this.version=other.getVersion();
		if( other.getYear() != null)
			this.year= other.getYear();  
		if( other.getJspName() != null)
			this.jspName= other.getJspName();  
		if( other.getJspHtml() != null)
			this.jspHtml= other.getJspHtml();  
		if( other.getReleaseFlag() != null)
			this.releaseFlag= other.getReleaseFlag();  
		if( other.getCreateTime() != null)
			this.createTime= other.getCreateTime();  
		if( other.getCreateBy() != null)
			this.createBy= other.getCreateBy();

	}
	
	public void clearProperties(){
  
		this.templetCode= null;  
		this.templetName= null;  
		this.templetType= null;  
		this.version=null;
		this.year= null;  
		this.jspName= null;  
		this.jspHtml= null;  
		this.releaseFlag= null;  
		this.createTime= null;  
		this.createBy= null;

	}
}
