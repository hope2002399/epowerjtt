package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VPotranslawbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PotranslawbasicId cid;
    private Long degreeno;
    private Long issurpass;
    private Date translawdate;
    private String punishClassCode;
    private String depID;
    private String punishBasis;

    // Constructors
    /** default constructor */
    public VPotranslawbasic() {
    }

    /** minimal constructor */
    public VPotranslawbasic(PotranslawbasicId id

    ) {
        this.cid = id;

    }

    /** full constructor */
    public VPotranslawbasic(PotranslawbasicId id

    , Long degreeno, Long issurpass, Date translawdate) {
        this.cid = id;

        this.degreeno = degreeno;
        this.issurpass = issurpass;
        this.translawdate = translawdate;
    }

    public PotranslawbasicId getCid() {
        return this.cid;
    }

    public void setCid(PotranslawbasicId id) {
        this.cid = id;
    }

    public VPotranslawbasic(PotranslawbasicId cid, Long degreeno,
            Long issurpass, Date translawdate, String punishClassCode,
            String depID, String punishBasis) {
        super();
        this.cid = cid;
        this.degreeno = degreeno;
        this.issurpass = issurpass;
        this.translawdate = translawdate;
        this.punishClassCode = punishClassCode;
        this.depID = depID;
        this.punishBasis = punishBasis;
    }

    public String getPunishClassCode() {
        return punishClassCode;
    }

    public void setPunishClassCode(String punishClassCode) {
        this.punishClassCode = punishClassCode;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getPunishBasis() {
        return punishBasis;
    }

    public void setPunishBasis(String punishBasis) {
        this.punishBasis = punishBasis;
    }

    public String getItem_id() {
        if (this.cid == null)
            this.cid = new PotranslawbasicId();
        return this.cid.getItem_id();
    }

    public void setItem_id(String item_id) {
        if (this.cid == null)
            this.cid = new PotranslawbasicId();
        this.cid.setItem_id(item_id);
    }

    public String getPunishobjectid() {
        if (this.cid == null)
            this.cid = new PotranslawbasicId();
        return this.cid.getPunishobjectid();
    }

    public void setPunishobjectid(String punishobjectid) {
        if (this.cid == null)
            this.cid = new PotranslawbasicId();
        this.cid.setPunishobjectid(punishobjectid);
    }

    // Property accessors

    public Long getDegreeno() {
        return this.degreeno;
    }

    public void setDegreeno(Long degreeno) {
        this.degreeno = degreeno;
    }

    public Long getIssurpass() {
        return this.issurpass;
    }

    public void setIssurpass(Long issurpass) {
        this.issurpass = issurpass;
    }

    public Date getTranslawdate() {
        return this.translawdate;
    }

    public void setTranslawdate(Date translawdate) {
        this.translawdate = translawdate;
    }

    public void copy(VPotranslawbasic other) {

        this.setItem_id(other.getItem_id());
        this.setPunishobjectid(other.getPunishobjectid());
        this.degreeno = other.getDegreeno();
        this.issurpass = other.getIssurpass();
        this.translawdate = other.getTranslawdate();
        this.depID = other.getDepID();
        this.punishClassCode = other.getPunishClassCode();
        this.punishBasis = other.getPunishBasis();

    }

    public void copyNotNullProperty(VPotranslawbasic other) {

        if (other.getItem_id() != null)
            this.setItem_id(other.getItem_id());
        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getDegreeno() != null)
            this.degreeno = other.getDegreeno();
        if (other.getIssurpass() != null)
            this.issurpass = other.getIssurpass();
        if (other.getTranslawdate() != null)
            this.translawdate = other.getTranslawdate();
        if (other.getDepID() != null)
            this.depID = other.getDepID();
        if (other.getPunishClassCode() != null)
            this.punishClassCode = other.getPunishClassCode();
        if (other.getPunishBasis() != null)
            this.punishBasis = other.getPunishBasis();
    }

    public void clearProperties() {

        this.degreeno = null;
        this.issurpass = null;
        this.translawdate = null;
        this.depID = null;
        this.punishClassCode = null;
        this.punishBasis = null;

    }
}
