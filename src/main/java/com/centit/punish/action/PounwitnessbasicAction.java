package com.centit.punish.action;

import java.util.Date;

import com.centit.punish.po.Pounwitnessbasic;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PoexcucebasicManager;
import com.centit.punish.service.PounwitnessbasicManager;
import com.centit.punish.service.PowitnessbasicManager;
import com.centit.punish.service.PunishobjectbasicManager;
import com.centit.sys.security.FUserDetail;

public class PounwitnessbasicAction extends
        PunishCommonBizAction<Pounwitnessbasic> {
    private static final long serialVersionUID = 1L;
    private PounwitnessbasicManager pounwitnessbasicMag;
    private PoexcucebasicManager poexcucebasicManager;
    private PowitnessbasicManager powitnessbasicManager;
    private Punishobjectbasic punishobjectbasic;

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

    private PunishobjectbasicManager punishobjectbasicManager;

    public void setPoexcucebasicManager(
            PoexcucebasicManager poexcucebasicManager) {
        this.poexcucebasicManager = poexcucebasicManager;
    }

    public void setPounwitnessbasicMag(
            PounwitnessbasicManager pounwitnessbasicMag) {
        this.pounwitnessbasicMag = pounwitnessbasicMag;
    }

    public void setPowitnessbasicManager(
            PowitnessbasicManager powitnessbasicManager) {
        this.powitnessbasicManager = powitnessbasicManager;
    }

    public void setPounwitnessbasicManager(PounwitnessbasicManager basemgr) {
        pounwitnessbasicMag = basemgr;
        this.setBaseEntityManager(pounwitnessbasicMag);
    }

    public String saveNoTz() {
        try {
            Pounwitnessbasic dbobject = pounwitnessbasicMag
                    .getObjectById(object.getPunishobjectid());
            if (dbobject != null) {
                dbobject.copyNotNullProperty(object);
                object = dbobject;
            }
            FUserDetail fUserDetail = (FUserDetail) getLoginUser();
            object.setUnwitnessdate(new Date());
            object.setEnregisterid(fUserDetail.getUsercode());
            pounwitnessbasicMag.saveObject(object);
            poexcucebasicManager.deleteObjectById(object.getPunishobjectid());
            powitnessbasicManager.deleteObjectById(object.getPunishobjectid());
            super.saveOpt();
            return "refreshTasks";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    public String submitNoTz() {
        try {
            this.saveNoTz();
            punishobjectbasic = punishobjectbasicManager.getObjectById(object
                    .getPunishobjectid());
            punishobjectbasic.setPocontrovertype((long) 2);
            punishobjectbasicManager.saveObject(punishobjectbasic);
            super.initalOptNewlyIdea(
                    (long) 1,
                    "陈述申辩、听证",
                    (long) 10,
                    "/punish/pounwitnessbasic!view.do?punishobjectid="
                            + object.getPunishobjectid());
            return super.submitOpt();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

}
