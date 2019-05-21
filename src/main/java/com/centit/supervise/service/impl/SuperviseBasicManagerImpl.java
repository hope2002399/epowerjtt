package com.centit.supervise.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.supervise.dao.SuperviseBasicDao;
import com.centit.supervise.dao.VSuperviseBasicDao;
import com.centit.supervise.po.SuperviseBasic;
import com.centit.supervise.po.VSuperviseBasic;
import com.centit.supervise.service.SuperviseBasicManager;
import com.centit.sys.service.CodeRepositoryUtil;

public class SuperviseBasicManagerImpl extends
        BaseEntityManagerImpl<SuperviseBasic> implements SuperviseBasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(SuperviseBasicManager.class);

    private SuperviseBasicDao superviseBasicDao;
    private VSuperviseBasicDao vsuperviseBasicDao;

    public void setVsuperviseBasicDao(VSuperviseBasicDao vsuperviseBasicDao) {
        this.vsuperviseBasicDao = vsuperviseBasicDao;
    }

    public void setSuperviseBasicDao(SuperviseBasicDao baseDao) {
        this.superviseBasicDao = baseDao;
        setBaseDao(this.superviseBasicDao);
    }

    @Override
    public SuperviseBasic getSuperviseBasicByFlowId(Long flowInstId) {
        return superviseBasicDao.getSuperviseBasicByFlowId(flowInstId);
    }

    public String getNextkey() {
        return CodeRepositoryUtil.getValue("DBBM", "DBBM")
                + superviseBasicDao.getNextKeyBySequence("S_SUPERIVSENO", 10);
    }

    public List<VSuperviseBasic> listVSuperviseBasic(
            Map<String, Object> filtermap, PageDesc pagedesc) {
        if (filtermap.get("queryUnderUnit") != null
                && !filtermap.get("queryUnderUnit").equals("")
                && filtermap.get("monitorOrgId") != null
                && !filtermap.get("monitorOrgId").equals("")
                && filtermap.get("subunit") != null
                && !filtermap.get("subunit").equals("")) {
            filtermap.put("monitorOrgId", "");
            String hql = "From VSuperviseBasic  where  monitorOrgId in("
                    + filtermap.get("subunit") + ") ";
            return this.vsuperviseBasicDao
                    .listObjects(hql, filtermap, pagedesc);
        }
        if (filtermap.get("queryUnderUnit") != null
                && !filtermap.get("queryUnderUnit").equals("")
                && filtermap.get("orgId") != null
                && !filtermap.get("orgId").equals("")
                && filtermap.get("subunit") != null
                && !filtermap.get("subunit").equals("")) {
            filtermap.put("orgId", "");
            String hql = "From VSuperviseBasic  where  orgId in("
                    + filtermap.get("subunit") + ") ";
            return this.vsuperviseBasicDao
                    .listObjects(hql, filtermap, pagedesc);
        }
        return this.vsuperviseBasicDao.listObjects(filtermap, pagedesc);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getdblist(String begintime, String endtime) {

        return vsuperviseBasicDao.getdblist(begintime, endtime);
    }

    @Override
    public String getDbbmForCjdbByDepno(String depno) {

        return vsuperviseBasicDao.getDbbmForCjdbByDepno(depno);
    }

}
