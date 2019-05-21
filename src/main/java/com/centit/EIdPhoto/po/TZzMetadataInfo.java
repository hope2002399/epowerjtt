package com.centit.EIdPhoto.po;

public class TZzMetadataInfo implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8032257371543271608L;

    private String id;
    
    private String mouldId;
    
    private String columnName;
    
    private String columnType;
    
    

    public TZzMetadataInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TZzMetadataInfo(String id, String mouldId, String columnName,
            String columnType) {
        super();
        this.id = id;
        this.mouldId = mouldId;
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMouldId() {
        return mouldId;
    }

    public void setMouldId(String mouldId) {
        this.mouldId = mouldId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    
    
    
}
