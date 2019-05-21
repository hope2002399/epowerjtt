package com.centit.punish.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.extremecomponents.table.limit.Limit;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Pcfreeumpiredegree;
import com.centit.punish.po.Pcdef;
import com.centit.punish.po.Pctype;
import com.centit.punish.service.PcdefManager;
import com.centit.sys.security.FUserDetail;
import com.centit.workflow.sample.optmodel.BaseWFEntityAction;

/**
 * 
 * TODO Class description should be added
 * 
 * @author sj
 * @create 2012-12-7
 * @version
 */
public class PcdefAction extends BaseWFEntityAction<Pcdef> {
    private static final long serialVersionUID = 1L;
    private PcdefManager pcdefManager;

    private List<Pctype> pctypesList = new ArrayList<Pctype>();
    private List<Pcfreeumpiredegree> pcfreeumpiredegrees;
    @SuppressWarnings("rawtypes")
    private List punishobjectList = new ArrayList();// 获取处罚对象 0表示个人，1表示机构
    @SuppressWarnings("rawtypes")
    private List pcdefList = new ArrayList();

    @SuppressWarnings("rawtypes")
    public List getPunishobjectList() {
        return punishobjectList;
    }

    public void setPunishobjectList(
            @SuppressWarnings("rawtypes") List punishobjectList) {
        this.punishobjectList = punishobjectList;
    }

    @SuppressWarnings("rawtypes")
    public List getPcdefList() {
        return pcdefList;
    }

    public void setPcdefList(@SuppressWarnings("rawtypes") List pcdefList) {
        this.pcdefList = pcdefList;
    }

    public void setPcdefManager(PcdefManager pcdefManager) {
        this.pcdefManager = pcdefManager;
    }

    public List<Pctype> getPctypesList() {
        return pctypesList;
    }

    public void setPctypesList(List<Pctype> pctypesList) {
        this.pctypesList = pctypesList;
    }

    public List<Pcfreeumpiredegree> getNewPcfreeumpiredegrees() {
        return this.pcfreeumpiredegrees;
    }

    public void setNewPcfreeumpiredegrees(
            List<Pcfreeumpiredegree> pcfreeumpiredegrees) {
        this.pcfreeumpiredegrees = pcfreeumpiredegrees;
    }

    /**
     * 保存处罚项目类别
     */
    @Override
    public String save() {
        Pcdef pcdef = pcdefManager.getObjectByItemId(object
                .getPunishclasscode());

        String[] punishobject_type = request
                .getParameterValues("punishobjectList");
        if (punishobject_type.length == 2) {
            object.setPunishobject(Long.parseLong("2"));// 2表示个人和机构
        } else {
            object.setPunishobject(Long.parseLong(punishobject_type[0]));
        }
        // pcdef不为空，则为更新
        if (pcdef != null) {
            pcdefManager.copyObjectNotNullProperty(pcdef, object);
            object = pcdef;

        } else {
            // 生成处罚项目类别编号 PDM里为8位
            object.setPunishclassid(pcdefManager.generateNextPunishClassID());
        }
        pcdefManager.saveObject(object);

        return this.edit();
    }

    /**
     * 处罚编辑
     * 
     * @author sj
     */

    @SuppressWarnings("unchecked")
    @Override
    public String edit() {
        String punishclasscode = object.getPunishclasscode();
        String punishclassid = object.getPunishclassid();
        object = pcdefManager.getObjectByItemId(punishclasscode);
        if (object == null && punishclasscode == null && punishclassid != null) {
            object = pcdefManager.getObjectById(punishclassid);
        }
        if (object == null) {
            object = new Pcdef();
            object.setPunishclasscode(punishclasscode);
        } else {
            if (object.getPunishobject() == 2) {
                punishobjectList.add("0");
                punishobjectList.add("1");
            } else {
                punishobjectList.add(String.valueOf(object.getPunishobject()));
            }
        }
        return EDIT;
    }

    /**
     * 获取处罚项目类别列表
     */
    public String listPcdef() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        Object anyou = filterMap.get("belonganyou");
        String s_anyou = "";
        if (anyou != null) {
            s_anyou = anyou.toString();
        }
        pcdefList = this.pcdefManager.listPcdefUsingOrg(fuser.getPrimaryUnit(),
                s_anyou);
        if (pcdefList != null && pcdefList.size() > 0) {
            totalRows = pcdefList.size();
        } else {
            totalRows = 0;
        }

        return "listPcdef";
    }

    public String listPcdef4XCCF() {
        String punishobjectid = request.getParameter("punishobjectid");
        request.setAttribute("punishobjectid", punishobjectid);
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        Object anyou = filterMap.get("belonganyou");
        String s_anyou = "";
        if (anyou != null) {
            s_anyou = anyou.toString();
        }
        pcdefList = this.pcdefManager.listPcdefUsingOrg(fuser.getPrimaryUnit(),
                s_anyou);
        totalRows = pageDesc.getTotalRows();

        return "listPcdef4XCCF";
    }
}
