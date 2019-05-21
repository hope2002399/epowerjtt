package com.centit.webservice.service.Impl;

import com.centit.webservice.po.Arg;
import com.centit.webservice.po.Result;
import com.centit.webservice.service.CityTogovServicePortType;

public class CityTogovServicePortTypeProxy implements CityTogovServicePortType {
  private String _endpoint = null;
  private CityTogovServicePortType citytogovserviceServicePortType = null;
  
  public CityTogovServicePortTypeProxy() {
    _initCitytogovserviceServicePortTypeProxy();
  }
  
  public CityTogovServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCitytogovserviceServicePortTypeProxy();
  }
  
  private void _initCitytogovserviceServicePortTypeProxy() {
    try {
      citytogovserviceServicePortType = (new CityTogovServiceLocator()).getcitytogovserviceServiceSoapBinding_Port();
      if (citytogovserviceServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)citytogovserviceServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)citytogovserviceServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (citytogovserviceServicePortType != null)
      ((javax.xml.rpc.Stub)citytogovserviceServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public CityTogovServicePortType getCitytogovserviceServicePortType() {
    if (citytogovserviceServicePortType == null)
      _initCitytogovserviceServicePortTypeProxy();
    return citytogovserviceServicePortType;
  }
  
  public Result cityToGovMail(Arg arg) throws java.rmi.RemoteException{
    if (citytogovserviceServicePortType == null)
      _initCitytogovserviceServicePortTypeProxy();
    return citytogovserviceServicePortType.cityToGovMail(arg);
  }
  
  public Result cityGetGovLogis(Arg arg) throws java.rmi.RemoteException{
    if (citytogovserviceServicePortType == null)
      _initCitytogovserviceServicePortTypeProxy();
    return citytogovserviceServicePortType.cityGetGovLogis(arg);
  }
  
  
}