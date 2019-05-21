package com.centit.powerbase.po;

import java.util.Date;

public class PunishBasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String no;
    private Date update_date;
    private String internal_no;
    private String org_id;
    private String department;
    private String source;
    private String fact;
    private String content;
    private Date punish_time;
    private String punish_target;
    private String target_type;
    private String target_code;
    private String target_phone;
    private String target_mobile;
    private String target_paper_type;
    private String target_email;
    private String reporter;
    private Date bookDate;
    /*
     * private Long personNum; private Long corpNum;
     */
    private String recodeStyle;
    private String punish_class;
    private String isRecord;
    private Long punish_result_fine;
    private Long punish_result_expropriatton_v;
    private String item_id;
    private String parentDepno;
    private String itemName;
    private Date createDate;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public PunishBasic() {
    }

    public PunishBasic(String no, Date update_date, String internal_no,
            String org_id, String department, String source, String fact,
            String content, Date punish_time, String punish_target,
            String target_type, String target_code, String target_phone,
            String target_mobile, String target_paper_type,
            String target_email, String reporter, Date bookDate,
            String recodeStyle, String punish_class, String isRecord,
            Long punish_result_fine, Long punish_result_expropriatton_v,
            String item_id, String parentDepno, String itemName, Date createDate) {
        super();
        this.no = no;
        this.update_date = update_date;
        this.internal_no = internal_no;
        this.org_id = org_id;
        this.department = department;
        this.source = source;
        this.fact = fact;
        this.content = content;
        this.punish_time = punish_time;
        this.punish_target = punish_target;
        this.target_type = target_type;
        this.target_code = target_code;
        this.target_phone = target_phone;
        this.target_mobile = target_mobile;
        this.target_paper_type = target_paper_type;
        this.target_email = target_email;
        this.reporter = reporter;
        this.bookDate = bookDate;
        /*
         * this.personNum = personNum; this.corpNum = corpNum;
         */
        this.recodeStyle = recodeStyle;
        this.punish_class = punish_class;
        this.isRecord = isRecord;
        this.punish_result_fine = punish_result_fine;
        this.punish_result_expropriatton_v = punish_result_expropriatton_v;
        this.item_id = item_id;
        this.parentDepno = parentDepno;
        this.itemName = itemName;
        this.createDate = createDate;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getInternal_no() {
        return internal_no;
    }

    public void setInternal_no(String internal_no) {
        this.internal_no = internal_no;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Date getPunish_time() {
        return punish_time;
    }

    public void setPunish_time(Date punish_time) {
        this.punish_time = punish_time;
    }

    public String getPunish_target() {
        return punish_target;
    }

    public void setPunish_target(String punish_target) {
        this.punish_target = punish_target;
    }

    public String getTarget_type() {
        return target_type;
    }

    public void setTarget_type(String target_type) {
        this.target_type = target_type;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public String getTarget_phone() {
        return target_phone;
    }

    public void setTarget_phone(String target_phone) {
        this.target_phone = target_phone;
    }

    public String getTarget_mobile() {
        return target_mobile;
    }

    public void setTarget_mobile(String target_mobile) {
        this.target_mobile = target_mobile;
    }

    public String getTarget_paper_type() {
        return target_paper_type;
    }

    public void setTarget_paper_type(String target_paper_type) {
        this.target_paper_type = target_paper_type;
    }

    public String getTarget_email() {
        return target_email;
    }

    public void setTarget_email(String target_email) {
        this.target_email = target_email;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    /*
     * public Long getPersonNum() { return personNum; }
     * 
     * public void setPersonNum(Long personNum) { this.personNum = personNum; }
     * 
     * public Long getCorpNum() { return corpNum; }
     * 
     * public void setCorpNum(Long corpNum) { this.corpNum = corpNum; }
     */

    public String getRecodeStyle() {
        return recodeStyle;
    }

    public void setRecodeStyle(String recodeStyle) {
        this.recodeStyle = recodeStyle;
    }

    public String getPunish_class() {
        return punish_class;
    }

    public void setPunish_class(String punish_class) {
        this.punish_class = punish_class;
    }

    public String getIsRecord() {
        return isRecord;
    }

    public void setIsRecord(String isRecord) {
        this.isRecord = isRecord;
    }

    public Long getPunish_result_fine() {
        return punish_result_fine;
    }

    public void setPunish_result_fine(Long punish_result_fine) {
        this.punish_result_fine = punish_result_fine;
    }

    public Long getPunish_result_expropriatton_v() {
        return punish_result_expropriatton_v;
    }

    public void setPunish_result_expropriatton_v(
            Long punish_result_expropriatton_v) {
        this.punish_result_expropriatton_v = punish_result_expropriatton_v;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParentDepno() {
        return parentDepno;
    }

    public void setParentDepno(String parentDepno) {
        this.parentDepno = parentDepno;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void copy(PunishBasic other) {
        this.setNo(other.getNo());
        this.update_date = other.update_date;
        this.internal_no = other.internal_no;
        this.org_id = other.org_id;
        this.department = other.department;
        this.source = other.source;
        this.fact = other.fact;
        this.content = other.content;
        this.punish_time = other.punish_time;
        this.punish_target = other.punish_target;
        this.target_type = other.target_type;
        this.target_code = other.target_code;
        this.target_phone = other.target_phone;
        this.target_mobile = other.target_mobile;
        this.target_paper_type = other.target_paper_type;

        this.target_email = other.target_email;

        this.reporter = other.reporter;
        this.bookDate = other.bookDate;
        /*
         * this.personNum = other.personNum; this.corpNum = other.corpNum;
         */

        this.recodeStyle = other.recodeStyle;
        this.punish_class = other.punish_class;
        this.isRecord = other.isRecord;
        this.punish_result_fine = other.punish_result_fine;
        this.punish_result_expropriatton_v = other.punish_result_expropriatton_v;
        this.createDate = other.getCreateDate();
        this.item_id = other.item_id;
        this.parentDepno = other.parentDepno;
        this.itemName = other.itemName;
    }

    public void copyNotNullProperty(PunishBasic other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());
        if (other.getUpdate_date() != null)
            this.update_date = other.update_date;

        if (other.getInternal_no() != null)
            this.internal_no = other.internal_no;
        if (other.getOrg_id() != null)
            this.org_id = other.org_id;
        if (other.getDepartment() != null)
            this.department = other.department;
        if (other.getSource() != null)
            this.source = other.source;
        if (other.getFact() != null)
            this.fact = other.fact;
        if (other.getContent() != null)
            this.content = other.content;
        if (other.getPunish_time() != null)
            this.punish_time = other.punish_time;
        if (other.getPunish_target() != null)
            this.punish_target = other.punish_target;
        if (other.getTarget_type() != null)
            this.target_type = other.target_type;
        if (other.getTarget_code() != null)
            this.target_code = other.target_code;
        if (other.getTarget_phone() != null)
            this.target_phone = other.target_phone;
        if (other.getTarget_mobile() != null)
            this.target_mobile = other.target_mobile;
        if (other.getTarget_paper_type() != null)
            this.target_paper_type = other.target_paper_type;

        if (other.getTarget_email() != null)
            this.target_email = other.target_email;

        if (other.getReporter() != null)
            this.reporter = other.reporter;
        if (other.getBookDate() != null)
            this.bookDate = other.bookDate;
        /*
         * if (other.getPersonNum() != null) this.personNum = other.personNum;
         * if (other.getCorpNum() != null) this.corpNum = other.corpNum;
         */

        if (other.getRecodeStyle() != null)
            this.recodeStyle = other.recodeStyle;
        if (other.getPunish_class() != null)
            this.punish_class = other.punish_class;
        if (other.getIsRecord() != null)
            this.isRecord = other.isRecord;
        if (other.getPunish_result_fine() != null)
            this.punish_result_fine = other.punish_result_fine;
        if (other.getPunish_result_expropriatton_v() != null)
            this.punish_result_expropriatton_v = other.punish_result_expropriatton_v;

        if (other.getItem_id() != null)
            this.item_id = other.item_id;
        if (other.getParentDepno() != null)
            this.parentDepno = other.parentDepno;
        if (other.getItemName() != null)
            this.itemName = other.itemName;
        if (other.getCreateDate() != null) {
            this.createDate = other.getCreateDate();
        }
    }

    public void clearProperties() {
        this.no = null;
        this.update_date = null;

        this.internal_no = null;
        this.org_id = null;
        this.department = null;
        this.source = null;
        this.fact = null;
        this.content = null;
        this.punish_time = null;
        this.punish_target = null;
        this.target_type = null;
        this.target_code = null;
        this.target_phone = null;
        this.target_mobile = null;
        this.target_paper_type = null;

        this.target_email = null;

        this.reporter = null;
        this.bookDate = null;
        /*
         * this.personNum = null; this.corpNum = null;
         */

        this.recodeStyle = null;
        this.punish_class = null;
        this.isRecord = null;
        this.punish_result_fine = null;
        this.punish_result_expropriatton_v = null;
        this.createDate = null;
        this.item_id = null;
        this.parentDepno = null;
        this.itemName = null;
    }

}
