create or replace view v_apply as
select distinct Apply.No,Apply.Transact_Affair_Name,Apply.Chang_No,Apply.Org_Id,Apply.Internal_No,Apply.Item_Id,Apply.Department,Apply.Applicant_Name,
apply.istrack,Apply.Applicant_Type, Apply.Apply_Date,
 case when Apply.Isrisk = 1 then 1 when Apply.Isrisk != 1 and m_applyprocess.isrisk = 1 then 2 else 0 end Isrisk,
substr(Apply.item_id,-7,2) item_type, V_HI_UNITINFO.topunitcode,ApplyResult.Finish_Time,b_power.version,income_doc.accept_no,income_doc.income_doc_no,dispatch_doc.dispatch_doc_no
, outway.monitor_style, maxprocess.status maxstatus, ApplyResult.status, V_HI_UNITINFO.unitcode
 From M_Apply Apply
left join m_applyprocess on Apply.internal_No = m_applyprocess.internal_No and Apply.item_Id = m_applyprocess.item_Id
left join (select  t.internal_no, t.item_id,t.no_ord,max(t.status) status from m_applyprocess t where ( t.internal_no, t.item_id,t.no_ord) in (select p.internal_no, p.item_id, max(p.no_ord) no_ord from m_applyprocess p group by p.internal_no, p.item_id) group by t.internal_no, t.item_id,t.no_ord) maxprocess on
Apply.internal_No = maxprocess.internal_No and Apply.item_Id = maxprocess.item_Id
left join M_ApplyResult ApplyResult on Apply.internal_No = ApplyResult.internal_No and Apply.item_Id = ApplyResult.item_Id
             left join b_power on Apply.item_id = b_power.item_id
             left join V_HI_UNITINFO on  Apply.org_id = V_HI_UNITINFO.depno
             left join m_income_doc income_doc on income_doc.internal_no = Apply.internal_no and income_doc.item_id = Apply.item_id
             left join m_dispatch_doc dispatch_doc on dispatch_doc.internal_no = Apply.internal_no and dispatch_doc.item_id = Apply.item_id
             left join (select t.bj_type,t.bj_no,t.internal_no,t.item_id,max(case when t.monitor_style = '3' then '0' else t.monitor_style end ) monitor_style from m_outway t where t.outtime is null group by t.bj_type,t.bj_no,t.internal_no,t.item_id)  outway on outway.bj_no = apply.no  and outway.bj_type='1'
  where (b_power.version <> 0 and b_power.begin_time <= sysdate and (b_power.end_time is null or b_power.end_time >sysdate)) or b_power.item_id is null;
