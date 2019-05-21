package com.centit.punish.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.Punishrecordparam;

public interface PunishrecordparamManager extends
        BaseEntityManager<Punishrecordparam> {
    // 处罚备案参数管理列表
    public List<Punishrecordparam> punishrecordparamList(
            Map<String, Object> filterMap, PageDesc pageDesc);

    // 保存 处罚备案参数
    public void punishrecordparamSave(Punishrecordparam info);

}
