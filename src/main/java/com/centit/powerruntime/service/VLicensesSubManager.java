package com.centit.powerruntime.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.LicensesSub;
import com.centit.powerruntime.po.QlQdzxtj;
import com.centit.powerruntime.po.VLicensesSub;
import com.centit.powerruntime.po.YwFiles;

public interface VLicensesSubManager extends BaseEntityManager<VLicensesSub> 
{

    List<LicensesSub> getsl(Map<String, Object> filterMap);



    List<VLicensesSub> getVLicensesSubExport(Map<String, Object> filterMap);

}
