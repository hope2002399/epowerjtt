package com.centit.jtt2xyb.bo;

import java.util.Date;

public class Jtt2XybXk {
   private String xkwsh;
   private String xkxmmc;
   private String xksplb;
   private String xknr;
   
   private String xkxdr;
   private String xkxdrshxym;
   private String xkxdrzdm;
   private String xkxdrgsdj;
   private String xkxdrswdj;
   private String xkxdrsfz;
   
   private String xkfr;
   private Date xksxq;
   private Date xkjzq;
   private String xkxzjg;
   private String xkzt;
   private String dfbm;
   private Date sjc;
   private String bz;
   private String xkbm;
   private String xksyfw;
public String getXkwsh() {
	return xkwsh;
}
public void setXkwsh(String xkwsh) {
	this.xkwsh = xkwsh;
}
public String getXkxmmc() {
	return xkxmmc;
}
public void setXkxmmc(String xkxmmc) {
	this.xkxmmc = xkxmmc;
}
public String getXksplb() {
	return xksplb;
}
public void setXksplb(String xksplb) {
	this.xksplb = xksplb;
}
public String getXknr() {
	return xknr;
}
public void setXknr(String xknr) {
	this.xknr = xknr;
}
public String getXkxdr() {
	return xkxdr;
}
public void setXkxdr(String xkxdr) {
	this.xkxdr = xkxdr;
}
public String getXkxdrshxym() {
	return xkxdrshxym;
}
public void setXkxdrshxym(String xkxdrshxym) {
	this.xkxdrshxym = xkxdrshxym;
}
public String getXkxdrzdm() {
	return xkxdrzdm;
}
public void setXkxdrzdm(String xkxdrzdm) {
	this.xkxdrzdm = xkxdrzdm;
}
public String getXkxdrgsdj() {
	return xkxdrgsdj;
}
public void setXkxdrgsdj(String xkxdrgsdj) {
	this.xkxdrgsdj = xkxdrgsdj;
}
public String getXkxdrswdj() {
	return xkxdrswdj;
}
public void setXkxdrswdj(String xkxdrswdj) {
	this.xkxdrswdj = xkxdrswdj;
}
public String getXkxdrsfz() {
	String birthday ="";
	String temp="********";
	if(xkxdrsfz!=null&&!"".equals(xkxdrsfz)&&xkxdrsfz.length()==18){
		 birthday =xkxdrsfz.substring(6, 14);
		 return xkxdrsfz.replace(birthday, temp);
	}
	return xkxdrsfz;
}
public void setXkxdrsfz(String xkxdrsfz) {
	this.xkxdrsfz = xkxdrsfz;
}
public String getXkfr() {
	return xkfr;
}
public void setXkfr(String xkfr) {
	this.xkfr = xkfr;
}
public Date getXksxq() {
	return xksxq;
}

public void setXksxq(Date xksxq) {
	this.xksxq = xksxq;
}
public Date getXkjzq() {
	return xkjzq;
}
public void setXkjzq(Date xkjzq) {
	this.xkjzq = xkjzq;
}
public String getXkxzjg() {
	return xkxzjg;
}
public void setXkxzjg(String xkxzjg) {
	this.xkxzjg = xkxzjg;
}
public String getXkzt() {
	return xkzt;
}
public void setXkzt(String xkzt) {
	this.xkzt = xkzt;
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
public String getXkbm() {
	return xkbm;
}
public void setXkbm(String xkbm) {
	this.xkbm = xkbm;
}
public String getXksyfw() {
	return xksyfw;
}
public void setXksyfw(String xksyfw) {
	this.xksyfw = xksyfw;
}
   
}
