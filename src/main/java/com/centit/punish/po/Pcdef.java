package com.centit.punish.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.centit.powerbase.po.Pcfreeumpiredegree;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Pcdef implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishclassid;

    private String punishclassname;
    private Long depid;
    private String punishclasscode;
    private Long punishobject;
    private Long isinuse;
    private String punishbasiscontent;
    private String punishbasis;
    private String remark;
    // private String belonganyou;
    private Long islawsuit;
    private Long isreconsider;

    private Set<Pctype> pctypes = null;// new ArrayList<Pctype>();
    private Set<Pcfreeumpiredegree> pcfreeumpiredegrees = null;// new
                                                               // ArrayList<Pcfreeumpiredegree>();

    // Constructors
    /** default constructor */
    public Pcdef() {
    }

    public Pcdef(String punishclassid, String punishclassname, Long depid,
            String punishclasscode, Long punishobject, Long isinuse,
            String punishbasiscontent, String punishbasis, String remark,
            String belonganyou, Long islawsuit, Long isreconsider) {
        super();
        this.punishclassid = punishclassid;
        this.punishclassname = punishclassname;
        this.depid = depid;
        this.punishclasscode = punishclasscode;
        this.punishobject = punishobject;
        this.isinuse = isinuse;
        this.punishbasiscontent = punishbasiscontent;
        this.punishbasis = punishbasis;
        this.remark = remark;
        // this.belonganyou = belonganyou;
        this.islawsuit = islawsuit;
        this.isreconsider = isreconsider;
    }

    /** minimal constructor */
    public Pcdef(String punishclassid, String punishclassname, Long depid,
            Long isinuse) {

        this.punishclassid = punishclassid;

        this.punishclassname = punishclassname;
        this.depid = depid;
        this.isinuse = isinuse;
    }

    /** full constructor */
    public Pcdef(String punishclassid, String punishclassname, Long depid,
            String punishclasscode, Long punishobject, Long isinuse,
            String punishbasiscontent, String punishbasis, String remark) {

        this.punishclassid = punishclassid;

        this.punishclassname = punishclassname;
        this.depid = depid;
        this.punishclasscode = punishclasscode;
        this.punishobject = punishobject;
        this.isinuse = isinuse;
        this.punishbasiscontent = punishbasiscontent;
        this.punishbasis = punishbasis;
        this.remark = remark;
    }

    public String getPunishclassid() {
        return this.punishclassid;
    }

    public void setPunishclassid(String punishclassid) {
        this.punishclassid = punishclassid;
    }

    // Property accessors

    public String getPunishclassname() {
        return this.punishclassname;
    }

    public void setPunishclassname(String punishclassname) {
        this.punishclassname = punishclassname;
    }

    public Long getDepid() {
        return this.depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public String getPunishclasscode() {
        return this.punishclasscode;
    }

    public void setPunishclasscode(String punishclasscode) {
        this.punishclasscode = punishclasscode;
    }

    public Long getPunishobject() {
        return this.punishobject;
    }

    public void setPunishobject(Long punishobject) {
        this.punishobject = punishobject;
    }

    public Long getIsinuse() {
        return this.isinuse;
    }

    public void setIsinuse(Long isinuse) {
        this.isinuse = isinuse;
    }

    public String getPunishbasiscontent() {
        return this.punishbasiscontent;
    }

    public void setPunishbasiscontent(String punishbasiscontent) {
        this.punishbasiscontent = punishbasiscontent;
    }

    public String getPunishbasis() {
        return this.punishbasis;
    }

    public void setPunishbasis(String punishbasis) {
        this.punishbasis = punishbasis;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Pctype> getPctypes() {
        if (this.pctypes == null)
            this.pctypes = new HashSet<Pctype>();
        return this.pctypes;
    }

    public void setPctypes(Set<Pctype> pctypes) {
        this.pctypes = pctypes;
    }

    public void addPctype(Pctype pctype) {
        if (this.pctypes == null)
            this.pctypes = new HashSet<Pctype>();
        this.pctypes.add(pctype);
    }

    public void removePctype(Pctype pctype) {
        if (this.pctypes == null)
            return;
        this.pctypes.remove(pctype);
    }

    public Pctype newPctype() {
        Pctype res = new Pctype();

        res.setPunishclassid(this.getPunishclassid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePctypes(List<Pctype> pctypes) {
        List<Pctype> newObjs = new ArrayList<Pctype>();
        for (Pctype p : pctypes) {
            if (p == null)
                continue;
            Pctype newdt = newPctype();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Pctype> oldObjs = new HashSet<Pctype>();
        oldObjs.addAll(getPctypes());

        for (Iterator<Pctype> it = oldObjs.iterator(); it.hasNext();) {
            Pctype odt = it.next();
            found = false;
            for (Pctype newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePctype(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Pctype newdt : newObjs) {
            found = false;
            for (Iterator<Pctype> it = getPctypes().iterator(); it.hasNext();) {
                Pctype odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPctype(newdt);
        }
    }

    public Set<Pcfreeumpiredegree> getPcfreeumpiredegrees() {
        if (this.pcfreeumpiredegrees == null)
            this.pcfreeumpiredegrees = new HashSet<Pcfreeumpiredegree>();
        return this.pcfreeumpiredegrees;
    }

    public void setPcfreeumpiredegrees(
            Set<Pcfreeumpiredegree> pcfreeumpiredegrees) {
        this.pcfreeumpiredegrees = pcfreeumpiredegrees;
    }

    public void addPcfreeumpiredegree(Pcfreeumpiredegree pcfreeumpiredegree) {
        if (this.pcfreeumpiredegrees == null)
            this.pcfreeumpiredegrees = new HashSet<Pcfreeumpiredegree>();
        this.pcfreeumpiredegrees.add(pcfreeumpiredegree);
    }

    public void removePcfreeumpiredegree(Pcfreeumpiredegree pcfreeumpiredegree) {
        if (this.pcfreeumpiredegrees == null)
            return;
        this.pcfreeumpiredegrees.remove(pcfreeumpiredegree);
    }

    public Pcfreeumpiredegree newPcfreeumpiredegree() {
        Pcfreeumpiredegree res = new Pcfreeumpiredegree();

        // res.setPunishclassid(this.getPunishclassid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePcfreeumpiredegrees(
            List<Pcfreeumpiredegree> pcfreeumpiredegrees) {
        List<Pcfreeumpiredegree> newObjs = new ArrayList<Pcfreeumpiredegree>();
        for (Pcfreeumpiredegree p : pcfreeumpiredegrees) {
            if (p == null)
                continue;
            Pcfreeumpiredegree newdt = newPcfreeumpiredegree();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Pcfreeumpiredegree> oldObjs = new HashSet<Pcfreeumpiredegree>();
        oldObjs.addAll(getPcfreeumpiredegrees());

        for (Iterator<Pcfreeumpiredegree> it = oldObjs.iterator(); it.hasNext();) {
            Pcfreeumpiredegree odt = it.next();
            found = false;
            for (Pcfreeumpiredegree newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePcfreeumpiredegree(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Pcfreeumpiredegree newdt : newObjs) {
            found = false;
            for (Iterator<Pcfreeumpiredegree> it = getPcfreeumpiredegrees()
                    .iterator(); it.hasNext();) {
                Pcfreeumpiredegree odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPcfreeumpiredegree(newdt);
        }
    }

    public Long getIslawsuit() {
        return islawsuit;
    }

    public void setIslawsuit(Long islawsuit) {
        this.islawsuit = islawsuit;
    }

    public Long getIsreconsider() {
        return isreconsider;
    }

    public void setIsreconsider(Long isreconsider) {
        this.isreconsider = isreconsider;
    }

    public void copy(Pcdef other) {

        this.setPunishclassid(other.getPunishclassid());

        this.punishclassname = other.getPunishclassname();
        this.depid = other.getDepid();
        this.punishclasscode = other.getPunishclasscode();
        this.punishobject = other.getPunishobject();
        this.isinuse = other.getIsinuse();
        this.punishbasiscontent = other.getPunishbasiscontent();
        this.punishbasis = other.getPunishbasis();
        this.remark = other.getRemark();

        this.pctypes = other.getPctypes();
        this.pcfreeumpiredegrees = other.getPcfreeumpiredegrees();
        this.islawsuit = other.getIslawsuit();
        this.isreconsider = other.getIsreconsider();
    }

    public void copyNotNullProperty(Pcdef other) {

        if (other.getPunishclassid() != null)
            this.setPunishclassid(other.getPunishclassid());

        if (other.getPunishclassname() != null)
            this.punishclassname = other.getPunishclassname();
        if (other.getDepid() != null)
            this.depid = other.getDepid();
        if (other.getPunishclasscode() != null)
            this.punishclasscode = other.getPunishclasscode();
        if (other.getPunishobject() != null)
            this.punishobject = other.getPunishobject();
        if (other.getIsinuse() != null)
            this.isinuse = other.getIsinuse();
        if (other.getPunishbasiscontent() != null)
            this.punishbasiscontent = other.getPunishbasiscontent();
        if (other.getPunishbasis() != null)
            this.punishbasis = other.getPunishbasis();
        if (other.getRemark() != null)
            this.remark = other.getRemark();
        /*
         * if (other.getBelonganyou() != null) this.belonganyou =
         * other.getBelonganyou();
         */
        if (other.getPctypes() != null)
            this.pctypes = other.getPctypes();
        if (other.getPcfreeumpiredegrees() != null)
            this.pcfreeumpiredegrees = other.getPcfreeumpiredegrees();
        if (other.getIslawsuit() != null)
            this.islawsuit = other.getIslawsuit();
        if (other.getIsreconsider() != null)
            this.isreconsider = other.getIsreconsider();
    }

    public void clearProperties() {

        this.punishclassname = null;
        this.depid = null;
        this.punishclasscode = null;
        this.punishobject = null;
        this.isinuse = null;
        this.punishbasiscontent = null;
        this.punishbasis = null;
        this.remark = null;

        this.pctypes = new HashSet<Pctype>();
        this.pcfreeumpiredegrees = new HashSet<Pcfreeumpiredegree>();
        this.islawsuit = null;
        this.isreconsider = null;
    }
}
