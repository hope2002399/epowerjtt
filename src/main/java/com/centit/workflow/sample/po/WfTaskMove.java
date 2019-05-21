package com.centit.workflow.sample.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfTaskMove implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long moveno;

    private String olduser;
    private String newuser;
    private String moveDesc;
    private String operuser;
    private Date operdate;

    // Constructors
    /** default constructor */
    public WfTaskMove() {
    }

    /** minimal constructor */
    public WfTaskMove(Long moveno) {

        this.moveno = moveno;

    }

    /** full constructor */
    public WfTaskMove(Long moveno, String olduser, String newuser,
            String moveDesc, String operuser, Date operdate) {

        this.moveno = moveno;

        this.olduser = olduser;
        this.newuser = newuser;
        this.moveDesc = moveDesc;
        this.operuser = operuser;
        this.operdate = operdate;
    }

    public Long getMoveno() {
        return this.moveno;
    }

    public void setMoveno(Long moveno) {
        this.moveno = moveno;
    }

    // Property accessors

    public String getOlduser() {
        return this.olduser;
    }

    public void setOlduser(String olduser) {
        this.olduser = olduser;
    }

    public String getNewuser() {
        return this.newuser;
    }

    public void setNewuser(String newuser) {
        this.newuser = newuser;
    }

    public String getMoveDesc() {
        return this.moveDesc;
    }

    public void setMoveDesc(String moveDesc) {
        this.moveDesc = moveDesc;
    }

    public String getOperuser() {
        return this.operuser;
    }

    public void setOperuser(String operuser) {
        this.operuser = operuser;
    }

    public Date getOperdate() {
        return this.operdate;
    }

    public void setOperdate(Date operdate) {
        this.operdate = operdate;
    }

    public void copy(WfTaskMove other) {

        this.setMoveno(other.getMoveno());

        this.olduser = other.getOlduser();
        this.newuser = other.getNewuser();
        this.moveDesc = other.getMoveDesc();
        this.operuser = other.getOperuser();
        this.operdate = other.getOperdate();

    }

    public void copyNotNullProperty(WfTaskMove other) {

        if (other.getMoveno() != null)
            this.setMoveno(other.getMoveno());

        if (other.getOlduser() != null)
            this.olduser = other.getOlduser();
        if (other.getNewuser() != null)
            this.newuser = other.getNewuser();
        if (other.getMoveDesc() != null)
            this.moveDesc = other.getMoveDesc();
        if (other.getOperuser() != null)
            this.operuser = other.getOperuser();
        if (other.getOperdate() != null)
            this.operdate = other.getOperdate();

    }

    public void clearProperties() {

        this.olduser = null;
        this.newuser = null;
        this.moveDesc = null;
        this.operuser = null;
        this.operdate = null;

    }
}
