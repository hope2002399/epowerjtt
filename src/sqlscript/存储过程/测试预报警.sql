select early_warning.calc_next_work_date(sysdate,7) from dual;


alter table M_Apply add  begin_count_date     date add
   warning_state        char;

update  M_Apply a
set a.begin_count_date = (select min(b.process_date) 
                         from M_ApplyProcess b 
                         where b.internal_no = a.internal_no and b.item_id=a.item_id
                           --and b.promise_start_sign='1'
                           )
where a.begin_count_date is null;

select begin_count_date from M_ApplyProcess where promise_start_sign='1'


select  a.no , a.internal_no , a.item_id,  a.begin_count_date, nvl(b.finish_time,sysdate) as finish_time,
        a.promise,a.promise_type, early_warning.calc_expired_date(a.begin_count_date,a.promise,a.promise_type,2)
from M_Apply a left join M_ApplyResult b on  b.internal_no = a.internal_no and b.item_id=a.item_id
where (a.warning_state is null or a.warning_state in('0','1','3') ) and  a.begin_count_date is not null 
      and promise > 0
      and alert_warning.calc_expired_date(a.begin_count_date,a.promise,a.promise_type,2) < nvl(b.finish_time,sysdate)
     


insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
       select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, 100,
                a.ORG_ID,a.INTERNAL_NO,a.item_id,'3','1' ,
                'PROCESS_BEFORE_REGISTER' ,'登记时间异常 ',sysdate
       from M_Apply a
            where a.UPDATE_DATE >= sysdate-100  
            and exists (select b.* from  M_ApplyProcess b where b.PROCESS_DATE < a.APPLY_DATE ) 
            and not exists (
                  select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='PROCESS_BEFORE_REGISTER' );    
                  
                  
    update M_Apply a  set warning_state='5'
           where (a.warning_state is null or a.warning_state = '0' )
             and  alert_warning.calc_expired_date(a.begin_count_date,a.promise,a.promise_type,0) 
                  > (select b.finish_time from  M_ApplyResult b where  b.internal_no = a.internal_no and b.item_id=a.item_id);                   
 
begin
  early_warning.check_warning(sysdate-100);
end;

select * from M_OutWayCalc;
select * from M_OutWay where intime > trunc(sysdate);     
      

select * from M_OutWayParam for update

select to_char(sysdate, 'MM'),extract(month from sysdate),extract(year from sysdate)  from dual;

select * from M_SupervisoryPersonnel ;

alter table M_PaMonthPunish rename column stat_type to PUNISH_TYPE;

select * from M_ApplyResult

begin
      performance_appraisal.appraisal_dept_all(to_date('2013-01-01','yyyy-mm-dd'),true,true);
end;

select * from M_PaCheckupParam

select sum(c.ITEM_VALUE) from M_PaMonthCheckup c where c.COUNT_YEAR =2013 and c.COUNT_MONTH=1 and c.org_id='98' and c.CHECK_TYPE='2'
