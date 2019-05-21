package com.centit.powerruntime.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.page.OptJspInfo;
import com.centit.powerruntime.po.GeneralModuleParam;
import com.centit.powerruntime.po.OptApplyInfo;
import com.centit.powerruntime.po.OptApplyInfoNet;
import com.centit.powerruntime.po.OptApplyReturn;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptBaseInfoNet;
import com.centit.powerruntime.po.OptExpressMessage;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.po.OptStuffInfoNet;
import com.centit.powerruntime.po.OptWritdef;
import com.centit.powerruntime.po.PowerOptInfo;
import com.centit.powerruntime.po.VOptApplyInfoNet;
import com.centit.powerruntime.service.GeneralModuleParamManager;
import com.centit.powerruntime.service.OptApplyManager;
import com.centit.powerruntime.service.OptApplyNetManager;
import com.centit.powerruntime.service.OptBaseInfoManager;
import com.centit.powerruntime.service.OptBaseInfoNetManager;
import com.centit.powerruntime.service.OptExpressMessageManager;
import com.centit.powerruntime.service.OptProcInfoManager;
import com.centit.powerruntime.service.OptSendMessageManager;
import com.centit.powerruntime.service.OptStuffInfoManager;
import com.centit.powerruntime.service.OptStuffInfoNetManager;
import com.centit.powerruntime.service.OptWritdefManager;
import com.centit.powerruntime.service.PowerOptInfoManager;
import com.centit.powerruntime.service.RiskInfoManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.po.VUserUnits;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.FunctionManager;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.sample.optmodel.BaseWFEntityAction;
import com.ibm.icu.math.BigDecimal;

/**
 * 航道局行政许可
 * 
 * @author ljy
 * @create 2012-8-31
 * @version
 */
public class OptApplyNetAction extends BaseWFEntityAction<OptApplyInfoNet>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    private OptApplyManager optApplyManager;
    private OptApplyNetManager optApplyNetManager;
    private FunctionManager functionManager;
    private String optId;
    private String flowCode;
    private OptJspInfo jspInfo;
    private OptBaseInfoManager optBaseInfoManager;
    private OptBaseInfoNetManager optBaseInfoNetManager;
    private OptExpressMessageManager optExpressMessageManager;
    private String moduleCode;
    private String documentTemplateIds;

    private OptStuffInfoNetManager optStuffInfoNetManager;

    public String getDocumentTemplateIds() {
        return documentTemplateIds;
    }

    public void setDocumentTemplateIds(String documentTemplateIds) {
        this.documentTemplateIds = documentTemplateIds;
    }

    public void setOptExpressMessageManager(
            OptExpressMessageManager optExpressMessageManager) {
        this.optExpressMessageManager = optExpressMessageManager;
    }

    private GeneralModuleParam moduleParam;
    private OptProcInfoManager optProcInfoManager;
    private List<VOptApplyInfoNet> srPermitApplyList;
    private SysUserManager sysUserManager;
    private RiskInfoManager riskInfoManager;
    private String optBaseInfoJson;
    private SuppowerManager suppowerManager;
    private PowerOptInfoManager powerOptInfoManager;
    private PowerOptInfo powerOptInfo = null;
    private OptWritdefManager optWritdefManager;
    private GeneralModuleParamManager generalModuleParamMag;
    private List<FUnitinfo> unitList;

    private OptStuffInfoManager optStuffInfoManager;

    public OptStuffInfoManager getOptStuffInfoManager() {
        return optStuffInfoManager;
    }

    public void setOptStuffInfoManager(OptStuffInfoManager optStuffInfoManager) {
        this.optStuffInfoManager = optStuffInfoManager;
    }

    public OptApplyNetManager getOptApplyNetManager() {
        return optApplyNetManager;
    }

    public void setOptApplyNetManager(OptApplyNetManager optApplyNetManager) {
        this.optApplyNetManager = optApplyNetManager;
    }

    public OptBaseInfoNetManager getOptBaseInfoNetManager() {
        return optBaseInfoNetManager;
    }

    public void setOptBaseInfoNetManager(
            OptBaseInfoNetManager optBaseInfoNetManager) {
        this.optBaseInfoNetManager = optBaseInfoNetManager;
    }

    public OptStuffInfoNetManager getOptStuffInfoNetManager() {
        return optStuffInfoNetManager;
    }

    public void setOptStuffInfoNetManager(
            OptStuffInfoNetManager optStuffInfoNetManager) {
        this.optStuffInfoNetManager = optStuffInfoNetManager;
    }

    public FunctionManager getFunctionManager() {
        return functionManager;
    }

    public OptBaseInfoManager getOptBaseInfoManager() {
        return optBaseInfoManager;
    }

    public OptProcInfoManager getOptProcInfoManager() {
        return optProcInfoManager;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public RiskInfoManager getRiskInfoManager() {
        return riskInfoManager;
    }

    public SuppowerManager getSuppowerManager() {
        return suppowerManager;
    }

    public PowerOptInfoManager getPowerOptInfoManager() {
        return powerOptInfoManager;
    }

    public OptWritdefManager getOptWritdefManager() {
        return optWritdefManager;
    }

    public GeneralModuleParamManager getGeneralModuleParamMag() {
        return generalModuleParamMag;
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
    }

    public void setOptApplyManager(OptApplyManager optApplyManager) {
        this.optApplyManager = optApplyManager;
    }

    public String getIpAddr() {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 保存基础业务数据:行政许可业务数据\行政基础信息表\7类申请事项
     * 
     * @return
     */
    /*
     * private String proposerPaperTypes;
     * 
     * public String savePermitReg() { try {
     * 
     * OptBaseInfo optBaseInfo = object.getOptBaseInfo(); OptBaseInfo baseInfo =
     * optBaseInfoManager.getObjectById(object .getDjId());
     * 
     * if (baseInfo == null) { optBaseInfo.setDjId(object.getDjId());
     * optBaseInfo.setFlowInstId(super.getFlowInstId()); if
     * (optBaseInfo.getFlowInstId() == null ||
     * "".equals(optBaseInfo.getFlowInstId())) { optBaseInfo.setBizstate("F"); }
     * optBaseInfo.setCreatedate(new Date(System.currentTimeMillis()));
     * optBaseInfo.setCreateuser(((FUserDetail) getLoginUser()) .getUsercode());
     * // optBaseInfo.setBizstate("N"); // object.setDjId(djId);
     * 
     * } else { OptApplyInfo applyInfo = optApplyManager
     * .getObjectById(object.getDjId());
     * optApplyManager.copyObjectNotNullProperty(applyInfo, object); object =
     * applyInfo; optBaseInfoManager.copyObjectNotNullProperty(baseInfo,
     * optBaseInfo); optBaseInfo = baseInfo; } object.setBookDate(new
     * Date(System.currentTimeMillis()));// 设置申请登记时间（当前系统时间） if
     * ("02".equals(object.getProposerType())) {
     * object.setProposerPaperType(proposerPaperTypes);// 区别页面自然人和法人重名 } if
     * (StringUtils.isBlank(optBaseInfo.getCaseNo())) { //
     * 保存案号：根据权力类型从格式文书案号管理处取出对应的文书格式。 OptWritdef owf =
     * optWritdefManager.getObjectByTempType("1");// 1:许可类 String caseNo = "";
     * if (owf != null) { caseNo =
     * this.getWritCodeByWritcodemodel(owf.getWritcode()); }
     * optBaseInfo.setCaseNo(caseNo); } optBaseInfo.setRemoteAddr(getIpAddr());
     * optApplyManager.saveObject(object);
     * optBaseInfoManager.saveObject(optBaseInfo);
     * 
     * } catch (Exception e) { log.error(e.getMessage()); e.printStackTrace(); }
     * return this.edit();// }
     */
    /**
     * 根据文书模版格式组装返回文书案号
     * 
     * @param writcodemodel
     * @return
     */
    private String getWritCodeByWritcodemodel(String writcodemodel) {
        String writCode = "";
        if (StringUtils.isNotBlank(writcodemodel)) {
            StringBuffer sb = new StringBuffer();

            writCode = writcodemodel;

            String codemodelLike = "";// 用于查询
            if (writCode.indexOf("$year$") != -1) {
                int first = writCode.indexOf("$year$");
                sb.append(writCode.substring(0, first));
                sb.append(DatetimeOpt.convertDateToString(
                        new Date(System.currentTimeMillis()), "").substring(0,
                        4));
                sb.append(writCode.substring(first + 6, writCode.length()));
                writCode = sb.toString();
                sb.delete(0, sb.length());
            }
            if (writCode.indexOf("$Y2$") != -1) {
                int first = writCode.indexOf("$Y2$");
                sb.append(writCode.substring(0, first));
                sb.append(DatetimeOpt
                        .convertDateToString(
                                new Date(System.currentTimeMillis()), "")
                        .substring(0, 4).substring(2));
                sb.append(writCode.substring(first + 4, writCode.length()));
                writCode = sb.toString();
                sb.delete(0, sb.length());
            }

            if (writCode.indexOf("$N") != -1) {
                int firstBegin = writCode.indexOf("$N");
                int firstEnd = firstBegin + 2;
                int secondBegin = writCode.indexOf("$", firstEnd);
                int nunber = Integer.parseInt(writCode.substring(firstEnd,
                        secondBegin));
                sb.append(writCode.substring(0, firstBegin));
                String zero = "";
                String model = "";
                for (int i = 0; i < nunber; i++) {
                    if (StringUtils.isBlank(model)) {
                        model = "_";
                    } else {
                        model = model + "_";
                    }
                    if (StringUtils.isBlank(zero)) {
                        zero = "0";
                    } else {
                        zero = zero + "0";
                    }
                }
                codemodelLike = sb.toString();
                // String codeModel = sb.toString()+ model+
                // writCode.substring(secondBegin + 1, writCode.length());
                int index = optBaseInfoManager.getNumOfsameModel(
                        codemodelLike,
                        DatetimeOpt.convertDateToString(
                                new Date(System.currentTimeMillis()), "")
                                .substring(0, 4)) + 1;
                sb.append(this.endReplace(zero, String.valueOf(index))).append(
                        writCode.substring(secondBegin + 1, writCode.length()));
                writCode = sb.toString();
            }

        }
        return writCode;

    }

    private String endReplace(String str, String replace) {
        return replace == null || str == null ? str : str.substring(0,
                str.length() - replace.length())
                + replace;
    }

    /**
     * 保存并提交基础业务数据:行政许可业务数据\行政基础信息表\7类申请事项
     * 
     * @return
     */
    public String saveAndSubmitPermit() {

        /*
         * OptBaseInfo optBaseInfo = object.getOptBaseInfo(); if
         * (optBaseInfo.getFlowInstId() == null ||
         * "".equals(optBaseInfo.getFlowInstId())) { FUserDetail fuser =
         * ((FUserDetail) getLoginUser());
         * 
         * flowCode = suppowerManager.getFlowCodeByOrgItem(
         * optBaseInfo.getPowerid(), fuser.getPrimaryUnit());
         * 
         * FlowInstance flowInst = flowEngine.createInstance(flowCode,
         * optBaseInfo.getTransaffairname(), optBaseInfo.getTransAffairNo(),
         * fuser.getUsercode(), fuser.getPrimaryUnit()); long flowInstId =
         * flowInst.getFlowInstId(); long nodeInstId =
         * flowInst.getFirstNodeInstance().getNodeInstId(); //
         * object.setFlowInstId(flowInstId); this.setFlowInstId(flowInstId);
         * curNodeInstId = nodeInstId;
         * 
         * object.getOptBaseInfo().setFlowInstId(flowInstId);
         * optBaseInfo.setBizstate("W"); } String itemType =
         * request.getParameter("s_itemType"); object.setItemType(itemType);
         * //savePermitReg(); saveIdeaInfo();
         */
        return "refreshTasks";
    }

    /**
     * 权力许可通用业务框架属性
     * 
     * @return
     */
    public String generalOpt() {
        String itemType = request.getParameter("s_itemType");
        OptBaseInfo optBaseInfo = optBaseInfoManager.getOptBaseByFlowId(super
                .getFlowInstId());
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        String username = loginInfo.getUsername();
        optBaseInfoJson = optApplyManager.getJSONDocumentNames(
                optBaseInfo.getDjId(), username).toString();
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        OptHtmlFrameInfo transFrameInfo = new OptHtmlFrameInfo();
        transFrameInfo.setFrameId("transFrame");
        // if("SFQR".endsWith(moduleCode)){
        // transFrameInfo
        // .setFrameSrc("/powerruntime/generalOperator!doSfOpt.do?djId="
        // + optBaseInfo.getDjId() + "&flowInstId="
        // + getFlowInstId() + "&nodeInstId=" + getNodeInstId()
        // + "&moduleCode=" + moduleCode + "&documentTemplateIds="
        // + documentTemplateIds+"&s_itemType="+itemType);
        // }else{
        transFrameInfo
                .setFrameSrc("/powerruntime/generalOperator!doOpt.do?djId="
                        + optBaseInfo.getDjId() + "&flowInstId="
                        + getFlowInstId() + "&nodeInstId=" + getNodeInstId()
                        + "&moduleCode=" + moduleCode + "&documentTemplateIds="
                        + documentTemplateIds + "&s_itemType=" + itemType);
        // }
        // 将配置信息放在主框架上
        moduleParam = generalModuleParamMag.getObjectById(moduleCode);

        transFrameInfo.setFrameHeight("220px");

        frameList.add(transFrameInfo);

        // frameList.add(getViewFrame(optBaseInfo.getDjId()));

        frameList.add(GeneralOperatorAction.getIdeaListFrame(optBaseInfo
                .getDjId()));

        frameList.add(GeneralOperatorAction.getStuffListFrame(optBaseInfo
                .getDjId()));

        jspInfo = new OptJspInfo();
        jspInfo.setTitle("许可登记办理");
        jspInfo.setFrameList(frameList);

        return "optframe";
    }

    public String saveBaseInfoOfRisk() {

        return "";
    }

    /**
     * 行政许可登记加载
     * 
     * @return
     */
    public String permitReg() {
        return "permitReg";
    }

    private SysUnitManager sysUnitManager;
    private String unitsJson;
    private String parentunit;

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    public String getParentunit() {
        return parentunit;
    }

    public void setParentunit(String parentunit) {
        this.parentunit = parentunit;
    }

    /*************** 保存业务数据 ************************/

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public List<VOptApplyInfoNet> getSrPermitApplyList() {
        return srPermitApplyList;
    }

    public void setSrPermitApplyList(List<VOptApplyInfoNet> srPermitApplyList) {
        this.srPermitApplyList = srPermitApplyList;
    }

    public void setRiskInfoManager(RiskInfoManager riskInfoManager) {
        this.riskInfoManager = riskInfoManager;
    }

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    public void setOptBaseInfoManager(OptBaseInfoManager optBaseInfoManager) {
        this.optBaseInfoManager = optBaseInfoManager;
    }

    public void setOptProcInfoManager(OptProcInfoManager optProcInfoManager) {
        this.optProcInfoManager = optProcInfoManager;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public OptJspInfo getJspInfo() {
        return jspInfo;
    }

    public void setJspInfo(OptJspInfo jspInfo) {
        this.jspInfo = jspInfo;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public GeneralModuleParam getModuleParam() {
        return moduleParam;
    }

    public void setModuleParam(GeneralModuleParam moduleParam) {
        this.moduleParam = moduleParam;
    }

    public String getOptBaseInfoJson() {
        return optBaseInfoJson;
    }

    public void setOptBaseInfoJson(String optBaseInfoJson) {
        this.optBaseInfoJson = optBaseInfoJson;
    }

    HttpServletResponse response;

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }

    public void setPowerOptInfoManager(PowerOptInfoManager powerOptInfoManager) {
        this.powerOptInfoManager = powerOptInfoManager;
    }

    public PowerOptInfo getPowerOptInfo() {
        return powerOptInfo;
    }

    public void setPowerOptInfo(PowerOptInfo powerOptInfo) {
        this.powerOptInfo = powerOptInfo;
    }

    public void setOptWritdefManager(OptWritdefManager optWritdefManager) {
        this.optWritdefManager = optWritdefManager;
    }

    public void setGeneralModuleParamMag(
            GeneralModuleParamManager generalModuleParamMag) {
        this.generalModuleParamMag = generalModuleParamMag;
    }

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public OptApplyManager getOptApplyManager() {
        return optApplyManager;
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

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 权力许可通用业务框架属性 办件信息查看
     * 
     * @return
     */
    public String generalOptView() {

        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 查看办件业务数据信息
        frameList.add(getBizDataViewFrame(object.getNetId()));
        // 查看过程日志
        // frameList.add(GeneralOperatorAction.getIdeaListFrame(object.getNetId()));
        String caozuo = request.getParameter("caozuo");
        if (caozuo != null && caozuo.equals("shencha")) {
            frameList.add(getShenchaViewFrame(object.getNetId()));

        }
        // 查看附件
        if (!"shencha".equals(caozuo)) {
            OptHtmlFrameInfo stuffsFrameInfo = new OptHtmlFrameInfo();
            stuffsFrameInfo.setFrameId("viewStuffsFrame");
            stuffsFrameInfo
                    .setFrameSrc("/powerruntime/optApplyNet!viewListStuffNets.do?netId="
                            + object.getNetId());
            stuffsFrameInfo.setFrameHeight("300px");
            frameList.add(stuffsFrameInfo);
        }

        jspInfo = new OptJspInfo();
        // jspInfo.setTitle("许可办理查看");
        jspInfo.setFrameList(frameList);
        request.setAttribute("caozuo", request.getParameter("caozuo"));
        return "generalOptView";
    }

    public String viewListStuffNets() {
        // 展示附件页面 ，参见行权系统中的页面
        List<OptStuffInfoNet> optStuffs = optStuffInfoNetManager
                .getZwfjStuffInfo(object.getNetId());
        request.setAttribute("optStuffs", optStuffs);
        return "viewListStuffs";
    }

    @Override
    public String view() {
        // 展示基本信息页面 ，参见行权系统中的页面
        object = optApplyNetManager.getObjectById(object.getNetId());
        // request.setAttribute("optStuffs", oain);
        OptBaseInfoNet obin = optBaseInfoNetManager.getObjectById(object
                .getNetId());
        request.setAttribute("obin", obin);
        if (obin != null) {
            String temp = obin.getFormXml();
            if (temp != null && !"".equals(temp) && temp.length() > 10) {
                JSONArray jsonxml = this.xmlList(temp);
                request.setAttribute("jsonxml", jsonxml);
            }
        }
        return "view";
    }

    /**
     * 解析xml文件
     * 
     * @param temp
     * @return
     */
    public JSONArray xmlList(String temp) {
        JSONArray jsonArray = new JSONArray();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(temp);
            Element root = doc.getRootElement();
            Iterator iter = root.elementIterator("DATA");
            while (iter.hasNext()) {
                JSONObject jsonObject = new JSONObject();
                Element ele = (Element) iter.next();
                String key = ele.elementTextTrim("KEY");
                String name = ele.elementTextTrim("NAME");
                String value = ele.elementTextTrim("VALUE");
                String valueName = ele.elementTextTrim("VALUENAME");
                jsonObject.put("key", key);
                jsonObject.put("name", name);
                if (value == null || value.equals("null")) {
                    jsonObject.put("value", "");
                } else {
                    jsonObject.put("value", value);
                }
                if (valueName == null || valueName.equals("null")) {
                    jsonObject.put("valueName", "");
                } else {
                    jsonObject.put("valueName", valueName);
                }
                jsonArray.add(jsonObject);
            }
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonArray;
    }

    public String shencha() {
        /*
         * // 展示基本信息页面 ，参见行权系统中的页面 object =
         * optApplyNetManager.getObjectById(object.getNetId()); //
         * request.setAttribute("optStuffs", oain); OptBaseInfoNet
         * obin=optBaseInfoNetManager.getObjectById(object.getNetId());
         * request.setAttribute("obin", obin);
         */
        OptBaseInfoNet optBaseInfoNet = optBaseInfoNetManager
                .getObjectById(object.getNetId());
        String groupid = "";
        if (powerOptInfoManager.getObjectByItemID(optBaseInfoNet.getPowerid()) != null) {
            groupid = powerOptInfoManager.getObjectByItemID(
                    optBaseInfoNet.getPowerid()).getGroup_id();
        }
        request.setAttribute("groupid", groupid);
        return "shencha";
    }

    /**
     * 办件业务数据查看
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getBizDataViewFrame(String netid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewFrame");
        /*
         * viewFrameInfo .setFrameSrc("/wwd/srPermitApply!viewItem.do?djId=" +
         * djid);
         */
        viewFrameInfo.setFrameSrc("/powerruntime/optApplyNet!view.do?netId="
                + netid);
        viewFrameInfo.setFrameHeight("700px");
        return viewFrameInfo;
    }

    private OptHtmlFrameInfo getShenchaViewFrame(String netid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewshenchaFrame");
        /*
         * viewFrameInfo .setFrameSrc("/wwd/srPermitApply!viewItem.do?djId=" +
         * djid);
         */
        viewFrameInfo.setFrameSrc("/powerruntime/optApplyNet!shencha.do?netId="
                + netid);
        viewFrameInfo.setFrameHeight("700px");
        return viewFrameInfo;
    }

    @SuppressWarnings("unchecked")
    public String list() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // filterMap.put("NP_delete","1" );
            if (!"true".equals(filterMap.get("queryUnderUnit"))
                    && (filterMap.get("orgcode") == null || filterMap.get(
                            "orgcode").equals(""))) {
                filterMap.put("orgcode", null);
            }

           /* if ("true".equals(filterMap.get("NP_delete"))) {
                filterMap.put("NP_delete", "");
            } else {
                filterMap.put("NP_delete", "1");
            }*/
            // 增加登陆人所在部门的orgcode条件进入条件集
            if(!"admin".equals(fuser.getUsername())){
            	filterMap.put("orgcode1", dept.getUnitcode());
            }
            
            filterMap.put("bizstate", "F");
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);

            srPermitApplyList = optApplyNetManager.listOptApplyInfoNet(
                    filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();

            // unitList = sysUnitManager.getAllSubUnits(dept.getUnitcode());
            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    @SuppressWarnings("unchecked")
    public String showlist() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // filterMap.put("NP_delete","1" );
            if (!"true".equals(filterMap.get("queryUnderUnit"))
                    && (filterMap.get("orgcode") == null || filterMap.get(
                            "orgcode").equals(""))) {
                filterMap.put("orgcode", null);
            }

           /* if ("true".equals(filterMap.get("NP_delete"))) {
                filterMap.put("NP_delete", "");
            } else {
                filterMap.put("NP_delete", "1");
            }*/
            // 增加登陆人所在部门的orgcode条件进入条件集
            if(!"admin".equals(fuser.getUsername())){
                filterMap.put("orgcode1", dept.getUnitcode());
            }
            
            filterMap.put("bizstate", "T");
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);

            srPermitApplyList = optApplyNetManager.listOptApplyInfoNet(
                    filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();

            // unitList = sysUnitManager.getAllSubUnits(dept.getUnitcode());
            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            return "showlist";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    @SuppressWarnings("unchecked")
    public String cityList(){
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            // filterMap.put("NP_delete","1" );
            if (!"true".equals(filterMap.get("queryUnderUnit"))
                    && (filterMap.get("orgcode") == null || filterMap.get(
                            "orgcode").equals(""))) {
                filterMap.put("orgcode", null);
            }

            if ("true".equals(filterMap.get("NP_delete"))) {
                filterMap.put("NP_delete", "");
            } else {
                filterMap.put("NP_delete", "1");
            }
            // 增加登陆人所在部门的orgcode条件进入条件集
            filterMap.put("orgcode1", dept.getUnitcode());

            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);

            srPermitApplyList = optApplyNetManager.listOptApplyInfoNet(
                    filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();

            // unitList = sysUnitManager.getAllSubUnits(dept.getUnitcode());
            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

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
    public static boolean downFile(String url, int port, String username, String password, String fileName,
            String fileUrl, HttpServletResponse response) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(url, port);
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.changeWorkingDirectory(fileUrl);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    InputStream in = ftp.retrieveFileStream(ff.getName());
                    response.setContentLength((int) ff.getSize());
                    response.setContentType("application/octet-stream; charset=GBK");
                    response.setHeader("Content-Disposition",
                            "attachment;filename=".concat(new String(ff.getName().getBytes("GB2312"), "ISO-8859-1")));
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
            success = true;
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
        return success;
    }

    /**
     * 附件下载功能
     * 
     * @return
     * @throws IOException
     */
    public String downStuffInfo() throws IOException {
        OptStuffInfoNet stuffInfoNet = optStuffInfoNetManager
                .getObjectById(request.getParameter("stuffid"));
        String fileUrl = "";
        String fn = stuffInfoNet.getFilename();
        try {
            if (stuffInfoNet.getStuffcontent() == null) {// 进行ftp判断
                if (!StringUtils.isBlank(stuffInfoNet.getFileUrl())) {
                    if (stuffInfoNet != null) {
                        filename = stuffInfoNet.getFilename();
                        fileUrl = "/" + stuffInfoNet.getNetId() + "/" + stuffInfoNet.getGroupid()
                        + stuffInfoNet.getSortId() + "/";
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
            if (stuffInfoNet.getStuffcontent() != null) {
                InputStream inputStream = new ByteArrayInputStream(
                        stuffInfoNet.getStuffcontent());
                this.setStuffStream(inputStream);
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }

        this.setFilename(new String(fn.getBytes("GBK"), "ISO8859-1"));
        return "download";

    }

    protected void postAlertMessage(String msg, HttpServletResponse response) {

        String alertCoding = "GBK";

        ServletOutputStream sos;
        String str = "<script language=\"JavaScript\""
                + " type=\"text/JavaScript\" charset=\"" + alertCoding + "\">"
                + "javascript:alert('" + msg + "');history.back(-1);"
                + " </script>";

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

    public String byshouli() {

        OptBaseInfoNet obin = optBaseInfoNetManager.getObjectById(object
                .getNetId());

        // 办理意见
        String blyj = request.getParameter("blyj");
        // java : 字符解码
        try {
            blyj = java.net.URLDecoder.decode(blyj, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        obin.setBizstate("W");
        obin.setYslblyj(blyj);
        optBaseInfoNetManager.saveObject(obin);
        optBaseInfoNetManager.saveObject(obin);
        OptApplyReturn appret = new OptApplyReturn();
        appret.setCaseNo(obin.getCaseNo());
        appret.setDjId(obin.getNetId());
        appret.setIsaccpet("0");
        appret.setIsTotal("0");
        appret.setNetId("0");
        String orgCode = obin.getOrgcode();
        if(!"".equals(orgCode)&& null!= orgCode){
            FUnitinfo unitInfo = sysUnitManager.getObjectById(orgCode);
            if(unitInfo != null)
                appret.setOrgCode(unitInfo.getDepno());
        }else
            appret.setOrgCode(obin.getOrgcode());
        appret.setOrgName(obin.getOrgname());
        appret.setPowerId(obin.getPowerid());
        appret.setPowerName(obin.getPowername());
        appret.setSign("");
        appret.setSlyj(blyj);
        appret.setSyncDate(new Date());
        appret.setSyncErrorDesc("");
        appret.setTransaffairName(obin.getTransaffairname());
        appret.setUpdateDate(new Date());
        optApplyNetManager.insertOptApplyReturn(appret);
        // 判断从“一张网”中有EMS信息，将相关dj_id与EMS信息进行联系。
        OptExpressMessage optExpressMessage = optExpressMessageManager
                .getObjectById(appret.getDjId());
        if (null != optExpressMessage) {
            optExpressMessage.setDjid(appret.getNetId());
            optExpressMessageManager.saveObject(optExpressMessage);
        }
        return "refreshlist";
    }

    public String buzheng() {

        OptBaseInfoNet obin = optBaseInfoNetManager.getObjectById(object
                .getNetId());

        // 办理意见
        String blyj = request.getParameter("blyj");
        // java : 字符解码
        try {
            blyj = java.net.URLDecoder.decode(blyj, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        obin.setBizstate("W");
        obin.setYslblyj(blyj);
        optBaseInfoNetManager.saveObject(obin);
        optBaseInfoNetManager.saveObject(obin);
        OptApplyReturn appret = new OptApplyReturn();
        appret.setCaseNo(obin.getCaseNo());
        appret.setDjId(obin.getNetId());
        appret.setIsaccpet("4");
        appret.setIsTotal("0");
        appret.setNetId("0");
        String orgCode = obin.getOrgcode();
        if(!"".equals(orgCode)&& null!= orgCode){
            FUnitinfo unitInfo = sysUnitManager.getObjectById(orgCode);
            if(unitInfo != null)
                appret.setOrgCode(unitInfo.getDepno());
        }else
            appret.setOrgCode(obin.getOrgcode());
        appret.setOrgName(obin.getOrgname());
        appret.setPowerId(obin.getPowerid());
        appret.setPowerName(obin.getPowername());
        appret.setSign("");
        appret.setSlyj(blyj);
        appret.setSyncDate(new Date());
        appret.setSyncErrorDesc("");
        appret.setTransaffairName(obin.getTransaffairname());
        appret.setUpdateDate(new Date());
        optApplyNetManager.insertOptApplyReturn(appret);
        return "refreshlist";
    }

    @SuppressWarnings("null")
    public String shouli() {
        String netId = request.getParameter("netId");
        System.out.println(netId + object.getNetId());
        // 办理意见
        String blyj = request.getParameter("blyj");
        // java : 字符解码
        try {
            blyj = java.net.URLDecoder.decode(blyj, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        OptBaseInfoNet obin = optBaseInfoNetManager.getObjectById(netId);
        OptApplyInfoNet oain = optApplyNetManager.getObjectById(netId);
        String djId = optApplyManager.generateNextDjId();
        obin.setBizstate("T");
        obin.setYslblyj(blyj);
        obin.setDjId(djId);
        oain.setDjId(djId);
        if (obin.getTransAffairNo() == null) {
            String temp = CodeRepositoryUtil.getValue("DBBM", "DBBM");
            if (temp != null || !"".equals(temp) || temp.length() > 6) {
                temp = "W" + temp.substring(0, 6) + "-";
            } else {
                temp = "WJS9999-";
            }
            obin.setTransAffairNo(temp
                    + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(
                            System.currentTimeMillis())));
        }
        optApplyNetManager.saveObject(oain);
        optBaseInfoNetManager.saveObject(obin);
        OptApplyReturn appret = new OptApplyReturn();
        appret.setCaseNo(obin.getCaseNo());
        appret.setDjId(netId);
        appret.setIsaccpet("1");
        appret.setIsTotal("0");
        appret.setNetId(djId);
        String orgCode = obin.getOrgcode();
        if(!"".equals(orgCode)&& null!= orgCode){
            FUnitinfo unitInfo = sysUnitManager.getObjectById(orgCode);
            if(unitInfo != null)
                appret.setOrgCode(unitInfo.getDepno());
        }else
            appret.setOrgCode(obin.getOrgcode());
        appret.setOrgName(obin.getOrgname());
        appret.setPowerId(obin.getPowerid());
        appret.setPowerName(obin.getPowername());
        appret.setSign("");
        appret.setSlyj(blyj);
        appret.setSyncDate(new Date());
        appret.setSyncErrorDesc("");
        appret.setTransaffairName(obin.getTransaffairname());
        appret.setUpdateDate(new Date());
        optApplyNetManager.insertOptApplyReturn(appret);
        OptBaseInfo baseInfo = optBaseInfoManager.getObjectById(djId);

        if (baseInfo == null) {
            baseInfo = new OptBaseInfo();
            baseInfo.setDjId(djId);
            baseInfo.setBizstate("F");

            baseInfo.setCreatedate(new Date(System.currentTimeMillis()));
            baseInfo.setCreateuser(((FUserDetail) getLoginUser()).getUsercode());
            baseInfo.setAcceptArchiveNo(obin.getAcceptArchiveNo());
            baseInfo.setBiztype(obin.getBiztype());
            baseInfo.setOutItemId(obin.getOutItemId());
            baseInfo.setOutItemName(obin.getOutItemName());
            // baseInfo.setChargeAccount(obin.getChargeAccount());
            baseInfo.setContent(obin.getContent());
            baseInfo.setHeadunitcode(obin.getHeadunitcode());
            baseInfo.setHeadusercode(obin.getHeadusercode());
            // baseInfo.setIsUpload(obin.getIsUpload());
            baseInfo.setOptId("HDJXZXK1");
            // baseInfo.setOrgcode(sysUnitManager.getUnitCode(obin.getOrgcode()));
            baseInfo.setOrgcode(obin.getOrgcode());
            baseInfo.setOrgname(obin.getOrgname());
            // baseInfo.setPaid(obin.getPaid());
            baseInfo.setPowerid(obin.getPowerid());
            baseInfo.setPowername(obin.getPowername());
            // baseInfo.setReceivable(obin.getReceivable());
            // baseInfo.setReliefReasons(obin.getReliefReasons());

            baseInfo.setSendArchiveNo(obin.getSendArchiveNo());
            baseInfo.setTransaffairname(obin.getTransaffairname());
            baseInfo.setTransAffairNo(obin.getTransAffairNo());
            baseInfo.setTransAffairQueryKey(obin.getTransAffairQueryKey());

        }
        OptApplyInfo applyInfo = optApplyManager.getObjectById(djId);
        if (applyInfo == null) {
            applyInfo = new OptApplyInfo();
            applyInfo.setDjId(djId);
            applyInfo.setAcceptDate(new Date(System.currentTimeMillis()));
            applyInfo.setAgentAddr(oain.getAgentAddr());
            applyInfo.setAgentEmail(oain.getAgentEmail());
            applyInfo.setAgentMobile(oain.getAgentMobile());
            applyInfo.setAgentName(oain.getAgentName());
            applyInfo.setAgentPaperCode(oain.getAgentPaperCode());
            applyInfo.setOutItemId(oain.getOutItemId());
            applyInfo.setOutItemName(oain.getOutItemName());
            applyInfo.setAgentPaperType(oain.getAgentPaperType());
            applyInfo.setAgentPhone(oain.getAgentPhone());
            applyInfo.setAgentUnitcode(oain.getAgentUnitcode());
            applyInfo.setAgentZipcode(oain.getAgentZipcode());
            applyInfo.setApplyDate(new Date(System.currentTimeMillis()));
            if (oain.getApplyItemType() == null
                    || "".equals(oain.getApplyItemType())) {
                applyInfo.setApplyItemType("XK");
            } else {
                applyInfo.setApplyItemType(oain.getApplyItemType());
            }
            applyInfo.setApplyMemo(oain.getApplyMemo());
            applyInfo.setApplyReason(oain.getApplyReason());
            applyInfo.setApplyWay(oain.getApplyWay());
            applyInfo.setBookDate(new Date(System.currentTimeMillis()));
            applyInfo.setChannel_lable(oain.getChannel_lable());
            applyInfo.setCheckAddr(oain.getCheckAddr());
            applyInfo.setCheckDetail(oain.getCheckDetail());
            applyInfo.setCheckIdea(oain.getCheckIdea());
            applyInfo.setProposerAddr(oain.getProposerAddr());
            applyInfo.setProposerEmail(oain.getProposerEmail());
            applyInfo.setProposerMobile(oain.getProposerMobile());
            applyInfo.setProposerName(oain.getProposerName());
            applyInfo.setProposerPaperCode(oain.getProposerPaperCode());
            applyInfo.setProposerPaperType(oain.getProposerPaperType());
            applyInfo.setProposerPhone(oain.getProposerPhone());
            applyInfo.setProposerType(oain.getProposerType());
            applyInfo.setProposerUnitcode(oain.getProposerUnitcode());
            applyInfo.setProposerZipcode(oain.getProposerZipcode());
            applyInfo.setLegal_person(oain.getLegal_person());

        }

        if (StringUtils.isBlank(baseInfo.getCaseNo())) {
            // 保存案号：根据权力类型从格式文书案号管理处取出对应的文书格式。
            OptWritdef owf = optWritdefManager.getObjectByTempType("1");// 1:许可类
            String caseNo = "";
            if (owf != null) {
                caseNo = this.getWritCodeByWritcodemodel(owf.getWritcode());
            }
            baseInfo.setCaseNo(caseNo);
        }
        if (baseInfo.getFlowInstId() == null
                || "".equals(baseInfo.getFlowInstId())) {
            FUserDetail fuser = ((FUserDetail) getLoginUser());

            flowCode = suppowerManager.getFlowCodeByOrgItem(
                    baseInfo.getPowerid(), baseInfo.getOrgcode());

            
            FlowInstance flowInst = flowEngine.createInstance(flowCode,
                    baseInfo.getTransaffairname(), baseInfo.getTransAffairNo(),
                    fuser.getUsercode(), baseInfo.getOrgcode());
            long flowInstId = flowInst.getFlowInstId();
            long nodeInstId = flowInst.getFirstNodeInstance().getNodeInstId();
            // object.setFlowInstId(flowInstId);
            this.setFlowInstId(flowInstId);
            curNodeInstId = nodeInstId;

            baseInfo.setFlowInstId(flowInstId);
            baseInfo.setBizstate("W");
            baseInfo.setBiztype("W");
        }
        // baseInfo.setRemoteAddr(getIpAddr());
        optApplyManager.saveObject(applyInfo);
        optBaseInfoManager.saveObject(baseInfo);

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

        OptProcInfo procInfo = new OptProcInfo();
        procInfo.setNodeInstId(curNodeInstId);
        procInfo.setDjId(djId);
        procInfo.setNodename("外网预受理");
        procInfo.setTransdate(new Date(System.currentTimeMillis()));
        procInfo.setNodeinststate("N");
        procInfo.setUnitcode(loginInfo.getPrimaryUnit());
        procInfo.setUsercode(loginInfo.getUsercode());
        // procInfo.setRemoteAddr(getIpAddr());
        optProcInfoManager.saveObject(procInfo);
        optProcInfoManager.saveIdeaInfo(optIdeaInfo, procInfo);

        List<OptStuffInfoNet> osnlist = optStuffInfoNetManager
                .getZwfjStuffInfo(object.getNetId());
        if (!osnlist.isEmpty()) {

            for (OptStuffInfoNet o : osnlist) {
                OptStuffInfo oi = new OptStuffInfo();
                oi.setDjId(djId);
                oi.setStuffid(o.getStuffid());
                oi.setArchivetype(o.getArchivetype());
                oi.setFilename(o.getFilename());
                oi.setFiletype("0");
                oi.setFileUrl(o.getFileUrl());
                oi.setGroupid(o.getGroupid());
                // oi.setIsUpload(o.getIsUpload());
                oi.setIsuse(o.getIsuse());
                oi.setIszhi(o.getIszhi());
                oi.setNodeInstId(o.getNodeInstId());
                oi.setNodename(o.getNodename());
                // oi.setRecordid(o.getRecordid());
                oi.setSortId(o.getSortId());
                //oi.setStuffcontent(o.getStuffcontent());
                oi.setStuffid(o.getStuffid());
                oi.setStuffname(o.getStuffname());
                // oi.setWsno(o.getWsno());
                oi.setUploadtime(new Date(System.currentTimeMillis()));
                oi.setUploadusercode(((FUserDetail) getLoginUser())
                        .getUsercode());
                try {
                    optStuffInfoManager.saveObject(oi);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        // 判断从“一张网”中有EMS信息，将相关dj_id与EMS信息进行联系。
        OptExpressMessage optExpressMessage = optExpressMessageManager
                .getObjectById(appret.getDjId());
        if (null != optExpressMessage) {
            optExpressMessage.setDjid(appret.getNetId());
            optExpressMessageManager.saveObject(optExpressMessage);
        }

        return "refreshlist";
    }

}
