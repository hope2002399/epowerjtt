package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.dao.OptApplyNetDao;
import com.centit.powerruntime.dao.OptBaseInfoNetDao;
import com.centit.powerruntime.dao.OptStuffInfoNetDao;
import com.centit.powerruntime.po.OptApplyInfoNet;
import com.centit.powerruntime.po.OptApplyReturn;
import com.centit.powerruntime.po.OptBaseInfoNet;
import com.centit.powerruntime.po.OptStuffInfoNet;
import com.centit.powerruntime.po.VOptApplyInfoNet;
import com.centit.powerruntime.service.OptApplyNetManager;
import com.centit.support.utils.DatetimeOpt;

public class OptApplyNetManagerImpl extends
        BaseEntityManagerImpl<OptApplyInfoNet> implements OptApplyNetManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(OptApplyNetManagerImpl.class);

    private OptApplyNetDao optApplyNetDao;
    private OptBaseInfoNetDao optBaseInfoNetDao;
    private OptStuffInfoNetDao optStuffInfoNetDao;

    public void setOptStuffInfoNetDao(OptStuffInfoNetDao optStuffInfoNetDao) {
        this.optStuffInfoNetDao = optStuffInfoNetDao;
    }

    public void setOptBaseInfoNetDao(OptBaseInfoNetDao optBaseInfoNetDao) {
        this.optBaseInfoNetDao = optBaseInfoNetDao;
    }

    /**
     * 查询保存但未提交的许可业务数据
     */
    public List<VOptApplyInfoNet> listOptApplyInfoNet(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return optApplyNetDao.listOptApplyInfoNet(filterMap, pageDesc);
    }

    /**
     * 获取未发送通知消息的人员
     * 
     * @return
     */
    public List<Object[]> getSendMessageInfo() {
        return optApplyNetDao.getSendMessageInfo();
    }

    /**
     * 新增opt_apply_return表
     * 
     * @param appret
     */
    public void insertOptApplyReturn(OptApplyReturn appret) {
        optApplyNetDao.insertOptApplyReturn(appret);
    }

    @Override
    public JSONObject getJSONDocumentNames(String net_id) {

        OptApplyInfoNet info = optApplyNetDao.getObjectById(net_id);

        JSONObject jsonObj = new JSONObject();
        if (info != null) {
            // 获取业务数据
            OptBaseInfoNet optBaseInfo = optBaseInfoNetDao
                    .getObjectById(net_id);
            // 获取许可登记时候的上传附件文件
            List<OptStuffInfoNet> optStuffInfos = optStuffInfoNetDao
                    .getStuffInfoNetListByNodeinstid(net_id, "0");
            String stuff_names = "";
            if (optStuffInfos.size() > 0) {
                for (OptStuffInfoNet osi : optStuffInfos) {
                    stuff_names += osi.getFilename() + "\n";
                }
            }

            // 组装公共部分
            String transaffairname = "";
            String caseNo = "";
            if (optBaseInfo != null) {
                transaffairname = optBaseInfo.getTransaffairname();
                caseNo = optBaseInfo.getCaseNo();
            } else {
                optBaseInfo = new OptBaseInfoNet();
            }

            jsonObj.put("transaffairname", transaffairname);// 办件名称
            jsonObj.put("proposer_paper_code", info.getProposerPaperCode());// 申请者证件号码
            jsonObj.put("proposerName", info.getProposerName());// 申请者
            jsonObj.put("proposerAddr", info.getProposerAddr());// 申请者地址
            jsonObj.put("legal_person", info.getLegal_person());// 法定代表人/负责人
            jsonObj.put(
                    "proposerPhone",
                    StringUtils.isBlank(info.getProposerPhone()) ? info
                            .getProposerMobile() : info.getProposerPhone());// 电话
            jsonObj.put("proposerZipcode", info.getProposerZipcode());// 邮政编码

            jsonObj.put("agentName", info.getAgentName());// 代理人姓名
            jsonObj.put(
                    "agentPhone",
                    StringUtils.isBlank(info.getAgentPhone()) ? info
                            .getAgentMobile() : info.getAgentPhone());// 代理人电话
            jsonObj.put("agentZipcode", info.getAgentZipcode());// 代理人邮政编码

            jsonObj.put("stuff_names", stuff_names);// 附送资料
            jsonObj.put("applyReason", info.getApplyReason());// 申请理由
            jsonObj.put("applyMemo", info.getApplyMemo());// 备注

            // 组装文书使用到年月日的字段
            String currDate = DatetimeOpt.convertDateToString(
                    info.getApplyDate(), "");
            jsonObj.put("applyDate", currDate);// 申请日期
            jsonObj.put("applyYear", currDate.substring(0, 4));// 申请日期_年
            jsonObj.put("applyMonth", currDate.substring(5, 7));// 申请日期_月
            jsonObj.put("applyDay", currDate.substring(8, 10));// 申请日期_日
            jsonObj.put(
                    "today",
                    DatetimeOpt.convertDateToString(
                            DatetimeOpt.currentUtilDate(), "yyyy年MM月dd日"));
            // 组装 关于XXX的许可申请：航道名称+办件名称
            jsonObj.put("cname_tname", transaffairname);
            // ItemClassName
            jsonObj.put("ItemClassName", optBaseInfo.getPowername());
            // 案号
            jsonObj.put("caseNo", net_id);

        } else {
            jsonObj.put("", "");
        }
        return jsonObj;
    }

    public void setOptApplyNetDao(OptApplyNetDao optApplyNetDao) {
        this.optApplyNetDao = optApplyNetDao;
        setBaseDao(this.optApplyNetDao);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> listOptApplyInfoNetUnprocessed(
            Map<String, Object> filterMap) {
        // TODO Auto-generated method stub
        String shql = "from v_opt_apply_info_net where 1=1 and bizstate='F' ";
        String queryUnderUnit = "";
        // 得到登陆人所在部门的orgcode
        String orgcode1 = (String) filterMap.get("orgcode1");
        if (null != orgcode1) {
            // 限制查找办件为登陆人所在部门或者其下属机构的办件
            queryUnderUnit += " and orgcode in ( select unitcode from f_unitinfo connect by prior unitcode = parentunit start with unitcode= "
                    + orgcode1 + " )  ";
            // 传值完成，清除多余查找条件
            filterMap.remove("orgcode1");
        }
        if ("true".equals(filterMap.get("queryUnderUnit"))) {
            queryUnderUnit += " and orgcode in ( select unitcode from f_unitinfo connect by prior unitcode = parentunit start with unitcode= "
                    + filterMap.get("orgcode") + " ) ";

            // 包含下属机构后，应去除查询所选的本级部门查询条件，如果不去builderHqlAndParams(shql,
            // filterMap)方法里会加上 and orgcode= 的条件，导致实际查找到的数据不包含下属机构
            filterMap.put("orgcode", null);
        }
        return optApplyNetDao.findObjectsBySql(" select * " + shql
                + queryUnderUnit);
    }

}
