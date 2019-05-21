package com.centit.supervise.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Reconsiderprocess implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String processno;

    private Long nodeInstId;
    private String reconsiderId;
    private String processCode;
    private String processName;
    private Date processDate;
    private String operatorId;
    private String operatorName;
    private String operatorResult;
    private String operatorOpinion;

    // Constructors
    /** default constructor */
    public Reconsiderprocess() {
    }

    /** minimal constructor */
    public Reconsiderprocess(String processno, Date processDate,
            String operatorOpinion) {

        this.processno = processno;

        this.processDate = processDate;
        this.operatorOpinion = operatorOpinion;
    }

    /** full constructor */
    public Reconsiderprocess(String processno, Long nodeinstid,
            String reconsiderId, String processCode, String processName,
            Date processDate, String operatorId, String operatorName,
            String operatorResult, String operatorOpinion) {

        this.processno = processno;

        this.nodeInstId = nodeinstid;
        this.reconsiderId = reconsiderId;
        this.processCode = processCode;
        this.processName = processName;
        this.processDate = processDate;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operatorResult = operatorResult;
        this.operatorOpinion = operatorOpinion;
    }

    public String getProcessno() {
        return this.processno;
    }

    public void setProcessno(String processno) {
        this.processno = processno;
    }

    // Property accessors

    public String getReconsiderId() {
        return this.reconsiderId;
    }

    public Long getNodeInstId() {
        return nodeInstId;
    }

    public void setNodeInstId(Long nodeInstId) {
        this.nodeInstId = nodeInstId;
    }

    public void setReconsiderId(String reconsiderId) {
        this.reconsiderId = reconsiderId;
    }

    public String getProcessCode() {
        return this.processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getProcessDate() {
        return this.processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return this.operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorResult() {
        return this.operatorResult;
    }

    public void setOperatorResult(String operatorResult) {
        this.operatorResult = operatorResult;
    }

    public String getOperatorOpinion() {
        return this.operatorOpinion;
    }

    public void setOperatorOpinion(String operatorOpinion) {
        this.operatorOpinion = operatorOpinion;
    }

    public void copy(Reconsiderprocess other) {

        this.setProcessno(other.getProcessno());

        this.nodeInstId = other.getNodeInstId();
        this.reconsiderId = other.getReconsiderId();
        this.processCode = other.getProcessCode();
        this.processName = other.getProcessName();
        this.processDate = other.getProcessDate();
        this.operatorId = other.getOperatorId();
        this.operatorName = other.getOperatorName();
        this.operatorResult = other.getOperatorResult();
        this.operatorOpinion = other.getOperatorOpinion();

    }

    public void copyNotNullProperty(Reconsiderprocess other) {

        if (other.getProcessno() != null)
            this.setProcessno(other.getProcessno());

        if (other.getNodeInstId() != null)
            this.nodeInstId = other.getNodeInstId();
        if (other.getReconsiderId() != null)
            this.reconsiderId = other.getReconsiderId();
        if (other.getProcessCode() != null)
            this.processCode = other.getProcessCode();
        if (other.getProcessName() != null)
            this.processName = other.getProcessName();
        if (other.getProcessDate() != null)
            this.processDate = other.getProcessDate();
        if (other.getOperatorId() != null)
            this.operatorId = other.getOperatorId();
        if (other.getOperatorName() != null)
            this.operatorName = other.getOperatorName();
        if (other.getOperatorResult() != null)
            this.operatorResult = other.getOperatorResult();
        if (other.getOperatorOpinion() != null)
            this.operatorOpinion = other.getOperatorOpinion();

    }

    public void clearProperties() {

        this.nodeInstId = null;
        this.reconsiderId = null;
        this.processCode = null;
        this.processName = null;
        this.processDate = null;
        this.operatorId = null;
        this.operatorName = null;
        this.operatorResult = null;
        this.operatorOpinion = null;

    }
}
