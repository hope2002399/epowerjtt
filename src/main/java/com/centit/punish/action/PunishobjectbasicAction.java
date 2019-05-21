package com.centit.punish.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Pcfreeumpiredegree;
import com.centit.powerbase.po.Vsuppowerinusing;
import com.centit.powerbase.service.PcfreeumpiredegreeManager;
import com.centit.powerbase.service.PcfreeumpiretypeManager;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.powerbase.service.VsuppowerinusingManager;
import com.centit.powerruntime.action.GeneralOperatorAction;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.page.OptJspInfo;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.po.VOrgSupPower;
import com.centit.punish.po.Appenterprise;
import com.centit.punish.po.Appindividual;
import com.centit.punish.po.OptNewlyIdea;
import com.centit.punish.po.Pcdef;
import com.centit.punish.po.Poacceptinfo;
import com.centit.punish.po.Podecisioninfo;
import com.centit.punish.po.Podiscussbasic;
import com.centit.punish.po.PodiscussbasicId;
import com.centit.punish.po.Poenterprise;
import com.centit.punish.po.Pofinishbasic;
import com.centit.punish.po.Poindagaterepbasic;
import com.centit.punish.po.Poindividual;
import com.centit.punish.po.Poregisterbasic;
import com.centit.punish.po.Potranslawbasic;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.AppenterpriseManager;
import com.centit.punish.service.AppindividualManager;
import com.centit.punish.service.PoacceptinfoManager;
import com.centit.punish.service.PodecisioninfoManager;
import com.centit.punish.service.PodiscussbasicManager;
import com.centit.punish.service.PoenterpriseManager;
import com.centit.punish.service.PofinishbasicManager;
import com.centit.punish.service.PoindagaterepbasicManager;
import com.centit.punish.service.PoindividualManager;
import com.centit.punish.service.PoregisterbasicManager;
import com.centit.punish.service.PotranslawbasicManager;
import com.centit.punish.service.PunishobjectbasicManager;
import com.centit.support.utils.StringRegularOpt;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.FunctionManager;
import com.centit.sys.service.SysUserFilterEngine;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

public class PunishobjectbasicAction extends
        PunishCommonBizAction<Punishobjectbasic> {
    private static final long serialVersionUID = 1L;
    private PunishobjectbasicManager punishobjectbasicMag;
    private FunctionManager functionManager;
    private SuppowerManager suppowerManager;

    private PoenterpriseManager poenterpriseMag;
    private PoindividualManager poindividualMag;
    private PotranslawbasicManager potranslawbasicManager;
    private PoregisterbasicManager poregisterbasicManager;

    private String reghour;// 案发时间--小时
    private String regmin;// 案发时间--分钟
    private String flowCode;
    private String nextOptUrl;
    private PoindagaterepbasicManager poindagaterepbasicManager;
    private AppindividualManager appindividualManager;
    private AppenterpriseManager appenterpriseManager;
    @SuppressWarnings("unused")
    private PcfreeumpiretypeManager pcfreeumpiretypeManager;
    private List<OptNewlyIdea> optNewlyIdeaList;
    private PodiscussbasicManager podiscussbasicManager;
    private String entid;// 页面机构编号
    private String indid;// 页面人员编号

    private VOrgSupPower vorgsuppower;

    /**
     * 案件受理、处罚决定
     */
    private PoacceptinfoManager poacceptinfoManager;
    private PodecisioninfoManager podecisioninfoManager;
    private VsuppowerinusingManager vsuppowerinusingManager;

    public String save() {
        return super.save();
    }

    public String saveAndSubmitPermit() {
        return this.saveAndSubmit();
    }

    private List<FUnitinfo> unitList;
    private String unitsJson;
    private String parentunit;
    private String isJD;

    @Override
    public String list() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser.getUsercode());
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        if (StringUtils.isBlank((String) filterMap.get("managedepid"))) {
            filterMap.put("managedepid", dept.getUnitcode());
        }
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        objList = punishobjectbasicMag.listPunishObjectBasics(filterMap,
                pageDesc);
        totalRows = pageDesc.getTotalRows();
        // unitList = sysUnitManager.getAllSubUnits(dept.getUnitcode());
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return LIST;
    }

    public String getParentunit() {
        return parentunit;
    }

    public void setParentunit(String parentunit) {
        this.parentunit = parentunit;
    }

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public boolean savePunishObject() {
        boolean flag = false;
        try {
            object.setPoregistedate(new Date(System.currentTimeMillis()));
            if (StringRegularOpt.isNvl(object.getPunishobjecttype())) {
                object.setPunishobjecttype("0");
            }
            if (StringRegularOpt.isNvl(object.getPunishobjectstate())) {
                object.setPunishobjectstate("1");
            }
            // 保存个人或者企业
            this.saveIndOrEntInfo(object);

            punishobjectbasicMag.saveObject(object);
            super.optProcInfoManager.isInuse(object.getPunishobjectid());
            flag = true;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            flag = false;

        }
        return flag;
    }

    public String getEntid() {
        return entid;
    }

    public void setEntid(String entid) {
        this.entid = entid;
    }

    public String getIndid() {
        return indid;
    }

    public void setIndid(String indid) {
        this.indid = indid;
    }

    public void setAppindividualManager(
            AppindividualManager appindividualManager) {
        this.appindividualManager = appindividualManager;
    }

    public void setAppenterpriseManager(
            AppenterpriseManager appenterpriseManager) {
        this.appenterpriseManager = appenterpriseManager;
    }

    @Override
    public String delete() {
        /*
         * super.delete(); return this.list();
         */
        punishobjectbasicMag.deleteObject(object);
        return this.list();
    }

    private OptJspInfo jspInfo;

    public String viewItem() {
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 查看办件业务数据信息
        frameList.add(getViewFrame(object.getPunishobjectid()));
        // 用于展示处罚查看详细信息Lab标签内容
        frameList.add(this.getAllViewFrame(object.getPunishobjectid()));

        jspInfo = new OptJspInfo();
        jspInfo.setTitle("案件办理查看");
        jspInfo.setFrameList(frameList);

        return "generalOptView";
    }

    /**
     * 用于展示处罚查看详细信息Lab标签内容
     * 
     * @param punishobjectid
     * @return
     */
    private OptHtmlFrameInfo getAllViewFrame(String punishobjectid) {
        OptHtmlFrameInfo stuffsFrameInfo = new OptHtmlFrameInfo();
        stuffsFrameInfo.setFrameId("viewStuffsFrame");
        stuffsFrameInfo
                .setFrameSrc("/punish/punishobjectbasic!getAllPunishView.do?punishobjectid="
                        + punishobjectid + "&nodeInstId=" + curNodeInstId);
        stuffsFrameInfo.setFrameHeight("300px");
        return stuffsFrameInfo;
    }

    private String curUrl;

    /**
     * 用于展示处罚查看详细信息Lab标签内容
     * 
     * @return
     */
    public String getAllPunishView() {
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("djId", object.getPunishobjectid());
        filterMap.put("isdisplay", "1");
        optNewlyIdeaList = optNewlyIdeaManager.listObjects(filterMap);
        long nodeId = (long) 0;
        if (curNodeInstId != null && curNodeInstId != 0) {
            NodeInstance nodeInst = flowEngine.getNodeInstById(curNodeInstId);
            nodeId = nodeInst.getNodeId();
        }
        // 用于初始化查看页面默认显示
        curUrl = "/powerruntime/generalOperator!listIdeaLogs.do?djId="
                + object.getPunishobjectid();
        if (optNewlyIdeaList != null && optNewlyIdeaList.size() > 0
                && nodeId != 0) {
            for (OptNewlyIdea bean : optNewlyIdeaList) {
                if (bean.getNodeid() == nodeId) {
                    curUrl = bean.getUrl();
                    break;
                }
            }
        }
        object = punishobjectbasicMag.getObject(object);
        if (null == object.getFlowInstId()) {
            object.setFlowInstId((long) 9999999);
        }
        request.setAttribute("nodeId", nodeId);
        return "AllPunishView";
    }

    public OptJspInfo getJspInfo() {
        return jspInfo;
    }

    public void setJspInfo(OptJspInfo jspInfo) {
        this.jspInfo = jspInfo;
    }

    public String getCurUrl() {
        return curUrl;
    }

    public void setCurUrl(String curUrl) {
        this.curUrl = curUrl;
    }

    public List<OptNewlyIdea> getOptNewlyIdeaList() {
        return optNewlyIdeaList;
    }

    public void setOptNewlyIdeaList(List<OptNewlyIdea> optNewlyIdeaList) {
        this.optNewlyIdeaList = optNewlyIdeaList;
    }

    /**
     * 根据处罚流水号 获取对应的处罚基本信息
     * 
     * @param punishobjectid
     * @return
     */
    private OptHtmlFrameInfo getViewFrame(String punishobjectid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewFrame");
        viewFrameInfo
                .setFrameSrc("/punish/punishobjectbasic!viewPunish.do?punishobjectid="
                        + punishobjectid);
        return viewFrameInfo;
    }

    /**
     * 
     * @return 处罚基本信息,用于案件办理页面显示
     */
    public String viewPunish() {
        object = punishobjectbasicMag.getObjectById(object.getPunishobjectid());
        return "PermitView";
    }

    /**
     * 简易流程案件登记
     * 
     * @return
     */
    public String facilityFlow() {
        this.edit();

        FUserDetail fUserDetail = (FUserDetail) getLoginUser();

        Set<String> users = SysUserFilterEngine.calcOperators("D(U)",
                fUserDetail.getPrimaryUnit(), null, null, null,
                fUserDetail.getUsercode(), null);
        JSONArray userjson = new JSONArray();
        if (users != null) {
            for (String user : users) {
                String username = CodeRepositoryUtil.getValue("usercode", user);
                JSONObject usermap = new JSONObject();
                usermap.put("name", username);
                usermap.put("nodeID", user);
                usermap.put("belongId", "-1");
                usermap.put("levle", 2);
                userjson.add(usermap);
            }
        }
        request.setAttribute("userjson", userjson);
        return "facilityFlow";
    }

    /**
     * 简易流程案件登记
     * 
     * @return
     */
    public String onthespotpunishment() {
        this.getPunishObjectBasicInfo();

        FUserDetail fUserDetail = (FUserDetail) getLoginUser();

        Set<String> users = SysUserFilterEngine.calcOperators("D(U)",
                fUserDetail.getPrimaryUnit(), null, null, null,
                fUserDetail.getUsercode(), null);
        JSONArray userjson = new JSONArray();
        if (users != null) {
            for (String user : users) {
                String username = CodeRepositoryUtil.getValue("usercode", user);
                JSONObject usermap = new JSONObject();
                usermap.put("name", username);
                usermap.put("nodeID", user);
                usermap.put("belongId", "-1");
                usermap.put("levle", 2);
                userjson.add(usermap);
            }
        }
        request.setAttribute("userjson", userjson);
        return "facilityFlow";
    }

    /**
     * 处罚种类
     * 
     * @return /** 现场处罚信息页面的查看方法
     * 
     * @return
     */

    // 结案信息
    private Pofinishbasic finishBasic;
    // 自由裁量
    private Pcfreeumpiredegree freeUmpireDegree;

    public String punishInfo() {
        // 根据登记编号查看处罚登记信息
        this.getPunishObjectBasicInfo();

        Potranslawbasic transLawBasic = this.potranslawbasicManager
                .getItem_idBypunishobjectid(object.getPunishobjectid());

        setFinishBasic(this.pofinishbasicManager.getObjectById(object
                .getPunishobjectid()));

        setFreeUmpireDegree(this.pcfreeumpiredegreeManager
                .getObjectByItemsId(transLawBasic.getDegreeno()));

        return "punishInfo";
    }

    /**
     * 保存并提交案件信息
     * 
     * @return
     */
    public String saveAndSubmit() {
        try {
            if (object.getFlowInstId() == null
                    || "".equals(object.getFlowInstId())) {

                FUserDetail fuser = ((FUserDetail) getLoginUser());

                if (StringUtils.isBlank(flowCode)) {
                    flowCode = suppowerManager.getFlowCodeByOrgItem(
                            object.getPowerid(), fuser.getPrimaryUnit());
                }
                FlowInstance flowInst = flowEngine.createInstance(flowCode,
                        "案件来源登记[" + object.getPunishobjectid() + "]",
                        object.getPunishobjectid(), fuser.getUsercode(),
                        fuser.getPrimaryUnit());
                long flowInstId = flowInst.getFlowInstId();
                long nodeInstId = flowInst.getFirstNodeInstance()
                        .getNodeInstId();
                // object.setFlowInstId(flowInstId);
                this.setFlowInstId(flowInstId);
                curNodeInstId = nodeInstId;

                object.setFlowInstId(flowInstId);
                object.setBiztype("W");
            }
            // TODO 保存业务数据
            if (savePunishObject()) {
                // TODO 保存过程日志信息
                saveIdeaInfo_inital();
            }

            // 流程步骤判断

            return this.nextStep();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交案件信息出错，详见系统日志。");
            return ERROR;
        }
    }

    public String savePunish() {
        try {
            object.setBiztype("F");
            this.savePunishObject();
            return this.list();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存案件信息出错，详见系统日志。");
            return ERROR;
        }
    }

    public String edit() {
        // 根据登记编号查看处罚登记信息
        object.setPunishobjectid("");
        GeneralOperatorAction.getUUID();

        this.getPunishObjectBasicInfo();

        return EDIT;
    }

    public String editold() {
        // 根据登记编号查看处罚登记信息
        this.getPunishObjectBasicInfo();

        return EDIT;
    }

    /**
     * 案源登记
     */
    public void getPunishObjectBasicInfo() {
        String optId = object.getOptId();
        object = punishobjectbasicMag.getObjectById(object.getPunishobjectid());
        if (object == null) {
            object = new Punishobjectbasic();

            object.setPunishobjectid(punishobjectbasicMag
                    .generateNextPunishObjectId());
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            object.setManagedepid(loginInfo.getPrimaryUnit());
            object.setOperatorid(loginInfo.getUsercode());//
            object.setPooccurdate(new Date(System.currentTimeMillis()));
            object.setPoregistedate(new Date(System.currentTimeMillis()));
            object.setOptId(optId);
        } else {
            if ("0".equals(String.valueOf(object.getPooccurstate()))) {
                object.setPoindividual(poindividualMag.getPoindividual(object
                        .getPunishobjectid()));
            } else if ("1".equals(String.valueOf(object.getPooccurstate()))) {
                object.setPoenterprise(poenterpriseMag.getPoenterprise(object
                        .getPunishobjectid()));
            }
        }

        // 根据业务编码，获取流程编码
        FOptinfo optInfo = functionManager.getObjectById(object.getOptId());
        if (optInfo != null) {
            flowCode = optInfo.getWfcode();
        }
    }

    /**
     * 保存过程日志信息
     */
    public void saveIdeaInfo_inital() {
        FUserDetail loginInfo = (FUserDetail) getLoginUser();

        OptIdeaInfo optIdeaInfo = new OptIdeaInfo();
        optIdeaInfo.setUsername(loginInfo.getUsername());

        FUnitinfo fUnitinfo = super.getSysUnitManager().getObjectById(
                loginInfo.getPrimaryUnit().trim());
        if (fUnitinfo == null) {
            fUnitinfo = new FUnitinfo();
        }
        optIdeaInfo.setUnitname(fUnitinfo.getUnitname());

        optIdeaInfo.setTransidea("登记受理");

        OptProcInfo procInfo = new OptProcInfo();
        procInfo.setNodeInstId(curNodeInstId);
        procInfo.setDjId(object.getPunishobjectid());
        procInfo.setNodename("案件来源登记");
        procInfo.setTransdate(new Date(System.currentTimeMillis()));
        procInfo.setNodeinststate("N");
        procInfo.setUnitcode(loginInfo.getPrimaryUnit());
        procInfo.setUsercode(loginInfo.getUsercode());
        procInfo.setTranscontent(object.getPoregisteropinion());
        procInfo.setTransidea("登记受理");

        super.getOptProcInfoManager().saveObject(procInfo);
        super.getOptProcInfoManager().saveIdeaInfo(optIdeaInfo, procInfo);

    }

    /******************************** 此处案件受理页面 *************************************/
    OptProcInfo opi = new OptProcInfo();

    /**
     * 案件受理页面
     * 
     * @return 案件信息
     */
    public String acceptPO() {
        object = punishobjectbasicMag.getObject(object);
        if (StringUtils.isNotBlank(super.getModuleCode())
                && !"null".equals(super.getModuleCode())) {
            // 初始化页面form对应的actionName、提交方法以及保存方法名
            super.initalGenneralOpt("punishobjectbasic", "submitAcceptPO",
                    "saveOptAcceptPO");
            return super.generalOpt();
        } else {
            super.initalOptProcInfo();
        }
        return "AcceptPO";
    }

    private String roleCode = "";

    /******************************** 案件受理审批 ***************************************/
    /**
     * **********************案件受理审批页面*******************
     * 
     * @return
     */
    public String isAcceptPO() {
        if (StringUtils.isNotBlank(super.getModuleCode())
                && !"null".equals(super.getModuleCode())) {
            // 初始化页面form对应的actionName、提交方法以及保存方法名
            super.initalGenneralOpt("punishobjectbasic",
                    "saveIsAcceptSubmitOpt", "saveOptIsAcceptPO");
            return super.generalOpt();
        }
        acceptPO();
        // 获取人员权限编号
        NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId);
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());
        if (fif != null) {
            roleCode = fif.getRoleCode();
            nodeName = fif.getNodeName();
        }
        /**
         * 获得办件角色人名单
         */
        Set<String> Rolecodes = flowEngine.viewFlowWorkTeam(
                object.getFlowInstId(), roleCode);

        String RoleuserCodes = "";

        if (Rolecodes != null && Rolecodes.size() > 0) {
            for (String a : Rolecodes) {
                RoleuserCodes += a + ",";
                // RoleuserNames += CodeRepositoryUtil.getValue("usercode", a)
                // + ",";
            }
            teamRoleCode = RoleuserCodes.substring(0,
                    RoleuserCodes.length() - 1);
            // bjUserNames = RoleuserNames
            // .substring(0, RoleuserNames.length() - 1);
        }

        /**
         * 根据参数是否需要 办件人员
         */
        FUserDetail fUserDetail = (FUserDetail) getLoginUser();
        String roleCode = roleCodefromFlow;
        if (StringUtils.isBlank(roleCode) || "null".equals(roleCode)) {
            roleCode = "D(all)";
        }
        Set<String> users = SysUserFilterEngine.calcOperators(roleCode,
                fUserDetail.getPrimaryUnit(), null, null, null,
                fUserDetail.getUsercode(), null);
        JSONArray userjson = new JSONArray();
        if (users != null) {
            for (String user : users) {
                String username = CodeRepositoryUtil.getValue("usercode", user);
                JSONObject usermap = new JSONObject();
                usermap.put("name", username);
                usermap.put("nodeID", user);
                usermap.put("belongId", "-1");
                usermap.put("levle", 2);
                userjson.add(usermap);
            }
        }
        request.setAttribute("userjson", userjson);

        return "isAcceptPO";
    }

    /**
     * 保存受理审批信息
     * 
     * @return
     */
    public String saveOptIsAcceptPO() {
        try {
            FUserDetail fUserDetail = (FUserDetail) getLoginUser();
            // 保存受理审批信息_负责人信息:此处用于重构过程信息
            Poacceptinfo poacceptinfo = poacceptinfoManager
                    .getObjectById(object.getPunishobjectid());
            if (poacceptinfo == null) {
                poacceptinfo = new Poacceptinfo();
                poacceptinfo.setPunishobjectid(object.getPunishobjectid());
            }
            poacceptinfo.setFzrSl(CodeRepositoryUtil.getValue("usercode",
                    fUserDetail.getUsercode()));
            poacceptinfo.setFzroptionSl(optProcInfo.getTranscontent());
            poacceptinfo
                    .setFzroptionSltime(new Date(System.currentTimeMillis()));
            poacceptinfoManager.saveObject(poacceptinfo);
            // 保存受理审批信息
            return super.saveOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存案件受理审批信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     ********************************* 提交案件受理审批信息******************
     * 
     * @return
     */
    public String saveIsAcceptSubmitOpt() {
        try {
            // 处理业务信息
            /**
             * 1、更新案件信息 ：案件受理时间、规定承办人 2、生成立案基础信息
             */
            this.updatePunishObjectOrInsertRegisterBasic(optProcInfo
                    .getIdeacode());
            //
            super.initalOptNewlyIdea((long) 1, "来源登记", (long) 2,
                    "/punish/punishobjectbasic!viewPunishobjectbasic.do?punishobjectid="
                            + object.getPunishobjectid() + "&nodeInstId="
                            + curNodeInstId);
            // 提交流程
            return super.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交案件受理审批信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 根据ideacode判断是否是同意受理 分管局长同意受理：更新案件信息、生成立案基础信息
     * 
     * @param ideacode
     */
    private void updatePunishObjectOrInsertRegisterBasic(String ideacode) {
        //
        if ("T".equals(ideacode)) {
            // 更新案件信息
            FUserDetail fUserDetail = (FUserDetail) getLoginUser();
            Punishobjectbasic base = punishobjectbasicMag.getObjectById(object
                    .getPunishobjectid());
            base.setIspass((long) 1);
            base.setPoorigindate(new Date(System.currentTimeMillis()));
            base.setPoundertaker(bjUserNames);
            punishobjectbasicMag.saveObject(base);

            // 案件受理信息_负责人信息:此处用于重构过程信息
            Poacceptinfo poacceptinfo = poacceptinfoManager
                    .getObjectById(object.getPunishobjectid());
            if (poacceptinfo == null) {
                poacceptinfo = new Poacceptinfo();
                poacceptinfo.setPunishobjectid(object.getPunishobjectid());
            }
            poacceptinfo.setFzrSl(CodeRepositoryUtil.getValue("usercode",
                    fUserDetail.getUsercode()));
            poacceptinfo.setFzroptionSl(optProcInfo.getTranscontent());
            poacceptinfo
                    .setFzroptionSltime(new Date(System.currentTimeMillis()));
            poacceptinfoManager.saveObject(poacceptinfo);

            // 生成立案基础信息
            Poregisterbasic porb = new Poregisterbasic();
            porb.setPunishobjectid(object.getPunishobjectid());
            poregisterbasicManager.saveObject(porb);

        }
    }

    /**
     * *********************************保存案件受理信息******************
     * 
     * @return
     */
    public String saveOptAcceptPO() {
        try {
            // 案件受理信息_经办人信息:此处用于重构过程信息
            FUserDetail fUserDetail = (FUserDetail) getLoginUser();
            Poacceptinfo poacceptinfo = poacceptinfoManager
                    .getObjectById(object.getPunishobjectid());
            if (poacceptinfo == null) {
                poacceptinfo = new Poacceptinfo();
                poacceptinfo.setPunishobjectid(object.getPunishobjectid());
            }
            poacceptinfo.setJbrSl(CodeRepositoryUtil.getValue("usercode",
                    fUserDetail.getUsercode()));
            poacceptinfo.setJbroptionSl(optProcInfo.getTranscontent());
            poacceptinfo
                    .setJbroptionSltime(new Date(System.currentTimeMillis()));
            poacceptinfoManager.saveObject(poacceptinfo);
            // 提交案件受理信息
            return super.saveOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "保存案件受理信息出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 提交案件受理信息
     * 
     * @return
     */
    public String submitAcceptPO() {
        try {
            this.saveOptAcceptPO();
            initalOptNewlyIdea((long) 0, "", (long) 1,
                    "/punish/punishobjectbasic!viewPunishobjectbasic.do?punishobjectid="
                            + object.getPunishobjectid());
            return this.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交案件受理信息出错，详见系统日志。");
            return ERROR;
        }

    }

    /******************************** 案件处罚决定：经办人意见 ***************************************/

    public String punishDecision() {
        if (StringUtils.isNotBlank(super.getModuleCode())
                && !"null".equals(super.getModuleCode())) {
            // 初始化页面form对应的actionName、提交方法以及保存方法名
            super.initalGenneralOpt("punishobjectbasic",
                    "submitPunishDecisionOpt", "saveOpt");
            // 预加载经办人意见信息
            this.intailpunishDecisionInfo();
            return super.generalOpt();
        } else {
            this.isAcceptPO();

            this.intailpunishDecisionInfo();
        }
        super.initalNextOperators();
        return "punishDecision";
    }

    /************************************ 保存案件处罚决定：经办人意见 ******************************************************/
    /**
     * 保存案件处罚决定：经办人意见
     * 
     * @return
     */
    public String submitPunishDecisionOpt() {
        try {
            // 保存办理人员意见信息
            FUserDetail fUserDetail = (FUserDetail) getLoginUser();
            Podecisioninfo podecisioninfo = podecisioninfoManager
                    .getObjectById(object.getPunishobjectid());
            if (podecisioninfo == null) {
                podecisioninfo = new Podecisioninfo();
                podecisioninfo.setPunishobjectid(object.getPunishobjectid());
            }
            podecisioninfo.setJbrCfjd(CodeRepositoryUtil.getValue("usercode",
                    fUserDetail.getUsercode()));
            podecisioninfo.setJbroptionCfjd(optProcInfo.getTranscontent());
            podecisioninfo.setJbroptionCfjdtime(new Date(System
                    .currentTimeMillis()));
            podecisioninfoManager.saveObject(podecisioninfo);
            //
            initalOptNewlyIdea((long) 0, "", (long) 12,
                    "/punish/punishobjectbasic!viewPunishobjectbasic.do?punishobjectid="
                            + object.getPunishobjectid());
            //
            return super.submitOpt();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 预加载经办人意见信息
     */
    private void intailpunishDecisionInfo() {
        
        String punishobjectid = object.getPunishobjectid();
        object = punishobjectbasicMag.getObjectById(punishobjectid);
        PodiscussbasicId id = new PodiscussbasicId(object.getPunishobjectid(),
                object.getPodiscussnum());
        Podiscussbasic podiscussbasic = podiscussbasicManager.getObjectById(id);
        String Transcontent = "";
        if (null != podiscussbasic) {
            if (!StringUtils.isBlank(Transcontent)) {
                Transcontent = "建议处以" + Transcontent + "的行政处罚";
            }
        } else {
            Transcontent = "";
        }
        optProcInfo.setTranscontent(Transcontent);
    }

    /******************************** 处罚决定审批：经办人意见，领导审批等 ***************************************/
    public String isPunishDecision() {
        super.initalDocJson("行政案件处罚报批表", object.getPunishobjectid());
        if (StringUtils.isNotBlank(super.getModuleCode())
                && !"null".equals(super.getModuleCode())) {
            // 初始化页面form对应的actionName、提交方法以及保存方法名
            super.initalGenneralOpt("punishobjectbasic",
                    "submitIsPunishDecisionOpt", "saveOpt");
            return super.generalOpt();
        }
        this.isAcceptPO();
        return "isPunishDecision";
    }

    /**
     * 保存案件处罚决定：经办人意见
     * 
     * @return
     */
    public String submitIsPunishDecisionOpt() {
        try {
            // 保存办理人员意见信息
            FUserDetail fUserDetail = (FUserDetail) getLoginUser();
            // 保存案件处罚决定办理人员意见信息
            Podecisioninfo podecisioninfo = podecisioninfoManager
                    .getObjectById(object.getPunishobjectid());
            if (podecisioninfo == null) {
                podecisioninfo = new Podecisioninfo();
                podecisioninfo.setPunishobjectid(object.getPunishobjectid());
            }

            if ("cfjd_jzsp".equalsIgnoreCase(super.getFlowPhase())) {
                // 保存案件处罚决定办理人员——负责人意见信息
                podecisioninfo.setFzrCfjd(CodeRepositoryUtil.getValue(
                        "usercode", fUserDetail.getUsercode()));
                podecisioninfo.setFzroptionCfjd(optProcInfo.getTranscontent());
                podecisioninfo.setFzroptionCfjdtime(new Date(System
                        .currentTimeMillis()));
                podecisioninfoManager.saveObject(podecisioninfo);
                // 处罚决定节点查看
                initalOptNewlyIdea((long) 0, "", (long) 14,
                        "/punish/punishobjectbasic!viewPunishobjectbasic.do?punishobjectid="
                                + object.getPunishobjectid());
            } else {
                // 保存案件处罚决定办理人员——科长意见信息
                podecisioninfo.setKsrCfjd(CodeRepositoryUtil.getValue(
                        "usercode", fUserDetail.getUsercode()));
                podecisioninfo.setKsoptionCfjd(optProcInfo.getTranscontent());
                podecisioninfo.setKsoptionCfjdtime(new Date(System
                        .currentTimeMillis()));
                podecisioninfoManager.saveObject(podecisioninfo);
                // 处罚决定节点查看
                initalOptNewlyIdea((long) 0, "", (long) 13,
                        "/punish/punishobjectbasic!viewPunishobjectbasic.do?punishobjectid="
                                + object.getPunishobjectid());
            }
            //
            return super.submitOpt();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 查看案件来源信息
     * 
     * @return
     */
    private List<OptStuffInfo> optStuffs;

    public List<OptStuffInfo> getOptStuffs() {
        return optStuffs;
    }

    public void setOptStuffs(List<OptStuffInfo> optStuffs) {
        this.optStuffs = optStuffs;
    }

    public Poacceptinfo getPoacceptinfo() {
        return poacceptinfo;
    }

    public void setPoacceptinfo(Poacceptinfo poacceptinfo) {
        this.poacceptinfo = poacceptinfo;
    }

    private Poacceptinfo poacceptinfo;

    public String viewPunishobjectbasic() {
        super.view();
        if (object != null) {
            if ("0".equals(String.valueOf(object.getPooccurstate()))) {
                object.setPoindividual(poindividualMag.getPoindividual(object
                        .getPunishobjectid()));
                if (object.getPoindividual() != null) {
                    object.setPocaseimpeachname(object.getPoindividual()
                            .getIndividualname());
                }
            } else if ("1".equals(String.valueOf(object.getPooccurstate()))) {
                object.setPoenterprise(poenterpriseMag.getPoenterprise(object
                        .getPunishobjectid()));
                if (object.getPoenterprise() != null) {
                    object.setPocaseimpeachname(object.getPoenterprise()
                            .getEnterprisename());
                }
            }
        }
        if (curNodeInstId != null) {
            if (optProcInfo == null) {
                optProcInfo = new OptProcInfo();
            }
            optProcInfo.setDjId(object.getPunishobjectid());
            optProcInfo.setNodeInstId(curNodeInstId);
            optStuffs = super.optProcInfoManager.getStuffInfoList(optProcInfo);
        }
        poacceptinfo = this.poacceptinfoManager.getObjectById(object
                .getPunishobjectid());
        return VIEW;
    }

    /**
     * //用于解决处罚决定经办人意见 案件基本信息中自动生成的“最终处罚意见”改为“初步处罚意见”
     */
    private String flagFrame;

    /**
     * 案件基本信息 用于调查取证的案件基本信息
     * 
     * @return
     */
    public String punishBasicFrame() {
        String punishobjectid = object.getPunishobjectid();
        this.viewPunishobjectbasic();
        // 获取案件最终结果信息
        Potranslawbasic potranslawbasic = potranslawbasicManager
                .getItem_idBypunishobjectid(punishobjectid);

        Vsuppowerinusing vsuppowerinusing = vsuppowerinusingManager
                .findB_PowerByItemId(potranslawbasic.getItem_id());

        object.setItem_id(potranslawbasic.getItem_id());
        object.setItemName(vsuppowerinusing.getItemName());
        // 最终处罚意见
        Podiscussbasic podiscussbasic = podiscussbasicManager
                .getObjectById(new PodiscussbasicId(object.getPunishobjectid(),
                        object.getPodiscussnum()));
        String Podiscussresult = "";
        if (podiscussbasic != null) {
            Podiscussresult = podiscussbasic.getPodiscussresult();
        }
        object.setPoIndagateRepResult(Podiscussresult);
        return "basicFrame";
    }

    /**
     * 案件结果信息
     * 
     * @return
     */
    public String punishResultFrame() {
        String punishobjectid = object.getPunishobjectid();
        Poindagaterepbasic poi = this.poindagaterepbasicManager
                .getObjectById(punishobjectid);
        request.setAttribute("poi", poi);
        return "poresultFrame";
    }

    public String generOptAllInfo() {

        return this.view();
    }

    /****************************************************
     * 
     * @param 现场处罚
     */

    private Pcdef pcdef;
    private List<Pcfreeumpiredegree> degreelist;
    private PcfreeumpiredegreeManager pcfreeumpiredegreeManager;
    private PofinishbasicManager pofinishbasicManager;
    private Vsuppowerinusing vsuppowerinusing;

    public void setPcfreeumpiredegreeManager(
            PcfreeumpiredegreeManager pcfreeumpiredegreeManager) {
        this.pcfreeumpiredegreeManager = pcfreeumpiredegreeManager;
    }

    public List<Pcfreeumpiredegree> getDegreelist() {
        return degreelist;
    }

    public void setDegreelist(List<Pcfreeumpiredegree> degreelist) {
        this.degreelist = degreelist;
    }

    public Pcdef getPcdef() {
        return pcdef;
    }

    public void setPcdef(Pcdef pcdef) {
        this.pcdef = pcdef;
    }

    /**
     * 暂存现场处罚信息，保存后，返回编辑页面，出处罚决定书
     * 
     * @return
     */
    public String savefacilityflowinfo_save() {
        this.setIsJD("T");// 决定书标示
        object.setBiztype("F");
        this.savefacilityflowinfo();// 保存现场处罚信息
        return this.onthespotpunishment();// 返回编辑页面
    }

    /**
     * 提交现场处罚信息
     * 
     * @return
     */
    public String savefacilityflowinfo_subm() {
        object.setBiztype("C");
        object.setBizstate("C");
        return this.savefacilityflowinfo();// 保存现场处罚信息
    }

    /**
     * 刷新现场处罚
     * 
     * @return
     */
    @SuppressWarnings("unused")
    public String refreshfacilitydes() {
        String item_id = request.getParameter("item_id");
        if (item_id == null) {
            item_id = object.getItem_id();
        }
        if (item_id != null) {
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            vorgsuppower = suppowerManager.getSupPowerInfo(object.getItem_id(),
                    loginInfo.getPrimaryUnit());
            object.setVorgsuppower(vorgsuppower);
            object.setItem_id(item_id);
            String name = vorgsuppower.getItemName();
            Map<String, Object> filterMap = new HashMap<String, Object>();
            filterMap.put("itemId", item_id);
            filterMap.put("version", object.getVorgsuppower().getVersion());
            degreelist = this.pcfreeumpiredegreeManager.listObjects(filterMap);
        } else {//
            Potranslawbasic potranslawbasic = potranslawbasicManager
                    .getItem_idBypunishobjectid(object.getPunishobjectid());
            if (potranslawbasic != null) {
                this.getPunishObjectBasicInfo();
                object.setDegreeno(String.valueOf(potranslawbasic.getDegreeno()));
                object.setItem_id(potranslawbasic.getItem_id());
                seldegreefacilitydes();
            }
        }

        // 以下为处理文书内容
        super.initTemplateFromNode();
        // 组织文书JSON

        // super.initCommonBizJSON(object);
        // this.initPunishobjectbasic_CFJDJSON();
        return "punishfacilitydes_";
    }

    public String refreshfacilitydes_first() {
        /*
         * Poradixbasic poradixbasic = poradixbasicManager
         * .getRadixBasicByPunishobjectid(object.getPunishobjectid());
         */

        Potranslawbasic potranslawbasic = potranslawbasicManager
                .getItem_idBypunishobjectid(object.getPunishobjectid());
        if (potranslawbasic != null) {
            this.getPunishObjectBasicInfo();
            object.setDegreeno(String.valueOf(potranslawbasic.getDegreeno()));
            object.setItem_id(potranslawbasic.getItem_id());
            request.setAttribute("degreeno", object.getDegreeno());
            Pofinishbasic pofinishbasic = pofinishbasicManager
                    .getObjectById(object.getPunishobjectid());
            if (pofinishbasic != null) {
                otherpunish = pofinishbasic.getOtherpunish();
                punishamout = pofinishbasic.getPunishamout() + "";
                discussresult = pofinishbasic.getPodiscussresult();
            }

            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            object.setVorgsuppower(suppowerManager.getSupPowerInfo(
                    object.getItem_id(), loginInfo.getPrimaryUnit()));

            object.setItem_id(object.getItem_id());
            Map<String, Object> filterMap = new HashMap<String, Object>();
            filterMap.put("itemId", object.getItem_id());
            filterMap.put("version", object.getVorgsuppower().getVersion());
            degreelist = this.pcfreeumpiredegreeManager.listObjects(filterMap);

        }

        // 以下为处理文书内容
        super.initTemplateFromNode();
        // 组织文书JSON

        // super.initCommonBizJSON(object);
        // this.initPunishobjectbasic_CFJDJSON();
        return "punishfacilitydes_";

    }

    /**
     * 选择处罚项目
     * 
     * @return
     */
    public String createfacilitydes() {
        String item_id = request.getParameter("item_id");
        this.potranslawbasicManager.initPunishInfo(object.getPunishobjectid(),
                item_id);
        return refreshfacilitydes();
    }

    /**
     * 现场处罚提交
     * 
     * @return
     */
    @SuppressWarnings("unused")
    public String savefacilityflowinfo() {
        String isoutrange = request.getParameter("isoutofrange");
        object.setPunishobjecttype("1"); // 案件性质：简易流程
        object.setPunishobjectstate("9"); // 案件状态：9结案
        // object.setBiztype("F");
        object.setPoundertaker(bjUserNames);// 办件人员

        // 保存基本信息
        boolean result = this.savePunishObject();
        if (result) {
            // 保存结案信息
            Pofinishbasic fisobj = new Pofinishbasic();
            fisobj.setPunishobjectid(object.getPunishobjectid());
            // 存处罚项目名称
            fisobj.setConfirmtruth(request.getParameter("confirmtruth"));
            // 存相关的法律依据
            fisobj.setDisobeyitem(request.getParameter("disobeyitem"));
            //
            fisobj.setPodiscussresult(discussresult);
            if (StringRegularOpt.isNumber(punishamout)) {
                fisobj.setPunishamout(Double.parseDouble(punishamout));
            }
            fisobj.setOtherpunish(otherpunish);
            fisobj.setIsfinish((long) 1);
            fisobj.setJbrja(getLoginUser().getUsername());
            fisobj.setJbroptionjatime(new Date());
            this.pofinishbasicManager.saveObject(fisobj);
        }
        return this.list();

    }

    /**
     * //保存个人或者企业
     * 
     * @param object
     */
    private void saveIndOrEntInfo(Punishobjectbasic object) {
        String occurstate = String.valueOf(object.getPooccurstate()); // 当事人类型
        if ("0".equals(occurstate)) {// 保存当事人类型--个人信息到poindividial表
            Poindividual poindobject = new Poindividual();
            if (StringUtils.isBlank(indid)) {// 如果是手动输入人员信息,增加至appindividual表;
                Appindividual indobj = new Appindividual();
                String id = poindividualMag.generateNextIndividualId();// 生成新id
                indobj.setIndividualid(id);
                indobj.copyNotNullPropertyFromPoindividual(object
                        .getPoindividual());
                indobj.setLastusedate(new Date(System.currentTimeMillis()));
                appindividualManager.saveObject(indobj);
                object.getPoindividual().setIndividualid(id);
            } else {// 列表选择方式选择当事人;
                Appindividual indobj = appindividualManager
                        .getObjectById(indid);
                indobj.copyNotNullPropertyFromPoindividual(object
                        .getPoindividual());
                indobj.setLastusedate(new Date(System.currentTimeMillis()));
                appindividualManager.saveObject(indobj);
                object.getPoindividual().setIndividualid(indid);
            }
            Map<String, Object> filtermap = new HashMap<String, Object>();
            filtermap.put("punishobjectid", object.getPunishobjectid());
            List<Poindividual> indlist = this.poindividualMag
                    .listObjects(filtermap);
            for (Poindividual o : indlist) {
                this.poindividualMag.deleteObject(o);
            }
            poindobject.copyNotNullProperty(object.getPoindividual());
            poindobject.setPunishobjectid(object.getPunishobjectid());
            poindividualMag.saveObject(poindobject);
        } else if ("1".equals(occurstate)) {// 保存当事人类型--组织机构信息到poenterprise表
            Poenterprise poentobject = new Poenterprise();
            if (StringUtils.isBlank(entid)) {// 如果是手动输入机构信息,增加至appenterprise表;
                Appenterprise entobj = new Appenterprise();
                String id = poenterpriseMag.generateNextEnterpriseId();// 生成新id
                entobj.setEnterpriseid(id);
                entobj.copyNotNullPropertyFromPoenterprise(object
                        .getPoenterprise());
                entobj.setLastusedate(new Date(System.currentTimeMillis()));
                appenterpriseManager.saveObject(entobj);
                object.getPoenterprise().setEnterpriseid(id);
            } else {// 列表选择方式选择当事人;
                Appenterprise entobj = appenterpriseManager
                        .getObjectById(entid);
                entobj.copyNotNullPropertyFromPoenterprise(object
                        .getPoenterprise());
                entobj.setLastusedate(new Date(System.currentTimeMillis()));
                appenterpriseManager.saveObject(entobj);
                object.getPoenterprise().setEnterpriseid(entid);
            }
            poentobject.setEnterpriseid(poenterpriseMag
                    .generateNextEnterpriseId());
            Map<String, Object> filtermap = new HashMap<String, Object>();
            filtermap.put("punishobjectid", object.getPunishobjectid());
            List<Poenterprise> endlist = this.poenterpriseMag
                    .listObjects(filtermap);
            for (Poenterprise o : endlist) {
                this.poenterpriseMag.deleteObject(o);
            }
            poentobject.copyNotNullProperty(object.getPoenterprise());
            poentobject.setPunishobjectid(object.getPunishobjectid());
            poenterpriseMag.saveObject(poentobject);
        }

    }

    private String punishamout;
    private String otherpunish;
    private String discussresult;

    public String getPunishamout() {
        return punishamout;
    }

    public void setPunishamout(String punishamout) {
        this.punishamout = punishamout;
    }

    public String getOtherpunish() {
        return otherpunish;
    }

    public void setOtherpunish(String otherpunish) {
        this.otherpunish = otherpunish;
    }

    public void setPofinishbasicManager(
            PofinishbasicManager pofinishbasicManager) {
        this.pofinishbasicManager = pofinishbasicManager;
    }

    public String getDiscussresult() {
        return discussresult;
    }

    public void setDiscussresult(String discussresult) {
        this.discussresult = discussresult;
    }

    /**
     * 选择现场处罚自由裁量
     * 
     * @return
     */

    public String seldegreefacilitydes() {
        String degreeno = request.getParameter("degreeno");
        request.setAttribute("degreeno", degreeno);
        object.setIssurpass(Long.parseLong("0"));
        this.potranslawbasicManager.updatePOTransLawBasic(
                object.getPunishobjectid(), object.getItem_id(), degreeno);
        punishamout = this.potranslawbasicManager.getPunishAmout(
                object.getPunishobjectid(), object.getItem_id());
        discussresult = this.poindagaterepbasicManager.getIndagateRepResult(
                object.getPunishobjectid(), object.getItem_id());
        otherpunish = this.potranslawbasicManager.getOtherPunish(
                object.getPunishobjectid(), object.getItem_id());
        return refreshfacilitydes();
    }

    /**
     * 现场处罚处罚决定
     * 
     * @return
     */
    public String savefreeumpire() {
        String degreeno = request.getParameter("degreeno");
        request.setAttribute("degreeno", degreeno);
        String selfreeumpire = request.getParameter("selfreeumpire");
        String freeUmpire[] = selfreeumpire.split(",");
        if (!StringUtils.isBlank(degreeno)) {
            Long version = null;
            if (object.getVersion() != null) {
                version = Long.parseLong(object.getVersion());
            }
            String issurpass = this.potranslawbasicManager.isSurpassFreeUmpire(
                    object.getItem_id(), version, degreeno, freeUmpire);
            object.setIssurpass(Long.parseLong(issurpass));

        } else {
            object.setIssurpass(Long.parseLong("0"));
        }
        this.potranslawbasicManager.updatePunishBasic(
                object.getPunishobjectid(), object.getItem_id(), freeUmpire,
                degreeno);
        punishamout = this.potranslawbasicManager.getPunishAmout(
                object.getPunishobjectid(), object.getItem_id());
        discussresult = this.poindagaterepbasicManager.getIndagateRepResult(
                object.getPunishobjectid(), object.getItem_id());
        otherpunish = this.potranslawbasicManager.getOtherPunish(
                object.getPunishobjectid(), object.getItem_id());
        return refreshfacilitydes();
    }

    /**
     * 如果下一步骤含本人，直接进入下一步骤； 如果不含本人，提示办理完毕，返回待办件列表
     */
    public String nextStep() {

        NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId);
        FlowInstance inst = super.getFlowManager().getFlowInstance(
                nit.getFlowInstId());

        long nextNodeInstId = 0l;
        for (NodeInstance nodeInst : inst.getActiveNodeInstances()) {
            String url = super.getFlowManager().getNodeOptUrl(
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
    }

    /*************************************************
    */
    public void setPunishobjectbasicMag(
            PunishobjectbasicManager punishobjectbasicMag) {
        this.punishobjectbasicMag = punishobjectbasicMag;
    }

    public void setPoenterpriseMag(PoenterpriseManager poenterpriseMag) {
        this.poenterpriseMag = poenterpriseMag;
    }

    public void setPoindividualMag(PoindividualManager poindividualMag) {
        this.poindividualMag = poindividualMag;
    }

    public void setPoindividualManager(PoindividualManager poindividualMag) {
        this.poindividualMag = poindividualMag;
    }

    public void setPoenterpriseManager(PoenterpriseManager poenterpriseMag) {
        this.poenterpriseMag = poenterpriseMag;
    }

    public void setPunishobjectbasicManager(PunishobjectbasicManager basemgr) {
        punishobjectbasicMag = basemgr;
        this.setBaseEntityManager(punishobjectbasicMag);
    }

    public OptProcInfo getOpi() {
        return opi;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public void setOpi(OptProcInfo opi) {
        this.opi = opi;
    }

    public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    public void setReghour(String reghour) {
        this.reghour = reghour;
    }

    public void setRegmin(String regmin) {
        this.regmin = regmin;
    }

    public String getReghour() {
        return reghour;
    }

    public String getRegmin() {
        return regmin;
    }

    public String getNextOptUrl() {
        return nextOptUrl;
    }

    public void setNextOptUrl(String nextOptUrl) {
        this.nextOptUrl = nextOptUrl;
    }

    public void setPotranslawbasicManager(
            PotranslawbasicManager potranslawbasicManager) {
        this.potranslawbasicManager = potranslawbasicManager;
    }

    public void setPoregisterbasicManager(
            PoregisterbasicManager poregisterbasicManager) {
        this.poregisterbasicManager = poregisterbasicManager;
    }

    public void setPoindagaterepbasicManager(
            PoindagaterepbasicManager poindagaterepbasicManager) {
        this.poindagaterepbasicManager = poindagaterepbasicManager;
    }

    public void setPcfreeumpiretypeManager(
            PcfreeumpiretypeManager pcfreeumpiretypeManager) {
        this.pcfreeumpiretypeManager = pcfreeumpiretypeManager;
    }

    public void setPoacceptinfoManager(PoacceptinfoManager poacceptinfoManager) {
        this.poacceptinfoManager = poacceptinfoManager;
    }

    public void setPodecisioninfoManager(
            PodecisioninfoManager podecisioninfoManager) {
        this.podecisioninfoManager = podecisioninfoManager;
    }

    public String getFlagFrame() {
        return flagFrame;
    }

    public void setFlagFrame(String flagFrame) {
        this.flagFrame = flagFrame;
    }

    public void setVsuppowerinusingManager(
            VsuppowerinusingManager vsuppowerinusingManager) {
        this.vsuppowerinusingManager = vsuppowerinusingManager;
    }

    public void setPodiscussbasicManager(
            PodiscussbasicManager podiscussbasicManager) {
        this.podiscussbasicManager = podiscussbasicManager;
    }

    public Vsuppowerinusing getVsuppowerinusing() {
        return vsuppowerinusing;
    }

    public void setVsuppowerinusing(Vsuppowerinusing vsuppowerinusing) {
        this.vsuppowerinusing = vsuppowerinusing;
    }

    public String getIsJD() {
        return isJD;
    }

    public void setIsJD(String isJD) {
        this.isJD = isJD;
    }

    public Pcfreeumpiredegree getFreeUmpireDegree() {
        return freeUmpireDegree;
    }

    public void setFreeUmpireDegree(Pcfreeumpiredegree freeUmpireDegree) {
        this.freeUmpireDegree = freeUmpireDegree;
    }

    public Pofinishbasic getFinishBasic() {
        return finishBasic;
    }

    public void setFinishBasic(Pofinishbasic finishBasic) {
        this.finishBasic = finishBasic;
    }

    public VOrgSupPower getVorgsuppower() {
        return vorgsuppower;
    }

    public void setVorgsuppower(VOrgSupPower vorgsuppower) {
        this.vorgsuppower = vorgsuppower;
    }

}
