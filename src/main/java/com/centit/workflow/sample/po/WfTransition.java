package com.centit.workflow.sample.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfTransition implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long transid;

    private Long version;
    private String wfcode;
    private String transclass;
    private String transname;
    private String transdesc;
    private Long startnodeid;
    private Long endnodeid;
    private String transcondition;
    private String limitType;
    private String timeLimit;

    // Constructors
    /** default constructor */
    public WfTransition() {
    }

    /** minimal constructor */
    public WfTransition(Long transid) {

        this.transid = transid;

    }

    /** full constructor */
    public WfTransition(Long transid, Long version, String wfcode,
            String transclass, String transname, String transdesc,
            Long startnodeid, Long endnodeid, String transcondition,
            String limitType, String timelimit) {

        this.transid = transid;

        this.version = version;
        this.wfcode = wfcode;
        this.transclass = transclass;
        this.transname = transname;
        this.transdesc = transdesc;
        this.startnodeid = startnodeid;
        this.endnodeid = endnodeid;
        this.transcondition = transcondition;
        this.limitType = limitType;
        this.timeLimit = timelimit;
    }

    /**
     * 期限类别 I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限
     * cycle、H 继承上一个节点剩余时间 hierarchical。
     * 
     * @return
     */
    public String getLimitType() {
        return limitType;
    }

    /**
     * 期限类别 I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限
     * cycle、H 继承上一个节点剩余时间 hierarchical。
     * 
     * @param limitType
     */
    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(String timelimit) {
        this.timeLimit = timelimit;
    }

    public Long getTransid() {
        return this.transid;
    }

    public void setTransid(Long transid) {
        this.transid = transid;
    }

    // Property accessors

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getWfcode() {
        return this.wfcode;
    }

    public void setWfcode(String wfcode) {
        this.wfcode = wfcode;
    }

    public String getTransclass() {
        return this.transclass;
    }

    public void setTransclass(String transclass) {
        this.transclass = transclass;
    }

    public String getTransname() {
        return this.transname;
    }

    public void setTransname(String transname) {
        this.transname = transname;
    }

    public String getTransdesc() {
        return this.transdesc;
    }

    public void setTransdesc(String transdesc) {
        this.transdesc = transdesc;
    }

    public Long getStartnodeid() {
        return this.startnodeid;
    }

    public void setStartnodeid(Long startnodeid) {
        this.startnodeid = startnodeid;
    }

    public Long getEndnodeid() {
        return this.endnodeid;
    }

    public void setEndnodeid(Long endnodeid) {
        this.endnodeid = endnodeid;
    }

    public String getTranscondition() {
        return this.transcondition;
    }

    public void setTranscondition(String transcondition) {
        this.transcondition = transcondition;
    }

    public void copy(WfTransition other) {

        this.setTransid(other.getTransid());

        this.version = other.getVersion();
        this.wfcode = other.getWfcode();
        this.transclass = other.getTransclass();
        this.transname = other.getTransname();
        this.transdesc = other.getTransdesc();
        this.startnodeid = other.getStartnodeid();
        this.endnodeid = other.getEndnodeid();
        this.transcondition = other.getTranscondition();
        this.limitType = other.getLimitType();
        this.timeLimit = other.getTimeLimit();
    }

    public void copyNotNullProperty(WfTransition other) {

        if (other.getTransid() != null)
            this.setTransid(other.getTransid());

        if (other.getVersion() != null)
            this.version = other.getVersion();
        if (other.getWfcode() != null)
            this.wfcode = other.getWfcode();
        if (other.getTransclass() != null)
            this.transclass = other.getTransclass();
        if (other.getTransname() != null)
            this.transname = other.getTransname();
        if (other.getTransdesc() != null)
            this.transdesc = other.getTransdesc();
        if (other.getStartnodeid() != null)
            this.startnodeid = other.getStartnodeid();
        if (other.getEndnodeid() != null)
            this.endnodeid = other.getEndnodeid();
        if (other.getTranscondition() != null)
            this.transcondition = other.getTranscondition();
        if (other.getLimitType() != null)
            this.limitType = other.getLimitType();
        if (other.getTimeLimit() != null)
            this.limitType = other.getTimeLimit();
    }
}
