create or replace view v_sr_apply_user as
select dj_id,
channel_name,
       channel_level,
       Elevation_system,
       APPLY_DATE,
       PROPOSER_NAME,
       APPLY_ITEM_type,
       APPLY_REASON,
       APPLY_WAY,
       PROPOSER_TYPE,
       PROPOSER_PAPER_TYPE,
       PROPOSER_PAPER_CODE,
       PROPOSER_PHONE,
       PROPOSER_MOBILE,
       PROPOSER_ADDR,
       PROPOSER_ZIPCODE,
       PROPOSER_EMAIL,
       PROPOSER_UNITCODE,
       AGENT_NAME,
       AGENT_PAPER_TYPE,
       AGENT_PAPER_CODE,
       AGENT_PHONE,
       AGENT_MOBILE,
       AGENT_ADDR,
       AGENT_ZIPCODE,
       AGENT_EMAIL,
       AGENT_UNITCODE,
       APPLY_MEMO
  from opt_apply_info
 where dj_id in (select max(DJ_ID) as dj_id
                   from opt_apply_info
                  group by PROPOSER_UNITCODE, PROPOSER_PAPER_CODE);
                  


