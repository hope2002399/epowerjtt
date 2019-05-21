package com.centit.complaint.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.complaint.dao.VUserTaskListComplaintDao;
import com.centit.complaint.po.VUserTaskListComplaint;
import com.centit.complaint.service.VUserTaskListComplaintManager;
import com.centit.core.service.BaseEntityManagerImpl;

public class VUserTaskListComplaintManagerImpl extends
        BaseEntityManagerImpl<VUserTaskListComplaint> implements
        VUserTaskListComplaintManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VUserTaskListComplaintManager.class);

    private VUserTaskListComplaintDao VUserTaskListComplaintDao;

    public void setVUserTaskListComplaintDao(VUserTaskListComplaintDao baseDao) {
        this.VUserTaskListComplaintDao = baseDao;
        setBaseDao(this.VUserTaskListComplaintDao);
    }

}
