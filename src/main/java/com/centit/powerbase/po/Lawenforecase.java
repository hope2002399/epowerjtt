package com.centit.powerbase.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Lawenforecase implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String caseno;

    private String casetitle;
    private String bookoperator;
    private Date bookdate;
    private String orgId;
    private String docName;
    private String fileName;
    private byte[] casedoc;

    private String remark;

    // Constructors
    /** default constructor */
    public Lawenforecase() {
    }

    /** minimal constructor */
    public Lawenforecase(String caseno, String docName, String fileName) {

        this.caseno = caseno;

        this.docName = docName;
        this.fileName = fileName;
    }

    /** full constructor */
    public Lawenforecase(String caseno, String casetitle, String bookoperator,
            Date bookdate, String orgId, String docName, String fileName,
            byte[] casedoc, String remark) {

        this.caseno = caseno;

        this.casetitle = casetitle;
        this.bookoperator = bookoperator;
        this.bookdate = bookdate;
        this.orgId = orgId;
        this.docName = docName;
        this.fileName = fileName;
        this.casedoc = casedoc;
        this.remark = remark;
    }

    public String getCaseno() {
        return this.caseno;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno;
    }

    // Property accessors

    public String getCasetitle() {
        return this.casetitle;
    }

    public void setCasetitle(String casetitle) {
        this.casetitle = casetitle;
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

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getDocName() {
        return this.docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public byte[] getCasedoc() {
        return casedoc;
    }

    public void setCasedoc(byte[] casedoc) {
        this.casedoc = casedoc;
    }

    public void copy(Lawenforecase other) {

        this.setCaseno(other.getCaseno());

        this.casetitle = other.getCasetitle();
        this.bookoperator = other.getBookoperator();
        this.bookdate = other.getBookdate();
        this.orgId = other.getOrgId();
        this.docName = other.getDocName();
        this.fileName = other.getFileName();
        this.casedoc = other.getCasedoc();
        this.remark = other.getRemark();

    }

    public void copyNotNullProperty(Lawenforecase other) {

        if (other.getCaseno() != null)
            this.setCaseno(other.getCaseno());

        if (other.getCasetitle() != null)
            this.casetitle = other.getCasetitle();
        if (other.getBookoperator() != null)
            this.bookoperator = other.getBookoperator();
        if (other.getBookdate() != null)
            this.bookdate = other.getBookdate();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getDocName() != null)
            this.docName = other.getDocName();
        if (other.getFileName() != null)
            this.fileName = other.getFileName();
        if (other.getCasedoc() != null)
            this.casedoc = other.getCasedoc();
        if (other.getRemark() != null)
            this.remark = other.getRemark();

    }

    public void clearProperties() {

        this.casetitle = null;
        this.bookoperator = null;
        this.bookdate = null;
        this.orgId = null;
        this.docName = null;
        this.fileName = null;
        this.casedoc = null;
        this.remark = null;

    }
}
