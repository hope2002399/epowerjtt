package com.centit.complaint.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.complaint.dao.ComplaintDao;
import com.centit.complaint.dao.VComplaintDao;
import com.centit.complaint.po.Complaint;
import com.centit.complaint.po.VComplaint;
import com.centit.complaint.service.ComplaintManager;
import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;

public class ComplaintManagerImpl extends BaseEntityManagerImpl<Complaint>
        implements ComplaintManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ComplaintManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private ComplaintDao complaintDao;
    private VComplaintDao vComplaintDao;

    public void setvComplaintDao(VComplaintDao vComplaintDao) {
        this.vComplaintDao = vComplaintDao;
    }

    public void setComplaintDao(ComplaintDao baseDao) {
        this.complaintDao = baseDao;
        setBaseDao(this.complaintDao);
    }

    @Override
    public String getNextkey() {
        return "TS" + complaintDao.getNextKeyBySequence("S_COMPLAINTID", 6);
    }

    @Override
    public Complaint getComplaintByFlowId(Long flowInstId) {
        return complaintDao.getComplaintByFlowId(flowInstId);
    }

    @Override
    public List<VComplaint> listVComplaint(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        return vComplaintDao.listObjects(filterMap, pageDesc);
    }

    public List<VComplaint> listVComplaint(Map<String, Object> filterMap) {
        
        return vComplaintDao.listObjects(filterMap);
    }

}
