package com.centit.workflow.sample.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class WfFlowDefineId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long version;

    private String wfcode;

    // Constructors
    /** default constructor */
    public WfFlowDefineId() {
    }

    /** full constructor */
    public WfFlowDefineId(Long version, String wfcode) {

        this.version = version;
        this.wfcode = wfcode;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFlowCode() {
        return this.wfcode;
    }

    public void setFlowCode(String wfcode) {
        this.wfcode = wfcode;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WfFlowDefineId))
            return false;

        WfFlowDefineId castOther = (WfFlowDefineId) other;
        boolean ret = true;

        ret = ret
                && (this.getVersion() == castOther.getVersion() || (this
                        .getVersion() != null && castOther.getVersion() != null && this
                        .getVersion().equals(castOther.getVersion())));

        ret = ret
                && (this.getFlowCode() == castOther.getFlowCode() || (this
                        .getFlowCode() != null
                        && castOther.getFlowCode() != null && this
                        .getFlowCode().equals(castOther.getFlowCode())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37
                * result
                + (this.getVersion() == null ? 0 : this.getVersion().hashCode());

        result = 37
                * result
                + (this.getFlowCode() == null ? 0 : this.getFlowCode()
                        .hashCode());

        return result;
    }
}
