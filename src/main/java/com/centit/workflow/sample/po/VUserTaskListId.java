package com.centit.workflow.sample.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class VUserTaskListId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long taskId;

    private Long nodeInstId;

    private String unitCode;

    private String userCode;

    // Constructors
    /** default constructor */
    public VUserTaskListId() {
    }

    /** full constructor */
    public VUserTaskListId(Long taskId, Long nodeInstId, String unitCode,
            String userCode) {
        this.taskId = taskId;
        this.nodeInstId = nodeInstId;
        this.unitCode = unitCode;
        this.userCode = userCode;

    }

    public Long getNodeInstId() {
        return this.nodeInstId;
    }

    public void setNodeInstId(Long nodeInstId) {
        this.nodeInstId = nodeInstId;
    }

    public String getUnitCode() {
        return this.unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
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
        if (!(other instanceof VUserTaskListId))
            return false;

        VUserTaskListId castOther = (VUserTaskListId) other;
        boolean ret = true;

        ret = ret
                && (this.getTaskId() == castOther.getTaskId() || (this
                        .getTaskId() != null && castOther.getTaskId() != null && this
                        .getTaskId().equals(castOther.getTaskId())));

        ret = ret
                && (this.getNodeInstId() == castOther.getNodeInstId() || (this
                        .getNodeInstId() != null
                        && castOther.getNodeInstId() != null && this
                        .getNodeInstId().equals(castOther.getNodeInstId())));

        ret = ret
                && (this.getUnitCode() == castOther.getUnitCode() || (this
                        .getUnitCode() != null
                        && castOther.getUnitCode() != null && this
                        .getUnitCode().equals(castOther.getUnitCode())));

        ret = ret
                && (this.getUserCode() == castOther.getUserCode() || (this
                        .getUserCode() != null
                        && castOther.getUserCode() != null && this
                        .getUserCode().equals(castOther.getUserCode())));

        return ret;
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result
                + (this.getTaskId() == null ? 0 : this.getTaskId().hashCode());

        result = 37
                * result
                + (this.getNodeInstId() == null ? 0 : this.getNodeInstId()
                        .hashCode());

        result = 37
                * result
                + (this.getUnitCode() == null ? 0 : this.getUnitCode()
                        .hashCode());

        result = 37
                * result
                + (this.getUserCode() == null ? 0 : this.getUserCode()
                        .hashCode());

        return result;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
