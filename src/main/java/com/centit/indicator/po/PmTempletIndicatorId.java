package com.centit.indicator.po;

import java.util.Date;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */ 

public class PmTempletIndicatorId implements java.io.Serializable {
	private static final long serialVersionUID =  1L;

	private String templetId;

	private String indicatorId;

	// Constructors
	/** default constructor */
	public PmTempletIndicatorId() {
	}
	/** full constructor */
	public PmTempletIndicatorId(String templetId, String indicatorId) {

		this.templetId = templetId;
		this.indicatorId = indicatorId;	
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


	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PmTempletIndicatorId))
			return false;
		
		PmTempletIndicatorId castOther = (PmTempletIndicatorId) other;
		boolean ret = true;
  
		ret = ret && ( this.getTempletId() == castOther.getTempletId() ||
					   (this.getTempletId() != null && castOther.getTempletId() != null
							   && this.getTempletId().equals(castOther.getTempletId())));
  
		ret = ret && ( this.getIndicatorId() == castOther.getIndicatorId() ||
					   (this.getIndicatorId() != null && castOther.getIndicatorId() != null
							   && this.getIndicatorId().equals(castOther.getIndicatorId())));

		return ret;
	}
	
	public int hashCode() {
		int result = 17;
  
		result = 37 * result +
		 	(this.getTempletId() == null ? 0 :this.getTempletId().hashCode());
  
		result = 37 * result +
		 	(this.getIndicatorId() == null ? 0 :this.getIndicatorId().hashCode());
	
		return result;
	}
}
