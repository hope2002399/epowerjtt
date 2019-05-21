create or replace view v_supervisebasic as
select a.*,
       case
         when a.promise_Date < sysdate and r.process_date is null then 'no_receipt_overtime'
         when r.supervise_no is null then 'no_receipt'
         when a.promise_Date >= r.process_date then  'receipt_intime'
         when a.promise_Date < r.process_date then 'overtime_receipt'
         when t.end_date is null then 'no_result'

       end state,t.is_external,o.monitor_source
  From m_supervisebasic a
  left join m_outway o on o.outwayno = a.outwayid

  left join (select MAX(r1.processno) as processno from m_supervisereply r1 group by r1.supervise_no) r2
  left join m_supervisereply r on r.processno = r2.processno

  --left join m_supervisereply r
    on a.supervise_no = r.supervise_no
  left join m_superviseresult t
    on a.supervise_no = t.supervise_no;
    
create or replace view v_supervise_onwork as
select distinct e.supervise_no,e.INTERNAL_NO,
       e.BjName,
       e.bj_type,
       e.bj_no,
       p.processno,
       p.process_name,
       p.process_date,
       p.operator_id as process_operator_id,
       p.operator_opinion,
       p.operator_result,
       e.complaintid,
       e.outwayid,
       e.org_id,
       e.operator_id,
       e.supervise_date,
       e.monitor_org_id,
       e.monitor_operator_id,
       e.supervise_option,
       e.promise_date,
       e.biztype
  from v_supervise_biz_common e
  left join (select MAX(r2.processno) as processno from m_supervisereply r2 group by r2.supervise_no) p2
  left join m_supervisereply p on p.processno = p2.processno
    on p.supervise_no = e.supervise_no
 where e.biztype = 'T';