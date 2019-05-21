package com.centit.indicator.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class PmIndexExpression implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String templetId;

	private String  expression;

	// Constructors
	/** default constructor */
	public PmIndexExpression() {
	}
	/** minimal constructor */
	public PmIndexExpression(
		String templetId		
		) {
	
	
		this.templetId = templetId;		
			
	}

/** full constructor */
	public PmIndexExpression(
	 String templetId		
	,String  expression) {
	
	
		this.templetId = templetId;		
	
		this.expression= expression;		
	}
	

  
	public String getTempletId() {
		return this.templetId;
	}

	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}
	// Property accessors
  
	public String getExpression() {
		return this.expression;
	}
	
	public void setExpression(String expression) {
		this.expression = expression;
	}



	public void copy(PmIndexExpression other){
  
		this.setTempletId(other.getTempletId());
  
		this.expression= other.getExpression();

	}
	
	public void copyNotNullProperty(PmIndexExpression other){
  
	if( other.getTempletId() != null)
		this.setTempletId(other.getTempletId());
  
		if( other.getExpression() != null)
			this.expression= other.getExpression();

	}
	
	public void clearProperties(){
  
		this.expression= null;

	}
}
