/**
�ֵ�������4�����������ϰ�ʱ��AM_BEGIN,�����°�ʱ��AM_END,�����ϰ�ʱ��PM_BEGIN,�����°�ʱ��PM_END��
 
����ɵĻ�����PROCESS_DATE��begin_date֮������ϰ�ʱ��ͽڼ��գ������ʵ����ʱ���Ͱ�����̱��е�promise�ȣ�����������
δ��ɵĻ�����sysdate��begin_date֮������ϰ�ʱ��ͽڼ��գ������ʵ����ʱ���Ͱ�����̱��е�promise�ȣ�����������
 
������������
1�����ڿ�ʼʱ����߰��ʱ�䲻�ڹ���ʱ��Σ�Ĭ��Ϊ��һ������ʱ��εĿ�ʼʱ�䣬��������8����ģ�����ʱ��Ϊ��2��Ŀ�ʼʱ�䡣
2���˻غ���ͣ��ͬһ����NODE_IDһ���ģ��ۼӼ�ʱ��
3����ʱ��־promise_start_sign=1ʱ�����ڲŽ���ʱ�޼��㡣
*/
--- ����ϰ�ʱ���������һ����������Ҫ���ϵ���ҵ���������У���ʱ�����ǣ�
select * from f_Datadictionary where catalogcode='SYSPARAM'; 

delete from f_Datadictionary where catalogcode='SYSPARAM' and datacode in ('AM_BEGIN','AM_END','PM_BEGIN','PM_END');

insert into f_Datadictionary(catalogcode,datacode,datatag,datavalue,extracode,datastyle,datadesc)
values('SYSPARAM','AM_BEGIN','T','9:00','','U','�����ϰ�ʱ��');
--- ��AM_END�� extracode �ֶ��з�����������°ൽ�����ϰ��ʱ������1:30��ʾ1Сʱ30����
insert into f_Datadictionary(catalogcode,datacode,datatag,datavalue,extracode,datastyle,datadesc)
values('SYSPARAM','AM_END','T','12:00','1:30','U','�����°�ʱ��');

insert into f_Datadictionary(catalogcode,datacode,datatag,datavalue,extracode,datastyle,datadesc)
values('SYSPARAM','PM_BEGIN','T','13:30','','U','�����ϰ�ʱ��');

--- ��PM_END�� extracode �ֶ��з�����������°ൽ�ڶ��������ϰ��ʱ������15:30��ʾ15Сʱ30����
insert into f_Datadictionary(catalogcode,datacode,datatag,datavalue,extracode,datastyle,datadesc)
values('SYSPARAM','PM_END','T','17:30','15:30','U','�����°�ʱ��');

select to_date( to_char(sysdate,'YYYY-MM-DD ')|| datavalue ,'YYYY-mm-dd HH24:mi') 
from f_Datadictionary where catalogcode='SYSPARAM' and datacode='AM_BEGIN'

-- ���������������
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

------- �����Զ����й���
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
                  COMMENTS => 'ÿ������11��45 �Զ����� alert_warning.check_warning ');
end;
/

begin
  dbms_scheduler.run_job(job_name => 'AUTO_RUN_ALERT_WARNING');
end;
/

select * from M_OutWayCalc order by calc_time desc
