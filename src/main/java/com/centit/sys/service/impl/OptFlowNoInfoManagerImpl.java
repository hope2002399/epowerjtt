package com.centit.sys.service.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.support.utils.DatetimeOpt;
import com.centit.sys.dao.OptFlowNoInfoDao;
import com.centit.sys.dao.OptFlowNoPoolDao;
import com.centit.sys.po.OptFlowNoInfo;
import com.centit.sys.po.OptFlowNoInfoId;
import com.centit.sys.po.OptFlowNoPool;
import com.centit.sys.po.OptFlowNoPoolId;
import com.centit.sys.service.OptFlowNoInfoManager;

public class OptFlowNoInfoManagerImpl extends
        BaseEntityManagerImpl<OptFlowNoInfo> implements OptFlowNoInfoManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptFlowNoInfoManager.class);

    private OptFlowNoInfoDao optFlowNoInfoDao;
    private OptFlowNoPoolDao optFlowNoPoolDao;

    // <property name="optFlowNoInfoDao" ref="optFlowNoInfoDao" />

    public void setOptFlowNoInfoDao(OptFlowNoInfoDao baseDao) {
        this.optFlowNoInfoDao = baseDao;
        setBaseDao(this.optFlowNoInfoDao);
    }

    public void setOptFlowNoPoolDao(OptFlowNoPoolDao baseDao) {
        this.optFlowNoPoolDao = baseDao;
    }

    @Override
    public synchronized long newNextLsh(String ownerCode, String codeCode,
            Date codeBaseDate) {
        Date codeDate = codeBaseDate;// DatetimeOpt.convertSqlDate(codeBaseDate);
        OptFlowNoInfoId noId = new OptFlowNoInfoId(ownerCode, codeDate,
                codeCode);
        OptFlowNoInfo noInfo = optFlowNoInfoDao.getObjectById(noId);
        long nextCode = 1l;
        if (noInfo == null) {
            noInfo = new OptFlowNoInfo(noId, 1l, DatetimeOpt.currentUtilDate());
        } else {
            nextCode = noInfo.getCurNo() + 1;
            noInfo.setCurNo(nextCode);
            noInfo.setLastCodeDate(DatetimeOpt.currentUtilDate());
        }
        optFlowNoInfoDao.saveObject(noInfo);
        return nextCode;
    }

    @Override
    public long newNextLshBaseDay(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return newNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToDay(codeBaseDate));
    }

    @Override
    public long newNextLshBaseMonth(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return newNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToMonth(codeBaseDate));
    }

    @Override
    public long newNextLshBaseYear(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return newNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToYear(codeBaseDate));
    }

    @Override
    public long newNextLsh(String codeCode) {
        return newNextLsh(DefaultOwnerCode, codeCode, DefaultCodeDate);
    }

    @Override
    public long newNextLsh(String ownerCode, String codeCode) {
        return newNextLsh(ownerCode, codeCode, DefaultCodeDate);
    }

    @Override
    public long viewNextLsh(String ownerCode, String codeCode, Date codeBaseDate) {
        Date codeDate = codeBaseDate; // DatetimeOpt.convertSqlDate(codeBaseDate);
        OptFlowNoInfoId noId = new OptFlowNoInfoId(ownerCode, codeDate,
                codeCode);
        OptFlowNoInfo noInfo = optFlowNoInfoDao.getObjectById(noId);
        long nextCode = 1l;
        if (noInfo != null)
            nextCode = noInfo.getCurNo() + 1;
        return nextCode;
    }

    @Override
    public long viewNextLshBaseDay(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return viewNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToDay(codeBaseDate));
    }

    @Override
    public long viewNextLshBaseMonth(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return viewNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToMonth(codeBaseDate));
    }

    @Override
    public long viewNextLshBaseYear(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return viewNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToYear(codeBaseDate));
    }

    @Override
    public long viewNextLsh(String codeCode) {
        return viewNextLsh(DefaultOwnerCode, codeCode, DefaultCodeDate);
    }

    @Override
    public long viewNextLsh(String ownerCode, String codeCode) {
        return viewNextLsh(ownerCode, codeCode, DefaultCodeDate);
    }

    @Override
    public synchronized void recordNextLsh(String ownerCode, String codeCode,
            Date codeBaseDate, long currCode) {
        Date codeDate = codeBaseDate;// DatetimeOpt.convertSqlDate(codeBaseDate);
        OptFlowNoInfoId noId = new OptFlowNoInfoId(ownerCode, codeDate,
                codeCode);
        OptFlowNoInfo noInfo = optFlowNoInfoDao.getObjectById(noId);
        if (noInfo == null) {
            noInfo = new OptFlowNoInfo(noId, currCode,
                    DatetimeOpt.currentUtilDate());
            optFlowNoInfoDao.saveObject(noInfo);
        } else {
            if (noInfo.getCurNo() < currCode) {
                noInfo.setCurNo(currCode);
                noInfo.setLastCodeDate(DatetimeOpt.currentUtilDate());
                optFlowNoInfoDao.saveObject(noInfo);
            }
        }
    }

    @Override
    public void recordNextLshBaseDay(String ownerCode, String codeCode,
            Date codeBaseDate, long currCode) {
        recordNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToDay(codeBaseDate), currCode);
    }

    @Override
    public void recordNextLshBaseMonth(String ownerCode, String codeCode,
            Date codeBaseDate, long currCode) {
        recordNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToMonth(codeBaseDate), currCode);
    }

    @Override
    public void recordNextLshBaseYear(String ownerCode, String codeCode,
            Date codeBaseDate, long currCode) {
        recordNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToYear(codeBaseDate), currCode);
    }

    @Override
    public void recordNextLsh(String codeCode, long currCode) {
        recordNextLsh(DefaultOwnerCode, codeCode, DefaultCodeDate, currCode);
    }

    @Override
    public void recordNextLsh(String ownerCode, String codeCode, long currCode) {
        recordNextLsh(ownerCode, codeCode, DefaultCodeDate, currCode);
    }

    @Override
    public synchronized long assignNextLsh(String ownerCode, String codeCode,
            Date codeBaseDate) {
        long minPoolNo = optFlowNoPoolDao.fetchFirstLsh(ownerCode, codeCode,
                codeBaseDate);
        if (minPoolNo > 0) {
            OptFlowNoPoolId obj = new OptFlowNoPoolId();
            obj.setOwnerCode(ownerCode);
            obj.setCodeDate(codeBaseDate);
            obj.setCodeCode(codeCode);
            obj.setCurNo(minPoolNo);
            optFlowNoPoolDao.deleteObjectById(obj);
            return minPoolNo;
        } else
            return newNextLsh(ownerCode, codeCode, codeBaseDate);
    }

    @Override
    public long assignNextLshBaseDay(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return assignNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToDay(codeBaseDate));
    }

    @Override
    public long assignNextLshBaseMonth(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return assignNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToMonth(codeBaseDate));
    }

    @Override
    public long assignNextLshBaseYear(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return assignNextLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToYear(codeBaseDate));
    }

    @Override
    public long assignNextLsh(String ownerCode, String codeCode) {
        return assignNextLsh(ownerCode, codeCode, DefaultCodeDate);
    }

    @Override
    public long assignNextLsh(String codeCode) {
        return assignNextLsh(DefaultOwnerCode, codeCode, DefaultCodeDate);
    }

    @Override
    public void releaseLsh(String ownerCode, String codeCode,
            Date codeBaseDate, long currCode) {
        OptFlowNoPool obj = new OptFlowNoPool();
        obj.setOwnerCode(ownerCode);
        obj.setCodeDate(codeBaseDate);
        obj.setCodeCode(codeCode);
        obj.setCurNo(currCode);
        obj.setCreateDate(DatetimeOpt.currentUtilDate());
        optFlowNoPoolDao.saveObject(obj);
    }

    @Override
    public void releaseLshBaseDay(String ownerCode, String codeCode,
            Date codeBaseDate, long currCode) {
        releaseLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToDay(codeBaseDate), currCode);
    }

    @Override
    public void releaseLshBaseMonth(String ownerCode, String codeCode,
            Date codeBaseDate, long currCode) {
        releaseLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToMonth(codeBaseDate), currCode);
    }

    @Override
    public void releaseLshBaseYear(String ownerCode, String codeCode,
            Date codeBaseDate, long currCode) {
        releaseLsh(ownerCode, codeCode,
                DatetimeOpt.truncateToYear(codeBaseDate), currCode);
    }

    @Override
    public void releaseLsh(String ownerCode, String codeCode, long currCode) {
        releaseLsh(ownerCode, codeCode, DefaultCodeDate, currCode);

    }

    @Override
    public void releaseLsh(String codeCode, long currCode) {
        releaseLsh(DefaultOwnerCode, codeCode, DefaultCodeDate, currCode);
    }

}
