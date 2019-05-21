package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PoprintdefId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long depid;

    private String printtype;

    // Constructors
    /** default constructor */
    public PoprintdefId() {
    }

    /** full constructor */
    public PoprintdefId(Long depid, String printtype) {

        this.depid = depid;
        this.printtype = printtype;
    }

    public Long getDepid() {
        return this.depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public String getPrinttype() {
        return this.printtype;
    }

    public void setPrinttype(String printtype) {
        this.printtype = printtype;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PoprintdefId))
            return false;

        PoprintdefId castOther = (PoprintdefId) other;
        boolean ret = true;

        ret = ret
                && (this.getDepid() == castOther.getDepid() || (this.getDepid() != null
                        && castOther.getDepid() != null && this.getDepid()
                        .equals(castOther.getDepid())));

        ret = ret
                && (this.getPrinttype() == castOther.getPrinttype() || (this
                        .getPrinttype() != null
                        && castOther.getPrinttype() != null && this
                        .getPrinttype().equals(castOther.getPrinttype())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (this.getDepid() == null ? 0 : this.getDepid().hashCode());

        result = 37
                * result
                + (this.getPrinttype() == null ? 0 : this.getPrinttype()
                        .hashCode());

        return result;
    }
}
