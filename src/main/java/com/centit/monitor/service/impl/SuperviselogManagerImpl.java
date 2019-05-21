package com.centit.monitor.service.impl;

import java.util.List;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.SuperviselogDao;
import com.centit.monitor.po.Superviselog;
import com.centit.monitor.service.SuperviselogManager;

public class SuperviselogManagerImpl extends
        BaseEntityManagerImpl<Superviselog> implements SuperviselogManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SuperviselogDao superviselogDao;

    public void setSuperviselogDao(SuperviselogDao baseDao) {
        this.superviselogDao = baseDao;
        setBaseDao(this.superviselogDao);
    }

    /**
     * 获取监察日志功能optID列表
     * 
     * @return
     */
    public List<String> getOptList() {
        return superviselogDao.getOptList();
    }

    @Override
    public void saveObject(Superviselog o) {
        o.setLogid(Long.parseLong(this.superviselogDao
                .getNextValueOfSequence("S_Supviselog")));
        super.saveObject(o);
    }

}
