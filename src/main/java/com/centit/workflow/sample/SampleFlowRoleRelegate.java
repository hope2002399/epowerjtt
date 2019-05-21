package com.centit.workflow.sample;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.utils.PageDesc;
import com.centit.support.utils.DatetimeOpt;
import com.centit.workflow.FlowRoleRelegate;
import com.centit.workflow.sample.dao.WfRoleRelegateDao;
import com.centit.workflow.sample.po.WfRoleRelegate;

public class SampleFlowRoleRelegate implements FlowRoleRelegate, Serializable {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(SampleFlowRoleRelegate.class);

    private WfRoleRelegateDao flowRoleRelegateDao;

    @Override
    public WfRoleRelegate getObjectById(Long relegateno) {
        return flowRoleRelegateDao.getObjectById(relegateno);
    }

    @Override
    public WfRoleRelegate getObject(WfRoleRelegate roleRelegate) {
        return flowRoleRelegateDao.getObject(roleRelegate);
    }

    @Override
    public void saveRoleRelegate(WfRoleRelegate roleRelegate) {
        roleRelegate.setRecorddate(DatetimeOpt.currentSqlDate());
        flowRoleRelegateDao.saveObject(roleRelegate);
    }

    public List<WfRoleRelegate> listRoleRelegate(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return flowRoleRelegateDao.listObjects(filterMap, pageDesc);
    }

    public void deleteRoleRelegate(Long relegateno) {
        flowRoleRelegateDao.deleteObjectById(relegateno);
    }

    public WfRoleRelegateDao getFlowRoleRelegateDao() {
        return flowRoleRelegateDao;
    }

    public void setFlowRoleRelegateDao(WfRoleRelegateDao flowRoleRelegateDao) {
        this.flowRoleRelegateDao = flowRoleRelegateDao;
    }

}
