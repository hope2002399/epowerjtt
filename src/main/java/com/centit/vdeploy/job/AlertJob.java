package com.centit.vdeploy.job;

import java.util.Date;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;





public class AlertJob{

    public int sendSMS(String phones,String content){
        
        Service srvcModel = null;
        XFireProxyFactory factory = null;
        IjstshWebService srvc = null;
        String fasrid = null; //发送人id
       // String phones = ""; //手机号
        String suosdq = "省厅应急指挥"; //所属地区
        //String content = ""; //短信内容
        Date yaoqfssj = new Date(); //要求发送时间
        Date jilsj = new Date(); //记录时间
        String yingy = "jttesb"; //应用
        String fasrmc = "应急指挥"; // 发送人名称
        String kuozm = "63"; //拓展码
        int returnMsg = -1;
        //发短信的URL地址
        //String WebServiceURL = "http://192.168.2.180:7001/jstsh/service/IjstshWebService";
        String WebServiceURL = "http://10.1.30.94:7141/jstsh/service/IjstshWebService";
        //String WebServiceURL = "http://221.226.4.186:7001/jstsh/service/IjstshWebService";
        try {
            srvcModel = new ObjectServiceFactory()
                    .create(IjstshWebService.class);
            factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
            
            srvc = (IjstshWebService) factory.create(srvcModel, WebServiceURL);
            //返回的returnMsg就是发送结果状态
            returnMsg = srvc.sendMessages(fasrid, phones, suosdq, content, yaoqfssj, jilsj, yingy, fasrmc, kuozm);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            srvcModel = null;
            factory = null;
            srvc = null;
        }
  

        
        return returnMsg;
    }
}
