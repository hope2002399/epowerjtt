create or replace view v_user_task_list_sw as
select rownum as taskid, t.WFINSTID,t.WFOPTNAME,t.WFOPTTAG,t.NODEINSTID,t.UNITCODE,t.USERCODE,
       t.ROLETYPE,t.ROLECODE,t.AUTHDESC,t.NODENAME,t.NODETYPE,t.NODEOPTTYPE,t.OPTID,t.OPTNAME,
       t.METHODNAME,t.OPTURL,t.OPTMETHOD,t.OPTPARAM,t.OPTDESC,t.CREATETIME,t.PROMISETIME,
       t.TIMELIMIT,t.EXPIREOPTSIGN,t.OPTCODE,t.EXPIREOPT,t.FLOWPHASE,t.GRANTOR,t.LASTUPDATEUSER,t.LASTUPDATETIME,t.inststate,e.dj_id,e.transaffairname,e.bizstate,e.biztype,e.orgcode,e.orgname,e.headunitcode,e.headusercode,e.content,e.powerid,e.powername,e.solvestatus,e.solvetime,e.solvenote,e.createuser,e.createdate,e.optno,e.optquerykey,e.risktype,e.riskdesc,e.riskresult,e.transaffairno,e.transaffairquerykey,e.sendarchiveno,e.acceptarchiveno
    from v_user_task_list t left join opt_base_info e on t.WFINSTID=e.flowinstid ,M_INCOME_DOC i where i.no = e.dj_id order by t.CREATETIME desc

