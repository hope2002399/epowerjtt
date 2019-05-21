package com.centit.workflow.sample.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class WfInstAttentionId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String userCode;

    private Long flowInstId;

    // Constructors
    /** default constructor */
    public WfInstAttentionId() {
    }

    /** full constructor */
    public WfInstAttentionId(String userCode, Long flowInstId) {

        this.userCode = userCode;
        this.flowInstId = flowInstId;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WfInstAttentionId))
            return false;

        WfInstAttentionId castOther = (WfInstAttentionId) other;
        boolean ret = true;

        ret = ret
                && (this.getUserCode() == castOther.getUserCode() || (this
                        .getUserCode() != null
                        && castOther.getUserCode() != null && this
                        .getUserCode().equals(castOther.getUserCode())));

        ret = ret
                && (this.getFlowInstId() == castOther.getFlowInstId() || (this
                        .getFlowInstId() != null
                        && castOther.getFlowInstId() != null && this
                        .getFlowInstId().equals(castOther.getFlowInstId())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37
                * result
                + (this.getUserCode() == null ? 0 : this.getUserCode()
                        .hashCode());

        result = 37
                * result
                + (this.getFlowInstId() == null ? 0 : this.getFlowInstId()
                        .hashCode());

        return result;
    }
}
