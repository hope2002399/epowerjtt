package com.centit.monitor.action;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.complaint.service.ComplaintManager;
import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.PaMonthCheckup;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.OutwayManager;
import com.centit.monitor.service.PaMonthCheckupManager;
import com.centit.monitor.service.PunishManager;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.supervise.service.SuperviseBasicManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class PaMonthCheckupAction extends
        BaseEntityExtremeAction<PaMonthCheckup> {
    private static final long serialVersionUID = 1L;
    private PaMonthCheckupManager paMonthCheckupMag;

    public void setPaMonthCheckupManager(PaMonthCheckupManager basemgr) {
        paMonthCheckupMag = basemgr;
        this.setBaseEntityManager(paMonthCheckupMag);
    }

    // 页面要用到的一些变量
    private List<PaMonthCheckup> checklist;

    public List<PaMonthCheckup> getChecklist() {
        return checklist;
    }

    public void setChecklist(List<PaMonthCheckup> checklist) {
        this.checklist = checklist;
    }

    /**
     * 查看明细
     * 
     * @return
     */

    public String view() {
        String countYear = (String) request.getAttribute("countYear");
        String countMonth = (String) request.getAttribute("countMonth");
        String orgId = (String) request.getAttribute("orgId");
        // Map<Object, Object> paramMap = request.getParameterMap();
        // resetPageParam(paramMap);
        // Map<String, Object> filterMap = convertSearchColumn(paramMap);
        // filterMap.put("itemId", orgId);
        // filterMap.put("countYear", countYear);
        // filterMap.put("countMonth", countMonth);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        checklist = paMonthCheckupMag
                .getCheckList(countYear, countMonth, orgId);
        totalRows = pageDesc.getTotalRows();
        return "clist";
    }

    /**
     * 地区统计分析报告（统计分析模块）
     * 
     * @return
     */

    private SuppowerManager suppowerManager;

    public SuppowerManager getSuppowerManager() {
        return suppowerManager;
    }

    public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }

    private ApplyManager applyManager;
    private PunishManager punishManager;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    private OutwayManager outwayManager;
    private SuperviseBasicManager superviseBasicManager;

    public SuperviseBasicManager getSuperviseBasicManager() {
        return superviseBasicManager;
    }

    public void setSuperviseBasicManager(
            SuperviseBasicManager superviseBasicManager) {
        this.superviseBasicManager = superviseBasicManager;
    }

    private ComplaintManager complaintManager;

    public ComplaintManager getComplaintManager() {
        return complaintManager;
    }

    public void setComplaintManager(ComplaintManager complaintManager) {
        this.complaintManager = complaintManager;
    }

    public OutwayManager getOutwayManager() {
        return outwayManager;
    }

    public void setOutwayManager(OutwayManager outwayManager) {
        this.outwayManager = outwayManager;
    }

    public SysUserManager getSysUserManager() {
        return sysUserManager;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public SysUnitManager getSysUnitManager() {
        return sysUnitManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public PunishManager getPunishManager() {
        return punishManager;
    }

    public void setPunishManager(PunishManager punishManager) {
        this.punishManager = punishManager;
    }

    public ApplyManager getApplyManager() {
        return applyManager;
    }

    public void setApplyManager(ApplyManager applyManager) {
        this.applyManager = applyManager;
    }

    private BigDecimal numapply;
    private BigDecimal numpunish;
    private BigDecimal depnum;
    //
    @SuppressWarnings("rawtypes")
    private List xzlist;
    @SuppressWarnings("rawtypes")
    private List qllist;
    @SuppressWarnings("rawtypes")
    private List deplist;
    @SuppressWarnings("rawtypes")
    private List applylist;
    @SuppressWarnings("rawtypes")
    private List punishlist;
    @SuppressWarnings("rawtypes")
    private List applyalllist;
    @SuppressWarnings("rawtypes")
    private List punishalllist;
    @SuppressWarnings("rawtypes")
    private List cjjclist;
    @SuppressWarnings("rawtypes")
    private List dblist;

    @SuppressWarnings("unused")
    public String listAll() {
        String flag = request.getParameter("flag");
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);// 这个是配置查询条件的
        Limit limit = ExtremeTableUtils.getLimit(request);
        String begintime = (String) filterMap.get("begTime");
        String endtime = (String) filterMap.get("endTime");
        if ("1".equals(flag)) {
            // 默认查询时间
            begintime = DatetimeOpt.getNowDateTime4String().substring(0, 10);
            endtime = DatetimeOpt.getNowDateTime4String().substring(0, 10);
            filterMap.put("begTime", begintime);
            filterMap.put("endTime", endtime);
            filterMap.put("begsupervisedate", begintime);
            filterMap.put("endsupervisedate", endtime);
        }
        request.setAttribute("begintime", begintime);
        request.setAttribute("endtime", endtime);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        FUserDetail user = ((FUserDetail) getLoginUser());// 获取当前用户的信息
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        DecimalFormat df = new DecimalFormat("####.##");
        Object xzsponum = new Object();
        Object tzsponum = new Object();
        Object gqsponum = new Object();
        Object fzsponum = new Object();
        if (StringUtils.isNotBlank(begintime)) {
            // 权力事项状态（新增,调整，挂起，废止）
            xzlist = suppowerManager.getxzlist(begintime, endtime);
            Object[] o = (Object[]) xzlist.get(0);
            xzsponum = o[0] == null ? 0 : o[0];// 新增
            tzsponum = o[1] == null ? 0 : o[1];// 调整
            gqsponum = o[2] == null ? 0 : o[2];// 挂起
            fzsponum = o[3] == null ? 0 : o[3];// 废止
        }
        StringBuffer QLString = new StringBuffer();
        QLString.append("&nbsp;&nbsp;&nbsp;&nbsp;").append("根据")
                .append(begintime).append("(至").append(endtime)
                .append(")的数据统计，期间江苏省各级交通运输部门因法律法规变动、职权调整等原因共计");
        QLString.append("新增行政权力").append(String.valueOf(xzsponum))
                .append("项，调整行政权力").append(String.valueOf(tzsponum))
                .append("项，挂起行政权力").append(String.valueOf(gqsponum));
        QLString.append("项，废止行政权力").append(String.valueOf(fzsponum))
                .append("项。");
        request.setAttribute("QLString", QLString);
        Object allsponum = new Object();
        Object xksponum = new Object();
        Object cfsponum = new Object();
        Object zssponum = new Object();
        Object qzsponum = new Object();
        Object zysponum = new Object();
        Object ztsponum = new Object();
        if (StringUtils.isNotBlank(begintime)) {
            String item_type = "";
            qllist = suppowerManager.getSuppowernum(item_type);
            Object[] o = (Object[]) qllist.get(0);
            allsponum = (Object) o[0];// 所有
            xksponum = (Object) o[1];// 许可
            zssponum = (Object) o[2];// 征收
            cfsponum = (Object) o[3];// 废止
            qzsponum = (Object) o[4];// /强制
            zysponum = (Object) o[5];// 再用
            ztsponum = (Object) o[6];// 挂起

        }
        int qtsponum = Integer.parseInt(String.valueOf(allsponum))
                - Integer.parseInt(String.valueOf(xksponum))
                - Integer.parseInt(String.valueOf(cfsponum))
                - Integer.parseInt(String.valueOf(zssponum))
                - Integer.parseInt(String.valueOf(qzsponum));
        StringBuffer QLSString = new StringBuffer();
        QLSString.append("&nbsp;&nbsp;&nbsp;&nbsp;").append("目前拥有行政权力事项")
                .append(allsponum).append("项，包括行政许可").append(xksponum);
        QLSString.append("项，行政处罚 ").append(cfsponum).append("项，行政征收")
                .append(zssponum).append("项，行政强制").append(qzsponum);
        QLSString.append("项，其他行政权力").append(qtsponum).append("项，其中在用")
                .append(zysponum).append("项，挂起").append(ztsponum).append("项。");
        request.setAttribute("QLSString", QLSString);
        if (StringUtils.isNotBlank(begintime)) {
            deplist = suppowerManager.getdeplist("");
            depnum = (BigDecimal) deplist.get(0);
            applylist = applyManager.getApplylistsize(begintime, endtime);
            numapply = (BigDecimal) applylist.get(0);
            punishlist = punishManager.getPunishlistsize(begintime, endtime);
            numpunish = (BigDecimal) punishlist.get(0);
        }
        int allnum = Integer.parseInt(String.valueOf(numapply))
                + Integer.parseInt(String.valueOf(numpunish));
        StringBuffer BJString = new StringBuffer();
        BJString.append("&nbsp;&nbsp;&nbsp;&nbsp;")
                .append("期间全省交通运输系统行政权力网上公开透明运行三级联网系统运行正常，省、市、县三级")
                .append(depnum).append("个部门共办理办件").append(allnum)
                .append("件。具体情况如下：");
        request.setAttribute("BJString", BJString);
        applyalllist = applyManager.getapplyalllist(begintime, endtime);
        Object[] o = (Object[]) applyalllist.get(0);
        Object xknum = (Object) o[0];
        Object xkspnum = (Object) o[1];
        Object xksjnum = (Object) o[2];
        Object xkqxnum = (Object) o[3];// 许可省市县3级办件
        Object zsnum = (Object) o[4];
        Object zsspnum = (Object) o[5];
        Object zssjnum = (Object) o[6];
        Object zsqxnum = (Object) o[7];// 征收省市县3级办件
        Object qznum = (Object) o[8];
        Object qzspnum = (Object) o[9];
        Object qzsjnum = (Object) o[10];
        Object qzqxnum = (Object) o[11];// 强制省市县3级办件
        Object qtnum = (Object) o[12];
        Object qtspnum = (Object) o[13];
        Object qtsjnum = (Object) o[14];
        Object qtqxnum = (Object) o[15];// 其他省市县3级办件
        Object xkrenum = (Object) o[16];
        Object zsrenum = (Object) o[17];
        Object qzrenum = (Object) o[18];
        Object qtrenum = (Object) o[19];// 办结件
        cjjclist = outwayManager.getcjjclist(begintime, endtime);
        Object[] o1 = (Object[]) cjjclist.get(0);
        Object allybjnum = (Object) o1[0];
        Object xkybjnnum = (Object) o1[1];
        Object zsybjnum = (Object) o1[2];
        Object cfybjnnum = (Object) o1[3];
        Object qzybjnum = (Object) o1[4];
        Object qtybjnum = (Object) o1[5];
        String xkrate = "";
        String zsrate = "";
        String cfrate = "";
        String qzrate = "";
        String qtrate = "";
        if ("0".equals(String.valueOf(allybjnum))) {
            xkrate = "0";
            zsrate = "0";
            cfrate = "0";
            qzrate = "0";
            qtrate = "0";
        } else {
            xkrate = df.format(Double.parseDouble(String.valueOf(xkybjnnum))
                    / Double.parseDouble(String.valueOf(allybjnum)));
            zsrate = df.format(Double.parseDouble(String.valueOf(zsybjnum))
                    / Double.parseDouble(String.valueOf(allybjnum)));
            cfrate = df.format(Double.parseDouble(String.valueOf(cfybjnnum))
                    / Double.parseDouble(String.valueOf(allybjnum)));
            qzrate = df.format(Double.parseDouble(String.valueOf(qzybjnum))
                    / Double.parseDouble(String.valueOf(allybjnum)));
            qtrate = df.format(Double.parseDouble(String.valueOf(qtybjnum))
                    / Double.parseDouble(String.valueOf(allybjnum)));
        }
        // 督办
        dblist = superviseBasicManager.getdblist(begintime, endtime);
        Object[] o2 = (Object[]) dblist.get(0);
        Object xkdunum = (Object) o1[0];
        Object zsdunum = (Object) o1[1];
        Object cfdunum = (Object) o1[2];
        Object qzdunum = (Object) o1[3];
        Object qtdunum = (Object) o1[4];
        /**
         * 省市县3级办件数start*****************************************
         */
        StringBuffer XKString = new StringBuffer();
        StringBuffer ZSString = new StringBuffer();
        StringBuffer QZString = new StringBuffer();
        StringBuffer QTString = new StringBuffer();
        XKString.append("&nbsp;&nbsp;&nbsp;&nbsp;").append("1、行政许可事项：共计受理办件")
                .append(xknum).append("件，其中省级办件").append(xkspnum)
                .append("件，市级办件").append(xksjnum);
        XKString.append("件，县级办件").append(xkqxnum).append("件。")
                .append("针对行政许可办件，层级监察系统共发出各类预报警").append(allybjnum)
                .append("项，涉及办件").append(xkybjnnum);
        XKString.append("件，预报警率为").append(xkrate).append("%，各级检察机关共发起督办")
                .append(xkdunum);
        XKString.append("件，其中已办结").append(xkrenum).append("件。");
        request.setAttribute("XKString", XKString);
        ZSString.append("&nbsp;&nbsp;&nbsp;&nbsp;").append("2、行政征收事项：共计受理办件")
                .append(zsnum).append("件，其中省级办件").append(zsspnum)
                .append("件，市级办件").append(zssjnum);
        ZSString.append("件，县级办件").append(zsqxnum).append("件。")
                .append("针对行政征收办件，层级监察系统共发出各类预报警").append(allybjnum)
                .append("项，涉及办件").append(zsybjnum);
        ZSString.append("件，预报警率为").append(zsrate).append("%，各级检察机关共发起督办")
                .append(zsdunum);
        ZSString.append("件，其中已办结").append(zsrenum).append("件。");
        request.setAttribute("ZSString", ZSString);
        QZString.append("&nbsp;&nbsp;&nbsp;&nbsp;").append("3、行政强制事项：共计受理办件")
                .append(qznum).append("件，其中省级办件").append(qzspnum)
                .append("件，市级办件").append(qzsjnum);
        QZString.append("件，县级办件").append(qzqxnum).append("件。")
                .append("针对行政强制办件，层级监察系统共发出各类预报警").append(allybjnum)
                .append("项，涉及办件").append(qzybjnum);
        QZString.append("件，预报警率为").append(qzrate).append("%，各级检察机关共发起督办")
                .append(qzdunum);
        QZString.append("件，其中已办结").append(qzrenum).append("件。");
        request.setAttribute("QZString", QZString);
        QTString.append("&nbsp;&nbsp;&nbsp;&nbsp;").append("4、其他权力事项：共计受理办件")
                .append(qtnum).append("件，其中省级办件").append(qtspnum)
                .append("件，市级办件").append(qtsjnum);
        QTString.append("件，县级办件").append(qtqxnum).append("件。")
                .append("针对行政其他办件，层级监察系统共发出各类预报警").append(allybjnum)
                .append("项，涉及办件").append(qtybjnum);
        QTString.append("件，预报警率为").append(qtrate).append("%，各级检察机关共发起督办")
                .append(qtdunum);
        QTString.append("件，其中已办结").append(qtrenum).append("件。");
        request.setAttribute("QTString", QTString);
        if (StringUtils.isNotBlank(begintime)) {
            punishalllist = punishManager.getpunishalllist(begintime, endtime);
            Object[] oo = (Object[]) punishalllist.get(0);
            Object cfnum = (Object) oo[0];
            Object cfspnum = (Object) oo[1];
            Object cfsjnum = (Object) oo[2];
            Object cfqxnum = (Object) oo[3];// 许可省市县3级办件
            Object cfrenum = (Object) oo[4];// 办结件
            StringBuffer CFString = new StringBuffer();
            CFString.append("&nbsp;&nbsp;&nbsp;&nbsp;")
                    .append("4、行政处罚事项：共计受理案件").append(cfnum).append("件，其中省级案件")
                    .append(cfspnum).append("件，市级案件").append(cfsjnum);
            CFString.append("件，县级办件").append(cfqxnum).append("件。")
                    .append("针对行政处罚案件，层级监察系统共发出各类预报警").append(allybjnum)
                    .append("项，涉及案件").append(cfybjnnum);
            CFString.append("件，预报警率为").append(cfrate).append("%，各级检察机关共发起督办")
                    .append(cfdunum);
            CFString.append("件，其中已办结").append(cfrenum).append("件。");
            request.setAttribute("CFString", CFString);
        }
        return "sup";
    }

    public String delete() {
        super.delete();
        return "delete";
    }
}
