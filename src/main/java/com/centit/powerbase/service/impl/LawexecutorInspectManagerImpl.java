package com.centit.powerbase.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerbase.dao.LawExecutorDao;
import com.centit.powerbase.dao.LawexecutorInspectDao;
import com.centit.powerbase.po.LawExecutor;
import com.centit.powerbase.po.LawexecutorInspect;
import com.centit.powerbase.service.LawexecutorInspectManager;

/**
 * 
 * 执法人年检Manager
 * 
 * @author JF
 * @create 2013-10-25
 * @version
 */
public class LawexecutorInspectManagerImpl extends
        BaseEntityManagerImpl<LawexecutorInspect> implements
        LawexecutorInspectManager {

    private static final long serialVersionUID = 1L;

    public static final Log log = LogFactory
            .getLog(LawexecutorInspectManager.class);

    private LawexecutorInspectDao lawexecutorInspectDao;

    private LawExecutorDao lawExecutorDao;

    public void setLawexecutorInspectDao(LawexecutorInspectDao baseDao) {
        this.lawexecutorInspectDao = baseDao;
        setBaseDao(this.lawexecutorInspectDao);
    }

    public void setLawExecutorDao(LawExecutorDao lawExecutorDao) {
        this.lawExecutorDao = lawExecutorDao;
    }

    @Override
    public void saveObject(LawexecutorInspect o) {
        // 生成主键
        Long key = this.lawexecutorInspectDao
                .getNextLongSequence("S_LAWEXECUTOR_INSPECT_ID");
        o.setInspectId(key);
        this.lawexecutorInspectDao.save(o);

        LawExecutor e = this.lawExecutorDao.getObjectById(o.getStaffno());
        e.setStatus(o.getInspectType()); // 人员状态
        e.setPasslife(o.getInspectValidate()); // 有效期
        this.lawexecutorInspectDao.save(e);

    }
}
