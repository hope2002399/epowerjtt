package com.centit.monitor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.PunishDocDao;
import com.centit.monitor.po.PunishDoc;
import com.centit.monitor.po.PunishProcess;
import com.centit.monitor.service.PunishDocManager;
import com.centit.sys.util.InFlowInfo;
import com.centit.sys.util.JDomeGetItem;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public class PunishDocManagerImpl extends BaseEntityManagerImpl<PunishDoc>
        implements PunishDocManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishDocManager.class);
    private PunishDocDao punishDocDao;

    public void setPunishDocDao(PunishDocDao baseDao) {
        this.punishDocDao = baseDao;
        setBaseDao(this.punishDocDao);
    }

    @Override
    public List<PunishDoc> listObjects(String internalNo, String orgId) {
        
        return punishDocDao.listObjects(internalNo, orgId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PunishDoc> getProcessPunishDoc(String colname,
            String internalNo, String orgId, String noord, boolean b) {
        
        List<PunishDoc> doclist = new ArrayList<PunishDoc>();
        String sql = "select * from m_punishprocess where " + colname
                + " is not null and internal_no='" + internalNo
                + "'  and org_id='" + orgId + "'";
        if (StringUtils.isNotBlank(noord)) {
            sql = sql + " and no_ord=" + noord;
        }
        sql = sql + " order by no_ord ";
        List<PunishProcess> processeList = (List<PunishProcess>) punishDocDao
                .findObjectsBySql(sql, PunishProcess.class);
        for (PunishProcess applyProcess : processeList) {
            String filexml = "";
            if ("attachment".equals(colname)) {
                filexml = applyProcess.getAttachment();
            } else {
                filexml = applyProcess.getEvidence();
            }
            List<InFlowInfo> listStuff = JDomeGetItem.JDomeGetDocument(filexml);
            for (int i = 0; i < listStuff.size(); i++) {
                InFlowInfo inFlowInfo = (InFlowInfo) listStuff.get(i);
                PunishDoc doc = new PunishDoc(inFlowInfo, b);
                doc.setNo(applyProcess.getNo()
                        + String.format("%02d", Integer.parseInt(String
                                .valueOf(applyProcess.getNoOrd())))
                        + String.format("%02d", i + 1));// 临时个附件编号规则：process的no＋docid
                doc.setInternalNo(internalNo);
                doc.setOrgId(orgId);
                doc.setProcessNo(String.valueOf(applyProcess.getNoOrd()));
                if ("attachment".equals(colname)) {
                    doc.setDocSort("1");
                } else if ("evidence".equals(colname)) {
                    doc.setDocType("2");
                }
                doclist.add(doc);
            }
        }
        return doclist;
    }
}
