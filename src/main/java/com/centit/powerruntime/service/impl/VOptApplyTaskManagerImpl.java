package com.centit.powerruntime.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.VOptApplyTaskDao;
import com.centit.powerruntime.po.VOptApplyTaskList;
import com.centit.powerruntime.service.VOptApplyTaskManager;

public class VOptApplyTaskManagerImpl extends
        BaseEntityManagerImpl<VOptApplyTaskList> implements
        VOptApplyTaskManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VOptApplyTaskManagerImpl.class);
    private VOptApplyTaskDao vOptApplyTaskDao;

    public void setVOptApplyTaskDao(VOptApplyTaskDao vOptApplyTaskDao) {
        this.vOptApplyTaskDao = vOptApplyTaskDao;
        setBaseDao(vOptApplyTaskDao);
    }

    public VOptApplyTaskDao getvOptApplyTaskDao() {
        return vOptApplyTaskDao;
    }

    @Override
    public VOptApplyTaskList getObjectBydjId(String djId) {
        List<VOptApplyTaskList> optApplyInfos = vOptApplyTaskDao
                .listObjects(" from VOptApplyTaskList where djId='" + djId
                        + "'");
        if (optApplyInfos.size() > 0) {
            return (VOptApplyTaskList) optApplyInfos.get(0);
        }
        return null;
    }

    @Override
    public List<VOptApplyTaskList> getEmsOptApplyList(
            Map<String, Object> filterMap) {
        List<VOptApplyTaskList> vOptApplyTaskLists = new ArrayList<VOptApplyTaskList>();
        String sql = "select b.dj_id,a.proposer_name,b.transaffairname,b.transaffairno from opt_base_info b left join opt_apply_info a on b.dj_id=a.dj_id where b.biztype in ('C','T')";
        if (filterMap.containsKey("unitcode")) {
            sql = sql + " and orgcode ="
                    + String.valueOf(filterMap.get("unitcode"));
        }
        sql = sql + " order by a.dj_id ";
        for (Object[] objects : (List<Object[]>) vOptApplyTaskDao
                .findObjectsBySql(sql)) {
            VOptApplyTaskList vOptApplyTaskList = new VOptApplyTaskList();
            vOptApplyTaskList.setDjId(String.valueOf(objects[0]));
            vOptApplyTaskList.setProposerName(String.valueOf(objects[1]));
            vOptApplyTaskList.setTransaffairname(String.valueOf(objects[2]));
            vOptApplyTaskList.setTransAffairNo(String.valueOf(objects[3]));
            vOptApplyTaskLists.add(vOptApplyTaskList);
        }
        return vOptApplyTaskLists;
    }
}
