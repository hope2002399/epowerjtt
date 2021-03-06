package com.centit.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.sys.dao.UnitInfoDao;
import com.centit.sys.dao.UserUnitDao;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.po.FUserunitId;
import com.centit.sys.service.SysUnitManager;

public class SysUnitManagerImpl extends BaseEntityManagerImpl<FUnitinfo>
        implements SysUnitManager {
    private static final long serialVersionUID = 1L;
    private UnitInfoDao sysunitdao;
    private UserUnitDao unituserDao;

    public void setSysunitdao(UnitInfoDao unitdao) {
        setBaseDao(unitdao);
        this.sysunitdao = unitdao;
    }

    public void setUnituserDao(UserUnitDao userunitdao) {
        this.unituserDao = userunitdao;
    }

    public List<FUnitinfo> getSubUnits(String superUnitID) {
        return sysunitdao.getSubUnits(superUnitID);

    }

    public List<FUnitinfo> getAllSubUnits(String superUnitID) {
        return sysunitdao.getAllSubUnits(superUnitID);
    }

    public Map<String, FUnitinfo> listObjectToUnitRepo() {
        Map<String, FUnitinfo> unitRepo = new HashMap<String, FUnitinfo>();
        List<FUnitinfo> unitList = listObjects();
        if (unitList != null)
            for (FUnitinfo unitinfo : unitList) {
                unitRepo.put(unitinfo.getUnitcode(), unitinfo);
            }
        /**
         * 计算所有机构的子机构。只计算启动的机构
         */
        for (Map.Entry<String, FUnitinfo> ent : unitRepo.entrySet()) {
            FUnitinfo u = ent.getValue();
            String sParentUnit = u.getParentunit();
            if ("T".equals(u.getIsvalid())
                    && (sParentUnit != null && (!"".equals(sParentUnit)) && (!"0"
                            .equals(sParentUnit)))) {
                FUnitinfo pU = unitRepo.get(sParentUnit);
                if (pU != null)
                    pU.getSubUnits().add(u.getIsvalid());
            }
        }

        return unitRepo;
    }

    /***
     * 查找对象，如果没有新建一个空对象，并附一个默认的编码
     */
    public FUnitinfo getObject(FUnitinfo object) {
        FUnitinfo newObj = sysunitdao.getObjectById(object.getUnitcode());
        if (newObj == null) {
            newObj = object;
            newObj.setUnitcode(sysunitdao.getNextKey());
            newObj.setIsvalid("T");
        }
        return newObj;
    }

    public List<FUserunit> getSysUsersByUnitId(String unitCode) {
        return sysunitdao.getSysUsersByUnitId(unitCode);
    }

    public List<FUserinfo> getUnitUsers(String unitCode) {
        return sysunitdao.getUnitUsers(unitCode);
    }

    public List<FUserunit> getSysUnitsByUserId(String userId) {
        return sysunitdao.getSysUnitsByUserId(userId);
    }

    public List<FUserinfo> getRelationUsers(String unitCode) {
        return sysunitdao.getRelationUsers(unitCode);
    }

    public FUserunit findUnitUserById(FUserunitId id) {
        return unituserDao.getObjectById(id);
    }

    public void saveUnitUser(FUserunit object) {
        unituserDao.saveObject(object);

    }

    public String getUnitCode(String depno) {
        return sysunitdao.getUnitCode(depno);
    }

    public String getNextKey() {
        return sysunitdao.getNextKey();
    }

    public void deleteUnitUser(FUserunitId id) {
        unituserDao.deleteObjectById(id);

    }

    public List<FUserunit> getSysUsersByRoleAndUnit(String roleType,
            String roleCode, String unitCode) {
        return unituserDao.getSysUsersByRoleAndUnit(roleType, roleCode,
                unitCode);
    }

    /**
     * 获取全部机构JSON数据
     * 
     * @return
     */
    public String getAllUnitsJSON() {
        List<FUnitinfo> unitList = sysunitdao.listObjects();
        return unitList2JSON(unitList);
    }

    /**
     * 根据当前机构编号，获取下级所有机构
     * 
     * @param ParentID
     * @return
     */
    public String getAllSubUnitsJSON(String unitCode) {
        List<FUnitinfo> unitList = sysunitdao.getAllSubUnits(unitCode);
        return unitList2JSON(unitList);
    }

    /**
     * 机构列表转换为Json对象
     * 
     * @param unitList
     * @return
     */
    private String unitList2JSON(List<FUnitinfo> unitList) {

        if (unitList == null) {
            return "";
        }

        JSONArray jsonArr = new JSONArray();
        for (FUnitinfo unitInfo : unitList) {

            // 如果机构名称为空，则不放入JSON对象
            if (unitInfo.getUnitname() == null
                    || unitInfo.getUnitname().equals("")) {
                continue;
            }

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("MID", unitInfo.getUnitcode());// 菜单编号
            jsonObj.put("ParentID", unitInfo.getParentunit());// 父级菜单编号
            jsonObj.put("MText", unitInfo.getUnitname());// 菜单名称
            jsonObj.put("depno", unitInfo.getDepno()); // 部门编号扩展
            jsonArr.add(jsonObj);
        }
        return jsonArr.toString();
    }

}
