package com.centit.workflow.sample.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseAction;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.service.SysUnitFilterEngine;
import com.centit.sys.service.SysUserFilterEngine;
import com.centit.workflow.FlowDefine;
import com.centit.workflow.FlowDescribe;
import com.centit.workflow.FlowModelData;
import com.centit.workflow.sample.po.WfFlowDefine;
import com.centit.workflow.sample.po.WfFlowDefineId;
import com.centit.workflow.sample.po.WfFlowStage;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * 流程定义ACTION类
 * 
 * @version $Rev$ <br>
 *          $Id$
 */
public class SampleFlowDefineAction extends BaseAction implements
        ModelDriven<WfFlowDefine> {
    public String getViewXml() {
        return viewXml;
    }

    public void setViewXml(String viewXml) {
        this.viewXml = viewXml;
    }

    public static final Log log = LogFactory
            .getLog(SampleFlowDefineAction.class);
    private static final long serialVersionUID = 1L;

    private FlowDefine flowDef;

    private FlowModelData modelData;
    private String datacode;
    private String result;
    private List<FOptinfo> optList;

    protected WfFlowDefine object;// getEntityClass().newInstance();//
    protected Integer totalRows;
    protected List<FlowDescribe> objList;

    private String viewXml;

    public SampleFlowDefineAction() {
        object = new WfFlowDefine();
    }

    public String getResult() {
        return result;
    }

    @Override
    public WfFlowDefine getModel() {
        return object;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setFlowDefine(FlowDefine flowdef) {
        this.flowDef = flowdef;
    }

    public void setFlowModelData(FlowModelData modelData) {
        this.modelData = modelData;
    }

    public FlowModelData getFlowModelData() {
        return modelData;
    }

    public void setDatacode(String datacode) {
        this.datacode = datacode;
    }

    public String getDatecode() {
        return datacode;
    }

    public List<FOptinfo> getOptList() {
        return optList;
    }

    public void setOptList(List<FOptinfo> optList) {
        this.optList = optList;
    }

    public List<FlowDescribe> getObjList() {
        return objList;
    }

    public void setObjList(List<FlowDescribe> objList) {
        this.objList = objList;
    }

    public WfFlowDefine getObject() {
        return object;
    }

    public void setObject(WfFlowDefine object) {
        this.object = object;
    }

    /**
     * 例举系统中的所有流程，只显示最新版本的
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String list() {
        try {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            objList = flowDef.listLastVersionFlow(filterMap);
            totalRows = objList.size();
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 查看一个流程的所有版本
     * 
     * @return
     */
    public String getMyAllVersions() {
        objList = flowDef.getFlowsByCode(object.getFlowCode());
        totalRows = objList.size();
        return "listFlowVersions";
    }

    // /**
    // * 查看一个流程某一版本的定义
    // *
    // * @return
    // */
    // public String viewFlow() {
    // String xmlStr = flowDef.getFlowDef(object.getFlowCode(),
    // object.getVersion());
    // object.setFlowXmlDesc(xmlStr);
    // //v viewXml = xmlStr;
    // return "view";
    // }

    /**
     * 发布新版本流程
     * 
     * @return String
     */
    public String publishFlow() {
        try {
            flowDef.publishFlowDef(object.getFlowCode());
        } catch (Exception e) {
            log.equals(e.getMessage());
            saveError(e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    /**
     * 启用某个流程
     * 
     * @return
     */
    public String enableFlow() {
        try {
            flowDef.enableFlow(object.getFlowCode());
            return SUCCESS;
        } catch (Exception e) {
            log.equals(e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 禁用某个流程
     * 
     * @return
     */
    public String disableFlow() {
        try {
            flowDef.disableFlow(object.getFlowCode());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 保存定义流程草稿
     * 
     * @return
     */
    public String saveFlow() {
        try {
            String wfcode = object.getFlowCode();
            // String wfname = object.getFlowName();
            BufferedReader br = request.getReader();
            StringBuffer buffer = new StringBuffer();
            String str = br.readLine();
            while (str != null) { // 如果 line 为空说明读完了
                buffer.append(str); // 将读到的内容添加到 buffer 中
                buffer.append("\r\n"); // 添加换行符
                str = br.readLine(); // 读取下一行
            }
            br.close();
            WfFlowDefine wfFlowDefine = new WfFlowDefine();
            wfFlowDefine.setFlowCode(wfcode);
            // wfFlowDefine.setFlowName(wfname);
            // wfFlowDefine.setFlowDesc(object.getFlowDesc());
            wfFlowDefine.setFlowXmlDesc(buffer.toString());
            // wfFlowDefine.setFlowState(object.getFlowState());
            // wfFlowDefine.setVersion(object.getVersion());
            // wfFlowDefine.setOptId(object.getOptId());
            // wfFlowDefine.setTimeLimit(object.getTimeLimit());
            // wfFlowDefine.setExpireOpt(object.getExpireOpt());
            flowDef.saveDraftFlowDef(wfFlowDefine);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    private List<WfFlowStage> wfFlowStages;

    public List<WfFlowStage> getNewWfFlowStages() {
        return this.wfFlowStages;
    }

    public void setNewWfFlowStages(List<WfFlowStage> wfFlowStages) {
        this.wfFlowStages = wfFlowStages;
    }

    public String saveFlowField() {
        try {
            WfFlowDefine dbobject = (WfFlowDefine) flowDef.getFlowDefObject(
                    object.getFlowCode(), object.getVersion());
            if (dbobject != null) {
                dbobject.copyNotNullProperty(object);
                object = dbobject;
            }
            if (wfFlowStages != null) {
                for (WfFlowStage stage : wfFlowStages) {
                    if (stage != null
                            && (stage.getStageId() == null || stage
                                    .getStageId() == 0)) {
                        stage.setStageId(flowDef.getNextStageId());
                        stage.setFlowCode(object.getFlowCode());
                        stage.setVersion(0L);
                    }
                }
            } else {
                wfFlowStages = new ArrayList<WfFlowStage>();
            }
            object.replaceWfFlowStages(wfFlowStages);
            flowDef.saveFlow(object);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 预定义流程草稿
     * 
     * @return
     */
    public String preDefFlow() {
        object.copy(new WfFlowDefine());
        object.setFlowCode(flowDef.getNextPrimarykey());
        object.setVersion(0L);
        return EDIT;
    }

    public String editFlow() {
        object.copy(flowDef.getFlowDefObject(object.getFlowCode(),
                object.getVersion()));
        return "";
    }

    /**
     * 复制流程
     * 
     * @return
     */
    public String copyFlow() {
        WfFlowDefine dbobject = (WfFlowDefine) flowDef.getFlowDefObject(
                object.getFlowCode(), object.getVersion());
        WfFlowDefine wfFlowDef = new WfFlowDefine();
        wfFlowDef.copyNotNullProperty(dbobject);
        wfFlowDef.setCid(new WfFlowDefineId(0L, flowDef.getNextPrimarykey()));
        wfFlowDef.setFlowName(wfFlowDef.getFlowName() + "1");
        flowDef.saveFlow(wfFlowDef);
        object.copy(wfFlowDef);
        return preEditFlow();
    }

    /**
     * 预修改流程草稿
     * 
     * @return
     */
    public String preEditFlow() {
        try {
            WfFlowDefine flowDescribe = flowDef.getFlowDefObject(
                    object.getFlowCode(), object.getVersion());
            object.copy(flowDescribe);
            return EDIT;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    /**
     * 系统数据常量
     * 
     * @return
     */
    public String getdataMap() {

        Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
        // 角色
        Map<String, Map<String, String>> map1 = modelData.listAllRole();
        map = map1;
        // 分配机制
        Map<String, String> map2 = modelData.listAllOptType();
        map.put("OptType", map2);
        // 操作定义
        Map<String, String> map3 = modelData.listAllOptCode(object
                .getFlowCode());
        map.put("OptCode", map3);
        // 子流程
        Map<String, String> map4 = modelData.listSubWf();
        map.put("SubWfcode", map4);

        Map<String, String> stageMap = modelData.listFlowStages(object
                .getFlowCode());
        ;
        map.put("FlowPhase", stageMap);

        JSONObject jObject = JSONObject.fromObject(map);
        result = jObject.toString();
        log.debug(result);
        // System.out.print(result);

        return "map";
    }

    public String getVar() {
        /* System.out.print(object.getOptId()); */
        Map<String, String> map = modelData.listAllVariable(object.getOptId());

        JSONObject jObject = JSONObject.fromObject(map);
        result = jObject.toString();
        log.debug(result);
        return "var";
    }

    public String getworkflowxml() {
        try {
            object.copy(flowDef.getFlowDefObject(object.getFlowCode(),
                    object.getVersion()));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
        return "xml";
    }

    public String getflowxml() {
        try {
            object.copy(flowDef.getFlowDefObject(object.getFlowCode(),
                    object.getVersion()));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
        return "svgxml";
    }

    public String viewworkflow() {
        try {
            object.copy(flowDef.getFlowDefObject(object.getFlowCode(),
                    object.getVersion()));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
        return "view";
    }

    public String checkUnitsExp() {
        BufferedReader br;
        try {
            br = request.getReader();
            StringBuffer buffer = new StringBuffer();
            String str = br.readLine();
            while (str != null) { // 如果 line 为空说明读完了
                buffer.append(str); // 将读到的内容添加到 buffer 中
                buffer.append("\r\n"); // 添加换行符
                str = br.readLine(); // 读取下一行
            }
            br.close();
            result = SysUnitFilterEngine.validateUnitsExp(buffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return "checkUnitsExp";
    }

    public String checkRolesExp() {
        BufferedReader br;
        try {
            br = request.getReader();
            StringBuffer buffer = new StringBuffer();
            String str = br.readLine();
            while (str != null) { // 如果 line 为空说明读完了
                buffer.append(str); // 将读到的内容添加到 buffer 中
                buffer.append("\r\n"); // 添加换行符
                str = br.readLine(); // 读取下一行
            }
            br.close();
            result = SysUserFilterEngine.validateRolesExp(buffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return "checkRolesExp";
    }
}
