package com.centit.monitor.po;

import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Superviselog implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    public static final String LEVEL_INFO = "0";

    private Long logid;

    private String loglevel = LEVEL_INFO;
    private String usercode;
    private Date opttime = new Date();
    private String optid;
    private String optmethod;
    private String optcontent;
    private String oldvalue;
    private String tagid;
    private String bjType;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    private String logType;

    // Constructors
    /** default constructor */
    public Superviselog() {
    }

    /** minimal constructor */
    public Superviselog(Long logid, String loglevel, String usercode,
            Date opttime, String optid, String optcontent) {

        this.logid = logid;

        this.loglevel = loglevel;
        this.usercode = usercode;
        this.opttime = opttime;
        this.optid = optid;
        this.optcontent = optcontent;
    }

    /** log constructor */
    public Superviselog(String usercode, String optId, String tagId,
            String optMethod, String optContent, String oldValue,
            String bjType, String logType) {
        this.usercode = usercode;
        this.optid = optId;
        this.optmethod = optMethod;
        this.optcontent = optContent;
        this.oldvalue = oldValue;
        this.tagid = tagId;
        this.bjType = bjType;
        if (StringUtils.hasText(logType))
            this.logType = logType;
        else
            this.logType = "1";

    }

    /** full constructor */
    public Superviselog(Long logid, String loglevel, String usercode,
            Date opttime, String optid, String optmethod, String optcontent,
            String oldvalue, String tagid, String bjType, String logType) {

        this.logid = logid;

        this.loglevel = loglevel;
        this.usercode = usercode;
        this.opttime = opttime;
        this.optid = optid;
        this.optmethod = optmethod;
        this.optcontent = optcontent;
        this.oldvalue = oldvalue;
        this.tagid = tagid;
        this.bjType = bjType;
        this.logType = logType;
    }

    public Long getLogid() {
        return this.logid;
    }

    public void setLogid(Long logid) {
        this.logid = logid;
    }

    // Property accessors

    public String getLoglevel() {
        return this.loglevel;
    }

    public void setLoglevel(String loglevel) {
        this.loglevel = loglevel;
    }

    public String getUsercode() {
        return this.usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public Date getOpttime() {
        return this.opttime;
    }

    public void setOpttime(Date opttime) {
        this.opttime = opttime;
    }

    public String getOptid() {
        return this.optid;
    }

    public void setOptid(String optid) {
        this.optid = optid;
    }

    public String getOptmethod() {
        return this.optmethod;
    }

    public void setOptmethod(String optmethod) {
        this.optmethod = optmethod;
    }

    public String getOptcontent() {
        return this.optcontent;
    }

    public void setOptcontent(String optcontent) {
        this.optcontent = optcontent;
    }

    public String getOldvalue() {
        return this.oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public String getTagid() {
        return this.tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

    public String getBjType() {
        return this.bjType;
    }

    public void setBjType(String bjType) {
        this.bjType = bjType;
    }

    public void copy(Superviselog other) {

        this.setLogid(other.getLogid());

        this.loglevel = other.getLoglevel();
        this.usercode = other.getUsercode();
        this.opttime = other.getOpttime();
        this.optid = other.getOptid();
        this.optmethod = other.getOptmethod();
        this.optcontent = other.getOptcontent();
        this.oldvalue = other.getOldvalue();
        this.tagid = other.getTagid();
        this.bjType = other.getBjType();
        this.logType = other.getLogType();

    }

    public void copyNotNullProperty(Superviselog other) {
        if (other.getLogid() != null)
            this.setLogid(other.getLogid());

        if (other.getLoglevel() != null)
            this.loglevel = other.getLoglevel();
        if (other.getUsercode() != null)
            this.usercode = other.getUsercode();
        if (other.getOpttime() != null)
            this.opttime = other.getOpttime();
        if (other.getOptid() != null)
            this.optid = other.getOptid();
        if (other.getOptmethod() != null)
            this.optmethod = other.getOptmethod();
        if (other.getOptcontent() != null)
            this.optcontent = other.getOptcontent();
        if (other.getOldvalue() != null)
            this.oldvalue = other.getOldvalue();
        if (other.getTagid() != null)
            this.tagid = other.getTagid();
        if (other.getBjType() != null)
            this.bjType = other.getBjType();
        if (other.getLogType() != null)
            this.logType = other.getLogType();
    }

    public void clearProperties() {
        this.loglevel = null;
        this.usercode = null;
        this.opttime = null;
        this.optid = null;
        this.optmethod = null;
        this.optcontent = null;
        this.oldvalue = null;
        this.tagid = null;
        this.bjType = null;
    }
}
