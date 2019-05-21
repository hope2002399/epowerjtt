package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class OptDobasicMessage implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String dobasicid;

	private String  internalno;
	private String  zwfwzxCode;
	private String  expressid;


	// Constructors
	/** default constructor */
	public OptDobasicMessage() {
	}
	/** minimal constructor */
	public OptDobasicMessage(
		String dobasicid		
		) {
	
	
		this.dobasicid = dobasicid;		
			
	}

/** full constructor */
	public OptDobasicMessage(
	 String dobasicid		
	,String  internalno,String  zwfwzxCode,String  expressid) {
	
	
		this.dobasicid = dobasicid;		
	
		this.internalno= internalno;
		this.zwfwzxCode= zwfwzxCode;
		this.expressid= expressid;		
	}
	

  
	public String getDobasicid() {
		return this.dobasicid;
	}

	public void setDobasicid(String dobasicid) {
		this.dobasicid = dobasicid;
	}
	// Property accessors
  
	public String getInternalno() {
		return this.internalno;
	}
	
	public void setInternalno(String internalno) {
		this.internalno = internalno;
	}
  
	public String getZwfwzxCode() {
		return this.zwfwzxCode;
	}
	
	public void setZwfwzxCode(String zwfwzxCode) {
		this.zwfwzxCode = zwfwzxCode;
	}
  
	public String getExpressid() {
		return this.expressid;
	}
	
	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}



	public void copy(OptDobasicMessage other){
  
		this.setDobasicid(other.getDobasicid());
  
		this.internalno= other.getInternalno();  
		this.zwfwzxCode= other.getZwfwzxCode();  
		this.expressid= other.getExpressid();

	}
	
	public void copyNotNullProperty(OptDobasicMessage other){
  
	if( other.getDobasicid() != null)
		this.setDobasicid(other.getDobasicid());
  
		if( other.getInternalno() != null)
			this.internalno= other.getInternalno();  
		if( other.getZwfwzxCode() != null)
			this.zwfwzxCode= other.getZwfwzxCode();  
		if( other.getExpressid() != null)
			this.expressid= other.getExpressid();

	}
	
	public void clearProperties(){
  
		this.internalno= null;  
		this.zwfwzxCode= null;  
		this.expressid= null;

	}
}
