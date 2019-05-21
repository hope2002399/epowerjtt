----视图
---处罚待办列表
create or replace view v_user_task_list_cf as
select rownum as taskid,t.WFOPTNAME,t.WFOPTTAG,t.NODEINSTID,t.UNITCODE,t.USERCODE,
       t.ROLETYPE,t.ROLECODE,t.AUTHDESC,t.NODENAME,t.NODETYPE,t.NODEOPTTYPE,t.OPTNAME,
       t.METHODNAME,t.OPTURL,t.OPTMETHOD,t.OPTPARAM,t.OPTDESC,t.CREATETIME,t.PROMISETIME,
       t.TIMELIMIT,t.EXPIREOPTSIGN,t.OPTCODE,t.EXPIREOPT,t.FLOWPHASE,t.GRANTOR,t.LASTUPDATEUSER,t.LASTUPDATETIME,t.inststate,e.*
       from v_user_task_list t left join PUNISHOBJECTBASIC e on t.WFINSTID=e.flowinstid where t.OPTID=e.optid;
----处罚种类\违法事实程度
    create or replace view VPOTransLawBasic as
Select POTransLawBasic.degreeNo,
       POTransLawBasic.isSurpass,
       POTransLawBasic.TransLawDate,
       POTransLawBasic.PunishObjectID,
       PCDef.PunishClassID,
       PCDef.PunishClassCode,
       PCDef.DepID,
       PCDef.PunishBasis
  FROM POTransLawBasic
 INNER JOIN PCDef ON POTransLawBasic.PunishClassID = PCDef.PunishClassID
 where 1 = 1
 ORDER BY POTransLawBasic.PunishObjectID, POTransLawBasic.TransLawDate
 
 ---
 CREATE OR REPLACE VIEW VPODISCUSS AS
SELECT PODiscussBasic.PODiscussType, PODiscussBasic.PODiscussAdress,
      PODiscussBasic.PODiscussBeginTime,
      PODiscussBasic.PODiscussEndTime, PODiscussBasic.PODiscussNoter,
      PODiscussBasic.PODiscussEmcee, PODiscussBasic.DisobeyItem,
      PODiscussBasic.PODiscussAttendeeName,
      PODiscussBasic.PODiscussAttendName, PODiscussBasic.confirmTruth,
      PODiscussBasic.PODiscussAffixName, PODiscussBasic.PODiscussRecored,
      PODiscussBasic.PODiscussResult, PODiscussBasic.PODiscussStep,
      PunishObjectBasic.PunishObjectID, PunishObjectBasic.isSurpass,PODiscussBasic.Punish_Heavy
FROM PODiscussBasic INNER JOIN
      PunishObjectBasic ON
      PODiscussBasic.PunishObjectID = PunishObjectBasic.PunishObjectID;
   