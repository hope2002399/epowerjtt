package com.centit.webservice.service;

public interface CityTogovService extends javax.xml.rpc.Service {
    public java.lang.String getcitytogovserviceServiceSoapBinding_PortAddress();

    public CityTogovServicePortType getcitytogovserviceServiceSoapBinding_Port()
            throws javax.xml.rpc.ServiceException;

    public CityTogovServicePortType getcitytogovserviceServiceSoapBinding_Port(
            java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
