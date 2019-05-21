 --更改表m_apply 增加一个字段查询密码
 alter table m_apply add (
                QUERYPASSWORD varchar2(30)); 
                
/
--更改抽取数据的package data_exchange
create or replace package body Data_Exchange is
--许可基本信息
  procedure P_TO_APPLY AS
    /*
    create sequence S_M_APPLY
    minvalue 1
    maxvalue 99999999999
    start with 1
    increment by 1
    cache 20;
    */


  BEGIN
    for r in (select nvl(u.depno, 'JS000000JT') ||
                     LPAD(S_M_APPLY.NEXTVAL, 10, 0) no,
                     nvl(u.depno, 'JS000000JT') org_id,
                     u.unitcode unitcode,
                     b.dj_id internal_no,
                     substr(nvl(u.depno, 'JS999900HD'), 1, 8) ||
                     substr(b.powerid, 1, 10) item_id,
                     nvl(u.unitname , '无业务处室') department,
                     nvl(b.transaffairname, '无办件名称') transact_affair_name,
                     nvl(b.content, '无办件摘要') content,
                     a.apply_way apply_way,
                     '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA ><DOCUMENT>
                     <DOCUMENT_ID></DOCUMENT_ID>
    <DOCUMENT_NAME></DOCUMENT_NAME>
    <FILE_NAME></FILE_NAME>
    <FILE_CONTENT></FILE_CONTENT>

                     </DOCUMENT></DOCUMENTDATA>' form,
                     nvl(centit_sunzw_xml.AnnexSqlToXml('select stuffid      as docId,
          nvl(replace(filename,''_''),''docName'')      as docName,
          nvl(stuffname,filename)    as pathName,
       stuffcontent as fileContent
  from opt_stuff_info
 where dj_id = ''' ||b.dj_id ||'''
                           and nodename=''受理'' '),
                         '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA ><DOCUMENT>
                     <DOCUMENT_ID></DOCUMENT_ID>
    <DOCUMENT_NAME></DOCUMENT_NAME>
    <FILE_NAME></FILE_NAME>
    <FILE_CONTENT></FILE_CONTENT>

                     </DOCUMENT></DOCUMENTDATA>') stuff,
                     a.proposer_unitcode applicant_code,
                     substr(proposer_type, -1, 1) applicant_type,
                     a.proposer_name applicant_name,
                     a.proposer_paper_type applicant_paper_type,
                     a.proposer_paper_code applicant_paper_code,
                     a.proposer_phone applicant_phone,
                     a.proposer_mobile applicant_mobile,
                     a.proposer_addr applicant_address,
                     a.proposer_zipcode applicant_zipcode,
                     a.proposer_email applicant_email,
                     a.agent_name linkman_name,
                     a.agent_paper_type linkman_paper_type,
                     a.agent_paper_code linkman_paper_code,
                     a.agent_phone linkman_phone,
                     a.agent_mobile linkman_mobile,
                     a.agent_addr linkman_address,
                     a.agent_zipcode linkman_zipcode,
                     a.agent_email linkman_email,
                     nvl(wf.promisetime/ (8*60), 0) promise,
                     '1' promise_type,
                     case
                       when length(b.riskdesc) >= 1 then
                        1else 0
                     end isrisk,
                     b.risktype risktype,
                     b.riskdesc riskdescription,
                     b.riskresult riskresult,
                     a.book_date apply_date,
                     b.createdate create_date,
                     sysdate update_date,
                     '' sync_error_desc,
                     b.transaffairquerykey
              --  select *
                from (select *
                        from opt_base_info
                       where dj_id like 'XK%'
                         AND (sign is null or sign = '0' or sign = '2')
                         and biztype != 'F'
                         ) b
                join opt_apply_info a
                  on a.dj_id = b.dj_id
                join f_unitinfo u
                  on u.unitcode = b.orgcode --拿部门编码
                 join wf_flow_instance wf
                  on b.flowinstid = wf.wfinstid

              ) loop
      begin
        insert into m_apply
          (no, --  VARCHAR2(50) not null,
           -- change_no,--默认1
           org_id, --  VARCHAR2(10) not null,
           internal_no, --     VARCHAR2(100) not null,
           item_id, --      VARCHAR2(100) not null,
           department, --       VARCHAR2(100) not null,
           transact_affair_name, --  VARCHAR2(200) not null,
           content, --        VARCHAR2(200) not null,
           apply_way, --     VARCHAR2(1) not null,parameters
           form, --      CLOB,
           stuff, --      CLOB,
           applicant_code, --    VARCHAR2(50),
           applicant_type, --    VARCHAR2(1) not null,
           applicant_name, --   VARCHAR2(100) not null,
           applicant_paper_type, -- VARCHAR2(2),
           applicant_paper_code, -- VARCHAR2(50),
           applicant_phone, --   VARCHAR2(40),
           applicant_mobile, --   VARCHAR2(20),
           applicant_address, --   VARCHAR2(200),
           applicant_zipcode, --   VARCHAR2(6),
           applicant_email, --    VARCHAR2(100),
           -- linkman, --       VARCHAR2(50),
           linkman_name, --     VARCHAR2(100),
           linkman_paper_type, --  VARCHAR2(2),
           linkman_paper_code, --   VARCHAR2(50),
           linkman_phone, --    VARCHAR2(40),
           linkman_mobile, --    VARCHAR2(20),
           linkman_address, --   VARCHAR2(200),
           linkman_zipcode, --   VARCHAR2(6),
           linkman_email, --     VARCHAR2(100),
           promise, --         NUMBER(4) not null,
           promise_type, --      VARCHAR2(2) not null,
           isrisk, --       NUMBER(1),
           risktype, --      VARCHAR2(50),
           riskdescription, --    VARCHAR2(200),
           riskresult, --     VARCHAR2(200),
           apply_date, --     DATE not null,
           create_date, --     DATE not null,
           update_date, --      DATE not null,
           -- sync_date, --     DATE,
           --  sync_sign, --       VARCHAR2(1),
           sync_error_desc, --    VARCHAR2(1000),
           from_system,
           QUERYPASSWORD
           
           )
        values
          (r.no, --  VARCHAR2(50) not null,
           -- change_no,--默认1
           r.org_id, --  VARCHAR2(10) not null,
           r.internal_no, --     VARCHAR2(100) not null,
           r.item_id, --      VARCHAR2(100) not null,
           r.department, --       VARCHAR2(100) not null,
           r.transact_affair_name, --  VARCHAR2(200) not null,
           r.content, --        VARCHAR2(200) not null,
           r.apply_way, --     VARCHAR2(1) not null,parameters
           r.form, --      CLOB,
           r.stuff, --  r.stuff,   CLOB,
           r.applicant_code, --    VARCHAR2(50),
           r.applicant_type, --    VARCHAR2(1) not null,
           r.applicant_name, --   VARCHAR2(100) not null,
           r.applicant_paper_type, -- VARCHAR2(2),
           r.applicant_paper_code, -- VARCHAR2(50),
           r.applicant_phone, --   VARCHAR2(40),
           r.applicant_mobile, --   VARCHAR2(20),
           r.applicant_address, --   VARCHAR2(200),
           r.applicant_zipcode, --   VARCHAR2(6),
           r.applicant_email, --    VARCHAR2(100),
           -- linkman, --       VARCHAR2(50),
           r.linkman_name, --     VARCHAR2(100),
           r.linkman_paper_type, --  VARCHAR2(2),
           r.linkman_paper_code, --   VARCHAR2(50),
           r.linkman_phone, --    VARCHAR2(40),
           r.linkman_mobile, --    VARCHAR2(20),
           r.linkman_address, --   VARCHAR2(200),
           r.linkman_zipcode, --   VARCHAR2(6),
           r.linkman_email, --     VARCHAR2(100),
           r.promise, --         NUMBER(4) not null,
           r.promise_type, --      VARCHAR2(2) not null,
           r.isrisk, --       NUMBER(1),
           r.risktype, --      VARCHAR2(50),
           r.riskdescription, --    VARCHAR2(200),
           r.riskresult, --     VARCHAR2(200),
           r.apply_date, --     DATE not null,
           r.create_date, --     DATE not null,
           r.update_date, --      DATE not null,
           -- sync_date, --     DATE,
           --  sync_sign, --       VARCHAR2(1),
           r.sync_error_desc, --    VARCHAR2(1000),
           '0',
           r.transaffairquerykey
          
           );

        update opt_base_info t
           set t.sign = 1
         where t.dj_id = r.internal_no;
        commit;

      EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
          update opt_base_info t
             set t.sign = 2
           where t.dj_id = r.internal_no;


      end;
      commit;
    end loop;
  end;

  --许可过程
  procedure P_TO_APPLYPROCESS AS

  BEGIN

    for r in (select nvl(u.depno, 'JS000000JT') ||
                     LPAD(S_M_APPLY.NEXTVAL, 10, 0) no,
                     row_number() over(partition by i.dj_id order by i.transdate)+
   (select nvl(max(t.no_ord),0)  from  m_applyprocess t where t.internal_no=i.dj_id)  no_ord, --1 2 3 4 5 6 环节序号
                     nvl(u.depno, 'JS000000JT') org_id, --      VARCHAR2(10) not null,
                     i.dj_id internal_no,
                     substr(u.depno, 1, 8) || substr(b.powerid, 1, 10) item_id,
                     i.nodename tache_name,
                     nvl(u.unitname, '无办理处室') department,
                     i.usercode user_staff_code,
                     i.username user_name,
                    case when i.ideacode ='B' then '6'  when i.ideacode ='T' then '1'
                       when i.ideacode ='F' then '2' ELSE '1'  end
                      status,
/*1：同意通过，本岗处理完成，同意上一岗位意见，进入后续岗位；
2：否决通过，本岗处理完成，不同意上一岗位意见，进入后续岗位；
3：暂停，由于申请者原因或上报上级机关原因，计时暂停；
4：补正，要求申请者对材料进行补正，此时计时暂停；
5：正在处理；
6：退回，退回到上一岗位；
7：中止，整个办件处理流程中止；*/

                     nvl(wf.promisetime/ (8*60), 0) promise, --promise
                     1 PROMISE_TYPE, --工作日
                     case
                       when length(b.riskdesc) >= 1 then
                        1else 0
                     END isrisk,
                     p.risktype risktype,
                     p.riskdesc riskdescription,
                     p.riskresult riskresult,
                     nvl(i.transIdea, '无处理意见') note,
                     nvl(centit_sunzw_xml.AnnexSqlToXml('select stuffid      as docId,
          nvl(replace(filename,''_''),''docName'')       as docName,
       nvl(stuffname,filename)     as pathName,
       stuffcontent as fileContent
  from opt_stuff_info
 where dj_id = ''' ||
                                                        i.dj_id ||
                                                        ''' and iszhi is null and nodeinstid=''' ||
                                                        i.nodeinstid ||
                                                        ''' and nodeinstid != 0 and nodeinstid is not null  '),
                         '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA ><DOCUMENT>
                     <DOCUMENT_ID></DOCUMENT_ID>
    <DOCUMENT_NAME></DOCUMENT_NAME>
    <FILE_NAME></FILE_NAME>
    <FILE_CONTENT></FILE_CONTENT>

                     </DOCUMENT></DOCUMENTDATA>') attachment,
                     i.transdate process_date,
                     wf.nodeid node_id,
                     '1' node_attribute,
                     wf.createtime create_date,
                     sysdate update_date,
                     i.procid,--更新标志位用
                 wf.nodeinstid tache_id,
                 wf.prevnodeinstid  tache_prev_int_no,
                 u.unitcode

              --    select*
                from (select *
                        from opt_idea_info
                       where (sign is null or sign = '0' or sign = '2')
                         and dj_id like 'XK%'
                         and nodename!='申请'
                         ) i
                join opt_proc_info p
                  on p.nodeinstid = i.nodeinstid
                     join opt_base_info b
                  on i.dj_id = b.dj_id
                join wf_node_instance wf
                  on wf.nodeinstid = i.nodeinstid
                join f_unitinfo u
                  on u.unitcode = b.orgcode


              ) loop
      begin
        insert into m_applyprocess
          (no, --           VARCHAR2(50) not null,
           no_ord, --1 2 3 4 5 6
           org_id, --      VARCHAR2(10) not null,
           internal_no, --    VARCHAR2(100) not null,
           item_id, --     VARCHAR2(100) not null,
           tache_id, --     VARCHAR2(50),
           tache_name, --    VARCHAR2(100),
           --tache_inte_no       ,--   VARCHAR2(50),
           tache_prev_int_no    ,--  VARCHAR2(50),
           department, --     VARCHAR2(100) not null,
           user_staff_code, --   VARCHAR2(30) not null,
           user_name, --    VARCHAR2(100) not null,
           status, --    VARCHAR2(2) not null,
           promise, --    NUMBER(4) not null,
           promise_type, --     VARCHAR2(2),
           --promise_start_sign    ,--  VARCHAR2(1),
           isrisk, --      NUMBER(1),
           risktype, --        VARCHAR2(50),
           riskdescription, --  VARCHAR2(200),
           riskresult, --      VARCHAR2(200),
           note, --     VARCHAR2(4000) not null,
           attachment, --      CLOB,
           process_date, --     DATE not null,
           node_id, --     下个节点的人
           node_attribute, --   NUMBER(1) not null,
           create_date, --     DATE not null,
           update_date --      DATE not null,
           --sync_date        ,--      DATE,
           --sync_sign         ,--     VARCHAR2(1),
           --   VARCHAR2(1000),
           -- begin_date       --      DATE
           
           )
        values
          (r.no, --           VARCHAR2(50) not null,
           r.no_ord, --1 2 3 4 5 6
           r.org_id, --      VARCHAR2(10) not null,
           r.internal_no, --    VARCHAR2(100) not null,
           r.item_id, --     VARCHAR2(100) not null,
           r.tache_id, --     VARCHAR2(50),
           r.tache_name, --    VARCHAR2(100),
           --tache_inte_no       ,--   VARCHAR2(50),
          r.tache_prev_int_no    ,--  VARCHAR2(50),
           r.department, --     VARCHAR2(100) not null,
           r.user_staff_code, --   VARCHAR2(30) not null,
           r.user_name, --    VARCHAR2(100) not null,
           r.status, --    VARCHAR2(2) not null,
           r.promise, --    NUMBER(4) not null,
           r.promise_type, --     VARCHAR2(2),
           --promise_start_sign    ,--  VARCHAR2(1),
           r.isrisk, --      NUMBER(1),
           r.risktype, --        VARCHAR2(50),
           r.riskdescription, --  VARCHAR2(200),
           r.riskresult, --      VARCHAR2(200),
           r.note, --     VARCHAR2(4000) not null,
           r.attachment, --      CLOB,
           r.process_date, --     DATE not null,
           r.node_id, --     下个节点的人
           r.node_attribute, --   NUMBER(1) not null,
           r.create_date, --     DATE not null,
           r.update_date --      DATE not null,
           --sync_date        ,--      DATE,
           --sync_sign         ,--     VARCHAR2(1),
          
           );
        update opt_idea_info t
           set t.sign = 1
         where t.procid = r.procid;
        commit;
      EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
          update opt_idea_info t
             set t.sign = 2
           where t.procid = r.procid;
      end;
      commit;
    end loop;
  END;

  --许可结果
  procedure P_TO_APPLYRESULT AS
  BEGIN
    for r in (select nvl(u.depno, 'JS000000JT') ||
                     LPAD(S_M_APPLY.NEXTVAL, 10, 0) no,
                     nvl(u.depno, 'JS000000JT') org_id,
                     b.dj_id internal_no,
                     substr(u.depno, 1, 8) || substr(b.powerid, 1, 10) item_id,
        (case  when nvl(b.solveStatus,'2')='T' then 2 when nvl(b.solveStatus,'2')='F' and nvl(b.solvenote,'无办结意见')!='不受理' then 3 when nvl(b.solveStatus,'2')='F' and nvl(b.solvenote,'无办结意见')='不受理'  then 1 else 2 end)  status, --字典选项：1：不予受理；2：许可/ 同意；3：不许可/ 不同意
                     nvl(b.solvenote,'无办结意见') note,
                     b.solvetime finish_time,
                     b.createdate create_date,
                     u.unitcode,
                     sysdate update_date,
                       nvl(centit_sunzw_xml.AnnexSqlToXml('select stuffid      as docId,
       nvl(replace(filename,''_''),''docName'')     as docName,
     nvl(stuffname,filename)    as pathName,
       stuffcontent as fileContent
  from opt_stuff_info
 where dj_id = ''' ||
                                                b.dj_id ||
                                                '''  and nodename=''制作'' '),
                 '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA ><DOCUMENT>
                     <DOCUMENT_ID></DOCUMENT_ID>
    <DOCUMENT_NAME></DOCUMENT_NAME>
    <FILE_NAME></FILE_NAME>
    <FILE_CONTENT></FILE_CONTENT>

                     </DOCUMENT></DOCUMENTDATA>')
                      attachment
              --     select *
                from (select *
                        from opt_base_info
                       where (sign2 is null or sign2 = 0 or sign2 = 2)
                         and biztype = 'C'

                        ) b
                join f_unitinfo u
                  on u.unitcode = b.orgcode
                  ) loop
      begin
        insert into m_applyresult
          (no,
           --chang_no,
           org_id,
           internal_no,
           item_id,
           status,
           note,
           attachment,
           finish_time,
           --   receivable,
           --   paid,
           --   relief_reasons,
           create_date,
         update_date
         
           -- sync_date,
           --   sync_sign,
           -- sync_error_desc
           )
        values
          (r.no,
           --chang_no,
           r.org_id,
           r.internal_no,
           r.item_id,
           r.status,
           r.note,
           r.attachment,
           r.finish_time,
           r.create_date,
           r.update_date
          
           );
        update opt_base_info t
           set t.sign2 = '1'
         where t. dj_id = r.internal_no;
        commit;
      EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
          update opt_base_info t
             set t.sign2 = '2'
           where t.dj_id = r.internal_no;
      end;
      commit;
    end loop;
  END;

  --处罚基本信息
  procedure P_TO_PUNISH as
    v_sign number;
    cursor c is
        select nvl(u.depno, 'JS000000JT') ||
             LPAD(S_M_PUNISH.NEXTVAL, 10, 0) as no,
             nvl(u.depno, 'JS000000JT') as org_id, 
             t.punishobjectid as internal_no, 
    nvl(F_GET_ItemId(t.punishobjectid),'无权力')  as item_id, 
             nvl(u.unitname, '无业务处室') as department, 
             t.pooccuradress as aj_addr, 
             t.pooccurdate as aj_occur_date,
             t.POOriginState source, 
             t.poorigincontext as fact, /*确认事实  */
                t.pooccurstate as target_type, --当事人类型
            case when  t.pooccurstate='0' then (select individualname from P_Individual where punishobjectid=t.punishobjectid  )
            when  t.pooccurstate='1' then (select Enterprisename from P_Enterprise where punishobjectid=t.punishobjectid  ) end
            as punish_target, /*处罚当事人*/

  case  when  t.pooccurstate='1' then (select enterpriseid from P_Enterprise where punishobjectid=t.punishobjectid  ) end
             TARGET_CODE,

             '0' as target_paper_type, /*身份证*/

               case when  t.pooccurstate='0' then (select individualcode from P_Individual where punishobjectid=t.punishobjectid  )
            when  t.pooccurstate='1' then (select enterprisecode from P_Enterprise where punishobjectid=t.punishobjectid  ) end
            target_paper_number,--身份证号

   case when  t.pooccurstate='0' then (select phone from P_Individual where punishobjectid=t.punishobjectid  )
            when  t.pooccurstate='1' then (select phone from P_Enterprise where punishobjectid=t.punishobjectid  ) end
            target_phone,

             case when  t.pooccurstate='0' then (select Individualadress from P_Individual where punishobjectid=t.punishobjectid  )
            when  t.pooccurstate='1' then (select enterpriseaddress from P_Enterprise where punishobjectid=t.punishobjectid  ) end
            target_address,

         ''   target_zip_code, --数据太脏 直接取空值
              case when  t.pooccurstate='0' then (select email from P_Individual where punishobjectid=t.punishobjectid  )
            when  t.pooccurstate='1' then (select email from P_Enterprise where punishobjectid=t.punishobjectid  ) end
            target_email,

             t.pocaseimpeachname as reporter, /*举报人姓名-举报人*/
             t.poregistedate as reporter_date, /*信息登记时间-举报时间*/
             '0' as reporter_paper_type, /*身份证*/
             t.pocaseimpeachid as reporter_aper_code, /*举报人身份证号码-举报人证件号码*/
             t.pocaseimpeachphone as reporter_phone, /*举报人联系电话-举报人电话*/
             t.POCaseImpeachphone as reporter_mobile,
             t.pocaseimpeachadress as reporter_address, /*举报人地址-举报人地址 */
             t.pocaseimpeachpostcode as reporter_zipcode, /*举报人邮编-举报人邮编*/
             '无邮件' as reporter_email,
            nvl(t.transaffairname,'行政处罚（理）['||t.punishobjectid||']') as content,--处罚名称

                 '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA ><DOCUMENT>
                     <DOCUMENT_ID></DOCUMENT_ID>
    <DOCUMENT_NAME></DOCUMENT_NAME>
    <FILE_NAME></FILE_NAME>
    <FILE_CONTENT></FILE_CONTENT>

                     </DOCUMENT></DOCUMENTDATA>' as form,
             nvl(wf.promisetime/ (8*60), 0) as promise,
             '1' as promise_type,
             case
               when length(t.riskdesc) >= 1 then
                1else 0
             end as isrisk,
             t.risktype as risktype,
             t.RiskDesc as riskdescription,
             t.riskresult as riskresult,
             nvl(t.PORegisteDate, t.pooccurdate) as create_date, --登记日期
             sysdate as update_date,
             t.punishobjecttype,    --0 一般处罚 1 现场处罚
             t.poundertaker ,--办理人员 现场处罚用
             u.depno,   --部门编码 现场处罚用
             t.sign,
             u.unitcode
      --  select *
        from (select *
                from P_Punish_Object_Basic where  biztype!='F'
               and (sign is null OR SIGN = '0' or sign = '2')
               --and punishobjecttype='0'--现场处罚不走流程过滤掉

               ) t
       left  join wf_flow_instance wf
          on wf.wfinstid = t.flowinstid
        join f_unitinfo u
          on u.unitcode = t.managedepid
 
 ;

  begin
    for rec in c loop
      begin
       
        insert into m_punish
          (no,
           org_id,
           internal_no,
           item_id,
           department,
           aj_addr,
           aj_occur_date,
           source,
           fact,
           target_type,
           punish_target,
         target_code,
        target_paper_type,
        target_paper_number,
         target_phone,
          -- target_mobile,
       target_address,
         target_zip_code,
        target_email,
           reporter,
           reporter_date,
           reporter_paper_type,
           reporter_aper_code,
           reporter_phone,
           reporter_mobile,
           reporter_address,
           reporter_zipcode,
           reporter_email,
           content,
           form,
           promise,
           promise_type,
           isrisk,
           risktype,
           riskdescription,
           riskresult,
           create_date,
           update_date,from_system
           )
        values
          (rec.no,
           rec.org_id,
           rec.internal_no,
           rec.item_id,
           rec.department,
           rec.aj_addr,
           rec.aj_occur_date,
           rec.source,
           rec.fact,
           rec.target_type,
           rec.punish_target,
       rec.target_code,
          rec.target_paper_type,
        rec.target_paper_number,
        rec.target_phone,
        --  rec.target_mobile,
         rec.target_address,
      rec.target_zip_code,
         rec.target_email,
           rec.reporter,
           rec.reporter_date,
           rec.reporter_paper_type,
           rec.reporter_aper_code,
           rec.reporter_phone,
           rec.reporter_mobile,
           rec.reporter_address,
           rec.reporter_zipcode,
           rec.reporter_email,
           rec.content,
           rec.form,
           rec.promise,
           rec.promise_type,
           rec.isrisk,
           rec.risktype,
           rec.riskdescription,
           rec.riskresult,
           rec.create_date,
           rec.update_date, '0'
           );
        update P_Punish_Object_Basic t
           set t.sign = '1'
         where t.punishobjectid = rec.internal_no;
     commit;--主表标志位先提交
     
    --现场处罚插入过程信息 
    select count(1) into v_sign from m_punishprocess where internal_no =rec.internal_no
    and tache_name='案件受理';--获取主表交换后的标志位信息
     if rec.punishobjecttype='1' and v_sign=0 --现场处罚的且主表信息已成功交换
         then 
       insert into m_Punishprocess
          (no,
          no_ord,
           org_id,
           internal_no,
           item_id,
           tache_id,
           tache_name,
           department,
           user_name,
           status,
           promise,
           promise_type,
           note,
           attachment,
           process_date,
           node_id,
           node_attribute,
           create_date,
           update_date
           )
            values 
      (  nvl(rec.depno, 'JS000000JT') || LPAD(S_M_PUNISHPROCESS.NEXTVAL, 10, 0) ,
          '1'   ,
           rec.org_id,
           rec.internal_no,
           rec.item_id,
          '4703' , 
           '案件受理' ,
           rec.department,
           rec.poundertaker,
           '5' ,
           0 ,
            '1' ,
           '现场处罚自动生成的过程受理数据' ,
          '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA ><DOCUMENT>
                     <DOCUMENT_ID></DOCUMENT_ID>
    <DOCUMENT_NAME></DOCUMENT_NAME>
    <FILE_NAME></FILE_NAME>
    <FILE_CONTENT></FILE_CONTENT>
                     </DOCUMENT></DOCUMENTDATA>' ,
           rec.create_date,
          '4703' ,  --4703  是处罚案件受理节点 虚拟的
           '1' ,
           rec.create_date,
           sysdate );  
              
     
     
      end if;   --现场处罚插入过程信息
        commit;
      EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
          update P_Punish_Object_Basic t
             set t.sign = '2'
           where t.punishobjectid = rec.internal_no;
      end;
      commit;
    end loop;
  end;

  --处罚过程
  procedure P_TO_PUNISHPROCESS as
    cursor c is
       select nvl(u.depno, 'JS000000JT') || LPAD(S_M_PUNISHPROCESS.NEXTVAL, 10, 0) no,
           row_number() over(partition by i.dj_id order by i.transdate)+
   (select nvl(max(t.no_ord),0)  from  m_applyprocess t where t.internal_no=i.dj_id)  no_ord,
   --1 2 3 4 5 6 环节序号
             u.depno org_id,
             i.dj_id internal_no,
        nvl(F_GET_ItemId(i.dj_id),'无权力')  as item_id, 
             i.nodename tache_name,
             nvl(u.unitname, '无业务处室') department,
             i.username user_name,
            case when i.ideacode ='B' then '4'  when i.ideacode ='T' then '5' ELSE '5'  end
              status,  --1：正在处理；2：暂停；4：退回；5：通过；6：中止
             nvl(wf.promisetime/ (8*60), 0) promise, --promise
             '1' PROMISE_TYPE, --工作日
             '1' promise_start_sign,
             case
               when length(p.riskdesc) >= 1 then
                1else 0
             end isrisk,
             p.risktype risktype,
             p.riskdesc riskdescription,
             p.riskresult riskresult,
             nvl(i.transIdea, '无处理意见') note,
             nvl(centit_sunzw_xml.AnnexSqlToXml('select stuffid      as docId,
        nvl(replace(filename,''_''),''docName'')     as docName,
      nvl(stuffname,filename)     as pathName,
       stuffcontent as fileContent
  from opt_stuff_info
 where dj_id = ''' ||
                                                i.dj_id ||
                                                ''' and nodeinstid=''' ||
                                                i.nodeinstid ||
                                                ''' and nodeinstid != 0 and nodeinstid is not null  '),
                 '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA ><DOCUMENT>
                     <DOCUMENT_ID></DOCUMENT_ID>
    <DOCUMENT_NAME></DOCUMENT_NAME>
    <FILE_NAME></FILE_NAME>
    <FILE_CONTENT></FILE_CONTENT>

                     </DOCUMENT></DOCUMENTDATA>') attachment,
             '无证据' evidence,
             i.transdate process_date,
             wf.nodeid node_id,
             '1' node_attribute,
             wf.createtime create_date,
             sysdate update_date,
             '' sync_error_desc,
             i.procid procid,
                  wf.nodeinstid tache_id,
                 wf.prevnodeinstid  tache_prev_int_no,
              u.unitcode

      --       select *
        from (select *
                from opt_idea_info
               where (sign is null or sign = '0' or sign = '2')
                 and dj_id like 'CF%'
                  and nodename!='案件来源登记' --登记和受理的nodeinstid 一样
           ) i
        join opt_proc_info p
          on p.nodeinstid = i.nodeinstid
         join wf_node_instance wf
          on wf.nodeinstid = p.nodeinstid
         join P_PUNISH_OBJECT_BASIC b
          on p.dj_id = b.punishobjectid
        join f_unitinfo u
          on u.unitcode = b.managedepid
   
        ;

  begin
    for rec in c loop
      begin

        insert into m_Punishprocess
          (no,
           no_ord,
           org_id,
           internal_no,
           item_id,
           tache_id,
           tache_name,
           department,
           user_name,
           status,
           promise,
           promise_type,
           promise_start_sign,
           isrisk,
           risktype,
           riskdescription,
           riskresult,
           note,
           attachment,
           evidence,
           process_date,
           node_id,
           node_attribute,
           create_date,
           update_date,
           tache_prev_int_no
           
           /*sync_date,
           sync_sign,
           sync_error_desc,
           begin_date,
           user_staff_code*/)
        values
          (rec.no,
           rec.no_ord,
           rec.org_id,
           rec.internal_no,
           rec.item_id,
           rec.tache_id , 
           rec.tache_name,
           rec.department,
           rec.user_name,
           rec.status,
           rec.promise,
           rec.promise_type,
           rec.promise_start_sign,
           rec.isrisk,
           rec.risktype,
           rec.riskdescription,
           rec.riskresult,
           rec.note,
           rec.attachment,
           rec.evidence,
           rec.process_date,
           rec.node_id,
           rec.node_attribute,
           rec.create_date,
           rec.update_date,
           rec.tache_prev_int_no
           );
        update opt_idea_info t
           set t.sign = '1'
         where t.procid = rec.procid;
        commit;
      EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
          update opt_idea_info t
             set t.sign = '2'
           where t.procid = rec.procid;
      end;
      commit;
    end loop;
  end;

  --处罚结果
  procedure P_TO_PUNISHRESULT as
 v_sign number;
    cursor c is
     select nvl(u.depno, 'JS000000JT') ||
             LPAD(S_M_PUNISHRESULT.NEXTVAL, 10, 0) no,
             nvl(u.depno, 'JS000000JT') as org_id,
             t.punishobjectid as internal_no,
        nvl(F_GET_ItemId(t.punishobjectid),'无权力')  as item_id, 
             case a.punishobjecttype
               when '0' then
                '2'
               when '1' then
                '1'
             end as program, --字典选项：1简易程序/2一般程序
             nvl(to_char(t.disobeyitem), '法律依据为空') as accordance, --处罚法律依据
             nvl((select max(b.item_id||substr(to_char(free_judge),10,5000))
                from B_power b join  p_trans_law_basic l on b.item_id=l.item_id 
               where QL_State = 'A'
                 and begin_time <= sysdate
                 and (end_time is null or end_time > sysdate)
                 and version != 0
                 AND l.punishobjectid =t.punishobjectid ),'处罚标准为空')  as standard,
            nvl(t.POINDAGATEREPSTATE ,'1') punish_deside, 
            --0 ：未立案（后加）1 ：做出行政处罚决定；2：行政处理；3：撤消；4：移送司法机关
             nvl(F_GET_PunishType(t.punishobjectid), '3') as punish_class,
             nvl(to_char(t.podiscussresult),'无处罚结果') as punish_result,
             nvl(decode(t.punishamout,-1,0,t.punishamout),0)  as punish_result_fine,
             t.punishamoutpeople as punish_result_fine_people,
             t.punishseizure as punish_result_expropriation,
             t.punishseizurevalue as punish_result_expropriation_v,
             t.punishshoutont as punish_result_business, --停业天数 
             t.punishdetentionpeople as punish_result_people, --人数
             t.punishdetention as punish_result_detain, --天数
        nvl(centit_sunzw_xml.AnnexSqlToXml('select stuffid      as docId,
       nvl(replace(filename,''_''),''docName'')      as docName,
       nvl(stuffname,filename)     as pathName,
       stuffcontent as fileContent
  from opt_stuff_info
 where dj_id = ''' ||a.punishobjectid || ''' and nodename=''结案'' '),
                 '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA ><DOCUMENT>
                     <DOCUMENT_ID></DOCUMENT_ID>
    <DOCUMENT_NAME></DOCUMENT_NAME>
    <FILE_NAME></FILE_NAME>
    <FILE_CONTENT></FILE_CONTENT>
                     </DOCUMENT></DOCUMENTDATA>')
      as attachment,
             nvl(A.SOLVETIME, sysdate) as finish_date,
             nvl(a.poregisterdate, sysdate) as create_date,
             sysdate as update_date,
             a.punishobjecttype, --以下四个字段是现场处罚加过程信息用
             a.poundertaker,
             u.unitname department,
             u.depno, u.unitcode
      --    select *
        from
        (select * from p_finish_basic
         where (sign is null or sign = '0' or sign = '2') ) t  join
         P_Punish_Object_Basic a
          on t.punishobjectid = a.punishobjectid
        join f_unitinfo u
          on u.unitcode = a.managedepid
          where not exists (select * from m_punishresult r where r.internal_no=t.punishobjectid)
          --不在监察库
     ;
  begin
    for rec in c loop
      begin
        insert into m_punishresult
          (no,
           org_id,
           internal_no,
           item_id,
           program,
           accordance,
           standard,
           punish_deside,
           punish_class,
           punish_result,
           punish_result_fine,
           punish_result_fine_people,
           punish_result_expropriation,
           punish_result_expropriation_v,
           punish_result_business,
           punish_result_people,
           punish_result_detain,
           attachment,
           finish_date,
           /*result_standard,*/
           create_date,
           update_date
           
           /*sync_date,
           sync_sign,
           sync_error_desc*/ )
        values
          (rec.no,
           rec.org_id,
           rec.internal_no,
           rec.item_id,
           rec.program,
           rec.accordance,
           rec.standard,
           rec.punish_deside,
           rec.punish_class,
           rec.punish_result,
           rec.punish_result_fine,
           rec.punish_result_fine_people,
           rec.punish_result_expropriation,
           rec.punish_result_expropriation_v,
           rec.punish_result_business,
           rec.punish_result_people,
           rec.punish_result_detain,
           rec.attachment,
           rec.finish_date,
           /*result_standard,*/
           rec.create_date,
           rec.update_date
           );
        update p_finish_basic t
           set t.sign = '1'
         where t.punishobjectid = rec.internal_no;
        commit;
        
         --现场处罚插入过程信息 
 select count(1) into v_sign from m_punishprocess where internal_no =rec.internal_no
    and tache_name='结案';
    --获取结果表交换后的标志位信息
     if rec.punishobjecttype='1' and v_sign=0 --现场处罚的且结果表信息已成功交换
         then 
       insert into m_Punishprocess
          (no,
          no_ord,
           org_id,
           internal_no,
           item_id,
           tache_id,
           tache_name,
           department,
           user_name,
           status,
           promise,
           promise_type,
           note,
           attachment,
           process_date,
           node_id,
           node_attribute,
           create_date,
           update_date)
            values 
      (  nvl(rec.depno, 'JS000000JT') || LPAD(S_M_PUNISHPROCESS.NEXTVAL, 10, 0) ,
          '1'   ,
           rec.org_id,
           rec.internal_no,
           rec.item_id,
          '4704' , 
           '结案' ,
           rec.department,
           rec.poundertaker,
           '5',
            0 ,
            '1' ,
           '现场处罚自动生成的过程结案数据' ,
          '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA ><DOCUMENT>
                     <DOCUMENT_ID></DOCUMENT_ID>
    <DOCUMENT_NAME></DOCUMENT_NAME>
    <FILE_NAME></FILE_NAME>
    <FILE_CONTENT></FILE_CONTENT>
                     </DOCUMENT></DOCUMENTDATA>' ,
           rec.finish_date,
          '4704' ,  --4704  是处罚案件办结节点 虚拟的
           '1' ,
           rec.finish_date,
           sysdate  );      
      end if;   --现场处罚插入过程信息
        commit;
        
        --异常处理
      EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
          update p_finish_basic t
             set t.sign = '2'
           where t.punishobjectid = rec.internal_no;
      end;
      commit;
    end loop;
  end;


  --调这个过程
procedure P_TO_ALL AS
begin
p_to_apply();
p_to_applyprocess();
p_to_applyresult();
p_to_punish();
p_to_punishprocess();
p_to_punishresult();
end;

/*获取处罚类型 1 ：警告；2 ：通报批评；3 ：罚款；4
没收财物（没收违法所得、没收非法财物）；5 ：暂扣或者吊销许可证和营业执照6 ：责令停产、停业   
7 ：行政拘留8 ：劳动教养 
处罚种类可以有多个，用“ || ”分隔 */
function F_GET_PunishType(cfid varchar2) return varchar2 is
  v_punish_class varchar2(1000);

  begin
   for r in(select distinct punishtypeid  from p_punish_basic  where punishobjectid=cfid  )loop
     v_punish_class:=v_punish_class||'||'||r.punishtypeid;
   end loop;
   v_punish_class:=substr(v_punish_class,3,50);--去掉开头的 ||
   return v_punish_class;
end;


--取权力编码 可能有多个
function F_GET_ItemId(cfid varchar2) return varchar2 is
  v_item_id varchar2(1000);
  begin
   for r in(select a.punishobjectid,a.item_id,u.depno from p_trans_law_basic a join P_Punish_Object_Basic b on a.punishobjectid=b.punishobjectid join f_unitinfo u    on u.unitcode = b.managedepid where a.punishobjectid=cfid  )loop
   
     v_item_id:=v_item_id||'||'||substr(nvl(r.depno, 'JS000000JT'), 1, 8) ||substr(r.item_id, 1, 10);
   end loop;
   v_item_id:=substr(v_item_id,3,60); 
   return v_item_id;
end;



end Data_Exchange;
