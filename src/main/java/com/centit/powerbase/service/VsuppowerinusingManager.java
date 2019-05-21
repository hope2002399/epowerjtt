package com.centit.powerbase.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerbase.po.Vsuppowerinusing;

public interface VsuppowerinusingManager extends
        BaseEntityManager<Vsuppowerinusing> {

    public Vsuppowerinusing findB_PowerByItemId(String itemId);

}
