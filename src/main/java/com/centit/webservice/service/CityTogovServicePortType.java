package com.centit.webservice.service;

import com.centit.webservice.po.Arg;
import com.centit.webservice.po.Result;

public interface CityTogovServicePortType extends java.rmi.Remote {
    public Result cityToGovMail(Arg arg) throws java.rmi.RemoteException;

    public Result cityGetGovLogis(Arg arg) throws java.rmi.RemoteException;
}
