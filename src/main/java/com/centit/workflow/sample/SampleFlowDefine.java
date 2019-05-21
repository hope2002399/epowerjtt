package com.centit.workflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.xml.XmlUtils;
import com.centit.workflow.FlowDefine;
import com.centit.workflow.FlowDescribe;
import com.centit.workflow.sample.dao.WfFlowDefineDao;
import com.centit.workflow.sample.po.WfFlowDefine;
import com.centit.workflow.sample.po.WfFlowDefineId;
import com.centit.workflow.sample.po.WfFlowStage;
import com.centit.workflow.sample.po.WfNode;
import com.centit.workflow.sample.po.WfTransition;

public class SampleFlowDefine implements FlowDefine, Serializable {

    private static final long serialVersionUID = 1L;
    private WfFlowDefineDao flowDefineDao;
    private static Log logger = LogFactory.getLog(SampleFlowDefine.class);
    public static final String BEGINNODETAG = "begin";
    public static final String ENDNODETAG = "end";

    // 这个Map放在这儿有一定的耦合性
    private Map<String, Long> nodeTagToId;
    private Map<String, Long> transTagToId;
    private long beginNodeId;
    private long firstNodeId;

    public SampleFlowDefine() {
        nodeTagToId = new HashMap<String, Long>();
        transTagToId = new HashMap<String, Long>();
    }

    public void setFlowDefineDao(WfFlowDefineDao baseDao) {
        this.flowDefineDao = baseDao;
    }

    public List<FlowDescribe> getFlowsByOptId(String optId) {
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("optId", optId);

        List<WfFlowDefine> flows = flowDefineDao
                .getAllLastVertionFlows(filterMap);
        return new ArrayList<FlowDescribe>(
                flows == null ? new ArrayList<WfFlowDefine>() : flows);
    }

    private static String getXmlNodeAttrAsStr(Element xNode, String attrName) {
        Attribute nameAttr = xNode.attribute(attrName);
        if (nameAttr != null) {
            return nameAttr.getValue();
        }
        return null;
    }

    /**
     * 获取流程节点信息 节点XML如下： <Nodes> <Node> <!--nodetype 节点类别 A:开始 B:首节点 C:一般 D:分支
     * E:汇聚 R:游离分支 F:结束 --> <!--OptType 操作类别 A:一般 B:抢先机制 C:多人操作 D:子流程 -->
     * <BaseProperties id="1" name="开始" nodetype="A" desc="开始节点描述" opttype="A"
     * optcode="" roletype="" rolecode="" /> <VMLProperties shapetype="Oval"
     * width="40" height="40" x="60" y="160" textWeight="9pt" strokeWeight="1"
     * zIndex="1" /> </Node> </Nodes>
     * 
     * @param nodeList
     * @param flowDef
     * @return wfSet
     */
    private Set<WfNode> getWfNodeSet(List<Node> nodeList, WfFlowDefine flowDef) {
        nodeTagToId.clear();
        Set<WfNode> wfSet = new HashSet<WfNode>();

        if (nodeList == null || nodeList.size() == 0) {
            return null;
        }
        long thisNodeId;
        for (Node tmpNode : nodeList) {
            Element baseNode = (Element) tmpNode
                    .selectSingleNode("BaseProperties");
            String sId = getXmlNodeAttrAsStr(baseNode, "id");
            if (sId == null)
                continue;
            thisNodeId = flowDefineDao.getNextNodeId();
            // 这个对应关系 留给下面的 getWfTransitionSet 使用，有一定的耦合性
            nodeTagToId.put(sId, thisNodeId);

        }

        for (Node tmpNode : nodeList) {

            Element baseNode = (Element) tmpNode
                    .selectSingleNode("BaseProperties");
            String sId = getXmlNodeAttrAsStr(baseNode, "id");
            if (sId == null)
                continue;
            WfNode wfNode = flowDef.newWfNode();
            thisNodeId = nodeTagToId.get(sId); // 获取节点ID

            sId = sId.toLowerCase();
            if (sId.equals(BEGINNODETAG)) {
                wfNode.setNodeType("A");
                beginNodeId = thisNodeId;
            } else if (sId.equals(ENDNODETAG)) {
                wfNode.setNodeType("F");
            } else {
                wfNode.setNodeType("C");
            }

            wfNode.setNodeId(thisNodeId);
            wfNode.setNodeName(getXmlNodeAttrAsStr(baseNode, "name"));
            // 获取节点类型
            if (getXmlNodeAttrAsStr(baseNode, "flowphase") != ""
                    && getXmlNodeAttrAsStr(baseNode, "flowphase") != null) {
                wfNode.setFlowPhase(getXmlNodeAttrAsStr(baseNode, "flowphase"));
            }
            wfNode.setNodeType(getXmlNodeAttrAsStr(baseNode, "nodetype"));
            wfNode.setNodeCode(getXmlNodeAttrAsStr(baseNode, "nodecode"));
            wfNode.setRiskinfo(getXmlNodeAttrAsStr(baseNode, "riskinfo"));
            wfNode.setNodeDesc(getXmlNodeAttrAsStr(baseNode, "desc"));
            wfNode.setOptType(getXmlNodeAttrAsStr(baseNode, "opttype"));
            wfNode.setOptCode(getXmlNodeAttrAsStr(baseNode, "optcode"));
            wfNode.setOptBean(getXmlNodeAttrAsStr(baseNode, "optbean"));

            String optparam = getXmlNodeAttrAsStr(baseNode, "optparam");

            if (optparam != null && optparam.indexOf("&amp;") > 0) {
                optparam = optparam.replaceAll("&amp;", "&");
            }

            wfNode.setOptParam(optparam);

            wfNode.setRoleType(getXmlNodeAttrAsStr(baseNode, "roletype"));
            wfNode.setRoleCode(getXmlNodeAttrAsStr(baseNode, "rolecode"));
            wfNode.setLimitType(getXmlNodeAttrAsStr(baseNode, "timeLimitType"));
            wfNode.setIsTrunkLine(getXmlNodeAttrAsStr(baseNode, "isTrunkLine"));
            String timelimit = getXmlNodeAttrAsStr(baseNode, "timeLimit");
            if (timelimit != null && timelimit.length() > 0) {
                wfNode.setTimeLimit(getXmlNodeAttrAsStr(baseNode, "timeLimit"));
            }
            wfNode.setInheritType(getXmlNodeAttrAsStr(baseNode, "inheritType"));
            wfNode.setInheritNodeCode(getXmlNodeAttrAsStr(baseNode,
                    "inheritNodeCode"));
            wfNode.setExpireOpt(getXmlNodeAttrAsStr(baseNode, "expireopt"));
            wfNode.setUnitExp(replaceXml(getXmlNodeAttrAsStr(baseNode,
                    "unitexp")));
            wfNode.setPowerExp(replaceXml(getXmlNodeAttrAsStr(baseNode,
                    "powerexp")));
            wfNode.setSubFlowCode(getXmlNodeAttrAsStr(baseNode, "subwfcode"));
            wfNode.setIsAccountTime(getXmlNodeAttrAsStr(baseNode,
                    "isaccounttime"));
            wfSet.add(wfNode);
        }
        return wfSet;
    }

    /**
     * 流程流转路径定义 路径节点信息如下： <Transitions> <Transition> <BaseProperties id="1"
     * name="流程开始" from="1" to="3" cond="" desc="" /> <VMLProperties
     * points="75pt,135pt,135pt,135pt" fromRelX="1" fromRelY="0.5" toRelX="0"
     * toRelY="0.5" shapetype="PolyLine" startArrow="none" endArrow="Classic"
     * strokeWeight="1" zIndex="0" /> <LabelProperties id="labstep0" width="60"
     * height="20px" x="119px" y="186px" /> </Transition> </Transitions>
     * 
     * @param transList
     * @param flowDef
     * @return wfTranSet
     */
    private Set<WfTransition> getWfTransitionSet(List<Node> transList,
            WfFlowDefine flowDef) {
        Set<WfTransition> wfTranSet = new HashSet<WfTransition>();
        transTagToId.clear();

        if (transList == null || transList.size() == 0) {
            return null;
        }
        for (Node tmpNode : transList) {
            WfTransition wfTran = flowDef.newWfTransition();

            Element baseNode = (Element) tmpNode
                    .selectSingleNode("BaseProperties");
            String sId = getXmlNodeAttrAsStr(baseNode, "id");
            if (sId == null)
                continue;
            long thisTransId = flowDefineDao.getNextTransId();
            transTagToId.put(sId, thisTransId);

            wfTran.setTransid(thisTransId);

            wfTran.setTransname(getXmlNodeAttrAsStr(baseNode, "name"));
            wfTran.setTranscondition(replaceXml(getXmlNodeAttrAsStr(baseNode,
                    "cond")));
            wfTran.setLimitType(getXmlNodeAttrAsStr(baseNode, "timeLimitType"));

            String timelimit = getXmlNodeAttrAsStr(baseNode, "timeLimit");
            if (timelimit != null && timelimit.length() > 0) {
                wfTran.setTimeLimit(getXmlNodeAttrAsStr(baseNode, "timeLimit"));
            }

            sId = getXmlNodeAttrAsStr(baseNode, "from");
            long fromNodeId = nodeTagToId.get(sId);
            wfTran.setStartnodeid(fromNodeId);
            sId = getXmlNodeAttrAsStr(baseNode, "to");
            long toNodeId = nodeTagToId.get(sId);
            wfTran.setEndnodeid(toNodeId);
            if (fromNodeId == beginNodeId)
                firstNodeId = toNodeId;
            wfTran.setTransdesc(getXmlNodeAttrAsStr(baseNode, "desc"));

            wfTranSet.add(wfTran);
        }

        return wfTranSet;
    }

    public static String replaceXml(String cond) {
        String condchange = null;
        if (cond != null) {
            condchange = cond.replaceAll("\\&amp;", "&");
            condchange = condchange.replaceAll("\\&lt;", "<");
            condchange = condchange.replaceAll("\\&gt;", ">");
            condchange = condchange.replaceAll("\\&quot;", "\"");
            condchange = condchange.replaceAll("\\&apos;", "'");
        }
        return condchange;
    }

    @SuppressWarnings("unchecked")
    private WfFlowDefine createFlowDefByXML(String sXMLdef, String flowCode,
            Long version) {

        WfFlowDefine flowDef = new WfFlowDefine();
        flowDef.setCid(new WfFlowDefineId(version, flowCode));
        Document doc = XmlUtils.string2xml(sXMLdef);

        logger.debug(doc.asXML());

        // <Flow code="test" name="测试流程定义" type="n" desc="这是一个测试流程图形定义界面的示例" >
        Element flowEle = (Element) doc.selectSingleNode("//Flow");
        // 流程代码
        // flowDef.setWfcode(getXmlNodeAttrAsStr(flowEle,"code"));
        // 流程名称
        flowDef.setFlowName(getXmlNodeAttrAsStr(flowEle, "name"));
        // 流程类别
        flowDef.setFlowClass(getXmlNodeAttrAsStr(flowEle, "type"));
        // 流程描述
        flowDef.setFlowDesc(getXmlNodeAttrAsStr(flowEle, "desc"));
        // 流程XML串
        flowDef.setFlowXmlDesc(sXMLdef);
        // 流程节点定义 必需先调用 getWfNodeSet 再调用 getWfTransitionSet因为nodeTagToId的耦合性
        List<Node> nodeList = flowEle.selectNodes("//Nodes/Node");
        flowDef.setWfNodes(getWfNodeSet(nodeList, flowDef));
        // 流程流转路径定义
        List<Node> transList = flowEle.selectNodes("//Transitions/Transition");
        flowDef.setWfTransitions(getWfTransitionSet(transList, flowDef));

        return flowDef;
    }

    @Override
    public boolean saveDraftFlowDef(FlowDescribe wfDef) {
        // 将 流程定义格式保存到 版本为 0 的记录中
        WfFlowDefine flowDef = flowDefineDao.getObjectById(new WfFlowDefineId(
                0L, wfDef.getFlowCode()));
        if (flowDef == null)
            flowDef = new WfFlowDefine();

        flowDef.copyNotNullProperty(wfDef);

        flowDef.setFlowCode(wfDef.getFlowCode());
        flowDef.setVersion(0L);// wfDef.getVersion()==null ? 0L :
                               // wfDef.getVersion());

        flowDef.setFlowState("A");// wfDef.getWfstate() == null ?
                                  // "A":wfDef.getWfstate());
        flowDef.setFlowClass("R");

        flowDefineDao.saveObject(flowDef);
        return true;
    }

    @Override
    public String getDraftFlowDef(String flowCode) {
        // 版本号为 0 的流程定义中获得 XML
        return getFlowDef(flowCode, 0);
    }

    private void checkFlowDef(WfFlowDefine newFlowDef) throws Exception {
        // 验证流程节点定义
        for (WfNode nd : newFlowDef.getWfNodes()) {
            if (!"A".equals(nd.getNodeType()) && !"F".equals(nd.getNodeType())) {
                if ("S".equals(nd.getOptType())) {
                    if (nd.getSubFlowCode() == null
                            || "".equals(nd.getSubFlowCode()))
                        throw new Exception("子流程节点：" + nd.getNodeName()
                                + ",没有指定流程代码。");
                } else if (!"E".equals(nd.getOptType())
                        && !"D".equals(nd.getOptType())) {
                    if (nd.getOptCode() == null || "".equals(nd.getOptCode()))
                        throw new Exception("节点：" + nd.getNodeName()
                                + ",没有指定业务操作代码。");
                    if (nd.getRoleType() == null || "".equals(nd.getRoleType()))
                        throw new Exception("节点：" + nd.getNodeName()
                                + ",没有指定角色类别。");
                    else if ("en".equals(nd.getRoleType())) {
                        if (nd.getPowerExp() == null
                                || "".equals(nd.getPowerExp()))
                            throw new Exception("节点：" + nd.getNodeName()
                                    + ",权限表达式为空。");
                    } else {
                        if (nd.getRoleCode() == null
                                || "".equals(nd.getRoleCode()))
                            throw new Exception("节点：" + nd.getNodeName()
                                    + ",没有指定角色代码。");
                    }
                } else if ("D".equals(nd.getOptType())) {
                    if (nd.getOptBean() == null || "".equals(nd.getOptBean()))
                        throw new Exception("自动运行节点：" + nd.getNodeName()
                                + ",没有运行的bean。");
                }
            }
        }
        // 检查 流转定义
        for (WfTransition tran : newFlowDef.getWfTransitions()) {
            if (tran.getTranscondition() == null
                    || "".equals(tran.getTranscondition())) {
                WfNode nd = newFlowDef.getWfNodeById(tran.getStartnodeid());
                if (nd != null && !"A".equals(nd.getNodeType())
                        && !"C".equals(nd.getNodeType())) {
                    throw new Exception("流转：" + tran.getTransname()
                            + ",没有指定流转条件。");
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public long publishFlowDef(String flowCode) throws Exception {
        // 将流程从 XML 格式中解析出来
        WfFlowDefine flowDef = flowDefineDao.getObjectById(new WfFlowDefineId(
                0L, flowCode));
        if (flowDef == null) {
            return 0L;
        }
        // 获取新的版本号
        long nCurVersion = flowDefineDao.getLastVersion(flowCode);
        Long newVersion = nCurVersion + 1L;

        // WfFlowDefine newFlowDef = new WfFlowDefine();
        String wfDefXML = flowDef.getFlowXmlDesc();
        WfFlowDefine newFlowDef = createFlowDefByXML(wfDefXML, flowCode,
                newVersion);
        // 添加验证流程定义验证
        checkFlowDef(newFlowDef);

        newFlowDef.replaceWfFlowStages(new ArrayList<WfFlowStage>(flowDef
                .getWfFlowStages()));

        Map<Long, String> nodeIsLeaf = new HashMap<Long, String>();
        for (WfNode nd : newFlowDef.getWfNodes()) {

            if (nd.getNodeId().equals(firstNodeId))
                nd.setNodeType("B");// 首届点

            if ("C".equals(nd.getNodeType()))
                nodeIsLeaf.put(nd.getNodeId(), "T");
            else
                nodeIsLeaf.put(nd.getNodeId(), "F");
        }
        // 检查 孤立的节点
        for (WfTransition tran : newFlowDef.getWfTransitions()) {
            nodeIsLeaf.put(tran.getStartnodeid(), "F");
        }
        for (WfNode nd : newFlowDef.getWfNodes())
            nd.setIsLeafNode(nodeIsLeaf.get(nd.getNodeId()));

        for (WfFlowStage stage : newFlowDef.getWfFlowStages()) {
            stage.setStageId(this.getNextStageId());
            stage.setVersion(newVersion);
        }

        // 替换 流程XML格式中的节点、流转编码 对照表在 ndMap 和 trMap 中
        Document wfDefDoc = XmlUtils.string2xml(wfDefXML);
        List<Node> nodeList = wfDefDoc.selectNodes("//Nodes/Node");

        for (Node tmpNode : nodeList) {
            Element baseNode = (Element) tmpNode
                    .selectSingleNode("BaseProperties");
            Attribute nodeIdAttr = baseNode.attribute("id");
            String sId = nodeIdAttr.getValue();
            if (BEGINNODETAG.compareToIgnoreCase(sId) != 0
                    && ENDNODETAG.compareToIgnoreCase(sId) != 0)
                nodeIdAttr.setValue(nodeTagToId.get(sId).toString());
        }

        List<Node> transList = wfDefDoc.selectNodes("//Transitions/Transition");
        for (Node transNode : transList) {
            Element baseNode = (Element) transNode
                    .selectSingleNode("BaseProperties");
            Attribute transIdAttr = baseNode.attribute("id");
            if (transIdAttr == null)
                continue;
            String sTransId = transTagToId.get(transIdAttr.getValue())
                    .toString();
            transIdAttr.setValue(sTransId);

            Attribute fromAttr = baseNode.attribute("from");
            if (fromAttr != null) {
                String sId = fromAttr.getValue();
                if (BEGINNODETAG.compareToIgnoreCase(sId) != 0
                        && ENDNODETAG.compareToIgnoreCase(sId) != 0)
                    fromAttr.setValue(nodeTagToId.get(sId).toString());
            }

            Attribute toAttr = baseNode.attribute("to");
            if (toAttr != null) {
                String sId = toAttr.getValue();
                if (BEGINNODETAG.compareToIgnoreCase(sId) != 0
                        && ENDNODETAG.compareToIgnoreCase(sId) != 0)
                    toAttr.setValue(nodeTagToId.get(sId).toString());
            }

            Element labNode = (Element) transNode
                    .selectSingleNode("LabelProperties");
            Attribute idAttr = labNode.attribute("id");
            if (idAttr != null)
                idAttr.setValue("lab" + sTransId);

        }
        newFlowDef.setFlowXmlDesc(wfDefDoc.asXML());

        // 保存新版本的流程,状态设置为正常
        newFlowDef.setFlowDesc(flowDef.getFlowDesc());
        newFlowDef.setFlowName(flowDef.getFlowName());
        newFlowDef.setFlowClass(flowDef.getFlowClass());
        newFlowDef.setOptId(flowDef.getOptId());
        newFlowDef.setTimeLimit(flowDef.getTimeLimit());
        newFlowDef.setExpireOpt(flowDef.getExpireOpt());
        newFlowDef.setPublishDate(DatetimeOpt.currentUtilDate());
        newFlowDef.setFlowState("B");

        // 复制相关节点信息

        // newFlowDef.getWfFlowStages()

        flowDefineDao.saveObject(newFlowDef);

        // 将0版本更新为已发布
        flowDef.setFlowState("E");
        flowDefineDao.saveObject(flowDef);

        // 将非0老版本流程状态改为已过期
        WfFlowDefine oldflowDef = flowDefineDao
                .getObjectById(new WfFlowDefineId((long) nCurVersion, flowCode));
        if (oldflowDef != null && nCurVersion > 0) {
            oldflowDef.setFlowState("C");
            flowDefineDao.saveObject(oldflowDef);
        }

        return nCurVersion + 1;
    }

    public List<FlowDescribe> listLastVersionFlow(Map<String, Object> filterMap) {
        List<WfFlowDefine> flows = flowDefineDao
                .getAllLastVertionFlows(filterMap);
        if (flows == null) {
            return new ArrayList<FlowDescribe>();
        }
        for (WfFlowDefine def : flows) {
            WfFlowDefine wfDef = flowDefineDao
                    .getObjectById(new WfFlowDefineId(0L, def.getFlowCode()));
            if (wfDef != null) {
                def.setFlowState(wfDef.getFlowState());
            }

        }
        return new ArrayList<FlowDescribe>(flows);
    }

    public List<FlowDescribe> getFlowsByCode(String wfCode) {
        List<WfFlowDefine> flows = flowDefineDao
                .getAllVersionFlowsByCode(wfCode);
        return new ArrayList<FlowDescribe>(
                flows == null ? new ArrayList<WfFlowDefine>() : flows);
    }

    public WfFlowDefine getFlowDefObject(String flowCode, long version) {
        try {
            return flowDefineDao.getObjectById(new WfFlowDefineId(version,
                    flowCode));
        } catch (Exception e) {
            return null;
        }
    }

    public FlowDescribe getFlowDefObject(String flowCode) {
        long version = flowDefineDao.getLastVersion(flowCode);
        return getFlowDefObject(flowCode, version);
    }

    public List<FlowDescribe> getAllFlows() {
        List<WfFlowDefine> flows = flowDefineDao.listObjects();
        return new ArrayList<FlowDescribe>(
                flows == null ? new ArrayList<WfFlowDefine>() : flows);
    }

    @Override
    public String getFlowDef(String flowCode, long version) {
        // 获得某个特定版本的流程定义 文本
        WfFlowDefine flowDef = flowDefineDao.getObjectById(new WfFlowDefineId(
                Long.valueOf(version), flowCode));
        if (flowDef == null)
            return "";
        return flowDef.getFlowXmlDesc();
    }

    @Override
    public String getFlowDef(String flowCode) {
        // 获得流程最新版本的流程定义 文本
        long nCurVersion = flowDefineDao.getLastVersion(flowCode);
        if (nCurVersion == 0)
            return null;
        return getFlowDef(flowCode, nCurVersion);
    }

    @Override
    public void disableFlow(String flowCode) {
        // 将最新版本的流程定义的状态更改为禁用 D
        WfFlowDefine flowDef = flowDefineDao.getLastVersionFlowByCode(flowCode);
        flowDef.setFlowState("D");
        flowDefineDao.saveObject(flowDef);
    }

    @Override
    public void enableFlow(String flowCode) {
        // 将最新版本的流程定义的状态更改为正常 B
        WfFlowDefine flowDef = flowDefineDao.getLastVersionFlowByCode(flowCode);
        flowDef.setFlowState("B");
        flowDefineDao.saveObject(flowDef);
    }

    @Override
    public String getNextPrimarykey() {

        return flowDefineDao.getNextPrimarykey();
    }

    public long getNextStageId() {
        return flowDefineDao.getNextStageId();
    }

    @Override
    public void saveFlow(WfFlowDefine wfDef) {
        wfDef.setFlowState("A");// wfDef.getWfstate() == null ?
                                // "A":wfDef.getWfstate());
        wfDef.setFlowClass("R");
        /*
         * Set<WfFlowStage> stages = wfDef.getWfFlowStages(); for(WfFlowStage
         * stage : stages){ if(stage!=null && (stage.getStageId()==null ||
         * stage.getStageId().equals(0))){
         * stage.setStageId(flowDefineDao.getNextStageId()); } }
         */
        flowDefineDao.saveObject(wfDef);
    }
}
