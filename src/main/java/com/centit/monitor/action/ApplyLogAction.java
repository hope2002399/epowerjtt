package com.centit.monitor.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.ApplyLog;
import com.centit.monitor.po.FormInfo;
import com.centit.monitor.service.ApplyLogManager;
import com.centit.support.utils.StringBaseOpt;

public class ApplyLogAction extends BaseEntityExtremeAction<ApplyLog> {
    private static final Log log = LogFactory.getLog(ApplyLogAction.class);
    private static final long serialVersionUID = 1L;
    private ApplyLogManager applyLogManager;

    public void setApplyLogManager(ApplyLogManager basemgr) {
        applyLogManager = basemgr;
        this.setBaseEntityManager(applyLogManager);
    }

    public String delete() {
        super.delete();

        return "delete";
    }

    public String view() {
        try {
            String internalNo = object.getInternalNo();
            String itemId = object.getItemId();
            Long chang_no = object.getChangNo();
            ApplyLog applyLog = applyLogManager.getApplyLog(internalNo, itemId,
                    chang_no);
            if (object == null) {

                return LIST;
            }
            // if (o != null)
            // applyManager.copyObject(object, o);
            request.setAttribute("applyLog", applyLog);

            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    public String viewForm() {
        try {
            String internalNo = object.getInternalNo();
            String itemId = object.getItemId();
            Long chang_no = object.getChangNo();
            ApplyLog applyLog = applyLogManager.getApplyLog(internalNo, itemId,
                    chang_no);
            String form = applyLog.getForm();
            if (object == null) {
                return LIST;
            }
            @SuppressWarnings("rawtypes")
            List formList = new ArrayList();
            if (!StringBaseOpt.isNvl(form)) {
                formList = this.getFormList(form);
            }
            request.setAttribute("formList", formList);
            return "formView";
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List getFormList(String form) {
        @SuppressWarnings("unused")
        boolean flag = false;
        List insertList = new ArrayList();
        Document doc = null;
        if (form == null || form.equals(""))
            return insertList;
        try {
            doc = DocumentHelper.parseText(form); // 为Docunment对象doc加载CLOB数据
            // doc.setXMLEncoding("GBK");
            Element root = doc.getRootElement(); // 获得XML根节点
            Iterator iter = root.elementIterator("DATA");// 获取根节点的子节点STAND_SEQ放入迭代器中
            while (iter.hasNext()) { // 遍历STAND_SEQ
                Element infoEle = (Element) iter.next(); // 在迭代器中获取当前STAND_SEQ
                FormInfo info = new FormInfo();
                info.setKey(infoEle.elementTextTrim("KEY"));
                info.setName(infoEle.elementTextTrim("NAME"));
                info.setValue(infoEle.elementTextTrim("VALUE"));
                insertList.add(info);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return insertList;
    }

}
