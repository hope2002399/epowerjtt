package com.centit.supervise.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Reconsiderresult implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String reconsiderId;

    private Date reconsiderenddate;
    private String reconsiderresult;
    private String reconsiderremark;
    private String operatorId;
    private String operatorName;
    private String finishType;

    // Constructors
    /** default constructor */
    public Reconsiderresult() {
    }

    /** minimal constructor */
    public Reconsiderresult(String reconsiderId) {

        this.reconsiderId = reconsiderId;

    }

    /** full constructor */
    public Reconsiderresult(String reconsiderId, Date reconsiderenddate,
            String reconsiderresult, String reconsiderremark,
            String operatorId, String operatorName) {

        this.reconsiderId = reconsiderId;

        this.reconsiderenddate = reconsiderenddate;
        this.reconsiderresult = reconsiderresult;
        this.reconsiderremark = reconsiderremark;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
    }

    public Reconsiderresult(String reconsiderId, Date reconsiderenddate,
            String reconsiderresult, String reconsiderremark,
            String operatorId, String operatorName, String finishType) {
        super();
        this.reconsiderId = reconsiderId;
        this.reconsiderenddate = reconsiderenddate;
        this.reconsiderresult = reconsiderresult;
        this.reconsiderremark = reconsiderremark;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.finishType = finishType;
    }

    public String getReconsiderId() {
        return this.reconsiderId;
    }

    public void setReconsiderId(String reconsiderId) {
        this.reconsiderId = reconsiderId;
    }

    // Property accessors

    public Date getReconsiderenddate() {
        return this.reconsiderenddate;
    }

    public void setReconsiderenddate(Date reconsiderenddate) {
        this.reconsiderenddate = reconsiderenddate;
    }

    public String getReconsiderresult() {
        return this.reconsiderresult;
    }

    public void setReconsiderresult(String reconsiderresult) {
        this.reconsiderresult = reconsiderresult;
    }

    public String getReconsiderremark() {
        return this.reconsiderremark;
    }

    public void setReconsiderremark(String reconsiderremark) {
        this.reconsiderremark = reconsiderremark;
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

    public String getFinishType() {
        return finishType;
    }

    public void setFinishType(String finishType) {
        this.finishType = finishType;
    }

    public void copy(Reconsiderresult other) {

        this.setReconsiderId(other.getReconsiderId());

        this.reconsiderenddate = other.getReconsiderenddate();
        this.reconsiderresult = other.getReconsiderresult();
        this.reconsiderremark = other.getReconsiderremark();
        this.operatorId = other.getOperatorId();
        this.operatorName = other.getOperatorName();
        this.finishType = other.getFinishType();

    }

    public void copyNotNullProperty(Reconsiderresult other) {

        if (other.getReconsiderId() != null)
            this.setReconsiderId(other.getReconsiderId());

        if (other.getReconsiderenddate() != null)
            this.reconsiderenddate = other.getReconsiderenddate();
        if (other.getReconsiderresult() != null)
            this.reconsiderresult = other.getReconsiderresult();
        if (other.getReconsiderremark() != null)
            this.reconsiderremark = other.getReconsiderremark();
        if (other.getOperatorId() != null)
            this.operatorId = other.getOperatorId();
        if (other.getOperatorName() != null)
            this.operatorName = other.getOperatorName();
        if (other.getFinishType() != null)
            this.finishType = other.getFinishType();
    }

    public void clearProperties() {

        this.reconsiderenddate = null;
        this.reconsiderresult = null;
        this.reconsiderremark = null;
        this.operatorId = null;
        this.operatorName = null;
        this.finishType = null;

    }
}
