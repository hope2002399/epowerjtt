package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class OptRelevancyResult implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String internalNo;
	private String  sendway;
	private String  memo;
	private String  username;
	private Date  updatedate;

	// Constructors
	/** default constructor */
	public OptRelevancyResult() {
	}
	/** minimal constructor */
	public OptRelevancyResult(
		String internalNo		
		) {
	
	
		this.internalNo = internalNo;		
			
	}

/** full constructor */
	public OptRelevancyResult(
	 String internalNo,String  sendway,String  memo,String  username,Date  updatedate) {
	
	
		this.internalNo = internalNo;		
		this.sendway= sendway;
		this.memo= memo;
		this.username= username;
		this.updatedate= updatedate;		
	}
	

  
	
  
	public String getInternalNo() {
	    return internalNo;
	}
    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }
    public String getSendway() {
		return this.sendway;
	}
	
	public void setSendway(String sendway) {
		this.sendway = sendway;
	}
  
	public String getMemo() {
		return this.memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
  
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
  
	public Date getUpdatedate() {
		return this.updatedate;
	}
	
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}



	public void copy(OptRelevancyResult other){
  
		this.setInternalNo(other.getInternalNo());
		this.sendway= other.getSendway();  
		this.memo= other.getMemo();  
		this.username= other.getUsername();  
		this.updatedate= other.getUpdatedate();

	}
	
	public void copyNotNullProperty(OptRelevancyResult other){
  
	if( other.getInternalNo() != null)
		this.setInternalNo(other.getInternalNo()); 
		if( other.getSendway() != null)
			this.sendway= other.getSendway();  
		if( other.getMemo() != null)
			this.memo= other.getMemo();  
		if( other.getUsername() != null)
			this.username= other.getUsername();  
		if( other.getUpdatedate() != null)
			this.updatedate= other.getUpdatedate();

	}
	
	public void clearProperties(){
   
		this.sendway= null;  
		this.memo= null;  
		this.username= null;  
		this.updatedate= null;

	}
}
