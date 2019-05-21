package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Lawmen;
import com.centit.powerbase.po.Lawmenannual;

public interface LawmenManager extends BaseEntityManager<Lawmen> {
    // 执行人员管理list
    public List<Lawmen> lawmenManagementList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    // 获取下一个执行人员编号
    public String genNextChangeId();

    // 保存执行人员管理——>新添加的执行人员信息
    public void lawmenSave(Lawmen info);

    // 获取具体执法人员信息
    public Lawmen getLawmenByUseridNo(String user_id, String lawmenId);

    // 获取具体执法人员信息
    public Lawmen getLawmenByLawmenId(String lawmenId);

    // 执法人员审核同时修改俩个表的信息
    public void saveboth(Lawmen info, Lawmenannual infoAnnual);

    // 获取下一个执行人员编号
    public String genNextAnnualId();
}
