package com.centit.indicator.po;

import java.util.Date;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class PmIndexType implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String indexId;

	private String indicatorName;
	private String  indexname;
	private String  evlType;
	private String  templetId;
	private String  indicatorId;
	private Set<PmIndexBasic> pmIndexBasics = null;// new ArrayList<PmIndexBasic>();

	// Constructors
	/** default constructor */
	public PmIndexType() {
	}
	/** minimal constructor */
	public PmIndexType(
		String indexId		
		,String  templetId,String  indicatorId) {
	
	
		this.indexId = indexId;		
	
		this.templetId= templetId; 
		this.indicatorId= indicatorId; 		
	}

/** full constructor */
	public PmIndexType(
	 String indexId		
	,String  indexname,String  evlType,String  templetId,String  indicatorId) {
	
	
		this.indexId = indexId;		
	
		this.indexname= indexname;
		this.evlType= evlType;
		this.templetId= templetId;
		this.indicatorId= indicatorId;		
	}
	

  
	public String getIndexId() {
		return this.indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	// Property accessors
  
	public String getIndexname() {
		return this.indexname;
	}
	
	public void setIndexname(String indexname) {
		this.indexname = indexname;
	}
  
	public String getEvlType() {
		return this.evlType;
	}
	
	public void setEvlType(String evlType) {
		this.evlType = evlType;
	}
  
	public String getTempletId() {
		return this.templetId;
	}
	
	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}
  
	public String getIndicatorId() {
		return this.indicatorId;
	}
	
	public void setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
	}


	public Set<PmIndexBasic> getPmIndexBasics(){
		if(this.pmIndexBasics==null)
			this.pmIndexBasics = new HashSet<PmIndexBasic>();
		return this.pmIndexBasics;
	}

	public void setPmIndexBasics(Set<PmIndexBasic> pmIndexBasics) {
		this.pmIndexBasics = pmIndexBasics;
	}	

	public void addPmIndexBasic(PmIndexBasic pmIndexBasic ){
		if (this.pmIndexBasics==null)
			this.pmIndexBasics = new HashSet<PmIndexBasic>();
		this.pmIndexBasics.add(pmIndexBasic);
	}
	
	public void removePmIndexBasic(PmIndexBasic pmIndexBasic ){
		if (this.pmIndexBasics==null)
			return;
		this.pmIndexBasics.remove(pmIndexBasic);
	}
	
	public PmIndexBasic newPmIndexBasic(){
		PmIndexBasic res = new PmIndexBasic();
  
		res.setIndexId(this.getIndexId());

		return res;
	}
	/**
	 * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不�?��的问�?
	 * 
	 */
	public void replacePmIndexBasics(List<PmIndexBasic> pmIndexBasics) {
		List<PmIndexBasic> newObjs = new ArrayList<PmIndexBasic>();
		for(PmIndexBasic p :pmIndexBasics){
			if(p==null)
				continue;
			PmIndexBasic newdt = newPmIndexBasic();
			newdt.copyNotNullProperty(p);
			newObjs.add(newdt);
		}
		//delete
		boolean found = false;
		Set<PmIndexBasic> oldObjs = new HashSet<PmIndexBasic>();
		oldObjs.addAll(getPmIndexBasics());
		
		for(Iterator<PmIndexBasic> it=oldObjs.iterator(); it.hasNext();){
			PmIndexBasic odt = it.next();
			found = false;
			for(PmIndexBasic newdt :newObjs){
				if(odt.getRangeId().equals( newdt.getRangeId())){
					found = true;
					break;
				}
			}
			if(! found)
				removePmIndexBasic(odt);
		}
		oldObjs.clear();
		//insert or update
		for(PmIndexBasic newdt :newObjs){
			found = false;
			for(Iterator<PmIndexBasic> it=getPmIndexBasics().iterator();
			 it.hasNext();){
				PmIndexBasic odt = it.next();
				if(odt.getRangeId().equals( newdt.getRangeId())){
					odt.copy(newdt);
					found = true;
					break;
				}
			}
			if(! found)
				addPmIndexBasic(newdt);
		} 	
	}	


	public void copy(PmIndexType other){
  
		this.setIndexId(other.getIndexId());
  
		this.indexname= other.getIndexname();  
		this.evlType= other.getEvlType();  
		this.templetId= other.getTempletId();  
		this.indicatorId= other.getIndicatorId();
	
		this.pmIndexBasics = other.getPmIndexBasics();
	}
	
	public void copyNotNullProperty(PmIndexType other){
  
	if( other.getIndexId() != null)
		this.setIndexId(other.getIndexId());
  
		if( other.getIndexname() != null)
			this.indexname= other.getIndexname();  
		if( other.getEvlType() != null)
			this.evlType= other.getEvlType();  
		if( other.getTempletId() != null)
			this.templetId= other.getTempletId();  
		if( other.getIndicatorId() != null)
			this.indicatorId= other.getIndicatorId();
	
		this.pmIndexBasics = other.getPmIndexBasics();
	}
	public void copyNotNullProperty(PmIndexTypeLog other){
		  
		if( other.getIndexId() != null)
			this.setIndexId(other.getIndexId());
	  
			if( other.getIndexname() != null)
				this.indexname= other.getIndexname();  
			if( other.getEvlType() != null)
				this.evlType= other.getEvlType();  
			if( other.getTempletId() != null)
				this.templetId= other.getTempletId();  
			if( other.getIndicatorId() != null)
				this.indicatorId= other.getIndicatorId();
		
//			this.pmIndexBasics = other.getPmIndexBasics();
		}
	
	public void clearProperties(){
  
		this.indexname= null;  
		this.evlType= null;  
		this.templetId= null;  
		this.indicatorId= null;
	
		this.pmIndexBasics = new HashSet<PmIndexBasic>();
	}
	public String getIndicatorName() {
		return indicatorName;
	}
	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}
}
