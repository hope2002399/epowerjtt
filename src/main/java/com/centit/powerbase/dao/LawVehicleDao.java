package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.powerbase.po.LawVehicle;

public class LawVehicleDao extends BaseDaoImpl<LawVehicle> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawVehicleDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("vehicleId", CodeBook.EQUAL_HQL_ID);

            filterField.put("plateNumber", CodeBook.LIKE_HQL_ID);

            filterField.put("vehicleType", CodeBook.LIKE_HQL_ID);

            filterField.put("purchaseDate", CodeBook.LIKE_HQL_ID);

            filterField.put("purchasePrice", CodeBook.LIKE_HQL_ID);

            filterField.put("engineNo", CodeBook.LIKE_HQL_ID);

            filterField.put("carframeNo", CodeBook.LIKE_HQL_ID);

            filterField.put("ownerUnit", CodeBook.LIKE_HQL_ID);

            filterField.put("vehicleAdmin", CodeBook.LIKE_HQL_ID);

            filterField.put("recordDate", CodeBook.LIKE_HQL_ID);

            filterField.put("recorder", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public String generateNextVehicleId() {
        String sKey = getNextValueOfSequence("s_VehicleId");

        return sKey;

    }

    public boolean IsplateNumberExist(String plateNumber) {
        if (plateNumber != null) {
            List<LawVehicle> procs = this
                    .listObjects("From LawVehicle where plateNumber =  "
                            + HQLUtils.buildHqlStringForSQL(plateNumber));
            if (procs != null && procs.size() >= 1)
                return true;
        }
        return false;

    }
}
