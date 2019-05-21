package com.centit.EIdPhoto.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.catalina.deploy.FilterMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.centit.EIdPhoto.po.TZzMetadataInfo;
import com.centit.EIdPhoto.po.TZzZmInfo;
import com.centit.EIdPhoto.po.TZzZmdyInfo;
import com.centit.EIdPhoto.service.TZzZmInfoManager;
import com.centit.EIdPhoto.service.TZzZmdyInfoManager;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.OptApplyInfo;
import com.centit.powerruntime.po.OptBaseInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.service.OptApplyManager;
import com.centit.powerruntime.service.OptBaseInfoManager;
import com.centit.powerruntime.service.OptStuffInfoManager;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUserManager;
import com.centit.workflow.sample.optmodel.BaseWFEntityAction;

/**
 * 
 * 电子证照
 * 
 * @author dzf
 * @create 2017年9月15日
 * @version
 */
public class ElectronicsIdPhotoAction extends BaseWFEntityAction<TZzZmdyInfo>
        implements ServletResponseAware {

    /**
     * 
     */
    private static final long serialVersionUID = -4831872395870341940L;
    HttpServletResponse response;
    private List<TZzZmdyInfo> srPermitApplyList;

    private List<TZzZmInfo> srPerApplyList;

    private SysUserManager sysUserManager;

    private TZzZmdyInfoManager tZzZmdyInfoManager;

    private TZzZmInfoManager tZzZmInfoManager;

    private OptBaseInfoManager optBaseInfoManager;

    private OptApplyManager optApplyManager;

    private OptStuffInfoManager optStuffInfoManager;

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }
    
    public OptApplyManager getOptApplyManager() {
        return optApplyManager;
    }

    public void setOptApplyManager(OptApplyManager optApplyManager) {
        this.optApplyManager = optApplyManager;
    }

    public OptStuffInfoManager getOptStuffInfoManager() {
        return optStuffInfoManager;
    }

    public void setOptStuffInfoManager(OptStuffInfoManager optStuffInfoManager) {
        this.optStuffInfoManager = optStuffInfoManager;
    }

    public TZzZmdyInfoManager gettZzZmdyInfoManager() {
        return tZzZmdyInfoManager;
    }

    public void settZzZmdyInfoManager(TZzZmdyInfoManager tZzZmdyInfoManager) {
        this.tZzZmdyInfoManager = tZzZmdyInfoManager;
    }

    public TZzZmInfoManager gettZzZmInfoManager() {
        return tZzZmInfoManager;
    }

    public void settZzZmInfoManager(TZzZmInfoManager tZzZmInfoManager) {
        this.tZzZmInfoManager = tZzZmInfoManager;
    }

    public List<TZzZmdyInfo> getSrPermitApplyList() {
        return srPermitApplyList;
    }

    public void setSrPermitApplyList(List<TZzZmdyInfo> srPermitApplyList) {
        this.srPermitApplyList = srPermitApplyList;
    }

    public OptBaseInfoManager getOptBaseInfoManager() {
        return optBaseInfoManager;
    }

    public void setOptBaseInfoManager(OptBaseInfoManager optBaseInfoManager) {
        this.optBaseInfoManager = optBaseInfoManager;
    }
    
    

    public List<TZzZmInfo> getSrPerApplyList() {
        return srPerApplyList;
    }

    public void setSrPerApplyList(List<TZzZmInfo> srPerApplyList) {
        this.srPerApplyList = srPerApplyList;
    }

    public String list() {
        try {
            FUserDetail fuser = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager
                    .getUserPrimaryUnit(fuser.getUsercode());
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);
            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);

            srPerApplyList = tZzZmInfoManager.findTZzZmdyInfo(filterMap,
                    pageDesc);
            totalRows = pageDesc.getTotalRows();

            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // 生成随机数字和字母,
    public String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        // 参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 新增电子证照
     * 
     * @throws ParseException
     * @throws IOException
     */
    public void addTZzZmInfo() throws ParseException, IOException {
        String zzBh = request.getParameter("zzBh");
        if (null != zzBh && zzBh.length() <= 2) {
            zzBh = getStringRandom(8);
        }
        String starTime = request.getParameter("starTime");
        String endTime = request.getParameter("endTime");
        String deptName = request.getParameter("deptName");
        String userName = request.getParameter("userName");
        String userType = request.getParameter("userType");
        String userZzType = request.getParameter("userZzType");
        String djId = request.getParameter("djId");
        String userNo = request.getParameter("userNo");
        String mouldId = request.getParameter("mouldId");
        List<TZzMetadataInfo> metadataInfoList = tZzZmdyInfoManager
                .findTZzMetadataInfo(mouldId);
        String xml = "<License><Face>";
        for (TZzMetadataInfo metadataInfoTmp : metadataInfoList) {
            xml = xml + "<Field CName=\"" + metadataInfoTmp.getColumnName()
                    + "\" value=\""
                    + request.getParameter(metadataInfoTmp.getId()) + "\"/>";
        }
        xml = xml + "</Face></License>";
        OptStuffInfo optStuffinfo = optStuffInfoManager.getStuffInfoByDjIdName(djId, "许可决定书.pdf");
        TZzZmInfo tZzZmInfo = new TZzZmInfo();
        tZzZmInfo.setZzFiles(optStuffinfo!=null?optStuffinfo.getStuffcontent():null);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tZzZmInfo.setDividuation(xml);
        tZzZmInfo.setEndTime(format.parse(endTime));
        tZzZmInfo.setStartTime(format.parse(starTime));
        tZzZmInfo.setDeptName(deptName);
        tZzZmInfo.setDzzzNo(userNo + "_" + zzBh);
        tZzZmInfo.setId(System.currentTimeMillis() + "");
        tZzZmInfo.setInDividuation(null);
        tZzZmInfo.setZzFile(null);
        tZzZmInfo.setMouldId(mouldId);
        tZzZmInfo.setState("A");
        tZzZmInfo.setUserName(userName);
        tZzZmInfo.setUserNo(userNo);
        tZzZmInfo.setUserType(userType);
        tZzZmInfo.setUserZjType(userZzType);
        tZzZmInfo.setZzBh(zzBh);
        tZzZmInfo.setZzType("A");
        tZzZmInfo.setStatus("01");
        tZzZmInfo.setNumCode("320000JT");
        tZzZmInfo.setQxNumCode("320000JT");
        tZzZmInfoManager.insertZmInfo(tZzZmInfo);
        /*
         * 
         * FUserDetail fuser = ((FUserDetail) getLoginUser()); FUserunit dept =
         * sysUserManager.getUserPrimaryUnit(fuser .getUsercode()); Map<Object,
         * Object> paramMap = request.getParameterMap();
         * resetPageParam(paramMap); Map<String, Object> filterMap =
         * convertSearchColumn(paramMap); Limit limit =
         * ExtremeTableUtils.getLimit(request); PageDesc pageDesc =
         * ExtremeTableUtils.makePageDesc(limit);
         * 
         * srPermitApplyList = tZzZmdyInfoManager.findTZzZmdyInfo(filterMap,
         * pageDesc); totalRows = pageDesc.getTotalRows(); return LIST;
         */
    }

    public String toPhoto() {
        String mouldId = request.getParameter("mouldId");
        if (StringUtils.isBlank(mouldId)) {
            String djId = request.getParameter("djId");
            OptBaseInfo optBaseInfo = optBaseInfoManager.getObjectById(djId);
            OptApplyInfo optApplyInfo = new OptApplyInfo();
            optApplyInfo.setDjId(djId);
            optApplyInfo = optApplyManager.getObject(optApplyInfo);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            Map<String, Object> filterMap = new HashMap<>();
            filterMap.put("outItemId", optBaseInfo.getOutItemId());
            srPermitApplyList = tZzZmdyInfoManager.findTZzZmdyInfo(filterMap,
                    pageDesc);
            if (srPermitApplyList != null && srPermitApplyList.size() > 0) {
                request.setAttribute("mouldId",
                        srPermitApplyList.get(0).getMouldId());
                request.setAttribute("metadataInfoList",
                        tZzZmdyInfoManager.findTZzMetadataInfo(
                                srPermitApplyList.get(0).getMouldId()));
            }
            request.setAttribute("djId", djId);
            request.setAttribute("deptName", optBaseInfo.getOrgname());
            request.setAttribute("userName", optApplyInfo.getProposerName());
            request.setAttribute("userNo", optApplyInfo.getProposerPaperCode());
            request.setAttribute("userType", StringUtils.isNotBlank(optApplyInfo.getLegal_person()) ? "02" : "01");
            if(StringUtils.isNotBlank(optApplyInfo.getLegal_person())){
                if(optApplyInfo.getProposerPaperType().equals("3")){
                    request.setAttribute("userZzType", "01");
                }else if(optApplyInfo.getProposerPaperType().equals("4")){
                    request.setAttribute("userZzType", "02");
                }else if(optApplyInfo.getProposerPaperType().equals("5")){
                    request.setAttribute("userZzType", "03");
                }else if(optApplyInfo.getProposerPaperType().equals("6")){
                    request.setAttribute("userZzType", "03");
                }
            }else{
                if(optApplyInfo.getProposerPaperType().equals("0")){
                    request.setAttribute("userZzType", "05");
                }else if(optApplyInfo.getProposerPaperType().equals("1")){
                    request.setAttribute("userZzType", "08");
                }else if(optApplyInfo.getProposerPaperType().equals("8")){
                    request.setAttribute("userZzType", "03");
                }else if(optApplyInfo.getProposerPaperType().equals("9")){
                    request.setAttribute("userZzType", "14");
                }else if(optApplyInfo.getProposerPaperType().equals("2")){
                    request.setAttribute("userZzType", "14");
                }else if(optApplyInfo.getProposerPaperType().equals("3")){
                    request.setAttribute("userZzType", "14");
                }else if(optApplyInfo.getProposerPaperType().equals("4")){
                    request.setAttribute("userZzType", "06");
                }else if(optApplyInfo.getProposerPaperType().equals("5")){
                    request.setAttribute("userZzType", "14");
                }else if(optApplyInfo.getProposerPaperType().equals("6")){
                    request.setAttribute("userZzType", "12");
                }else if(optApplyInfo.getProposerPaperType().equals("7")){
                    request.setAttribute("userZzType", "13");
                }else if(optApplyInfo.getProposerPaperType().equals("10")){
                    request.setAttribute("userZzType", "14");
                }
            }
        } else {
            request.setAttribute("mouldId", mouldId);
            request.setAttribute("metadataInfoList",
                    tZzZmdyInfoManager.findTZzMetadataInfo(mouldId));
        }
        return EDIT;
    }

}
