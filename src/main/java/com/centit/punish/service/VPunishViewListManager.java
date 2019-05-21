package com.centit.punish.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.VPunishViewList;

public interface VPunishViewListManager extends
        BaseEntityManager<VPunishViewList> {

    public List<VPunishViewList> listPunishObjectBasics(
            Map<String, Object> filterMap, PageDesc pageDesc);

}
