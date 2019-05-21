create or replace package performance_appraisal is

  -- Author  : CODEFAN
  -- Created : 2013-6-8 9:08:24
  -- Purpose : ��Ч����
  type ref_cursor is ref cursor;
  
   
  -- �Բ��Ž�����������  onlyCalcSun Ϊ true �ǽ��������ܷ� deleteOld Ϊtrueʱ ����ѽ������������
  procedure appraisal_dept(unitCode in varchar2,yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0');
  -- �����в��Ž�����������
  procedure appraisal_dept_all(yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0');
  -- �����в��Ž����������ˣ��Ż�����
  procedure appraisal_dept_all2(yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0');
  
  -- ���Ƽල��ʱ����
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
    12������������������Ҫȡ��������ɵģ�Ӧ����ʱ��֪�����˲�����ԭ��  Υ��һ�ο�
    0.5��  ��  �����������ʱ��û����д������ԭ��ģ���һ��Υ����0.5�֡�
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
               nMonth,sysdate, 'REFUSE_WITHOUT_RESION','û�и�֪ԭ��Ĳ�������',
                   nTemp, '��');  

                
     insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values( S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'REFUSE_WITHOUT_RESION','û�и�֪ԭ��Ĳ�������', -0.5*nTemp,
               '��','�����������ʱ��û����д������ԭ��ģ���һ��Υ����0.5��','-0.5*'||to_char(nTemp)  
        );   
    
    /**
    18����������Ӧ�����������ύ��������Ͻ�����顣  Υ��һ�ο�
    0.5��  ��  ��������Ƿ��С�������ݡ������û��Υ��һ�ο�0.5��
    **/
    select count(1) into nTemp 
               from M_ApplyResult r 
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                     r.STATUS='2' and not exists(select b.* from M_ApplyProcess b 
                                      where b.INTERNAL_NO=r.INTERNAL_NO and b.ITEM_ID=r.ITEM_ID
                                             and b.TACHE_NAME like '%�������%') and r.org_id=unitCode;
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         values( S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
               nMonth,sysdate, 'NOCHECK_REQUEST_STUFF','δ���������������ɰ���',nTemp,
               '��');  
               
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values(S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'NOCHECK_REQUEST_STUFF','δ���������������ɰ���', -0.5*nTemp,
               '��','��������Ƿ��С�������ݡ������û��Υ��һ�ο�0.5��','-0.5*'||to_char(nTemp)  
         );             
    /**
    21���������ض�������������������Ӧ�����չ涨��������������ɾ�����  Υ��һ�ο�
    0.5��  ��  �������û�г�ʾ��ɾ����飬��һ����0.5�֡�

    22����������������������������ɵ���������ģ�Ӧ��˵�����ɡ�  Υ��һ�ο�
    0.5��  ��  û�жԲ������û��˵��ԭ��İ������һ����0.5�֡�
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
               nMonth,sysdate, 'PROHIBIT_WITHOUT_RESION','û�и�֪ԭ��Ĳ���ɰ���',nTemp,
               '��'); 
                   
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values(S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'PROHIBIT_WITHOUT_RESION','û�и�֪ԭ��Ĳ���ɰ���', -0.5*nTemp,
               '��','û�жԲ������û��˵��ԭ��İ������һ����0.5��','-0.5*'||to_char(nTemp)  
         );        
    /**
    25���޷������ݲ������Ըı��Ѿ���Ч��������ɡ�  Υ��һ�ο�
    0.5��  ��  ������������ϰ��ߵ�������ɰ������Υ��һ�ο�0.5��

    27����������Ӧ���ڹ涨�����ں�ʵ������Υ�������������������Ͷ�ߡ��ٱ���  Υ��һ�ο�
    0.5��  ��  ��Թ���Ͷ�ߣ�������Աһ����û�д�����һ��Υ���Ŀ�0.5��

    28���������ض��ϼ����ػ������Ҫ��𸴵��������Ͷ�ߡ��ٱ�Ӧ���ڹ涨�����ڱ��Ͱ�������  Υ��һ�ο�
    0.5��  ��  �������Ͷ�ߣ�������Աһ����û�д���������һ��Υ���Ŀ�0.5��

    29����������ʵʩ������ɲ��������������鲢������ɽ�������  ����һ�ο�
    1��  ��  ���������г����������ȷ��Υ����������һ����1��

    30����������ʵʩ������ɵ����������ϲ����ߡ�  ����һ�ο�
    1��  ��  ����Ӧ���г��ְ��ߵ����������һ�ο�1��

    32����������Ӧ����ǿ���¼���������ʵʩ������ɵļල��飬��ʱ�����������ʵʩ�е�Υ����Ϊ��  Υ��һ�ο�
    0.5��  ��  ���м��������쳣���𶽰�ʱ����һ����0.5��

    36����������Ӧ�ڷ�������������������ɾ�������������������һ�������������������ģ�������ƾ��档  ����һ�ο�
    1��  ��  ��������������������Ӧ�ڷ���������ɾ�������������������һ�������������������ģ���һ����1�֡�
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
               nMonth,sysdate, 'ALARM_EXPIRED','���ڻ��ƾ��永��',nTemp,
               '��');    
                  
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values(S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'ALARM_EXPIRED','���ڻ��ƾ��永��', -1.0*nTemp,
               '��','��������������������Ӧ�ڷ���������ɾ�������������������һ�������������������ģ���һ����1��','-1*'||to_char(nTemp)  
         );     
    /**
    37����������Ӧ�ڷ�������������������ɾ����������������������켰���������������������ģ�������ƾ��档  ����һ�ο�
    1.5��  ��  ����������Ӧ�ڷ�������������������ɾ����������������������켰��������������������һ����1.5��
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
               nMonth,sysdate, 'ALTER_EXPIRED','���ں����ƾ��永��',nTemp,
               '��');       
    
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         values(S_STAT_PIECE_NO.Nextval,'2',null,unitCode,  nYear,
                nMonth,sysdate, 'ALTER_EXPIRED','���ں����ƾ��永��', -1.5*nTemp,
               '��','����������Ӧ�ڷ�������������������ɾ����������������������켰��������������������һ����1.5��','-1.5*'||to_char(nTemp)  
         ); 
    /**
    50������ȵ�����Ϊ������ġ�	����һ�ο�
    1��	��	������������������Ϊ��������һ����1��
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
      -- ɾ��������
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
  
  -- �������еĲ��ţ��򵥵Ķ����в��Ž��е�����
  procedure appraisal_dept_all(yearAndMonth in date,deleteOld in varchar2:='0',onlyCalcSum in varchar2:='0')
  is
  begin
    for r in (select u.unitcode
             from f_unitinfo u --where u.unittype = 'X'  �Ի������й���
    )loop
       appraisal_dept(r.unitcode,yearAndMonth,deleteOld ,onlyCalcSum); 
    end loop;
  end appraisal_dept_all;
  
  -- �Ż�����ʽ�����Ч��
  procedure auto_appraisal(nYear in number, nMonth in number)
  is
    dateBegin date;
    dateEnd date;
  begin
    dateBegin := to_date(to_char(nYear)||'-'||to_char(nMonth),'YYYY-MM');
    dateEnd  := add_months(dateBegin,1);
    /**
    12������������������Ҫȡ��������ɵģ�Ӧ����ʱ��֪�����˲�����ԭ��  Υ��һ�ο�
    0.5��  ��  �����������ʱ��û����д������ԭ��ģ���һ��Υ����0.5�֡�
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'REFUSE_WITHOUT_RESION','û�и�֪ԭ��Ĳ�������',t.caseCount,
               '��'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r 
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                     r.STATUS='1' and (r.NOTE is null or length(r.NOTE)<10)
               group by r.org_id) t;  
                
     insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'REFUSE_WITHOUT_RESION','û�и�֪ԭ��Ĳ�������', -0.5*p.STAT_VALUE,
               '��','�����������ʱ��û����д������ԭ��ģ���һ��Υ����0.5��','-0.5*'||to_char(p.STAT_VALUE)  
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'REFUSE_WITHOUT_RESION';   
    
    /**
    18����������Ӧ�����������ύ��������Ͻ�����顣  Υ��һ�ο�
    0.5��  ��  ��������Ƿ��С�������ݡ������û��Υ��һ�ο�0.5��
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'NOCHECK_REQUEST_STUFF','δ���������������ɰ���',t.caseCount,
               '��'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r 
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                     r.STATUS='2' and not exists(select b.* from M_ApplyProcess b 
                                      where b.INTERNAL_NO=r.INTERNAL_NO and b.ITEM_ID=r.ITEM_ID
                                             and b.TACHE_NAME like '%�������%')
               group by r.org_id) t;  
               
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'NOCHECK_REQUEST_STUFF','δ���������������ɰ���', -0.5*p.STAT_VALUE,
               '��','��������Ƿ��С�������ݡ������û��Υ��һ�ο�0.5��','-0.5*'||to_char(p.STAT_VALUE)
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'NOCHECK_REQUEST_STUFF';          
    /**
    21���������ض�������������������Ӧ�����չ涨��������������ɾ�����  Υ��һ�ο�
    0.5��  ��  �������û�г�ʾ��ɾ����飬��һ����0.5�֡�

    22����������������������������ɵ���������ģ�Ӧ��˵�����ɡ�  Υ��һ�ο�
    0.5��  ��  û�жԲ������û��˵��ԭ��İ������һ����0.5�֡�
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'PROHIBIT_WITHOUT_RESION','û�и�֪ԭ��Ĳ���ɰ���',t.caseCount,
               '��'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r 
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and 
                     r.STATUS='3' and (r.NOTE is null or length(r.NOTE)<10)
               group by r.org_id) t; 
                   
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'PROHIBIT_WITHOUT_RESION','û�и�֪ԭ��Ĳ���ɰ���', -0.5*p.STAT_VALUE,
               '��','û�жԲ������û��˵��ԭ��İ������һ����0.5��','-0.5*'||to_char(p.STAT_VALUE)
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'PROHIBIT_WITHOUT_RESION';     
    /**
    25���޷������ݲ������Ըı��Ѿ���Ч��������ɡ�  Υ��һ�ο�
    0.5��  ��  ������������ϰ��ߵ�������ɰ������Υ��һ�ο�0.5��

    27����������Ӧ���ڹ涨�����ں�ʵ������Υ�������������������Ͷ�ߡ��ٱ���  Υ��һ�ο�
    0.5��  ��  ��Թ���Ͷ�ߣ�������Աһ����û�д�����һ��Υ���Ŀ�0.5��

    28���������ض��ϼ����ػ������Ҫ��𸴵��������Ͷ�ߡ��ٱ�Ӧ���ڹ涨�����ڱ��Ͱ�������  Υ��һ�ο�
    0.5��  ��  �������Ͷ�ߣ�������Աһ����û�д���������һ��Υ���Ŀ�0.5��

    29����������ʵʩ������ɲ��������������鲢������ɽ�������  ����һ�ο�
    1��  ��  ���������г����������ȷ��Υ����������һ����1��

    30����������ʵʩ������ɵ����������ϲ����ߡ�  ����һ�ο�
    1��  ��  ����Ӧ���г��ְ��ߵ����������һ�ο�1��

    32����������Ӧ����ǿ���¼���������ʵʩ������ɵļල��飬��ʱ�����������ʵʩ�е�Υ����Ϊ��  Υ��һ�ο�
    0.5��  ��  ���м��������쳣���𶽰�ʱ����һ����0.5��

    36����������Ӧ�ڷ�������������������ɾ�������������������һ�������������������ģ�������ƾ��档  ����һ�ο�
    1��  ��  ��������������������Ӧ�ڷ���������ɾ�������������������һ�������������������ģ���һ����1�֡�
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'ALARM_EXPIRED','���ڻ��ƾ��永��',t.caseCount,
               '��'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r join M_OutWay o on o.BJ_TYPE='1' and  o.INTERNAL_NO=r.INTERNAL_NO and o.ITEM_ID=r.ITEM_ID
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and
                     o.Warning_Code = 'ALARM_EXPIRED' and o.OutWayState='1' 
               group by r.org_id) t;  
                  
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'ALARM_EXPIRED','���ڻ��ƾ��永��', -1.0*p.STAT_VALUE,
               '��','��������������������Ӧ�ڷ���������ɾ�������������������һ�������������������ģ���һ����1��','-1*'||to_char(p.STAT_VALUE)
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'ALARM_EXPIRED';    
    /**
    37����������Ӧ�ڷ�������������������ɾ����������������������켰���������������������ģ�������ƾ��档  ����һ�ο�
    1.5��  ��  ����������Ӧ�ڷ�������������������ɾ����������������������켰��������������������һ����1.5��
    **/
    insert into M_PaMonthStat(STAT_NO, STAT_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
              COUNT_MONTH, CREATE_DATE, STAT_CODE, STAT_NAME,STAT_VALUE, 
              STAT_UNIT)
         select S_STAT_PIECE_NO.Nextval,'2',null,t.org_id,  nYear,
               nMonth,sysdate, 'ALTER_EXPIRED','���ں����ƾ��永��',t.caseCount,
               '��'  
         from (select r.org_id, count(1) as caseCount 
               from M_ApplyResult r join M_OutWay o on o.BJ_TYPE='1' and  o.INTERNAL_NO=r.INTERNAL_NO and o.ITEM_ID=r.ITEM_ID
               where r.UPDATE_DATE >= dateBegin and r.UPDATE_DATE < dateEnd and
                     o.Warning_Code = 'ALTER_EXPIRED' and o.OutWayState='1' 
               group by r.org_id) t;         
    
    insert into M_PaMonthCheckup(PIECE_NO, CHECK_TYPE, USER_CODE, ORG_ID, COUNT_YEAR,
                  COUNT_MONTH, CREATE_DATE, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                  ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE)
         select S_STAT_PIECE_NO.Nextval,'2',null,p.org_id,  nYear,
                nMonth,sysdate, 'ALTER_EXPIRED','���ں����ƾ��永��', -1.5*p.STAT_VALUE,
               '��','����������Ӧ�ڷ�������������������ɾ����������������������켰��������������������һ����1.5��','-1.5*'||to_char(p.STAT_VALUE)
         from  M_PaMonthStat p
         where p.COUNT_YEAR= nYear and p.COUNT_MONTH=nMonth and p.STAT_TYPE='2' and
               p.STAT_CODE= 'ALTER_EXPIRED';
    /**
    50������ȵ�����Ϊ������ġ�	����һ�ο�
    1��	��	������������������Ϊ��������һ����1��
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
      -- ɾ��������
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
           from f_unitinfo u --where u.unittype = 'X'  �Ի������й���
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
  
  /** ���Ƽල ��Ч����
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
                 'REFUSE_WITHOUT_RESION','û�и�֪ԭ��Ĳ�������', -0.5*nTemp,
               '��','�����������ʱ��û����д������ԭ��ģ���һ��Υ����0.5��','-0.5*'||to_char(nTemp)  
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
