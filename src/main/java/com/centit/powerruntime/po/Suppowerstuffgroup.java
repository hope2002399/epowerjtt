package com.centit.powerruntime.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Suppowerstuffgroup implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String groupId;

    private String stuffGroup;
    private String groupDesc;

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    private Set<YwFiles> suppowerstuffinfos = null;// new
                                                             // ArrayList<YwFile>();

    // Constructors
    /** default constructor */
    public Suppowerstuffgroup() {

    }

    /** minimal constructor */
    public Suppowerstuffgroup(String groupId) {
        this.groupId = groupId;

    }

    /** full constructor */
    public Suppowerstuffgroup(String groupId

    , String stuffGroup, String groupDesc) {
        this.groupId = groupId;

        this.groupDesc = groupDesc;
        this.stuffGroup = stuffGroup;
    }

    // Property accessors

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStuffGroup() {
        return this.stuffGroup;
    }

    public void setStuffGroup(String stuffGroup) {
        this.stuffGroup = stuffGroup;
    }

    public Set<YwFiles> getSuppowerstuffinfos() {
        if (this.suppowerstuffinfos == null)
            this.suppowerstuffinfos = new HashSet<YwFiles>();
        return this.suppowerstuffinfos;
    }

    public void setSuppowerstuffinfos(Set<YwFiles> suppowerstuffinfos) {
        this.suppowerstuffinfos = suppowerstuffinfos;
    }

    public void addYwFile(YwFiles suppowerstuffinfos) {
        if (this.suppowerstuffinfos == null)
            this.suppowerstuffinfos = new HashSet<YwFiles>();
        this.suppowerstuffinfos.add(suppowerstuffinfos);
    }

    public void removeYwFile(YwFiles suppowerstuffinfos) {
        if (this.suppowerstuffinfos == null)
            return;
        this.suppowerstuffinfos.remove(suppowerstuffinfos);
    }

    public YwFiles newYwFile() {
        YwFiles res = new YwFiles();

        res.setGroupId(this.getGroupId());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replaceYwFiles(
            List<YwFiles> YwFiles) {
        List<YwFiles> newObjs = new ArrayList<YwFiles>();
        for (YwFiles p : YwFiles) {
            if (p == null)
                continue;
            YwFiles newdt = newYwFile();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<YwFiles> oldObjs = new HashSet<YwFiles>();
        oldObjs.addAll(getSuppowerstuffinfos());

        for (Iterator<YwFiles> it = oldObjs.iterator(); it.hasNext();) {
            YwFiles odt = it.next();
            found = false;
            for (YwFiles newdt : newObjs) {
                if (odt.getSortId().equals(newdt.getSortId())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeYwFile(odt);
        }
        oldObjs.clear();
        // insert or update
        for (YwFiles newdt : newObjs) {
            found = false;
            for (Iterator<YwFiles> it = getSuppowerstuffinfos()
                    .iterator(); it.hasNext();) {
                YwFiles odt = it.next();
                if (odt.getSortId().equals(newdt.getSortId())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addYwFile(newdt);
        }
    }

    public void copy(Suppowerstuffgroup other) {

        this.setGroupId(other.getGroupId());
        this.groupDesc = other.getGroupDesc();

        this.stuffGroup = other.getStuffGroup();
        this.suppowerstuffinfos = other.getSuppowerstuffinfos();
    }

    public void copyNotNullProperty(Suppowerstuffgroup other) {

        if (other.getGroupId() != null)
            this.setGroupId(other.getGroupId());

        if (other.getStuffGroup() != null)
            this.stuffGroup = other.getStuffGroup();
        if (other.getGroupDesc() != null)
            this.groupDesc = other.getGroupDesc();

        this.suppowerstuffinfos = other.getSuppowerstuffinfos();
    }

    public void clearProperties() {

        this.stuffGroup = null;
        this.groupDesc = null;

        this.suppowerstuffinfos = new HashSet<YwFiles>();
    }
}
