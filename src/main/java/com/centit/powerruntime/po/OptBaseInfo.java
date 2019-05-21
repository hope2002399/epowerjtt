package com.centit.powerruntime.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.centit.powerruntime.service.OptBaseInfoManager;
import com.centit.powerruntime.service.OptProcInfoManager;
import com.centit.workflow.FlowEngine;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.NodeEventSupport;
import com.centit.workflow.NodeInstance;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class OptBaseInfo implements java.io.Serializable, NodeEventSupport {
    private static final long serialVersionUID = 1L;
    private OptBaseInfoManager optBaseInfoManager;
    private OptProcInfoManager optProcInfoManager;
    private FlowEngine flowEngine;

    private String djId;

    private Long flowInstId;
    private String transaffairname;
    private String bizstate;
    private String biztype;// F未提交，W等待受理，T办理中，C办结
    private String orgcode;
    private String orgname;
    private String headunitcode;
    private String headusercode;
    private String content;
    private String powerid;
    private String powername;
    private String solvestatus;
    private Date solvetime;
    private String solvenote;
    private String createuser;
    private String riskType;
    private String riskDesc;
    private String riskResult;
    private String transAffairNo;// 办件编号
    private String transAffairQueryKey;// 办件查询密码
    private Date createdate;
    private String optId;
    private String sendArchiveNo;// 发文号
    private String acceptArchiveNo;// 收文号
    private String caseNo;
    
    private String templateXml;
    private String outItemId;
    private String outItemName;
    private String formXml;

    private Set<OptProcInfo> optProcInfos = null;// new
                                                 // ArrayList<OptProcInfo>();
    private Set<OptProcAttention> optProcAttentions = null;// new
                                                           // ArrayList<OptProcAttention>();
    private Set<OptStuffInfo> optStuffInfos = null;// new
                                                   // ArrayList<OptStuffInfo>();

    // Constructors
    /** default constructor */
    public OptBaseInfo() {
    }

    /** minimal constructor */
    public OptBaseInfo(String djId) {

        this.djId = djId;

    }

    /** full constructor */
    public OptBaseInfo(String djId, Long flowInstId, String transaffairname,
            String bizstate, String biztype, String orgcode, String orgname,
            String headunitcode, String headusercode, String content,
            String powerid, String powername, String solvestatus,
            Date solvetime, String solvenote, String createuser,
            Date createdate, String riskType, String riskDesc,
            String riskResult, String transAffairNo,
            String transAffairQueryKey, String optId) {
        this.djId = djId;
        this.flowInstId = flowInstId;
        this.transaffairname = transaffairname;
        this.bizstate = bizstate;
        this.biztype = biztype;
        this.orgcode = orgcode;
        this.orgname = orgname;
        this.headunitcode = headunitcode;
        this.headusercode = headusercode;
        this.content = content;
        this.powerid = powerid;
        this.powername = powername;
        this.solvestatus = solvestatus;
        this.solvetime = solvetime;
        this.solvenote = solvenote;
        this.createuser = createuser;
        this.createdate = createdate;
        this.riskType = riskType;
        this.riskDesc = riskDesc;
        this.riskResult = riskResult;
        this.transAffairNo = transAffairNo;
        this.transAffairQueryKey = transAffairQueryKey;
        this.optId = optId;
    }

    public String getDjId() {
        return this.djId;
    }

    public void setDjId(String djId) {
        this.djId = djId;
    }
    
    

    // Property accessors

    public String getOutItemId() {
        return outItemId;
    }

    public void setOutItemId(String outItemId) {
        this.outItemId = outItemId;
    }

    public String getOutItemName() {
        return outItemName;
    }

    public void setOutItemName(String outItemName) {
        this.outItemName = outItemName;
    }

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public String getFormXml() {
        return formXml;
    }

    public void setFormXml(String formXml) {
        this.formXml = formXml;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public OptBaseInfo(String djId, Long flowInstId, String transaffairname,
            String bizstate, String biztype, String orgcode, String orgname,
            String headunitcode, String headusercode, String content,
            String powerid, String powername, String solvestatus,
            Date solvetime, String solvenote, String createuser,
            String riskType, String riskDesc, String riskResult,
            String transAffairNo, String transAffairQueryKey, Date createdate,
            String optId, String sendArchiveNo, String acceptArchiveNo,
            Set<OptProcInfo> optProcInfos,
            Set<OptProcAttention> optProcAttentions,
            Set<OptStuffInfo> optStuffInfos) {
        super();
        this.djId = djId;
        this.flowInstId = flowInstId;
        this.transaffairname = transaffairname;
        this.bizstate = bizstate;
        this.biztype = biztype;
        this.orgcode = orgcode;
        this.orgname = orgname;
        this.headunitcode = headunitcode;
        this.headusercode = headusercode;
        this.content = content;
        this.powerid = powerid;
        this.powername = powername;
        this.solvestatus = solvestatus;
        this.solvetime = solvetime;
        this.solvenote = solvenote;
        this.createuser = createuser;
        this.riskType = riskType;
        this.riskDesc = riskDesc;
        this.riskResult = riskResult;
        this.transAffairNo = transAffairNo;
        this.transAffairQueryKey = transAffairQueryKey;
        this.createdate = createdate;
        this.optId = optId;
        this.sendArchiveNo = sendArchiveNo;
        this.acceptArchiveNo = acceptArchiveNo;
        this.optProcInfos = optProcInfos;
        this.optProcAttentions = optProcAttentions;
        this.optStuffInfos = optStuffInfos;
    }

    public String getSendArchiveNo() {
        return sendArchiveNo;
    }

    public void setSendArchiveNo(String sendArchiveNo) {
        this.sendArchiveNo = sendArchiveNo;
    }

    public String getAcceptArchiveNo() {
        return acceptArchiveNo;
    }

    public void setAcceptArchiveNo(String acceptArchiveNo) {
        this.acceptArchiveNo = acceptArchiveNo;
    }

    public String getTransaffairname() {
        return this.transaffairname;
    }

    public void setTransaffairname(String transaffairname) {
        this.transaffairname = transaffairname;
    }

    public String getBizstate() {
        return this.bizstate;
    }

    public void setBizstate(String bizstate) {
        this.bizstate = bizstate;
    }

    public String getBiztype() {
        return this.biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }

    public String getOrgcode() {
        return this.orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getOrgname() {
        return this.orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getHeadunitcode() {
        return this.headunitcode;
    }

    public void setHeadunitcode(String headunitcode) {
        this.headunitcode = headunitcode;
    }

    public String getHeadusercode() {
        return this.headusercode;
    }

    public void setHeadusercode(String headusercode) {
        this.headusercode = headusercode;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPowerid() {
        return this.powerid;
    }

    public void setPowerid(String powerid) {
        this.powerid = powerid;
    }

    public String getPowername() {
        return this.powername;
    }

    public void setPowername(String powername) {
        this.powername = powername;
    }

    public String getSolvestatus() {
        return this.solvestatus;
    }

    public void setSolvestatus(String solvestatus) {
        this.solvestatus = solvestatus;
    }

    public Date getSolvetime() {
        return this.solvetime;
    }

    public void setSolvetime(Date solvetime) {
        this.solvetime = solvetime;
    }

    public String getSolvenote() {
        return this.solvenote;
    }

    public void setSolvenote(String solvenote) {
        this.solvenote = solvenote;
    }

    public String getCreateuser() {
        return this.createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Set<OptProcInfo> getOptProcInfos() {
        if (this.optProcInfos == null)
            this.optProcInfos = new HashSet<OptProcInfo>();
        return this.optProcInfos;
    }

    public void setOptProcInfos(Set<OptProcInfo> optProcInfos) {
        this.optProcInfos = optProcInfos;
    }

    public void addOptProcInfo(OptProcInfo optProcInfo) {
        if (this.optProcInfos == null)
            this.optProcInfos = new HashSet<OptProcInfo>();
        this.optProcInfos.add(optProcInfo);
    }

    public void removeOptProcInfo(OptProcInfo optProcInfo) {
        if (this.optProcInfos == null)
            return;
        this.optProcInfos.remove(optProcInfo);
    }

    public OptProcInfo newOptProcInfo() {
        OptProcInfo res = new OptProcInfo();

        res.setDjId(this.getDjId());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replaceOptProcInfos(List<OptProcInfo> optProcInfos) {
        List<OptProcInfo> newObjs = new ArrayList<OptProcInfo>();
        for (OptProcInfo p : optProcInfos) {
            if (p == null)
                continue;
            OptProcInfo newdt = newOptProcInfo();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<OptProcInfo> oldObjs = new HashSet<OptProcInfo>();
        oldObjs.addAll(getOptProcInfos());

        for (Iterator<OptProcInfo> it = oldObjs.iterator(); it.hasNext();) {
            OptProcInfo odt = it.next();
            found = false;
            for (OptProcInfo newdt : newObjs) {
                if (odt.getNodeInstId().equals(newdt.getNodeInstId())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeOptProcInfo(odt);
        }
        oldObjs.clear();
        // insert or update
        for (OptProcInfo newdt : newObjs) {
            found = false;
            for (Iterator<OptProcInfo> it = getOptProcInfos().iterator(); it
                    .hasNext();) {
                OptProcInfo odt = it.next();
                if (odt.getNodeInstId().equals(newdt.getNodeInstId())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addOptProcInfo(newdt);
        }
    }

    public Set<OptProcAttention> getOptProcAttentions() {
        if (this.optProcAttentions == null)
            this.optProcAttentions = new HashSet<OptProcAttention>();
        return this.optProcAttentions;
    }

    public void setOptProcAttentions(Set<OptProcAttention> optProcAttentions) {
        this.optProcAttentions = optProcAttentions;
    }

    public void addOptProcAttention(OptProcAttention optProcAttention) {
        if (this.optProcAttentions == null)
            this.optProcAttentions = new HashSet<OptProcAttention>();
        this.optProcAttentions.add(optProcAttention);
    }

    public void removeOptProcAttention(OptProcAttention optProcAttention) {
        if (this.optProcAttentions == null)
            return;
        this.optProcAttentions.remove(optProcAttention);
    }

    public OptProcAttention newOptProcAttention() {
        OptProcAttention res = new OptProcAttention();

        res.setDjId(this.getDjId());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replaceOptProcAttentions(
            List<OptProcAttention> optProcAttentions) {
        List<OptProcAttention> newObjs = new ArrayList<OptProcAttention>();
        for (OptProcAttention p : optProcAttentions) {
            if (p == null)
                continue;
            OptProcAttention newdt = newOptProcAttention();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<OptProcAttention> oldObjs = new HashSet<OptProcAttention>();
        oldObjs.addAll(getOptProcAttentions());

        for (Iterator<OptProcAttention> it = oldObjs.iterator(); it.hasNext();) {
            OptProcAttention odt = it.next();
            found = false;
            for (OptProcAttention newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeOptProcAttention(odt);
        }
        oldObjs.clear();
        // insert or update
        for (OptProcAttention newdt : newObjs) {
            found = false;
            for (Iterator<OptProcAttention> it = getOptProcAttentions()
                    .iterator(); it.hasNext();) {
                OptProcAttention odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addOptProcAttention(newdt);
        }
    }

    public Set<OptStuffInfo> getOptStuffInfos() {
        if (this.optStuffInfos == null)
            this.optStuffInfos = new HashSet<OptStuffInfo>();
        return this.optStuffInfos;
    }

    public void setOptStuffInfos(Set<OptStuffInfo> optStuffInfos) {
        this.optStuffInfos = optStuffInfos;
    }

    public void addOptStuffInfo(OptStuffInfo optStuffInfo) {
        if (this.optStuffInfos == null)
            this.optStuffInfos = new HashSet<OptStuffInfo>();
        this.optStuffInfos.add(optStuffInfo);
    }

    public void removeOptStuffInfo(OptStuffInfo optStuffInfo) {
        if (this.optStuffInfos == null)
            return;
        this.optStuffInfos.remove(optStuffInfo);
    }

    public OptStuffInfo newOptStuffInfo() {
        OptStuffInfo res = new OptStuffInfo();

        res.setDjId(this.getDjId());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replaceOptStuffInfos(List<OptStuffInfo> optStuffInfos) {
        List<OptStuffInfo> newObjs = new ArrayList<OptStuffInfo>();
        for (OptStuffInfo p : optStuffInfos) {
            if (p == null)
                continue;
            OptStuffInfo newdt = newOptStuffInfo();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<OptStuffInfo> oldObjs = new HashSet<OptStuffInfo>();
        oldObjs.addAll(getOptStuffInfos());

        for (Iterator<OptStuffInfo> it = oldObjs.iterator(); it.hasNext();) {
            OptStuffInfo odt = it.next();
            found = false;
            for (OptStuffInfo newdt : newObjs) {
                if (odt.getStuffid().equals(newdt.getStuffid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeOptStuffInfo(odt);
        }
        oldObjs.clear();
        // insert or update
        for (OptStuffInfo newdt : newObjs) {
            found = false;
            for (Iterator<OptStuffInfo> it = getOptStuffInfos().iterator(); it
                    .hasNext();) {
                OptStuffInfo odt = it.next();
                if (odt.getStuffid().equals(newdt.getStuffid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addOptStuffInfo(newdt);
        }
    }

    public void copy(OptBaseInfo other) {

        this.setDjId(other.getDjId());

        this.flowInstId = other.getFlowInstId();
        this.transaffairname = other.getTransaffairname();
        this.bizstate = other.getBizstate();
        this.biztype = other.getBiztype();
        this.orgcode = other.getOrgcode();
        this.orgname = other.getOrgname();
        this.headunitcode = other.getHeadunitcode();
        this.headusercode = other.getHeadusercode();
        this.content = other.getContent();
        this.powerid = other.getPowerid();
        this.powername = other.getPowername();
        this.solvestatus = other.getSolvestatus();
        this.solvetime = other.getSolvetime();
        this.solvenote = other.getSolvenote();
        this.createuser = other.getCreateuser();
        this.createdate = other.getCreatedate();
        this.riskType = other.getRiskType();
        this.riskDesc = other.getRiskDesc();
        this.riskResult = other.getRiskResult();
        this.transAffairNo = other.getTransAffairNo();
        this.transAffairQueryKey = other.getTransAffairQueryKey();
        this.optProcInfos = other.getOptProcInfos();
        this.optProcAttentions = other.getOptProcAttentions();
        this.optStuffInfos = other.getOptStuffInfos();
        this.optId = other.getOptId();
        this.sendArchiveNo = other.getSendArchiveNo();
        this.acceptArchiveNo = other.getAcceptArchiveNo();
        this.templateXml=other.getTemplateXml();
    }

    public void copyNotNullProperty(OptBaseInfo other) {

        if (other.getDjId() != null)
            this.setDjId(other.getDjId());

        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getTransaffairname() != null)
            this.transaffairname = other.getTransaffairname();
        if (other.getBizstate() != null)
            this.bizstate = other.getBizstate();
        if (other.getBiztype() != null)
            this.biztype = other.getBiztype();
        if (other.getOrgcode() != null)
            this.orgcode = other.getOrgcode();
        if (other.getOrgname() != null)
            this.orgname = other.getOrgname();
        if (other.getHeadunitcode() != null)
            this.headunitcode = other.getHeadunitcode();
        if (other.getHeadusercode() != null)
            this.headusercode = other.getHeadusercode();
        if (other.getContent() != null)
            this.content = other.getContent();
        if (other.getPowerid() != null)
            this.powerid = other.getPowerid();
        if (other.getPowername() != null)
            this.powername = other.getPowername();
        if (other.getSolvestatus() != null)
            this.solvestatus = other.getSolvestatus();
        if (other.getSolvetime() != null)
            this.solvetime = other.getSolvetime();
        if (other.getSolvenote() != null)
            this.solvenote = other.getSolvenote();
        if (other.getCreateuser() != null)
            this.createuser = other.getCreateuser();
        if (other.getCreatedate() != null)
            this.createdate = other.getCreatedate();
        if (other.getRiskType() != null)
            this.riskType = other.getRiskType();
        if (other.getRiskDesc() != null)
            this.riskDesc = other.getRiskDesc();
        if (other.getRiskResult() != null)
            this.riskResult = other.getRiskResult();
        if (other.getTransAffairNo() != null)
            this.transAffairNo = other.getTransAffairNo();
        if (other.getTransAffairQueryKey() != null)
            this.transAffairQueryKey = other.getTransAffairQueryKey();
        if (other.getOptId() != null)
            this.optId = other.getOptId();

        if (other.getSendArchiveNo() != null)
            this.sendArchiveNo = other.getSendArchiveNo();
        if (other.getAcceptArchiveNo() != null)
            this.acceptArchiveNo = other.getAcceptArchiveNo();
        if (other.getOptProcInfos() != null)
            this.optProcInfos = other.getOptProcInfos();

        if (other.getOptProcAttentions() != null)
            this.optProcAttentions = other.getOptProcAttentions();

        if (other.getOptStuffInfos() != null)
            this.optStuffInfos = other.getOptStuffInfos();
        if (other.getTemplateXml() != null)
            this.templateXml=other.getTemplateXml();
    }

    public void clearProperties() {

        this.flowInstId = null;
        this.transaffairname = null;
        this.bizstate = null;
        this.biztype = null;
        this.orgcode = null;
        this.orgname = null;
        this.headunitcode = null;
        this.headusercode = null;
        this.content = null;
        this.powerid = null;
        this.powername = null;
        this.solvestatus = null;
        this.solvetime = null;
        this.solvenote = null;
        this.createuser = null;
        this.createdate = null;
        this.riskType = null;
        this.riskDesc = null;
        this.riskResult = null;
        this.transAffairNo = null;
        this.transAffairQueryKey = null;
        this.optId = null;
        this.sendArchiveNo = null;
        this.acceptArchiveNo = null;
        this.optProcInfos = new HashSet<OptProcInfo>();
        this.optProcAttentions = new HashSet<OptProcAttention>();
        this.optStuffInfos = new HashSet<OptStuffInfo>();
        this.templateXml=null;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getRiskDesc() {
        return riskDesc;
    }

    public void setRiskDesc(String riskDesc) {
        this.riskDesc = riskDesc;
    }

    public String getRiskResult() {
        return riskResult;
    }

    public void setRiskResult(String riskResult) {
        this.riskResult = riskResult;
    }

    public String getTemplateXml() {
        return templateXml;
    }

    public void setTemplateXml(String templateXml) {
        this.templateXml = templateXml;
    }

    public String getTransAffairNo() {
        if (StringUtils.isBlank(this.transAffairNo)) {
            this.transAffairNo = String.valueOf(UUID.randomUUID().timestamp());
        }
        return transAffairNo;
    }

    public void setTransAffairNo(String transAffairNo) {
        this.transAffairNo = transAffairNo;
    }

    public String getTransAffairQueryKey() {
        return transAffairQueryKey;
    }

    public void setTransAffairQueryKey(String transAffairQueryKey) {
        this.transAffairQueryKey = transAffairQueryKey;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public OptBaseInfo(String djId, Long flowInstId, String transaffairname,
            String bizstate, String biztype, String orgcode, String orgname,
            String headunitcode, String headusercode, String content,
            String powerid, String powername, String solvestatus,
            Date solvetime, String solvenote, String createuser,
            String riskType, String riskDesc, String riskResult,
            String transAffairNo, String transAffairQueryKey, Date createdate,
            String optId, String sendArchiveNo, String acceptArchiveNo,
            String caseNo) {
        super();
        this.djId = djId;
        this.flowInstId = flowInstId;
        this.transaffairname = transaffairname;
        this.bizstate = bizstate;
        this.biztype = biztype;
        this.orgcode = orgcode;
        this.orgname = orgname;
        this.headunitcode = headunitcode;
        this.headusercode = headusercode;
        this.content = content;
        this.powerid = powerid;
        this.powername = powername;
        this.solvestatus = solvestatus;
        this.solvetime = solvetime;
        this.solvenote = solvenote;
        this.createuser = createuser;
        this.riskType = riskType;
        this.riskDesc = riskDesc;
        this.riskResult = riskResult;
        this.transAffairNo = transAffairNo;
        this.transAffairQueryKey = transAffairQueryKey;
        this.createdate = createdate;
        this.optId = optId;
        this.sendArchiveNo = sendArchiveNo;
        this.acceptArchiveNo = acceptArchiveNo;
        this.caseNo = caseNo;
    }

    public void runAfterCreate(FlowInstance flowInst, NodeInstance nodeInst,
            String optParam, String optUserCode) {

        OptBaseInfo bean = optBaseInfoManager.getOptBaseByFlowId(flowInst
                .getFlowInstId());
        OptProcInfo procInfo = optProcInfoManager
                .getObjectByNodeInstId(nodeInst.getPrevNodeInstId());

        if (procInfo == null) {
            procInfo = new OptProcInfo();
        }
        if (!"FKHSB".equals(procInfo.getNodeCode())) {// 如果不是 【反馈或上报】 节点过来的
            bean.setBiztype("C");
            bean.setSolvetime(new Date(System.currentTimeMillis()));
            bean.setSolvenote(procInfo.getTransidea());
            bean.setSolvestatus(procInfo.getIdeacode());
            optBaseInfoManager.saveObject(bean);
        } else {
            // 获取自动提交节点上一个节点的上一节点
            NodeInstance nodeInst_prev = getFlowEngine().getNodeInstById(
                    nodeInst.getPrevNodeInstId());
            OptProcInfo procInfo_prev = optProcInfoManager
                    .getObjectByNodeInstId(nodeInst_prev.getPrevNodeInstId());
            if ("T".equals(procInfo_prev.getIdeacode())) {
                procInfo_prev.setIdeacode("2");// 准予许可
            } else {
                procInfo_prev.setIdeacode("3");// 不予许可
            }
            bean.setBiztype("C");
            bean.setSolvetime(new Date(System.currentTimeMillis()));
            bean.setSolvenote(procInfo_prev.getTransidea());
            bean.setSolvestatus(procInfo_prev.getIdeacode());
            optBaseInfoManager.saveObject(bean);
        }
    }

    public OptBaseInfoManager getOptBaseInfoManager() {
        return optBaseInfoManager;
    }

    public void setOptBaseInfoManager(OptBaseInfoManager optBaseInfoManager) {
        this.optBaseInfoManager = optBaseInfoManager;
    }

    public OptProcInfoManager getOptProcInfoManager() {
        return optProcInfoManager;
    }

    public void setOptProcInfoManager(OptProcInfoManager optProcInfoManager) {
        this.optProcInfoManager = optProcInfoManager;
    }

    public FlowEngine getFlowEngine() {
        return flowEngine;
    }

    public void setFlowEngine(FlowEngine flowEngine) {
        this.flowEngine = flowEngine;
    }

    @Override
    public void runBeforeSubmit(FlowInstance flowInst, NodeInstance nodeInst,
            String optParam, String optUserCode) {

    }

    @Override
    public boolean runAutoOperator(FlowInstance flowInst,
            NodeInstance nodeInst, String optParam, String optUserCode) {

        return false;
    }
}
