package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class OptSendMessage implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String sendid;

	private String  sendname;
	private String  sendprov;
	private String  sendcity;
	private String  sendCountry;
	private String  sendstrect;
	private String  sendphone;
	private String  sendcall;

	// Constructors
	/** default constructor */
	public OptSendMessage() {
	}
	/** minimal constructor */
	public OptSendMessage(
		String sendid		
		) {
	
	
		this.sendid = sendid;		
			
	}

/** full constructor */
	public OptSendMessage(
	 String sendid		
	,String  sendname,String  sendprov,String  sendcity,String  sendCountry,String  sendstrect,String  sendphone,String  sendcall) {
	
	
		this.sendid = sendid;		
	
		this.sendname= sendname;
		this.sendprov= sendprov;
		this.sendcity= sendcity;
		this.sendCountry= sendCountry;
		this.sendstrect= sendstrect;
		this.sendphone= sendphone;
		this.sendcall= sendcall;		
	}
	

  
	public String getSendid() {
		return this.sendid;
	}

	public void setSendid(String sendid) {
		this.sendid = sendid;
	}
	// Property accessors
  
	public String getSendname() {
		return this.sendname;
	}
	
	public void setSendname(String sendname) {
		this.sendname = sendname;
	}
  
	public String getSendprov() {
		return this.sendprov;
	}
	
	public void setSendprov(String sendprov) {
		this.sendprov = sendprov;
	}
  
	public String getSendcity() {
		return this.sendcity;
	}
	
	public void setSendcity(String sendcity) {
		this.sendcity = sendcity;
	}
  
	public String getSendCountry() {
		return this.sendCountry;
	}
	
	public void setSendCountry(String sendCountry) {
		this.sendCountry = sendCountry;
	}
  
	public String getSendstrect() {
		return this.sendstrect;
	}
	
	public void setSendstrect(String sendstrect) {
		this.sendstrect = sendstrect;
	}
  
	public String getSendphone() {
		return this.sendphone;
	}
	
	public void setSendphone(String sendphone) {
		this.sendphone = sendphone;
	}
  
	public String getSendcall() {
		return this.sendcall;
	}
	
	public void setSendcall(String sendcall) {
		this.sendcall = sendcall;
	}



	public void copy(OptSendMessage other){
  
		this.setSendid(other.getSendid());
  
		this.sendname= other.getSendname();  
		this.sendprov= other.getSendprov();  
		this.sendcity= other.getSendcity();  
		this.sendCountry= other.getSendCountry();  
		this.sendstrect= other.getSendstrect();  
		this.sendphone= other.getSendphone();  
		this.sendcall= other.getSendcall();

	}
	
	public void copyNotNullProperty(OptSendMessage other){
  
	if( other.getSendid() != null)
		this.setSendid(other.getSendid());
  
		if( other.getSendname() != null)
			this.sendname= other.getSendname();  
		if( other.getSendprov() != null)
			this.sendprov= other.getSendprov();  
		if( other.getSendcity() != null)
			this.sendcity= other.getSendcity();  
		if( other.getSendCountry() != null)
			this.sendCountry= other.getSendCountry();  
		if( other.getSendstrect() != null)
			this.sendstrect= other.getSendstrect();  
		if( other.getSendphone() != null)
			this.sendphone= other.getSendphone();  
		if( other.getSendcall() != null)
			this.sendcall= other.getSendcall();

	}
	
	public void clearProperties(){
  
		this.sendname= null;  
		this.sendprov= null;  
		this.sendcity= null;  
		this.sendCountry= null;  
		this.sendstrect= null;  
		this.sendphone= null;  
		this.sendcall= null;

	}
}
