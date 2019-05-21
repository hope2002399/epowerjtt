package com.centit.dispatchdoc.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.dao.DispatchDocTaskDao;
import com.centit.dispatchdoc.dao.IncomeDocTaskDao;
import com.centit.dispatchdoc.po.DispatchDocTask;
import com.centit.dispatchdoc.po.IncomeDocTask;
import com.centit.dispatchdoc.service.IODocTasksManager;

public class IODocTasksManagerImpl implements IODocTasksManager {
    public static final Log log = LogFactory.getLog(IODocTasksManager.class);

    private DispatchDocTaskDao dispatchDocTaskDao;
    private IncomeDocTaskDao incomeDocTaskDao;

    public List<IncomeDocTask> listIncomeDocTask(Map<String, Object> filterMap,
            PageDesc pageDesc) {

        return incomeDocTaskDao.listObjects(filterMap, pageDesc);
    }

    public List<DispatchDocTask> listDispatchDocTask(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return dispatchDocTaskDao.listObjects(filterMap, pageDesc);
    }

    public void setIncomeDocTaskDao(IncomeDocTaskDao baseDao) {
        this.incomeDocTaskDao = baseDao;
    }

    public void setDispatchDocTaskDao(DispatchDocTaskDao baseDao) {
        this.dispatchDocTaskDao = baseDao;
    }
}
