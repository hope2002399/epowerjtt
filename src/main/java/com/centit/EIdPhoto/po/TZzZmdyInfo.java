package com.centit.EIdPhoto.po;

/**
 * 
 * TODO Class description should be added
 * 
 * @author dzf
 * @create 2017年9月15日
 * @version
 */
public class TZzZmdyInfo implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 153901427579185625L;
    //部门电子证照实施清单主键(必填)
    private String mouldId;
    //电子证照目录编号
    private String mouldNumber;
    //行业编号
    private String deptId;
    //行业
    private String hyCode;
    //证照名称
    private String zzName;
    //业务名称
    private String outItemName;
    //业务编码
    private String outItemId;
    //是否省级
    private String isProvince;
    //是否市级
    private String isCity;
    //是否县级
    private String isCounty;
    
    
    public TZzZmdyInfo(){}
    
    
    public TZzZmdyInfo(String mouldId, String mouldNumber, String deptId,
            String hyCode, String zzName, String outItemName, String outItemId,
            String isProvince, String isCity, String isCounty) {
        super();
        this.mouldId = mouldId;
        this.mouldNumber = mouldNumber;
        this.deptId = deptId;
        this.hyCode = hyCode;
        this.zzName = zzName;
        this.outItemName = outItemName;
        this.outItemId = outItemId;
        this.isProvince = isProvince;
        this.isCity = isCity;
        this.isCounty = isCounty;
    }
    public String getMouldId() {
        return mouldId;
    }
    public void setMouldId(String mouldId) {
        this.mouldId = mouldId;
    }
    public String getMouldNumber() {
        return mouldNumber;
    }
    public void setMouldNumber(String mouldNumber) {
        this.mouldNumber = mouldNumber;
    }
    public String getDeptId() {
        return deptId;
    }
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    public String getHyCode() {
        return hyCode;
    }
    public void setHyCode(String hyCode) {
        this.hyCode = hyCode;
    }
    public String getZzName() {
        return zzName;
    }
    public void setZzName(String zzName) {
        this.zzName = zzName;
    }
    public String getOutItemName() {
        return outItemName;
    }
    public void setOutItemName(String outItemName) {
        this.outItemName = outItemName;
    }
    public String getOutItemId() {
        return outItemId;
    }
    public void setOutItemId(String outItemId) {
        this.outItemId = outItemId;
    }
    public String getIsProvince() {
        return isProvince;
    }
    public void setIsProvince(String isProvince) {
        this.isProvince = isProvince;
    }
    public String getIsCity() {
        return isCity;
    }
    public void setIsCity(String isCity) {
        this.isCity = isCity;
    }
    public String getIsCounty() {
        return isCounty;
    }
    public void setIsCounty(String isCounty) {
        this.isCounty = isCounty;
    }
    
    
    
    
}
