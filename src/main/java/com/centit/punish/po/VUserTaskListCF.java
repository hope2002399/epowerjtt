package com.centit.punish.po;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import com.centit.core.structs2.OptDesc;
import com.centit.core.structs2.Struts2UrlParser;

public class VUserTaskListCF implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long taskId;
    private String punishobjectid;
    private String punishobjectno;
    private String punishobjecttype;
    private String managedepid;
    private Date poorigindate;
    private Date poregisterdate;
    private Date poindagaterepdate;
    private Date pofinishdate;
    private String punishobjectbrief;
    private Long pooccurstate;
    private Long poimpeachstate;
    private String poundertaker;
    private Long punishclassnum;
    private Long pocontrovertype;
    private Long podiscussnum;
    private Long issurpass;
    private String punishobjectstate;
    private String remark;
    private Long ispass;
    private String pooccuradress;
    private Date pooccurdate;
    private String poregisteropinion;
    private String operatorid;
    private String poorigincontext;
    private Date poregistedate;
    private String pooriginstate;
    private String pocaseimpeachphone;
    private String pocaseimpeachunit;
    private String pocaseimpeachid;
    private String pocaseimpeachname;
    private String pocaseimpeachsex;
    private Long pocaseimpeachage;
    private String pocaseimpeachadress;
    private String pocaseimpeachpostcode;
    private String riskdesc;
    private String risktype;
    private String riskresult;
    private Long flowInstId;
    private String bizstate;
    private String biztype;// F未提交，W等待受理，T办理中，C办结
    private String powerid;
    private String powername;
    private String solvestatus;
    private Date solvetime;
    private String solvenote;
    private String optId;// 业务编码
    private Long nodeInstId;
    private String unitCode;
    private String userCode;
    private String authDesc;
    private String flowOptName;
    private String flowOptTag;
    private String nodeName;
    private String nodeType;
    private String nodeOptType;
    private String optName;
    private String methodName;
    private String optParam;
    private String optUrl;
    private String optMethod;
    private String optDesc;
    private String optCode;
    private Date createTime;
    private String expireOpt;
    private Date lastUpdateTime;
    private String lastUpdateUser;
    private Long promiseTime;
    private Long timeLimit;
    private String grantor;
    private String roleType;
    private String roleCode;
    private String inststate;
    private Date nodeCreateTime;
    private Date nodeExpireTime;
    private Long expireOptSign;
    private Date nodeLastUpdateTime;
    private Date flowExpireTime;
    private Long flowTimeLimit;
    private String flowPhase;

    public VUserTaskListCF() {

    }

    public VUserTaskListCF(Long taskId) {
        this.taskId = taskId;

    }

    public VUserTaskListCF(String punishobjectid, String punishobjectno,
            String punishobjecttype, String managedepid, Date poorigindate,
            Date poregisterdate, Date poindagaterepdate, Date pofinishdate,
            String punishobjectbrief, Long pooccurstate, Long poimpeachstate,
            String poundertaker, Long punishclassnum, Long pocontrovertype,
            Long podiscussnum, Long issurpass, String punishobjectstate,
            String remark, Long ispass, String pooccuradress, Date pooccurdate,
            String poregisteropinion, String operatorid,
            String poorigincontext, Date poregistedate, String pooriginstate,
            String pocaseimpeachphone, String pocaseimpeachunit,
            String pocaseimpeachid, String pocaseimpeachname,
            String pocaseimpeachsex, Long pocaseimpeachage,
            String pocaseimpeachadress, String pocaseimpeachpostcode,
            String riskdesc, String risktype, String riskresult,
            Long flowInstId, String bizstate, String biztype, String powerid,
            String powername, String solvestatus, Date solvetime,
            String solvenote, String optId, Long nodeInstId, String unitCode,
            String flowPhase, String userCode, String authDesc,
            String flowOptName, String flowOptTag, String nodeName,
            String nodeType, String nodeOptType, String optName,
            String methodName, String optParam, String optUrl,
            String optMethod, String optDesc, String optCode, Date createTime,
            String expireOpt, Date lastUpdateTime, String lastUpdateUser,
            Long promiseTime, Long timeLimit, String grantor, String roleType,
            String roleCode, String inststate, Date nodeCreateTime,
            Date nodeExpireTime, Long expireOptSign, Date nodeLastUpdateTime,
            Date flowExpireTime, Long flowTimeLimit, Long taskId) {
        this.taskId = taskId;
        this.nodeInstId = nodeInstId;
        this.flowPhase = flowPhase;
        this.unitCode = unitCode;
        this.userCode = userCode;
        this.flowInstId = flowInstId;
        this.authDesc = authDesc;
        this.flowOptName = flowOptName;
        this.flowOptTag = flowOptTag;
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.nodeOptType = nodeOptType;
        this.optName = optName;
        this.methodName = methodName;
        this.optParam = optParam;
        this.optUrl = optUrl;
        this.optMethod = optMethod;
        this.optDesc = optDesc;
        this.optCode = optCode;
        this.createTime = createTime;
        this.expireOpt = expireOpt;
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateUser = lastUpdateUser;
        this.promiseTime = promiseTime;
        this.timeLimit = timeLimit;
        this.grantor = grantor;
        this.roleType = roleType;
        this.roleCode = roleCode;
        this.inststate = inststate;
        this.nodeCreateTime = nodeCreateTime;
        this.nodeExpireTime = nodeExpireTime;
        this.expireOptSign = expireOptSign;
        this.nodeLastUpdateTime = nodeLastUpdateTime;
        this.flowExpireTime = flowExpireTime;
        this.flowTimeLimit = flowTimeLimit;
        this.punishobjectid = punishobjectid;
        this.punishobjectno = punishobjectno;
        this.punishobjecttype = punishobjecttype;
        this.managedepid = managedepid;
        this.poorigindate = poorigindate;
        this.poregisterdate = poregisterdate;
        this.poindagaterepdate = poindagaterepdate;
        this.pofinishdate = pofinishdate;
        this.punishobjectbrief = punishobjectbrief;
        this.pooccurstate = pooccurstate;
        this.poimpeachstate = poimpeachstate;
        this.poundertaker = poundertaker;
        this.punishclassnum = punishclassnum;
        this.pocontrovertype = pocontrovertype;
        this.podiscussnum = podiscussnum;
        this.issurpass = issurpass;
        this.punishobjectstate = punishobjectstate;
        this.remark = remark;
        this.ispass = ispass;
        this.pooccuradress = pooccuradress;
        this.pooccurdate = pooccurdate;
        this.poregisteropinion = poregisteropinion;
        this.operatorid = operatorid;
        this.poorigincontext = poorigincontext;
        this.poregistedate = poregistedate;
        this.pooriginstate = pooriginstate;
        this.pocaseimpeachphone = pocaseimpeachphone;
        this.pocaseimpeachunit = pocaseimpeachunit;
        this.pocaseimpeachid = pocaseimpeachid;
        this.pocaseimpeachname = pocaseimpeachname;
        this.pocaseimpeachsex = pocaseimpeachsex;
        this.pocaseimpeachage = pocaseimpeachage;
        this.pocaseimpeachadress = pocaseimpeachadress;
        this.pocaseimpeachpostcode = pocaseimpeachpostcode;
        this.riskdesc = riskdesc;
        this.risktype = risktype;
        this.riskresult = riskresult;
        this.bizstate = bizstate;
        this.biztype = biztype;
        this.powerid = powerid;
        this.powername = powername;
        this.solvestatus = solvestatus;
        this.solvetime = solvetime;
        this.solvenote = solvenote;
        this.optId = optId;

    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getPunishobjectid() {
        return punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public String getPunishobjectno() {
        return punishobjectno;
    }

    public void setPunishobjectno(String punishobjectno) {
        this.punishobjectno = punishobjectno;
    }

    public String getPunishobjecttype() {
        return punishobjecttype;
    }

    public void setPunishobjecttype(String punishobjecttype) {
        this.punishobjecttype = punishobjecttype;
    }

    public String getManagedepid() {
        return managedepid;
    }

    public void setManagedepid(String managedepid) {
        this.managedepid = managedepid;
    }

    public Date getPoorigindate() {
        return poorigindate;
    }

    public void setPoorigindate(Date poorigindate) {
        this.poorigindate = poorigindate;
    }

    public Date getPoregisterdate() {
        return poregisterdate;
    }

    public void setPoregisterdate(Date poregisterdate) {
        this.poregisterdate = poregisterdate;
    }

    public Date getPoindagaterepdate() {
        return poindagaterepdate;
    }

    public void setPoindagaterepdate(Date poindagaterepdate) {
        this.poindagaterepdate = poindagaterepdate;
    }

    public Date getPofinishdate() {
        return pofinishdate;
    }

    public void setPofinishdate(Date pofinishdate) {
        this.pofinishdate = pofinishdate;
    }

    public String getPunishobjectbrief() {
        return punishobjectbrief;
    }

    public void setPunishobjectbrief(String punishobjectbrief) {
        this.punishobjectbrief = punishobjectbrief;
    }

    public Long getPooccurstate() {
        return pooccurstate;
    }

    public void setPooccurstate(Long pooccurstate) {
        this.pooccurstate = pooccurstate;
    }

    public Long getPoimpeachstate() {
        return poimpeachstate;
    }

    public void setPoimpeachstate(Long poimpeachstate) {
        this.poimpeachstate = poimpeachstate;
    }

    public String getPoundertaker() {
        return poundertaker;
    }

    public void setPoundertaker(String poundertaker) {
        this.poundertaker = poundertaker;
    }

    public Long getPunishclassnum() {
        return punishclassnum;
    }

    public void setPunishclassnum(Long punishclassnum) {
        this.punishclassnum = punishclassnum;
    }

    public Long getPocontrovertype() {
        return pocontrovertype;
    }

    public void setPocontrovertype(Long pocontrovertype) {
        this.pocontrovertype = pocontrovertype;
    }

    public Long getPodiscussnum() {
        return podiscussnum;
    }

    public void setPodiscussnum(Long podiscussnum) {
        this.podiscussnum = podiscussnum;
    }

    public Long getIssurpass() {
        return issurpass;
    }

    public void setIssurpass(Long issurpass) {
        this.issurpass = issurpass;
    }

    public String getPunishobjectstate() {
        return punishobjectstate;
    }

    public void setPunishobjectstate(String punishobjectstate) {
        this.punishobjectstate = punishobjectstate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getIspass() {
        return ispass;
    }

    public void setIspass(Long ispass) {
        this.ispass = ispass;
    }

    public String getPooccuradress() {
        return pooccuradress;
    }

    public void setPooccuradress(String pooccuradress) {
        this.pooccuradress = pooccuradress;
    }

    public Date getPooccurdate() {
        return pooccurdate;
    }

    public void setPooccurdate(Date pooccurdate) {
        this.pooccurdate = pooccurdate;
    }

    public String getPoregisteropinion() {
        return poregisteropinion;
    }

    public void setPoregisteropinion(String poregisteropinion) {
        this.poregisteropinion = poregisteropinion;
    }

    public String getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid;
    }

    public String getPoorigincontext() {
        return poorigincontext;
    }

    public void setPoorigincontext(String poorigincontext) {
        this.poorigincontext = poorigincontext;
    }

    public Date getPoregistedate() {
        return poregistedate;
    }

    public void setPoregistedate(Date poregistedate) {
        this.poregistedate = poregistedate;
    }

    public String getPooriginstate() {
        return pooriginstate;
    }

    public void setPooriginstate(String pooriginstate) {
        this.pooriginstate = pooriginstate;
    }

    public String getPocaseimpeachphone() {
        return pocaseimpeachphone;
    }

    public void setPocaseimpeachphone(String pocaseimpeachphone) {
        this.pocaseimpeachphone = pocaseimpeachphone;
    }

    public String getPocaseimpeachunit() {
        return pocaseimpeachunit;
    }

    public void setPocaseimpeachunit(String pocaseimpeachunit) {
        this.pocaseimpeachunit = pocaseimpeachunit;
    }

    public String getPocaseimpeachid() {
        return pocaseimpeachid;
    }

    public void setPocaseimpeachid(String pocaseimpeachid) {
        this.pocaseimpeachid = pocaseimpeachid;
    }

    public String getPocaseimpeachname() {
        return pocaseimpeachname;
    }

    public void setPocaseimpeachname(String pocaseimpeachname) {
        this.pocaseimpeachname = pocaseimpeachname;
    }

    public String getPocaseimpeachsex() {
        return pocaseimpeachsex;
    }

    public void setPocaseimpeachsex(String pocaseimpeachsex) {
        this.pocaseimpeachsex = pocaseimpeachsex;
    }

    public Long getPocaseimpeachage() {
        return pocaseimpeachage;
    }

    public void setPocaseimpeachage(Long pocaseimpeachage) {
        this.pocaseimpeachage = pocaseimpeachage;
    }

    public String getPocaseimpeachadress() {
        return pocaseimpeachadress;
    }

    public void setPocaseimpeachadress(String pocaseimpeachadress) {
        this.pocaseimpeachadress = pocaseimpeachadress;
    }

    public String getPocaseimpeachpostcode() {
        return pocaseimpeachpostcode;
    }

    public void setPocaseimpeachpostcode(String pocaseimpeachpostcode) {
        this.pocaseimpeachpostcode = pocaseimpeachpostcode;
    }

    public String getRiskdesc() {
        return riskdesc;
    }

    public void setRiskdesc(String riskdesc) {
        this.riskdesc = riskdesc;
    }

    public String getRisktype() {
        return risktype;
    }

    public void setRisktype(String risktype) {
        this.risktype = risktype;
    }

    public String getRiskresult() {
        return riskresult;
    }

    public void setRiskresult(String riskresult) {
        this.riskresult = riskresult;
    }

    public Long getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getBizstate() {
        return bizstate;
    }

    public void setBizstate(String bizstate) {
        this.bizstate = bizstate;
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }

    public String getPowerid() {
        return powerid;
    }

    public void setPowerid(String powerid) {
        this.powerid = powerid;
    }

    public String getPowername() {
        return powername;
    }

    public void setPowername(String powername) {
        this.powername = powername;
    }

    public String getSolvestatus() {
        return solvestatus;
    }

    public void setSolvestatus(String solvestatus) {
        this.solvestatus = solvestatus;
    }

    public Date getSolvetime() {
        return solvetime;
    }

    public void setSolvetime(Date solvetime) {
        this.solvetime = solvetime;
    }

    public String getSolvenote() {
        return solvenote;
    }

    public void setSolvenote(String solvenote) {
        this.solvenote = solvenote;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public Long getNodeInstId() {
        return nodeInstId;
    }

    public void setNodeInstId(Long nodeInstId) {
        this.nodeInstId = nodeInstId;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAuthDesc() {
        return authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc;
    }

    public String getFlowOptName() {
        return flowOptName;
    }

    public void setFlowOptName(String flowOptName) {
        this.flowOptName = flowOptName;
    }

    public String getFlowOptTag() {
        return flowOptTag;
    }

    public void setFlowOptTag(String flowOptTag) {
        this.flowOptTag = flowOptTag;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeOptType() {
        return nodeOptType;
    }

    public void setNodeOptType(String nodeOptType) {
        this.nodeOptType = nodeOptType;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getOptParam() {
        return optParam;
    }

    public void setOptParam(String optParam) {
        this.optParam = optParam;
    }

    public String getOptUrl() {
        return optUrl;
    }

    public void setOptUrl(String optUrl) {
        this.optUrl = optUrl;
    }

    public String getOptMethod() {
        return optMethod;
    }

    public void setOptMethod(String optMethod) {
        this.optMethod = optMethod;
    }

    public String getOptDesc() {
        return optDesc;
    }

    public void setOptDesc(String optDesc) {
        this.optDesc = optDesc;
    }

    public String getOptCode() {
        return optCode;
    }

    public void setOptCode(String optCode) {
        this.optCode = optCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExpireOpt() {
        return expireOpt;
    }

    public void setExpireOpt(String expireOpt) {
        this.expireOpt = expireOpt;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Long getPromiseTime() {
        return promiseTime;
    }

    public void setPromiseTime(Long promiseTime) {
        this.promiseTime = promiseTime;
    }

    public Long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getInststate() {
        return inststate;
    }

    public void setInststate(String inststate) {
        this.inststate = inststate;
    }

    public Date getNodeCreateTime() {
        return nodeCreateTime;
    }

    public void setNodeCreateTime(Date nodeCreateTime) {
        this.nodeCreateTime = nodeCreateTime;
    }

    public Date getNodeExpireTime() {
        return nodeExpireTime;
    }

    public void setNodeExpireTime(Date nodeExpireTime) {
        this.nodeExpireTime = nodeExpireTime;
    }

    public Long getExpireOptSign() {
        return expireOptSign;
    }

    public void setExpireOptSign(Long expireOptSign) {
        this.expireOptSign = expireOptSign;
    }

    public Date getNodeLastUpdateTime() {
        return nodeLastUpdateTime;
    }

    public void setNodeLastUpdateTime(Date nodeLastUpdateTime) {
        this.nodeLastUpdateTime = nodeLastUpdateTime;
    }

    public Date getFlowExpireTime() {
        return flowExpireTime;
    }

    public void setFlowExpireTime(Date flowExpireTime) {
        this.flowExpireTime = flowExpireTime;
    }

    public Long getFlowTimeLimit() {
        return flowTimeLimit;
    }

    public void setFlowTimeLimit(Long flowTimeLimit) {
        this.flowTimeLimit = flowTimeLimit;
    }

    public String getFlowPhase() {
        return flowPhase;
    }

    public void setFlowPhase(String flowPhase) {
        this.flowPhase = flowPhase;
    }

    public String getNodeOptUrl() {
        if (optUrl == null) {
            return null;
        }

        OptDesc optDesc = Struts2UrlParser.parseUrl(optUrl);
        optDesc.setMethod(optMethod);
        String url = optDesc.getOptUrl() + "?nodeInstId="
                + this.getNodeInstId() + "&flowInstId=" + flowInstId
                + "&flowPhase=" + flowPhase;
        // System.out.println(url);
        if (grantor != null && !"".equals(grantor)) {// &&
                                                     // !grantor.equals(userCode)){
            url = url + "&isGrantor=yes&grantor=" + grantor;
        }
        if (optParam != null && !"".equals(optParam))
            url = url + "&" + optParam;

        try {
            url = URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "/sampleflow/flowUserTask!todoWork.do?nodeInstId="
                + this.getNodeInstId() + "&flowInstId=" + flowInstId
                + "&nodeOptUrl=" + url;
    }
}
