package com.centit.punish.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.punish.po.Podiscussbasic;
import com.centit.punish.po.VPODiscuss;

public interface PodiscussbasicManager extends
        BaseEntityManager<Podiscussbasic> {
    public VPODiscuss getVPODiscussByCid(String Punishobjectid,
            Long podiscusstype);

    public String getPunishClassID(String punishobjectid);

    public String getDegreeNoByCon(String punishObjectID, String punishClassId);

    public void savepunishBasicInfo(String punishobjectid,
            String podiscusstype, String punishclassid, String[] freeumpire,
            String issurpass, String punisnclassnum, String degreeno,
            Podiscussbasic discuss);

    public void saveDiscussbase(Podiscussbasic podiscussbasic);
}
