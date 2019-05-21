package com.centit.supervise.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.supervise.dao.SuperviseResultDao;
import com.centit.supervise.po.SuperviseResult;
import com.centit.supervise.service.SuperviseResultManager;
import com.centit.sys.service.CodeRepositoryUtil;

public class SuperviseResultManagerImpl extends
        BaseEntityManagerImpl<SuperviseResult> implements
        SuperviseResultManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(SuperviseResultManager.class);

    private SuperviseResultDao superviseResultDao;

    public void setSuperviseResultDao(SuperviseResultDao baseDao) {
        this.superviseResultDao = baseDao;
        setBaseDao(this.superviseResultDao);
    }

    @Override
    public SuperviseResult getSuperviseResultBySuperviseNo(String superviseNo) {
        
        return superviseResultDao.getSuperviseResultBySuperviseNo(superviseNo);
    }

    @Override
    public String getNextKeyId() {
        return CodeRepositoryUtil.getValue("DBBM", "DBBM")
                + superviseResultDao.getNextKeyBySequence(
                        "S_SUPERVISERESULTNO", 10);
    }

}
