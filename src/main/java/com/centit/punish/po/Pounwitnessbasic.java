package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

@SuppressWarnings("serial")
public class Pounwitnessbasic implements java.io.Serializable {
    @SuppressWarnings("unused")
    private static final Long serialVersionUID = 1L;

    private String punishobjectid;

    private String pounwitnessreason;
    private Date unwitnessdate;
    private String enregisterid;

    // Constructors
    /** default constructor */
    public Pounwitnessbasic() {
    }

    /** minimal constructor */
    public Pounwitnessbasic(String punishobjectid, Date unwitnessdate,
            String enregisterid) {

        this.punishobjectid = punishobjectid;

        this.unwitnessdate = unwitnessdate;
        this.enregisterid = enregisterid;
    }

    /** full constructor */
    public Pounwitnessbasic(String punishobjectid, String pounwitnessreason,
            Date unwitnessdate, String enregisterid) {

        this.punishobjectid = punishobjectid;

        this.pounwitnessreason = pounwitnessreason;
        this.unwitnessdate = unwitnessdate;
        this.enregisterid = enregisterid;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public String getPounwitnessreason() {
        return this.pounwitnessreason;
    }

    public void setPounwitnessreason(String pounwitnessreason) {
        this.pounwitnessreason = pounwitnessreason;
    }

    public Date getUnwitnessdate() {
        return this.unwitnessdate;
    }

    public void setUnwitnessdate(Date unwitnessdate) {
        this.unwitnessdate = unwitnessdate;
    }

    public String getEnregisterid() {
        return this.enregisterid;
    }

    public void setEnregisterid(String enregisterid) {
        this.enregisterid = enregisterid;
    }

    public void copy(Pounwitnessbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.pounwitnessreason = other.getPounwitnessreason();
        this.unwitnessdate = other.getUnwitnessdate();
        this.enregisterid = other.getEnregisterid();

    }

    public void copyNotNullProperty(Pounwitnessbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getPounwitnessreason() != null)
            this.pounwitnessreason = other.getPounwitnessreason();
        if (other.getUnwitnessdate() != null)
            this.unwitnessdate = other.getUnwitnessdate();
        if (other.getEnregisterid() != null)
            this.enregisterid = other.getEnregisterid();

    }

    public void clearProperties() {

        this.pounwitnessreason = null;
        this.unwitnessdate = null;
        this.enregisterid = null;

    }
}
