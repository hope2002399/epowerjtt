package com.centit.powerruntime.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Suppowerstuffinfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long sortId;

    private String groupId;
    private String stuffType;
    private String stuffName;
    private String isNeed;
    private String isElectron;

    // Constructors
    /** default constructor */
    public Suppowerstuffinfo() {
    }

    /** minimal constructor */
    public Suppowerstuffinfo(Long sortId, String stuffName) {

        this.sortId = sortId;

        this.stuffName = stuffName;
    }

    /** full constructor */
    public Suppowerstuffinfo(Long sortId, String groupId, String stuffType,
            String stuffName, String isNeed, String isElectron) {

        this.sortId = sortId;

        this.groupId = groupId;
        this.stuffType = stuffType;
        this.stuffName = stuffName;
        this.isNeed = isNeed;
        this.isElectron = isElectron;
    }

    public Long getSortId() {
        return this.sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    // Property accessors

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStuffType() {
        return this.stuffType;
    }

    public void setStuffType(String stuffType) {
        this.stuffType = stuffType;
    }

    public String getStuffName() {
        return this.stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public String getIsNeed() {
        return this.isNeed;
    }

    public void setIsNeed(String isNeed) {
        this.isNeed = isNeed;
    }

    public String getIsElectron() {
        return this.isElectron;
    }

    public void setIsElectron(String isElectron) {
        this.isElectron = isElectron;
    }

    public void copy(Suppowerstuffinfo other) {

        this.setSortId(other.getSortId());

        this.groupId = other.getGroupId();
        this.stuffType = other.getStuffType();
        this.stuffName = other.getStuffName();
        this.isNeed = other.getIsNeed();
        this.isElectron = other.getIsElectron();

    }

    public void copyNotNullProperty(Suppowerstuffinfo other) {

        if (other.getSortId() != null)
            this.setSortId(other.getSortId());

        if (other.getGroupId() != null)
            this.groupId = other.getGroupId();
        if (other.getStuffType() != null)
            this.stuffType = other.getStuffType();
        if (other.getStuffName() != null)
            this.stuffName = other.getStuffName();
        if (other.getIsNeed() != null)
            this.isNeed = other.getIsNeed();
        if (other.getIsElectron() != null)
            this.isElectron = other.getIsElectron();

    }

    public void clearProperties() {

        this.groupId = null;
        this.stuffType = null;
        this.stuffName = null;
        this.isNeed = null;
        this.isElectron = null;

    }
}
