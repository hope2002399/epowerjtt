package com.centit.poweritem.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.poweritem.po.BpowerItem;
import com.centit.poweritem.po.BpowerItemQldy;
import com.centit.poweritem.service.BpowerItemManager;
import com.centit.poweritem.service.BpowerItemQldyManager;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.opensymphony.xwork2.ActionContext;

public class BpowerItemAction extends BaseEntityExtremeAction<BpowerItem>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    ActionContext context = ActionContext.getContext();
    HttpServletResponse response;
    private BpowerItemManager bpowerItemManager;
    private BpowerItemQldyManager bpowerItemQldyManager;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private List<FUnitinfo> unitList;
    private String unitsJson;
    private String parentunit;
    @SuppressWarnings("rawtypes")
    private List bpowerItemlist;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public ActionContext getContext() {
        return context;
    }

    public void setContext(ActionContext context) {
        this.context = context;
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    public String getParentunit() {
        return parentunit;
    }

    public void setParentunit(String parentunit) {
        this.parentunit = parentunit;
    }
    @SuppressWarnings("rawtypes")
    public List getBpowerItemlist() {
        return bpowerItemlist;
    }
    @SuppressWarnings("rawtypes")
    public void setBpowerItemlist(List bpowerItemlist) {
        this.bpowerItemlist = bpowerItemlist;
    }

    public BpowerItemManager getBpowerItemManager() {
        return bpowerItemManager;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
    }

    public BpowerItemQldyManager getBpowerItemQldyManager() {
        return bpowerItemQldyManager;
    }

    public void setBpowerItemQldyManager(
            BpowerItemQldyManager bpowerItemQldyManager) {
        this.bpowerItemQldyManager = bpowerItemQldyManager;
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

    public void setBpowerItemManager(BpowerItemManager bpowerItemManager) {
        this.bpowerItemManager = bpowerItemManager;
    }

    @SuppressWarnings("unchecked")
    public String listBpowerItem() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);

        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("sParentUnit", sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);

        PageDesc page = new PageDesc();
        page.setPageSize(15);
        String offSet = (String) request.getParameter("offset");
        if (StringUtils.isBlank(offSet))
            offSet = "0";

        int pageno = Integer.parseInt(offSet) / page.getPageSize() + 1;
        page.setPageNo(pageno);

        bpowerItemlist = bpowerItemManager.listObjects(filterMap, page);
        request.setAttribute("page", page);
        return "list";

    }

    public String deleteBpowerItem() {
        object = bpowerItemManager.getObjectById(object.getItemId());
        object.setItemStatus("4");
        object.setModifyTime(new Date(System.currentTimeMillis()));
        bpowerItemManager.saveObject(object);
        return listBpowerItem();

    }
    @SuppressWarnings("rawtypes")
    public String viewBpowerItem() {
        object = bpowerItemManager.getObjectById(object.getItemId());

        if ("1".equals(object.getIsContainSub())) {
            Map<String, Object> filterMap = new HashMap<String, Object>();
            filterMap.put("parentId", object.getItemId());
            List subList = bpowerItemManager.listObjects(filterMap);
            if (subList != null && subList.size() > 0)
                request.setAttribute("sublist", subList);
        } else {
            Map<String, Object> filterMap = new HashMap<String, Object>();
            filterMap.put("itemSubId", object.getItemId());
            List ywList = bpowerItemQldyManager.listObjects(filterMap);
            if (ywList != null && ywList.size() > 0)
                request.setAttribute("ywlist", ywList);
        }

        return "view";

    }

    @SuppressWarnings("unchecked")
    public String addBpowerItem() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);

        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("sParentUnit", sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        String type = request.getParameter("type");
        if ("cfzx".equals(type)) {
            object = bpowerItemManager.getObjectById(object.getItemId());
            request.setAttribute("type", type);
        }

        return "add";

    }

    @SuppressWarnings("unchecked")
    public String editBpowerItem() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);

        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("sParentUnit", sParentUnit);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);

        object = bpowerItemManager.getObjectById(object.getItemId());

        return "form";

    }

    public String saveBpowerItem() {

        object.setModifyTime(new Date(System.currentTimeMillis()));
        bpowerItemManager.saveObject(object);
        if (object.getCreateTime() == null) {
            object.setCreateTime(object.getModifyTime());
            bpowerItemManager.saveObject(object);
        }
        return listBpowerItem();

    }

    public String checkItemId() {
        try {
            String type = request.getParameter("type");
            if (!"cfzx".equals(type)) {
                if (!object.getItemId().endsWith("000")) {
                    result.put("message", "ERROR");
                    return "checkitemid";
                }
            }
            object = bpowerItemManager.getObjectById(object.getItemId());
            result = new JSONObject();
            if (object != null) {
                result.put("message", "USED");
            } else {
                result.put("message", "UNUSE");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "checkitemid";
    }

    private JSONObject result;

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    public String editBpowerItemQldy() {

        // 拆分子项处理
        String serviceId = request.getParameter("serviceId");
        qldy = bpowerItemQldyManager.getObjectById(serviceId);
        object = bpowerItemManager.getObjectById(qldy.getItemSubId());
        request.setAttribute("type", request.getParameter("type"));

        request.setAttribute("itemType", getOldItemType(object.getItemType()));

        return "editQldy";

    }

    public String addBpowerItemQldy() {

        // 拆分子项处理
        String itemSubId = request.getParameter("itemSubId");
        object = bpowerItemManager.getObjectById(itemSubId);
        request.setAttribute("type", request.getParameter("type"));

        request.setAttribute("itemType", getOldItemType(object.getItemType()));
        return "addQldy";

    }

    // 把新的itemType转换成老的
    private Object getOldItemType(String itemType) {
        String oldItemType = "";
        if ("01".equals(itemType)) {
            oldItemType = "XK";
        } else if ("02".equals(itemType)) {
            oldItemType = "CF";
        } else if ("03".equals(itemType)) {
            oldItemType = "QZ";
        } else if ("04".equals(itemType)) {
            oldItemType = "ZS";
        } else if ("05".equals(itemType)) {
            oldItemType = "GF";
        } else if ("06".equals(itemType)) {
            oldItemType = "JL";
        } else if ("07".equals(itemType)) {
            oldItemType = "QR";
        } else if ("08".equals(itemType)) {
            oldItemType = "CJ";
        } else if ("09".equals(itemType)) {
            oldItemType = "ZY";
        } else if ("10".equals(itemType)) {
            oldItemType = "QT";
        }
        return oldItemType;
    }

    private BpowerItemQldy qldy;

    public BpowerItemQldy getQldy() {
        return qldy;
    }

    public void setQldy(BpowerItemQldy qldy) {
        this.qldy = qldy;
    }

    public String checkServiceId() {
        try {

            qldy = bpowerItemQldyManager.getObjectById(request
                    .getParameter("serviceId"));
            result = new JSONObject();
            if (qldy != null) {
                result.put("message", "USED");
            } else {
                result.put("message", "UNUSE");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "checkitemid";
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String checkItemQldyItemId() {
        try {
            Map map = new HashMap();
            String itemQldyItemId = request.getParameter("itemQldyItemId");
            String serviceId = request.getParameter("serviceId");
            String itemId = request.getParameter("itemId");
            map.put("itemQldyItemId", itemQldyItemId);
            if (StringUtils.isNotBlank(serviceId)) {
                map.put("NserviceId", serviceId);
            }
            if (StringUtils.isNotBlank(itemId)) {
                map.put("NitemId", itemId);
            }
            List list = new ArrayList();
            List list1 = new ArrayList();

            list = bpowerItemQldyManager.listObjects(map);

            list1 = bpowerItemManager.listObjects(map);

            result = new JSONObject();
            if ((list != null && list.size() > 0)
                    || (list1 != null && list1.size() > 0)) {
                result.put("message", "USED");
            } else {
                result.put("message", "UNUSE");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "checkitemid";
    }

    private void request2BpowerItemQldy() {
        qldy = new BpowerItemQldy();
        qldy.setServiceId(request.getParameter("serviceId"));
        qldy.setServiceName(request.getParameter("serviceName"));
        qldy.setItemMainId(request.getParameter("itemMainId"));
        qldy.setItemMainName(request.getParameter("itemMainName"));
        qldy.setItemSubId(request.getParameter("itemSubId"));
        qldy.setItemSubName(request.getParameter("itemSubName"));
        qldy.setItemQldyItemId(request.getParameter("itemQldyItemId"));
        qldy.setStatus(request.getParameter("status"));

    }

    public String saveBpowerItemQldy() {
        if (qldy == null)
            request2BpowerItemQldy();
        bpowerItemQldyManager.saveObject(qldy);
        String type = request.getParameter("type");
        if ("list".equals(type)) {
            return listBpowerItemQldy();
        }
        if ("listitem".equals(type)) {
            return listBpowerItem();
        }
        object.setItemId(qldy.getItemSubId());
        return viewBpowerItem();

    }

    public String deleteBpowerItemQldy() {
        if (qldy == null)
            request2BpowerItemQldy();
        qldy = bpowerItemQldyManager.getObjectById(qldy.getServiceId());
        qldy.setStatus("4");
        bpowerItemQldyManager.saveObject(qldy);
        String type = request.getParameter("type");
        if ("list".equals(type)) {
            return listBpowerItemQldy();
        }
        object.setItemId(qldy.getItemSubId());
        return viewBpowerItem();

    }

    public String viewBpowerItemQldy() {
        qldy = bpowerItemQldyManager.getObjectById(request
                .getParameter("serviceId"));

        return "viewQldy";

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String listBpowerItemQldy() {
        if (qldy == null) {
            request2BpowerItemQldy();
        }
        String itemSubId = qldy.getItemSubId();
        Map map = new HashMap();
        map.put("itemSubId", itemSubId);
        object = bpowerItemManager.getObjectById(itemSubId);

        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);

        List list = bpowerItemQldyManager.listObjects(map, pageDesc);
        request.setAttribute("list", list);
        totalRows = pageDesc.getTotalRows();

        return "listQldy";
    }
}
