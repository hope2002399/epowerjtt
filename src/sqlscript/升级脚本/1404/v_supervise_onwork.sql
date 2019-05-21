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
       e.biztype,
       e.monitor_source
  from v_supervise_biz_common e
  left join (select MAX(r2.processno) as processno from m_supervisereply r2 group by r2.supervise_no) p2
  left join m_supervisereply p on p.processno = p2.processno
    on p.supervise_no = e.supervise_no
 where e.biztype = 'T';
