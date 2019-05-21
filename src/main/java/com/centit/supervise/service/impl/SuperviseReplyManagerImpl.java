package com.centit.supervise.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.supervise.dao.SuperviseReplyDao;
import com.centit.supervise.po.SuperviseReply;
import com.centit.supervise.service.SuperviseReplyManager;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.workflow.sample.dao.WfFlowInstanceDao;
import com.centit.workflow.sample.po.WfFlowInstance;

public class SuperviseReplyManagerImpl extends
        BaseEntityManagerImpl<SuperviseReply> implements SuperviseReplyManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(SuperviseReplyManager.class);

    private SuperviseReplyDao superviseReplyDao;
    private WfFlowInstanceDao wfFlowInstanceDao;

    public void setSuperviseReplyDao(SuperviseReplyDao baseDao) {
        this.superviseReplyDao = baseDao;
        setBaseDao(this.superviseReplyDao);
    }

    @Override
    public List<SuperviseReply> getObjListBySuperviseNo(String superviseNo) {
        
        return superviseReplyDao.getObjListBySuperviseNo(superviseNo);
    }

    @Override
    public void updateWfFlowInstance(WfFlowInstance dbflowINST) {
        wfFlowInstanceDao.saveObject(dbflowINST);
    }

    public void setWfFlowInstanceDao(WfFlowInstanceDao wfFlowInstanceDao) {
        this.wfFlowInstanceDao = wfFlowInstanceDao;
    }

    @Override
    public SuperviseReply getObjectByNodeInstId(long nodeInstId) {
        
        return superviseReplyDao.getObjectByNodeInstId(nodeInstId);
    }

    @Override
    public String getNextKey() {
        
        return CodeRepositoryUtil.getValue("DBBM", "DBBM")
                + superviseReplyDao
                        .getNextKeyBySequence("s_superviseReply", 10);
    }

}
