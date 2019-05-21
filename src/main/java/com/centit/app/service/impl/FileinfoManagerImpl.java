package com.centit.app.service.impl;

import com.centit.app.dao.FileInfoDao;
import com.centit.app.po.FileInfo;
import com.centit.app.service.FileinfoManager;
import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.support.utils.DatetimeOpt;

public class FileinfoManagerImpl extends BaseEntityManagerImpl<FileInfo>
        implements FileinfoManager {
    private static final long serialVersionUID = 1L;
    private FileInfoDao fileInfoDao;

    public void setFileinfoDao(FileInfoDao baseDao) {
        this.fileInfoDao = baseDao;
        setBaseDao(this.fileInfoDao);
    }

    public String getNextKey() {
        String sKey = "00000000000"
                + fileInfoDao.getNextValueOfSequence("S_FILENO");
        return DatetimeOpt.convertDateToString(DatetimeOpt.currentUtilDate(),
                "yyMMdd") + sKey.substring(sKey.length() - 10);
    }

}
