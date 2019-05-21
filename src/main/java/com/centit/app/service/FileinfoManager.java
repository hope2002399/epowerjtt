package com.centit.app.service;

import com.centit.app.po.FileInfo;
import com.centit.core.service.BaseEntityManager;

public interface FileinfoManager extends BaseEntityManager<FileInfo> {
    public String getNextKey();
}
