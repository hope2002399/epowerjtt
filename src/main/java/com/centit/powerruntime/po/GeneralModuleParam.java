package com.centit.powerruntime.po;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class GeneralModuleParam implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String moduleCode;

    private String hasIdea;
    private String ideaLabel;
    private String ideaCatalog;
    private String ideaContent;
    private String hasAttention;
    private String attentionLabel;
    private String attentionFilter;
    private String hasStuff;
    private String stuffGroupId;
    private String hasDocument;
    private String documentLabel;
    private String documentType;
    private String documentTemplateIds;
    private String documentTemplateNames;
    private String canDefer;
    private String canRollback;
    private String canClose;
    private Long riskId;
    private String assignTeamRole;
    private String teamRoleCode;
    private String teamRoleName;
    private String teamRoleFilter;
    private RiskInfo riskInfo;
    private String isInUse;

    private String nodeName;// 节点名称 add by HX 2013-04-15

    private Date lastUpdateTime;

    public String getIsInUse() {
        if (StringUtils.isBlank(this.isInUse)) {
            this.isInUse = "T";
        }
        return isInUse;
    }

    public void setIsInUse(String isInUse) {
        this.isInUse = isInUse;
    }

    // 页面操作对象，非配置属性
    private String powerId;

    public RiskInfo getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(RiskInfo riskInfo) {
        this.riskInfo = riskInfo;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    // Constructors
    /** default constructor */
    public GeneralModuleParam() {
    }

    /** minimal constructor */
    public GeneralModuleParam(String moduleCode) {

        this.moduleCode = moduleCode;

    }

    public GeneralModuleParam(String moduleCode, String ideaLabel,
            String ideaCatalog, String ideaContent, String hasAttention,
            String attentionLabel, String attentionFilter, String hasStuff,
            String stuffGroupId, String hasDocument, String documentLabel,
            String documentType, String documentTemplateIds,
            String documentTemplateNames, String canDefer, String canRollback,
            String canClose, Long riskId, String assignTeamRole,
            String teamRoleCode, String teamRoleName, String teamRoleFilter,
            String isInUse, String nodeName, String powerId) {
        super();
        this.moduleCode = moduleCode;
        this.ideaLabel = ideaLabel;
        this.ideaCatalog = ideaCatalog;
        this.ideaContent = ideaContent;
        this.hasAttention = hasAttention;
        this.attentionLabel = attentionLabel;
        this.attentionFilter = attentionFilter;
        this.hasStuff = hasStuff;
        this.stuffGroupId = stuffGroupId;
        this.hasDocument = hasDocument;
        this.documentLabel = documentLabel;
        this.documentType = documentType;
        this.documentTemplateIds = documentTemplateIds;
        this.documentTemplateNames = documentTemplateNames;
        this.canDefer = canDefer;
        this.canRollback = canRollback;
        this.canClose = canClose;
        this.riskId = riskId;
        this.assignTeamRole = assignTeamRole;
        this.teamRoleCode = teamRoleCode;
        this.teamRoleName = teamRoleName;
        this.teamRoleFilter = teamRoleFilter;
        this.isInUse = isInUse;
        this.nodeName = nodeName;
        this.powerId = powerId;
    }

    /** full constructor */
    public GeneralModuleParam(String moduleCode, String ideaLabel,
            String ideaCatalog, String ideaContent, String hasAttention,
            String attentionLabel, String attentionFilter, String hasStuff,
            String stuffGroupId, String hasDocument, String documentLabel,
            String documentType, String documentTemplateIds,
            String documentTemplateNames, String canDefer, String canRollback,
            String canClose, Long riskId, String assignTeamRole,
            String teamRoleCode, String teamRoleName, String teamRoleFilter) {

        this.moduleCode = moduleCode;

        this.ideaLabel = ideaLabel;
        this.ideaCatalog = ideaCatalog;
        this.ideaContent = ideaContent;
        this.hasAttention = hasAttention;
        this.attentionLabel = attentionLabel;
        this.attentionFilter = attentionFilter;
        this.hasStuff = hasStuff;
        this.stuffGroupId = stuffGroupId;
        this.hasDocument = hasDocument;
        this.documentLabel = documentLabel;
        this.documentType = documentType;
        this.documentTemplateIds = documentTemplateIds;
        this.documentTemplateNames = documentTemplateNames;
        this.canDefer = canDefer;
        this.canRollback = canRollback;
        this.canClose = canClose;
        this.riskId = riskId;
        this.assignTeamRole = assignTeamRole;
        this.teamRoleCode = teamRoleCode;
        this.teamRoleName = teamRoleName;
        this.teamRoleFilter = teamRoleFilter;
    }

    public String getModuleCode() {
        return this.moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    // Property accessors

    public GeneralModuleParam(String moduleCode, String hasIdea,
            String ideaLabel, String ideaCatalog, String ideaContent,
            String hasAttention, String attentionLabel, String attentionFilter,
            String hasStuff, String stuffGroupId, String hasDocument,
            String documentLabel, String documentType,
            String documentTemplateIds, String documentTemplateNames,
            String canDefer, String canRollback, String canClose, Long riskId,
            String assignTeamRole, String teamRoleCode, String teamRoleName,
            String teamRoleFilter, RiskInfo riskInfo, String isInUse,
            String powerId) {
        super();
        this.hasIdea = hasIdea;
        this.moduleCode = moduleCode;
        this.ideaLabel = ideaLabel;
        this.ideaCatalog = ideaCatalog;
        this.ideaContent = ideaContent;
        this.hasAttention = hasAttention;
        this.attentionLabel = attentionLabel;
        this.attentionFilter = attentionFilter;
        this.hasStuff = hasStuff;
        this.stuffGroupId = stuffGroupId;
        this.hasDocument = hasDocument;
        this.documentLabel = documentLabel;
        this.documentType = documentType;
        this.documentTemplateIds = documentTemplateIds;
        this.documentTemplateNames = documentTemplateNames;
        this.canDefer = canDefer;
        this.canRollback = canRollback;
        this.canClose = canClose;
        this.riskId = riskId;
        this.assignTeamRole = assignTeamRole;
        this.teamRoleCode = teamRoleCode;
        this.teamRoleName = teamRoleName;
        this.teamRoleFilter = teamRoleFilter;
        this.riskInfo = riskInfo;
        this.isInUse = isInUse;
        this.powerId = powerId;
    }

    public String getIdeaLabel() {
        return this.ideaLabel;
    }

    public void setIdeaLabel(String ideaLabel) {
        this.ideaLabel = ideaLabel;
    }

    public String getIdeaCatalog() {
        return this.ideaCatalog;
    }

    public void setIdeaCatalog(String ideaCatalog) {
        this.ideaCatalog = ideaCatalog;
    }

    public String getIdeaContent() {
        return this.ideaContent;
    }

    public void setIdeaContent(String ideaContent) {
        this.ideaContent = ideaContent;
    }

    public String getHasAttention() {
        if (StringUtils.isBlank(this.hasAttention)) {
            this.hasAttention = "F";
        }
        return this.hasAttention;
    }

    public void setHasAttention(String hasAttention) {
        this.hasAttention = hasAttention;
    }

    public String getAttentionLabel() {
        return this.attentionLabel;
    }

    public void setAttentionLabel(String attentionLabel) {
        this.attentionLabel = attentionLabel;
    }

    public String getAttentionFilter() {
        return this.attentionFilter;
    }

    public void setAttentionFilter(String attentionFilter) {
        this.attentionFilter = attentionFilter;
    }

    public String getHasStuff() {
        if (StringUtils.isBlank(this.hasStuff)) {
            this.hasStuff = "F";
        }
        return this.hasStuff;
    }

    public void setHasStuff(String hasStuff) {
        this.hasStuff = hasStuff;
    }

    public String getStuffGroupId() {
        return this.stuffGroupId;
    }

    public void setStuffGroupId(String stuffGroupId) {
        this.stuffGroupId = stuffGroupId;
    }

    public String getHasDocument() {
        if (StringUtils.isBlank(this.hasDocument)) {
            this.hasDocument = "F";
        }
        return this.hasDocument;
    }

    public void setHasDocument(String hasDocument) {
        this.hasDocument = hasDocument;
    }

    public String getDocumentLabel() {
        return this.documentLabel;
    }

    public void setDocumentLabel(String documentLabel) {
        this.documentLabel = documentLabel;
    }

    public String getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentTemplateIds() {
        return this.documentTemplateIds;
    }

    public void setDocumentTemplateIds(String documentTemplateIds) {
        this.documentTemplateIds = documentTemplateIds;
    }

    public String getCanDefer() {
        if (StringUtils.isBlank(this.canDefer)) {
            this.canDefer = "F";
        }
        return this.canDefer;
    }

    public void setCanDefer(String canDefer) {
        this.canDefer = canDefer;
    }

    public String getCanRollback() {
        if (StringUtils.isBlank(this.canRollback)) {
            this.canRollback = "F";
        }
        return this.canRollback;
    }

    public void setCanRollback(String canRollback) {
        this.canRollback = canRollback;
    }

    public String getCanClose() {
        if (StringUtils.isBlank(this.canClose)) {
            this.canClose = "F";
        }
        return this.canClose;
    }

    public void setCanClose(String canClose) {
        this.canClose = canClose;
    }

    public Long getRiskId() {
        return this.riskId;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public String getAssignTeamRole() {
        if (StringUtils.isBlank(this.assignTeamRole)) {
            this.assignTeamRole = "F";
        }
        return this.assignTeamRole;
    }

    public void setAssignTeamRole(String assignTeamRole) {
        this.assignTeamRole = assignTeamRole;
    }

    public String getTeamRoleCode() {
        return this.teamRoleCode;
    }

    public void setTeamRoleCode(String teamRoleCode) {
        this.teamRoleCode = teamRoleCode;
    }

    public String getTeamRoleName() {
        return this.teamRoleName;
    }

    public void setTeamRoleName(String teamRoleName) {
        this.teamRoleName = teamRoleName;
    }

    public String getTeamRoleFilter() {
        return this.teamRoleFilter;
    }

    public void setTeamRoleFilter(String teamRoleFilter) {
        this.teamRoleFilter = teamRoleFilter;
    }

    public void copy(GeneralModuleParam other) {

        this.setModuleCode(other.getModuleCode());

        this.hasIdea = other.getHasIdea();
        this.ideaLabel = other.getIdeaLabel();
        this.ideaCatalog = other.getIdeaCatalog();
        this.ideaContent = other.getIdeaContent();
        this.hasAttention = other.getHasAttention();
        this.attentionLabel = other.getAttentionLabel();
        this.attentionFilter = other.getAttentionFilter();
        this.hasStuff = other.getHasStuff();
        this.stuffGroupId = other.getStuffGroupId();
        this.hasDocument = other.getHasDocument();
        this.documentLabel = other.getDocumentLabel();
        this.documentType = other.getDocumentType();
        this.documentTemplateIds = other.getDocumentTemplateIds();
        this.documentTemplateNames = other.getDocumentTemplateNames();
        this.canDefer = other.getCanDefer();
        this.canRollback = other.getCanRollback();
        this.canClose = other.getCanClose();
        this.riskId = other.getRiskId();
        this.assignTeamRole = other.getAssignTeamRole();
        this.teamRoleCode = other.getTeamRoleCode();
        this.teamRoleName = other.getTeamRoleName();
        this.teamRoleFilter = other.getTeamRoleFilter();
        this.nodeName = other.getNodeName();
        this.lastUpdateTime = other.getLastUpdateTime();
    }

    public void copyNotNullProperty(GeneralModuleParam other) {

        if (other.getModuleCode() != null)
            this.setModuleCode(other.getModuleCode());

        if (other.getHasIdea() != null)
            this.hasIdea = other.getHasIdea();
        if (other.getIdeaLabel() != null)
            this.ideaLabel = other.getIdeaLabel();
        if (other.getIdeaCatalog() != null)
            this.ideaCatalog = other.getIdeaCatalog();
        if (other.getIdeaContent() != null)
            this.ideaContent = other.getIdeaContent();
        if (other.getHasAttention() != null)
            this.hasAttention = other.getHasAttention();
        if (other.getAttentionLabel() != null)
            this.attentionLabel = other.getAttentionLabel();
        if (other.getAttentionFilter() != null)
            this.attentionFilter = other.getAttentionFilter();
        if (other.getHasStuff() != null)
            this.hasStuff = other.getHasStuff();
        if (other.getStuffGroupId() != null)
            this.stuffGroupId = other.getStuffGroupId();
        if (other.getHasDocument() != null)
            this.hasDocument = other.getHasDocument();
        if (other.getDocumentLabel() != null)
            this.documentLabel = other.getDocumentLabel();
        if (other.getDocumentType() != null)
            this.documentType = other.getDocumentType();
        if (other.getDocumentTemplateIds() != null)
            this.documentTemplateIds = other.getDocumentTemplateIds();
        if (other.getDocumentTemplateNames() != null) {
            this.documentTemplateNames = other.getDocumentTemplateNames();
        }
        if (other.getCanDefer() != null)
            this.canDefer = other.getCanDefer();
        if (other.getCanRollback() != null)
            this.canRollback = other.getCanRollback();
        if (other.getCanClose() != null)
            this.canClose = other.getCanClose();
        if (other.getRiskId() != null)
            this.riskId = other.getRiskId();
        if (other.getAssignTeamRole() != null)
            this.assignTeamRole = other.getAssignTeamRole();
        if (other.getTeamRoleCode() != null)
            this.teamRoleCode = other.getTeamRoleCode();
        if (other.getTeamRoleName() != null)
            this.teamRoleName = other.getTeamRoleName();
        if (other.getTeamRoleFilter() != null)
            this.teamRoleFilter = other.getTeamRoleFilter();
        if (other.getNodeName() != null)
            this.nodeName = other.getNodeName();
        if (other.getLastUpdateTime() != null)
            this.lastUpdateTime = other.getLastUpdateTime();
    }

    public void clearProperties() {
        this.hasIdea = null;
        this.ideaLabel = null;
        this.ideaCatalog = null;
        this.ideaContent = null;
        this.hasAttention = null;
        this.attentionLabel = null;
        this.attentionFilter = null;
        this.hasStuff = null;
        this.stuffGroupId = null;
        this.hasDocument = null;
        this.documentLabel = null;
        this.documentType = null;
        this.documentTemplateIds = null;
        this.documentTemplateNames = null;
        this.canDefer = null;
        this.canRollback = null;
        this.canClose = null;
        this.riskId = null;
        this.assignTeamRole = null;
        this.teamRoleCode = null;
        this.teamRoleName = null;
        this.teamRoleFilter = null;
        this.nodeName = null;
        this.lastUpdateTime = null;
    }

    public String getPowerId() {
        return powerId;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId;
    }

    public String getDocumentTemplateNames() {
        return documentTemplateNames;
    }

    public void setDocumentTemplateNames(String documentTemplateNames) {
        this.documentTemplateNames = documentTemplateNames;
    }

    public String getHasIdea() {
        if (StringUtils.isBlank(this.hasIdea)) {
            this.hasIdea = "T";
        }
        return hasIdea;
    }

    public void setHasIdea(String hasIdea) {
        this.hasIdea = hasIdea;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
