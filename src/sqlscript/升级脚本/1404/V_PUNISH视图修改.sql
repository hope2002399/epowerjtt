create or replace view v_punish as
select distinct M_Punish.No,M_Punish.Content,M_Punish.Chang_No,M_Punish.Org_Id,M_Punish.Internal_No,M_Punish.Item_Id,M_Punish.Department,
M_Punish.Punish_Target,M_Punish.Istrack,M_Punish.Target_Type,M_Punish.Fact,M_Punish.Source, M_Punish.Create_Date, case when M_Punish.Isrisk = 1 then 1 when M_Punish.Isrisk != 1 and M_PunishProcess.isrisk = 1 then 2 else 0 end Isrisk,
b_power.item_type, V_HI_UNITINFO.topunitcode,M_PunishResult.Finish_Date ,b_power.version,V_HI_UNITINFO.unitcode
,case when outway.monitor_style = '0' then '3' else outway.monitor_style end monitor_style, M_PunishResult.Punish_Deside From M_Punish
left join m_punishprocess on M_Punish.internal_No = m_punishprocess.internal_No and M_Punish.Org_Id = m_punishprocess.org_id
left join M_PunishResult  on M_Punish.internal_No = M_PunishResult.internal_No and M_Punish.Org_Id = M_PunishResult.Org_Id
             left join b_power on M_Punish.item_id = b_power.item_id
             left join V_HI_UNITINFO on  M_Punish.org_id = V_HI_UNITINFO.depno
              left join (select t.bj_type,t.bj_no,t.internal_no,t.org_id,t.item_id,max(case when t.monitor_style = '3' then '0' else t.monitor_style end ) monitor_style from m_outway t where t.outtime is null group by t.bj_type,t.bj_no,t.internal_no,t.org_id,t.item_id)  outway on outway.bj_no = M_Punish.no and outway.bj_type='2'
             where (b_power.version <> 0 and b_power.begin_time <= sysdate and (b_power.end_time is null or b_power.end_time >sysdate)) or b_power.item_id is null;
