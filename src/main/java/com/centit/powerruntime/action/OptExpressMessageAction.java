package com.centit.powerruntime.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.po.Logistics;
import com.centit.powerruntime.po.OptApplyInfo;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptDobasicMessage;
import com.centit.powerruntime.po.OptExpressMessage;
import com.centit.powerruntime.service.OptApplyManager;
import com.centit.powerruntime.service.OptDobasicMessageManager;
import com.centit.powerruntime.service.OptExpressMessageManager;
import com.centit.powerruntime.util.EmsWebserviceUtil;
import com.centit.sys.util.SysConstant;

public class OptExpressMessageAction extends
        PowerRuntimeEntityAction<OptExpressMessage> implements
        ServletResponseAware {
    private static final Log log = LogFactory
            .getLog(OptExpressMessageAction.class);
    private static final long serialVersionUID = 1L;
    private OptExpressMessageManager optExpressMessageMag;
    private OptDobasicMessageManager optDobasicMessageManager;
    private OptApplyManager optApplyManager;
    private InputStream stuffStream;
    private String filename;
    private List<Logistics> ticslist = new ArrayList<Logistics>();
    private JSONObject result;

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public String getFilename() {
        return filename;
    }

    public void setOptApplyManager(OptApplyManager optApplyManager) {
        this.optApplyManager = optApplyManager;
    }

    public void setOptExpressMessageManager(OptExpressMessageManager basemgr) {
        optExpressMessageMag = basemgr;
        this.setBaseEntityManager(optExpressMessageMag);
    }

    public void setOptDobasicMessageManager(
            OptDobasicMessageManager optDobasicMessageManager) {
        this.optDobasicMessageManager = optDobasicMessageManager;
    }

    public List<Logistics> getTicslist() {
        return ticslist;
    }

    public void setTicslist(List<Logistics> ticslist) {
        this.ticslist = ticslist;
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    @SuppressWarnings("unchecked")
    public String list() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        List<OptExpressMessage> expressMessagelist = optExpressMessageMag
                .listObjects(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        request.setAttribute("expressMessagelist", expressMessagelist);
        return "list";

    }

    /**
     * 快递签字确认单
     * 
     * @return
     */
    public String signlist() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        List<OptExpressMessage> expressMessagelist = optExpressMessageMag
                .listObjects(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        request.setAttribute("expressMessagelist", expressMessagelist);
        return "signlist";

    }

    public String add() {// 新增
        optExpressMessageMag.clearObjectProperties(object);
        object.setExpressid(null);
        object.setChkcode(getCharAndNumr(6).toUpperCase());
        object.setGovtbname("江苏省交通运输厅窗口");
        object.setExpresstime(new Date(System.currentTimeMillis()));
        return EDIT;
    }

    public String bjAddAndEdit() {// 送达与制作EMS
        String expressid = request.getParameter("expressid");
        if (StringUtils.isNotBlank(expressid)) {
            object = optExpressMessageMag.getObjectById(expressid);
            if (StringUtils.isBlank(object.getEmsordno())) {
                object.setChkcode(getCharAndNumr(6).toUpperCase());
                object.setGovtbname("江苏省交通运输厅窗口");
                object.setExpresstime(new Date(System.currentTimeMillis()));
                object.setPosttype("1");
                object.setNettype("2");
                object.setBusstype("1");
                object.setIssend("F");
                OptBaseInfo optBaseInfo = super.optBaseInfoManager
                        .getObjectById(object.getDjid());
                object.setShowmore(optBaseInfo.getTransAffairNo() + "("
                        + optBaseInfo.getTransaffairname() + ")");
            }
        } else {
            String djId = request.getParameter("djId");
            object.setDjid(djId);
            OptBaseInfo optBaseInfo = super.optBaseInfoManager
                    .getObjectById(djId);
            OptApplyInfo optApplyinfo = optApplyManager.getObjectById(djId);
            object.setShowmore(optBaseInfo.getTransAffairNo() + "("
                    + optBaseInfo.getTransaffairname() + ")");
            object.setExpressid(null);
            object.setChkcode(getCharAndNumr(6).toUpperCase());
            object.setGovtbname("江苏省交通运输厅窗口");
            object.setExpresstime(new Date(System.currentTimeMillis()));
            object.setPosttype("1");
            object.setNettype("2");
            object.setBusstype("1");
            object.setIssend("F");
            object.setRcvname(optApplyinfo.getProposerName());
            object.setRcvphone(optApplyinfo.getProposerMobile());
            object.setRcvcall(optApplyinfo.getProposerPhone());
            object.setRcvpostcode(optApplyinfo.getProposerZipcode());
            object.setRcvstrect(optApplyinfo.getProposerAddr());
            object.setIsnetApply("0");
        }
        return "bjEdit";
    }

    public static String getCharAndNumr(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public String edit() {
        try {
            if (object == null) {
                object = getEntityClass().newInstance();
            } else {
                OptExpressMessage o = optExpressMessageMag.getObject(object);
                if (o != null) {
                    optExpressMessageMag.copyObject(object, o);
                } else {
                    optExpressMessageMag.clearObjectProperties(object);
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("expressid", object.getExpressid());
            List<OptDobasicMessage> dobasicMessagelist = optDobasicMessageManager
                    .listObjects(map);
            String bjnumber = "";
            String showmore = "";
            if (dobasicMessagelist != null & dobasicMessagelist.size() > 0) {
                for (int j = 0; j < dobasicMessagelist.size(); j++) {
                    String internalno = dobasicMessagelist.get(j)
                            .getInternalno();
                    bjnumber += internalno + ",";
                    if (StringUtils.isBlank(object.getShowmore())) {
                        OptBaseInfo optBaseInfo = super.optBaseInfoManager
                                .getObjectById(internalno);
                        showmore += optBaseInfo.getTransAffairNo() + "("
                                + optBaseInfo.getTransaffairname() + "),";
                    }
                }
            }
            if (bjnumber != "" && bjnumber != null) {
                request.setAttribute("bjnumber",
                        bjnumber.substring(0, bjnumber.length() - 1));
            }
            if (StringUtils.isNotBlank(showmore)) {
                object.setShowmore(showmore.substring(0, showmore.length() - 1));
            }
            return EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String qyedit() {
        try {
            if (object == null) {
                object = getEntityClass().newInstance();
            } else {
                OptExpressMessage o = optExpressMessageMag.getObject(object);
                if (o != null) {
                    optExpressMessageMag.copyObject(object, o);
                } else {
                    optExpressMessageMag.clearObjectProperties(object);
                }
            }
            String showmore = "";
            for (int i = 0; i < object.getDjid().split(",").length
                    && StringUtils.isBlank(object.getShowmore()); i++) {
                String djId = object.getDjid().split(",")[i];
                OptBaseInfo optBaseInfo = super.optBaseInfoManager
                        .getObjectById(djId);
                showmore += optBaseInfo.getTransAffairNo() + "("
                        + optBaseInfo.getTransaffairname() + "),";
            }
            if (StringUtils.isNotBlank(showmore)) {
                object.setShowmore(showmore.substring(0, showmore.length() - 1));
            }
            return "qyedit";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String saveAndSubmit() {
        OptExpressMessage o = optExpressMessageMag.getObject(object);
        if (o != null) {
            optExpressMessageMag.copyObjectNotNullProperty(o, object);
            object = o;
        } else {
            object.setExpressid(optExpressMessageMag.getExpressMessageId());
        }
        optExpressMessageMag.saveObject(object);
        // 保存办件编码信息
        String[] bjnumbers = request.getParameter("bjnumber").split(",");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("expressid", object.getExpressid());
        List<OptDobasicMessage> dobasicMessagelist = optDobasicMessageManager
                .listObjects(map);
        for (int i = 0; i < bjnumbers.length; i++) {
            int state = 0;
            if (dobasicMessagelist != null & dobasicMessagelist.size() > 0) {
                for (int j = 0; j < dobasicMessagelist.size(); j++) {
                    if (bjnumbers[i].equals(dobasicMessagelist.get(j)
                            .getInternalno())) {
                        state = 1;
                        dobasicMessagelist.remove(j);
                        break;
                    }
                }
            }
            if (state == 0) {// 如果list里没有则说明是新增加的
                OptDobasicMessage dobasic = new OptDobasicMessage();
                dobasic.setDobasicid(optDobasicMessageManager
                        .getDobasicMessageId());
                dobasic.setExpressid(object.getExpressid());
                dobasic.setInternalno(bjnumbers[i]);
                dobasic.setZwfwzxCode("3200JT");
                optDobasicMessageManager.saveObject(dobasic);
            }

        }
        // 处理以后如果list里面还有数据则说明这些数据要删除
        if (dobasicMessagelist != null & dobasicMessagelist.size() > 0) {
            for (int j = 0; j < dobasicMessagelist.size(); j++) {
                optDobasicMessageManager.deleteObjectById(dobasicMessagelist
                        .get(j).getDobasicid());
            }
        }
        return this.list();
    }

    public String qysaveAndSubmit() {
        OptExpressMessage o = optExpressMessageMag.getObject(object);
        if (o != null) {
            optExpressMessageMag.copyObjectNotNullProperty(o, object);
            object = o;
        } else {
            object.setExpressid(optExpressMessageMag.getExpressMessageId());
        }
        optExpressMessageMag.saveObject(object);
        return this.list();
    }

    public String view() {
        try {
            OptExpressMessage o = optExpressMessageMag.getObject(object);
            if (object == null) {
                return "view";
            }
            if (o != null) {
                optExpressMessageMag.copyObject(object, o);
            }
            if (StringUtils.isBlank(object.getShowmore())) {
                String showmore = "";
                if (StringUtils.isBlank(object.getDjid())) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("expressid", object.getExpressid());
                    List<OptDobasicMessage> dobasicMessagelist = optDobasicMessageManager
                            .listObjects(map);
                    if (dobasicMessagelist != null
                            & dobasicMessagelist.size() > 0) {
                        for (int j = 0; j < dobasicMessagelist.size(); j++) {
                            String internalno = dobasicMessagelist.get(j)
                                    .getInternalno();
                            OptBaseInfo optBaseInfo = super.optBaseInfoManager
                                    .getObjectById(internalno);
                            showmore += optBaseInfo.getTransAffairNo() + "("
                                    + optBaseInfo.getTransaffairname() + "),";
                        }
                    }
                } else {
                    for (int i = 0; i < object.getDjid().split(",").length
                            && StringUtils.isBlank(object.getShowmore()); i++) {
                        String djId = object.getDjid().split(",")[i];
                        OptBaseInfo optBaseInfo = super.optBaseInfoManager
                                .getObjectById(djId);
                        showmore += optBaseInfo.getTransAffairNo() + "("
                                + optBaseInfo.getTransaffairname() + "),";
                    }
                }
                object.setShowmore(showmore.substring(0, showmore.length() - 1));
            }
            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    /**
     * 发送EMS信息给政务服务网 三级联网
     * 
     * @return
     * @throws Exception
     */
    public String send() throws Exception {
        optExpressMessageMag.sendExpreeMessage(object.getExpressid());
        return this.list();
    }

    /**
     * 调用政务服务网接口，查询EMS物流信息 三级联网
     * 
     * @return
     * @throws Exception
     */
    public String logistics() throws Exception {
        OptExpressMessage o = optExpressMessageMag.getObjectById(object
                .getExpressid());
        String instr2 = "<?xml version='1.0' encoding='UTF-8'?><RequestMessage><LogisInfo><EMS_ORD_NO>"
                + o.getEmsordno()
                + "</EMS_ORD_NO><ZWFWZX_CODE>3200JT</ZWFWZX_CODE></LogisInfo>"
                + "</RequestMessage>";
        String xmlStr = EmsWebserviceUtil.cityGetGovLogis(instr2);
        SAXBuilder builder = new SAXBuilder();
        Document parse = builder.build(new ByteArrayInputStream(xmlStr
                .getBytes("UTF-8")));
        Element root = parse.getRootElement();// 获取xml文件跟节点
        String resultmessage = ((root.getChildren("RtnMsg").get(0))
                .getChildren("Rtn_Msg").get(0)).getText();
        request.setAttribute("resultmessage", resultmessage);
        List<Element> LogisInfos = ((root.getChildren("LogisInfos")).get(0))
                .getChildren("LogisInfo");
        if (LogisInfos.size() > 0) {
            List<Logistics> ticslists = new ArrayList<Logistics>();
            for (Element logisInfo : LogisInfos) {
                Logistics logistics = new Logistics();
                logistics.setEmsordno(logisInfo.getChildText("EMS_ORD_NO"));
                logistics.setMailnum(logisInfo.getChildText("MAIL_NUM"));
                logistics.setStatus(logisInfo.getChildText("STATUS"));
                logistics.setStsinfo(logisInfo.getChildText("STS_INFO"));
                logistics.setStsdesc(logisInfo.getChildText("STS_DESC"));
                logistics.setStstime(new SimpleDateFormat("yyyy-MM-dd")
                        .parse(logisInfo.getChildText("STS_TIME")));
                ticslists.add(logistics);
            }
            request.setAttribute("ticslists", ticslists);
        }
        return "logistics";

    }

    /**
     * 删除EMS信息
     */
    public String delete() {
        super.delete();
        return this.list();
    }

    /**
     * 核实EMS单号是否唯一
     * 
     * @return
     */
    public String checkems() {
        String expressid = request.getParameter("expressid");
        result = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("emsordno", request.getParameter("emsordno"));
        if (request.getParameter("emsordno") != null
                && request.getParameter("emsordno") != "") {
            List<OptExpressMessage> expressMessagelist = optExpressMessageMag
                    .listObjects(map);
            if (expressMessagelist != null && expressMessagelist.size() > 0) {
                if (expressMessagelist.get(0).getExpressid().equals(expressid)) {
                    result.put("cades", "T");
                } else {
                    result.put("cades", "F");
                }

            } else {
                result.put("cades", "T");
            }
        } else {
            result.put("cades", "T");
        }
        return "cades";
    }

    /**
     * 保存EMS信息到数据中
     * 
     * @return
     */
    public String saveBjEmsInfo() {
        String emsinfo = request.getParameter("emsInfo");
        result = new JSONObject();
        if (StringUtils.isNotBlank(emsinfo)) {
            try {
                HashMap<String, String> EmsHashMap = new HashMap<String, String>();
                String conditions = java.net.URLDecoder
                        .decode(emsinfo, "UTF-8");
                for (int i = 0; i < conditions.split(";").length; i++) {
                    String tmp = conditions.split(";")[i];
                    int mark = tmp.indexOf(":");
                    if (StringUtils.isNotBlank(tmp.substring(mark + 1))) {
                        String key = tmp.substring(0, mark);
                        String value = tmp.substring(mark + 1);
                        if (StringUtils.isNotBlank(value)) {
                            System.out.println("key is " + key + " and value :"
                                    + value);
                            EmsHashMap.put(key.toUpperCase(), value.trim());
                        }
                    }
                }

                OptExpressMessage optExpressMessage = (OptExpressMessage) SysConstant
                        .getValueFromMap(EmsHashMap, OptExpressMessage.class);
                if (StringUtils.isBlank(optExpressMessage.getExpressid())) {
                    optExpressMessage.setExpressid(optExpressMessageMag
                            .getExpressMessageId());
                }
                optExpressMessageMag.saveObject(optExpressMessage);
                result.put("expressid", optExpressMessage.getExpressid());
                if (EmsHashMap.containsKey("EXPRESSID")) {
                    result.put("editType", "E");
                    result.put("resuleValue", "Ems信息修改成功！");
                } else {
                    result.put("editType", "A");
                    result.put("resuleValue", "Ems信息保存保存成功！");
                }
            } catch (Exception e) {
                result.put("expressid", "");
                result.put("resuleValue", e.getMessage());
            }
        }
        return "cades";
    }

    /**
     * 删除办结EMS信息
     * 
     * @return
     */
    public String delteBjEmsInfo() {
        String expressid = request.getParameter("expressid");
        result = new JSONObject();
        try {
            OptExpressMessage optExpressMessage = optExpressMessageMag
                    .getObjectById(expressid);
            if ("1".equals(optExpressMessage.getIsnetApply())) {
                optExpressMessage.setEmsordno("");
                optExpressMessage.setChkcode("");
                optExpressMessage.setGovtbname("");
                optExpressMessage.setExpresstime(null);
                optExpressMessage.setPosttype("");
                optExpressMessage.setNettype("");
                optExpressMessage.setBusstype("");
                optExpressMessage.setIssend("");
                optExpressMessage.setItem("");
                optExpressMessage.setSendcall("");
                optExpressMessage.setSendcity("");
                optExpressMessage.setSendCountry("");
                optExpressMessage.setSendname("");
                optExpressMessage.setSendphone("");
                optExpressMessage.setSendprov("");
                optExpressMessage.setSendstrect("");
                optExpressMessage.setShowmore("");
                optExpressMessageMag.saveObject(optExpressMessage);
            } else {
                optExpressMessageMag.deleteObject(optExpressMessageMag
                        .getObjectById(expressid));
            }

            result.put("result", "OK");
        } catch (Exception e) {
            result.put("result", e.getMessage());
        }
        return "cades";
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        // TODO Auto-generated method stub

    }
}
