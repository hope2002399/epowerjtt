package com.centit.supervise.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.supervise.po.SuperviseReply;
import com.centit.workflow.sample.po.WfFlowInstance;

public interface SuperviseReplyManager extends
        BaseEntityManager<SuperviseReply> {

    public List<SuperviseReply> getObjListBySuperviseNo(String superviseNo);

    public void updateWfFlowInstance(WfFlowInstance dbflowINST);

    public SuperviseReply getObjectByNodeInstId(long nodeInstId);

    public String getNextKey();

}
