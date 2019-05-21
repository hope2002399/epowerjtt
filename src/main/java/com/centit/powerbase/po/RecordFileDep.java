package com.centit.powerbase.po;

public class RecordFileDep implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String recordCode;
    private String constituteDepID;
    private String no;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getConstituteDepID() {
        return constituteDepID;
    }

    public void setConstituteDepID(String constituteDepID) {
        this.constituteDepID = constituteDepID;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

}
