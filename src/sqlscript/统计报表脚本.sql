--Ȩ������ֲ�ͳ��
select nvl(f.unitname,c.org_id) as unitname , nvl(d.datavalue,c.ITEM_TYPE) as item_type,
       nvl(nvl(e.datavalue,c.chg_type),'δ֪') as item_state, c.pSum
from 
  (select b.ORG_ID,b.ITEM_TYPE,a.chg_type , count(1) as pSum
  from B_PowerStateChgLog a join B_Power b on a.ITEM_ID=b.ITEM_ID and a.version=b.version
  where a.begin_time <= sysdate and (a.end_time is null or a.end_time > sysdate) 
  group by b.ORG_ID,b.ITEM_TYPE,a.chg_type) c 
  left join (select datacode,datavalue from f_datadictionary where catalogcode='ITEM_TYPE') d on (c.ITEM_TYPE=d.datacode)
  left join (select datacode,datavalue from f_datadictionary where catalogcode='QL_State') e on (c.chg_type=e.datacode)
  left join f_unitinfo f  on (c.ORG_ID=f.unitcode)
order by c.ORG_ID,c.ITEM_TYPE,c.chg_type 

select a.DATAVALUE as IT, b.DATAVALUE as QS
from f_datadictionary a, f_datadictionary b 
where a.catalogcode='ITEM_TYPE' and b.catalogcode='QL_State' and  b.datacode<>'U'
order by a.extracode2,b.extracode2



select nvl(f.unitname,c.org_id) as unitname , nvl(d.datavalue,c.ITEM_TYPE) as item_type,
        c.pSum
from 
  (select b.ORG_ID,b.ITEM_TYPE, count(1) as pSum
  from B_PowerStateChgLog a join B_Power b on a.ITEM_ID=b.ITEM_ID and a.version=b.version
  where a.begin_time <= sysdate and (a.end_time is null or a.end_time > sysdate) 
  group by b.ORG_ID,b.ITEM_TYPE) c 
  left join (select datacode,datavalue from f_datadictionary where catalogcode='ITEM_TYPE') d on (c.ITEM_TYPE=d.datacode)
  left join f_unitinfo f  on (c.ORG_ID=f.unitcode)
order by c.ORG_ID,c.ITEM_TYPE
  
select DATAVALUE from f_datadictionary where catalogcode='ITEM_TYPE' order by extracode2

-- Ȩ������ͳ�� 

-- ��ʾһ��ʱ���ڵǼ�

select nvl(f.unitname,c.org_id) as unitname , nvl(d.datavalue,c.ITEM_TYPE) as item_type,
        c.pSum
from (
  select a.org_id,  substr(a.item_id,-7,2) as ITEM_TYPE, count(1) as pSum
  from m_apply a
  where a.CREATE_DATE >= to_date('2012-09-01','yyyy-mm-dd') and a.CREATE_DATE < to_date('2012-10-01','yyyy-mm-dd')
  group by a.org_id,  substr(a.item_id,-7,2) 
  union all
  select a.org_id, 'CF' /* substr(a.item_id,-7,2)*/ as ITEM_TYPE, count(1) as pSum
  from m_punish a
  where a.CREATE_DATE >= to_date('2012-09-01','yyyy-mm-dd') and a.CREATE_DATE < to_date('2012-10-01','yyyy-mm-dd')
  group by a.org_id --,  substr(a.item_id,-7,2) 
  ) c 
  left join (select datacode,datavalue from f_datadictionary where catalogcode='ITEM_TYPE') d on (c.ITEM_TYPE=d.datacode)
  left join f_unitinfo f  on (c.ORG_ID=f.unitcode)
order by c.ORG_ID

select DATAVALUE from f_datadictionary where catalogcode='ITEM_TYPE' order by extracode2
/*
1	1	�����������
2	10	����ȷ������
3	11	������������
4	2	������������
5	3	������������
6	4	����Ȩ��
7	5	������������
8	6	������������
9	7	����ǿ������
10	8	������������
11	9	������������
*/

-- ��ʾһ��ʱ���ڰ���
select nvl(f.unitname,c.org_id) as unitname , nvl(d.datavalue,c.ITEM_TYPE) as item_type,
        c.pSum
from (
  select a.org_id,  substr(a.item_id,-7,2) as ITEM_TYPE, count(1) as pSum
  from M_ApplyResult a
  where a.FINISH_TIME >= to_date('2012-09-01','yyyy-mm-dd') and a.FINISH_TIME < to_date('2012-10-01','yyyy-mm-dd')
  group by a.org_id,  substr(a.item_id,-7,2) 
  union all
  select a.org_id, 'CF' /* substr(a.item_id,-7,2)*/ as ITEM_TYPE, count(1) as pSum
  from M_PunishResult a
  where a.FINISH_DATE >= to_date('2012-09-01','yyyy-mm-dd') and a.FINISH_DATE < to_date('2012-10-01','yyyy-mm-dd')
  group by a.org_id --,  substr(a.item_id,-7,2) 
  ) c 
  left join (select datacode,datavalue from f_datadictionary where catalogcode='ITEM_TYPE') d on (c.ITEM_TYPE=d.datacode)
  left join f_unitinfo f  on (c.ORG_ID=f.unitcode)
order by c.ORG_ID

select DATAVALUE from f_datadictionary where catalogcode='ITEM_TYPE' order by extracode2
-- δ����

select nvl(f.unitname,c.org_id) as unitname , nvl(d.datavalue,c.ITEM_TYPE) as item_type,
        c.pSum
from (
  select a.org_id,  substr(a.item_id,-7,2) as ITEM_TYPE, count(1) as pSum
  from m_apply a left join M_ApplyResult b on (a.Internal_no=b.internal_no and a.item_id=b.item_id)
  where b.internal_no is null --and a.CREATE_DATE >= to_date('2012-09-01','yyyy-mm-dd') and a.CREATE_DATE < to_date('2012-10-01','yyyy-mm-dd')
  group by a.org_id,  substr(a.item_id,-7,2) 
  union all
  select a.org_id, 'CF' /* substr(a.item_id,-7,2)*/ as ITEM_TYPE, count(1) as pSum
  from m_punish a left join M_PunishResult b on (a.Internal_no=b.internal_no and a.item_id=b.item_id)
  where b.internal_no is null --and a.CREATE_DATE >= to_date('2012-09-01','yyyy-mm-dd') and a.CREATE_DATE < to_date('2012-10-01','yyyy-mm-dd')
  group by a.org_id --,  substr(a.item_id,-7,2) 
  ) c 
  left join (select datacode,datavalue from f_datadictionary where catalogcode='ITEM_TYPE') d on (c.ITEM_TYPE=d.datacode)
  left join f_unitinfo f  on (c.ORG_ID=f.unitcode)
order by c.ORG_ID

select DATAVALUE from f_datadictionary where catalogcode='ITEM_TYPE' order by extracode2
--- Ԥ����ͳ�Ʊ���

select nvl(f.unitname,c.org_id) as unitname , nvl(d.datavalue,c.MONITOR_TYPE) as MONITOR_TYPE,
        nvl(e.datavalue,c.MONITOR_STYLE) as MONITOR_STYLE,c.pSum
from (
  select ORG_ID,MONITOR_TYPE,MONITOR_STYLE , count(1) as psum
  from M_OutWay
  where  /*δժ�Ƶ�*/ OutWayState='1' and InTime >= to_date('2012-09-01','yyyy-mm-dd') and InTime < to_date('2013-10-01','yyyy-mm-dd')
  group by ORG_ID,MONITOR_TYPE,MONITOR_STYLE
 ) c 
  left join (select datacode,datavalue from f_datadictionary where catalogcode='MONITOR_TYPE') d on (c.MONITOR_TYPE=d.datacode)
  left join (select datacode,datavalue from f_datadictionary where catalogcode='MONITOR_STYLE') e on (c.MONITOR_STYLE=e.datacode)
  left join f_unitinfo f  on (c.ORG_ID=f.unitcode)
order by c.ORG_ID


select a.DATAVALUE as IT, b.DATAVALUE as QS
from f_datadictionary a, f_datadictionary b 
where a.catalogcode='MONITOR_TYPE' and b.catalogcode='MONITOR_STYLE' and  b.datacode<>'U'
order by a.extracode2,b.extracode2

---- Ͷ��ͳ�Ʊ���
--��ͨ��
--����	��Ͷ��		����ʱ���� ��ʱ����	��ʱ����	��ʱδ����	Ͷ�ߴ�����	Ͷ����ʵ	������ʵ	Ͷ�߲�ʵ
select a.WERE_COMPLAINTS_ORG_ID, count(1) as be_monitor_times,
       sum(case when a.promise_Date > sysdate and r.RESULT_DATE is null then 1 end) as wait_receipt,
       sum(case when a.promise_Date >= r.RESULT_DATE then 1 end) as receipt_intime,
       sum(case when a.promise_Date < r.RESULT_DATE then 1 end) as receipt_overtime,
       sum(case when a.promise_Date < sysdate and r.RESULT_DATE is null then 1 end) as no_receipt_overtime,
       sum(case when r.ComplaintID is null then 1 end) as in_operate,
       sum(case r.TYPE when '2' then 1 end) as be_verified,
       sum(case r.TYPE when '3' then 1 end) as part_verified,
       sum(case r.TYPE when '1' then 1 end) as not_verified
from M_Complaint a left join M_ComplaintsResult r on (a.ComplaintID = r.ComplaintID)
where a.ComplaintDate >= to_date('2012-09-01','yyyy-mm-dd') and a.ComplaintDate < to_date('2013-10-01','yyyy-mm-dd')
group by a.WERE_COMPLAINTS_ORG_ID

---- ����ͳ�Ʊ���
--��ͨ��
--����	������		����ʱ����	��ʱ����	��ʱ���� ��ʱδ����	���촦����	�����϶�	�����϶�

select a.MONITOR_ORG_ID, count(1) as be_monitor_times,
       sum(case when a.promise_Date > sysdate and r.receipt_Date is null then 1 end) as wait_receipt,
       sum(case when a.promise_Date >= r.receipt_Date then 1 end) as receipt_intime,
       sum(case when a.promise_Date < r.receipt_Date then 1 end) as receipt_overtime,
       sum(case when a.promise_Date < sysdate and r.receipt_Date is null then 1 end) as no_receipt_overtime,
       sum(case when r.supervise_no is null then 1 end) as in_operate,
       sum(case r.CONFIRM when '2' then 1 end) as no_fault,
       sum(case r.CONFIRM when '1' then 1 end) as has_fault
from M_SuperviseBasic a left join M_SuperviseResult r on (a.supervise_no = r.supervise_no)
where a.isOrg = 'T' and /* a.ORG_ID = ? and*/ 
      a.supervise_date >= to_date('2012-09-01','yyyy-mm-dd') and a.supervise_date < to_date('2013-10-01','yyyy-mm-dd')
group by a.MONITOR_ORG_ID



