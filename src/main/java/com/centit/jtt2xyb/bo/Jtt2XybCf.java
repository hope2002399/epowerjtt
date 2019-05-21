package com.centit.jtt2xyb.bo;

import java.util.Date;

public class Jtt2XybCf {
	   private String cfwsh;
	   private String cfajmc;
	   private String cfsy;
	   private String cfzl;
	   private String cfzl2;
	   private String cfyj;
	   
	   private String cfxdr;
	   private String cfxdrshxym;
	   private String cfxdrzdm;
	   private String cfxdrgsdj;
	   private String cfxdrswdj;
	   private String cfxdrsfz;
	   
	   private String cffr;
	   private String cfjg;
	   private Date cfsxq;
	   private Date cfjzq;
	   private String cfxzjg;
	   private String cfzt;
	   private String dfbm;
	   private Date sjc;
	   private String bz;
	   private String cfbm;
	   private String cfsyfw;
	   private String cfsxyzcd;
	   private Date cfgsjzq;
	public String getCfwsh() {
		return cfwsh;
	}
	public void setCfwsh(String cfwsh) {
		this.cfwsh = cfwsh;
	}
	public String getCfajmc() {
		return cfajmc;
	}
	public void setCfajmc(String cfajmc) {
		this.cfajmc = cfajmc;
	}
	public String getCfsy() {
		return cfsy;
	}
	public void setCfsy(String cfsy) {
		this.cfsy = cfsy;
	}
	public String getCfzl() {
		return cfzl;
	}
	public void setCfzl(String cfzl) {
		this.cfzl = cfzl;
	}
	public String getCfzl2() {
		return cfzl2;
	}
	public void setCfzl2(String cfzl2) {
		this.cfzl2 = cfzl2;
	}
	public String getCfyj() {
		return cfyj;
	}
	public void setCfyj(String cfyj) {
		this.cfyj = cfyj;
	}
	public String getCfxdr() {
		return cfxdr;
	}
	public void setCfxdr(String cfxdr) {
		this.cfxdr = cfxdr;
	}
	public String getCfxdrshxym() {
		return cfxdrshxym;
	}
	public void setCfxdrshxym(String cfxdrshxym) {
		this.cfxdrshxym = cfxdrshxym;
	}
	public String getCfxdrzdm() {
		return cfxdrzdm;
	}
	public void setCfxdrzdm(String cfxdrzdm) {
		this.cfxdrzdm = cfxdrzdm;
	}
	public String getCfxdrgsdj() {
		return cfxdrgsdj;
	}
	public void setCfxdrgsdj(String cfxdrgsdj) {
		this.cfxdrgsdj = cfxdrgsdj;
	}
	public String getCfxdrswdj() {
		return cfxdrswdj;
	}
	public void setCfxdrswdj(String cfxdrswdj) {
		this.cfxdrswdj = cfxdrswdj;
	}
	public String getCfxdrsfz() {
		String birthday ="";
		String temp="********";
		if(cfxdrsfz!=null&&!"".equals(cfxdrsfz)&&cfxdrsfz.length()==18){
			 birthday =cfxdrsfz.substring(6, 14);
			 return cfxdrsfz.replace(birthday, temp);
		}
		return cfxdrsfz;
	}
	public void setCfxdrsfz(String cfxdrsfz) {
		this.cfxdrsfz = cfxdrsfz;
	}
	public String getCffr() {
		return cffr;
	}
	public void setCffr(String cffr) {
		this.cffr = cffr;
	}
	public Date getCfsxq() {
		return cfsxq;
	}
	public void setCfsxq(Date cfsxq) {
		this.cfsxq = cfsxq;
	}
	public Date getCfjzq() {
		return cfjzq;
	}
	public void setCfjzq(Date cfjzq) {
		this.cfjzq = cfjzq;
	}
	public String getCfxzjg() {
		return cfxzjg;
	}
	public void setCfxzjg(String cfxzjg) {
		this.cfxzjg = cfxzjg;
	}
	public String getCfzt() {
		return cfzt;
	}
	public void setCfzt(String cfzt) {
		this.cfzt = cfzt;
	}
	public String getDfbm() {
		return dfbm;
	}
	public void setDfbm(String dfbm) {
		this.dfbm = dfbm;
	}
	public Date getSjc() {
		return sjc;
	}
	public void setSjc(Date sjc) {
		this.sjc = sjc;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getCfbm() {
		return cfbm;
	}
	public void setCfbm(String cfbm) {
		this.cfbm = cfbm;
	}
	public String getCfsyfw() {
		return cfsyfw;
	}
	public void setCfsyfw(String cfsyfw) {
		this.cfsyfw = cfsyfw;
	}
	public String getCfsxyzcd() {
		return cfsxyzcd;
	}
	public void setCfsxyzcd(String cfsxyzcd) {
		this.cfsxyzcd = cfsxyzcd;
	}
	public Date getCfgsjzq() {
		return cfgsjzq;
	}
	public void setCfgsjzq(Date cfgsjzq) {
		this.cfgsjzq = cfgsjzq;
	}
	public String getCfjg() {
		return cfjg;
	}
	public void setCfjg(String cfjg) {
		this.cfjg = cfjg;
	}
	   
}
