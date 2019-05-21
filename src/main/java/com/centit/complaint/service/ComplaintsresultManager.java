package com.centit.complaint.service;

import com.centit.complaint.po.ComplaintsResult;
import com.centit.core.service.BaseEntityManager;

public interface ComplaintsresultManager extends
        BaseEntityManager<ComplaintsResult> {
    /**
     * 根据投诉编号，获得对应的投诉结果信息
     * 
     * @param complaintId
     * @return
     */
    public ComplaintsResult getObjectByComplaintsId(String complaintId);

    public String getNextComplaintNo(String depno);

    public String getDetailByid(String complaintid);
}
