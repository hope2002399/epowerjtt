package com.centit.punish.po;

import java.util.Date;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PodetainwptransinfoId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String wpid;

    private Date optdate;

    // Constructors
    /** default constructor */
    public PodetainwptransinfoId() {
    }

    /** full constructor */
    public PodetainwptransinfoId(String wpid, Date optdate) {

        this.wpid = wpid;
        this.optdate = optdate;
    }

    public String getWpid() {
        return this.wpid;
    }

    public void setWpid(String wpid) {
        this.wpid = wpid;
    }

    public Date getOptdate() {
        return this.optdate;
    }

    public void setOptdate(Date optdate) {
        this.optdate = optdate;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PodetainwptransinfoId))
            return false;

        PodetainwptransinfoId castOther = (PodetainwptransinfoId) other;
        boolean ret = true;

        ret = ret
                && (this.getWpid() == castOther.getWpid() || (this.getWpid() != null
                        && castOther.getWpid() != null && this.getWpid()
                        .equals(castOther.getWpid())));

        ret = ret
                && (this.getOptdate() == castOther.getOptdate() || (this
                        .getOptdate() != null && castOther.getOptdate() != null && this
                        .getOptdate().equals(castOther.getOptdate())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (this.getWpid() == null ? 0 : this.getWpid().hashCode());

        result = 37
                * result
                + (this.getOptdate() == null ? 0 : this.getOptdate().hashCode());

        return result;
    }
}
