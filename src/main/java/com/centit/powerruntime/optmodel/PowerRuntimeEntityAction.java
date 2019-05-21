package com.centit.powerruntime.optmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.lang.StringUtils;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.WorkTimeSpan;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.po.GeneralModuleParam;
import com.centit.powerruntime.po.OptProcAttention;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.RiskInfo;
import com.centit.powerruntime.po.TemplateFile;
import com.centit.powerruntime.service.GeneralModuleParamManager;
import com.centit.powerruntime.service.OptBaseInfoManager;
import com.centit.powerruntime.service.OptProcAttentionManager;
import com.centit.powerruntime.service.OptProcInfoManager;
import com.centit.powerruntime.service.RiskInfoManager;
import com.centit.powerruntime.service.TemplateFileManager;
import com.centit.support.utils.HtmlFormUtils;
import com.centit.support.utils.StringRegularOpt;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.SysUserFilterEngine;
import com.centit.sys.service.SysVariableTranslate;
import com.centit.workflow.FlowDescribe;
import com.centit.workflow.FlowEngine;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.FlowManager;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.WorkflowException;
import com.opensymphony.xwork2.ModelDriven;

public class PowerRuntimeEntityAction<T extends Object> extends
        BaseEntityExtremeAction<T> implements ModelDriven<T> {
    private static final long serialVersionUID = 1L;

    protected SysVariableTranslate businessVariable = null;
    protected FlowEngine flowEngine;
    protected FlowManager flowManager;
    protected OptProcInfoManager optProcInfoManager;
    protected OptBaseInfoManager optBaseInfoManager;
    protected Long curNodeInstId;
    protected Long curFlowInstId;
    protected String curFlowPhase;
    private String curdjId;
    private String nextOptUrl;
    protected String moduleCode;
    protected String documentTemplateIds;

    protected String processNote;// 各个节点的意见集合

    /* ------------------ 通用业务操作部分 * */
    protected String teamRoleCode;// 办件角色代码
    protected String teamUserCodes;// 办件用户代码
    protected GeneralModuleParam moduleParam;
    private List<TemplateFile> templateList;
    protected GeneralModuleParamManager generalModuleParamManager;
    protected OptProcAttentionManager optProcAttentionManager;
    protected TemplateFileManager templateFileManager;
    private RiskInfoManager riskInfoManager;
    protected String attUserCodes;// 关注人员代码
    protected String attUserNames;
    protected String bjUserNames;
    protected OptProcInfo optProcInfo;
    private Map<String, Set<String>> teamMap;
    private Map<String, Set<String>> orgMap;
    protected String roleCodefromFlow;// 角色代码：工作流程配置
    protected List<TemplateFile> templateFileList = null;
    private String templateFromNode;

    // 公用JSON数据存放
    protected Object optCommonBizJson;

    protected String flowTime;
    protected String nodeTime;
    protected String flowDefTime;
    protected String nodeName;
    protected String affairTitle;
    protected String nodePromiseTime;
    protected long nodeTimeLimit;
    protected long flowTimeLimit;

    protected void initFlowTime() {
        FlowInstance flowInstance = flowEngine.getFlowInstById(this
                .getFlowInstId());
        flowTime = flowInstance.getTimeLimitStr();
        flowTimeLimit = flowInstance.getTimeLimit();
        NodeInstance nodeinstance = flowEngine.getNodeInstById(this
                .getNodeInstId());
        nodeTime = nodeinstance.getTimeLimitStr();
        if (nodeinstance.getTimeLimit() != null) {
            nodeTimeLimit = nodeinstance.getTimeLimit();
        } else {
            nodeTimeLimit = 0;
        }

        FlowNodeInfo wfnode = flowEngine.getNodeInfoById(nodeinstance
                .getNodeId());
        nodeName = wfnode.getNodeName();
        nodePromiseTime = nodeinstance.getPromiseTimeStr();
        // String worktime = workCalendar.getWorkTime(
        // nodeInstance.getCreateTime(), new Date()).getTimeSpanDesc();
        // request.setAttribute("worktime", worktime);
        FlowDescribe flowdefine = flowEngine.getFlowDefObject(
                flowInstance.getFlowCode(), flowInstance.getVersion());
        // String nodeDefTime =
        // flowEngine.getNodeDefTimelimit(this.getNodeInstId());
        WorkTimeSpan wts = new WorkTimeSpan();
        wts.fromString(flowdefine.getTimeLimit());
        flowDefTime = wts.getTimeSpanDesc();
        // request.setAttribute("nodeDefTime", nodeDefTime);
        // OptBaseInfo baseInfo =
        // optBaseInfoManager.getOptBaseByFlowId(this.getFlowInstId());
        // affairTitle = baseInfo.getTransaffairname();
    }

    /**
     * 获得关注人名单
     */
    protected void initAttUsersConfig() {
        FUserDetail fUserDetail = (FUserDetail) getLoginUser();
        List<OptProcAttention> attList = optProcAttentionManager
                .getAttentionsByDjId(curdjId);
        attUserCodes = "";
        attUserNames = "";
        if (attList != null && attList.size() != 0) {
            for (OptProcAttention att : attList) {
                if (attUserCodes.endsWith(""))
                    attUserCodes = attUserCodes + ",";
                attUserCodes = attUserCodes + att.getUserCode();
                if (attUserNames.endsWith(""))
                    attUserNames = attUserNames + ",";
                attUserNames = attUserNames
                        + CodeRepositoryUtil.getValue("usercode",
                                att.getUserCode());
            }

            attUserCodes = attUserCodes.substring(1, attUserCodes.length());
            attUserNames = attUserNames.substring(1, attUserNames.length());
        }

        /**
         * 根据参数是否需要 关注人 ，提供候选关注人列表
         */
        if (moduleParam != null && moduleParam.getHasAttention() != null
                && moduleParam.getHasAttention().equals("T")) {

            Set<String> attUsers = SysUserFilterEngine.calcOperators(
                    moduleParam.getAttentionFilter(),
                    fUserDetail.getPrimaryUnit(), null, null, null,
                    fUserDetail.getUsercode(), null);
            JSONArray attUserJson = new JSONArray();
            if (attUsers != null) {
                for (String user : attUsers) {
                    String username = CodeRepositoryUtil.getValue("usercode",
                            user);
                    JSONObject usermap = new JSONObject();
                    usermap.put("name", username);
                    usermap.put("nodeID", user);
                    usermap.put("belongId", "-1");
                    usermap.put("levle", 2);
                    attUserJson.add(usermap);
                }
            }
            request.setAttribute("attentionJson", attUserJson);

        }
    }

    /**
     * 加载办件角色
     */
    protected void initTeamUsersConfig() {
        /**
         * 获得办件角色人名单
         */
        if (moduleParam == null) {
            moduleParam = new GeneralModuleParam();
        }
        Set<String> userCodes = null;
        if (this.getFlowInstId() != null
                && StringUtils.isNotBlank(moduleParam.getTeamRoleCode())) {
            userCodes = flowEngine.viewFlowWorkTeam(this.getFlowInstId(),
                    moduleParam.getTeamRoleCode());
        } else {
            moduleParam.setTeamRoleCode("jbr");
        }
        teamUserCodes = "";
        bjUserNames = "";

        if (userCodes != null && userCodes.size() > 0) {
            for (String userCode : userCodes) {
                if ((teamUserCodes.endsWith(""))) {
                    teamUserCodes = teamUserCodes + ",";
                }
                teamUserCodes = teamUserCodes + userCode;
                if ((bjUserNames.endsWith(""))) {
                    bjUserNames = bjUserNames + ",";
                }
                bjUserNames = bjUserNames
                        + CodeRepositoryUtil.getValue("usercode", userCode);
            }
            teamUserCodes = teamUserCodes.substring(1, teamUserCodes.length());
            bjUserNames = bjUserNames.substring(1, bjUserNames.length());
        }

        /**
         * 根据参数是否需要 办件人员
         */
        FUserDetail fUserDetail = (FUserDetail) getLoginUser();

        if ("T".equals(moduleParam.getAssignTeamRole())) {
            Set<String> users = SysUserFilterEngine.calcOperators(
                    moduleParam.getTeamRoleFilter(),
                    fUserDetail.getPrimaryUnit(), null, null, null,
                    fUserDetail.getUsercode(), null);
            JSONArray userjson = new JSONArray();
            if (users != null) {
                for (String user : users) {
                    String username = CodeRepositoryUtil.getValue("usercode",
                            user);
                    JSONObject usermap = new JSONObject();
                    usermap.put("name", username);
                    usermap.put("nodeID", user);
                    usermap.put("belongId", "-1");
                    usermap.put("levle", 2);
                    userjson.add(usermap);
                }
            }
            request.setAttribute("userjson", userjson);
        }
    }

    /*
     * 获取办件人员
     */
    public void initUsers() {
        List<FUserinfo> users = CodeRepositoryUtil.getAllUsers("A");
        JSONArray userjson = new JSONArray();
        if (users != null) {
            for (FUserinfo user : users) {
                JSONObject usermap = new JSONObject();
                usermap.put("name", user.getUsername());
                usermap.put("nodeID", user.getUsercode());
                usermap.put("belongId", "-1");
                usermap.put("levle", 2);
                userjson.add(usermap);
            }
        }
        request.setAttribute("userjson", userjson);
    }

    /**
     * 根据参数是否有风险点 ，提供风险点的风险内控手段与结果的维护
     */
    protected void initRiskConfig() {

        if (moduleParam != null && moduleParam.getRiskId() != null) {
            // 判断是新增还是修改
            RiskInfo riskInfo = new RiskInfo();
            if (StringUtils.isBlank(optProcInfo.getRisktype())) {

                riskInfo = riskInfoManager.getObjectById(moduleParam
                        .getRiskId());
            } else {
                riskInfo.setRisktype(optProcInfo.getRisktype());
                riskInfo.setRiskdes(optProcInfo.getRiskdesc());
                riskInfo.setRiskdeal(optProcInfo.getRiskresult());
            }
            moduleParam.setRiskInfo(riskInfo);
        }
    }

    /**
     * 根据是否可以生产公文 ，确定需要编辑的文档模板
     */
    protected void initTemplateConfig() {
        if (moduleParam != null && moduleParam.getHasDocument() != null
                && moduleParam.getHasDocument().equals("T")) {// 是否存在模版

            String templates = moduleParam.getDocumentTemplateIds();
            if (!StringUtils.isBlank(templates)) {
                String[] tempArr = templates.split("[,]");
                templateList = new ArrayList<TemplateFile>();
                for (String recordId : tempArr) {
                    TemplateFile temp = templateFileManager
                            .getTempByRecord(recordId);
                    templateList.add(temp);
                }
            } else {
                templateList = templateFileManager
                        .listTemplateByType(moduleParam.getDocumentType());
            }
        }
    }

    /**
     * 遇到步骤需要两个以上指定文书的（如回执、意见书等），可从节点参数中配置， 这样能解决通用配置步骤以及不走通用配置的步骤的多文书问题。
     * 配置说明：参数变量名documentTemplateIds：多个文书的，模板编号之间用“,”,隔开;
     */
    protected void initTemplateFromNode() {
        // String param = request.getParameter("documentTemplateIds");2
        if (StringUtils.isNotBlank(documentTemplateIds)
                && !"null".equalsIgnoreCase(documentTemplateIds)) {
            templateFileList = new ArrayList<TemplateFile>();
            String[] params = documentTemplateIds.split(",");
            for (String tempId : params) {
                TemplateFile templateFile = templateFileManager
                        .getTempByRecord(tempId);
                templateFileList.add(templateFile);
            }

            if (templateFileList.size() > 0) {
                templateFromNode = "TRUE";
            }
        }
    }

    public String getDocumentTemplateIds() {
        return documentTemplateIds;
    }

    public void setDocumentTemplateIds(String documentTemplateIds) {
        this.documentTemplateIds = documentTemplateIds;
    }

    /**
     * 初始化风险点
     * 
     * @return
     */
    protected void initalOptProcInfo() {
        optProcInfo = optProcInfoManager.getObjectByNodeInstId(curNodeInstId);
        if (optProcInfo == null) {
            optProcInfo = new OptProcInfo();
            optProcInfo.setIsrisk("F");// 给出默认风险点:为没有风险点
        } else {
            if (StringUtils.isBlank(optProcInfo.getIsrisk()))
                optProcInfo.setIsrisk("F");// 给出默认风险点:为没有风险点
        }

    }

    /**
     * 如果下一步骤含本人，直接进入下一步骤； 如果不含本人，提示办理完毕，返回待办件列表
     */
    public String nextStep() {
        try {
            NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId);
            FlowInstance inst = flowManager
                    .getFlowInstance(nit.getFlowInstId());

            long nextNodeInstId = 0l;
            for (NodeInstance nodeInst : inst.getActiveNodeInstances()) {
                String url = flowManager.getNodeOptUrl(
                        nodeInst.getNodeInstId(),
                        ((FUserDetail) getLoginUser()).getUsercode());
                if (url != null && nextNodeInstId < nodeInst.getNodeInstId()
                        && !"".equals(url.trim())) {
                    nextNodeInstId = nodeInst.getNodeInstId();
                    nextOptUrl = "/" + url;
                }
            }
            if (nextNodeInstId > 0l)
                return "gotoNext";
            else
                return "refreshTasks";

        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "进入下一阶段办理步骤出错，详见系统日志。");
            return ERROR;
        }
    }

    public void setFlowEngine(FlowEngine flowEngine) {
        this.flowEngine = flowEngine;
        // this.request.getSession().getServletContext();
    }

    /**
     * 需要设定自定义 变量解释器是需要调用这个函数
     * 
     * @param businessVariable
     */
    public void setBusinessVariable(SysVariableTranslate businessVariable) {
        this.businessVariable = businessVariable;
    }

    /**
     * 从request的参数中获取节点编号（包括流程编号）
     * 
     * @return false 没有找到对应的参数
     */
    @SuppressWarnings("unchecked")
    protected boolean extractFlowOptParam() {
        boolean bHasExtract = false;
        try {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Object oParam = paramMap.get("nodeInstId");
            if (oParam != null) {
                String sNodeInstId = HtmlFormUtils.getParameterString(oParam);
                if (sNodeInstId != null
                        && StringRegularOpt.isNumber(sNodeInstId)) {
                    curNodeInstId = Long.valueOf(sNodeInstId);
                }
            }
            oParam = paramMap.get("flowInstId");
            if (oParam != null) {
                String sFlowInstId = HtmlFormUtils.getParameterString(oParam);
                if (sFlowInstId != null
                        && StringRegularOpt.isNumber(sFlowInstId)) {
                    curFlowInstId = Long.valueOf(sFlowInstId);
                }
            }

            oParam = paramMap.get("flowPhase");
            if (oParam != null) {
                String sFlowPhase = HtmlFormUtils.getParameterString(oParam);
                if (StringUtils.isNotBlank(sFlowPhase)) {
                    curFlowPhase = sFlowPhase;
                }
            }
            /*
             * oParam = paramMap.get("optParam"); if (oParam != null) {
             * curOptParam = StringBaseOpt.getParameterString(oParam); }
             */
            bHasExtract = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bHasExtract;
    }

    public Long getNodeInstId() {
        return curNodeInstId;
    }

    public void setNodeInstId(Long curNodeInstId) {
        this.curNodeInstId = curNodeInstId;
    }

    public Long getFlowInstId() {
        return curFlowInstId;
    }

    public void setFlowInstId(Long curFlowInstId) {
        this.curFlowInstId = curFlowInstId;
    }

    public String getFlowPhase() {
        return curFlowPhase;
    }

    public void setFlowPhase(String curFlowPhase) {
        this.curFlowPhase = curFlowPhase;
    }

    protected Set<Long> submitNode() throws WorkflowException {
        return submitNode(true);
    }

    public SysVariableTranslate getBusinessVariable() {
        if (businessVariable == null) {
            PowerRuntimeEntityVariable<T> bo = new PowerRuntimeEntityVariable<T>();
            bo.setModuleObject(object);
            bo.setServletRequest(request);
            businessVariable = bo;
        }
        return businessVariable;
    }

    /**
     * 设置业务数据对象
     * 
     * @param optObject
     */
    public void setOptObject(Object optObject) {
        PowerRuntimeEntityVariable<T> bo = new PowerRuntimeEntityVariable<T>();
        bo.setModuleObject(object, optObject);
        bo.setServletRequest(request);
        businessVariable = bo;
    }

    protected Set<Long> submitNode(boolean closeBranch)
            throws WorkflowException {
        extractFlowOptParam();
        FUserDetail curUser = ((FUserDetail) getLoginUser());

        return flowEngine.submitOpt(curNodeInstId, curUser.getUsercode(),
                curUser.getPrimaryUnit(), closeBranch, getBusinessVariable(),
                this.request.getSession().getServletContext());
    }

    protected Set<Long> submitNode(String grantorCode, boolean closeBranch)
            throws WorkflowException {
        extractFlowOptParam();
        FUserDetail curUser = ((FUserDetail) getLoginUser());

        return flowEngine.submitOpt(curNodeInstId, curUser.getUsercode(),
                grantorCode, curUser.getPrimaryUnit(), closeBranch,
                getBusinessVariable(), this.request.getSession()
                        .getServletContext());
    }

    protected Set<Long> submitNode(String grantorCode) throws WorkflowException {
        return submitNode(grantorCode, true);
    }

    public void addSqClFrame(Long nodeInstId, Long groupId,
            List<OptHtmlFrameInfo> frameList, String dj_id) {

        groupId = ((groupId == null) ? 103L : groupId);
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("stuffsFrame");
        viewFrameInfo
                .setFrameSrc("/powerruntime/generalOperator!gotoCFsqcl.do?stuffInfo.djId="
                        + dj_id
                        + "&stuffInfo.nodeInstId="
                        + nodeInstId
                        + "&suppowerstuffinfo.groupId=" + groupId);
        frameList.add(viewFrameInfo);

    }

    /**
     * 各业务节点可调用此方法生成业务JSON，如果数据复杂，可建视图PO
     * 
     * @param obj
     */
    protected void initCommonBizJSON(Object obj) {
        JsonConfig jsonConfig = new JsonConfig();

        // 解决过滤空值问题
        PropertyFilter filter = new PropertyFilter() {
            public boolean apply(Object object, String fieldName,
                    Object fieldValue) {
                return null == fieldValue;
            }
        };
        jsonConfig.setJsonPropertyFilter(filter);

        optCommonBizJson = JSONObject.fromObject(obj, jsonConfig);
    }

    public String getDjId() {
        return curdjId;
    }

    public void setDjId(String djId) {
        this.curdjId = djId;
    }

    public List<TemplateFile> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<TemplateFile> templateList) {
        this.templateList = templateList;
    }

    public GeneralModuleParam getModuleParam() {
        return moduleParam;
    }

    public void setModuleParam(GeneralModuleParam moduleParam) {
        this.moduleParam = moduleParam;
    }

    public String getTeamRoleCode() {
        return teamRoleCode;
    }

    public void setTeamRoleCode(String teamRoleCode) {
        this.teamRoleCode = teamRoleCode;
    }

    public String getTeamUserCodes() {
        return teamUserCodes;
    }

    public void setTeamUserCodes(String teamUserCodes) {
        this.teamUserCodes = teamUserCodes;
    }

    public String getAttUserCodes() {
        return attUserCodes;
    }

    public void setAttUserCodes(String attUserCodes) {
        this.attUserCodes = attUserCodes;
    }

    public String getAttUserNames() {
        return attUserNames;
    }

    public void setAttUserNames(String attUserNames) {
        this.attUserNames = attUserNames;
    }

    public String getBjUserNames() {
        return bjUserNames;
    }

    public void setBjUserNames(String bjUserNames) {
        this.bjUserNames = bjUserNames;
    }

    public void setOptProcInfo(OptProcInfo optProcInfo) {
        this.optProcInfo = optProcInfo;
    }

    public OptProcInfo getOptProcInfo() {
        return optProcInfo;
    }

    public void setGeneralModuleParamManager(
            GeneralModuleParamManager generalModuleParamManager) {
        this.generalModuleParamManager = generalModuleParamManager;
    }

    public void setOptProcAttentionManager(
            OptProcAttentionManager optProcAttentionManager) {
        this.optProcAttentionManager = optProcAttentionManager;
    }

    public void setRiskInfoManager(RiskInfoManager riskInfoManager) {
        this.riskInfoManager = riskInfoManager;
    }

    public OptProcInfoManager getOptProcInfoManager() {
        return optProcInfoManager;
    }

    public void setOptProcInfoManager(OptProcInfoManager optProcInfoManager) {
        this.optProcInfoManager = optProcInfoManager;
    }

    public void setFlowManager(FlowManager flowManager) {
        this.flowManager = flowManager;
    }

    public void setNextOptUrl(String nextOptUrl) {
        this.nextOptUrl = nextOptUrl;
    }

    public String getNextOptUrl() {
        return nextOptUrl;
    }

    public FlowManager getFlowManager() {
        return flowManager;
    }

    public TemplateFileManager getTemplateFileManager() {
        return templateFileManager;
    }

    public void setTemplateFileManager(TemplateFileManager templateFileManager) {
        this.templateFileManager = templateFileManager;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getProcessNote() {
        return processNote;
    }

    public List<TemplateFile> getTemplateFileList() {
        return templateFileList;
    }

    public void setTemplateFileList(List<TemplateFile> templateFileList) {
        this.templateFileList = templateFileList;
    }

    public void setProcessNote(String processNote) {
        this.processNote = processNote;
    }

    public OptProcAttentionManager getOptProcAttentionManager() {
        return optProcAttentionManager;
    }

    public RiskInfoManager getRiskInfoManager() {
        return riskInfoManager;
    }

    public String getTemplateFromNode() {
        return templateFromNode;
    }

    public void setTemplateFromNode(String templateFromNode) {
        this.templateFromNode = templateFromNode;
    }

    public String getRoleCodefromFlow() {
        return roleCodefromFlow;
    }

    public void setRoleCodefromFlow(String roleCodefromFlow) {
        this.roleCodefromFlow = roleCodefromFlow;
    }

    public OptBaseInfoManager getOptBaseInfoManager() {
        return optBaseInfoManager;
    }

    public void setOptBaseInfoManager(OptBaseInfoManager optBaseInfoManager) {
        this.optBaseInfoManager = optBaseInfoManager;
    }

    public Map<String, Set<String>> getTeamMap() {
        return teamMap;
    }

    public void setTeamMap(Map<String, Set<String>> teamMap) {
        this.teamMap = teamMap;
    }

    public Map<String, Set<String>> getOrgMap() {
        return orgMap;
    }

    public void setOrgMap(Map<String, Set<String>> orgMap) {
        this.orgMap = orgMap;
    }

    public Object getOptCommonBizJson() {
        return optCommonBizJson;
    }

    public void setOptCommonBizJson(Object optCommonBizJson) {
        this.optCommonBizJson = optCommonBizJson;
    }

    public String getFlowTime() {
        return flowTime;
    }

    public void setFlowTime(String flowTime) {
        this.flowTime = flowTime;
    }

    public String getNodeTime() {
        return nodeTime;
    }

    public void setNodeTime(String nodeTime) {
        this.nodeTime = nodeTime;
    }

    public String getFlowDefTime() {
        return flowDefTime;
    }

    public void setFlowDefTime(String flowDefTime) {
        this.flowDefTime = flowDefTime;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getAffairTitle() {
        return affairTitle;
    }

    public void setAffairTitle(String affairTitle) {
        this.affairTitle = affairTitle;
    }

    public String getNodePromiseTime() {
        return nodePromiseTime;
    }

    public void setNodePromiseTime(String nodePromiseTime) {
        this.nodePromiseTime = nodePromiseTime;
    }

    public long getNodeTimeLimit() {
        return nodeTimeLimit;
    }

    public void setNodeTimeLimit(long nodeTimeLimit) {
        this.nodeTimeLimit = nodeTimeLimit;
    }

    public long getFlowTimeLimit() {
        return flowTimeLimit;
    }

    public void setFlowTimeLimit(long flowTimeLimit) {
        this.flowTimeLimit = flowTimeLimit;
    }

}
