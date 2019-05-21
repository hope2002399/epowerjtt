package com.centit.punish.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Vporegisterbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String poregisterindagate;
    private String poregisterbasis;
    private String jbrLa;
    private String ksLa;
    private String fzrLa;
    private String jbroptionLa;
    private String ksoptionLa;
    private String fzroptionLa;
    private String jbroptionLatime;
    private String ksoptionLatime;
    private String fzroptionLatime;
    private String punishobjectbrief;
    private Long pooccurstate;
    private String poorigindate;//
    private String enterprisename;
    private String enterpriseaddress;
    private String mastername;
    private String enphone;
    private String individualname;
    private String individualcode;
    private String sex;
    private Long age;
    private String individualadress;
    private String inphone;
    private String pooriginstate;
    private String poinconfirmtruth;
    private String unconfirmtruth;
    private String poindagatereppassage;
    private String disobeyitem;
    private String poindagaterepresult;
    private String jbroptionDczj;
    private String jbrDczj;
    private String jbroptiontimeDczj;//
    private String ksoptionDczj;
    private String ksoptiontimeDczj;//
    private String ksrDczj;
    private String fzroptionDczj;
    private String fzroptiontimeDczj;//
    private String fzrrDczj;
    private String pofconfirmtruth;
    private String podiscussresult;
    private String otherpunish;
    private String ksoptiontimeJa;//
    private String jbroptiontimeJa;//
    private String jbroptionJa;
    private String ksoptionJa;
    private String fzroptionJa;
    private String jbrJa;
    private String ksJa;
    private String fzrJa;
    private String fzroptiontimeJa;//
    private String caseno;// 业务文书案号
    private String poundertaker;
    private String pooccurdate;
    private String pooccuradress;
    private String title;

    // Constructors
    /** default constructor */
    public Vporegisterbasic() {
    }

    /** minimal constructor */
    public Vporegisterbasic(String punishobjectid, String enterprisename,
            String individualname) {

        this.punishobjectid = punishobjectid;

        this.enterprisename = enterprisename;
        this.individualname = individualname;
    }

    public Vporegisterbasic(String punishobjectid, String poregisterindagate,
            String poregisterbasis, String jbrLa, String ksLa, String fzrLa,
            String jbroptionLa, String ksoptionLa, String fzroptionLa,
            String jbroptionLatime, String ksoptionLatime,
            String fzroptionLatime, String punishobjectbrief,
            Long pooccurstate, String poorigindate, String enterprisename,
            String enterpriseaddress, String mastername, String enphone,
            String individualname, String individualcode, String sex, Long age,
            String individualadress, String inphone, String pooriginstate,
            String poinconfirmtruth, String unconfirmtruth,
            String poindagatereppassage, String disobeyitem,
            String poindagaterepresult, String jbroptionDczj, String jbrDczj,
            String jbroptiontimeDczj, String ksoptionDczj,
            String ksoptiontimeDczj, String ksrDczj, String fzroptionDczj,
            String fzroptiontimeDczj, String fzrrDczj, String pofconfirmtruth,
            String podiscussresult, String otherpunish, String ksoptiontimeJa,
            String jbroptiontimeJa, String jbroptionJa, String ksoptionJa,
            String fzroptionJa, String jbrJa, String ksJa, String fzrJa,
            String fzroptiontimeJa, String caseno) {
        super();
        this.punishobjectid = punishobjectid;
        this.poregisterindagate = poregisterindagate;
        this.poregisterbasis = poregisterbasis;
        this.jbrLa = jbrLa;
        this.ksLa = ksLa;
        this.fzrLa = fzrLa;
        this.jbroptionLa = jbroptionLa;
        this.ksoptionLa = ksoptionLa;
        this.fzroptionLa = fzroptionLa;
        this.jbroptionLatime = jbroptionLatime;
        this.ksoptionLatime = ksoptionLatime;
        this.fzroptionLatime = fzroptionLatime;
        this.punishobjectbrief = punishobjectbrief;
        this.pooccurstate = pooccurstate;
        this.poorigindate = poorigindate;
        this.enterprisename = enterprisename;
        this.enterpriseaddress = enterpriseaddress;
        this.mastername = mastername;
        this.enphone = enphone;
        this.individualname = individualname;
        this.individualcode = individualcode;
        this.sex = sex;
        this.age = age;
        this.individualadress = individualadress;
        this.inphone = inphone;
        this.pooriginstate = pooriginstate;
        this.poinconfirmtruth = poinconfirmtruth;
        this.unconfirmtruth = unconfirmtruth;
        this.poindagatereppassage = poindagatereppassage;
        this.disobeyitem = disobeyitem;
        this.poindagaterepresult = poindagaterepresult;
        this.jbroptionDczj = jbroptionDczj;
        this.jbrDczj = jbrDczj;
        this.jbroptiontimeDczj = jbroptiontimeDczj;
        this.ksoptionDczj = ksoptionDczj;
        this.ksoptiontimeDczj = ksoptiontimeDczj;
        this.ksrDczj = ksrDczj;
        this.fzroptionDczj = fzroptionDczj;
        this.fzroptiontimeDczj = fzroptiontimeDczj;
        this.fzrrDczj = fzrrDczj;
        this.pofconfirmtruth = pofconfirmtruth;
        this.podiscussresult = podiscussresult;
        this.otherpunish = otherpunish;
        this.ksoptiontimeJa = ksoptiontimeJa;
        this.jbroptiontimeJa = jbroptiontimeJa;
        this.jbroptionJa = jbroptionJa;
        this.ksoptionJa = ksoptionJa;
        this.fzroptionJa = fzroptionJa;
        this.jbrJa = jbrJa;
        this.ksJa = ksJa;
        this.fzrJa = fzrJa;
        this.fzroptiontimeJa = fzroptiontimeJa;
        this.caseno = caseno;
    }

    public String getPofconfirmtruth() {
        return pofconfirmtruth;
    }

    public Vporegisterbasic(String punishobjectid, String poregisterindagate,
            String poregisterbasis, String jbrLa, String ksLa, String fzrLa,
            String jbroptionLa, String ksoptionLa, String fzroptionLa,
            String jbroptionLatime, String ksoptionLatime,
            String fzroptionLatime, String punishobjectbrief,
            Long pooccurstate, String poorigindate, String enterprisename,
            String enterpriseaddress, String mastername, String enphone,
            String individualname, String individualcode, String sex, Long age,
            String individualadress, String inphone, String pooriginstate,
            String poinconfirmtruth, String unconfirmtruth,
            String poindagatereppassage, String disobeyitem,
            String poindagaterepresult, String jbroptionDczj, String jbrDczj,
            String jbroptiontimeDczj, String ksoptionDczj,
            String ksoptiontimeDczj, String ksrDczj, String fzroptionDczj,
            String fzroptiontimeDczj, String fzrrDczj, String pofconfirmtruth,
            String podiscussresult, String otherpunish, String ksoptiontimeJa,
            String jbroptiontimeJa, String jbroptionJa, String ksoptionJa,
            String fzroptionJa, String jbrJa, String ksJa, String fzrJa,
            String fzroptiontimeJa, String caseno, String poundertaker) {
        super();
        this.punishobjectid = punishobjectid;
        this.poregisterindagate = poregisterindagate;
        this.poregisterbasis = poregisterbasis;
        this.jbrLa = jbrLa;
        this.ksLa = ksLa;
        this.fzrLa = fzrLa;
        this.jbroptionLa = jbroptionLa;
        this.ksoptionLa = ksoptionLa;
        this.fzroptionLa = fzroptionLa;
        this.jbroptionLatime = jbroptionLatime;
        this.ksoptionLatime = ksoptionLatime;
        this.fzroptionLatime = fzroptionLatime;
        this.punishobjectbrief = punishobjectbrief;
        this.pooccurstate = pooccurstate;
        this.poorigindate = poorigindate;
        this.enterprisename = enterprisename;
        this.enterpriseaddress = enterpriseaddress;
        this.mastername = mastername;
        this.enphone = enphone;
        this.individualname = individualname;
        this.individualcode = individualcode;
        this.sex = sex;
        this.age = age;
        this.individualadress = individualadress;
        this.inphone = inphone;
        this.pooriginstate = pooriginstate;
        this.poinconfirmtruth = poinconfirmtruth;
        this.unconfirmtruth = unconfirmtruth;
        this.poindagatereppassage = poindagatereppassage;
        this.disobeyitem = disobeyitem;
        this.poindagaterepresult = poindagaterepresult;
        this.jbroptionDczj = jbroptionDczj;
        this.jbrDczj = jbrDczj;
        this.jbroptiontimeDczj = jbroptiontimeDczj;
        this.ksoptionDczj = ksoptionDczj;
        this.ksoptiontimeDczj = ksoptiontimeDczj;
        this.ksrDczj = ksrDczj;
        this.fzroptionDczj = fzroptionDczj;
        this.fzroptiontimeDczj = fzroptiontimeDczj;
        this.fzrrDczj = fzrrDczj;
        this.pofconfirmtruth = pofconfirmtruth;
        this.podiscussresult = podiscussresult;
        this.otherpunish = otherpunish;
        this.ksoptiontimeJa = ksoptiontimeJa;
        this.jbroptiontimeJa = jbroptiontimeJa;
        this.jbroptionJa = jbroptionJa;
        this.ksoptionJa = ksoptionJa;
        this.fzroptionJa = fzroptionJa;
        this.jbrJa = jbrJa;
        this.ksJa = ksJa;
        this.fzrJa = fzrJa;
        this.fzroptiontimeJa = fzroptiontimeJa;
        this.caseno = caseno;
        this.poundertaker = poundertaker;
    }

    public Vporegisterbasic(String punishobjectid, String poregisterindagate,
            String poregisterbasis, String jbrLa, String ksLa, String fzrLa,
            String jbroptionLa, String ksoptionLa, String fzroptionLa,
            String jbroptionLatime, String ksoptionLatime,
            String fzroptionLatime, String punishobjectbrief,
            Long pooccurstate, String poorigindate, String enterprisename,
            String enterpriseaddress, String mastername, String enphone,
            String individualname, String individualcode, String sex, Long age,
            String individualadress, String inphone, String pooriginstate,
            String poinconfirmtruth, String unconfirmtruth,
            String poindagatereppassage, String disobeyitem,
            String poindagaterepresult, String jbroptionDczj, String jbrDczj,
            String jbroptiontimeDczj, String ksoptionDczj,
            String ksoptiontimeDczj, String ksrDczj, String fzroptionDczj,
            String fzroptiontimeDczj, String fzrrDczj, String pofconfirmtruth,
            String podiscussresult, String otherpunish, String ksoptiontimeJa,
            String jbroptiontimeJa, String jbroptionJa, String ksoptionJa,
            String fzroptionJa, String jbrJa, String ksJa, String fzrJa,
            String fzroptiontimeJa, String caseno, String poundertaker,
            String pooccurdate, String pooccuradress) {
        super();
        this.punishobjectid = punishobjectid;
        this.poregisterindagate = poregisterindagate;
        this.poregisterbasis = poregisterbasis;
        this.jbrLa = jbrLa;
        this.ksLa = ksLa;
        this.fzrLa = fzrLa;
        this.jbroptionLa = jbroptionLa;
        this.ksoptionLa = ksoptionLa;
        this.fzroptionLa = fzroptionLa;
        this.jbroptionLatime = jbroptionLatime;
        this.ksoptionLatime = ksoptionLatime;
        this.fzroptionLatime = fzroptionLatime;
        this.punishobjectbrief = punishobjectbrief;
        this.pooccurstate = pooccurstate;
        this.poorigindate = poorigindate;
        this.enterprisename = enterprisename;
        this.enterpriseaddress = enterpriseaddress;
        this.mastername = mastername;
        this.enphone = enphone;
        this.individualname = individualname;
        this.individualcode = individualcode;
        this.sex = sex;
        this.age = age;
        this.individualadress = individualadress;
        this.inphone = inphone;
        this.pooriginstate = pooriginstate;
        this.poinconfirmtruth = poinconfirmtruth;
        this.unconfirmtruth = unconfirmtruth;
        this.poindagatereppassage = poindagatereppassage;
        this.disobeyitem = disobeyitem;
        this.poindagaterepresult = poindagaterepresult;
        this.jbroptionDczj = jbroptionDczj;
        this.jbrDczj = jbrDczj;
        this.jbroptiontimeDczj = jbroptiontimeDczj;
        this.ksoptionDczj = ksoptionDczj;
        this.ksoptiontimeDczj = ksoptiontimeDczj;
        this.ksrDczj = ksrDczj;
        this.fzroptionDczj = fzroptionDczj;
        this.fzroptiontimeDczj = fzroptiontimeDczj;
        this.fzrrDczj = fzrrDczj;
        this.pofconfirmtruth = pofconfirmtruth;
        this.podiscussresult = podiscussresult;
        this.otherpunish = otherpunish;
        this.ksoptiontimeJa = ksoptiontimeJa;
        this.jbroptiontimeJa = jbroptiontimeJa;
        this.jbroptionJa = jbroptionJa;
        this.ksoptionJa = ksoptionJa;
        this.fzroptionJa = fzroptionJa;
        this.jbrJa = jbrJa;
        this.ksJa = ksJa;
        this.fzrJa = fzrJa;
        this.fzroptiontimeJa = fzroptiontimeJa;
        this.caseno = caseno;
        this.poundertaker = poundertaker;
        this.pooccurdate = pooccurdate;
        this.pooccuradress = pooccuradress;
    }

    public void setPofconfirmtruth(String pofconfirmtruth) {
        this.pofconfirmtruth = pofconfirmtruth;
    }

    public String getPoundertaker() {
        return poundertaker;
    }

    public void setPoundertaker(String poundertaker) {
        this.poundertaker = poundertaker;
    }

    public String getTitle() {
        return title;
    }

    public String getCaseno() {
        return caseno;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno;
    }

    public String getPooccurdate() {
        return pooccurdate;
    }

    public void setPooccurdate(String pooccurdate) {
        this.pooccurdate = pooccurdate;
    }

    public String getPooccuradress() {
        return pooccuradress;
    }

    public void setPooccuradress(String pooccuradress) {
        this.pooccuradress = pooccuradress;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /** full constructor */
    public Vporegisterbasic(String punishobjectid, String poregisterindagate,
            String poregisterbasis, String jbrLa, String ksLa, String fzrLa,
            String jbroptionLa, String ksoptionLa, String fzroptionLa,
            String jbroptionLatime, String ksoptionLatime,
            String fzroptionLatime, String punishobjectbrief,
            Long pooccurstate, String poorigindate, String enterprisename,
            String enterpriseaddress, String mastername, String enphone,
            String individualname, String individualcode, String sex, Long age,
            String individualadress, String inphone, String pooriginstate,
            String poinconfirmtruth, String unconfirmtruth,
            String poindagatereppassage, String disobeyitem,
            String poindagaterepresult, String jbroptionDczj, String jbrDczj,
            String jbroptiontimeDczj, String ksoptionDczj,
            String ksoptiontimeDczj, String ksrDczj, String fzroptionDczj,
            String fzroptiontimeDczj, String fzrrDczj, String confirmtruth,
            String podiscussresult, String otherpunish, String ksoptiontimeJa,
            String jbroptiontimeJa, String jbroptionJa, String ksoptionJa,
            String fzroptionJa, String jbrJa, String ksJa, String fzrJa,
            String fzroptiontimeJa) {

        this.punishobjectid = punishobjectid;

        this.poregisterindagate = poregisterindagate;
        this.poregisterbasis = poregisterbasis;
        this.jbrLa = jbrLa;
        this.ksLa = ksLa;
        this.fzrLa = fzrLa;
        this.jbroptionLa = jbroptionLa;
        this.ksoptionLa = ksoptionLa;
        this.fzroptionLa = fzroptionLa;
        this.jbroptionLatime = jbroptionLatime;
        this.ksoptionLatime = ksoptionLatime;
        this.fzroptionLatime = fzroptionLatime;
        this.punishobjectbrief = punishobjectbrief;
        this.pooccurstate = pooccurstate;
        this.poorigindate = poorigindate;
        this.enterprisename = enterprisename;
        this.enterpriseaddress = enterpriseaddress;
        this.mastername = mastername;
        this.enphone = enphone;
        this.individualname = individualname;
        this.individualcode = individualcode;
        this.sex = sex;
        this.age = age;
        this.individualadress = individualadress;
        this.inphone = inphone;
        this.pooriginstate = pooriginstate;
        this.poinconfirmtruth = poinconfirmtruth;
        this.unconfirmtruth = unconfirmtruth;
        this.poindagatereppassage = poindagatereppassage;
        this.disobeyitem = disobeyitem;
        this.poindagaterepresult = poindagaterepresult;
        this.jbroptionDczj = jbroptionDczj;
        this.jbrDczj = jbrDczj;
        this.jbroptiontimeDczj = jbroptiontimeDczj;
        this.ksoptionDczj = ksoptionDczj;
        this.ksoptiontimeDczj = ksoptiontimeDczj;
        this.ksrDczj = ksrDczj;
        this.fzroptionDczj = fzroptionDczj;
        this.fzroptiontimeDczj = fzroptiontimeDczj;
        this.fzrrDczj = fzrrDczj;
        this.pofconfirmtruth = confirmtruth;
        this.podiscussresult = podiscussresult;
        this.otherpunish = otherpunish;
        this.ksoptiontimeJa = ksoptiontimeJa;
        this.jbroptiontimeJa = jbroptiontimeJa;
        this.jbroptionJa = jbroptionJa;
        this.ksoptionJa = ksoptionJa;
        this.fzroptionJa = fzroptionJa;
        this.jbrJa = jbrJa;
        this.ksJa = ksJa;
        this.fzrJa = fzrJa;
        this.fzroptiontimeJa = fzroptiontimeJa;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public String getPoregisterindagate() {
        return this.poregisterindagate;
    }

    public void setPoregisterindagate(String poregisterindagate) {
        this.poregisterindagate = poregisterindagate;
    }

    public String getPoregisterbasis() {
        return this.poregisterbasis;
    }

    public void setPoregisterbasis(String poregisterbasis) {
        this.poregisterbasis = poregisterbasis;
    }

    public String getJbrLa() {
        return this.jbrLa;
    }

    public void setJbrLa(String jbrLa) {
        this.jbrLa = jbrLa;
    }

    public String getKsLa() {
        return this.ksLa;
    }

    public void setKsLa(String ksLa) {
        this.ksLa = ksLa;
    }

    public String getFzrLa() {
        return this.fzrLa;
    }

    public void setFzrLa(String fzrLa) {
        this.fzrLa = fzrLa;
    }

    public String getJbroptionLa() {
        return this.jbroptionLa;
    }

    public void setJbroptionLa(String jbroptionLa) {
        this.jbroptionLa = jbroptionLa;
    }

    public String getKsoptionLa() {
        return this.ksoptionLa;
    }

    public void setKsoptionLa(String ksoptionLa) {
        this.ksoptionLa = ksoptionLa;
    }

    public String getFzroptionLa() {
        return this.fzroptionLa;
    }

    public void setFzroptionLa(String fzroptionLa) {
        this.fzroptionLa = fzroptionLa;
    }

    public String getJbroptionLatime() {
        return this.jbroptionLatime;
    }

    public void setJbroptionLatime(String jbroptionLatime) {
        this.jbroptionLatime = jbroptionLatime;
    }

    public String getKsoptionLatime() {
        return this.ksoptionLatime;
    }

    public void setKsoptionLatime(String ksoptionLatime) {
        this.ksoptionLatime = ksoptionLatime;
    }

    public String getFzroptionLatime() {
        return this.fzroptionLatime;
    }

    public void setFzroptionLatime(String fzroptionLatime) {
        this.fzroptionLatime = fzroptionLatime;
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

    public String getPoorigindate() {
        return this.poorigindate;
    }

    public void setPoorigindate(String poorigindate) {
        this.poorigindate = poorigindate;
    }

    public String getEnterprisename() {
        return this.enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getEnterpriseaddress() {
        return this.enterpriseaddress;
    }

    public void setEnterpriseaddress(String enterpriseaddress) {
        this.enterpriseaddress = enterpriseaddress;
    }

    public String getMastername() {
        return this.mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

    public String getEnphone() {
        return this.enphone;
    }

    public void setEnphone(String enphone) {
        this.enphone = enphone;
    }

    public String getIndividualname() {
        return this.individualname;
    }

    public void setIndividualname(String individualname) {
        this.individualname = individualname;
    }

    public String getIndividualcode() {
        return this.individualcode;
    }

    public void setIndividualcode(String individualcode) {
        this.individualcode = individualcode;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getAge() {
        return this.age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getIndividualadress() {
        return this.individualadress;
    }

    public void setIndividualadress(String individualadress) {
        this.individualadress = individualadress;
    }

    public String getInphone() {
        return this.inphone;
    }

    public void setInphone(String inphone) {
        this.inphone = inphone;
    }

    public String getPooriginstate() {
        return this.pooriginstate;
    }

    public void setPooriginstate(String pooriginstate) {
        this.pooriginstate = pooriginstate;
    }

    public String getPoinconfirmtruth() {
        return this.poinconfirmtruth;
    }

    public void setPoinconfirmtruth(String poinconfirmtruth) {
        this.poinconfirmtruth = poinconfirmtruth;
    }

    public String getUnconfirmtruth() {
        return this.unconfirmtruth;
    }

    public void setUnconfirmtruth(String unconfirmtruth) {
        this.unconfirmtruth = unconfirmtruth;
    }

    public String getPoindagatereppassage() {
        return this.poindagatereppassage;
    }

    public void setPoindagatereppassage(String poindagatereppassage) {
        this.poindagatereppassage = poindagatereppassage;
    }

    public String getDisobeyitem() {
        return this.disobeyitem;
    }

    public void setDisobeyitem(String disobeyitem) {
        this.disobeyitem = disobeyitem;
    }

    public String getPoindagaterepresult() {
        return this.poindagaterepresult;
    }

    public void setPoindagaterepresult(String poindagaterepresult) {
        this.poindagaterepresult = poindagaterepresult;
    }

    public String getJbroptionDczj() {
        return this.jbroptionDczj;
    }

    public void setJbroptionDczj(String jbroptionDczj) {
        this.jbroptionDczj = jbroptionDczj;
    }

    public String getJbrDczj() {
        return this.jbrDczj;
    }

    public void setJbrDczj(String jbrDczj) {
        this.jbrDczj = jbrDczj;
    }

    public String getJbroptiontimeDczj() {
        return this.jbroptiontimeDczj;
    }

    public void setJbroptiontimeDczj(String jbroptiontimeDczj) {
        this.jbroptiontimeDczj = jbroptiontimeDczj;
    }

    public String getKsoptionDczj() {
        return this.ksoptionDczj;
    }

    public void setKsoptionDczj(String ksoptionDczj) {
        this.ksoptionDczj = ksoptionDczj;
    }

    public String getKsoptiontimeDczj() {
        return this.ksoptiontimeDczj;
    }

    public void setKsoptiontimeDczj(String ksoptiontimeDczj) {
        this.ksoptiontimeDczj = ksoptiontimeDczj;
    }

    public String getKsrDczj() {
        return this.ksrDczj;
    }

    public void setKsrDczj(String ksrDczj) {
        this.ksrDczj = ksrDczj;
    }

    public String getFzroptionDczj() {
        return this.fzroptionDczj;
    }

    public void setFzroptionDczj(String fzroptionDczj) {
        this.fzroptionDczj = fzroptionDczj;
    }

    public String getFzroptiontimeDczj() {
        return this.fzroptiontimeDczj;
    }

    public void setFzroptiontimeDczj(String fzroptiontimeDczj) {
        this.fzroptiontimeDczj = fzroptiontimeDczj;
    }

    public String getFzrrDczj() {
        return this.fzrrDczj;
    }

    public void setFzrrDczj(String fzrrDczj) {
        this.fzrrDczj = fzrrDczj;
    }

    public String getConfirmtruth() {
        return this.pofconfirmtruth;
    }

    public void setConfirmtruth(String confirmtruth) {
        this.pofconfirmtruth = confirmtruth;
    }

    public String getPodiscussresult() {
        return this.podiscussresult;
    }

    public void setPodiscussresult(String podiscussresult) {
        this.podiscussresult = podiscussresult;
    }

    public String getOtherpunish() {
        return this.otherpunish;
    }

    public void setOtherpunish(String otherpunish) {
        this.otherpunish = otherpunish;
    }

    public String getKsoptiontimeJa() {
        return this.ksoptiontimeJa;
    }

    public void setKsoptiontimeJa(String ksoptiontimeJa) {
        this.ksoptiontimeJa = ksoptiontimeJa;
    }

    public String getJbroptiontimeJa() {
        return this.jbroptiontimeJa;
    }

    public void setJbroptiontimeJa(String jbroptiontimeJa) {
        this.jbroptiontimeJa = jbroptiontimeJa;
    }

    public String getJbroptionJa() {
        return this.jbroptionJa;
    }

    public void setJbroptionJa(String jbroptionJa) {
        this.jbroptionJa = jbroptionJa;
    }

    public String getKsoptionJa() {
        return this.ksoptionJa;
    }

    public void setKsoptionJa(String ksoptionJa) {
        this.ksoptionJa = ksoptionJa;
    }

    public String getFzroptionJa() {
        return this.fzroptionJa;
    }

    public void setFzroptionJa(String fzroptionJa) {
        this.fzroptionJa = fzroptionJa;
    }

    public String getJbrJa() {
        return this.jbrJa;
    }

    public void setJbrJa(String jbrJa) {
        this.jbrJa = jbrJa;
    }

    public String getKsJa() {
        return this.ksJa;
    }

    public void setKsJa(String ksJa) {
        this.ksJa = ksJa;
    }

    public String getFzrJa() {
        return this.fzrJa;
    }

    public void setFzrJa(String fzrJa) {
        this.fzrJa = fzrJa;
    }

    public String getFzroptiontimeJa() {
        return this.fzroptiontimeJa;
    }

    public void setFzroptiontimeJa(String fzroptiontimeJa) {
        this.fzroptiontimeJa = fzroptiontimeJa;
    }

    public void copy(Vporegisterbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.poregisterindagate = other.getPoregisterindagate();
        this.poregisterbasis = other.getPoregisterbasis();
        this.jbrLa = other.getJbrLa();
        this.ksLa = other.getKsLa();
        this.fzrLa = other.getFzrLa();
        this.jbroptionLa = other.getJbroptionLa();
        this.ksoptionLa = other.getKsoptionLa();
        this.fzroptionLa = other.getFzroptionLa();
        this.jbroptionLatime = other.getJbroptionLatime();
        this.ksoptionLatime = other.getKsoptionLatime();
        this.fzroptionLatime = other.getFzroptionLatime();
        this.punishobjectbrief = other.getPunishobjectbrief();
        this.pooccurstate = other.getPooccurstate();
        this.poorigindate = other.getPoorigindate();
        this.enterprisename = other.getEnterprisename();
        this.enterpriseaddress = other.getEnterpriseaddress();
        this.mastername = other.getMastername();
        this.enphone = other.getEnphone();
        this.individualname = other.getIndividualname();
        this.individualcode = other.getIndividualcode();
        this.sex = other.getSex();
        this.age = other.getAge();
        this.individualadress = other.getIndividualadress();
        this.inphone = other.getInphone();
        this.pooriginstate = other.getPooriginstate();
        this.poinconfirmtruth = other.getPoinconfirmtruth();
        this.unconfirmtruth = other.getUnconfirmtruth();
        this.poindagatereppassage = other.getPoindagatereppassage();
        this.disobeyitem = other.getDisobeyitem();
        this.poindagaterepresult = other.getPoindagaterepresult();
        this.jbroptionDczj = other.getJbroptionDczj();
        this.jbrDczj = other.getJbrDczj();
        this.jbroptiontimeDczj = other.getJbroptiontimeDczj();
        this.ksoptionDczj = other.getKsoptionDczj();
        this.ksoptiontimeDczj = other.getKsoptiontimeDczj();
        this.ksrDczj = other.getKsrDczj();
        this.fzroptionDczj = other.getFzroptionDczj();
        this.fzroptiontimeDczj = other.getFzroptiontimeDczj();
        this.fzrrDczj = other.getFzrrDczj();
        this.pofconfirmtruth = other.getConfirmtruth();
        this.podiscussresult = other.getPodiscussresult();
        this.otherpunish = other.getOtherpunish();
        this.ksoptiontimeJa = other.getKsoptiontimeJa();
        this.jbroptiontimeJa = other.getJbroptiontimeJa();
        this.jbroptionJa = other.getJbroptionJa();
        this.ksoptionJa = other.getKsoptionJa();
        this.fzroptionJa = other.getFzroptionJa();
        this.jbrJa = other.getJbrJa();
        this.ksJa = other.getKsJa();
        this.fzrJa = other.getFzrJa();
        this.fzroptiontimeJa = other.getFzroptiontimeJa();

    }

    public void copyNotNullProperty(Vporegisterbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getPoregisterindagate() != null)
            this.poregisterindagate = other.getPoregisterindagate();
        if (other.getPoregisterbasis() != null)
            this.poregisterbasis = other.getPoregisterbasis();
        if (other.getJbrLa() != null)
            this.jbrLa = other.getJbrLa();
        if (other.getKsLa() != null)
            this.ksLa = other.getKsLa();
        if (other.getFzrLa() != null)
            this.fzrLa = other.getFzrLa();
        if (other.getJbroptionLa() != null)
            this.jbroptionLa = other.getJbroptionLa();
        if (other.getKsoptionLa() != null)
            this.ksoptionLa = other.getKsoptionLa();
        if (other.getFzroptionLa() != null)
            this.fzroptionLa = other.getFzroptionLa();
        if (other.getJbroptionLatime() != null)
            this.jbroptionLatime = other.getJbroptionLatime();
        if (other.getKsoptionLatime() != null)
            this.ksoptionLatime = other.getKsoptionLatime();
        if (other.getFzroptionLatime() != null)
            this.fzroptionLatime = other.getFzroptionLatime();
        if (other.getPunishobjectbrief() != null)
            this.punishobjectbrief = other.getPunishobjectbrief();
        if (other.getPooccurstate() != null)
            this.pooccurstate = other.getPooccurstate();
        if (other.getPoorigindate() != null)
            this.poorigindate = other.getPoorigindate();
        if (other.getEnterprisename() != null)
            this.enterprisename = other.getEnterprisename();
        if (other.getEnterpriseaddress() != null)
            this.enterpriseaddress = other.getEnterpriseaddress();
        if (other.getMastername() != null)
            this.mastername = other.getMastername();
        if (other.getEnphone() != null)
            this.enphone = other.getEnphone();
        if (other.getIndividualname() != null)
            this.individualname = other.getIndividualname();
        if (other.getIndividualcode() != null)
            this.individualcode = other.getIndividualcode();
        if (other.getSex() != null)
            this.sex = other.getSex();
        if (other.getAge() != null)
            this.age = other.getAge();
        if (other.getIndividualadress() != null)
            this.individualadress = other.getIndividualadress();
        if (other.getInphone() != null)
            this.inphone = other.getInphone();
        if (other.getPooriginstate() != null)
            this.pooriginstate = other.getPooriginstate();
        if (other.getPoinconfirmtruth() != null)
            this.poinconfirmtruth = other.getPoinconfirmtruth();
        if (other.getUnconfirmtruth() != null)
            this.unconfirmtruth = other.getUnconfirmtruth();
        if (other.getPoindagatereppassage() != null)
            this.poindagatereppassage = other.getPoindagatereppassage();
        if (other.getDisobeyitem() != null)
            this.disobeyitem = other.getDisobeyitem();
        if (other.getPoindagaterepresult() != null)
            this.poindagaterepresult = other.getPoindagaterepresult();
        if (other.getJbroptionDczj() != null)
            this.jbroptionDczj = other.getJbroptionDczj();
        if (other.getJbrDczj() != null)
            this.jbrDczj = other.getJbrDczj();
        if (other.getJbroptiontimeDczj() != null)
            this.jbroptiontimeDczj = other.getJbroptiontimeDczj();
        if (other.getKsoptionDczj() != null)
            this.ksoptionDczj = other.getKsoptionDczj();
        if (other.getKsoptiontimeDczj() != null)
            this.ksoptiontimeDczj = other.getKsoptiontimeDczj();
        if (other.getKsrDczj() != null)
            this.ksrDczj = other.getKsrDczj();
        if (other.getFzroptionDczj() != null)
            this.fzroptionDczj = other.getFzroptionDczj();
        if (other.getFzroptiontimeDczj() != null)
            this.fzroptiontimeDczj = other.getFzroptiontimeDczj();
        if (other.getFzrrDczj() != null)
            this.fzrrDczj = other.getFzrrDczj();
        if (other.getConfirmtruth() != null)
            this.pofconfirmtruth = other.getConfirmtruth();
        if (other.getPodiscussresult() != null)
            this.podiscussresult = other.getPodiscussresult();
        if (other.getOtherpunish() != null)
            this.otherpunish = other.getOtherpunish();
        if (other.getKsoptiontimeJa() != null)
            this.ksoptiontimeJa = other.getKsoptiontimeJa();
        if (other.getJbroptiontimeJa() != null)
            this.jbroptiontimeJa = other.getJbroptiontimeJa();
        if (other.getJbroptionJa() != null)
            this.jbroptionJa = other.getJbroptionJa();
        if (other.getKsoptionJa() != null)
            this.ksoptionJa = other.getKsoptionJa();
        if (other.getFzroptionJa() != null)
            this.fzroptionJa = other.getFzroptionJa();
        if (other.getJbrJa() != null)
            this.jbrJa = other.getJbrJa();
        if (other.getKsJa() != null)
            this.ksJa = other.getKsJa();
        if (other.getFzrJa() != null)
            this.fzrJa = other.getFzrJa();
        if (other.getFzroptiontimeJa() != null)
            this.fzroptiontimeJa = other.getFzroptiontimeJa();

    }

    public void clearProperties() {

        this.poregisterindagate = null;
        this.poregisterbasis = null;
        this.jbrLa = null;
        this.ksLa = null;
        this.fzrLa = null;
        this.jbroptionLa = null;
        this.ksoptionLa = null;
        this.fzroptionLa = null;
        this.jbroptionLatime = null;
        this.ksoptionLatime = null;
        this.fzroptionLatime = null;
        this.punishobjectbrief = null;
        this.pooccurstate = null;
        this.poorigindate = null;
        this.enterprisename = null;
        this.enterpriseaddress = null;
        this.mastername = null;
        this.enphone = null;
        this.individualname = null;
        this.individualcode = null;
        this.sex = null;
        this.age = null;
        this.individualadress = null;
        this.inphone = null;
        this.pooriginstate = null;
        this.poinconfirmtruth = null;
        this.unconfirmtruth = null;
        this.poindagatereppassage = null;
        this.disobeyitem = null;
        this.poindagaterepresult = null;
        this.jbroptionDczj = null;
        this.jbrDczj = null;
        this.jbroptiontimeDczj = null;
        this.ksoptionDczj = null;
        this.ksoptiontimeDczj = null;
        this.ksrDczj = null;
        this.fzroptionDczj = null;
        this.fzroptiontimeDczj = null;
        this.fzrrDczj = null;
        this.pofconfirmtruth = null;
        this.podiscussresult = null;
        this.otherpunish = null;
        this.ksoptiontimeJa = null;
        this.jbroptiontimeJa = null;
        this.jbroptionJa = null;
        this.ksoptionJa = null;
        this.fzroptionJa = null;
        this.jbrJa = null;
        this.ksJa = null;
        this.fzrJa = null;
        this.fzroptiontimeJa = null;

    }
}
