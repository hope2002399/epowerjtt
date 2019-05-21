package com.centit.sys.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.centit.core.action.BaseAction;
import com.centit.support.utils.StringRegularOpt;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.Usersetting;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.FirstPageManager;
import com.centit.sys.service.FunctionManager;
import com.centit.sys.service.SysUserManager;
import com.opensymphony.xwork2.ActionContext;

public class MainFrameAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    private FunctionManager functionMgr;
    private String userFirstPage;
    private SysUserManager sysUserManager;

    private FirstPageManager firstPageManager;

    public FirstPageManager getFirstPageManager() {
        return firstPageManager;
    }

    public void setFirstPageManager(FirstPageManager firstPageManager) {
        this.firstPageManager = firstPageManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    // private String superFunctionId;
    public String getUserFirstPage() {
        return userFirstPage;
    }

    public void setUserFirstPage(String userFirstPage) {
        this.userFirstPage = userFirstPage;
    }

    public void setFunctionMgr(FunctionManager functionMgr) {
        this.functionMgr = functionMgr;
    }

    public String showMain() throws Exception {

        FUserDetail uinfo = ((FUserDetail) getLoginUser());
        if ("noname".equals(uinfo.getUsercode())) {
            return loginError();
        }
        Usersetting us = uinfo.getUserSetting();

        try {
            if (StringUtils.isEmpty(us.getMainpage())) {
                FOptinfo f = (FOptinfo) functionMgr.getFunctionsByUser(uinfo)
                        .get(0);
                us.setMainpage(f.getOpturl());
            }
        } catch (Exception e) {
        }

        Map<String, Object> session = ActionContext.getContext().getSession();
        String stylePath = request.getContextPath() + "/styles/"
                + us.getPagestyle();
        session.put("STYLE_PATH", stylePath);
        userFirstPage = '/' + us.getMainpage();
        request.setAttribute("firstPage", userFirstPage);
        session.put("LAYOUT", us.getFramelayout());
        // 当前用户所能获取菜单
        ActionContext.getContext().put(
                "OA_MENUS",
                this.getFunctionsByUserCode(((FUserinfo) super.getLoginUser())
                        .getUsercode()));

        String url = request.getParameter("url");
        request.setAttribute("url", url);

        return "MainPage";
    }

    /**
     * 通过Ajax请求获取当前菜单下所有子菜单
     * 
     * @param superFunctionId
     * @return
     */
    public String getSuperFunc() {
        String superFunctionId = this.request.getParameter("superFunctionId");
        if (!org.springframework.util.StringUtils.hasText(superFunctionId)) {
            return getMenuFunc(new ArrayList<FOptinfo>());
        }

        FUserinfo user = new FUserinfo();
        user.setUsercode(((FUserinfo) this.getLoginUser()).getUsercode());
        List<FOptinfo> menuFunsByUser = this.functionMgr
                .getMenuFuncByUserIDAndSuperFunctionId(user, superFunctionId);

        return getMenuFunc(menuFunsByUser);
    }

    private String getFunctionsByUserCode(String usercode) {
        FUserinfo user = new FUserinfo();

        user.setUsercode(((FUserinfo) this.getLoginUser()).getUsercode());
        List<FOptinfo> menuFunsByUser = this.functionMgr
                .getMenuFuncByUser(user);

        // user.setUsercode(usercode);
        // List<FOptinfo>
        // menuFunsByUser=this.functionMgr.getMenuFuncByUserIDAndSuperFunctionId(user,
        // superFunctionId);
        return getMenuFunc(menuFunsByUser);
    }

    @SuppressWarnings("unused")
    private String getMenuFunc(List<FOptinfo> menuFunsByUser) {
        Map<String, List<Map<String, String>>> result = new HashMap<String, List<Map<String, String>>>();

        // List<Map<String, String>> menuHeader = new ArrayList<Map<String,
        // String>>();
        List<Map<String, String>> menuList = new ArrayList<Map<String, String>>();

        String usercode = ((FUserinfo) this.getLoginUser()).getUsercode();
        for (FOptinfo fOptinfo : menuFunsByUser) {
            Map<String, String> menu = new HashMap<String, String>();

            menu.put("MID", fOptinfo.getOptid());
            menu.put("MText", fOptinfo.getOptname());
            menu.put("ParentID", fOptinfo.getPreoptid());
            // menu.put("MUrl", transformOptUrl(fOptinfo.getOpturl(),
            // usercode));
            menu.put("MUrl", fOptinfo.getOpturl());
            menu.put("MType", fOptinfo.getPageType());

            menuList.add(menu);

        }
        // result.put("menuHeader", menuHeader);
        result.put("menuList", menuList);

        return JSONObject.fromObject(result).toString();
    }

    /**
     * 转换菜单地址,带入usercode参数,目的是为了解决jttsunzw系统对接,在不需要对接jttsunzw时,菜单地址依然是optUrl,
     * 该方法作废
     * 
     * @param optUrl
     * @param usercode
     * @return
     */
    @SuppressWarnings("unused")
    private String transformOptUrl(String optUrl, String usercode) {
        if (!StringRegularOpt.isNvl(optUrl) && optUrl.length() > 3
                && !StringRegularOpt.isNvl(usercode)) {
            String url = null;
            if (optUrl.indexOf("?") < 0) {
                url = optUrl + "?usercode=" + usercode;
            } else {
                url = optUrl + "&usercode=" + usercode;
            }
            return url;
        } else {
            return optUrl;
        }
    }

    public String login() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (request.getParameter("inDialog") != null) {
            session.put("loginInDialog", "true");
            return "loginInDialog";
        } else {
            session.put("loginInDialog", "false");
            return "login";
        }
    }

    public String fgLogin() {
        String loginName = request.getParameter("loginName");
        FUserDetail uinfo = null;
        try {
            uinfo = sysUserManager.loadUserByUsername(loginName);
        } catch (Exception e) {
            return "login";
        }
        Usersetting us = uinfo.getUserSetting();

        try {
            if (StringUtils.isEmpty(us.getMainpage())) {
                FOptinfo f = (FOptinfo) functionMgr.getFunctionsByUser(uinfo)
                        .get(0);
                us.setMainpage(f.getOpturl());
            }
        } catch (Exception e) {
        }

        Map<String, Object> session = ActionContext.getContext().getSession();
        String stylePath = request.getContextPath() + "/styles/"
                + us.getPagestyle();
        session.put("STYLE_PATH", stylePath);
        userFirstPage = '/' + us.getMainpage();
        request.setAttribute("firstPage", userFirstPage);
        session.put("LAYOUT", us.getFramelayout());
        // 当前用户所能获取菜单
        ActionContext.getContext().put(
                "OA_MENUS",
                this.getFunctionsByUserCode(((FUserinfo) super.getLoginUser())
                        .getUsercode()));
        request.getSession().setAttribute("USERDETAIL", uinfo);
        return "MainPage";
    }

    public String loginError() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String inDialog = (String) session.get("loginInDialog");
        if (inDialog != null || "true".equals(inDialog)) {
            saveError("用户名或密码错误！");
            return "loginResInDialog";
        } else {
            saveError("用户名或密码错误！");
            return "loginError";
        }
    }

    public String captchaError() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String inDialog = (String) session.get("loginInDialog");
        if (inDialog != null || "true".equals(inDialog)) {
            saveError("验证码错误！");
            return "loginResInDialog";
        } else {
            saveError("验证码错误！");
            return "loginError";
        }
    }

    public String loginSuccess() throws Exception {

        Map<String, Object> session = ActionContext.getContext().getSession();
        String inDialog = (String) session.get("loginInDialog");
        if (inDialog != null)
            session.remove("loginInDialog");
        if (inDialog != null && "true".equals(inDialog)) {
            saveMessage("登录成功");
            return "loginResInDialog";
        } else {
            return "loginSuccess";
        }

        /*
         * 模块分别登录功能 Map<String, Object> session =
         * ActionContext.getContext().getSession(); String inDialog =
         * (String)session.get("loginInDialog"); //处理子系统S
         * superFunctionId=(String) session.get("sysType"); if(inDialog!=null)
         * session.remove("loginInDialog"); if(inDialog!=null &&
         * "true".equals(inDialog)){ saveMessage("登录成功"); return
         * "loginResInDialog"; }else{ //return "loginSuccess"; return
         * this.showMain(); }
         */
    }

    public String logincas() throws Exception {
        return "lgoinSuccess";
    }

    public String dashboard() throws Exception {

        return "dashboard";
    }

    /*
     * public String getSuperFunctionId() { return superFunctionId; }
     * 
     * public void setSuperFunctionId(String superFunctionId) {
     * this.superFunctionId = superFunctionId; }
     */

    public String showNewFirstPage() throws Exception {
        DateFormat sdf = new SimpleDateFormat("yyyyMM");

        String yyyymm = sdf.format(new Date(System.currentTimeMillis()));
        // yyyymm="201404";
        // System.out.println("查找年月"+yyyymm);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String firstdayofmonth = new SimpleDateFormat("yyyy-MM-dd").format(cal
                .getTime());

        String xknum = firstPageManager.getXknum(yyyymm);
        String cfnum = firstPageManager.getCfnum(yyyymm);
        ;
        String yjnum = firstPageManager.getYjnum(yyyymm);
        ;
        String dbnum = firstPageManager.getDbnum(yyyymm);
        ;

        request.setAttribute("xknum", xknum);
        request.setAttribute("cfnum", cfnum);
        request.setAttribute("yjnum", yjnum);
        request.setAttribute("dbnum", dbnum);
        request.setAttribute("firstdayofmonth", firstdayofmonth);

        return "newFirstPage";
    }
    /**
     * 地图
     * @return
     * @throws Exception
     */
    public String showFirstPageMap() throws Exception {
        
        DateFormat sdf=new SimpleDateFormat("yyyyMM"); 
        String yyyymm=sdf.format(new Date(System.currentTimeMillis()));
         //yyyymm="201404"; 
        Map map=new HashMap(); 
        map.put("yyyymm", yyyymm);
        List<Map<String,String>> list=firstPageManager.getAreaNum(map);
         
        map=list.get(13); 
        list.remove(13);
         
        JSONArray json = JSONArray.fromObject(list);
         
        request.setAttribute("minvalue", map.get("minvalue"));
        request.setAttribute("maxvalue", map.get("maxvalue"));
        request.setAttribute("list", json);
         
        List<FDatadictionary> listd = CodeRepositoryUtil
                .getDictionary("areacode");
        String rootcity1 = listd.get(0).getDatadesc();

        request.getSession().setAttribute("rootcity", rootcity1);
        if ("江苏".equals(rootcity1)) {
            return "firstPageMap";
        } else {
            return "firstPageMapForCity";
        }
    }

    /**
     * 折线图
     * @return
     * @throws Exception
     */
    public String showFirstPageLine() throws Exception {
        
          DateFormat sdf=new SimpleDateFormat("yyyy");
          
          
          String thisyear=sdf.format(new Date(System.currentTimeMillis()));
          
          Map map=new HashMap(); 
          map.put("yyyy", thisyear); 
          List<Integer> listthis=firstPageManager.getMonthNumByYear(map); 
          JSONArray jsonthis = JSONArray.fromObject(listthis);
          
          
          String lastyear=String.valueOf(Integer.parseInt(thisyear)-1); 
          map=new HashMap(); 
          map.put("yyyy", lastyear); 
          List<Integer> listlast=firstPageManager.getMonthNumByYear(map); 
          JSONArray jsonlast = JSONArray.fromObject(listlast);
          
          request.setAttribute("listthis", jsonthis);
          request.setAttribute("listlast", jsonlast);
          request.setAttribute("thisyear", thisyear);
          request.setAttribute("lastyear", lastyear);
         

        return "firstPageLine";
    }
    public String showFirstPageLine2() throws Exception {
        
//      DateFormat sdf=new SimpleDateFormat("yyyy");
//      
//      
//      String thisyear=sdf.format(new Date(System.currentTimeMillis()));
//      
//      Map map=new HashMap(); map.put("yyyy", thisyear); List<Integer>
//      listthis=firstPageManager.getMonthNumByYear(map); JSONArray jsonthis
//      = JSONArray.fromObject(listthis);
//      
//      
//      String lastyear=String.valueOf(Integer.parseInt(thisyear)-1); map=new
//      HashMap(); map.put("yyyy", lastyear); List<Integer>
//      listlast=firstPageManager.getMonthNumByYear(map); JSONArray jsonlast
//      = JSONArray.fromObject(listlast);
//      
//      request.setAttribute("listthis", jsonthis);
//      request.setAttribute("listlast", jsonlast);
//      request.setAttribute("thisyear", thisyear);
//      request.setAttribute("lastyear", lastyear);
     

    return "firstPageLine2";
}
    /**
     * 柱状图
     * @return
     * @throws Exception
     */
    public String showFirstPageBar() throws Exception {
        
         DateFormat sdf=new SimpleDateFormat("yyyyMM"); 
         String yyyymm=sdf.format(new Date(System.currentTimeMillis()));
         //yyyymm="201404"; 
         Map map=new HashMap(); 
         map.put("yyyymm", yyyymm);
         List<Integer> listxk=firstPageManager.getAreaXkNum(map);
         List<Integer> listcf=firstPageManager.getAreaCfNum(map);
         
         JSONArray jsonxk = JSONArray.fromObject(listxk); 
         JSONArray jsoncf = JSONArray.fromObject(listcf);
         
         request.setAttribute("listxk", jsonxk);
         request.setAttribute("listcf", jsoncf);
         
        List<FDatadictionary> listd = CodeRepositoryUtil
                .getDictionary("areacode");
        String[] cityname = new String[listd.size()];
        for (int i = 0; i < listd.size(); i++) {
            cityname[i] = listd.get(i).getDatavalue();
        }
        request.setAttribute("cityname", JSONArray.fromObject(cityname));
        return "firstPageBar";
    }

    
    public void selectFirstPageData() {
        // 地图数据
        DateFormat sdf = new SimpleDateFormat("yyyyMM");
        String yyyymm = sdf.format(new Date(System.currentTimeMillis()));
        Map<String, String> map = new HashMap<String, String>();
        map.put("yyyymm", yyyymm);
        List<Map<String, String>> list = firstPageManager.getAreaNum(map);
        map = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        JSONArray json = JSONArray.fromObject(list);

        try {
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(request.getSession()
                            .getServletContext().getRealPath("/")
                            + "media/firstpagemap.js"), "UTF-8");

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
        String thisyear = sdf1.format(new Date(System.currentTimeMillis()/1000));
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
            // FileWriter writer=new
            // FileWriter(request.getSession().getServletContext().getRealPath("/")+"media/firstpageline.js");
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(request.getSession()
                            .getServletContext().getRealPath("/")
                            + "media/firstpageline.js"), "UTF-8");
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
        map = new HashMap<String, String>();
        map.put("yyyymm", yyyymm);
        List<Integer> listxk = firstPageManager.getAreaXkNum(map);
        List<Integer> listcf = firstPageManager.getAreaCfNum(map);

        JSONArray jsonxk = JSONArray.fromObject(listxk);
        JSONArray jsoncf = JSONArray.fromObject(listcf);

        try {
            // FileWriter writer=new
            // FileWriter(request.getSession().getServletContext().getRealPath("/")+"media/firstpagebar.js");
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(request.getSession()
                            .getServletContext().getRealPath("/")
                            + "media/firstpagebar.js"), "UTF-8");

            writer.write("var listxk=" + jsonxk.toString() + ";");
            writer.write("var listcf=" + jsoncf.toString() + ";");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
