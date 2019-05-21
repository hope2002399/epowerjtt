package com.centit.monitor.po;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-25
 * @version
 */
public class FormInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String key;
    private String name;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
