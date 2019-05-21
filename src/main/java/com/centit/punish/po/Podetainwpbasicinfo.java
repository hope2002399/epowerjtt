package com.centit.punish.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Podetainwpbasicinfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String wpid;

    private String punishobjectid;
    private String wptype;
    private String wpname;
    private String wpstate;
    private Date receivedate;
    private String receivelocation;
    private String receiveperson;
    private String confirmperson;
    private String wpcurrentlocation;
    private String remark;
    private Set<Podetainwptransinfo> podetainwptransinfos = null;// new
                                                                 // ArrayList<Podetainwptransinfo>();

    // Constructors
    /** default constructor */
    public Podetainwpbasicinfo() {
    }

    /** minimal constructor */
    public Podetainwpbasicinfo(String wpid) {

        this.wpid = wpid;

    }

    /** full constructor */
    public Podetainwpbasicinfo(String wpid, String punishobjectid,
            String wptype, String wpname, String wpstate, Date receivedate,
            String receivelocation, String receiveperson, String confirmperson,
            String wpcurrentlocation, String remark) {

        this.wpid = wpid;

        this.punishobjectid = punishobjectid;
        this.wptype = wptype;
        this.wpname = wpname;
        this.wpstate = wpstate;
        this.receivedate = receivedate;
        this.receivelocation = receivelocation;
        this.receiveperson = receiveperson;
        this.confirmperson = confirmperson;
        this.wpcurrentlocation = wpcurrentlocation;
        this.remark = remark;
    }

    public String getWpid() {
        return this.wpid;
    }

    public void setWpid(String wpid) {
        this.wpid = wpid;
    }

    // Property accessors

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public String getWptype() {
        return this.wptype;
    }

    public void setWptype(String wptype) {
        this.wptype = wptype;
    }

    public String getWpname() {
        return this.wpname;
    }

    public void setWpname(String wpname) {
        this.wpname = wpname;
    }

    public String getWpstate() {
        return this.wpstate;
    }

    public void setWpstate(String wpstate) {
        this.wpstate = wpstate;
    }

    public Date getReceivedate() {
        return this.receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public String getReceivelocation() {
        return this.receivelocation;
    }

    public void setReceivelocation(String receivelocation) {
        this.receivelocation = receivelocation;
    }

    public String getReceiveperson() {
        return this.receiveperson;
    }

    public void setReceiveperson(String receiveperson) {
        this.receiveperson = receiveperson;
    }

    public String getConfirmperson() {
        return this.confirmperson;
    }

    public void setConfirmperson(String confirmperson) {
        this.confirmperson = confirmperson;
    }

    public String getWpcurrentlocation() {
        return this.wpcurrentlocation;
    }

    public void setWpcurrentlocation(String wpcurrentlocation) {
        this.wpcurrentlocation = wpcurrentlocation;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Podetainwptransinfo> getPodetainwptransinfos() {
        if (this.podetainwptransinfos == null)
            this.podetainwptransinfos = new HashSet<Podetainwptransinfo>();
        return this.podetainwptransinfos;
    }

    public void setPodetainwptransinfos(
            Set<Podetainwptransinfo> podetainwptransinfos) {
        this.podetainwptransinfos = podetainwptransinfos;
    }

    public void addPodetainwptransinfo(Podetainwptransinfo podetainwptransinfo) {
        if (this.podetainwptransinfos == null)
            this.podetainwptransinfos = new HashSet<Podetainwptransinfo>();
        this.podetainwptransinfos.add(podetainwptransinfo);
    }

    public void removePodetainwptransinfo(
            Podetainwptransinfo podetainwptransinfo) {
        if (this.podetainwptransinfos == null)
            return;
        this.podetainwptransinfos.remove(podetainwptransinfo);
    }

    public Podetainwptransinfo newPodetainwptransinfo() {
        Podetainwptransinfo res = new Podetainwptransinfo();

        res.setWpid(this.getWpid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不�?��的问�?
     * 
     */
    public void replacePodetainwptransinfos(
            List<Podetainwptransinfo> podetainwptransinfos) {
        List<Podetainwptransinfo> newObjs = new ArrayList<Podetainwptransinfo>();
        for (Podetainwptransinfo p : podetainwptransinfos) {
            if (p == null)
                continue;
            Podetainwptransinfo newdt = newPodetainwptransinfo();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Podetainwptransinfo> oldObjs = new HashSet<Podetainwptransinfo>();
        oldObjs.addAll(getPodetainwptransinfos());

        for (Iterator<Podetainwptransinfo> it = oldObjs.iterator(); it
                .hasNext();) {
            Podetainwptransinfo odt = it.next();
            found = false;
            for (Podetainwptransinfo newdt : newObjs) {
                if (odt.getWpid().equals(newdt.getWpid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePodetainwptransinfo(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Podetainwptransinfo newdt : newObjs) {
            found = false;
            for (Iterator<Podetainwptransinfo> it = getPodetainwptransinfos()
                    .iterator(); it.hasNext();) {
                Podetainwptransinfo odt = it.next();
                if (odt.getWpid().equals(newdt.getWpid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPodetainwptransinfo(newdt);
        }
    }

    public void copy(Podetainwpbasicinfo other) {

        this.setWpid(other.getWpid());

        this.punishobjectid = other.getPunishobjectid();
        this.wptype = other.getWptype();
        this.wpname = other.getWpname();
        this.wpstate = other.getWpstate();
        this.receivedate = other.getReceivedate();
        this.receivelocation = other.getReceivelocation();
        this.receiveperson = other.getReceiveperson();
        this.confirmperson = other.getConfirmperson();
        this.wpcurrentlocation = other.getWpcurrentlocation();
        this.remark = other.getRemark();

        this.podetainwptransinfos = other.getPodetainwptransinfos();
    }

    public void copyNotNullProperty(Podetainwpbasicinfo other) {

        if (other.getWpid() != null)
            this.setWpid(other.getWpid());

        if (other.getPunishobjectid() != null)
            this.punishobjectid = other.getPunishobjectid();
        if (other.getWptype() != null)
            this.wptype = other.getWptype();
        if (other.getWpname() != null)
            this.wpname = other.getWpname();
        if (other.getWpstate() != null)
            this.wpstate = other.getWpstate();
        if (other.getReceivedate() != null)
            this.receivedate = other.getReceivedate();
        if (other.getReceivelocation() != null)
            this.receivelocation = other.getReceivelocation();
        if (other.getReceiveperson() != null)
            this.receiveperson = other.getReceiveperson();
        if (other.getConfirmperson() != null)
            this.confirmperson = other.getConfirmperson();
        if (other.getWpcurrentlocation() != null)
            this.wpcurrentlocation = other.getWpcurrentlocation();
        if (other.getRemark() != null)
            this.remark = other.getRemark();

        this.podetainwptransinfos = other.getPodetainwptransinfos();
    }

    public void clearProperties() {

        this.punishobjectid = null;
        this.wptype = null;
        this.wpname = null;
        this.wpstate = null;
        this.receivedate = null;
        this.receivelocation = null;
        this.receiveperson = null;
        this.confirmperson = null;
        this.wpcurrentlocation = null;
        this.remark = null;

        this.podetainwptransinfos = new HashSet<Podetainwptransinfo>();
    }
}
