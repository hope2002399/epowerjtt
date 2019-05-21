package com.centit.punish.action;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.punish.po.Podetainwpbasicinfo;
import com.centit.punish.po.Podetainwptransinfo;
import com.centit.punish.service.PodetainwpbasicinfoManager;
import com.centit.punish.service.PodetainwptransinfoManager;
import com.centit.sys.security.FUserDetail;

public class PodetainwptransinfoAction extends
        PunishCommonBizAction<Podetainwptransinfo> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory
            .getLog(PodetainwptransinfoAction.class);
    private static final long serialVersionUID = 1L;
    private PodetainwptransinfoManager podetainwptransinfoManager;
    private PodetainwpbasicinfoManager podetainwpbasicinfoManager;
    private Podetainwpbasicinfo wpinfo;
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Podetainwpbasicinfo getWpinfo() {
        return wpinfo;
    }

    public void setWpinfo(Podetainwpbasicinfo wpinfo) {
        this.wpinfo = wpinfo;
    }

    public void setPodetainwpbasicinfoManager(
            PodetainwpbasicinfoManager podetainwpbasicinfoManager) {
        this.podetainwpbasicinfoManager = podetainwpbasicinfoManager;
    }

    public void setPodetainwptransinfoManager(PodetainwptransinfoManager basemgr) {
        podetainwptransinfoManager = basemgr;
        this.setBaseEntityManager(podetainwptransinfoManager);
    }

    // 移交
    public String turnover() {
        String wpid = object.getWpid();
        object.clearProperties();
        object = new Podetainwptransinfo();
        object.setWpid(wpid);
        keyword = "移交";
        wpinfo = this.podetainwpbasicinfoManager
                .getObjectById(object.getWpid());
        object.setOpttype((long) 1);
        object.setTransperson(((FUserDetail) this.getLoginUser()).getUsercode());
        object.setReceivedate(new Date(System.currentTimeMillis()));
        return EDIT;
    }

    // 归还
    public String sendback() {
        String wpid = object.getWpid();
        object.clearProperties();
        object = new Podetainwptransinfo();
        object.setWpid(wpid);
        keyword = "归还";
        wpinfo = this.podetainwpbasicinfoManager
                .getObjectById(object.getWpid());
        object.setOpttype((long) 2);
        object.setTransperson(((FUserDetail) this.getLoginUser()).getUsercode());
        object.setReceivedate(new Date(System.currentTimeMillis()));
        return EDIT;
    }

    // 登记遗失
    public String reglost() {
        String wpid = object.getWpid();
        object.clearProperties();
        object = new Podetainwptransinfo();
        object.setWpid(wpid);
        keyword = "遗失";
        wpinfo = this.podetainwpbasicinfoManager
                .getObjectById(object.getWpid());
        object.setOpttype((long) 3);
        return EDIT;
    }

    // 销毁
    public String destroy() {
        String wpid = object.getWpid();
        object.clearProperties();
        object = new Podetainwptransinfo();
        object.setWpid(wpid);
        keyword = "销毁";
        wpinfo = this.podetainwpbasicinfoManager
                .getObjectById(object.getWpid());
        object.setOpttype((long) 4);
        return EDIT;
    }

    // 保存
    public String save() {
        object.setOptperson(((FUserDetail) this.getLoginUser()).getUsercode());// 操作人员
        object.setOptdate(new Date(System.currentTimeMillis()));// 操作日期
        this.podetainwptransinfoManager.saveObject(object);
        wpinfo.setWpstate(object.getOpttype().toString());// 修改基本表的状态位;
        switch (object.getOpttype().intValue()) {
        case 1:
            wpinfo.setWpcurrentlocation(object.getTranslocation());
            break;
        case 2:
            wpinfo.setWpcurrentlocation(object.getTranslocation());
            break;
        case 3:
            wpinfo.setWpcurrentlocation("");
            break;
        case 4:
            wpinfo.setWpcurrentlocation("");
            break;
        }
        this.podetainwpbasicinfoManager.saveObject(wpinfo);
        return list();
    }

    // 返回暂扣品列表
    public String list() {
        return "wplist";
    }
}
