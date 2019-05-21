create or replace package alert_warning is

  -- Author  : CODEFAN
  -- Created : 2013-6-8 9:21:55
  -- Purpose : ���Ӽ��Ԥ����
 

  -- �Թ����ռ������չ��promise Ϊ��ŵ�ڣ�promiseTypeΪ��ŵ����� �� extendDays Ϊ���޵�����
  function calc_expired_date(beginDate in date, promise in number, promiseType in varchar2,extendDays in number)
     return date; 
  -- ���溯������չ������˱ȽϵĹ���        
  function check_expired(beginDate in date, endDate in date,  promise in number, promiseType in varchar2,extendDays in number)
     return boolean; 
      
  -- checkBeginDate Ҫ������ʵʱ��
  /**
  alter table M_Apply add  begin_count_date     date add
   warning_state        char; ---- null,0 δi�㣬 1��Ԥ��  2 ���� 3 ����  4 ժ�� 5 ��ʱ���

  --��ʼ�� ��ʱ��ʼ�� 
  update  M_Apply a
  set a.begin_count_date = (select min(b.process_date) 
                           from M_ApplyProcess b 
                           where b.internal_no = a.internal_no and b.item_id=a.item_id
                             and b.promise_start_sign='1')
  where a.begin_count_date is null;
  */
  -- Ԥ������������job��ϵͳ����
  procedure check_warning(checkBeginDate in date,callType varchar2:='A',callerCode varchar2:=null);
  
  procedure auto_check_warning;
  -- �Զ�ժ�ƣ���job��ϵͳ����
  procedure relieve_warning;  

end alert_warning;
/
create or replace package body alert_warning is


   function calc_expired_date(beginDate in date, promise in number, promiseType in varchar2,extendDays in number)
     return date
   is
     expiredDate date;
   begin
     expiredDate := beginDate;
     CASE promiseType
        WHEN '0' THEN expiredDate := beginDate + promise + extendDays;
        WHEN '1' THEN expiredDate := WORK_DAY_OPT.calc_next_work_date(beginDate, promise + extendDays);
        WHEN '2' THEN expiredDate := add_months(beginDate,promise);
        WHEN '3' THEN expiredDate := add_months(beginDate,promise*12);
     END CASE;

     return expiredDate;
   end calc_expired_date;

   function check_expired(beginDate in date, endDate in date, promise in number, promiseType in varchar2,extendDays in number)
     return boolean
   is
     bRes boolean;
   begin
     bRes := false;
     CASE promiseType
        WHEN '0' THEN bRes := endDate > beginDate + promise + extendDays;
        WHEN '1' THEN bRes := endDate > WORK_DAY_OPT.calc_next_work_date(beginDate, promise + extendDays);
        WHEN '2' THEN bRes := endDate > add_months(beginDate,promise);
        WHEN '3' THEN bRes := endDate > add_months(beginDate,promise*12);
     END CASE;

     return bRes;
   end check_expired;
  -- BJ_TYPE 1����� 2������ 3 ������ 4:Ͷ�� 5:�����쳣
  -- MONITOR_STYLE 1:Ԥ�� 2:���� 3:����
  -- MONITOR_TYPE  1��ʱЧ�쳣 2�������쳣 3�������쳣 4���������շѣ��쳣 5�����շ����쳣 6������

   /*�������  �Ǵ���������ְȨ���ʱ��Ϊ��ŵ���޵����һ��������                                  ���� 3
               �Ǵ���������ְȨ�����ŵ�ڳ���һ����������δ���                                    Ԥ�� 1
               �Ǵ���������ְȨ���������ŵ��2��������������δ���򳬹���ŵ��2���������Ժ����  ���� 2 ʱЧ���쳣  1
    */
procedure check_permit_process_time(checkBeginDate in date,calcNo in number)
is
   leaveTime number(6,2);
   nEscapeTime number(12,4);
begin
 for r in(select p.No, p.ORG_ID, p.INTERNAL_NO, p.ITEM_ID,p.NODE_ID,-- TACHE_ID,
               p.PROMISE, p.PROMISE_TYPE,p.PROMISE_START_SIGN,p.Begin_Date,nvl(p.PROCESS_DATE,sysdate) as  PROCESS_DATE,
                 a.no as ApplyNo
          from M_ApplyProcess p join M_Apply a on (a.INTERNAL_NO=p.INTERNAL_NO and a.ITEM_ID=p.ITEM_ID)
          where p.UPDATE_DATE > checkBeginDate
                and not exists(select o.* from M_OutWay o where o.BJ_TYPE='1' and o.BJ_No= a.no
                       and o.Process_No = p.No  and o.Warning_Code='ALTER_EXPIRED')
         ) loop
         
        leaveTime := r.promise;
        
        for innerR in(     
          select a.BEGIN_DATE, a.PROCESS_DATE  from M_ApplyProcess a
          where a.INTERNAL_NO=r.INTERNAL_NO and a.ITEM_ID=r.ITEM_ID
                and a.NODE_ID=r.NODE_ID and a.no <>  r.No) 
        loop
           if innerR.Begin_Date is not null and innerR.Process_Date is not null then 
             nEscapeTime := WORK_DAY_OPT.calc_work_time(innerR.Begin_Date,innerR.Process_Date,6.5);
             leaveTime := leaveTime - nEscapeTime;
           end if;               
        end loop;          
       --ÿ��7Сʱ��д����
      if leaveTime <0 or r.begin_date is null or r.process_date > WORK_DAY_OPT.calc_next_work_time(r.begin_date, FLOOR(leaveTime/6.5) , leaveTime - FLOOR(leaveTime/6.5)*6.5 )
        and r.PROMISE_START_SIGN=1 then
          insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   ,  InTime   )
          values(S_Out_Way_No.Nextval, '1', r.applyNo  , r.No , calcNo,
                       r.org_id,r.internal_no,r.item_id,'2', '1' ,
                     'ALTER_EXPIRED' ,'����ʱ�䳬�ڱ���',sysdate);
       end if;
     
  end loop;
end check_permit_process_time;

  procedure check_permit_apply_time(calcNo in number)
  is
  begin
    -- ���������������İ��
    update M_Apply a  set warning_state='5'
           where (a.warning_state is null or a.warning_state = '0' )
             and  calc_expired_date(a.begin_count_date,a.promise,a.promise_type,0)
                  > (select b.finish_time from  M_ApplyResult b where  b.internal_no = a.internal_no and b.item_id=a.item_id);

    --- ����
    for r in ( select  a.no , a.internal_no , a.item_id, a.org_id
        --a.begin_count_date, nvl(b.finish_time,sysdate) as finish_time,
        --a.promise,a.promise_type, early_warning.calc_expired_date(a.begin_count_date,a.promise,a.promise_type,2)
        from M_Apply a left join M_ApplyResult b on  b.internal_no = a.internal_no and b.item_id=a.item_id
        where (a.warning_state is null or a.warning_state in('0','1','3') ) and  a.begin_count_date is not null
              and promise > 0
              and calc_expired_date(a.begin_count_date,a.promise,a.promise_type,2) < nvl(b.finish_time,sysdate))
    loop
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
       values(S_Out_Way_No.Nextval, '1',r.no  ,'0'/*��԰�����쳣����*/, calcNo,
                r.org_id,r.internal_no,r.item_id,'2','1' ,
                'ALTER_EXPIRED' ,'���/����ʱ�䳬�ڱ���',sysdate);
       update M_Apply set warning_state='2' where no=r.no;
    end loop;

    --- Ԥ��
    for r in ( select  a.no , a.internal_no , a.item_id, a.org_id
        --a.begin_count_date, nvl(b.finish_time,sysdate) as finish_time,
        --a.promise,a.promise_type, early_warning.calc_expired_date(a.begin_count_date,a.promise,a.promise_type,2)
        from M_Apply a left join M_ApplyResult b on  b.internal_no = a.internal_no and b.item_id=a.item_id
        where (a.warning_state is null or a.warning_state in('0','3') ) and  a.begin_count_date is not null
              and promise > 0
              and calc_expired_date(a.begin_count_date,a.promise,a.promise_type,1) < nvl(b.finish_time,sysdate))
    loop
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
       values(S_Out_Way_No.Nextval, '1',r.no  ,'0'/*��԰�����쳣����*/, calcNo,
                r.org_id,r.internal_no,r.item_id,'1','1' ,
                'ALARM_EXPIRED' ,'���/����ʱ�䳬��Ԥ��',sysdate);

       update M_Apply set warning_state='1' where no=r.no;
    end loop;

    --- ����
    for r in ( select  a.no , a.internal_no , a.item_id, a.org_id
        --a.begin_count_date, nvl(b.finish_time,sysdate) as finish_time,
        --a.promise,a.promise_type, early_warning.calc_expired_date(a.begin_count_date,a.promise,a.promise_type,2)
        from M_Apply a left join M_ApplyResult b on  b.internal_no = a.internal_no and b.item_id=a.item_id
        where (a.warning_state is null or a.warning_state = '0' ) and  a.begin_count_date is not null
              and promise > 0
              and calc_expired_date(a.begin_count_date,a.promise,a.promise_type,0) < nvl(b.finish_time,sysdate))
    loop
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
       values(S_Out_Way_No.Nextval, '1',r.no  ,'0'/*��԰�����쳣����*/, calcNo,
                r.org_id,r.internal_no,r.item_id,'0','1' ,
                'WARN_EXPIRED' ,'���/����ʱ�䳬������',sysdate);
       update M_Apply set warning_state='3' where no=r.no;
    end loop;

  end check_permit_apply_time;

  procedure check_permit_warning(checkBeginDate in date,calcNo in number)
  is
     chargeOffset number(6,4);
  begin

      -- BJ_TYPE 1����� 2������ 3 ������ 4:Ͷ�� 5:�����쳣
      -- MONITOR_STYLE 1:Ԥ�� 2:���� 3:����
      -- MONITOR_TYPE  1��ʱЧ�쳣 2�������쳣 3�������쳣 4���������շѣ��쳣 5�����շ����쳣 6������

      -- ժҪ��Ϣδ�  ����ְȨ�������ݻ������еİ��ժҪ��Ϣδ�  ����  �������쳣
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', no  ,'0'/*��԰�����쳣����*/, calcNo,
                  ORG_ID,INTERNAL_NO,item_id,'0','3' ,
                  'NO_SUMMARY' ,'ժҪ��Ϣδ�',sysdate
         from M_Apply
              where (CONTENT is null or length(CONTENT)<5 )
                    and UPDATE_DATE >= checkBeginDate  and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=M_Apply.no and Warning_Code='NO_SUMMARY' );

       --���������������δ�ϱ�  ��������������û���ϱ������Ӽ��ϵͳ  ����  �������쳣

       insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', no  ,'0'/*��԰�����쳣����*/, calcNo,
                  ORG_ID,INTERNAL_NO,item_id,'0','3' ,
                  'NO_STUFF' ,'�������δ�ϱ�',sysdate
         from M_Apply
              where (STUFF is null or length(STUFF)<100 )
                    and UPDATE_DATE >= checkBeginDate  and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=M_Apply.no and Warning_Code='NO_STUFF' );

       --������������֪ͨ��δ�ϱ�  �����������֪ͨ��û���ϱ������Ӽ��ϵͳ  ����  �������쳣
       insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0', calcNo,
                  p.ORG_ID,p.INTERNAL_NO,p.item_id,'0','3' ,
                  'NO_NOTICE_OF_ACCEPTANCE' ,'����֪ͨ��δ�ϱ�',sysdate
         from M_ApplyProcess p join M_Apply a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
              where p.TACHE_NAME like '%����%' and -- û������֪ͨ��
               p.internal_no like '%XK%' AND
               ( p.ATTACHMENT is null or length(p.ATTACHMENT)<100
                       or not exists (select d.* from M_ApplyDoc d
                            where d.INTERNAL_NO=p.INTERNAL_NO and d.ITEM_ID=p.ITEM_ID and d.PROCESS_NO=p.no and d.DOCUMENT_NAME like '%֪ͨ��%' ) )
                    and p.UPDATE_DATE >= checkBeginDate  and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code='NO_NOTICE_OF_ACCEPTANCE' );

       --�������
       check_permit_apply_time(calcNo);
     --   check_permit_process_time(checkBeginDate,calcNo);

       --�Ǽ�ʱ���쳣  ����ְȨ�������ݹ��̱��е����ݷ���ʱ�����ڻ������еĵǼ�ʱ��  ����  ʱЧ���쳣
       insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*��԰�����쳣����*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','1' ,
                  'PROCESS_BEFORE_REGISTER' ,'�Ǽ�ʱ���쳣 ',sysdate
         from M_Apply a
         where a.UPDATE_DATE >= checkBeginDate
              and exists (select b.* from  M_ApplyProcess b where b.PROCESS_DATE < a.APPLY_DATE and b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID)
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='PROCESS_BEFORE_REGISTER' );

       --�����������  �Ǵ���������������  ����  �����쳣
       insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*��԰�����쳣����*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','6' ,
                  'NOT_BE_ACCEPTED' ,'�����������',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and r.STATUS='1'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='NOT_BE_ACCEPTED' );
      -- �������������β���  ������ɰ�����ֶ�β��������  Ԥ��  �������쳣
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*��԰�����쳣����*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'1','2' ,
                  'MULTI_CORRECTION' ,'��β���',sysdate
         from  M_ApplyProcess p join M_Apply a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
         where p.UPDATE_DATE >= checkBeginDate
              and p.TACHE_NAME like '%����%'
              and exists( select b.* from M_ApplyProcess b
                          where b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID
                                 and b.TACHE_NAME like '%����%' and b.no <> p.no )
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='MULTI_CORRECTION');
      --- ������������������  ������ɰ���������ֲ��������  ����  �������쳣
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*��԰�����쳣����*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'2','2' ,
                  'CORRECTION_AFTER_ACCEPT' ,'������������������ ',sysdate
         from  M_ApplyProcess p join M_Apply a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
         where p.UPDATE_DATE >= checkBeginDate
              and p.TACHE_NAME like '%����%'
              and exists( select b.* from M_ApplyProcess b
                          where b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID
                                 and b.TACHE_NAME like '%����%' and b.PROCESS_DATE < p.PROCESS_DATE)
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='CORRECTION_AFTER_ACCEPT');
      --- ���������շ������쳣  ������ɰ�������е��շѲ���������ļ��涨�ı�׼	Ԥ��	�������쳣
      /**
      ����ط�Ӧ�ð� Ȩ�������е��շѱ�׼��ʽ�������������봦����׼�����ɲ�����������ͨ��ʵ�շ��úʹ�����׼���жԱȡ�
      **/
      --- ��ȡ��صĲ���
      select to_number(param_value) into chargeOffset from M_OutWayParam where param_no='CHARGE_OFFSET';
      if chargeOffset is null then
         chargeOffset := 0.05;
      end if;
      --- ���쳣���뵽�쳣��Ϣ����
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*��԰�����쳣����*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'1','3' ,
                  'CHARGE_WARNING' ,'���������շ������쳣',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and r.RECEIVABLE > 0 and ( (r.PAID-r.RECEIVABLE) / r.RECEIVABLE > chargeOffset or (r.RECEIVABLE-r.PAID) / r.RECEIVABLE < chargeOffset )
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='CHARGE_WARNING' );

      -- ���״̬δ�	����ְȨ�������ݽ�����еİ��״̬����	����	�������쳣
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*��԰�����쳣����*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','3' ,
                  'NO_RESULT_STATUS' ,'���״̬δ�',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and (r.STATUS is null or r.STATUS not in ('1','2','3'))
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='NO_RESULT_STATUS' );

      --- �Ѱ�ᵫ�޹�������	����ְȨ�������ݽ�������������ݣ������̱��������ݻ����ݲ����ϱ�׼	����	�������쳣
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*��԰�����쳣����*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','3' ,
                  'NO_PROCESS_DATA' ,'�Ѱ�ᵫ�޹�������',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and not exists( select b.* from M_ApplyProcess b
                          where b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID)
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='NO_PROCESS_DATA' );
      --- ���ʱ���쳣	����ְȨ�������ݽ�����еİ��ʱ�����ڹ��̱��е����ݷ���ʱ��	����	�������쳣
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*��԰�����쳣����*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','3' ,
                  'PROCESS_AFTER_FINISH' ,'���ʱ���쳣',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and exists( select b.* from M_ApplyProcess b
                          where b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID
                                and b.PROCESS_DATE > r.FINISH_TIME)
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='PROCESS_AFTER_FINISH' );
      --- ��������������δ�ϱ�	������ɾ�����û���ϱ������Ӽ��ϵͳ	����	�������쳣
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*��԰�����쳣����*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','3' ,
                  'NO_DECISION' ,'��������������δ�ϱ�',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and ( r.ATTACHMENT is null or length(r.ATTACHMENT)<100
                       or not exists (select d.* from M_ApplyDoc d
                            where d.INTERNAL_NO=r.INTERNAL_NO and d.ITEM_ID=r.ITEM_ID and d.DOCUMENT_NAME like '%����%' ) )
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='NO_DECISION' );
      -- BJ_TYPE 1����� 2������ 3 ������ 4:Ͷ�� 5:�����쳣
      -- MONITOR_STYLE 1:Ԥ�� 2:���� 3:����
      -- MONITOR_TYPE  1��ʱЧ�쳣 2�������쳣 3�������쳣 4���������շѣ��쳣 5�����շ����쳣 6������
  end check_permit_warning;

  -- �����쳣��Ԥ������
  procedure check_punish_warning(checkBeginDate in date,calcNo in number)
  is
  begin
    -- BJ_TYPE 1����� 2������ 3 ������ 4:Ͷ�� 5:�����쳣
    -- MONITOR_STYLE 1:Ԥ�� 2:���� 3:����
    -- MONITOR_TYPE  1��ʱЧ�쳣 2�������쳣 3�������쳣 4���������շѣ��쳣 5�����շ����쳣 6������
    null;
  end check_punish_warning;
  -- �����쳣��Ԥ������
  procedure check_other_warning(checkBeginDate in date,calcNo in number)
  is
  begin
    -- BJ_TYPE 1����� 2������ 3 ������ 4:Ͷ�� 5:�����쳣
    -- MONITOR_STYLE 1:Ԥ�� 2:���� 3:����
    -- MONITOR_TYPE  1��ʱЧ�쳣 2�������쳣 3�������쳣 4���������շѣ��쳣 5�����շ����쳣 6������
    null;
  end check_other_warning;

  procedure check_warning(checkBeginDate in date,callType varchar2:='A',callerCode varchar2:=null)
  is
    calcNo number(12);
    calcTime date;

  begin
      select S_Out_Way_No.Nextval,sysdate into calcNo,calcTime from dual;
      -- BJ_TYPE 1����� 2������ 3 ������ 4:Ͷ�� 5:�����쳣
      -- MONITOR_STYLE 1:Ԥ�� 2:���� 3:����
      -- MONITOR_TYPE  1��ʱЧ�쳣 2�������쳣 3�������쳣 4���������շѣ��쳣 5�����շ����쳣 6������
      -- ����쳣��Ԥ������
      check_permit_warning(checkBeginDate,calcNo);
      -- �����쳣��Ԥ������
      check_punish_warning(checkBeginDate,calcNo);
      -- �����쳣��Ԥ������
      check_other_warning(checkBeginDate,calcNo);
      check_permit_process_time(checkBeginDate,calcNo);
      -- ������������Ϣ
      insert into M_OutWayCalc (  calc_no,  calc_time, call_type  ,caller  , scope_begin,
                scope_end  , alert_pieces  , alarm_pieces )
       values ( calcNo,sysdate,callType,callerCode,checkBeginDate,
                calcTime, (select count(1) from M_OutWay where calc_no=calcNo and MONITOR_STYLE='2'),
                    (select count(1) from M_OutWay where calc_no=calcNo and MONITOR_STYLE<>'2') );
       -- ֻ����������Ĵ洢������Ҫcommit�ģ������ع�ʱҪע��
       commit;
  end check_warning;

  procedure auto_check_warning
  is
  begin
    check_warning( sysdate-10 ,'A',null);
  end;

  --- �Զ�ժ��
  procedure relieve_warning
  is
  begin
    update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='��Ϊ��ʱ��Ԥ�����������Զ�ժ��'
    where a.Warning_Code = 'WARN_EXPIRED' and a.OutWayState='1'
          and exists (select b.* from M_OutWay b where
                     ( b.Warning_Code='ALARM_EXPIRED' or  b.Warning_Code='ALTER_EXPIRED') and b.BJ_No=a.BJ_No and b.BJ_TYPE=a.BJ_TYPE);

    update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='��Ϊ��ʱ�䱨�����Զ�ժ��'
    where a.Warning_Code = 'ALARM_EXPIRED' and a.OutWayState='1'
          and exists (select b.* from M_OutWay b where
                        b.Warning_Code='ALTER_EXPIRED' and b.BJ_No=a.BJ_No and b.BJ_TYPE=a.BJ_TYPE);

  end relieve_warning;
begin
  -- Initialization
  null;
end alert_warning;
/
