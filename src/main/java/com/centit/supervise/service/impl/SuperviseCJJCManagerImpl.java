package com.centit.supervise.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.supervise.dao.SuperviseCJJCDao;
import com.centit.supervise.po.SuperviseCJJC;
import com.centit.supervise.service.SuperviseCJJCManager;

public class SuperviseCJJCManagerImpl extends
        BaseEntityManagerImpl<SuperviseCJJC> implements SuperviseCJJCManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SuperviseCJJCManager.class);

    private SuperviseCJJCDao superviseCJJCDao;

    public void setSuperviseCJJCDao(SuperviseCJJCDao supDao) {
        this.superviseCJJCDao = supDao;
        setBaseDao(this.superviseCJJCDao);
    }

    @Override
    public SuperviseCJJC getSuperviseCJJCByCode(String supervisecode) {
        return superviseCJJCDao.getSuperviseCJJCByCode(supervisecode);
    }

    public String getNextkey() {
        return superviseCJJCDao.getNextKeyBySequence("S_SUPERIVSENO", 10);
    }

    public List<SuperviseCJJC> listSuperviseCJJC(Map<String, Object> filtermap,
            PageDesc pagedesc) {
        return this.superviseCJJCDao.listObjects(filtermap, pagedesc);
    }

}
