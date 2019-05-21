package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.LawExecutorDao;
import com.centit.powerbase.po.LawExecutor;
import com.centit.powerbase.service.LawExecutorManager;

/**
 * 
 * 执法人员管理Service
 * 
 * @author jf
 * @create 2013-10-25
 * @version
 */
public class LawExecutorManagerImpl extends BaseEntityManagerImpl<LawExecutor>
        implements LawExecutorManager {
    private static final long serialVersionUID = 1L;

    public static final Log log = LogFactory.getLog(LawExecutorManager.class);

    private LawExecutorDao lawExecutorDao;

    public void setLawExecutorDao(LawExecutorDao baseDao) {
        this.lawExecutorDao = baseDao;
        setBaseDao(this.lawExecutorDao);
    }

    public String createStaffno(String deptid) {
        return lawExecutorDao.createStaffno(deptid);
    }

    @Override
    public List<LawExecutor> pageCheckList(String unitcode,
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return lawExecutorDao.pageCheckList(unitcode, filterMap, pageDesc);
    }

    @Override
    public boolean IsPasscodeExist(String passcode) {
        
        return lawExecutorDao.IsPasscodeExist(passcode);
    }
}
