package com.centit.workflow.sample.po;

import java.util.HashSet;
import java.util.Set;

import com.centit.workflow.FlowVariable;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfFlowVariable implements java.io.Serializable, FlowVariable {
    private static final long serialVersionUID = 1L;
    private WfFlowVariableId cid;

    private String varValue;
    private String varType;

    // Constructors
    /** default constructor */
    public WfFlowVariable() {
    }

    /**
     * full constructor
     * 
     * @param id
     * @param varValue
     * @param varType
     *            E:集合 S:单个字符串
     */
    public WfFlowVariable(WfFlowVariableId id, String varValue, String varType) {
        this.cid = id;

        this.varValue = varValue;
        this.varType = varType;
    }

    /**
     * 
     * @param flowInstId
     * @param runToken
     * @param varName
     * @param varValue
     * @param varType
     *            E:集合 S:单个字符串
     */
    public WfFlowVariable(Long flowInstId, String runToken, String varName,
            String varValue, String varType) {
        this.cid = new WfFlowVariableId(flowInstId, runToken, varName);
        this.varValue = varValue;
        this.varType = varType;
    }

    public WfFlowVariableId getCid() {
        return this.cid;
    }

    public void setCid(WfFlowVariableId id) {
        this.cid = id;
    }

    public Long getFlowInstId() {
        if (this.cid == null)
            this.cid = new WfFlowVariableId();
        return this.cid.getFlowInstId();
    }

    public void setFlowInstId(Long flowInstId) {
        if (this.cid == null)
            this.cid = new WfFlowVariableId();
        this.cid.setFlowInstId(flowInstId);
    }

    public String getRunToken() {
        if (this.cid == null)
            this.cid = new WfFlowVariableId();
        return this.cid.getRunToken();
    }

    public void setRunToken(String runToken) {
        if (this.cid == null)
            this.cid = new WfFlowVariableId();
        this.cid.setRunToken(runToken);
    }

    public String getVarName() {
        if (this.cid == null)
            this.cid = new WfFlowVariableId();
        return this.cid.getVarName();
    }

    public void setVarName(String varName) {
        if (this.cid == null)
            this.cid = new WfFlowVariableId();
        this.cid.setVarName(varName);
    }

    // Property accessors
    public String getVarValue() {
        return this.varValue;
    }

    public static String stringsetToString(Set<String> sSet) {
        if (sSet == null)
            return null;
        String sRes = null;
        for (String s : sSet) {
            if (sRes == null)
                sRes = s;
            else
                sRes = sRes + ';' + s;
        }
        return sRes;
    }

    public static Set<String> stringToStringset(String s) {
        if (s == null)
            return null;
        String[] sSet = s.split(";");
        Set<String> sVS = new HashSet<String>();

        for (int i = 0; i < sSet.length; i++)
            sVS.add(sSet[i]);
        return sVS;
    }

    public Set<String> getVarSet() {
        if ("E".equals(varType)) {
            return stringToStringset(varValue);
        }
        Set<String> sVS = new HashSet<String>();
        sVS.add(varValue);
        return sVS;
    }

    public void setVarValue(String varValue) {
        this.varValue = varValue;
    }

    /**
     * E:集合 S:单个字符串
     */
    public String getVarType() {
        return this.varType;
    }

    /**
     * E:集合 S:单个字符串
     * 
     * @param varType
     */
    public void setVarType(String varType) {
        this.varType = varType;
    }

    public void copy(WfFlowVariable other) {

        this.setFlowInstId(other.getFlowInstId());
        this.setRunToken(other.getRunToken());
        this.setVarName(other.getVarName());

        this.varValue = other.getVarValue();
        this.varType = other.getVarType();

    }

    public void copyNotNullProperty(WfFlowVariable other) {

        if (other.getFlowInstId() != null)
            this.setFlowInstId(other.getFlowInstId());
        if (other.getRunToken() != null)
            this.setRunToken(other.getRunToken());
        if (other.getVarName() != null)
            this.setVarName(other.getVarName());

        if (other.getVarValue() != null)
            this.varValue = other.getVarValue();
        if (other.getVarType() != null)
            this.varType = other.getVarType();

    }

    public void clearProperties() {

        this.varValue = null;
        this.varType = null;

    }
}
