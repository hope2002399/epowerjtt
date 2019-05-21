package com.centit.monitor.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Outwayparam implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String paramNo;

    private String paramName;
    private String defaultValue;
    private String paramValue;
    private String paramDesc;
    private String paramType;

    // Constructors
    /** default constructor */
    public Outwayparam() {
    }

    /** minimal constructor */
    public Outwayparam(String paramNo, String paramName, String defaultValue,
            String paramDesc) {

        this.paramNo = paramNo;

        this.paramName = paramName;
        this.defaultValue = defaultValue;
        this.paramDesc = paramDesc;
    }

    /** full constructor */
    public Outwayparam(String paramNo, String paramName, String defaultValue,
            String paramValue, String paramDesc, String paramType) {

        this.paramNo = paramNo;

        this.paramName = paramName;
        this.defaultValue = defaultValue;
        this.paramValue = paramValue;
        this.paramDesc = paramDesc;
        this.paramType = paramType;
    }

    public String getParamNo() {
        return this.paramNo;
    }

    public void setParamNo(String paramNo) {
        this.paramNo = paramNo;
    }

    // Property accessors

    public String getParamName() {
        return this.paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getParamValue() {
        return this.paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamDesc() {
        return this.paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    public String getParamType() {
        return this.paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public void copy(Outwayparam other) {

        this.setParamNo(other.getParamNo());

        this.paramName = other.getParamName();
        this.defaultValue = other.getDefaultValue();
        this.paramValue = other.getParamValue();
        this.paramDesc = other.getParamDesc();
        this.paramType = other.getParamType();

    }

    public void copyNotNullProperty(Outwayparam other) {

        if (other.getParamNo() != null)
            this.setParamNo(other.getParamNo());

        if (other.getParamName() != null)
            this.paramName = other.getParamName();
        if (other.getDefaultValue() != null)
            this.defaultValue = other.getDefaultValue();
        if (other.getParamValue() != null)
            this.paramValue = other.getParamValue();
        if (other.getParamDesc() != null)
            this.paramDesc = other.getParamDesc();
        if (other.getParamType() != null)
            this.paramType = other.getParamType();

    }

    public void clearProperties() {

        this.paramName = null;
        this.defaultValue = null;
        this.paramValue = null;
        this.paramDesc = null;
        this.paramType = null;

    }
}
