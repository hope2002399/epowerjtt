package com.centit.indicator.po;


/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class PmNode implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String indicatorId;
	private String templetId;

	private String  ifMust;
	private String  ifInternal;
	private String  internalTable;
	private String ifAlong;
	private String  ifPrimary;
	private String  ifHidden;
	private Long  indicatorLevel;
	private Long  indicatorIndex;
	private String  ifWriteBack;
	private String  writeBackTable;
	private String  writeBackIndicator;
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
	private String  ifCp;					//是否参与测评
	private String evlType;					//测评方式
	private String evlMethod;              //测评具体方式
	
	private Long order = -1L;              //指标页面排序
	
	
	public String getIfMust() {
		return ifMust;
	}
	public void setIfMust(String ifMust) {
		this.ifMust = ifMust;
	}
	public String getIfInternal() {
		return ifInternal;
	}
	public void setIfInternal(String ifInternal) {
		this.ifInternal = ifInternal;
	}
	public String getInternalTable() {
		return internalTable;
	}
	public void setInternalTable(String internalTable) {
		this.internalTable = internalTable;
	}
	public String getIfAlong() {
		return ifAlong;
	}
	public void setIfAlong(String ifAlong) {
		this.ifAlong = ifAlong;
	}
	public String getIfPrimary() {
		return ifPrimary;
	}
	public void setIfPrimary(String ifPrimary) {
		this.ifPrimary = ifPrimary;
	}
	public String getIfHidden() {
		return ifHidden;
	}
	public void setIfHidden(String ifHidden) {
		this.ifHidden = ifHidden;
	}
	public Long getIndicatorLevel() {
		return indicatorLevel;
	}
	public void setIndicatorLevel(Long indicatorLevel) {
		this.indicatorLevel = indicatorLevel;
	}
	public Long getIndicatorIndex() {
		return indicatorIndex;
	}
	public void setIndicatorIndex(Long indicatorIndex) {
		this.indicatorIndex = indicatorIndex;
	}
	public String getIfWriteBack() {
		return ifWriteBack;
	}
	public void setIfWriteBack(String ifWriteBack) {
		this.ifWriteBack = ifWriteBack;
	}
	public String getWriteBackTable() {
		return writeBackTable;
	}
	public void setWriteBackTable(String writeBackTable) {
		this.writeBackTable = writeBackTable;
	}
	public String getWriteBackIndicator() {
		return writeBackIndicator;
	}
	public void setWriteBackIndicator(String writeBackIndicator) {
		this.writeBackIndicator = writeBackIndicator;
	}
	public String getIndicatorId() {
		return indicatorId;
	}
	public void setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
	}
	public String getTempletId() {
		return templetId;
	}
	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}
	public String getIndicatorName() {
		return indicatorName;
	}
	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}
	public String getIndicatorNickName() {
		return indicatorNickName;
	}
	public void setIndicatorNickName(String indicatorNickName) {
		this.indicatorNickName = indicatorNickName;
	}
	public String getHasLower() {
		return hasLower;
	}
	public void setHasLower(String hasLower) {
		this.hasLower = hasLower;
	}
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	public String getIfDictionary() {
		return ifDictionary;
	}
	public void setIfDictionary(String ifDictionary) {
		this.ifDictionary = ifDictionary;
	}
	public String getDictionaryId() {
		return dictionaryId;
	}
	public void setDictionaryId(String dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
	public String getDictionaryKey() {
		return dictionaryKey;
	}
	public void setDictionaryKey(String dictionaryKey) {
		this.dictionaryKey = dictionaryKey;
	}
	public String getInputType() {
		return inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	public String getIfCascade() {
		return ifCascade;
	}
	public void setIfCascade(String ifCascade) {
		this.ifCascade = ifCascade;
	}
	public String getCascadeId() {
		return cascadeId;
	}
	public void setCascadeId(String cascadeId) {
		this.cascadeId = cascadeId;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIfCp() {
		return ifCp;
	}
	public void setIfCp(String ifCp) {
		this.ifCp = ifCp;
	}
	public String getEvlType() {
		return evlType;
	}
	public void setEvlType(String evlType) {
		this.evlType = evlType;
	}
	public String getEvlMethod() {
		return evlMethod;
	}
	public void setEvlMethod(String evlMethod) {
		this.evlMethod = evlMethod;
	}

	public Long getOrder() {
		return order;
	}
	public void setOrder(Long order) {
		this.order = order;
	}

}
