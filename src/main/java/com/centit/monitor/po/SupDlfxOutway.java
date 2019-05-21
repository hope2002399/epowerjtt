package com.centit.monitor.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * TODO Class description should be added
 * 
 * @author zjh
 * @create 2013-12-17
 * @version
 */
public class SupDlfxOutway implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String outwayId;
    private String warnPointNo;
    private String outwayType;
    private String orgId;
    private Date inTime;
    private Date outTime;
    private String outPerson;
    private String outReason;
    private String sync_sign;
    private String error_desc;
    private String isCheck;
    private String isSync;
    private String supervisionType;
    private String analysisType;
    private String year;
    private String month;
    private String itemId;
    private Double hbValue;
    private Double tbValue;
    private Double bzValue;
    private Double sjValue;
    private String desc1;
    @SuppressWarnings("rawtypes")
    private List docList = new ArrayList();

    @SuppressWarnings("rawtypes")
    public List getDocList() {
        return docList;
    }

    @SuppressWarnings("rawtypes")
    public void setDocList(List docList) {
        this.docList = docList;
    }

    // Constructors
    /** default constructor */
    public SupDlfxOutway() {
    }

    /** full constructor */
    public SupDlfxOutway(String outwayId, String warnPointNo,
            String outwayType, String orgId, Date inTime, Date outTime,
            String outPerson, String outReason, String supervisionType,
            String sync_sign, String error_desc, String isCheck, String isSync,
            Double hbValue, String analysisType, Double bzValue,
            Double sjValue, Double tbValue, String month, String year,
            String itemId, String desc1) {
        this.outwayId = outwayId;
        this.warnPointNo = warnPointNo;
        this.outwayType = outwayType;
        this.orgId = orgId;
        this.inTime = inTime;
        this.outTime = outTime;
        this.outPerson = outPerson;
        this.outReason = outReason;
        // this.outwayInfo=outwayInfo;
        this.supervisionType = supervisionType;
        this.sync_sign = sync_sign;
        this.error_desc = error_desc;
        this.isCheck = isCheck;
        this.isSync = isSync;
        this.analysisType = analysisType;
        this.hbValue = hbValue;
        this.month = month;
        this.year = year;
        this.itemId = itemId;
        this.sjValue = sjValue;
        this.bzValue = bzValue;
        this.tbValue = tbValue;
        this.desc1 = desc1;
    }

    public String getOutwayId() {
        return outwayId;
    }

    public void setOutwayId(String outwayId) {
        this.outwayId = outwayId;
    }

    public String getWarnPointNo() {
        return warnPointNo;
    }

    public void setWarnPointNo(String warnPointNo) {
        this.warnPointNo = warnPointNo;
    }

    public String getOutwayType() {
        return outwayType;
    }

    public void setOutwayType(String outwayType) {
        this.outwayType = outwayType;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Double getTbValue() {
        return tbValue;
    }

    public void setTbValue(Double tbValue) {
        this.tbValue = tbValue;
    }

    public Double getBzValue() {
        return bzValue;
    }

    public void setBzValue(Double bzValue) {
        this.bzValue = bzValue;
    }

    public Double getSjValue() {
        return sjValue;
    }

    public void setSjValue(Double sjValue) {
        this.sjValue = sjValue;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getOutPerson() {
        return outPerson;
    }

    public void setOutPerson(String outPerson) {
        this.outPerson = outPerson;
    }

    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }

    public String getSync_sign() {
        return sync_sign;
    }

    public void setSync_sign(String sync_sign) {
        this.sync_sign = sync_sign;
    }

    public String getError_desc() {
        return error_desc;
    }

    public void setError_desc(String error_desc) {
        this.error_desc = error_desc;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    public String getSupervisionType() {
        return supervisionType;
    }

    public void setSupervisionType(String supervisionType) {
        this.supervisionType = supervisionType;
    }

    public String getAnalysisType() {
        return analysisType;
    }

    public void setAnalysisType(String analysisType) {
        this.analysisType = analysisType;
    }

    public Double getHbValue() {
        return hbValue;
    }

    public void setHbValue(Double hbValue) {
        this.hbValue = hbValue;
    }

    public String getIsSync() {
        return isSync;
    }

    public void setIsSync(String isSync) {
        this.isSync = isSync;
    }

    public void copy(SupDlfxOutway other) {
        this.error_desc = other.getError_desc();
        this.inTime = other.getInTime();
        this.isCheck = other.getIsCheck();
        this.isSync = other.getIsSync();
        this.orgId = other.getOrgId();
        this.outPerson = other.getOutPerson();
        this.outReason = other.getOutReason();
        this.outTime = other.getOutTime();
        this.outwayId = other.getOutwayId();
        // this.outwayInfo=other.getOutwayInfo();
        this.outwayType = other.getOutwayType();
        this.sync_sign = other.getSync_sign();
        this.warnPointNo = other.getWarnPointNo();
        this.supervisionType = other.getSupervisionType();
        this.analysisType = other.getAnalysisType();
        this.hbValue = other.getHbValue();
        this.sjValue = other.getSjValue();
        this.bzValue = other.getBzValue();
        this.tbValue = other.getTbValue();
        this.itemId = other.getItemId();
        this.month = other.getMonth();
        this.year = other.getYear();
        this.desc1 = other.getDesc1();
    }

    public void copyNotNullProperty(SupDlfxOutway other) {

        if (other.getOutwayId() != null)
            this.setOutwayId(other.getOutwayId());
        if (other.getError_desc() != null) {
            this.setError_desc(other.getError_desc());
        }
        if (other.getInTime() != null) {
            this.setInTime(other.getInTime());
        }
        if (other.getIsCheck() != null) {
            this.setIsCheck(other.getIsCheck());
        }
        if (other.getIsSync() != null) {
            this.setIsSync(other.getIsSync());
        }
        if (other.getOrgId() != null) {
            this.setOrgId(other.getOrgId());
        }
        if (other.getOutPerson() != null) {
            this.setOutReason(other.getOutPerson());
        }
        if (other.getOutReason() != null) {
            this.setOutReason(other.getOutReason());
        }
        if (other.getOutTime() != null) {
            this.setOutTime(other.getOutTime());
        }
        if (other.getDesc1() != null) {
            this.setDesc1(other.getDesc1());
        }
        if (other.getOutwayType() != null) {
            this.setOutwayType(other.getOutwayType());
        }
        if (other.getSupervisionType() != null) {
            this.setSupervisionType(other.getSupervisionType());
        }
        if (other.getSync_sign() != null) {
            this.setSync_sign(other.getSync_sign());
        }
        if (other.getAnalysisType() != null) {
            this.setAnalysisType(other.getAnalysisType());
        }
        if (other.getWarnPointNo() != null) {
            this.setWarnPointNo(other.getWarnPointNo());
        }
        if (other.getHbValue() != null) {
            this.setHbValue(other.getHbValue());
        }
        if (other.getMonth() != null) {
            this.setMonth(other.getMonth());
        }
        if (other.getYear() != null) {
            this.setYear(other.getYear());
        }
        if (other.getItemId() != null) {
            this.setItemId(other.getItemId());
        }
        if (other.getBzValue() != null) {
            this.setBzValue(other.getBzValue());
        }
        if (other.getSjValue() != null) {
            this.setSjValue(other.getSjValue());
        }
        if (other.getTbValue() != null) {
            this.setTbValue(other.getTbValue());
        }
    }

    public void clearProperties() {
        this.outwayId = null;
        this.error_desc = null;
        this.inTime = null;
        this.isCheck = null;
        this.isSync = null;
        this.orgId = null;
        this.outPerson = null;
        this.outReason = null;
        this.outTime = null;
        // this.outwayInfo=null;
        this.outwayType = null;
        this.sync_sign = null;
        this.warnPointNo = null;
        this.supervisionType = null;
        this.analysisType = null;
        this.hbValue = null;
        this.bzValue = null;
        this.month = null;
        this.year = null;
        this.itemId = null;
        this.sjValue = null;
        this.tbValue = null;
        this.desc1 = null;
    }
}
