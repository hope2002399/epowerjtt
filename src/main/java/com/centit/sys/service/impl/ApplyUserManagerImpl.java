package com.centit.sys.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.sys.dao.ApplyUserDao;
import com.centit.sys.po.ApplyUser;
import com.centit.sys.po.ApplyUserStuffInfo;
import com.centit.sys.service.ApplyUserManager;

public class ApplyUserManagerImpl extends BaseEntityManagerImpl<ApplyUser>
        implements ApplyUserManager {
    private static final long serialVersionUID = 1L;

    private ApplyUserDao applyUserDao;

    public void setApplyUserDao(ApplyUserDao applyUserDao) {
        setBaseDao(applyUserDao);
        this.applyUserDao = applyUserDao;
    }

    @Override
    public ApplyUserStuffInfo getApplyUserStuffInfoByUserID(String UserID) {
        
        return (ApplyUserStuffInfo) this.applyUserDao.findObjectsByHql(
                "From ApplyUserStuffInfo where userID=" + UserID).get(0);
    }

}
