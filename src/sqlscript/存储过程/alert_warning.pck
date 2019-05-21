create or replace package alert_warning is

  -- Author  : CODEFAN
  -- Created : 2013-6-8 9:21:55
  -- Purpose : 电子监察预报警
 

  -- 对工作日计算的扩展，promise 为承诺期，promiseType为承诺期类别 ， extendDays 为宽限的日期
  function calc_expired_date(beginDate in date, promise in number, promiseType in varchar2,extendDays in number)
     return date; 
  -- 上面函数的扩展，添加了比较的功能        
  function check_expired(beginDate in date, endDate in date,  promise in number, promiseType in varchar2,extendDays in number)
     return boolean; 
      
  -- checkBeginDate 要检查的其实时间
  /**
  alter table M_Apply add  begin_count_date     date add
   warning_state        char; ---- null,0 未i算， 1，预警  2 报警 3 提醒  4 摘牌 5 按时完成

  --初始化 计时开始点 
  update  M_Apply a
  set a.begin_count_date = (select min(b.process_date) 
                           from M_ApplyProcess b 
                           where b.internal_no = a.internal_no and b.item_id=a.item_id
                             and b.promise_start_sign='1')
  where a.begin_count_date is null;
  */
  -- 预报警函数，供job和系统调用
  procedure check_warning(checkBeginDate in date,callType varchar2:='A',callerCode varchar2:=null);
  
  procedure auto_check_warning;
  -- 自动摘牌，供job和系统调用
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
  -- BJ_TYPE 1：许可 2：处罚 3 ：督查 4:投诉 5:其他异常
  -- MONITOR_STYLE 1:预警 2:报警 3:提醒
  -- MONITOR_TYPE  1：时效异常 2：流程异常 3：内容异常 4：裁量（收费）异常 5：风险防控异常 6：其他

   /*办件超期  非处罚类行政职权办件时间为承诺期限的最后一个工作日                                  提醒 3
               非处罚类行政职权办件承诺期超过一个工作日仍未办结                                    预警 1
               非处罚类行政职权办件超过承诺期2个工作日以上仍未办结或超过承诺期2个工作日以后办结的  报警 2 时效性异常  1
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
       --每天7小时是写死的
      if leaveTime <0 or r.begin_date is null or r.process_date > WORK_DAY_OPT.calc_next_work_time(r.begin_date, FLOOR(leaveTime/6.5) , leaveTime - FLOOR(leaveTime/6.5)*6.5 )
        and r.PROMISE_START_SIGN=1 then
          insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   ,  InTime   )
          values(S_Out_Way_No.Nextval, '1', r.applyNo  , r.No , calcNo,
                       r.org_id,r.internal_no,r.item_id,'2', '1' ,
                     'ALTER_EXPIRED' ,'环节时间超期报警',sysdate);
       end if;
     
  end loop;
end check_permit_process_time;

  procedure check_permit_apply_time(calcNo in number)
  is
  begin
    -- 先设置正常结束的办件
    update M_Apply a  set warning_state='5'
           where (a.warning_state is null or a.warning_state = '0' )
             and  calc_expired_date(a.begin_count_date,a.promise,a.promise_type,0)
                  > (select b.finish_time from  M_ApplyResult b where  b.internal_no = a.internal_no and b.item_id=a.item_id);

    --- 报警
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
       values(S_Out_Way_No.Nextval, '1',r.no  ,'0'/*针对办件的异常过程*/, calcNo,
                r.org_id,r.internal_no,r.item_id,'2','1' ,
                'ALTER_EXPIRED' ,'办件/案件时间超期报警',sysdate);
       update M_Apply set warning_state='2' where no=r.no;
    end loop;

    --- 预警
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
       values(S_Out_Way_No.Nextval, '1',r.no  ,'0'/*针对办件的异常过程*/, calcNo,
                r.org_id,r.internal_no,r.item_id,'1','1' ,
                'ALARM_EXPIRED' ,'办件/案件时间超期预警',sysdate);

       update M_Apply set warning_state='1' where no=r.no;
    end loop;

    --- 提醒
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
       values(S_Out_Way_No.Nextval, '1',r.no  ,'0'/*针对办件的异常过程*/, calcNo,
                r.org_id,r.internal_no,r.item_id,'0','1' ,
                'WARN_EXPIRED' ,'办件/案件时间超期提醒',sysdate);
       update M_Apply set warning_state='3' where no=r.no;
    end loop;

  end check_permit_apply_time;

  procedure check_permit_warning(checkBeginDate in date,calcNo in number)
  is
     chargeOffset number(6,4);
  begin

      -- BJ_TYPE 1：许可 2：处罚 3 ：督查 4:投诉 5:其他异常
      -- MONITOR_STYLE 1:预警 2:报警 3:提醒
      -- MONITOR_TYPE  1：时效异常 2：流程异常 3：内容异常 4：裁量（收费）异常 5：风险防控异常 6：其他

      -- 摘要信息未填报  行政职权运行数据基本表中的办件摘要信息未填报  提醒  内容性异常
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', no  ,'0'/*针对办件的异常过程*/, calcNo,
                  ORG_ID,INTERNAL_NO,item_id,'0','3' ,
                  'NO_SUMMARY' ,'摘要信息未填报',sysdate
         from M_Apply
              where (CONTENT is null or length(CONTENT)<5 )
                    and UPDATE_DATE >= checkBeginDate  and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=M_Apply.no and Warning_Code='NO_SUMMARY' );

       --行政审批申请材料未上报  行政许可申请材料没有上报到电子监察系统  提醒  内容性异常

       insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', no  ,'0'/*针对办件的异常过程*/, calcNo,
                  ORG_ID,INTERNAL_NO,item_id,'0','3' ,
                  'NO_STUFF' ,'申请材料未上报',sysdate
         from M_Apply
              where (STUFF is null or length(STUFF)<100 )
                    and UPDATE_DATE >= checkBeginDate  and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=M_Apply.no and Warning_Code='NO_STUFF' );

       --行政审批受理通知书未上报  行政许可受理通知书没有上报到电子监察系统  提醒  内容性异常
       insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0', calcNo,
                  p.ORG_ID,p.INTERNAL_NO,p.item_id,'0','3' ,
                  'NO_NOTICE_OF_ACCEPTANCE' ,'受理通知书未上报',sysdate
         from M_ApplyProcess p join M_Apply a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
              where p.TACHE_NAME like '%受理%' and -- 没有受理通知书
               p.internal_no like '%XK%' AND
               ( p.ATTACHMENT is null or length(p.ATTACHMENT)<100
                       or not exists (select d.* from M_ApplyDoc d
                            where d.INTERNAL_NO=p.INTERNAL_NO and d.ITEM_ID=p.ITEM_ID and d.PROCESS_NO=p.no and d.DOCUMENT_NAME like '%通知书%' ) )
                    and p.UPDATE_DATE >= checkBeginDate  and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code='NO_NOTICE_OF_ACCEPTANCE' );

       --办件超期
       check_permit_apply_time(calcNo);
     --   check_permit_process_time(checkBeginDate,calcNo);

       --登记时间异常  行政职权运行数据过程表中的数据发生时间早于基本表中的登记时间  提醒  时效性异常
       insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','1' ,
                  'PROCESS_BEFORE_REGISTER' ,'登记时间异常 ',sysdate
         from M_Apply a
         where a.UPDATE_DATE >= checkBeginDate
              and exists (select b.* from  M_ApplyProcess b where b.PROCESS_DATE < a.APPLY_DATE and b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID)
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='PROCESS_BEFORE_REGISTER' );

       --办件不予受理  非处罚类办件不予受理  提醒  其它异常
       insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','6' ,
                  'NOT_BE_ACCEPTED' ,'办件不予受理',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and r.STATUS='1'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='NOT_BE_ACCEPTED' );
      -- 行政审批办件多次补正  行政许可办件出现多次补正的情况  预警  流程性异常
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'1','2' ,
                  'MULTI_CORRECTION' ,'多次补正',sysdate
         from  M_ApplyProcess p join M_Apply a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
         where p.UPDATE_DATE >= checkBeginDate
              and p.TACHE_NAME like '%补正%'
              and exists( select b.* from M_ApplyProcess b
                          where b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID
                                 and b.TACHE_NAME like '%补正%' and b.no <> p.no )
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='MULTI_CORRECTION');
      --- 行政审批办件受理后补正  行政许可办件受理后出现补正的情况  报警  流程性异常
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'2','2' ,
                  'CORRECTION_AFTER_ACCEPT' ,'行政审批办件受理后补正 ',sysdate
         from  M_ApplyProcess p join M_Apply a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
         where p.UPDATE_DATE >= checkBeginDate
              and p.TACHE_NAME like '%补正%'
              and exists( select b.* from M_ApplyProcess b
                          where b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID
                                 and b.TACHE_NAME like '%受理%' and b.PROCESS_DATE < p.PROCESS_DATE)
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='CORRECTION_AFTER_ACCEPT');
      --- 行政审批收费数据异常  行政许可办理过程中的收费不符合相关文件规定的标准	预警	内容性异常
      /**
      这个地方应该把 权力事项中的收费标准格式化，可以类似与处罚标准和自由裁量那样处理，通过实收费用和处罚标准进行对比。
      **/
      --- 获取相关的参数
      select to_number(param_value) into chargeOffset from M_OutWayParam where param_no='CHARGE_OFFSET';
      if chargeOffset is null then
         chargeOffset := 0.05;
      end if;
      --- 将异常插入到异常信息表中
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'1','3' ,
                  'CHARGE_WARNING' ,'行政审批收费数据异常',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and r.RECEIVABLE > 0 and ( (r.PAID-r.RECEIVABLE) / r.RECEIVABLE > chargeOffset or (r.RECEIVABLE-r.PAID) / r.RECEIVABLE < chargeOffset )
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='CHARGE_WARNING' );

      -- 办结状态未填报	行政职权运行数据结果表中的办结状态错误	提醒	内容性异常
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','3' ,
                  'NO_RESULT_STATUS' ,'办结状态未填报',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and (r.STATUS is null or r.STATUS not in ('1','2','3'))
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='NO_RESULT_STATUS' );

      --- 已办结但无过程数据	行政职权运行数据结果表中已有数据，但过程表中无数据或数据不符合标准	提醒	内容性异常
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','3' ,
                  'NO_PROCESS_DATA' ,'已办结但无过程数据',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and not exists( select b.* from M_ApplyProcess b
                          where b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID)
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='NO_PROCESS_DATA' );
      --- 办结时间异常	行政职权运行数据结果表中的办结时间早于过程表中的数据发生时间	提醒	内容性异常
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','3' ,
                  'PROCESS_AFTER_FINISH' ,'办结时间异常',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and exists( select b.* from M_ApplyProcess b
                          where b.INTERNAL_NO=a.INTERNAL_NO and b.ITEM_ID=a.ITEM_ID
                                and b.PROCESS_DATE > r.FINISH_TIME)
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='PROCESS_AFTER_FINISH' );
      --- 行政审批决定书未上报	行政许可决定书没有上报到电子监察系统	提醒	内容性异常
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  InTime   )
         select S_Out_Way_No.Nextval, '1', a.no  ,'0'/*针对办件的异常过程*/, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,'0','3' ,
                  'NO_DECISION' ,'行政审批决定书未上报',sysdate
         from M_ApplyResult r  join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.UPDATE_DATE >= checkBeginDate
              and ( r.ATTACHMENT is null or length(r.ATTACHMENT)<100
                       or not exists (select d.* from M_ApplyDoc d
                            where d.INTERNAL_NO=r.INTERNAL_NO and d.ITEM_ID=r.ITEM_ID and d.DOCUMENT_NAME like '%决定%' ) )
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code='NO_DECISION' );
      -- BJ_TYPE 1：许可 2：处罚 3 ：督查 4:投诉 5:其他异常
      -- MONITOR_STYLE 1:预警 2:报警 3:提醒
      -- MONITOR_TYPE  1：时效异常 2：流程异常 3：内容异常 4：裁量（收费）异常 5：风险防控异常 6：其他
  end check_permit_warning;

  -- 处罚异常（预报警）
  procedure check_punish_warning(checkBeginDate in date,calcNo in number)
  is
  begin
    -- BJ_TYPE 1：许可 2：处罚 3 ：督查 4:投诉 5:其他异常
    -- MONITOR_STYLE 1:预警 2:报警 3:提醒
    -- MONITOR_TYPE  1：时效异常 2：流程异常 3：内容异常 4：裁量（收费）异常 5：风险防控异常 6：其他
    null;
  end check_punish_warning;
  -- 其他异常（预报警）
  procedure check_other_warning(checkBeginDate in date,calcNo in number)
  is
  begin
    -- BJ_TYPE 1：许可 2：处罚 3 ：督查 4:投诉 5:其他异常
    -- MONITOR_STYLE 1:预警 2:报警 3:提醒
    -- MONITOR_TYPE  1：时效异常 2：流程异常 3：内容异常 4：裁量（收费）异常 5：风险防控异常 6：其他
    null;
  end check_other_warning;

  procedure check_warning(checkBeginDate in date,callType varchar2:='A',callerCode varchar2:=null)
  is
    calcNo number(12);
    calcTime date;

  begin
      select S_Out_Way_No.Nextval,sysdate into calcNo,calcTime from dual;
      -- BJ_TYPE 1：许可 2：处罚 3 ：督查 4:投诉 5:其他异常
      -- MONITOR_STYLE 1:预警 2:报警 3:提醒
      -- MONITOR_TYPE  1：时效异常 2：流程异常 3：内容异常 4：裁量（收费）异常 5：风险防控异常 6：其他
      -- 许可异常（预报警）
      check_permit_warning(checkBeginDate,calcNo);
      -- 处罚异常（预报警）
      check_punish_warning(checkBeginDate,calcNo);
      -- 其他异常（预报警）
      check_other_warning(checkBeginDate,calcNo);
      check_permit_process_time(checkBeginDate,calcNo);
      -- 插入计算汇总信息
      insert into M_OutWayCalc (  calc_no,  calc_time, call_type  ,caller  , scope_begin,
                scope_end  , alert_pieces  , alarm_pieces )
       values ( calcNo,sysdate,callType,callerCode,checkBeginDate,
                calcTime, (select count(1) from M_OutWay where calc_no=calcNo and MONITOR_STYLE='2'),
                    (select count(1) from M_OutWay where calc_no=calcNo and MONITOR_STYLE<>'2') );
       -- 只有这个最外层的存储过程需要commit的，后面重构时要注意
       commit;
  end check_warning;

  procedure auto_check_warning
  is
  begin
    check_warning( sysdate-10 ,'A',null);
  end;

  --- 自动摘牌
  procedure relieve_warning
  is
  begin
    update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='因为有时间预警、报警而自动摘牌'
    where a.Warning_Code = 'WARN_EXPIRED' and a.OutWayState='1'
          and exists (select b.* from M_OutWay b where
                     ( b.Warning_Code='ALARM_EXPIRED' or  b.Warning_Code='ALTER_EXPIRED') and b.BJ_No=a.BJ_No and b.BJ_TYPE=a.BJ_TYPE);

    update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='因为有时间报警而自动摘牌'
    where a.Warning_Code = 'ALARM_EXPIRED' and a.OutWayState='1'
          and exists (select b.* from M_OutWay b where
                        b.Warning_Code='ALTER_EXPIRED' and b.BJ_No=a.BJ_No and b.BJ_TYPE=a.BJ_TYPE);

  end relieve_warning;
begin
  -- Initialization
  null;
end alert_warning;
/
