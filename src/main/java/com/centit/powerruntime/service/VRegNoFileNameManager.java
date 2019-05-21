package com.centit.powerruntime.service;


import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.VRegNoFileName;

public interface VRegNoFileNameManager extends
        BaseEntityManager<VRegNoFileName> {

    List<VRegNoFileName> getinfosByOutItemId(String outItemId);

}
