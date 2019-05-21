package com.centit.powerbase.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Lawsuit implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String lawsuitno;

    private Date lawsuitdate;
    private String lawsuitapplyunit;
    private String lawsuitdep;
    private Date lawsuitenddate;
    private Long lawsuitresult;
    private String lawsuitremark;
    private String bookoperator;
    private Date bookdate;

    // Constructors
    /** default constructor */
    public Lawsuit() {
    }

    /** minimal constructor */
    public Lawsuit(String lawsuitno) {

        this.lawsuitno = lawsuitno;

    }

    /** full constructor */
    public Lawsuit(String lawsuitno, Date lawsuitdate, String lawsuitapplyunit,
            String lawsuitdep, Date lawsuitenddate, Long lawsuitresult,
            String lawsuitremark, String bookoperator, Date bookdate) {

        this.lawsuitno = lawsuitno;

        this.lawsuitdate = lawsuitdate;
        this.lawsuitapplyunit = lawsuitapplyunit;
        this.lawsuitdep = lawsuitdep;
        this.lawsuitenddate = lawsuitenddate;
        this.lawsuitresult = lawsuitresult;
        this.lawsuitremark = lawsuitremark;
        this.bookoperator = bookoperator;
        this.bookdate = bookdate;
    }

    public String getLawsuitno() {
        return this.lawsuitno;
    }

    public void setLawsuitno(String lawsuitno) {
        this.lawsuitno = lawsuitno;
    }

    // Property accessors

    public Date getLawsuitdate() {
        return this.lawsuitdate;
    }

    public void setLawsuitdate(Date lawsuitdate) {
        this.lawsuitdate = lawsuitdate;
    }

    public String getLawsuitapplyunit() {
        return this.lawsuitapplyunit;
    }

    public void setLawsuitapplyunit(String lawsuitapplyunit) {
        this.lawsuitapplyunit = lawsuitapplyunit;
    }

    public String getLawsuitdep() {
        return this.lawsuitdep;
    }

    public void setLawsuitdep(String lawsuitdep) {
        this.lawsuitdep = lawsuitdep;
    }

    public Date getLawsuitenddate() {
        return this.lawsuitenddate;
    }

    public void setLawsuitenddate(Date lawsuitenddate) {
        this.lawsuitenddate = lawsuitenddate;
    }

    public Long getLawsuitresult() {
        return this.lawsuitresult;
    }

    public void setLawsuitresult(Long lawsuitresult) {
        this.lawsuitresult = lawsuitresult;
    }

    public String getLawsuitremark() {
        return this.lawsuitremark;
    }

    public void setLawsuitremark(String lawsuitremark) {
        this.lawsuitremark = lawsuitremark;
    }

    public String getBookoperator() {
        return this.bookoperator;
    }

    public void setBookoperator(String bookoperator) {
        this.bookoperator = bookoperator;
    }

    public Date getBookdate() {
        return this.bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

    public void copy(Lawsuit other) {

        this.setLawsuitno(other.getLawsuitno());

        this.lawsuitdate = other.getLawsuitdate();
        this.lawsuitapplyunit = other.getLawsuitapplyunit();
        this.lawsuitdep = other.getLawsuitdep();
        this.lawsuitenddate = other.getLawsuitenddate();
        this.lawsuitresult = other.getLawsuitresult();
        this.lawsuitremark = other.getLawsuitremark();
        this.bookoperator = other.getBookoperator();
        this.bookdate = other.getBookdate();

    }

    public void copyNotNullProperty(Lawsuit other) {

        if (other.getLawsuitno() != null)
            this.setLawsuitno(other.getLawsuitno());

        if (other.getLawsuitdate() != null)
            this.lawsuitdate = other.getLawsuitdate();
        if (other.getLawsuitapplyunit() != null)
            this.lawsuitapplyunit = other.getLawsuitapplyunit();
        if (other.getLawsuitdep() != null)
            this.lawsuitdep = other.getLawsuitdep();
        if (other.getLawsuitenddate() != null)
            this.lawsuitenddate = other.getLawsuitenddate();
        if (other.getLawsuitresult() != null)
            this.lawsuitresult = other.getLawsuitresult();
        if (other.getLawsuitremark() != null)
            this.lawsuitremark = other.getLawsuitremark();
        if (other.getBookoperator() != null)
            this.bookoperator = other.getBookoperator();
        if (other.getBookdate() != null)
            this.bookdate = other.getBookdate();

    }

    public void clearProperties() {

        this.lawsuitdate = null;
        this.lawsuitapplyunit = null;
        this.lawsuitdep = null;
        this.lawsuitenddate = null;
        this.lawsuitresult = null;
        this.lawsuitremark = null;
        this.bookoperator = null;
        this.bookdate = null;

    }
}
