package com.centit.punish.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poapprovebasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private Long poapprovestep;
    private Long ispass;

    // Constructors
    /** default constructor */
    public Poapprovebasic() {
    }

    /** minimal constructor */
    public Poapprovebasic(String punishobjectid, Long poapprovestep, Long ispass) {

        this.punishobjectid = punishobjectid;

        this.poapprovestep = poapprovestep;
        this.ispass = ispass;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public Long getPoapprovestep() {
        return this.poapprovestep;
    }

    public void setPoapprovestep(Long poapprovestep) {
        this.poapprovestep = poapprovestep;
    }

    public Long getIspass() {
        return this.ispass;
    }

    public void setIspass(Long ispass) {
        this.ispass = ispass;
    }

    public void copy(Poapprovebasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.poapprovestep = other.getPoapprovestep();
        this.ispass = other.getIspass();

    }

    public void copyNotNullProperty(Poapprovebasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getPoapprovestep() != null)
            this.poapprovestep = other.getPoapprovestep();
        if (other.getIspass() != null)
            this.ispass = other.getIspass();

    }

    public void clearProperties() {

        this.poapprovestep = null;
        this.ispass = null;

    }
}
