package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Powitnessbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private Date powitnessdate;
    private Long powitnesstype;
    private String powitnessadress;
    private String powitnessemceename;
    private String powitnessnotername;
    private String investigatename;
    private String investigatedepname;
    private String deputyname;
    private String deputybusiness;
    private String deputydepname;
    private String delegatename;
    private String powitnessmind;
    private String powitnessreason;
    private Date witnessdate;

    // Constructors
    /** default constructor */
    public Powitnessbasic() {
    }

    /** minimal constructor */
    public Powitnessbasic(String punishobjectid, Date powitnessdate,
            Long powitnesstype, Date witnessdate) {

        this.punishobjectid = punishobjectid;

        this.powitnessdate = powitnessdate;
        this.powitnesstype = powitnesstype;
        this.witnessdate = witnessdate;
    }

    /** full constructor */
    public Powitnessbasic(String punishobjectid, Date powitnessdate,
            Long powitnesstype, String powitnessadress,
            String powitnessemceename, String powitnessnotername,
            String investigatename, String investigatedepname,
            String deputyname, String deputybusiness, String deputydepname,
            String delegatename, String powitnessmind, String powitnessreason,
            Date witnessdate) {

        this.punishobjectid = punishobjectid;

        this.powitnessdate = powitnessdate;
        this.powitnesstype = powitnesstype;
        this.powitnessadress = powitnessadress;
        this.powitnessemceename = powitnessemceename;
        this.powitnessnotername = powitnessnotername;
        this.investigatename = investigatename;
        this.investigatedepname = investigatedepname;
        this.deputyname = deputyname;
        this.deputybusiness = deputybusiness;
        this.deputydepname = deputydepname;
        this.delegatename = delegatename;
        this.powitnessmind = powitnessmind;
        this.powitnessreason = powitnessreason;
        this.witnessdate = witnessdate;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public Date getPowitnessdate() {
        return this.powitnessdate;
    }

    public void setPowitnessdate(Date powitnessdate) {
        this.powitnessdate = powitnessdate;
    }

    public Long getPowitnesstype() {
        return this.powitnesstype;
    }

    public void setPowitnesstype(Long powitnesstype) {
        this.powitnesstype = powitnesstype;
    }

    public String getPowitnessadress() {
        return this.powitnessadress;
    }

    public void setPowitnessadress(String powitnessadress) {
        this.powitnessadress = powitnessadress;
    }

    public String getPowitnessemceename() {
        return this.powitnessemceename;
    }

    public void setPowitnessemceename(String powitnessemceename) {
        this.powitnessemceename = powitnessemceename;
    }

    public String getPowitnessnotername() {
        return this.powitnessnotername;
    }

    public void setPowitnessnotername(String powitnessnotername) {
        this.powitnessnotername = powitnessnotername;
    }

    public String getInvestigatename() {
        return this.investigatename;
    }

    public void setInvestigatename(String investigatename) {
        this.investigatename = investigatename;
    }

    public String getInvestigatedepname() {
        return this.investigatedepname;
    }

    public void setInvestigatedepname(String investigatedepname) {
        this.investigatedepname = investigatedepname;
    }

    public String getDeputyname() {
        return this.deputyname;
    }

    public void setDeputyname(String deputyname) {
        this.deputyname = deputyname;
    }

    public String getDeputybusiness() {
        return this.deputybusiness;
    }

    public void setDeputybusiness(String deputybusiness) {
        this.deputybusiness = deputybusiness;
    }

    public String getDeputydepname() {
        return this.deputydepname;
    }

    public void setDeputydepname(String deputydepname) {
        this.deputydepname = deputydepname;
    }

    public String getDelegatename() {
        return this.delegatename;
    }

    public void setDelegatename(String delegatename) {
        this.delegatename = delegatename;
    }

    public String getPowitnessmind() {
        return this.powitnessmind;
    }

    public void setPowitnessmind(String powitnessmind) {
        this.powitnessmind = powitnessmind;
    }

    public String getPowitnessreason() {
        return this.powitnessreason;
    }

    public void setPowitnessreason(String powitnessreason) {
        this.powitnessreason = powitnessreason;
    }

    public Date getWitnessdate() {
        return this.witnessdate;
    }

    public void setWitnessdate(Date witnessdate) {
        this.witnessdate = witnessdate;
    }

    public void copy(Powitnessbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.powitnessdate = other.getPowitnessdate();
        this.powitnesstype = other.getPowitnesstype();
        this.powitnessadress = other.getPowitnessadress();
        this.powitnessemceename = other.getPowitnessemceename();
        this.powitnessnotername = other.getPowitnessnotername();
        this.investigatename = other.getInvestigatename();
        this.investigatedepname = other.getInvestigatedepname();
        this.deputyname = other.getDeputyname();
        this.deputybusiness = other.getDeputybusiness();
        this.deputydepname = other.getDeputydepname();
        this.delegatename = other.getDelegatename();
        this.powitnessmind = other.getPowitnessmind();
        this.powitnessreason = other.getPowitnessreason();
        this.witnessdate = other.getWitnessdate();

    }

    public void copyNotNullProperty(Powitnessbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getPowitnessdate() != null)
            this.powitnessdate = other.getPowitnessdate();
        if (other.getPowitnesstype() != null)
            this.powitnesstype = other.getPowitnesstype();
        if (other.getPowitnessadress() != null)
            this.powitnessadress = other.getPowitnessadress();
        if (other.getPowitnessemceename() != null)
            this.powitnessemceename = other.getPowitnessemceename();
        if (other.getPowitnessnotername() != null)
            this.powitnessnotername = other.getPowitnessnotername();
        if (other.getInvestigatename() != null)
            this.investigatename = other.getInvestigatename();
        if (other.getInvestigatedepname() != null)
            this.investigatedepname = other.getInvestigatedepname();
        if (other.getDeputyname() != null)
            this.deputyname = other.getDeputyname();
        if (other.getDeputybusiness() != null)
            this.deputybusiness = other.getDeputybusiness();
        if (other.getDeputydepname() != null)
            this.deputydepname = other.getDeputydepname();
        if (other.getDelegatename() != null)
            this.delegatename = other.getDelegatename();
        if (other.getPowitnessmind() != null)
            this.powitnessmind = other.getPowitnessmind();
        if (other.getPowitnessreason() != null)
            this.powitnessreason = other.getPowitnessreason();
        if (other.getWitnessdate() != null)
            this.witnessdate = other.getWitnessdate();

    }

    public void clearProperties() {

        this.powitnessdate = null;
        this.powitnesstype = null;
        this.powitnessadress = null;
        this.powitnessemceename = null;
        this.powitnessnotername = null;
        this.investigatename = null;
        this.investigatedepname = null;
        this.deputyname = null;
        this.deputybusiness = null;
        this.deputydepname = null;
        this.delegatename = null;
        this.powitnessmind = null;
        this.powitnessreason = null;
        this.witnessdate = null;

    }
}
