package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Appindividual implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String individualid;

    private String individualname;
    private String individualcode;
    private String sex;
    private Long age;
    private String individualadress;
    private String workunit;
    private String postcode;
    private String phone;
    private String email;
    private Date lastusedate;

    public Date getLastusedate() {
        return lastusedate;
    }

    public void setLastusedate(Date lastusedate) {
        this.lastusedate = lastusedate;
    }

    // Constructors
    /** default constructor */
    public Appindividual() {
    }

    /** minimal constructor */
    public Appindividual(String individualid, String individualname) {

        this.individualid = individualid;

        this.individualname = individualname;
    }

    /** full constructor */
    public Appindividual(String individualid, String individualname,
            String individualcode, String sex, Long age,
            String individualadress, String workunit, String postcode,
            String phone, String email) {

        this.individualid = individualid;

        this.individualname = individualname;
        this.individualcode = individualcode;
        this.sex = sex;
        this.age = age;
        this.individualadress = individualadress;
        this.workunit = workunit;
        this.postcode = postcode;
        this.phone = phone;
        this.email = email;
    }

    public String getIndividualid() {
        return this.individualid;
    }

    public void setIndividualid(String individualid) {
        this.individualid = individualid;
    }

    // Property accessors

    public String getIndividualname() {
        return this.individualname;
    }

    public void setIndividualname(String individualname) {
        this.individualname = individualname;
    }

    public String getIndividualcode() {
        return this.individualcode;
    }

    public void setIndividualcode(String individualcode) {
        this.individualcode = individualcode;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getAge() {
        return this.age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getIndividualadress() {
        return this.individualadress;
    }

    public void setIndividualadress(String individualadress) {
        this.individualadress = individualadress;
    }

    public String getWorkunit() {
        return this.workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void copy(Appindividual other) {

        this.setIndividualid(other.getIndividualid());

        this.individualname = other.getIndividualname();
        this.individualcode = other.getIndividualcode();
        this.sex = other.getSex();
        this.age = other.getAge();
        this.individualadress = other.getIndividualadress();
        this.workunit = other.getWorkunit();
        this.postcode = other.getPostcode();
        this.phone = other.getPhone();
        this.email = other.getEmail();

    }

    public void copyNotNullProperty(Appindividual other) {

        if (other.getIndividualid() != null)
            this.setIndividualid(other.getIndividualid());

        if (other.getIndividualname() != null)
            this.individualname = other.getIndividualname();
        if (other.getIndividualcode() != null)
            this.individualcode = other.getIndividualcode();
        if (other.getSex() != null)
            this.sex = other.getSex();
        if (other.getAge() != null)
            this.age = other.getAge();
        if (other.getIndividualadress() != null)
            this.individualadress = other.getIndividualadress();
        if (other.getWorkunit() != null)
            this.workunit = other.getWorkunit();
        if (other.getPostcode() != null)
            this.postcode = other.getPostcode();
        if (other.getPhone() != null)
            this.phone = other.getPhone();
        if (other.getEmail() != null)
            this.email = other.getEmail();

    }

    public void clearProperties() {

        this.individualname = null;
        this.individualcode = null;
        this.sex = null;
        this.age = null;
        this.individualadress = null;
        this.workunit = null;
        this.postcode = null;
        this.phone = null;
        this.email = null;

    }

    public void copyNotNullPropertyFromPoindividual(Poindividual other) {
        if (other.getIndividualname() != null)
            this.individualname = other.getIndividualname();
        if (other.getIndividualcode() != null)
            this.individualcode = other.getIndividualcode();
        if (other.getSex() != null)
            this.sex = other.getSex();
        if (other.getAge() != null)
            this.age = other.getAge();
        if (other.getIndividualadress() != null)
            this.individualadress = other.getIndividualadress();
        if (other.getWorkunit() != null)
            this.workunit = other.getWorkunit();
        if (other.getPostcode() != null)
            this.postcode = other.getPostcode();
        if (other.getPhone() != null)
            this.phone = other.getPhone();
        if (other.getEmail() != null)
            this.email = other.getEmail();
    }
}
