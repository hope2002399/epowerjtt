package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class OptPickupMessage implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String pickupid;

	private String  rcvname;
	private String  rcvprov;
	private String  rcvcity;
	private String  rcvcountry;
	private String  rcvstrect;
	private String  rcvphone;
	private String  rcvcall;
	private String  rcvpostcode;
	private String djid;

	// Constructors
	/** default constructor */
	public OptPickupMessage() {
	}
	/** minimal constructor */
	public OptPickupMessage(
		String pickupid		
		) {
	
	
		this.pickupid = pickupid;		
			
	}

/** full constructor */
	public OptPickupMessage(
	 String pickupid		
	,String  rcvname,String  rcvprov,String  rcvcity,String  rcvcountry,String  rcvstrect,String  rcvphone,String  rcvcall,String  rcvpostcode,String djid) {
	
	
		this.pickupid = pickupid;		
	
		this.rcvname= rcvname;
		this.rcvprov= rcvprov;
		this.rcvcity= rcvcity;
		this.rcvcountry= rcvcountry;
		this.rcvstrect= rcvstrect;
		this.rcvphone= rcvphone;
		this.rcvcall= rcvcall;
		this.rcvpostcode= rcvpostcode;	
		this.djid=djid;
	}
	

  
	public String getPickupid() {
		return this.pickupid;
	}

	public void setPickupid(String pickupid) {
		this.pickupid = pickupid;
	}
	// Property accessors
  
	public String getRcvname() {
		return this.rcvname;
	}
	
	public void setRcvname(String rcvname) {
		this.rcvname = rcvname;
	}
  
	public String getRcvprov() {
		return this.rcvprov;
	}
	
	public void setRcvprov(String rcvprov) {
		this.rcvprov = rcvprov;
	}
  
	public String getRcvcity() {
		return this.rcvcity;
	}
	
	public void setRcvcity(String rcvcity) {
		this.rcvcity = rcvcity;
	}
  
	public String getRcvcountry() {
		return this.rcvcountry;
	}
	
	public void setRcvcountry(String rcvcountry) {
		this.rcvcountry = rcvcountry;
	}
  
	public String getRcvstrect() {
		return this.rcvstrect;
	}
	
	public void setRcvstrect(String rcvstrect) {
		this.rcvstrect = rcvstrect;
	}
  
	public String getRcvphone() {
		return this.rcvphone;
	}
	
	public void setRcvphone(String rcvphone) {
		this.rcvphone = rcvphone;
	}
  
	public String getRcvcall() {
		return this.rcvcall;
	}
	
	public void setRcvcall(String rcvcall) {
		this.rcvcall = rcvcall;
	}
  
	public String getRcvpostcode() {
		return this.rcvpostcode;
	}
	
	public void setRcvpostcode(String rcvpostcode) {
		this.rcvpostcode = rcvpostcode;
	}

	public String getDjid() {
        return djid;
    }
    public void setDjid(String djid) {
        this.djid = djid;
    }
    public void copy(OptPickupMessage other){
  
		this.setPickupid(other.getPickupid());
  
		this.rcvname= other.getRcvname();  
		this.rcvprov= other.getRcvprov();  
		this.rcvcity= other.getRcvcity();  
		this.rcvcountry= other.getRcvcountry();  
		this.rcvstrect= other.getRcvstrect();  
		this.rcvphone= other.getRcvphone();  
		this.rcvcall= other.getRcvcall();  
		this.rcvpostcode= other.getRcvpostcode();
		this.djid = other.getDjid();
	}
	
	public void copyNotNullProperty(OptPickupMessage other){
  
	if( other.getPickupid() != null)
		this.setPickupid(other.getPickupid());
  
		if( other.getRcvname() != null)
			this.rcvname= other.getRcvname();  
		if( other.getRcvprov() != null)
			this.rcvprov= other.getRcvprov();  
		if( other.getRcvcity() != null)
			this.rcvcity= other.getRcvcity();  
		if( other.getRcvcountry() != null)
			this.rcvcountry= other.getRcvcountry();  
		if( other.getRcvstrect() != null)
			this.rcvstrect= other.getRcvstrect();  
		if( other.getRcvphone() != null)
			this.rcvphone= other.getRcvphone();  
		if( other.getRcvcall() != null)
			this.rcvcall= other.getRcvcall();  
		if( other.getRcvpostcode() != null)
			this.rcvpostcode= other.getRcvpostcode();
		if( other.getDjid() != null)
		    this.djid = other.getDjid();

	}
	
	public void clearProperties(){
  
		this.rcvname= null;  
		this.rcvprov= null;  
		this.rcvcity= null;  
		this.rcvcountry= null;  
		this.rcvstrect= null;  
		this.rcvphone= null;  
		this.rcvcall= null;  
		this.rcvpostcode= null;
		this.djid = null;
	}
}
