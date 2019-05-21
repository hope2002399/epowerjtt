package com.centit.punish.action;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.punish.po.OptNewlyIdea;
import com.centit.punish.po.Vporegisterbasic;
import com.centit.punish.service.OptNewlyIdeaManager;
import com.centit.punish.service.VporegisterbasicManager;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

/**
 * TODO Class description should be added
 * 
 * @author ljy
 * @create 2013-1-9
 * @version
 */
public class PunishCommonBizAction<T> extends PowerRuntimeEntityAction<T>
        implements ServletResponseAware {
    private static final long serialVersionUID = 4063405489456258953L;

    protected SysUserManager sysUserManager;

    protected SysUnitManager sysUnitManager;

    private String ideaCatalog;// 节点对应审批意见字典代码

    private String templateId;// 节点对应模版编号

    private String templateType;// 对应模版分类

    private String stuffGroupId;// 材料分组编号

    private String userFilterExp;// 人员过滤表达式

    protected String nodeName;// 当前节点名称

    protected String nextOperaters = "";

    protected HttpServletResponse response;

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    protected String actionName;// 对应form的actionName
    protected String submitOptURI;// 对应form的提交方法名
    protected String saveOptURI;// 对应form的保存方法名

    protected VporegisterbasicManager vporegisterbasicManager;
    protected OptNewlyIdeaManager optNewlyIdeaManager;

    public void initalDocJson(String title, String punishobjectid) {
        Vporegisterbasic vporegisterbasic = vporegisterbasicManager
                .getObjectById(punishobjectid);
        if (vporegisterbasic == null) {
            vporegisterbasic = new Vporegisterbasic();
            vporegisterbasic.setPunishobjectid(punishobjectid);
        }

        vporegisterbasic.setPoorigindate(StringUtils.isBlank(vporegisterbasic
                .getPoorigindate()) ? "" : vporegisterbasic.getPoorigindate()
                .substring(0, 16));
        vporegisterbasic.setJbroptiontimeDczj(StringUtils
                .isBlank(vporegisterbasic.getJbroptiontimeDczj()) ? ""
                : vporegisterbasic.getJbroptiontimeDczj().substring(0, 16));
        vporegisterbasic.setKsoptiontimeDczj(StringUtils
                .isBlank(vporegisterbasic.getKsoptiontimeDczj()) ? ""
                : vporegisterbasic.getKsoptiontimeDczj().substring(0, 16));
        vporegisterbasic.setFzroptiontimeDczj(StringUtils
                .isBlank(vporegisterbasic.getFzroptiontimeDczj()) ? ""
                : vporegisterbasic.getFzroptiontimeDczj().substring(0, 16));
        vporegisterbasic.setKsoptiontimeJa(StringUtils.isBlank(vporegisterbasic
                .getKsoptiontimeJa()) ? "" : vporegisterbasic
                .getKsoptiontimeJa().substring(0, 16));
        vporegisterbasic.setJbroptiontimeJa(StringUtils
                .isBlank(vporegisterbasic.getJbroptiontimeJa()) ? ""
                : vporegisterbasic.getJbroptiontimeJa().substring(0, 16));
        vporegisterbasic.setFzroptiontimeJa(StringUtils
                .isBlank(vporegisterbasic.getFzroptiontimeJa()) ? ""
                : vporegisterbasic.getFzroptiontimeJa().substring(0, 16));
        vporegisterbasic.setPooccurdate(StringUtils.isBlank(vporegisterbasic
                .getPooccurdate()) ? "" : vporegisterbasic.getPooccurdate()
                .substring(0, 16));
        // vporegisterbasic.setTitle(title);
        vporegisterbasic.setPunishobjectbrief(CodeRepositoryUtil.getValue(
                "anyou", vporegisterbasic.getPunishobjectbrief()));
        this.initCommonBizJSON(vporegisterbasic);
    }

    public VporegisterbasicManager getVporegisterbasicManager() {
        return vporegisterbasicManager;
    }

    public void setVporegisterbasicManager(
            VporegisterbasicManager vporegisterbasicManager) {
        this.vporegisterbasicManager = vporegisterbasicManager;
    }

    /**
     * 整合处罚过程阶段意见
     * 
     * @return
     */
    public String viewPunishOptInfo() {
        String flowPhase = curFlowPhase;
        if (StringUtils.isNotBlank(flowPhase)) {
            if (flowPhase.lastIndexOf("_") != -1) {
                flowPhase = flowPhase.substring(0, flowPhase.lastIndexOf("_"));
            }
            if ("ja".equalsIgnoreCase(flowPhase)) {
                NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId);
                OptIdeaInfo OptIdeaInfo = optProcInfoManager
                        .getOptIdeaInfoByNodeInstId(nit.getPrevNodeInstId());
                if (OptIdeaInfo != null) {
                    flowPhase = OptIdeaInfo.getFlowPhase();
                    if (flowPhase.lastIndexOf("_") != -1) {
                        flowPhase = flowPhase.substring(0,
                                flowPhase.lastIndexOf("_"));
                    }
                }
            }
            String punishobjectid = request.getParameter("punishobjectid");
            List<OptIdeaInfo> opt = optProcInfoManager
                    .listIdeaLogsByDjIdAndFlowPhase(punishobjectid, flowPhase);
            processNote = "";
            if (opt != null)
                for (OptIdeaInfo proc : opt) {
                    String transdate = "";
                    if (proc.getTransdate() != null) {
                        transdate = String.valueOf(proc.getTransdate());
                        transdate = transdate.substring(0, 19);
                    }

                    // processNote +="【"
                    // +CodeRepositoryUtil.getValue("usercode",
                    // proc.getUsercode()) +":"+ proc.getNodename() +
                    // " "+proc.getTransdate()+" 】" + proc.getTransidea() +
                    // "\r\n";
                    processNote += "【"
                            + proc.getNodename()
                            + ":"
                            + (StringUtils.isBlank(proc.getTranscontent()) ? ""
                                    : proc.getTranscontent())
                            + "】 签名："
                            + CodeRepositoryUtil.getValue("usercode",
                                    proc.getUsercode()) + " 日期：" + transdate
                            + "\r\n";
                }
        }
        return "viewPunishOptInfo";
    }

    /**
     * 如果使用初始化，则方法的三个参数缺一不可！
     * 
     * @param actionname
     *            对应form的actionName
     * @param submitopturi
     *            对应form的提交方法名
     * @param saveopturi
     *            对应form的保存方法名
     */
    public void initalGenneralOpt(String actionname, String submitopturi,
            String saveopturi) {
        this.actionName = actionname;
        this.submitOptURI = submitopturi;
        this.saveOptURI = saveopturi;
    }

    /**
     * 用于加载处罚通用配置
     * 
     * @return
     */
    public String generalOpt() {
        try {
            moduleParam = generalModuleParamManager.getObjectById(moduleCode);// "XKSL"
            extractFlowOptParam();
            super.initalOptProcInfo();

            super.initAttUsersConfig();
            super.initTeamUsersConfig();
            super.initTemplateConfig();
            super.initRiskConfig();
            /**
             * 配置当前步骤名称
             */
            NodeInstance nodeInst = flowEngine.getNodeInstById(curNodeInstId);
            FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nodeInst
                    .getNodeId());
            nodeName = nodeInfo.getNodeName();
            // this.initCommonBizJSON(object);
            return "commonFrame";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e, e.getCause());
            request.setAttribute("error", "通用配置功能出错，请检查各配置项是否准确。");
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
            if (optProcInfo == null) {
                optProcInfo = new OptProcInfo();
            }
            optProcInfo.setTransdate(new Date(System.currentTimeMillis()));
            optProcInfo.setUsercode(loginInfo.getUsercode());
            optProcInfo.setUnitcode(loginInfo.getPrimaryUnit());
            if (StringUtils.isBlank(optProcInfo.getDjId())) {
                optProcInfo.setDjId(super.getDjId());
            }
            optProcInfo.setNodeInstId(curNodeInstId);

            NodeInstance nodeInst = flowEngine.getNodeInstById(curNodeInstId);
            FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nodeInst
                    .getNodeId());
            optProcInfo.setNodename(nodeInfo.getNodeName());
            optProcInfo.setNodeinststate(nodeInst.getNodeState());

            // 存在风险点的信息:风险类别、风险描述、风险内控手段与结果
            if (StringUtils.isNotBlank(optProcInfo.getRisktype())) {
                optProcInfo.setIsrisk("T");// 存在
            } else {
                optProcInfo.setIsrisk("F");// 不存在
            }
            try {
                optProcInfoManager.saveObject(optProcInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return ERROR;
            }
            // 保存办件人员
            saveTeamRolepeople();
            return "refreshTasks";
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存流程过程信息失败。");
            return ERROR;
        }
    }

    private String teamRoles;

    /**
     * 保存办件人员
     */
    public void saveTeamRolepeople() {
        try {
            // flowEngine.deleteFlowWorkTeam(super.getFlowInstId(),"ajjbr");
            NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId);
            if (!StringUtils.isBlank(teamRoles)) {
                String[] teamRole = teamRoles.split(",");
                if (teamRole.length > 0) {
                    for (String a : teamRole) {
                        flowEngine.assignFlowWorkTeam(nit.getFlowInstId(),
                                "ajjbr", a);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回退节点
     * 
     * @return
     */
    public String rollBackOpt() {
        flowManager.rollbackOpt(curNodeInstId,
                ((FUserDetail) getLoginUser()).getUsercode());
        // 保存过程日志信息
        if (optProcInfo == null) {
            optProcInfo = new OptProcInfo();
        }
        optProcInfo.setDjId(super.getDjId());
        optProcInfo.setNodeInstId(curNodeInstId);

        if (!"B".equals(optProcInfo.getIdeacode())) {
            optProcInfo.setIdeacode("B");
        }
        saveIdeaInfo();
        return "refreshTasks";
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

            saveOptNewlyIdea();

            return this.nextStep();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 
     * @param isdisplay
     *            :是否需要在页面lab标签显示
     * @param nodeName
     *            :节点名称
     * @param orderno
     *            :排序号
     * @param url
     *            :操作业务信息的链接
     */
    public void initalOptNewlyIdea(Long isdisplay, String nodeName,
            Long orderno, String url) {
        optProcInfo.setIsdisplay(isdisplay);
        optProcInfo.setIntalNodeName(nodeName);
        optProcInfo.setOrderno(orderno);
        optProcInfo.setUrl(url);
    }

    /**
     * 记录最新办理信息:主要作用是针对详细信息查看功能； 在对应业务提交处，首先需要实例化(OptProcInfo中属性)一下以下参数：
     * isdisplay、nodeName、orderno、url 分别对应：是否需要在页面lab标签显示、节点名称、排序号、操作业务信息的链接
     */
    public void saveOptNewlyIdea() {
        // 获得流程信息
        NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId);
        FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nit.getNodeId());
        // 默认是以对应业务自主命名的节点名称，如果没有指定，则使用流程节点名称；
        String nodeName = optProcInfo.getIntalNodeName();
        if (StringUtils.isBlank(nodeName)) {
            nodeName = nodeInfo.getNodeName();
        }

        Long isdisplay = optProcInfo.getIsdisplay();
        if (isdisplay == null) {
            isdisplay = (long) 0;
        }
        Long orderno = optProcInfo.getOrderno();
        if (orderno == null) {
            orderno = (long) 0;
        }

        // 判断是否存在记录最新办理信息
        OptNewlyIdea optNewlyIdea = optNewlyIdeaManager
                .getObject(new OptNewlyIdea(optProcInfo.getDjId(), nit
                        .getNodeId()));
        if (optNewlyIdea == null) {
            optNewlyIdea = new OptNewlyIdea();
            optNewlyIdea.setDjId(optProcInfo.getDjId());
            optNewlyIdea.setNodeid(nit.getNodeId());
        }
        optNewlyIdea.setNodeinstid(curNodeInstId);
        optNewlyIdea.setIsdisplay(isdisplay);
        optNewlyIdea.setNodename(nodeName);
        optNewlyIdea.setOrderno(orderno);
        optNewlyIdea.setUrl(optProcInfo.getUrl());
        // 保存最新记录
        optNewlyIdeaManager.saveObject(optNewlyIdea);
    }

    /**
     * 保存过程日志信息
     */
    public void saveIdeaInfo() {
        try {
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            OptIdeaInfo optIdeaInfo = new OptIdeaInfo();
            optIdeaInfo.setUsername(loginInfo.getUsername());

            FUnitinfo fUnitinfo = sysUnitManager.getObjectById(loginInfo
                    .getPrimaryUnit());
            optIdeaInfo.setUnitname(fUnitinfo.getUnitname());

            /** 获取过程日志信息：环节名称、办理意见、环节状态 start */
            NodeInstance nodeInst = flowEngine.getNodeInstById(curNodeInstId);
            FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nodeInst
                    .getNodeId());
            optProcInfo.setNodename(nodeInfo.getNodeName());
            optProcInfo.setNodeinststate(nodeInst.getNodeState());
            optProcInfo.setTransdate(new Date(System.currentTimeMillis()));
            optProcInfo.setUsercode(loginInfo.getUsercode());
            optProcInfo.setUnitcode(loginInfo.getPrimaryUnit());
            optIdeaInfo.setTransidea(optProcInfo.getTransidea());
            optIdeaInfo.setFlowPhase(super.getFlowPhase());
            /** 获取过程日志信息：环节名称、办理意见、环节状态 end */

            optProcInfoManager.saveIdeaInfo(optIdeaInfo, optProcInfo);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e, e.getCause());
            request.setAttribute("error", "保存业务过程信息失败。");
        }
    }

    /**
     * 获取下一节点审批角色人员
     */
    public void initalNextOperators() {
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        Set<FlowNodeInfo> fniList = flowEngine.viewNextNode(curNodeInstId,
                loginInfo.getUsercode(), loginInfo.getPrimaryUnit(), null);
        FlowNodeInfo fni = null;
        if (fniList != null && fniList.size() > 0) {
            fni = fniList.iterator().next();
        }

        Set<String> oper = flowEngine.viewNextNodeOperator(fni.getNodeId(),
                curNodeInstId, loginInfo.getUsercode(),
                loginInfo.getPrimaryUnit(), null);
        if (oper != null && oper.size() > 0) {
            for (String op : oper) {
                nextOperaters += CodeRepositoryUtil.getValue("usercode", op)
                        + ",";
            }
        }
        if (!StringUtils.isBlank(nextOperaters)) {
            nextOperaters = nextOperaters.substring(0,
                    nextOperaters.length() - 1);
        }
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

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public String getTeamRoles() {
        return teamRoles;
    }

    public void setTeamRoles(String teamRoles) {
        this.teamRoles = teamRoles;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public String getIdeaCatalog() {
        return ideaCatalog;
    }

    public void setIdeaCatalog(String ideaCatalog) {
        this.ideaCatalog = ideaCatalog;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getStuffGroupId() {
        return stuffGroupId;
    }

    public void setStuffGroupId(String stuffGroupId) {
        this.stuffGroupId = stuffGroupId;
    }

    public String getUserFilterExp() {
        return userFilterExp;
    }

    public void setUserFilterExp(String userFilterExp) {
        this.userFilterExp = userFilterExp;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getSubmitOptURI() {
        return submitOptURI;
    }

    public void setSubmitOptURI(String submitOptURI) {
        this.submitOptURI = submitOptURI;
    }

    public String getSaveOptURI() {
        return saveOptURI;
    }

    public void setSaveOptURI(String saveOptURI) {
        this.saveOptURI = saveOptURI;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setOptNewlyIdeaManager(OptNewlyIdeaManager optNewlyIdeaManager) {
        this.optNewlyIdeaManager = optNewlyIdeaManager;
    }

    public String getNextOperaters() {
        return nextOperaters;
    }

    public void setNextOperaters(String nextOperaters) {
        this.nextOperaters = nextOperaters;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

}
