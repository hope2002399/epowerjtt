package com.centit.monitor.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Departmentattribute implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String depNo;

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    private String depID;
    private String supdepno;
    private String depshortname;

    public String getSupdepno() {
        return supdepno;
    }

    public void setSupdepno(String supdepno) {
        this.supdepno = supdepno;
    }

    public String getDepshortname() {
        return depshortname;
    }

    public void setDepshortname(String depshortname) {
        this.depshortname = depshortname;
    }

    private String depLevel;
    private String adminDivision;
    private String depIndustry;

    // Constructors
    /** default constructor */
    public Departmentattribute() {
    }

    /** minimal constructor */
    public Departmentattribute(String depNo) {

        this.depNo = depNo;

    }

    /** full constructor */
    public Departmentattribute(String depNo, String depLevel,
            String adminDivision, String depIndustry) {

        this.depNo = depNo;

        this.depLevel = depLevel;
        this.adminDivision = adminDivision;
        this.depIndustry = depIndustry;
    }

    public String getDepNo() {
        return this.depNo;
    }

    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    // Property accessors

    public String getDepLevel() {
        return this.depLevel;
    }

    public void setDepLevel(String depLevel) {
        this.depLevel = depLevel;
    }

    public String getAdminDivision() {
        return this.adminDivision;
    }

    public void setAdminDivision(String adminDivision) {
        this.adminDivision = adminDivision;
    }

    public String getDepIndustry() {
        return this.depIndustry;
    }

    public void setDepIndustry(String depIndustry) {
        this.depIndustry = depIndustry;
    }

    public void copy(Departmentattribute other) {

        this.setDepNo(other.getDepNo());

        this.depLevel = other.getDepLevel();
        this.adminDivision = other.getAdminDivision();
        this.depIndustry = other.getDepIndustry();

    }

    public void copyNotNullProperty(Departmentattribute other) {

        if (other.getDepNo() != null)
            this.setDepNo(other.getDepNo());

        if (other.getDepLevel() != null)
            this.depLevel = other.getDepLevel();
        if (other.getAdminDivision() != null)
            this.adminDivision = other.getAdminDivision();
        if (other.getDepIndustry() != null)
            this.depIndustry = other.getDepIndustry();

    }
}
