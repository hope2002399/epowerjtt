--1,数据字典增加DBBM督办部门项（f_datacatalog，f_datadictionary）
--其中datavalue的值根据所处的系统需要自己改变
insert into F_DATACATALOG (catalogcode,catalogname,catalogstyle,catalogtype,catalogdesc,isupload)
values('DBBM','督办部门','U','L','督办部门','0');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('DBBM', 'DBBM', null, null, 'T', 'JS000000JT', 'S', null);

commit;



--2,修改包package2个： alert_warning 、alert_warning_new，目前使用的是alert_warning_new

create or replace package alert_warning_new is

-- Author  : PK
-- Created : 2013-12-8 9:21:55
-- Purpose : 电子监察预报警新规则
PROCEDURE P_A001 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);

PROCEDURE P_A002 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A003 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A004 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A005 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A006 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A007 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A008 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A009(calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A010 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A011 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A012 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A013 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A014 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A015 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A016 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A017 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A018 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A019(calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A020 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A021 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A022 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A023 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A024(calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A025 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A026 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A027 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A028 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_A029 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_B001 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_B002 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C001 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C002 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C003 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C004 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C005 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C006 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C007 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C008 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C009 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C010 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C011 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C012 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C013(calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C014 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C015 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C016 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C017 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);
PROCEDURE P_C018 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2);

--定量分析统计月份
Exe_date varchar2(10):= to_char(add_months(SYSDATE, -1), 'yyyymm') ;    --   -1 表示上个月

--工作日计算
 function calc_expired_date(beginDate in date, promise in number, promiseType in varchar2)   return date;
  procedure relieve_warning;
procedure p_call;
/*获取m_outway的主键OutWayNo*/
function getNoBM return varchar2;

function getBM return varchar2;

--工作日插入

/*
insert into oa_work_day
  (workday, daytype, workdaydesc)values
  (to_date('2014-6-2','yyyy-mm-dd'),'A','端午周一放假' );
  insert into oa_work_day
  (workday, daytype, workdaydesc)values
  (to_date('2014-9-8','yyyy-mm-dd'),'A','中秋周一放假' );
    insert into oa_work_day
  (workday, daytype, workdaydesc)values
  (to_date('2014-9-28','yyyy-mm-dd'),'B','国庆周日上班' );
    insert into oa_work_day
  (workday, daytype, workdaydesc)values
  (to_date('2014-10-11','yyyy-mm-dd'),'B','国庆周六上班' );
   insert into oa_work_day
  (workday, daytype, workdaydesc)values
  (to_date('2014-10-1','yyyy-mm-dd'),'A','国庆周三放假' );
   insert into oa_work_day
  (workday, daytype, workdaydesc)values
  (to_date('2014-10-2','yyyy-mm-dd'),'A','国庆周四放假' );
   insert into oa_work_day
  (workday, daytype, workdaydesc)values
  (to_date('2014-10-3','yyyy-mm-dd'),'A','国庆周五放假' );
   insert into oa_work_day
  (workday, daytype, workdaydesc)values
  (to_date('2014-10-6','yyyy-mm-dd'),'A','国庆周一放假' );
   insert into oa_work_day
  (workday, daytype, workdaydesc)values
  (to_date('2014-10-7','yyyy-mm-dd'),'A','国庆周二放假' );
  */


/*
select COUNT(*) from m_outway
DELETE FROM M_OUTWAY
CALL alert_warning_new.p_call();
*/


end alert_warning_new;


/

create or replace package body alert_warning_new is


  --A01环节承诺时限超时预警-岗位办理时间达到承诺期限（按小时计时）的4/5  每个办件的各个岗位都会报警
  --疑问：promise 单位是分钟吗？目前是按天算的        主表promise不等于过程各步骤时间之和？
    procedure p_A001  (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
  is
  begin
  --许可
    insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE, InTime   )
           select getNoBM, '1', a.no  , p.no, calcNo,
                    a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
           from M_apply a join m_applyprocess p on a.internal_no=p.internal_no and a.item_id=p.item_id
                where
                p.promise>0 --过滤掉没有承诺时间的节点
            --     and a.from_system = '0'
  and calc_expired_date(p.create_date,p.promise*0.8,p.promise_type)<p.process_date--先按照承诺时间算到期日，再跟实际处理日期对比
              and   not exists (
                      select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Process_No=p.no and Warning_Code=V_Warning_Code );

    --处罚
    insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE, InTime   )
           select getNoBM, '2', a.no  , p.no, calcNo,
                    a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
           from M_punish a join m_punishprocess p
           on a.internal_no=p.internal_no and a.item_id=p.item_id
                where
                p.promise>0 --过滤掉没有承诺时间的节点
                 and a.from_system = '0'
    and calc_expired_date(p.create_date,p.promise*0.8,p.promise_type)<p.process_date
              and   not exists (
                      select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Process_No=p.no and Warning_Code=V_Warning_Code );
  END;

  --A02 岗位办理时间超过承诺期限
    procedure p_A002  (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
  is
  begin
  --许可
      for ar in(select getNoBM, '1', a.no ano  , p.no, calcNo,
                    a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
           from M_apply a join m_applyprocess p on a.internal_no=p.internal_no and a.item_id=p.item_id
                where
                p.promise>0 --过滤掉没有承诺时间的节点
                 and a.from_system = '0'
    and calc_expired_date(p.create_date,p.promise,p.promise_type)<p.process_date
              and   not exists (
                      select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Process_No=p.no and Warning_Code=V_Warning_Code )
                      )loop 
                      
        insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE, InTime   )
                      select getNoBM, '1', ar.no  , ar.no, calcNo,
                    ar.ORG_ID,ar.INTERNAL_NO,ar.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
           from dual;
            --当有报警时取消预警
                  update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='该办件已被环节超时报警，环节超时预警自动取消' where a.bj_no=ar.ano AND
                   a.warning_code='A001' and a.outwaystate='1';
           end loop;

    --处罚
    for ar in (select getNoBM, '2', a.no ano , p.no, calcNo,
                    a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE
                  ,sysdate
           from M_punish a left join m_punishprocess p on a.internal_no=p.internal_no and a.item_id=p.item_id
                where
                p.promise>0 --过滤掉没有承诺时间的节点
                 and a.from_system = '0'
    and calc_expired_date(p.create_date,p.promise,p.promise_type)<p.process_date
              and   not exists (
                      select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no  and Process_No=p.no and Warning_Code=V_Warning_Code )
                      )loop
    insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE, InTime   )
           select getNoBM, '2', ar.ano  , ar.no, calcNo,
                    ar.ORG_ID,ar.INTERNAL_NO,ar.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE
                  ,sysdate
           from dual;
            --当有报警时取消预警
                  update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='该办件已被环节超时报警，环节超时预警自动取消' where a.bj_no=ar.ano AND
                   a.warning_code='A001' and a.outwaystate='1';
                   
          end loop ;
         
  END;


  --A03 　　事项办理的时间达到承诺期限（按小时计时）的4/5
                  --主表承诺时间不等于过程各节点之和？主表多为20工作日?
    procedure p_A003  (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
  is
  begin
  --许可
    insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,Monitor_Desc, InTime   )
           select getNoBM, '1', a.no  , '0', calcNo,
                    a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE
                      ,'办件创建时间为：'||to_char(a.create_date,'yyyy-mm-dd hh24:mi:ss')||'，办件承诺到期日为：'||to_char(calc_expired_date(a.create_date,a.promise*0.8,a.promise_type),'yyyy-mm-dd hh24:mi:ss')||',实际办结日为：'||to_char(nvl(r.finish_time,sysdate),'yyyy-mm-dd hh24:mi:ss')||',承诺时限是'||a.promise*0.8||'天。',sysdate
           from M_apply a left join m_applyresult r on a.internal_no=r.internal_no and a.item_id=r.item_id
                where
                a.promise>0 --过滤掉没有承诺时间的节点
                 and a.from_system = '0'
     and calc_expired_date(a.create_date,a.promise*0.8,a.promise_type)<=nvl(r.finish_time,sysdate)
              and   not exists (
                      select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code=V_Warning_Code );

    --处罚
    insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,Monitor_Desc, InTime   )
           select getNoBM, '2', a.no  , '0', calcNo,
                    a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE
                        ,'办件创建时间为：'||to_char(a.create_date,'yyyy-mm-dd hh24:mi:ss')||'，办件承诺到期日为：'||to_char(calc_expired_date(a.create_date,a.promise*0.8,
                      a.promise_type),'yyyy-mm-dd hh24:mi:ss')||',实际办结日为：'||to_char(nvl(r.finish_date,sysdate),'yyyy-mm-dd hh24:mi:ss')||',承诺时限是'||a.promise*0.8||'天。'
                    ,sysdate
           from M_punish a left join m_punishresult r on a.internal_no=r.internal_no and a.item_id=r.item_id
                where
                a.promise>0 --过滤掉没有承诺时间的节点
                 and a.from_system = '0'
    and calc_expired_date(a.create_date,a.promise*0.8,a.promise_type)<=nvl(r.finish_date,sysdate)
              and   not exists (
                      select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Warning_Code=V_Warning_Code );
  END;

  --A004 事项办理的时间超过承诺期限
    procedure p_A004  (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
  is
  begin
  --许可
  for ar in(
    select a.org_id,a.internal_no,a.item_id,a.no ano,a.create_date,a.promise,a.promise_type,r.finish_time from M_apply a  left join m_applyresult r on a.internal_no=r.internal_no and a.item_id=r.item_id
                where
                a.promise>0 --过滤掉没有承诺时间的节点
                 and a.from_system = '0'
  and calc_expired_date(a.create_date,a.promise,a.promise_type)<=nvl(r.finish_time,sysdate)
              and   not exists (
                      select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code=V_Warning_Code )
    ) loop
    insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,Monitor_Desc, InTime   )
           select getNoBM, '1', ar.ano  ,'0', calcNo,
                    ar.ORG_ID,ar.INTERNAL_NO,ar.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE
                      ,'办件创建时间为：'||to_char(ar.create_date,'yyyy-mm-dd hh24:mi:ss')||'，办件承诺到期日为：'||to_char(calc_expired_date(ar.create_date,ar.promise,
                      ar.promise_type),'yyyy-mm-dd hh24:mi:ss')||',实际办结日为：'||to_char(nvl(ar.finish_time,sysdate),'yyyy-mm-dd hh24:mi:ss')||',承诺时限是'||ar.promise||'天。' ,sysdate
          from dual;


              --当有报警时取消预警
                  update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='该办件已被超时报警，超时预警自动取消' where a.bj_no=ar. ano AND
                   a.warning_code='A003' and a.outwaystate='1';
              end loop;
    --处罚
    for pr in(
    select a.org_id,a.internal_no,a.item_id,a.no ano,a.create_date,a.promise,a.promise_type,r.finish_date from M_punish a  left join m_punishresult r on a.internal_no=r.internal_no and a.item_id=r.item_id
                where
                a.promise>0 --过滤掉没有承诺时间的节点
                 and a.from_system = '0'
  and calc_expired_date(a.create_date,a.promise,a.promise_type)<=nvl(r.finish_date,sysdate)
              and   not exists (
                      select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Warning_Code=V_Warning_Code )
    ) loop

    insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE, Monitor_Desc,InTime   )
           select getNoBM, '2', pr.ano  , '0', calcNo,
                    pr.ORG_ID,pr.INTERNAL_NO,pr.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE
                      ,'办件创建时间为：'||to_char(pr.create_date,'yyyy-mm-dd hh24:mi:ss')||',办件承诺到期日为：'||to_char(calc_expired_date(pr.create_date,pr.promise,
                      pr.promise_type),'yyyy-mm-dd hh24:mi:ss')||',实际办结日为：'||to_char(nvl(pr.finish_date,sysdate),'yyyy-mm-dd hh24:mi:ss')||',承诺时限是'||pr.promise||'天。',
                    sysdate
           from dual;
              --当有报警时取消预警
                  update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='该办件已被超时报警，超时预警自动取消' where a.bj_no=pr. ano AND
                   a.warning_code='A003' and a.outwaystate='1';
              end loop;
  END;



     --　A005 　案件登记时间晚于案发时间10个工作日以上
  procedure p_A005  (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
  is
  begin
    insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE, Monitor_Desc,InTime   )
           select getNoBM, '2', a.no  ,'0', calcNo,
                    ORG_ID,INTERNAL_NO,item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE
                    ,'案发时间为：'||to_char(a.AJ_OCCUR_DATE,'yyyy-mm-dd hh24:mi:ss')||'，案发10工作日时间为：'||to_char(calc_expired_date(a.AJ_OCCUR_DATE,10,'1'),'yyyy-mm-dd hh24:mi:ss')||'，实际登记时间为：'||to_char(a.create_date,'yyyy-mm-dd hh24:mi:ss')||'。'
                    ,sysdate
           from M_PUNISH a
                where
            a.create_date >calc_expired_date(a.AJ_OCCUR_DATE,10,'1')
             and a.from_system = '0'
              and    not exists (
                      select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Warning_Code=V_Warning_Code );
  end ;


     --　A006 　行政权力办件3 个月未进行处理(目前只做了处罚) 一个办件只报一次警
  procedure p_A006  (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
  is
  begin
    insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                      ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                      Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE, InTime   )
           select getNoBM, '2', t.no  ,'0', calcNo,
                    t.ORG_ID,t.INTERNAL_NO,t.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                    V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
           from
 (select   p.no_ord,a.no, a.ORG_ID ,a.INTERNAL_NO,a.item_id ,p.process_date
                ,  row_number() over( partition by a.internal_no order by p.no_ord desc) r
           from M_punish a join m_punishprocess p on a.internal_no=p.internal_no
              and a.item_id=p.item_id where  a.from_system = '0' ) t
              where t.r=1 /*获取最大节点*/
              and 1=2 --强制不报警

              and not exists (select * from m_punishresult where INTERNAL_NO=t.INTERNAL_NO)--排除办结案件
              and sysdate>=t.process_date+90 /*最大节点3个月未处理*/
                and    not exists (
                      select * from M_OutWay where BJ_TYPE='2' and BJ_No=t.no and Warning_Code=V_Warning_Code );
  end ;

   /*  许可过程：   1：同意通过，本岗处理完成，同意上一岗位意见，进入后续岗位；
2：否决通过，本岗处理完成，不同意上一岗位意见，进入后续岗位；
3：暂停，由于申请者原因或上报上级机关原因，计时暂停；
4：补正，要求申请者对材料进行补正，此时计时暂停；
5：正在处理；
6：退回，退回到上一岗位；
7：中止，整个办件处理流程中止；

处罚过程：1：正在处理；2：暂停；4：退回；5：通过；6：中止
*/

 --　A007 　流程退回预警

procedure p_A007 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
--许可
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,MONITOR_SOURCE,   InTime   )
          select getNoBM, '1', a.no  ,p.no, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
             V_Warning_Code,V_MONITOR_LOGO,   V_MONITOR_SOURCE,
        sysdate
         from M_apply a join m_applyprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id
              where      p.internal_no||p.no_ord in (select internal_no||(no_ord-1) from m_applyprocess where status ='6' )  --取被后续岗位退回的节点 许可退回  要取上一个岗位名称
               and a.from_system = '0'
               and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Process_No=p.no and Warning_Code =V_Warning_Code);
--处罚

  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,p.no, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                 V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
   from M_punish a join m_punishprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id
          and a.from_system = '0'
          where
           p.internal_no||p.no_ord in (select internal_no||(no_ord-1) from m_punishprocess where status ='4' )  --取被后续岗位退回的节点
               and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Process_No=p.no and Warning_Code =V_Warning_Code);

end;

 --　A008 　流程暂停预警
procedure p_A008 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is

begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '1', a.no  ,p.no, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
             V_Warning_Code,V_MONITOR_LOGO,   V_MONITOR_SOURCE,
        sysdate
         from M_apply a join m_applyprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id
              where  p.status ='3'--许可暂停
               and a.from_system = '0'
               and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Process_No=p.no and Warning_Code =V_Warning_Code);
--处罚
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,p.no, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                 V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from M_punish a join m_punishprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id
              where  p.status ='2'--处罚暂停
               and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Process_No=p.no and Warning_Code =V_Warning_Code);
end;

 --　A009　流程终止预警
procedure p_A009 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '1', a.no  ,p.no, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
             V_Warning_Code,V_MONITOR_LOGO,   V_MONITOR_SOURCE,
        sysdate
         from M_apply a join m_applyprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id
              where  p.status ='7'--许可中止
              and a.from_system = '0'
               and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Process_No=p.no and Warning_Code =V_Warning_Code);
--处罚
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,p.no, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE ,
                 V_Warning_Code,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from M_punish a join m_punishprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id
              where  p.status ='6'-- 处罚中止
               and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Process_No=p.no and Warning_Code =V_Warning_Code);
end;


   -- A010 流程多次退回报警
   procedure p_A010 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
   --许可

   for ar in(
     select a.no ano,p.no  pno,a.internal_no,a.org_id,a.item_id
        from  M_ApplyProcess p join M_Apply a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
         where
              p.internal_no||p.no_ord in
         (select p.internal_no||(max(p.no_ord)-1)           from  M_applyProcess p
         where  p.status ='6' --许可退回
              and exists( select b.* from M_applyProcess b
                          where b.INTERNAL_NO=p.INTERNAL_NO and b.ITEM_ID=p.ITEM_ID
          and b.status ='6' and b.node_id = p.node_id and b.no!=p.no )
           group by p.internal_no) --找出被退回的节点及办件号
           and a.from_system = '0'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Process_No=p.no and Warning_Code=V_Warning_Code)
     ) loop
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '1', ar.ano  ,ar.pNO, calcNo,
                  ar.ORG_ID,ar.INTERNAL_NO,ar.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
     from dual ;

                        --取消单个该节点退回预警
                  update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='该节点已被多次退回预警，单次退回预警自动取消' where a.bj_no=ar. ano AND  a.process_no in(
            select no from   m_applyprocess where node_id in(
             select node_id  from m_applyprocess where no =ar.pNO
              ))
                  and a.warning_code='A007' and a.outwaystate='1';
                  end loop;
   --处罚

   for pr in(
     select a.no ano,p.no  pno,a.internal_no,a.org_id,a.item_id from  M_punishProcess p join M_punish a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
         where
         p.internal_no||p.no_ord in
         (select p.internal_no||(max(p.no_ord)-1)           from  M_punishProcess p
         where  p.status ='4' --处罚退回
              and exists( select b.* from M_punishProcess b
                          where b.INTERNAL_NO=p.INTERNAL_NO and b.ITEM_ID=p.ITEM_ID
          and b.status ='4' and b.node_id = p.node_id and b.no!=p.no )
           group by p.internal_no)
           and a.from_system = '0'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Process_No=p.no and Warning_Code=V_Warning_Code)  --找出被退回的节点及办件号
     ) loop
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', pr.ano  ,pr.pNO, calcNo,
                  pr.ORG_ID,pr.INTERNAL_NO,pr.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
       from dual ;

                    --取消单个该节点退回预警
                  update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='该节点已被多次退回预警，单次退回预警自动取消' where a.bj_no=pr. ano AND  a.process_no
               in(
            select no from   m_punishprocess where node_id in
            (select node_id  from m_punishprocess where no =pr.pNO  ) )

                  and a.warning_code='A007' and a.outwaystate='1';
                  end loop;
end;


 --　A011 　决定不同预警-办理过程中后一岗位与前一岗位做出不同的决定  等效于否决通过 蒋确认了许可，处罚未知
 procedure p_A011 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
--许可
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '1', a.no  ,p.no, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from M_ApplyProcess p join M_Apply a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
              where
              p.status='2' --否决通过
              and a.from_system = '0'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Process_No=p.no and Warning_Code=V_Warning_Code);
--处罚
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,p.no, calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from M_punishProcess p join M_punish a on p.INTERNAL_NO=a.INTERNAL_NO and p.ITEM_ID=a.ITEM_ID
              where
          1=2 and --强制不报警
              p.status='7' --？？？否决通过  1：正在处理；2：暂停；4：退回；5：通过；6：中止
              and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Process_No=p.no and Warning_Code=V_Warning_Code );
end;

--　A012 　不予受理预警    直到有办件结果再报警 蒋确认
procedure p_A012 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
 insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,MONITOR_SOURCE,   InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from m_Applyresult r   join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where ( r.note  like '不予受理%'
          or  r.status='1'   )           --1：不予受理；2：许可/ 同意；3：不许可/ 不同意
          and a.from_system = '0'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code=V_Warning_Code );
end;

--　A013　不予许可预警  直到有办件结果再报警 蒋确认
procedure p_A013 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
 insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from M_Applyresult r  join M_apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where ( r.note  like '不予许可%'
          or  r.status='3'   )        --1：不予受理；2：许可/ 同意；3：不许可/ 不同意
          and a.from_system = '0'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no and Warning_Code=V_Warning_Code );
end;

--14  不予立案预警 ？？？结果表无法知道
procedure p_A014(calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
       from  M_punishresult r join M_punish a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where    (  r.punish_result like '不予立案%'  or r.punish_deside='0'  )
         -- 0 ：不予立案 新增 1：做出行政处罚决定；2：行政处理；3：撤消；4：移送司法机关
         and a.from_system = '0'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Warning_Code=V_Warning_Code);
end;

--15 不予处罚预警
procedure p_A015(calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
      insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_punishresult r join M_punish a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where  (  r.punish_result like '不予处罚%'  or r.punish_deside='3'  )
         --1：做出行政处罚决定；2：行政处理；3：撤消；4：移送司法机关
         and a.from_system = '0'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no and Warning_Code=V_Warning_Code);
end;

--　A016 　　　处罚罚款金额未上报
/*punish_class 1：警告；2：通报批评；3：罚款；4
没收财物（没收违法所得、没收非法财物）；5：暂扣或者吊销许可证和营业执照6：责令停产、停业
7：行政拘留8：劳动教养*/
procedure p_A016 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
 insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,MONITOR_SOURCE,   InTime   )
         select getNoBM, '2', r.no  ,'0', calcNo,
                  r.ORG_ID,r.INTERNAL_NO,r.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from m_punishresult r left join m_punish a on a.internal_no = r.internal_no and a.org_id = r.org_id
         where
               r.punish_class like '%3%'
                --罚款  必须要用like 因为处罚种类有  整改的也是3      公路的数据其他状态也有罚款的
               and (r.PUNISH_RESULT_FINE is null or r.PUNISH_RESULT_FINE<=0
               or r.punish_result like '%元')  --有些处罚金额字段为空 但是处罚结果却有金额
               and a.from_system = '0'
              and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=r.no and Warning_Code=V_Warning_Code );
end;

--　A017 　　　处罚没收价值未上报
/*punish_class 1：警告；2：通报批评；3：罚款；4
没收财物（没收违法所得、没收非法财物）；5：暂扣或者吊销许可证和营业执照6：责令停产、停业
7：行政拘留8：劳动教养*/
procedure p_A017 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
 insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', r.no  ,'0', calcNo,
                  r.ORG_ID,r.INTERNAL_NO,r.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from m_punishresult r  left join m_punish a on a.internal_no = r.internal_no and a.org_id = r.org_id
         where
               r.punish_class = '4'    --没收财物
               and a.from_system = '0'
            and (r.PUNISH_RESULT_EXPROPRIATION_V is null or r.PUNISH_RESULT_EXPROPRIATION_V=0)
              and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=r.no and Warning_Code=V_Warning_Code );
end;

--　A018 　　　许可受理通知书未上报(已办结非不予受理办件文书 )
procedure p_A018 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,MONITOR_SOURCE,   InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_Apply a  join  m_applyresult r on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
              where
              r.status!='1' --已办结的非不予受理的办件
               and a.from_system = '0'
              and     not exists (select d.* from M_ApplyDoc d
                            where d.INTERNAL_NO=a.INTERNAL_NO and d.ITEM_ID=a.ITEM_ID and d.DOC_NAME like '%受理通知书%' )
                    and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;


--　A019 　　　处罚违法通知书未上报
procedure p_A019 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_punish a join m_punishresult r on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
              where
         r.punish_deside!='3'--已办结的非不予处罚的案件
            and  r.program='2'--现场处罚的没有证据 不报警
            and a.from_system = '0'
      and not exists (select d.* from M_punishDoc d
                            where d.INTERNAL_NO=a.INTERNAL_NO   and d.DOC_NAME like '%违法行为通知书%' )  --行政处罚_违法行为通知书.doc  节点：打印送达预先告知书
                  and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　A020 　 　　　　许可决定书未上报
procedure p_A020 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,MONITOR_SOURCE,   InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_Apply a  join  m_applyresult r on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
         where r.status='2'--已办结的许可办件
         and a.from_system = '0'
      and not exists (select d.* from M_ApplyDoc d
                            where d.INTERNAL_NO=a.INTERNAL_NO and d.ITEM_ID=a.ITEM_ID  and d.DOC_NAME like '%决定书%' ) --交通行政许可准予决定书.doc  桥梁_决定书.doc
                 and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　A021　　　处罚决定书未上报
procedure p_A021 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,MONITOR_SOURCE,   InTime   )
         select getNoBM, '2', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_punish a  join m_punishresult r on  r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
              where
        r.punish_deside!='3'--已办结的？不知道是否要过滤掉未处罚的办件
        and a.from_system = '0'
      and not exists (select d.* from M_punishDoc d
                            where d.INTERNAL_NO=a.INTERNAL_NO and d.org_id=a.org_id  and d.DOC_NAME like '%处罚决定送达回证%' or d.DOC_NAME like '当场处罚决定书%') --行政处罚_处罚决定送达回证.doc 节点：打印送达处罚决定书
                 and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　A022 　　　许可申请材料未上报
procedure p_A022 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_Apply a join m_applyresult r on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
              where
        r.status!='1'--已办结的非不予受理办件
        and a.from_system = '0'
      and  not exists (select d.* from M_ApplyDoc d
                            where d.INTERNAL_NO=a.INTERNAL_NO and d.ITEM_ID=a.ITEM_ID  and d.DOC_NAME like '%申请材料%' )  --许可申请材料清单.doc
                   and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　A023 　　　处罚证据材料未上报（？？？不知道证据是哪个节点上传的？也不知道材料名称是怎样的）
procedure p_A023 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_punish a  join m_punishresult r on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
              where
              r.punish_deside!='3'--已办结的处罚
              and  r.program='2'--现场处罚的没有证据 不报警
              and a.from_system = '0'
        and not exists (select d.* from M_punishDoc d
                            where d.INTERNAL_NO=a.INTERNAL_NO and d.org_id=a.org_id  and d.document_name = '案件受理证据材料' )
                and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　A024 　　　权力编码未确认
procedure p_A024 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
--许可
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  MONITOR_SOURCE, InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,A.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_apply a join b_power b on a.item_id=b.item_id
              where  a.create_date<=b.lastmodifytime
              and b.ql_state in('T','X')
              and a.from_system = '0'
                and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
--处罚
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,A.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_punish a join b_power b on a.item_id=b.item_id
              where  a.create_date<=b.lastmodifytime
              and a.from_system = '0'
              and b.ql_state in('T','X')
                and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　A025 　　　行政权力已挂起
procedure p_A025 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
--许可
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  MONITOR_SOURCE, InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,A.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_apply a join b_power b on a.item_id=b.item_id
              where  a.create_date<=b.lastmodifytime
              and b.ql_state in('T')
              and a.from_system = '0'
                and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
--处罚
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,A.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_punish a join b_power b on a.item_id=b.item_id
              where  a.create_date<=b.lastmodifytime
              and b.ql_state in('T')
              and a.from_system = '0'
                and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　A026 　　　　　裁量执行异常报警？？？？
procedure p_A026 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,MONITOR_SOURCE,   InTime   )
         select getNoBM, '2', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from m_Punishresult r join M_punish a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
              where  r.standard!=r.punish_result
              and 1=2 --强制不报警
              and a.from_system = '0'
                and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　　27 收费执行异常报警
procedure p_A027 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from m_Applyresult r join M_Apply a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
              where
     r.receivable!=r.paid
       and 1=2 --强制不报警
       and a.from_system = '0'
                   and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　A028 　　　　　重大处罚提醒  (依照老系统做的)
procedure p_A028 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,a.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from m_Punishresult r join M_punish a on r.INTERNAL_NO=a.INTERNAL_NO and r.ITEM_ID=a.ITEM_ID
              where  r.Program = '1'
   AND r.Punish_Class = '3'
   and a.from_system = '0'
   AND r.Punish_Result_Fine > 5000
                and not exists (
                    select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--　A029　　　办件、案件重要权力提醒（不知道？？？）
procedure p_A029 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
--许可
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  MONITOR_SOURCE, InTime   )
         select getNoBM, '1', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,A.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_apply a join b_power b on a.item_id=b.item_id
              where
                 1=2 --强制不报警
                 and a.from_system = '0'
                and not exists (
                    select * from M_OutWay where BJ_TYPE='1' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
--处罚
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,  InTime   )
         select getNoBM, '2', a.no  ,'0', calcNo,
                  a.ORG_ID,a.INTERNAL_NO,A.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE,sysdate
         from  M_punish a join b_power b on a.item_id=b.item_id
              where
                 1=2 --强制不报警
                 and a.from_system = '0'
                 and  not exists ( select * from M_OutWay where BJ_TYPE='2' and BJ_No=a.no  and Warning_Code=V_Warning_Code );
end;

--督办 B001 未及时发起督办
procedure p_B001 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE,Monitor_Desc,  InTime   )
         select getNoBM, '7', o.outwayno  ,'0', calcNo,
                  o.ORG_ID,o.INTERNAL_NO,o.item_id,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE
                  ,'异常产生时间为：'||to_char(o.intime,'yyyy-mm-dd hh24:mi:ss')||'，承诺督办时间为：'||to_char(calc_expired_date(o.intime,5,'1'),'yyyy-mm-dd hh24:mi:ss')||',发起督办时间为：'||to_char(nvl(s.supervise_date,sysdate),'yyyy-mm-dd hh24:mi:ss')||',承诺时限是5工作日。'
                  ,sysdate
         from M_OutWay o left join M_SUPERVISEBASIC s on o.outwayno=s.outwayid
         --针对单个异常督办的
              where   nvl(s.supervise_date,sysdate) >calc_expired_date(o.intime,5,'1') --5 个工作日
             and o.monitor_style ='2' and o.warning_code != V_Warning_Code
                  and not exists (
                    select * from M_OutWay where BJ_TYPE='7' and BJ_No=o.outwayno  and Warning_Code=V_Warning_Code ) and o.org_id in 
                    (select a.depno from  (select level as cj,t.* from f_unitinfo t connect by  t.parentunit= prior unitcode start with depno = getBM  order by level) a where a.cj <3);
end;

--督办 B002 未及时办结督办
procedure p_B002 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
begin
  insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   , MONITOR_SOURCE, Monitor_Desc, InTime   )
         select getNoBM, '4', S.SUPERVISE_NO  ,'0', calcNo,
                  S.ORG_ID,'0','0',V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO,V_MONITOR_SOURCE
                  ,'督办发起时间为：'||to_char(s.supervise_date,'yyyy-mm-dd hh24:mi:ss')||'，承诺督办办结时间为：'||to_char(calc_expired_date(s.supervise_date,20,'1'),'yyyy-mm-dd hh24:mi:ss')||',实际督办办结时间为：'||to_char(nvl(r.end_date, sysdate),'yyyy-mm-dd hh24:mi:ss')||',承诺时限是20工作日。'
                  ,sysdate
         from  M_SUPERVISEBASIC s  left  join m_Superviseresult r
         on s.supervise_no=r.supervise_no--关联督办结果表
              where nvl(r.end_date, sysdate)>calc_expired_date(s.supervise_date,20,'1')
           --   and r.supervise_no is null --取未办结的督办
                  and not exists (
                    select * from M_OutWay where BJ_TYPE='4' and BJ_No=S.SUPERVISE_NO  and Warning_Code=V_Warning_Code ) and s.org_id in 
                    (select a.depno from  (select level as cj,t.* from f_unitinfo t connect by  t.parentunit= prior unitcode start with depno = getBM  order by level) a where a.cj <3)
                    ;
END;

--定量分析预报警


--C001 权力运行量环比偏差过大提示
procedure p_C001 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份2013-1
 insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime   )
select  getNoBM
,'6'
,null
,null
,calcno
,t2.org_id
,'0',t2.item_id
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,t2.orgname||',权力编号为'||t2.item_id||'的行政权力，'||substr(Exe_date,1,4) ||'年'||substr(Exe_date,5,2)||'月运行量是'||t2.bjs||'件，上月运行量是'||t2.sybjs||'件，环比偏差达到'||to_char(round(abs(t2.bjs - t2.sybjs) / t2.sybjs, 2),'0.00')*100||'%。' ,
V_MONITOR_SOURCE,sysdate
  from (select t.*,
               LAG(bjs, 1, 0) OVER(PARTITION BY t.org_id, t.item_id ORDER BY t.yf) sybjs
               --计算环比 同比是将1改为12
          from (select a.org_id,
                       a.item_id,
                       to_char(create_date, 'yyyymm') yf,
                       count(1) bjs,
                       max(a.department) orgname
                  from m_apply a
                 group by a.org_id,
                          a.item_id,
                          to_char(a.create_date, 'yyyymm')
                union
                select a.org_id,
                       a.item_id,
                       to_char(create_date, 'yyyymm'),
                       count(1) bjs,
                        max(a.department) orgname
                  from m_punish a
                 group by a.org_id,
                          a.item_id,
                          to_char(a.create_date, 'yyyymm')  ) t
                           ) t2
 where t2.yf =Exe_date --每月三号执行，只计算上月环比
 and t2.sybjs!=0--过滤掉上月数为0
   and round(abs(t2.bjs - t2.sybjs) / t2.sybjs, 2) >= 0.1 ;--只显示指定偏差
END;

--C002 权力运行量同比偏差过大提示
procedure p_C002 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
   insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime   )

select getNoBM
,'6'
,null
,null
,calcno
,t2.org_id
,'0',t2.item_id
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,t2.orgname||',权力编号为'||t2.item_id||'的行政权力，'||substr(Exe_date,1,4) ||'年'||substr(Exe_date,5,2)||'月运行量是'||t2.bjs||'件，去年同期运行量是'||t2.sybjs||'件，同比偏差达到'||to_char(round(abs(t2.bjs - t2.sybjs) / t2.sybjs, 2),'0.00')*100||'%。',
V_MONITOR_SOURCE,sysdate
  from (select t.*,
               nvl(LAG(bjs, 12, 0) OVER(PARTITION BY t.org_id, t.item_id ORDER BY t.yf),0) sybjs
               --计算环比 同比是将1改为12
          from (select a.org_id,
                       a.item_id,
                       to_char(create_date, 'yyyymm') yf,
                       count(1) bjs
                        , max(a.department) orgname
                  from m_apply a
                 group by a.org_id,
                          a.item_id,
                          to_char(a.create_date, 'yyyymm')
                union
                select a.org_id,
                       a.item_id,
                       to_char(create_date, 'yyyymm'),
                       count(1) bjs
                         , max(a.department) orgname
                  from m_punish a
                 group by a.org_id,
                          a.item_id,
                          to_char(a.create_date, 'yyyymm')) t
                           ) t2
 where t2.yf = Exe_date--每月三号执行，只计算上月环比
 and t2.sybjs!=0--过滤掉上月数为0
   and round(abs(t2.bjs - t2.sybjs) / t2.sybjs, 2) >= 0.05 ;--只显示指定偏差
END;


   --3 在用行政权力数环比偏差过大提示
   procedure p_C003 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
 insert into M_OutWay (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime   )
select getNoBM
,'6'
,null
,null
,calcno
,t2.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,substr(Exe_date,1,4) ||'年'||substr(Exe_date,5,2)||'月,'||t2.orgname||',在用行政权力数是'||t2.bjs||'个，上月所用行政权力数是'||t2.sybjs||'个，环比偏差达到'||to_char(round(abs(t2.bjs - t2.sybjs) / t2.sybjs, 2),'0.00')*100||'%。'
,V_MONITOR_SOURCE,SYSDATE
  from (select t1.*,
               LAG(bjs, 1, 0) OVER(PARTITION BY t1.org_id ORDER BY t1.yf) sybjs
               --计算环比 同比是将1改为12
          from (select t.org_id,t.yf,sum(t.bjs) bjs, t.orgname from ( select a.org_id,
                       to_char(create_date, 'yyyymm') yf,
                       count(distinct a.item_id) bjs
                         , max(a.department) orgname
                  from m_apply a
                 group by a.org_id,
                          to_char(a.create_date, 'yyyymm')

                union
                select a.org_id,
                       to_char(create_date, 'yyyymm') yf,
                       count(distinct a.item_id) bjs
                         , max(a.department) orgname
                  from m_punish a
                 group by a.org_id,
                          to_char(a.create_date, 'yyyymm') ) t
                          group by t.org_id,t.yf,t.orgname) t1 ) t2
 where t2.yf = Exe_date--每月三号执行，只计算上月环比
 and t2.sybjs!=0--过滤掉上月数为0
   and round(abs(t2.bjs - t2.sybjs) / t2.sybjs, 2) >= 0.1 ;--只显示指定偏差
END;

 --4在用行政权力数同比偏差过大提示
 procedure p_C004 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
      insert into m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime )
select getNoBM
,'6'
,null
,null
,calcno
,t2.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,substr(Exe_date,1,4) ||'年'||substr(Exe_date,5,2)||'月,'||t2.orgname||',在用行政权力数是'||t2.bjs||'个，去年同期在用行政权力数是'||t2.sybjs||'个，同比偏差达到'||to_char(round(abs(t2.bjs - t2.sybjs) / t2.sybjs, 2),'0.00')*100||'%。'
,V_MONITOR_SOURCE,SYSDATE
  from (select t1.*,
               LAG(bjs, 12, 0) OVER(PARTITION BY t1.org_id ORDER BY t1.yf) sybjs
               --计算环比 同比是将1改为12
          from (select t.org_id,t.yf,sum(t.bjs) bjs, t.orgname from ( select a.org_id,
                       to_char(create_date, 'yyyymm') yf,
                       count(distinct a.item_id) bjs
                         , max(a.department) orgname
                  from m_apply a
                 group by a.org_id,
                          to_char(a.create_date, 'yyyymm')

                union
                select a.org_id,
                       to_char(create_date, 'yyyymm') yf,
                       count(distinct a.item_id) bjs
                         , max(a.department) orgname
                  from m_punish a
                 group by a.org_id,
                          to_char(a.create_date, 'yyyymm') ) t
                          group by t.org_id,t.yf,t.orgname) t1
                           ) t2
 where t2.yf = Exe_date--每月三号执行，只计算上月环比
 and t2.sybjs!=0--过滤掉上月数为0
   and round(abs(t2.bjs - t2.sybjs) / t2.sybjs, 2) >= 0.05 ;--只显示指定偏差
END;

--5 在用行政权力数对比偏差过大提示
 procedure p_C005 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
power_sum number(5); --权力总数
power_sum_inuse number(5); --在用权力总数
--bm_power_sum number(5);
bm_power_sum_inuse number(5);--部门在用权力总数
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
select count(item_id) into power_sum  from b_power  where ql_state in('A');--全库权力总数

select count(distinct t.item_id) into power_sum_inuse  from
(select  item_id from m_apply
                union
                select  item_id from m_punish
                 ) t;--全库在用权力总数

for r in(select b.org_id,count(b.item_id) qls,max(u.unitname) orgname  from b_power b
   join f_unitinfo u on  b.org_id=u.depno
                 where ql_state in('A')
                 group by org_id  )--将各部门权力总数放入游标
                 loop

select qls into bm_power_sum_inuse  from
(select org_id, nvl(count(distinct item_id),0) qls from m_apply
where  to_char(create_date, 'yyyymm')= Exe_date--只选择计算日的上个月在用权力数
 group by org_id
                union
                select  org_id, count(distinct item_id) qls from m_punish
                where  to_char(create_date, 'yyyymm')=Exe_date--只选择计算日的上个月数据
                group by org_id
                 ) t where t.org_id=r.org_id;--循环计算每个部门在用权力数
            if
             abs(bm_power_sum_inuse/r.qls-power_sum_inuse/power_sum)>=0.05
             --筛选出符合条件的插入数据
            then
      insert into m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime )
select getNoBM
,'6'
,null
,null
,calcno
,r.org_id
,NULL,NULL
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月,'||r.orgname||',在用行政权力数是'||bm_power_sum_inuse||'个，本部门拥有权力数是'||r.qls||'个，本部门在用行政权力占比是'||to_char(round(bm_power_sum_inuse/r.qls, 2),'0.00')||'，而权力平均在用数占比为'||to_char(round(power_sum_inuse/power_sum, 2),'0.00')||'，偏差为'||
abs(bm_power_sum_inuse/r.qls-power_sum_inuse/power_sum)*100||'%。'
,V_MONITOR_SOURCE,SYSDATE
          from dual;
   end if;
   end loop;
END;

   --6 非处罚类办件结果否定率过高提示
  procedure p_C006 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
   insert into   m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE,InTime)
   select
   getNoBM
  ,'6'
,null
,null
,calcno
,t1.org_id
,NULL,NULL
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
                  ,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月,'||t1.orgname||',非处罚类事项办理总数是'||t1.zs||'件，其中不予受理、不予许可等情况合计达到'||nvl(t2.bxs,0)||'件，占比为'||round(nvl(t2.bxs,0)/t1.zs,2)*100||'%。'
                  ,V_MONITOR_SOURCE    ,sysdate
                  from
     ( select r.org_id,count(distinct r.internal_no) zs,max(a.department)  orgname
     from m_applyresult r join m_apply a on r.internal_no=a.internal_no
   where   to_char(r.create_date, 'yyyymm')=Exe_date--只选被统计月份
      group by r.org_id) t1 left join
        (select org_id,count(distinct internal_no) bxs /*不予数量 */ from m_applyresult
   where  status in ('1','3')
   and  to_char(create_date, 'yyyymm')=Exe_date
   group by org_id) t2  on t1.org_id=t2.org_id
   where t2.bxs/t1.zs>=0.02;
END;


 --7 处罚类案件结果否定率过高提示
  procedure p_C007 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
   insert into   m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE,InTime)
   select
   getNoBM
  ,'6'
,null
,'0'
,calcno
,t1.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
                  ,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月,'||t1.orgname||',行政处罚类事项办理总数是'||t1.zs||'件，其中不予立案、不予处罚等情况合计达到'||t2.bxs||'件，占比为'||round(t2.bxs/t1.zs,2)*100||'%。'
                  ,V_MONITOR_SOURCE    ,sysdate
                  from
     ( select r.org_id,count(distinct r.internal_no) zs ,max(a.department)  orgname
     from m_punishresult r join m_apply a on r.internal_no=a.internal_no
   where  to_char(r.create_date, 'yyyymm')=Exe_date
      group by r.org_id) t1 left join
        (select org_id,count(distinct internal_no) bxs from m_punishresult
   where   punish_deside in('0','3') --3 为撤销  0 为不立案
   and to_char(create_date, 'yyyymm')=Exe_date
   group by org_id) t2  on t1.org_id=t2.org_id
   where t2.bxs/t1.zs>=0.02;
END;

--3 类  8 事项预警率分析
procedure p_C008 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is

--Exe_date varchar2(10);     --被统计的月份
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
  insert into   m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE,InTime)
   select
   getNoBM
  ,'6'
,null
,null
,calcno
,t1.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
                  ,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月,'||t1.orgname||',事项办理总数是'||t1.zs||'件，其中被预警(含提醒、预警、报警)事项数量达到'||nvl(t2.yjs,0)||'件，占比为'||round(nvl(t2.yjs,0)/t1.zs,2)*100||'%。'
                  ,V_MONITOR_SOURCE    ,sysdate
                  from
     ( select org_id,count(distinct internal_no) zs,max(department) orgname from
(select org_id,internal_no,create_date,department
 from m_punish
 union select  org_id,internal_no,create_date ,department
  from m_apply) a
   where   to_char(create_date, 'yyyymm')=Exe_date
      group by org_id) t1
      left join
        (select org_id,count(distinct internal_no) yjs from
(select org_id,internal_no,create_date from
 m_punish union
  select  org_id,internal_no,create_date  from
 m_apply) a
   where  to_char(create_date, 'yyyymm')=Exe_date
   and exists(select * from m_outway where internal_no=a.internal_no)
      group by org_id ) t2
        on t1.org_id=t2.org_id
   where t2.yjs/t1.zs>=0.02;
END;

   ----9  事项办理超期率异常预警
   procedure p_C009 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
bm_cqbjs number;--部门超期办件数
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份

for r in(
select t.org_id,count(distinct t.internal_no) zs,max(t.department) orgname  from
(select r.org_id,r.internal_no ,r.create_date,a.department
from m_punishresult r join m_punish a on a.internal_no=r.internal_no

 union select r.org_id, r.internal_no ,r.create_date,a.department
from m_applyresult r join m_punish a on a.internal_no=r.internal_no) t
   where   to_char(t.create_date, 'yyyymm')=Exe_date
      group by t.org_id  ) --将各部门月办结量放入游标
     loop

     select count(distinct t.internal_no) into  bm_cqbjs from
(select pr.org_id,pr.internal_no ,pr.create_date/*结案时间*/
,a.promise,a.promise_type,a.create_date  apply_date/*办件开始时间*/
from m_punishresult pr join m_punish a on pr.internal_no=a.internal_no
 union select pr.org_id,pr.internal_no ,pr.create_date,a.promise,a.promise_type,a.create_date
from m_applyresult pr join m_apply a on pr.internal_no=a.internal_no ) t
   where   to_char(t.create_date, 'yyyymm')=Exe_date
   and  calc_expired_date(t.apply_date,t.promise,t.promise_type)>=sysdate
   and t.org_id=r.org_id;

   if bm_cqbjs >=0.01
   then
  insert into   m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE,InTime)
   select
  getNoBM
  ,'6'
,null
,null
,calcno
,r.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
                  ,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月,'||r.orgname||',事项办理总数是'||r.zs||'件，其中办结时间超过法定期限的事项达到'||bm_cqbjs||'件，占比为'||round(bm_cqbjs/r.zs,2)*100||'%。'
                ,V_MONITOR_SOURCE  ,sysdate
                  from dual ;
   end if;
   end loop;
   end;

    ----10  事项办理超期率异常报警
   procedure p_C010 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
bm_cqbjs number;--部门超期办件数
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份

for r in(
select t.org_id,count(distinct t.internal_no) zs,max(t.department) orgname  from
(select r.org_id,r.internal_no ,r.create_date,a.department
from m_punishresult r join m_punish a on a.internal_no=r.internal_no

 union select r.org_id, r.internal_no ,r.create_date,a.department
from m_applyresult r join m_punish a on a.internal_no=r.internal_no) t
   where   to_char(t.create_date, 'yyyymm')=Exe_date
      group by t.org_id  ) --将各部门月办结量放入游标
     loop

     select count(distinct t.internal_no) into  bm_cqbjs from
(select pr.org_id,pr.internal_no ,pr.create_date/*结案时间*/
,a.promise,a.promise_type,a.create_date  apply_date/*办件开始时间*/
from m_punishresult pr join m_punish a on pr.internal_no=a.internal_no
 union select pr.org_id,pr.internal_no ,pr.create_date,a.promise,a.promise_type,a.create_date
from m_applyresult pr join m_apply a on pr.internal_no=a.internal_no ) t
   where   to_char(t.create_date, 'yyyymm')=Exe_date
   and  calc_expired_date(t.apply_date,t.promise,t.promise_type)>=sysdate
   and t.org_id=r.org_id;

   if bm_cqbjs >=0.02
   then
  insert into   m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE,InTime)
   select
   getNoBM
  ,'6'
,null
,null
,calcno
,r.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
                  ,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月,'||r.orgname||',本部门事项办理总数是'||r.zs||'件，其中办结时间超过法定期限的事项达到'||bm_cqbjs||'件，占比为'||round(bm_cqbjs/r.zs,2)*100||'%。'
                ,V_MONITOR_SOURCE  ,sysdate
                  from dual ;
   end if;
   end loop;
   end;

       ----11  内容规整率异常（未做）
   procedure p_C011 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
  insert into   m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE,InTime)
   select
   getNoBM
  ,'6'
,null
,null
,calcno
,t1.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
                  ,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月本部门行政处罚类事项办理总数是'||t1.zs||'件，其中不予立案、不予处罚等情况合计达到'||t2.bxs||'件，占比为'||round(t2.bxs/t1.zs,2)*100||'%。'
                ,V_MONITOR_SOURCE  ,sysdate
                  from
     ( select org_id,count(distinct internal_no) zs from m_punishresult
   where  to_char(create_date, 'yyyymm')=Exe_date
      group by org_id) t1 left join
        (select org_id,count(distinct internal_no) bxs from m_punishresult
   where  punish_result like '%不予%'
   and to_char(create_date, 'yyyymm')=Exe_date
   group by org_id) t2  on t1.org_id=t2.org_id
   where t2.bxs/t1.zs>=0.02
   and 1=2 --强制不报警
   ;
   end;

     ----12  内容规整率异常报警（未做）
   procedure p_C012 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
  insert into   m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE,InTime)
   select
   getNoBM
  ,'6'
,null
,null
,calcno
,t1.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
                  ,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月本部门行政处罚类事项办理总数是'||t1.zs||'件，其中不予立案、不予处罚等情况合计达到'||t2.bxs||'件，占比为'||round(t2.bxs/t1.zs,2)*100||'%。'
                ,V_MONITOR_SOURCE  ,sysdate
                  from
     ( select org_id,count(distinct internal_no) zs from m_punishresult
   where   to_char(create_date, 'yyyymm')=Exe_date
      group by org_id) t1 left join
        (select org_id,count(distinct internal_no) bxs from m_punishresult
   where  punish_result like '%不予%'
   and to_char(create_date, 'yyyymm')=Exe_date
   group by org_id) t2  on t1.org_id=t2.org_id
   where t2.bxs/t1.zs>=0.02
   and  1=2 ;--强制不报警
   end;

      /*  许可过程：   1：同意通过，本岗处理完成，同意上一岗位意见，进入后续岗位；
2：否决通过，本岗处理完成，不同意上一岗位意见，进入后续岗位；
3：暂停，由于申请者原因或上报上级机关原因，计时暂停；
4：补正，要求申请者对材料进行补正，此时计时暂停；
5：正在处理；
6：退回，退回到上一岗位；
7：中止，整个办件处理流程中止；

处罚过程：1：正在处理；2：暂停；4：退回；5：通过；6：中止
*/
     ----13  流程规范率异常预警
   procedure p_C013 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
/*case_sum number(5); --部门办件总数*/
case_pro number(5); --部门有问题的办件数
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
for r in(
select org_id,count(distinct t.internal_no) case_sum,max(department) orgname   from
(select  org_id,internal_no,create_date,department from m_apply
                union
            select  org_id,internal_no,create_date,department from m_apply
                 ) t
              where    to_char(t.create_date, 'yyyymm')=Exe_date
                  group by t.org_id   )  --部门办件总数
                 loop
            select count(distinct t.internal_no) into case_pro   from
(select  a.org_id,a.internal_no,p.status,a.create_date from m_apply  a
join m_applyprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id where  p.status in('6','3','7')
                union
            select  a.org_id,a.internal_no,p.status,a.create_date from m_punish  a
            join m_punishprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id where  p.status in('2','4','6')
                 ) t
                 where
              to_char(t.create_date, 'yyyymm')=Exe_date
                and  t.org_id=r.org_id ;

            if   case_pro /r.case_sum>=0.01 --筛选出符合条件的插入数据
            then
      insert into m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime )
select getNoBM
,'6'
,null
,null
,calcno
,r.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月,'||r.orgname||',总办件数是'||r.case_sum||'件，其中有暂停、中止、被一次退回办件数是'||case_pro||'件，占比为'||round(case_pro/r.case_sum,2)*100||'%。'
,V_MONITOR_SOURCE,SYSDATE
          from dual;
   end if;
   end loop;
   end;

        ----14 流程规范率异常报警
   procedure p_C014 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
/*case_sum number(5); --部门办件总数*/
case_pro number(5); --部门有问题的办件数
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
for r in(
select org_id,count(distinct t.internal_no) case_sum,max(department) orgname   from
(select  org_id,internal_no,create_date,department from m_apply
                union
            select  org_id,internal_no,create_date,department from m_apply
                 ) t
              where      to_char(t.create_date, 'yyyymm')=Exe_date
                  group by t.org_id   )  --部门办件总数

            loop
            select count(distinct t.internal_no) into case_pro   from
(select  a.org_id,a.internal_no,p.status,a.create_date,p.node_id,p.no from m_apply  a  join m_applyprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id where p.status='6'
                union
            select  a.org_id,a.internal_no,p.status,a.create_date,p.node_id,p.no from m_punish  a  join m_punishprocess p on a.internal_no=p.internal_no
         and a.item_id=p.item_id where p.status='4'
                 ) t
                 where
                to_char(t.create_date, 'yyyymm')=Exe_date
              and (exists( select b.* from M_ApplyProcess b
                          where b.INTERNAL_NO=t.INTERNAL_NO
                                 and b.status ='6' and b.node_id = t.node_id and b.no!=t.no )
              or exists( select b.* from M_punishProcess b
                          where b.INTERNAL_NO=t.INTERNAL_NO
                                 and b.status ='4' and b.node_id = t.node_id and b.no!=t.no )
                                ) ;--多次退回

            if   case_pro/r.case_sum>=0.01 --筛选出符合条件的插入数据
            then
      insert into m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime )
select getNoBM
,'6'
,null
,null
,calcno
,r.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月,'||r.orgname||',总办件数是'||r.case_sum||'件，其中有两次以上被退回的办件数是'||case_pro||'件，占比为'||round(case_pro/r.case_sum,2)
,V_MONITOR_SOURCE,SYSDATE
          from dual;
   end if;
   end loop;
   end;

     ----15 处罚类事项裁量偏差率异常预警
   procedure p_C015 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
case_pro number(5); --部门有问题的办件数
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
for r in(
select org_id,count(distinct t.internal_no) case_sum   from
m_punishresult t
              where         to_char(t.create_date, 'yyyymm')=Exe_date
   and t.punish_deside not in('3') --   0 ：未立案 1： 做出行政处罚决定；2 ：行政处理；3 ：撤消；4 ：移送司法机关
                  group by t.org_id   )  --部门办件结果总数

            loop
          select count(distinct t.internal_no)  into case_pro   from
m_punishresult t
              where
              t.org_id=r.org_id
              and        to_char(t.create_date, 'yyyymm')=Exe_date
   and t.punish_result !=t.standard;--处罚结果与裁量不一样

            if   case_pro / r.case_sum>=0.01 --筛选出符合条件的插入数据
            and 1=2 --强制不报警
            then
      insert into m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime )
select getNoBM
,'6'
,null
,null
,calcno
,r.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月本部门总办件数是'||r.case_sum||'件，其中处罚金额与裁量标准、处罚金额与执行结果存在偏差的办件数是'||case_pro||'件，占比为'||round(case_pro / r.case_sum,2)*100||'%。'
,V_MONITOR_SOURCE,SYSDATE
          from dual;
   end if;
   end loop;
   end;

      ----16 处罚类事项裁量偏差率异常预警
   procedure p_C016 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
/*case_sum number(5); --部门办件总数*/
case_pro number(5); --部门有问题的办件数
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
for r in(
select org_id,count(distinct t.internal_no) case_sum   from
m_punishresult t
              where          to_char(t.create_date, 'yyyymm')=Exe_date
   and t.punish_result not like '%不予%'
                  group by t.org_id   )  --部门办件总数
            loop
          select count(distinct t.internal_no)  into case_pro   from
m_punishresult t
              where
              t.org_id=r.org_id
              and         to_char(t.create_date, 'yyyymm')=Exe_date
   and t.punish_result !=t.standard;--处罚结果与裁量不一样

            if   case_pro/r.case_sum>=0.03 --筛选出符合条件的插入数据
    and 1=2 --强制不报警
     then
      insert into m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime )
select getNoBM
,'6'
,null
,null
,calcno
,r.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月本部门总办件数是'||r.case_sum||'件，其中处罚金额与裁量标准、处罚金额与执行结果存在偏差的办件数是'||case_pro||'件，占比为'||round(case_pro/r.case_sum,2)*100||'%。'
,V_MONITOR_SOURCE,SYSDATE
          from dual;
   end if;
   end loop;
   end;


    ----17 处罚类事项裁量偏差率异常预警（未做）
   procedure p_C017 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
/*case_sum number(5); --部门办件总数*/
case_pro number(5); --部门有问题的办件数
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
for r in(
select org_id,count(distinct t.internal_no) case_sum   from
m_punishresult t
              where         to_char(t.create_date, 'yyyymm')=Exe_date
   and t.punish_result not like '%不予%'
                  group by t.org_id   )  --部门办件总数

            loop
          select count(distinct t.internal_no)  into case_pro   from
m_punishresult t
              where
              t.org_id=r.org_id
              and        to_char(t.create_date, 'yyyymm')=Exe_date
   and t.punish_result !=t.standard;--处罚结果与裁量不一样

            if   case_pro/r.case_sum>=0.03 --筛选出符合条件的插入数据
              and 1=2 --强制不报警
            then
      insert into m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime )
select getNoBM
,'6'
,null
,null
,calcno
,r.org_id
,'0','0'
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月本部门总办件数是'||r.case_sum||'件，其中处罚金额与裁量标准、处罚金额与执行结果存在偏差的办件数是'||case_pro||'件，占比为'||round(case_pro/r.case_sum,2)*100||'%。'
,V_MONITOR_SOURCE,SYSDATE
          from dual;
   end if;
   end loop;
   end;

    ----18 处罚类事项裁量偏差率异常预警（未做）
   procedure p_C018 (calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
is
--Exe_date varchar2(10);     --被统计的月份
case_pro number(5); --部门有问题的办件数
begin
--Exe_date:=to_char(add_months(SYSDATE, -13), 'yyyymm') ;     --被统计的月份
for r in(
select org_id,count(distinct t.internal_no) case_sum   from
m_punishresult t
              where to_char(t.create_date, 'yyyymm')=Exe_date
   and t.punish_result not like '%不予%'
                  group by t.org_id   )  --部门办件总数
            loop
          select count(distinct t.internal_no)  into case_pro   from
m_punishresult t
              where
              t.org_id=r.org_id
              and         to_char(t.create_date, 'yyyymm')=Exe_date
   and t.punish_result !=t.standard;--处罚结果与裁量不一样

          if   case_pro/r.case_sum>=0.03 --筛选出符合条件的插入数据
            and 1=2 --强制不报警
     then
      insert into m_outway
   (OutWayNo , BJ_TYPE  , BJ_No , Process_No , calc_no ,
                    ORG_ID , INTERNAL_NO , ITEM_ID  , MONITOR_STYLE  ,  MONITOR_TYPE  ,
                    Warning_Code, MONITOR_LOGO   ,  Monitor_Desc,MONITOR_SOURCE, InTime )
select getNoBM
,'6'
,null
,null
,calcno
,r.org_id
,'0','0' --办件编号和权力编号非空要求，所以置0
,V_MONITOR_STYLE,V_MONITOR_TYPE,
                  V_Warning_Code ,V_MONITOR_LOGO
,substr(Exe_date,1,4)||'年'||substr(Exe_date,5,2)||'月本部门总办件数是'||r.case_sum||'件，其中处罚金额与裁量标准、处罚金额与执行结果存在偏差的办件数是'||case_pro||'件，占比为'||round(case_pro/r.case_sum,2)*100||'%。'
,V_MONITOR_SOURCE,SYSDATE
          from dual;
   end if;
   end loop;
   end;

     --- 20 工 作日后对 提醒和 预警的异常自动摘牌
  procedure relieve_warning
  is
  begin
    update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='20工作日后对提醒和预警的异常信息系统自动摘牌'
    where sysdate>=calc_expired_date(a.intime,20,'1')  and a.OutWayState='1' and a.monitor_source in('A','C')--只针对部门和定量分析预警
    and a.monitor_style in('1','3');--只针对提醒和预警的异常
   
    --根据督办信息对异常做摘牌
    update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='针对该异常有督办，系统自动摘牌'
    where  a.OutWayState='1' and a.outwayno in (select distinct t.outwayid from m_supervisebasic t);
    --未超期办结时，对超期预警做摘牌
     update M_OutWay a set a.OutWayState='0', a.OUTTIME=sysdate,a.OUTPERSON='SYSTEM',a.OUTREASON='该办件已办结，对该超期预警摘牌'
    where  a.OutWayState='1' and a.warning_code='A003' and (a.bj_no in 
    (select t.no from m_apply t left join m_applyresult s on t.internal_no=s.internal_no and t.item_id=s.item_id where calc_expired_date(t.create_date,t.promise,t.promise_type)>s.finish_time)
    or a.bj_no in (select t.no from m_punish t left join m_punishresult s on t.internal_no=s.internal_no and t.item_id=s.item_id where calc_expired_date(t.create_date,t.promise,t.promise_type)>s.finish_date));
     commit;
  end relieve_warning;

   --计算工作日函数（A 工作日放假）
   function calc_expired_date(beginDate in date, promise in number, promiseType in varchar2)
     return date
   is
     expiredDate date;
   begin
     expiredDate := beginDate;
     CASE promiseType
        WHEN '0' THEN expiredDate := beginDate + promise;
    WHEN '1' THEN expiredDate := WORK_DAY_OPT.calc_next_work_date(beginDate, promise );
        WHEN '2' THEN expiredDate := add_months(beginDate,promise);
        WHEN '3' THEN expiredDate := add_months(beginDate,promise*12);
     END CASE;

     return expiredDate;
   end calc_expired_date;

   --调用存储过程拼 sql
   procedure p_call is
  v_sql varchar2(1000);
  calcNo number;
begin
  calcNo:=999;
for r in (   select * from m_outway_warnpoint  where wp_no   like'B%'  order by wp_no        )loop
v_sql:='call '||r.wp_oracle||'('||calcNo||','||r.wp_level_no||','||r.wp_type_no||','''||r.wp_no||''','''||r.wp_desc||''','''||r.wp_source||''')';
dbms_output.put_line(v_sql);
execute IMMEDIATE  v_sql;
commit;
end loop;
end ;
/*获取m_outway的主键OutWayNo*/
  function getNoBM 
     return varchar2 
   is 
    bmno varchar2(4000);
   begin 
    select t.datavalue||lpad(S_Out_Way_No.Nextval,10,0) into bmno from f_datadictionary t where t.catalogcode='DBBM' and t.datacode='DBBM';
   return bmno;
  end getNoBM;



/*获取本级部门*/
  function getBM 
     return varchar2 
   is 
    bmno varchar2(4000);
   begin 
    select t.datavalue into bmno from f_datadictionary t where t.catalogcode='DBBM' and t.datacode='DBBM';
   return bmno;
  end getBM;

end alert_warning_new;

/

--3,增加表6张：INF_SUPINFO INF_SUPBACK INF_SUPINFO_RESULT    MONITOR_SUPERVISE MONITOR_SUPERVISE_REPLY MONITOR_SUPERVISE_RESULT

create table INF_SUPINFO
(
  NO                   VARCHAR2(50) not null,
  SUPERVISE_TYPE       VARCHAR2(1) not null,
  INTERNAL_NO          VARCHAR2(100),
  ITEM_ID              VARCHAR2(100),
  ORG_ID               VARCHAR2(10) not null,
  SORTNO               VARCHAR2(100) not null,
  SUPERVISEOPTION      VARCHAR2(200),
  OPERATORNAME         VARCHAR2(100),
  SUPERDATE            DATE not null,
  ATTACHMENT           CLOB,
  UPDATE_DATE          DATE,
  SYNC_DATE            DATE,
  SYNC_SIGN            VARCHAR2(1),
  SYNC_ERROR_DESC      VARCHAR2(1000),
  SYNC_DATE_SHOW       DATE,
  SYNC_SIGN_SHOW       VARCHAR2(1),
  SYNC_ERROR_DESC_SHOW VARCHAR2(1000)
);
-- Add comments to the columns 
comment on column INF_SUPINFO.NO
  is '流水号 主键，全局唯一，以部门编号为开头，部门编码（10位）+流水号0000000001';
comment on column INF_SUPINFO.SUPERVISE_TYPE
  is '督办类型 1：行政权力办件督办
2：行政处罚办件督办
3：投诉督办
4：部门督办
5：行政权力办件告警督办
6：行政处罚办件告警督办
9：其他督办
';
comment on column INF_SUPINFO.INTERNAL_NO
  is '部门内部办件编号 应保证唯一，督办类型为1、2、5、6时必填';
comment on column INF_SUPINFO.ITEM_ID
  is '权力编码 行政权力事项编码，
督办类型为1、5时必填
';
comment on column INF_SUPINFO.ORG_ID
  is '部门编码 业务所在部门编码';
comment on column INF_SUPINFO.SORTNO
  is '序号';
comment on column INF_SUPINFO.SUPERVISEOPTION
  is '督办建议';
comment on column INF_SUPINFO.OPERATORNAME
  is '发起督办人员';
comment on column INF_SUPINFO.SUPERDATE
  is '发起督办时间';
comment on column INF_SUPINFO.ATTACHMENT
  is '相关附件 将多个材料信息构成xml';
-- Create/Recreate primary, unique and foreign key constraints 
alter table INF_SUPINFO
  add constraint PK_INF_SUPINFO primary key (NO);
  
  
  -- Create table
create table INF_SUPBACK
(
  NO                 VARCHAR2(50) not null,
  ORG_ID             VARCHAR2(10),
  SUPERVISEBACK      VARCHAR2(200) not null,
  OPERATORNAME       VARCHAR2(100) not null,
  MONITOR_ID         VARCHAR2(50) not null,
  RECEIPTDATE        DATE not null,
  ATTACHMENT         CLOB,
  UPDATE_DATE        DATE,
  SYNC_DATE          DATE,
  SYNC_SIGN          VARCHAR2(1),
  SYNC_ERROR_DESC    VARCHAR2(1000),
  BM_SYNC_DATE       DATE,
  BM_SYNC_SIGN       VARCHAR2(1),
  BM_SYNC_ERROR_DESC VARCHAR2(1000)

);
-- Add comments to the columns 
comment on column INF_SUPBACK.NO
  is '流水号';
comment on column INF_SUPBACK.SUPERVISEBACK
  is '督办反馈信息';
comment on column INF_SUPBACK.OPERATORNAME
  is '反馈人员';
comment on column INF_SUPBACK.MONITOR_ID
  is '反馈人ID';
comment on column INF_SUPBACK.RECEIPTDATE
  is '反馈督办时间';
comment on column INF_SUPBACK.ATTACHMENT
  is '相关附件 督办过程中的附件，将多个材料信息构成xml';
-- Create/Recreate primary, unique and foreign key constraints 
alter table INF_SUPBACK
  add constraint PK_INF_SUPBACK primary key (NO);


-- Create table
create table INF_SUPINFO_RESULT
(
  NO                   VARCHAR2(50) not null,
  ISEXTERNAL           NUMBER(1),
  SUPERVISERESULT      VARCHAR2(200),
  ENDDATE              DATE,
  ENDOPERATORNAME      VARCHAR2(100),
  UPDATE_DATE          DATE,
  SYNC_DATE            DATE,
  SYNC_SIGN            VARCHAR2(1),
  SYNC_ERROR_DESC      VARCHAR2(1000),
  SYNC_DATE_SHOW       DATE,
  SYNC_SIGN_SHOW       VARCHAR2(1),
  SYNC_ERROR_DESC_SHOW VARCHAR2(1000)
);
-- Add comments to the columns 
comment on column INF_SUPINFO_RESULT.NO
  is '流水号';
comment on column INF_SUPINFO_RESULT.ISEXTERNAL
  is '有无客观原因 0：无
1：有
';
comment on column INF_SUPINFO_RESULT.SUPERVISERESULT
  is '督办结论';
comment on column INF_SUPINFO_RESULT.ENDDATE
  is '结束督办时间';
comment on column INF_SUPINFO_RESULT.ENDOPERATORNAME
  is '督办结论办理人';
-- Create/Recreate primary, unique and foreign key constraints 
alter table INF_SUPINFO_RESULT
  add constraint PK_INF_SUPINFO_RESULT primary key (NO);


-- Create table
create table MONITOR_SUPERVISE
(
  NO                   VARCHAR2(50) not null,
  BJ_NO                VARCHAR2(50) not null,
  BJ_TYPE              VARCHAR2(1) not null,
  ASSOCIATION          VARCHAR2(50),
  SUPERVISE_ORG_ID     VARCHAR2(10) not null,
  SUPERVISE_PERSON     VARCHAR2(100) not null,
  SUPERVISE_ID         VARCHAR2(50) not null,
  MONITOR_ORG_ID       VARCHAR2(50) not null,
  MONITOR_NAME         VARCHAR2(100) not null,
  SUPERVISE_DATE       DATE not null,
  SUPERVISE_OPINION    VARCHAR2(4000) not null,
  ATTACHMENT           CLOB,
  SUPERVISE_REPLY_DATE DATE not null,
  UPDATE_DATE          DATE,
  SYNC_DATE            DATE,
  SYNC_SIGN            VARCHAR2(1),
  SYNC_ERROR_DESC      VARCHAR2(1000),
  SYNC_DATE_SHOW       DATE,
  SYNC_SIGN_SHOW       VARCHAR2(1),
  SYNC_ERROR_DESC_SHOW VARCHAR2(1000)
);
-- Add comments to the columns 
comment on column MONITOR_SUPERVISE.NO
  is '流水号 主键，全局唯一，以各地、各部门编号起始，部门编码（10位）+流水号0000000001';
comment on column MONITOR_SUPERVISE.BJ_NO
  is '办件流水号 关联行政权力运行信息八张表中的INF_APPLY、INF_PUNISH中的NO';
comment on column MONITOR_SUPERVISE.BJ_TYPE
  is '办件类型 1：非处罚类办件
2：处罚类办件
';
comment on column MONITOR_SUPERVISE.ASSOCIATION
  is '异常办件关联号 关联异常记录信息表的主键';
comment on column MONITOR_SUPERVISE.SUPERVISE_ORG_ID
  is '督办发起部门编码 发起督办件的部门编码，采用全省统一编码';
comment on column MONITOR_SUPERVISE.SUPERVISE_PERSON
  is '督办发起人姓名';
comment on column MONITOR_SUPERVISE.SUPERVISE_ID
  is '督办人ID';
comment on column MONITOR_SUPERVISE.MONITOR_ORG_ID
  is '被督办部门编码';
comment on column MONITOR_SUPERVISE.MONITOR_NAME
  is '被督办部门名称';
comment on column MONITOR_SUPERVISE.SUPERVISE_DATE
  is '发出督办时间';
comment on column MONITOR_SUPERVISE.SUPERVISE_OPINION
  is '督办意见';
comment on column MONITOR_SUPERVISE.ATTACHMENT
  is '相关附件';
comment on column MONITOR_SUPERVISE.SUPERVISE_REPLY_DATE
  is '督办反馈截止时间 该督办件要求的办结时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table MONITOR_SUPERVISE
  add constraint PK_MONITOR_SUPERVISE primary key (NO);

  -- Create table
create table MONITOR_SUPERVISE_REPLY
(
  NO                   VARCHAR2(50) not null,
  MONITOR_NO           VARCHAR2(50) not null,
  MONITOR_PERSON       VARCHAR2(50) not null,
  MONITOR_ID           VARCHAR2(50) not null,
  REPLY_DATE           DATE not null,
  REPLY_OPINION        VARCHAR2(4000) not null,
  ATTACHMENT           CLOB,
  UPDATE_DATE          DATE,
  SYNC_DATE            DATE,
  SYNC_SIGN            VARCHAR2(1),
  SYNC_ERROR_DESC      VARCHAR2(1000),
  SYNC_DATE_SHOW       DATE,
  SYNC_SIGN_SHOW       VARCHAR2(1),
  SYNC_ERROR_DESC_SHOW VARCHAR2(1000)
);
-- Add comments to the columns 
comment on column MONITOR_SUPERVISE_REPLY.NO
  is '流水号 主键，全局唯一，以各地、各部门编号起始，部门编码（10位）+流水号0000000001';
comment on column MONITOR_SUPERVISE_REPLY.MONITOR_NO
  is '督办件编号 关联督查督办基本信息表中流水号';
comment on column MONITOR_SUPERVISE_REPLY.MONITOR_PERSON
  is '反馈人姓名';
comment on column MONITOR_SUPERVISE_REPLY.MONITOR_ID
  is '反馈人ID';
comment on column MONITOR_SUPERVISE_REPLY.REPLY_DATE
  is '督办反馈处理时间';
comment on column MONITOR_SUPERVISE_REPLY.REPLY_OPINION
  is '反馈意见';
comment on column MONITOR_SUPERVISE_REPLY.ATTACHMENT
  is '相关附件';
-- Create/Recreate primary, unique and foreign key constraints 
alter table MONITOR_SUPERVISE_REPLY
  add constraint PK_MONITOR_SUPERVISE_REPLY primary key (NO);

-- Create table
create table MONITOR_SUPERVISE_RESULT
(
  NO                   VARCHAR2(50) not null,
  MONITOR_NO           VARCHAR2(50) not null,
  END_DATE             DATE not null,
  CONFIRM              VARCHAR2(1) not null,
  END_OPINION          VARCHAR2(4000),
  UPDATE_DATE          DATE,
  SYNC_DATE            DATE,
  SYNC_SIGN            VARCHAR2(1),
  SYNC_ERROR_DESC      VARCHAR2(1000),
  SYNC_DATE_SHOW       DATE,
  SYNC_SIGN_SHOW       VARCHAR2(1),
  SYNC_ERROR_DESC_SHOW VARCHAR2(1000)
);
-- Add comments to the columns 
comment on column MONITOR_SUPERVISE_RESULT.NO
  is '流水号 主键，全局唯一，以各地、各部门编号起始，部门编码（10位）+流水号0000000001';
comment on column MONITOR_SUPERVISE_RESULT.MONITOR_NO
  is '督办件编号 关联督查督办基本信息表中流水号';
comment on column MONITOR_SUPERVISE_RESULT.END_DATE
  is '办结时间';
comment on column MONITOR_SUPERVISE_RESULT.CONFIRM
  is '反馈是否属实';
comment on column MONITOR_SUPERVISE_RESULT.END_OPINION
  is '办结意见';
-- Create/Recreate primary, unique and foreign key constraints 
alter table MONITOR_SUPERVISE_RESULT
  add constraint PK_MONITOR_SUPERVISE_RESULT primary key (NO);

--4，m_supervisebasic增加6个存储过程抽取数据标识字段；
--m_supervisereply增加6个存储过程抽取数据标识字段；
--m_superviseresult增加6个存储过程抽取数据标识字段；

alter table m_supervisebasic 
	add(sync_date_info date,sync_sign_info varchar2(1),sync_error_desc_info varchar2(1000),sync_date_monitor date,sync_sign_monitor varchar2(1),sync_error_desc_monitor varchar2(1000));
alter table m_supervisereply 
	add(sync_date_info date,sync_sign_info varchar2(1),sync_error_desc_info varchar2(1000),sync_date_monitor date,sync_sign_monitor varchar2(1),sync_error_desc_monitor varchar2(1000));
alter table m_superviseresult 
	add(sync_date_info date,sync_sign_info varchar2(1),sync_error_desc_info varchar2(1000),sync_date_monitor date,sync_sign_monitor varchar2(1),sync_error_desc_monitor varchar2(1000));

--5,增加包package inf_sup_to_m_sup	
create or replace package inf_sup_to_m_sup is

  -- Author  : czp
  -- Created : 2015-3-3
  -- Purpose : 督办基本信息表m_supervise3张和接口表inf_sup3张之间互相转换



  -- 督办基本信息表m_supervise3张向接口表inf_sup3张转换
  procedure data_change1;
  -- 接口表inf_sup3张向督办基本信息表m_supervise3张转换
  procedure data_change2;
  -- 供job和系统调用
  procedure auto_excute;
   /*把blob类型的附件转为clob类型特定xml的附件信息*/ 
 function att_blobtoclob(id in varchar2,filename in varchar2,content in blob)  return clob;
   /*blob转为clob*/ 
  FUNCTION BLOBTOBASE64 (b in blob) return clob;
    /*获取督办的主键流水号*/
  function getNo return varchar2;
      /*获取督办的部门*/
  function getDBBM return varchar2;
  
  /*根据clob类型的xml获取附件的名称*/
  function getattname(att in clob) return varchar2;
   /*根据clob类型的xml获取附件的内容并保存进blob*/
  function getattcontent(att in clob) return blob;
  /*clob转为blob*/
   FUNCTION C2B (b IN CLOB default empty_clob()) RETURN BLOB;
end inf_sup_to_m_sup;
/
create or replace package body inf_sup_to_m_sup is

  -- 督办基本信息表m_supervise3张向接口表inf_sup3张转换
 procedure data_change1 is
    v_errorerrm varchar2(1000);
 begin
  --m_supervisebasic向inf_supinfo抽取数据
   for r in (select a.supervise_no
               from m_supervisebasic a
              where a.sync_sign_info is null and (a.monitor_source='B' or a.monitor_source='C')) loop
     begin
       insert into inf_supinfo
         (NO,
          SUPERVISE_TYPE,
          INTERNAL_NO,
          ITEM_ID,
          ORG_ID,
          SORTNO,
          SUPERVISEOPTION,
          OPERATORNAME,
          SUPERDATE,
          attachment)
         select t.supervise_no,t.bj_type,t.bj_no,s.item_id,t.org_id,0,t.supervise_option,t.operator_name,t.supervise_date,att_blobtoclob(t.supervise_no,t.attachmentname,t.attachment)
           from m_supervisebasic t left join m_apply s on t.bj_no=s.no
          where t.supervise_no = r.supervise_no;
       update m_supervisebasic t
          set t.sync_sign_info = '1', t.sync_date_info = sysdate
        where t.supervise_no = r.supervise_no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update m_supervisebasic t
            set t.sync_sign_info       = '2',
                t.sync_date_info       = sysdate,
                t.sync_error_desc_info = v_errorerrm
          where t.supervise_no = r.supervise_no;
     end;
     commit;
   end loop;
   
   
     --m_supervisereply向inf_supback抽取数据
   for r in (select a.processno
               from m_supervisereply a left join m_supervisebasic b on a.supervise_no=b.supervise_no
              where a.sync_sign_info is null and (b.monitor_source='B' or b.monitor_source='C')) loop
     begin
       insert into inf_supback
         (  NO                 ,
  SUPERVISEBACK      ,
  OPERATORNAME       ,
  MONITOR_ID         ,
  RECEIPTDATE        ,
  ATTACHMENT         )
         select t.supervise_no,t.operator_opinion,t.operator_name,t.operator_id,t.process_date,t.attachment
           from m_supervisereply t 
          where t.processno = r.processno;
       update m_supervisereply t
          set t.sync_sign_info = '1', t.sync_date_info = sysdate
        where t.processno = r.processno;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update m_supervisereply t
            set t.sync_sign_info       = '2',
                t.sync_date_info       = sysdate,
                t.sync_error_desc_info = v_errorerrm
          where t.processno = r.processno;
     end;
     commit;
   end loop;
   
   
     --m_superviseresult向inf_supinfo_result抽取数据
   for r in (select a.no
               from m_superviseresult a  left join m_supervisebasic b on a.supervise_no=b.supervise_no
              where a.sync_sign_info is null and (b.monitor_source='B' or b.monitor_source='C')) loop
     begin
       insert into inf_supinfo_result
         ( NO              ,
  ISEXTERNAL      ,
  SUPERVISERESULT ,
  ENDDATE         ,
  ENDOPERATORNAME )
         select t.supervise_no,t.is_external,t.supervise_result,t.end_date,s.username
           from m_superviseresult t left join f_userinfo s on t.endoperatorid=s.usercode
          where t.no = r.no;
       update m_superviseresult t
          set t.sync_sign_info = '1', t.sync_date_info = sysdate
        where t.no = r.no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update m_superviseresult t
            set t.sync_sign_info       = '2',
                t.sync_date_info       = sysdate,
                t.sync_error_desc_info = v_errorerrm
          where t.no = r.no;
     end;
     commit;
   end loop;
 
 end data_change1;

-- 接口表inf_sup3张向督办基本信息表m_supervise3张转换
 procedure data_change2 is
   v_errorerrm varchar2(1000);
 begin
  --inf_supinfo向m_supervisebasic抽取数据
   for r in (select a.no
               from inf_supinfo a
              where a.sync_sign_show is null and a.no not like getDBBM||'%') loop
     begin
       insert into m_supervisebasic
         (supervise_no,
          bj_type ,
         bj_no ,
         org_id ,
        supervise_option  ,
        operator_name  ,
        supervise_date  ,
        createdate,
        monitor_source,
        attachmentname ,
         attachment)
         select t. NO,t.SUPERVISE_TYPE,t.INTERNAL_NO,t.ORG_ID,t.SUPERVISEOPTION,t.OPERATORNAME,t.SUPERDATE,'B',sysdate,getattname(t.attachment),getattcontent(t.attachment)
           from inf_supinfo t 
          where t.no = r.no;
       update inf_supinfo t
          set t.sync_sign_show = '1', t.sync_date_show = sysdate
        where t.no = r.no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update inf_supinfo t
            set t.sync_sign_show       = '2',
                t.sync_date_show       = sysdate,
                t.sync_error_desc_show = v_errorerrm
          where t.no = r.no;
     end;
     commit;
   end loop;
   
   
     --inf_supback向m_supervisereply抽取数据
   for r in (select a.no
               from inf_supback a
              where a.bm_sync_sign is null and  a.no not like getDBBM||'%') loop
     begin
       insert into m_supervisereply
         (processno,
          supervise_no                  ,
 operator_opinion       ,
 operator_name        ,
 operator_id          ,
 process_date         ,
 process_name,
  ATTACHMENT         )
         select t.no,t.no,t.SUPERVISEBACK,t.OPERATORNAME,t.MONITOR_ID,t.RECEIPTDATE,'督办反馈',t.attachment
           from inf_supback t 
          where t.no = r.no;
       update inf_supback t
          set t.bm_sync_sign= '1', t.bm_sync_date = sysdate
        where t.no = r.no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update inf_supback t
            set t.bm_sync_sign       = '2',
                t.bm_sync_date       = sysdate,
                t.bm_sync_error_desc = v_errorerrm
          where t.no = r.no;
     end;
     commit;
   end loop;
   
   
     --inf_supinfo_result向m_superviseresult抽取数据
   for r in (select a.no
               from inf_supinfo_result a
              where a.sync_sign_show is null and a.no not like getDBBM||'%' ) loop
     begin
       insert into m_superviseresult
         ( no,
         supervise_no              ,
   is_external       ,
 supervise_result   ,
  end_date          ,
 endoperatorid  )
         select t.no,t.no,t.ISEXTERNAL,t.SUPERVISERESULT,t.ENDDATE,t.ENDOPERATORNAME
           from inf_supinfo_result t 
          where t.no = r.no;
       update inf_supinfo_result t
          set t.sync_sign_show = '1', t.sync_date_show = sysdate
        where t.no = r.no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update inf_supinfo_result t
            set t.sync_sign_show       = '2',
                t.sync_date_show       = sysdate,
                t.sync_error_desc_show = v_errorerrm
          where t.no = r.no;
     end;
     commit;
   end loop;

 end data_change2;

  -- 供job和系统调用
 procedure auto_excute is
   begin
    data_change1;
    data_change2;

 end auto_excute;
   /*把blob类型的附件转为clob类型特定xml的附件信息*/ 
 function att_blobtoclob(id in varchar2,filename in varchar2, content in blob) return clob is
   v_att         clob;
   v_Table_Name  varchar2(200);
   v_File_Name   varchar2(200);
   v_File_Base64 clob;
   v_apply_form  blob;
 begin
   v_Table_Name := '附件';
   v_File_Name  := filename;
   v_apply_form := content;
   if dbms_lob.compare(v_apply_form, empty_blob()) > 0 then
     v_File_Base64 := blobtobase64(v_apply_form);
     else
       return null;
   end if;
   v_att := '<?XML VERSION="1.0" ENCODING="GBK"?><DOCUMENTDATA><DOCUMENT><DOCUMENT_ID>'
   ||id||'</DOCUMENT_ID><DOCUMENT_NAME>'||v_Table_Name||'</DOCUMENT_NAME><FILE_NAME>'
   ||v_File_Name||'</FILE_NAME><FILE_CONTENT>CDATA['||v_File_Base64||']</FILE_CONTENT></DOCUMENT></DOCUMENTDATA>'
;
            --v_att:=v_File_Base64;
    return v_att;
 
 end att_blobtoclob;
  /*blob转为clob*/ 
  FUNCTION BLOBTOBASE64 (b in blob) return clob
is
  sizeB integer := 4096;
  buffer raw(4096);
  offset integer default 1;
result clob;
begin
  dbms_lob.createtemporary(result, FALSE, dbms_lob.call);
  loop
    begin
       dbms_lob.read(b, sizeB, offset, buffer);
   exception
     when no_data_found then
     exit;
  end;
 offset := offset + sizeB;
 dbms_lob.append(result, to_clob(utl_raw.cast_to_varchar2(utl_encode.base64_encode(buffer))));
 end loop;
 return result;
end;

  /*获取督办的主键流水号*/
  function getNo 
     return varchar2 
   is 
    no varchar2(4000);
   begin 
    select t.datavalue||lpad(S_SUPERVISERESULTNO.Nextval,10,0) into no from f_datadictionary t where t.catalogcode='DBBM' and t.datacode='DBBM';
   return no;
  end getNo;
  
    /*获取督办的部门*/
  function getDBBM
     return varchar2 
   is 
    dbbm varchar2(4000);
   begin 
    select t.datavalue into dbbm from f_datadictionary t where t.catalogcode='DBBM' and t.datacode='DBBM';
   return dbbm;
  end getDBBM;
  
  /*根据clob类型的xml获取附件的名称*/
  function getattname(att in clob) return varchar2
    is
    attname varchar2(1000);
    startnum  number;
    endnum  number;
    begin
      if att is null then 
        return null;
        else
          startnum:=instr(att,'<FILE_NAME>',0);
          endnum:=instr(att,'</FILE_NAME>',0);
          attname:=substr(att,startnum+11,endnum-startnum-11);
          return attname;
      end if;
    end getattname;
   /*根据clob类型的xml获取附件的内容并保存进blob*/
  function getattcontent(att in clob) return blob is
    attcontent blob;
     startnum  number;
    endnum  number;
    tempclob  clob;
    begin
      if att is null then 
        return null;
        else
          startnum:=instr(att,'<FILE_CONTENT>CDATA[',0);
          endnum:=instr(att,']</FILE_CONTENT>',0);
          tempclob:=substr(att,startnum+20,endnum-startnum-20);
          attcontent:=C2B(tempclob);
          return attcontent;
      end if;
    end getattcontent;  
    
    /*clob转为blob*/
  FUNCTION C2B (b IN CLOB default empty_clob())
   RETURN BLOB
-- typecasts BLOB to CLOB (binary conversion)
   IS
     res            BLOB;
     b_len          number  := dbms_lob.getlength(b) ;
     dest_offset1   NUMBER  := 1;
     src_offset1    NUMBER  := 1;
     amount_c       INTEGER := DBMS_LOB.lobmaxsize;
     blob_csid      NUMBER  := DBMS_LOB.default_csid;
     lang_ctx       INTEGER := DBMS_LOB.default_lang_ctx;
     warning        INTEGER;
   BEGIN

       if  b_len  > 0  then
       DBMS_LOB.createtemporary (res, TRUE);
       DBMS_LOB.OPEN (res, DBMS_LOB.lob_readwrite);
       DBMS_LOB.convertToBlob (res,
                               b,
                               amount_c,
                               dest_offset1,
                               src_offset1,
                               blob_csid,
                               lang_ctx,
                               warning
                              );
     else
       select   empty_blob()  into  res  from  dual ;
      end if ;
     RETURN res;                                             -- res is OPEN here
   END C2B;

  
 begin
   null;
end inf_sup_to_m_sup;
/

--6,增加包package monitor_sup_to_m_sup
	
create or replace package monitor_sup_to_m_sup is

  -- Author  : czp
  -- Created : 2015-3-3
  -- Purpose : 督办基本信息表m_supervise3张和接口表monitor_sup3张之间互相转换



  -- 督办基本信息表m_supervise3张向接口表monitor_sup3张转换
  procedure data_change1;
  -- 接口表monitor_sup3张向督办基本信息表m_supervise3张转换
  procedure data_change2;
  -- 供job和系统调用
  procedure auto_excute;

 /*把blob类型的附件转为clob类型特定xml的附件信息*/ 
 function att_blobtoclob(id in varchar2,filename in varchar2,content in blob)  return clob;
   /*blob转为clob*/ 
  FUNCTION BLOBTOBASE64 (b in blob) return clob;
    /*获取督办的主键流水号*/
  function getNo return varchar2;
      /*获取督办的部门*/
  function getDBBM return varchar2;
  
  /*根据clob类型的xml获取附件的名称*/
  function getattname(att in clob) return varchar2;
   /*根据clob类型的xml获取附件的内容并保存进blob*/
  function getattcontent(att in clob) return blob;
  /*clob转为blob*/
   FUNCTION C2B (b IN CLOB default empty_clob()) RETURN BLOB;
end monitor_sup_to_m_sup;
/

create or replace package body monitor_sup_to_m_sup is

-- 督办基本信息表m_supervise3张向接口表monitor_sup3张转换
procedure data_change1 is
    v_errorerrm varchar2(1000);
 begin
  --m_supervisebasic向monitor_supervise抽取数据
   for r in (select a.supervise_no
               from m_supervisebasic a
              where a.sync_sign_monitor is null and (a.monitor_source='A' or a.monitor_source is null)) loop
     begin
       insert into monitor_supervise
         (  NO                   ,
  BJ_NO                ,
  BJ_TYPE              ,
  ASSOCIATION          ,
  SUPERVISE_ORG_ID     ,
  SUPERVISE_PERSON     ,
  SUPERVISE_ID         ,
  MONITOR_ORG_ID       ,
  MONITOR_NAME         ,
  SUPERVISE_DATE       ,
  SUPERVISE_OPINION    ,
  ATTACHMENT           ,
  SUPERVISE_REPLY_DATE )
         select t.supervise_no,t.bj_no,t.bj_type,t.outwayid,t.org_id,t.operator_name,t.operator_id,t.monitor_org_id,t.monitor_org_name,t.supervise_date,t.supervise_option,att_blobtoclob(t.supervise_no,t.attachmentname,t.attachment),t.promise_date 
           from m_supervisebasic t 
          where t.supervise_no = r.supervise_no;
       update m_supervisebasic t
          set t.sync_sign_monitor = '1', t.sync_date_monitor = sysdate
        where t.supervise_no = r.supervise_no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update m_supervisebasic t
            set t.sync_sign_monitor       = '2',
                t.sync_date_monitor       = sysdate,
                t.sync_error_desc_monitor = v_errorerrm
          where t.supervise_no = r.supervise_no;
     end;
     commit;
   end loop;
   
   
     --m_supervisereply向monitor_supervise_reply抽取数据
   for r in (select a.processno
               from m_supervisereply a left join m_supervisebasic b on a.supervise_no=b.supervise_no 
              where a.sync_sign_monitor is null and (b.monitor_source='A' or b.monitor_source is null) ) loop
     begin
       insert into monitor_supervise_reply
         (   NO              ,
  MONITOR_NO      ,
  MONITOR_PERSON  ,
  MONITOR_ID      ,
  REPLY_DATE      ,
  REPLY_OPINION   ,
  ATTACHMENT         )
         select getNo,t.supervise_no,t.operator_name,t.operator_id,t.process_date,t.operator_opinion,t.attachment
           from m_supervisereply t 
          where t.processno = r.processno;
       update m_supervisereply t
          set t.sync_sign_monitor = '1', t.sync_date_monitor = sysdate
        where t.processno = r.processno;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update m_supervisereply t
            set t.sync_sign_monitor       = '2',
                t.sync_date_monitor       = sysdate,
                t.sync_error_desc_monitor = v_errorerrm
          where t.processno = r.processno;
     end;
     commit;
   end loop;
   
   
     --m_superviseresult向monitor_supervise_result抽取数据
   for r in (select a.no
               from m_superviseresult a left join m_supervisebasic b on a.supervise_no=b.supervise_no 
              where a.sync_sign_monitor is null and (b.monitor_source='A' or b.monitor_source is null)) loop
     begin
       insert into monitor_supervise_result
         (  NO              ,
  MONITOR_NO      ,
  END_DATE        ,
  CONFIRM         ,
  END_OPINION     )
         select getNo,t.supervise_no,t.end_date,nvl(t.confirm,1),t.supervise_result 
           from m_superviseresult t 
          where t.no = r.no;
       update m_superviseresult t
          set t.sync_sign_monitor = '1', t.sync_date_monitor = sysdate
        where t.no = r.no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update m_superviseresult t
            set t.sync_sign_monitor       = '2',
                t.sync_date_monitor       = sysdate,
                t.sync_error_desc_monitor = v_errorerrm
          where t.no = r.no;
     end;
     commit;
   end loop;
 
 end data_change1;

-- 接口表monitor_sup3张向督办基本信息表m_supervise3张转换
 procedure data_change2 is
   v_errorerrm varchar2(1000);
 begin
  --monitor_supervise向m_supervisebasic抽取数据
   for r in (select a.no
               from monitor_supervise a
              where a.sync_sign_show is null and a.no not like getDBBM||'%') loop
     begin
       insert into m_supervisebasic
         (supervise_no, 
          bj_no ,
          bj_type ,
       outwayid,
         org_id ,
        operator_name  ,
        operator_id,
        monitor_org_id,
        monitor_org_name,
        supervise_date  ,
        supervise_option  ,
        createdate,
        monitor_source,
        promise_date,
        attachmentname ,
         attachment)
         select  t. NO,t. BJ_NO, t. BJ_TYPE,t. ASSOCIATION,t. SUPERVISE_ORG_ID ,
 t. SUPERVISE_PERSON,t. SUPERVISE_ID,
 t. MONITOR_ORG_ID ,t. MONITOR_NAME,
 t. SUPERVISE_DATE,t. SUPERVISE_OPINION,
 sysdate,'A',t. SUPERVISE_REPLY_DATE,getattname(t.attachment),getattcontent(t.attachment)
           from monitor_supervise t 
          where t.no = r.no;
       update monitor_supervise t
          set t.sync_sign_show = '1', t.sync_date_show = sysdate
        where t.no = r.no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update monitor_supervise t
            set t.sync_sign_show       = '2',
                t.sync_date_show       = sysdate,
                t.sync_error_desc_show = v_errorerrm
          where t.no = r.no;
     end;
     commit;
   end loop;
   
   
     --monitor_supervise_reply向m_supervisereply抽取数据
   for r in (select a.no
               from monitor_supervise_reply a
              where a.sync_sign_show is null and  a.no not like getDBBM||'%') loop
     begin
       insert into m_supervisereply
         (processno,
          supervise_no                  ,
 operator_opinion       ,
 operator_name        ,
 operator_id          ,
 process_date         ,
 process_name,
  ATTACHMENT         )
         select t.no,t.monitor_no,t.reply_opinion,t.monitor_person,t.monitor_id,t.reply_date,'督办反馈',t.attachment
           from monitor_supervise_reply t 
          where t.no = r.no;
       update monitor_supervise_reply t
          set t.sync_sign_show= '1', t.sync_date_show = sysdate
        where t.no = r.no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update monitor_supervise_reply t
            set t.sync_sign_show       = '2',
                t.sync_date_show       = sysdate,
                t.sync_error_desc_show = v_errorerrm
          where t.no = r.no;
     end;
     commit;
   end loop;
   
   
     --monitor_supervise_result向m_superviseresult抽取数据
   for r in (select a.no
               from monitor_supervise_result a
              where a.sync_sign_show is null and a.no not like getDBBM||'%' ) loop
     begin
       insert into m_superviseresult
         ( no,
         supervise_no              ,
   confirm      ,
 supervise_result   ,
  end_date           )
         select t.no,t.monitor_no,nvl(t.confirm,1),t.end_opinion,t.end_date
           from monitor_supervise_result t 
          where t.no = r.no;
       update monitor_supervise_result t
          set t.sync_sign_show = '1', t.sync_date_show = sysdate
        where t.no = r.no;
     exception
       WHEN OTHERS THEN
         v_errorerrm:=to_char(sqlerrm);
         update monitor_supervise_result t
            set t.sync_sign_show       = '2',
                t.sync_date_show       = sysdate,
                t.sync_error_desc_show = v_errorerrm
          where t.no = r.no;
     end;
     commit;
   end loop;

 end data_change2;

-- 供job和系统调用
 procedure auto_excute is
   begin
    data_change1;
    data_change2;

 end auto_excute;
  /*把blob类型的附件转为clob类型特定xml的附件信息*/ 
 function att_blobtoclob(id in varchar2,filename in varchar2, content in blob) return clob is
   v_att         clob;
   v_Table_Name  varchar2(200);
   v_File_Name   varchar2(200);
   v_File_Base64 clob;
   v_apply_form  blob;
 begin
   v_Table_Name := '附件';
   v_File_Name  := filename;
   v_apply_form := content;
   if dbms_lob.compare(v_apply_form, empty_blob()) > 0 then
     v_File_Base64 := blobtobase64(v_apply_form);
     else
       return null;
   end if;
   v_att := '<?XML VERSION="1.0" ENCODING="GBK"?><DOCUMENTDATA><DOCUMENT><DOCUMENT_ID>'
   ||id||'</DOCUMENT_ID><DOCUMENT_NAME>'||v_Table_Name||'</DOCUMENT_NAME><FILE_NAME>'
   ||v_File_Name||'</FILE_NAME><FILE_CONTENT>CDATA['||v_File_Base64||']</FILE_CONTENT></DOCUMENT></DOCUMENTDATA>'
;
            --v_att:=v_File_Base64;
    return v_att;
 
 end att_blobtoclob;
  /*blob转为clob*/ 
  FUNCTION BLOBTOBASE64 (b in blob) return clob
is
  sizeB integer := 4096;
  buffer raw(4096);
  offset integer default 1;
result clob;
begin
  dbms_lob.createtemporary(result, FALSE, dbms_lob.call);
  loop
    begin
       dbms_lob.read(b, sizeB, offset, buffer);
   exception
     when no_data_found then
     exit;
  end;
 offset := offset + sizeB;
 dbms_lob.append(result, to_clob(utl_raw.cast_to_varchar2(utl_encode.base64_encode(buffer))));
 end loop;
 return result;
end;

  /*获取督办的主键流水号*/
  function getNo 
     return varchar2 
   is 
    no varchar2(4000);
   begin 
    select t.datavalue||lpad(S_SUPERVISERESULTNO.Nextval,10,0) into no from f_datadictionary t where t.catalogcode='DBBM' and t.datacode='DBBM';
   return no;
  end getNo;
  
    /*获取督办的部门*/
  function getDBBM
     return varchar2 
   is 
    dbbm varchar2(4000);
   begin 
    select t.datavalue into dbbm from f_datadictionary t where t.catalogcode='DBBM' and t.datacode='DBBM';
   return dbbm;
  end getDBBM;
  
  /*根据clob类型的xml获取附件的名称*/
  function getattname(att in clob) return varchar2
    is
    attname varchar2(1000);
    startnum  number;
    endnum  number;
    begin
      if att is null then 
        return null;
        else
          startnum:=instr(att,'<FILE_NAME>',0);
          endnum:=instr(att,'</FILE_NAME>',0);
          attname:=substr(att,startnum+11,endnum-startnum-11);
          return attname;
      end if;
    end getattname;
   /*根据clob类型的xml获取附件的内容并保存进blob*/
  function getattcontent(att in clob) return blob is
    attcontent blob;
     startnum  number;
    endnum  number;
    tempclob  clob;
    begin
      if att is null then 
        return null;
        else
          startnum:=instr(att,'<FILE_CONTENT>CDATA[',0);
          endnum:=instr(att,']</FILE_CONTENT>',0);
          tempclob:=substr(att,startnum+20,endnum-startnum-20);
          attcontent:=C2B(tempclob);
          return attcontent;
      end if;
    end getattcontent;  
    
    /*clob转为blob*/
  FUNCTION C2B (b IN CLOB default empty_clob())
   RETURN BLOB
-- typecasts BLOB to CLOB (binary conversion)
   IS
     res            BLOB;
     b_len          number  := dbms_lob.getlength(b) ;
     dest_offset1   NUMBER  := 1;
     src_offset1    NUMBER  := 1;
     amount_c       INTEGER := DBMS_LOB.lobmaxsize;
     blob_csid      NUMBER  := DBMS_LOB.default_csid;
     lang_ctx       INTEGER := DBMS_LOB.default_lang_ctx;
     warning        INTEGER;
   BEGIN

       if  b_len  > 0  then
       DBMS_LOB.createtemporary (res, TRUE);
       DBMS_LOB.OPEN (res, DBMS_LOB.lob_readwrite);
       DBMS_LOB.convertToBlob (res,
                               b,
                               amount_c,
                               dest_offset1,
                               src_offset1,
                               blob_csid,
                               lang_ctx,
                               warning
                              );
     else
       select   empty_blob()  into  res  from  dual ;
      end if ;
     RETURN res;                                             -- res is OPEN here
   END C2B;

  
 begin
   null;
end monitor_sup_to_m_sup;
/

alter table inf_supinfo_result add (org_id varchar2(20));