package com.centit.sys.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.utils.LabelValueBean;
import com.centit.powerbase.dao.SuppowerDao;
import com.centit.powerbase.dao.Zf_powerDao;
import com.centit.powerbase.po.Suppower;
import com.centit.powerbase.po.Zf_power;
import com.centit.support.utils.StringRegularOpt;
import com.centit.sys.dao.DataCatalogDao;
import com.centit.sys.dao.DataDictionaryDao;
import com.centit.sys.dao.OptDefDao;
import com.centit.sys.dao.OptInfoDao;
import com.centit.sys.dao.RoleInfoDao;
import com.centit.sys.dao.UnitInfoDao;
import com.centit.sys.dao.UserInfoDao;
import com.centit.sys.dao.UserUnitDao;
import com.centit.sys.po.FDatacatalog;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.po.FOptdef;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.po.FRoleinfo;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.service.CodeRepositoryManager;
import com.centit.sys.service.CodeRepositoryUtil;

public class CodeRepositoryManagerImpl implements CodeRepositoryManager {
    private DataCatalogDao catalogDao;
    private DataDictionaryDao dictionaryDao;
    private UserInfoDao daoUser;
    private UnitInfoDao daoUnit;
    private RoleInfoDao sysroledao;
    private OptDefDao optdefdao;
    private OptInfoDao daoOptinfo;
    private UserUnitDao unituserDao;
    private SuppowerDao suppowerDao;
    private Zf_powerDao zf_powerDao;

    public void setZf_powerDao(Zf_powerDao zf_powerDao) {
        this.zf_powerDao = zf_powerDao;
    }

    public void setSuppowerDao(SuppowerDao suppowerDao) {
        this.suppowerDao = suppowerDao;
    }

    public void setCatalogDao(DataCatalogDao dao) {
        this.catalogDao = dao;
    }

    public void setDictionaryDao(DataDictionaryDao dao) {
        this.dictionaryDao = dao;
    }

    private static final Log log = LogFactory
            .getLog(CodeRepositoryManager.class);

    public void setUnituserDao(UserUnitDao userunitdao) {
        this.unituserDao = userunitdao;
    }

    public void setSysroleDao(RoleInfoDao roledao) {
        this.sysroledao = roledao;
    }

    public void setOptdefDao(OptDefDao pDao) {
        this.optdefdao = pDao;
    }

    public void setFunctionDao(OptInfoDao dao) {
        this.daoOptinfo = dao;
    }

    public void setSysUserDao(UserInfoDao dao) {
        this.daoUser = dao;
    }

    public void setSysUnitDao(UnitInfoDao dao) {
        this.daoUnit = dao;
    }

    // invoked by spring
    /*
     * (non-Javadoc)
     * 
     * @see com.centit.sys.service.CodeRepositoryManager#init()
     */
    public void refreshAll() {
        log.info("CodeRepository initializing...... ");
        /**
         * 最先初始化数据字典
         * 
         * @param catalogCode
         */
        List<FDatacatalog> datalist = catalogDao.listObjects();//
        REPOSITORIES.clear();
        DATACATALOG.clear();
        DATACATALOG.add(new LabelValueBean("系统用户", "usercode"));
        DATACATALOG.add(new LabelValueBean("系统机构", "unitcode"));

        if (datalist != null)
            for (Iterator<FDatacatalog> it = datalist.iterator(); it.hasNext();) {
                FDatacatalog dc = it.next();
                DATACATALOG.add(new LabelValueBean(dc.getCatalogname(), dc
                        .getCatalogcode()));
                refresh(dc.getCatalogcode());
            }
        DATACATALOG.add(new LabelValueBean("用户角色", "rolecode"));
        DATACATALOG.add(new LabelValueBean("系统业务", "optid"));
        DATACATALOG.add(new LabelValueBean("业务操作", "optcode"));

        refresh("usercode");
        refresh("loginName");
        refresh("unitcode");
        refresh("depno");
        refresh("userunit");// 必需在 usercode 、 unitcode 和数据字典的后面
        refresh("rolecode");
        refresh("optid");
        refresh("optcode");
        refresh("suppowerId");
        refresh("zf_powerid");
        log.info("CodeRepository initialized!");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.centit.sys.service.CodeRepositoryManager#refreshCodeRepository(java
     * .lang.String)
     */

    public void refreshCodeRepository(String catalogCode) {
        synchronized (this) {
            List<FDatadictionary> codeRepository = REPOSITORIES
                    .get(catalogCode);
            if (codeRepository != null)
                codeRepository.clear();
            List<FDatadictionary> list = dictionaryDao
                    .findByCdtbnm(catalogCode);
            REPOSITORIES.put(catalogCode, list);
            /*
             * codeRepository.addAll(dictionaryDao.findByCdtbnm(catalogCode);
             * List<FDatadictionary> list =
             * dictionaryDao.findByCdtbnm(catalogCode);
             * 
             * for (Iterator<FDatadictionary> it = list.iterator();
             * it.hasNext();) { FDatadictionary dict = it.next();
             * codeRepository.put(dict.getKey(),dict); }
             */
        }

    }

    public void refresh(String sCatalog) {

        if (sCatalog.equalsIgnoreCase("usercode")) {
            USERREPO.clear();

            List<FUserinfo> userList = daoUser.listObjects();//
            if (userList != null)
                for (FUserinfo ui : userList) {
                    USERREPO.put(ui.getUsercode(), ui);
                }
            return;
        }
        if (sCatalog.equalsIgnoreCase("loginName")) {
            LOGINEPO.clear();

            List<FUserinfo> userList = daoUser.listObjects();//
            if (userList != null)
                for (FUserinfo ui : userList) {
                    LOGINEPO.put(ui.getLoginname(), ui);
                }
            return;
        }
        if (sCatalog.equalsIgnoreCase("suppowerId")) {
            SUPPOWERREPO.clear();
            List<Suppower> powerList = suppowerDao.getlistSuppower("");
            if (powerList != null)
                for (Suppower ui : powerList) {
                    SUPPOWERREPO.put(ui.getItemId(), ui);
                }
            return;
        }

        if (sCatalog.equalsIgnoreCase("zf_powerid")) {
            ZFPOWERREPO.clear();
            List<Zf_power> powerList = zf_powerDao.getlistZfpower();
            if (powerList != null)
                for (Zf_power ui : powerList) {
                    ZFPOWERREPO.put(ui.getItemId(), ui);
                }
            return;
        }
        if (sCatalog.equalsIgnoreCase("unitcode")) {
            UNITREPO.clear();

            List<FUnitinfo> unitList = daoUnit.listObjects();
            if (unitList != null)
                for (FUnitinfo unitinfo : unitList) {
                    UNITREPO.put(unitinfo.getUnitcode(), unitinfo);
                }
            /**
             * 计算所有机构的子机构。只计算启动的机构
             */
            for (Map.Entry<String, FUnitinfo> ent : UNITREPO.entrySet()) {
                FUnitinfo u = ent.getValue();
                String sParentUnit = u.getParentunit();
                if ("T".equals(u.getIsvalid())
                        && (sParentUnit != null && (!"".equals(sParentUnit)) && (!"0"
                                .equals(sParentUnit)))) {
                    FUnitinfo pU = UNITREPO.get(sParentUnit);
                    if (pU != null)
                        pU.getSubUnits().add(u.getUnitcode());
                }
            }
            return;
        }
        if (sCatalog.equalsIgnoreCase("depno")) {
            DEPNO.clear();

            List<FUnitinfo> unitList = daoUnit.listObjects();
            if (unitList != null)
                for (FUnitinfo unitinfo : unitList) {
                    DEPNO.put(unitinfo.getDepno(), unitinfo);
                }
            /**
             * 计算所有机构的子机构。只计算启动的机构
             */
            for (Map.Entry<String, FUnitinfo> ent : DEPNO.entrySet()) {
                FUnitinfo u = ent.getValue();
                String sParentUnit = u.getParentunit();
                if ("T".equals(u.getIsvalid())
                        && (sParentUnit != null && (!"".equals(sParentUnit)) && (!"0"
                                .equals(sParentUnit)))) {
                    FUnitinfo pU = DEPNO.get(sParentUnit);
                    if (pU != null)
                        pU.getSubUnits().add(u.getUnitcode());
                }
            }
            return;
        }
        if (sCatalog.equalsIgnoreCase("userunit")) {

            List<FUserunit> userUnits = unituserDao.listObjects();
            USERUNIT.clear();
            USERUNIT.addAll(userUnits);

            for (FUserunit uu : USERUNIT) {
                String userCode = uu.getUsercode();
                String unitCode = uu.getUnitcode();
                // 设置行政角色等级
                FDatadictionary dd = CodeRepositoryUtil.getDataPiece(
                        "RankType", uu.getUserrank());
                if (dd != null && dd.getExtracode() != null
                        && StringRegularOpt.isNumber(dd.getExtracode())) {
                    try {
                        uu.setXzRank(Integer.valueOf(dd.getExtracode()));
                    } catch (Exception e) {
                        uu.setXzRank(CodeRepositoryUtil.MAXXZRANK);
                    }

                }
                FUnitinfo uint = UNITREPO.get(unitCode);
                if (uint != null) {
                    uint.getSubUserUnits().add(uu);
                    // 设置主机构
                    FUserinfo ui = USERREPO.get(userCode);
                    if (ui != null
                            && (ui.getPrimaryUnit() == null || "T".equals(uu
                                    .getIsprimary()))) {
                        ui.setPrimaryUnit(unitCode);
                    }
                }
            }

            return;
        }

        if (sCatalog.equalsIgnoreCase("rolecode")) {
            ROLEREPO.clear();// = new HashMap<String, FRoleinfo>();
            List<FRoleinfo> roleList = sysroledao.listObjects();
            for (Iterator<FRoleinfo> it = roleList.iterator(); it.hasNext();) {
                FRoleinfo roleinfo = it.next();
                ROLEREPO.put(roleinfo.getRolecode(), roleinfo);
            }
            return;
        }

        if (sCatalog.equalsIgnoreCase("optid")) {
            OPTREPO.clear();// = new HashMap<String, FOptinfo>();
            List<FOptinfo> optList = daoOptinfo.listObjects();
            if (optList != null) {
                for (Iterator<FOptinfo> it = optList.iterator(); it.hasNext();) {
                    FOptinfo optinfo = it.next();
                    OPTREPO.put(optinfo.getOptid(), optinfo);
                }
            }
            return;
        }

        if (sCatalog.equalsIgnoreCase("optcode")) {
            POWERREPO.clear();// = new HashMap<String, FOptdef>();
            List<FOptdef> optdefList = optdefdao.listObjects();
            for (Iterator<FOptdef> it = optdefList.iterator(); it.hasNext();) {
                FOptdef optdef = it.next();
                POWERREPO.put(optdef.getOptcode(), optdef);
            }
            return;
        }

        refreshCodeRepository(sCatalog);
    }

}
