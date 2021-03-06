package com.centit.powerruntime.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.LabelValueBean;
import com.centit.indicator.service.PmTempletManager;
import com.centit.powerruntime.po.PowerOptInfo;
import com.centit.powerruntime.po.RiskInfo;
import com.centit.powerruntime.po.Suppowerstuffgroup;
import com.centit.powerruntime.po.TemplateFile;
import com.centit.powerruntime.service.PowerOptInfoManager;
import com.centit.powerruntime.service.RiskInfoManager;
import com.centit.powerruntime.service.SuppowerstuffgroupManager;
import com.centit.powerruntime.service.TemplateFileManager;
import com.centit.sys.security.FUserDetail;
import com.centit.workflow.FlowDefine;
import com.centit.workflow.FlowDescribe;

public class PowerOptInfoAction extends BaseEntityExtremeAction<PowerOptInfo> {
    private static final long serialVersionUID = 1L;
    private PowerOptInfoManager powerOptInfoManager;
    private RiskInfoManager riskInfoManager;
    private SuppowerstuffgroupManager suppowerstuffgroupManager;
    private TemplateFileManager templateFileManager;
    private PmTempletManager pmTempletManager;
    private String templetJsp;
    
    public String getTempletJsp() {
        return templetJsp;
    }

    public void setTempletJsp(String templetJsp) {
        this.templetJsp = templetJsp;
    }

    public void setPmTempletManager(PmTempletManager pmTempletManager) {
        this.pmTempletManager = pmTempletManager;
    }

    private FlowDefine flowDefine;

    // 材料分组
    private List<Suppowerstuffgroup> groupList = new ArrayList<Suppowerstuffgroup>();
    // 流程代码
    private List<FlowDescribe> flowDescribesList = new ArrayList<FlowDescribe>();
    // 权力事项对应历史记录列表
    private List<PowerOptInfo> powerOptInfoList = new ArrayList<PowerOptInfo>();
    // 7类申请事项模版列表
    private List<TemplateFile> templatelist = new ArrayList<TemplateFile>();

    /****************************************************************************
     * 编辑关联信息
     */

    private String item_id;

    @Override
    public String edit() {
        item_id = object.getItemId();
        object = powerOptInfoManager.getObject(object);
        if (object == null) {
            object = powerOptInfoManager.getObjectByItemID(item_id);
        }

        // 预加载风险点信息
        if (object != null) {
            if (object.getRiskid() != null && object.getRiskid() != 0) {
                RiskInfo riskInfo = riskInfoManager.getObjectById(object
                        .getRiskid());
                object.setRiskInfo(riskInfo);
            }
        }
        // 预加载材料分组
        List<Suppowerstuffgroup> list = suppowerstuffgroupManager.listObjects();
        this.genSelectList(groupList, list, 22);
        // 预加载流程代码
        @SuppressWarnings({ "unchecked", "rawtypes" })
        List<FlowDescribe> fdslist = flowDefine
                .listLastVersionFlow(new HashMap());
        this.getSelectList(flowDescribesList, fdslist, 22);

        // 预加载模版类型
        // 根据申请事项类型获取对应的模版
        List<TemplateFile> tmlist = templateFileManager
                .listTemplateByType("zw");
        this.getTemplateSelectList(templatelist, tmlist, 22);
        if (object == null) {
            object = new PowerOptInfo();
            object.setItemId(item_id);
        }
        return EDIT;
    }

    @SuppressWarnings("unchecked")
    private void getTemplateSelectList(
            @SuppressWarnings("rawtypes") List templatelist,
            List<TemplateFile> tmlist, int len) {

        if (templatelist == null) {
            return;
        }
        templatelist.clear();

        if (tmlist != null && tmlist.size() > 0) {
            for (int i = 0; i < tmlist.size(); i++) {
                TemplateFile po = (TemplateFile) tmlist.get(i);
                String id = po.getRecordId();
                String value = po.getDescript();
                if (value.length() > len) {
                    value = value.substring(0, len) + "...";
                }
                templatelist.add(new LabelValueBean(value, id));
            }
        }

    }

    @SuppressWarnings("unchecked")
    private void getSelectList(
            @SuppressWarnings("rawtypes") List flowDescribesList,
            List<FlowDescribe> fdslist, int len) {
        if (flowDescribesList == null) {
            return;
        }
        flowDescribesList.clear();

        if (fdslist != null && fdslist.size() > 0) {
            for (int i = 0; i < fdslist.size(); i++) {
                FlowDescribe po = (FlowDescribe) fdslist.get(i);
                String id = po.getFlowCode();
                String value = po.getFlowName();
                if (value.length() > len) {
                    value = value.substring(0, len) + "...";
                }
                flowDescribesList.add(new LabelValueBean(value, id));
            }
        }

    }

    /***********************************************************
     * 保存关联信息
     */
    @Override
    public String save() {
        try {
            PowerOptInfo powerOptInfo = powerOptInfoManager.getObject(object);
            if (powerOptInfo != null) {
                powerOptInfoManager.copyObject(powerOptInfo, object);
                object = powerOptInfo;
            }
            object.setSetime(new Date(System.currentTimeMillis()));
            object.setSetoperator(((FUserDetail) getLoginUser()).getUsercode());

            powerOptInfoManager.savePowerOptInfo(object);
            savedMessage();
            return this.edit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    @SuppressWarnings("unchecked")
    private void genSelectList(@SuppressWarnings("rawtypes") List groupList,
            List<Suppowerstuffgroup> nowList, int len) {
        if (groupList == null) {
            return;
        }
        groupList.clear();

        if (nowList != null && nowList.size() > 0) {
            for (int i = 0; i < nowList.size(); i++) {
                Suppowerstuffgroup po = (Suppowerstuffgroup) nowList.get(i);
                String id = po.getGroupId();
                String value = po.getGroupDesc();
                if (StringUtils.isNotBlank(value) && value.length() > len) {
                    value = value.substring(0, len) + "...";
                }
                groupList.add(new LabelValueBean(value, id));
            }
        }

    }

    private JSONObject result;

    public String getGroupIDByItemid() {
        try {
            String itemId = request.getParameter("itemId");
            //判断编号为JS000000JT-XK-1030 是没有groupid的。
            String shrotItemId = itemId.substring(itemId.length()-4, itemId.length());
            if(!"1030".equals(shrotItemId)){
                object = powerOptInfoManager.getObjectByItemID(itemId);
                result = new JSONObject();
                if (object != null && StringUtils.isNotBlank(object.getGroup_id()))
                    result.put("groupidByitemid", object.getGroup_id());
                else
                    result.put("groupidByitemid", "F");
            }else{
                result = new JSONObject();
                result.put("groupidByitemid", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "GroupID";
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    public void setPowerOptInfoManager(PowerOptInfoManager basemgr) {
        powerOptInfoManager = basemgr;
        this.setBaseEntityManager(powerOptInfoManager);
    }

    public void setTemplateFileManager(TemplateFileManager templateFileManager) {
        this.templateFileManager = templateFileManager;
    }

    public void setSuppowerstuffgroupManager(
            SuppowerstuffgroupManager suppowerstuffgroupManager) {
        this.suppowerstuffgroupManager = suppowerstuffgroupManager;
    }

    public void setFlowDefine(FlowDefine flowDefine) {
        this.flowDefine = flowDefine;
    }

    public void setRiskInfoManager(RiskInfoManager riskInfoManager) {
        this.riskInfoManager = riskInfoManager;
    }

    public List<Suppowerstuffgroup> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Suppowerstuffgroup> groupList) {
        this.groupList = groupList;
    }

    public List<FlowDescribe> getFlowDescribesList() {
        return flowDescribesList;
    }

    public void setFlowDescribesList(List<FlowDescribe> flowDescribesList) {
        this.flowDescribesList = flowDescribesList;
    }

    public List<PowerOptInfo> getPowerOptInfoList() {
        return powerOptInfoList;
    }

    public void setPowerOptInfoList(List<PowerOptInfo> powerOptInfoList) {
        this.powerOptInfoList = powerOptInfoList;
    }

    public String getItem_id() {

        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public List<TemplateFile> getTemplatelist() {
        return templatelist;
    }

    public void setTemplatelist(List<TemplateFile> templatelist) {
        this.templatelist = templatelist;
    }

}
