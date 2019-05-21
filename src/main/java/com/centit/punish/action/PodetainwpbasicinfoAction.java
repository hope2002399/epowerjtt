package com.centit.punish.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Podetainwpbasicinfo;
import com.centit.punish.po.Podetainwptransinfo;
import com.centit.punish.service.PodetainwpbasicinfoManager;
import com.centit.punish.service.PodetainwptransinfoManager;
import com.centit.sys.security.FUserDetail;

public class PodetainwpbasicinfoAction extends
        PunishCommonBizAction<Podetainwpbasicinfo> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory
            .getLog(PodetainwpbasicinfoAction.class);
    private static final long serialVersionUID = 1L;
    private PodetainwpbasicinfoManager podetainwpbasicinfoManager;
    private PodetainwptransinfoManager podetainwptransinfoManager;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setPodetainwpbasicinfoManager(PodetainwpbasicinfoManager basemgr) {
        podetainwpbasicinfoManager = basemgr;
        this.setBaseEntityManager(podetainwpbasicinfoManager);
    }

    public void setPodetainwptransinfoManager(PodetainwptransinfoManager basemgr) {
        podetainwptransinfoManager = basemgr;
    }

    private List<Podetainwptransinfo> podetainwptransinfosforshow;
    private List<Podetainwpbasicinfo> podetainwpbasicinfos;

    public List<Podetainwptransinfo> getPodetainwptransinfosforshow() {
        return podetainwptransinfosforshow;
    }

    public void setPodetainwptransinfosforshow(
            List<Podetainwptransinfo> podetainwptransinfosforshow) {
        this.podetainwptransinfosforshow = podetainwptransinfosforshow;
    }

    public List<Podetainwpbasicinfo> getPodetainwpbasicinfos() {
        return podetainwpbasicinfos;
    }

    public void setPodetainwpbasicinfos(
            List<Podetainwpbasicinfo> podetainwpbasicinfos) {
        this.podetainwpbasicinfos = podetainwpbasicinfos;
    }

    // 暂扣品管理
    public String list() {

        Map<String, Object> filtermap = new HashMap<String, Object>();
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        filtermap = convertSearchColumn(paramMap);
        podetainwpbasicinfos = this.podetainwpbasicinfoManager
                .listObjects(filtermap);
        totalRows = (podetainwpbasicinfos != null && podetainwpbasicinfos
                .size() > 0) ? podetainwpbasicinfos.size() : 0;
        return LIST;
    }

    // 保存
    public String save() {
        // object.replacePodetainwptransinfos(podetainwptransinfos)
        if (!StringUtils.isNotBlank(object.getWpid())) {
            object.setWpid(this.podetainwpbasicinfoManager.genNextWpId());
        }
        if (!StringUtils.isNotBlank(object.getWpstate())) {
            object.setWpstate("1");
        }
        try {
            this.baseEntityManager.saveObject(object);
        } catch (Exception e) {
            String errmsg = e.getCause().getCause().getMessage();
            if (errmsg.contains("ORA-02291")) {
                request.setAttribute("error", "找不到该处罚办件编号");
                this.setEorroMessage("找不到该处罚办件编号");
                return EDIT;
            }
        }
        if ("1".equals(flag)) {
            Podetainwptransinfo transobject = new Podetainwptransinfo();
            transobject.setWpid(object.getWpid());
            transobject.setTransperson(object.getConfirmperson());// 新增暂扣品里的对方确认人作为流转信息表里的移交人
            transobject.setReceiveperson(object.getReceiveperson());// 新增暂扣品里的接收人作为流转信息表里的接收人
            transobject.setTranslocation(object.getWpcurrentlocation());// 新增暂扣品里的存放地点作为流转信息表里的移交地点
            transobject.setReceivedate(object.getReceivedate());// 新增暂扣品里的接收时间作为流转信息表里的接收时间
            transobject.setRemark(object.getRemark());// 新增暂扣品里的备注作为流转信息表里的备注
            transobject.setOpttype((long) 0);// 操作类型--新增
            transobject.setOptperson(((FUserDetail) this.getLoginUser())
                    .getUsercode());// 操作人
            transobject.setOptdate(new Date(System.currentTimeMillis()));// 操作时间
            this.podetainwptransinfoManager.saveObject(transobject);
        }
        object.clearProperties();// 处理object缓存问题
        return "wplist";
    }

    // 新增界面
    public String addnew() {
        String punishobjectid = object.getPunishobjectid();
        object.clearProperties();
        object = new Podetainwpbasicinfo();
        if (StringUtils.isNotBlank(punishobjectid)) {
            object.setPunishobjectid(punishobjectid);
        }
        this.setEorroMessage("");
        object.setReceivedate(new Date(System.currentTimeMillis()));
        object.setReceiveperson(((FUserDetail) this.getLoginUser())
                .getUsercode());
        flag = "1";
        return EDIT;
    }

    // 编辑
    public String edit() {
        object = this.podetainwpbasicinfoManager
                .getObjectById(object.getWpid());
        this.setEorroMessage("");
        flag = "2";
        return EDIT;

    }

    public String view() {
        object = this.podetainwpbasicinfoManager
                .getObjectById(object.getWpid());
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("wpid", object.getWpid());
        filtermap.put(CodeBook.ORDER_BY_HQL_ID, "receivedate");
        podetainwptransinfosforshow = this.podetainwptransinfoManager
                .listObjects(filtermap);
        return VIEW;
    }

}
