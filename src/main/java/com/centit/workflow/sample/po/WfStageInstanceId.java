package com.centit.workflow.sample.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class WfStageInstanceId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long flowInstId;

    private Long stageId;

    // Constructors
    /** default constructor */
    public WfStageInstanceId() {
    }

    /** full constructor */
    public WfStageInstanceId(Long flowInstId, Long stageId) {

        this.flowInstId = flowInstId;
        this.stageId = stageId;
    }

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public Long getStageId() {
        return this.stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WfStageInstanceId))
            return false;

        WfStageInstanceId castOther = (WfStageInstanceId) other;
        boolean ret = true;

        ret = ret
                && (this.getFlowInstId() == castOther.getFlowInstId() || (this
                        .getFlowInstId() != null
                        && castOther.getFlowInstId() != null && this
                        .getFlowInstId().equals(castOther.getFlowInstId())));

        ret = ret
                && (this.getStageId() == castOther.getStageId() || (this
                        .getStageId() != null && castOther.getStageId() != null && this
                        .getStageId().equals(castOther.getStageId())));

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
                + (this.getStageId() == null ? 0 : this.getStageId().hashCode());

        return result;
    }
}
