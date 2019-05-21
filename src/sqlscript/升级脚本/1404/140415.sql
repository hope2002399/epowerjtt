create or replace view v_superviseresult as
select r.*, o.org_id,o.monitor_source from M_SuperviseResult r
  left join m_supervisebasic b on r.supervise_no = b.supervise_no
  left join m_outway o on b.outwayid = o.outwayno;

-- 供数据交换使用
create or replace view V_INF_SUPINFO_FOR_SWAP as
  select s.*,o2.item_id,o2.internal_no,
         case
           when s.bj_type = '7' and o2.bj_type = '1' then '5'
           when s.bj_type = '7' and o2.bj_type = '2' then '6'
           when s.bj_type = '4' then '9'
         end
         as SUPERVISE_TYPE
   from m_supervisebasic s
   left join m_outway o on o.outwayno = s.outwayid
   left join m_outway o2 on to_char(o2.outwayno) = o.bj_no
   where o.monitor_source = 'B'
   
create or replace view v_supervise_biz_common as
(select t.INTERNAL_NO,t.TRANSACT_AFFAIR_NAME as BjName,
      e.supervise_no,e.flowInstId,e.BJ_Type,e.BJ_NO,e.ComplaintID,e.OutWayID,e.ORG_ID,e.OPERATOR_NAME,
     e.operator_ID,e.supervise_date,e.MONITOR_ORG_ID,e.MONITOR_ORG_NAME,e.MONITOR_OPERATOR_ID,
   e.MONITOR_OPERATOR_NAME,e.supervise_Option,e.ATTACHMENTName,e.promise_Date,e.UPDATE_DATE,e.OPTID,e.biztype,e.monitor_source
   from v_supervisebasic e
   left join m_Apply t on e.bj_no=t.no where e.bj_type='1')--许可
   union all
   ( select t.INTERNAL_NO,t.content as BjName,
     e.supervise_no,e.flowInstId,e.BJ_Type,e.BJ_NO,e.ComplaintID,e.OutWayID,e.ORG_ID,e.OPERATOR_NAME,
     e.operator_ID,e.supervise_date,e.MONITOR_ORG_ID,e.MONITOR_ORG_NAME,e.MONITOR_OPERATOR_ID,
   e.MONITOR_OPERATOR_NAME,e.supervise_Option,e.ATTACHMENTName,e.promise_Date,e.UPDATE_DATE,e.OPTID,e.biztype,e.monitor_source
   from v_supervisebasic e
   left join m_punish t on e.bj_no=t.no where e.bj_type='2' )--处罚
    union all
    (
    select a.internal_no,b.transact_affair_name as Bjname,
     a.supervise_no,a.flowInstId,a.BJ_Type,a.BJ_NO,a.ComplaintID,a.OutWayID,a.ORG_ID,a.OPERATOR_NAME,
     a.operator_ID,a.supervise_date,a.MONITOR_ORG_ID,a.MONITOR_ORG_NAME,a.MONITOR_OPERATOR_ID,
     a.MONITOR_OPERATOR_NAME,a.supervise_Option,a.ATTACHMENTName,a.promise_Date,a.UPDATE_DATE,a.OPTID,a.biztype,a.monitor_source
   from
  V_M_SuperviseBasic_m_complaint a
   left join m_Apply b on a.bj_no=b.no where a.bj_type1='1'--//投诉类许可
    )
    union all
    (
    select a.internal_no,b.content as Bjname,
     a.supervise_no,a.flowInstId,a.BJ_Type,a.BJ_NO,a.ComplaintID,a.OutWayID,a.ORG_ID,a.OPERATOR_NAME,
     a.operator_ID,a.supervise_date,a.MONITOR_ORG_ID,a.MONITOR_ORG_NAME,a.MONITOR_OPERATOR_ID,
     a.MONITOR_OPERATOR_NAME,a.supervise_Option,a.ATTACHMENTName,a.promise_Date,a.UPDATE_DATE,a.OPTID,a.biztype,a.monitor_source
   from
  V_M_SuperviseBasic_m_complaint a
   left join m_punish b on a.bj_no=b.no where a.bj_type1='2'--//投诉类处罚
    )
    union all
    --层级 对预警（bj_type='7'） 许可
    ( select t.INTERNAL_NO,t.TRANSACT_AFFAIR_NAME as BjName,
     e.supervise_no,e.flowInstId,e.BJ_Type,e.BJ_NO,e.ComplaintID,e.OutWayID,e.ORG_ID,e.OPERATOR_NAME,
     e.operator_ID,e.supervise_date,e.MONITOR_ORG_ID,e.MONITOR_ORG_NAME,e.MONITOR_OPERATOR_ID,
   e.MONITOR_OPERATOR_NAME,e.supervise_Option,e.ATTACHMENTName,e.promise_Date,e.UPDATE_DATE,e.OPTID,e.biztype,e.monitor_source
   from v_supervisebasic e
   left join M_outway tt on to_char(tt.outwayno) = e.bj_no
   left join m_apply t on tt.bj_no=t.no
   where e.bj_type='7' and tt.bj_type='1' and e.monitor_source='B')
    union all
    --层级 对预警（bj_type='7'） 处罚
    ( select t.INTERNAL_NO,t.content as BjName,
     e.supervise_no,e.flowInstId,e.BJ_Type,e.BJ_NO,e.ComplaintID,e.OutWayID,e.ORG_ID,e.OPERATOR_NAME,
     e.operator_ID,e.supervise_date,e.MONITOR_ORG_ID,e.MONITOR_ORG_NAME,e.MONITOR_OPERATOR_ID,
   e.MONITOR_OPERATOR_NAME,e.supervise_Option,e.ATTACHMENTName,e.promise_Date,e.UPDATE_DATE,e.OPTID,e.biztype,e.monitor_source
   from v_supervisebasic e
   left join M_outway tt on to_char(tt.outwayno) = e.bj_no
   left join m_punish t on tt.bj_no=t.no
   where e.bj_type='7' and tt.bj_type='2' and e.monitor_source='B')
   union all
    --层级 对督办（bj_type='4'） 许可
    ( select t.INTERNAL_NO,t.TRANSACT_AFFAIR_NAME as BjName,
     e.supervise_no,e.flowInstId,e.BJ_Type,e.BJ_NO,e.ComplaintID,e.OutWayID,e.ORG_ID,e.OPERATOR_NAME,
     e.operator_ID,e.supervise_date,e.MONITOR_ORG_ID,e.MONITOR_ORG_NAME,e.MONITOR_OPERATOR_ID,
   e.MONITOR_OPERATOR_NAME,e.supervise_Option,e.ATTACHMENTName,e.promise_Date,e.UPDATE_DATE,e.OPTID,e.biztype,e.monitor_source
   from v_supervisebasic e
   left join M_supervisebasic s on s.supervise_no = e.bj_no
   left join M_outway tt on to_char(tt.outwayno) = s.bj_no
   left join m_apply t on tt.bj_no=t.no
   where e.bj_type='4' and tt.bj_type='1' and e.monitor_source='B')
    union all
    --层级 对督办（bj_type='4'） 处罚
    ( select t.INTERNAL_NO,t.content as BjName,
     e.supervise_no,e.flowInstId,e.BJ_Type,e.BJ_NO,e.ComplaintID,e.OutWayID,e.ORG_ID,e.OPERATOR_NAME,
     e.operator_ID,e.supervise_date,e.MONITOR_ORG_ID,e.MONITOR_ORG_NAME,e.MONITOR_OPERATOR_ID,
   e.MONITOR_OPERATOR_NAME,e.supervise_Option,e.ATTACHMENTName,e.promise_Date,e.UPDATE_DATE,e.OPTID,e.biztype,e.monitor_source
   from v_supervisebasic e
   left join M_supervisebasic s on s.supervise_no = e.bj_no
   left join M_outway tt on to_char(tt.outwayno) = s.bj_no
   left join m_punish t on tt.bj_no=t.no
   where e.bj_type='4' and tt.bj_type='2' and e.monitor_source='B')
    union all
    --定量分析
    ( select distinct t.INTERNAL_NO,t.monitor_desc as BjName,
     e.supervise_no,e.flowInstId,e.BJ_Type,e.BJ_NO,e.ComplaintID,e.OutWayID,e.ORG_ID,e.OPERATOR_NAME,
     e.operator_ID,e.supervise_date,e.MONITOR_ORG_ID,e.MONITOR_ORG_NAME,e.MONITOR_OPERATOR_ID,
   e.MONITOR_OPERATOR_NAME,e.supervise_Option,e.ATTACHMENTName,e.promise_Date,e.UPDATE_DATE,e.OPTID,e.biztype,e.monitor_source
   from v_supervisebasic e
   left join M_outway t on to_char(t.outwayno) = e.outwayid
   where e.bj_type='6' and e.monitor_source='C');
