package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class DeptYwInfExpand implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String iddeptYwExpand;

	private String  updateType;
	private String  iddeptYwInf;
	private String  ifJzHall;
	private String  ifOnlineSb;
	private String  onlineBlSd;
	private String  onlineQcBj;
	private String  daoXcNum;
	private String  onlinePay;
	private String  onlineEms;
	private String  zxspType;
	private String  linkwithPHall;
	private String  useTyPlatform;
	private String  djType;
	private String  jrTyBj;
	private String  needLogin;
	private String  idTestType;
	private Date  createDate;
	private String  syncSign;
	private Date  syncDate;
	private String  syncErrorDesc;
	private String  updateSign;
	private Date  updateDate;
	private String  updateErrorDesc;

	// Constructors
	/** default constructor */
	public DeptYwInfExpand() {
	}
	/** minimal constructor */
	public DeptYwInfExpand(
		String iddeptYwExpand		
		,String  updateType,String  iddeptYwInf,Date  createDate,String  syncSign,String  updateSign) {
	
	
		this.iddeptYwExpand = iddeptYwExpand;		
	
		this.updateType= updateType; 
		this.iddeptYwInf= iddeptYwInf; 
		this.createDate= createDate; 
		this.syncSign= syncSign; 
		this.updateSign= updateSign; 		
	}

/** full constructor */
	public DeptYwInfExpand(
	 String iddeptYwExpand		
	,String  updateType,String  iddeptYwInf,String  ifJzHall,String  ifOnlineSb,String  onlineBlSd,String  onlineQcBj,String  daoXcNum,String  onlinePay,String  onlineEms,String  zxspType,String  linkwithPHall,String  useTyPlatform,String  djType,String  jrTyBj,String  needLogin,String  idTestType,Date  createDate,String  syncSign,Date  syncDate,String  syncErrorDesc,String  updateSign,Date  updateDate,String  updateErrorDesc) {
	
	
		this.iddeptYwExpand = iddeptYwExpand;		
	
		this.updateType= updateType;
		this.iddeptYwInf= iddeptYwInf;
		this.ifJzHall= ifJzHall;
		this.ifOnlineSb= ifOnlineSb;
		this.onlineBlSd= onlineBlSd;
		this.onlineQcBj= onlineQcBj;
		this.daoXcNum= daoXcNum;
		this.onlinePay= onlinePay;
		this.onlineEms= onlineEms;
		this.zxspType= zxspType;
		this.linkwithPHall= linkwithPHall;
		this.useTyPlatform= useTyPlatform;
		this.djType= djType;
		this.jrTyBj= jrTyBj;
		this.needLogin= needLogin;
		this.idTestType= idTestType;
		this.createDate= createDate;
		this.syncSign= syncSign;
		this.syncDate= syncDate;
		this.syncErrorDesc= syncErrorDesc;
		this.updateSign= updateSign;
		this.updateDate= updateDate;
		this.updateErrorDesc= updateErrorDesc;		
	}
	

  
	public String getIddeptYwExpand() {
		return this.iddeptYwExpand;
	}

	public void setIddeptYwExpand(String iddeptYwExpand) {
		this.iddeptYwExpand = iddeptYwExpand;
	}
	// Property accessors
  
	public String getUpdateType() {
		return this.updateType;
	}
	
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
  
	public String getIddeptYwInf() {
		return this.iddeptYwInf;
	}
	
	public void setIddeptYwInf(String iddeptYwInf) {
		this.iddeptYwInf = iddeptYwInf;
	}
  
	public String getIfJzHall() {
		return this.ifJzHall;
	}
	
	public void setIfJzHall(String ifJzHall) {
		this.ifJzHall = ifJzHall;
	}
  
	public String getIfOnlineSb() {
		return this.ifOnlineSb;
	}
	
	public void setIfOnlineSb(String ifOnlineSb) {
		this.ifOnlineSb = ifOnlineSb;
	}
  
	public String getOnlineBlSd() {
		return this.onlineBlSd;
	}
	
	public void setOnlineBlSd(String onlineBlSd) {
		this.onlineBlSd = onlineBlSd;
	}
  
	public String getOnlineQcBj() {
		return this.onlineQcBj;
	}
	
	public void setOnlineQcBj(String onlineQcBj) {
		this.onlineQcBj = onlineQcBj;
	}
  
	public String getDaoXcNum() {
		return this.daoXcNum;
	}
	
	public void setDaoXcNum(String daoXcNum) {
		this.daoXcNum = daoXcNum;
	}
  
	public String getOnlinePay() {
		return this.onlinePay;
	}
	
	public void setOnlinePay(String onlinePay) {
		this.onlinePay = onlinePay;
	}
  
	public String getOnlineEms() {
		return this.onlineEms;
	}
	
	public void setOnlineEms(String onlineEms) {
		this.onlineEms = onlineEms;
	}
  
	public String getZxspType() {
		return this.zxspType;
	}
	
	public void setZxspType(String zxspType) {
		this.zxspType = zxspType;
	}
  
	public String getLinkwithPHall() {
		return this.linkwithPHall;
	}
	
	public void setLinkwithPHall(String linkwithPHall) {
		this.linkwithPHall = linkwithPHall;
	}
  
	public String getUseTyPlatform() {
		return this.useTyPlatform;
	}
	
	public void setUseTyPlatform(String useTyPlatform) {
		this.useTyPlatform = useTyPlatform;
	}
  
	public String getDjType() {
		return this.djType;
	}
	
	public void setDjType(String djType) {
		this.djType = djType;
	}
  
	public String getJrTyBj() {
		return this.jrTyBj;
	}
	
	public void setJrTyBj(String jrTyBj) {
		this.jrTyBj = jrTyBj;
	}
  
	public String getNeedLogin() {
		return this.needLogin;
	}
	
	public void setNeedLogin(String needLogin) {
		this.needLogin = needLogin;
	}
  
	public String getIdTestType() {
		return this.idTestType;
	}
	
	public void setIdTestType(String idTestType) {
		this.idTestType = idTestType;
	}
  
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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



	public void copy(DeptYwInfExpand other){
  
		this.setIddeptYwExpand(other.getIddeptYwExpand());
  
		this.updateType= other.getUpdateType();  
		this.iddeptYwInf= other.getIddeptYwInf();  
		this.ifJzHall= other.getIfJzHall();  
		this.ifOnlineSb= other.getIfOnlineSb();  
		this.onlineBlSd= other.getOnlineBlSd();  
		this.onlineQcBj= other.getOnlineQcBj();  
		this.daoXcNum= other.getDaoXcNum();  
		this.onlinePay= other.getOnlinePay();  
		this.onlineEms= other.getOnlineEms();  
		this.zxspType= other.getZxspType();  
		this.linkwithPHall= other.getLinkwithPHall();  
		this.useTyPlatform= other.getUseTyPlatform();  
		this.djType= other.getDjType();  
		this.jrTyBj= other.getJrTyBj();  
		this.needLogin= other.getNeedLogin();  
		this.idTestType= other.getIdTestType();  
		this.createDate= other.getCreateDate();  
		this.syncSign= other.getSyncSign();  
		this.syncDate= other.getSyncDate();  
		this.syncErrorDesc= other.getSyncErrorDesc();  
		this.updateSign= other.getUpdateSign();  
		this.updateDate= other.getUpdateDate();  
		this.updateErrorDesc= other.getUpdateErrorDesc();

	}
	
	public void copyNotNullProperty(DeptYwInfExpand other){
  
	if( other.getIddeptYwExpand() != null)
		this.setIddeptYwExpand(other.getIddeptYwExpand());
  
		if( other.getUpdateType() != null)
			this.updateType= other.getUpdateType();  
		if( other.getIddeptYwInf() != null)
			this.iddeptYwInf= other.getIddeptYwInf();  
		if( other.getIfJzHall() != null)
			this.ifJzHall= other.getIfJzHall();  
		if( other.getIfOnlineSb() != null)
			this.ifOnlineSb= other.getIfOnlineSb();  
		if( other.getOnlineBlSd() != null)
			this.onlineBlSd= other.getOnlineBlSd();  
		if( other.getOnlineQcBj() != null)
			this.onlineQcBj= other.getOnlineQcBj();  
		if( other.getDaoXcNum() != null)
			this.daoXcNum= other.getDaoXcNum();  
		if( other.getOnlinePay() != null)
			this.onlinePay= other.getOnlinePay();  
		if( other.getOnlineEms() != null)
			this.onlineEms= other.getOnlineEms();  
		if( other.getZxspType() != null)
			this.zxspType= other.getZxspType();  
		if( other.getLinkwithPHall() != null)
			this.linkwithPHall= other.getLinkwithPHall();  
		if( other.getUseTyPlatform() != null)
			this.useTyPlatform= other.getUseTyPlatform();  
		if( other.getDjType() != null)
			this.djType= other.getDjType();  
		if( other.getJrTyBj() != null)
			this.jrTyBj= other.getJrTyBj();  
		if( other.getNeedLogin() != null)
			this.needLogin= other.getNeedLogin();  
		if( other.getIdTestType() != null)
			this.idTestType= other.getIdTestType();  
		if( other.getCreateDate() != null)
			this.createDate= other.getCreateDate();  
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

	}
	
	public void clearProperties(){
  
		this.updateType= null;  
		this.iddeptYwInf= null;  
		this.ifJzHall= null;  
		this.ifOnlineSb= null;  
		this.onlineBlSd= null;  
		this.onlineQcBj= null;  
		this.daoXcNum= null;  
		this.onlinePay= null;  
		this.onlineEms= null;  
		this.zxspType= null;  
		this.linkwithPHall= null;  
		this.useTyPlatform= null;  
		this.djType= null;  
		this.jrTyBj= null;  
		this.needLogin= null;  
		this.idTestType= null;  
		this.createDate= null;  
		this.syncSign= null;  
		this.syncDate= null;  
		this.syncErrorDesc= null;  
		this.updateSign= null;  
		this.updateDate= null;  
		this.updateErrorDesc= null;

	}
}
