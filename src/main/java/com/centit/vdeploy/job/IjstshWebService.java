package com.centit.vdeploy.job;

import java.util.Date;

public interface IjstshWebService {
    /**
     * 短信发送 web service （支持群发） 
     * @param fasrid 发送人ID (null)
     * @param fasrmc 发送人名称 (请填写“应急指挥”) 
     * @param phone 手机号（多个号码以","分开）(not null)
     * @param suosdq 所属地区 (null)(请填写“省厅应急指挥”)
     * @param content 短信内容 (not null)
     * @param yaoqfssj 要求发送时间 (null)
     * @param jilsj 记录时间 (not null)
     * @param yingy 应用 (not null) (请填写“应急指挥”)
     * @param kuozm 扩展码 (null)  (请填写“63”)
     * @return 0 短信超额 1 存在敏感词 2 手机号有误 3 ERROR 4 SUCCESS
     * @throws SysException
     */
    public int sendMessages(String fasrid, String phones, String suosdq,
            String content, Date yaoqfssj, Date jilsj, String yingy,String fasrmc,String kuozm);

}
