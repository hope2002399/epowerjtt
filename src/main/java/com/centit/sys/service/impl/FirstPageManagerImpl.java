package com.centit.sys.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.sys.dao.FirstPageDao;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.FirstPageManager;

public class FirstPageManagerImpl extends BaseEntityManagerImpl<FOptinfo>
        implements FirstPageManager {
    private static final long serialVersionUID = 1L;
    private FirstPageDao firstPageDao;

    private int minvalue = 0;
    private int maxvalue = 0;

    public void setFirstPageDao(FirstPageDao dao) {
        setBaseDao(dao);
        this.firstPageDao = dao;
    }

    @Override
    public String getXknum(String yyyymm) {
        
        return firstPageDao.getAreaXkNum(null, yyyymm);
    }

    @Override
    public String getCfnum(String yyyymm) {
        
        return firstPageDao.getAreaCfNum(null, yyyymm);
    }

    @Override
    public String getYjnum(String yyyymm) {
        
        return firstPageDao.getYjnum(yyyymm);
    }

    @Override
    public String getDbnum(String yyyymm) {
        
        return firstPageDao.getDbnum(yyyymm);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Map<String, String>> getAreaNum(Map map) {
        
        String yyyymm = (String) map.get("yyyymm");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<FDatadictionary> listd = CodeRepositoryUtil
                .getDictionary("areacode");
        Map<String, String> tempmap = null;
        for (int i = 0; i < listd.size(); i++) {
            tempmap = getAreaNumMap(listd.get(i).getDatacode(), yyyymm);
            int temp = Integer.valueOf(tempmap.get("value"));
            if (minvalue == 0) {
                minvalue = temp;
            }
            if (maxvalue == 0) {
                maxvalue = temp;
            }
            if (minvalue > temp) {
                minvalue = temp;
            }
            if (maxvalue < temp) {
                maxvalue = temp;
            }
            list.add(tempmap);
        }
        tempmap = new HashMap<String, String>();
        tempmap.put("minvalue", String.valueOf(minvalue));
        tempmap.put("maxvalue", String.valueOf(maxvalue));
        list.add(tempmap);

        return list;
    }

    private Map<String, String> getAreaNumMap(String areacode, String yyyymm) {
        Map<String, String> map = new HashMap<String, String>();
        String area = "";
        /*
         * if("JS01".equals(areacode)){ area="南京市"; }else
         * if("JS02".equals(areacode)){ area="无锡市"; }else
         * if("JS03".equals(areacode)){ area="徐州市"; }else
         * if("JS04".equals(areacode)){ area="常州市"; }else
         * if("JS05".equals(areacode)){ area="苏州市"; }else
         * if("JS06".equals(areacode)){ area="南通市"; }else
         * if("JS07".equals(areacode)){ area="连云港市"; }else
         * if("JS08".equals(areacode)){ area="淮安市"; }else
         * if("JS09".equals(areacode)){ area="盐城市"; }else
         * if("JS10".equals(areacode)){ area="扬州市"; }else
         * if("JS11".equals(areacode)){ area="镇江市"; }else
         * if("JS12".equals(areacode)){ area="泰州市"; }else
         * if("JS13".equals(areacode)){ area="宿迁市"; }
         */
        area = CodeRepositoryUtil.getValue("areacode", areacode);
        String xknum = firstPageDao.getAreaXkNum(areacode, yyyymm);
        String cfnum = firstPageDao.getAreaCfNum(areacode, yyyymm);
        int num = Integer.parseInt(xknum) + Integer.parseInt(cfnum);
        map.put("name", area);
        map.put("value", String.valueOf(num));
        return map;

    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Integer> getAreaXkNum(Map map) {
        String yyyymm = (String) map.get("yyyymm");
        List<Integer> list = new ArrayList<Integer>();
        List<FDatadictionary> listd = CodeRepositoryUtil
                .getDictionary("areacode");
        for (int i = 0; i < listd.size(); i++) {
            int temp = Integer.valueOf(firstPageDao.getAreaXkNum(listd.get(i)
                    .getDatacode(), yyyymm));

            list.add(temp);
        }

        return list;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Integer> getAreaCfNum(Map map) {
        String yyyymm = (String) map.get("yyyymm");
        List<Integer> list = new ArrayList<Integer>();
        List<FDatadictionary> listd = CodeRepositoryUtil
                .getDictionary("areacode");
        for (int i = 0; i < listd.size(); i++) {
            int temp = Integer.valueOf(firstPageDao.getAreaCfNum(listd.get(i)
                    .getDatacode(), yyyymm));

            list.add(temp);
        }

        return list;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Integer> getMonthNumByYear(Map map) {
        String yyyy = (String) map.get("yyyy");
        List<Integer> list = new ArrayList<Integer>();
        String[] yyyymm = new String[] { "01", "02", "03", "04", "05", "06",
                "07", "08", "09", "10", "11", "12" };
        DateFormat sdf = new SimpleDateFormat("yyyyMM");
        String thismonth = sdf.format(new Date(System.currentTimeMillis()));

        for (int i = 0; i < yyyymm.length; i++) {
            StringBuffer ym = new StringBuffer("");
            ym = ym.append(yyyy).append(yyyymm[i]);
            int temp1 = Integer.valueOf(firstPageDao.getAreaXkNum(null,
                    ym.toString()));
            int temp2 = Integer.valueOf(firstPageDao.getAreaCfNum(null,
                    ym.toString()));

            list.add(temp1 + temp2);
            if (thismonth.equals(ym.toString())) {
                break;
            }
        }

        return list;
    }

    @Override
    public List<Double> getAreaXkBjl(Map map) {
        String yyyymm = (String) map.get("yyyymm");
        List<Double> list = new ArrayList<Double>();
        List<FDatadictionary> listd = CodeRepositoryUtil
                .getDictionary("areacode");
        for (int i = 0; i < listd.size(); i++) {
            double temp = Double.parseDouble(firstPageDao.getAreaXkBjl(listd.get(i)
                    .getDatacode(), yyyymm));

            list.add(temp);
        }

        return list;
    }

    @Override
    public List<Double> getAreaCfBjl(Map map) {
        String yyyymm = (String) map.get("yyyymm");
        List<Double> list = new ArrayList<Double>();
        List<FDatadictionary> listd = CodeRepositoryUtil
                .getDictionary("areacode");
        for (int i = 0; i < listd.size(); i++) {
            double temp = Double.valueOf(firstPageDao.getAreaCfBjl(listd.get(i)
                    .getDatacode(), yyyymm));

            list.add(temp);
        }

        return list;
    }

}
