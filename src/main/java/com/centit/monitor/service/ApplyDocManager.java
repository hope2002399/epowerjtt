package com.centit.monitor.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.ApplyDoc;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-4
 * @version
 */
public interface ApplyDocManager extends BaseEntityManager<ApplyDoc> {
    public List<ApplyDoc> listObjects(String internalNo, String itemId);

    public List<ApplyDoc> getProcessApplyDoc(String internalNo, String itemId,
            String process_no, boolean isContents);
}
