package com.centit.powerruntime.po;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;


/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class LicensesSub implements java.io.Serializable {
	private static final long serialVersionUID =  1L;

	private String  orgname;
	
	private List<Map<String, Object>> ListOrgname;
	
    // Constructors
	/** default constructor */
	public LicensesSub() {
	}

	

    public List<Map<String, Object>> getListOrgname() {
        return ListOrgname;
    }



    public void setListOrgname(List<Map<String, Object>> listOrgname) {
        ListOrgname = listOrgname;
    }



    public String getOrgname() {
        return orgname;
    }



    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

 
}
