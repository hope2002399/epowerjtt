create or replace package performance_appraisal is

  -- Author  : CODEFAN
  -- Created : 2013-6-8 9:08:24
  -- Purpose : 绩效考核
  type ref_cursor is ref cursor;
  
   
  -- 对部门进行评估考核  onlyCalcSun 为 true 是仅仅计算总分 deleteOld 为true时 如果已近计算过就重算
  procedure appraisal_dept(unitCode in varchar2,yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0');
  -- 对所有部门进行评估考核
  procedure appraisal_dept_all(yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0');
  -- 对所有部门进行评估考核，优化处理
  procedure appraisal_dept_all2(yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0');
  
  -- 法制监督临时考评
  procedure appraisal_dept_temporary(unitCode in varchar2,beginTime in date, endTime in date,curAppraisal out ref_cursor);


end performance_appraisal;
/
create or replace package body performance_appraisal is

  -- Private type declarations
  procedure auto_appraisal_dept(unitCode in varchar2,nYear in number, nMonth in number)
  is
    dateBegin date;
    dateEnd date;
    nTemp number(12);
  begin
    dateBegin := to_date(to_char(nYear)||'-'||to_char(nMonth),'YYYY-MM');
    dateEnd  := add_months(dateBegin,1);
    /**
    12、申请事项依法不需要取得行政许可的，应当即时告知申请人不受理及原因。  违反一次扣
    0.5分  是  当办件不受理时，没有填写不受理原因的，有一例违反扣0.5分。
    **/
    select count(1) into nTemp
                   from M_ApplyResult r 
                   where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                         r.STATUS='1' and (r.NOTE is null or length(r.NOTE)<10)
                         and r.org_id= unitCode;
                         
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         values( S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
               nMonth,sysdate, 'REFUSE_WITHOUT_RESION','没有告知原因的不受理案件',
                   nTemp, '件');  

                
     insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values( S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'REFUSE_WITHOUT_RESION','没有告知原因的不受理案件', -0.5*nTemp,
               '分','当办件不受理时，没有填写不受理原因的，有一例违反扣0.5分','-0.5*'||to_char(nTemp)  
        );   
    
    /**
    18、行政机关应当对申请人提交的申请材料进行审查。  违反一次扣
    0.5分  是  办件过程是否有“审查内容”，如果没有违反一次扣0.5分
    **/
    select count(1) into nTemp 
               from M_ApplyResult r 
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                     r.STATUS='2' and not exists(select b.* from M_ApplyProcess b 
                                      where b.INTERNAL_NO=r.INTERNAL_NO and b.ITEM_ID=r.ITEM_ID
                                             and b.TACHE_NAME like '%审查内容%') and r.org_id=unitCode;
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         values( S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
               nMonth,sysdate, 'NOCHECK_REQUEST_STUFF','未对申请材料审查的许可案件',nTemp,
               '件');  
               
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values(S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'NOCHECK_REQUEST_STUFF','未对申请材料审查的许可案件', -0.5*nTemp,
               '分','办件过程是否有“审查内容”，如果没有违反一次扣0.5分','-0.5*'||to_char(nTemp)  
         );             
    /**
    21、行政机关对行政许可申请进行审查后，应当按照规定程序作出行政许可决定。  违反一次扣
    0.5分  是  办件结束没有出示许可决定书，有一例扣0.5分。

    22、行政机关依法作出不予行政许可的书面决定的，应当说明理由。  违反一次扣
    0.5分  是  没有对不予许可没有说明原因的办件，有一件扣0.5分。
    **/
    select count(1) into nTemp
               from M_ApplyResult r 
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                     r.STATUS='3' and (r.NOTE is null or length(r.NOTE)<10)
                     and r.org_id=unitCode;
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         values( S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
               nMonth,sysdate, 'PROHIBIT_WITHOUT_RESION','没有告知原因的不许可案件',nTemp,
               '件'); 
                   
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values(S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'PROHIBIT_WITHOUT_RESION','没有告知原因的不许可案件', -0.5*nTemp,
               '分','没有对不予许可没有说明原因的办件，有一件扣0.5分','-0.5*'||to_char(nTemp)  
         );        
    /**
    25、无法定依据不得擅自改变已经生效的行政许可。  违反一次扣
    0.5分  是  针对有行政诉讼败诉的行政许可办件办理，违反一次扣0.5分

    27、行政机关应当在规定期限内核实、处理违法从事行政许可事项活动的投诉、举报。  违反一次扣
    0.5分  是  针对公众投诉，办理人员一个月没有处理，有一例违反的扣0.5分

    28、行政机关对上级机关或监察机关要求答复的行政许可投诉、举报应当在规定期限内报送办理结果。  违反一次扣
    0.5分  是  针对行政投诉，办理人员一个月没有处理结果，有一例违反的扣0.5分

    29、行政机关实施行政许可不当引起行政复议并发生许可结果变更。  发生一次扣
    1分  是  行政复议有撤销、变更或确认违法决定，有一例扣1分

    30、行政机关实施行政许可导致行政诉讼并败诉。  发生一次扣
    1分  是  行政应诉有出现败诉的情况，发生一次扣1分

    32、行政机关应当加强对下级行政机关实施行政许可的监督检查，及时纠正行政许可实施中的违法行为。  违反一次扣
    0.5分  是  当市监察室针对异常发起督办时，有一例扣0.5分

    36、行政机关应在法定期限内作出行政许可决定，超过法定的期限一天作出行政审批决定的，给予黄牌警告。  发生一次扣
    1分  是  当行政机关期限内作出应在法定行政许可决定，超过法定的期限一天作出行政审批决定的，有一例扣1分。
    **/
    select count(1) into nTemp
               from M_ApplyResult r join M_OutWay o on o.BJ_TYPE='1' and  o.INTERNAL_NO=r.INTERNAL_NO and o.ITEM_ID=r.ITEM_ID
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and
                     o.Warning_Code = 'ALARM_EXPIRED' and o.OutWayState='1'
                and r.org_id=unitCode;
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         values( S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
               nMonth,sysdate, 'ALARM_EXPIRED','超期黄牌警告案件',nTemp,
               '件');    
                  
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values(S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'ALARM_EXPIRED','超期黄牌警告案件', -1.0*nTemp,
               '分','当行政机关期限内作出应在法定行政许可决定，超过法定的期限一天作出行政审批决定的，有一例扣1分','-1*'||to_char(nTemp)  
         );     
    /**
    37、行政机关应在法定期限内作出行政许可决定，超过法定的期限两天及以上作出行政审批决定的，给予红牌警告。  发生一次扣
    1.5分  是  当行政机关应在法定期限内作出行政许可决定，超过法定的期限两天及以上作出行政审批，有一例扣1.5分
    **/
    select count(1) into nTemp
               from M_ApplyResult r join M_OutWay o on o.BJ_TYPE='1' and  o.INTERNAL_NO=r.INTERNAL_NO and o.ITEM_ID=r.ITEM_ID
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and
                     o.Warning_Code = 'ALTER_EXPIRED' and o.OutWayState='1' 
                     and r.org_id=unitCode;
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         values( S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
               nMonth,sysdate, 'ALTER_EXPIRED','超期红牌牌警告案件',nTemp,
               '件');       
    
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values(S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'ALTER_EXPIRED','超期红牌牌警告案件', -1.5*nTemp,
               '分','当行政机关应在法定期限内作出行政许可决定，超过法定的期限两天及以上作出行政审批，有一例扣1.5分','-1.5*'||to_char(nTemp)  
         ); 
    /**
    50、满意度调查结果为不满意的。	发生一次扣
    1分	有	网上受理办件出现评价为不满的有一例扣1份
    **/
  end auto_appraisal_dept;
  
  
  procedure appraisal_dept(unitCode in varchar2,yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0')
  is
    nTemp number(8);
    nYear number(4);
    nMonth number(2);
    calculate_num number(12,4);
    record_num number(12,4);
    auditState  M_PaPerformanceResult.AUDIT_RESULT%TYPE;
  begin
    nMonth := extract(month from yearAndMonth);
    nYear := extract(year from yearAndMonth);
    
    select count(1),max(AUDIT_RESULT) into nTemp,auditState 
           from M_PaPerformanceResult a where a.COUNT_YEAR =nYear and a.COUNT_MONTH=nMonth and a.CHECK_TYPE='2' and a.org_id = unitCode;
    if auditState<>'0' then
       return;
    end if;
    
    if onlyCalcSum='0' and nTemp > 0  then
      if not deleteOld='0'  then
        return ;
      end if;
      -- 删除旧数据
      --delete from M_PaPerformanceResult where COUNT_YEAR =nYear and COUNT_MONTH=nMonth;
      delete from M_PaMonthCheckup where COUNT_YEAR =nYear and COUNT_MONTH=nMonth and CHECK_TYPE='2' and org_id = unitCode;
      delete from M_PaMonthStat where COUNT_YEAR =nYear and COUNT_MONTH=nMonth and STAT_TYPE='2' and org_id = unitCode;
    end if;    
  
    
    if onlyCalcSum='0' then
       auto_appraisal_dept(unitCode,nYear, nMonth);
    end if;
    

    select count(1) into nTemp from M_PaPerformanceResult p 
       where p.COUNT_YEAR =nYear and p.COUNT_MONTH=nMonth and p.CHECK_TYPE='2' and p.org_id = unitCode;

    select nvl(sum(c.ITEM_VALUE),0) into calculate_num
      from M_PaMonthCheckup c 
      where c.COUNT_YEAR =nYear and c.COUNT_MONTH=nMonth and c.org_id=unitCode and c.CHECK_TYPE='2';
       
    select nvl(sum(p.PUNISH_SUM),0) into record_num
      from M_PaMonthPunish p 
      where p.COUNT_YEAR =nYear and p.COUNT_MONTH=nMonth and p.org_id=unitCode and p.PUNISH_TYPE='2';
         
     if nTemp=1 then
        update M_PaPerformanceResult 
               set CREATE_DATE = sysdate,calculate_num=calculate_num,record_num = record_num,
                   ALL_NUM =calculate_num +  record_num,
                   ZS_SCORE = 100 + calculate_num +  record_num
        where COUNT_YEAR =nYear and COUNT_MONTH=nMonth and CHECK_TYPE='2' and org_id = unitCode;
     else
       if nTemp>1 then
          delete from M_PaPerformanceResult p 
                 where p.COUNT_YEAR =nYear and p.COUNT_MONTH=nMonth and p.CHECK_TYPE='2' and p.org_id = unitCode;
       end if;
       insert into M_PaPerformanceResult(CHECK_NO,CHECK_TYPE,USER_CODE ,ORG_ID ,COUNT_YEAR,
               COUNT_MONTH,CREATE_DATE , calculate_num ,record_num , ALL_NUM ,
               ZS_SCORE,AUDIT_RESULT)
       values(S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
            nMonth,sysdate,calculate_num ,record_num , calculate_num + record_num  ,
               100+calculate_num+record_num ,'0');           
     end if;

  end appraisal_dept;
  
  -- 计算所有的部门，简单的对所有部门进行迭代。
  procedure appraisal_dept_all(yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0')
  is
  begin
    for r in (select u.unitcode
             from f_unitinfo u --where u.unittype = 'X'  对机构进行过滤
    )loop
       appraisal_dept(r.unitcode,yearAndMonth,deleteOld ,onlyCalcSum); 
    end loop;
  end appraisal_dept_all;
  
  -- 优化处理方式以提高效率
  procedure auto_appraisal(nYear in number, nMonth in number)
  is
    dateBegin date;
    dateEnd date;
  begin
    dateBegin := to_date(to_char(nYear)||'-'||to_char(nMonth),'YYYY-MM');
    dateEnd  := add_months(dateBegin,1);
    /**
    12、申请事项依法不需要取得行政许可的，应当即时告知申请人不受理及原因。  违反一次扣
    0.5分  是  当办件不受理时，没有填写不受理原因的，有一例违反扣0.5分。
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'REFUSE_WITHOUT_RESION','没有告知原因的不受理案件',t.caseCount,
               '件'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r 
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                     r.STATUS='1' and (r.NOTE is null or length(r.NOTE)<10)
               group by r.org_id) t;  
                
     insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'REFUSE_WITHOUT_RESION','没有告知原因的不受理案件', -0.5*p.STAT_VALUE,
               '分','当办件不受理时，没有填写不受理原因的，有一例违反扣0.5分','-0.5*'||to_char(p.STAT_VALUE)  
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'REFUSE_WITHOUT_RESION';   
    
    /**
    18、行政机关应当对申请人提交的申请材料进行审查。  违反一次扣
    0.5分  是  办件过程是否有“审查内容”，如果没有违反一次扣0.5分
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'NOCHECK_REQUEST_STUFF','未对申请材料审查的许可案件',t.caseCount,
               '件'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r 
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                     r.STATUS='2' and not exists(select b.* from M_ApplyProcess b 
                                      where b.INTERNAL_NO=r.INTERNAL_NO and b.ITEM_ID=r.ITEM_ID
                                             and b.TACHE_NAME like '%审查内容%')
               group by r.org_id) t;  
               
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'NOCHECK_REQUEST_STUFF','未对申请材料审查的许可案件', -0.5*p.STAT_VALUE,
               '分','办件过程是否有“审查内容”，如果没有违反一次扣0.5分','-0.5*'||to_char(p.STAT_VALUE)
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'NOCHECK_REQUEST_STUFF';          
    /**
    21、行政机关对行政许可申请进行审查后，应当按照规定程序作出行政许可决定。  违反一次扣
    0.5分  是  办件结束没有出示许可决定书，有一例扣0.5分。

    22、行政机关依法作出不予行政许可的书面决定的，应当说明理由。  违反一次扣
    0.5分  是  没有对不予许可没有说明原因的办件，有一件扣0.5分。
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'PROHIBIT_WITHOUT_RESION','没有告知原因的不许可案件',t.caseCount,
               '件'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r 
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                     r.STATUS='3' and (r.NOTE is null or length(r.NOTE)<10)
               group by r.org_id) t; 
                   
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'PROHIBIT_WITHOUT_RESION','没有告知原因的不许可案件', -0.5*p.STAT_VALUE,
               '分','没有对不予许可没有说明原因的办件，有一件扣0.5分','-0.5*'||to_char(p.STAT_VALUE)
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'PROHIBIT_WITHOUT_RESION';     
    /**
    25、无法定依据不得擅自改变已经生效的行政许可。  违反一次扣
    0.5分  是  针对有行政诉讼败诉的行政许可办件办理，违反一次扣0.5分

    27、行政机关应当在规定期限内核实、处理违法从事行政许可事项活动的投诉、举报。  违反一次扣
    0.5分  是  针对公众投诉，办理人员一个月没有处理，有一例违反的扣0.5分

    28、行政机关对上级机关或监察机关要求答复的行政许可投诉、举报应当在规定期限内报送办理结果。  违反一次扣
    0.5分  是  针对行政投诉，办理人员一个月没有处理结果，有一例违反的扣0.5分

    29、行政机关实施行政许可不当引起行政复议并发生许可结果变更。  发生一次扣
    1分  是  行政复议有撤销、变更或确认违法决定，有一例扣1分

    30、行政机关实施行政许可导致行政诉讼并败诉。  发生一次扣
    1分  是  行政应诉有出现败诉的情况，发生一次扣1分

    32、行政机关应当加强对下级行政机关实施行政许可的监督检查，及时纠正行政许可实施中的违法行为。  违反一次扣
    0.5分  是  当市监察室针对异常发起督办时，有一例扣0.5分

    36、行政机关应在法定期限内作出行政许可决定，超过法定的期限一天作出行政审批决定的，给予黄牌警告。  发生一次扣
    1分  是  当行政机关期限内作出应在法定行政许可决定，超过法定的期限一天作出行政审批决定的，有一例扣1分。
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'ALARM_EXPIRED','超期黄牌警告案件',t.caseCount,
               '件'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r join M_OutWay o on o.BJ_TYPE='1' and  o.INTERNAL_NO=r.INTERNAL_NO and o.ITEM_ID=r.ITEM_ID
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and
                     o.Warning_Code = 'ALARM_EXPIRED' and o.OutWayState='1' 
               group by r.org_id) t;  
                  
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'ALARM_EXPIRED','超期黄牌警告案件', -1.0*p.STAT_VALUE,
               '分','当行政机关期限内作出应在法定行政许可决定，超过法定的期限一天作出行政审批决定的，有一例扣1分','-1*'||to_char(p.STAT_VALUE)
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'ALARM_EXPIRED';    
    /**
    37、行政机关应在法定期限内作出行政许可决定，超过法定的期限两天及以上作出行政审批决定的，给予红牌警告。  发生一次扣
    1.5分  是  当行政机关应在法定期限内作出行政许可决定，超过法定的期限两天及以上作出行政审批，有一例扣1.5分
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'ALTER_EXPIRED','超期红牌牌警告案件',t.caseCount,
               '件'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r join M_OutWay o on o.BJ_TYPE='1' and  o.INTERNAL_NO=r.INTERNAL_NO and o.ITEM_ID=r.ITEM_ID
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and
                     o.Warning_Code = 'ALTER_EXPIRED' and o.OutWayState='1' 
               group by r.org_id) t;         
    
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'ALTER_EXPIRED','超期红牌牌警告案件', -1.5*p.STAT_VALUE,
               '分','当行政机关应在法定期限内作出行政许可决定，超过法定的期限两天及以上作出行政审批，有一例扣1.5分','-1.5*'||to_char(p.STAT_VALUE)
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'ALTER_EXPIRED';
    /**
    50、满意度调查结果为不满意的。	发生一次扣
    1分	有	网上受理办件出现评价为不满的有一例扣1份
    **/
  end auto_appraisal;
  
  procedure appraisal_dept_all2(yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0')
  is
    nTemp number(8);
    nYear number(4);
    nMonth number(2);
    auditState  M_PaPerformanceResult.AUDIT_RESULT%TYPE;
  begin
    nMonth := extract(month from yearAndMonth);
    nYear := extract(year from yearAndMonth);
    
    select count(1),max(AUDIT_RESULT) into nTemp,auditState from M_PaPerformanceResult a where a.COUNT_YEAR =nYear and a.COUNT_MONTH=nMonth and a.CHECK_TYPE='2';
    if auditState<>'0' then
       return;
    end if;
    
    if onlyCalcSum='0' and nTemp > 0  then
      if deleteOld='0'  then
        return ;
      end if;
      -- 删除旧数据
      --delete from M_PaPerformanceResult where COUNT_YEAR =nYear and COUNT_MONTH=nMonth;
      delete from M_PaMonthCheckup where COUNT_YEAR =nYear and COUNT_MONTH=nMonth and CHECK_TYPE='2';
      delete from M_PaMonthStat where COUNT_YEAR =nYear and COUNT_MONTH=nMonth and STAT_TYPE='2';
    end if;
    
    if onlyCalcSum='0' then
       auto_appraisal(nYear, nMonth);
    end if;
    
    for r in (select u.unitcode, 
                     nvl((select sum(c.ITEM_VALUE) from M_PaMonthCheckup c where c.COUNT_YEAR =nYear and c.COUNT_MONTH=nMonth and c.org_id=u.unitcode and c.CHECK_TYPE='2'),0) as calculate_num, 
                     nvl((select sum(p.PUNISH_SUM) from M_PaMonthPunish p where p.COUNT_YEAR =nYear and p.COUNT_MONTH=nMonth and p.org_id=u.unitcode and p.PUNISH_TYPE='2'),0) as record_num
           from f_unitinfo u --where u.unittype = 'X'  对机构进行过滤
    )loop
         select count(1) into nTemp from M_PaPerformanceResult p 
           where p.COUNT_YEAR =nYear and p.COUNT_MONTH=nMonth and p.CHECK_TYPE='2' and p.org_id = r.unitcode;
         
         if nTemp=1 then
            update M_PaPerformanceResult 
                   set CREATE_DATE = sysdate,calculate_num=r.calculate_num,record_num = r.record_num,
                       ALL_NUM = r.calculate_num +  r.record_num,
                       ZS_SCORE = 100 + r.calculate_num +  r.record_num
            where COUNT_YEAR =nYear and COUNT_MONTH=nMonth and CHECK_TYPE='2' and org_id = r.unitcode;
         else
           if nTemp>1 then
              delete from M_PaPerformanceResult p 
                     where p.COUNT_YEAR =nYear and p.COUNT_MONTH=nMonth and p.CHECK_TYPE='2' and p.org_id = r.unitcode;
           end if;
           insert into M_PaPerformanceResult(CHECK_NO,CHECK_TYPE,USER_CODE ,ORG_ID ,COUNT_YEAR,
                   COUNT_MONTH,CREATE_DATE , calculate_num ,record_num , ALL_NUM ,
                   ZS_SCORE,AUDIT_RESULT)
           values(S_STAT_PIECE_NO.Nextval,'2',null,r.unitcode,  nYear,
                nMonth,sysdate,r.calculate_num ,r.record_num , r.calculate_num +r.record_num  ,
                   100+r.calculate_num+r.record_num ,'0');
           
         end if;
    end loop;
  end appraisal_dept_all2;
  
  /** 法制监督 绩效考评
  */
  procedure appraisal_dept_temporary(unitCode in varchar2,beginTime in date, endTime in date,curAppraisal out ref_cursor)
  is
    nTemp number(12);
  begin
    select count(1) into nTemp
                   from M_ApplyResult r 
                   where r.UPDATE_DATE >= beginTime and r.UPDATE_DATE < endTime and 
                         r.STATUS='1' and (r.NOTE is null or length(r.NOTE)<10)
                         and r.org_id= unitCode;

                
     insert into M_TempCheckupDetail(PIECE_NO, ORG_ID, 
                    ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values( S_STAT_PIECE_NO.Nextval,unitCode,  
                 'REFUSE_WITHOUT_RESION','没有告知原因的不受理案件', -0.5*nTemp,
               '分','当办件不受理时，没有填写不受理原因的，有一例违反扣0.5分','-0.5*'||to_char(nTemp)  
        );  
        
     open curAppraisal for select PIECE_NO, ORG_ID, 
                    ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE from M_TempCheckupDetail;
     --commit;
  end;
begin
  -- Initialization
  null;
end performance_appraisal;
/
