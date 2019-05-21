 alter table b_power add (
                APPLY_FORM_DEMO_NAME varchar2(200)); 
                
                
                
 --更改v_opt_apply_info 增加flowinstid字段
                
 create or replace view v_opt_apply_info as
select a.dj_id,a.apply_date,a.proposer_name,a.apply_item_type,a.apply_reason,
a.apply_way,a.proposer_type,a.proposer_paper_type,a.proposer_paper_code,a.proposer_phone,a.proposer_mobile,a.proposer_addr,a.proposer_zipcode,a.proposer_email,
a.proposer_unitcode,a.agent_name,a.agent_paper_type,a.agent_paper_code,a.agent_phone,a.agent_mobile,a.agent_addr,a.agent_zipcode,a.agent_email,a.agent_unitcode,
a.apply_memo,a.accept_date,a.auditing_date,a.head_usercode,a.head_auditing_idea,a.check_idea_date,a.check_usercode,a.check_idea,a.check_detail,a.check_addr,
a.check_date,a.check_memo,a.book_date,b.transaffairno,b.transaffairname,b.orgcode,b.orgname,b.powerid,b.powername,b.biztype,b.flowinstid
 from opt_apply_info a join opt_base_info b on a.dj_id = b.dj_id order by a.apply_date desc;