package com.centit.jtt2xyb.bo;

public class JiaoTongLog{
	private static final long serialVersionUID = 1L;
	private String id;
	private String userid;
	private String fileName;
	private String ip;
	private int dataNum;
	private int drjg;
	private String type;
	private String errormsg;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getDataNum() {
		return dataNum;
	}
	public void setDataNum(int dataNum) {
		this.dataNum = dataNum;
	}
	public int getDrjg() {
		return drjg;
	}
	public void setDrjg(int drjg) {
		this.drjg = drjg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public JiaoTongLog(){}
	
	public JiaoTongLog(String id,String userid,String fileName,String ip,
			int dataNum,int drjg,String type,String errormsg){
		this.id = id;
		this.userid = userid;
		this.fileName = fileName;
		this.ip = ip;
		this.dataNum = dataNum;
		this.drjg = drjg;
		this.errormsg = errormsg;
		this.type = type;
	}

}
