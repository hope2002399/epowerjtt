package com.centit.punish.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.page.OptJspInfo;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.service.OptProcInfoManager;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PunishobjectbasicManager;
import com.centit.sys.po.VUserUnits;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.FlowManager;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

/**
 * 
 * 行政处罚任务办理、明细加载ACTION 关键字 PO PunishObject
 * 
 * @author ljy
 * @create 2012-12-4
 * @version
 */
public class PunishTasksExecuteAction extends
        PowerRuntimeEntityAction<OptProcInfo> implements ServletResponseAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private OptJspInfo jspInfo;

    private PunishobjectbasicManager punishobjectbasicManager;

    private OptProcInfoManager optProcInfoManager;

    private SysUserManager sysUserManager;

    private FlowManager flowManager;

    private String nextOptUrl;

    HttpServletResponse response;

    private String moduleCode;

    private Long stuffGroupid;

    public Long getStuffGroupid() {
        return stuffGroupid;
    }

    public void setStuffGroupid(Long stuffGroupid) {
        this.stuffGroupid = stuffGroupid;
    }

    /**
     * 案件受理
     * 
     * @return
     */
    public String AcceptPO() {
        // extractFlowOptParam();
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        if (punishobjectbasic == null) {
            this.postAlertMessage("操作失败，原因可能是案件不存在！", response);
            return null;
        }
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/punishobjectbasic!acceptPO.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&moduleCode="
                        + moduleCode
                        + "&documentTemplateIds="
                        + super.getDocumentTemplateIds()
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());
        viewFrameInfo.setFrameHeight("490px");
        frameList.add(viewFrameInfo);

        addSqClFrame(object.getNodeInstId(), stuffGroupid, frameList,
                punishobjectbasic.getPunishobjectid());
        // addAllInfoFrame(object.getNodeInstId(),punishobjectbasic.getPunishobjectid(),super.getFlowPhase(),frameList);
        this.setFrameList(frameList, "案件受理");
        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        return "optframe";
    }

    /**
     * 案件受理审批
     * 
     * @return
     */
    public String isAcceptPO() {
        // extractFlowOptParam();
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/punishobjectbasic!isAcceptPO.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&moduleCode="
                        + moduleCode
                        + "&documentTemplateIds="
                        + super.getDocumentTemplateIds()
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());

        // 添加业务办理信息
        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, "案件受理审批");
        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        // 跳转到 操作界面
        // TODO 增加上一部办理信息的FRAME
        // TODO 增加案件基本信息FRAME
        return "optframe";
    }

    /**
     * 立案前调查
     * 
     * @return
     */
    public String PORegister() {

        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poregisterbasic!pORegister.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&roleCodefromFlow=" + super.getRoleCodefromFlow());

        frameList.add(viewFrameInfo);

        addSqClFrame(object.getNodeInstId(), stuffGroupid, frameList,
                punishobjectbasic.getPunishobjectid());
        this.setFrameList(frameList, "立案前调查");

        return "optframe";

    }

    /**
     * 立案科室审批
     * 
     * @return
     */
    public String isKSPORegister() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());
        // 初核与立案审批信息
        this.addIsPORegisterInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poregisterbasic!isKSPORegister.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&moduleCode="
                        + moduleCode
                        + "&documentTemplateIds="
                        + super.getDocumentTemplateIds()
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());
        frameList.add(viewFrameInfo);
        this.setFrameList(frameList, "立案科室审批");
        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        return "optframe";
    }

    /**
     * 立案审批
     * 
     * @return
     */
    public String isPORegister() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());
        // 初核与立案审批信息
        this.addIsPORegisterInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poregisterbasic!ispORegister.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&moduleCode="
                        + moduleCode
                        + "&documentTemplateIds="
                        + super.getDocumentTemplateIds()
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());
        frameList.add(viewFrameInfo);
        this.setFrameList(frameList, "立案审批");
        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        return "optframe";
    }

    /**
     * 调查取证
     * 
     * @return
     */
    public String inquireProof() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poindagaterepbasic!inquireProof.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&roleCodefromFlow=" + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        frameList.add(viewFrameInfo);
        addSqClFrame(object.getNodeInstId(), stuffGroupid, frameList,
                punishobjectbasic.getPunishobjectid());

        this.setFrameList(frameList, "调查取证");

        // TODO 增加上一部办理信息的FRAME
        // TODO 增加案件基本信息FRAME

        return "optframe";
    }

    /**
     * 调查取证审核
     * 
     * @return
     */
    public String isProofResult() {

        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poindagaterepbasic!isProofResult.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&documentTemplateIds="
                        + super.getDocumentTemplateIds()
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        this.addPunishOptInquireProofFrame(frameList,
                punishobjectbasic.getPunishobjectid());
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        frameList.add(viewFrameInfo);
        this.setFrameList(frameList, "调查结果");
        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        return "optframe";
    }

    /**
     * 调查取证意见
     * 
     * @return
     */
    public String proofAuditing() {

        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poindagaterepbasic!proofAuditing.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&moduleCode="
                        + moduleCode
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        this.addPunishOptInquireProofFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());
        // TODO 增加上一部办理信息的FRAME
        // TODO 增加案件基本信息FRAME
        frameList.add(viewFrameInfo);
        this.setFrameList(frameList, "调查取证行政执法机关意见");
        return "optframe";
    }

    /**
     * 案件讨论
     * 
     * @return
     */
    public String PODiscuss() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/podiscussbasic!PODiscuss.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&roleCodefromFlow=" + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, fif.getNodeName());
        return "optframe";
    }

    /**
     * 案件二次讨论
     * 
     * @return
     */
    public String PO2Discuss() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/podiscussbasic!PO2Discuss.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&roleCodefromFlow=" + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, fif.getNodeName());
        return "optframe";
    }

    /**
     * 陈述、申辩与听证
     * 
     * @return
     */
    public String POExcuce() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poexcucebasic!csSbTz.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId=" + super.getFlowInstId()
                        + "&nodeInstId=" + object.getNodeInstId()
                        + "&flowPhase=" + super.getFlowPhase()
                        + "&roleCodefromFlow=" + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        // 添加案件基本信息
        frameList.add(viewFrameInfo);
        addSqClFrame(object.getNodeInstId(), stuffGroupid, frameList,
                punishobjectbasic.getPunishobjectid());

        this.setFrameList(frameList, fif.getNodeName());

        return "optframe";
    }

    /**
     * 处罚决定：经办人意见,
     * 
     * @return
     */
    public String punishDecision() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/punishobjectbasic!punishDecision.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&roleCodefromFlow=" + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "punishDecision");
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, fif.getNodeName());

        // 跳转到 操作界面
        // TODO 增加上一部办理信息的FRAME
        // TODO 增加案件基本信息FRAME
        return "optframe";
    }

    /**
     * 处罚决定审批：经办人意见，领导审批等
     * 
     * @return
     */
    public String isPunishDecision() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/punishobjectbasic!isPunishDecision.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&moduleCode="
                        + moduleCode
                        + "&documentTemplateIds="
                        + super.getDocumentTemplateIds()
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, fif.getNodeName());
        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        return "optframe";
    }

    /**
     * 送达处罚决定书
     * 
     * @return
     */
    public String sendPunishDoc() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poreceiptinfo!sendPunishDoc.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&documentTemplateIds="
                        + super.getDocumentTemplateIds()
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, fif.getNodeName());
        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        return "optframe";
    }

    /**
     * 送达预先告知书
     * 
     * @return
     */
    public String sendAdvanceDoc() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poreceiptinfo!sendAdvanceDoc.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&documentTemplateIds="
                        + super.getDocumentTemplateIds()
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, fif.getNodeName());

        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        return "optframe";
    }

    /**
     * 处罚执行情况的登记
     * 
     * @return
     */
    public String doBookfinish() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/pofinishbasic!doBookfinish.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&roleCodefromFlow=" + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, fif.getNodeName());

        return "optframe";
    }

    /**
     * 结案审批：经办人意见，领导审批等
     * 
     * @return
     */
    public String isPOFinish() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/pofinishbasic!isPOFinish.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&moduleCode="
                        + moduleCode
                        + "&documentTemplateIds="
                        + super.getDocumentTemplateIds()
                        + "&roleCodefromFlow="
                        + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        this.addFinishBasicView(frameList,
                punishobjectbasic.getPunishobjectid());
        // 添加案件结果信息
        // this.addPunishResultViewFrameInfo(frameList,
        // punishobjectbasic.getPunishobjectid());
        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, fif.getNodeName());
        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        return "optframe";
    }

    /**
     * 结案
     * 
     * @return
     */
    public String POFinish() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        NodeInstance nit = flowEngine.getNodeInstById(object.getNodeInstId());
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/pofinishbasic!poFinish.do?punishobjectid="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId="
                        + super.getFlowInstId()
                        + "&nodeInstId="
                        + object.getNodeInstId()
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&roleCodefromFlow=" + super.getRoleCodefromFlow());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 案件来源信息
        this.addPunishSourseInfoFrame(frameList,
                punishobjectbasic.getPunishobjectid());

        // 添加案件基本信息
        this.addViewFrameInfo(frameList, punishobjectbasic.getPunishobjectid(),
                "");
        // 添加案件结果信息
        // this.addPunishResultViewFrameInfo(frameList,
        // punishobjectbasic.getPunishobjectid());
        // 案件办理过程意见
        // this.addPunishOptInfoFrame(frameList,punishobjectbasic.getPunishobjectid());

        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, fif.getNodeName());
        return "optframe";
    }

    /**
     * 初核与立案审批信息
     * 
     * @param frameList
     * @param punishobjectid
     * @param flowPhase
     */
    private void addIsPORegisterInfoFrame(List<OptHtmlFrameInfo> frameList,
            String punishobjectid) {
        OptHtmlFrameInfo viewFrameInfo1 = new OptHtmlFrameInfo();
        viewFrameInfo1.setFrameId("addIsPORegisterInfoFrame");
        viewFrameInfo1
                .setFrameSrc("/punish/poregisterbasic!initialAndApproval.do?punishobjectid="
                        + punishobjectid
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&nodeInstId=" + object.getNodeInstId());

        frameList.add(viewFrameInfo1);

    }

    /**
     * 案件办理过程意见
     * 
     * @param frameList
     * @param punishobjectid
     */
    private void addPunishOptInfoFrame(List<OptHtmlFrameInfo> frameList,
            String punishobjectid) {
        OptHtmlFrameInfo viewFrameInfo1 = new OptHtmlFrameInfo();
        viewFrameInfo1.setFrameId("PunishOptInfoFrame");
        viewFrameInfo1
                .setFrameSrc("/punish/punishobjectbasic!viewPunishOptInfo.do?punishobjectid="
                        + punishobjectid
                        + "&flowPhase="
                        + super.getFlowPhase()
                        + "&nodeInstId=" + object.getNodeInstId());

        frameList.add(viewFrameInfo1);

    }

    /**
     * 案件调查取证信息Frame
     * 
     * @param frameList
     * @param punishobjectid
     */
    private void addPunishOptInquireProofFrame(
            List<OptHtmlFrameInfo> frameList, String punishobjectid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("PunishOptInquireProofFrame");
        viewFrameInfo
                .setFrameSrc("/punish/poindagaterepbasic!viewInquireProof.do?punishobjectid="
                        + punishobjectid + "");
        frameList.add(viewFrameInfo);
    }

    /**
     * 添加案件基础信息
     * 
     * @param frameList
     */
    private void addViewFrameInfo(List<OptHtmlFrameInfo> frameList,
            String punishobjectid, String punishDecision) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("basicFrame");
        viewFrameInfo
                .setFrameSrc("/punish/punishobjectbasic!punishBasicFrame.do?punishobjectid="
                        + punishobjectid + "&flagFrame=" + punishDecision);
        frameList.add(viewFrameInfo);

    }

    /**
     * 添加案件结果信息
     */
    /*
     * private void addPunishResultViewFrameInfo(List<OptHtmlFrameInfo>
     * frameList,String punishobjectid){ OptHtmlFrameInfo poresultFrameInfo =
     * new OptHtmlFrameInfo(); poresultFrameInfo.setFrameId("resultFrame");
     * poresultFrameInfo
     * .setFrameSrc("/punish/punishobjectbasic!punishResultFrame.do?punishobjectid="
     * +punishobjectid); frameList.add(poresultFrameInfo); }
     */

    @SuppressWarnings("unused")
    private void addAllInfoFrame(Long nodeInstId, String punishobjectid,
            String flowPhase, List<OptHtmlFrameInfo> frameList) {
        
        String src = "/punish/punishobjectbasic!generOptAllInfo.do?punishobjectid="
                + punishobjectid
                + "&nodeInstId="
                + nodeInstId
                + "&flowPhase="
                + flowPhase;
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("allinfoFrame");

        viewFrameInfo.setFrameSrc(src);
        frameList.add(viewFrameInfo);
    }

    private void addFinishBasicView(List<OptHtmlFrameInfo> frameList,
            String punishobjectid) {
        OptHtmlFrameInfo viewFrameInfo1 = new OptHtmlFrameInfo();
        viewFrameInfo1.setFrameId("FinishBasicView");
        viewFrameInfo1
                .setFrameSrc("/punish/pofinishbasic!viewFinishBasic.do?punishobjectid="
                        + punishobjectid);
        frameList.add(viewFrameInfo1);

    }

    private void addPunishSourseInfoFrame(List<OptHtmlFrameInfo> frameList,
            String punishobjectid) {
        OptHtmlFrameInfo viewFrameInfo1 = new OptHtmlFrameInfo();
        viewFrameInfo1.setFrameId("addPunishSourseInfoFrame");
        viewFrameInfo1
                .setFrameSrc("/punish/punishobjectbasic!viewPunishobjectbasic.do?punishobjectid="
                        + punishobjectid);

        frameList.add(viewFrameInfo1);

    }

    /**
     * 案件详细信息 1、案件来源登记 2、案件受理 ajsl 3、初核与立案调查 cfla 4、调查取证 dcqz 5、案件讨论 ajtl
     * 6、陈述申辩、听证 cssbtz 7、二次讨论 ajtl_ectl 8、处罚决定 cfjd 9、执行情况与结案 cfja
     * 
     * @return
     */
    public String punishAllInfo() {
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        String punishObjectId = request.getParameter("punishObjectId");
        String flowphase = super.getFlowPhase();

        // 组装各个阶段信息
        this.addPunishAllInfoFrame(frameList, punishObjectId, flowphase);
        // 案件办理过程意见
        this.addPunishOptInfoFrame(frameList, punishObjectId);
        // 此阶段文书

        jspInfo = new OptJspInfo();
        jspInfo.setTitle("");
        jspInfo.setFrameList(frameList);
        return "optframe";
    }

    /**
     * 
     * @param frameList
     * @param punishObjectId
     * @param flowphase
     */
    private void addPunishAllInfoFrame(List<OptHtmlFrameInfo> frameList,
            String punishObjectId, String flowphase) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        String FrameId = flowphase + "Frame";
        String FrameSrc = "";
        viewFrameInfo.setFrameId(FrameId);
        if ("ajsl".equalsIgnoreCase(flowphase)) {// 案件受理
            FrameSrc = "/punish/punishobjectbasic!viewPunishobjectbasic.do?punishobjectid="
                    + punishObjectId;

        } else if ("cfla".equalsIgnoreCase(flowphase)) {// 初核与立案调查
            FrameSrc = "/punish/punishobjectbasic!viewPunishobjectbasic.do?punishobjectid="
                    + punishObjectId + "&flowPhase=" + flowphase;

        } else if ("dcqz".equalsIgnoreCase(flowphase)) {// 调查取证

        } else if ("ajtl".equalsIgnoreCase(flowphase)) {// 案件讨论

        } else if ("cssbtz".equalsIgnoreCase(flowphase)) {// 陈述申辩、听证

        } else if ("ajtl_ectl".equalsIgnoreCase(flowphase)) {// 二次讨论

        } else if ("cfjd".equalsIgnoreCase(flowphase)) {// 处罚决定

        } else if ("cfja".equalsIgnoreCase(flowphase)) {// 执行情况与结案

        }
        viewFrameInfo.setFrameSrc(FrameSrc);

        frameList.add(viewFrameInfo);
    }

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
        return this.nextStep();
    }

    /**
     * 提交受理审批操作结果
     * 
     * @return
     */

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

    /**
     * 保存操作结果
     * 
     * @return
     */
    public String saveOpt() {
        try {
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
            optProcInfoManager.saveObject(object);

            // 保存办件人员
            saveTeamRolepeople();
            return "refreshTasks";
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存流程过程信息失败。");
            return ERROR;
        }
    }

    /**
     * 回退节点
     * 
     * @return
     */
    public String rollBackOpt() {
        flowManager.rollbackOpt(object.getNodeInstId(),
                ((FUserDetail) getLoginUser()).getUsercode());
        // 保存过程日志信息
        if (!"B".equals(object.getIdeacode())) {
            object.setIdeacode("B");
            object.setTransidea("退回");
            object.setTranscontent("退回");
        }
        saveIdeaInfo();
        return "refreshTasks";
    }

    private String roleCode;
    private String bjUserNames;
    private String teamRoles;

    /**
     * 保存办件人员
     */
    public void saveTeamRolepeople() {
        // flowEngine.deleteFlowWorkTeam(super.getFlowInstId(),"ajjbr");
        if (!StringUtils.isBlank(teamRoles)) {
            String[] teamRole = teamRoles.split(",");
            if (teamRole.length > 0) {
                for (String a : teamRole) {
                    flowEngine.assignFlowWorkTeam(super.getFlowInstId(),
                            "ajjbr", a);
                }
            }
        }
    }

    /**
     * 保存过程日志信息
     */
    public void saveIdeaInfo() {
        try {
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
            FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nodeInst
                    .getNodeId());
            object.setNodename(nodeInfo.getNodeName());
            object.setNodeinststate(nodeInst.getNodeState());
            object.setTransdate(new Date(System.currentTimeMillis()));
            object.setUsercode(loginInfo.getUsercode());
            object.setUnitcode(loginInfo.getPrimaryUnit());
            optIdeaInfo.setTransidea(object.getTransidea());
            /** 获取过程日志信息：环节名称、办理意见、环节状态 end */

            optProcInfoManager.saveIdeaInfo(optIdeaInfo, object);
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存业务过程信息失败。");
        }
    }

    private List<OptHtmlFrameInfo> setFrameList(
            List<OptHtmlFrameInfo> frameList, String moduleDesc) {
        Punishobjectbasic punishBasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        // frameList.add(GeneralOperatorAction.getIdeaListFrame(punishBasic.getPunishobjectid()));
        //
        // frameList.add(GeneralOperatorAction.getStuffListFrame(punishBasic.getPunishobjectid()));
        addAllPunishOptInfoFrame(frameList, punishBasic.getPunishobjectid());

        jspInfo = new OptJspInfo();
        jspInfo.setTitle(moduleDesc);
        jspInfo.setFrameList(frameList);

        return null;
    }

    private void addAllPunishOptInfoFrame(List<OptHtmlFrameInfo> frameList,
            String punishobjectid) {
        OptHtmlFrameInfo viewFrameInfo1 = new OptHtmlFrameInfo();
        viewFrameInfo1.setFrameId("AllPunishOptInfoFrame");
        viewFrameInfo1
                .setFrameSrc("/punish/punishobjectbasic!getAllPunishView.do?punishobjectid="
                        + punishobjectid
                        + "&nodeInstId="
                        + object.getNodeInstId());

        frameList.add(viewFrameInfo1);
    }

    /**
     * 默认办理方法，某个步骤没有开发完成，方便进入下一个节点。防止步骤分工开发后的阻塞
     * 
     * @return
     */
    public String defaultTrans() {
        return "defaultTrans";
    }

    /**
     * 默认办理方法，某个步骤没有开发完成，方便进入下一个节点。防止步骤分工开发后的阻塞
     * 
     * @return
     */
    @SuppressWarnings("unused")
    private void defaltFrame() {
        Punishobjectbasic punishobjectbasic = punishobjectbasicManager
                .getPunishBaseByFlowId(super.getFlowInstId());

        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("transFrame");
        viewFrameInfo
                .setFrameSrc("/punish/punishTasksExecute!defaultTrans.do?djId="
                        + punishobjectbasic.getPunishobjectid()
                        + "&flowInstId=" + super.getFlowInstId()
                        + "&nodeInstId=" + object.getNodeInstId());
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        frameList.add(viewFrameInfo);

        this.setFrameList(frameList, "默认办理");
    }

    public PunishobjectbasicManager getPunishobjectbasicManager() {
        return punishobjectbasicManager;
    }

    public void setPunishobjectbasicManager(
            PunishobjectbasicManager punishobjectbasicManager) {
        this.punishobjectbasicManager = punishobjectbasicManager;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public OptProcInfoManager getOptProcInfoManager() {
        return optProcInfoManager;
    }

    public void setOptProcInfoManager(OptProcInfoManager optProcInfoManager) {
        this.optProcInfoManager = optProcInfoManager;
    }

    public OptJspInfo getJspInfo() {
        return jspInfo;
    }

    public void setJspInfo(OptJspInfo jspInfo) {
        this.jspInfo = jspInfo;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getBjUserNames() {
        return bjUserNames;
    }

    public void setBjUserNames(String bjUserNames) {
        this.bjUserNames = bjUserNames;
    }

    public String getTeamRoles() {
        return teamRoles;
    }

    public void setTeamRoles(String teamRoles) {
        this.teamRoles = teamRoles;
    }

    public void setFlowManager(FlowManager flowManager) {
        this.flowManager = flowManager;
    }

    public String getNextOptUrl() {
        return nextOptUrl;
    }

    public void setNextOptUrl(String nextOptUrl) {
        this.nextOptUrl = nextOptUrl;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;

    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * 弹出提示信息
     * 
     * @param msg
     * @param response
     */
    protected void postAlertMessage(String msg, HttpServletResponse response) {

        String alertCoding = "GBK";

        ServletOutputStream sos;
        String str = "<script language=\"JavaScript\""
                + " type=\"text/JavaScript\" charset=\"" + alertCoding + "\">"
                + "javascript:alert('" + msg + "');history.back(-1);"
                + " </script>";

        response.setContentType("text/html; charset=" + alertCoding);
        try {
            sos = response.getOutputStream();
            int strSize = (int) str.length();
            byte[] b = new byte[strSize];
            b = str.getBytes();
            sos.write(b);
            sos.flush();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

}
