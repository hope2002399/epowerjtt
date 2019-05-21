package com.centit.complaint.action;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

/**
 * 
 * 通用类
 * 
 * @author hx
 * @create 2013-6-12
 * @version
 */
public class EpowerCommonBizAction<T> extends PowerRuntimeEntityAction<T> {
    private static final long serialVersionUID = 4063405489456258953L;
    protected String actionName;// 对应form的actionName
    protected String submitOptURI;// 对应form的提交方法名
    protected String saveOptURI;// 对应form的保存方法名
    protected Object optCommonBizJson;

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
     * 用于加载通用配置
     * 
     * @return
     */
    public String generalOpt() {
        try {
            moduleParam = generalModuleParamManager.getObjectById(moduleCode);//
            extractFlowOptParam();
            super.initTeamUsersConfig();
            super.initTemplateConfig();
            super.initTemplateFromNode();
            /**
             * 配置当前步骤名称
             */
            NodeInstance nodeInst = flowEngine.getNodeInstById(curNodeInstId);
            FlowNodeInfo nodeInfo = flowEngine.getNodeInfoById(nodeInst
                    .getNodeId());
            nodeName = nodeInfo.getNodeName();
            return "optTrans";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e, e.getCause());
            request.setAttribute("error", "通用配置功能出错，请检查各配置项是否准确。");
            return ERROR;
        }
    }

    /*************************** getter,setter *********************************/
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

    public Object getOptCommonBizJson() {
        return optCommonBizJson;
    }

    public void setOptCommonBizJson(Object optCommonBizJson) {
        this.optCommonBizJson = optCommonBizJson;
    }
}
