package com.centit.app.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Publicinfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String infocode;

    private String parentinfocode;
    private String filecode;
    private String infoname;
    private String ownertype;
    private String ownercode;
    private Long readtimes;

    // Constructors
    /** default constructor */
    public Publicinfo() {
    }

    /** minimal constructor */
    public Publicinfo(String infocode, Long readtimes) {

        this.infocode = infocode;

        this.readtimes = readtimes;
    }

    /** full constructor */
    public Publicinfo(String infocode, String parentinfocode, String filecode,
            String infoname, String ownertype, String ownercode, Long readtimes) {

        this.infocode = infocode;

        this.parentinfocode = parentinfocode;
        this.filecode = filecode;
        this.infoname = infoname;
        this.ownertype = ownertype;
        this.ownercode = ownercode;
        this.readtimes = readtimes;
    }

    public String getInfocode() {
        return this.infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    // Property accessors

    public String getParentinfocode() {
        return this.parentinfocode;
    }

    public void setParentinfocode(String parentinfocode) {
        this.parentinfocode = parentinfocode;
    }

    public String getFilecode() {
        return this.filecode;
    }

    public void setFilecode(String filecode) {
        this.filecode = filecode;
    }

    public String getInfoname() {
        return this.infoname;
    }

    public void setInfoname(String infoname) {
        this.infoname = infoname;
    }

    public String getOwnertype() {
        return this.ownertype;
    }

    public void setOwnertype(String ownertype) {
        this.ownertype = ownertype;
    }

    public String getOwnercode() {
        return this.ownercode;
    }

    public void setOwnercode(String ownercode) {
        this.ownercode = ownercode;
    }

    public Long getReadtimes() {
        return this.readtimes;
    }

    public void setReadtimes(Long readtimes) {
        this.readtimes = readtimes;
    }

    public void copy(Publicinfo other) {

        this.setInfocode(other.getInfocode());

        this.parentinfocode = other.getParentinfocode();
        this.filecode = other.getFilecode();
        this.infoname = other.getInfoname();
        this.ownertype = other.getOwnertype();
        this.ownercode = other.getOwnercode();
        this.readtimes = other.getReadtimes();

    }

    public void copyNotNullProperty(Publicinfo other) {

        if (other.getInfocode() != null)
            this.setInfocode(other.getInfocode());

        if (other.getParentinfocode() != null)
            this.parentinfocode = other.getParentinfocode();
        if (other.getFilecode() != null)
            this.filecode = other.getFilecode();
        if (other.getInfoname() != null)
            this.infoname = other.getInfoname();
        if (other.getOwnertype() != null)
            this.ownertype = other.getOwnertype();
        if (other.getOwnercode() != null)
            this.ownercode = other.getOwnercode();
        if (other.getReadtimes() != null)
            this.readtimes = other.getReadtimes();

    }
}
