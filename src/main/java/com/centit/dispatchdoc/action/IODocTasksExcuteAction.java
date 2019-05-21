package com.centit.dispatchdoc.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.centit.dispatchdoc.po.DispatchDoc;
import com.centit.dispatchdoc.po.IncomeDoc;
import com.centit.dispatchdoc.service.DispatchDocManager;
import com.centit.dispatchdoc.service.IncomeDocManager;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.VUserUnits;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.FunctionManager;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

/**
 * 收发文流程待办事项公用流转ACTION
 * 
 * @author ljy
 * @create 2013-9-23
 * @version
 */
public class IODocTasksExcuteAction extends IODocCommonBizAction<OptProcInfo> {

    private static final long serialVersionUID = 1L;

    private FunctionManager functionManager;
    private DispatchDocManager dispatchDocManager;
    private IncomeDocManager incomeDocManager;

    // 发文frame类型（编辑/查看）
    private String frameType;
    // 收发文关联frame类型（编辑/查看）
    private String docRelativeFrameType;
    private String roleCode;

    /**
     * 提交操作结果
     * 
     * @return
     */
    public String submitOpt() {
        try {
            saveOpt();

            submitNode();
            // 保存过程日志信息
            saveIdeaInfo();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "当前操作提交失败，详见系统日志。");
            return ERROR;
        }
        return "refreshTasks";
    }

    /**
     * 保存操作结果
     * 
     * @return
     */
    public String saveOpt() {
        try {
            String djId = object.getDjId();

            if (djId.startsWith("SW")) {
                IncomeDoc incomeDoc = incomeDocManager.getObjectById(djId);

                if (null != incomeDoc) {
                    incomeDoc
                            .setUpdateDate(new Date(System.currentTimeMillis()));

                    incomeDocManager.saveObject(incomeDoc);
                }
            }

            // TODO 添加保存操作
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            object.setTransdate(new Date(System.currentTimeMillis()));
            object.setUsercode(loginInfo.getUsercode());
            object.setUnitcode(loginInfo.getPrimaryUnit());

            NodeInstance nodeInst = flowEngine.getNodeInstById(object
                    .getNodeInstId());
            FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nodeInst
                    .getNodeId());
            object.setNodename(nodeInfo.getNodeName());
            object.setNodeinststate(nodeInst.getNodeState());

            // 存在风险点的信息:风险类别、风险描述、风险内控手段与结果
            if (StringUtils.isNotBlank(object.getRisktype())) {
                object.setIsrisk("T");// 存在
            } else {
                object.setIsrisk("F");// 不存在
            }
            optProcInfoManager.saveObject(object);// 保存办件人员

            return "refreshTasks";
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存流程过程信息失败。");
            return ERROR;
        }
    }

    /**
     * 暂缓处理
     * 
     * @return
     */
    public String suspendNodeInstance() {
        flowManager.suspendNodeInstance(object.getNodeInstId(),
                ((FUserDetail) getLoginUser()).getUsercode());
        // return "toDispatchDocTask";
        return "refreshTasks";
    }

    /**
     * 回退节点
     * 
     * @return
     */
    public String rollBackOpt() {
        flowManager.rollbackOpt(object.getNodeInstId(),
                ((FUserDetail) getLoginUser()).getUsercode());
        return "toDispatchDocTask";
    }

    /**
     * 结束流程
     * 
     * @return
     */
    public String endFlow() {
        NodeInstance nodeInst = flowEngine.getNodeInstById(object
                .getNodeInstId());
        flowManager.stopInstance(nodeInst.getFlowInstId(),
                ((FUserDetail) getLoginUser()).getUsercode(), "强制结束流程");
        return "toDispatchDocTask";
    }

    public String doOpt() {

        try {

            moduleParam = generalModuleParamManager.getObjectById(moduleCode);// "XKSL"

            extractFlowOptParam();

            object = optProcInfoManager.getObjectByNodeInstId(object
                    .getNodeInstId());

            // TODO 判断是 新建 还是更新
            if (object == null)
                object = new OptProcInfo();

            super.initalOptProcInfo();
            /**
             * 根据参数是否需要 关注人 ，提供候选关注人列表
             */
            super.initAttUsersConfig();
            /**
             * 获得办件角色人名单,根据参数是否需要 办件人员
             */
            super.initTeamUsersConfig();

            /**
             * 根据参数是否有风险点 ，提供风险点的风险内控手段与结果的维护
             */
            super.initRiskConfig();

            /**
             * 根据是否可以上传附件 ，确定可以上传附件的类型
             */
            if (moduleParam.getHasStuff() != null
                    && moduleParam.getHasStuff().equals("T")) {
                OptBaseInfo optBaseInfo = optBaseInfoManager
                        .getObjectById(object.getDjId());
                if (optBaseInfo != null) {
                    moduleParam.setPowerId(optBaseInfo.getPowerid());
                }
            }

            // optBaseInfoJson =
            // srPermitApplyManager.getJSONDocumentNames(object
            // .getDjId());
            /**
             * 根据是否可以生产公文 ，确定需要编辑的文档模板
             */
            super.initTemplateConfig();
            /**
             * 多模板情况加载
             */
            super.initTemplateFromNode();

        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "通用配置功能出错，请检查各配置项是否准确。");
            return ERROR;
        }
        return "IODOcTransForm";

    }

    /**
     * 发文流程通用操作定义
     * 
     * @return
     */
    public String genDispatchDocFrame() {

        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        this.setNodeInstId(object.getNodeInstId());

        frameList.add(super.getCommonTransFrame(object.getDjId()));// 引用通用的办理界面

        frameList.add(getDispatchDocRelativeFrame(object.getDjId()));// 关联收文信息查看

        frameList.add(getDispatchDocFrame(object.getDjId(), frameType));// 基础业务信息查看

        NodeInstance nodeInst = flowEngine.getNodeInstById(object
                .getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nodeInst.getNodeId());
        this.setFrameList(frameList, fif.getNodeName() + "办理");

        super.initFlowTime();

        return "optframe";
    }

    /**
     * 收文流程通用操作定义
     * 
     * @return
     */
    public String genIncomeDocFrame() {

        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        this.setNodeInstId(object.getNodeInstId());
        frameList.add(super.getCommonTransFrame(object.getDjId()));// 引用通用的办理界面

        frameList.add(getIncomeDocFrame(object.getDjId()));// 基础收文业务信息查看

        NodeInstance nodeInst = flowEngine.getNodeInstById(object
                .getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nodeInst.getNodeId());
        this.setFrameList(frameList, fif.getNodeName()
                + (fif.getNodeName().endsWith("办理") ? "" : "办理"));

        super.initFlowTime();

        return "optframe";
    }

    /**
     * 置文号：不符合通用条件的特殊业务处理
     * 
     * @return
     */
    public String dispatchDocZWH() {
        this.setNodeInstId(object.getNodeInstId());
        OptBaseInfo optBaseInfo = optBaseInfoManager.getOptBaseByFlowId(super
                .getFlowInstId());

        DispatchDoc dispatchDoc = dispatchDocManager.getObjectById(object
                .getDjId());

        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        OptHtmlFrameInfo transFrameInfo = new OptHtmlFrameInfo();
        transFrameInfo.setFrameId("transFrame");
        // transFrameInfo
        // .setFrameSrc("/powerruntime/optzwh!edit.do?djId="
        // + object.getDjId() + "&flowInstId="
        // + super.getFlowInstId() + "&nodeInstId="
        // + object.getNodeInstId() + "&moduleCode=" + moduleCode
        // + "&dispatchFileType="
        // + dispatchDoc.getDispatchFileType() + "&orgCode="
        // + optBaseInfo.getOrgcode());

        transFrameInfo.setFrameSrc("/dispatchdoc/ioDocArchiveNo!edit.do?djId="
                + object.getDjId() + "&flowInstId=" + super.getFlowInstId()
                + "&nodeInstId=" + object.getNodeInstId() + "&moduleCode="
                + moduleCode + "&dispatchFileType="
                + dispatchDoc.getDispatchFileType() + "&orgCode="
                + optBaseInfo.getOrgcode());

        frameList.add(transFrameInfo);
        frameList.add(getDispatchDocFrame(object.getDjId(), frameType));// 基础业务信息查看
        this.setFrameList(frameList, "置文号");
        super.initFlowTime();
        return "optframe";
    }

    /**
     * 查看或者编辑发文业务信息FRAME
     * 
     * @param djid
     * @param frameType
     *            查看或者编辑
     * @return
     */
    private OptHtmlFrameInfo getDispatchDocFrame(String djid, String frameType) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewFrame");
        // 编辑
        if ("edit".equals(frameType)) {
            viewFrameInfo
                    .setFrameSrc("/dispatchdoc/dispatchDoc!editDispatchDocInfo.do?djId="
                            + djid);
        }
        // 查看
        else if ("view".equals(frameType)) {
            viewFrameInfo
                    .setFrameSrc("/dispatchdoc/dispatchDoc!viewDispatchDocInfo.do?djId="
                            + djid);
        } else {
            viewFrameInfo
                    .setFrameSrc("/dispatchdoc/dispatchDoc!viewDispatchDocInfo.do?djId="
                            + djid);
        }

        return viewFrameInfo;
    }

    /**
     * 查看关联收文业务信息FRAME
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getDispatchDocRelativeFrame(String djid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("docRelativeFrame");

        viewFrameInfo
                .setFrameSrc("/dispatchdoc/dispatchDoc!docRelativeList.do?dispatchNo="
                        + djid
                        + "&docRelativeFrameType="
                        + docRelativeFrameType);

        return viewFrameInfo;
    }

    /**
     * 查看或者编辑发文业务信息FRAME
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getIncomeDocFrame(String djid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewFrame");
        viewFrameInfo
                .setFrameSrc("/dispatchdoc/incomeDoc!viewIncomeDocInfo.do?djId="
                        + djid);
        return viewFrameInfo;
    }

    /**
     * 保存过程日志信息
     */
    public void saveIdeaInfo() {
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        OptIdeaInfo optIdeaInfo = new OptIdeaInfo();
        optIdeaInfo.setUsername(loginInfo.getUsername());

        /** 获得用户所在部门 start */
        VUserUnits fuerunit = new VUserUnits();
        fuerunit.setUnitCode(loginInfo.getPrimaryUnit());
        fuerunit.setUserCode(loginInfo.getUsercode());
        fuerunit = sysUserManager.getUnitByUserCode(fuerunit);
        /** 获得用户所在部门 end */

        optIdeaInfo.setUnitname(fuerunit.getUnitName());

        /** 获取过程日志信息：环节名称、办理意见、环节状态 start */
        NodeInstance nodeInst = flowEngine.getNodeInstById(object
                .getNodeInstId());
        FlowNodeInfo nodeInfo = flowEngine
                .getNodeInfoById(nodeInst.getNodeId());
        object.setNodename(nodeInfo.getNodeName());
        object.setNodeinststate(nodeInst.getNodeState());
        optIdeaInfo.setTransidea(object.getTransidea());
        /** 获取过程日志信息：环节名称、办理意见、环节状态 end */

        optProcInfoManager.saveIdeaInfo(optIdeaInfo, object);

    }

    public FunctionManager getFunctionManager() {
        return functionManager;
    }

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    /**
     * 选择工作流
     * 
     * @return
     */
    public String selectFlow() {

        return this.genIncomeDocFrame();
    }

    /**
     * 办公室批分节点操作
     * 
     * @return
     */
    public String officeBranch() {
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        OptHtmlFrameInfo transFrameInfo = new OptHtmlFrameInfo();
        transFrameInfo.setFrameId("transFrame");
        transFrameInfo
                .setFrameSrc("/dispatchdoc/ioDocTasksExcute!ioDocPF.do?djId="
                        + object.getDjId() + "&flowInstId="
                        + super.getFlowInstId() + "&nodeInstId="
                        + object.getNodeInstId() + "&moduleCode=" + moduleCode);

        frameList.add(transFrameInfo);
        frameList.add(getIncomeDocFrame(object.getDjId()));// 基础业务信息查看
        this.setFrameList(frameList, "批分办理");
        initUsers();
        request.setAttribute("unitsJson", sysUnitManager.getAllUnitsJSON());
        return "optframe";
    }

    public String assignWorkGroup() {
        String[] userCodes = request.getParameter("userCode").split(",");
        if (userCodes != null && userCodes.length > 0) {
            flowEngine.assignFlowWorkTeam(super.getFlowInstId(), roleCode,
                    new HashSet<String>(Arrays.asList(userCodes)));
        }
        // request.setAttribute("flowInstId", super.getFlowInstId());
        return "ListWorkGroup";
    }

    public String deleteWorkGroup() {
        flowEngine.deleteFlowWorkTeam(super.getFlowInstId(), roleCode);
        return "ListWorkGroup";
    }

    public String deleteWorkGroupUser() {
        flowEngine.deleteFlowWorkTeam(super.getFlowInstId(), roleCode,
                request.getParameter("userCode"));
        return "ListWorkGroup";
    }

    public String assignFlowOrganize() {
        String[] orgCodes = request.getParameter("orgCode").split(",");
        if (orgCodes != null && orgCodes.length > 0) {
            flowEngine.assignFlowOrganize(super.getFlowInstId(), roleCode,
                    new HashSet<String>(Arrays.asList(orgCodes)));
        }
        // request.setAttribute("flowInstId", super.getFlowInstId());
        return "ListWorkGroup";
    }

    public String deleteFlowOrganize() {
        log.info("nodeInstId:" + object.getNodeInstId());
        flowEngine.deleteFlowOrganize(super.getFlowInstId(), roleCode);
        return "ListWorkGroup";
    }

    public String deleteFlowOrganizeUnit() {
        flowEngine.deleteFlowOrganize(super.getFlowInstId(), roleCode,
                request.getParameter("orgCode"));
        return "ListWorkGroup";
    }

    /**
     * 通用批分节点操作
     * 
     * @return
     */
    public String ioDocPF() {
        setTeamMap(flowEngine.viewFlowWorkTeam(super.getFlowInstId()));
        setOrgMap(flowEngine.viewFlowOrganize(super.getFlowInstId()));
        /*
         * super.initUsers(); setUnitsJson(sysUnitManager.getAllUnitsJSON());
         */
        return "ioDocPF";
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
     * 负责人分工
     * 
     * @return
     */
    public String principalDivision() {

        return this.defaltTransFrame();
    }

    /**
     * 主办承办人受理
     * 
     * @return
     */
    public String registrarAccept() {

        return this.defaltTransFrame();
    }

    /**
     * 主办承办人办理
     * 
     * @return
     */
    public String thereunderFor() {

        return this.defaltTransFrame();
    }

    /**
     * 负责人审核
     * 
     * @return
     */
    public String managerVerify() {

        return this.defaltTransFrame();
    }

    /**
     * 默认办理方法，某个步骤没有开发完成，方便进入下一个节点。防止步骤分工开发后的阻塞
     * 
     * @return
     */
    private String defaltTransFrame() {
        OptHtmlFrameInfo transFrame = new OptHtmlFrameInfo();
        transFrame.setFrameId("transFrame");
        transFrame
                .setFrameSrc("/punish/punishTasksExecute!defaultTrans.do?djId="
                        + object.getDjId() + "&flowInstId="
                        + super.getFlowInstId() + "&nodeInstId="
                        + object.getNodeInstId());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        frameList.add(transFrame);
        this.setFrameList(frameList, "默认办理");
        return "optframe";
    }

    public void setDispatchDocManager(DispatchDocManager dispatchDocManager) {
        this.dispatchDocManager = dispatchDocManager;
    }

    public String getFrameType() {
        return frameType;
    }

    public void setFrameType(String frameType) {
        this.frameType = frameType;
    }

    public void setIncomeDocManager(IncomeDocManager incomeDocManager) {
        this.incomeDocManager = incomeDocManager;
    }

    public String getDocRelativeFrameType() {
        return docRelativeFrameType;
    }

    public void setDocRelativeFrameType(String docRelativeFrameType) {
        this.docRelativeFrameType = docRelativeFrameType;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
