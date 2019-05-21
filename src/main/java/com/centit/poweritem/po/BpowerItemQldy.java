package com.centit.poweritem.po;

public class BpowerItemQldy implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String serviceId;
    private String serviceName;
    private String itemMainId;
    private String itemMainName;
    private String itemSubId;
    private String itemSubName;
    private String itemQldyItemId;
    private String status;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getItemMainId() {
        return itemMainId;
    }

    public void setItemMainId(String itemMainId) {
        this.itemMainId = itemMainId;
    }

    public String getItemMainName() {
        return itemMainName;
    }

    public void setItemMainName(String itemMainName) {
        this.itemMainName = itemMainName;
    }

    public String getItemSubId() {
        return itemSubId;
    }

    public void setItemSubId(String itemSubId) {
        this.itemSubId = itemSubId;
    }

    public String getItemSubName() {
        return itemSubName;
    }

    public void setItemSubName(String itemSubName) {
        this.itemSubName = itemSubName;
    }

    public String getItemQldyItemId() {
        return itemQldyItemId;
    }

    public void setItemQldyItemId(String itemQldyItemId) {
        this.itemQldyItemId = itemQldyItemId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BpowerItemQldy(String serviceId, String serviceName,
            String itemMainId, String itemMainName, String itemSubId,
            String itemSubName, String itemQldyItemId, String status) {
        super();
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.itemMainId = itemMainId;
        this.itemMainName = itemMainName;
        this.itemSubId = itemSubId;
        this.itemSubName = itemSubName;
        this.itemQldyItemId = itemQldyItemId;
        this.status = status;
    }

    public BpowerItemQldy() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void copy(BpowerItemQldy other) {
        this.serviceName = other.getServiceName();
        this.itemMainId = other.getItemMainId();
        this.itemMainName = other.getItemMainName();
        this.itemSubId = other.getItemSubId();
        this.itemSubName = other.getItemSubName();
        this.itemQldyItemId = other.getItemQldyItemId();
        this.status = other.getStatus();
    }

    public void copyNotNullProperty(BpowerItemQldy other) {
        if (other.getServiceName() != null)
            this.serviceName = other.getServiceName();
        if (other.getItemMainId() != null)
            this.itemMainId = other.getItemMainId();
        if (other.getItemMainName() != null)
            this.itemMainName = other.getItemMainName();
        if (other.getItemSubId() != null)
            this.itemSubId = other.getItemSubId();
        if (other.getItemSubName() != null)
            this.itemSubName = other.getItemSubName();
        if (other.getItemQldyItemId() != null)
            this.itemQldyItemId = other.getItemQldyItemId();
        if (other.getStatus() != null)
            this.status = other.getStatus();
    }

    public void clearProperties() {
        this.serviceName = null;
        this.itemMainId = null;
        this.itemMainName = null;
        this.itemSubId = null;
        this.itemSubName = null;
        this.itemQldyItemId = null;
        this.status = null;
    }
}
