package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class DeptStInf implements java.io.Serializable {
	private static final long serialVersionUID =  1L;

 
	private String  iddeptQlInf;
	private String  updateType;
	private String  deptQlParentId;
	private String  qlRegNo;
	private String  deptQlRegNo;
	private String  qlName;
	private String  deptId;
	private String  deptAreano;
	private String  hiLevel;
    private String  topiddeptQlInf;
    private String  zxs;
    private String orgshortname;
    private String qlKind;
    
    private String orgname1;
    private String orgname2;
    
    
	public String getOrgname1() {
        return orgname1;
    }
    public void setOrgname1(String orgname1) {
        this.orgname1 = orgname1;
    }
    public String getOrgname2() {
        return orgname2;
    }
    public void setOrgname2(String orgname2) {
        this.orgname2 = orgname2;
    }
    // Constructors
	/** default constructor */
	public DeptStInf() {
	}
	/** minimal constructor */

  
	public String getIddeptQlInf() {
		return this.iddeptQlInf;
	}

	public String getQlKind() {
        return qlKind;
    }
    public void setQlKind(String qlKind) {
        this.qlKind = qlKind;
    }
    public String getZxs() {
        return zxs;
    }
    public void setZxs(String zxs) {
        this.zxs = zxs;
    }
    public void setIddeptQlInf(String iddeptQlInf) {
		this.iddeptQlInf = iddeptQlInf;
	}
	// Property accessors
  
	public String getUpdateType() {
		return this.updateType;
	}
	
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
  
	public String getDeptQlParentId() {
		return this.deptQlParentId;
	}
	
	public void setDeptQlParentId(String deptQlParentId) {
		this.deptQlParentId = deptQlParentId;
	}
  
  
	public String getOrgshortname() {
        return orgshortname;
    }
    public void setOrgshortname(String orgshortname) {
        this.orgshortname = orgshortname;
    }
    public String getQlRegNo() {
		return this.qlRegNo;
	}
	
	public void setQlRegNo(String qlRegNo) {
		this.qlRegNo = qlRegNo;
	}
  
	public String getDeptQlRegNo() {
		return this.deptQlRegNo;
	}
	
	public void setDeptQlRegNo(String deptQlRegNo) {
		this.deptQlRegNo = deptQlRegNo;
	}
  
	public String getQlName() {
		return this.qlName;
	}
	
	public void setQlName(String qlName) {
		this.qlName = qlName;
	}
	public String getDeptId() {
		return this.deptId;
	}
	
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
    public String getDeptAreano() {
        return deptAreano;
    }
    public void setDeptAreano(String deptAreano) {
        this.deptAreano = deptAreano;
    }
    public String getHiLevel() {
        return hiLevel;
    }
    public void setHiLevel(String hiLevel) {
        this.hiLevel = hiLevel;
    }
    public String getTopiddeptQlInf() {
        return topiddeptQlInf;
    }
    public void setTopiddeptQlInf(String topiddeptQlInf) {
        this.topiddeptQlInf = topiddeptQlInf;
    }
  
}
