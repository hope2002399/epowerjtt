package com.centit.monitor.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.PacheckupparamDao;
import com.centit.monitor.po.Pacheckupparam;
import com.centit.monitor.service.PacheckupparamManager;

public class PacheckupparamManagerImpl extends
        BaseEntityManagerImpl<Pacheckupparam> implements PacheckupparamManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PacheckupparamManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private PacheckupparamDao pacheckupparamDao;

    public void setPacheckupparamDao(PacheckupparamDao baseDao) {
        this.pacheckupparamDao = baseDao;
        setBaseDao(this.pacheckupparamDao);
    }

    @Override
    public List<Pacheckupparam> getPacheckupparamList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        
        return pacheckupparamDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public boolean insertPerformance(Date yearAndmonth, String deleteOld,
            String onlyCalcSum) {
        boolean bl = true;
        boolean flag = true;
        if (flag) {
            log.info("对所有部门进行评估考核计算开始...");
            try {
                this.callAppraisalDeptAll(yearAndmonth, deleteOld, onlyCalcSum);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            log.info(flag + "==对所有部门进行评估考核计算结束\n");
        }

        return bl;
    }

    public boolean insertPerformancedep(String orgId, Date yearAndmonth,
            String deleteOld, String onlyCalcSum) {
        boolean bl = true;
        boolean flag = true;

        if (flag) {
            log.info("对部门进行评估考核计算开始...");
            try {
                this.calappraisal_dept(orgId, yearAndmonth, deleteOld,
                        onlyCalcSum);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            log.info(flag + "==对部门进行评估考核计算结束\n");
        }
        return bl;
    }

    public boolean calappraisal_dept(String orgId, Date yearAndmonth,
            String deleteOld, String onlyCalcSum) throws Exception {
        return pacheckupparamDao.callAppraisalDept(orgId, yearAndmonth,
                deleteOld, onlyCalcSum);
    }

    public boolean callAppraisalDeptAll(Date yearAndmonth, String deleteOld,
            String onlyCalcSum) throws Exception {
        return pacheckupparamDao.callAppraisalDeptAll(yearAndmonth, deleteOld,
                onlyCalcSum);
    }

}
