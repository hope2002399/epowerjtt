package com.centit.monitor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.ApplyDocDao;
import com.centit.monitor.po.ApplyDoc;
import com.centit.monitor.po.ApplyProcess;
import com.centit.monitor.service.ApplyDocManager;
import com.centit.sys.util.InFlowInfo;
import com.centit.sys.util.JDomeGetItem;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-4
 * @version
 */
public class ApplyDocManagerImpl extends BaseEntityManagerImpl<ApplyDoc>
        implements ApplyDocManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyDocManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private ApplyDocDao applyDocDao;

    public void setApplyDocDao(ApplyDocDao baseDao) {
        this.applyDocDao = baseDao;
        setBaseDao(this.applyDocDao);
    }

    public List<ApplyDoc> listObjects(String internalNo, String itemId) {
        return applyDocDao.listObjects(internalNo, itemId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ApplyDoc> getProcessApplyDoc(String internalNo, String itemId,
            String process_no, boolean isContents) {
        
        List<ApplyDoc> doclist = new ArrayList<ApplyDoc>();
        String sql = "select * from m_applyprocess where attachment is not null and internal_no='"
                + internalNo + "' and item_id='" + itemId + "'";
        if (StringUtils.isNotBlank(process_no)) {
            sql = sql + " and no_ord=" + process_no;
        }
        sql = sql + " order by no_ord ";
        List<ApplyProcess> processeList = (List<ApplyProcess>) applyDocDao
                .findObjectsBySql(sql, ApplyProcess.class);
        for (ApplyProcess applyProcess : processeList) {
            List<InFlowInfo> listStuff = JDomeGetItem
                    .JDomeGetDocument(applyProcess.getAttachment());
            for (int i = 0; i < listStuff.size(); i++) {
                InFlowInfo inFlowInfo = (InFlowInfo) listStuff.get(i);
                ApplyDoc doc = new ApplyDoc(inFlowInfo, isContents);
                doc.setNo(applyProcess.getNo()
                        + String.format("%02d", Integer.parseInt(String
                                .valueOf(applyProcess.getNoOrd())))
                        + String.format("%02d", i + 1));// 临时个附件编号规则：process的no＋docid
                doc.setInternalNo(internalNo);
                doc.setItemId(itemId);
                doc.setProcessNo(String.valueOf(applyProcess.getNoOrd()));
                doc.setDocSort("4");
                doc.setDocType("2");
                doclist.add(doc);
            }
        }
        return doclist;
    }
}
