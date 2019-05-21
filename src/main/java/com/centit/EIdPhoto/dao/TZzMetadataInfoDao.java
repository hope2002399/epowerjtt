package com.centit.EIdPhoto.dao;

import java.util.List;

import com.centit.EIdPhoto.po.TZzMetadataInfo;
import com.centit.core.dao.BaseDaoImpl;

public class TZzMetadataInfoDao extends BaseDaoImpl<TZzMetadataInfo> {

    
    /**
     * 
     */
    private static final long serialVersionUID = -4832865526775468190L;

    @Override
    public List<TZzMetadataInfo> listObjects(String mouldId) {
        
        String hql = "from TZzMetadataInfo where 1=1";
        if(mouldId != null && !"".equals(mouldId.trim())){
            hql = hql + " and mouldId = '" + mouldId + "'";
        }
        
        return super.listObjects(hql);
    }  
}
