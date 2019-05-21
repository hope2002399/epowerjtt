package com.centit.indicator.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class PmIndexBasic implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String rangeId;

	private Double  grade;
	private Double  leftRange;
	private Double  rightRange;
	private String  indexId;
	private String  dictvalue;

	// Constructors
	/** default constructor */
	public PmIndexBasic() {
	}
	/** minimal constructor */
	public PmIndexBasic(
		String rangeId		
		) {
	
	
		this.rangeId = rangeId;		
			
	}

/** full constructor */
	public PmIndexBasic(
	 String rangeId		
	,Double  grade,Double  leftRange,Double  rightRange,String  indexId,String  dictvalue) {
	
	
		this.rangeId = rangeId;		
	
		this.grade= grade;
		this.leftRange= leftRange;
		this.rightRange= rightRange;
		this.indexId= indexId;
		this.dictvalue= dictvalue;		
	}
	

  
	public String getRangeId() {
		return this.rangeId;
	}

	public void setRangeId(String rangeId) {
		this.rangeId = rangeId;
	}
	// Property accessors
  
	public Double getGrade() {
		return this.grade;
	}
	
	public void setGrade(Double grade) {
		this.grade = grade;
	}
  
	public Double getLeftRange() {
		return this.leftRange;
	}
	
	public void setLeftRange(Double leftRange) {
		this.leftRange = leftRange;
	}
  
	public Double getRightRange() {
		return this.rightRange;
	}
	
	public void setRightRange(Double rightRange) {
		this.rightRange = rightRange;
	}
  
	public String getIndexId() {
		return this.indexId;
	}
	
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
  
	public String getDictvalue() {
		return this.dictvalue;
	}
	
	public void setDictvalue(String dictvalue) {
		this.dictvalue = dictvalue;
	}



	public void copy(PmIndexBasic other){
  
		this.setRangeId(other.getRangeId());
  
		this.grade= other.getGrade();  
		this.leftRange= other.getLeftRange();  
		this.rightRange= other.getRightRange();  
		this.indexId= other.getIndexId();  
		this.dictvalue= other.getDictvalue();

	}
	
	public void copyNotNullProperty(PmIndexBasic other){
  
	if( other.getRangeId() != null)
		this.setRangeId(other.getRangeId());
  
		if( other.getGrade() != null)
			this.grade= other.getGrade();  
		if( other.getLeftRange() != null)
			this.leftRange= other.getLeftRange();  
		if( other.getRightRange() != null)
			this.rightRange= other.getRightRange();  
		if( other.getIndexId() != null)
			this.indexId= other.getIndexId();  
		if( other.getDictvalue() != null)
			this.dictvalue= other.getDictvalue();

	}
	
	public void clearProperties(){
  
		this.grade= null;  
		this.leftRange= null;  
		this.rightRange= null;  
		this.indexId= null;  
		this.dictvalue= null;

	}
}
