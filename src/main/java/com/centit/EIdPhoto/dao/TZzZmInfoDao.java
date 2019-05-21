package com.centit.EIdPhoto.dao;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessResourceFailureException;

import com.centit.EIdPhoto.po.TZzZmInfo;
import com.centit.EIdPhoto.po.TZzZmdyInfo;
import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.HqlAndParams;
import com.centit.core.dao.SQLQueryCallBack;
import com.centit.core.utils.PageDesc;
import com.ibm.icu.text.SimpleDateFormat;

public class TZzZmInfoDao extends BaseDaoImpl<TZzZmInfo> {

    /**
     * 
     */
    private static final long serialVersionUID = -7633072450788744539L;
    
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public void insertTZzZmInfo(TZzZmInfo appret){
       /* try {
            //InputStream div = new FileInputStream(appret.getDividuation());
            //Reader reader = new FileReader(appret.getDividuation()); 
            //appret.setInDividuation(Hibernate.getLobCreator(getSession()).createClob(reader,appret.getDividuation().length()));
            //appret.setZzFile(Hibernate.getLobCreator(getSession()).createBlob(div,appret.getZzFiles().length()));
            
            //div.close();
            //reader.close();
        } catch (DataAccessResourceFailureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch blo
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
       /* String inssql="insert into T_ZZ_ZM_INFO (ID, MOULD_ID, DZZZ_NO, ZZ_BH, BZ_DATE, STAR_TIME, END_TIME, DEPT_NAME, USER_NAME, USER_TYPE, USER_ZJ_TYPE, USER_N0, ZZ_TYPE, INDIVIDUATION, ZZ_FILE,CREATE_DATE,STATE,STATUS)"
                    + "values ('" + appret.getId() + "','" + appret.getMouldId() + "','"  + appret.getDzzzNo()!=null?appret.getDzzzNo():"" + "','"
                    + appret.getZzBh()!=null?appret.getZzBh():"" + "',to_date('" + format.format(appret.getBzDate()) + "','yyyy-MM-dd hh24:mi:ss'),to_date('" + format.format(appret.getStartTime()) + "','yyyy-MM-dd hh24:mi:ss'),to_date('"
                    + format.format(appret.getEndTime()) + "','yyyy-MM-dd hh24:mi:ss'),'" + appret.getDeptName() + "','" + appret.getUserName() + "','"
                    + appret.getUserType() + "','" + appret.getUserZjType() + "','"
                    + appret.getUserNo() + "','" + appret.getZzType() + "','" + appret.getInDividuation() + "','" + appret.getZzFile() + "',sysdate,'" + appret.getState() + "','" + appret.getStatus() + "')";
        super.doExecuteSql(inssql);*/
        appret.setBzDate(new Date());
        appret.setZzFile(Hibernate.getLobCreator(getSession()).createBlob(appret.getZzFiles()));
        appret.setCreateDate(new Date());
        Transaction ts = getSession().beginTransaction();
        LobHelper lobHelper = getSession().getLobHelper(); 
        Clob clob = lobHelper.createClob(appret.getDividuation());
        appret.setInDividuation(clob);
        try {
            getSession().save(appret);
            ts.commit();
        } catch (Exception e) {
            System.out.println(e);
            ts.rollback();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TZzZmInfo> listObjects(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        String shql = " from t_zz_zm_info where 1=1 ";
        String queryUnderUnit = "";
        if(filterMap.get("dzzzNo") != null && !"".equals(filterMap.get("dzzzNo").toString().trim())){
            shql = shql + " and dzzz_no like '%" + filterMap.get("dzzzNo") + "%'";
        }
        HqlAndParams hql = builderHqlAndParams(shql, filterMap);

        String hql1 = "select * " + hql.getHql() + queryUnderUnit;
        String hql2 = "select count(*) " + hql.getHql() + queryUnderUnit;
        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();
        List<TZzZmInfo> list = null;
        try {

            list = getHibernateTemplate().executeFind(
                    new SQLQueryCallBack(hql1, hql.getParams(), startPos,
                            maxSize, TZzZmInfo.class));
            pageDesc.setTotalRows(new Integer(getHibernateTemplate()
                    .executeFind(new SQLQueryCallBack(hql2, hql.getParams()))
                    .get(0).toString()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return list;
    }  
}
