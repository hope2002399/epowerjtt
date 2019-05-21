package com.centit.complaint.service;

import java.util.List;
import java.util.Map;

import com.centit.complaint.po.Complaint;
import com.centit.complaint.po.VComplaint;
import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;

public interface ComplaintManager extends BaseEntityManager<Complaint> {
    public String getNextkey();

    public List<VComplaint> listVComplaint(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public Complaint getComplaintByFlowId(Long flowInstId);

    public List<VComplaint> listVComplaint(Map<String, Object> filterMap);
}
