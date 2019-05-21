package com.centit.sys.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class JDomeGetItem {
    public String ReadXmlElement[][];

    /**
     * 根据附件xml获得附件列表
     * 
     * @param clobstring
     * @return
     */
    @SuppressWarnings({ "unused", "rawtypes" })
    public static List<InFlowInfo> JDomeGetDocument(String clobstring) {
        List<InFlowInfo> InFlowInfoList2 = new ArrayList<InFlowInfo>();

        String subXMLHead = "";
        if (StringUtils.isBlank(clobstring)) {
            return null;
        }
        if (!StringUtils.isBlank(clobstring)) {
            if (clobstring.indexOf("<?XML VERSION=\"1.0\" ENCODING=\"GBK\"?>") > -1) {
                clobstring = "<?xml version=\"1.0\" encoding=\"GBK\"?>"
                        + clobstring.substring(36);
            }
            if (clobstring.indexOf("<DOCUMENTDATA>") != -1) {
                subXMLHead = clobstring.substring(0,
                        clobstring.indexOf("<DOCUMENTDATA>"));
                if (!StringUtils.isBlank(subXMLHead)) {
                    InputStream clobStream = null;
                    try {
                        clobStream = new ByteArrayInputStream(
                                clobstring.getBytes("GBK"));
                        Document document = DocumentHelper.parseText(clobstring
                                .trim());
                        Element elements = document.getRootElement();
                        for (Iterator i = elements.elementIterator(); i
                                .hasNext();) {
                            Element element = (Element) i.next();
                            if (element.getName().equals("DOCUMENT")) {
                                InFlowInfo info = new InFlowInfo();
                                for (Iterator j = element.elementIterator(); j
                                        .hasNext();) { // ����<DOCUMENT>�µĽڵ�
                                    Element node = (Element) j.next(); // ���<DOCUMENT>Ԫ��ÿһ���ڵ�
                                    if ("DOCUMENT_ID".equals(node.getName())) {
                                        info.setDocument_id(node.getText());
                                    } else if ("DOCUMENT_NAME".equals(node
                                            .getName())) {
                                        info.setDocument_name(node.getText());
                                    } else if ("FILE_NAME".equals(node
                                            .getName())) {
                                        info.setFile_name(node.getText());
                                    } else if ("FILE_CONTENT".equals(node
                                            .getName())) {
                                        info.setFile_content(node.getText());
                                    }
                                }
                                InFlowInfoList2.add(info);
                            }
                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        return InFlowInfoList2;
    }

    /**
     * 根据附件ID获取对应的附件实体
     * 
     * @param clobstring
     * @param document_id
     * @return
     */
    @SuppressWarnings({ "unused", "rawtypes" })
    public static InFlowInfo JDomeGetDocument_File_content(String clobstring,
            String document_id) {
        ArrayList<InFlowInfo> InFlowInfoList2 = new ArrayList<InFlowInfo>();

        String subXMLHead = "";
        if (StringUtils.isBlank(clobstring)) {
            return null;
        }
        if (!StringUtils.isBlank(clobstring)) {

            if (clobstring.indexOf("<?XML VERSION=\"1.0\" ENCODING=\"GBK\"?>") > -1) {

                clobstring = "<?xml version=\"1.0\" encoding=\"GBK\"?>"
                        + clobstring.substring(36);
            }
            if (clobstring.indexOf("<DOCUMENTDATA>") != -1) {
                subXMLHead = clobstring.substring(0,
                        clobstring.indexOf("<DOCUMENTDATA>"));
                if (!StringUtils.isBlank(subXMLHead)) {
                    InputStream clobStream;
                    try {
                        clobStream = new ByteArrayInputStream(
                                clobstring.getBytes("GBK"));
                        Document document = DocumentHelper.parseText(clobstring
                                .trim());
                        Element elements = document.getRootElement();
                        for (Iterator i = elements.elementIterator(); i
                                .hasNext();) {
                            Element element = (Element) i.next();
                            boolean flage = false;
                            if (element.getName().equals("DOCUMENT")) {
                                InFlowInfo info = new InFlowInfo();
                                for (Iterator j = element.elementIterator(); j
                                        .hasNext();) { // ����<DOCUMENT>�µĽڵ�
                                    Element node = (Element) j.next(); // ���<DOCUMENT>Ԫ��ÿһ���ڵ�
                                    if ("DOCUMENT_ID".equals(node.getName())) {
                                        info.setDocument_id(node.getText());
                                        if (info.getDocument_id().equals(
                                                document_id)) {
                                            flage = true; // ����Document_id���ж��Ƿ�Ϊѡ�е��ļ�
                                        }
                                    } else if ("DOCUMENT_NAME".equals(node
                                            .getName())) {
                                        info.setDocument_name(node.getText());
                                    } else if ("FILE_NAME".equals(node
                                            .getName())) {
                                        info.setFile_name(node.getText());
                                    } else if ("FILE_CONTENT".equals(node
                                            .getName())) {
                                        info.setFile_content(node.getText());
                                    }
                                }
                                if (flage) {
                                    InFlowInfoList2.add(info);
                                }
                            }
                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        return (InFlowInfo) InFlowInfoList2.get(0);
    }

}
