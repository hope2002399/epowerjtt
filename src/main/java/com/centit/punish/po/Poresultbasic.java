package com.centit.punish.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poresultbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String resulttype;
    private String poneatencontent;
    private String poarbitrationcontent;
    private String poquashreason;
    private String podeportationdepname;
    private String remark;

    // Constructors
    /** default constructor */
    public Poresultbasic() {
    }

    /** minimal constructor */
    public Poresultbasic(String punishobjectid) {

        this.punishobjectid = punishobjectid;

    }

    /** full constructor */
    public Poresultbasic(String punishobjectid, String resulttype,
            String poneatencontent, String poarbitrationcontent,
            String poquashreason, String podeportationdepname, String remark) {

        this.punishobjectid = punishobjectid;

        this.resulttype = resulttype;
        this.poneatencontent = poneatencontent;
        this.poarbitrationcontent = poarbitrationcontent;
        this.poquashreason = poquashreason;
        this.podeportationdepname = podeportationdepname;
        this.remark = remark;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public String getResulttype() {
        return this.resulttype;
    }

    public void setResulttype(String resulttype) {
        this.resulttype = resulttype;
    }

    public String getPoneatencontent() {
        return this.poneatencontent;
    }

    public void setPoneatencontent(String poneatencontent) {
        this.poneatencontent = poneatencontent;
    }

    public String getPoarbitrationcontent() {
        return this.poarbitrationcontent;
    }

    public void setPoarbitrationcontent(String poarbitrationcontent) {
        this.poarbitrationcontent = poarbitrationcontent;
    }

    public String getPoquashreason() {
        return this.poquashreason;
    }

    public void setPoquashreason(String poquashreason) {
        this.poquashreason = poquashreason;
    }

    public String getPodeportationdepname() {
        return this.podeportationdepname;
    }

    public void setPodeportationdepname(String podeportationdepname) {
        this.podeportationdepname = podeportationdepname;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void copy(Poresultbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.resulttype = other.getResulttype();
        this.poneatencontent = other.getPoneatencontent();
        this.poarbitrationcontent = other.getPoarbitrationcontent();
        this.poquashreason = other.getPoquashreason();
        this.podeportationdepname = other.getPodeportationdepname();
        this.remark = other.getRemark();

    }

    public void copyNotNullProperty(Poresultbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getResulttype() != null)
            this.resulttype = other.getResulttype();
        if (other.getPoneatencontent() != null)
            this.poneatencontent = other.getPoneatencontent();
        if (other.getPoarbitrationcontent() != null)
            this.poarbitrationcontent = other.getPoarbitrationcontent();
        if (other.getPoquashreason() != null)
            this.poquashreason = other.getPoquashreason();
        if (other.getPodeportationdepname() != null)
            this.podeportationdepname = other.getPodeportationdepname();
        if (other.getRemark() != null)
            this.remark = other.getRemark();

    }

    public void clearProperties() {

        this.resulttype = null;
        this.poneatencontent = null;
        this.poarbitrationcontent = null;
        this.poquashreason = null;
        this.podeportationdepname = null;
        this.remark = null;

    }
}
