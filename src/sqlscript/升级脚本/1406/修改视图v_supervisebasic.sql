create or replace view v_supervisebasic as
select a.*,
       case
         when a.promise_Date < sysdate and r.process_date is null then 'no_receipt_overtime'
         when r.supervise_no is null then 'no_receipt'
         when a.promise_Date >= r.process_date then  'receipt_intime'
         when a.promise_Date < r.process_date then 'overtime_receipt'
         when t.end_date is null then 'no_result'

       end state,t.is_external,o.monitor_source, u.depno
  From m_supervisebasic a
  left join m_outway o on o.outwayno = a.outwayid

  left join (select MAX(r1.processno) as processno from m_supervisereply r1 group by r1.supervise_no) r2
  left join m_supervisereply r on r.processno = r2.processno

  --left join m_supervisereply r
    on a.supervise_no = r.supervise_no
  left join m_superviseresult t
    on a.supervise_no = t.supervise_no
    
  left join f_unitinfo u on a.monitor_org_id = u.unitcode;
