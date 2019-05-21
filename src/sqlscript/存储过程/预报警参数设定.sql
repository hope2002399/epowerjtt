/**
字典项新增4个参数上午上班时间AM_BEGIN,上午下班时间AM_END,下午上班时间PM_BEGIN,下午下班时间PM_END。
 
已完成的环节用PROCESS_DATE和begin_date之差，考虑上班时间和节假日，计算出实际用时，和办件过程表中的promise比，超过报警。
未完成的环节用sysdate和begin_date之差，考虑上班时间和节假日，计算出实际用时，和办件过程表中的promise比，超过报警。
 
其他考虑因素
1、环节开始时间或者办结时间不在工作时间段，默认为下一个工作时间段的开始时间，比如晚上8点办结的，计算时算为第2天的开始时间。
2、退回和暂停，同一环节NODE_ID一样的，累加计时。
3、计时标志promise_start_sign=1时，环节才进行时限计算。
*/
--- 添加上班时间参数（这一块后面可能需要整合到企业工作日历中，暂时不考虑）
select * from f_Datadictionary where catalogcode='SYSPARAM'; 

delete from f_Datadictionary where catalogcode='SYSPARAM' and datacode in ('AM_BEGIN','AM_END','PM_BEGIN','PM_END');

insert into f_Datadictionary(catalogcode,datacode,datatag,datavalue,extracode,datastyle,datadesc)
values('SYSPARAM','AM_BEGIN','T','9:00','','U','上午上班时间');
--- 在AM_END的 extracode 字段中放入的是上午下班到下午上班的时间间隔，1:30表示1小时30分钟
insert into f_Datadictionary(catalogcode,datacode,datatag,datavalue,extracode,datastyle,datadesc)
values('SYSPARAM','AM_END','T','12:00','1:30','U','上午下班时间');

insert into f_Datadictionary(catalogcode,datacode,datatag,datavalue,extracode,datastyle,datadesc)
values('SYSPARAM','PM_BEGIN','T','13:30','','U','下午上班时间');

--- 在PM_END的 extracode 字段中放入的是下午下班到第二天上午上班的时间间隔，15:30表示15小时30分钟
insert into f_Datadictionary(catalogcode,datacode,datatag,datavalue,extracode,datastyle,datadesc)
values('SYSPARAM','PM_END','T','17:30','15:30','U','下午下班时间');

select to_date( to_char(sysdate,'YYYY-MM-DD ')|| datavalue ,'YYYY-mm-dd HH24:mi') 
from f_Datadictionary where catalogcode='SYSPARAM' and datacode='AM_BEGIN'

-- 调整索引提高性能
drop index ind_process_internal;

/*==============================================================*/
/* Index: ind_process_internal                                  */
/*==============================================================*/
create index ind_process_internal on M_ApplyProcess (
   INTERNAL_NO ASC,
   ITEM_ID ASC,
   NODE_ID ASC
);


--select FLOOR(3/7), mod(10, 7) ,sysdate + TO_DSINTERVAL('0 23:00:00') from dual;
select alert_warning.calc_next_work_time(sysdate,0,6) from dual;
select alert_warning.calc_next_work_date(sysdate,1) from dual;

------- 创建自动运行工作
begin
  DBMS_SCHEDULER.drop_job(JOB_NAME => 'AUTO_RUN_ALERT_WARNING');
end;
/

begin  
  DBMS_SCHEDULER.CREATE_JOB (JOB_NAME => 'AUTO_RUN_ALERT_WARNING',
                  JOB_TYPE => 'STORED_PROCEDURE',
                  JOB_ACTION => 'alert_warning.auto_check_warning',
                  START_DATE => TRUNC(SYSDATE),
                  REPEAT_INTERVAL => 'FREQ=DAILY;BYHOUR=8,9,10,11,12,13,14,15,16,17,18;BYMINUTE=0,15,30,45;bysecond=0',
                  END_DATE => SYSTIMESTAMP+3000,
                  ENABLED => TRUE,
                  AUTO_DROP => TRUE,
                  COMMENTS => '每天晚上11：45 自动运行 alert_warning.check_warning ');
end;
/

begin
  dbms_scheduler.run_job(job_name => 'AUTO_RUN_ALERT_WARNING');
end;
/

select * from M_OutWayCalc order by calc_time desc
