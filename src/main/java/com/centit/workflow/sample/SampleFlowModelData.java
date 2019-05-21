package com.centit.workflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.centit.core.utils.LabelValueBean;
import com.centit.sys.dao.OptDefDao;
import com.centit.sys.dao.OptVariableDao;
import com.centit.sys.po.FOptdef;
import com.centit.sys.po.OptVariable;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.workflow.FlowModelData;
import com.centit.workflow.sample.dao.WfFlowDefineDao;
import com.centit.workflow.sample.po.WfFlowDefine;
import com.centit.workflow.sample.po.WfFlowStage;

/**
 * 实现一个最简单的元数据提供类 实际业务应该从数据库中获取
 */
public class SampleFlowModelData implements FlowModelData, Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 例举所有节点任务分配机制 A:一般 B:抢先机制 C:多人操作
     */
    private WfFlowDefineDao flowDefineDao;
    private OptDefDao optDefDao;
    private OptVariableDao optVariableDao;

    public void setOptVariableDao(OptVariableDao optVariableDao) {
        this.optVariableDao = optVariableDao;
    }

    public void setOptDefDao(OptDefDao optDefDao) {
        this.optDefDao = optDefDao;
    }

    public void setFlowDefineDao(WfFlowDefineDao flowDefineDao) {
        this.flowDefineDao = flowDefineDao;
    }

    @Override
    public Map<String, String> listAllOptType() {

        Map<String, String> optType = new HashMap<String, String>();
        optType.put("A", "一般");
        optType.put("B", "抢先机制");
        optType.put("C", "多人操作");
        optType.put("D", "自动执行");
        optType.put("S", "子流程");
        optType.put("E", "哑元");

        return optType;
    }

    /**
     * 例举所有节点类别 A:开始 B:首节点 C:一般 D:分支 E:汇聚 F结束
     */
    @Override
    public Map<String, String> listAllNoteType() {
        Map<String, String> nodeType = new HashMap<String, String>();
        // nodeType.put("A", "开始");
        // nodeType.put("B", "首节点");
        nodeType.put("C", "一般");
        nodeType.put("D", "分支");
        nodeType.put("E", "汇聚 ");
        // nodeType.put("F", "结束");
        return nodeType;
    }

    /*
     * 根据业务id例举所有的业务变量
     */
    @Override
    public Map<String, String> listAllVariable(String optid) {
        Map<String, String> varList = new HashMap<String, String>();
        List<LabelValueBean> list = CodeRepositoryUtil
                .getLabelValueBeans("WFGenVar");// 读取公用的变量
        for (LabelValueBean a : list) {
            varList.put(a.getValue(), a.getLabel());
        }

        List<OptVariable> list1 = (List<OptVariable>) optVariableDao
                .getVarByOptid(optid);// 读取业务本身的变量
        for (OptVariable var : list1) {

            if (var.getIsvalid().equals("T"))// 启用的才显示出去
                varList.put(var.getVarname(), var.getVardesc());
        }
        return varList;
    }

    public Map<String, String> listAllOptCode(String flowCode, long version) {
        WfFlowDefine flowDef = flowDefineDao.getFlowDefineByID(flowCode,
                version);

        List<FOptdef> optDefList = optDefDao.getOptDefByOptID(flowDef
                .getOptId());

        Map<String, String> optmap = new HashMap<String, String>();

        if (optDefList != null) {
            for (FOptdef optdef : optDefList) {
                optmap.put(optdef.getOptcode(), optdef.getOptname());
            }
        }

        return optmap;
    }

    /**
     * 列举流程定义对应的操作定义
     */
    public Map<String, String> listAllOptCode(String flowCode) {

        return listAllOptCode(flowCode, 0L);
    }

    @Override
    public Map<String, Map<String, String>> listAllRole() {

        Map<String, Map<String, String>> roleList = new HashMap<String, Map<String, String>>();

        Map<String, String> map1 = new HashMap<String, String>(); // 岗位角色
        List<LabelValueBean> lvbmap = CodeRepositoryUtil
                .getLabelValueBeans("StationType");
        for (LabelValueBean a : lvbmap) {
            map1.put(a.getValue(), a.getLabel());
        }

        roleList.put("gw", map1);
        Map<String, String> map2 = new HashMap<String, String>();// 行政角色
        List<LabelValueBean> lvbmap2 = CodeRepositoryUtil
                .getLabelValueBeans("RankType");
        for (LabelValueBean b : lvbmap2) {
            map2.put(b.getValue(), b.getLabel());
        }

        roleList.put("xz", map2);
        Map<String, String> map3 = new HashMap<String, String>(); // 办件角色
        List<LabelValueBean> lvbmap3 = CodeRepositoryUtil
                .getLabelValueBeans("WFTeamRole");
        for (LabelValueBean b : lvbmap3) {
            map3.put(b.getValue(), b.getLabel());
        }

        roleList.put("bj", map3);
        return roleList;
    }

    @Override
    public String getUserNameByCode(String userCode) {

        return userCode;
    }

    @Override
    public String getUnitNameByCode(String unitCode) {

        return unitCode;
    }

    @Override
    public String getRoleNameByCode(String roleCode) {

        return roleCode;
    }

    @Override
    public List<String> getRightUsers(String unitCode, String roleCode,
            int instID) {

        List<String> userList = new ArrayList<String>();
        userList.add("0001");
        userList.add("0002");
        return userList;
    }

    @Override
    public Map<String, String> listSubWf() {
        Map<String, String> subwf = new HashMap<String, String>();

        List<WfFlowDefine> listflow = flowDefineDao.getFlowsByState("B");
        for (WfFlowDefine wfFlowDefine : listflow) {
            subwf.put(wfFlowDefine.getFlowCode(), wfFlowDefine.getFlowName());
        }

        return subwf;
    }

    /**
     * 根据流程代码、流程版本获取流程阶段信息
     * 
     * @param flowCode
     * @param version
     * @return
     */
    public Map<String, String> listFlowStages(String flowCode) {
        WfFlowDefine flowDef = flowDefineDao.getFlowDefineByID(flowCode, 0L);// 流程0版本读取
        Set<WfFlowStage> stageSet = flowDef.getWfFlowStages();

        Map<String, String> optmap = new HashMap<String, String>();

        if (stageSet != null && !stageSet.isEmpty()) {
            Iterator<WfFlowStage> it = stageSet.iterator();
            while (it.hasNext()) {
                WfFlowStage stage = it.next();
                optmap.put(stage.getStageCode(), stage.getStageName());
            }
        }
        return optmap;
    }

}
