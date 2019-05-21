package com.centit.punish.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoradixbasicDao;
import com.centit.punish.po.Poradixbasic;
import com.centit.punish.service.PoradixbasicManager;

public class PoradixbasicManagerImpl extends
        BaseEntityManagerImpl<Poradixbasic> implements PoradixbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoradixbasicManager.class);

    private PoradixbasicDao poradixbasicDao;

    public void setPoradixbasicDao(PoradixbasicDao baseDao) {
        this.poradixbasicDao = baseDao;
        setBaseDao(this.poradixbasicDao);
    }

    public String generateNextPoRadixId() {
        return poradixbasicDao.generateNextPoRadixId();

    }

    // 以前是用存储过程实现,现改为程序内实现,PORADIXBASIC表较之于老系统增加RADIXID为主键,老系统为无主键表;
    public void initRadixBasic(String punishObjectID, String item_id) {
        String sql = " select t.degreeNo,'scar' from b_freeumpiredegree t where t.item_id='"
                + item_id
                + "' and t.isInUse=1 "
                + "and t.version=(select max(b.version) as version from b_power b where b.item_id = t.item_id)  ";
        List<Object[]> l = poradixbasicDao.findObjectsBySql(sql);
        int degreenum = 0;
        if (l != null && l.size() > 0) {
            Object[] count = (Object[]) l.get(0);
            degreenum = Integer.parseInt(count[0].toString());
        }

        if (degreenum > 0) {
            String sql2 = "select distinct punishTypeID,DEGREENO from b_freeumpiretype where 1=1 and DEGREENO="
                    + degreenum;// +" and israte='1'";
            List<Object[]> l2 = poradixbasicDao.findObjectsBySql(sql2);
            for (Object[] o : l2) {
                String radixid = this.generateNextPoRadixId();
                Poradixbasic saveobject = new Poradixbasic();
                saveobject.setRadixid(Long.parseLong(radixid));
                saveobject.setPunishobjectid(punishObjectID);
                saveobject.setItem_id(item_id);
                saveobject.setPunishtypeid(o[0].toString());
                saveobject.setDegreeno(Long.parseLong(o[1].toString()));
                this.saveObject(saveobject);
            }
        } else {
            String sql3 = "select t.punishTypeID,0 from B_PunishStandard t where t.item_id='"
                    + item_id
                    + "' and t.version=(select max(b.version) as version from b_power b where b.item_id = t.item_id)";// +" and isRate=1";
            List<Object[]> l3 = poradixbasicDao.findObjectsBySql(sql3);
            if (l3 != null && l3.size() > 0) {
                for (Object[] o : l3) {
                    String radixid = this.generateNextPoRadixId();
                    Poradixbasic saveobject = new Poradixbasic();
                    saveobject.setRadixid(Long.parseLong(radixid));
                    saveobject.setPunishobjectid(punishObjectID);
                    saveobject.setItem_id(item_id);
                    saveobject.setPunishtypeid(o[0].toString());
                    saveobject.setDegreeno((long) 0);
                    this.saveObject(saveobject);
                }
            }
        }
    }

    public String getDatavalueFromFdic(String catalogcode, String datacode) {
        return this.poradixbasicDao.getDatavalueFromFdic(catalogcode, datacode);
    }

    @Override
    public boolean deleteObjectBypunishObjectID(String punishobjectid) {
        return poradixbasicDao.deleteObjectBypunishObjectID(punishobjectid);

    }

    public String getDataCodeFromFdic(String catalogcode, String extracode) {
        return this.poradixbasicDao.getDataCodeFromFdic(catalogcode, extracode);
    }

    public Poradixbasic getRadixBasic(String punishobjectid,
            String punishtypeid, String punishclassid) {
        return this.poradixbasicDao.getRadixBasic(punishobjectid, punishtypeid,
                punishclassid);
    }

    /**
     * 根据处罚流水号获取对应基数信息
     */
    @Override
    public Poradixbasic getRadixBasicByPunishobjectid(String punishobjectid) {
        
        return poradixbasicDao.getRadixBasicByPunishobjectid(punishobjectid);
    }

}
