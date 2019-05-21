package com.centit.complaint.service;

import java.util.List;

import com.centit.complaint.po.ComplaintsProcess;
import com.centit.core.service.BaseEntityManager;

public interface ComplaintsprocessManager extends
        BaseEntityManager<ComplaintsProcess> {

    public List<ComplaintsProcess> getObjListByComplaintId(String complaintId);

    public String getNextKey();
}
