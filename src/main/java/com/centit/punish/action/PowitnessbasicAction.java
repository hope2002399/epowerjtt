package com.centit.punish.action;

import com.centit.punish.po.Powitnessbasic;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PoexcucebasicManager;
import com.centit.punish.service.PounwitnessbasicManager;
import com.centit.punish.service.PowitnessbasicManager;
import com.centit.punish.service.PunishobjectbasicManager;

public class PowitnessbasicAction extends PunishCommonBizAction<Powitnessbasic> {
    private static final long serialVersionUID = 1L;
    private PowitnessbasicManager powitnessbasicMag;
    private PounwitnessbasicManager pounwitnessbasicManager;
    private PoexcucebasicManager poexcucebasicManager;

    public Punishobjectbasic getPunishobjectbasic() {
        return punishobjectbasic;
    }

    public void setPunishobjectbasic(Punishobjectbasic punishobjectbasic) {
        this.punishobjectbasic = punishobjectbasic;
    }

    public void setPunishobjectbasicManager(
            PunishobjectbasicManager punishobjectbasicManager) {
        this.punishobjectbasicManager = punishobjectbasicManager;
    }

    private Punishobjectbasic punishobjectbasic;
    private PunishobjectbasicManager punishobjectbasicManager;

    public void setPowitnessbasicMag(PowitnessbasicManager powitnessbasicMag) {
        this.powitnessbasicMag = powitnessbasicMag;
    }

    public void setPoexcucebasicManager(
            PoexcucebasicManager poexcucebasicManager) {
        this.poexcucebasicManager = poexcucebasicManager;
    }

    public void setPounwitnessbasicManager(
            PounwitnessbasicManager pounwitnessbasicManager) {
        this.pounwitnessbasicManager = pounwitnessbasicManager;
    }

    public void setPowitnessbasicManager(PowitnessbasicManager basemgr) {
        powitnessbasicMag = basemgr;
        this.setBaseEntityManager(powitnessbasicMag);
    }

    public String saveTz() {
        try {
            Powitnessbasic dbobject = powitnessbasicMag.getObjectById(object
                    .getPunishobjectid());
            if (dbobject != null) {
                dbobject.copyNotNullProperty(object);
                object = dbobject;
            }
            powitnessbasicMag.saveObject(object);
            poexcucebasicManager.deleteObjectById(object.getPunishobjectid());
            pounwitnessbasicManager
                    .deleteObjectById(object.getPunishobjectid());
            super.saveOpt();
            return "refreshTasks";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    public String submitTz() {
        try {
            this.saveTz();
            punishobjectbasic = punishobjectbasicManager.getObjectById(object
                    .getPunishobjectid());
            punishobjectbasic.setPocontrovertype((long) 1);
            punishobjectbasicManager.saveObject(punishobjectbasic);
            super.initalOptNewlyIdea(
                    (long) 1,
                    "陈述申辩、听证",
                    (long) 10,
                    "/punish/powitnessbasic!view.do?punishobjectid="
                            + object.getPunishobjectid());
            return super.submitOpt();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

}
