package com.centit.powerruntime.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerbase.po.PowerOrgInfo;
import com.centit.powerruntime.po.VPowerOrgInfo;

public class VPowerOrgInfoDao extends BaseDaoImpl<PowerOrgInfo> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VPowerOrgInfoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("itemId", CodeBook.LIKE_HQL_ID);
            filterField.put("unitcode", CodeBook.LIKE_HQL_ID);
            filterField.put("wfcode", CodeBook.LIKE_HQL_ID);
            filterField.put("setoperator", CodeBook.LIKE_HQL_ID);
            filterField.put("setime", CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }

    public List<VPowerOrgInfo> listOfReadyPowerOrgInfoList(PowerOrgInfo o) {
        String hql = "from VPowerOrgInfo where unitcode = ?";
        @SuppressWarnings("unchecked")
        List<VPowerOrgInfo> sqclList = (List<VPowerOrgInfo>) this
                .findObjectsByHql(hql, o.getCid().getUnitcode());

        return sqclList;
    }

    @SuppressWarnings("unchecked")
    public List<VPowerOrgInfo> listOfAllPowerOrgInfoList(PowerOrgInfo o) {
        List<VPowerOrgInfo> list = new ArrayList<VPowerOrgInfo>();
        String sSqlsen = "select t.item_id, t.item_name,t.item_type from suppower t where t.isinuse = '1' and t.ql_state = 'A' ";
        if (StringUtils.isNotBlank(o.getUnitcode())) {
            sSqlsen += " and t.item_id not in (select p.item_id  from c_power_org_info p where p.unitcode='"
                    + o.getUnitcode() + "')";
        }
        if (StringUtils.isNotBlank(o.getItem_type())) {
            sSqlsen += " and item_type='" + o.getItem_type() + "'";
        }
        List<Object[]> l = findObjectsBySql(sSqlsen);
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Object[] O = (Object[]) l.get(i);
                VPowerOrgInfo po = new VPowerOrgInfo(); 
                po.setItemId((String) O[0]);
                po.setItemName((String) O[1]);
                list.add(po);
            }
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    public List<VPowerOrgInfo> listOfPowerOrgInfoList(PowerOrgInfo object) {
        String hql = "from VPowerOrgInfo where cid.itemId = ?";
        return (List<VPowerOrgInfo>) this.findObjectsByHql(hql,
                object.getItemId());
    }
}
