package com.centit.punish.po;

import java.util.Date;
import java.util.List;

import com.centit.powerbase.po.Pcfreeumpiredegree;
import com.centit.powerbase.po.Pcfreeumpiretype;
import com.centit.powerruntime.po.VOrgSupPower;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Potranslawbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PotranslawbasicId cid;

    private Long degreeno;
    private Long issurpass;
    private Date translawdate;
    private VOrgSupPower vOrgSupPower;
    private List<Pcfreeumpiredegree> degreelist;
    private List<Pcfreeumpiretype> typelist;
    private String result;
    private String ishavedegree;

    public String getIshavedegree() {
        return ishavedegree;
    }

    public void setIshavedegree(String ishavedegree) {
        this.ishavedegree = ishavedegree;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Pcfreeumpiredegree> getDegreelist() {
        return degreelist;
    }

    public void setDegreelist(List<Pcfreeumpiredegree> degreelist) {
        this.degreelist = degreelist;
    }

    public List<Pcfreeumpiretype> getTypelist() {
        return typelist;
    }

    public void setTypelist(List<Pcfreeumpiretype> typelist) {
        this.typelist = typelist;
    }

    // Constructors
    /** default constructor */
    public Potranslawbasic() {
    }

    /** minimal constructor */
    public Potranslawbasic(PotranslawbasicId id

    ) {
        this.cid = id;
    }

    /** full constructor */
    public Potranslawbasic(PotranslawbasicId id

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

    public void copy(Potranslawbasic other) {

        this.setItem_id(other.getItem_id());
        this.setPunishobjectid(other.getPunishobjectid());

        this.degreeno = other.getDegreeno();
        this.issurpass = other.getIssurpass();
        this.translawdate = other.getTranslawdate();

    }

    public void copyNotNullProperty(Potranslawbasic other) {

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

    }

    public void clearProperties() {

        this.degreeno = null;
        this.issurpass = null;
        this.translawdate = null;

    }

    public VOrgSupPower getvOrgSupPower() {
        return vOrgSupPower;
    }

    public void setvOrgSupPower(VOrgSupPower vOrgSupPower) {
        this.vOrgSupPower = vOrgSupPower;
    }

}
