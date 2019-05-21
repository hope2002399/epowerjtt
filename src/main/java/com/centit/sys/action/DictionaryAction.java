package com.centit.sys.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.sys.po.FDatacatalog;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.po.FDatadictionaryId;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.service.CodeRepositoryManager;
import com.centit.sys.service.DictionaryManager;
import com.centit.sys.util.ISysOptLog;
import com.centit.sys.util.SysOptLogFactoryImpl;

public class DictionaryAction extends BaseEntityExtremeAction<FDatacatalog> {

    private static final long serialVersionUID = 1L;
    private DictionaryManager dictManger;

    private CodeRepositoryManager codeRepo;
    private FDatacatalog catalog;
    private String[] fdesc;
    private List<FDatadictionary> dictDetails;
    private static final ISysOptLog SYS_OPT_LOG = SysOptLogFactoryImpl
            .getSysOptLog("DICTSET");

    private Integer dc_totalRows;
    private FDatadictionaryId id;
    private FDatadictionary datadictionary;

    public FDatacatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(FDatacatalog catalog) {
        this.catalog = catalog;
    }

    public String[] getFdesc() {
        return fdesc;
    }

    public void setFdesc(String[] fdesc) {
        this.fdesc = fdesc;
    }

    public List<FDatadictionary> getDictDetails() {
        return dictDetails;
    }

    public void setDictDetails(List<FDatadictionary> dictDetails) {
        this.dictDetails = dictDetails;
    }

    public Integer getDc_totalRows() {
        return dc_totalRows;
    }

    public void setDc_totalRows(Integer dc_totalRows) {
        this.dc_totalRows = dc_totalRows;
    }

    public FDatadictionaryId getId() {
        return id;
    }

    public void setId(FDatadictionaryId id) {
        this.id = id;
    }

    public FDatadictionary getDatadictionary() {
        return datadictionary;
    }

    public void setDatadictionary(FDatadictionary datadictionary) {
        this.datadictionary = datadictionary;
    }

    public void setCodeRepoManager(CodeRepositoryManager crm) {
        this.codeRepo = crm;
    }

    public void setDictManger(DictionaryManager dm) {
        this.dictManger = dm;
        setBaseEntityManager(dm);
    }

    /*
     * @Override protected Map<String,String>
     * convertSearchColumn(Map<Object,Object> paramMap) { //
     * log.debug("规则化前参数表：" + paramMap.toString()); Map<String,String> map =
     * super.convertSearchColumn(paramMap);
     * //log.warn("request.getAttribute style"); Object obj = map.get("style");
     * 
     * String sAttr = obj==null?"U":obj.toString(); //log.warn(sAttr); if(sAttr
     * !=null && !sAttr.equals("")) map.put("CATALOGSTYLE", sAttr);
     * 
     * return map; }
     */

    public String refresh() {

        codeRepo.refreshAll();
        return SUCCESS;
    }

    public String view() {

        try {

            FDatacatalog dbobject = dictManger.getObjectById(object
                    .getCatalogcode());

            if (dbobject == null) {

                return LIST;
            }
            catalog = dbobject;

            fdesc = dictManger.getFieldsDesc(dbobject.getFielddesc(),
                    dbobject.getCatalogtype());
            // request.setAttribute("fdesc", fdesc);
            dictDetails = dictManger.findByCdtbnm(object.getCatalogcode());
            // request.setAttribute("dictDetails", dictDetailList);
            if (dictDetails != null) {
                totalRows = dictDetails.size();
                dc_totalRows = dictDetails.size();
            }
            // onInitForm(form, request, null);
            return VIEW;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String save() {

        try {
            FDatacatalog dbobject = dictManger.getObject(object);
            if (dbobject != null) {
                dbobject.copyNotNullProperty(object);
                object = dbobject;
            }
            try {
                dictManger.saveObject(object);
                savedMessage();
            } catch (Exception e) {
                log.error(e.getMessage(), e);

                return EDIT;
            }

            return SUCCESS;
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    public String deleteDetail() {

        try {
            String catalogCode = request.getParameter("catalogcode");
            String dataCode = request.getParameter("datacode");
            id = new FDatadictionaryId();
            if (StringUtils.isNotBlank(catalogCode)) {
                id.setCatalogcode(catalogCode);
            }
            if (StringUtils.isNotBlank(dataCode)) {
                id.setDatacode(dataCode);
            }
            dictManger.deleteCditms(id);
            codeRepo.refresh(id.getCatalogcode());

            FDatacatalog dbobject = dictManger.getObjectById(id
                    .getCatalogcode());

            if (dbobject == null) {
                saveError("entity.missing");
                return LIST;
            }
            SYS_OPT_LOG
                    .log(((FUserinfo) this.getLoginUser()).getUsercode(),
                            id.toString(),
                            "删除字典代码 [" + dbobject.getCatalogcode() + "]");

            // fdesc =
            // dictManger.getFieldsDesc(dbobject.getFielddesc(),dbobject.getCatalogtype());
            // catalog=dbobject;
            // dictDetails =
            // CodeRepositoryUtil.getDataDetail(id.getCatalogcode());
            //
            // totalRows= dictDetails.size();

            return "deleteDetail";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String editDetail() {

        try {
            String catalogCode = request.getParameter("catalogcode");
            String dataCode = request.getParameter("datacode");
            id = new FDatadictionaryId();
            if (StringUtils.isNotBlank(catalogCode)) {
                id.setCatalogcode(catalogCode);
            }
            if (StringUtils.isNotBlank(dataCode)) {
                id.setDatacode(dataCode);
            }
            datadictionary = dictManger.findById(id);
            if (datadictionary == null) {
                datadictionary = new FDatadictionary();
                datadictionary.setId(id);
            }

            catalog = dictManger.getObjectById(id.getCatalogcode());

            fdesc = dictManger.getFieldsDesc(catalog.getFielddesc(),
                    catalog.getCatalogtype());

            return "editDetail";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String saveDetail() {
        try {

            FDatadictionary desobj = dictManger
                    .findById(datadictionary.getId());

            if (desobj != null) {
                desobj.copyNotNullProperty(datadictionary);
                datadictionary = desobj;
            }

            dictManger.saveCditms(datadictionary);
            savedMessage();
            // 刷新缓存中的字典
            codeRepo.refresh(datadictionary.getCatalogcode());

            SYS_OPT_LOG.log(((FUserinfo) this.getLoginUser()).getUsercode(),
                    datadictionary.getId().toString(),
                    datadictionary.display(), desobj != null ? desobj.display()
                            : "");
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return "editDetail";
        }

        return "saveDetail";

    }

}
