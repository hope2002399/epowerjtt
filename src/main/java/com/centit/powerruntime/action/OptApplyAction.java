package com.centit.powerruntime.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.extremecomponents.table.limit.Limit;

import com.centit.app.util.SqlUtil;
import com.centit.complaint.action.EpowerCommonBizAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.indicator.po.PmTemplet;
import com.centit.indicator.service.PmTempletManager;
import com.centit.powerbase.po.Suppower;
import com.centit.powerbase.po.SuppowerId;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.powerruntime.page.OptHtmlFrameInfo;
import com.centit.powerruntime.page.OptJspInfo;
import com.centit.powerruntime.po.GeneralModuleParam;
import com.centit.powerruntime.po.OptApplyInfo;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptWritdef;
import com.centit.powerruntime.po.PowerOptInfo;
import com.centit.powerruntime.po.RiskInfo;
import com.centit.powerruntime.po.VOptApplyInfo;
import com.centit.powerruntime.service.GeneralModuleParamManager;
import com.centit.powerruntime.service.OptApplyManager;
import com.centit.powerruntime.service.OptBaseInfoManager;
import com.centit.powerruntime.service.OptProcInfoManager;
import com.centit.powerruntime.service.OptWritdefManager;
import com.centit.powerruntime.service.PowerOptInfoManager;
import com.centit.powerruntime.service.RiskInfoManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.po.VUserUnits;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.FunctionManager;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.FlowInstance;
import com.opensymphony.xwork2.ActionContext;

/**
 * 航道局行政许可
 * 
 * @author ljy
 * @create 2012-8-31
 * @version
 */
public class OptApplyAction extends EpowerCommonBizAction<OptApplyInfo>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    private OptApplyManager optApplyManager;
    private FunctionManager functionManager;
    private String optId;
    private String flowCode;
    private OptJspInfo jspInfo;
    private OptBaseInfoManager optBaseInfoManager;
    private String moduleCode;
    private String documentTemplateIds;
    private PmTempletManager pmTempletManager;
    private Map<String, Object> obj = new HashMap<String, Object>();
    private String templetJsp;
    
    public Map<String, Object> getObj() {
        return obj;
    }

    public void setObj(Map<String, Object> obj) {
        this.obj = obj;
    }

    public String getTempletJsp() {
        return templetJsp;
    }

    public void setTempletJsp(String templetJsp) {
        this.templetJsp = templetJsp;
    }

    public void setPmTempletManager(PmTempletManager pmTempletManager) {
        this.pmTempletManager = pmTempletManager;
    }

    public String getDocumentTemplateIds() {
        return documentTemplateIds;
    }

    public void setDocumentTemplateIds(String documentTemplateIds) {
        this.documentTemplateIds = documentTemplateIds;
    }

    private GeneralModuleParam moduleParam;
    private OptProcInfoManager optProcInfoManager;
    private List<VOptApplyInfo> srPermitApplyList;
    private SysUserManager sysUserManager;
    private RiskInfoManager riskInfoManager;
    private String optBaseInfoJson;
    private SuppowerManager suppowerManager;
    private PowerOptInfoManager powerOptInfoManager;
    private PowerOptInfo powerOptInfo = null;
    private OptWritdefManager optWritdefManager;
    private GeneralModuleParamManager generalModuleParamMag;
    private List<FUnitinfo> unitList;

    public String delete() {

        super.delete();

        return this.list();
    }

    /**
     * 办件登记
     */
    public String edit() {

        object = optApplyManager.getObjectById(object.getDjId());
        String itemId = request.getParameter("itemId");
        
        if(object!=null){
            OptBaseInfo optBaseInfo = optBaseInfoManager.getObjectById(object
                    .getDjId());
            if(optBaseInfo!=null)
            if(StringUtils.isNotBlank(optBaseInfo.getPowerid())){
                itemId=optBaseInfo.getPowerid();
            }
        }
      //自定义表单
        PmTemplet pmtempl = pmTempletManager.getVersionTemplet(itemId);
        if(pmtempl!=null){
            templetJsp = pmTempletManager.getJspFileName(pmtempl) + "Form";
            /*request.setAttribute("templetJs", templetJsp);*/
            obj.put("templetId", pmtempl.getTempletId());
            obj.put("version", pmtempl.getVersion());
        }
        
        
        if (object != null) {
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            String username = loginInfo.getUsername();

            optBaseInfoJson = optApplyManager.getJSONDocumentNames(
                    object.getDjId(), username);
            // System.out.println(optBaseInfoJson);
            OptBaseInfo optBaseInfo = optBaseInfoManager.getObjectById(object
                    .getDjId());
            
            //取自定义表单的值
            if(StringUtils.isNotBlank(optBaseInfo.getTemplateXml())){
                pmTempletManager.paseTemplateXml(obj, optBaseInfo.getTemplateXml());
            }
            
            object.setOptBaseInfo(optBaseInfo);

            optId = optBaseInfo.getOptId();

            // 页面文书模版对应申请事项
            if (StringUtils.isNotBlank(optBaseInfo.getPowerid())) {
                // 到业务配置表里查询对应的模版编码
                powerOptInfo = powerOptInfoManager
                        .getObjectByItemID(optBaseInfo.getPowerid());
                if (powerOptInfo == null) {
                    powerOptInfo = new PowerOptInfo();
                }
            }
        } else {
            object = new OptApplyInfo();
            // 生成登记编号
            object.setDjId(optApplyManager.generateNextDjId());
            object.setApplyDate(new Date(System.currentTimeMillis()));
            OptBaseInfo optBase = new OptBaseInfo();
            optBase.setOptId(optId);
            // 生成办件编号：编号规则以JTHD打头+时间戳
            String temp = CodeRepositoryUtil.getValue("DBBM", "DBBM");
            if (temp != null || !"".equals(temp) || temp.length() > 6) {
                temp = temp.substring(0, 6) + "-";
            } else {
                temp = "JS9999-";
            }
            optBase.setTransAffairNo(temp
                    + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(
                            System.currentTimeMillis())));
            double psw = Math.random() * 9000 + 1000;
            long pws = (long) psw;
            optBase.setTransAffairQueryKey(pws + "");
            if(itemId != null && pmtempl != null) {
                Suppower suppower = suppowerManager.getObjectById(new SuppowerId(itemId, Long.parseLong(pmtempl.getVersion())));
                if(suppower != null) {
                    optBase.setPowername(suppower.getItemName());
                    optBase.setPowerid(suppower.getItemId());
                    optBase.setOrgcode(request.getParameter("orgId"));
                    optBase.setOrgname(CodeRepositoryUtil.getValue("unitcode", request.getParameter("orgId")));
                }  
            }
            object.setOptBaseInfo(optBase);
        }
        /*
         * List<SeaRouteInfo> rrList = new ArrayList<SeaRouteInfo>(); rrList =
         * seaRouteInfoManager.listObjects(); this.genSelectList(sriList,
         * rrList, 28);
         */
        // 根据业务编码，获取流程编码
        FOptinfo optInfo = functionManager.getObjectById(optId);
        if (optInfo != null) {
            flowCode = optInfo.getWfcode();
        }
        
        return EDIT;
    }

    /**
     * 查询许可登记信息
     */
    @SuppressWarnings("null")
    private void getPermitInfo() {

        object = optApplyManager.getObjectById(object.getDjId());

        if (object != null) {
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            String username = loginInfo.getUsername();

            optBaseInfoJson = optApplyManager.getJSONDocumentNames(
                    object.getDjId(), username);
            // System.out.println(optBaseInfoJson);
            OptBaseInfo optBaseInfo = optBaseInfoManager.getObjectById(object
                    .getDjId());
            object.setOptBaseInfo(optBaseInfo);

            optId = optBaseInfo.getOptId();

            // 页面文书模版对应申请事项
            if (StringUtils.isNotBlank(optBaseInfo.getPowerid())) {
                // 到业务配置表里查询对应的模版编码
                powerOptInfo = powerOptInfoManager
                        .getObjectByItemID(optBaseInfo.getPowerid());
                if (powerOptInfo == null) {
                    powerOptInfo = new PowerOptInfo();
                }
            }
        } else {
            object = new OptApplyInfo();
            // 生成登记编号
            object.setDjId(optApplyManager.generateNextDjId());
            object.setApplyDate(new Date(System.currentTimeMillis()));
            OptBaseInfo optBase = new OptBaseInfo();
            optBase.setOptId(optId);
            // 生成办件编号：编号规则以JTHD打头+时间戳
            String temp = CodeRepositoryUtil.getValue("DBBM", "DBBM");
            if (temp != null || !"".equals(temp) || temp.length() > 6) {
                temp = temp.substring(0, 6) + "-";
            } else {
                temp = "JS9999-";
            }
            optBase.setTransAffairNo(temp
                    + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(
                            System.currentTimeMillis())));
            double psw = Math.random() * 9000 + 1000;
            long pws = (long) psw;
            optBase.setTransAffairQueryKey(pws + "");
            System.out.println(pws);
            object.setOptBaseInfo(optBase);
        }
        /*
         * List<SeaRouteInfo> rrList = new ArrayList<SeaRouteInfo>(); rrList =
         * seaRouteInfoManager.listObjects(); this.genSelectList(sriList,
         * rrList, 28);
         */
        // 根据业务编码，获取流程编码
        FOptinfo optInfo = functionManager.getObjectById(optId);
        if (optInfo != null) {
            flowCode = optInfo.getWfcode();
        }
        
        /*//自定义表单
        String itemId = request.getParameter("itemId");
        PmTemplet temp = pmTempletManager.getVersionTemplet(itemId);
        if(temp!=null){
            templetJsp = pmTempletManager.getJspFileName(temp) + "Form";
            obj.put("templetId", temp.getTempletId());
            obj.put("version", temp.getVersion());
        }*/
    }

    /**
     * 保存业务数据
     * 
     * @return
     */
    public String savePermit() {

        OptBaseInfo optBaseInfo = object.getOptBaseInfo();

        OptBaseInfo baseInfo = optBaseInfoManager.getObjectById(object
                .getDjId());
        if (baseInfo == null) {
            String djId = String.valueOf(System.currentTimeMillis());
            optBaseInfo.setDjId(djId);
            optBaseInfo.setFlowInstId(super.getFlowInstId());
            optBaseInfo.setBiztype("F");
            optBaseInfo.setCreatedate(new Date(System.currentTimeMillis()));
            optBaseInfo.setCreateuser(((FUserDetail) getLoginUser())
                    .getUsercode());
            optBaseInfo.setBizstate("N");
            object.setDjId(djId);
        }
        return "";
    }

    /**
     * 保存基础业务数据:行政许可业务数据\行政基础信息表\7类申请事项
     * 
     * @return
     */
    private String proposerPaperTypes;

    public String savePermitReg() {
        try {

            OptBaseInfo optBaseInfo = object.getOptBaseInfo();
            OptBaseInfo baseInfo = optBaseInfoManager.getObjectById(object
                    .getDjId());

            if (baseInfo == null) {
                optBaseInfo.setDjId(object.getDjId());
                optBaseInfo.setFlowInstId(super.getFlowInstId());
                if (optBaseInfo.getFlowInstId() == null
                        || "".equals(optBaseInfo.getFlowInstId())) {
                    optBaseInfo.setBiztype("F");// 未提交标志
                }
                optBaseInfo.setCreatedate(new Date(System.currentTimeMillis()));
                optBaseInfo.setCreateuser(((FUserDetail) getLoginUser())
                        .getUsercode());
                optBaseInfo.setBizstate("N");
                // object.setDjId(djId);

            } else {
                OptApplyInfo applyInfo = optApplyManager.getObjectById(object
                        .getDjId());
                optApplyManager.copyObjectNotNullProperty(applyInfo, object);
                object = applyInfo;
                optBaseInfoManager.copyObjectNotNullProperty(baseInfo,
                        optBaseInfo);
                optBaseInfo = baseInfo;
            }
            object.setApplyItemType(request.getParameter("itemType"));
            object.setBookDate(new Date(System.currentTimeMillis()));// 设置申请登记时间（当前系统时间）
            if ("02".equals(object.getProposerType())) {
                object.setProposerPaperType(proposerPaperTypes);// 区别页面自然人和法人重名
            }
            if (StringUtils.isBlank(optBaseInfo.getCaseNo())) {
                // 保存案号：根据权力类型从格式文书案号管理处取出对应的文书格式。
                OptWritdef owf = optWritdefManager.getObjectByTempType("1");// 1:许可类
                String caseNo = "";
                if (owf != null) {
                    caseNo = this.getWritCodeByWritcodemodel(owf.getWritcode());
                }
                optBaseInfo.setCaseNo(caseNo);
            }
            
            
            //拼接自定义表单的数据为xml字符串
            Map<Object, Object> paramMap = SqlUtil.getRequestMap(request);
            String templetId=(String) paramMap.get("templetId");
            String templateXml="";
            if(templetId!=null&&!"".equals(templetId)){
                try{
                    //获取并拼接xml字符串
                    templateXml=pmTempletManager.getTemplateXml(paramMap,templetId);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            optBaseInfo.setTemplateXml(templateXml);
            
            
            // object.setApplyDate(new Date(System.currentTimeMillis()));
            optApplyManager.saveObject(object);
            optBaseInfoManager.saveObject(optBaseInfo);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return this.edit();//
    }

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

        OptProcInfo procInfo = new OptProcInfo();
        procInfo.setNodeInstId(curNodeInstId);
        procInfo.setDjId(object.getDjId());
        procInfo.setNodename("申请");
        procInfo.setTransdate(new Date(System.currentTimeMillis()));
        procInfo.setNodeinststate("N");
        procInfo.setUnitcode(loginInfo.getPrimaryUnit());
        procInfo.setUsercode(loginInfo.getUsercode());
        optProcInfoManager.saveObject(procInfo);
        optProcInfoManager.saveIdeaInfo(optIdeaInfo, procInfo);

    }

    /**
     * 保存并提交基础业务数据:行政许可业务数据\行政基础信息表\7类申请事项
     * 
     * @return
     */
    public String saveAndSubmitPermit() {

        OptBaseInfo optBaseInfo = object.getOptBaseInfo();
        if (optBaseInfo.getFlowInstId() == null
                || "".equals(optBaseInfo.getFlowInstId())) {
            FUserDetail fuser = ((FUserDetail) getLoginUser());

            flowCode = suppowerManager.getFlowCodeByOrgItem(
                    optBaseInfo.getPowerid(), optBaseInfo.getOrgcode());

            FlowInstance flowInst = flowEngine.createInstance(flowCode,
                    optBaseInfo.getTransaffairname(),
                    optBaseInfo.getTransAffairNo(), fuser.getUsercode(),
                    fuser.getPrimaryUnit());
            long flowInstId = flowInst.getFlowInstId();
            long nodeInstId = flowInst.getFirstNodeInstance().getNodeInstId();
            // object.setFlowInstId(flowInstId);
            this.setFlowInstId(flowInstId);
            curNodeInstId = nodeInstId;

            object.getOptBaseInfo().setFlowInstId(flowInstId);
            object.getOptBaseInfo().setBiztype("W");
        }

        savePermitReg();
        saveIdeaInfo();
        return "refreshTasks";
    }

    /**
     * 权力许可通用业务框架属性
     * 
     * @return
     */
    public String generalOpt() {
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        String username = loginInfo.getUsername();
        OptBaseInfo optBaseInfo = optBaseInfoManager.getOptBaseByFlowId(super
                .getFlowInstId());
        optBaseInfoJson = optApplyManager.getJSONDocumentNames(
                optBaseInfo.getDjId(), username);
        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();

        frameList.add(getViewFrame(optBaseInfo.getDjId()));

        frameList.add(GeneralOperatorAction.getIdeaListFrame(optBaseInfo
                .getDjId()));

        frameList.add(GeneralOperatorAction.getStuffListFrame(optBaseInfo
                .getDjId()));
        jspInfo = new OptJspInfo();
        jspInfo.setTitle("许可登记办理");
        jspInfo.setFrameList(frameList);
        OptHtmlFrameInfo transFrameInfo = new OptHtmlFrameInfo();
        transFrameInfo.setFrameId("transFrame");

        transFrameInfo
                .setFrameSrc("/powerruntime/generalOperator!doOpt.do?djId="
                        + optBaseInfo.getDjId() + "&flowInstId="
                        + getFlowInstId() + "&nodeInstId=" + getNodeInstId()
                        + "&moduleCode=" + moduleCode + "&documentTemplateIds="
                        + documentTemplateIds);

        // 将配置信息放在主框架上
        moduleParam = generalModuleParamMag.getObjectById(moduleCode);

        // transFrameInfo.setFrameHeight("220px");

        super.initFlowTime();
        System.out.println("-+++++++++++++++++++++++" + nodeName);
        frameList.add(transFrameInfo);
        return "optframe";
    }

    /**
     * 权力许可通用业务框架属性 办件信息查看
     * 
     * @return
     */
    public String generalOptView() {

        List<OptHtmlFrameInfo> frameList = new ArrayList<OptHtmlFrameInfo>();
        // 查看办件业务数据信息
        frameList.add(getBizDataViewFrame(object.getDjId()));
        // 查看过程日志
        frameList.add(GeneralOperatorAction.getIdeaListFrame(object.getDjId()));
        // 查看附件
        frameList
                .add(GeneralOperatorAction.getStuffsViewFrame(object.getDjId()));

        jspInfo = new OptJspInfo();
        // jspInfo.setTitle("许可办理查看");
        jspInfo.setFrameList(frameList);
        Long flowInstId = optBaseInfoManager.getObjectById(object.getDjId())
                .getFlowInstId();
        request.setAttribute("flowInstId", flowInstId);
        return "generalOptView";
    }

    /*
     * 
     * 查看办件以及申请者信息
     */
    private OptHtmlFrameInfo getViewFrame(String djid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewInfoFrame");
        viewFrameInfo.setFrameSrc("/powerruntime/optApply!viewInfo.do?djId="
                + djid);
        // viewFrameInfo.setFrameHeight("1175px");
        return viewFrameInfo;
    }

    public String viewInfo() {
        OptBaseInfo baseinfo = this.optBaseInfoManager.getObjectById(object
                .getDjId());
        super.view();
        if(baseinfo!=null){
            String temp = baseinfo.getFormXml();
            if(temp != null && !"".equals(temp) && temp.length()>10){
                JSONArray jsonxml = this.xmlList(temp);
                request.setAttribute("jsonxml", jsonxml);
            }
        }
        object.setOptBaseInfo(baseinfo);
        return "viewInfo";
    }
    /**
     * 解析xml文件
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
             while(iter.hasNext()){
                JSONObject jsonObject = new JSONObject();
                Element ele=(Element) iter.next();
                String key=ele.elementTextTrim("KEY");
                String name=ele.elementTextTrim("NAME");
                String value=ele.elementTextTrim("VALUE");
                jsonObject.put("key", key);
                jsonObject.put("name", name);
                if(value==null || value.equals("null")){
                    jsonObject.put("value", "");  
                }else{
                    jsonObject.put("value", value);  
                }
            }
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return jsonArray;
    }
    /**
     * 办件业务数据查看
     * 
     * @param djid
     * @return
     */
    private OptHtmlFrameInfo getBizDataViewFrame(String djid) {
        OptHtmlFrameInfo viewFrameInfo = new OptHtmlFrameInfo();
        viewFrameInfo.setFrameId("viewFrame");
        /*
         * viewFrameInfo .setFrameSrc("/wwd/srPermitApply!viewItem.do?djId=" +
         * djid);
         */
        viewFrameInfo.setFrameSrc("/powerruntime/optApply!viewInfo.do?djId="
                + djid);
        viewFrameInfo.setFrameHeight("700px");
        return viewFrameInfo;
    }

    // 加载风险点信息:在申请时调用
    public String forwardRisk() {
        String riskId = request.getParameter("riskId");
        if (StringUtils.isBlank(riskId))
            return "riskFrame";

        RiskInfo riskInfo = riskInfoManager.getObjectById(Long
                .parseLong(riskId));
        if (riskInfo != null) {
            OptBaseInfo optBaseInfo = new OptBaseInfo();
            optBaseInfo.setRiskType(riskInfo.getRisktype());
            optBaseInfo.setRiskDesc(riskInfo.getRiskdes());
            optBaseInfo.setRiskResult(riskInfo.getRiskdeal());

            object.setOptBaseInfo(optBaseInfo);
        }
        // 跳转forward
        return "riskFrame";
    }

    // 加载风险点信息:在编辑时且之前已经保存过风险点时加载
    public String editRisk() {
        OptBaseInfo optBaseInfo = optBaseInfoManager.getObjectById(object
                .getDjId());
        object.setOptBaseInfo(optBaseInfo);
        // 跳转forward
        return "riskFrame";
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

    /**
     * 查询许可列表
     */
    @SuppressWarnings("unchecked")
    public String list() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            if (StringUtils.isBlank(String.valueOf(filterMap.get("orgcode")))) {
                filterMap.remove("orgcode");
            }
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);

            srPermitApplyList = optApplyManager.listOptApplyInfo(filterMap,
                    pageDesc);
            totalRows = pageDesc.getTotalRows();

            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // 许可归档查询
    @SuppressWarnings("unchecked")
    public String XKgdlist() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            if (StringUtils.isBlank(String.valueOf(filterMap.get("orgcode")))) {
                filterMap.remove("orgcode");
            }
            filterMap.put("biztype", "C");
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);

            srPermitApplyList = optApplyManager.listOptApplyInfo(filterMap,
                    pageDesc);
            totalRows = pageDesc.getTotalRows();

            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    public String sdlist() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser
                    .getUsercode());
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            if (StringUtils.isBlank(String.valueOf(filterMap.get("orgcode")))) {
                filterMap.remove("orgcode");
            }
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            filterMap.put("biztype", "C");
            srPermitApplyList = optApplyManager.listOptApplyInfo(filterMap,pageDesc);
            totalRows = pageDesc.getTotalRows();

            unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
            parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                    .getParentunit();
            return "sdlist";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /*************** 保存业务数据 ************************/

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public List<VOptApplyInfo> getSrPermitApplyList() {
        return srPermitApplyList;
    }

    public void setSrPermitApplyList(List<VOptApplyInfo> srPermitApplyList) {
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

    public String getProposerPaperTypes() {
        return proposerPaperTypes;
    }

    public void setProposerPaperTypes(String proposerPaperTypes) {
        this.proposerPaperTypes = proposerPaperTypes;
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

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setGeneralModuleParamMag(
            GeneralModuleParamManager generalModuleParamMag) {
        this.generalModuleParamMag = generalModuleParamMag;
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

    public void setOptApplyManager(OptApplyManager optApplyManager) {
        this.optApplyManager = optApplyManager;
        this.setBaseEntityManager(optApplyManager);
    }

    public String check() {
        String transAffairNo = request.getParameter("transAffairNo");
        String djId = "";
        if (null != request.getParameter("djId")) {
            djId = request.getParameter("djId");
        }
        HttpServletResponse response = (HttpServletResponse) ActionContext
                .getContext().get(ServletActionContext.HTTP_RESPONSE);
        String str_utf = request.getParameter("callback");
        try {
            str_utf = str_utf
                    + "({result:'OK',Flag:'"
                    + optBaseInfoManager.isSimpleTransAffairNo(djId,
                            transAffairNo) + "'})";
        } catch (Exception e) {
            str_utf = str_utf + "({result:'NO'})";
        }
        try {
            response.getWriter().print(str_utf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
