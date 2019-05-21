package com.centit.punish.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.centit.powerbase.po.Pcfreeumpiretype;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Pctype implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PctypeId cid;

    private Long isinuse;
    private String punishmax;
    private String punishmin;
    private Long israte;
    private String chargemax;
    private String radixname;
    private String radixunit;
    private String punishcontent;
    private Set<Pcfreeumpiretype> pcfreeumpiretypes = null;// new
                                                           // ArrayList<Pcfreeumpiretype>();
    private Popunishbasic popunishbasic;
    private Poradixbasic poradixbasic;

    public Poradixbasic getPoradixbasic() {
        return poradixbasic;
    }

    public void setPoradixbasic(Poradixbasic poradixbasic) {
        this.poradixbasic = poradixbasic;
    }

    private String degreeforpage;
    private String freeisrate;
    private String punishname;

    public String getPunishname() {
        return punishname;
    }

    public void setPunishname(String punishname) {
        this.punishname = punishname;
    }

    public String getDegreeforpage() {
        return degreeforpage;
    }

    public void setDegreeforpage(String degreeforpage) {
        this.degreeforpage = degreeforpage;
    }

    public String getFreeisrate() {
        return freeisrate;
    }

    public void setFreeisrate(String freeisrate) {
        this.freeisrate = freeisrate;
    }

    public Popunishbasic getPopunishbasic() {
        return popunishbasic;
    }

    public void setPopunishbasic(Popunishbasic popunishbasic) {
        this.popunishbasic = popunishbasic;
    }

    // Constructors
    /** default constructor */
    public Pctype() {
    }

    /** minimal constructor */
    public Pctype(PctypeId id

    , Long isinuse) {
        this.cid = id;

        this.isinuse = isinuse;
    }

    /** full constructor */
    public Pctype(PctypeId id

    , Long isinuse, String punishmax, String punishmin, Long israte,
            String chargemax, String radixname, String radixunit,
            String punishcontent) {
        this.cid = id;

        this.isinuse = isinuse;
        this.punishmax = punishmax;
        this.punishmin = punishmin;
        this.israte = israte;
        this.chargemax = chargemax;
        this.radixname = radixname;
        this.radixunit = radixunit;
        this.punishcontent = punishcontent;
    }

    public PctypeId getCid() {
        return this.cid;
    }

    public void setCid(PctypeId id) {
        this.cid = id;
    }

    public String getPunishclassid() {
        if (this.cid == null)
            this.cid = new PctypeId();
        return this.cid.getPunishclassid();
    }

    public void setPunishclassid(String punishclassid) {
        if (this.cid == null)
            this.cid = new PctypeId();
        this.cid.setPunishclassid(punishclassid);
    }

    public String getPunishtypeid() {
        if (this.cid == null)
            this.cid = new PctypeId();
        return this.cid.getPunishtypeid();
    }

    public void setPunishtypeid(String punishtypeid) {
        if (this.cid == null)
            this.cid = new PctypeId();
        this.cid.setPunishtypeid(punishtypeid);
    }

    // Property accessors

    public Long getIsinuse() {
        return this.isinuse;
    }

    public void setIsinuse(Long isinuse) {
        this.isinuse = isinuse;
    }

    public String getPunishmax() {
        return this.punishmax;
    }

    public void setPunishmax(String punishmax) {
        this.punishmax = punishmax;
    }

    public String getPunishmin() {
        return this.punishmin;
    }

    public void setPunishmin(String punishmin) {
        this.punishmin = punishmin;
    }

    public Long getIsrate() {
        return this.israte;
    }

    public void setIsrate(Long israte) {
        this.israte = israte;
    }

    public String getChargemax() {
        return this.chargemax;
    }

    public void setChargemax(String chargemax) {
        this.chargemax = chargemax;
    }

    public String getRadixname() {
        return this.radixname;
    }

    public void setRadixname(String radixname) {
        this.radixname = radixname;
    }

    public String getRadixunit() {
        return this.radixunit;
    }

    public void setRadixunit(String radixunit) {
        this.radixunit = radixunit;
    }

    public String getPunishcontent() {
        return this.punishcontent;
    }

    public void setPunishcontent(String punishcontent) {
        this.punishcontent = punishcontent;
    }

    public Set<Pcfreeumpiretype> getPcfreeumpiretypes() {
        if (this.pcfreeumpiretypes == null)
            this.pcfreeumpiretypes = new HashSet<Pcfreeumpiretype>();
        return this.pcfreeumpiretypes;
    }

    public void setPcfreeumpiretypes(Set<Pcfreeumpiretype> pcfreeumpiretypes) {
        this.pcfreeumpiretypes = pcfreeumpiretypes;
    }

    public void addPcfreeumpiretype(Pcfreeumpiretype pcfreeumpiretype) {
        if (this.pcfreeumpiretypes == null)
            this.pcfreeumpiretypes = new HashSet<Pcfreeumpiretype>();
        this.pcfreeumpiretypes.add(pcfreeumpiretype);
    }

    public void removePcfreeumpiretype(Pcfreeumpiretype pcfreeumpiretype) {
        if (this.pcfreeumpiretypes == null)
            return;
        this.pcfreeumpiretypes.remove(pcfreeumpiretype);
    }

    public Pcfreeumpiretype newPcfreeumpiretype() {
        Pcfreeumpiretype res = new Pcfreeumpiretype();

        // res.setPunishclassid(this.getPunishclassid());

        res.setPunishtypeid(this.getPunishtypeid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePcfreeumpiretypes(
            List<Pcfreeumpiretype> pcfreeumpiretypes) {
        List<Pcfreeumpiretype> newObjs = new ArrayList<Pcfreeumpiretype>();
        for (Pcfreeumpiretype p : pcfreeumpiretypes) {
            if (p == null)
                continue;
            Pcfreeumpiretype newdt = newPcfreeumpiretype();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Pcfreeumpiretype> oldObjs = new HashSet<Pcfreeumpiretype>();
        oldObjs.addAll(getPcfreeumpiretypes());

        for (Iterator<Pcfreeumpiretype> it = oldObjs.iterator(); it.hasNext();) {
            Pcfreeumpiretype odt = it.next();
            found = false;
            for (Pcfreeumpiretype newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePcfreeumpiretype(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Pcfreeumpiretype newdt : newObjs) {
            found = false;
            for (Iterator<Pcfreeumpiretype> it = getPcfreeumpiretypes()
                    .iterator(); it.hasNext();) {
                Pcfreeumpiretype odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPcfreeumpiretype(newdt);
        }
    }

    public void copy(Pctype other) {

        this.setPunishclassid(other.getPunishclassid());
        this.setPunishtypeid(other.getPunishtypeid());

        this.isinuse = other.getIsinuse();
        this.punishmax = other.getPunishmax();
        this.punishmin = other.getPunishmin();
        this.israte = other.getIsrate();
        this.chargemax = other.getChargemax();
        this.radixname = other.getRadixname();
        this.radixunit = other.getRadixunit();
        this.punishcontent = other.getPunishcontent();

        this.pcfreeumpiretypes = other.getPcfreeumpiretypes();
    }

    public void copyNotNullProperty(Pctype other) {

        if (other.getPunishclassid() != null)
            this.setPunishclassid(other.getPunishclassid());
        if (other.getPunishtypeid() != null)
            this.setPunishtypeid(other.getPunishtypeid());

        if (other.getIsinuse() != null)
            this.isinuse = other.getIsinuse();
        if (other.getPunishmax() != null)
            this.punishmax = other.getPunishmax();
        if (other.getPunishmin() != null)
            this.punishmin = other.getPunishmin();
        if (other.getIsrate() != null)
            this.israte = other.getIsrate();
        if (other.getChargemax() != null)
            this.chargemax = other.getChargemax();
        if (other.getRadixname() != null)
            this.radixname = other.getRadixname();
        if (other.getRadixunit() != null)
            this.radixunit = other.getRadixunit();
        if (other.getPunishcontent() != null)
            this.punishcontent = other.getPunishcontent();

        this.pcfreeumpiretypes = other.getPcfreeumpiretypes();
    }

    public void clearProperties() {

        this.isinuse = null;
        this.punishmax = null;
        this.punishmin = null;
        this.israte = null;
        this.chargemax = null;
        this.radixname = null;
        this.radixunit = null;
        this.punishcontent = null;

        this.pcfreeumpiretypes = new HashSet<Pcfreeumpiretype>();
    }
}
