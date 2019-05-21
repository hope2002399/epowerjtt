package com.centit.dispatchdoc.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.po.IncomeDoc;
import com.centit.dispatchdoc.po.VIncomeDocList;
import com.centit.dispatchdoc.service.IncomeDocManager;
import com.centit.dispatchdoc.service.VIncomeDocListManager;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.security.FUserDetail;
import com.centit.workflow.FlowInstance;

/**
 * 
 * 收文流程业务操作ACTION
 * 
 * @author ljy
 * @create 2013-9-26
 * @version
 */
public class IncomeDocAction extends IODocCommonBizAction<IncomeDoc> {
    private static final long serialVersionUID = 1L;
    private IncomeDocManager incomeDocManage;
    private VIncomeDocListManager incomeDocListManager;
    private List<VIncomeDocList> incomeDocList;

    public void setIncomeDocManager(IncomeDocManager basemgr) {
        this.incomeDocManage = basemgr;
        super.setBaseEntityManager(basemgr);
    }

    public void setIncomeDocListManager(VIncomeDocListManager incomeDocListMgr) {
        this.incomeDocListManager = incomeDocListMgr;
    }

    public List<VIncomeDocList> getIncomeDocList() {
        return incomeDocList;
    }

    public void setIncomeDocList(List<VIncomeDocList> incomeDocList) {
        this.incomeDocList = incomeDocList;
    }

    /**
     * 收文子流程：1、收文后，获取收文信息封装并流转到发文界面 2、提交发文信息进入发文流程、
     * 
     * @return
     */
    public String toDispatchDocFlow() {
        // TODO 封装全部对应的收发文信息
        return "startDispatchDoc";
    }

    public String saveIncomeDocReg() {

        try {
            OptBaseInfo optBaseInfo = object.getOptBaseInfo();
            OptBaseInfo baseInfo = optBaseInfoManager.getObjectById(object
                    .getDjId());

            if (baseInfo == null) {
                optBaseInfo.setDjId(object.getDjId());
                optBaseInfo.setFlowInstId(super.getFlowInstId());
                if (optBaseInfo.getFlowInstId() == null
                        || "".equals(optBaseInfo.getFlowInstId())) {
                    optBaseInfo.setBiztype("F");// 未提交标志
                }
                optBaseInfo.setCreatedate(new Date(System.currentTimeMillis()));
                optBaseInfo.setCreateuser(((FUserDetail) getLoginUser())
                        .getUsercode());
                optBaseInfo.setBizstate("N");
            } else {
                IncomeDoc incomeDoc = incomeDocManage.getObjectById(object
                        .getDjId());
                incomeDocManage.copyObjectNotNullProperty(incomeDoc, object);
                object = incomeDoc;
                optBaseInfoManager.copyObjectNotNullProperty(baseInfo,
                        optBaseInfo);
                optBaseInfo = baseInfo;
            }

            // TODO 收文业务数据保存

            optBaseInfoManager.saveObject(optBaseInfo);

            // incomeDocManage.saveObject(object);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }

        return this.edit();
    }

    public String edit() {
        try {
            if (StringUtils.isBlank(object.getDjId())) {
                object.setDjId(incomeDocManage.getNextkey());
                OptBaseInfo optBase = new OptBaseInfo();
                // optBase.setTransAffairNo("JS0113-"
                // + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(
                // System.currentTimeMillis())));
                object.setOptBaseInfo(optBase);
            } else {
                // 根据登记编号查看许可信息
                this.getIncomeDocInfo();
                request.setAttribute("flowCode", object.getFlowCode());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }

        return EDIT;
    }

    private void getIncomeDocInfo() {
        object = incomeDocManage.getObjectById(object.getDjId());

        if (null != object) {
            OptBaseInfo optBaseInfo = optBaseInfoManager.getObjectById(object
                    .getDjId());
            object.setOptBaseInfo(optBaseInfo);
        } else {
            object = new IncomeDoc();
            object.setDjId(incomeDocManage.getNextkey());
            OptBaseInfo optBase = new OptBaseInfo();
            // optBase.setTransAffairNo("JS0113-"
            // + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(
            // System.currentTimeMillis())));
            object.setOptBaseInfo(optBase);
        }
    }

    public String saveIncomeDoc() {
        OptBaseInfo optBaseInfo = object.getOptBaseInfo();
        OptBaseInfo baseInfo = optBaseInfoManager.getObjectById(object
                .getDjId());

        if (baseInfo == null) {
            optBaseInfo.setDjId(object.getDjId());
            optBaseInfo.setFlowInstId(super.getFlowInstId());
            if (optBaseInfo.getFlowInstId() == null
                    || "".equals(optBaseInfo.getFlowInstId())) {
                optBaseInfo.setBiztype("F");// 未提交标志
            }
            optBaseInfo.setCreatedate(new Date(System.currentTimeMillis()));
            optBaseInfo.setCreateuser(((FUserDetail) getLoginUser())
                    .getUsercode());
            optBaseInfo.setBizstate("N");
            object.setCreateDate(new Date(System.currentTimeMillis()));
        } else {
            IncomeDoc incomeDoc = incomeDocManage.getObjectById(object
                    .getDjId());
            incomeDocManage.copyObjectNotNullProperty(incomeDoc, object);
            object = incomeDoc;

            optBaseInfoManager.copyObjectNotNullProperty(baseInfo, optBaseInfo);
            optBaseInfo = baseInfo;
        }

        object.setItemId(optBaseInfo.getPowerid());
        object.setInternalNo(object.getDjId());
        object.setUpdateDate(new Date(System.currentTimeMillis()));

        incomeDocManage.saveObject(object);
        optBaseInfoManager.saveObject(optBaseInfo);

        return this.edit();
    }

    /**
     * 保存并提交收文信息
     * 
     * @return
     */
    public String saveAndSubmitIncomeDoc() {

        OptBaseInfo optBaseInfo = object.getOptBaseInfo();
        if (optBaseInfo.getFlowInstId() == null
                || "".equals(optBaseInfo.getFlowInstId())) {
            FUserDetail fuser = ((FUserDetail) getLoginUser());

            FlowInstance flowInst = flowEngine.createInstance(
                    object.getFlowCode(), optBaseInfo.getTransaffairname(),
                    optBaseInfo.getTransAffairNo(), fuser.getUsercode(),
                    fuser.getPrimaryUnit());
            long flowInstId = flowInst.getFlowInstId();
            long nodeInstId = flowInst.getFirstNodeInstance().getNodeInstId();
            this.setFlowInstId(flowInstId);
            curNodeInstId = nodeInstId;

            object.getOptBaseInfo().setFlowInstId(flowInstId);
            object.getOptBaseInfo().setBiztype("T");
        }

        saveIncomeDoc();
        saveIdeaInfo();
        return "refreshIncomeTasks";
    }

    /**
     * 保存收文发起步骤过程日志信息
     */
    public void saveIdeaInfo() {
        FUserDetail loginInfo = (FUserDetail) getLoginUser();

        OptIdeaInfo optIdeaInfo = new OptIdeaInfo();
        optIdeaInfo.setUsername(loginInfo.getUsername());

        FUnitinfo fUnitinfo = sysUnitManager.getObjectById(loginInfo
                .getPrimaryUnit().trim());
        if (fUnitinfo == null) {
            fUnitinfo = new FUnitinfo();
        }
        optIdeaInfo.setUnitname(fUnitinfo.getUnitname());

        optIdeaInfo.setTransidea("收文发起");

        OptProcInfo procInfo = new OptProcInfo();
        procInfo.setNodeInstId(curNodeInstId);
        procInfo.setDjId(object.getDjId());
        procInfo.setNodename("收文发起");
        procInfo.setTransdate(new Date(System.currentTimeMillis()));
        procInfo.setNodeinststate("N");
        procInfo.setUnitcode(loginInfo.getPrimaryUnit());
        procInfo.setUsercode(loginInfo.getUsercode());
        procInfo.setTransidea("收文发起");

        optProcInfoManager.saveObject(procInfo);
        optProcInfoManager.saveIdeaInfo(optIdeaInfo, procInfo);

    }

    public String viewIncomeDocInfo() {
        try {
            object = incomeDocManage.getObjectById(object.getDjId());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }

        return VIEW;
    }

    /**
     * 根据查询表单查询(未提交发文/已办结发文)
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String list() {
        try {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            PageDesc pageDesc = makePageDesc();

            FUserDetail loginUser = ((FUserDetail) getLoginUser());
            filterMap.put("createuser", loginUser.getUsercode());
            filterMap.put(CodeBook.SELF_ORDER_BY, "update_date desc");

            incomeDocList = incomeDocListManager.listObjects(filterMap,
                    pageDesc);

            totalRows = pageDesc.getTotalRows();

            this.pageDesc = pageDesc;
            return "fList";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String delete() {
        try {
            OptBaseInfo optBaseInfo = optBaseInfoManager.getObjectById(object
                    .getDjId());
            IncomeDoc incomeDoc = incomeDocManage.getObjectById(object
                    .getDjId());

            if (optBaseInfo != null) {
                optBaseInfoManager.deleteObject(optBaseInfo);
            }
            if (incomeDoc != null) {
                incomeDocManage.deleteObject(incomeDoc);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

        return this.list();
    }
}
