package com.centit.complaint.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.complaint.dao.ComplaintsprocessDao;
import com.centit.complaint.po.ComplaintsProcess;
import com.centit.complaint.service.ComplaintsprocessManager;
import com.centit.core.service.BaseEntityManagerImpl;

public class ComplaintsprocessManagerImpl extends
        BaseEntityManagerImpl<ComplaintsProcess> implements
        ComplaintsprocessManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(ComplaintsprocessManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private ComplaintsprocessDao complaintsprocessDao;

    public void setComplaintsprocessDao(ComplaintsprocessDao baseDao) {
        this.complaintsprocessDao = baseDao;
        setBaseDao(this.complaintsprocessDao);
    }

    @Override
    public List<ComplaintsProcess> getObjListByComplaintId(String complaintId) {

        return complaintsprocessDao.getObjListByComplaintId(complaintId);
    }

    @Override
    public String getNextKey() {
        
        return complaintsprocessDao.getNextKeyBySequence("s_complaintsprocess",
                32);
    }

}
