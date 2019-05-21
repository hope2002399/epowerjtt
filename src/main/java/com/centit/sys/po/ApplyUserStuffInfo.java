package com.centit.sys.po;

public class ApplyUserStuffInfo {

    private String userID;

    private String filename;

    private byte[] filecontent;

    public byte[] getFilecontent() {
        return filecontent;
    }

    public void setFilecontent(byte[] filecontent) {
        this.filecontent = filecontent;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void copy(ApplyUserStuffInfo other) {

        this.userID = other.getUserID();
        this.filename = other.getFilename();
        this.filecontent = other.getFilecontent();

    }

    public void copyNotNullProperty(ApplyUserStuffInfo other) {

        if (other.getUserID() != null)
            this.userID = other.getUserID();

        if (other.getFilename() != null)
            this.filename = other.getFilename();
        if (other.getFilecontent() != null)
            this.filecontent = other.getFilecontent();
    }

    public void clearProperties() {

        this.userID = null;
        this.filename = null;
        this.filecontent = null;

    }

}
