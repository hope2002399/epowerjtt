package com.centit.EIdPhoto.po;

import java.beans.Transient;
import java.io.File;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;

/**
 * 
 * TODO Class description should be added
 * 
 * @author dzf
 * @create 2017年9月15日
 * @version
 */
public class TZzZmInfo implements java.io.Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -9076424970166156065L;
    //主键
    private String id;
    //部门电子证照实施清单主键(必填)
    private String mouldId;
    //电子证照编号
    private String dzzzNo;
    //纸质证照编号
    private String zzBh;
    //颁证时间
    private Date bzDate;
    //有效期（起始）,如果证照长期有效该数据项为空
    private Date startTime;
    //有效期（截止）,如果证照长期有效该数据项为空
    private Date endTime;
    //颁证单位(必填)
    private String deptName;
    //持证者(必填)
    private String userName;
    //持证者类型(必填)
    private String userType;
    //持证者证件类型(必填)
    private String userZjType;
    //持证者号码(必填)
    private String userNo;
    //证照分类
    private String zzType;
    //证照补充信息(必填)
    private Clob inDividuation;
    
    private String dividuation;
    //存放已生成好的电子证照文件
    private Blob zzFile;
    //创建时间(必填)
    private Date createDate;
    //01：未交换；02：已交换(必填)
    private String status;
    //A：有效；X：有效(必填)
    private String state;
    
    private String numCode;
    
    private String qxNumCode;
    
    private byte[] zzFiles;
    
    
    public TZzZmInfo(){}
    
    public TZzZmInfo(String id, String mouldId, String dzzzNo, String zzBh,
            Date bzDate, Date startTime, Date endTime, String deptName,
            String userName, String userType, String userZjType, String userNo,
            String zzType, Clob inDividuation, Blob zzFile, Date createDate,
            String status, String state) {
        super();
        this.id = id;
        this.mouldId = mouldId;
        this.dzzzNo = dzzzNo;
        this.zzBh = zzBh;
        this.bzDate = bzDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deptName = deptName;
        this.userName = userName;
        this.userType = userType;
        this.userZjType = userZjType;
        this.userNo = userNo;
        this.zzType = zzType;
        this.inDividuation = inDividuation;
        this.zzFile = zzFile;
        this.createDate = createDate;
        this.status = status;
        this.state = state;
    }
    
    
    @Transient
    public String getDividuation() {
        return dividuation;
    }

    public void setDividuation(String dividuation) {
        this.dividuation = dividuation;
    }

    @Transient
    public byte[] getZzFiles() {
        return zzFiles;
    }

    public void setZzFiles(byte[] zzFiles) {
        this.zzFiles = zzFiles;
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
    public String getDzzzNo() {
        return dzzzNo;
    }
    public void setDzzzNo(String dzzzNo) {
        this.dzzzNo = dzzzNo;
    }
    public String getZzBh() {
        return zzBh;
    }
    public void setZzBh(String zzBh) {
        this.zzBh = zzBh;
    }
    public Date getBzDate() {
        return bzDate;
    }
    public void setBzDate(Date bzDate) {
        this.bzDate = bzDate;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getUserZjType() {
        return userZjType;
    }
    public void setUserZjType(String userZjType) {
        this.userZjType = userZjType;
    }
    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getZzType() {
        return zzType;
    }
    public void setZzType(String zzType) {
        this.zzType = zzType;
    }
    
    public Clob getInDividuation() {
        return inDividuation;
    }
    public void setInDividuation(Clob inDividuation) {
        this.inDividuation = inDividuation;
    }
    
    public Blob getZzFile() {
        return zzFile;
    }
    public void setZzFile(Blob zzFile) {
        this.zzFile = zzFile;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getQxNumCode() {
        return qxNumCode;
    }

    public void setQxNumCode(String qxNumCode) {
        this.qxNumCode = qxNumCode;
    }
    
}
