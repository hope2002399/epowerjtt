package com.centit.powerbase.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.centit.powerbase.service.PunishrecordManager;

public class RecordJob extends QuartzJobBean {
    private PunishrecordManager punishRecordManager;

    public void setPunishRecordManager(PunishrecordManager punishRecordManager) {
        this.punishRecordManager = punishRecordManager;
    }

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        
        System.out
                .println("--------------------begin---------------------------");
        punishRecordManager.initPunishRecords("");
        System.out
                .println("--------------------end---------------------------");
    }
}
