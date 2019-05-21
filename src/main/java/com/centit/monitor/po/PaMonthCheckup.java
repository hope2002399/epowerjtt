package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class PaMonthCheckup implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long pieceNo;

    private String checkType;
    private String userCode;
    private String orgId;
    private String countYear;

    public String getCountYear() {
        return countYear;
    }

    public void setCountYear(String countYear) {
        this.countYear = countYear;
    }

    public String getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(String countMonth) {
        this.countMonth = countMonth;
    }

    private String countMonth;
    private Date createDate;
    private String itemCode;
    private String itemName;
    private Double itemValue;
    private String itemUnit;
    private String itemRuleDesc;
    private String itemRule;

    // Constructors
    /** default constructor */
    public PaMonthCheckup() {
    }

    /** minimal constructor */
    public PaMonthCheckup(Long pieceNo, String checkType, String countYear,
            String countMonth, String itemCode) {

        this.pieceNo = pieceNo;

        this.checkType = checkType;
        this.countYear = countYear;
        this.countMonth = countMonth;
        this.itemCode = itemCode;
    }

    /** full constructor */
    public PaMonthCheckup(Long pieceNo, String checkType, String userCode,
            String orgId, String countYear, String countMonth, Date createDate,
            String itemCode, String itemName, Double itemValue,
            String itemUnit, String itemRuleDesc, String itemRule) {

        this.pieceNo = pieceNo;

        this.checkType = checkType;
        this.userCode = userCode;
        this.orgId = orgId;
        this.countYear = countYear;
        this.countMonth = countMonth;
        this.createDate = createDate;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemUnit = itemUnit;
        this.itemRuleDesc = itemRuleDesc;
        this.itemRule = itemRule;
    }

    public Long getPieceNo() {
        return this.pieceNo;
    }

    public void setPieceNo(Long pieceNo) {
        this.pieceNo = pieceNo;
    }

    // Property accessors

    public String getCheckType() {
        return this.checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemValue() {
        return this.itemValue;
    }

    public void setItemValue(Double itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemUnit() {
        return this.itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemRuleDesc() {
        return this.itemRuleDesc;
    }

    public void setItemRuleDesc(String itemRuleDesc) {
        this.itemRuleDesc = itemRuleDesc;
    }

    public String getItemRule() {
        return this.itemRule;
    }

    public void setItemRule(String itemRule) {
        this.itemRule = itemRule;
    }

    public void copy(PaMonthCheckup other) {

        this.setPieceNo(other.getPieceNo());

        this.checkType = other.getCheckType();
        this.userCode = other.getUserCode();
        this.orgId = other.getOrgId();
        this.countYear = other.getCountYear();
        this.countMonth = other.getCountMonth();
        this.createDate = other.getCreateDate();
        this.itemCode = other.getItemCode();
        this.itemName = other.getItemName();
        this.itemValue = other.getItemValue();
        this.itemUnit = other.getItemUnit();
        this.itemRuleDesc = other.getItemRuleDesc();
        this.itemRule = other.getItemRule();

    }

    public void copyNotNullProperty(PaMonthCheckup other) {

        if (other.getPieceNo() != null)
            this.setPieceNo(other.getPieceNo());

        if (other.getCheckType() != null)
            this.checkType = other.getCheckType();
        if (other.getUserCode() != null)
            this.userCode = other.getUserCode();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getCountYear() != null)
            this.countYear = other.getCountYear();
        if (other.getCountMonth() != null)
            this.countMonth = other.getCountMonth();
        if (other.getCreateDate() != null)
            this.createDate = other.getCreateDate();
        if (other.getItemCode() != null)
            this.itemCode = other.getItemCode();
        if (other.getItemName() != null)
            this.itemName = other.getItemName();
        if (other.getItemValue() != null)
            this.itemValue = other.getItemValue();
        if (other.getItemUnit() != null)
            this.itemUnit = other.getItemUnit();
        if (other.getItemRuleDesc() != null)
            this.itemRuleDesc = other.getItemRuleDesc();
        if (other.getItemRule() != null)
            this.itemRule = other.getItemRule();

    }

    public void clearProperties() {

        this.checkType = null;
        this.userCode = null;
        this.orgId = null;
        this.countYear = null;
        this.countMonth = null;
        this.createDate = null;
        this.itemCode = null;
        this.itemName = null;
        this.itemValue = null;
        this.itemUnit = null;
        this.itemRuleDesc = null;
        this.itemRule = null;

    }
}
