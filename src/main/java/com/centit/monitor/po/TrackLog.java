package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class TrackLog implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String trackno;

    private String no;
    private String powertype;
    private String tracktype;
    private String trackoperator;
    private Date tracktime;
    private String trackreason;
    private String untrackoperator;
    private Date untracktime;
    private String untrackreason;

    // Constructors
    /** default constructor */
    public TrackLog() {
    }

    /** minimal constructor */
    public TrackLog(String trackno, String no, String powertype,
            String tracktype, String trackoperator, Date tracktime) {

        this.trackno = trackno;

        this.no = no;
        this.powertype = powertype;
        this.tracktype = tracktype;
        this.trackoperator = trackoperator;
        this.tracktime = tracktime;
    }

    /** full constructor */
    public TrackLog(String trackno, String no, String powertype,
            String tracktype, String trackoperator, Date tracktime,
            String trackreason, String untrackoperator, Date untracktime,
            String untrackreason) {

        this.trackno = trackno;

        this.no = no;
        this.powertype = powertype;
        this.tracktype = tracktype;
        this.trackoperator = trackoperator;
        this.tracktime = tracktime;
        this.trackreason = trackreason;
        this.untrackoperator = untrackoperator;
        this.untracktime = untracktime;
        this.untrackreason = untrackreason;
    }

    public String getTrackno() {
        return this.trackno;
    }

    public void setTrackno(String trackno) {
        this.trackno = trackno;
    }

    // Property accessors

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPowertype() {
        return this.powertype;
    }

    public void setPowertype(String powertype) {
        this.powertype = powertype;
    }

    public String getTracktype() {
        return this.tracktype;
    }

    public void setTracktype(String tracktype) {
        this.tracktype = tracktype;
    }

    public String getTrackoperator() {
        return this.trackoperator;
    }

    public void setTrackoperator(String trackoperator) {
        this.trackoperator = trackoperator;
    }

    public Date getTracktime() {
        return this.tracktime;
    }

    public void setTracktime(Date tracktime) {
        this.tracktime = tracktime;
    }

    public String getTrackreason() {
        return this.trackreason;
    }

    public void setTrackreason(String trackreason) {
        this.trackreason = trackreason;
    }

    public String getUntrackoperator() {
        return this.untrackoperator;
    }

    public void setUntrackoperator(String untrackoperator) {
        this.untrackoperator = untrackoperator;
    }

    public Date getUntracktime() {
        return this.untracktime;
    }

    public void setUntracktime(Date untracktime) {
        this.untracktime = untracktime;
    }

    public String getUntrackreason() {
        return this.untrackreason;
    }

    public void setUntrackreason(String untrackreason) {
        this.untrackreason = untrackreason;
    }

    public void copy(TrackLog other) {

        this.setTrackno(other.getTrackno());

        this.no = other.getNo();
        this.powertype = other.getPowertype();
        this.tracktype = other.getTracktype();
        this.trackoperator = other.getTrackoperator();
        this.tracktime = other.getTracktime();
        this.trackreason = other.getTrackreason();
        this.untrackoperator = other.getUntrackoperator();
        this.untracktime = other.getUntracktime();
        this.untrackreason = other.getUntrackreason();

    }

    public void copyNotNullProperty(TrackLog other) {

        if (other.getTrackno() != null)
            this.setTrackno(other.getTrackno());

        if (other.getNo() != null)
            this.no = other.getNo();
        if (other.getPowertype() != null)
            this.powertype = other.getPowertype();
        if (other.getTracktype() != null)
            this.tracktype = other.getTracktype();
        if (other.getTrackoperator() != null)
            this.trackoperator = other.getTrackoperator();
        if (other.getTracktime() != null)
            this.tracktime = other.getTracktime();
        if (other.getTrackreason() != null)
            this.trackreason = other.getTrackreason();
        if (other.getUntrackoperator() != null)
            this.untrackoperator = other.getUntrackoperator();
        if (other.getUntracktime() != null)
            this.untracktime = other.getUntracktime();
        if (other.getUntrackreason() != null)
            this.untrackreason = other.getUntrackreason();

    }

    public void clearProperties() {

        this.no = null;
        this.powertype = null;
        this.tracktype = null;
        this.trackoperator = null;
        this.tracktime = null;
        this.trackreason = null;
        this.untrackoperator = null;
        this.untracktime = null;
        this.untrackreason = null;

    }
}
