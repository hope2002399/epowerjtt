package com.centit.monitor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.ApplyDocDao;
import com.centit.monitor.dao.ApplyProcessDao;
import com.centit.monitor.po.ApplyProcess;
import com.centit.monitor.service.ApplyProcessManager;
import com.centit.support.utils.StringBaseOpt;

public class ApplyProcessManagerImpl extends
        BaseEntityManagerImpl<ApplyProcess> implements ApplyProcessManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyProcessManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private ApplyProcessDao applyProcessDao;
    private ApplyDocDao applyDocDao;

    public void setApplyDocDao(ApplyDocDao applyDocDao) {
        this.applyDocDao = applyDocDao;
    }

    public void setApplyProcessDao(ApplyProcessDao baseDao) {
        this.applyProcessDao = baseDao;
        setBaseDao(this.applyProcessDao);
    }

    public List<ApplyProcess> listObjects(String internalNo, String itemId) {
        List<ApplyProcess> list = applyProcessDao.listObjects(internalNo,
                itemId);
        for (int i = 0; i < list.size(); i++) {
            ApplyProcess process = list.get(i);
            if (applyDocDao.isDoc(internalNo, itemId, process.getNoOrd() + "",
                    "2")) {
                process.setIsDoc("1");
            } else {
                process.setIsDoc("0");
            }
            list.remove(i);
            list.add(i, process);
        }
        return list;
    }

    public List<ApplyProcess> listApplyProcessEx(String internalNo,
            String orgId, String xmlInFlowInfo) {
        
        List<ApplyProcess> list = applyProcessDao
                .listObjects(internalNo, orgId);
        if (!StringBaseOpt.isNvl(xmlInFlowInfo)) {
            Element e = GetXmlRootElement(xmlInFlowInfo.toLowerCase());
            for (int i = 0; i < list.size(); i++) {
                ApplyProcess apply = list.get(i);
                String process_id = apply.getTacheId();
                apply.setTitle(getTitle(e, apply.getTacheName()));
                apply.setStandardProTime(getAnticipate_day(e, process_id));
                apply.setStandardProType(getAnticipate_type(e, process_id));
                String riskInfo = getRiskInfo(e, process_id);
                apply.setAcceptName(getAcceptName(e, process_id));
                apply.setProcessID(getProcessId(e, process_id));
                riskInfo.split("&");
                String standardIsRisk = "";
                String standardRistResult = "";
                if (!StringBaseOpt.isNvl(riskInfo)) {
                    standardIsRisk = riskInfo.split("&")[0];
                    standardRistResult = riskInfo.split("&")[1];
                }
                if ("true".equals(standardIsRisk)) {
                    apply.setIsRisk("1");
                    if (!StringBaseOpt.isNvl(standardRistResult)
                            && !"NULL".equals(standardRistResult))
                        apply.setRiskResult(standardRistResult.equals("NULL") ? null
                                : standardRistResult);
                }

                list.remove(i);
                list.add(i, apply);
            }
        }
        return list;
    }

    @SuppressWarnings("unused")
    public Element GetXmlRootElement(String xmlString) {
        Document doc = null;
        Element root = null;
        if (StringBaseOpt.isNvl(xmlString)) {
            return null;
        }
        if (xmlString.indexOf("<flow>") != -1) {
            try {
                InputStream clobStream;
                clobStream = new ByteArrayInputStream(
                        xmlString.getBytes("gb2312"));
                doc = DocumentHelper.parseText(xmlString);
                root = doc.getRootElement(); // 取得根节点
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return root;
    }

    @SuppressWarnings("rawtypes")
    public String getTitle(Element e, String tacheName) {
        if (!StringBaseOpt.isNvl(tacheName)) {
            tacheName = tacheName.trim();
            Element root = e;
            List list = root.elements("flow_seq");
            String retstr = "";
            for (int i = 0; i < list.size(); i++) {
                Element element = (Element) list.get(i);
                String title = element.elementText("title");
                if (!StringBaseOpt.isNvl(title) && title.equals(tacheName))
                    retstr = title;
            }
            return retstr;
        } else {
            return "";
        }
    }

    @SuppressWarnings("rawtypes")
    public String getAnticipate_day(Element e, String process_id) {
        if (!StringBaseOpt.isNvl(process_id)) {
            // process_id = StringUtil.filterString(process_id).trim();
            process_id = process_id.trim();
            Element root = e;
            List list = root.elements("flow_seq");
            String retstr = "";
            for (int i = 0; i < list.size(); i++) {
                Element element = (Element) list.get(i);
                String anticipate_day = element.elementText("anticipate_day");
                if (!StringBaseOpt.isNvl(anticipate_day)) {
                    anticipate_day = String.valueOf((int) Math.rint(Double
                            .parseDouble(anticipate_day)));
                }
                String title = element.elementText("seq_id");
                if (!StringBaseOpt.isNvl(title) && process_id.equals(title))
                    retstr = anticipate_day;
            }
            return retstr;
        } else {
            return "";
        }
    }

    @SuppressWarnings("rawtypes")
    public String getRiskInfo(Element e, String process_id) {
        if (!StringBaseOpt.isNvl(process_id)) {
            process_id = process_id.trim();
            Element root = e;
            List list = root.elements("flow_seq");
            String retstr = "";
            for (int i = 0; i < list.size(); i++) {
                Element element = (Element) list.get(i);
                String title = element.elementText("seq_id");
                String is_risk = element.elementText("is_risk");
                String risk_desc = element.elementText("risk_desc");
                String risk_result = "NULL";
                if (!StringBaseOpt.isNvl(risk_desc)) {
                    String[] str = risk_desc.split("，");
                    if (str.length > 1) {
                        risk_result = str[1].substring(str[1].indexOf("：") + 1);
                    }
                }
                if (!StringBaseOpt.isNvl(title) && process_id.equals(title))
                    retstr = is_risk + "&" + risk_result;
            }
            return retstr;
        } else {
            return "";
        }
    }

    @SuppressWarnings("rawtypes")
    public String getAcceptName(Element e, String process_id) {
        if (!StringBaseOpt.isNvl(process_id)) {
            process_id = process_id.trim();
            Element root = e;
            List list = root.elements("flow_seq");
            String retstr = "";
            for (int i = 0; i < list.size(); i++) {
                Element element = (Element) list.get(i);
                String anticipate_type = element.elementText("accept_name");
                String title = element.elementText("seq_id");
                if (!StringBaseOpt.isNvl(title) && process_id.equals(title))
                    retstr = anticipate_type;
            }
            return retstr;
        } else {
            return "";
        }
    }

    @SuppressWarnings("rawtypes")
    public String getProcessId(Element e, String process_id) {
        if (!StringBaseOpt.isNvl(process_id)) {
            process_id = process_id.trim();
            Element root = e;
            List list = root.elements("flow_seq");
            String retstr = "";
            for (int i = 0; i < list.size(); i++) {
                Element element = (Element) list.get(i);
                String processid = element.elementText("seq_id");
                if (!StringBaseOpt.isNvl(processid)
                        && process_id.equals(processid))
                    retstr = processid;
            }
            return retstr;
        } else {
            return "";
        }
    }

    @SuppressWarnings("rawtypes")
    public String getAnticipate_type(Element e, String process_id) {

        if (!StringBaseOpt.isNvl(process_id)) {
            process_id = process_id.trim();
            Element root = e;
            List list = root.elements("flow_seq");
            String retstr = "";
            for (int i = 0; i < list.size(); i++) {
                Element element = (Element) list.get(i);
                String anticipate_type = element.elementText("anticipate_type");
                String title = element.elementText("seq_id");
                if (!StringBaseOpt.isNvl(title) && process_id.equals(title))
                    retstr = anticipate_type;
            }
            return retstr;
        } else {
            return "";
        }
    }
}
