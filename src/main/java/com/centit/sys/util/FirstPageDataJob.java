package com.centit.sys.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.centit.sys.service.FirstPageManager;

public class FirstPageDataJob extends QuartzJobBean {
    private FirstPageManager firstPageManager;

    public FirstPageManager getFirstPageManager() {
        return firstPageManager;
    }

    public void setFirstPageManager(FirstPageManager firstPageManager) {
        this.firstPageManager = firstPageManager;
    }

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        
        System.out
                .println("--------------------begin---------------------------");

        selectFirstPageData();

        System.out
                .println("--------------------end---------------------------");
    }

    public void selectFirstPageData() {
        
        String path = this.getClass().getResource("/").getPath();
        path = path.substring(0, path.length() - 16);
        System.out.println(path);

        // 地图数据
        DateFormat sdf = new SimpleDateFormat("yyyyMM");
        String yyyymm = sdf.format(new Date(System.currentTimeMillis()));
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("yyyymm", yyyymm);
        List<Map<String, String>> list = firstPageManager.getAreaNum(map);
        map = (HashMap<String, String>) list.get(list.size() - 1);
        list.remove(list.size() - 1);

        JSONArray json = JSONArray.fromObject(list);

        try {
            // FileWriter writer=new FileWriter(path +"/media/firstpagemap.js");
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(path + "/media/firstpagemap.js"),
                    "UTF-8");

            writer.write("var mapData=" + json.toString() + ";");
            writer.write("var minvalue=" + map.get("minvalue") + ";");
            writer.write("var maxvalue=" + map.get("maxvalue") + ";");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 同比月度数据
        DateFormat sdf1 = new SimpleDateFormat("yyyy");

        String thisyear = sdf1.format(new Date(System.currentTimeMillis()));

        map = new HashMap<String, String>();
        map.put("yyyy", thisyear);
        List<Integer> listthis = firstPageManager.getMonthNumByYear(map);
        JSONArray jsonthis = JSONArray.fromObject(listthis);

        String lastyear = String.valueOf(Integer.parseInt(thisyear) - 1);
        map = new HashMap<String, String>();
        map.put("yyyy", lastyear);
        List<Integer> listlast = firstPageManager.getMonthNumByYear(map);
        JSONArray jsonlast = JSONArray.fromObject(listlast);

        try {
            // FileWriter writer=new FileWriter(path+"/media/firstpageline.js");
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(path + "/media/firstpageline.js"),
                    "UTF-8");
            writer.write("var listthis=" + jsonthis.toString() + ";");
            writer.write("var listlast=" + jsonlast.toString() + ";");
            writer.write("var thisyear=" + thisyear + ";");
            writer.write("var lastyear=" + lastyear + ";");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 堆积图数据
        sdf = new SimpleDateFormat("yyyyMM");
        yyyymm = sdf.format(new Date(System.currentTimeMillis()));
        // yyyymm="201404";
        map = new HashMap<String, String>();
        map.put("yyyymm", yyyymm);
        List<Integer> listxk = firstPageManager.getAreaXkNum(map);
        List<Integer> listcf = firstPageManager.getAreaCfNum(map);

        JSONArray jsonxk = JSONArray.fromObject(listxk);
        JSONArray jsoncf = JSONArray.fromObject(listcf);

        try {
            // FileWriter writer=new FileWriter(path+"/media/firstpagebar.js");
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(path + "/media/firstpagebar.js"),
                    "UTF-8");

            writer.write("var listxk=" + jsonxk.toString() + ";");
            writer.write("var listcf=" + jsoncf.toString() + ";");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        List<Double> listxkbjl = firstPageManager.getAreaXkBjl(map);
        List<Double> listcfbjl = firstPageManager.getAreaCfBjl(map);

        JSONArray jsonxkbjl = JSONArray.fromObject(listxkbjl);
        JSONArray jsoncfbjl = JSONArray.fromObject(listcfbjl);

        try {
            // FileWriter writer=new FileWriter(path+"/media/firstpagebar.js");
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(path + "/media/firstpageline2.js"),
                    "UTF-8");

            writer.write("var listthis=" + jsonxkbjl.toString() + ";");
            writer.write("var listlast=" + jsoncfbjl.toString() + ";");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
