package com.centit.punish.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.centit.powerruntime.po.VOrgSupPower;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Punishobjectbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

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

    private String caseno;// 业务文书案号
    private String transaffairname;

    private String optId;// 业务编码

    private Set<Poenterprise> poenterprises = null;// new
                                                   // ArrayList<Poenterprise>();
    private Set<Poindividual> poindividuals = null;// new
                                                   // ArrayList<Poindividual>();
    private Set<Poregisterbasic> poregisterbasics = null;// new
                                                         // ArrayList<Poregisterbasic>();
    private Set<Poindagaterepbasic> poindagaterepbasics = null;// new
                                                               // ArrayList<Poindagaterepbasic>();
    private Set<Podiscussbasic> podiscussbasics = null;// new
                                                       // ArrayList<Podiscussbasic>();
    private Set<Poreceiptinfo> poreceiptinfos = null;// new
                                                     // ArrayList<Poreceiptinfo>();
    private Set<Powitnessbasic> powitnessbasics = null;// new
                                                       // ArrayList<Powitnessbasic>();
    private Set<Poexcucebasic> poexcucebasics = null;// new
                                                     // ArrayList<Poexcucebasic>();
    private Set<Pounwitnessbasic> pounwitnessbasics = null;// new
                                                           // ArrayList<Pounwitnessbasic>();
    private Set<Poapprovebasic> poapprovebasics = null;// new
                                                       // ArrayList<Poapprovebasic>();
    private Set<Pofinishbasic> pofinishbasics = null;// new
                                                     // ArrayList<Pofinishbasic>();
    private Set<Poundertakebasic> poundertakebasics = null;// new
                                                           // ArrayList<Poundertakebasic>();
    private Set<Popunishbasic> popunishbasics = null;// new
                                                     // ArrayList<Popunishbasic>();
    private Set<Potranslawbasic> potranslawbasics = null;// new
                                                         // ArrayList<Potranslawbasic>();
    private Set<Poresultbasic> poresultbasics = null;// new
                                                     // ArrayList<Poresultbasic>();

    private Poindividual poindividual;
    private Poenterprise poenterprise;

    // 权力编码
    private String item_id;
    private String version;
    private String itemName;
    private String poIndagateRepResult;
    private String degreeno;

    private VOrgSupPower vorgsuppower;

    public VOrgSupPower getVorgsuppower() {
        return vorgsuppower;
    }

    public void setVorgsuppower(VOrgSupPower vorgsuppower) {
        this.vorgsuppower = vorgsuppower;
    }

    public String getCaseno() {
        return caseno;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno;
    }

    public String getPoIndagateRepResult() {
        return poIndagateRepResult;
    }

    public void setPoIndagateRepResult(String poIndagateRepResult) {
        this.poIndagateRepResult = poIndagateRepResult;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Poenterprise getPoenterprise() {
        return poenterprise;
    }

    public void setPoenterprise(Poenterprise poenterprise) {
        this.poenterprise = poenterprise;
    }

    public Poindividual getPoindividual() {
        return poindividual;
    }

    public void setPoindividual(Poindividual poindividual) {
        this.poindividual = poindividual;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    // Constructors
    /** default constructor */
    public Punishobjectbasic() {
    }

    /** minimal constructor */
    public Punishobjectbasic(String punishobjectid) {

        this.punishobjectid = punishobjectid;

    }

    public Punishobjectbasic(String punishobjectid, String punishobjectno,
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
            String solvenote, String optId, String transaffairname) {
        super();
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
        this.flowInstId = flowInstId;
        this.bizstate = bizstate;
        this.biztype = biztype;
        this.powerid = powerid;
        this.powername = powername;
        this.solvestatus = solvestatus;
        this.solvetime = solvetime;
        this.solvenote = solvenote;
        this.optId = optId;
        this.transaffairname = transaffairname;
    }

    /** full constructor */
    public Punishobjectbasic(String punishobjectid, String punishobjectno,
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
            String riskdesc, String risktype, String riskresult) {

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
    }

    public Punishobjectbasic(String punishobjectid, String punishobjectno,
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
            String solvenote, String optId, Set<Poenterprise> poenterprises,
            Set<Poindividual> poindividuals,
            Set<Poregisterbasic> poregisterbasics,
            Set<Poindagaterepbasic> poindagaterepbasics,
            Set<Podiscussbasic> podiscussbasics,
            Set<Poreceiptinfo> poreceiptinfos,
            Set<Powitnessbasic> powitnessbasics,
            Set<Poexcucebasic> poexcucebasics,
            Set<Pounwitnessbasic> pounwitnessbasics,
            Set<Poapprovebasic> poapprovebasics,
            Set<Pofinishbasic> pofinishbasics,
            Set<Poundertakebasic> poundertakebasics,
            Set<Popunishbasic> popunishbasics,
            Set<Potranslawbasic> potranslawbasics,
            Set<Poresultbasic> poresultbasics, Poindividual poindividual,
            Poenterprise poenterprise) {
        super();
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
        this.flowInstId = flowInstId;
        this.bizstate = bizstate;
        this.biztype = biztype;
        this.powerid = powerid;
        this.powername = powername;
        this.solvestatus = solvestatus;
        this.solvetime = solvetime;
        this.solvenote = solvenote;
        this.optId = optId;
        this.poenterprises = poenterprises;
        this.poindividuals = poindividuals;
        this.poregisterbasics = poregisterbasics;
        this.poindagaterepbasics = poindagaterepbasics;
        this.podiscussbasics = podiscussbasics;
        this.poreceiptinfos = poreceiptinfos;
        this.powitnessbasics = powitnessbasics;
        this.poexcucebasics = poexcucebasics;
        this.pounwitnessbasics = pounwitnessbasics;
        this.poapprovebasics = poapprovebasics;
        this.pofinishbasics = pofinishbasics;
        this.poundertakebasics = poundertakebasics;
        this.popunishbasics = popunishbasics;
        this.potranslawbasics = potranslawbasics;
        this.poresultbasics = poresultbasics;
        this.poindividual = poindividual;
        this.poenterprise = poenterprise;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public String getPunishobjectno() {
        return this.punishobjectno;
    }

    public void setPunishobjectno(String punishobjectno) {
        this.punishobjectno = punishobjectno;
    }

    public String getPunishobjecttype() {
        return this.punishobjecttype;
    }

    public void setPunishobjecttype(String punishobjecttype) {
        this.punishobjecttype = punishobjecttype;
    }

    public String getManagedepid() {
        return this.managedepid;
    }

    public void setManagedepid(String managedepid) {
        this.managedepid = managedepid;
    }

    public Date getPoorigindate() {
        return this.poorigindate;
    }

    public void setPoorigindate(Date poorigindate) {
        this.poorigindate = poorigindate;
    }

    public Date getPoregisterdate() {
        return this.poregisterdate;
    }

    public void setPoregisterdate(Date poregisterdate) {
        this.poregisterdate = poregisterdate;
    }

    public Date getPoindagaterepdate() {
        return this.poindagaterepdate;
    }

    public void setPoindagaterepdate(Date poindagaterepdate) {
        this.poindagaterepdate = poindagaterepdate;
    }

    public Date getPofinishdate() {
        return this.pofinishdate;
    }

    public void setPofinishdate(Date pofinishdate) {
        this.pofinishdate = pofinishdate;
    }

    public String getPunishobjectbrief() {
        return this.punishobjectbrief;
    }

    public void setPunishobjectbrief(String punishobjectbrief) {
        this.punishobjectbrief = punishobjectbrief;
    }

    public Long getPooccurstate() {
        return this.pooccurstate;
    }

    public void setPooccurstate(Long pooccurstate) {
        this.pooccurstate = pooccurstate;
    }

    public Long getPoimpeachstate() {
        return this.poimpeachstate;
    }

    public void setPoimpeachstate(Long poimpeachstate) {
        this.poimpeachstate = poimpeachstate;
    }

    public String getPoundertaker() {
        return this.poundertaker;
    }

    public void setPoundertaker(String poundertaker) {
        this.poundertaker = poundertaker;
    }

    public Long getPunishclassnum() {
        return this.punishclassnum;
    }

    public void setPunishclassnum(Long punishclassnum) {
        this.punishclassnum = punishclassnum;
    }

    public Long getPocontrovertype() {
        return this.pocontrovertype;
    }

    public void setPocontrovertype(Long pocontrovertype) {
        this.pocontrovertype = pocontrovertype;
    }

    public Long getPodiscussnum() {
        return this.podiscussnum;
    }

    public void setPodiscussnum(Long podiscussnum) {
        this.podiscussnum = podiscussnum;
    }

    public Long getIssurpass() {
        return this.issurpass;
    }

    public void setIssurpass(Long issurpass) {
        this.issurpass = issurpass;
    }

    public String getPunishobjectstate() {
        return this.punishobjectstate;
    }

    public void setPunishobjectstate(String punishobjectstate) {
        this.punishobjectstate = punishobjectstate;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getIspass() {
        return this.ispass;
    }

    public void setIspass(Long ispass) {
        this.ispass = ispass;
    }

    public String getPooccuradress() {
        return this.pooccuradress;
    }

    public void setPooccuradress(String pooccuradress) {
        this.pooccuradress = pooccuradress;
    }

    public Date getPooccurdate() {
        return this.pooccurdate;
    }

    public void setPooccurdate(Date pooccurdate) {
        this.pooccurdate = pooccurdate;
    }

    public String getPoregisteropinion() {
        return this.poregisteropinion;
    }

    public void setPoregisteropinion(String poregisteropinion) {
        this.poregisteropinion = poregisteropinion;
    }

    public String getOperatorid() {
        return this.operatorid;
    }

    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid;
    }

    public String getPoorigincontext() {
        return this.poorigincontext;
    }

    public void setPoorigincontext(String poorigincontext) {
        this.poorigincontext = poorigincontext;
    }

    public Date getPoregistedate() {
        /*
         * if(null==this.poregistedate){ this.poregistedate=new
         * Date(System.currentTimeMillis()); }
         */
        return this.poregistedate;
    }

    public void setPoregistedate(Date poregistedate) {

        this.poregistedate = poregistedate;
    }

    public String getPooriginstate() {
        return this.pooriginstate;
    }

    public void setPooriginstate(String pooriginstate) {
        this.pooriginstate = pooriginstate;
    }

    public String getPocaseimpeachphone() {
        return this.pocaseimpeachphone;
    }

    public void setPocaseimpeachphone(String pocaseimpeachphone) {
        this.pocaseimpeachphone = pocaseimpeachphone;
    }

    public String getPocaseimpeachunit() {
        return this.pocaseimpeachunit;
    }

    public void setPocaseimpeachunit(String pocaseimpeachunit) {
        this.pocaseimpeachunit = pocaseimpeachunit;
    }

    public String getPocaseimpeachid() {
        return this.pocaseimpeachid;
    }

    public void setPocaseimpeachid(String pocaseimpeachid) {
        this.pocaseimpeachid = pocaseimpeachid;
    }

    public String getPocaseimpeachname() {
        return this.pocaseimpeachname;
    }

    public void setPocaseimpeachname(String pocaseimpeachname) {
        this.pocaseimpeachname = pocaseimpeachname;
    }

    public String getPocaseimpeachsex() {
        return this.pocaseimpeachsex;
    }

    public void setPocaseimpeachsex(String pocaseimpeachsex) {
        this.pocaseimpeachsex = pocaseimpeachsex;
    }

    public Long getPocaseimpeachage() {
        return this.pocaseimpeachage;
    }

    public void setPocaseimpeachage(Long pocaseimpeachage) {
        this.pocaseimpeachage = pocaseimpeachage;
    }

    public String getPocaseimpeachadress() {
        return this.pocaseimpeachadress;
    }

    public void setPocaseimpeachadress(String pocaseimpeachadress) {
        this.pocaseimpeachadress = pocaseimpeachadress;
    }

    public String getPocaseimpeachpostcode() {
        return this.pocaseimpeachpostcode;
    }

    public void setPocaseimpeachpostcode(String pocaseimpeachpostcode) {
        this.pocaseimpeachpostcode = pocaseimpeachpostcode;
    }

    public String getRiskdesc() {
        return this.riskdesc;
    }

    public void setRiskdesc(String riskdesc) {
        this.riskdesc = riskdesc;
    }

    public String getRisktype() {
        return this.risktype;
    }

    public void setRisktype(String risktype) {
        this.risktype = risktype;
    }

    public String getRiskresult() {
        return this.riskresult;
    }

    public void setRiskresult(String riskresult) {
        this.riskresult = riskresult;
    }

    public Set<Poenterprise> getPoenterprises() {
        if (this.poenterprises == null)
            this.poenterprises = new HashSet<Poenterprise>();
        return this.poenterprises;
    }

    public void setPoenterprises(Set<Poenterprise> poenterprises) {
        this.poenterprises = poenterprises;
    }

    public void addPoenterprise(Poenterprise poenterprise) {
        if (this.poenterprises == null)
            this.poenterprises = new HashSet<Poenterprise>();
        this.poenterprises.add(poenterprise);
    }

    public void removePoenterprise(Poenterprise poenterprise) {
        if (this.poenterprises == null)
            return;
        this.poenterprises.remove(poenterprise);
    }

    public Poenterprise newPoenterprise() {
        Poenterprise res = new Poenterprise();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePoenterprises(List<Poenterprise> poenterprises) {
        List<Poenterprise> newObjs = new ArrayList<Poenterprise>();
        for (Poenterprise p : poenterprises) {
            if (p == null)
                continue;
            Poenterprise newdt = newPoenterprise();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Poenterprise> oldObjs = new HashSet<Poenterprise>();
        oldObjs.addAll(getPoenterprises());

        for (Iterator<Poenterprise> it = oldObjs.iterator(); it.hasNext();) {
            Poenterprise odt = it.next();
            found = false;
            for (Poenterprise newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePoenterprise(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Poenterprise newdt : newObjs) {
            found = false;
            for (Iterator<Poenterprise> it = getPoenterprises().iterator(); it
                    .hasNext();) {
                Poenterprise odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPoenterprise(newdt);
        }
    }

    public Set<Poindividual> getPoindividuals() {
        if (this.poindividuals == null)
            this.poindividuals = new HashSet<Poindividual>();
        return this.poindividuals;
    }

    public void setPoindividuals(Set<Poindividual> poindividuals) {
        this.poindividuals = poindividuals;
    }

    public void addPoindividual(Poindividual poindividual) {
        if (this.poindividuals == null)
            this.poindividuals = new HashSet<Poindividual>();
        this.poindividuals.add(poindividual);
    }

    public void removePoindividual(Poindividual poindividual) {
        if (this.poindividuals == null)
            return;
        this.poindividuals.remove(poindividual);
    }

    public Poindividual newPoindividual() {
        Poindividual res = new Poindividual();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePoindividuals(List<Poindividual> poindividuals) {
        List<Poindividual> newObjs = new ArrayList<Poindividual>();
        for (Poindividual p : poindividuals) {
            if (p == null)
                continue;
            Poindividual newdt = newPoindividual();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Poindividual> oldObjs = new HashSet<Poindividual>();
        oldObjs.addAll(getPoindividuals());

        for (Iterator<Poindividual> it = oldObjs.iterator(); it.hasNext();) {
            Poindividual odt = it.next();
            found = false;
            for (Poindividual newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePoindividual(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Poindividual newdt : newObjs) {
            found = false;
            for (Iterator<Poindividual> it = getPoindividuals().iterator(); it
                    .hasNext();) {
                Poindividual odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPoindividual(newdt);
        }
    }

    public Set<Poregisterbasic> getPoregisterbasics() {
        if (this.poregisterbasics == null)
            this.poregisterbasics = new HashSet<Poregisterbasic>();
        return this.poregisterbasics;
    }

    public void setPoregisterbasics(Set<Poregisterbasic> poregisterbasics) {
        this.poregisterbasics = poregisterbasics;
    }

    public void addPoregisterbasic(Poregisterbasic poregisterbasic) {
        if (this.poregisterbasics == null)
            this.poregisterbasics = new HashSet<Poregisterbasic>();
        this.poregisterbasics.add(poregisterbasic);
    }

    public void removePoregisterbasic(Poregisterbasic poregisterbasic) {
        if (this.poregisterbasics == null)
            return;
        this.poregisterbasics.remove(poregisterbasic);
    }

    public Poregisterbasic newPoregisterbasic() {
        Poregisterbasic res = new Poregisterbasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePoregisterbasics(List<Poregisterbasic> poregisterbasics) {
        List<Poregisterbasic> newObjs = new ArrayList<Poregisterbasic>();
        for (Poregisterbasic p : poregisterbasics) {
            if (p == null)
                continue;
            Poregisterbasic newdt = newPoregisterbasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Poregisterbasic> oldObjs = new HashSet<Poregisterbasic>();
        oldObjs.addAll(getPoregisterbasics());

        for (Iterator<Poregisterbasic> it = oldObjs.iterator(); it.hasNext();) {
            Poregisterbasic odt = it.next();
            found = false;
            for (Poregisterbasic newdt : newObjs) {
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePoregisterbasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Poregisterbasic newdt : newObjs) {
            found = false;
            for (Iterator<Poregisterbasic> it = getPoregisterbasics()
                    .iterator(); it.hasNext();) {
                Poregisterbasic odt = it.next();
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPoregisterbasic(newdt);
        }
    }

    public Set<Poindagaterepbasic> getPoindagaterepbasics() {
        if (this.poindagaterepbasics == null)
            this.poindagaterepbasics = new HashSet<Poindagaterepbasic>();
        return this.poindagaterepbasics;
    }

    public void setPoindagaterepbasics(
            Set<Poindagaterepbasic> poindagaterepbasics) {
        this.poindagaterepbasics = poindagaterepbasics;
    }

    public void addPoindagaterepbasic(Poindagaterepbasic poindagaterepbasic) {
        if (this.poindagaterepbasics == null)
            this.poindagaterepbasics = new HashSet<Poindagaterepbasic>();
        this.poindagaterepbasics.add(poindagaterepbasic);
    }

    public void removePoindagaterepbasic(Poindagaterepbasic poindagaterepbasic) {
        if (this.poindagaterepbasics == null)
            return;
        this.poindagaterepbasics.remove(poindagaterepbasic);
    }

    public Poindagaterepbasic newPoindagaterepbasic() {
        Poindagaterepbasic res = new Poindagaterepbasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePoindagaterepbasics(
            List<Poindagaterepbasic> poindagaterepbasics) {
        List<Poindagaterepbasic> newObjs = new ArrayList<Poindagaterepbasic>();
        for (Poindagaterepbasic p : poindagaterepbasics) {
            if (p == null)
                continue;
            Poindagaterepbasic newdt = newPoindagaterepbasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Poindagaterepbasic> oldObjs = new HashSet<Poindagaterepbasic>();
        oldObjs.addAll(getPoindagaterepbasics());

        for (Iterator<Poindagaterepbasic> it = oldObjs.iterator(); it.hasNext();) {
            Poindagaterepbasic odt = it.next();
            found = false;
            for (Poindagaterepbasic newdt : newObjs) {
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePoindagaterepbasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Poindagaterepbasic newdt : newObjs) {
            found = false;
            for (Iterator<Poindagaterepbasic> it = getPoindagaterepbasics()
                    .iterator(); it.hasNext();) {
                Poindagaterepbasic odt = it.next();
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPoindagaterepbasic(newdt);
        }
    }

    public Set<Podiscussbasic> getPodiscussbasics() {
        if (this.podiscussbasics == null)
            this.podiscussbasics = new HashSet<Podiscussbasic>();
        return this.podiscussbasics;
    }

    public void setPodiscussbasics(Set<Podiscussbasic> podiscussbasics) {
        this.podiscussbasics = podiscussbasics;
    }

    public void addPodiscussbasic(Podiscussbasic podiscussbasic) {
        if (this.podiscussbasics == null)
            this.podiscussbasics = new HashSet<Podiscussbasic>();
        this.podiscussbasics.add(podiscussbasic);
    }

    public void removePodiscussbasic(Podiscussbasic podiscussbasic) {
        if (this.podiscussbasics == null)
            return;
        this.podiscussbasics.remove(podiscussbasic);
    }

    public Podiscussbasic newPodiscussbasic() {
        Podiscussbasic res = new Podiscussbasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePodiscussbasics(List<Podiscussbasic> podiscussbasics) {
        List<Podiscussbasic> newObjs = new ArrayList<Podiscussbasic>();
        for (Podiscussbasic p : podiscussbasics) {
            if (p == null)
                continue;
            Podiscussbasic newdt = newPodiscussbasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Podiscussbasic> oldObjs = new HashSet<Podiscussbasic>();
        oldObjs.addAll(getPodiscussbasics());

        for (Iterator<Podiscussbasic> it = oldObjs.iterator(); it.hasNext();) {
            Podiscussbasic odt = it.next();
            found = false;
            for (Podiscussbasic newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePodiscussbasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Podiscussbasic newdt : newObjs) {
            found = false;
            for (Iterator<Podiscussbasic> it = getPodiscussbasics().iterator(); it
                    .hasNext();) {
                Podiscussbasic odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPodiscussbasic(newdt);
        }
    }

    public Set<Poreceiptinfo> getPoreceiptinfos() {
        if (this.poreceiptinfos == null)
            this.poreceiptinfos = new HashSet<Poreceiptinfo>();
        return this.poreceiptinfos;
    }

    public void setPoreceiptinfos(Set<Poreceiptinfo> poreceiptinfos) {
        this.poreceiptinfos = poreceiptinfos;
    }

    public void addPoreceiptinfo(Poreceiptinfo poreceiptinfo) {
        if (this.poreceiptinfos == null)
            this.poreceiptinfos = new HashSet<Poreceiptinfo>();
        this.poreceiptinfos.add(poreceiptinfo);
    }

    public void removePoreceiptinfo(Poreceiptinfo poreceiptinfo) {
        if (this.poreceiptinfos == null)
            return;
        this.poreceiptinfos.remove(poreceiptinfo);
    }

    public Poreceiptinfo newPoreceiptinfo() {
        Poreceiptinfo res = new Poreceiptinfo();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePoreceiptinfos(List<Poreceiptinfo> poreceiptinfos) {
        List<Poreceiptinfo> newObjs = new ArrayList<Poreceiptinfo>();
        for (Poreceiptinfo p : poreceiptinfos) {
            if (p == null)
                continue;
            Poreceiptinfo newdt = newPoreceiptinfo();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Poreceiptinfo> oldObjs = new HashSet<Poreceiptinfo>();
        oldObjs.addAll(getPoreceiptinfos());

        for (Iterator<Poreceiptinfo> it = oldObjs.iterator(); it.hasNext();) {
            Poreceiptinfo odt = it.next();
            found = false;
            for (Poreceiptinfo newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePoreceiptinfo(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Poreceiptinfo newdt : newObjs) {
            found = false;
            for (Iterator<Poreceiptinfo> it = getPoreceiptinfos().iterator(); it
                    .hasNext();) {
                Poreceiptinfo odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPoreceiptinfo(newdt);
        }
    }

    public Set<Powitnessbasic> getPowitnessbasics() {
        if (this.powitnessbasics == null)
            this.powitnessbasics = new HashSet<Powitnessbasic>();
        return this.powitnessbasics;
    }

    public void setPowitnessbasics(Set<Powitnessbasic> powitnessbasics) {
        this.powitnessbasics = powitnessbasics;
    }

    public void addPowitnessbasic(Powitnessbasic powitnessbasic) {
        if (this.powitnessbasics == null)
            this.powitnessbasics = new HashSet<Powitnessbasic>();
        this.powitnessbasics.add(powitnessbasic);
    }

    public void removePowitnessbasic(Powitnessbasic powitnessbasic) {
        if (this.powitnessbasics == null)
            return;
        this.powitnessbasics.remove(powitnessbasic);
    }

    public Powitnessbasic newPowitnessbasic() {
        Powitnessbasic res = new Powitnessbasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePowitnessbasics(List<Powitnessbasic> powitnessbasics) {
        List<Powitnessbasic> newObjs = new ArrayList<Powitnessbasic>();
        for (Powitnessbasic p : powitnessbasics) {
            if (p == null)
                continue;
            Powitnessbasic newdt = newPowitnessbasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Powitnessbasic> oldObjs = new HashSet<Powitnessbasic>();
        oldObjs.addAll(getPowitnessbasics());

        for (Iterator<Powitnessbasic> it = oldObjs.iterator(); it.hasNext();) {
            Powitnessbasic odt = it.next();
            found = false;
            for (Powitnessbasic newdt : newObjs) {
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePowitnessbasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Powitnessbasic newdt : newObjs) {
            found = false;
            for (Iterator<Powitnessbasic> it = getPowitnessbasics().iterator(); it
                    .hasNext();) {
                Powitnessbasic odt = it.next();
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPowitnessbasic(newdt);
        }
    }

    public Set<Poexcucebasic> getPoexcucebasics() {
        if (this.poexcucebasics == null)
            this.poexcucebasics = new HashSet<Poexcucebasic>();
        return this.poexcucebasics;
    }

    public void setPoexcucebasics(Set<Poexcucebasic> poexcucebasics) {
        this.poexcucebasics = poexcucebasics;
    }

    public void addPoexcucebasic(Poexcucebasic poexcucebasic) {
        if (this.poexcucebasics == null)
            this.poexcucebasics = new HashSet<Poexcucebasic>();
        this.poexcucebasics.add(poexcucebasic);
    }

    public void removePoexcucebasic(Poexcucebasic poexcucebasic) {
        if (this.poexcucebasics == null)
            return;
        this.poexcucebasics.remove(poexcucebasic);
    }

    public Poexcucebasic newPoexcucebasic() {
        Poexcucebasic res = new Poexcucebasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePoexcucebasics(List<Poexcucebasic> poexcucebasics) {
        List<Poexcucebasic> newObjs = new ArrayList<Poexcucebasic>();
        for (Poexcucebasic p : poexcucebasics) {
            if (p == null)
                continue;
            Poexcucebasic newdt = newPoexcucebasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Poexcucebasic> oldObjs = new HashSet<Poexcucebasic>();
        oldObjs.addAll(getPoexcucebasics());

        for (Iterator<Poexcucebasic> it = oldObjs.iterator(); it.hasNext();) {
            Poexcucebasic odt = it.next();
            found = false;
            for (Poexcucebasic newdt : newObjs) {
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePoexcucebasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Poexcucebasic newdt : newObjs) {
            found = false;
            for (Iterator<Poexcucebasic> it = getPoexcucebasics().iterator(); it
                    .hasNext();) {
                Poexcucebasic odt = it.next();
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPoexcucebasic(newdt);
        }
    }

    public Set<Pounwitnessbasic> getPounwitnessbasics() {
        if (this.pounwitnessbasics == null)
            this.pounwitnessbasics = new HashSet<Pounwitnessbasic>();
        return this.pounwitnessbasics;
    }

    public void setPounwitnessbasics(Set<Pounwitnessbasic> pounwitnessbasics) {
        this.pounwitnessbasics = pounwitnessbasics;
    }

    public void addPounwitnessbasic(Pounwitnessbasic pounwitnessbasic) {
        if (this.pounwitnessbasics == null)
            this.pounwitnessbasics = new HashSet<Pounwitnessbasic>();
        this.pounwitnessbasics.add(pounwitnessbasic);
    }

    public void removePounwitnessbasic(Pounwitnessbasic pounwitnessbasic) {
        if (this.pounwitnessbasics == null)
            return;
        this.pounwitnessbasics.remove(pounwitnessbasic);
    }

    public Pounwitnessbasic newPounwitnessbasic() {
        Pounwitnessbasic res = new Pounwitnessbasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePounwitnessbasics(
            List<Pounwitnessbasic> pounwitnessbasics) {
        List<Pounwitnessbasic> newObjs = new ArrayList<Pounwitnessbasic>();
        for (Pounwitnessbasic p : pounwitnessbasics) {
            if (p == null)
                continue;
            Pounwitnessbasic newdt = newPounwitnessbasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Pounwitnessbasic> oldObjs = new HashSet<Pounwitnessbasic>();
        oldObjs.addAll(getPounwitnessbasics());

        for (Iterator<Pounwitnessbasic> it = oldObjs.iterator(); it.hasNext();) {
            Pounwitnessbasic odt = it.next();
            found = false;
            for (Pounwitnessbasic newdt : newObjs) {
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePounwitnessbasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Pounwitnessbasic newdt : newObjs) {
            found = false;
            for (Iterator<Pounwitnessbasic> it = getPounwitnessbasics()
                    .iterator(); it.hasNext();) {
                Pounwitnessbasic odt = it.next();
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPounwitnessbasic(newdt);
        }
    }

    public Set<Poapprovebasic> getPoapprovebasics() {
        if (this.poapprovebasics == null)
            this.poapprovebasics = new HashSet<Poapprovebasic>();
        return this.poapprovebasics;
    }

    public void setPoapprovebasics(Set<Poapprovebasic> poapprovebasics) {
        this.poapprovebasics = poapprovebasics;
    }

    public void addPoapprovebasic(Poapprovebasic poapprovebasic) {
        if (this.poapprovebasics == null)
            this.poapprovebasics = new HashSet<Poapprovebasic>();
        this.poapprovebasics.add(poapprovebasic);
    }

    public void removePoapprovebasic(Poapprovebasic poapprovebasic) {
        if (this.poapprovebasics == null)
            return;
        this.poapprovebasics.remove(poapprovebasic);
    }

    public Poapprovebasic newPoapprovebasic() {
        Poapprovebasic res = new Poapprovebasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePoapprovebasics(List<Poapprovebasic> poapprovebasics) {
        List<Poapprovebasic> newObjs = new ArrayList<Poapprovebasic>();
        for (Poapprovebasic p : poapprovebasics) {
            if (p == null)
                continue;
            Poapprovebasic newdt = newPoapprovebasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Poapprovebasic> oldObjs = new HashSet<Poapprovebasic>();
        oldObjs.addAll(getPoapprovebasics());

        for (Iterator<Poapprovebasic> it = oldObjs.iterator(); it.hasNext();) {
            Poapprovebasic odt = it.next();
            found = false;
            for (Poapprovebasic newdt : newObjs) {
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePoapprovebasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Poapprovebasic newdt : newObjs) {
            found = false;
            for (Iterator<Poapprovebasic> it = getPoapprovebasics().iterator(); it
                    .hasNext();) {
                Poapprovebasic odt = it.next();
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPoapprovebasic(newdt);
        }
    }

    public Set<Pofinishbasic> getPofinishbasics() {
        if (this.pofinishbasics == null)
            this.pofinishbasics = new HashSet<Pofinishbasic>();
        return this.pofinishbasics;
    }

    public void setPofinishbasics(Set<Pofinishbasic> pofinishbasics) {
        this.pofinishbasics = pofinishbasics;
    }

    public void addPofinishbasic(Pofinishbasic pofinishbasic) {
        if (this.pofinishbasics == null)
            this.pofinishbasics = new HashSet<Pofinishbasic>();
        this.pofinishbasics.add(pofinishbasic);
    }

    public void removePofinishbasic(Pofinishbasic pofinishbasic) {
        if (this.pofinishbasics == null)
            return;
        this.pofinishbasics.remove(pofinishbasic);
    }

    public Pofinishbasic newPofinishbasic() {
        Pofinishbasic res = new Pofinishbasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePofinishbasics(List<Pofinishbasic> pofinishbasics) {
        List<Pofinishbasic> newObjs = new ArrayList<Pofinishbasic>();
        for (Pofinishbasic p : pofinishbasics) {
            if (p == null)
                continue;
            Pofinishbasic newdt = newPofinishbasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Pofinishbasic> oldObjs = new HashSet<Pofinishbasic>();
        oldObjs.addAll(getPofinishbasics());

        for (Iterator<Pofinishbasic> it = oldObjs.iterator(); it.hasNext();) {
            Pofinishbasic odt = it.next();
            found = false;
            for (Pofinishbasic newdt : newObjs) {
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePofinishbasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Pofinishbasic newdt : newObjs) {
            found = false;
            for (Iterator<Pofinishbasic> it = getPofinishbasics().iterator(); it
                    .hasNext();) {
                Pofinishbasic odt = it.next();
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPofinishbasic(newdt);
        }
    }

    public Set<Poundertakebasic> getPoundertakebasics() {
        if (this.poundertakebasics == null)
            this.poundertakebasics = new HashSet<Poundertakebasic>();
        return this.poundertakebasics;
    }

    public void setPoundertakebasics(Set<Poundertakebasic> poundertakebasics) {
        this.poundertakebasics = poundertakebasics;
    }

    public void addPoundertakebasic(Poundertakebasic poundertakebasic) {
        if (this.poundertakebasics == null)
            this.poundertakebasics = new HashSet<Poundertakebasic>();
        this.poundertakebasics.add(poundertakebasic);
    }

    public void removePoundertakebasic(Poundertakebasic poundertakebasic) {
        if (this.poundertakebasics == null)
            return;
        this.poundertakebasics.remove(poundertakebasic);
    }

    public Poundertakebasic newPoundertakebasic() {
        Poundertakebasic res = new Poundertakebasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePoundertakebasics(
            List<Poundertakebasic> poundertakebasics) {
        List<Poundertakebasic> newObjs = new ArrayList<Poundertakebasic>();
        for (Poundertakebasic p : poundertakebasics) {
            if (p == null)
                continue;
            Poundertakebasic newdt = newPoundertakebasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Poundertakebasic> oldObjs = new HashSet<Poundertakebasic>();
        oldObjs.addAll(getPoundertakebasics());

        for (Iterator<Poundertakebasic> it = oldObjs.iterator(); it.hasNext();) {
            Poundertakebasic odt = it.next();
            found = false;
            for (Poundertakebasic newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePoundertakebasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Poundertakebasic newdt : newObjs) {
            found = false;
            for (Iterator<Poundertakebasic> it = getPoundertakebasics()
                    .iterator(); it.hasNext();) {
                Poundertakebasic odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPoundertakebasic(newdt);
        }
    }

    public Set<Popunishbasic> getPopunishbasics() {
        if (this.popunishbasics == null)
            this.popunishbasics = new HashSet<Popunishbasic>();
        return this.popunishbasics;
    }

    public void setPopunishbasics(Set<Popunishbasic> popunishbasics) {
        this.popunishbasics = popunishbasics;
    }

    public void addPopunishbasic(Popunishbasic popunishbasic) {
        if (this.popunishbasics == null)
            this.popunishbasics = new HashSet<Popunishbasic>();
        this.popunishbasics.add(popunishbasic);
    }

    public void removePopunishbasic(Popunishbasic popunishbasic) {
        if (this.popunishbasics == null)
            return;
        this.popunishbasics.remove(popunishbasic);
    }

    public Popunishbasic newPopunishbasic() {
        Popunishbasic res = new Popunishbasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePopunishbasics(List<Popunishbasic> popunishbasics) {
        List<Popunishbasic> newObjs = new ArrayList<Popunishbasic>();
        for (Popunishbasic p : popunishbasics) {
            if (p == null)
                continue;
            Popunishbasic newdt = newPopunishbasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Popunishbasic> oldObjs = new HashSet<Popunishbasic>();
        oldObjs.addAll(getPopunishbasics());

        for (Iterator<Popunishbasic> it = oldObjs.iterator(); it.hasNext();) {
            Popunishbasic odt = it.next();
            found = false;
            for (Popunishbasic newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePopunishbasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Popunishbasic newdt : newObjs) {
            found = false;
            for (Iterator<Popunishbasic> it = getPopunishbasics().iterator(); it
                    .hasNext();) {
                Popunishbasic odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPopunishbasic(newdt);
        }
    }

    public Set<Potranslawbasic> getPotranslawbasics() {
        if (this.potranslawbasics == null)
            this.potranslawbasics = new HashSet<Potranslawbasic>();
        return this.potranslawbasics;
    }

    public void setPotranslawbasics(Set<Potranslawbasic> potranslawbasics) {
        this.potranslawbasics = potranslawbasics;
    }

    public void addPotranslawbasic(Potranslawbasic potranslawbasic) {
        if (this.potranslawbasics == null)
            this.potranslawbasics = new HashSet<Potranslawbasic>();
        this.potranslawbasics.add(potranslawbasic);
    }

    public void removePotranslawbasic(Potranslawbasic potranslawbasic) {
        if (this.potranslawbasics == null)
            return;
        this.potranslawbasics.remove(potranslawbasic);
    }

    public Potranslawbasic newPotranslawbasic() {
        Potranslawbasic res = new Potranslawbasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePotranslawbasics(List<Potranslawbasic> potranslawbasics) {
        List<Potranslawbasic> newObjs = new ArrayList<Potranslawbasic>();
        for (Potranslawbasic p : potranslawbasics) {
            if (p == null)
                continue;
            Potranslawbasic newdt = newPotranslawbasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Potranslawbasic> oldObjs = new HashSet<Potranslawbasic>();
        oldObjs.addAll(getPotranslawbasics());

        for (Iterator<Potranslawbasic> it = oldObjs.iterator(); it.hasNext();) {
            Potranslawbasic odt = it.next();
            found = false;
            for (Potranslawbasic newdt : newObjs) {
                if (odt.getCid().equals(newdt.getCid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePotranslawbasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Potranslawbasic newdt : newObjs) {
            found = false;
            for (Iterator<Potranslawbasic> it = getPotranslawbasics()
                    .iterator(); it.hasNext();) {
                Potranslawbasic odt = it.next();
                if (odt.getCid().equals(newdt.getCid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPotranslawbasic(newdt);
        }
    }

    public Set<Poresultbasic> getPoresultbasics() {
        if (this.poresultbasics == null)
            this.poresultbasics = new HashSet<Poresultbasic>();
        return this.poresultbasics;
    }

    public void setPoresultbasics(Set<Poresultbasic> poresultbasics) {
        this.poresultbasics = poresultbasics;
    }

    public void addPoresultbasic(Poresultbasic poresultbasic) {
        if (this.poresultbasics == null)
            this.poresultbasics = new HashSet<Poresultbasic>();
        this.poresultbasics.add(poresultbasic);
    }

    public void removePoresultbasic(Poresultbasic poresultbasic) {
        if (this.poresultbasics == null)
            return;
        this.poresultbasics.remove(poresultbasic);
    }

    public Poresultbasic newPoresultbasic() {
        Poresultbasic res = new Poresultbasic();

        res.setPunishobjectid(this.getPunishobjectid());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replacePoresultbasics(List<Poresultbasic> poresultbasics) {
        List<Poresultbasic> newObjs = new ArrayList<Poresultbasic>();
        for (Poresultbasic p : poresultbasics) {
            if (p == null)
                continue;
            Poresultbasic newdt = newPoresultbasic();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<Poresultbasic> oldObjs = new HashSet<Poresultbasic>();
        oldObjs.addAll(getPoresultbasics());

        for (Iterator<Poresultbasic> it = oldObjs.iterator(); it.hasNext();) {
            Poresultbasic odt = it.next();
            found = false;
            for (Poresultbasic newdt : newObjs) {
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removePoresultbasic(odt);
        }
        oldObjs.clear();
        // insert or update
        for (Poresultbasic newdt : newObjs) {
            found = false;
            for (Iterator<Poresultbasic> it = getPoresultbasics().iterator(); it
                    .hasNext();) {
                Poresultbasic odt = it.next();
                if (odt.getPunishobjectid().equals(newdt.getPunishobjectid())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addPoresultbasic(newdt);
        }
    }

    public void copy(Punishobjectbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.punishobjectno = other.getPunishobjectno();
        this.punishobjecttype = other.getPunishobjecttype();
        this.managedepid = other.getManagedepid();
        this.poorigindate = other.getPoorigindate();
        this.poregisterdate = other.getPoregisterdate();
        this.poindagaterepdate = other.getPoindagaterepdate();
        this.pofinishdate = other.getPofinishdate();
        this.punishobjectbrief = other.getPunishobjectbrief();
        this.pooccurstate = other.getPooccurstate();
        this.poimpeachstate = other.getPoimpeachstate();
        this.poundertaker = other.getPoundertaker();
        this.punishclassnum = other.getPunishclassnum();
        this.pocontrovertype = other.getPocontrovertype();
        this.podiscussnum = other.getPodiscussnum();
        this.issurpass = other.getIssurpass();
        this.punishobjectstate = other.getPunishobjectstate();
        this.remark = other.getRemark();
        this.ispass = other.getIspass();
        this.pooccuradress = other.getPooccuradress();
        this.pooccurdate = other.getPooccurdate();
        this.poregisteropinion = other.getPoregisteropinion();
        this.operatorid = other.getOperatorid();
        this.poorigincontext = other.getPoorigincontext();
        this.poregistedate = other.getPoregistedate();
        this.pooriginstate = other.getPooriginstate();
        this.pocaseimpeachphone = other.getPocaseimpeachphone();
        this.pocaseimpeachunit = other.getPocaseimpeachunit();
        this.pocaseimpeachid = other.getPocaseimpeachid();
        this.pocaseimpeachname = other.getPocaseimpeachname();
        this.pocaseimpeachsex = other.getPocaseimpeachsex();
        this.pocaseimpeachage = other.getPocaseimpeachage();
        this.pocaseimpeachadress = other.getPocaseimpeachadress();
        this.pocaseimpeachpostcode = other.getPocaseimpeachpostcode();
        this.riskdesc = other.getRiskdesc();
        this.risktype = other.getRisktype();
        this.riskresult = other.getRiskresult();

        this.poenterprises = other.getPoenterprises();
        this.poindividuals = other.getPoindividuals();
        this.poregisterbasics = other.getPoregisterbasics();
        this.poindagaterepbasics = other.getPoindagaterepbasics();
        this.podiscussbasics = other.getPodiscussbasics();
        this.poreceiptinfos = other.getPoreceiptinfos();
        this.powitnessbasics = other.getPowitnessbasics();
        this.poexcucebasics = other.getPoexcucebasics();
        this.pounwitnessbasics = other.getPounwitnessbasics();
        this.poapprovebasics = other.getPoapprovebasics();
        this.pofinishbasics = other.getPofinishbasics();
        this.poundertakebasics = other.getPoundertakebasics();
        this.popunishbasics = other.getPopunishbasics();
        this.potranslawbasics = other.getPotranslawbasics();
        this.poresultbasics = other.getPoresultbasics();
    }

    public void copyNotNullProperty(Punishobjectbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getPunishobjectno() != null)
            this.punishobjectno = other.getPunishobjectno();
        if (other.getPunishobjecttype() != null)
            this.punishobjecttype = other.getPunishobjecttype();
        if (other.getManagedepid() != null)
            this.managedepid = other.getManagedepid();
        if (other.getPoorigindate() != null)
            this.poorigindate = other.getPoorigindate();
        if (other.getPoregisterdate() != null)
            this.poregisterdate = other.getPoregisterdate();
        if (other.getPoindagaterepdate() != null)
            this.poindagaterepdate = other.getPoindagaterepdate();
        if (other.getPofinishdate() != null)
            this.pofinishdate = other.getPofinishdate();
        if (other.getPunishobjectbrief() != null)
            this.punishobjectbrief = other.getPunishobjectbrief();
        if (other.getPooccurstate() != null)
            this.pooccurstate = other.getPooccurstate();
        if (other.getPoimpeachstate() != null)
            this.poimpeachstate = other.getPoimpeachstate();
        if (other.getPoundertaker() != null)
            this.poundertaker = other.getPoundertaker();
        if (other.getPunishclassnum() != null)
            this.punishclassnum = other.getPunishclassnum();
        if (other.getPocontrovertype() != null)
            this.pocontrovertype = other.getPocontrovertype();
        if (other.getPodiscussnum() != null)
            this.podiscussnum = other.getPodiscussnum();
        if (other.getIssurpass() != null)
            this.issurpass = other.getIssurpass();
        if (other.getPunishobjectstate() != null)
            this.punishobjectstate = other.getPunishobjectstate();
        if (other.getRemark() != null)
            this.remark = other.getRemark();
        if (other.getIspass() != null)
            this.ispass = other.getIspass();
        if (other.getPooccuradress() != null)
            this.pooccuradress = other.getPooccuradress();
        if (other.getPooccurdate() != null)
            this.pooccurdate = other.getPooccurdate();
        if (other.getPoregisteropinion() != null)
            this.poregisteropinion = other.getPoregisteropinion();
        if (other.getOperatorid() != null)
            this.operatorid = other.getOperatorid();
        if (other.getPoorigincontext() != null)
            this.poorigincontext = other.getPoorigincontext();
        if (other.getPoregistedate() != null)
            this.poregistedate = other.getPoregistedate();
        if (other.getPooriginstate() != null)
            this.pooriginstate = other.getPooriginstate();
        if (other.getPocaseimpeachphone() != null)
            this.pocaseimpeachphone = other.getPocaseimpeachphone();
        if (other.getPocaseimpeachunit() != null)
            this.pocaseimpeachunit = other.getPocaseimpeachunit();
        if (other.getPocaseimpeachid() != null)
            this.pocaseimpeachid = other.getPocaseimpeachid();
        if (other.getPocaseimpeachname() != null)
            this.pocaseimpeachname = other.getPocaseimpeachname();
        if (other.getPocaseimpeachsex() != null)
            this.pocaseimpeachsex = other.getPocaseimpeachsex();
        if (other.getPocaseimpeachage() != null)
            this.pocaseimpeachage = other.getPocaseimpeachage();
        if (other.getPocaseimpeachadress() != null)
            this.pocaseimpeachadress = other.getPocaseimpeachadress();
        if (other.getPocaseimpeachpostcode() != null)
            this.pocaseimpeachpostcode = other.getPocaseimpeachpostcode();
        if (other.getRiskdesc() != null)
            this.riskdesc = other.getRiskdesc();
        if (other.getRisktype() != null)
            this.risktype = other.getRisktype();
        if (other.getRiskresult() != null)
            this.riskresult = other.getRiskresult();

        this.poenterprises = other.getPoenterprises();
        this.poindividuals = other.getPoindividuals();
        this.poregisterbasics = other.getPoregisterbasics();
        this.poindagaterepbasics = other.getPoindagaterepbasics();
        this.podiscussbasics = other.getPodiscussbasics();
        this.poreceiptinfos = other.getPoreceiptinfos();
        this.powitnessbasics = other.getPowitnessbasics();
        this.poexcucebasics = other.getPoexcucebasics();
        this.pounwitnessbasics = other.getPounwitnessbasics();
        this.poapprovebasics = other.getPoapprovebasics();
        this.pofinishbasics = other.getPofinishbasics();
        this.poundertakebasics = other.getPoundertakebasics();
        this.popunishbasics = other.getPopunishbasics();
        this.potranslawbasics = other.getPotranslawbasics();
        this.poresultbasics = other.getPoresultbasics();
    }

    public void clearProperties() {

        this.punishobjectno = null;
        this.punishobjecttype = null;
        this.managedepid = null;
        this.poorigindate = null;
        this.poregisterdate = null;
        this.poindagaterepdate = null;
        this.pofinishdate = null;
        this.punishobjectbrief = null;
        this.pooccurstate = null;
        this.poimpeachstate = null;
        this.poundertaker = null;
        this.punishclassnum = null;
        this.pocontrovertype = null;
        this.podiscussnum = null;
        this.issurpass = null;
        this.punishobjectstate = null;
        this.remark = null;
        this.ispass = null;
        this.pooccuradress = null;
        this.pooccurdate = null;
        this.poregisteropinion = null;
        this.operatorid = null;
        this.poorigincontext = null;
        this.poregistedate = null;
        this.pooriginstate = null;
        this.pocaseimpeachphone = null;
        this.pocaseimpeachunit = null;
        this.pocaseimpeachid = null;
        this.pocaseimpeachname = null;
        this.pocaseimpeachsex = null;
        this.pocaseimpeachage = null;
        this.pocaseimpeachadress = null;
        this.pocaseimpeachpostcode = null;
        this.riskdesc = null;
        this.risktype = null;
        this.riskresult = null;

        this.poenterprises = new HashSet<Poenterprise>();
        this.poindividuals = new HashSet<Poindividual>();
        this.poregisterbasics = new HashSet<Poregisterbasic>();
        this.poindagaterepbasics = new HashSet<Poindagaterepbasic>();
        this.podiscussbasics = new HashSet<Podiscussbasic>();
        this.poreceiptinfos = new HashSet<Poreceiptinfo>();
        this.powitnessbasics = new HashSet<Powitnessbasic>();
        this.poexcucebasics = new HashSet<Poexcucebasic>();
        this.pounwitnessbasics = new HashSet<Pounwitnessbasic>();
        this.poapprovebasics = new HashSet<Poapprovebasic>();
        this.pofinishbasics = new HashSet<Pofinishbasic>();
        this.poundertakebasics = new HashSet<Poundertakebasic>();
        this.popunishbasics = new HashSet<Popunishbasic>();
        this.potranslawbasics = new HashSet<Potranslawbasic>();
        this.poresultbasics = new HashSet<Poresultbasic>();
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDegreeno() {
        return degreeno;
    }

    public void setDegreeno(String degreeno) {
        this.degreeno = degreeno;
    }

    public String getTransaffairname() {
        return transaffairname;
    }

    public void setTransaffairname(String transaffairname) {
        this.transaffairname = transaffairname;
    }
}
