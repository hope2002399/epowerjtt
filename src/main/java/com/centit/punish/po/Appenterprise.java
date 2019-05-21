package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Appenterprise implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String enterpriseid;

    private String enterprisename;
    private String enterprisecode;
    private String enterpriseaddress;
    private String unittype;
    private String corpdomain;
    private String regtype;
    private String mastername;

    public Date getLastusedate() {
        return lastusedate;
    }

    public void setLastusedate(Date lastusedate) {
        this.lastusedate = lastusedate;
    }

    private String postcode;
    private String phone;
    private String linker;
    private String fax;
    private String email;
    private Long isvip;
    private Date lastusedate;

    // Constructors
    /** default constructor */
    public Appenterprise() {
    }

    /** minimal constructor */
    public Appenterprise(String enterpriseid, String enterprisename) {

        this.enterpriseid = enterpriseid;

        this.enterprisename = enterprisename;
    }

    /** full constructor */
    public Appenterprise(String enterpriseid, String enterprisename,
            String enterprisecode, String enterpriseaddress, String unittype,
            String corpdomain, String regtype, String mastername,
            String postcode, String phone, String linker, String fax,
            String email, Long isvip) {

        this.enterpriseid = enterpriseid;

        this.enterprisename = enterprisename;
        this.enterprisecode = enterprisecode;
        this.enterpriseaddress = enterpriseaddress;
        this.unittype = unittype;
        this.corpdomain = corpdomain;
        this.regtype = regtype;
        this.mastername = mastername;
        this.postcode = postcode;
        this.phone = phone;
        this.linker = linker;
        this.fax = fax;
        this.email = email;
        this.isvip = isvip;
    }

    public String getEnterpriseid() {
        return this.enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    // Property accessors

    public String getEnterprisename() {
        return this.enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getEnterprisecode() {
        return this.enterprisecode;
    }

    public void setEnterprisecode(String enterprisecode) {
        this.enterprisecode = enterprisecode;
    }

    public String getEnterpriseaddress() {
        return this.enterpriseaddress;
    }

    public void setEnterpriseaddress(String enterpriseaddress) {
        this.enterpriseaddress = enterpriseaddress;
    }

    public String getUnittype() {
        return this.unittype;
    }

    public void setUnittype(String unittype) {
        this.unittype = unittype;
    }

    public String getCorpdomain() {
        return this.corpdomain;
    }

    public void setCorpdomain(String corpdomain) {
        this.corpdomain = corpdomain;
    }

    public String getRegtype() {
        return this.regtype;
    }

    public void setRegtype(String regtype) {
        this.regtype = regtype;
    }

    public String getMastername() {
        return this.mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinker() {
        return this.linker;
    }

    public void setLinker(String linker) {
        this.linker = linker;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIsvip() {
        return this.isvip;
    }

    public void setIsvip(Long isvip) {
        this.isvip = isvip;
    }

    public void copy(Appenterprise other) {

        this.setEnterpriseid(other.getEnterpriseid());

        this.enterprisename = other.getEnterprisename();
        this.enterprisecode = other.getEnterprisecode();
        this.enterpriseaddress = other.getEnterpriseaddress();
        this.unittype = other.getUnittype();
        this.corpdomain = other.getCorpdomain();
        this.regtype = other.getRegtype();
        this.mastername = other.getMastername();
        this.postcode = other.getPostcode();
        this.phone = other.getPhone();
        this.linker = other.getLinker();
        this.fax = other.getFax();
        this.email = other.getEmail();
        this.isvip = other.getIsvip();

    }

    public void copyNotNullProperty(Appenterprise other) {

        if (other.getEnterpriseid() != null)
            this.setEnterpriseid(other.getEnterpriseid());

        if (other.getEnterprisename() != null)
            this.enterprisename = other.getEnterprisename();
        if (other.getEnterprisecode() != null)
            this.enterprisecode = other.getEnterprisecode();
        if (other.getEnterpriseaddress() != null)
            this.enterpriseaddress = other.getEnterpriseaddress();
        if (other.getUnittype() != null)
            this.unittype = other.getUnittype();
        if (other.getCorpdomain() != null)
            this.corpdomain = other.getCorpdomain();
        if (other.getRegtype() != null)
            this.regtype = other.getRegtype();
        if (other.getMastername() != null)
            this.mastername = other.getMastername();
        if (other.getPostcode() != null)
            this.postcode = other.getPostcode();
        if (other.getPhone() != null)
            this.phone = other.getPhone();
        if (other.getLinker() != null)
            this.linker = other.getLinker();
        if (other.getFax() != null)
            this.fax = other.getFax();
        if (other.getEmail() != null)
            this.email = other.getEmail();
        if (other.getIsvip() != null)
            this.isvip = other.getIsvip();

    }

    public void clearProperties() {

        this.enterprisename = null;
        this.enterprisecode = null;
        this.enterpriseaddress = null;
        this.unittype = null;
        this.corpdomain = null;
        this.regtype = null;
        this.mastername = null;
        this.postcode = null;
        this.phone = null;
        this.linker = null;
        this.fax = null;
        this.email = null;
        this.isvip = null;

    }

    public void copyNotNullPropertyFromPoenterprise(Poenterprise other) {
        if (other.getEnterprisename() != null)
            this.enterprisename = other.getEnterprisename();
        if (other.getEnterprisecode() != null)
            this.enterprisecode = other.getEnterprisecode();
        if (other.getEnterpriseaddress() != null)
            this.enterpriseaddress = other.getEnterpriseaddress();
        if (other.getUnittype() != null)
            this.unittype = other.getUnittype();
        if (other.getCorpdomain() != null)
            this.corpdomain = other.getCorpdomain();
        if (other.getRegtype() != null)
            this.regtype = other.getRegtype();
        if (other.getMastername() != null)
            this.mastername = other.getMastername();
        if (other.getPostcode() != null)
            this.postcode = other.getPostcode();
        if (other.getPhone() != null)
            this.phone = other.getPhone();
        if (other.getLinker() != null)
            this.linker = other.getLinker();
        if (other.getFax() != null)
            this.fax = other.getFax();
        if (other.getEmail() != null)
            this.email = other.getEmail();
        if (other.getIsvip() != null)
            this.isvip = other.getIsvip();

    }
}
