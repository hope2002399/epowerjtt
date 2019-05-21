package com.centit.punish.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerbase.po.Pcfreeumpiretype;
import com.centit.powerbase.service.PcfreeumpiretypeManager;
import com.centit.punish.po.Pcdef;
import com.centit.punish.po.Pctype;
import com.centit.punish.service.PcdefManager;
import com.centit.punish.service.PctypeManager;

/**
 * 
 * TODO Class description should be added
 * 
 * @author sj
 * @create 2012-12-11
 * @version
 */
public class PctypeAction extends BaseEntityExtremeAction<Pctype> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(PctypeAction.class);
    private static final long serialVersionUID = 1L;
    private PctypeManager pctypeMag;
    private PcdefManager pcdefManager;
    private PcfreeumpiretypeManager pcfreeumpiretypeManager;

    private String punishclassname;// 处罚项目名称
    private String punishclasscode;
    private String rate;

    List<Pcfreeumpiretype> pcfreeumpiretypeList = new ArrayList<Pcfreeumpiretype>();
    private List<Pctype> pctypesList = new ArrayList<Pctype>();

    public void setPctypeManager(PctypeManager basemgr) {
        pctypeMag = basemgr;
        this.setBaseEntityManager(pctypeMag);
    }

    public void setPcdefManager(PcdefManager pcdefManager) {
        this.pcdefManager = pcdefManager;
    }

    public void setPcfreeumpiretypeManager(
            PcfreeumpiretypeManager pcfreeumpiretypeManager) {
        this.pcfreeumpiretypeManager = pcfreeumpiretypeManager;
    }

    public String getPunishclasscode() {
        return punishclasscode;
    }

    public void setPunishclasscode(String punishclasscode) {
        this.punishclasscode = punishclasscode;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public List<Pctype> getPctypesList() {
        return pctypesList;
    }

    public void setPctypesList(List<Pctype> pctypesList) {
        this.pctypesList = pctypesList;
    }

    private List<Pcfreeumpiretype> pcfreeumpiretypes;

    public List<Pcfreeumpiretype> getNewPcfreeumpiretypes() {
        return this.pcfreeumpiretypes;
    }

    public void setNewPcfreeumpiretypes(List<Pcfreeumpiretype> pcfreeumpiretypes) {
        this.pcfreeumpiretypes = pcfreeumpiretypes;
    }

    public String getPunishclassname() {
        return punishclassname;
    }

    public void setPunishclassname(String punishclassname) {
        this.punishclassname = punishclassname;
    }

    @Override
    public String save() {
        if ("false".equals(rate)) {
            object.setIsrate(Long.parseLong("0"));
        } else {
            object.setIsrate(Long.parseLong("1"));
        }
        Pctype pctype = pctypeMag.getObjectByItemsId(object.getPunishclassid(),
                object.getPunishtypeid());
        if (pctype != null) {
            pctypeMag.copyObjectNotNullProperty(pctype, object);
            object = pctype;
        }
        object.setIsinuse(Long.parseLong("1"));
        pctypeMag.saveObject(object);
        Pcdef pcdefobj = this.pcdefManager.getObjectById(object
                .getPunishclassid());
        punishclasscode = pcdefobj.getPunishclasscode();
        savedMessage();
        return "scucessedit";
    }

    public String listPcType() {

        pctypesList = pctypeMag.listPcType(object.getPunishclassid());

        return "viewpctype";
    }

    @Override
    public String edit() {
        Pcdef pcdef = pcdefManager.getObjectById(object.getPunishclassid());
        punishclassname = pcdef.getPunishclassname();// 获取处罚项目名称
        // Punishtypeid为空，则为新增
        if (StringUtils.isNotBlank(object.getPunishtypeid())) {
            object = pctypeMag.getObjectByItemsId(object.getPunishclassid(),
                    object.getPunishtypeid());

        } else {
            object.setPunishclassid(object.getPunishclassid());

        }
        return EDIT;
    }

    /**
     * 是否禁止操作
     * 
     * @return
     */

    public String editIsInUse() {
        object = pctypeMag.getObjectByItemsId(object.getPunishclassid(),
                object.getPunishtypeid());
        if (object.getIsinuse() == 1) {
            object.setIsinuse(Long.parseLong("0"));
        } else {
            object.setIsinuse(Long.parseLong("1"));
        }
        pctypeMag.saveObject(object);

        return this.listPcType();
    }

    /**
     * 是否在禁止处罚种类时，禁止相应的自由裁量处罚种类
     * 
     * @return
     */

    public String editFreeumpireTypeIsInUse() {
        object = pctypeMag.getObjectByItemsId(object.getPunishclassid(),
                object.getPunishtypeid());
        if (object.getIsinuse() == 1) {
            object.setIsinuse(Long.parseLong("0"));
        } else {
            object.setIsinuse(Long.parseLong("1"));
        }
        pctypeMag.saveObject(object);

        pcfreeumpiretypeList = pcfreeumpiretypeManager
                .getPCFreeUmpireTypeListByClassID(object.getPunishclassid(),
                        null, object.getPunishtypeid());// ////////////
        if (pcfreeumpiretypeList.size() > 0) {
            pcfreeumpiretypeManager.updatepcfreeumpiretype(0,
                    object.getPunishtypeid(), object.getIsinuse());// ///////////

        }

        return this.listPcType();

    }
}
