package com.centit.supervise.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.supervise.dao.VUserTaskListSuperviseDao;
import com.centit.supervise.po.VUserTaskListSupervise;
import com.centit.supervise.service.VUserTaskListSuperviseManager;

public class VUserTaskListSuperviseManagerImpl extends
        BaseEntityManagerImpl<VUserTaskListSupervise> implements
        VUserTaskListSuperviseManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VUserTaskListSuperviseManager.class);

    private VUserTaskListSuperviseDao VUserTaskListSuperviseDao;

    public void setVUserTaskListSuperviseDao(VUserTaskListSuperviseDao baseDao) {
        this.VUserTaskListSuperviseDao = baseDao;
        setBaseDao(this.VUserTaskListSuperviseDao);
    }

}
