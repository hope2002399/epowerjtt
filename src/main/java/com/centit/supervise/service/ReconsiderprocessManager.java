package com.centit.supervise.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.supervise.po.Reconsiderprocess;

public interface ReconsiderprocessManager extends
        BaseEntityManager<Reconsiderprocess> {

    public Reconsiderprocess getObjectByNodeInstId(Long nodeInstId);

    public String getNextKey();

    public List<Reconsiderprocess> getObjListByReconsiderId(String reconsiderId);

}
