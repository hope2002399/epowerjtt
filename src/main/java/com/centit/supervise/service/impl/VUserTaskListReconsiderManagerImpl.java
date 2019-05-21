package com.centit.supervise.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.supervise.dao.VUserTaskListReconsiderDao;
import com.centit.supervise.po.VUserTaskListReconsider;
import com.centit.supervise.service.VUserTaskListReconsiderManager;

public class VUserTaskListReconsiderManagerImpl extends
        BaseEntityManagerImpl<VUserTaskListReconsider> implements
        VUserTaskListReconsiderManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VUserTaskListReconsiderManager.class);

    private VUserTaskListReconsiderDao VUserTaskListReconsiderDao;

    public void setVUserTaskListReconsiderDao(VUserTaskListReconsiderDao baseDao) {
        this.VUserTaskListReconsiderDao = baseDao;
        setBaseDao(this.VUserTaskListReconsiderDao);
    }

}
