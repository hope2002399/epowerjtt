package com.centit.monitor.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class OutwayWarnpoint implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String wpNo;

    private String wpType;
    private String wpLevel;
    private String wpLevelNo;
    private String wpDesc;
    private String wpTypeNo;
    private String wpStatus;
    private String wpSource;
    private String wpOracle;
    private String wpOracleSql;
    private String wpRunning;
    private String wpExeType;
    private String wpExeRule;
    private String wpName;

    // Constructors
    /** default constructor */
    public OutwayWarnpoint() {
    }

    /** minimal constructor */
    public OutwayWarnpoint(String wpNo) {

        this.wpNo = wpNo;

    }

    /** full constructor */
    public OutwayWarnpoint(String wpNo, String wpType, String wpLevel,
            String wpLevelNo, String wpDesc, String wpTypeNo, String wpStatus,
            String wpSource, String wpOracle, String wpOracleSql,
            String wpRunning, String wpExeType, String wpExeRule, String wpName) {

        this.wpNo = wpNo;

        this.wpType = wpType;
        this.wpLevel = wpLevel;
        this.wpLevelNo = wpLevelNo;
        this.wpDesc = wpDesc;
        this.wpTypeNo = wpTypeNo;
        this.wpStatus = wpStatus;
        this.wpSource = wpSource;
        this.wpOracle = wpOracle;
        this.wpOracleSql = wpOracleSql;
        this.wpRunning = wpRunning;
        this.wpExeType = wpExeType;
        this.wpExeRule = wpExeRule;
        this.wpName = wpName;
    }

    public String getWpNo() {
        return this.wpNo;
    }

    public void setWpNo(String wpNo) {
        this.wpNo = wpNo;
    }

    // Property accessors

    public String getWpType() {
        return this.wpType;
    }

    public void setWpType(String wpType) {
        this.wpType = wpType;
    }

    public String getWpLevel() {
        return this.wpLevel;
    }

    public void setWpLevel(String wpLevel) {
        this.wpLevel = wpLevel;
    }

    public String getWpLevelNo() {
        return this.wpLevelNo;
    }

    public void setWpLevelNo(String wpLevelNo) {
        this.wpLevelNo = wpLevelNo;
    }

    public String getWpDesc() {
        return this.wpDesc;
    }

    public void setWpDesc(String wpDesc) {
        this.wpDesc = wpDesc;
    }

    public String getWpTypeNo() {
        return this.wpTypeNo;
    }

    public void setWpTypeNo(String wpTypeNo) {
        this.wpTypeNo = wpTypeNo;
    }

    public String getWpStatus() {
        return this.wpStatus;
    }

    public void setWpStatus(String wpStatus) {
        this.wpStatus = wpStatus;
    }

    public String getWpSource() {
        return this.wpSource;
    }

    public void setWpSource(String wpSource) {
        this.wpSource = wpSource;
    }

    public String getWpOracle() {
        return this.wpOracle;
    }

    public void setWpOracle(String wpOracle) {
        this.wpOracle = wpOracle;
    }

    public String getWpOracleSql() {
        return this.wpOracleSql;
    }

    public void setWpOracleSql(String wpOracleSql) {
        this.wpOracleSql = wpOracleSql;
    }

    public String getWpRunning() {
        return this.wpRunning;
    }

    public void setWpRunning(String wpRunning) {
        this.wpRunning = wpRunning;
    }

    public String getWpExeType() {
        return this.wpExeType;
    }

    public void setWpExeType(String wpExeType) {
        this.wpExeType = wpExeType;
    }

    public String getWpExeRule() {
        return this.wpExeRule;
    }

    public void setWpExeRule(String wpExeRule) {
        this.wpExeRule = wpExeRule;
    }

    public String getWpName() {
        return this.wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
    }

    public void copy(OutwayWarnpoint other) {

        this.setWpNo(other.getWpNo());

        this.wpType = other.getWpType();
        this.wpLevel = other.getWpLevel();
        this.wpLevelNo = other.getWpLevelNo();
        this.wpDesc = other.getWpDesc();
        this.wpTypeNo = other.getWpTypeNo();
        this.wpStatus = other.getWpStatus();
        this.wpSource = other.getWpSource();
        this.wpOracle = other.getWpOracle();
        this.wpOracleSql = other.getWpOracleSql();
        this.wpRunning = other.getWpRunning();
        this.wpExeType = other.getWpExeType();
        this.wpExeRule = other.getWpExeRule();
        this.wpName = other.getWpName();

    }

    public void copyNotNullProperty(OutwayWarnpoint other) {

        if (other.getWpNo() != null)
            this.setWpNo(other.getWpNo());

        if (other.getWpType() != null)
            this.wpType = other.getWpType();
        if (other.getWpLevel() != null)
            this.wpLevel = other.getWpLevel();
        if (other.getWpLevelNo() != null)
            this.wpLevelNo = other.getWpLevelNo();
        if (other.getWpDesc() != null)
            this.wpDesc = other.getWpDesc();
        if (other.getWpTypeNo() != null)
            this.wpTypeNo = other.getWpTypeNo();
        if (other.getWpStatus() != null)
            this.wpStatus = other.getWpStatus();
        if (other.getWpSource() != null)
            this.wpSource = other.getWpSource();
        if (other.getWpOracle() != null)
            this.wpOracle = other.getWpOracle();
        if (other.getWpOracleSql() != null)
            this.wpOracleSql = other.getWpOracleSql();
        if (other.getWpRunning() != null)
            this.wpRunning = other.getWpRunning();
        if (other.getWpExeType() != null)
            this.wpExeType = other.getWpExeType();
        if (other.getWpExeRule() != null)
            this.wpExeRule = other.getWpExeRule();
        if (other.getWpName() != null)
            this.wpName = other.getWpName();

    }

    public void clearProperties() {

        this.wpType = null;
        this.wpLevel = null;
        this.wpLevelNo = null;
        this.wpDesc = null;
        this.wpTypeNo = null;
        this.wpStatus = null;
        this.wpSource = null;
        this.wpOracle = null;
        this.wpOracleSql = null;
        this.wpRunning = null;
        this.wpExeType = null;
        this.wpExeRule = null;
        this.wpName = null;

    }
}
