package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.dao.OptApplyDao;
import com.centit.powerruntime.dao.OptBaseInfoDao;
import com.centit.powerruntime.dao.OptProcInfoDao;
import com.centit.powerruntime.dao.OptStuffInfoDao;
import com.centit.powerruntime.po.OptApplyInfo;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.po.VOptApplyInfo;
import com.centit.powerruntime.service.OptApplyManager;
import com.centit.support.utils.DatetimeOpt;

public class OptApplyManagerImpl extends BaseEntityManagerImpl<OptApplyInfo>
        implements OptApplyManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptApplyManagerImpl.class);

    private OptApplyDao optApplyDao;
    private OptBaseInfoDao optBaseInfoDao;
    private OptStuffInfoDao optStuffInfoDao;
    private OptProcInfoDao optProcInfoDao;

    public void setOptStuffInfoDao(OptStuffInfoDao optStuffInfoDao) {
        this.optStuffInfoDao = optStuffInfoDao;
    }

    public void setOptBaseInfoDao(OptBaseInfoDao optBaseInfoDao) {
        this.optBaseInfoDao = optBaseInfoDao;
    }

    public void setOptProcInfoDao(OptProcInfoDao optProcInfoDao) {
        this.optProcInfoDao = optProcInfoDao;
    }

    public String generateNextDjId() {
        return optApplyDao.genNextDjID();
    }

    /**
     * 查询保存但未提交的许可业务数据
     */
    public List<VOptApplyInfo> listOptApplyInfo(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return optApplyDao.listOptApplyInfo(filterMap, pageDesc);
    }

    @Override
    public String getJSONDocumentNames(String dj_id, String username) {

        OptApplyInfo info = optApplyDao.getObjectById(dj_id);

        JSONObject jsonObj = new JSONObject();
        if (info != null) {
            // 获取业务数据
            OptBaseInfo optBaseInfo = optBaseInfoDao.getObjectById(dj_id);
            // 获取许可登记时候的上传附件文件
            List<OptStuffInfo> optStuffInfos = optStuffInfoDao
                    .getStuffInfoListByNodeinstid(dj_id, "0");
            String stuff_names = "";
            if (optStuffInfos.size() > 0) {
                for (OptStuffInfo osi : optStuffInfos) {
                    stuff_names += osi.getFilename() + "\n";
                }
            }

            // 组装公共部分
            String transaffairname = "";
            String caseNo = "";
            if (optBaseInfo != null) {
                transaffairname = optBaseInfo.getTransaffairname();
                caseNo = optBaseInfo.getCaseNo() != null ? optBaseInfo
                        .getCaseNo() : optBaseInfo.getTransAffairNo();
            } else {
                optBaseInfo = new OptBaseInfo();
            }

            if ("0".equals(info.getProposerType())) {
                jsonObj.put("applyUsername", info.getProposerName());
                jsonObj.put("proposer_paper_code", info.getProposerPaperCode());// 申请者证件号码
            } else {
                jsonObj.put("applyUnitcode", info.getProposerUnitcode());
                jsonObj.put("legal_person", info.getLegal_person());// 法定代表人/负责人
                jsonObj.put("applyUnitName", info.getProposerName());
            }
            jsonObj.put("transaffairname", transaffairname);// 办件名称
            jsonObj.put("proposerName", info.getProposerName());// 申请者
            jsonObj.put("proposerName1", username);// 办理人
            jsonObj.put("proposerAddr", info.getProposerAddr());// 申请者地址

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
            jsonObj.put("applyDate1", currDate);// 申请日期
            jsonObj.put("today",
                    currDate.substring(0, 4) + "年" + currDate.substring(5, 7)
                            + "月" + currDate.substring(8, 10) + "日");// 申请日期_年
            // 组装 关于XXX的许可申请：航道名称+办件名称
            jsonObj.put("cname_tname", transaffairname);
            // 案号
            jsonObj.put("caseNo", caseNo);
            jsonObj.put("transAffairQueryKey",
                    optBaseInfo.getTransAffairQueryKey());
        } else {
            jsonObj.put("", "");
        }
        return jsonObj.toString();
    }

    public void setOptApplyDao(OptApplyDao optApplyDao) {
        this.optApplyDao = optApplyDao;
        setBaseDao(this.optApplyDao);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OptProcInfo> getOptProcInfos(String djId) {
        return (List<OptProcInfo>) optProcInfoDao
                .findObjectsByHql(" from OptProcInfo where djId='" + djId
                        + "' order by transdate");
    }

}
