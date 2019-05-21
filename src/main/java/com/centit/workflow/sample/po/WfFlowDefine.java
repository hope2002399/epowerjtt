package com.centit.workflow.sample.po;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.centit.workflow.FlowDescribe;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.FlowStage;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfFlowDefine implements java.io.Serializable, FlowDescribe {
    private static final long serialVersionUID = 1L;
    private WfFlowDefineId cid;

    private String wfname;
    private String wfclass;
    private String wfstate;
    private String wfdesc;
    private String wfxmldesc;
    private Date wfPubDate;
    private String optid;
    private String timeLimit;
    private String expireOpt;
    private Date atPublishDate;
    private Set<WfNode> wfNodes = null;// new ArrayList<WfNode>();
    private Set<WfTransition> wfTransitions = null;// new
                                                   // ArrayList<WfTransition>();
    private Set<WfFlowStage> wfFlowStages = null;// new
                                                 // ArrayList<WfFlowStage>();

    // Constructors
    /** default constructor */
    public WfFlowDefine() {
    }

    /** minimal constructor */
    public WfFlowDefine(WfFlowDefineId id

    , String wfclass) {
        this.cid = id;

        this.wfclass = wfclass;
    }

    /** full constructor */
    public WfFlowDefine(WfFlowDefineId id

    , String wfname, String wfclass, String wfstate, String wfdesc,
            String wfxmldesc, Date wfPubDate, String optid, String timeLimit,
            String expireOpt, Date atPublishDate) {
        this.cid = id;

        this.wfname = wfname;
        this.wfclass = wfclass;
        this.wfstate = wfstate;
        this.wfdesc = wfdesc;
        this.wfxmldesc = wfxmldesc;
        this.wfPubDate = wfPubDate;
        this.optid = optid;
        this.timeLimit = timeLimit;
        this.expireOpt = expireOpt;
        this.atPublishDate = atPublishDate;
    }

    public WfFlowDefineId getCid() {
        return this.cid;
    }

    public void setCid(WfFlowDefineId id) {
        this.cid = id;
    }

    public Long getVersion() {
        if (this.cid == null)
            this.cid = new WfFlowDefineId();
        return this.cid.getVersion();
    }

    public void setVersion(Long version) {
        if (this.cid == null)
            this.cid = new WfFlowDefineId();
        this.cid.setVersion(version);
    }

    public String getFlowCode() {
        if (this.cid == null)
            this.cid = new WfFlowDefineId();
        return this.cid.getFlowCode();
    }

    public void setFlowCode(String wfcode) {
        if (this.cid == null)
            this.cid = new WfFlowDefineId();
        this.cid.setFlowCode(wfcode);
    }

    // Property accessors

    public String getFlowName() {
        return this.wfname;
    }

    public void setFlowName(String wfname) {
        this.wfname = wfname;
    }

    public String getFlowClass() {
        return this.wfclass;
    }

    public void setFlowClass(String wfclass) {
        this.wfclass = wfclass;
    }

    /**
     * A 草稿 E 已发布 (A,E仅对0版本有效) B 正常 C 过期 D 禁用
     * 
     * @return
     */
    public String getFlowState() {
        return this.wfstate;
    }

    /**
     * A 草稿 B 正常 C 过期 D 禁用
     * 
     * @param wfstate
     */
    public void setFlowState(String wfstate) {
        this.wfstate = wfstate;
    }

    public String getFlowDesc() {
        return this.wfdesc;
    }

    public void setFlowDesc(String wfdesc) {
        this.wfdesc = wfdesc;
    }

    public String getFlowXmlDesc() {
        return this.wfxmldesc;
    }

    public void setFlowXmlDesc(String wfxmldesc) {
        this.wfxmldesc = wfxmldesc;
    }

    public Date getPublishDate() {
        return this.wfPubDate;
    }

    public void setPublishDate(Date wfPubDate) {
        this.wfPubDate = wfPubDate;
    }

    public String getOptId() {
        return this.optid;
    }

    public void setOptId(String optid) {
        this.optid = optid;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getExpireOpt() {
        return expireOpt;
    }

    public void setExpireOpt(String expireOpt) {
        this.expireOpt = expireOpt;
    }

    public Date getAtPublishDate() {
        return atPublishDate;
    }

    public void setAtPublishDate(Date atPublishDate) {
        this.atPublishDate = atPublishDate;
    }

    public Set<WfNode> getWfNodes() {
        if (this.wfNodes == null)
            this.wfNodes = new HashSet<WfNode>();
        return this.wfNodes;
    }

    public WfNode getWfNodeById(long nodeId) {
        if (this.wfNodes == null)
            return null;
        for (WfNode nd : wfNodes)
            if (nd.getNodeId().equals(nodeId))
                return nd;
        return null;
    }

    public void setWfNodes(Set<WfNode> wfNodes) {
        this.wfNodes = wfNodes;
    }

    public void addWfNode(WfNode wfNode) {
        if (this.wfNodes == null)
            this.wfNodes = new HashSet<WfNode>();
        this.wfNodes.add(wfNode);
    }

    public void removeWfNode(WfNode wfNode) {
        if (this.wfNodes == null)
            return;
        this.wfNodes.remove(wfNode);
    }

    public WfNode newWfNode() {
        WfNode res = new WfNode();

        res.setVersion(this.getVersion());

        res.setFlowCode(this.getFlowCode());

        return res;
    }

    public WfNode getFirstNode() {
        if (this.wfNodes == null)
            return null;
        for (WfNode node : wfNodes) {
            if ("B".equals(node.getNodeType()))
                return node;
        }
        return null;
    }

    public Set<FlowNodeInfo> getFlowNodes() {
        return new HashSet<FlowNodeInfo>(wfNodes);
    }

    public void replaceWfNodes(List<WfNode> wfNodes) {
        List<WfNode> newObjs = new ArrayList<WfNode>();
        for (WfNode p : wfNodes) {
            if (p == null)
                continue;
            WfNode newdt = newWfNode();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<WfNode> oldObjs = new HashSet<WfNode>();
        oldObjs.addAll(getWfNodes());

        for (Iterator<WfNode> it = oldObjs.iterator(); it.hasNext();) {
            WfNode odt = it.next();
            found = false;
            for (WfNode newdt : newObjs) {
                if (odt.getNodeId().equals(newdt.getNodeId())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeWfNode(odt);
        }
        oldObjs.clear();
        // insert
        for (WfNode newdt : newObjs) {
            found = false;
            for (Iterator<WfNode> it = getWfNodes().iterator(); it.hasNext();) {
                WfNode odt = it.next();
                if (odt.getNodeId().equals(newdt.getNodeId())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addWfNode(newdt);
        }
    }

    public Set<WfTransition> getWfTransitions() {
        if (this.wfTransitions == null)
            this.wfTransitions = new HashSet<WfTransition>();
        return this.wfTransitions;
    }

    public void setWfTransitions(Set<WfTransition> wfTransitions) {
        this.wfTransitions = wfTransitions;
    }

    public void addWfTransition(WfTransition wfTransition) {
        if (this.wfTransitions == null)
            this.wfTransitions = new HashSet<WfTransition>();
        this.wfTransitions.add(wfTransition);
    }

    public void removeWfTransition(WfTransition wfTransition) {
        if (this.wfTransitions == null)
            return;
        this.wfTransitions.remove(wfTransition);
    }

    public WfTransition newWfTransition() {
        WfTransition res = new WfTransition();

        res.setVersion(this.getVersion());

        res.setWfcode(this.getFlowCode());

        return res;
    }

    public void replaceWfTransitions(List<WfTransition> wfTransitions) {
        List<WfTransition> newObjs = new ArrayList<WfTransition>();
        for (WfTransition p : wfTransitions) {
            if (p == null)
                continue;
            WfTransition newdt = newWfTransition();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<WfTransition> oldObjs = new HashSet<WfTransition>();
        oldObjs.addAll(getWfTransitions());

        for (Iterator<WfTransition> it = oldObjs.iterator(); it.hasNext();) {
            WfTransition odt = it.next();
            found = false;
            for (WfTransition newdt : newObjs) {
                if (odt.getTransid().equals(newdt.getTransid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeWfTransition(odt);
        }
        oldObjs.clear();
        // insert
        for (WfTransition newdt : newObjs) {
            found = false;
            for (Iterator<WfTransition> it = getWfTransitions().iterator(); it
                    .hasNext();) {
                WfTransition odt = it.next();
                if (odt.getTransid().equals(newdt.getTransid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addWfTransition(newdt);
        }
    }

    public Set<FlowStage> getFlowStages() {
        if (this.wfFlowStages == null)
            this.wfFlowStages = new HashSet<WfFlowStage>();
        Set<FlowStage> fsSet = new HashSet<FlowStage>();
        fsSet.addAll(this.wfFlowStages);
        return fsSet;
    }

    public Set<WfFlowStage> getWfFlowStages() {
        if (this.wfFlowStages == null)
            this.wfFlowStages = new HashSet<WfFlowStage>();
        return this.wfFlowStages;
    }

    public void setWfFlowStages(Set<WfFlowStage> wfFlowStages) {
        this.wfFlowStages = wfFlowStages;
    }

    public void addWfFlowStage(WfFlowStage wfFlowStage) {
        wfFlowStage.setFlowCode(this.getFlowCode());
        wfFlowStage.setVersion(this.getVersion());
        this.getWfFlowStages().add(wfFlowStage);
    }

    public void removeWfFlowStage(WfFlowStage wfFlowStage) {
        this.getWfFlowStages().remove(wfFlowStage);
    }

    public WfFlowStage newWfFlowStage() {
        WfFlowStage res = new WfFlowStage();
        res.setVersion(this.getVersion());
        res.setFlowCode(this.getFlowCode());
        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replaceWfFlowStages(Collection<WfFlowStage> wfFlowStages) {
        List<WfFlowStage> newObjs = new ArrayList<WfFlowStage>();
        for (WfFlowStage p : wfFlowStages) {
            if (p == null)
                continue;
            WfFlowStage newdt = newWfFlowStage();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<WfFlowStage> oldObjs = new HashSet<WfFlowStage>();
        oldObjs.addAll(getWfFlowStages());

        for (Iterator<WfFlowStage> it = oldObjs.iterator(); it.hasNext();) {
            WfFlowStage odt = it.next();
            found = false;
            for (WfFlowStage newdt : newObjs) {
                if (odt.getStageId().equals(newdt.getStageId())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeWfFlowStage(odt);
        }
        oldObjs.clear();
        // insert or update
        for (WfFlowStage newdt : newObjs) {
            found = false;
            for (Iterator<WfFlowStage> it = getWfFlowStages().iterator(); it
                    .hasNext();) {
                WfFlowStage odt = it.next();
                if (odt.getStageId().equals(newdt.getStageId())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addWfFlowStage(newdt);
        }
    }

    public void copy(WfFlowDefine other) {

        this.setVersion(other.getVersion());
        this.setFlowCode(other.getFlowCode());

        this.wfname = other.getFlowName();
        this.wfclass = other.getFlowClass();
        this.wfstate = other.getFlowState();
        this.wfdesc = other.getFlowDesc();
        this.wfxmldesc = other.getFlowXmlDesc();
        this.wfPubDate = other.getPublishDate();
        this.optid = other.getOptId();
        this.timeLimit = other.getTimeLimit();
        this.expireOpt = other.getExpireOpt();
        this.atPublishDate = other.getAtPublishDate();
        this.replaceWfFlowStages(other.getWfFlowStages());
    }

    public void copyNotNullProperty(FlowDescribe other) {

        if (other.getVersion() != null)
            this.setVersion(other.getVersion());
        if (other.getFlowCode() != null)
            this.setFlowCode(other.getFlowCode());

        if (other.getFlowName() != null)
            this.wfname = other.getFlowName();
        if (other.getFlowClass() != null)
            this.wfclass = other.getFlowClass();
        if (other.getFlowState() != null)
            this.wfstate = other.getFlowState();
        if (other.getFlowDesc() != null)
            this.wfdesc = other.getFlowDesc();
        if (other.getFlowXmlDesc() != null)
            this.wfxmldesc = other.getFlowXmlDesc();
        if (other.getPublishDate() != null)
            this.wfPubDate = other.getPublishDate();
        if (other.getOptId() != null)
            this.optid = other.getOptId();
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getExpireOpt() != null)
            this.expireOpt = other.getExpireOpt();
        if (other.getAtPublishDate() != null)
            this.atPublishDate = other.getAtPublishDate();
    }

    public void clearProperties() {
        this.setVersion(null);
        this.setFlowCode(null);
        this.wfname = null;
        this.wfclass = null;
        this.wfstate = null;
        this.wfdesc = null;
        this.wfxmldesc = null;
        this.wfPubDate = null;
        this.optid = null;
        this.timeLimit = null;
        this.expireOpt = null;
        this.atPublishDate = null;
        this.getWfFlowStages().clear();
    }
}
