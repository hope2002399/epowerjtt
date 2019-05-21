package com.centit.powerruntime.po;

import java.util.List;
import java.util.Map;


/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class VLicensesSub implements java.io.Serializable {
	private static final long serialVersionUID =  1L;

	private String cid;
	private String  orgcode;
	private String  orgname;
	private String  zzName;
	private String  sl;
	
	
    public String getCid() {
        return cid;
    }


    public void setCid(String cid) {
        this.cid = cid;
    }


    // Constructors
	/** default constructor */
	public VLicensesSub() {
	}


    public String getOrgcode() {
        return orgcode;
    }


    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }


    public String getOrgname() {
        return orgname;
    }


    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }


    public String getZzName() {
        return zzName;
    }


    public void setZzName(String zzName) {
        this.zzName = zzName;
    }


    public String getSl() {
        return sl;
    }


    public void setSl(String sl) {
        this.sl = sl;
    }

 
}
