package com.centit.indicator.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class PmIndexEvluation implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String evlId;

	private String  templetId;
	private String  objectId;
	private String  objectType;
	private String  evlScore;
	private String  taskId;
	private Date  evlTime;
	private String annual;

	// Constructors
	/** default constructor */
	public PmIndexEvluation() {
	}
	/** minimal constructor */
	public PmIndexEvluation(
		String evlId		
		) {
	
	
		this.evlId = evlId;		
			
	}

/** full constructor */
	public PmIndexEvluation(
	 String evlId		
	,String  templetId,String  objectId,String  objectType,String  evlScore,String  taskId,Date  evlTime,String annual) {
	
	
		this.evlId = evlId;		
	
		this.templetId= templetId;
		this.objectId= objectId;
		this.objectType= objectType;
		this.evlScore= evlScore;
		this.taskId= taskId;
		this.evlTime= evlTime;		
		this.annual= annual;
	}
	

  
	public String getEvlId() {
		return this.evlId;
	}

	public void setEvlId(String evlId) {
		this.evlId = evlId;
	}
	// Property accessors
  
	public String getTempletId() {
		return this.templetId;
	}
	
	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}
  
	public String getObjectId() {
		return this.objectId;
	}
	
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
  
	public String getObjectType() {
		return this.objectType;
	}
	
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
  
	public String getEvlScore() {
		return this.evlScore;
	}
	
	public void setEvlScore(String evlScore) {
		this.evlScore = evlScore;
	}
  
	public String getTaskId() {
		return this.taskId;
	}
	
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
  
	public Date getEvlTime() {
		return this.evlTime;
	}
	
	public void setEvlTime(Date evlTime) {
		this.evlTime = evlTime;
	}



	public void copy(PmIndexEvluation other){
  
		this.setEvlId(other.getEvlId());
  
		this.templetId= other.getTempletId();  
		this.objectId= other.getObjectId();  
		this.objectType= other.getObjectType();  
		this.evlScore= other.getEvlScore();  
		this.taskId= other.getTaskId();  
		this.evlTime= other.getEvlTime();
		this.annual= other.getAnnual();

	}
	
	public void copyNotNullProperty(PmIndexEvluation other){
  
	if( other.getEvlId() != null)
		this.setEvlId(other.getEvlId());
  
		if( other.getTempletId() != null)
			this.templetId= other.getTempletId();  
		if( other.getObjectId() != null)
			this.objectId= other.getObjectId();  
		if( other.getObjectType() != null)
			this.objectType= other.getObjectType();  
		if( other.getEvlScore() != null)
			this.evlScore= other.getEvlScore();  
		if( other.getTaskId() != null)
			this.taskId= other.getTaskId();  
		if( other.getEvlTime() != null)
			this.evlTime= other.getEvlTime();
		if( other.getAnnual() != null)
			this.annual=other.getAnnual();

	}
	
	public void clearProperties(){
  
		this.templetId= null;  
		this.objectId= null;  
		this.objectType= null;  
		this.evlScore= null;  
		this.taskId= null;  
		this.evlTime= null;
		this.annual= null;

	}
	public String getAnnual() {
		return annual;
	}
	public void setAnnual(String annual) {
		this.annual = annual;
	}
}
