create or replace view v_orgsuppower as
select  rownum as id, s.ITEM_ID,s.version,p.unitcode as ORG_ID,s.ITEM_NAME  ,s.ITEM_STA_NAME,s.ITEM_TYPE,s.TIME_LIMIT,s.IS_NETWORK,
   s.IS_FORMULA,s.PHONE,s.ADDRESS, s.LASTMODIFYTIME  ,
   s.file_name      ,
   s.audit_Sign,   s.MONITOR_PHONE    ,   s.ACCEPT_LINK    , s.LEGAL_TIME_LIMIT  ,s.CHARGE, FORM_NAME ,
   s.In_Flow_img_Name,
  -- s.ISCHARGE,
    s.PUNISH_CLASS  ,s.Transact_DEPNAME  , s.Promise_Type  ,  s.Anticipate_Type    ,
   s.QL_DepID  , s.QL_DepState ,s.ENTRUST_Name    ,s.QL_State,s.PunishBasis,s.punishobject,
   o.APPLY_ITEM_TYPE,o.GROUP_ID,o.wfcode as optFlowCode,p.wfcode as orgFlowCode,o.riskid,r.risktype,r.riskdes as RISKDESC,r.riskdeal as riskResult, V_HI_UNITINFO.topunitcode
from  b_v_powerinusing s
      left join C_POWER_OPT_INFO o on s.item_id = o.item_id
      left join opt_risk_info r on r.riskid=o.riskid
      left join c_power_org_info p on p.item_id=s.item_id
      left join V_HI_UNITINFO on  s.org_id = V_HI_UNITINFO.depno;
