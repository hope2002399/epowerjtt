package com.centit.sys.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.service.CodeRepositoryManager;
import com.centit.sys.service.FunctionManager;
import com.centit.sys.util.ISysOptLog;
import com.centit.sys.util.SysOptLogFactoryImpl;

public class OptInfoAction extends BaseEntityExtremeAction<FOptinfo> {

    private static final long serialVersionUID = 1L;
    private FunctionManager functionManager;
    private CodeRepositoryManager codeRepositoryManager;
    private Integer totalRows;
    private static final ISysOptLog SYS_OPT_LOG = SysOptLogFactoryImpl
            .getSysOptLog("OPTINFO");

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public void setCodeRepositoryManager(
            CodeRepositoryManager codeRepositoryManager) {
        this.codeRepositoryManager = codeRepositoryManager;
    }

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
        setBaseEntityManager(functionManager);
    }

    // 应为这个业务管理页面 不需要进行分页
    public String list() {

        try {

            objList = functionManager.listObjects();

            totalRows = objList.size();

            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String built() {
        try {

            return EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String save() {
        try {
            FOptinfo dbobject = functionManager
                    .getObjectById(object.getOptid());
            if (dbobject != null) {
                functionManager.copyObjectNotNullProperty(dbobject, object);
                object = dbobject;

            }
            try {
                functionManager.saveObject(object);
                // 刷新系统中的缓存
                codeRepositoryManager.refresh("optid");
                savedMessage();

                SYS_OPT_LOG.log(
                        ((FUserinfo) this.getLoginUser()).getUsercode(), object
                                .getOptid(), object.display(),
                        dbobject != null ? dbobject.display() : "");
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                e.printStackTrace();
                return EDIT;
            }
            return SUCCESS;
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    public String delete() {
        try {

            try {
                functionManager.deleteObject(object);
                // 刷新系统中的缓存
                codeRepositoryManager.refresh("optid");
                deletedMessage();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return EDIT;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

}
