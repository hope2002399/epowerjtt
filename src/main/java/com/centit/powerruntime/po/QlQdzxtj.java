package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */ 

public class QlQdzxtj implements java.io.Serializable {
	private static final long serialVersionUID =  1L;


	private String orgname;

	private String  jtcode;
	private String  xzxk;
	private String  xzcf;
	private String  xzqz;
	private String  xzzs;
	private String  xzjf;
	private String  xzjl;
	private String  xzqr;
	private String  xzcj;
	private String  xzzy;
	private String  qt;
	private String  pjtcode;
	
    public String getPjtcode() {
        return pjtcode;
    }
    public void setPjtcode(String pjtcode) {
        this.pjtcode = pjtcode;
    }
    public String getOrgname() {
        return orgname;
    }
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
    public String getJtcode() {
        return jtcode;
    }
    public void setJtcode(String jtcode) {
        this.jtcode = jtcode;
    }
    public String getXzxk() {
        return xzxk;
    }
    public void setXzxk(String xzxk) {
        this.xzxk = xzxk;
    }
    public String getXzcf() {
        return xzcf;
    }
    public void setXzcf(String xzcf) {
        this.xzcf = xzcf;
    }
    public String getXzqz() {
        return xzqz;
    }
    public void setXzqz(String xzqz) {
        this.xzqz = xzqz;
    }
    public String getXzzs() {
        return xzzs;
    }
    public void setXzzs(String xzzs) {
        this.xzzs = xzzs;
    }
    public String getXzjf() {
        return xzjf;
    }
    public void setXzjf(String xzjf) {
        this.xzjf = xzjf;
    }
    public String getXzjl() {
        return xzjl;
    }
    public void setXzjl(String xzjl) {
        this.xzjl = xzjl;
    }
    public String getXzqr() {
        return xzqr;
    }
    public void setXzqr(String xzqr) {
        this.xzqr = xzqr;
    }
    public String getXzcj() {
        return xzcj;
    }
    public void setXzcj(String xzcj) {
        this.xzcj = xzcj;
    }
    public String getXzzy() {
        return xzzy;
    }
    public void setXzzy(String xzzy) {
        this.xzzy = xzzy;
    }
    public String getQt() {
        return qt;
    }
    public void setQt(String qt) {
        this.qt = qt;
    }
    public void copyNotNullProperty(QlQdzxsxtj other) {
        if (other.getOrgname() != null)
            this.setOrgname(other.getOrgname());

        if (other.getQt() != null)
            this.setQt(other.getQt());
        if (other.getXzcf() != null)
            this.setXzcf(other.getXzcf());
        if (other.getXzcj() != null)
            this.setXzcj(other.getXzcj());
        if (other.getXzjf() != null)
            this.setXzjf(other.getXzjf());
        if (other.getXzjl() != null)
            this.setXzjl(other.getXzjl());
        if (other.getXzqr() != null)
            this.setXzqr(other.getXzqr());
        if (other.getXzqz() != null)
            this.setXzqz(other.getXzqz());
        if (other.getXzxk() != null)
            this.setXzxk(other.getXzxk());
        if (other.getXzzs() != null)
            this.setXzzs(other.getXzzs());
        if (other.getXzzy() != null)
            this.setXzzy(other.getXzzy());
        
    }


}
