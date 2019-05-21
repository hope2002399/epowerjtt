package com.centit.complaint.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.complaint.dao.ComplaintsresultDao;
import com.centit.complaint.po.Complaint;
import com.centit.complaint.po.ComplaintsResult;
import com.centit.complaint.service.ComplaintsresultManager;
import com.centit.core.service.BaseEntityManagerImpl;

public class ComplaintsresultManagerImpl extends
        BaseEntityManagerImpl<ComplaintsResult> implements
        ComplaintsresultManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(ComplaintsresultManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private ComplaintsresultDao complaintsresultDao;

    public void setComplaintsresultDao(ComplaintsresultDao baseDao) {
        this.complaintsresultDao = baseDao;
        setBaseDao(this.complaintsresultDao);
    }

    public String getNextComplaintNo(String depno) {
        String inistr = "0000000000";
        int maxno = this.complaintsresultDao.getNextComplantNo(depno);
        String no = String.valueOf(maxno + 1);
        String retstr = depno + inistr.substring(0, 10 - no.length()) + no;
        return retstr;
    }

    @Override
    public ComplaintsResult getObjectByComplaintsId(String complaintId) {
        return complaintsresultDao.getObjectByComplaintsId(complaintId);
    }

    public String getDetailByid(String complaintid) {
        
        String shql = " from Complaint where complaintid='" + complaintid + "'";
        Complaint complaint = (Complaint) complaintsresultDao.findObjectsByHql(
                shql).get(0);
        return complaint.getComplaintsType();
    }
}
