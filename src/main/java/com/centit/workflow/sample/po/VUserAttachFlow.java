package com.centit.workflow.sample.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VUserAttachFlow implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private VUserAttachFlowId cid;

    // Constructors
    /** default constructor */
    public VUserAttachFlow() {
    }

    /** full constructor */
    public VUserAttachFlow(VUserAttachFlowId id

    ) {
        this.cid = id;

    }

    public VUserAttachFlowId getCid() {
        return this.cid;
    }

    public void setCid(VUserAttachFlowId id) {
        this.cid = id;
    }

    public Long getFlowInstId() {
        if (this.cid == null)
            this.cid = new VUserAttachFlowId();
        return this.cid.getFlowInstId();
    }

    public void setFlowInstId(Long flowInstId) {
        if (this.cid == null)
            this.cid = new VUserAttachFlowId();
        this.cid.setFlowInstId(flowInstId);
    }

    public String getUserCode() {
        if (this.cid == null)
            this.cid = new VUserAttachFlowId();
        return this.cid.getUserCode();
    }

    public void setUserCode(String userCode) {
        if (this.cid == null)
            this.cid = new VUserAttachFlowId();
        this.cid.setUserCode(userCode);
    }

    public String getFlowPhase() {
        if (this.cid == null)
            this.cid = new VUserAttachFlowId();
        return this.cid.getFlowPhase();
    }

    public void setFlowPhase(String flowPhase) {
        if (this.cid == null)
            this.cid = new VUserAttachFlowId();
        this.cid.setUserCode(flowPhase);
    }

    // Property accessors

    public void copy(VUserAttachFlow other) {

        this.setFlowInstId(other.getFlowInstId());
        this.setUserCode(other.getUserCode());

    }

    public void copyNotNullProperty(VUserAttachFlow other) {

        if (other.getFlowInstId() != null)
            this.setFlowInstId(other.getFlowInstId());
        if (other.getUserCode() != null)
            this.setUserCode(other.getUserCode());

    }

    public void clearProperties() {

    }

}
