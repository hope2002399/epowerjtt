package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Lawenforecase;

public interface LawenforecaseManager extends BaseEntityManager<Lawenforecase> {

    public List<Lawenforecase> LawenforecaseList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public Lawenforecase getUpdateNo(String caseno);

    public void lawenforecaseSave(Lawenforecase phobject);

    public boolean CheckCasenoExist(String caseno);

}
