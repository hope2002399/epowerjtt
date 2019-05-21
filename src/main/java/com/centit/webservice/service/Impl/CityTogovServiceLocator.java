package com.centit.webservice.service.Impl;

import com.centit.webservice.service.CityTogovService;
import com.centit.webservice.service.CityTogovServicePortType;

public class CityTogovServiceLocator extends org.apache.axis.client.Service
        implements CityTogovService {

    private static final long serialVersionUID = 1L;

    public CityTogovServiceLocator() {
    }

    public CityTogovServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CityTogovServiceLocator(java.lang.String wsdlLoc,
            javax.xml.namespace.QName sName)
            throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for citytogovserviceServiceSoapBinding_Port
    /*
     * "http://193.168.1.88:7879/onlineGovEMS_dpl_onlineGovEMS/services/citytogovserviceService/" 测试地址。
     * ;
     */
    private java.lang.String citytogovserviceServiceSoapBinding_Port_address = "http://193.168.1.88:7879/onlineFormalGovEMS_dpl_onlineFormalGovEMS/services/citytogovserviceService?wsdl";

    public java.lang.String getcitytogovserviceServiceSoapBinding_PortAddress() {
        return citytogovserviceServiceSoapBinding_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String citytogovserviceServiceSoapBinding_PortWSDDServiceName = "citytogovserviceServiceSoapBinding_Port";

    public java.lang.String getcitytogovserviceServiceSoapBinding_PortWSDDServiceName() {
        return citytogovserviceServiceSoapBinding_PortWSDDServiceName;
    }

    public void setcitytogovserviceServiceSoapBinding_PortWSDDServiceName(
            java.lang.String name) {
        citytogovserviceServiceSoapBinding_PortWSDDServiceName = name;
    }

    public CityTogovServicePortType getcitytogovserviceServiceSoapBinding_Port()
            throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(
                    citytogovserviceServiceSoapBinding_Port_address);
        } catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getcitytogovserviceServiceSoapBinding_Port(endpoint);
    }

    public CityTogovServicePortType getcitytogovserviceServiceSoapBinding_Port(
            java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CityTogovServiceSoapBindingStub _stub = new CityTogovServiceSoapBindingStub(
                    portAddress, this);
            _stub.setPortName(getcitytogovserviceServiceSoapBinding_PortWSDDServiceName());
            return _stub;
        } catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setcitytogovserviceServiceSoapBinding_PortEndpointAddress(
            java.lang.String address) {
        citytogovserviceServiceSoapBinding_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation. If this service has
     * no port for the given interface, then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface)
            throws javax.xml.rpc.ServiceException {
        try {
            if (CityTogovServicePortType.class
                    .isAssignableFrom(serviceEndpointInterface)) {
                CityTogovServiceSoapBindingStub _stub = new CityTogovServiceSoapBindingStub(
                        new java.net.URL(
                                citytogovserviceServiceSoapBinding_Port_address),
                        this);
                _stub.setPortName(getcitytogovserviceServiceSoapBinding_PortWSDDServiceName());
                return _stub;
            }
        } catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException(
                "There is no stub implementation for the interface:  "
                        + (serviceEndpointInterface == null ? "null"
                                : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation. If this service has
     * no port for the given interface, then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName,
            Class serviceEndpointInterface)
            throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("citytogovserviceServiceSoapBinding_Port".equals(inputPortName)) {
            return getcitytogovserviceServiceSoapBinding_Port();
        } else {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName(
                "http://powerjtt/wsfolder/onlinegovems/inboundservice/onlineGovEMS",
                "citytogovserviceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName(
                    "http://powerjtt/wsfolder/onlinegovems/inboundservice/onlineGovEMS",
                    "citytogovserviceServiceSoapBinding_Port"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(java.lang.String portName,
            java.lang.String address) throws javax.xml.rpc.ServiceException {

        if ("citytogovserviceServiceSoapBinding_Port".equals(portName)) {
            setcitytogovserviceServiceSoapBinding_PortEndpointAddress(address);
        } else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(
                    " Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName,
            java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
