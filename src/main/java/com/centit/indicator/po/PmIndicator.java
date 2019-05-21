package com.centit.indicator.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class PmIndicator implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String indicatorId;

	private String  indicatorName;				//指标名称
	private String  indicatorNickName;		//字段名称
	private String  hasLower;						//是否有下级
	private String  fatherId;						//上级指标id
	private String  ifDictionary;					//是否字典项
	private String  dictionaryId;					//字典id
	private String  dictionaryKey;				//字典key
	private String  inputType;					//输入方式
	private String  ifCascade;						//是否级联
	private String  cascadeId;					//级联指标id
	private String  valueType;					//指标值类型
	private Date  createTime;
	private String  createBy;
	
	private Long order = -1L;              //指标页面排序

	// Constructors
	/** default constructor */
	public PmIndicator() {
	}
	/** minimal constructor */
	public PmIndicator(
		String indicatorId		
		) {
	
	
		this.indicatorId = indicatorId;		
			
	}

/** full constructor */
	public PmIndicator(
	 String indicatorId		
	,String  indicatorName,String  indicatorNickName,String  hasLower,String  fatherId,String  ifDictionary,String  dictionaryId,String  dictionaryKey,String  inputType,String  ifCascade,String  cascadeId,String  valueType,Date  createTime,String  createBy, Long order) {
	
	
		this.indicatorId = indicatorId;		
	
		this.indicatorName= indicatorName;
		this.indicatorNickName= indicatorNickName;
		this.hasLower= hasLower;
		this.fatherId= fatherId;
		this.ifDictionary= ifDictionary;
		this.dictionaryId= dictionaryId;
		this.dictionaryKey= dictionaryKey;
		this.inputType= inputType;
		this.ifCascade= ifCascade;
		this.cascadeId= cascadeId;
		this.valueType= valueType;
		this.createTime= createTime;
		this.createBy= createBy;
		this.order = order;
	}
	

  
	public String getIndicatorId() {
		return this.indicatorId;
	}

	public void setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
	}
	// Property accessors
  
	public String getIndicatorName() {
		return this.indicatorName;
	}
	
	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}
  
	public String getIndicatorNickName() {
		return this.indicatorNickName;
	}
	
	public void setIndicatorNickName(String indicatorNickName) {
		this.indicatorNickName = indicatorNickName;
	}
  
	public String getHasLower() {
		return this.hasLower;
	}
	
	public void setHasLower(String hasLower) {
		this.hasLower = hasLower;
	}
  
	public String getFatherId() {
		return this.fatherId;
	}
	
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
  
	public String getIfDictionary() {
		return this.ifDictionary;
	}
	
	public void setIfDictionary(String ifDictionary) {
		this.ifDictionary = ifDictionary;
	}
  
	public String getDictionaryId() {
		return this.dictionaryId;
	}
	
	public void setDictionaryId(String dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
  
	public String getDictionaryKey() {
		return this.dictionaryKey;
	}
	
	public void setDictionaryKey(String dictionaryKey) {
		this.dictionaryKey = dictionaryKey;
	}
  
	public String getInputType() {
		return this.inputType;
	}
	
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
  
	public String getIfCascade() {
		return this.ifCascade;
	}
	
	public void setIfCascade(String ifCascade) {
		this.ifCascade = ifCascade;
	}
  
	public String getCascadeId() {
		return this.cascadeId;
	}
	
	public void setCascadeId(String cascadeId) {
		this.cascadeId = cascadeId;
	}
  
	public String getValueType() {
		return this.valueType;
	}
	
	public void setValueType(String valueType) {
		this.valueType = valueType;
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



	public Long getOrder() {
		return order;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
	public void copy(PmIndicator other){
  
		this.setIndicatorId(other.getIndicatorId());
  
		this.indicatorName= other.getIndicatorName();  
		this.indicatorNickName= other.getIndicatorNickName();  
		this.hasLower= other.getHasLower();  
		this.fatherId= other.getFatherId();  
		this.ifDictionary= other.getIfDictionary();  
		this.dictionaryId= other.getDictionaryId();  
		this.dictionaryKey= other.getDictionaryKey();  
		this.inputType= other.getInputType();  
		this.ifCascade= other.getIfCascade();  
		this.cascadeId= other.getCascadeId();  
		this.valueType= other.getValueType();  
		this.createTime= other.getCreateTime();  
		this.createBy= other.getCreateBy();
		this.order= other.getOrder();

	}
	
	public void copyNotNullProperty(PmIndicator other){
  
	if( other.getIndicatorId() != null)
		this.setIndicatorId(other.getIndicatorId());
  
		if( other.getIndicatorName() != null)
			this.indicatorName= other.getIndicatorName();  
		if( other.getIndicatorNickName() != null)
			this.indicatorNickName= other.getIndicatorNickName();  
		if( other.getHasLower() != null)
			this.hasLower= other.getHasLower();  
		if( other.getFatherId() != null)
			this.fatherId= other.getFatherId();  
		if( other.getIfDictionary() != null)
			this.ifDictionary= other.getIfDictionary();  
		if( other.getDictionaryId() != null)
			this.dictionaryId= other.getDictionaryId();  
		if( other.getDictionaryKey() != null)
			this.dictionaryKey= other.getDictionaryKey();  
		if( other.getInputType() != null)
			this.inputType= other.getInputType();  
		if( other.getIfCascade() != null)
			this.ifCascade= other.getIfCascade();  
		if( other.getCascadeId() != null)
			this.cascadeId= other.getCascadeId();  
		if( other.getValueType() != null)
			this.valueType= other.getValueType();  
		if( other.getCreateTime() != null)
			this.createTime= other.getCreateTime();  
		if( other.getCreateBy() != null)
			this.createBy= other.getCreateBy();
		if( other.getOrder() != null)
			this.order= other.getOrder();

	}
	
	public void clearProperties(){
  
		this.indicatorName= null;  
		this.indicatorNickName= null;  
		this.hasLower= null;  
		this.fatherId= null;  
		this.ifDictionary= null;  
		this.dictionaryId= null;  
		this.dictionaryKey= null;  
		this.inputType= null;  
		this.ifCascade= null;  
		this.cascadeId= null;  
		this.valueType= null;  
		this.createTime= null;  
		this.createBy= null;
		this.order= null;

	}
}
