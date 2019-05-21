package com.centit.dispatchdoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.po.DispatchDoc;
import com.centit.dispatchdoc.po.DispatchDocTask;
import com.centit.dispatchdoc.po.DocRelative;
import com.centit.dispatchdoc.po.DocRelativeId;
import com.centit.dispatchdoc.po.VDispatchDocList;
import com.centit.dispatchdoc.po.VIncomeDocList;
import com.centit.dispatchdoc.service.DispatchDocManager;
import com.centit.dispatchdoc.service.DocRelativeManager;
import com.centit.dispatchdoc.service.IODocTasksManager;
import com.centit.dispatchdoc.service.IncomeDocManager;
import com.centit.dispatchdoc.service.VIncomeDocListManager;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.security.FUserDetail;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.NodeInstance;

public class DispatchDocAction extends IODocCommonBizAction<DispatchDoc>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    HttpServletResponse response;
    private DispatchDocManager dispatchDocMag;
    private IODocTasksManager ioDocTasksManager;
    private DocRelativeManager docRelativeManager;
    private IncomeDocManager incomeDocManager;
    private VIncomeDocListManager incomeDocListManager;

    private List<VIncomeDocList> incomeDocList;
    private List<DispatchDocTask> vUserTasksList;

    // 关联的收文集合
    private List<VDispatchDocList> vDispatchDocList;

    // 收发文关联frame类型（编辑/查看）
    private String docRelativeFrameType;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String viewDispatchDocInfo() {
        try {
            DispatchDoc o = baseEntityManager.getObject(object);
            if (object == null) {

                return LIST;
            }
            if (o != null)

                baseEntityManager.copyObject(object, o);
            object.setOptBaseInfo(super.optBaseInfoManager.getObjectById(o
                    .getDjId()));
            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
        // return super.view();
    }

    /**
     * 收文子流程：1、收文后，获取收文信息封装并流转到发文界面 2、提交发文信息进入发文流程、
     * 
     * @return
     */
    public String toDispatchDocFlow() {
        String incomeNo = object.getDjId();
        object.setDjId(dispatchDocMag.getNextkey());

        request.setAttribute("incomeNo", incomeNo);
        return "IODocSubFlow";
    }

    /**
     * 查询收发文关系表，列出关联的收文
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String docRelativeList() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);

        // 发文号
        String dispatchNo = request.getParameter("dispatchNo");
        request.setAttribute("dispatchNo", dispatchNo);

        PageDesc pageDesc = makePageDesc();

        incomeDocList = incomeDocListManager.getDocRelativeList(dispatchNo);

        totalRows = incomeDocList.size();

        request.setAttribute("docRelativeFrameType", docRelativeFrameType);

        this.pageDesc = pageDesc;
        return "cList";
    }

    public String docRelativeSave() {
        JSONObject json = new JSONObject();

        try {
            String dispatchNo = request.getParameter("dispatchNo");
            String incomeNo = request.getParameter("incomeNo");
            String[] incomeNos = null;
            if (incomeNo.indexOf(",") > -1) {
                incomeNos = incomeNo.split(",");
            } else {
                incomeNos = new String[1];
                incomeNos[0] = incomeNo;
            }

            List<DocRelative> docRelativeList = docRelativeManager
                    .getObjectsByDispatchNo(dispatchNo);

            List<DocRelative> docRelativeCheckedList = new ArrayList<DocRelative>();
            for (int i = incomeNos.length - 1; i >= 0; i--) {
                if (StringUtils.isNotBlank(incomeNos[i])) {
                    DocRelative docRelative = new DocRelative();
                    DocRelativeId cid = new DocRelativeId();
                    cid.setDispatchNo(dispatchNo);
                    cid.setIncomeNo(incomeNos[i]);
                    docRelative.setCid(cid);
                    docRelative.setRelativeType("A");

                    docRelativeCheckedList.add(docRelative);
                }
            }

            for (int i = docRelativeCheckedList.size() - 1; i >= 0; i--) {
                if (docRelativeList.isEmpty()) {
                    docRelativeManager
                            .saveObject(docRelativeCheckedList.get(i));
                } else {
                    DocRelativeId id = docRelativeCheckedList.get(i).getCid();
                    for (int j = docRelativeList.size() - 1; j >= 0; j--) {
                        DocRelativeId cid = docRelativeList.get(j).getCid();
                        if (id.getDispatchNo().equals(cid.getDispatchNo())
                                && id.getIncomeNo().equals(cid.getIncomeNo())) {
                            docRelativeList.remove(j);
                            break;
                        }

                        if (j == 0) {
                            docRelativeManager
                                    .saveObject(docRelativeCheckedList.get(i));
                        }
                    }
                }
            }

            for (int i = docRelativeList.size() - 1; i >= 0; i--) {
                docRelativeManager.deleteObject(docRelativeList.get(i));
            }

            json.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("status", "failed");
        } finally {
            this.ajaxResponseJson(response, json);
        }

        return null;
    }

    /**
     * 查询收发文关系表，列出收文
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String incomeDocList() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);

        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        filterMap.put(CodeBook.SELF_ORDER_BY, "update_date desc");
        PageDesc pageDesc = makePageDesc();
        incomeDocList = incomeDocListManager.listObjects(filterMap, pageDesc);

        totalRows = pageDesc.getTotalRows();

        request.setAttribute("dispatchNo", request.getParameter("dispatchNo"));

        this.pageDesc = pageDesc;
        return "rList";
    }

    /**
     * 删除收发文关系
     * 
     * @return
     */
    public String docRelativeDel() {
        JSONObject json = new JSONObject();

        try {
            DocRelativeId id = new DocRelativeId();
            id.setDispatchNo(request.getParameter("dispatchNo"));
            id.setIncomeNo(request.getParameter("incomeNo"));

            DocRelative docRelative = docRelativeManager.getObjectById(id);

            if (StringUtils.isNotBlank(docRelative.getCid().getDispatchNo())
                    && StringUtils.isNotBlank(docRelative.getCid()
                            .getIncomeNo())) {
                docRelativeManager.deleteObject(docRelative);
            }

            json.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("status", "failed");
        } finally {
            this.ajaxResponseJson(response, json);
        }

        return null;
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

            String orderField = request.getParameter("orderField");
            String orderDirection = request.getParameter("orderDirection");

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            if (!StringUtils.isBlank(orderField)
                    && !StringUtils.isBlank(orderDirection)) {

                filterMap.put(CodeBook.SELF_ORDER_BY, orderField + " "
                        + orderDirection);

                // request.setAttribute("orderDirection", orderDirection);
                // request.setAttribute("orderField", orderField);
            }
            PageDesc pageDesc = makePageDesc();

            FUserDetail loginUser = ((FUserDetail) getLoginUser());

            filterMap.put("createuser", loginUser.getUsercode());

            vDispatchDocList = dispatchDocMag.getVDispatchDocList(filterMap,
                    pageDesc);

            request.setAttribute("vDispatchDocList", vDispatchDocList);
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
            DispatchDoc dispatchDoc = dispatchDocMag.getObjectById(object
                    .getDjId());
            List<DocRelative> docRelativeList = docRelativeManager
                    .getObjectsByDispatchNo(object.getDjId());

            if (optBaseInfo != null) {
                optBaseInfoManager.deleteObject(optBaseInfo);
            }
            if (dispatchDoc != null) {
                dispatchDocMag.deleteObject(dispatchDoc);
            }
            if (docRelativeList != null) {
                for (int i = 0; i < docRelativeList.size(); i++) {
                    docRelativeManager.deleteObject(docRelativeList.get(i));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

        return this.list();
    }

    /**
     * 
     * 未提交编辑
     * 
     * @return
     */
    public String edit() {
        try {
            if (LIST.equals(editDispatchDoc())) {
                return LIST;
            } else {
                return "fEdit";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    /**
     * 已提交编辑
     * 
     * @return
     */
    public String editDispatchDocInfo() {
        try {
            if (LIST.equals(editDispatchDoc())) {
                return LIST;
            } else {
                // 查询关联的收文
                docRelativeList();
                return "procEdit";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    /**
     * 
     * @return
     */
    public String editDispatchDoc() {

        DispatchDoc o = baseEntityManager.getObject(object);
        if (object == null) {

            return LIST;
        }
        if (o != null)
            baseEntityManager.copyObject(object, o);
        object.setOptBaseInfo(super.optBaseInfoManager.getObjectById(o
                .getDjId()));
        this.initCommonBizJSON(o);
        return "fEdit";

    }

    public String startDispatchDoc() {

        String djId = dispatchDocMag.getNextkey();
        object.setDjId(djId);
        return "startDispatchDoc";
    }

    /**
     * 办理步骤时保存
     * 
     * @return
     */
    public String saveTransDispatch() {
        this.saveCommon();
        return "procEdit";
    }

    /**
     * 发文流程发起时保存
     * 
     * @return
     */
    public String saveDispatchDoc() {
        this.saveCommon();
        return SUCCESS;
    }

    private void saveCommon() {
        OptBaseInfo optBaseInfo = object.getOptBaseInfo();
        OptBaseInfo baseInfo = optBaseInfoManager.getObjectById(object
                .getDjId());

        // 创建基本信息
        if (baseInfo == null) {
            // String djId = dispatchDocMag.getNextkey();
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
            // 修改基本信息
            DispatchDoc dispatchDoc = dispatchDocMag.getObjectById(object
                    .getDjId());
            dispatchDocMag.copyObjectNotNullProperty(dispatchDoc, object);

            object = dispatchDoc;

            optBaseInfoManager.copyObjectNotNullProperty(baseInfo, optBaseInfo);
            optBaseInfo = baseInfo;

            object.setUpdateDate(new Date(System.currentTimeMillis()));
        }

        // 部门内部事项编号
        object.setInternalNo(optBaseInfo.getDjId());

        // 权力编码
        object.setItemId(optBaseInfo.getPowerid());

        dispatchDocMag.saveObject(object);

        optBaseInfoManager.saveObject(optBaseInfo);
    }

    private String ideacode;

    public String getIdeacode() {
        return ideacode;
    }

    public void setIdeacode(String ideacode) {
        this.ideacode = ideacode;
    }

    /**
     * 收发文子流程提交，发文作为子流程，需要组织并提交收文的节点，然后进入子流程
     * 
     * @return
     */
    public String submitAsSubFlow() {

        // 提交收文节点
        Set<Long> parentNode = super.submitNode();

        // 系统自动创建流程实例
        if (parentNode != null && parentNode.size() > 0) {
            Long parentNodeInstId = parentNode.iterator().next();

            // 根据收文子流程节点的实例编号获取子流程节点信息（* 可获取子流程实例编号getSubFlowInstId）
            NodeInstance nodeInst = flowEngine
                    .getNodeInstById(parentNodeInstId);

            /************** 构建发文基本信息数据begin **************************/
            OptBaseInfo optBaseInfo = object.getOptBaseInfo();
            optBaseInfo.setDjId(object.getDjId());
            optBaseInfo.setFlowInstId(nodeInst.getSubFlowInstId());
            optBaseInfo.setBiztype("T");// 未提交标志
            optBaseInfo.setCreatedate(new Date(System.currentTimeMillis()));
            optBaseInfo.setCreateuser(((FUserDetail) getLoginUser())
                    .getUsercode());
            optBaseInfo.setBizstate("N");
            object.setCreateDate(new Date(System.currentTimeMillis()));
            /************** 构建发文基本信息数据end **************************/

            /******************** 建立收发文关联begin **************************/
            DocRelative drObj = new DocRelative();
            drObj.setDispatchNo(object.getDjId());

            // 根据收文流程实例号获取当前收文办件基本信息
            OptBaseInfo baseInfo = optBaseInfoManager
                    .getOptBaseByFlowId(nodeInst.getFlowInstId());
            drObj.setIncomeNo(baseInfo.getDjId());

            List<DocRelative> docRelatives = new ArrayList<DocRelative>();
            docRelatives.add(drObj);
            object.replaceDocRelatives(docRelatives);
            /******************** 建立收发文关联end **************************/

            // 设置djId
            // startDispatchDoc();
            // 部门内部事项编号
            object.setInternalNo(optBaseInfo.getDjId());
            // 权力编码
            object.setItemId(optBaseInfo.getPowerid());

            dispatchDocMag.saveObject(object);
            optBaseInfoManager.saveObject(optBaseInfo);

            // 根据子流程获取流程实例
            // WfFlowInstance dbflowINST = (WfFlowInstance) flowEngine
            // .getFlowInstById(nodeInst.getSubFlowInstId());

            // 保存过程信息
            saveIdeaInfo();
        }
        return "refreshTasks";
    }

    /**
     * 保存并提交收文信息
     * 
     * @return
     */
    public String saveAndSubmitDispatchDoc() {

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

        // DocRelativeId id = new DocRelativeId();
        // id.setDispatchNo(object.getDjId());
        // id.setIncomeNo(request.getParameter("incomeNo"));
        // DocRelative docRelative = new DocRelative();
        // docRelative.setCid(id);
        // docRelative.setRelativeType("B");
        // docRelativeManager.saveObject(docRelative);
        saveDispatchDoc();
        saveIdeaInfo();
        return "dispatchDocTask";
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

        optProcInfoManager.saveObject(procInfo);
        optProcInfoManager.saveIdeaInfo(optIdeaInfo, procInfo);

    }

    public List<DispatchDocTask> getvUserTasksList() {
        return vUserTasksList;
    }

    public void setvUserTasksList(List<DispatchDocTask> vUserTasksList) {
        this.vUserTasksList = vUserTasksList;
    }

    public void setDispatchDocManager(DispatchDocManager basemgr) {
        dispatchDocMag = basemgr;
        this.setBaseEntityManager(dispatchDocMag);
    }

    public DispatchDocManager getDispatchDocMag() {
        return dispatchDocMag;
    }

    public void setDispatchDocMag(DispatchDocManager dispatchDocMag) {
        this.dispatchDocMag = dispatchDocMag;
    }

    public IODocTasksManager getIoDocTasksManager() {
        return ioDocTasksManager;
    }

    public void setIoDocTasksManager(IODocTasksManager ioDocTasksManager) {
        this.ioDocTasksManager = ioDocTasksManager;
    }

    public DocRelativeManager getDocRelativeManager() {
        return docRelativeManager;
    }

    public void setDocRelativeManager(DocRelativeManager docRelativeManager) {
        this.docRelativeManager = docRelativeManager;
    }

    public List<VDispatchDocList> getvDispatchDocList() {
        return vDispatchDocList;
    }

    public void setvDispatchDocList(List<VDispatchDocList> vDispatchDocList) {
        this.vDispatchDocList = vDispatchDocList;
    }

    public IncomeDocManager getIncomeDocManager() {
        return incomeDocManager;
    }

    public void setIncomeDocManager(IncomeDocManager incomeDocManager) {
        this.incomeDocManager = incomeDocManager;
    }

    public String getDocRelativeFrameType() {
        return docRelativeFrameType;
    }

    public void setDocRelativeFrameType(String docRelativeFrameType) {
        this.docRelativeFrameType = docRelativeFrameType;
    }

    public void setIncomeDocListManager(
            VIncomeDocListManager incomeDocListManager) {
        this.incomeDocListManager = incomeDocListManager;
    }

    public List<VIncomeDocList> getIncomeDocList() {
        return incomeDocList;
    }

    public void setIncomeDocList(List<VIncomeDocList> incomeDocList) {
        this.incomeDocList = incomeDocList;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        
        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    @SuppressWarnings("resource")
    public void ajaxResponseJson(HttpServletResponse response, JSONObject json) {
        // response 返回页面信息
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = null;

        try {
            response.setHeader("Cache-Control", "no-cache");
            response.setContentType("text/html;charset=UTF-8");

            writer = response.getWriter();
            writer.write(json.toString()); // 发送json数据
        } catch (Exception e) {
            response.setHeader("Cache-Control", "no-cache");
            response.setContentType("text/html;charset=UTF-8");

            try {
                writer = response.getWriter();
                writer.write(json.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
