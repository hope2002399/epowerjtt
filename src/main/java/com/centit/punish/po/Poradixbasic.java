package com.centit.punish.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poradixbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long radixid;
    private String punishobjectid;

    private String punishtypeid;
    private String item_id;
    private Long radix;
    private Double multiple;
    private Long degreeno;

    private String radixName;

    public String getRadixName() {
        return radixName;
    }

    public void setRadixName(String radixName) {
        this.radixName = radixName;
    }

    public String getRadixUnit() {
        return radixUnit;
    }

    public void setRadixUnit(String radixUnit) {
        this.radixUnit = radixUnit;
    }

    private String radixUnit;

    // Constructors
    /** default constructor */
    public Poradixbasic() {
    }

    /** minimal constructor */
    public Poradixbasic(Long radixid) {

        this.radixid = radixid;

    }

    /** full constructor */
    public Poradixbasic(Long radixid, String punishtypeid, String item_id,
            Long radix, Double multiple, Long degreeno) {

        this.radixid = radixid;

        this.punishtypeid = punishtypeid;
        this.item_id = item_id;
        this.radix = radix;
        this.multiple = multiple;
        this.degreeno = degreeno;
    }

    public Long getRadixid() {
        return this.radixid;
    }

    public void setRadixid(Long radixid) {
        this.radixid = radixid;
    }

    public String getPunishobjectid() {
        return punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public String getPunishtypeid() {
        return this.punishtypeid;
    }

    public void setPunishtypeid(String punishtypeid) {
        this.punishtypeid = punishtypeid;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Long getRadix() {
        return this.radix;
    }

    public void setRadix(Long radix) {
        this.radix = radix;
    }

    public Double getMultiple() {
        return this.multiple;
    }

    public void setMultiple(Double multiple) {
        this.multiple = multiple;
    }

    public Long getDegreeno() {
        return this.degreeno;
    }

    public void setDegreeno(Long degreeno) {
        this.degreeno = degreeno;
    }

    public void copy(Poradixbasic other) {

        this.setRadixid(other.getRadixid());
        this.punishobjectid = (other.getPunishobjectid());
        this.punishtypeid = other.getPunishtypeid();
        this.item_id = other.getItem_id();
        this.radix = other.getRadix();
        this.multiple = other.getMultiple();
        this.degreeno = other.getDegreeno();

    }

    public void copyNotNullProperty(Poradixbasic other) {

        if (other.getRadixid() != null)
            this.setRadixid(other.getRadixid());

        if (other.getPunishtypeid() != null)
            this.punishtypeid = other.getPunishtypeid();
        if (other.getItem_id() != null)
            this.item_id = other.getItem_id();
        if (other.getRadix() != null)
            this.radix = other.getRadix();
        if (other.getMultiple() != null)
            this.multiple = other.getMultiple();
        if (other.getDegreeno() != null)
            this.degreeno = other.getDegreeno();

    }

    public void clearProperties() {
        this.punishobjectid = null;
        this.punishtypeid = null;
        this.item_id = null;
        this.radix = null;
        this.multiple = null;
        this.degreeno = null;

    }
}
