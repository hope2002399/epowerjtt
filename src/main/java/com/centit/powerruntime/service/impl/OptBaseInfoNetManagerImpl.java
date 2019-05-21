package com.centit.powerruntime.service.impl;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.OptBaseInfoNetDao;
import com.centit.powerruntime.po.OptBaseInfoNet;
import com.centit.powerruntime.service.OptBaseInfoNetManager;

public class OptBaseInfoNetManagerImpl extends
        BaseEntityManagerImpl<OptBaseInfoNet> implements OptBaseInfoNetManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(OptBaseInfoNetManager.class);

    private OptBaseInfoNetDao optBaseInfoNetDao;

    public void setOptBaseInfoNetDao(OptBaseInfoNetDao baseDao) {
        this.optBaseInfoNetDao = baseDao;
        setBaseDao(this.optBaseInfoNetDao);
    }

    @Override
    public OptBaseInfoNet getOptBaseNetByFlowId(Long flowinstid) {
        return optBaseInfoNetDao.getOptBaseByFlowId(flowinstid);
    }

    public String getOptBaseNetJsonBynetId(String netId) {
        OptBaseInfoNet optBaseInfo = optBaseInfoNetDao.getObjectById(netId);

        JSONObject jsonObj = new JSONObject();
        if (optBaseInfo != null) {
            jsonObj.put("transAffairNo", optBaseInfo.getTransAffairNo());
            jsonObj.put("transaffairname", optBaseInfo.getTransaffairname());
            jsonObj.put("orgcode", optBaseInfo.getOrgcode());
            jsonObj.put("orgname", optBaseInfo.getOrgname());
            jsonObj.put("powerid", optBaseInfo.getPowerid());
            jsonObj.put("powername", optBaseInfo.getPowername());
            jsonObj.put("createDate", optBaseInfo.getCreatedate());
        }
        return jsonObj.toString();
    }

    @Override
    public int getNumOfsameModel(String codeModel, String year) {
        return optBaseInfoNetDao.getNumOfsameModel(codeModel, year);
    }

    /*
     * private void saveIdeaInfo(OptBaseInfo optinfo,String userCode,long
     * nodeInstId,String nodeName , String optCode,String ideaCode,String
     * transIdea,String transContent) { saveIdeaInfo( optinfo, userCode,
     * nodeInstId, nodeName , optCode, ideaCode, transIdea, transContent,
     * null,null); } private void saveIdeaInfo(OptBaseInfo optinfo,String
     * userCode,long nodeInstId,String nodeName , String optCode,String
     * ideaCode,String transIdea,String transContent, String unitCode,String
     * flowPhase) { OptIdeaInfo optIdeaInfo = new OptIdeaInfo();
     * optIdeaInfo.setProcid(optIdeaInfoDao.getNextIdeaPK());
     * 
     * optIdeaInfo.setDjId(optinfo.getDjId());
     * optIdeaInfo.setNodeInstId(nodeInstId); optIdeaInfo.setNodeinststate("N");
     * optIdeaInfo.setNodename(nodeName);
     * optIdeaInfo.setTransdate(DatetimeOpt.currentUtilDate());
     * optIdeaInfo.setOptcode(optCode);
     * optIdeaInfo.setTranscontent(transContent);
     * optIdeaInfo.setUsercode(userCode); optIdeaInfo.setIdeacode(ideaCode);
     * optIdeaInfo.setTransidea(transIdea); optIdeaInfo.setUnitcode(unitCode);
     * //optIdeaInfo.setNodeCode(nodeCode); optIdeaInfo.setFlowPhase(flowPhase);
     * optIdeaInfoDao.saveObject(optIdeaInfo); }
     * 
     * 
     * //// 流程管理接口 private OptBaseInfo manageInstance(long flowInstId, String
     * admindesc, String bizstate) { OptBaseInfo optBaseInfo =
     * getOptBaseByFlowId(flowInstId); optBaseInfo.setBizstate(bizstate);
     * optBaseInfo.setSolvenote(admindesc);
     * optBaseInfo.setSolvetime(DatetimeOpt.currentUtilDate());
     * 
     * optBaseInfoDao.saveObject(optBaseInfo);
     * 
     * return optBaseInfo; }
     *//**
     * 终止一个流程
     */
    /*
     * public int stopInstance(long flowInstId, String mangerUserCode, String
     * admindesc) { OptBaseInfo optBaseInfo = manageInstance(flowInstId,
     * admindesc, "X"); saveIdeaInfo(optBaseInfo,mangerUserCode,0,"流程管理" ,
     * "stop","stop","终止",admindesc); return 0; }
     *//**
     * 暂停一个流程
     */
    /*
     * public int suspendInstance(long flowInstId, String mangerUserCode, String
     * admindesc) { OptBaseInfo optBaseInfo = manageInstance(flowInstId,
     * admindesc, "S"); saveIdeaInfo(optBaseInfo,mangerUserCode,0,"流程管理" ,
     * "suspend","suspend","暂停",admindesc); return 0; }
     *//**
     * 使流程失效
     */
    /*
     * public int invalidInstance(long flowInstId, String mangerUserCode, String
     * admindesc) { OptBaseInfo optBaseInfo = manageInstance(flowInstId,
     * admindesc, "I"); saveIdeaInfo(optBaseInfo,mangerUserCode,0,"流程管理" ,
     * "invalid","invalid","失效",admindesc); return 0; }
     *//**
     * 激活一个 挂起的或者无效的流程
     */
    /*
     * public int activizeInstance(long flowInstId, String mangerUserCode,
     * String admindesc) { OptBaseInfo optBaseInfo = manageInstance(flowInstId,
     * admindesc, "T"); saveIdeaInfo(optBaseInfo,mangerUserCode,0,"流程管理" ,
     * "wakeup","wakeup","唤醒",admindesc); return 0; }
     *//**
     * 唤醒一个超时流程的一个节点
     */
    /*
     * public long activizeExpireInstance(long flowInstId, String timeLimit,
     * String mangerUserCode, String admindesc) { OptBaseInfo optBaseInfo =
     * manageInstance(flowInstId, admindesc, "T");
     * saveIdeaInfo(optBaseInfo,mangerUserCode,0,"流程管理" ,
     * "wakeup","wakeup","唤醒",admindesc); return 0; }
     * 
     * 
     * @Override public long suspendNodeInstance(long nodeInstId, String
     * mangerUserCode) { WfNodeInstance nodeInst =
     * nodeInstanceDao.getObjectById(nodeInstId); if(nodeInst==null) return -1;
     * OptBaseInfo optBaseInfo = getOptBaseByFlowId(nodeInst.getFlowInstId());
     * saveIdeaInfo(optBaseInfo,mangerUserCode,nodeInstId,
     * nodeInst.getNodeName() , "suspend","suspend","暂停","暂停节点",
     * nodeInst.getUnitCode(),nodeInst.getFlowPhase()); return 0; }
     * 
     * 
     * @Override public long activizeNodeInstance(long nodeInstId, String
     * mangerUserCode) { WfNodeInstance nodeInst =
     * nodeInstanceDao.getObjectById(nodeInstId); if(nodeInst==null) return -1;
     * OptBaseInfo optBaseInfo = getOptBaseByFlowId(nodeInst.getFlowInstId());
     * saveIdeaInfo(optBaseInfo,mangerUserCode,nodeInstId,
     * nodeInst.getNodeName() , "wakeup","wakeup","唤醒","唤醒节点",
     * nodeInst.getUnitCode(),nodeInst.getFlowPhase()); return 0; }
     */
}
