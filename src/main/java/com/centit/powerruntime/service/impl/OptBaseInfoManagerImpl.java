package com.centit.powerruntime.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.OptBaseInfoDao;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.service.OptBaseInfoManager;

public class OptBaseInfoManagerImpl extends BaseEntityManagerImpl<OptBaseInfo>
        implements OptBaseInfoManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptBaseInfoManager.class);

    private OptBaseInfoDao optBaseInfoDao;

    public void setOptBaseInfoDao(OptBaseInfoDao baseDao) {
        this.optBaseInfoDao = baseDao;
        setBaseDao(this.optBaseInfoDao);
    }

    @Override
    public OptBaseInfo getOptBaseByFlowId(Long flowinstid) {
        return optBaseInfoDao.getOptBaseByFlowId(flowinstid);
    }

    public void updateBizType(String djId, String rolecode) {
        optBaseInfoDao.updateBizType(djId, rolecode);
    }

    public String getOptBaseJson(String djId) {
        OptBaseInfo optBaseInfo = optBaseInfoDao.getObjectById(djId);

        JSONObject jsonObj = new JSONObject();
        if (optBaseInfo != null) {
            jsonObj.put("transAffairNo", optBaseInfo.getTransAffairNo());
            jsonObj.put("transaffairname", optBaseInfo.getTransaffairname());
            jsonObj.put("orgcode", optBaseInfo.getOrgcode());
            jsonObj.put("orgname", optBaseInfo.getOrgname());
            jsonObj.put("powerid", optBaseInfo.getPowerid());
            jsonObj.put("powername", optBaseInfo.getPowername());
            jsonObj.put("createDate", optBaseInfo.getCreatedate());
        }
        return jsonObj.toString();
    }

    @Override
    public int getNumOfsameModel(String codeModel, String year) {
        return optBaseInfoDao.getNumOfsameModel(codeModel, year);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String isSimpleTransAffairNo(String djId, String transAffairNo) {
        
        String sHql = "from  OptBaseInfo where transAffairNo='" + transAffairNo
                + "'";
        if (StringUtils.isNotBlank(djId)) {
            sHql = sHql + " and djId<>'" + djId + "'";
        }
        List<OptBaseInfo> infos = optBaseInfoDao.findObjectsByHql(sHql);
        if (infos.size() > 0) {
            return "true";
        } else {
            return "false";
        }
    }
}
