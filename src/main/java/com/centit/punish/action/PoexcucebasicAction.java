package com.centit.punish.action;

import com.centit.punish.po.Poexcucebasic;
import com.centit.punish.po.Pounwitnessbasic;
import com.centit.punish.po.Powitnessbasic;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PoexcucebasicManager;
import com.centit.punish.service.PounwitnessbasicManager;
import com.centit.punish.service.PowitnessbasicManager;
import com.centit.punish.service.PunishobjectbasicManager;

public class PoexcucebasicAction extends PunishCommonBizAction<Poexcucebasic> {
    private static final long serialVersionUID = 1L;
    private PoexcucebasicManager poexcucebasicMag;

    public void setPoexcucebasicManager(PoexcucebasicManager basemgr) {
        poexcucebasicMag = basemgr;
        this.setBaseEntityManager(poexcucebasicMag);
    }

    private Powitnessbasic powitnessbasic;
    private PowitnessbasicManager powitnessbasicManager;
    private Pounwitnessbasic pounwitnessbasic;
    private PounwitnessbasicManager pounwitnessbasicManager;
    private PunishobjectbasicManager punishobjectbasicManager;
    private Punishobjectbasic punishobjectbasic;

    public void setPunishobjectbasicManager(
            PunishobjectbasicManager punishobjectbasicManager) {
        this.punishobjectbasicManager = punishobjectbasicManager;
    }

    public Punishobjectbasic getPunishobjectbasic() {
        return punishobjectbasic;
    }

    public void setPunishobjectbasic(Punishobjectbasic punishobjectbasic) {
        this.punishobjectbasic = punishobjectbasic;
    }

    public void setPounwitnessbasicManager(
            PounwitnessbasicManager pounwitnessbasicManager) {
        this.pounwitnessbasicManager = pounwitnessbasicManager;
    }

    public void setPowitnessbasicManager(
            PowitnessbasicManager powitnessbasicManager) {
        this.powitnessbasicManager = powitnessbasicManager;
    }

    public Powitnessbasic getPowitnessbasic() {
        return powitnessbasic;
    }

    public void setPowitnessbasic(Powitnessbasic powitnessbasic) {
        this.powitnessbasic = powitnessbasic;
    }

    private String fs;

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String csSbTz() {

        pounwitnessbasic = pounwitnessbasicManager.getObjectById(object
                .getPunishobjectid());
        powitnessbasic = powitnessbasicManager.getObjectById(object
                .getPunishobjectid());
        Poexcucebasic dbobject = poexcucebasicMag.getObjectById(object
                .getPunishobjectid());
        if (dbobject != null) {
            fs = "C";
            object = dbobject;
        }
        if (pounwitnessbasic != null)
            fs = "F";
        if (powitnessbasic != null)
            fs = "T";
        initalOptProcInfo();
        return "csSbTz";
    }

    public String saveCs() {
        try {
            Poexcucebasic dbobject = poexcucebasicMag.getObjectById(object
                    .getPunishobjectid());
            if (dbobject != null) {
                dbobject.copyNotNullProperty(object);
                object = dbobject;
            }

            poexcucebasicMag.saveObject(object);
            powitnessbasicManager.deleteObjectById(object.getPunishobjectid());
            pounwitnessbasicManager
                    .deleteObjectById(object.getPunishobjectid());

            super.saveOpt();
            return "refreshTasks";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    public String submitCs() {
        try {
            this.saveCs();
            punishobjectbasic = punishobjectbasicManager.getObjectById(object
                    .getPunishobjectid());
            punishobjectbasic.setPocontrovertype((long) 0);
            punishobjectbasicManager.saveObject(punishobjectbasic);
            super.initalOptNewlyIdea(
                    (long) 1,
                    "陈述申辩、听证",
                    (long) 10,
                    "/punish/poexcucebasic!view.do?punishobjectid="
                            + object.getPunishobjectid());
            return super.submitOpt();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

}
