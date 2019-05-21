package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.LawVehicle;

public interface LawVehicleManager extends BaseEntityManager<LawVehicle> {

    public String generateNextVehicleId();

    public List<LawVehicle> lawVehicleList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public LawVehicle getUpdateNo(String vehicleId);

    public boolean checkplateNumber(String plateNumber);
}
