package com.centit.poweritem.po;

public class BpowerItemServiceId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String itemId;
    private Long version;

    public BpowerItemServiceId() {
    }

    public BpowerItemServiceId(String itemId, Long version) {

        this.itemId = itemId;
        this.version = version;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof BpowerItemServiceId))
            return false;

        BpowerItemServiceId castOther = (BpowerItemServiceId) other;
        boolean ret = true;

        ret = ret
                && (this.getItemId() == castOther.getItemId() || (this
                        .getItemId() != null && castOther.getItemId() != null && this
                        .getItemId().equals(castOther.getItemId())));

        ret = ret
                && (this.getVersion() == castOther.getVersion() || (this
                        .getVersion() != null && castOther.getVersion() != null && this
                        .getVersion().equals(castOther.getVersion())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (this.getItemId() == null ? 0 : this.getItemId().hashCode());

        result = 37
                * result
                + (this.getVersion() == null ? 0 : this.getVersion().hashCode());

        return result;
    }

}
