package com.centit.punish.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.punish.po.Poindividual;

public interface PoindividualManager extends BaseEntityManager<Poindividual> {
    public String generateNextIndividualId();

    public Poindividual getPoindividual(String punishobjectid);
}
