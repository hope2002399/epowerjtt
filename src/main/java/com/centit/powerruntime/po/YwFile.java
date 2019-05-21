package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class YwFile implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String idywFile;

	private String  deptYwId;
	private String  fileType;
	private String  fileName;
	private String  sourceFileName;
	private String  sourceFileUrl;
	private String  fileRemark;
	private String  pageNum;
	private String  ifEcPage;
	private String  fileSource;
	private String  fileSourceExplain;
	private String  fileExplian;
	private String  fileLaw;
	private String  ifNeed;
	private String  ord;
	private Date  createDate;
	private String  updateType;
	private String  syncSign;
	private Date  syncDate;
	private String  syncErrorDesc;
	private String  updateSign;
	private Date  updateDate;
	private String  updateErrorDesc;
	private String fileSourceName;
	// Constructors
	/** default constructor */
	public YwFile() {
	}
	/** minimal constructor */
	public YwFile(
		String idywFile		
		,String  updateType,String  syncSign,String  updateSign) {
	
	
		this.idywFile = idywFile;		
	
		this.updateType= updateType; 
		this.syncSign= syncSign; 
		this.updateSign= updateSign; 		
	}

/** full constructor */
	public YwFile(
	 String idywFile		
	,String  deptYwId,String  fileType,String  fileName,String  sourceFileName,String  sourceFileUrl,String  fileRemark,String  pageNum,String  ifEcPage,String  fileSource,String  fileSourceExplain,String  fileExplian,String  fileLaw,String  ifNeed,String  ord,Date  createDate,String  updateType,String  syncSign,Date  syncDate,String  syncErrorDesc,String  updateSign,Date  updateDate,String  updateErrorDesc) {
	
	
		this.idywFile = idywFile;		
	
		this.deptYwId= deptYwId;
		this.fileType= fileType;
		this.fileName= fileName;
		this.sourceFileName= sourceFileName;
		this.sourceFileUrl= sourceFileUrl;
		this.fileRemark= fileRemark;
		this.pageNum= pageNum;
		this.ifEcPage= ifEcPage;
		this.fileSource= fileSource;
		this.fileSourceExplain= fileSourceExplain;
		this.fileExplian= fileExplian;
		this.fileLaw= fileLaw;
		this.ifNeed= ifNeed;
		this.ord= ord;
		this.createDate= createDate;
		this.updateType= updateType;
		this.syncSign= syncSign;
		this.syncDate= syncDate;
		this.syncErrorDesc= syncErrorDesc;
		this.updateSign= updateSign;
		this.updateDate= updateDate;
		this.updateErrorDesc= updateErrorDesc;		
	}
	

  
	public String getFileSourceName() {
    return fileSourceName;
    }
    public void setFileSourceName(String fileSourceName) {
        this.fileSourceName = fileSourceName;
    }
    public String getIdywFile() {
		return this.idywFile;
	}

	public void setIdywFile(String idywFile) {
		this.idywFile = idywFile;
	}
	// Property accessors
  
	public String getDeptYwId() {
		return this.deptYwId;
	}
	
	public void setDeptYwId(String deptYwId) {
		this.deptYwId = deptYwId;
	}
  
	public String getFileType() {
		return this.fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
  
	public String getFileName() {
		return this.fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
  
	public String getSourceFileName() {
		return this.sourceFileName;
	}
	
	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}
  
	public String getSourceFileUrl() {
		return this.sourceFileUrl;
	}
	
	public void setSourceFileUrl(String sourceFileUrl) {
		this.sourceFileUrl = sourceFileUrl;
	}
  
	public String getFileRemark() {
		return this.fileRemark;
	}
	
	public void setFileRemark(String fileRemark) {
		this.fileRemark = fileRemark;
	}
  
	public String getPageNum() {
		return this.pageNum;
	}
	
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
  
	public String getIfEcPage() {
		return this.ifEcPage;
	}
	
	public void setIfEcPage(String ifEcPage) {
		this.ifEcPage = ifEcPage;
	}
  
	public String getFileSource() {
		return this.fileSource;
	}
	
	public void setFileSource(String fileSource) {
		this.fileSource = fileSource;
	}
  
	public String getFileSourceExplain() {
		return this.fileSourceExplain;
	}
	
	public void setFileSourceExplain(String fileSourceExplain) {
		this.fileSourceExplain = fileSourceExplain;
	}
  
	public String getFileExplian() {
		return this.fileExplian;
	}
	
	public void setFileExplian(String fileExplian) {
		this.fileExplian = fileExplian;
	}
  
	public String getFileLaw() {
		return this.fileLaw;
	}
	
	public void setFileLaw(String fileLaw) {
		this.fileLaw = fileLaw;
	}
  
	public String getIfNeed() {
		return this.ifNeed;
	}
	
	public void setIfNeed(String ifNeed) {
		this.ifNeed = ifNeed;
	}
  
	public String getOrd() {
		return this.ord;
	}
	
	public void setOrd(String ord) {
		this.ord = ord;
	}
  
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
  
	public String getUpdateType() {
		return this.updateType;
	}
	
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
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



	public void copy(YwFile other){
  
		this.setIdywFile(other.getIdywFile());
  
		this.deptYwId= other.getDeptYwId();  
		this.fileType= other.getFileType();  
		this.fileName= other.getFileName();  
		this.sourceFileName= other.getSourceFileName();  
		this.sourceFileUrl= other.getSourceFileUrl();  
		this.fileRemark= other.getFileRemark();  
		this.pageNum= other.getPageNum();  
		this.ifEcPage= other.getIfEcPage();  
		this.fileSource= other.getFileSource();  
		this.fileSourceExplain= other.getFileSourceExplain();  
		this.fileExplian= other.getFileExplian();  
		this.fileLaw= other.getFileLaw();  
		this.ifNeed= other.getIfNeed();  
		this.ord= other.getOrd();  
		this.createDate= other.getCreateDate();  
		this.updateType= other.getUpdateType();  
		this.syncSign= other.getSyncSign();  
		this.syncDate= other.getSyncDate();  
		this.syncErrorDesc= other.getSyncErrorDesc();  
		this.updateSign= other.getUpdateSign();  
		this.updateDate= other.getUpdateDate();  
		this.updateErrorDesc= other.getUpdateErrorDesc();

	}
	
	public void copyNotNullProperty(YwFile other){
  
	if( other.getIdywFile() != null)
		this.setIdywFile(other.getIdywFile());
  
		if( other.getDeptYwId() != null)
			this.deptYwId= other.getDeptYwId();  
		if( other.getFileType() != null)
			this.fileType= other.getFileType();  
		if( other.getFileName() != null)
			this.fileName= other.getFileName();  
		if( other.getSourceFileName() != null)
			this.sourceFileName= other.getSourceFileName();  
		if( other.getSourceFileUrl() != null)
			this.sourceFileUrl= other.getSourceFileUrl();  
		if( other.getFileRemark() != null)
			this.fileRemark= other.getFileRemark();  
		if( other.getPageNum() != null)
			this.pageNum= other.getPageNum();  
		if( other.getIfEcPage() != null)
			this.ifEcPage= other.getIfEcPage();  
		if( other.getFileSource() != null)
			this.fileSource= other.getFileSource();  
		if( other.getFileSourceExplain() != null)
			this.fileSourceExplain= other.getFileSourceExplain();  
		if( other.getFileExplian() != null)
			this.fileExplian= other.getFileExplian();  
		if( other.getFileLaw() != null)
			this.fileLaw= other.getFileLaw();  
		if( other.getIfNeed() != null)
			this.ifNeed= other.getIfNeed();  
		if( other.getOrd() != null)
			this.ord= other.getOrd();  
		if( other.getCreateDate() != null)
			this.createDate= other.getCreateDate();  
		if( other.getUpdateType() != null)
			this.updateType= other.getUpdateType();  
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
  
		this.deptYwId= null;  
		this.fileType= null;  
		this.fileName= null;  
		this.sourceFileName= null;  
		this.sourceFileUrl= null;  
		this.fileRemark= null;  
		this.pageNum= null;  
		this.ifEcPage= null;  
		this.fileSource= null;  
		this.fileSourceExplain= null;  
		this.fileExplian= null;  
		this.fileLaw= null;  
		this.ifNeed= null;  
		this.ord= null;  
		this.createDate= null;  
		this.updateType= null;  
		this.syncSign= null;  
		this.syncDate= null;  
		this.syncErrorDesc= null;  
		this.updateSign= null;  
		this.updateDate= null;  
		this.updateErrorDesc= null;

	}
}
