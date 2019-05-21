package com.centit.workflow.sample.po;

import com.centit.workflow.FlowNodeInfo;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfNode implements FlowNodeInfo, java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long nodeId;

    private String flowCode;
    private Long version;
    private String nodeType;
    private String nodeName;
    private String optType;
    private String optCode;
    private String optParam;
    private String optBean;
    private String subFlowCode;
    private String roleType;
    private String roleCode;
    private String unitExp;
    private String powerExp;
    private String nodeDesc;
    private String limitType;
    private String timeLimit;
    private String inheritType;
    private String inheritNodeCode;
    private String expireOpt;
    private String isAccountTime;
    private String isLeafNode;
    private String isTrunkLine;
    private String nodeCode;
    private String riskinfo;
    private String flowPhase;

    public String getIsTrunkLine() {
        return isTrunkLine;
    }

    public void setIsTrunkLine(String isTrunkLine) {
        this.isTrunkLine = isTrunkLine;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getRiskinfo() {
        return riskinfo;
    }

    public void setRiskinfo(String riskinfo) {
        this.riskinfo = riskinfo;
    }

    // Constructors
    /** default constructor */
    public WfNode() {
        this.isAccountTime = "T";
        this.isLeafNode = "F";
        this.inheritType = "0";
    }

    /** minimal constructor */
    public WfNode(Long nodeid, String nodetype) {

        this.nodeId = nodeid;

        this.nodeType = nodetype;
        this.isAccountTime = "T";
        this.isLeafNode = "F";
        this.inheritType = "0";
    }

    /** full constructor */
    public WfNode(Long nodeid, String wfcode, Long version, String nodetype,
            String nodename, String opttype, String optcode, String optparam,
            String opturl, String subwfcode, String roletype, String rolecode,
            String unitexp, String powerexp, String nodedesc, String limitType,
            String timelimit, String inheritType, String inheritNodeCode,
            String isTrunkLine, String expireopt, String issync,
            String flowPhase, String isleafnode, String riskinfo,
            String nodeCode) {

        this.nodeId = nodeid;

        this.flowCode = wfcode;
        this.version = version;
        this.nodeType = nodetype;
        this.nodeName = nodename;
        this.optType = opttype;
        this.optCode = optcode;
        this.optParam = optparam;
        this.optBean = opturl;
        this.subFlowCode = subwfcode;
        this.roleType = roletype;
        this.roleCode = rolecode;
        this.unitExp = unitexp;
        this.powerExp = powerexp;
        this.nodeDesc = nodedesc;
        this.limitType = limitType;
        this.timeLimit = timelimit;
        this.inheritType = inheritType;
        this.inheritNodeCode = inheritNodeCode;
        this.expireOpt = expireopt;
        this.isAccountTime = issync;
        this.flowPhase = flowPhase;
        this.isTrunkLine = isTrunkLine;
        this.riskinfo = riskinfo;
        this.nodeCode = nodeCode;
        this.isLeafNode = isleafnode;

    }

    public Long getNodeId() {
        return this.nodeId;
    }

    public void setNodeId(Long nodeid) {
        this.nodeId = nodeid;
    }

    // Property accessors

    public String getFlowPhase() {
        return flowPhase;
    }

    public void setFlowPhase(String flowPhase) {
        this.flowPhase = flowPhase;
    }

    public String getFlowCode() {
        return this.flowCode;
    }

    public void setFlowCode(String wfcode) {
        this.flowCode = wfcode;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * A:开始 B:首节点 C:一般 D:分支 E:汇聚 G:多实例节点 H:并行 R:游离分支 F结束
     * 
     * @return
     */
    public String getNodeType() {
        return this.nodeType;
    }

    /**
     * 
     * @param nodetype
     *            A:开始 B:首节点 C:一般 D:分支 E:汇聚 G:多实例节点 R:游离分支 H:并行 F结束
     */
    public void setNodeType(String nodetype) {
        this.nodeType = nodetype;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public void setNodeName(String nodename) {
        this.nodeName = nodename;
    }

    /**
     * @return A:一般 B:抢先机制 C:多人操作 D:自动执行 E哑元（可用于嵌套汇聚） S:子流程
     */
    public String getOptType() {
        return this.optType;
    }

    /**
     * 
     * @param opttype
     *            A:一般 B:抢先机制 C:多人操作 D:自动执行 E哑元（可用于嵌套汇聚） S:子流程
     */
    public void setOptType(String opttype) {
        this.optType = opttype;
    }

    public String getOptCode() {
        return this.optCode;
    }

    public void setOptCode(String optcode) {
        this.optCode = optcode;
    }

    public String getOptBean() {
        return this.optBean;
    }

    public void setOptBean(String opturl) {
        this.optBean = opturl;
    }

    public String getSubFlowCode() {
        return this.subFlowCode;
    }

    public void setSubFlowCode(String subwfcode) {
        this.subFlowCode = subwfcode;
    }

    /**
     * en gw xz bj
     * 
     * @return
     */
    public String getRoleType() {
        return this.roleType;
    }

    public void setRoleType(String roletype) {
        this.roleType = roletype;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String rolecode) {
        this.roleCode = rolecode;
    }

    public String getOptParam() {
        return optParam;
    }

    public void setOptParam(String optparam) {
        this.optParam = optparam;
    }

    public String getUnitExp() {
        return this.unitExp;
    }

    public void setUnitExp(String unitexp) {
        this.unitExp = unitexp;
    }

    public String getPowerExp() {
        return this.powerExp;
    }

    public void setPowerExp(String powerexp) {
        this.powerExp = powerexp;
    }

    public String getNodeDesc() {
        return this.nodeDesc;
    }

    public void setNodeDesc(String nodedesc) {
        this.nodeDesc = nodedesc;
    }

    /**
     * 期限类别 I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限
     * cycle、H 继承上一个节点剩余时间 hierarchical。
     * 
     * @return
     */
    public String getLimitType() {
        return limitType;
    }

    /**
     * 期限类别 I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限
     * cycle、H 继承上一个节点剩余时间 hierarchical。
     * 
     * @param limitType
     */
    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(String timelimit) {
        this.timeLimit = timelimit;
    }

    /**
     * 0：不继承， 1 ：继承前节点 2 ：继承指定节点；
     * 
     * @return
     */
    public String getInheritType() {
        return inheritType;
    }

    /**
     * @param inheritType
     *            0：不继承， 1 ：继承前节点 2 ：继承指定节点；
     */
    public void setInheritType(String inheritType) {
        this.inheritType = inheritType;
    }

    /**
     * 继承节点环节代码 输入框 ，文本输入； XML 属性名 inheritNodeCode InheritType == '2' 时有效
     * 
     * @return
     */
    public String getInheritNodeCode() {
        return inheritNodeCode;
    }

    public void setInheritNodeCode(String inheritNodeCode) {
        this.inheritNodeCode = inheritNodeCode;
    }

    /**
     * N：通知， O:不处理 ，X：挂起，E：终止（流程）， C：完成（强制提交,提交失败就挂起）
     * 
     * @return
     */
    public String getExpireOpt() {
        return this.expireOpt;
    }

    /**
     * N：通知， O:不处理 ，X：挂起，E：终止（流程）， C：完成（强制提交,提交失败就挂起）
     * 
     * @param expireopt
     */
    public void setExpireOpt(String expireopt) {
        this.expireOpt = expireopt;
    }

    /**
     * 节点执行时间是否计入时间限制 T 计时、有期限 F 不计时 H仅环节计时
     */
    public String getIsAccountTime() {
        return this.isAccountTime;
    }

    /**
     * 节点执行时间是否计入时间限制 T 计时、有期限 F 不计时 H 仅环节计时
     * 
     * @param issync
     */
    public void setIsAccountTime(String issync) {
        this.isAccountTime = issync;
    }

    public String getIsLeafNode() {
        return isLeafNode;
    }

    public void setIsLeafNode(String isleafnode) {
        this.isLeafNode = isleafnode;
    }

    public void copy(WfNode other) {

        this.setNodeId(other.getNodeId());

        this.flowCode = other.getFlowCode();
        this.version = other.getVersion();
        this.nodeType = other.getNodeType();
        this.nodeName = other.getNodeName();
        this.optType = other.getOptType();
        this.optCode = other.getOptCode();
        this.optParam = other.getOptParam();
        this.optBean = other.getOptBean();
        this.subFlowCode = other.getSubFlowCode();
        this.roleType = other.getRoleType();
        this.roleCode = other.getRoleCode();
        this.unitExp = other.getUnitExp();
        this.powerExp = other.getPowerExp();
        this.nodeDesc = other.getNodeDesc();
        this.timeLimit = other.getTimeLimit();
        this.expireOpt = other.getExpireOpt();
        this.isAccountTime = other.getIsAccountTime();
        this.flowPhase = other.getFlowPhase();
        this.isLeafNode = other.getIsLeafNode();
    }

    public void copyNotNullProperty(WfNode other) {

        if (other.getNodeId() != null)
            this.setNodeId(other.getNodeId());

        if (other.getFlowCode() != null)
            this.flowCode = other.getFlowCode();
        if (other.getVersion() != null)
            this.version = other.getVersion();
        if (other.getNodeType() != null)
            this.nodeType = other.getNodeType();
        if (other.getNodeName() != null)
            this.nodeName = other.getNodeName();
        if (other.getOptType() != null)
            this.optType = other.getOptType();
        if (other.getOptCode() != null)
            this.optCode = other.getOptCode();
        if (other.getOptParam() != null)
            this.optParam = other.getOptParam();
        if (other.getOptBean() != null)
            this.optBean = other.getOptBean();
        if (other.getSubFlowCode() != null)
            this.subFlowCode = other.getSubFlowCode();
        if (other.getRoleType() != null)
            this.roleType = other.getRoleType();
        if (other.getRoleCode() != null)
            this.roleCode = other.getRoleCode();
        if (other.getUnitExp() != null)
            this.unitExp = other.getUnitExp();
        if (other.getPowerExp() != null)
            this.powerExp = other.getPowerExp();
        if (other.getNodeDesc() != null)
            this.nodeDesc = other.getNodeDesc();
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getExpireOpt() != null)
            this.expireOpt = other.getExpireOpt();
        if (other.getIsAccountTime() != null)
            this.isAccountTime = other.getIsAccountTime();
        if (other.getFlowPhase() != null)
            this.flowPhase = other.getFlowPhase();
        if (other.getIsLeafNode() != null)
            this.isLeafNode = other.getIsLeafNode();
        if (other.getIsTrunkLine() != null)
            this.isTrunkLine = other.getIsTrunkLine();

    }

    public void clearProperties() {
        this.nodeId = null;
        this.flowCode = null;
        this.version = null;
        this.nodeType = null;
        this.nodeName = null;
        this.optType = null;
        this.optCode = null;
        this.optParam = null;
        this.optBean = null;
        this.subFlowCode = null;
        this.roleType = null;
        this.roleCode = null;
        this.unitExp = null;
        this.powerExp = null;
        this.nodeDesc = null;
        this.timeLimit = null;
        this.flowPhase = null;
        this.expireOpt = null;
        this.isAccountTime = "T";
        this.isLeafNode = "F";
        this.isTrunkLine = "F";
    }
}
