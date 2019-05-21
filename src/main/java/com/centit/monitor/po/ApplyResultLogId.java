package com.centit.monitor.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class ApplyResultLogId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String no;

    private Long changNo;

    // Constructors
    /** default constructor */
    public ApplyResultLogId() {
    }

    /** full constructor */
    public ApplyResultLogId(String no, Long changNo) {

        this.no = no;
        this.changNo = changNo;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Long getChangNo() {
        return this.changNo;
    }

    public void setChangNo(Long changNo) {
        this.changNo = changNo;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof ApplyResultLogId))
            return false;

        ApplyResultLogId castOther = (ApplyResultLogId) other;
        boolean ret = true;

        ret = ret
                && (this.getNo() == castOther.getNo() || (this.getNo() != null
                        && castOther.getNo() != null && this.getNo().equals(
                        castOther.getNo())));

        ret = ret
                && (this.getChangNo() == castOther.getChangNo() || (this
                        .getChangNo() != null && castOther.getChangNo() != null && this
                        .getChangNo().equals(castOther.getChangNo())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (this.getNo() == null ? 0 : this.getNo().hashCode());

        result = 37
                * result
                + (this.getChangNo() == null ? 0 : this.getChangNo().hashCode());

        return result;
    }
}
