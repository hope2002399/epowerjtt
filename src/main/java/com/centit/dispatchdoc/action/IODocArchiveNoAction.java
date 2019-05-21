package com.centit.dispatchdoc.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.centit.dispatchdoc.service.IODocArchiveNoManager;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptZwh;
import com.centit.powerruntime.service.OptBaseInfoManager;
import com.centit.powerruntime.service.OptProcInfoManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.VUserUnits;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.OptFlowNoInfoManager;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

public class IODocArchiveNoAction extends IODocCommonBizAction<OptZwh> {
    private static final long serialVersionUID = 1L;
    private IODocArchiveNoManager ioDocArchiveNoManager;
    private OptBaseInfoManager optBaseInfoManager;
    private OptFlowNoInfoManager optFlowNoInfoManager;
    private OptProcInfoManager optProcInfoManager;
    private SysUserManager sysUserManager;

    private JSONObject result;
    private JSONObject whresult;
    private List<Map<String, String>> year;

    public void setIoDocArchiveNoManager(IODocArchiveNoManager basemgr) {
        ioDocArchiveNoManager = basemgr;
        this.setBaseEntityManager(ioDocArchiveNoManager);
    }

    public void setOptBaseInfoManager(OptBaseInfoManager optBaseInfoManager) {
        this.optBaseInfoManager = optBaseInfoManager;
    }

    @Override
    public String edit() {
        try {
            String djid = object.getDjId();
            long flowinstid = object.getFlowInstID();
            String wjlx = request.getParameter("dispatchFileType");
            String zbcs = request.getParameter("orgCode");
            if (object == null) {
                object = getEntityClass().newInstance();
            } else {
                OptZwh o = ioDocArchiveNoManager.getObject(object);
                if (o != null)
                    ioDocArchiveNoManager.copyObject(object, o);
                else
                    ioDocArchiveNoManager.clearObjectProperties(object);
            }
            // 生成流水号
            object.setLsh(makeFWlsH(wjlx, new Date(), flowinstid));
            // 生成置文号
            FUnitinfo unit = CodeRepositoryUtil.getUnitInfoByCode(zbcs);
            object.setFwh(makeFWH(wjlx, new Date(), unit.getPrefix(),
                    object.getLsh(), flowinstid));
            object.setDjId(djid);
            object.setFlowInstID(flowinstid);
            object.setOrgCode(zbcs);
            object.setWjlx(wjlx);
            object.setLshYear(String.valueOf(Calendar.getInstance().get(
                    Calendar.YEAR)));
            year = this.getFromArray();

            moduleParam = generalModuleParamManager.getObjectById(moduleCode);

            return EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 提交操作结果
     * 
     * @return
     */
    public String submitOpt() {
        try {
            saveIODocArchiveNoInfo();
            submitNode();
            // 保存过程日志信息
            saveIdeaInfo();

            return "refreshTasks";
        } catch (Exception e) {
            // log.error(e, e.getCause());
            e.printStackTrace();
            request.setAttribute("error", "当前操作提交失败，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 保存置文号信息
     * 
     * @return
     */
    public String saveIODocArchiveNoInfo() {
        try {
            // 保存业务信息
            OptZwh dbObject = ioDocArchiveNoManager.getObject(object);
            if (dbObject != null) {
                ioDocArchiveNoManager.copyObjectNotNullProperty(dbObject,
                        object);
                object = dbObject;
            }

            // 保存置文号OPT_ZWH表
            ioDocArchiveNoManager.saveObject(object);
            OptBaseInfo obi = optBaseInfoManager
                    .getObjectById(object.getDjId());
            obi.setSendArchiveNo(object.getFwh());

            // 保存置文号 OPT_BASE_INFO表
            optBaseInfoManager.saveObject(obi);

            return "refreshTasks";
        } catch (Exception e) {
            // log.error(e, e.getCause());
            e.printStackTrace();
            request.setAttribute("error", "保存流程过程信息失败。");
            return ERROR;
        }
    }

    /**
     * 保存过程日志信息
     */
    public void saveIdeaInfo() {
        FUserDetail loginInfo = (FUserDetail) getLoginUser();

        Long nodeInstId = Long.parseLong(request.getParameter("nodeInstId"));
        String djId = request.getParameter("djId");

        OptProcInfo optProcInfo = new OptProcInfo();
        optProcInfo.setTransdate(new Date(System.currentTimeMillis()));
        optProcInfo.setUsercode(loginInfo.getUsercode());
        optProcInfo.setUnitcode(loginInfo.getPrimaryUnit());

        NodeInstance nodeInst = flowEngine.getNodeInstById(nodeInstId);
        FlowNodeInfo nodeInfo = flowEngine
                .getNodeInfoById(nodeInst.getNodeId());
        optProcInfo.setNodename(nodeInfo.getNodeName());
        optProcInfo.setNodeinststate(nodeInst.getNodeState());
        optProcInfo.setIdeacode(object.getIdeacode());

        // 存在风险点的信息:风险类别、风险描述、风险内控手段与结果
        if (StringUtils.isNotBlank(optProcInfo.getRisktype())) {
            optProcInfo.setIsrisk("T");// 存在
        } else {
            optProcInfo.setIsrisk("F");// 不存在
        }
        optProcInfo.setNodeInstId(nodeInstId);
        optProcInfo.setDjId(djId);
        optProcInfoManager.saveObject(optProcInfo);// 保存办件人员

        /** 获得用户所在部门 start */
        VUserUnits fuerunit = new VUserUnits();
        fuerunit.setUnitCode(loginInfo.getPrimaryUnit());
        fuerunit.setUserCode(loginInfo.getUsercode());
        fuerunit = sysUserManager.getUnitByUserCode(fuerunit);
        /** 获得用户所在部门 end */

        OptIdeaInfo optIdeaInfo = new OptIdeaInfo();
        optIdeaInfo.setUsername(loginInfo.getUsername());
        optIdeaInfo.setUnitname(fuerunit.getUnitName());

        optProcInfoManager.saveIdeaInfo(optIdeaInfo, optProcInfo);

    }

    /**
     * 根据文件类型 年份 生成一个流水号，每次生成的都不一样，每次创建一个最新的号码
     * 
     * @param wjlx
     *            文件类型
     * @param baseYear
     *            年份，只要在这个年份的任意一天中
     * @return 流水号
     */
    public String makeFWlsH(String wjlx, Date baseYear, long flowinstid) {
        // WJLX FDatadictionary getDataPiece
        FDatadictionary wjlxData = CodeRepositoryUtil
                .getDataPiece("WJLX", wjlx);
        String fwhgz = wjlxData.getDatadesc();
        long lsh = optFlowNoInfoManager.newNextLshBaseYear("xtzwhgz", fwhgz,
                baseYear);
        FDatadictionary zwhgzData = CodeRepositoryUtil.getDataPiece("ZWHGZ",
                fwhgz);
        int nlshlen = 0;
        String slshlen = zwhgzData.getExtracode();
        try {
            nlshlen = Integer.valueOf(slshlen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sLsh = String.valueOf(lsh);
        if (sLsh.length() < nlshlen)
            sLsh = StringBaseOpt.fillZeroForString(sLsh, nlshlen);
        return sLsh;
    }

    /**
     * 根据 文件类型 年份 字头 流水号 自动生成一个 发文号
     * 
     * @param wjlx
     *            文件类型
     * @param baseYear
     *            年份，只要在这个年份的任意一天中
     * @param zt
     *            字头，在机构信息中
     * @param lsh
     *            流水号
     * @return 发文号
     */
    public String makeFWH(String wjlx, Date baseYear, String zt, String lsh,
            long flowinstid) {
        FDatadictionary wjlxData = CodeRepositoryUtil
                .getDataPiece("WJLX", wjlx);
        String fwhgz = wjlxData.getDatadesc();
        FDatadictionary zwhgzData = CodeRepositoryUtil.getDataPiece("ZWHGZ",
                fwhgz);
        int nlshlen = 0;
        String slshlen = zwhgzData.getExtracode();
        try {
            nlshlen = Integer.valueOf(slshlen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sLsh = lsh;
        if (sLsh.length() < nlshlen)
            sLsh = StringBaseOpt.fillZeroForString(sLsh, nlshlen);
        String sYear = String.valueOf(DatetimeOpt.getYear(baseYear));
        String sfwh = zwhgzData.getDatavalue().replaceAll("%nh%", sYear);

        if (null != zt) {

            sfwh = sfwh.replaceAll("%zt%", zt);

        } else {
            sfwh = sfwh.replaceAll("%zt%", " ");
        }
        if (null != sLsh) {
            sfwh = sfwh.replaceAll("%ls%", sLsh);
        }

        return sfwh;
    }

    /**
     * 重新生成置文号和流水号
     * 
     * @return
     */
    public String change() {
        String wjlx = request.getParameter("wjlx");
        String lshyear = request.getParameter("lshYear");
        String lsh = request.getParameter("lsh");
        long flowinstid = Long.valueOf(request.getParameter("flowInstId"));
        String zbcs = request.getParameter("orgCode");
        FUnitinfo unit = CodeRepositoryUtil.getUnitInfoByCode(zbcs);
        String wh = "";
        try {
            lsh = makeFWlsH(wjlx,
                    DatetimeOpt.convertStringToDate(lshyear + "-10-10"),
                    flowinstid);
            wh = makeFWH(wjlx,
                    DatetimeOpt.convertStringToDate(lshyear + "-10-10"),
                    unit.getPrefix(), lsh, flowinstid);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("wh", wh);
        map.put("newlsh", lsh);
        result = JSONObject.fromObject(map);
        return "fwhlsh";
    }

    /**
     * 重新生成发文号
     * 
     * @return
     */

    public String changeFwh() {
        String wjlx = request.getParameter("wjlx");
        String lshyear = request.getParameter("lshYear");
        String lsh = request.getParameter("lsh");
        long flowinstid = Long.valueOf(request.getParameter("flowInstId"));
        String zbcs = request.getParameter("orgCode");
        FUnitinfo unit = CodeRepositoryUtil.getUnitInfoByCode(zbcs);
        String wh = "";
        try {
            wh = makeFWH(wjlx,
                    DatetimeOpt.convertStringToDate(lshyear + "-10-10"),
                    unit.getPrefix(), lsh, flowinstid);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("wh", wh);
        whresult = JSONObject.fromObject(map);
        return "fwh";
    }

    /*
     * 得到当前年份前后5年的时间段
     */
    public List<Map<String, String>> getFromArray() {
        List<Map<String, String>> fromArray = new ArrayList<Map<String, String>>();
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        for (int i = y - 5; i < y + 5; i++) {
            HashMap<String, String> cache = new HashMap<String, String>();
            cache.put("id", String.valueOf(i));
            cache.put("name", String.valueOf(i));
            fromArray.add(cache);
        }
        return fromArray;
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    public JSONObject getWhresult() {
        return whresult;
    }

    public void setWhresult(JSONObject whresult) {
        this.whresult = whresult;
    }

    public void setOptFlowNoInfoManager(
            OptFlowNoInfoManager optFlowNoInfoManager) {
        this.optFlowNoInfoManager = optFlowNoInfoManager;
    }

    public List<Map<String, String>> getYear() {
        return year;
    }

    public void setYear(List<Map<String, String>> year) {
        this.year = year;
    }

    public OptProcInfoManager getOptProcInfoManager() {
        return optProcInfoManager;
    }

    public void setOptProcInfoManager(OptProcInfoManager optProcInfoManager) {
        this.optProcInfoManager = optProcInfoManager;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }
}
