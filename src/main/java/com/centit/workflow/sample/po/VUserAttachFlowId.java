package com.centit.workflow.sample.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class VUserAttachFlowId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long flowInstId;

    private String userCode;

    private String flowPhase;

    // Constructors
    /** default constructor */
    public VUserAttachFlowId() {
    }

    /** full constructor */
    public VUserAttachFlowId(Long flowInstId, String userCode) {

        this.flowInstId = flowInstId;
        this.userCode = userCode;
    }

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof VUserAttachFlowId))
            return false;

        VUserAttachFlowId castOther = (VUserAttachFlowId) other;
        boolean ret = true;

        ret = ret
                && (this.getFlowInstId() == castOther.getFlowInstId() || (this
                        .getFlowInstId() != null
                        && castOther.getFlowInstId() != null && this
                        .getFlowInstId().equals(castOther.getFlowInstId())));

        ret = ret
                && (this.getUserCode() == castOther.getUserCode() || (this
                        .getUserCode() != null
                        && castOther.getUserCode() != null && this
                        .getUserCode().equals(castOther.getUserCode())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37
                * result
                + (this.getFlowInstId() == null ? 0 : this.getFlowInstId()
                        .hashCode());

        result = 37
                * result
                + (this.getUserCode() == null ? 0 : this.getUserCode()
                        .hashCode());

        return result;
    }

    public String getFlowPhase() {
        return flowPhase;
    }

    public void setFlowPhase(String flowPhase) {
        this.flowPhase = flowPhase;
    }
}
