package com.centit.monitor.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.centit.monitor.po.SmsLog;
import com.centit.monitor.service.SendMessageManager;
import com.centit.powerruntime.service.OptApplyNetManager;
import com.centit.vdeploy.job.AlertJob;

/**
 * 
 * 预报警规则定时任务
 * 
 * @author jf
 * @create 2014-2-20
 * @version
 */
public class SendMessageJob extends QuartzJobBean {


    private SendMessageManager sendMessageManager;
    
    private OptApplyNetManager optApplyNetManager;

    public SendMessageManager getSendMessageManager() {
        return sendMessageManager;
    }

    public void setSendMessageManager(SendMessageManager sendMessageManager) {
        this.sendMessageManager = sendMessageManager;
    }

    public OptApplyNetManager getOptApplyNetManager() {
        return optApplyNetManager;
    }

    public void setOptApplyNetManager(OptApplyNetManager optApplyNetManager) {
        this.optApplyNetManager = optApplyNetManager;
    }




    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        AlertJob alertJob = new AlertJob();
        List<Object[]> list = optApplyNetManager.getSendMessageInfo();
        for(int i= 0;i < list.size();i++){
            SmsLog smsLog = new SmsLog();
            int returnStatus = -1;
            String status = "F";
            String phone = "";
            if(list.get(i)[3] != null){
                phone = list.get(i)[3] + "";
                returnStatus = alertJob.sendSMS(phone, "您有新的未受理办件");
            }else if(list.get(i)[4] != null){
                phone = list.get(i)[4] + "";
                returnStatus = alertJob.sendSMS(phone, "您有新的未受理办件");
            }
            if(returnStatus == 4){
                status = "Y";
            }
            smsLog.setSmsSendReturnStatus(returnStatus + "");
            smsLog.setId("SMSLOG" + System.currentTimeMillis());
            smsLog.setNetId(list.get(i)[8] + "");
            smsLog.setSmsContent("您有新的未受理办件");
            smsLog.setSmsNames(list.get(i)[1] + "");
            smsLog.setSmsPhones(phone);
            smsLog.setSmsSendstatus(status);
            smsLog.setSmsType("1");
            smsLog.setSmsUsercodes(list.get(i)[0] + "");
            sendMessageManager.insertSendSMSLog(smsLog);
        }
       
    }

}
