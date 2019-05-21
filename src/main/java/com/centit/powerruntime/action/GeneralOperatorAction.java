package com.centit.powerruntime.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import DBstep.iFileUpLoad2000;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.service.DispatchDocManager;
import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptExpressMessage;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcAttention;
import com.centit.powerruntime.po.OptProcAttentionId;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.po.OptStuffInfoNet;
import com.centit.powerruntime.po.Suppowerstuffgroup;
import com.centit.powerruntime.po.Suppowerstuffinfo;
import com.centit.powerruntime.po.TemplateFile;
import com.centit.powerruntime.po.VOptStuffInfo;
import com.centit.powerruntime.po.VRegNoFileName;
import com.centit.powerruntime.po.YwFile;
import com.centit.powerruntime.po.YwFiles;
import com.centit.powerruntime.service.GeneralModuleParamManager;
import com.centit.powerruntime.service.OptApplyManager;
import com.centit.powerruntime.service.OptBaseInfoManager;
import com.centit.powerruntime.service.OptExpressMessageManager;
import com.centit.powerruntime.service.OptProcInfoManager;
import com.centit.powerruntime.service.OptStuffInfoNetManager;
import com.centit.powerruntime.service.SuppowerstuffgroupManager;
import com.centit.powerruntime.service.SuppowerstuffinfoManager;
import com.centit.powerruntime.service.VRegNoFileNameManager;
import com.centit.powerruntime.service.YwFileManager;
import com.centit.powerruntime.service.YwFilesManager;
import com.centit.sys.po.VUserUnits;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.FlowDefine;
import com.centit.workflow.FlowDescribe;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.sample.po.VNodeInstDetail;
import com.opensymphony.xwork2.ActionContext;
import com.sun.mail.iap.Literal;

/**
 * 
 * 通用的业务操作类，其中包括一下功能 1，获取某个业务的所有操作环节 2，获得某个业务的所有附件 3，上传附件（可以内嵌到通用的业务操作中）
 * 4，通用的业务操作页面、保存和提交
 * 
 * @author codefan
 * @create 2012-6-27
 * @version
 */
public class GeneralOperatorAction extends
        PowerRuntimeEntityAction<OptProcInfo> implements ServletResponseAware {
    private static final Log log = LogFactory
            .getLog(GeneralOperatorAction.class);
    private static final long serialVersionUID = 1L;
    private GeneralModuleParamManager generalModuleParamMag;
    private OptExpressMessageManager optExpressMessageManager;
    private SysUserManager sysUserManager;
    private OptBaseInfoManager optBaseInfoManager;
    private SuppowerstuffgroupManager suppowerstuffgroupManager;
    private SuppowerstuffinfoManager suppowerstuffinfoManager;
    private YwFilesManager ywFilesManager;
    private VRegNoFileNameManager vRegNoFileNameManager;
    private OptApplyManager optApplyManager;
    private DispatchDocManager dispatchDocManager;
    private FlowDefine flowDefine;
    private String roleCode;
    private String unitsJson;
    private String optBaseInfoJson;

    private List<FlowDescribe> fwList;
    private List<FlowDescribe> swList;
    private List<Map<String, String>> year;
    private List<VOptStuffInfo> VOpt;

    

    public void setvRegNoFileNameManager(VRegNoFileNameManager vRegNoFileNameManager) {
        this.vRegNoFileNameManager = vRegNoFileNameManager;
    }

    public void setSuppowerstuffinfoManager(
            SuppowerstuffinfoManager suppowerstuffinfoManager) {
        this.suppowerstuffinfoManager = suppowerstuffinfoManager;
    }

    public void setGeneralModuleParamMag(
            GeneralModuleParamManager generalModuleParamMag) {
        this.generalModuleParamMag = generalModuleParamMag;
    }

    public GeneralOperatorAction() {
        object = new OptProcInfo();
    }

    public void setOptProcInfoManager(OptProcInfoManager basemgr) {
        optProcInfoManager = basemgr;
        this.setBaseEntityManager(optProcInfoManager);
    }

    public void setOptExpressMessageManager(
            OptExpressMessageManager optExpressMessageManager) {
        this.optExpressMessageManager = optExpressMessageManager;
    }

    public void setFlowDefine(FlowDefine flowDefine) {
        this.flowDefine = flowDefine;
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

    /**
     * 通用置文号节点操作
     * 
     * @return
     */
    // public String ioDocZwh() {
    // DispatchDoc dis = dispatchDocManager.getObjectById(object.getDjId());
    // String fwh = dis.getDispatchDocNo();
    // String wjlx = dis.getDispatchFileType();
    // String lsh = dis.getDjId();
    //
    // year = getFromArray();
    //
    // return "ioDocZwh";
    // }

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
     * 获取通用模块参数 ，以供生成通用模块操作界面
     * 
     * @return
     */
    public String doOpt() {

        try {
            moduleParam = generalModuleParamMag.getObjectById(moduleCode);// "XKSL"
            extractFlowOptParam();
            object = optProcInfoManager.getObjectByNodeInstId(curNodeInstId);

            // TODO 判断是 新建 还是更新
            if (object == null) {
                object = new OptProcInfo();
                object.setDjId(request.getParameter("djId"));
            }

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
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            String username = loginInfo.getUsername();
            optBaseInfoJson = optApplyManager.getJSONDocumentNames(
                    object.getDjId(), username);
            /**
             * 根据是否可以生产公文 ，确定需要编辑的文档模板
             */
            super.initTemplateConfig();
            /**
             * 多模板情况加载
             */
            super.initTemplateFromNode();
            String recordId = "";
            if (null != super.getTemplateList()) {
                if (StringUtils.isBlank(object.getRecordId())) {// 没有点击"保存",但是文书已经存在了.
                    long nodeid = 0;
                    if (null != object.getNodeInstId()) {
                        nodeid = object.getNodeInstId();
                    } else {
                        nodeid = curNodeInstId;
                    }
                    List<OptStuffInfo> stuffInfos = optProcInfoManager
                            .listStuffsByNode(nodeid);
                    if (null != stuffInfos) {
                        if (stuffInfos.size() == 1) {
                            recordId = isCheckSuffSave(super.getTemplateList(),
                                    (OptStuffInfo) stuffInfos.get(0));
                        } else {
                            for (OptStuffInfo optStuffInfo : stuffInfos) {
                                if (!"03".equals(optStuffInfo.getArchivetype())) {
                                    recordId = isCheckSuffSave(
                                            super.getTemplateList(),
                                            optStuffInfo);
                                }
                                if (StringUtils.isNotBlank(recordId)) {
                                    break;
                                }
                            }
                        }
                        object.setRecordId(recordId);
                    }
                } else {
                    recordId = object.getRecordId();
                }
            }
            List<OptProcInfo> optProcInfos = optApplyManager
                    .getOptProcInfos(object.getDjId());
            HashSet<String> temp = new HashSet<String>();
            String optProInfoString = "";
            if (null != optProcInfos) {
                for (OptProcInfo optProcInfo : optProcInfos) {
                    String userName = sysUserManager.getObjectById(
                            optProcInfo.getUsercode()).getUsername();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                    if (!temp.contains(optProcInfo.getNodename())) {
                        temp.add(optProcInfo.getNodename());
                        if (StringUtils.isNotBlank(optProInfoString)) {
                            optProInfoString = optProInfoString + ";"
                                    + optProcInfo.getNodeInstId() + "|";
                            if (optProcInfo.getTranscontent() != null) {
                                // 把分号:替换为逗号,过滤"|"不然页面解析js会报错
                                optProInfoString = optProInfoString
                                        + optProcInfo.getTranscontent()
                                                .replaceAll(";", ",")
                                                .replaceAll("|", "");
                            } else {
                                optProInfoString = optProInfoString + "";
                            }
                            optProInfoString = optProInfoString + "|"
                                    + userName + "|"
                                    + sdf.format(optProcInfo.getTransdate())
                                    + "|" + optProcInfo.getNodename();
                        } else {
                            optProInfoString = optProcInfo.getNodeInstId()
                                    + "|";
                            if (optProcInfo.getTranscontent() != null) {
                                // 把分号:替换为逗号,过滤"|"不然页面解析js会报错
                                optProInfoString = optProInfoString
                                        + optProcInfo.getTranscontent()
                                                .replaceAll(";", ",")
                                                .replaceAll("|", "");
                            } else {
                                optProInfoString = optProInfoString + "";
                            }
                            optProInfoString = optProInfoString + "|"
                                    + userName + "|"
                                    + sdf.format(optProcInfo.getTransdate())
                                    + "|" + optProcInfo.getNodename();
                        }
                    }
                }
            }

            request.setAttribute("optProInfo",
                    optProInfoString.replaceAll("[\\t\\n\\r]", "")); // 把换行符过滤掉,不然页面解析js会报错
            request.setAttribute("recordId", recordId);

            // 初始化环节名称
            NodeInstance nodeInst = flowEngine.getNodeInstById(curNodeInstId);
            FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nodeInst
                    .getNodeId());
            if (moduleCode.equals("gkcbsj_zz")
                    || moduleCode.equals("gkjgys_zz")
                    || moduleCode.equals("gklh_zz")
                    || moduleCode.equals("XKZZJ") || moduleCode.equals("XKZZ")
                    || moduleCode.equals("XKZZ1030") || moduleCode.equals("ZZ")
                    || moduleCode.equals("ZZBSD") || moduleCode.equals("PAP")
                    || "yzwhs_sd".equals(moduleCode)) {// 用moduleCode来判断是否显示EMS信息
                OptExpressMessage emsinfo = optExpressMessageManager
                        .getExpressMessageInfoBydjId(object.getDjId());
                if (null != emsinfo) {
                    request.setAttribute("emsinfo", emsinfo);
                    request.setAttribute("isSendEms", "T");
                } else {
                    request.setAttribute("isSendEms", "F");
                }
            }
            request.setAttribute("nowNodeName", nodeInfo.getNodeName());
        } catch (Exception e) {
            log.error(e, e.getCause());
            e.printStackTrace();
            request.setAttribute("error", "通用配置功能出错，请检查各配置项是否准确。");
            return ERROR;
        }
        return "optForm";
    }

    private String isCheckSuffSave(List<TemplateFile> templateList,
            OptStuffInfo optStuffInfo) {

        for (TemplateFile templateFile : templateList) {
            if (optStuffInfo.getFilename().equals(
                    templateFile.getDescript() + ".doc")) {
                return templateFile.getRecordId();
            }
        }
        return "";
    }

    /**
     * 保存操作结果
     * 
     * @return
     */
    public String saveOpt() {
        // TODO 添加保存操作
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        object.setTransdate(new Date(System.currentTimeMillis()));
        object.setUsercode(loginInfo.getUsercode());
        object.setUnitcode(loginInfo.getPrimaryUnit());

        this.setNodeInstId(object.getNodeInstId());

        log.info("NodeInstId:" + object.getNodeInstId());
        NodeInstance nodeInst = flowEngine.getNodeInstById(object
                .getNodeInstId());
        FlowNodeInfo nodeInfo = flowEngine
                .getNodeInfoById(nodeInst.getNodeId());
        object.setNodename(nodeInfo.getNodeName());
        object.setNodeinststate(nodeInst.getNodeState());

        // 存在风险点的信息:风险类别、风险描述、风险内控手段与结果
        if (StringUtils.isNotBlank(object.getRisktype())) {
            object.setIsrisk("T");// 存在
        } else {
            object.setIsrisk("F");// 不存在
        }

        object.setRecordId(object.getRecordId());
        optProcInfoManager.saveObject(object);
        // 修改opt_base_info中bizType状态
        String rolecode = nodeInfo.getRoleCode();
        String djId = object.getDjId();
        if ("XKSL".equals(rolecode) || "XKFHSD".equals(rolecode)) {
            optBaseInfoManager.updateBizType(djId, rolecode);

        }

        // 保存关注人员
        saveAtt();
        saveTeamRolepeople();
        return "refreshTasks";
    }

    /**
     * 提交操作结果
     * 
     * @return
     */
    public String submitOpt() {
        saveOpt();
        String expressid = request.getParameter("expressid");
        String emsordno = request.getParameter("emsordno");
        if (StringUtils.isNotBlank(expressid)
                && StringUtils.isNotBlank(emsordno)) {
            optExpressMessageManager.sendExpreeMessage(expressid);
        }
        submitNode();
        // 保存过程日志信息
        saveIdeaInfo();

        return "refreshTasks";
    }

    /**
     * 暂缓处理
     * 
     * @return
     */
    public String suspendNodeInstance() {
        flowManager.suspendNodeInstance(object.getNodeInstId(),
                ((FUserDetail) getLoginUser()).getUsercode());
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
        return "refreshTasks";
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
        return "refreshTasks";
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

    // TODO 在这儿 可能还需要 添加 暂停计时、挂起流程和终止流程的方法
    /**
     * -------------------------------------------------------------------------
     * 获取流程操作日志
     */

    List<OptIdeaInfo> ideaLogs;// 各个操作节点

    public List<OptIdeaInfo> getIdeaLogs() {
        return ideaLogs;
    }

    public void setIdeaLogs(List<OptIdeaInfo> ideaLogs) {
        this.ideaLogs = ideaLogs;
    }

    public String listIdeaLogs() {

        ideaLogs = optProcInfoManager.listIdeaLogsByDjId(object.getDjId());
        return "listIdeaLogs";
    }

    public static OptHtmlFrameInfo getIdeaListFrame(String djId) {
        OptHtmlFrameInfo procFrameInfo = new OptHtmlFrameInfo();
        procFrameInfo.setFrameId("procFrame");
        procFrameInfo
                .setFrameSrc("/powerruntime/generalOperator!listIdeaLogs.do?djId="
                        + djId);
        procFrameInfo.setFrameHeight("300px");
        // frameMap.put("proc", procFrameInfo);
        return procFrameInfo;
    }
    

    /**
     * -------------------------------------------------------------------------
     * TODO 对附件的操作
     */
    private OptStuffInfo stuffInfo;

    private List<YwFiles> suppowerstuffinfos;
    /**
     * 附件材料文件，供上传使用
     */
    private File stuffFile;

    private String stuffFileFileName;

    public String getStuffFileFileName() {
        return stuffFileFileName;
    }

    public void setStuffFileFileName(String stuffFileFileName) {
        this.stuffFileFileName = stuffFileFileName;
    }

    /**
     * 材料下载使用
     */
    private InputStream stuffStream;

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    public File getStuffFile() {
        return stuffFile;
    }

    public void setStuffFile(File stuffFile) {
        this.stuffFile = stuffFile;
    }

    public OptStuffInfo getStuffInfo() {
        return stuffInfo;
    }

    public void setStuffInfo(OptStuffInfo stuffInfo) {
        this.stuffInfo = stuffInfo;
    }

    public String downloadStuff() {
        OptStuffInfo stuffObj = optProcInfoManager.getStuffById(stuffInfo
                .getStuffid());
        if (stuffObj != null)
            stuffInfo = stuffObj;

        try {
            setStuffStream(new ByteArrayInputStream(stuffObj.getStuffcontent()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }
        // TODO 用户下载 附件材料
        return "download";
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13)
                + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return temp;
    }

    /**
     * -------------------------------------------------------------------------
     * 保存附件
     */
    @SuppressWarnings("resource")
    public String saveStuff() {
        try {
            FUserDetail loguser = ((FUserDetail) getLoginUser());
            if ("1".equals(stuffInfo.getIszhi())) {
                stuffInfo.setStuffid(getUUID());

                stuffInfo.setUploadtime(new Date());
                stuffInfo.setUploadusercode(loguser.getUsercode());
                stuffInfo.setFilename("纸质文件");

                VNodeInstDetail o = flowManager
                        .getVNodeInstDetailbyNode(stuffInfo.getNodeInstId());
                if (o != null) {
                    stuffInfo.setNodename(o.getNodeName());
                } else {
                    stuffInfo.setNodename("办件登记");
                }
                optProcInfoManager.saveStuffInfo(stuffInfo);
            }
            if (stuffInfo.getIszhi() == null && stuffFile == null) {
                optProcInfoManager.deleteStuffByiszhi(stuffInfo.getSortId());
            } else if (stuffFile != null) {
                byte[] bbuf = null;

                FileInputStream fis = new FileInputStream(stuffFile);
                if (fis != null) {
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                }
                stuffInfo.setStuffcontent(bbuf);
                stuffInfo.setStuffid(getUUID());
                stuffInfo.setFilename(stuffFileFileName);
                stuffInfo.setUploadtime(new Date());
                stuffInfo.setUploadusercode(loguser.getUsercode());

                VNodeInstDetail o = flowManager
                        .getVNodeInstDetailbyNode(stuffInfo.getNodeInstId());
                if (o != null) {
                    stuffInfo.setNodename(o.getNodeName());
                } else {
                    stuffInfo.setNodename("办件登记");
                }
                optProcInfoManager.saveStuffInfo(stuffInfo);
            }
            return "gotosqcl";

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    @SuppressWarnings("resource")
    public String saveCFStuff() {
        try {
            FUserDetail loguser = ((FUserDetail) getLoginUser());
            if ("1".equals(stuffInfo.getIszhi())) {
                stuffInfo.setStuffid(getUUID());

                stuffInfo.setUploadtime(new Date());
                stuffInfo.setUploadusercode(loguser.getUsercode());
                stuffInfo.setFilename("纸质文件");
                stuffInfo.setIsuse("0");
                VNodeInstDetail o = flowManager
                        .getVNodeInstDetailbyNode(stuffInfo.getNodeInstId());
                if (o != null) {
                    stuffInfo.setNodename(o.getNodeName());
                } else {
                    stuffInfo.setNodename("行政处罚登记");
                }
                optProcInfoManager.saveStuffInfo(stuffInfo);
            }
            if (stuffInfo.getIszhi() == null && stuffFile == null) {
                optProcInfoManager.deleteStuffByiszhi(stuffInfo.getSortId());
            } else if (stuffFile != null) {
                byte[] bbuf = null;

                FileInputStream fis = new FileInputStream(stuffFile);
                if (fis != null) {
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                }
                stuffInfo.setStuffcontent(bbuf);
                stuffInfo.setStuffid(getUUID());
                stuffInfo.setFilename(stuffFileFileName);
                stuffInfo.setUploadtime(new Date());
                stuffInfo.setUploadusercode(loguser.getUsercode());
                stuffInfo.setIsuse("0");
                VNodeInstDetail o = flowManager
                        .getVNodeInstDetailbyNode(stuffInfo.getNodeInstId());
                if (o != null) {
                    stuffInfo.setNodename(o.getNodeName());
                } else {
                    stuffInfo.setNodename("行政处罚登记");
                }
                optProcInfoManager.saveStuffInfo(stuffInfo);
            }
            return "gotoCFsqcl";

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    private String isAllsc; // 是否全部上传

    public String getIsAllsc() {
        return isAllsc;
    }

    public void setIsAllsc(String isAllsc) {
        this.isAllsc = isAllsc;
    }

    public String gotosqcl() {
        String outItemId = request.getParameter("outItemId");
        suppowerstuffinfos = new ArrayList<>();
        if(StringUtils.isBlank(outItemId)){
             List<Suppowerstuffinfo> suppowerList = suppowerstuffinfoManager
                    .getinfosByGroupId(stuffInfo.getGroupid());
             for(Suppowerstuffinfo suppower:suppowerList){
                 YwFiles ywFiles = new YwFiles();
                 ywFiles.setGroupId(suppower.getGroupId());
                 ywFiles.setIsElectron(suppower.getIsElectron());
                 ywFiles.setIsNeed(suppower.getIsNeed());
                 ywFiles.setSortId(suppower.getSortId() + "");
                 ywFiles.setStuffName(suppower.getStuffName());
                 ywFiles.setStuffType(suppower.getStuffType());
                 suppowerstuffinfos.add(ywFiles);
             }
        }else{//港口深水岸线使用审批 
           List<VRegNoFileName> vRegNoFileNames = vRegNoFileNameManager.getinfosByOutItemId(outItemId);
           int i = 0;
           if(vRegNoFileNames.size() != 0){
               for (int j = 0; j < vRegNoFileNames.size(); j++) {
                   YwFiles file = new YwFiles();
                   file.copyNotNullProperty(vRegNoFileNames.get(i));
                   suppowerstuffinfos.add(file);
                   i++;
               }
           }
        }
        VOpt = optProcInfoManager.getStuffsByDjId(stuffInfo.getDjId());
        /* optStuffs = optProcInfoManager.listStuffsByDjId(stuffInfo.getDjId()); */
        //港口深水岸线使用审批 
        if(suppowerstuffinfos == null){
            suppowerstuffinfos = new ArrayList<YwFiles>();
        }
        isAllsc = isAllSC(suppowerstuffinfos, VOpt);
        return "sqclList";
    }

    // 判断是否全部传完了 1：传完了 0：没有传完
    public String isAllSC(List<YwFiles> suppowerstuffinfos,
            List<VOptStuffInfo> VOpt) {
        String ast = "1";
        Boolean[] bool = new Boolean[suppowerstuffinfos.size()];

        int i = 0;
        for (YwFiles a : suppowerstuffinfos) {
            if ("1".equals(a.getIsNeed())) {
                bool[i] = false;
                if (VOpt == null) {
                    ast = "0";
                    return ast;
                }
                for (VOptStuffInfo st : VOpt) {
                    if (a.getSortId().equals(st.getSortId()))
                        bool[i] = true;
                }
                i++;
            } else {
                bool[i] = true;
                i++;
            }
        }
        Boolean b = true;
        for (int j = 0; j < bool.length; j++) {
            b = b && bool[j];
        }
        if (!b)
            ast = "0";
        return ast;
    }

    public String deleteStuffInfo() {
        stuffInfo = optProcInfoManager.getStuffById(stuffInfo.getStuffid());
        optProcInfoManager.deleteStuffInfo(stuffInfo);

        return "gotosqcl";

    }

    public String deleteCFStuffInfo() {
        stuffInfo = optProcInfoManager.getStuffById(stuffInfo.getStuffid());
        optProcInfoManager.deleteStuffInfo(stuffInfo);
        return "gotoCFsqcl";
    }

    /**
     * 发文步骤根据DJID和ArchiveType 删除当前文书
     * 
     * @return
     */
    public String deleteStuffByArchiveType() {
        List<OptStuffInfo> osf = optProcInfoManager.listStuffsByArchiveType(
                object.getDjId(), object.getArchiveType());
        if (osf != null && osf.size() > 0) {
            optProcInfoManager.deleteStuffInfo(osf.get(0));
            OptProcInfo procInfo = optProcInfoManager
                    .getObjectByNodeInstId(object.getNodeInstId());
            procInfo.setArchiveType("");
            procInfo.setRecordId("");
            optProcInfoManager.saveObject(procInfo);
        }
        return null;
    }

    public String gotoCFsqcl() {
        try {
            suppowerstuffinfos = ywFilesManager
                    .getinfosByGroupId(suppowerstuffinfo.getGroupId());
            VOpt = optProcInfoManager.getStuffsByDjId(stuffInfo.getDjId());
            isAllsc = isAllSC(suppowerstuffinfos, VOpt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "cFsqclList";
    }

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    protected HttpServletResponse response;

    /**
     * Description: 从FTP服务器下载文件
     * 
     * @Version
     * @param url
     *            FTP服务器hostname
     * @param port
     *            FTP服务器端口
     * @param username
     *            FTP登录账号
     * @param password
     *            FTP登录密码
     * @param remotePath
     *            FTP服务器上的相对路径
     * @param fileName
     *            要下载的文件名
     * @param localPath
     *            下载后保存到本地的路径 fileUrl 文件保存路径
     * @return
     */
    public void downFile(String url, int port, String username,
            String password, String fileName, String fileUrl,
            HttpServletResponse response) {
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(url, port);
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
            }
            ftp.changeWorkingDirectory(fileUrl);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    InputStream in = ftp.retrieveFileStream(ff.getName());
                    response.setContentLength((int) ff.getSize());
                    response.setContentType("application/octet-stream; charset=GBK");
                    response.setHeader("Content-Disposition",
                            "attachment;filename="
                                    .concat(new String(ff.getName().getBytes(
                                            "GB2312"), "ISO-8859-1")));
                    ServletOutputStream sout = response.getOutputStream();
                    byte[] buffer = new byte[10000];
                    int copySize;
                    while ((copySize = in.read(buffer)) > 0) {
                        sout.write(buffer, 0, copySize);
                        sout.flush();
                    }
                    sout.close();
                    in.close();
                }
            }
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
    }

    public String downStuffInfo() throws IOException {
        stuffInfo = optProcInfoManager.getStuffById(request
                .getParameter("stuffid"));
        String netId = request.getParameter("netid");
        OptStuffInfo stuffInfo1 = optProcInfoManager.getStuffById(request
                .getParameter("stuffInfo.stuffid"));
        if (stuffInfo == null) {
            stuffInfo = stuffInfo1;
        }
        String fileUrl = "";
        String fn = stuffInfo.getFilename();
        try {
            if (stuffInfo.getStuffcontent() == null) {
                if (!StringUtils.isBlank(stuffInfo.getFileUrl())) {
                    if (stuffInfo != null) {
                        filename = stuffInfo.getFilename();
                        if(StringUtils.isNotBlank(netId)){
                            fileUrl = "/" + netId + "/" + stuffInfo.getGroupid() + stuffInfo.getSortId() + "/";
                        }else{
                            fileUrl = "/" + stuffInfo.getGroupid() + stuffInfo.getSortId() + "/";
                        }
                        
                    }
                    // downFile("192.168.132.41", 21, "centit",
                    // "happy@19871023",filename, fileUrl,response);
                    downFile("193.168.1.27", 21, "centit", "000000", filename,
                            fileUrl, response);
                } else {
                    this.postAlertMessage("附件为空或为纸质文件", response);
                    return null;
                }
            }
            if (stuffInfo.getStuffcontent() != null) {
                inputStream = new ByteArrayInputStream(
                        stuffInfo.getStuffcontent());
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }
        this.setFilename(new String(fn.getBytes("GBK"), "ISO8859-1"));
        return "download";

    }

    /**
     * -------------------------------------------------------------------------
     * 材料分组
     */

    private List<Suppowerstuffgroup> stuffgroups;
    private Suppowerstuffgroup suppowerstuffgroup;
    private YwFiles suppowerstuffinfo;

    public YwFiles getSuppowerstuffinfo() {
        return suppowerstuffinfo;
    }

    public void setSuppowerstuffinfo(YwFiles suppowerstuffinfo) {
        this.suppowerstuffinfo = suppowerstuffinfo;
    }

    @SuppressWarnings("unchecked")
    public String stuffdivide() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        stuffgroups = suppowerstuffgroupManager
                .listObjects(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "stuffdivide";
    }

    public String selectstuffGroup() {
        stuffgroups = suppowerstuffgroupManager.listObjects();
        totalRows = stuffgroups.size();
        return "selectstuffGroup";
    }

    public String groupbuilt() {
        if (suppowerstuffgroup != null) {
            suppowerstuffgroup = suppowerstuffgroupManager
                    .getObjectById(suppowerstuffgroup.getGroupId());
        } else {
            suppowerstuffgroup = new Suppowerstuffgroup();
            suppowerstuffgroup.setGroupId(suppowerstuffgroupManager
                    .getNextGroupCode());
        }
        return "groupbuilt";
    }

    public String groupedit() {
        suppowerstuffgroup = suppowerstuffgroupManager
                .getObjectById(suppowerstuffgroup.getGroupId());
        return "groupbuilt";
    }

    public String saveStuffGroup() {
        Suppowerstuffgroup dbobject = suppowerstuffgroupManager
                .getObjectById(suppowerstuffgroup.getGroupId());
        if (dbobject != null) {
            dbobject.copyNotNullProperty(suppowerstuffgroup);
            suppowerstuffgroup = dbobject;
        }
        suppowerstuffgroupManager.saveObject(suppowerstuffgroup);
        return "groupSuccess";
    }

    public String viewGroupInfo() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        List<Suppowerstuffinfo> suppowerinfoList = suppowerstuffinfoManager.listObjects(filterMap,pageDesc);
        suppowerstuffinfos = new ArrayList<>();
        for(Suppowerstuffinfo suppowerinfo : suppowerinfoList){
            YwFiles ywfilesTmp = new YwFiles();
            ywfilesTmp.setGroupId(suppowerinfo.getGroupId());
            ywfilesTmp.setIsElectron(suppowerinfo.getIsElectron());
            ywfilesTmp.setIsNeed(suppowerinfo.getIsNeed());
            ywfilesTmp.setSortId(suppowerinfo.getSortId() + "");
            ywfilesTmp.setStuffName(suppowerinfo.getStuffName());
            ywfilesTmp.setStuffType(suppowerinfo.getStuffType());
            suppowerstuffinfos.add(ywfilesTmp);
        }
        /*suppowerstuffinfos = ywFilesManager.listObjects(filterMap,
                pageDesc);*/
        totalRows = pageDesc.getTotalRows();
        return "viewGroupInfo";
    }

    public String stuffinfobuilt() {
        if (suppowerstuffinfo != null)
            suppowerstuffinfo = ywFilesManager
                    .getObjectById(suppowerstuffinfo.getSortId());
        else {
            suppowerstuffinfo = new YwFiles();
            suppowerstuffinfo.setSortId(suppowerstuffinfoManager.getNextKey());
            suppowerstuffinfo.setGroupId(request.getParameter("s_groupId"));
        }
        return "stuffinfobuilt";
    }

    public String saveStuffinfo() {
        try {
            ywFilesManager.saveObject(suppowerstuffinfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "saveStuffinfo";
    }

    public List<Suppowerstuffgroup> getStuffgroups() {
        return stuffgroups;
    }

    public void setStuffgroups(List<Suppowerstuffgroup> stuffgroups) {
        this.stuffgroups = stuffgroups;
    }

    /**
     * -------------------------------------------------------------------------
     * 获取附件列表
     */
    /*
     * List<OptStuffInfo> optStuffs;
     * 
     * public List<OptStuffInfo> getOptStuffs() { return optStuffs; }
     * 
     * public void setOptStuffs(List<OptStuffInfo> optStuffs) { this.optStuffs =
     * optStuffs; }
     */

    public String listStuffs() {
        // TODO 展示附件页面 ，参见行权系统中的页面
        String djid = object.getDjId();
        VOpt = optProcInfoManager.getStuffsByDjId(djid);
        // optStuffs = optProcInfoManager.listStuffsByDjId(djid);
        // return "listStuffs";
        return "listStuffs_new";
    }

    public static OptHtmlFrameInfo getStuffListFrame(String djId) {
        OptHtmlFrameInfo stuffsFrameInfo = new OptHtmlFrameInfo();
        stuffsFrameInfo.setFrameId("stuffsFrame");
        stuffsFrameInfo
                .setFrameSrc("/powerruntime/generalOperator!listStuffs.do?djId="
                        + djId);
        stuffsFrameInfo.setFrameHeight("300px");
        // frameMap.put("stuffs", stuffsFrameInfo);
        // frameMap.put("proc", procFrameInfo);
        return stuffsFrameInfo;
    }

    /************************************************************
     * 此项为办件查看：查看附件，只保留下载查看功能，不支持删除。
     * 
     * @param djId
     * @return
     */
    public static OptHtmlFrameInfo getStuffsViewFrame(String djId) {
        OptHtmlFrameInfo stuffsFrameInfo = new OptHtmlFrameInfo();
        stuffsFrameInfo.setFrameId("viewStuffsFrame");
        stuffsFrameInfo
                .setFrameSrc("/powerruntime/generalOperator!viewListStuffs.do?djId="
                        + djId);
        stuffsFrameInfo.setFrameHeight("300px");
        return stuffsFrameInfo;
    }

    /************************************************************
     * 此项为办件查看：查看附件，只保留下载查看功能，不支持删除。
     * 
     * @param djId
     * @return
     */
    public String viewListStuffs() {
        // TODO 展示附件页面 ，参见行权系统中的页面
        VOpt = optProcInfoManager.getStuffsByDjId(object.getDjId());
        return "viewListStuffs";
    }

    /**
     * 添加设置关注
     * 
     * @return
     * 
     */
    public String saveAtt() {
        try {
            if (!StringUtils.isBlank(attUserCodes)) {
                FUserDetail userDetail = ((FUserDetail) getLoginUser());

                // 获取页面attUserCodes
                String[] attUserCode = attUserCodes.split(",");
                // 拆分userCode
                if (attUserCode.length > 0) {
                    for (int i = 0; i < attUserCode.length; i++) {
                        optProcAttentionManager
                                .deleteObjectById(new OptProcAttentionId(object
                                        .getDjId(), attUserCode[i]));
                        OptProcAttention optProcAttention = new OptProcAttention();
                        optProcAttention.setUserCode(attUserCode[i]);
                        optProcAttention.setDjId(object.getDjId());
                        optProcAttention
                                .setAttSetUser(userDetail.getUsercode());
                        optProcAttention.setAttType(object
                                .getOptProcAttention().getAttType());
                        optProcAttention.setAttSetTime(new Date(System
                                .currentTimeMillis()));
                        optProcAttention.setNodeInstId(object.getNodeInstId());
                        optProcAttention.setIsAtt("0");// 0，未提出（关注意见状态），1 已经提出
                        optProcInfoManager.saveAtt(optProcAttention);// 保存关注
                    }
                }
            }
            savedMessage();
            return LIST;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            saveError(e.getMessage());
            return ERROR;
        }
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

    public void saveTeamRolepeople() {
        flowEngine.deleteFlowWorkTeam(super.getFlowInstId(), teamRoleCode);
        if (!StringUtils.isBlank(teamUserCodes)) {
            String[] teamUserCode = teamUserCodes.split(",");
            if (teamUserCode.length > 0) {
                for (String userCode : teamUserCode) {
                    flowEngine.assignFlowWorkTeam(super.getFlowInstId(),
                            teamRoleCode, userCode);
                }
            }
        }
    }

    public List<YwFiles> getSuppowerstuffinfos() {
        return suppowerstuffinfos;
    }

    public void setSuppowerstuffinfos(List<YwFiles> suppowerstuffinfos) {
        this.suppowerstuffinfos = suppowerstuffinfos;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public String getAttUserNames() {
        return attUserNames;
    }

    public void setAttUserNames(String attUserNames) {
        this.attUserNames = attUserNames;
    }

    public void setOptBaseInfoManager(OptBaseInfoManager optBaseInfoManager) {
        this.optBaseInfoManager = optBaseInfoManager;
    }

    public void setSuppowerstuffgroupManager(
            SuppowerstuffgroupManager suppowerstuffgroupManager) {
        this.suppowerstuffgroupManager = suppowerstuffgroupManager;
    }

    public Suppowerstuffgroup getSuppowerstuffgroup() {
        return suppowerstuffgroup;
    }

    public void setSuppowerstuffgroup(Suppowerstuffgroup suppowerstuffgroup) {
        this.suppowerstuffgroup = suppowerstuffgroup;
    }

    public String getOptBaseInfoJson() {
        return optBaseInfoJson;
    }

    public void setOptBaseInfoJson(String optBaseInfoJson) {
        this.optBaseInfoJson = optBaseInfoJson;
    }

    public HttpServletResponse getResponse() {
        return response;
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
        String alertCoding = "utf-8";
        ServletOutputStream sos;
        String str = "<script language=\"JavaScript\""
                + " type=\"text/JavaScript\" " + alertCoding + "\">"
                + "javascript:alert('" + msg + "');" + " </script>";
        // response.setContentType("text/html; charset=" + alertCoding);
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

    @Override
    public void setServletResponse(HttpServletResponse response) {

        this.response = response;
    }

    /**
     * 选择流程
     * 
     * @return
     */
    public String ioSelectFlow() {
        try {
            fwList = flowDefine.getFlowsByOptId("IO_DOC");
            // swList = flowDefine.getFlowsByOptId("INCOME_DOC");

            savedMessage();
            return "ioSelectFlow";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            saveError(e.getMessage());
            return ERROR;
        }
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    public List<FlowDescribe> getFwList() {
        return fwList;
    }

    public void setFwList(List<FlowDescribe> fwList) {
        this.fwList = fwList;
    }

    public List<FlowDescribe> getSwList() {
        return swList;
    }

    public void setSwList(List<FlowDescribe> swList) {
        this.swList = swList;
    }

    /*
     * 得到当前年份前后5年的时间段
     */
    public List<Map<String, String>> getFromArray() {
        List<Map<String, String>> fromArray = new ArrayList<Map<String, String>>();
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        for (int i = y - 5; i < y + 5; i++) {
            HashMap<String, String> cache = new HashMap<String, String>();
            cache.put("id", String.valueOf(i));
            cache.put("name", String.valueOf(i));
            fromArray.add(cache);
        }
        return fromArray;
    }

    public List<Map<String, String>> getYear() {
        return year;
    }

    public void setYear(List<Map<String, String>> year) {
        this.year = year;
    }

    public DispatchDocManager getDispatchDocManager() {
        return dispatchDocManager;
    }

    public void setDispatchDocManager(DispatchDocManager dispatchDocManager) {
        this.dispatchDocManager = dispatchDocManager;
    }

    public void setOptApplyManager(OptApplyManager optApplyManager) {
        this.optApplyManager = optApplyManager;
    }

    public String deleteStuffInfoByAjax() {
        String djId = request.getParameter("djId");
        String sortId = request.getParameter("sortId");
        String stuffid = request.getParameter("stuffid");
        String callback = request.getParameter("callback");
        HttpServletResponse response = (HttpServletResponse) ActionContext
                .getContext().get(ServletActionContext.HTTP_RESPONSE);
        String str_utf = callback;
        OptStuffInfo optStuffInfo = null;
        if (StringUtils.isBlank(sortId) && StringUtils.isNotBlank(stuffid)) {
            optStuffInfo = optProcInfoManager.getStuffById(stuffid);
        } else if (StringUtils.isNotBlank(sortId)
                && StringUtils.isBlank(stuffid)) {
            optStuffInfo = optProcInfoManager.getStuffByIDs(djId, sortId);
        }
        try {
            optProcInfoManager.deleteStuffInfo(optStuffInfo);
            if (StringUtils.isBlank(request.getParameter("sortId"))) {
                sortId = optStuffInfo.getSortId();
                List<OptStuffInfo> stuffInfos = optProcInfoManager
                        .getStuffInfoListBySortID(djId, sortId);
                if (null == stuffInfos) {
                    str_utf = str_utf + "({result:'OK',suffid:''})";
                } else {
                    String suffids = "";
                    String suffnames = "";
                    for (OptStuffInfo object : stuffInfos) {
                        if (StringUtils.isBlank(suffids)) {
                            suffids = object.getStuffid();
                            suffnames = object.getFilename();
                        } else {
                            suffids = suffids + "," + object.getStuffid();
                            suffnames = suffnames + "," + object.getFilename();
                        }
                    }
                    str_utf = str_utf + "({result:'OK',suffid:'" + suffids
                            + "',suffname:'" + suffnames + "'})";
                }
            } else {
                str_utf = str_utf + "({result:'OK'})";
            }
        } catch (Exception e) {
            str_utf = str_utf + "({result:'FALSE'})";
        }
        try {
            response.getWriter().print(str_utf);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("resource")
    public String AddStuffinfoByAjax() throws IOException {
        FUserDetail loguser = ((FUserDetail) getLoginUser());
        OptStuffInfo optStuffInfo = new OptStuffInfo();
        String djId = request.getParameter("djId");
        optStuffInfo.setDjId(djId);
        String iszhi = request.getParameter("iszhi");
        optStuffInfo.setIszhi(iszhi);
        String sortId = request.getParameter("sortId");
        optStuffInfo.setSortId(sortId);
        String nodeInstId = request.getParameter("nodeInstId");
        String groupid = request.getParameter("groupid");
        optStuffInfo.setGroupid(groupid);
        String stuffname = "";
        try {
            stuffname = java.net.URLDecoder.decode(
                    request.getParameter("stuffname"), "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        optStuffInfo.setStuffname(stuffname);
        optStuffInfo.setStuffid(getUUID());
        optStuffInfo.setNodeInstId(Long.parseLong(nodeInstId));
        optStuffInfo.setUploadtime(new Date(System.currentTimeMillis()));
        optStuffInfo.setUploadusercode(loguser.getUsercode());
        VNodeInstDetail o = flowManager.getVNodeInstDetailbyNode(optStuffInfo
                .getNodeInstId());
        if (o != null) {
            optStuffInfo.setNodename(o.getNodeName());
        } else {
            if (djId.indexOf("XK") > -1) {
                optStuffInfo.setNodename("办件登记");
            } else if (djId.indexOf("CF") > -1) {
                optStuffInfo.setNodename("行政处罚登记");
            }
        }
        String str_utf = "";
        HttpServletResponse response = (HttpServletResponse) ActionContext
                .getContext().get(ServletActionContext.HTTP_RESPONSE);
        if (StringUtils.isNotBlank(iszhi)) {
            if (djId.indexOf("XK") > -1) {
                optStuffInfo.setNodename("办件登记");
            } else if (djId.indexOf("CF") > -1) {
                optStuffInfo.setNodename("行政处罚登记");
            }
            String callback = request.getParameter("callback");

            str_utf = callback;
            try {
                optStuffInfo.setFilename("纸质材料");
                optProcInfoManager.saveStuffInfo(optStuffInfo);
                str_utf = str_utf + "({result:'OK',suffid:'"
                        + optStuffInfo.getStuffid() + "'})";
            } catch (Exception e) {
                str_utf = str_utf + "({result:'FALSE'})";
            }
        } else {
            String filename = request.getParameter("filename");
            if (StringUtils.isNotBlank(filename)) {
                try {
                    filename = java.net.URLDecoder.decode(filename, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                optStuffInfo.setFilename(filename);
            }
            try {
                if (stuffFile != null) {
                    byte[] stuffcontent = null;
                    FileInputStream fis = new FileInputStream(stuffFile);
                    if (fis != null) {
                        int len = fis.available();
                        stuffcontent = new byte[len];
                        fis.read(stuffcontent);
                    }
                    optStuffInfo.setStuffcontent(stuffcontent);
                    optProcInfoManager.saveStuffInfo(optStuffInfo);
                    str_utf = str_utf + "{result:'OK',suffid:'"
                            + optStuffInfo.getStuffid() + "'}";
                }
            } catch (Exception e) {
                str_utf = str_utf + "{result:'FALSE'}";
            }
        }
        try {
            response.getWriter().print(str_utf);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public List<VOptStuffInfo> getVOpt() {
        return VOpt;
    }

    public void setVOpt(List<VOptStuffInfo> vOpt) {
        VOpt = vOpt;
    }

    public String saveYslStuff() {
        try {
            FUserDetail loguser = ((FUserDetail) getLoginUser());
            // OptStuffInfoNet
            // o1=optStuffInfoNetManager.getObjectById(optStuffInfoNet.getStuffid());
            if ("1".equals(optStuffInfoNet.getIszhi())) {

                optStuffInfoNetManager.deleteOSIN(optStuffInfoNet.getNetId(),
                        optStuffInfoNet.getSortId());

                optStuffInfoNet.setStuffid(getUUID());

                optStuffInfoNet.setUploadtime(new Date());
                optStuffInfoNet.setUploadusercode(loguser.getUsercode());
                optStuffInfoNet.setFilename("纸质文件");

                VNodeInstDetail o = flowManager
                        .getVNodeInstDetailbyNode(optStuffInfoNet
                                .getNodeInstId());
                if (o != null) {
                    optStuffInfoNet.setNodename(o.getNodeName());
                } else {
                    optStuffInfoNet.setNodename("办件登记");
                }

                optStuffInfoNetManager.saveObject(optStuffInfoNet);
                this.yslgroupid = optStuffInfoNet.getGroupid();
                this.yslnetid = optStuffInfoNet.getNetId();
            }
            if (optStuffInfoNet.getIszhi() == null && stuffFile == null) {
                this.yslgroupid = optStuffInfoNet.getGroupid();
                this.yslnetid = optStuffInfoNet.getNetId();
                // 删除纸质项
                // OptStuffInfoNet
                // optStuffInfonet1=optStuffInfoNetManager.getObjectById(optStuffInfoNet.getNetId());

                optStuffInfoNetManager.deleteOSIN(optStuffInfoNet.getNetId(),
                        optStuffInfoNet.getSortId());

                // optProcInfoManager.deleteStuffByiszhi(stuffInfo.getSortId());
            } else if (stuffFile != null) {
                byte[] bbuf = null;

                FileInputStream fis = new FileInputStream(stuffFile);
                if (fis != null) {
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                }
                fis.close();

                optStuffInfoNet.setStuffcontent(bbuf);
                optStuffInfoNet.setStuffid(getUUID());
                optStuffInfoNet.setFilename(stuffFileFileName);
                optStuffInfoNet.setUploadtime(new Date());
                optStuffInfoNet.setUploadusercode(loguser.getUsercode());

                VNodeInstDetail o = flowManager
                        .getVNodeInstDetailbyNode(optStuffInfoNet
                                .getNodeInstId());
                if (o != null) {
                    optStuffInfoNet.setNodename(o.getNodeName());
                } else {
                    optStuffInfoNet.setNodename("办件登记");
                }
                optStuffInfoNetManager.saveObject(optStuffInfoNet);
                this.yslgroupid = optStuffInfoNet.getGroupid();
                this.yslnetid = optStuffInfoNet.getNetId();
            }
            return "gotoyslsqcl";

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String gotoyslsqcl() {
        if (optStuffInfoNet != null) {
            suppowerstuffinfos = ywFilesManager
                    .getinfosByGroupId(optStuffInfoNet.getGroupid());
            optStuffInfoNets = optStuffInfoNetManager
                    .getZwfjStuffInfo(optStuffInfoNet.getNetId());
        } else {
            suppowerstuffinfos = ywFilesManager
                    .getinfosByGroupId(yslgroupid);
            optStuffInfoNets = optStuffInfoNetManager
                    .getZwfjStuffInfo(yslnetid);

        }
        isAllsc = isAllSCysl(suppowerstuffinfos, optStuffInfoNets);
        return "yslsqclList";
    }

    // 判断是否全部传完了 1：传完了 0：没有传完
    public String isAllSCysl(List<YwFiles> suppowerstuffinfos,
            List<OptStuffInfoNet> optStuffNets) {
        String ast = "1";
        Boolean[] bool = new Boolean[suppowerstuffinfos.size()];
        int i = 0;
        for (YwFiles a : suppowerstuffinfos) {
            if ("1".equals(a.getIsNeed())) {
                bool[i] = false;
                if (optStuffNets == null) {
                    ast = "0";
                    return ast;
                }
                for (OptStuffInfoNet st : optStuffNets) {
                    if (a.getSortId().equals(st.getSortId()))
                        bool[i] = true;
                }
                i++;
            } else {
                bool[i] = true;
                i++;
            }
        }
        Boolean b = true;
        for (int j = 0; j < bool.length; j++) {
            b = b && bool[j];
        }
        if (!b)
            ast = "0";
        return ast;
    }

    public String deleteYslStuffInfo() {
        optStuffInfoNet = optStuffInfoNetManager.getObjectById(optStuffInfoNet
                .getStuffid());
        this.yslgroupid = optStuffInfoNet.getGroupid();
        this.yslnetid = optStuffInfoNet.getNetId();
        optStuffInfoNetManager.deleteObject(optStuffInfoNet);

        return "gotoyslsqcl";

    }

    private String yslnetid;
    private String yslgroupid;

    public String getYslnetid() {
        return yslnetid;
    }

    public void setYslnetid(String yslnetid) {
        this.yslnetid = yslnetid;
    }

    public String getYslgroupid() {
        return yslgroupid;
    }

    public void setYslgroupid(String yslgroupid) {
        this.yslgroupid = yslgroupid;
    }

    private OptStuffInfoNet optStuffInfoNet;
    private List<OptStuffInfoNet> optStuffInfoNets;

    private OptStuffInfoNetManager optStuffInfoNetManager;

    public List<OptStuffInfoNet> getOptStuffInfoNets() {
        return optStuffInfoNets;
    }

    public void setOptStuffInfoNets(List<OptStuffInfoNet> optStuffInfoNets) {
        this.optStuffInfoNets = optStuffInfoNets;
    }

    public OptStuffInfoNet getOptStuffInfoNet() {
        return optStuffInfoNet;
    }

    public void setOptStuffInfoNet(OptStuffInfoNet optStuffInfoNet) {
        this.optStuffInfoNet = optStuffInfoNet;
    }

    public OptStuffInfoNetManager getOptStuffInfoNetManager() {
        return optStuffInfoNetManager;
    }

    public void setOptStuffInfoNetManager(
            OptStuffInfoNetManager optStuffInfoNetManager) {
        this.optStuffInfoNetManager = optStuffInfoNetManager;
    }

    public YwFilesManager getYwFilesManager() {
        return ywFilesManager;
    }

    public void setYwFilesManager(YwFilesManager ywFilesManager) {
        this.ywFilesManager = ywFilesManager;
    }
    
}
