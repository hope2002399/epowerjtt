package com.centit.powerbase.po;

public class Zf_power implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String itemId;
    private String itemName;

    public Zf_power() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Zf_power(String itemId, String itemName) {
        super();
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
