package com.centit.powerbase.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class LawVehicle implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String vehicleId;

    private String plateNumber;
    private String vehicleType;
    private Date purchaseDate;
    private Double purchasePrice;
    private String engineNo;
    private String carframeNo;
    private String ownerUnit;
    private String vehicleAdmin;
    private Date recordDate;
    private String recorder;

    // Constructors
    /** default constructor */
    public LawVehicle() {
    }

    /** minimal constructor */
    public LawVehicle(String vehicleId) {

        this.vehicleId = vehicleId;

    }

    /** full constructor */
    public LawVehicle(String vehicleId, String plateNumber, String vehicleType,
            Date purchaseDate, Double purchasePrice, String engineNo,
            String carframeNo, String ownerUnit, String vehicleAdmin,
            Date recordDate, String recorder) {

        this.vehicleId = vehicleId;

        this.plateNumber = plateNumber;
        this.vehicleType = vehicleType;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.engineNo = engineNo;
        this.carframeNo = carframeNo;
        this.ownerUnit = ownerUnit;
        this.vehicleAdmin = vehicleAdmin;
        this.recordDate = recordDate;
        this.recorder = recorder;
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    // Property accessors

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getEngineNo() {
        return this.engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getCarframeNo() {
        return this.carframeNo;
    }

    public void setCarframeNo(String carframeNo) {
        this.carframeNo = carframeNo;
    }

    public String getOwnerUnit() {
        return this.ownerUnit;
    }

    public void setOwnerUnit(String ownerUnit) {
        this.ownerUnit = ownerUnit;
    }

    public String getVehicleAdmin() {
        return this.vehicleAdmin;
    }

    public void setVehicleAdmin(String vehicleAdmin) {
        this.vehicleAdmin = vehicleAdmin;
    }

    public Date getRecordDate() {
        return this.recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecorder() {
        return this.recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public void copy(LawVehicle other) {

        this.setVehicleId(other.getVehicleId());

        this.plateNumber = other.getPlateNumber();
        this.vehicleType = other.getVehicleType();
        this.purchaseDate = other.getPurchaseDate();
        this.purchasePrice = other.getPurchasePrice();
        this.engineNo = other.getEngineNo();
        this.carframeNo = other.getCarframeNo();
        this.ownerUnit = other.getOwnerUnit();
        this.vehicleAdmin = other.getVehicleAdmin();
        this.recordDate = other.getRecordDate();
        this.recorder = other.getRecorder();

    }

    public void copyNotNullProperty(LawVehicle other) {

        if (other.getVehicleId() != null)
            this.setVehicleId(other.getVehicleId());

        if (other.getPlateNumber() != null)
            this.plateNumber = other.getPlateNumber();
        if (other.getVehicleType() != null)
            this.vehicleType = other.getVehicleType();
        if (other.getPurchaseDate() != null)
            this.purchaseDate = other.getPurchaseDate();
        if (other.getPurchasePrice() != null)
            this.purchasePrice = other.getPurchasePrice();
        if (other.getEngineNo() != null)
            this.engineNo = other.getEngineNo();
        if (other.getCarframeNo() != null)
            this.carframeNo = other.getCarframeNo();
        if (other.getOwnerUnit() != null)
            this.ownerUnit = other.getOwnerUnit();
        if (other.getVehicleAdmin() != null)
            this.vehicleAdmin = other.getVehicleAdmin();
        if (other.getRecordDate() != null)
            this.recordDate = other.getRecordDate();
        if (other.getRecorder() != null)
            this.recorder = other.getRecorder();

    }

    public void clearProperties() {

        this.plateNumber = null;
        this.vehicleType = null;
        this.purchaseDate = null;
        this.purchasePrice = null;
        this.engineNo = null;
        this.carframeNo = null;
        this.ownerUnit = null;
        this.vehicleAdmin = null;
        this.recordDate = null;
        this.recorder = null;

    }
}
