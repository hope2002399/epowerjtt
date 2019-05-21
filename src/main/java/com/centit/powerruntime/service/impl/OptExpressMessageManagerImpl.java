package com.centit.powerruntime.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.EmsDao;
import com.centit.powerruntime.dao.OptBaseInfoDao;
import com.centit.powerruntime.dao.OptDobasicMessageDao;
import com.centit.powerruntime.dao.OptExpressMessageDao;
import com.centit.powerruntime.po.Ems;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptDobasicMessage;
import com.centit.powerruntime.po.OptExpressMessage;
import com.centit.powerruntime.service.OptExpressMessageManager;
import com.centit.powerruntime.util.EmsWebserviceUtil;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.util.SysConstant;

public class OptExpressMessageManagerImpl extends
        BaseEntityManagerImpl<OptExpressMessage> implements
        OptExpressMessageManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(OptExpressMessageManager.class);

    private OptExpressMessageDao optExpressMessageDao;
    private OptDobasicMessageDao optDobasicMessageDao;
    private EmsDao emsDao;
    private OptBaseInfoDao optBaseInfoDao;

    public void setOptExpressMessageDao(OptExpressMessageDao baseDao) {
        this.optExpressMessageDao = baseDao;
        setBaseDao(this.optExpressMessageDao);
    }

    public void setOptDobasicMessageDao(
            OptDobasicMessageDao optDobasicMessageDao) {
        this.optDobasicMessageDao = optDobasicMessageDao;
    }

    public void setEmsDao(EmsDao emsDao) {
        this.emsDao = emsDao;
    }

    public void setOptBaseInfoDao(OptBaseInfoDao optBaseInfoDao) {
        this.optBaseInfoDao = optBaseInfoDao;
    }

    @Override
    public String getExpressMessageId() {
        // TODO Auto-generated method stub
        return optExpressMessageDao.getExpressMessageId();
    }

    @SuppressWarnings("unchecked")
    @Override
    public OptExpressMessage getExpressMessageInfoBydjId(String djId) {
        List<OptExpressMessage> optExpressMessages = optExpressMessageDao
                .findObjectsByHql(" from OptExpressMessage where djid='" + djId
                        + "'");
        if (optExpressMessages.size() > 0) {
            return (OptExpressMessage) optExpressMessages.get(0);
        }
        return null;
    }

    /**
     * 调用政务EMS接口发送信息
     * 
     * @throws IOException
     * @throws JDOMException
     * @throws UnsupportedEncodingException
     */
    @Override
    public void sendExpreeMessage(String expressid) {
        String updatesql = " update opt_express_message set ";
        OptExpressMessage optExpressMessage = this.getObjectById(expressid);
        String instr = " <?xml version='1.0' encoding='UTF-8'?><RequestMessage><PostInfo><EMS_ORD_NO>"
                + optExpressMessage.getEmsordno()
                + "</EMS_ORD_NO><MAIL_NUM>"
                + optExpressMessage.getMailnum()
                + "</MAIL_NUM><GOV_TB_NAME>"
                + optExpressMessage.getGovtbname()
                + "</GOV_TB_NAME>"
                + "<POST_TYPE>"
                + optExpressMessage.getPosttype()
                + "</POST_TYPE>"
                + "<NET_TYPE>"
                + optExpressMessage.getNettype()
                + "</NET_TYPE>"
                + "<BUSS_TYPE>"
                + optExpressMessage.getBusstype()
                + "</BUSS_TYPE>"
                + "<SEND_NAME>"
                + optExpressMessage.getSendname()
                + "</SEND_NAME>"
                + "<SEND_PROV>"
                + optExpressMessage.getSendprov()
                + "</SEND_PROV>"
                + "<SEND_CITY>"
                + optExpressMessage.getSendcity()
                + "</SEND_CITY>"
                + "<SEND_COUNTRY>"
                + optExpressMessage.getSendCountry()
                + "</SEND_COUNTRY>"
                + "<SEND_STRECT>"
                + optExpressMessage.getSendstrect()
                + "</SEND_STRECT><SEND_PHONE>"
                + optExpressMessage.getSendphone() + "</SEND_PHONE><SEND_CALL>";
        if (StringUtils.isNotBlank(optExpressMessage.getSendcall())) {
            instr = instr + optExpressMessage.getSendcall();
        }
        instr = instr + "</SEND_CALL><RCV_NAME>"
                + optExpressMessage.getRcvname() + "</RCV_NAME><RCV_PROV>"
                + optExpressMessage.getRcvprov() + "</RCV_PROV><RCV_CITY>"
                + optExpressMessage.getRcvcity() + "</RCV_CITY>"
                + "<RCV_COUNTRY>" + optExpressMessage.getRcvcountry()
                + "</RCV_COUNTRY><RCV_STRECT>"
                + optExpressMessage.getRcvstrect() + "</RCV_STRECT>"
                + "<RCV_PHONE>" + optExpressMessage.getRcvphone()
                + "</RCV_PHONE><RCV_CALL>";
        if (StringUtils.isNotBlank(optExpressMessage.getRcvcall())) {
            instr = instr + optExpressMessage.getRcvcall();
        }
        instr = instr + "</RCV_CALL><RCV_POSTCODE>"
                + optExpressMessage.getRcvpostcode() + "</RCV_POSTCODE>"
                + "<ITEM>" + optExpressMessage.getItem() + "</ITEM>"
                + "<CHK_CODE>" + optExpressMessage.getChkcode()
                + "</CHK_CODE><ISSEND>";
        if (StringUtils.isBlank(optExpressMessage.getDjid())) {
            if ("T".equals(optExpressMessage.getIssend())) {
                instr = instr + "2";
            } else {
                instr = instr + "1";
            }
        } else {
            instr = instr + "2";
            updatesql = updatesql + " issend='T',";
        }
        instr = instr
                + "</ISSEND><ORGNAME>江苏省交通运输厅</ORGNAME><SENDTIME>"
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(optExpressMessage.getExpresstime())
                + "</SENDTIME><ZWFWZX_CODE>3200JT</ZWFWZX_CODE><ORGNAME_ID>014000810</ORGNAME_ID></PostInfo><ApplyInfos>";
        if (StringUtils.isNotBlank(optExpressMessage.getDjid())) {
            instr += "<ApplyInfo><INTERNAL_NO>" + optExpressMessage.getDjid()
                    + "</INTERNAL_NO></ApplyInfo>";
        } else {
            List<OptDobasicMessage> optDobasics = optDobasicMessageDao
                    .listObjects(" from OptDobasicMessage where expressid='"
                            + expressid + "'");
            for (OptDobasicMessage optDobasicMessage : optDobasics) {
                instr += "<ApplyInfo><INTERNAL_NO>"
                        + optDobasicMessage.getInternalno()
                        + "</INTERNAL_NO><ZWFWZX_CODE>"
                        + optDobasicMessage.getZwfwzxCode()
                        + "</ZWFWZX_CODE></ApplyInfo>";
            }
        }
        instr += "</ApplyInfos></RequestMessage>";
        String xmlstr = EmsWebserviceUtil.cityToGovMail(instr);
        String orgcode = "";
        try {
            OptBaseInfo optBaseInfo = optBaseInfoDao
                    .getObjectById(optExpressMessage.getDjid());
            FUnitinfo fUnitinfo = CodeRepositoryUtil
                    .getUnitInfoByCode(optBaseInfo.getOrgcode());
            orgcode = fUnitinfo.getDepno();
        } catch (Exception e) {
            orgcode = "JS00000000";
        }
        String resultJson = "";
        try {
            resultJson = analysisResult(xmlstr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
        String state = SysConstant.getValueByKey(resultJson, "rtncode", ",");
        Ems ems = new Ems(optExpressMessage.getEmsordno(), orgcode,
                optExpressMessage.getDjid(), optExpressMessage.getRcvname(),
                optExpressMessage.getRcvstrect(),
                optExpressMessage.getRcvphone(), instr);
        ems.setEmsresultcode(state);
        if (!"0".equals(state)) {
            ems.setEmsresultmsg(SysConstant.getValueByKey(resultJson, "rtnmsg",
                    ","));
        }
        emsDao.saveNewObject(ems); // 将发送内容保存到m_ems表中，以便外网查询ems信息
        optExpressMessage.setState(state);
        updatesql = updatesql + " state='" + state + "'";
        optExpressMessageDao.doExecuteSql(updatesql + " where expressid='"
                + optExpressMessage.getExpressid() + "'");
    }

    // 返回值XML内同用JSON展示
    private String analysisResult(String xmlStr)
            throws UnsupportedEncodingException, JDOMException, IOException {
        String resultjson = "";
        SAXBuilder builder = new SAXBuilder();
        Document parse = builder.build(new ByteArrayInputStream(xmlStr
                .getBytes("UTF-8")));
        Element root = parse.getRootElement();// 获取xml文件跟节点
        String rtn_msg = (root.getChildren("RtnMsg").get(0))
                .getChildText("Rtn_Msg");
        String rtn_code = (root.getChildren("RtnMsg").get(0))
                .getChildText("Rtn_Code");
        resultjson = "rtncode:" + rtn_code + ",rtnmsg:" + rtn_msg;
        return resultjson;
    }
}
