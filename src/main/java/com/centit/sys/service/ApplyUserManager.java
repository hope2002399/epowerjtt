package com.centit.sys.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.sys.po.ApplyUser;
import com.centit.sys.po.ApplyUserStuffInfo;

public interface ApplyUserManager extends BaseEntityManager<ApplyUser> {

    public ApplyUserStuffInfo getApplyUserStuffInfoByUserID(String UserID);

}
